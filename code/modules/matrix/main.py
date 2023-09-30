from fastapi import FastAPI
from pydantic import BaseModel
from nio import AsyncClient, MatrixRoom, RoomMessageText
import asyncio
import json
from os.path import exists


def gen_config(config_file):
    config_dict = {
        "homeserver": "https://matrix.org",
        "username": "@name:matrix.org",
        "password": "matrixpassword"
    }

    if not exists(config_file):
        with open(config_file, "w") as f:
            json.dump(config_dict, f, indent=4)
            print(f"Example configuration dumped to {config_file}")
            return None

    with open(config_file, "r") as f:
        config = json.loads(f.read())

    return config


class Message(BaseModel):
    room_id: str
    message: str


app = FastAPI()
config = gen_config("config.json")
client = AsyncClient(config['homeserver'], config['username'])


@app.on_event("startup")
async def startup_event():
    asyncio.create_task(start_matrix())


@app.get("/")
async def root():
    return {"message": "Root"}


@app.post("/sendmessage")
async def send_message(message: Message):
    if message.message is None or message.room_id is None:
        return False

    await client.room_send(
        room_id=message.room_id,
        message_type="m.room.message",
        content={"msgtype": "m.text", "body": message.message},
    )

    return message


async def message_callback(room: MatrixRoom, event: RoomMessageText) -> None:
    print(
        f"Message received in room {room.display_name}\n"
        f"{room.user_name(event.sender)} | {event.body}"
    )


async def start_matrix() -> None:
    client.add_event_callback(message_callback, RoomMessageText)

    print(await client.login(config['password']))

    await client.sync_forever(timeout=30000)  # milliseconds

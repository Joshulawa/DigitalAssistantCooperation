import requests

url = "http://127.0.0.1:8000/sendmessage"
msg = {"room_id": "!KrgXrmFMxeopwWvvIp:matrix.org", "message": "initial test message"}

x = requests.post(url, json=msg)
print(x)

while True:
    msg["message"] = str(input("Message: "))
    x = requests.post(url, json=msg)
    print(x)
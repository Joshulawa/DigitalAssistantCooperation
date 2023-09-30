package com.example.mysql;

public class ResponseCreds {
    private String homeserver;
    private String username;
    private String password;

    public ResponseCreds(){}

    public ResponseCreds(String homeserver, String username, String password){
        this.homeserver = homeserver;
        this.username = username;
        this.password = password;
    }

    public String getHomeserver(){
        return homeserver;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }
}

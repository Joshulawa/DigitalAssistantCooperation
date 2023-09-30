package com.example.mysql;

public class Credentials {
    private String credentials;
    private Integer service;
    private String return_url;

    public Credentials(){
    }

    public Credentials(String credentials, Integer service, String return_url){
        super();
        this.credentials = credentials;
        this.service = service;
        this.return_url = return_url;
    }

    public String getCredentials() {
        return credentials;
    }

    public Integer getService() {
        return service;
    }

    public String getReturn_url() {
        return return_url;
    }
}

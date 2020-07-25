package com.mytime.authCenterServer.dto;

import lombok.Data;

@Data
public class Role {

    private String id;
    private String name;


    public Role(){

    }

    public Role(String name) {
        this.name = name;
    }
}
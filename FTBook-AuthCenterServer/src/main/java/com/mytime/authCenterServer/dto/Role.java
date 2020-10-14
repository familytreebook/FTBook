package com.mytime.authCenterServer.dto;

import org.springframework.security.core.GrantedAuthority;

import java.io.Serializable;


public class Role implements Serializable, GrantedAuthority {

    private static final long serialVersionUID = 1L;

    private String name;

    private String id;

    @Override
    public String toString() {
        return name;
    }

    @Override
    public String getAuthority() {
        return name;
    }
}

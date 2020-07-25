package com.mytime.authCenterServer.controller;

import com.mytime.authCenterServer.dto.UserInfo;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.security.Principal;
@RestController
@RequestMapping("/user")
public class UserController{
    @RequestMapping("/current")
    @CrossOrigin
    public UserDetails user(Principal user) {
        Authentication a = (Authentication) user;
        UserInfo u = (UserInfo) a.getPrincipal();
        u.setWords("hello word!");
        u.setNickname("张鸿森");
        return u;

    }


}
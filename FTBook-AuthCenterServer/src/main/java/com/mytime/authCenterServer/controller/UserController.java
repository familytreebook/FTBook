package com.mytime.authCenterServer.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.security.Principal;
@RestController
@RequestMapping("/oauth2_token")
public class UserController {
    @GetMapping("/current")
    public Principal user(Principal principal) {
        return principal;
    }
}
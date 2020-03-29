package com.mytime.authCenterServer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BaseController {

    @RequestMapping("/oauth_login")
    public String login(Model model) {
        System.out.println("oauth_login");
        System.out.println(model.toString());
        model.addAttribute("loginProcessUrl", "/auth/authentication/form");

        return "oauth_login";
        //return model;
    }


}

package com.mytime.UserCenter.UserService.controller;

import com.mytime.UserCenter.UserService.dto.GetTokenByCodeDto;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @GetMapping("/normal")
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public String normal( ) {
        return "用户页面";
    }

    @GetMapping("/medium")
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public String medium() {
        return "这也是用户页面";
    }

    @GetMapping("/admin")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public String admin() {
        return "管理员页面";
    }

    @GetMapping("/ssologin")
    public String login(@ModelAttribute GetTokenByCodeDto dto) {
        System.out.println("ssologin");
        System.out.println(dto.toString());
        //System.out.println(model.toString());
       // model.addAttribute("loginProcessUrl", "/auth/authentication/form");

        return "oauth_login";
        //return model;
    }
}

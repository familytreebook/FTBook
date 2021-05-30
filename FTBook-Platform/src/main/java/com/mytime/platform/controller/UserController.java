package com.mytime.platform.controller;


import com.mytime.api.usercenter.api.IUserCenterServiceAPI;
import com.mytime.api.usercenter.vo.VUser;
import com.mytime.framework.common.bean.ResultModel;
import com.mytime.framework.common.vo.TokenInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;

@RestController
@RequestMapping("/user")
public class UserController {
    private final static Logger logger = LoggerFactory.getLogger(UserController.class);
    @Autowired
    private IUserCenterServiceAPI iUserCenterServiceAPI;

    @RequestMapping(value="login",method = RequestMethod.GET)
    public ModelAndView login(Principal user){
        //重定向
        return new ModelAndView("redirect:http://localhost:8080/login");
    }

    @RequestMapping(value="getToken",method = RequestMethod.GET)
    public TokenInfo getToken(Principal user){

        OAuth2Authentication auth = (OAuth2Authentication) user;
        OAuth2AuthenticationDetails details = (OAuth2AuthenticationDetails)auth.getDetails();
        return TokenInfo.builder().tokenType(details.getTokenType()).tokenValue(details.getTokenValue()).build();
    }

    @RequestMapping(value="getUserInfo",method = RequestMethod.GET)
    public ResultModel<VUser> getUserInfo(Principal pincipal){
        return iUserCenterServiceAPI.getUserDetail(pincipal.getName());
    }


    @RequestMapping(value="getResourceList",method = RequestMethod.GET)
    public Principal getResourceList(Principal user){

        return user;
    }
}

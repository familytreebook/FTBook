package com.mytime.platform.controller;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.mytime.framework.common.vo.TokenInfo;
import com.mytime.platform.dto.GetTokenByCodeDto;
import com.mytime.platform.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.UriComponentsBuilder;

import java.security.Principal;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {
    private final static Logger logger = LoggerFactory.getLogger(UserController.class);

    //获取当前人的菜单信息
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
    public Principal getUserInfo(Principal user){

        return user;
    }
    @RequestMapping(value="getResourceList",method = RequestMethod.GET)
    public Principal getResourceList(Principal user){

        return user;
    }
}

package com.mytime.platform.controller;


import com.mytime.api.usercenter.api.IUserCenterServiceAPI;
import com.mytime.api.usercenter.dto.UserRequestDto;
import com.mytime.api.usercenter.vo.VUser;
import com.mytime.framework.common.bean.ResultModel;
import com.mytime.framework.common.reponse.PageResponseDto;
import com.mytime.framework.common.vo.TokenInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;

@RestController
@RequestMapping("/admin")
public class AdminController {
    private final static Logger logger = LoggerFactory.getLogger(AdminController.class);
    @Autowired
    private IUserCenterServiceAPI iUserCenterServiceAPI;



    @RequestMapping(value="getUserList",method = RequestMethod.GET)
    public ResultModel<PageResponseDto<VUser>> getUserList(UserRequestDto dto){

        return iUserCenterServiceAPI.getUsers(dto);
    }


    @RequestMapping(value="getResourceList",method = RequestMethod.GET)
    public Principal getResourceList(Principal user){

        return user;
    }
}

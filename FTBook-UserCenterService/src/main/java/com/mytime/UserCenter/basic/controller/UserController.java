package com.mytime.UserCenter.basic.controller;

import com.mytime.UserCenter.basic.entity.User;
import com.mytime.UserCenter.basic.service.IUserService;
import com.mytime.api.usercenter.dto.UserDto;
import com.mytime.api.usercenter.dto.UserRequestDto;
import com.mytime.api.usercenter.vo.VUser;
import com.mytime.framework.common.bean.CommonResultEnum;
import com.mytime.framework.common.bean.ResultModel;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private IUserService userService;

    @GetMapping("/current")
    public Principal user(Principal principal) {
        return principal;
    }

    //添加用户
    @PostMapping(value="/addUser")
    ResultModel<VUser> addUser(@RequestBody UserDto dto){
        return null;
    }

    //修改用户
    @PostMapping(value="/updateUser")
    ResultModel<VUser> updateUser(@RequestBody UserDto dto){
        return null;
    }

    //删除用户
    @PostMapping(value="/delUser")
    ResultModel<Boolean> delUser(@RequestBody String userId){
        return null;
    }

    //查询用户列表
    @PostMapping(value="/getUsers")
    ResultModel<List<VUser>> getUsers(@RequestBody UserRequestDto dto){

        return null;
    }

    //查询用户详情
    @GetMapping(value="/getUserDetail")
    ResultModel<VUser> getUserDetail(@RequestParam String userIdOrNameOrPhone){
        User user = userService.getUserDetailByIdOrNameOrPhone(userIdOrNameOrPhone);
        VUser vUser = null;
        if(user!=null){
            vUser = new VUser();
            BeanUtils.copyProperties(user, vUser);
        }

        return new ResultModel<>(CommonResultEnum.CODE_OK,vUser);
    }
}

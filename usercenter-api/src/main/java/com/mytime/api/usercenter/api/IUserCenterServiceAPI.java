package com.mytime.api.usercenter.api;

import com.mytime.api.usercenter.dto.UserDto;
import com.mytime.api.usercenter.dto.UserRequestDto;
import com.mytime.api.usercenter.vo.VUser;
import com.mytime.framework.common.bean.ResultModel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "usercenter",path = "/usercenter",fallback=UserCenterServiceFallbackFactory.class)
public interface IUserCenterServiceAPI {

    //添加用户
    @PostMapping(value="/user/addUser")
    ResultModel<VUser> addUser(@RequestBody UserDto dto);

    //修改用户
    @PostMapping(value="/user/updateUser")
    ResultModel<VUser> updateUser(@RequestBody UserDto dto);

    //删除用户
    @PostMapping(value="/user/delUser")
    ResultModel<Boolean> delUser(@RequestBody String userId);

    //查询用户列表
    @PostMapping(value="/user/getUsers")
    ResultModel<List<VUser>> getUsers(@RequestBody UserRequestDto dto);

    //查询用户详情
    @GetMapping(value="/user/getUserDetail")
    ResultModel<VUser> getUserDetail(@RequestParam String userIdOrNameOrPhone);

    //添加角色

    //删除角色
}

package com.mytime.api.authcenter.api;

import com.mytime.api.authcenter.dto.UserDto;
import com.mytime.api.authcenter.dto.UserRequestDto;
import com.mytime.api.authcenter.vo.VUser;
import com.mytime.framework.common.bean.ResultModel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name="authserver",path="user",qualifier="iAuthCenterServiceAPI",fallback=AuthCenterServiceFallback.class)
public interface IAuthCenterServiceAPI {

    //添加用户
    @PostMapping(value="/addUser")
    ResultModel<VUser> addUser(@RequestBody UserDto dto);

    //修改用户
    @PostMapping(value="/updateUser")
    ResultModel<VUser> updateUser(@RequestBody UserDto dto);

    //删除用户
    @PostMapping(value="/delUser")
    ResultModel<Boolean> delUser(@RequestBody String userId);

    //查询用户列表
    @PostMapping(value="/getUsers")
    ResultModel<List<VUser>> getUsers(@RequestBody UserRequestDto dto);

    //查询用户详情
    @GetMapping(value="/getUserDetail")
    ResultModel<VUser> getUserDetail(@RequestParam String userId);

    //添加角色

    //删除角色
}

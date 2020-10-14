package com.mytime.authCenterServer.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.mytime.authCenterServer.dto.Role;
import com.mytime.authCenterServer.dto.User;
import com.mytime.authCenterServer.mapper.RoleMapper;
import com.mytime.authCenterServer.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserServiceDetail implements UserDetailsService {
    private final UserMapper userMapper;
    private final RoleMapper roleMapper;

    @Autowired
    public UserServiceDetail(UserMapper userMapper, RoleMapper roleMapper) {
        this.userMapper = userMapper;
        this.roleMapper = roleMapper;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.eq("username", s);
        User user = userMapper.selectOne(userQueryWrapper);
        if (user == null) {
            throw new RuntimeException("用户名或密码错误");
        }

        user.setAuthorities(roleMapper.selectByUserId(user.getId()));
        return user;
    }
}
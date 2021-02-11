package com.mytime.authCenterServer.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.mytime.authCenterServer.dto.User;
import com.mytime.authCenterServer.mapper.UserMapper;
import com.mytime.authCenterServer.service.IUserService;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements IUserService {

    @Resource
    private  UserMapper userMapper;

    @Override
    public User getUserDetail(String userIdOrNameOrPhone) {
        if(StringUtils.isEmpty(userIdOrNameOrPhone)){
            return null;
        }

        User user = userMapper.selectById(userIdOrNameOrPhone);
        if(user==null){
            QueryWrapper<User> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("username", userIdOrNameOrPhone);
            user = userMapper.selectOne(queryWrapper);
            if(user==null){
                queryWrapper = new QueryWrapper<>();
                queryWrapper.eq("phone", userIdOrNameOrPhone);
                user = userMapper.selectOne(queryWrapper);
            }
        }

        return user;
    }
}

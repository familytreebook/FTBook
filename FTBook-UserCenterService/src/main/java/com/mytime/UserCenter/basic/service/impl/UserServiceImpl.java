package com.mytime.UserCenter.basic.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.mytime.UserCenter.basic.entity.User;
import com.mytime.UserCenter.basic.mapper.UserMapper;
import com.mytime.UserCenter.basic.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zhs
 * @since 2021-02-11
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {
    @Resource
    private  UserMapper userMapper;

    @Override
    public User getUserDetailByIdOrNameOrPhone(String userIdOrNameOrPhone) {
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

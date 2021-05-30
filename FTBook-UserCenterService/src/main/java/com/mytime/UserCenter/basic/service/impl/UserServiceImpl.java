package com.mytime.UserCenter.basic.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mytime.UserCenter.basic.entity.User;
import com.mytime.UserCenter.basic.mapper.UserMapper;
import com.mytime.UserCenter.basic.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mytime.api.usercenter.dto.UserRequestDto;
import com.mytime.framework.common.request.PageRequestDto;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

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

    @Override
    public IPage<User> getUserList(UserRequestDto dto){
        IPage<User> userPage = new Page<>(dto.getPageNum(), dto.getPageSize());//参数一是当前页，参数二是每页个数
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper
                .eq(StringUtils.isNotBlank(dto.getUsername()),"username",dto.getUsername())
                .like(StringUtils.isNotBlank(dto.getUsernameLike()),"username",dto.getUsernameLike())
                .likeLeft(StringUtils.isNotBlank(dto.getUsernameLikeLeft()),"username",dto.getUsernameLikeLeft())
                .eq(StringUtils.isNotBlank(dto.getPhone()),"phone",dto.getPhone())
                .likeLeft(StringUtils.isNotBlank(dto.getPhoneLikeLeft()),"phone",dto.getPhoneLikeLeft())
                .eq(StringUtils.isNotBlank(dto.getNickname()),"nickname",dto.getNickname())
                .like(StringUtils.isNotBlank(dto.getNicknameLike()),"nickname",dto.getNicknameLike())
                .likeLeft(StringUtils.isNotBlank(dto.getNicknameLikeLeft()),"nickname",dto.getNicknameLikeLeft())
                .eq(StringUtils.isNotBlank(dto.getEmail()),"email",dto.getEmail())
                .like(StringUtils.isNotBlank(dto.getEmailLike()),"email",dto.getEmailLike())
                .likeLeft(StringUtils.isNotBlank(dto.getEmailLikeLeft()),"email",dto.getEmailLikeLeft())
                .likeRight(StringUtils.isNotBlank(dto.getEmailLikeRight()),"email",dto.getEmailLikeRight())
                //.eq(StringUtils.isNotBlank(dto.getUsername()),"username",dto.getUsername())
                .eq(dto.getSex()!=null,"sex",dto.getSex())
        .orderByDesc("regtime")
        ;
        return  userMapper.selectPage(userPage, queryWrapper);
    }
}

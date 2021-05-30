package com.mytime.UserCenter.basic.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mytime.UserCenter.basic.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;
import com.mytime.api.usercenter.dto.UserRequestDto;
import com.mytime.framework.common.request.PageRequestDto;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zhs
 * @since 2021-02-11
 */
public interface IUserService extends IService<User> {
     User getUserDetailByIdOrNameOrPhone(String userIdOrNameOrPhone);
     IPage<User> getUserList(UserRequestDto dto);

     //IPage<User> selectPageVo(Page<?> page, Integer state);

}

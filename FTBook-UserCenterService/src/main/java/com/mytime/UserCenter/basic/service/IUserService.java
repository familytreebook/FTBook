package com.mytime.UserCenter.basic.service;

import com.mytime.UserCenter.basic.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

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
}

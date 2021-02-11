package com.mytime.authCenterServer.service;

import com.mytime.authCenterServer.dto.User;
import org.springframework.web.bind.annotation.RequestParam;

public interface IUserService {
    User getUserDetail(String userIdOrNameOrPhone);


}

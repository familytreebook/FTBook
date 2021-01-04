package com.mytime.api.authcenter.api;

import com.mytime.api.authcenter.dto.UserDto;
import com.mytime.api.authcenter.dto.UserRequestDto;
import com.mytime.api.authcenter.vo.VUser;
import com.mytime.framework.common.bean.CommonResultEnum;
import com.mytime.framework.common.bean.ResultModel;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AuthCenterServiceFallback implements IAuthCenterServiceAPI {

    @Override
    public ResultModel<VUser> addUser(UserDto dto) {
        return new ResultModel(CommonResultEnum.CODE_Circuit_Breaker,null);
    }

    @Override
    public ResultModel<VUser> updateUser(UserDto dto) {
        return new ResultModel(CommonResultEnum.CODE_Circuit_Breaker,null);
    }

    @Override
    public ResultModel<Boolean> delUser(String userId) {
        return new ResultModel(CommonResultEnum.CODE_Circuit_Breaker,null);
    }

    @Override
    public ResultModel<List<VUser>> getUsers(UserRequestDto dto) {
        return new ResultModel(CommonResultEnum.CODE_Circuit_Breaker,null);
    }

    @Override
    public ResultModel<VUser> getUserDetail(String userId) {
        return new ResultModel(CommonResultEnum.CODE_Circuit_Breaker,null);
    }
}

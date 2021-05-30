package com.mytime.api.usercenter.api;

import com.mytime.api.usercenter.dto.UserDto;
import com.mytime.api.usercenter.dto.UserRequestDto;
import com.mytime.api.usercenter.vo.VUser;
import com.mytime.framework.common.bean.CommonResultEnum;
import com.mytime.framework.common.bean.ResultModel;
import com.mytime.framework.common.reponse.PageResponseDto;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserCenterServiceFallbackFactory implements IUserCenterServiceAPI {

   /* @Override
    public IAuthCenterServiceAPI create(Throwable throwable) {
        return new IAuthCenterServiceAPI() {
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
            public ResultModel<VUser> getUserDetail(String userIdOrNameOrPhone) {
                return new ResultModel(CommonResultEnum.CODE_Circuit_Breaker,null);
            }
        };
    }*/

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
    public ResultModel<PageResponseDto<VUser>> getUsers(UserRequestDto dto) {
        return new ResultModel(CommonResultEnum.CODE_Circuit_Breaker,null);
    }

    @Override
    public ResultModel<VUser> getUserDetail(String userIdOrNameOrPhone) {
        return new ResultModel(CommonResultEnum.CODE_Circuit_Breaker,null);
    }
}

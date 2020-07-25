package com.mytime.UserCenter.UserService.dto;

import lombok.Data;

@Data
public class GetTokenByCodeDto {
    private String client_id;
    private String code;
    private String redirect_uri;
    private String grant_type;
}

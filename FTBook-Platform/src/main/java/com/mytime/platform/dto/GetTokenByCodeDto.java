package com.mytime.platform.dto;

import lombok.Data;

@Data
public class GetTokenByCodeDto {
    private String client_id;
    private String code;
    private String redirect_uri;
    private String grant_type;
    private String scope;

    private String client_secret;
}

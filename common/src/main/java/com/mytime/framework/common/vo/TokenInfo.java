package com.mytime.framework.common.vo;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TokenInfo {

    private String tokenType;

    private String tokenValue;

}

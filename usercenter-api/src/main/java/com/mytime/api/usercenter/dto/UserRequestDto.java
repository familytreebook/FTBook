package com.mytime.api.usercenter.dto;


import com.mytime.api.usercenter.vo.VRole;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * 查询专用请求实体类
 * */

@Data
public class UserRequestDto {

    private Integer id;

    private String username;

    private List<VRole> authorities;

    private String avatar;

    private String phone;

    private String nickname;

    private boolean enabled;

    private String email;

    private String words;

    private Date regtime;

    private int sex;

    private Date birthday;

}

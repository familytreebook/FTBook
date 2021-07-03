package com.mytime.api.usercenter.dto;


import com.mytime.api.usercenter.vo.VRole;
import com.mytime.framework.common.request.PageRequestDto;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * 查询专用请求实体类
 * */

@Data
public class UserRequestDto extends PageRequestDto {

    private Integer id;

    private String username;

    private String usernameLike;

    private String usernameLikeLeft;

    private List<VRole> authorities;

    private String avatar;

    private String phone;
    private String phoneLikeLeft;

    private String nickname;
    private String nicknameLike;
    private String nicknameLikeLeft;

    private Integer userstatus;

    private String email;
    private String emailLike;
    private String emailLikeLeft;
    private String emailLikeRight;

    private String words;

    private Date regtime;

    private Integer sex;

    private Date birthday;

}

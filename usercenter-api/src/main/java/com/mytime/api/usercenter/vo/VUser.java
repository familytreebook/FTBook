package com.mytime.api.usercenter.vo;


import lombok.Data;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 用户信息查询出的实体类
 * */
@Data
public class VUser implements Serializable {


    private Integer id;

    private String username;

    private List<VRole> authorities;

    private String avatar;

    private String phone;

    private String nickname;

    private int userstatus;

    private String email;

    private String words;

    private Date regtime;

    private int sex;

    private Date birthday;

    private Date updatetime;

    private Date lastlogintime;

}

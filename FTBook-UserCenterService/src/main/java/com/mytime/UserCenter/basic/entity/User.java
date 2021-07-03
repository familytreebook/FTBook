package com.mytime.UserCenter.basic.entity;

import java.time.LocalDateTime;
import java.io.Serializable;
import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author zhs
 * @since 2021-02-11
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="User对象", description="")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    private String username;

    private String password;

    private String avatar;

    private String phone;

    private String nickname;

    private int userstatus;

    private String email;

    private String words;

    private Date regtime;

    private Date updatetime;

    private Date lastlogintime;

    private String sex;

    private Date birthday;


}

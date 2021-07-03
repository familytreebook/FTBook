package com.mytime.api.usercenter.constants;

public enum UserStatusEnum {

    unactivated(1,"未激活"),
    enabled(2,"启用"),
    disabled(3,"禁用"),
    expired(4,"过期"),
    locked(5,"被锁定"),
    deleted(6,"已删除")
    ;

    private int code;
    private String name;
    UserStatusEnum(int code, String name) {
        this.code = code;
        this.name = name;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

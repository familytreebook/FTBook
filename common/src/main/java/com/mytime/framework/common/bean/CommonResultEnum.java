package com.mytime.framework.common.bean;


public enum CommonResultEnum {
    CODE_OK(2000, "OK"),
    CODE_FAIL(5000, "操作失败"),
    CODE_UNKNOWN(-1, "未知错误"),
    CODE_Circuit_Breaker(5001, "系统熔断"),
    CODE_PARAM_ERROR(5002, "请求参数错误");

    private int code;
    private String msg;

    CommonResultEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public static CommonResultEnum codeOf(int code) {
        for (CommonResultEnum state : values()) {
            if (state.getCode() == code) {
                return state;
            }
        }
        return CommonResultEnum.CODE_UNKNOWN;
    }
}

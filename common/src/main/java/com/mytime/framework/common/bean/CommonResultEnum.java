package com.mytime.framework.common.bean;


public enum CommonResultEnum {
    CODE_OK_0(0, "Success"),
    CODE_OK(200, "OK"),
    CODE_FAIL(-1, "操作失败"),
    CODE_RPC_ERROR(-2, "远程调度失败"),
    CODE_UNKNOWN(-3, "未知错误"),
    CODE_REDIS_ERROR(-4, "存储redis错误"),
    CODE_CPBEAN_ERROR(-5, "复制bean失败"),
    CODE_PARAM_ERROR(460, "请求参数错误");

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

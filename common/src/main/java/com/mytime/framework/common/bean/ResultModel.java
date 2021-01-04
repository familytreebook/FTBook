package com.mytime.framework.common.bean;

import com.alibaba.fastjson.JSONObject;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


@Data
@NoArgsConstructor
public class ResultModel<T> implements Serializable {
    private static final int CODE_OK = CommonResultEnum.CODE_OK.getCode();


    private static final long serialVersionUID = 828655026342216609L;
    private Integer code = CODE_OK;
    private String msg = "";
    private T result;

    public ResultModel(Integer code) {
        this.code = code;
        if (code == CODE_OK) {
            this.msg = "success";
        } else {
            this.msg = "failed";
        }
    }

    public ResultModel(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public ResultModel(CommonResultEnum commonResultEnum, T result) {
        this.code = commonResultEnum.getCode();
        this.msg = commonResultEnum.getMsg();
        this.result = result;
    }

    public ResultModel(Integer code, String msg, T result) {
        this.code = code;
        this.msg = msg;
        this.result = result;
    }

    public boolean isOk() {
        return (this.code == CODE_OK) || (this.code == CommonResultEnum.CODE_OK.getCode());
    }

    public static  <T> ResultModel<T> ok(){
        return  result(CommonResultEnum.CODE_OK);
    }

    public static  <T> ResultModel<T> ok(T result ){
        return  result(CommonResultEnum.CODE_OK, result);
    }

    public static  <T> ResultModel<T> fail(){
        return  result(CommonResultEnum.CODE_FAIL);
    }

    public static  <T> ResultModel<T> fail(CommonResultEnum code){
        return  result(code);
    }

    public static <T> ResultModel<T> result(CommonResultEnum code) {
        return result(code, null);
    }

    public static <T> ResultModel<T> result(CommonResultEnum code, T result) {
        return new ResultModel<>(code.getCode(), code.getMsg(), result);
    }

    public static  <T> ResultModel<T> fail(Integer code, String msg){
        return  new ResultModel<>(code,msg);
    }

    @Override
    public String toString() {
        return JSONObject.toJSONString(this);
    }

}

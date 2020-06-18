package com.namsangmi.learning.http.bean;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * 响应类
 */

public class ResponseBean<T> implements Serializable {

    /**
     * result : null
     * resultCode : 0
     * resultMsg : 操作成功！
     */
    @SerializedName("data")
    private T data;
    @SerializedName("code")
    private int code;
    @SerializedName("msg")
    private String msg;


    @Override
    public String toString() {
        return "ResponseBean{" +
                "data=" + data +
                ", code=" + code +
                ", msg='" + msg + '\'' +
                '}';
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}

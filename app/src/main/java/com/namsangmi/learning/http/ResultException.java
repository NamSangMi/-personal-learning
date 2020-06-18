package com.namsangmi.learning.http;

/**
 * 服务端出错
 */

public class ResultException extends RuntimeException {
    /**
     * 服务端接口  resultCode
     * 0  成功
     */
    private int errCode = 0;

    public ResultException(int errCode, String msg) {
        super(msg);
        this.errCode = errCode;
    }

    public int getErrCode() {
        return errCode;
    }
}

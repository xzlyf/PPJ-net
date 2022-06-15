package com.xz.ppjnet.base;

/**
 * @author XiaoZe
 * @email czr2001@outlook.com
 * @date 2022/6/7 14:23
 */
public enum ResultStatus {
    /**
     * 基础状态码
     */
    STATUS_SUCCESS(1, "success"),
    //STATUS_ERROR(-1, "服务器睡着了，稍后再试吧！"),
    STATUS_ERROR(-1, "error"),
    /**
     * 请求状态码
     * 201-300
     */
    STATUS_REQUEST_FREQUENT(201, "接口请求频繁"),
    /**
     * 响应状态码
     * 301-400
     */
    STATUS_RESPONSE_FAILED(301, "操作未授权"),

    /**
     * 业务状态码
     * 501-600
     */
    STATUS_BUSINESS_FAILED(501, "业务处理异常");


    public int code;
    public String msg;

    ResultStatus(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}

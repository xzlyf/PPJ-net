package com.xz.ppjnet.exception;

import lombok.Data;

/**
 * @author XiaoZe
 * @email czr2001@outlook.com
 * @date 2022/6/7 15:12
 * 自定义异常，接收状态码信息。
 * 不直接调用此异常，通过调用该子类实现
 */
@Data
public class DefinitionException extends RuntimeException {
    protected Integer code;
    protected String msg;

    /**
     * 自定义错误码和错误描述
     */
    public DefinitionException(Integer errorCode, String errorMsg) {
        this.code = errorCode;
        this.msg = errorMsg;
    }
}

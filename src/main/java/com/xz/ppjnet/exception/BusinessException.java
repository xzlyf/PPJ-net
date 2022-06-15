package com.xz.ppjnet.exception;


import com.xz.ppjnet.base.ResultStatus;

/**
 * 自定义业务异常
 */
public class BusinessException extends DefinitionException {

    /**
     * 默认业务异常信息
     */
    public BusinessException() {
        super(ResultStatus.STATUS_BUSINESS_FAILED.getCode(), ResultStatus.STATUS_BUSINESS_FAILED.getMsg());
    }

    /**
     * 自定义异常信息
     */
    public BusinessException(String errorMsg) {
        super(ResultStatus.STATUS_BUSINESS_FAILED.getCode(), errorMsg);
    }

    /**
     * 自定义异常代码
     * 自定义异常信息
     */
    public BusinessException(Integer errorCode, String errorMsg) {
        super(errorCode, errorMsg);
    }
}
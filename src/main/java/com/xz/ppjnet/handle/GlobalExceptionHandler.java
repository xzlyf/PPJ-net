package com.xz.ppjnet.handle;


import com.xz.ppjnet.base.ResultStatus;
import com.xz.ppjnet.exception.DefinitionException;
import com.xz.ppjnet.vo.ResultVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局异常捕获
 */
@RestControllerAdvice
public class GlobalExceptionHandler {
    private static Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class.getName());

    /**
     * 处理自定义异常
     * 交给自定义的DefinitionException异常处理类处理
     */
    @ExceptionHandler(value = DefinitionException.class)
    @ResponseBody
    public ResultVo bizExceptionHandler(DefinitionException e) {
        return ResultVo.defineError(e);
    }

    /**
     * 处理其他异常
     */
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public ResultVo exceptionHandler(Exception e) {
        log.error("未知异常:{}", e.getMessage());
        e.printStackTrace();
        return ResultVo.otherError(ResultStatus.STATUS_ERROR);
    }
}
package com.xz.ppjnet.entity;

import com.xz.ppjnet.exception.DefinitionException;
import lombok.Data;

import java.io.Serializable;

/**
 * @author XiaoZe
 * @email czr2001@outlook.com
 * @date 2022/6/7 14:21
 */
@Data
public class ResultVo implements Serializable {
    private int code;
    private String msg;
    private Object data;

    /**
     * 成功返回的结果
     *
     * @param data
     * @return
     */
    public static ResultVo success(Object data) {
        ResultVo resultVo = new ResultVo();
        resultVo.setCode(ResultStatus.STATUS_SUCCESS.getCode());
        resultVo.setMsg(ResultStatus.STATUS_SUCCESS.getMsg());
        resultVo.setData(data);
        return resultVo;
    }

    /**
     * 自定义异常返回的结果
     */
    public static ResultVo defineError(DefinitionException de) {
        ResultVo result = new ResultVo();
        result.setCode(de.getCode());
        result.setMsg(de.getMsg());
        return result;
    }

    /**
     * 其他异常处理方法返回的结果
     */
    public static ResultVo otherError(ResultStatus status) {
        ResultVo result = new ResultVo();
        result.setMsg(status.getMsg());
        result.setCode(status.getCode());
        return result;
    }
}

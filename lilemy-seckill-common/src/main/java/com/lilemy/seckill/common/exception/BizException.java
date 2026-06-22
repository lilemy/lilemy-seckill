package com.lilemy.seckill.common.exception;

import lombok.Getter;
import lombok.Setter;

/**
 * 业务异常类
 *
 * @author lilemy
 * @date 2026-06-22 14:26
 */
@Getter
@Setter
public class BizException extends RuntimeException {

    // 异常码
    private String errorCode;

    // 错误信息
    private String errorMessage;

    public BizException(BaseExceptionInterface baseExceptionInterface) {
        this.errorCode = baseExceptionInterface.getErrorCode();
        this.errorMessage = baseExceptionInterface.getErrorMessage();
    }
}

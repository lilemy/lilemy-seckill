package com.lilemy.seckill.common.exception;

/**
 * 通用异常接口
 *
 * @author lilemy
 * @date 2026-06-22 14:25
 */
public interface BaseExceptionInterface {

    /**
     * 返回错误码
     *
     * @return 错误码
     */
    String getErrorCode();

    /**
     * 返回错误信息
     *
     * @return 错误信息
     */
    String getErrorMessage();
}

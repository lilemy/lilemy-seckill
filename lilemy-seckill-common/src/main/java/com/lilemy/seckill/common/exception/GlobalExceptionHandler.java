package com.lilemy.seckill.common.exception;

import cn.dev33.satoken.exception.NotLoginException;
import com.lilemy.seckill.common.enums.ResponseCodeEnum;
import com.lilemy.seckill.common.utils.Response;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Optional;

/**
 * @author lilemy
 * @date 2026-06-22 14:33
 */
@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 捕获自定义业务异常
     */
    @ExceptionHandler({BizException.class})
    @ResponseBody
    public Response<Object> handleBizException(HttpServletRequest request, BizException e) {
        log.warn("{} 请求异常, 状态码: {}, 信息: {}", request.getRequestURI(), e.getErrorCode(), e.getErrorMessage());
        return Response.fail(e);
    }

    /**
     * 捕获参数校验异常
     */
    @ExceptionHandler({MethodArgumentNotValidException.class})
    @ResponseBody
    public Response<Object> handleMethodArgumentNotValidException(HttpServletRequest request, MethodArgumentNotValidException e) {
        // 参数错误异常码
        String errorCode = ResponseCodeEnum.PARAM_NOT_VALID.getErrorCode();

        // 获取 BindingResult
        BindingResult bindingResult = e.getBindingResult();

        StringBuilder sb = new StringBuilder();

        // 获取校验不通过的字段，并组合错误信息，格式为： email 邮箱格式不正确, 当前值: '123124qq.com';
        Optional.of(bindingResult.getFieldErrors()).ifPresent(errors ->
                errors.forEach(error ->
                        sb.append(error.getField())
                                .append(" ")
                                .append(error.getDefaultMessage())
                                .append(", 当前值: '")
                                .append(error.getRejectedValue())
                                .append("'; ")

                ));

        // 错误信息
        String errorMessage = sb.toString();

        log.warn("{} 参数请求异常, 状态码: {}, 信息: {}", request.getRequestURI(), errorCode, errorMessage);

        return Response.fail(errorCode, errorMessage);
    }

    /**
     * 捕获 SaToken 未登录异常
     */
    @ExceptionHandler({NotLoginException.class})
    @ResponseBody
    public Response<Object> handleNotLoginException(HttpServletRequest request, NotLoginException e) {
        log.warn("{} request fail, 未登录异常: {}", request.getRequestURI(), e.getMessage());
        return Response.fail(ResponseCodeEnum.UNAUTHORIZED);
    }

    /**
     * 其他类型异常
     */
    @ExceptionHandler({Exception.class})
    @ResponseBody
    public Response<Object> handleOtherException(HttpServletRequest request, Exception e) {
        log.error("{} 系统请求异常, ", request.getRequestURI(), e);
        return Response.fail(ResponseCodeEnum.SYSTEM_ERROR);
    }
}

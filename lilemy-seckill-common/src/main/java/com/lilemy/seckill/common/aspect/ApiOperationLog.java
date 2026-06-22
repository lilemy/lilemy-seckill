package com.lilemy.seckill.common.aspect;

import java.lang.annotation.*;

/**
 * @author lilemy
 * @date 2026-06-22 14:44
 */
@Documented
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ApiOperationLog {

    /**
     * API 功能描述
     *
     * @return
     */
    String description() default "";
}

package com.lilemy.seckill.user.constant;

/**
 * 用户常量
 *
 * @author lilemy
 * @date 2026-06-23 13:40
 */
public interface UserConstant {

    // Redis 中验证码的 Key 前缀
    String VERIFY_CODE_KEY_PREFIX = "verify_code:";
    // Redis 中发送频率限制的 Key 前缀
    String VERIFY_CODE_LIMIT_KEY_PREFIX = "verify_code_limit:";
    // 验证码过期时间（分钟）
    Long VERIFY_CODE_EXPIRE_MINUTES = 5L;
    // 发送频率限制时间（秒）
    Long VERIFY_CODE_LIMIT_SECONDS = 60L;

    // Redis 中每日发送次数限制的 Key 前缀
    String VERIFY_CODE_DAILY_LIMIT_KEY_PREFIX = "verify_code_daily:";
    // 每日发送次数上限
    Integer VERIFY_CODE_DAILY_LIMIT = 10;

    // Redis 中登录失败次数的 Key 前缀
    String LOGIN_FAIL_COUNT_KEY_PREFIX = "login_fail_count:";
    // 登录失败次数上限（超过此值则临时锁定账号）
    Integer LOGIN_FAIL_MAX_COUNT = 5;
    // 账号临时锁定时间（分钟）
    Long LOGIN_LOCK_MINUTES = 30L;
}

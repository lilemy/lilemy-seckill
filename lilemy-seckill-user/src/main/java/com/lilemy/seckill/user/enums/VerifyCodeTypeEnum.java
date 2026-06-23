package com.lilemy.seckill.user.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 验证码类型枚举
 *
 * @author lilemy
 * @date 2026-06-23 11:19
 */
@Getter
@AllArgsConstructor
public enum VerifyCodeTypeEnum {

    REGISTER(1, "register", "注册"),
    LOGIN(2, "login", "登录"),
    ;

    // 类型值
    private final Integer code;
    // 场景标识（用于拼接 Redis Key）
    private final String purpose;
    // 类型描述
    private final String description;

    /**
     * 根据 code 获取枚举
     *
     * @param code 枚举码
     * @return 对应枚举
     */
    public static VerifyCodeTypeEnum valueOf(Integer code) {
        for (VerifyCodeTypeEnum typeEnum : values()) {
            if (typeEnum.getCode().equals(code)) {
                return typeEnum;
            }
        }
        return null;
    }
}

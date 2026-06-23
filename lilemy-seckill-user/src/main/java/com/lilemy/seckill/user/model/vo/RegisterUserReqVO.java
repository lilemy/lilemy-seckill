package com.lilemy.seckill.user.model.vo;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;

/**
 * 用户注册
 *
 * @author lilemy
 * @date 2026-06-23 10:16
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RegisterUserReqVO implements Serializable {

    @Serial
    private static final long serialVersionUID = -6197537727889572726L;

    /**
     * 手机号（充当登录账号）
     */
    @NotBlank(message = "手机号不能为空")
    @Pattern(regexp = "^1[3-9]\\d{9}$", message = "手机号格式不正确")
    private String mobile;

    /**
     * 密码
     */
    @NotBlank(message = "密码不能为空")
    private String password;

    /**
     * 短信验证码
     */
    @NotBlank(message = "验证码不能为空")
    private String verifyCode;
}

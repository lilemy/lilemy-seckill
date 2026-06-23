package com.lilemy.seckill.user.model.vo;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;

/**
 * 发送验证码
 *
 * @author lilemy
 * @date 2026-06-23 11:19
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SendVerifyCodeReqVO implements Serializable {

    @Serial
    private static final long serialVersionUID = -8411825109265500214L;

    /**
     * 手机号
     */
    @NotBlank(message = "手机号不能为空")
    @Pattern(regexp = "^1[3-9]\\d{9}$", message = "手机号格式不正确")
    private String mobile;

    /**
     * 验证码类型（1: 注册，2: 登录）
     */
    @NotNull(message = "验证码类型不能为空")
    private Integer type;
}

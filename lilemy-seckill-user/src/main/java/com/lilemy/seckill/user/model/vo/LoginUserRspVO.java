package com.lilemy.seckill.user.model.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigInteger;

/**
 * @author lilemy
 * @date 2026-06-23 10:58
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LoginUserRspVO implements Serializable {

    @Serial
    private static final long serialVersionUID = -3470242696750206794L;

    /**
     * Token 令牌
     */
    private String token;

    /**
     * 用户信息
     */
    private UserInfo userInfo;

    /**
     * 用户信息内部类
     */
    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class UserInfo {

        /**
         * 用户 ID
         */
        private BigInteger id;

        /**
         * 昵称
         */
        private String nickname;

        /**
         * 头像
         */
        private String avatar;
    }
}

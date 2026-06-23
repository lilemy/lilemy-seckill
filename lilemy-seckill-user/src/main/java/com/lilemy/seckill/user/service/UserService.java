package com.lilemy.seckill.user.service;

import com.lilemy.seckill.common.entity.User;
import com.lilemy.seckill.common.utils.Response;
import com.lilemy.seckill.user.model.vo.LoginUserReqVO;
import com.lilemy.seckill.user.model.vo.LoginUserRspVO;
import com.lilemy.seckill.user.model.vo.RegisterUserReqVO;
import com.lilemy.seckill.user.model.vo.SendVerifyCodeReqVO;
import com.mybatisflex.core.service.IService;

/**
 * 用户表 服务层。
 *
 * @author lilemy
 * @since 2026-06-18
 */
public interface UserService extends IService<User> {

    /**
     * 用户注册
     *
     * @param registerUserReqVO 用户注册请求
     * @return 是否注册成功
     */
    Response<?> register(RegisterUserReqVO registerUserReqVO);

    /**
     * 用户登录
     *
     * @param loginUserReqVO 用户登录请求
     * @return 登录用户 Token 等信息
     */
    Response<LoginUserRspVO> login(LoginUserReqVO loginUserReqVO);

    /**
     * 退出登录
     *
     * @return 是否退出成功
     */
    Response<?> logout();

    /**
     * 发送验证码
     *
     * @param sendVerifyCodeReqVO 验证码请求
     * @return 是否发送成功
     */
    Response<?> sendVerifyCode(SendVerifyCodeReqVO sendVerifyCodeReqVO);
}

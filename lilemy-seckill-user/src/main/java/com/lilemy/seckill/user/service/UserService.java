package com.lilemy.seckill.user.service;

import com.lilemy.seckill.common.entity.User;
import com.lilemy.seckill.common.utils.Response;
import com.lilemy.seckill.user.model.vo.RegisterUserReqVO;
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
}

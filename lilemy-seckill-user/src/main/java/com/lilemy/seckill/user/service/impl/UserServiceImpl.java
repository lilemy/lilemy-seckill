package com.lilemy.seckill.user.service.impl;

import com.lilemy.seckill.common.entity.User;
import com.lilemy.seckill.common.mapper.UserMapper;
import com.lilemy.seckill.user.service.UserService;
import com.mybatisflex.spring.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * 用户表 服务层实现。
 *
 * @author lilemy
 * @since 2026-06-18
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}

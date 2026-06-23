package com.lilemy.seckill.user.service.impl;

import cn.hutool.core.util.RandomUtil;
import com.lilemy.seckill.common.entity.User;
import com.lilemy.seckill.common.enums.ResponseCodeEnum;
import com.lilemy.seckill.common.exception.BizException;
import com.lilemy.seckill.common.mapper.UserMapper;
import com.lilemy.seckill.common.utils.Response;
import com.lilemy.seckill.user.enums.UserStatusEnum;
import com.lilemy.seckill.user.model.vo.RegisterUserReqVO;
import com.lilemy.seckill.user.service.UserService;
import com.mybatisflex.core.query.QueryWrapper;
import com.mybatisflex.spring.service.impl.ServiceImpl;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * 用户表 服务层实现。
 *
 * @author lilemy
 * @since 2026-06-18
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Override
    public Response<?> register(RegisterUserReqVO registerUserReqVO) {
        String mobile = registerUserReqVO.getMobile();
        String password = registerUserReqVO.getPassword();
        String verifyCode = registerUserReqVO.getVerifyCode();
        // 1. 校验验证码
        // TODO: 验证码先写死 123456，后续开发验证码发送接口，再重构这里
        if (!"123456".equals(verifyCode)) {
            throw new BizException(ResponseCodeEnum.USER_VERIFY_CODE_ERROR);
        }
        // 2. 校验手机号是否已注册
        QueryWrapper queryWrapper = QueryWrapper.create();
        queryWrapper.eq(User::getMobile, mobile);
        boolean exists = this.exists(queryWrapper);
        if (exists) {
            throw new BizException(ResponseCodeEnum.USER_MOBILE_EXISTS);
        }
        // 3. 密码加密（使用 BCrypt 算法）
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(password);

        // 4. 构建用户实体，插入数据库
        User user = User.builder()
                .mobile(mobile)
                .password(encodedPassword)
                .nickname(this.generateNickname())
                .status(UserStatusEnum.ENABLED.getCode())
                .build();

        boolean save = this.save(user);
        if (!save) {
            return Response.fail(ResponseCodeEnum.SYSTEM_ERROR);
        }
        return Response.success();
    }

    /**
     * 生成随机昵称
     * 格式：用户 + 6 位随机数字，如：用户382910
     *
     * @return 昵称
     */
    private String generateNickname() {
        return "用户" + RandomUtil.randomNumbers(6);
    }
}

package com.lilemy.seckill.order.service.impl;

import com.lilemy.seckill.common.entity.SeckillOrder;
import com.lilemy.seckill.common.mapper.SeckillOrderMapper;
import com.lilemy.seckill.order.service.SeckillOrderService;
import com.mybatisflex.spring.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * 秒杀订单表 服务层实现。
 *
 * @author lilemy
 * @since 2026-06-18
 */
@Service
public class SeckillOrderServiceImpl extends ServiceImpl<SeckillOrderMapper, SeckillOrder> implements SeckillOrderService {

}

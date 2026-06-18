package com.lilemy.seckill.goods.service.impl;

import com.lilemy.seckill.common.entity.SeckillGoods;
import com.lilemy.seckill.common.mapper.SeckillGoodsMapper;
import com.lilemy.seckill.goods.service.SeckillGoodsService;
import com.mybatisflex.spring.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * 秒杀商品关联表 服务层实现。
 *
 * @author lilemy
 * @since 2026-06-18
 */
@Service
public class SeckillGoodsServiceImpl extends ServiceImpl<SeckillGoodsMapper, SeckillGoods> implements SeckillGoodsService {

}

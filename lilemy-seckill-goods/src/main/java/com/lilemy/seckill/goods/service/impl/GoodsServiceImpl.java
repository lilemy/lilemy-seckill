package com.lilemy.seckill.goods.service.impl;

import com.lilemy.seckill.common.entity.Goods;
import com.lilemy.seckill.common.mapper.GoodsMapper;
import com.lilemy.seckill.goods.service.GoodsService;
import com.mybatisflex.spring.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * 商品表 服务层实现。
 *
 * @author lilemy
 * @since 2026-06-18
 */
@Service
public class GoodsServiceImpl extends ServiceImpl<GoodsMapper, Goods> implements GoodsService {

}

package com.lilemy.seckill.common.entity;

import com.mybatisflex.annotation.Column;
import com.mybatisflex.annotation.Id;
import com.mybatisflex.annotation.KeyType;
import com.mybatisflex.annotation.Table;
import com.mybatisflex.core.keygen.KeyGenerators;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDateTime;

/**
 * 秒杀订单表 实体类。
 *
 * @author lilemy
 * @since 2026-06-18
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table("seckill_order")
public class SeckillOrder implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    @Id(keyType = KeyType.Generator, value = KeyGenerators.snowFlakeId)
    private BigInteger id;

    /**
     * 用户ID
     */
    private BigInteger userId;

    /**
     * 活动ID
     */
    private BigInteger activityId;

    /**
     * 商品ID
     */
    private BigInteger goodsId;

    /**
     * 订单号
     */
    private String orderNo;

    /**
     * 秒杀价格(冗余字段)
     */
    private BigDecimal seckillPrice;

    /**
     * 商品名称(冗余字段)
     */
    private String goodsName;

    /**
     * 商品图片(冗余字段)
     */
    private String goodsImg;

    /**
     * 订单状态(0:待支付 1:待发货 2:已发货 3:已收货 4:已退款 5:已取消 6:已关闭)
     */
    private Integer status;

    /**
     * 订单过期时间
     */
    private LocalDateTime expireTime;

    /**
     * 是否删除(0:未删除 1:已删除)
     */
    @Column(isLogicDelete = true)
    private Integer isDeleted;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;

}

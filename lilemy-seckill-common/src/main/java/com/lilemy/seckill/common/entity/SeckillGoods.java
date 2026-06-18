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
 * 秒杀商品关联表 实体类。
 *
 * @author lilemy
 * @since 2026-06-18
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table("seckill_goods")
public class SeckillGoods implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    @Id(keyType = KeyType.Generator, value = KeyGenerators.snowFlakeId)
    private BigInteger id;

    /**
     * 活动ID
     */
    private BigInteger activityId;

    /**
     * 商品ID
     */
    private BigInteger goodsId;

    /**
     * 秒杀展示名称(简短，用于列表)
     */
    private String seckillTitle;

    /**
     * 秒杀展示图片(用于列表)
     */
    private String seckillImg;

    /**
     * 秒杀价
     */
    private BigDecimal seckillPrice;

    /**
     * 秒杀库存总量(不变)
     */
    private Integer seckillTotal;

    /**
     * 秒杀剩余库存(扣减)
     */
    private Integer seckillStock;

    /**
     * 秒杀限购数量
     */
    private Integer seckillLimit;

    /**
     * 展示排序(数字越小越靠前)
     */
    private Integer sort;

    /**
     * 版本号(乐观锁)
     */
    private Long version;

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

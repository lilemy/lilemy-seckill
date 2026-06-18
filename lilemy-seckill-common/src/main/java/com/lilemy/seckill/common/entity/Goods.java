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
 * 商品表 实体类。
 *
 * @author lilemy
 * @since 2026-06-18
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table("goods")
public class Goods implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    @Id(keyType = KeyType.Generator, value = KeyGenerators.snowFlakeId)
    private BigInteger id;

    /**
     * 商品名称(完整，含规格)
     */
    private String goodsName;

    /**
     * 商品主图(冗余字段，用于列表展示)
     */
    private String goodsImg;

    /**
     * 商品原价
     */
    private BigDecimal goodsPrice;

    /**
     * 商品状态(0:下架 1:上架)
     */
    private Integer status;

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

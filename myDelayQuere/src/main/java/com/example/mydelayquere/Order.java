package com.example.mydelayquere;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order implements Serializable {
    /**
     * 订单id
     */
    private String orderId;

    /**
     * 订单名称
     */
    private String name;


    /**
     * 订单状态 0：未支付，1：已支付，2：订单已取消
     */
    private Integer orderStatus;

    /**
     * 下单时间
     */
    private Date orderTime;

    /**
     * 订单金额
     */
    private BigDecimal amount;

}

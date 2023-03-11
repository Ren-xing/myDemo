package com.myredisson.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("`order`")
public class Order {
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    private Integer number;
}

package com.myredisson;

import com.myredisson.entity.Order;
import com.myredisson.mapper.OrderMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class MyRedissonApplicationTests {
    @Resource
    private OrderMapper orderMapper;

    @Test
    void contextLoads() {
        Order order = orderMapper.selectById(1);
        System.out.println(order.toString());
    }

}

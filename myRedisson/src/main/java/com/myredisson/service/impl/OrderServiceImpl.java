package com.myredisson.service.impl;

import com.myredisson.entity.Order;
import com.myredisson.mapper.OrderMapper;
import com.myredisson.service.CommodityService;
import com.myredisson.service.OrderService;
import io.lettuce.core.RedisClient;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

@Service
public class OrderServiceImpl implements OrderService {
    @Resource
    private OrderMapper orderMapper;
    @Resource
    private CommodityService commodityService;
    @Resource
    private RedissonClient redissonClient;
    @Resource
    private RedisTemplate redisTemplate;

    public static final String DISTRIBUTED_LOCK_KEY = "order:lock";


    @Override
    public void addOrder(Integer number) {
        Boolean lock = redisTemplate.opsForValue().setIfAbsent(DISTRIBUTED_LOCK_KEY, "", 2, TimeUnit.SECONDS);
        while (!lock) {
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            lock = redisTemplate.opsForValue().setIfAbsent(DISTRIBUTED_LOCK_KEY, "", 2, TimeUnit.SECONDS);
        }
        // ----- 业务代码
        Order order = new Order();
        order.setNumber(number);
        orderMapper.insert(order);
        commodityService.reduceCommodity(number);

    }
}

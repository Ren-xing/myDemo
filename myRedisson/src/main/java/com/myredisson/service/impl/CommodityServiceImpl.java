package com.myredisson.service.impl;

import com.myredisson.entity.Commodity;
import com.myredisson.mapper.CommodityMapper;
import com.myredisson.service.CommodityService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class CommodityServiceImpl implements CommodityService {
    @Resource
    private CommodityMapper commodityMapper;

    @Override
    public void reduceCommodity(Integer inventory) {
        Commodity commodity1 = commodityMapper.selectById(1);
        Commodity commodity = new Commodity();
        commodity.setId(1);
        commodity.setInventory(commodity1.getInventory() - inventory);
        commodityMapper.updateById(commodity);
    }
}

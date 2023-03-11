package com.myredisson.controller;

import com.myredisson.service.OrderService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Resource
    private OrderService orderService;

    @RequestMapping("/add/{number}")
    public String addOrder(@PathVariable Integer number) {
        orderService.addOrder(number);
        return "OK";
    }
}

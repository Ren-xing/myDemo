package com.example.mydelayquere;

public class DelayConstant {
    /**
     * 延迟队列 TTL 名称
     */
    public static final String ORDER_DELAY_QUEUE = "ticket.order.delay.queue";

    /**
     * 延时队列
     * 延时消息就是发送到该交换机的
     */
    public static final String ORDER_DELAY_EXCHANGE = "ticket.order.delay.exchange";

    /**
     * routing key 名称 路由键
     * 具体延时消息发送在该 routingKey 的
     */
    public static final String ORDER_DELAY_ROUTING_KEY = "order_delay";

    /**
     * 死信队列
     */
    public static final String DEAD_ORDER_QUEUE_NAME = "dead.ticket.order.queue";

    /**
     * 死信队列交换机 DLX，dead letter发送到的 exchange
     */
    public static final String DEAD_ORDER_EXCHANGE_NAME = "dead.ticket.order.exchange";

    /**
     * 路由
     */
    public static final String DEAD_ORDER_ROUTING_KEY = "dead.order";

}

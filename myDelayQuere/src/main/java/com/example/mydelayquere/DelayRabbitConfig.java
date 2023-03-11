package com.example.mydelayquere;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class DelayRabbitConfig {
    /**
     * 1.死信队列
     */
    @Bean
    public Queue orderQueue() {
        return new Queue(DelayConstant.DEAD_ORDER_QUEUE_NAME, true);
    }

    /**
     * 2.死信交换机
     * 通过死信交换机把死信消息发送到指定的队列中去
     * 将路由键和某模式进行匹配。此时队列需要绑定要一个模式上。
     */
    @Bean
    public TopicExchange orderTopicExchange() {
        return new TopicExchange(DelayConstant.DEAD_ORDER_EXCHANGE_NAME);
    }

    /**
     * 3.死信队列（绑定交换机）
     */
    @Bean
    public Binding orderBinding() {
        // TODO 如果要让延迟队列之间有关联,这里的 routingKey 和 绑定的交换机很关键
        return BindingBuilder.bind(orderQueue()).to(orderTopicExchange()).with(DelayConstant.DEAD_ORDER_ROUTING_KEY);
    }


    /**
     * 4.延时队列配置
     * <p>
     * 1、第一种方式是直接设置 Queue 延迟时间 但如果直接给队列设置过期时间,这种做法不是很灵活,（当然二者是兼容的,默认是时间小的优先）
     * params.put("x-message-ttl", 5 * 1000);
     * 2、第二种就是每次发送消息动态设置延迟时间,这样我们可以灵活控制
     */
    @Bean
    public Queue delayOrderQueue() {
        Map<String, Object> params = new HashMap<>();
        // x-dead-letter-exchange 声明了队列里的死信转发到的DLX名称，即死信消息转发到那个队列
        params.put("x-dead-letter-exchange", DelayConstant.DEAD_ORDER_EXCHANGE_NAME);
        // x-dead-letter-routing-key 声明了这些死信在转发时携带的 routing-key 名称。
        params.put("x-dead-letter-routing-key", DelayConstant.DEAD_ORDER_ROUTING_KEY);
        return new Queue(DelayConstant.ORDER_DELAY_QUEUE, true, false, false, params);
    }

    /**
     * 5.延时队列绑定到交换机上，要求该消息与一个特定的路由键完全匹配。
     *
     * @return DirectExchange
     */
    @Bean
    public DirectExchange orderDelayExchange() {
        return new DirectExchange(DelayConstant.ORDER_DELAY_EXCHANGE);
    }

    /**
     * 6.延时队列绑定交换机
     */
    @Bean
    public Binding dlxBinding() {
        return BindingBuilder.bind(delayOrderQueue()).to(orderDelayExchange()).with(DelayConstant.ORDER_DELAY_ROUTING_KEY);
    }

}

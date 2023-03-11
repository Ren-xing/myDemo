package com.example.mydelayquere;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class RabbitmqOrderProducer {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void publish(Order order, String messageId, String exchangeName, String key) {
        /* 确认的回调 确认消息是否到达 Broker 服务器 其实就是是否到达交换器
         * 如果发送时候指定的交换器不存在 ack 就是 false 代表消息不可达
         */
        rabbitTemplate.setConfirmCallback((correlationData, ack, cause) -> {
            log.info("correlationData：{} , ack:{}", correlationData.getId(), ack);
            if (!ack) {
                System.out.println("进行对应的消息补偿机制");
            }
        });
        /* 消息失败的回调
         * 例如消息已经到达交换器上，但路由键匹配任何绑定到该交换器的队列，会触发这个回调，此时 replyText: NO_ROUTE
         */
        rabbitTemplate.setReturnCallback((message, replyCode, replyText, exchange, routingKey) -> {
            log.info("message:{}; replyCode: {}; replyText: {} ; exchange:{} ; routingKey:{}",
                    message, replyCode, replyText, exchange, routingKey);
        });
        // 在实际中ID 应该是全局唯一 能够唯一标识消息 消息不可达的时候触发ConfirmCallback回调方法时可以获取该值，进行对应的错误处理
        CorrelationData correlationData = new CorrelationData(messageId);
        rabbitTemplate.convertAndSend(exchangeName, key, order, message -> {
            /**
             * 如果配置了 params.put("x-message-ttl", 60 * 1000 * 30);
             * 那么这一句也可以省略,具体根据业务需要是声明 Queue 的时候就指定好延迟时间还是在发送自己控制时间
             * 这里为了演示设置为 10 s
             */
            message.getMessageProperties().setExpiration(1000 * 10 + "");
            return message;
        }, correlationData);
    }

}

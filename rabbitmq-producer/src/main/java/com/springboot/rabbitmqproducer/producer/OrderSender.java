package com.springboot.rabbitmqproducer.producer;

import com.springboot.rabbitmqproducer.entity.Order;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 订单发送
 *
 * @author huangyin
 */
@Component
public class OrderSender {
    /**
     * 模板对象：Spring 为了简化 RabbitMQ 操作，引入的模板对象
     * 建议使用 RabbitTemplate，而不是使用 AmqpTemplate
     */
    private final RabbitTemplate rabbitTemplate;

    public OrderSender(
            @Autowired RabbitTemplate rabbitTemplate
    ) {
        this.rabbitTemplate = rabbitTemplate;
    }

    /**
     * 发送消息
     *
     * @param order 订单数据
     */
    public void sendByRouteKeyTwo(Order order) {
//        CorrelationData correlationData = new CorrelationData();
//        correlationData.setId(order.getMessageId());
//        this.rabbitTemplate.setReturnsCallback(this);
        this.rabbitTemplate.setConfirmCallback((correlationData, ack, cause) -> {

        });
        // CorrelationData：消息唯一id
        // 路由key：order.*模糊匹配，表示一个点后面的，如果要表达多个点，那么使用order.#
//        rabbitTemplate.convertAndSend("route_exchange", "route_two", order, correlationData);
    }

    /**
     * 路由方式发送
     *
     * @param message 消息
     */
    public void sendByRoute(String message) {

        rabbitTemplate.convertAndSend("route_exchange", "route_one", message);
    }

//    @Override
//    public void confirm(CorrelationData correlationData, boolean b, String s) {
//
//    }
}

package com.springboot.rabbitmqconsumer.consumer;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Delivery;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Map;

/**
 * 订单消息接收方
 *
 * @author huangyin
 */
@Component
public class OrderReceiver {
    /**
     * 监听队列
     *
     * @param message 消息
     * @param headers 消息头
     * @param channel 通道
     * @throws IOException IOException
     */
    @RabbitListener(queues = "queue_one")
    public void receiveMessageForQueueOne(@Payload String message,
                                          @Headers Map<String, Object> headers,
                                          Channel channel) throws IOException {
        System.out.println("接收到队列One中的消息：消息为：" + message);
        Long deliveryTag = (Long) headers.get(AmqpHeaders.DELIVERY_TAG);
        channel.basicAck(deliveryTag, false);
    }

    @RabbitListener(queues = "queue_two")
    public void receiveMessageForQueueTwo(String message) {
        System.out.println("接收到队列Two中的消息：消息为：" + message);
    }
}

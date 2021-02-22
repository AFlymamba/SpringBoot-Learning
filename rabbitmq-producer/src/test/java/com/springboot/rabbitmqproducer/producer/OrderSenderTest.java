package com.springboot.rabbitmqproducer.producer;

import com.springboot.rabbitmqproducer.entity.Order;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.UUID;

/**
 * @author huangyin
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class OrderSenderTest {
    @Autowired
    private OrderSender orderSender;

    @Test
    public void testSend() {
        Order order = new Order();
        order.setId(1L);
        order.setName("one-order");
        order.setOrderId(UUID.randomUUID().toString());
        order.setMessageId(System.currentTimeMillis() + "$" + UUID.randomUUID().toString());
//        orderSender.send(order);
    }

    @Test
    public void testRoute() {
        String message = "路由One信息";
        orderSender.sendByRoute(message);
    }
}

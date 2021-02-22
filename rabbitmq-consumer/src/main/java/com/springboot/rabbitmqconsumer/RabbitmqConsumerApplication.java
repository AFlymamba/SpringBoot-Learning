package com.springboot.rabbitmqconsumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 主启动类：只有消费者定义交换器、路由相关属性时，RabbitMQ 才会去创建
 *
 * @author huangyin
 */
@SpringBootApplication
public class RabbitmqConsumerApplication {
    public static void main(String[] args) {
        SpringApplication.run(RabbitmqConsumerApplication.class, args);
    }
}

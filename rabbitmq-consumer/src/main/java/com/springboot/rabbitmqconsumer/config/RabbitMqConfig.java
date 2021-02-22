package com.springboot.rabbitmqconsumer.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * RabbitMQ 配置
 *
 * @author huangyin
 */
@Configuration
public class RabbitMqConfig {
    /**
     * 交换器名称
     */
    private final String ROUTE_EXCHANGE = "route_exchange";

    /**
     * 队列名称
     */
    private final String QUEUE_ONE = "queue_one";
    private final String QUEUE_TWO = "queue_two";

    /**
     * 路由 key
     */
    private final String ROUTE_KEY_ONE = "route_one";
    private final String ROUTE_KEY_TWO = "route_two";

    @Bean
    public DirectExchange directExchange() {
        return new DirectExchange(ROUTE_EXCHANGE, true, false);
    }

    @Bean
    public Queue oneQueue() {
        return new Queue(QUEUE_ONE, true, true, false);
    }

    @Bean
    public Queue twoQueue() {
        return new Queue(QUEUE_TWO, true, true, false);
    }

    @Bean
    public Binding bindQueueOneToExchange(Queue oneQueue, DirectExchange directExchange) {
        return BindingBuilder.bind(oneQueue).to(directExchange).with(ROUTE_KEY_ONE);
    }

    @Bean
    public Binding bindQueueTwoToExchange(Queue twoQueue, DirectExchange directExchange) {
        return BindingBuilder.bind(twoQueue).to(directExchange).with(ROUTE_KEY_TWO);
    }
}

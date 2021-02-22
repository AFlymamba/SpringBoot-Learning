package com.springboot.rabbitmqproducer.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * RabbitMQ：发布订阅模式配置
 *
 * @author huangyin
 */
@Configuration
public class FanoutRabbitMqConfig {
    public static final String MASS_FANOUT_EXCHANGE_NAME = "mass_fanout_exchange";

    public static final String QUEUE_NAME_CUSTOMER_MESSAGE = "queue_name_customer_message";
    public static final String QUEUE_NAME_TEMPLATE_MESSAGE = "queue_name_template_message";

    /**
     * 定义交换机
     */
    @Bean
    public FanoutExchange fanoutExchange() {
        return new FanoutExchange(MASS_FANOUT_EXCHANGE_NAME, true, true);
    }

    /**
     * durable：是否持久化
     * exclusive：是否隔离
     * autoDelete：是否自动删除
     *
     * @return 队列
     */
    @Bean(name = "customer_queue")
    public Queue customerQueue() {
        return new Queue(QUEUE_NAME_CUSTOMER_MESSAGE, true, true, true);
    }
//
//    @Bean
//    public Queue templateQueue() {
//        return new Queue(QUEUE_NAME_TEMPLATE_MESSAGE, true);
//    }

    /**
     * 配置绑定关系
     *
     * @param customerQueue
     * @param fanoutExchange
     * @return
     */
    @Bean
    public Binding bindingExchangeCustomer(@Qualifier("customer_queue") Queue customerQueue, FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(customerQueue).to(fanoutExchange);
    }

//    @Bean
//    public Binding bindingExchangeTemplate(@Qualifier("template_queue") Queue templateQueue, FanoutExchange fanoutExchange) {
//        return BindingBuilder.bind(templateQueue).to(fanoutExchange);
//    }
}

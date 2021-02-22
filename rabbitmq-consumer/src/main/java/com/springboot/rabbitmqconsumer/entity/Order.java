package com.springboot.rabbitmqconsumer.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * 订单实体
 *
 * @author huangyin
 */
@Data
public class Order implements Serializable {
    private static final long serialVersionUID = 4511943292762976496L;

    private Long id;

    private String orderId;

    private String name;

    private String messageId;
}

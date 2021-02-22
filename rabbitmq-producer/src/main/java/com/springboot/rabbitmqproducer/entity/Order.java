package com.springboot.rabbitmqproducer.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @author huangyin
 */
@Data
public class Order implements Serializable {
    private static final long serialVersionUID = -2585469716137737693L;

    private Long id;

    private String orderId;

    private String name;

    private String messageId;
}

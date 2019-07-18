package com.example;

import io.micronaut.configuration.rabbitmq.annotation.Queue;
import io.micronaut.configuration.rabbitmq.annotation.RabbitListener;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RabbitListener
public class ProductListener {

    List<Integer> messageLengths = Collections.synchronizedList(new ArrayList<>());

    @Queue("product")
    public void receive(byte[] data) {
        messageLengths.add(data.length);
    }
}

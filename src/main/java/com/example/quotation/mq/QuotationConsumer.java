package com.example.quotation.mq;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "demoQueue")
public class QuotationConsumer {

    @RabbitHandler
    public void received(String msg) {
        System.out.println("[demoQueue] received message: " + msg);
    }

}

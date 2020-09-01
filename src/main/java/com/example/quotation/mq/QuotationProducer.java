package com.example.quotation.mq;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@Component
public class QuotationProducer {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    @Resource
    private RestTemplate restTemplate;

    public void sendDemoQueue(String list) {
        String quotation = "";

        try {
            quotation = restTemplate.getForObject("http://hq.sinajs.cn/?list=" + list, String.class).split("\"")[1];
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("[demoQueue] send message: " + quotation);
        this.rabbitTemplate.convertAndSend("demoQueue", quotation);
    }

}

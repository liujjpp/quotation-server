package com.example.quotation.controller;

import com.example.quotation.mq.QuotationProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RabbitMQController {

    @Autowired
    private QuotationProducer quotationProducer;

    @GetMapping("/sendDemoQueue")
    public Object sendDemoQueue(String list) {
        quotationProducer.sendDemoQueue(list);
        return "success";
    }

}

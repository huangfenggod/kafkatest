package com.hf.controller;

import com.hf.kafka.ProducerUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KfakaController {
    @Autowired
    private ProducerUtils producerUtils;

    @GetMapping("/send")
    public String sendKafka(@RequestParam String s){
        producerUtils.produce(s);
        return "success";
    }

}

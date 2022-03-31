package com.hf.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Kafkaconfig {

    @Bean
    public NewTopic newTopic(){
        return new NewTopic("test",2,(short) 1);
    }
}

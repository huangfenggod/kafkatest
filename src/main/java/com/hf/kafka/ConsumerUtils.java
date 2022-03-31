package com.hf.kafka;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class ConsumerUtils {
    private static final Logger LOGGER = LoggerFactory.getLogger(ConsumerUtils.class);
    @Autowired
    private KafkaTemplate kafkaTemplate;

    @KafkaListener(id = "hf",topics = "test",groupId = "hf")
    public void consume(ConsumerRecord<Object,Object> record){
    LOGGER.info("topic:"+record.topic());
    LOGGER.info(String.valueOf("partition:"+record.partition()));
    LOGGER.info(String.valueOf("offset:"+record.offset()));
    LOGGER.info("value:"+record.value().toString());
    }
}

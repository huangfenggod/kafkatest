package com.hf.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

import java.util.concurrent.ExecutionException;

@Component
public class ProducerUtils {

    @Autowired
    private KafkaTemplate kafkaTemplate;
    private static final Logger LOGGER = LoggerFactory.getLogger(ProducerUtils.class);


    public void produce(Object o){
//异步方式获取回调
        kafkaTemplate.send("test", o).addCallback(new ListenableFutureCallback() {
            @Override
            public void onFailure(Throwable ex) {
            LOGGER.info(o.toString()+"传入kafka失败");
            }

            @Override
            public void onSuccess(Object result) {
            LOGGER.info(o.toString()+"传入kafka成功");
            }
        });
        //同步方式获取回调
//        ListenableFuture<SendResult<Object,Object>> listenableFuture=kafkaTemplate.send("test",o);
//        try {
//            SendResult<Object, Object> sendResult = listenableFuture.get();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

//开启事务性  在需要添加事务性的方法上添加@Transactional 开启配置spring.kafka.producer.transaction-id-prefix
//        kafkaTemplate.executeInTransaction(t->{
//            t.send("test",0);
//            return true;
//        });

    }

}

//package org.mcclone.listener;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.amqp.rabbit.annotation.RabbitListener;
//import org.springframework.stereotype.Component;
//
///**
// * @author zhengsd
// */
//@Component
//public class MessageListener {
//
//    private static final Logger logger = LoggerFactory.getLogger(MessageListener.class);
//
//    @RabbitListener(queues = "hello")
//    public void processMessage(String content) {
//        logger.info(content);
//    }
//}

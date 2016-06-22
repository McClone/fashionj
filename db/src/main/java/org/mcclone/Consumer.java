package org.mcclone;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author zhengsd
 */
public class Consumer {

    public static void main(String[] args) {
        ApplicationContext context=new AnnotationConfigApplicationContext(AmqpConfig.class);
        AmqpTemplate amqpTemplate=context.getBean(AmqpTemplate.class);
        System.out.println(amqpTemplate.receiveAndConvert());
    }
}

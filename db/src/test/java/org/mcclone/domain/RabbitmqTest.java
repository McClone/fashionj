package org.mcclone.domain;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mcclone.DbApplication;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author zhengsd
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = DbApplication.class)
public class RabbitmqTest {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Test
    public void testMessage() throws Exception {
        rabbitTemplate.setQueue("hello");
        rabbitTemplate.convertAndSend("Hello world!!!!");
    }

    @Test
    public void testReceived() throws Exception {
        rabbitTemplate.setQueue("hello");
        System.out.println(rabbitTemplate.receiveAndConvert());
    }
}

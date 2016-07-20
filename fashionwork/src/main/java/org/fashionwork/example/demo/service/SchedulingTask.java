package org.fashionwork.example.demo.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @author zhengsd
 */
@Component
public class SchedulingTask {

    private Logger logger = LoggerFactory.getLogger(SchedulingTask.class);

    @Scheduled(fixedDelay = 5000)
    public void doSomething() {
        logger.info("do something......");
    }
}

package com.example.service.impl;

import com.example.service.DemoService;
import org.springframework.beans.factory.InitializingBean;

/**
 * @author zhengsd
 */
public class DemoServiceImpl implements DemoService, InitializingBean {

    @Override
    public String test() {
        return "test";
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("123");
    }
}

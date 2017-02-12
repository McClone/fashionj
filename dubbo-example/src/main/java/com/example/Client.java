package com.example;

import com.example.service.DemoService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author zhengsd
 */
public class Client {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("dubbo-client.xml");
        context.start();
        DemoService demoService = (DemoService) context.getBean("demoService"); // 获取远程服务代理
        String hello = demoService.test(); // 执行远程方法
        System.out.println(hello);
    }
}

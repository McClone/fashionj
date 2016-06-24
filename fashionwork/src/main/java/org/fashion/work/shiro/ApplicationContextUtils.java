package org.fashion.work.shiro;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhengsd
 */
public class ApplicationContextUtils implements ApplicationContextAware {

    private static ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    public static Object getBean(String beanName) throws BeansException {
        return applicationContext.getBean(beanName);
    }

    public static <T> T getBean(Class<T> tClass, String beanName) throws BeansException {
        return applicationContext.getBean(beanName, tClass);
    }

    public static <T> List<T> getBean(Class<T> tClass, String... beanNames) throws BeansException {
        List<T> beans = new ArrayList<>();
        for (String beanName : beanNames) {
            beans.add(getBean(tClass, beanName));
        }
        return beans;
    }

}

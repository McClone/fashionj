package org.mcclone.aop;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * @author zhengsd
 */
public class TestAdvice implements MethodBeforeAdvice {

    private static final Logger logger = LoggerFactory.getLogger(TestAdvice.class);

    @Override
    public void before(Method method, Object[] args, Object target) throws Throwable {
        logger.info(method.getName());
    }
}

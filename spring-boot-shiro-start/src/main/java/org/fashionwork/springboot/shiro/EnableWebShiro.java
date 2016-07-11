package org.fashionwork.springboot.shiro;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * @author zhengsd
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
@Documented
@Import({WebShiroAutoConfiguration.class})
@Configuration
public @interface EnableWebShiro {
}

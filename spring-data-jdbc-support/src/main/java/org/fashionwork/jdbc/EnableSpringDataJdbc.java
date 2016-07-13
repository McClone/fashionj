package org.fashionwork.jdbc;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * @author zhengsd
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
@Documented
@Import({SpringDataJdbcAutoConfiguration.class})
@Configuration
public @interface EnableSpringDataJdbc {

}

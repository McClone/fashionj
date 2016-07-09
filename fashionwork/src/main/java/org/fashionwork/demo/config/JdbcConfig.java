package org.fashionwork.demo.config;

import org.fashionwork.demo.domain.dialect.NamedOracle12cDialect;
import org.fashionwork.demo.domain.page.JdbcRepository;
import org.fashionwork.demo.domain.page.SimpleJdbcRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * @author zhengsd
 */
@Configuration
public class JdbcConfig {

    @Autowired
    private DataSource dataSource;

    @Bean
    public JdbcRepository jdbcRepository() {
        SimpleJdbcRepository jdbcRepository = new SimpleJdbcRepository(dataSource);
        jdbcRepository.setDialect(new NamedOracle12cDialect());
        return jdbcRepository;
    }
}

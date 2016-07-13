package org.fashionwork.jdbc;

import org.fashionwork.jdbc.dialect.NamedOracle12cDialect;
import org.fashionwork.jdbc.repository.JdbcRepository;
import org.fashionwork.jdbc.repository.SimpleJdbcRepository;
import org.hibernate.dialect.Dialect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * @author zhengsd
 */
@Configuration
public class SpringDataJdbcAutoConfiguration {

    @Autowired
    private DataSource dataSource;

    private Dialect defaultDiaect = new NamedOracle12cDialect();

    @Bean
    public JdbcRepository jdbcRepository() {
        SimpleJdbcRepository jdbcRepository = new SimpleJdbcRepository(dataSource);
        jdbcRepository.setDialect(defaultDiaect);
        return jdbcRepository;
    }
}

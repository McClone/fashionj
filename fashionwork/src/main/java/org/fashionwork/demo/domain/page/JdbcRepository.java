package org.fashionwork.demo.domain.page;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.jdbc.core.RowMapper;

import java.util.Map;

/**
 * @author zhengsd
 */
public interface JdbcRepository {

    <T> Page<T> findAll(Pageable pageable, String sql, Map<String, Object> params, RowMapper<T> rowMapper);

    Integer countSql(String sql, Map<String, Object> params);

}
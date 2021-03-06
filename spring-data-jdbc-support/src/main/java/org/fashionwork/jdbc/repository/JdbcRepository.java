package org.fashionwork.jdbc.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;

import java.util.Map;

/**
 * @author zhengsd
 */
public interface JdbcRepository extends NamedParameterJdbcOperations {

    <T> Page<T> queryForPage(Pageable pageable, String sql, Map<String, Object> params, RowMapper<T> rowMapper);

    Integer countForInt(String sql, Map<String, Object> params);

}

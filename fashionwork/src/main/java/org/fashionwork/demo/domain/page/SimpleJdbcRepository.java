package org.fashionwork.demo.domain.page;

import org.hibernate.dialect.Dialect;
import org.hibernate.engine.spi.RowSelection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zhengsd
 */
public class SimpleJdbcRepository implements JdbcRepository {

    private static final String COUNT_QUERY_STRING = "select count(*) from (%s) x";

    private Logger logger = LoggerFactory.getLogger(SimpleJdbcRepository.class);

    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    private Dialect dialect;

    @Override
    public <T> Page<T> queryForPage(Pageable pageable, String sql, Map<String, Object> params, RowMapper<T> rowMapper) {
        if (null == pageable) {
            return new PageImpl<>(getNamedParameterJdbcTemplate().query(sql, params, rowMapper));
        }
        int total = countForInt(sql, params);
        String limitSql = dialect.getLimitHandler().processSql(sql, wrapperPageable(pageable));
        logger.info("sql:{};total:{}", limitSql, total);
        params = params != null ? params : new HashMap<>();
        params.put("offset", pageable.getOffset());
        params.put("limit", pageable.getPageSize() + pageable.getOffset());
        List<T> content = total > pageable.getOffset() ? this.getNamedParameterJdbcTemplate().query(limitSql, params, rowMapper) : Collections.emptyList();
        return new PageImpl<>(content, pageable, total);
    }

    public NamedParameterJdbcTemplate getNamedParameterJdbcTemplate() {
        return namedParameterJdbcTemplate;
    }

    @Override
    public Integer countForInt(String sql, Map<String, Object> params) {
        String totalSql = String.format(COUNT_QUERY_STRING, sql);
        return this.namedParameterJdbcTemplate.queryForObject(totalSql, params, Integer.class);
    }

    public void setDialect(Dialect dialect) {
        this.dialect = dialect;
    }

    private static RowSelection wrapperPageable(Pageable pageable) {
        RowSelection rowSelection = new RowSelection();
        rowSelection.setFetchSize(pageable.getPageSize());
        rowSelection.setFirstRow(pageable.getOffset());
        return rowSelection;
    }

    public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }
}

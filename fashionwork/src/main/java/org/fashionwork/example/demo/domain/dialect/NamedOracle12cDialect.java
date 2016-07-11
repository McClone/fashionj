package org.fashionwork.example.demo.domain.dialect;

import org.hibernate.dialect.Oracle12cDialect;
import org.hibernate.dialect.pagination.AbstractLimitHandler;
import org.hibernate.dialect.pagination.LimitHandler;
import org.hibernate.dialect.pagination.LimitHelper;
import org.hibernate.engine.spi.RowSelection;

import java.util.Locale;

/**
 * <p>提供占位符形式的Dialect</p>
 *
 * @author zhengsd
 */
public class NamedOracle12cDialect extends Oracle12cDialect {

    private static final AbstractLimitHandler LIMIT_HANDLER = new AbstractLimitHandler() {
        @Override
        public String processSql(String sql, RowSelection selection) {
            final boolean hasOffset = LimitHelper.hasFirstRow(selection);
            sql = sql.trim();
            String forUpdateClause = null;
            boolean isForUpdate = false;
            final int forUpdateIndex = sql.toLowerCase(Locale.ROOT).lastIndexOf("for update");
            if (forUpdateIndex > -1) {
                forUpdateClause = sql.substring(forUpdateIndex);
                sql = sql.substring(0, forUpdateIndex - 1);
                isForUpdate = true;
            }

            final StringBuilder pagingSelect = new StringBuilder(sql.length() + 100);
            if (hasOffset) {
                pagingSelect.append("select * from ( select row_.*, rownum rownum_ from ( ");
            } else {
                pagingSelect.append("select * from ( ");
            }
            pagingSelect.append(sql);
            if (hasOffset) {
                pagingSelect.append(" ) row_ where rownum <= :limit) where rownum_ > :offset");
            } else {
                pagingSelect.append(" ) where rownum <= :limit");
            }

            if (isForUpdate) {
                pagingSelect.append(" ");
                pagingSelect.append(forUpdateClause);
            }

            return pagingSelect.toString();
        }

        @Override
        public boolean supportsLimit() {
            return true;
        }

        @Override
        public boolean bindLimitParametersInReverseOrder() {
            return true;
        }

        @Override
        public boolean useMaxForLimit() {
            return true;
        }
    };

    @Override
    public LimitHandler getLimitHandler() {
        return LIMIT_HANDLER;
    }
}

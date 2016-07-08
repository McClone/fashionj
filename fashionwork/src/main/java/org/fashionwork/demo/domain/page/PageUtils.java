package org.fashionwork.demo.domain.page;

import org.hibernate.engine.spi.RowSelection;
import org.springframework.data.domain.Pageable;

/**
 * @author zhengsd
 */
public class PageUtils {

    public static final String COUNT_QUERY_STRING = "select count(*) from (%s) x";

    public static RowSelection createRowSelection(Pageable pageable) {
        RowSelection rowSelection = new RowSelection();
        rowSelection.setFetchSize(pageable.getPageSize());
        rowSelection.setFirstRow(pageable.getOffset());
        return rowSelection;
    }

}

package com.chy.to;

import lombok.Data;

/**
 * @author chy
 * @since 2021-03-22 19:50
 */
@Data
public class PageQueryTo extends BaseTo {
    private static final long serialVersionUID = -1319283881967144831L;

    private static final Integer DEFAULT_PAGE = 1;
    private static final Integer DEFAULT_PAGE_SIZE = 20;

    /**
     * 当前页数
     */
    private Integer page = DEFAULT_PAGE;
    /**
     * 每页大小
     */
    private Integer pageSize = DEFAULT_PAGE_SIZE;


}
package com.chy.to;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.chy.enums.CommonEnum;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author chy
 * @since 2021-03-22 19:52
 */
@Data
public class PageResult<T> implements Serializable {

    private Integer code;
    private String message;
    private List<T> data;
    // 新增和分页相关的三个字段
    private Long page;
    private Long pageSize;
    private Long total;

    private PageResult(List<T> data, Long page, Long pageSize, Long total) {
        this.code = CommonEnum.SUCCESS.getCode();
        this.message = CommonEnum.SUCCESS.getMessage();
        this.data = data;
        this.page = page;
        this.pageSize = pageSize;
        this.total = total;
    }

    /**
     * 成功实体，传入一个page对象
     *
     * @param page
     */
    public static <T> PageResult<T> success(Page<T> page) {
        if (page != null) {
            return new PageResult<T>(page.getRecords(), page.getCurrent(), page.getSize(), page.getTotal());
        } else {
            return new PageResult<T>(new ArrayList<T>(), 0L, 1L, 10L);
        }
    }
}
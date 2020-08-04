package com.isiyi.common.entity.vo;

import lombok.Data;


@Data
public class PageResultVO<T> extends ResultVO<T>  {

    private long total;//总页数
    private long totalPages;//总页数
    private long pageSize;//页面容量
    private long page;//当前页

    public PageResultVO() {
    }

    /**
     * @param data       数据列表
     * @param total      数据总量
     * @param totalPages 总页数
     * @param pageSize   页容量
     * @param page       当前页
     * @Description: 分页回调数据
     * @Author: isiyi
     * @Date: 2020/07/13
     **/
    public PageResultVO success(T data,
                              long total,
                              long totalPages,
                              long pageSize,
                              long page) {

        super.success(data);

        this.total = total;
        this.totalPages = totalPages;
        this.pageSize = pageSize;
        this.page = page;

        return this;
    }

}

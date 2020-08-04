package com.isiyi.common.entity.dto;

import lombok.Data;

/**
 * 分页的公共dto
 */
@Data
public class PageCommonDTO {
    /**
     * 分页 ，页码，默认1
     */
    private Integer page = 1; //分页 ，页码

    /**
     * 分页size，默认10
     */
    private Integer limit = 10; //分页size

}

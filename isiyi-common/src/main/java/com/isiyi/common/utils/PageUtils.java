package com.isiyi.common.utils;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.isiyi.common.entity.dto.PageCommonDTO;
import com.isiyi.common.entity.vo.PageResultVO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.Validate;
import org.springframework.beans.BeanUtils;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @ClassName : PageUtils
 * @Description : 集合分页工具类
 * @Author : xpf
 * @Date: 2020-02-26 18:07
 */
public class PageUtils<O, T> {

    public PageUtils() {
    }

    /**
     * @param collection, currentPage, limit
     * @return com.secxun.common.utils.PageUtils.CollectionPage
     * @Description: 集合分页
     * @Author: xpf
     * @Date: 2020/2/26 18:39
     **/
    public static <T> CollectionPage collectionPage(List<T> collection, int currentPage, int limit) {
        Validate.notNull(collection, "集合不能为NULL");
        Validate.inclusiveBetween(1, Integer.MAX_VALUE, currentPage, "页码必须大于1");
        Validate.inclusiveBetween(1, Integer.MAX_VALUE, limit, "页面容量必须大于1");

        CollectionPage collectionPage = new CollectionPage();
        //1.集合为空
        if (collection.isEmpty()) {
            return collectionPage;
        }
        //2.集合有长度,起始索引(currentPage-1)*limit，结束索引currentPage*limit
        //2.1.结束索引大于集合总长度
        //2.2.结束索引小于集合总长度
        int beginIndex = (currentPage - 1) * limit, endIndex = currentPage * limit, pages = collection.size() / limit;
        //起始索引处理
        Validate.inclusiveBetween(0, collection.size() - 1, beginIndex, "页码超出");
        //处理页数
        pages = collection.size() % limit == 0 ? pages : pages + 1;
        endIndex = Math.min(endIndex, collection.size());
        collectionPage.setContent(collection.subList(beginIndex, endIndex));
        collectionPage.setPages(pages);
        collectionPage.setTotal(collection.size());
        collectionPage.setCurrentPage(currentPage);
        collectionPage.setLimit(limit);
        return collectionPage;
    }

    /**
     * 获取分页当前页需要默认 -1
     *
     * @param page
     * @return
     */
    public static int getPage(PageCommonDTO page) {
        try {
            Integer currPage = page.getPage();
            currPage -= 1;
            return currPage;
        } catch (Exception e) {
        }
        return 0;
    }

    /**
     * @param page, voClazz
     * @return com.secxun.common.entity.vo.PageResult<java.util.List < T>>
     * @Description: 分页数据的vo转换
     * @Author: xpf
     * @Date: 2020/2/26 18:37
     **/
    public PageResultVO<List<T>> ApiPageResult(IPage<List<O>> page, Class<T> voClazz) {

        List<T> voList = page.getRecords().stream().map(po -> {
            try {
                T t = voClazz.newInstance();
                BeanUtils.copyProperties(po, t);
                return t;
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            return null;
        }).collect(Collectors.toList());

        return new PageResultVO<>().success(voList, page.getTotal(),
                page.getPages(),
                page.getSize(),
                page.getCurrent());
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class CollectionPage {
        private List<?> content = Collections.EMPTY_LIST;
        private Integer pages = 0;
        private Integer total = 0;
        private Integer currentPage = 0;
        private Integer limit = 0;
    }


}

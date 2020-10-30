package com.monkey.service.impl.center;

import com.github.pagehelper.PageInfo;
import com.monkey.utils.PagedGridResult;

import java.util.List;

/**
 * @author tao
 * @date 2020/10/30 4:11 下午
 */
public class BaseService {

    public PagedGridResult setterPagedGrid(List<?> list, Integer page) {
        PageInfo<?> pageList = new PageInfo<>(list);
        PagedGridResult pagedGridResult = new PagedGridResult();
        pagedGridResult.setPage(page);
        pagedGridResult.setRows(list);
        pagedGridResult.setTotal(pageList.getPages());
        pagedGridResult.setRecords(pageList.getTotal());
        return pagedGridResult;
    }
}

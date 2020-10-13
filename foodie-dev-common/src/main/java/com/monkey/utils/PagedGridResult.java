package com.monkey.utils;

import lombok.Data;

import java.util.List;

/**
 * @author tao
 * @date 2020/10/13 5:32 下午
 */
@Data
public class PagedGridResult {
    private int page;
    private int total;
    private long records;
    private List<?> rows;
}

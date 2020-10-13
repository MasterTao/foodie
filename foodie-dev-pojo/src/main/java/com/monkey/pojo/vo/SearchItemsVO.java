package com.monkey.pojo.vo;

import lombok.Data;

/**
 * 用于展示商品搜索列表结果的vo
 *
 * @author tao
 * @date 2020/10/13 5:08 下午
 */
@Data
public class SearchItemsVO {
    private String itemId;
    private String itemName;
    private Integer sellCounts;
    private String imgUrl;
    private Integer price;
}

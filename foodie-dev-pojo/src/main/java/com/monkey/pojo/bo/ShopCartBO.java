package com.monkey.pojo.bo;

import lombok.Data;

/**
 * @author tao
 * @date 2020/10/14 4:39 下午
 */
@Data
public class ShopCartBO {
    private String itemId;
    private String itemImgUrl;
    private String itemName;
    private String specId;
    private String specName;
    private Integer buyCounts;
    private String priceDiscount;
    private String priceNormal;
}

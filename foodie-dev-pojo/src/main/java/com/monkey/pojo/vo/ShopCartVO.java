package com.monkey.pojo.vo;

import lombok.Data;

/**
 * @author tao
 * @date 2020/10/14 7:28 下午
 */
@Data
public class ShopCartVO {
    private String itemId;
    private String itemImgUrl;
    private String itemName;
    private String specId;
    private String specName;
    private String priceDiscount;
    private String priceNormal;
}

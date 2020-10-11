package com.monkey.pojo.vo;

import lombok.Data;

import java.util.List;

/**
 * 最新商品VO
 *
 * @author tao
 * @date 2020/10/10 4:09 下午
 */
@Data
public class NewItemsVO {

    private Integer rootCatId;
    private String rootCatName;
    private String slogan;
    private String catImage;
    private String bgColor;

    private List<SimpleItemVO> simpleItemList;
}

package com.monkey.pojo.bo.center;

import lombok.Data;

/**
 * @author tao
 * @date 2020/10/28 6:55 下午
 */
@Data
public class OrderItemsCommentBO {
    private String commentId;
    private String itemId;
    private String itemName;
    private String itemSpecId;
    private String itemSpecName;
    private Integer commentLevel;
    private String content;
}

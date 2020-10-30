package com.monkey.pojo.vo;

import lombok.Data;

import java.util.Date;

/**
 * @author tao
 * @date 2020/10/30 3:57 下午
 */
@Data
public class MyCommentVO {

    private String commentId;
    private String content;
    private Date createdTime;
    private String itemId;
    private String itemName;
    private String sepcName;
    private String itemImg;
}

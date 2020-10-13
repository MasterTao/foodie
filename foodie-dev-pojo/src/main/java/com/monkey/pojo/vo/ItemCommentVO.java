package com.monkey.pojo.vo;

import lombok.Data;

import java.util.Date;

/**
 * 用于展示商品评价的vo
 *
 * @author tao
 * @date 2020/10/13 5:08 下午
 */
@Data
public class ItemCommentVO {
    private Integer commentLevel;
    private String content;
    private String specName;
    private Date createTime;
    private String userFace;
    private String nickname;
}

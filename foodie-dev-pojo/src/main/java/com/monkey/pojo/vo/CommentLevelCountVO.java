package com.monkey.pojo.vo;

import lombok.Data;

/**
 * 用于展示商品评论数的vo
 *
 * @author tao
 * @date 2020/10/11 3:52 下午
 */
@Data
public class CommentLevelCountVO {

    private Integer totalCounts;
    private Integer goodsCounts;
    private Integer normalCounts;
    private Integer badCounts;
}

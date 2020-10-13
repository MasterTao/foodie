package com.monkey.enums;

/**
 * 商品评价等级 枚举
 *
 * @author tao
 * @date 2020/10/8 7:41 下午
 */
public enum CommentLevel {

    GOOD(1, "好评"),
    NORAML(2, "中评"),
    BAD(3, "差评");

    /**
     * 类型
     */
    public final Integer type;

    /**
     * 描述
     */
    public final String value;

    CommentLevel(Integer type, String value) {
        this.type = type;
        this.value = value;
    }
}

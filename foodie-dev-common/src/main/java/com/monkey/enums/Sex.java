package com.monkey.enums;

/**
 * 性别枚举
 *
 * @author tao
 * @date 2020/10/8 7:41 下午
 */
public enum Sex {
    /**
     * 性别
     */
    women(0, "女"),
    man(1, "男"),
    secret(2, "保密");

    /**
     * 类型
     */
    public final Integer type;

    /**
     * 描述
     */
    public final String value;

    Sex(Integer type, String value) {
        this.type = type;
        this.value = value;
    }
}

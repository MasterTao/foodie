package com.monkey.enums;

/**
 * 是否 枚举
 *
 * @author tao
 * @date 2020/10/8 7:41 下午
 */
public enum YesOrNo {

    NO(0, "否"),
    YES(1, "是");
    /**
     * 类型
     */
    public final Integer type;

    /**
     * 描述
     */
    public final String value;

    YesOrNo(Integer type, String value) {
        this.type = type;
        this.value = value;
    }
}

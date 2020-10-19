package com.monkey.enums;

/**
 * @author tao
 * @date 2020/10/18 9:05 下午
 */
public enum PayMethod {

    /**
     * 支付方式
     */
    WEIXIN(1, "微信"),
    ALIPAY(2, "支付宝");

    public final Integer type;
    public final String value;

    PayMethod(Integer type, String value) {
        this.type = type;
        this.value = value;
    }
}

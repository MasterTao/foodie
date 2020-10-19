package com.monkey.enums;

/**
 * @author tao
 * @date 2020/10/19 9:26 下午
 */
public enum OrderStatusEnum {
    /**
     * 支付状态
     */
    WAIT_PAY(10, "待付款"),
    WAIT_DELIVER(20, "已付款，代发货"),
    WAIT_RECEIVE(30, "已发货，待收货"),
    SUCCESS(40, "交易成功"),
    CLOSE(50, "交易关闭");

    public final Integer type;
    public final String value;

    OrderStatusEnum(Integer type, String value) {
        this.type = type;
        this.value = value;
    }
}

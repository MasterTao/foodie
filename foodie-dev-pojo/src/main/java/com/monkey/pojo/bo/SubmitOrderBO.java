package com.monkey.pojo.bo;

import lombok.Data;

/**
 * @author tao
 * @date 2020/10/18 8:59 下午
 */
@Data
public class SubmitOrderBO {
    private String userId;
    private String itemSpecIds;
    private String addressId;
    private Integer payMethod;
    private String leftMsg;
}

package com.monkey.pojo.bo;

import lombok.Data;

/**
 * 用于新增或修改地址的BO
 * @author tao
 * @date 2020/10/15 9:26 下午
 */
@Data
public class AddressBO {

    private String addressId;
    private String userId;
    private String receiver;
    private String mobile;
    private String province;
    private String city;
    private String district;
    private String detail;
}

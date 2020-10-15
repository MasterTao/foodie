package com.monkey.controller;

import com.monkey.pojo.UserAddress;
import com.monkey.service.AddressService;
import com.monkey.utils.JsonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author tao
 * @date 2020/10/7 3:21 下午
 */
@Api(value = "地址相关", tags = {"地址相关的api接口"})
@RestController
@RequestMapping("address")
public class AddressController {

    @Resource
    private AddressService addressService;

    @ApiOperation(value = "根据用户id查询收货地址列表", notes = "根据用户id查询收货地址列表", httpMethod = "POST")
    @PostMapping("/list")
    public JsonResult list(@RequestParam String userId) {
        if (StringUtils.isBlank(userId)) {
            return JsonResult.errorMsg("");
        }

        List<UserAddress> userAddresses = addressService.queryAll(userId);
        return JsonResult.ok(userAddresses);
    }
}

package com.monkey.controller;

import com.monkey.pojo.UserAddress;
import com.monkey.pojo.bo.AddressBO;
import com.monkey.service.AddressService;
import com.monkey.utils.JsonResult;
import com.monkey.utils.MobileEmailUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author tao
 * @date 2020/10/7 3:21 下午
 */
@Api(value = "地址相关", tags = {"地址相关的api接口"})
@RestController
@RequestMapping("address")
public class AddressController extends BaseController {

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

    @ApiOperation(value = "用户新增地址", notes = "用户新增地址", httpMethod = "POST")
    @PostMapping("/add")
    public JsonResult add(@RequestBody AddressBO addressBO) {

        JsonResult checkRes = checkAddress(addressBO);
        if (checkRes.getStatus() != 200) {
            return checkRes;
        }

        addressService.addNewUserAddress(addressBO);
        return JsonResult.ok();
    }

    private JsonResult checkAddress(AddressBO addressBO) {
        String receiver = addressBO.getReceiver();
        if (StringUtils.isBlank(receiver)) {
            return JsonResult.errorMsg("收货人不能为空");
        }
        if (receiver.length() > 12) {
            return JsonResult.errorMsg("收货人名字不能太长");
        }

        String mobile = addressBO.getMobile();
        if (StringUtils.isBlank(mobile)) {
            return JsonResult.errorMsg("收货人手机号不能为空");
        }
        if (mobile.length() != 11) {
            return JsonResult.errorMsg("收货人手机号长度不正确");
        }

        boolean isMobileOk = MobileEmailUtils.checkMobileIsOk(mobile);
        if (!isMobileOk) {
            return JsonResult.errorMsg("收货人手机号格式不正确");
        }

        String province = addressBO.getProvince();
        String city = addressBO.getCity();
        String district = addressBO.getDistrict();
        String detail = addressBO.getDetail();
        if (StringUtils.isBlank(province)
                || StringUtils.isBlank(city)
                || StringUtils.isBlank(district)
                || StringUtils.isBlank(detail)) {
            return JsonResult.errorMsg("收货地址信息不能为空");
        }

        return JsonResult.ok();
    }

    @ApiOperation(value = "用户修改地址", notes = "用户修改地址", httpMethod = "POST")
    @PostMapping("/update")
    public JsonResult update(@RequestBody AddressBO addressBO) {

        if (StringUtils.isBlank(addressBO.getAddressId())) {
            return JsonResult.errorMsg("修改地址错误：addressId不能为空");
        }

        JsonResult checkRes = checkAddress(addressBO);
        if (checkRes.getStatus() != 200) {
            return checkRes;
        }

        addressService.updateUserAddress(addressBO);
        return JsonResult.ok();
    }

    @ApiOperation(value = "用户删除地址", notes = "用户删除地址", httpMethod = "POST")
    @PostMapping("/delete")
    public JsonResult delete(@RequestParam String userId, @RequestParam String addressId) {
        if (StringUtils.isBlank(userId) || StringUtils.isBlank(addressId)) {
            return JsonResult.errorMsg("");
        }

        addressService.deleteUserAddress(userId, addressId);
        return JsonResult.ok();
    }

    @ApiOperation(value = "用户设置默认地址", notes = "用户设置默认地址", httpMethod = "POST")
    @PostMapping("/setDefault")
    public JsonResult setDefault(@RequestParam String userId, @RequestParam String addressId) {
        if (StringUtils.isBlank(userId) || StringUtils.isBlank(addressId)) {
            return JsonResult.errorMsg("");
        }

        addressService.updateUserAddressToBeDefault(userId, addressId);
        return JsonResult.ok();
    }
}

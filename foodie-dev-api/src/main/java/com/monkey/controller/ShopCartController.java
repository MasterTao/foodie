package com.monkey.controller;

import com.monkey.pojo.bo.ShopCartBO;
import com.monkey.utils.JsonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author tao
 * @date 2020/10/7 3:21 下午
 */
@Api(value = "购物车接口controller", tags = {"购物车接口相关的api"})
@RestController
@RequestMapping("shopcart")
public class ShopCartController extends BaseController {

    @ApiOperation(value = "添加商品到购物车", notes = "添加商品到购物车", httpMethod = "POST")
    @PostMapping("/add")
    public JsonResult add(@RequestParam String userId,
                          @RequestBody ShopCartBO shopCartBO,
                          HttpServletRequest request,
                          HttpServletResponse response) {
        if (StringUtils.isBlank(userId)) {
            return JsonResult.errorMsg("");
        }

        System.out.println(shopCartBO);
        // TODO 前端用户在登录的情况下，添加商品到购物车，会同步在后端同步redis缓存

        return JsonResult.ok();
    }

    @ApiOperation(value = "从购物车中删除商品", notes = "从购物车中删除商品", httpMethod = "POST")
    @PostMapping("/del")
    public JsonResult del(@RequestParam String userId,
                          @RequestParam String itemSpecId,
                          HttpServletRequest request,
                          HttpServletResponse response) {
        if (StringUtils.isBlank(userId) && StringUtils.isBlank(itemSpecId)) {
            return JsonResult.errorMsg("参数不能为空");
        }

        // TODO 用户在页面删除购物车中的商品数据，如果此时用户已经登录，则需要同步删除后端购物车中的商品数据

        return JsonResult.ok();
    }
}

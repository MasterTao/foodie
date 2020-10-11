package com.monkey.controller;

import com.monkey.pojo.Items;
import com.monkey.pojo.ItemsImg;
import com.monkey.pojo.ItemsParam;
import com.monkey.pojo.ItemsSpec;
import com.monkey.pojo.vo.ItemInfoVO;
import com.monkey.service.ItemService;
import com.monkey.utils.JsonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author tao
 * @date 2020/10/7 3:21 下午
 */
@Api(value = "商品接口", tags = {"商品信息展示的相关接口"})
@RequestMapping("items")
@RestController
public class ItemsController {

    @Resource
    private ItemService itemService;

    @ApiOperation(value = "查询商品详情", notes = "查询商品详情", httpMethod = "GET")
    @GetMapping("/info/{itemId}")
    public JsonResult info(
            @ApiParam(name = "itemId", value = "商品id", required = true)
            @PathVariable String itemId) {
        if (StringUtils.isBlank(itemId)) {
            return JsonResult.errorMsg(null);
        }

        Items items = itemService.queryItemById(itemId);
        List<ItemsImg> itemsImgList = itemService.queryItemImgList(itemId);
        ItemsParam itemsParam = itemService.queryItemParam(itemId);
        List<ItemsSpec> itemsSpecList = itemService.queryItemSpecList(itemId);

        ItemInfoVO itemInfoVO = new ItemInfoVO();
        itemInfoVO.setItems(items);
        itemInfoVO.setItemsImgList(itemsImgList);
        itemInfoVO.setItemsParam(itemsParam);
        itemInfoVO.setItemsSpecList(itemsSpecList);

        return JsonResult.ok(itemInfoVO);
    }
}

package com.monkey.controller;

import com.monkey.enums.YesOrNo;
import com.monkey.pojo.Carousel;
import com.monkey.service.CarouselService;
import com.monkey.utils.JsonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author tao
 * @date 2020/10/7 3:21 下午
 */
@Api(value = "首页", tags = {"首页展示的相关接口"})
@RequestMapping("index")
@RestController
public class IndexController {

    @Resource
    private CarouselService carouselService;

    @ApiOperation(value = "获取首页轮播图列表", notes = "获取首页轮播图列表", httpMethod = "GET")
    @GetMapping("/carousel")
    public JsonResult carousel() {
        List<Carousel> list = carouselService.queryAll(YesOrNo.YES.type);
        return JsonResult.ok(list);
    }
}

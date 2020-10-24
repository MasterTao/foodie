package com.monkey.controller.center;

import com.monkey.controller.BaseController;
import com.monkey.pojo.Users;
import com.monkey.service.center.CenterUserService;
import com.monkey.utils.JsonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author tao
 * @date 2020/10/23 4:51 下午
 */
@Api(value = "center - 用户中心", tags = {"用户中心展示的相关接口"})
@RestController
@RequestMapping("center")
public class CenterController extends BaseController {

    @Resource
    private CenterUserService centerUserService;

    @ApiOperation(value = "获取用户信息", notes = "获取用户信息", httpMethod = "GET")
    @GetMapping("userInfo")
    public JsonResult userInfo(
            @ApiParam(name = "userId", value = "用户id", required = true)
            @RequestParam String userId) {
        Users user = centerUserService.queryUserInfo(userId);
        return JsonResult.ok(user);
    }
}

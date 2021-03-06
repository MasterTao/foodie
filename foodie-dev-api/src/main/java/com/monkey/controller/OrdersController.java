package com.monkey.controller;

import com.monkey.enums.OrderStatusEnum;
import com.monkey.enums.PayMethod;
import com.monkey.pojo.OrderStatus;
import com.monkey.pojo.bo.SubmitOrderBO;
import com.monkey.pojo.vo.MerchantOrdersVO;
import com.monkey.pojo.vo.OrderVO;
import com.monkey.service.OrderService;
import com.monkey.utils.CookieUtils;
import com.monkey.utils.JsonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author tao
 * @date 2020/10/7 3:21 下午
 */
@Api(value = "订单相关", tags = {"订单相关的api接口"})
@RestController
@RequestMapping("orders")
public class OrdersController extends BaseController {

    @Resource
    private OrderService orderService;

    @Resource
    private RestTemplate restTemplate;

    @ApiOperation(value = "用户下单", notes = "用户下单", httpMethod = "POST")
    @PostMapping("/create")
    public JsonResult list(@RequestBody SubmitOrderBO submitOrderBO,
                           HttpServletRequest request,
                           HttpServletResponse response) {

        if (!submitOrderBO.getPayMethod().equals(PayMethod.WEIXIN.type)
                && !submitOrderBO.getPayMethod().equals(PayMethod.ALIPAY.type)) {
            return JsonResult.errorMsg("支付方式不支持");
        }

        // 1. 创建订单
        OrderVO orderVO = orderService.createOrder(submitOrderBO);
        String orderId = orderVO.getOrderId();

        // 2. 创建订单以后，移除购物车中已结算（已提交）的商品
        // TODO 整合redis之后，完善购物车中的已结算商品清除，并且同步到前端的cookie
        CookieUtils.setCookie(request, response, FOODIE_SHOP_CART, "");

        // 3. 向支付中心发送当前订单，用于保存支付中心的订单数据
        MerchantOrdersVO merchantOrdersVO = orderVO.getMerchantOrdersVO();
        merchantOrdersVO.setReturnUrl(PAY_RETURN_URL);

        // 为了方便测试，所以所有的支付金额统一改为一分钱
        merchantOrdersVO.setAmount(1);

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpHeaders.add("imoocUserId", "imooc");
        httpHeaders.add("password", "imooc");

        HttpEntity<MerchantOrdersVO> entity = new HttpEntity<>(merchantOrdersVO, httpHeaders);

        ResponseEntity<JsonResult> jsonResultResponseEntity = restTemplate.postForEntity(PAYMENT_URL, entity, JsonResult.class);
        JsonResult paymentResult = jsonResultResponseEntity.getBody();

        if (paymentResult.getStatus() != 200) {
            return JsonResult.errorMsg("支付中心订单创建失败，请联系管理员！");
        }

        return JsonResult.ok(orderId);
    }

    @PostMapping("notifyMerchantOrderPaid")
    public Integer notifyMerchantOrderPaid(String merchantOrderId) {
        orderService.updateOrderStatus(merchantOrderId, OrderStatusEnum.WAIT_DELIVER.type);
        return HttpStatus.OK.value();
    }

    @PostMapping("getPaidOrderInfo")
    public JsonResult getPaidOrderInfo(String merchantOrderId) {
        OrderStatus orderStatus = orderService.queryOrderStatusInfo(merchantOrderId);
        return JsonResult.ok(orderStatus);
    }
}

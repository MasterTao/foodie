package com.monkey.service.center;

import com.monkey.pojo.OrderItems;
import com.monkey.pojo.bo.center.OrderItemsCommentBO;

import java.util.List;

/**
 * @author tao
 * @date 2020/10/8 4:21 下午
 */
public interface MyCommentsService {

    /**
     * 根据订单id查询关联的商品
     * @param orderId
     * @return
     */
    List<OrderItems> queryPendingComment(String orderId);

    /**
     * 保存用户的评论
     * @param orderId
     * @param userId
     * @param commentList
     */
    void saveComments(String orderId, String userId, List<OrderItemsCommentBO> commentList);
}

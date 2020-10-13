package com.monkey.service;


import com.monkey.pojo.Items;
import com.monkey.pojo.ItemsImg;
import com.monkey.pojo.ItemsParam;
import com.monkey.pojo.ItemsSpec;
import com.monkey.pojo.vo.CommentLevelCountVO;
import com.monkey.utils.PagedGridResult;

import java.util.List;

/**
 * @author tao
 * @date 2020/10/11 11:21 上午
 */
public interface ItemService {

    /**
     * 根据商品id查询商品
     * @param itemId
     * @return
     */
    Items queryItemById(String itemId);

    /**
     * 根据商品id查询商品图片列表
     * @param itemId
     * @return
     */
    List<ItemsImg> queryItemImgList(String itemId);

    /**
     * 根据商品id查询商品规格
     * @param itemId
     * @return
     */
    List<ItemsSpec> queryItemSpecList(String itemId);

    /**
     * 根据商品id查询商品参数
     * @param itemId
     * @return
     */
    ItemsParam queryItemParam(String itemId);

    /**
     * 根据商品id查询商品评论数
     * @param itemId
     * @return
     */
    CommentLevelCountVO queryCommentCounts(String itemId);

    /**
     * 根据商品id查询商品的评价
     * @param itemId
     * @param level
     * @param page
     * @param pageSize
     * @return
     */
    PagedGridResult queryPagedComments(String itemId, Integer level, Integer page, Integer pageSize);
}

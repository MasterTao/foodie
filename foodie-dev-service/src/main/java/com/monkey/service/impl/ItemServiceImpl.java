package com.monkey.service.impl;

import com.monkey.enums.CommentLevel;
import com.monkey.mapper.*;
import com.monkey.pojo.*;
import com.monkey.pojo.vo.CommentLevelCountVO;
import com.monkey.service.ItemService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author tao
 * @date 2020/10/11 11:21 上午
 */
@Service
public class ItemServiceImpl implements ItemService {

    @Resource
    private ItemsMapper itemsMapper;

    @Resource
    private ItemsImgMapper itemsImgMapper;

    @Resource
    private ItemsSpecMapper itemsSpecMapper;

    @Resource
    private ItemsParamMapper itemsParamMapper;

    @Resource
    private ItemsCommentsMapper itemsCommentsMapper;

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public Items queryItemById(String itemId) {
        return itemsMapper.selectByPrimaryKey(itemId);
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public List<ItemsImg> queryItemImgList(String itemId) {
        Example example = new Example(ItemsImg.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("itemId", itemId);

        return itemsImgMapper.selectByExample(example);
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public List<ItemsSpec> queryItemSpecList(String itemId) {
        Example example = new Example(ItemsSpec.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("itemId", itemId);
        return itemsSpecMapper.selectByExample(example);
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public ItemsParam queryItemParam(String itemId) {
        Example example = new Example(ItemsParam.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("itemId", itemId);
        return itemsParamMapper.selectOneByExample(example);
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public CommentLevelCountVO queryCommentCounts(String itemId) {

        Integer goodsCounts = getCommentsCounts(itemId, CommentLevel.GOOD.type);
        Integer normalCounts = getCommentsCounts(itemId, CommentLevel.NORAML.type);
        Integer badCounts = getCommentsCounts(itemId, CommentLevel.BAD.type);
        Integer totalCounts = goodsCounts + normalCounts + badCounts;

        CommentLevelCountVO commentLevelCountVO = new CommentLevelCountVO();
        commentLevelCountVO.setGoodsCounts(goodsCounts);
        commentLevelCountVO.setBadCounts(badCounts);
        commentLevelCountVO.setNormalCounts(normalCounts);
        commentLevelCountVO.setTotalCounts(totalCounts);

        return commentLevelCountVO;
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    Integer getCommentsCounts(String itemId, Integer level) {
        ItemsComments condition = new ItemsComments();
        condition.setItemId(itemId);
        if (level != null) {
            condition.setCommentLevel(level);
        }
        return itemsCommentsMapper.selectCount(condition);
    }
}

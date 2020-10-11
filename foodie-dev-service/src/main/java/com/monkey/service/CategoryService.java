package com.monkey.service;

import com.monkey.pojo.Category;
import com.monkey.pojo.vo.CategoryVO;
import com.monkey.pojo.vo.NewItemsVO;

import java.util.List;

/**
 * @author tao
 * @date 2020/10/9 9:39 下午
 */
public interface CategoryService {
    /**
     * 查询所有一级分类
     * @return
     */
    List<Category> queryAllRootLevelCat();

    /**
     * 根据一级分类id查询子分类id
     * @param rootCatId
     * @return
     */
    List<CategoryVO> getSubCatList(Integer rootCatId);

    /**
     * 查询首页每个一级分类下的6条最新商品数据
     * @param rootCatId
     * @return
     */
    List<NewItemsVO> getSixNewItemsLazy(Integer rootCatId);
}

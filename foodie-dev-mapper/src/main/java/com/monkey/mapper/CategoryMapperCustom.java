package com.monkey.mapper;

import com.monkey.pojo.vo.CategoryVO;
import com.monkey.pojo.vo.NewItemsVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface CategoryMapperCustom {

    List<CategoryVO> getSubCatList(Integer rootCatId);

    List<NewItemsVO> getSixNewItemsLazy(@Param("paramsMap") Map<String, Object> map);
}
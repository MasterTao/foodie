package com.monkey.mapper;


import com.monkey.pojo.vo.ItemCommentVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface ItemsMapperCustom {

    List<ItemCommentVO> queryItemContents(@Param("paramsMap") Map<String, Object> map);
}
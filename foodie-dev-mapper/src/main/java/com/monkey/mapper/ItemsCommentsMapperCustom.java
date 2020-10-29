package com.monkey.mapper;

import com.monkey.my.mapper.MyMapper;
import com.monkey.pojo.ItemsComments;

import java.util.Map;

public interface ItemsCommentsMapperCustom extends MyMapper<ItemsComments> {

    void saveComments(Map<String, Object> map);
}
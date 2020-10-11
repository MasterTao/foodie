package com.monkey.pojo.vo;

import com.monkey.pojo.Items;
import com.monkey.pojo.ItemsImg;
import com.monkey.pojo.ItemsParam;
import com.monkey.pojo.ItemsSpec;
import lombok.Data;

import java.util.List;

/**
 * 商品详情VO
 *
 * @author tao
 * @date 2020/10/11 9:01 上午
 */
@Data
public class ItemInfoVO {

    private Items items;
    private List<ItemsImg> itemsImgList;
    ItemsParam itemsParam;
    List<ItemsSpec> itemsSpecList;
}

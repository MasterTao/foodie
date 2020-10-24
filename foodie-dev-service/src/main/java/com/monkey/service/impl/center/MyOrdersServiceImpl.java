package com.monkey.service.impl.center;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.monkey.mapper.OrdersMapperCustom;
import com.monkey.pojo.vo.MyOrdersVO;
import com.monkey.service.center.MyOrdersService;
import com.monkey.utils.PagedGridResult;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author tao
 * @date 2020/10/23 4:54 下午
 */
@Service
public class MyOrdersServiceImpl implements MyOrdersService {

    @Resource
    private OrdersMapperCustom ordersMapperCustom;

    @Transactional(propagation = Propagation.SUPPORTS, rollbackFor = Exception.class)
    @Override
    public PagedGridResult queryMyOrders(String userId, Integer orderStatus, Integer page, Integer pageSize) {

        Map<String, Object> map = new HashMap<>();
        map.put("userId", userId);
        if (orderStatus != null) {
            map.put("orderStatus", orderStatus);
        }

        PageHelper.startPage(page, pageSize);
        List<MyOrdersVO> list = ordersMapperCustom.queryMyOrders(map);

        return setterPagedGrid(list, page);
    }

    private PagedGridResult setterPagedGrid(List<?> list, Integer page) {
        PageInfo<?> pageList = new PageInfo<>(list);
        PagedGridResult pagedGridResult = new PagedGridResult();
        pagedGridResult.setPage(page);
        pagedGridResult.setRows(list);
        pagedGridResult.setTotal(pageList.getPages());
        pagedGridResult.setRecords(pageList.getTotal());
        return pagedGridResult;
    }
}

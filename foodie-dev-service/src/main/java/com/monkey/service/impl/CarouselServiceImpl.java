package com.monkey.service.impl;

import com.monkey.mapper.CarouselMapper;
import com.monkey.pojo.Carousel;
import com.monkey.service.CarouselService;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author tao
 * @date 2020/10/9 9:40 下午
 */
@Service
public class CarouselServiceImpl implements CarouselService {

    @Resource
    private CarouselMapper carouselMapper;

    @Override
    public List<Carousel> queryAll(Integer isShow) {
        Example example = new Example(Carousel.class);
        example.orderBy("sort").desc();
        Example.Criteria criteria = example.createCriteria();

        criteria.andEqualTo("isShow", isShow);
        return carouselMapper.selectByExample(example);
    }
}

package com.company.oa.service;

import com.company.oa.mapper.ShufflingMapper;
import com.company.oa.model.Shuffling;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ShufflingService {

    @Autowired
    private ShufflingMapper shufflingMapper;
 
  
    public List<Shuffling> selectAll(){
        // 单表分页
        //PageHelper.startPage(0,10);

        //单表自定义查询
        //Example company = new Example(Demo.class);

        return shufflingMapper.selectAll();
    }
}

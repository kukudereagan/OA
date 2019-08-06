package com.company.oa.service;

import com.company.oa.mapper.TrafficLawMapper;
import com.company.oa.model.TrafficLaw;
import com.github.pagehelper.PageHelper;

import tk.mybatis.mapper.entity.Example;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TrafficLawService {

    @Autowired
    private TrafficLawMapper trafficLawMapper;
 
    public TrafficLaw selectOne(Integer id){
    	TrafficLaw model = new TrafficLaw();
    	model.setId(id);
        return trafficLawMapper.selectOne(model);
    }
    
    public List<TrafficLaw> selectAll(Integer pageIndex,Integer pageSize){
        // 单表分页
        PageHelper.startPage(pageIndex,pageSize,false);

        //单表自定义查询
        //Example company = new Example(Demo.class);

        return trafficLawMapper.selectAll();
    }

    public List<TrafficLaw> selectAll(String filter,Integer pageIndex,Integer pageSize){
        // 单表分页
        PageHelper.startPage(pageIndex,pageSize);
        Example example = new Example(TrafficLaw.class);
        if(StringUtils.isNotEmpty(filter)) {
            filter = "%" + filter + "%";
            example.createCriteria().andLike("title", filter).orLike("content", filter);
        }

        return trafficLawMapper.selectByExample(example);
    }

    public TrafficLaw createOrUpdate(TrafficLaw trafficLaw) {
        // 新增
        if(trafficLaw.getId() == null){
        	trafficLawMapper.insert(trafficLaw);
        }else{
        	trafficLawMapper.updateByPrimaryKeySelective(trafficLaw);
        }
        return trafficLaw;
    }

    public int delete(Integer id) {
    	TrafficLaw model = new TrafficLaw();
        model.setId(id);
        return trafficLawMapper.deleteByPrimaryKey(model);
    }

}

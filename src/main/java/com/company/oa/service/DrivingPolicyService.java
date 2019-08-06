package com.company.oa.service;

import com.company.oa.mapper.DrivingPolicyMapper;
import com.company.oa.model.DrivingPolicy;
import com.github.pagehelper.PageHelper;

import tk.mybatis.mapper.entity.Example;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class DrivingPolicyService {

    @Autowired
    private DrivingPolicyMapper drivingPolicyMapper;
 
    public DrivingPolicy selectOne(Integer id){
    	DrivingPolicy model=new DrivingPolicy();
    	model.setId(id);
        return drivingPolicyMapper.selectOne(model);
    }
    
    public List<DrivingPolicy> selectAll(Integer pageIndex,Integer pageSize){
        // 单表分页
        PageHelper.startPage(pageIndex,pageSize,false);

        //单表自定义查询
        //Example company = new Example(Demo.class);

        return drivingPolicyMapper.selectAll();
    }
    
    public List<DrivingPolicy> selectAll(String filter,Integer pageIndex,Integer pageSize){
        // 单表分页
        PageHelper.startPage(pageIndex,pageSize);
        Example example = new Example(DrivingPolicy.class);
        if(StringUtils.isNotEmpty(filter)) {
            filter = "%" + filter + "%";
            example.createCriteria().andLike("title", filter).orLike("content", filter);
        }

        return drivingPolicyMapper.selectByExample(example);
    }

    public DrivingPolicy createOrUpdate(DrivingPolicy model) {
        // 新增
        if(model.getId() == null){
        	drivingPolicyMapper.insert(model);
        }else{
        	drivingPolicyMapper.updateByPrimaryKeySelective(model);
        }
        return model;
    }

    public int delete(Integer id) {
    	DrivingPolicy model = new DrivingPolicy();
        model.setId(id);
        return drivingPolicyMapper.deleteByPrimaryKey(model);
    }
}

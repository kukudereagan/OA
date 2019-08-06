package com.company.oa.service;

import com.company.oa.mapper.TeacherApiMapper;
import com.company.oa.modelApi.TeacherApi;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class TeacherApiService {

    @Autowired
    private TeacherApiMapper teacherApiMapper;
 
    /*显示在首页的教练列表*/
    public List<TeacherApi> selectHomePageAll(){
        return teacherApiMapper.getHomePageTeacherApis();
    }
    
    public List<TeacherApi> selectAll(Integer pageIndex,Integer pageSize){
        // 单表分页
        PageHelper.startPage(pageIndex,pageSize,false);

        //单表自定义查询
        //Example company = new Example(Demo.class);

        return teacherApiMapper.getTeacherApis(pageIndex, pageSize);
    }
    
    public TeacherApi selectOne(Integer id){
        return teacherApiMapper.getTeacherApi(id);
    }
    

    
}

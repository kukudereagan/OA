package com.company.oa.service;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.oa.mapper.CourseOnlineMapper;
import com.company.oa.mapper.TeacherMapper;
import com.company.oa.model.Common;
import com.company.oa.model.CourseOnline;
import com.github.pagehelper.PageHelper;

import tk.mybatis.mapper.entity.Example;

@Service
public class TeacherService {

	@Autowired
	private TeacherMapper teacherMapper;
	@Autowired
	private CourseOnlineMapper courseOnlineMapper;
	public List<Common> getTeachers(Integer pageIndex, Integer pageSize) {
		// 单表分页
		PageHelper.startPage(pageIndex, pageSize,false);

		// 单表自定义查询
		// Example company = new Example(Demo.class);
		Common model=new Common();
		model.setType("3");
		return teacherMapper.selectByExample(model);
	}
	
	public List<Common> getTeachers(String filter,Integer pageIndex,Integer pageSize){
        // 单表分页
        PageHelper.startPage(pageIndex,pageSize);
        Example example = new Example(Common.class);
        if(StringUtils.isNotEmpty(filter)) {
            filter = "%" + filter + "%";
            example.createCriteria().andLike("name", filter);
        }

        return teacherMapper.selectByExample(example);
    }

	public Common getTeacher(Integer id) {
		Common model = new Common();
		model.setId(id);
		return teacherMapper.selectOne(model);
	}

	public Common createOrUpdate(Common model) {
        // 新增
        if(model.getId() == null){
        	teacherMapper.insert(model);
        }else{
        	teacherMapper.updateByPrimaryKeySelective(model);
        }
        return model;	   
	}
	
	public int delete(Integer id) {
		Common model = new Common();
		model.setId(id);
        return teacherMapper.deleteByPrimaryKey(model);
    }
	
    public List<CourseOnline> selectCourseOnlines(Integer tid){
    	CourseOnline model=new CourseOnline();
    	model.setUserId(tid);
    	model.setType(null);
    	model.setCreateTime(null);
    	
        return courseOnlineMapper.select(model);
    }
}

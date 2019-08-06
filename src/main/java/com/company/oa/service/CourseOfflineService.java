package com.company.oa.service;

import com.company.oa.mapper.CourseOfflineMapper;
import com.company.oa.mapper.TeacherApiMapper;
import com.company.oa.model.CourseOffline;
import com.company.oa.modelApi.TeacherApi;
import com.github.pagehelper.PageHelper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.List;


@Service
public class CourseOfflineService {

	 @Autowired
	    private CourseOfflineMapper courseOfflineMapper;
	 @Autowired
	    private TeacherApiMapper teacherApiMapper;
	 
    public List<CourseOffline> selectHomePageAll(){
        //单表自定义查询
        //Example company = new Example(CourseOffline.class);
        CourseOffline model=new CourseOffline();
        model.setShowHomepage(1);
        return courseOfflineMapper.select(model);
    }
    
    public List<CourseOffline> selectAll(Integer pageIndex,Integer pageSize){
        // 单表分页
        PageHelper.startPage(pageIndex,pageSize,false);

        //单表自定义查询
        //Example company = new Example(Demo.class);

        return courseOfflineMapper.selectAll();
    }

    public List<CourseOffline> selectAll(String filter,Integer pageIndex,Integer pageSize){
        // 单表分页
        PageHelper.startPage(pageIndex,pageSize);
        Example example = new Example(CourseOffline.class);
        if(StringUtils.isNotEmpty(filter)) {
            filter = "%" + filter + "%";
            example.createCriteria().andLike("title", filter).orLike("content", filter);
        }

        return courseOfflineMapper.selectByExample(example);
    }

    
    
    public CourseOffline selectOne(Integer id){
    	CourseOffline model=new CourseOffline();
    	model.setId(id);
    	CourseOffline m=courseOfflineMapper.selectOne(model);
    	
    	List<TeacherApi> lst=new ArrayList<>();
    	
    	for (int i = 0; i < m.getTeachers().split(",").length; i++) {
    		lst.add(teacherApiMapper.getTeacherApi(Integer.parseInt(m.getTeachers().split(",")[i])));
		}
     
    	m.setTeacherList(lst);
        return m;
    }

    public CourseOffline createOrUpdate(CourseOffline courseOffline) {

        // 新增
        if(courseOffline.getId() == null){
            courseOfflineMapper.insert(courseOffline);
        }else{
            courseOfflineMapper.updateByPrimaryKeySelective(courseOffline);
        }
        return courseOffline;
    }

    public int delete(Integer id) {
        CourseOffline courseOffline = new CourseOffline();
        courseOffline.setId(id);
        return courseOfflineMapper.deleteByPrimaryKey(courseOffline);
    }
}

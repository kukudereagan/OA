package com.company.oa.service;

import com.company.oa.mapper.CourseOnlineMapper;
import com.company.oa.model.CourseOnline;
import com.company.oa.modelApi.CourseOnlineApi;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CourseOnlineService {

	@Autowired
	private CourseOnlineMapper courseOnlineMapper;

    public List<CourseOnline> selectHomePageAll(){
        //单表自定义查询
        //Example company = new Example(CourseOffline.class);
        CourseOnline model=new CourseOnline();
        model.setShowHomepage(1);
        model.setType(null);
        model.setCreateTime(null);
        return courseOnlineMapper.select(model);
    }
	
	public List<CourseOnline> selectAll(Integer type, Integer isRecommended, Integer pageIndex, Integer pageSize) {
		// 单表分页
		PageHelper.startPage(pageIndex, pageSize,false);

		// 单表自定义查询
		// Example company = new Example(Demo.class);
		CourseOnline model = new CourseOnline();
		model.setCreateTime(null);
		model.setType(null);
		if (type != 0) {
			model.setType(type);
		}
		
		if (isRecommended == 1) {
			model.setIsRecommended(true);
		}

		return courseOnlineMapper.select(model);
	}
	
	public CourseOnlineApi selectList() {
		CourseOnlineApi model=new CourseOnlineApi();
		model.setList1(selectAll(1,1,1,4));
		model.setList2(selectAll(2,1,1,4));
		model.setList3(selectAll(3,1,1,4));
		model.setList4(selectAll(4,1,1,4));
		
		return model;
	}

	public CourseOnline selectOne(Integer id) {
		CourseOnline model = new CourseOnline();
		model.setId(id);
		model.setType(null);
		model.setCreateTime(null);
		return courseOnlineMapper.selectOne(model);
	}

	public CourseOnline createOrUpdate(CourseOnline courseOnline) {

        // 新增
        if(courseOnline.getId() == null){
            courseOnlineMapper.insert(courseOnline);
        }else{
           courseOnlineMapper.updateByPrimaryKeySelective(courseOnline);
        }
        return courseOnline;
    }

    public int delete(Integer id) {
        CourseOnline CourseOnline = new CourseOnline();
        CourseOnline.setId(id);
        return courseOnlineMapper.deleteByPrimaryKey(id);
    }
}

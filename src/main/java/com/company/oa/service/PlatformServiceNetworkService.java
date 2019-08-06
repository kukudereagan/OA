package com.company.oa.service;

import com.company.oa.mapper.CourseOfflineMapper;
import com.company.oa.mapper.PlatformServiceNetworkImageMapper;
import com.company.oa.mapper.PlatformServiceNetworkMapper;
import com.company.oa.model.CourseOffline;
import com.company.oa.model.PlatformServiceNetwork;
import com.company.oa.model.PlatformServiceNetworkImage;
import com.github.pagehelper.PageHelper;

import tk.mybatis.mapper.entity.Example;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PlatformServiceNetworkService {

	@Autowired
	private PlatformServiceNetworkMapper platformServiceNetworkMapper;
	@Autowired
	private PlatformServiceNetworkImageMapper platformServiceNetworkImageMapper;
	@Autowired
	private CourseOfflineMapper courseOfflineMapper;

	public List<PlatformServiceNetwork> selectAll(Integer pageIndex, Integer pageSize) {
		// 单表分页
		PageHelper.startPage(pageIndex, pageSize,false);

		// 单表自定义查询
		// Example company = new Example(Demo.class);

		return platformServiceNetworkMapper.selectAll();
	}

	public PlatformServiceNetwork selectOne(Integer id) {
		PlatformServiceNetwork model = new PlatformServiceNetwork();
		model.setId(id);
		PlatformServiceNetwork m=platformServiceNetworkMapper.selectOne(model);
		List<PlatformServiceNetworkImage> lst=selectImages(id);
		m.setImages(lst);
		return m;
	}
	
	/*获取平台图片列表*/
	public List<PlatformServiceNetworkImage> selectImages(Integer fromId) {
		 
		// 单表自定义查询
		// Example company = new Example(Demo.class);
		PlatformServiceNetworkImage model=new PlatformServiceNetworkImage();
		model.setFromId(fromId);
		return platformServiceNetworkImageMapper.select(model);
	}
	
	
	/*获取平台线下课程*/
	public List<CourseOffline> selectCourseOfflines(Integer platformServiceNetworkId,Integer pageIndex, Integer pageSize) {
		// 单表分页
		PageHelper.startPage(pageIndex, pageSize);

		// 单表自定义查询
		// Example company = new Example(Demo.class);
		CourseOffline model=new CourseOffline();
		model.setPlatformServiceNetworkId(platformServiceNetworkId);
		return courseOfflineMapper.select(model);
	}
	
	 public List<PlatformServiceNetwork> selectAll(String filter,Integer pageIndex,Integer pageSize){
	        // 单表分页
	        PageHelper.startPage(pageIndex,pageSize);
	        Example example = new Example(PlatformServiceNetwork.class);
	        if(StringUtils.isNotEmpty(filter)) {
	            filter = "%" + filter + "%";
	            example.createCriteria().andLike("title", filter).orLike("content", filter);
	        }

	        return platformServiceNetworkMapper.selectByExample(example);
	    }

	    public PlatformServiceNetwork createOrUpdate(PlatformServiceNetwork model) {
	        // 新增
	        if(model.getId() == null){
	        	platformServiceNetworkMapper.insert(model);
	        }else{
	        	platformServiceNetworkMapper.updateByPrimaryKeySelective(model);
	        }
	        return model;
	    }

	    public int delete(Integer id) {
	    	PlatformServiceNetwork model = new PlatformServiceNetwork();
	        model.setId(id);
	        return platformServiceNetworkMapper.deleteByPrimaryKey(model);
	    }

}

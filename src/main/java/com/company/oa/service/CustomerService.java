package com.company.oa.service;

import com.company.oa.mapper.CourseOfflineMapper;
import com.company.oa.mapper.CourseOnlineMapper;
import com.company.oa.mapper.CustomerMapper;
import com.company.oa.model.CourseOffline;
import com.company.oa.model.CourseOnline;
import com.company.oa.model.Customer;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/*@SuppressWarnings("unused")*/
@Service
public class CustomerService {

	@Autowired
	private CustomerMapper customerMapper;
	@Autowired
	private CourseOnlineMapper courseOnlineMapper;
	@Autowired
	private CourseOfflineMapper courseOfflineMapper;

	/**
	 * 添加： 在Demo po中的id列加入@GeneratedValue(strategy = GenerationType.IDENTITY)
	 * 可自动生成Id,
	 * 
	 * @param demo
	 * @return
	 */
	public Customer insert(Customer model) {
		// 通用mapper中的两个新增方式
		customerMapper.insert(model); // 插入所有数据，保存字段值为null的。
		// demoMapper.insertSelective(oa); //只插入字段值不为null的数据。

		int id = model.getId(); // 调用插入方法后，通过这样的方式获取插入的数据的新ID
		System.out.println(id);
		return model;
	}
	
	public Customer update(Customer model) {
		customerMapper.updateByPrimaryKeySelective(model); 
		return model;
	}

	public Customer selectOneByMobile(String mobile) {
		Customer demo = new Customer();
		demo.setMobile(mobile);
		return customerMapper.selectOne(demo);
	}

	/*获取我的已经购买的线上课程*/
	public List<CourseOnline> getMyCourseOnlines(Integer customerid,Integer pageIndex,Integer pageSize) {
		 PageHelper.startPage(pageIndex,pageSize,false);

		List<CourseOnline> lst= courseOnlineMapper.getCustomerCourseOnline(customerid);
		return lst;
	}
	
	/*获取我的已经报名的线下课程*/
	public List<CourseOffline> getMyCourseOfflines(Integer customerid,Integer pageIndex,Integer pageSize) {
		 PageHelper.startPage(pageIndex,pageSize,false);

		List<CourseOffline> lst= courseOfflineMapper.getCustomerCourseOffline(customerid);
		return lst;
	}
}

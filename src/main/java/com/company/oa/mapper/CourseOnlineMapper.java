package com.company.oa.mapper;

import com.company.oa.model.CourseOnline;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

@org.apache.ibatis.annotations.Mapper
@Repository
public interface CourseOnlineMapper extends Mapper<CourseOnline> {
	public List<CourseOnline> getCustomerCourseOnline(@Param("customerid") Integer customerid);
}

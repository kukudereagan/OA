package com.company.oa.mapper;

import com.company.oa.model.CourseOffline;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

@org.apache.ibatis.annotations.Mapper
@Repository
public interface CourseOfflineMapper extends Mapper<CourseOffline> {
	public List<CourseOffline> getCustomerCourseOffline(@Param("customerid") Integer customerid);
}

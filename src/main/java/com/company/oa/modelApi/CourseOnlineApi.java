package com.company.oa.modelApi;

import org.apache.ibatis.type.Alias;

import com.company.oa.model.CourseOnline;

import lombok.Data;

import java.util.List;
 
//线上课程列表
@Alias("courseOnlineApiModel")
@Data
public class CourseOnlineApi {
	  private List<CourseOnline> list1;
	  private List<CourseOnline> list2;
	  private List<CourseOnline> list3;
	  private List<CourseOnline> list4;
}

package com.company.oa.mapper;

import com.company.oa.modelApi.TeacherApi;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

@org.apache.ibatis.annotations.Mapper
@Repository
public interface TeacherApiMapper extends Mapper<TeacherApi> {
	 public List<TeacherApi> getTeacherApis(@Param("pageIndex") Integer pageIndex,@Param("pageSize") Integer pageSize);
	 public List<TeacherApi> getHomePageTeacherApis();
	 public TeacherApi getTeacherApi(@Param("id") Integer id);
}

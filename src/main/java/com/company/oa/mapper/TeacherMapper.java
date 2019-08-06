package com.company.oa.mapper;

import com.company.oa.model.Common;

import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

@org.apache.ibatis.annotations.Mapper
@Repository
public interface TeacherMapper extends Mapper<Common> {
}

package com.company.oa.mapper;

import com.company.oa.model.Student;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

@org.apache.ibatis.annotations.Mapper
@Repository
public interface StudentMapper extends Mapper<Student> {
}

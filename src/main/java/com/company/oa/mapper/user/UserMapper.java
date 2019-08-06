package com.company.oa.mapper.user;

import com.company.oa.model.system.SysRole;
import com.company.oa.model.system.SysUser;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@org.apache.ibatis.annotations.Mapper
@Repository
public interface UserMapper extends Mapper<SysUser> {
}

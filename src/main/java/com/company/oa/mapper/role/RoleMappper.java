package com.company.oa.mapper.role;

import com.company.oa.model.system.SysRole;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

@org.apache.ibatis.annotations.Mapper
@Repository
public interface RoleMappper extends Mapper<SysRole> {
}

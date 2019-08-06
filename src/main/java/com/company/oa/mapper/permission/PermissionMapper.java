package com.company.oa.mapper.permission;

import com.company.oa.model.system.SysPermission;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;
@org.apache.ibatis.annotations.Mapper
@Repository
public interface PermissionMapper extends Mapper<SysPermission> {
}

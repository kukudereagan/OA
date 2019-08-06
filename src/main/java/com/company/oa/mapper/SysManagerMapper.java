package com.company.oa.mapper;

import com.company.oa.model.system.SysPermission;
import com.company.oa.model.system.SysRole;
import com.company.oa.model.system.SysUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Liaopan on 2018/1/10.
 */
@Repository
@Mapper
public interface SysManagerMapper {

    SysUser selectUserByName(@Param("userName") String userName);

    List<SysPermission> selectPermissionsByUserId(@Param("userId")Integer userId);

    List<SysRole> selectRolesByUserId(@Param("userId")Integer userId);

    List<SysRole> selectCheckRole(@Param("userId") Integer userId);

    int insertUserRole(@Param("list") List list);

    int deleteUserRoleByUserId(@Param("userId") Integer userId);

}

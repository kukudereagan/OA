package com.company.oa.service.permission;

import com.company.oa.mapper.SysManagerMapper;
import com.company.oa.mapper.permission.PermissionMapper;
import com.company.oa.model.system.SysPermission;
import com.github.pagehelper.PageHelper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class PermissionService {
    @Autowired
    private PermissionMapper permissionMapper;

    @Autowired
    private SysManagerMapper sysManagerMapper;

    public List<SysPermission> selectAll(){
        return permissionMapper.selectAll();
    }

    public List<SysPermission> getPageData(String filter, Integer pageIndex, Integer pageSize){
        // 单表分页
        PageHelper.startPage(pageIndex,pageSize);
        Example example = new Example(SysPermission.class);
        if(StringUtils.isNotEmpty(filter)) {
            filter = "%" + filter + "%";
            example.createCriteria().andLike("name", filter).orLike("url",filter);
        }
        return permissionMapper.selectByExample(example);
    }
    public SysPermission getDetail(Integer id) {
        SysPermission model = new SysPermission();
        model.setId(id);
        return permissionMapper.selectOne(model);
    }


    public SysPermission createOrUpdate(SysPermission model) {
        // 新增
        if(model.getId() == null){
            permissionMapper.insert(model);
        }else{
            permissionMapper.updateByPrimaryKeySelective(model);
        }
        return model;
    }

    public int delete(Integer id) {
        SysPermission model = new SysPermission();
        model.setId(id);
        return permissionMapper.deleteByPrimaryKey(model);
    }

}

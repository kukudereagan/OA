package com.company.oa.service.role;

import com.company.oa.mapper.role.RoleMappper;
import com.company.oa.model.system.SysRole;
import com.company.oa.model.system.SysUser;
import com.github.pagehelper.PageHelper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class RoleService {
    @Autowired
    private RoleMappper roleMappper;

    public List<SysRole> selectAll(){
        return roleMappper.selectAll();
    }

    public List<SysRole> getPageData(String filter, Integer pageIndex, Integer pageSize){
        // 单表分页
        PageHelper.startPage(pageIndex,pageSize);
        Example example = new Example(SysRole.class);
        if(StringUtils.isNotEmpty(filter)) {
            filter = "%" + filter + "%";
            example.createCriteria().andLike("description", filter).orLike("role",filter);
        }

        return roleMappper.selectByExample(example);
    }
    public SysRole getDetail(Integer id) {
        SysRole model = new SysRole();
        model.setId(id);
        return roleMappper.selectOne(model);
    }

    public SysRole createOrUpdate(SysRole model) {
        // 新增
        if(model.getId() == null){
            roleMappper.insert(model);
        }else{
            roleMappper.updateByPrimaryKeySelective(model);
        }
        return model;
    }

    public int delete(Integer id) {
        SysRole model = new SysRole();
        model.setId(id);
        return roleMappper.deleteByPrimaryKey(model);
    }


}

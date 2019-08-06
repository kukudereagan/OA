package com.company.oa.service.user;

import com.company.oa.mapper.SysManagerMapper;
import com.company.oa.mapper.user.UserMapper;
import com.company.oa.model.Student;
import com.company.oa.model.system.SysRole;
import com.company.oa.model.system.SysUser;
import com.company.oa.service.SysManager;
import com.github.pagehelper.PageHelper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private SysManagerMapper sysManagerMapper;

    public List<SysUser> selectAll(){
        return userMapper.selectAll();
    }

    public List<SysUser> getUsers(String filter, Integer pageIndex, Integer pageSize){
        // 单表分页
        PageHelper.startPage(pageIndex,pageSize);
        Example example = new Example(SysUser.class);
        example.createCriteria().andEqualTo("state",'1');
        if(StringUtils.isNotEmpty(filter)) {
            filter = "%" + filter + "%";
            example.createCriteria().andLike("userName", filter).orLike("nickName",filter);
        }
        return userMapper.selectByExample(example);
    }
    public SysUser getDetail(Integer id) {
        SysUser model = new SysUser();
        model.setId(id);
        return userMapper.selectOne(model);
    }

    public List<SysRole> getRoles(Integer id){
        return sysManagerMapper.selectRolesByUserId(id);
    }

    public List<SysRole> getCheckRole(Integer id){
        return sysManagerMapper.selectCheckRole(id);
    }

    public SysUser createOrUpdate(SysUser model) {
        // 新增
        if(model.getId() == null){
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            model.setCreatetime(sdf.format(new Date()));
            userMapper.insert(model);
        }else{
            userMapper.updateByPrimaryKeySelective(model);
        }
        return model;
    }

    public int delete(Integer id) {
        SysUser model = new SysUser();
        model.setId(id);
        return userMapper.deleteByPrimaryKey(model);
    }

    public int addUserRole(List list){
        return sysManagerMapper.insertUserRole(list);
    }

    public int deleteUserRoleByUserId(Integer id){
        return sysManagerMapper.deleteUserRoleByUserId(id);
    }
}

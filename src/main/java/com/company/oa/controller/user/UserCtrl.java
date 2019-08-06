package com.company.oa.controller.user;

import com.company.oa.controller.response.ResponsePageData;
import com.company.oa.model.CourseOffline;
import com.company.oa.model.Student;
import com.company.oa.model.system.SysRole;
import com.company.oa.model.system.SysUser;
import com.company.oa.service.role.RoleService;
import com.company.oa.service.user.UserService;
import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("/system/user/")
@Controller
public class UserCtrl {

    @Autowired
    private UserService userService;
    private SysUser sysUser=new SysUser();
    @GetMapping("index")
    public String index(ModelMap modelMap){
        return "system/user/index";
    }

    /**
     * 编辑，新增，查看 方法，。
     * @param modelMap
     * @param id
     * @param editFlag edit = 1, new = 0 , show = 2
     * @return
     */
    @GetMapping("edit")
    public String edit(ModelMap modelMap,
                       @RequestParam(value = "id",required = false) Integer id,
                       @RequestParam(value = "flag",defaultValue = "1") Integer editFlag){
        SysUser sysUser = new SysUser();
        List<SysRole> sysRoleList=new ArrayList<SysRole>();
        sysRoleList=userService.getCheckRole(id);
        if(editFlag > 0) {
            sysUser = userService.getDetail(id);
            sysUser.setRoles(userService.getRoles(id));
        }
        modelMap.put("sysRoleList",sysRoleList);
        modelMap.put("sysUser",sysUser);
        modelMap.put("edit",editFlag != 2);
        return "system/user/edit";
    }

    /**
     * 数据处理
     */
    @GetMapping("data")
    @ResponseBody
    public ResponsePageData data(@RequestParam(value = "page",defaultValue = "0") Integer offset,
                                 @RequestParam(value = "limit",defaultValue = "10") Integer limit,
                                 @RequestParam(value = "filter",required = false) String filter){
        System.out.println(filter);
        Page<SysUser> page = (Page<SysUser>)userService.getUsers(filter,offset, limit);
        return new ResponsePageData<SysUser>(page.getTotal(),page);
    }

    @PostMapping("edit")
    @ResponseBody
    public int edit(@RequestBody SysUser model){
        sysUser = userService.createOrUpdate(model);
        return sysUser != null? 1:0;
    }

    @PostMapping("editRole")
    @ResponseBody
    public int editRole(@RequestBody Map map){
        //System.out.println(list.size());
        int is=-1;
        if(!map.isEmpty()){
            List  list=(List)map.get("list");
            String id=(String)map.get("userId") ;
            Integer userId=-1;
            if(id!=null && id!=""){
                userId=Integer.parseInt(id);
            }else{
                userId=sysUser.getId();
            }
            if(list.size()>0){
                for(int i=0;i<list.size();i++){
                    Map map1=(Map)list.get(i);
                    map1.put("userId",userId);
                }
                userService.deleteUserRoleByUserId(userId);
                is =  userService.addUserRole(list);
            }else{
                is=userService.deleteUserRoleByUserId(userId);
            }
        }

        return is;
    }

    @DeleteMapping("del")
    @ResponseBody
    public int del(@RequestParam("id") Integer id){
        return userService.delete(id);
    }
}

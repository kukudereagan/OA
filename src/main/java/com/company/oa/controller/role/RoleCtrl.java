package com.company.oa.controller.role;

import com.company.oa.controller.response.ResponsePageData;
import com.company.oa.model.system.SysRole;
import com.company.oa.model.system.SysUser;
import com.company.oa.service.role.RoleService;
import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/system/role/")
@Controller
public class RoleCtrl {
    @Autowired
    private RoleService roleService;
    @GetMapping("index")
    public String index(ModelMap modelMap){
        return "system/role/index";
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
        SysRole sysRole = new SysRole();
        if(editFlag > 0) {
            sysRole = roleService.getDetail(id);
        }
        modelMap.put("sysRole",sysRole);
        modelMap.put("edit",editFlag != 2);
        return "system/role/edit";
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
        Page<SysRole> page = (Page<SysRole>)roleService.getPageData(filter,offset, limit);
        return new ResponsePageData<SysRole>(page.getTotal(),page);
    }

    @PostMapping("edit")
    @ResponseBody
    public int edit(@RequestBody SysRole model){
        SysRole re = roleService.createOrUpdate(model);
        return re != null? 1:0;
    }

    @DeleteMapping("del")
    @ResponseBody
    public int del(@RequestParam("id") Integer id){
        return roleService.delete(id);
    }
}

package com.company.oa.controller.permission;

import com.company.oa.controller.response.ResponsePageData;
import com.company.oa.model.system.SysPermission;
import com.company.oa.model.system.SysRole;
import com.company.oa.service.permission.PermissionService;
import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/system/permission/")
@Controller
public class PermissionCtrl {
    @Autowired
    private PermissionService permissionService;
    @GetMapping("index")
    public String index(ModelMap modelMap){
        return "system/permission/index";
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
        SysPermission sysPermission = new SysPermission();
        if(editFlag > 0) {
            sysPermission = permissionService.getDetail(id);
        }
        modelMap.put("sysPermission",sysPermission);
        modelMap.put("edit",editFlag != 2);
        return "system/permission/edit";
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
        Page<SysPermission> page = (Page<SysPermission>)permissionService.getPageData(filter,offset, limit);
        return new ResponsePageData<SysPermission>(page.getTotal(),page);
    }

    @PostMapping("edit")
    @ResponseBody
    public int edit(@RequestBody SysPermission model){
        SysPermission re = permissionService.createOrUpdate(model);
        return re != null? 1:0;
    }

    @DeleteMapping("del")
    @ResponseBody
    public int del(@RequestParam("id") Integer id){
        return permissionService.delete(id);
    }
}

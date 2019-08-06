package com.company.oa.controller.ops;

import com.company.oa.controller.response.ResponsePageData;
import com.company.oa.model.Common;
import com.company.oa.service.TeacherService;
import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/ops/teacher/")
public class TeacherOpsController {

    @Autowired
    private TeacherService teacherService;

    /**
     *  ------页面跳转 start-----
     */
    @GetMapping("index")
    public String index(ModelMap modelMap){

        return "ops/teacher/index";
    }

    /**
     * 编辑，新增，查看 方法，。
     * @param modelMap
     * @param id
     * @param editFlag edit = 1, new = 0 , show = 2
     * @return
     */
    @GetMapping("edit")
    public String edit(ModelMap modelMap,@RequestParam(value = "id",required = false) Integer id,
                       @RequestParam(value = "flag",defaultValue = "1") Integer editFlag){
        Common model = new Common();
        if(editFlag > 0) {
            model = teacherService.getTeacher(id);
        }
        modelMap.put("teacher",model);
        modelMap.put("edit",editFlag != 2);
        return "ops/teacher/edit";
    }
    /**
     * 数据处理
     */
    @GetMapping("data")
    @ResponseBody
    public ResponsePageData data(@RequestParam(value = "offset",defaultValue = "0") Integer offset,
                                    @RequestParam(value = "limit",defaultValue = "10") Integer limit,
                                 @RequestParam(value = "filter",required = false) String filter){
        System.out.println(filter);
        Page<Common> page = (Page<Common>)teacherService.getTeachers(filter,offset, limit);
        return new ResponsePageData<Common>(page.getTotal(),page);
    }

    @PostMapping("edit")
    @ResponseBody
    public int edit(@RequestBody Common model){
    	Common re = teacherService.createOrUpdate(model);
        return re != null? 1:0;
    }

    @DeleteMapping("del")
    @ResponseBody
    public int del(@RequestParam("id") Integer id){
        return teacherService.delete(id);
    }
}

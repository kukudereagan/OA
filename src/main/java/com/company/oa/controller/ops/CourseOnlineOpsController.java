package com.company.oa.controller.ops;

import com.company.oa.controller.response.ResponsePageData;
import com.company.oa.model.CourseOnline;
import com.company.oa.service.CourseOnlineService;
import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/ops/courseonline/")
public class CourseOnlineOpsController {

    @Autowired
    private CourseOnlineService courseOnlineService;

    /**
     *  ------页面跳转 start-----
     */


    @GetMapping("index")
    public String index(ModelMap modelMap){

        return "ops/courseonline/index";
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
        CourseOnline courseOnline = new CourseOnline();
        if(editFlag > 0) {
            courseOnline = courseOnlineService.selectOne(id);
        }
        modelMap.put("courseOnline",courseOnline);
        modelMap.put("edit",editFlag != 2);
        return "ops/courseonline/edit";
    }

    /**
     * 数据处理
     */

    @GetMapping("data")
    @ResponseBody
    public ResponsePageData data(@RequestParam(value = "type",defaultValue = "0") Integer type,
    								@RequestParam(value = "isRecommended",defaultValue = "0") Integer isRecommended,
    								@RequestParam(value = "offset",defaultValue = "0") Integer offset,
                                    @RequestParam(value = "limit",defaultValue = "10") Integer limit,
                                    @RequestParam(value = "filter",required = false) String filter){
        System.out.println(filter);
        Page<CourseOnline> page = (Page<CourseOnline>)courseOnlineService.selectAll(type, isRecommended, offset, limit);
        return new ResponsePageData<CourseOnline>(page.getTotal(),page);
    }

   @PostMapping("edit")
    @ResponseBody
    public int edit(@RequestBody CourseOnline courseOnline){
        CourseOnline re = courseOnlineService.createOrUpdate(courseOnline);
        return re != null? 1:0;
    }

    @DeleteMapping("del")
    @ResponseBody
    public int del(@RequestParam("id") Integer id){
        return courseOnlineService.delete(id);
    }
}

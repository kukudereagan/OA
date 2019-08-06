package com.company.oa.controller.ops;

import com.company.camera.CatD;
import com.company.oa.controller.response.ResponsePageData;
import com.company.oa.model.CourseOffline;
import com.company.oa.model.ResposeModel;
import com.company.oa.service.CourseOfflineService;
import com.github.pagehelper.Page;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Liaopan on 2018/1/25.
 */
@Controller
@RequestMapping("/ops/courseoffline/")
public class CourseOfflineOpsController {

    @Autowired
    private CourseOfflineService courseOfflineService;

    /**
     *  ------页面跳转 start-----
     */


    @GetMapping("index")
    public String index(ModelMap modelMap){

        return "ops/courseoffline/index";
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
        CourseOffline courseOffline = new CourseOffline();
        if(editFlag > 0) {
            courseOffline = courseOfflineService.selectOne(id);
        }
        modelMap.put("courseOffline",courseOffline);
        modelMap.put("edit",editFlag != 2);
        return "ops/courseoffline/edit";
    }

    /**
     *  ------页面跳转 end------
     */


    /**
     * 数据处理
     */

    @GetMapping("data")
    @ResponseBody
    public ResponsePageData data(@RequestParam(value = "page",defaultValue = "0") Integer offset,
                                    @RequestParam(value = "limit",defaultValue = "10") Integer limit,
                                 @RequestParam(value = "filter",required = false) String filter){
        System.out.println(filter);
        Page<CourseOffline> page = (Page<CourseOffline>)courseOfflineService.selectAll(filter,offset,limit);
        return new ResponsePageData<CourseOffline>(page.getTotal(),page);
    }

    @PostMapping("edit")
    @ResponseBody
    public int edit(@RequestBody CourseOffline courseOffline){
        CourseOffline re = courseOfflineService.createOrUpdate(courseOffline);
        return re != null? 1:0;
    }

    @DeleteMapping("del")
    @ResponseBody
    public int del(@RequestParam("id") Integer id){
        return courseOfflineService.delete(id);
    }
    
    
    @RequestMapping(value="/upload", method = RequestMethod.POST)
    public @ResponseBody ResposeModel upload(@RequestParam("file") MultipartFile file,
            HttpServletRequest request) {
        String contentType = file.getContentType();
        
        String fileName=new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date())+file.getOriginalFilename();
        //String fileName = file.getOriginalFilename();
        String filePath = request.getSession().getServletContext().getRealPath("/imgupload/");
        System.out.println(filePath);
        ResposeModel res = new ResposeModel();
        try {
            CatD.uploadFile(file.getBytes(), filePath, fileName);
            res.setData("/imgupload/"+fileName);
        } catch (Exception e) {
        	e.printStackTrace();
        	res.setStatus("0");
        }
        
		return res;        
    }
}

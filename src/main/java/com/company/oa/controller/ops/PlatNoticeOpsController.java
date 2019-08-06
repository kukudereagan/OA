package com.company.oa.controller.ops;

import com.company.oa.controller.response.ResponsePageData;
import com.company.oa.model.PlatNotice;
import com.company.oa.service.PlatNoticeService;
import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

/**
 * 平台公告
 */
@Controller
@RequestMapping("/ops/platnotice/")
public class PlatNoticeOpsController {

    @Autowired
    private PlatNoticeService platNoticeService;

    /**
     *  ------页面跳转 start-----
     */
    @GetMapping("index")
    public String index(ModelMap modelMap){
        return "ops/platnotice/index";
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
    	PlatNotice notice = new PlatNotice();
        if(editFlag > 0) {
        	notice = platNoticeService.selectOne(id);
        }
        modelMap.put("notice",notice);
        modelMap.put("edit",editFlag != 2);
        return "ops/platnotice/edit";
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
        Page<PlatNotice> page = (Page<PlatNotice>)platNoticeService.selectAll(filter,offset,limit);
        return new ResponsePageData<PlatNotice>(page.getTotal(),page);
    }

    @PostMapping("edit")
    @ResponseBody
    public int edit(@RequestBody PlatNotice notice){
    	PlatNotice re = platNoticeService.createOrUpdate(notice);
        return re != null? 1:0;
    }

    @DeleteMapping("del")
    @ResponseBody
    public int del(@RequestParam("id") Integer id){
        return platNoticeService.delete(id);
    }
}

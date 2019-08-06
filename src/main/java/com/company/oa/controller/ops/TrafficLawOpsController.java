package com.company.oa.controller.ops;

import com.company.oa.controller.response.ResponsePageData;
import com.company.oa.model.TrafficLaw;
import com.company.oa.service.TrafficLawService;
import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

/**
 * 法律法规
 */
@Controller
@RequestMapping("/ops/trafficlaw/")
public class TrafficLawOpsController {

    @Autowired
    private TrafficLawService trafficlawService;

    /**
     *  ------页面跳转 start-----
     */


    @GetMapping("index")
    public String index(ModelMap modelMap){
        return "ops/trafficlaw/index";
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
    	TrafficLaw trafficlaw = new TrafficLaw();
        if(editFlag > 0) {
        	trafficlaw = trafficlawService.selectOne(id);
        }
        modelMap.put("trafficlaw",trafficlaw);
        modelMap.put("edit",editFlag != 2);
        return "ops/trafficlaw/edit";
    }

    /**
     *  ------页面跳转 end------
     */


    /**
     * 数据处理
     */

    @GetMapping("data")
    @ResponseBody
    public ResponsePageData data(@RequestParam(value = "offset",defaultValue = "0") Integer offset,
                                    @RequestParam(value = "limit",defaultValue = "10") Integer limit,
                                 @RequestParam(value = "filter",required = false) String filter){
        System.out.println(filter);
        Page<TrafficLaw> page = (Page<TrafficLaw>)trafficlawService.selectAll(filter,offset,limit);
        return new ResponsePageData<TrafficLaw>(page.getTotal(),page);
    }

    @PostMapping("edit")
    @ResponseBody
    public int edit(@RequestBody TrafficLaw trafficLaw){
    	TrafficLaw re = trafficlawService.createOrUpdate(trafficLaw);
        return re != null? 1:0;
    }

    @DeleteMapping("del")
    @ResponseBody
    public int del(@RequestParam("id") Integer id){
        return trafficlawService.delete(id);
    }
}

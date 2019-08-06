package com.company.oa.controller;

import com.company.oa.configuration.CustomConfig;
import com.company.oa.model.ResposeModel;
import com.company.oa.service.CourseOfflineService;
import com.company.oa.service.CourseOnlineService;
import com.company.oa.service.DemoService;
import com.company.oa.service.ShufflingService;
import com.company.oa.service.TeacherService;
import com.company.oa.service.TrafficLawService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/api/HomePage")
public class HomePageController {
	private Logger log = LoggerFactory.getLogger(HomePageController.class);
    @Autowired
    private DemoService demoService;
 
    @Autowired
    private TeacherService teacherService;

    @Autowired
    private CourseOnlineService courseOnlineService;

    @Autowired
    private CourseOfflineService courseOfflineService;

    @Autowired
    private TrafficLawService trafficLawService;

    @Autowired
    private ShufflingService shufflingService;

    @Autowired
    private CustomConfig customConfig;
 
    /*获取线下培训课程*/
    @RequestMapping("/getCourseOfflines/pageIndex/{pageIndex}/pageSize/{pageSize}")
    @ResponseBody
    public ResposeModel getCourseOfflines(@PathVariable("pageIndex") Integer pageIndex
    		,@PathVariable("pageSize") Integer pageSize){
    	ResposeModel res=new ResposeModel();
    	try {
    		res.setData(courseOfflineService.selectAll(pageIndex,pageSize));
		} catch (Exception e) {
			res.setStatus("0");
			res.setMsg("获取数据出错");
		}
    	
        return res;
    }
    
    /*获取首页轮播*/
    @RequestMapping("/getShufflings")
    @ResponseBody
    public ResposeModel getShufflings(){
    	ResposeModel res=new ResposeModel();
    	try {
    		res.setData(shufflingService.selectAll());
		} catch (Exception e) {
			res.setStatus("0");
			res.setMsg("获取数据出错");
		}
    	
        return res;
    }
}

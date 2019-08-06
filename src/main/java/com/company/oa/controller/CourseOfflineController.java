package com.company.oa.controller;

import com.company.oa.model.ResposeModel;
import com.company.oa.service.CourseOfflineService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/*线下课程*/
@Controller
@RequestMapping("/api/CourseOffline")
public class CourseOfflineController {
	private Logger log = LoggerFactory.getLogger(CourseOfflineController.class);

	@Autowired
	private CourseOfflineService courseOfflineService;

	/* 获取首页线下课程 */
	@RequestMapping("/getHomePageCourseOfflines")
	@ResponseBody
	public ResposeModel getHomePageCourseOfflines() {
		ResposeModel res = new ResposeModel();
		try {
			res.setData(courseOfflineService.selectHomePageAll());
		} catch (Exception e) {
			log.info("getHomePageCourseOfflines:"+e.toString());
			res.setStatus("0");
			res.setMsg("获取数据出错");
		}

		return res;
	}
	
	/* 获取线下课程 */
	@RequestMapping("/getCourseOfflines/pageIndex/{pageIndex}/pageSize/{pageSize}")
	@ResponseBody
	public ResposeModel getCourseOfflines(@PathVariable("pageIndex") Integer pageIndex,
			@PathVariable("pageSize") Integer pageSize) {
		ResposeModel res = new ResposeModel();
		try {
			res.setData(courseOfflineService.selectAll(pageIndex, pageSize));
		} catch (Exception e) {
			log.info("getCourseOfflines:"+e.toString());
			res.setStatus("0");
			res.setMsg("获取数据出错");
		}

		return res;
	}
	
	/* 获取线下课程 */
	@RequestMapping("/getCourseOffline/id/{id}")
	@ResponseBody
	public ResposeModel getCourseOffline(@PathVariable("id") Integer id) {
		ResposeModel res = new ResposeModel();
		try {
			res.setData(courseOfflineService.selectOne(id));
		} catch (Exception e) {
			log.info("getCourseOffline:"+e.toString());
			res.setStatus("0");
			res.setMsg("获取数据出错");
		}

		return res;
	}

 
}

package com.company.oa.controller;

import com.company.oa.model.ResposeModel;
import com.company.oa.service.CourseOnlineService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/*线上课程*/
@Controller
@RequestMapping("/api/CourseOnline")
public class CourseOnlineController {
	private Logger log = LoggerFactory.getLogger(CourseOnlineController.class);

	@Autowired
	private CourseOnlineService courseOnlineService;

	/* 获取首页线上课程 */
	@RequestMapping("/getHomePageCourseOnlines")
	@ResponseBody
	public ResposeModel getHomePageCourseOnlines() {
		ResposeModel res = new ResposeModel();
		try {
			res.setData(courseOnlineService.selectHomePageAll());
		} catch (Exception e) {
			log.info("api-getHomePageCourseOnlines:" + e.toString());
			res.setStatus("0");
			res.setMsg("获取数据出错");
		}

		return res;
	}
	
	/* 获取线上课程 */
	@RequestMapping("/getCourseOnlines/type/{type}/isRecommended/{isRecommended}/pageIndex/{pageIndex}/pageSize/{pageSize}")
	@ResponseBody
	public ResposeModel getCourseOnlines(@PathVariable("type") Integer type,
			@PathVariable("isRecommended") Integer isRecommended, @PathVariable("pageIndex") Integer pageIndex,
			@PathVariable("pageSize") Integer pageSize) {
		ResposeModel res = new ResposeModel();
		try {
			res.setData(courseOnlineService.selectAll(type, isRecommended, pageIndex, pageSize));
		} catch (Exception e) {
			log.info("api-getCourseOnlines:" + e.toString());
			res.setStatus("0");
			res.setMsg("获取数据出错");
		}

		return res;
	}

	/* 获取线上课程 */
	@RequestMapping("/getCourseOnline/id/{id}")
	@ResponseBody
	public ResposeModel getCourseOnline(@PathVariable("id") Integer id) {
		ResposeModel res = new ResposeModel();
		try {
			res.setData(courseOnlineService.selectOne(id));
		} catch (Exception e) {
			log.info("api-getCourseOnline:" + e.toString());
			res.setStatus("0");
			res.setMsg("获取数据出错");
		}

		return res;
	}

	/* 获取线上课程-列表页面用 */
	@RequestMapping("/getCourseOnlineList")
	@ResponseBody
	public ResposeModel getCourseOnlineList() {
		ResposeModel res = new ResposeModel();
		try {
			res.setData(courseOnlineService.selectList());
		} catch (Exception e) {
			log.info("api-getCourseOnlineList:" + e.toString());
			res.setStatus("0");
			res.setMsg("获取数据出错");
		}

		return res;
	}

}

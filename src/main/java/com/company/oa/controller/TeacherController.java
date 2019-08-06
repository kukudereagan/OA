package com.company.oa.controller;

import com.company.oa.model.ResposeModel;
import com.company.oa.service.TeacherApiService;
import com.company.oa.service.TeacherService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/*教练*/
@Controller
@RequestMapping("/api/Teacher")
public class TeacherController {
	private Logger log = LoggerFactory.getLogger(TeacherController.class);
	@Autowired
	private TeacherService teacherService;
	@Autowired
	private TeacherApiService teacherApiService;

	/* 获取首页教练列表 */
	@RequestMapping("/getHomePageTeachers")
	@ResponseBody
	public ResposeModel getHomePageTeachers() {
		ResposeModel res = new ResposeModel();
		try {
			res.setData(teacherApiService.selectHomePageAll());
		} catch (Exception e) {
			res.setStatus("0");
			res.setMsg("获取数据出错");
		}

		return res;
	}
	
	/* 获取教练列表 */
	@RequestMapping("/getTeachers/pageIndex/{pageIndex}/pageSize/{pageSize}")
	@ResponseBody
	public ResposeModel getTeachers(@PathVariable("pageIndex") Integer pageIndex,
			@PathVariable("pageSize") Integer pageSize) {
		ResposeModel res = new ResposeModel();
		try {
			res.setData(teacherApiService.selectAll(pageIndex, pageSize));
		} catch (Exception e) {
			res.setStatus("0");
			res.setMsg("获取数据出错");
		}

		return res;
	}
	
	/* 获取教练 */
	@RequestMapping("/getTeacher/id/{id}")
	@ResponseBody
	public ResposeModel getTeacher(@PathVariable("id") Integer id) {
		ResposeModel res = new ResposeModel();
		try {
			res.setData(teacherApiService.selectOne(id));
		} catch (Exception e) {
			res.setStatus("0");
			res.setMsg("获取数据出错");
		}

		return res;
	}
	
	/* 获取教练的线上课程列表 */
	@RequestMapping("/getCourseOnlines/tid/{tid}")
	@ResponseBody
	public ResposeModel getCourseOnlines(@PathVariable("tid") Integer tid) {
		ResposeModel res = new ResposeModel();
		try {
			res.setData(teacherService.selectCourseOnlines(tid));
		} catch (Exception e) {
			res.setStatus("0");
			res.setMsg("获取数据出错");
		}

		return res;
	}

}

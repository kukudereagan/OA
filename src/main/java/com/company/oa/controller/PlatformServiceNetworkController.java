package com.company.oa.controller;

import com.company.oa.model.ResposeModel;
import com.company.oa.service.PlatformServiceNetworkService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


/*平台网点*/
@Controller
@RequestMapping("/api/PlatformServiceNetwork")
public class PlatformServiceNetworkController {
	private Logger log = LoggerFactory.getLogger(PlatformServiceNetworkController.class);
	@Autowired
	private PlatformServiceNetworkService platformServiceNetworkService;

	/*  */
	@RequestMapping("/getPlatformServiceNetworks/pageIndex/{pageIndex}/pageSize/{pageSize}")
	@ResponseBody
	public ResposeModel getPlatformServiceNetworks(@PathVariable("pageIndex") Integer pageIndex,
			@PathVariable("pageSize") Integer pageSize) {
		ResposeModel res = new ResposeModel();
		try {
			res.setData(platformServiceNetworkService.selectAll(pageIndex, pageSize));
		} catch (Exception e) {
			res.setStatus("0");
			res.setMsg("获取数据出错");
		}

		return res;
	}
	
	/*  */
	@RequestMapping("/getPlatformServiceNetwork/id/{id}")
	@ResponseBody
	public ResposeModel getPlatformServiceNetwork(@PathVariable("id") Integer id) {
		ResposeModel res = new ResposeModel();
		try {
			res.setData(platformServiceNetworkService.selectOne(id));
		} catch (Exception e) {
			res.setStatus("0");
			res.setMsg("获取数据出错");
		}

		return res;
	}
	
	/* 获取平台网点的线下课程 */
	@RequestMapping("/getPlatformServiceNetworkCourse/id/{id}/pageIndex/{pageIndex}/pageSize/{pageSize}")
	@ResponseBody
	public ResposeModel getPlatformServiceNetworkCourse(
			@PathVariable("id") Integer id,
			@PathVariable("pageIndex") Integer pageIndex,
			@PathVariable("pageSize") Integer pageSize) {
		ResposeModel res = new ResposeModel();
		try {
			res.setData(platformServiceNetworkService.selectCourseOfflines(id, pageIndex, pageSize));
		} catch (Exception e) {
			res.setStatus("0");
			res.setMsg("获取数据出错");
		}

		return res;
	}

}

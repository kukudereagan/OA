package com.company.oa.controller;

import com.company.oa.model.ResposeModel;
import com.company.oa.service.DrivingPolicyService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/*驾考政策*/
@Controller
@RequestMapping("/api/DrivingPolicy")
public class DrivingPolicyController {
	private Logger log = LoggerFactory.getLogger(DrivingPolicyController.class);
	@Autowired
	private DrivingPolicyService drivingPolicyService;

	/* 获取驾考政策 */
	@RequestMapping("/getDrivingPolicies/pageIndex/{pageIndex}/pageSize/{pageSize}")
	@ResponseBody
	public ResposeModel getDrivingPolicies(@PathVariable("pageIndex") Integer pageIndex,
			@PathVariable("pageSize") Integer pageSize) {
		ResposeModel res = new ResposeModel();
		try {
			res.setData(drivingPolicyService.selectAll(pageIndex, pageSize));
		} catch (Exception e) {
			log.info("getDrivingPolicies:"+e.toString());
			res.setStatus("0");
			res.setMsg("获取数据出错");
		}

		return res;
	}
	
	/* 获取驾考政策 */
	@RequestMapping("/getDrivingPolicy/id/{id}")
	@ResponseBody
	public ResposeModel getDrivingPolicy(@PathVariable("id") Integer id) {
		ResposeModel res = new ResposeModel();
		try {
			res.setData(drivingPolicyService.selectOne(id));
		} catch (Exception e) {
			log.info("getDrivingPolicy:"+e.toString());
			res.setStatus("0");
			res.setMsg("获取数据出错");
		}

		return res;
	}

}

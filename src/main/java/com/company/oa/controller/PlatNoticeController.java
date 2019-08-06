package com.company.oa.controller;

import com.company.oa.model.ResposeModel;
import com.company.oa.service.PlatNoticeService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/*交通法规*/
@Controller
@RequestMapping("/api/platnotice")
public class PlatNoticeController {
	private Logger log = LoggerFactory.getLogger(PlatNoticeController.class);
	@Autowired
	private PlatNoticeService platNoticeService;

	/* 获取交通安全法律法规 */
	@RequestMapping("/getNotices/pageIndex/{pageIndex}/pageSize/{pageSize}")
	@ResponseBody
	public ResposeModel getNotices(@PathVariable("pageIndex") Integer pageIndex,
			@PathVariable("pageSize") Integer pageSize) {
		ResposeModel res = new ResposeModel();
		try {
			res.setData(platNoticeService.selectAll(pageIndex, pageSize));
		} catch (Exception e) {
			res.setStatus("0");
			res.setMsg("获取数据出错");
		}

		return res;
	}
	
	/* 获取交通安全法律法规 */
	@RequestMapping("/getNotice/id/{id}")
	@ResponseBody
	public ResposeModel getNotice(@PathVariable("id") Integer id) {
		ResposeModel res = new ResposeModel();
		try {
			res.setData(platNoticeService.selectOne(id));
		} catch (Exception e) {
			res.setStatus("0");
			res.setMsg("获取数据出错");
		}

		return res;
	}

}

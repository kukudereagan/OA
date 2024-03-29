package com.company.oa.controller;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsRequest;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;
import com.company.oa.model.Customer;
import com.company.oa.model.ResposeModel;
import com.company.oa.model.SMS;
import com.company.oa.service.CustomerService;
import com.company.oa.service.SMSService;

import java.util.Date;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/api/SMS")
public class SMSController {
	private Logger log = LoggerFactory.getLogger(SMSController.class);
	@Autowired
	private SMSService smsService;

	@Autowired
	private CustomerService customerService;

	/* 短信发送 */
	/*@RequestMapping(value = "/sendSMS", method = RequestMethod.POST,consumes = "application/json")*/
	@PostMapping(value = "/sendSMS")
	@ResponseBody
	public ResposeModel sendSMS(@RequestBody SMS model) {
		ResposeModel res = new ResposeModel();
		try {
			// 设置超时时间-可自行调整
			System.setProperty("sun.net.client.defaultConnectTimeout", "10000");
			System.setProperty("sun.net.client.defaultReadTimeout", "10000");
			// 初始化ascClient需要的几个参数
			final String product = "Dysmsapi";// 短信API产品名称（短信产品名固定，无需修改）
			final String domain = "dysmsapi.aliyuncs.com";// 短信API产品域名（接口地址固定，无需修改）
			// 替换成你的AK
			final String accessKeyId = "LTAIWvS9DxXNZYaW";// 你的accessKeyId,参考本文档步骤2
			final String accessKeySecret = "zcrKMYSO8sPp5RfUZRQKRXEK48q2JM";// 你的accessKeySecret，参考本文档步骤2
			// 初始化ascClient,暂时不支持多region（请勿修改）
			IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou", accessKeyId, accessKeySecret);
			DefaultProfile.addEndpoint("cn-hangzhou", "cn-hangzhou", product, domain);
			IAcsClient acsClient = new DefaultAcsClient(profile);
			// 组装请求对象
			SendSmsRequest request = new SendSmsRequest();
			// 使用post提交
			request.setMethod(MethodType.POST);
			// 必填:待发送手机号。支持以逗号分隔的形式进行批量调用，批量上限为1000个手机号码,批量调用相对于单条调用及时性稍有延迟,验证码类型的短信推荐使用单条调用的方式
			request.setPhoneNumbers(model.getMobile());
			// 必填:短信签名-可在短信控制台中找到
			request.setSignName("我的学车网");
			// 必填:短信模板-可在短信控制台中找到
			request.setTemplateCode("SMS_122560153");
			// 可选:模板中的变量替换JSON串,如模板内容为"亲爱的${name},您的验证码为${code}"时,此处的值为
			// 友情提示:如果JSON中需要带换行符,请参照标准的JSON协议对换行符的要求,比如短信内容中包含\r\n的情况在JSON中需要表示成\\r\\n,否则会导致JSON在服务端解析失败

			String REGEX_MOBILE = "^((17[0-9])|(14[0-9])|(13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$";
			Boolean ismobile = Pattern.matches(REGEX_MOBILE, model.getMobile());
			String code = (Integer.toString((int)((Math.random() * 9 + 1) * 1000)));
			if (!ismobile) {
				res.setStatus("0");
				res.setMsg("手机号格式不正确");
				return res;
			}

			Customer cus = customerService.selectOneByMobile(model.getMobile());
			if (cus != null) {
				res.setStatus("0");
				res.setMsg("此手机号已经注册");
				return res;
			}
			request.setTemplateParam("{\"code\":\"" + code + "\"}");
			// 可选-上行短信扩展码(扩展码字段控制在7位或以下，无特殊需求用户请忽略此字段)
			// request.setSmsUpExtendCode("90997");
			// 可选:outId为提供给业务方扩展字段,最终在短信回执消息中将此值带回给调用者
			request.setOutId("yourOutId");
			// 请求失败这里会抛ClientException异常
			SendSmsResponse sendSmsResponse = acsClient.getAcsResponse(request);
			if (sendSmsResponse.getCode() != null && sendSmsResponse.getCode().equals("OK")) {
				// 请求成功
				model.setCode(code);
				model.setCreateTime(new Date());
				smsService.insert(model);
			} else {
				res.setStatus("0");
				res.setMsg(sendSmsResponse.getCode());
			}
		} catch (Exception e) {
			res.setStatus("0");
			res.setMsg("短信发送出错");
		}

		return res;
	}

	/*验证验证码*/
	@PostMapping(value = "/checkSMSCode")
	@ResponseBody
	public ResposeModel checkSMSCode(@RequestBody SMS model) {
		ResposeModel res = new ResposeModel();
		try {
			SMS sms = smsService.selectOneByMobileAndCode(model);
			if (sms == null) {
				res.setStatus("0");
				res.setMsg("验证码不正确");
			} else {
				long l = (new Date().getTime() - sms.getCreateTime().getTime())/6000;
				if(l>30) {
					res.setStatus("0");
					res.setMsg("验证码已经过期");
				}
			}
		} catch (Exception e) {
			res.setStatus("0");
			res.setMsg("出错");
		}
		return res;
	}

}

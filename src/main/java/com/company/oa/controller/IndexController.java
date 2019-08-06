package com.company.oa.controller;

import com.company.oa.configuration.CustomConfig;
import com.company.oa.model.Demo;
import com.company.oa.model.system.SysUser;
import com.company.oa.service.DemoService;
import com.company.oa.model.Student;
import com.company.oa.service.StudentService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.company.oa.service.SysManager;
import org.apache.shiro.SecurityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class IndexController {
private Logger log = LoggerFactory.getLogger(IndexController.class);
    @Autowired
    private DemoService demoService;

    @Autowired
    private StudentService studentService;

    @Autowired
    private CustomConfig customConfig;

    @Autowired
    private SysManager sysManagerService;

    @Value("${uuid}")
    private String id;

    /**
     * 首页，根据角色不同返回不同的页面
     * @return
     */
    @RequestMapping("")
    public ModelAndView index(){
        ModelAndView modelAndView = new ModelAndView("login");

        if(SecurityUtils.getSubject().hasRole("admin")){  //平台管理员
            modelAndView.setViewName("admin/index");
            SysUser sysUser = (SysUser) SecurityUtils.getSubject().getPrincipal();
            modelAndView.addObject("menus",sysManagerService.selectPermissionsByUserId(sysUser.getId()));
        }else if(SecurityUtils.getSubject().hasRole("teacher")){  // teacher教师
            modelAndView.setViewName("index");
        }else if(SecurityUtils.getSubject().hasRole("drivingschool")){  // 驾校
        	modelAndView.setViewName("admin/index");
        	SysUser sysUser = (SysUser) SecurityUtils.getSubject().getPrincipal();
            modelAndView.addObject("menus",sysManagerService.selectPermissionsByUserId(sysUser.getId()));
        }else if(SecurityUtils.getSubject().hasRole("dba")){// DBA 角色
            modelAndView.setViewName("admin/index");
            SysUser sysUser = (SysUser) SecurityUtils.getSubject().getPrincipal();
            modelAndView.addObject("menus",sysManagerService.selectPermissionsByUserId(sysUser.getId()));
        }

        return modelAndView;
    }

    @RequestMapping("/show/{id}")
    public ModelAndView show(@PathVariable Integer id){
        ModelAndView modelAndView = new ModelAndView("/show");
        modelAndView.addObject("id",id);
        return modelAndView;
    }

    @RequestMapping("/blank")
    public String blankPage(){
        return "blank";
    }

    @RequestMapping(value = "/test/{id}",method = RequestMethod.GET)
    @ResponseBody
    public Demo showData(@PathVariable("id") Integer id){
        return demoService.selectOne(id);
    }

    @PostMapping("/add")
    @ResponseBody
    public Demo insert(@RequestBody Demo demo){
        return demoService.insert(demo);
    }
    
    @PostMapping("/addStudent")
    @ResponseBody
    public Student insertStudent(@RequestBody Student model){
        return studentService.insert(model);
    }

    @PostMapping("/edit")
    @ResponseBody
    public Demo update(@RequestBody Demo demo){
        return demoService.update(demo);
    }

    @GetMapping("/del")
    @ResponseBody
    public int delete(@RequestParam("id") Integer id){
        return demoService.delete(id);
    }
    
    
    /**
     * 返回一个带数据的页面
     * @return
     */
    @RequestMapping("/students")
    public ModelAndView students(){
        ModelAndView modelAndView = new ModelAndView("/students");
        List<Student> lst=new ArrayList<Student>();
        
        Student stu1=new Student();
        stu1.setName("zhang");
        lst.add(stu1);
        Student stu2=new Student();
        stu2.setName("li");
        lst.add(stu2);
        modelAndView.addObject("students",studentService.selectAll());
        return modelAndView;
    }
    
    @RequestMapping(value="/printStudent", method = RequestMethod.GET)
    public ModelAndView printStudent(
    		@RequestParam("name") String name,
    		@RequestParam("sex") Integer sex,
    		@RequestParam("nation") String nation,
    		@RequestParam("birthDay") String birthDay,
    		@RequestParam("country") String country,
    		@RequestParam("certificateCode") String certificateCode,
    		@RequestParam("registerAddress") String registerAddress,
    		@RequestParam("phone") String phone,
    		@RequestParam("mobile") String mobile,
    		@RequestParam("contactZip") String contactZip,
    		@RequestParam("email") String email,
    		@RequestParam("carModelCode") String carModelCode
    		) throws ParseException{
    	ModelAndView modelAndView = new ModelAndView("/printStudent");
    	SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
    	Student s = new Student();
    	Date birth = format.parse(birthDay);
    	s.setName(name);
    	s.setSex(sex);
    	s.setBirthDay(birth);
    	s.setCountry(country);
    	s.setNation(nation);
    	s.setCertificateCode(certificateCode);
    	
    	s.setRegisterAddress(registerAddress);
    	s.setContactZip(contactZip);   	
    	s.setMobile1(mobile);
    	s.setMobile2(email);
    	s.setPhone(phone);
    	s.setCarModelCode(carModelCode);
    	modelAndView.addObject("student",s);
    	return modelAndView;
    }
}

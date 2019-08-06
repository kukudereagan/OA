package com.company.oa.service;

import com.company.oa.model.Demo;

import org.junit.Assert;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/** 
* DemoService Tester. 
* 
* @author <Authors name> 
* @since <pre>01/08/2018</pre> 
* @version 1.0 
*/
@SpringBootTest
@RunWith(SpringRunner.class)
public class DemoServiceTest {

    @Autowired
    private DemoService demoService;
    
    @Autowired
    private TeacherApiService teacherApiService;

@Before
public void before() throws Exception { 
} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: selectAll() 
* 
*/ 
@Test
public void testSelectAll() throws Exception {
    List<Demo> demoList = demoService.selectAll();
    System.out.println(demoList.size());
    Assert.assertTrue(demoList.size() > 0);
}

/** 
* 
* Method: selectOne(Integer id) 
* 
*/ 
@Test
public void testSelectOne() throws Exception { 
	/*Page<TeacherApi> list = (Page<TeacherApi>)teacherApiService.selectAll(0, 10);
	List<TeacherApi> a = list.getResult();
	System.out.println(list.getTotal());
	for(TeacherApi api : list) {
		System.out.println(api.getSchoolName());
	}
	System.out.println(a);*/
} 


} 

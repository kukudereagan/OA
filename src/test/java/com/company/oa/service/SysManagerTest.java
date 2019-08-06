package com.company.oa.service;

import org.junit.Test;
import org.junit.Before; 
import org.junit.After;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/** 
* SysManager Tester. 
* 
* @author <Authors name> 
* @since <pre>01/10/2018</pre> 
* @version 1.0 
*/
@SpringBootTest
@RunWith(SpringRunner.class)
public class SysManagerTest { 

    @Autowired
    private SysManager sysManager;
@Before
public void before() throws Exception { 
} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: loadUserByUserName(String userName) 
* 
*/ 
@Test
public void testLoadUserByUserName() throws Exception {
   /* SysUser user = sysManager.loadUserByUserName("zhang");
    System.out.println(user);*/
} 


} 

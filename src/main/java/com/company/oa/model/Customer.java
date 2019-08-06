package com.company.oa.model;

import org.apache.ibatis.type.Alias;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

//用户
@Alias("customerModel")
@Data
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String mobile;
    private String pwd;
    private String pwdagain;
    
    
	 
	 
}

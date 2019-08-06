package com.company.oa.model;

import org.apache.ibatis.type.Alias;

import lombok.Data;

import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

//用户报名(购买)线下课程
@Alias("customer_buy_course_offlineModel")
@Data
public class CustomerBuyCourseOffline {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer customerId;
    private Integer courseOfflineId;
    private Date buyTime;
	 
	 
}

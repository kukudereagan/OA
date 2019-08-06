package com.company.oa.model;

import org.apache.ibatis.type.Alias;

import lombok.Data;

import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

//用户购买付费视频
@Alias("customer_buy_course_onlineModel")
@Data
public class CustomerBuyCourseOnline {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer customerId;
    private Integer courseOnlineId;
    private Date buyTime;
	 
	 
}

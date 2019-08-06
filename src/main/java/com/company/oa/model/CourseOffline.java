package com.company.oa.model;

import org.apache.ibatis.type.Alias;

import com.company.oa.modelApi.TeacherApi;

import lombok.Data;

import java.util.Date;
import java.util.List;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

//线下课程、培训计划
@Alias("course_offlineModel")
@Data
public class CourseOffline {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    /*平台网点id*/
    private Integer platformServiceNetworkId;
    private String title;
    private Double price;
    private String content;
    private String imagePath;
 
    /*课长*/
    private String length;
	/* 开始时间 */
    private Date startTime;
    /*授课地址*/
    private String address;
    /*是否显示在首页 1-是 */
    private Integer showHomepage;
    /*教师-用逗号拼接教师id的字符串*/
    private String teachers;
    
    @Transient
    private List<TeacherApi> teacherList;

}

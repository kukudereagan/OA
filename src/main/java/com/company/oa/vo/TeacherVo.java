package com.company.oa.vo;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Alias("teacherVoModel")
@Data
public class TeacherVo {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String schoolName;
    private String name;
    private Integer teachingAge;
    private String avator;
    /*标签-用逗号拼接标签id的字符串*/
    private String tag;
    /*简介*/
    private String introduce;
    /*授课地点*/
    private String teachingAddress;
}

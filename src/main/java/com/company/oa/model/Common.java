package com.company.oa.model;

import org.apache.ibatis.type.Alias;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Alias("commonModel")
@Data
public class Common {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /*sysuserid*/
    private Integer userId;
    
    /*平台-1*/
    /*驾校-2*/
    /*教师-3*/
    private String type;
    
    /*教师-学校id*/
    /*驾校-区域id*/
    private Integer belongId;
    
    /*教师-名称*/
    /*驾校-名称*/
    private String name;
    
    /*教师-教龄*/
    private Integer teachingAge;
    
    /*教师-头像*/
    /*驾校-图片*/
    private String imagePath;
    
    /*教师-标签-用逗号拼接标签id的字符串*/
    /*驾校-用逗号拼接驾照类型id的字符串*/
    private String tag;
    
    /*教师-简介*/
    /*驾校-简介*/
    private String introduce;
    
    /*教师-授课地点*/
    /*驾校-地址*/
    private String address;
    
    /*教师-电话*/
    /*驾校-电话*/
    private String tel;
    
    /*教师-是否显示在首页 1-是 */
    private Integer showHomepage;
    
}

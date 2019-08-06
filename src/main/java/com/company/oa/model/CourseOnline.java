package com.company.oa.model;

import org.apache.ibatis.type.Alias;

import lombok.Data;

import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

//线上课程
@Alias("course_onlineModel")
@Data
public class CourseOnline {
	public CourseOnline() {
		type = 1;
		createTime = new Date();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	// 所属教师
	private Integer userId;
	// 类别 1,2,3,4 分别代表 科目一、二、三、四
	private Integer type;
	private String title;
	private String content;
	/*视频地址*/
	private String videoPath;
	private String imagePath;
	private Date createTime;
	// 是否热点和付费 0-都不是,1-热点,2-付费,3-热点且付费
	private Integer isHotAndCharge;
	// 是否推荐
	private Boolean isRecommended;
	private Integer hour;
	private Integer minute;
	private Integer second;
	/* 播放次数 */
	private Integer playNumber;
	
	/*是否显示在首页 1-是 */
    private Integer showHomepage;
   
}

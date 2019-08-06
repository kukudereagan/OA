package com.company.oa.model;

import org.apache.ibatis.type.Alias;

import lombok.Data;

import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

//公告
@Alias("plat_notice")
@Data
public class PlatNotice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    private String introduce;
    private String content;
    private String imagePath;
    private Date createTime;
}

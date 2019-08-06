package com.company.oa.modelApi;

import org.apache.ibatis.type.Alias;

import lombok.Data;

//教练
@Alias("teacherApiModel")
@Data
public class TeacherApi {
    private Integer id;
    private String name;
    private Integer teachingAge;
    private String avator;
    private Integer schoolId;
    private String schoolName;
    private String tag;
    private String tags;
    private String introduce;
    private String address;
}

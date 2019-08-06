package com.company.oa.model;

import org.apache.ibatis.type.Alias;

import lombok.Data;

import java.util.List;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

/*平台网点*/
@Alias("platform_service_networkModel")
@Data
public class PlatformServiceNetwork {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String address;
    private String tel;
    private String imagePath;
    @Transient
    private List<PlatformServiceNetworkImage> images;
}

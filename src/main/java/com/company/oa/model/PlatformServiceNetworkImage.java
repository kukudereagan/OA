package com.company.oa.model;

import org.apache.ibatis.type.Alias;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

/*平台网点图片*/
@Alias("platform_service_network_imageModel")
@Data
public class PlatformServiceNetworkImage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer fromId;
    private String imagePath;
    @Transient
    private PlatformServiceNetwork from;
}

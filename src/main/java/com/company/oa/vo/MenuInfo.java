package com.company.oa.vo;

import lombok.Data;

import java.util.List;

/**
 * Created by Liaopan on 2018/1/25.
 */
@Data
public class MenuInfo {

    private String id;
    private String name;
    private String url;
    private List<MenuInfo> children;

    public MenuInfo(){}
    public MenuInfo(String id,String name,String url){
        this.id = id;
        this.name = name;
        this.url = url;
    }
}

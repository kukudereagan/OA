package com.company.oa.controller.response;

import lombok.Data;

import java.util.List;

/**
 * Created by Liaopan on 2018/1/25.
 */
@Data
public class ResponsePageData<T> {

    private Integer code = 0;
    private String msg = "success";
    private long count;
    private List<T> data ;

    public ResponsePageData(long count,List<T> data){
        this.count = count;
        this.data = data;
    }
}

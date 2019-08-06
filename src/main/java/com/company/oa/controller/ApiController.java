package com.company.oa.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Liaopan on 2018/1/23.
 */
@RestController
@RequestMapping("/api")
public class ApiController {

    @GetMapping("index")
    public String index(){
        return "hello";
    }
}

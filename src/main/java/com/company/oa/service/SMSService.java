package com.company.oa.service;

import com.company.oa.mapper.SMSMapper;
import com.company.oa.model.SMS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SMSService {

    @Autowired
    private SMSMapper smsMapper;

    /**
     * 添加：
     * 在Demo po中的id列加入@GeneratedValue(strategy = GenerationType.IDENTITY) 可自动生成Id,
     * @param demo
     * @return
     */
    public SMS insert(SMS model){
        //通用mapper中的两个新增方式
        smsMapper.insert(model); //插入所有数据，保存字段值为null的。
       // demoMapper.insertSelective(oa); //只插入字段值不为null的数据。
        
        int id = model.getId();  //调用插入方法后，通过这样的方式获取插入的数据的新ID
        System.out.println(id);
        return model;
    }
    
    public SMS selectOne(Integer id){
    	SMS demo = new SMS();
        demo.setId(id);
        return smsMapper.selectOne(demo);
    }

    public SMS selectOneByMobileAndCode(SMS model){
        return smsMapper.selectOne(model);
    }
}

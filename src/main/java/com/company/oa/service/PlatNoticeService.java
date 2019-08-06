package com.company.oa.service;

import com.company.oa.mapper.NoticeMapper;
import com.company.oa.model.PlatNotice;
import com.github.pagehelper.PageHelper;

import tk.mybatis.mapper.entity.Example;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PlatNoticeService {

    @Autowired
    private NoticeMapper noticeMapper;
 
    public PlatNotice selectOne(Integer id){
    	PlatNotice model = new PlatNotice();
    	model.setId(id);
        return noticeMapper.selectOne(model);
    }
    
    public List<PlatNotice> selectAll(Integer pageIndex,Integer pageSize){
        // 单表分页
        PageHelper.startPage(pageIndex,pageSize,false);

        //单表自定义查询
        //Example company = new Example(Demo.class);

        return noticeMapper.selectAll();
    }

    public List<PlatNotice> selectAll(String filter,Integer pageIndex,Integer pageSize){
        // 单表分页
        PageHelper.startPage(pageIndex,pageSize);
        Example example = new Example(PlatNotice.class);
        if(StringUtils.isNotEmpty(filter)) {
            filter = "%" + filter + "%";
            example.createCriteria().andLike("title", filter).orLike("content", filter);
        }

        return noticeMapper.selectByExample(example);
    }

    public PlatNotice createOrUpdate(PlatNotice notice) {
        // 新增
        if(notice.getId() == null){
        	noticeMapper.insert(notice);
        }else{
        	noticeMapper.updateByPrimaryKeySelective(notice);
        }
        return notice;
    }

    public int delete(Integer id) {
    	PlatNotice model = new PlatNotice();
        model.setId(id);
        return noticeMapper.deleteByPrimaryKey(model);
    }

}

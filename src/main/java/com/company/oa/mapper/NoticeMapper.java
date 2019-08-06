package com.company.oa.mapper;

import com.company.oa.model.PlatNotice;

import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

@org.apache.ibatis.annotations.Mapper
@Repository
public interface NoticeMapper extends Mapper<PlatNotice> {
}

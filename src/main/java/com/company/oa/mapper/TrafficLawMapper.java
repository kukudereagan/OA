package com.company.oa.mapper;

import com.company.oa.model.TrafficLaw;

import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

@org.apache.ibatis.annotations.Mapper
@Repository
public interface TrafficLawMapper extends Mapper<TrafficLaw> {
}

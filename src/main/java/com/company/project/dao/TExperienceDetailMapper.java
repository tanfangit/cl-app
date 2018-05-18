package com.company.project.dao;

import java.util.List;
import java.util.Map;

import com.company.project.core.Mapper;
import com.company.project.model.TExperienceDetail;

public interface TExperienceDetailMapper extends Mapper<TExperienceDetail> {
	List<TExperienceDetail> selectTExperienceDetailByMap(Map<String,Object> map);
}
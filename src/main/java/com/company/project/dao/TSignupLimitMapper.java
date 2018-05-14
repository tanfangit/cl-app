package com.company.project.dao;

import java.util.List;
import java.util.Map;

import com.company.project.core.Mapper;
import com.company.project.model.TSignupLimit;

public interface TSignupLimitMapper extends Mapper<TSignupLimit> {
	 List<TSignupLimit> selectTSignupLimitByMap(Map<String,Object> map);
}
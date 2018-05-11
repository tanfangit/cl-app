package com.company.project.dao;

import java.util.List;
import java.util.Map;

import com.company.project.core.Mapper;
import com.company.project.model.TDict;

public interface TDictMapper extends Mapper<TDict> {
	List<TDict>   selectTDictByCondition(Map<String,Object> map);
}
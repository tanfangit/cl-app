package com.company.project.dao;

import java.util.List;
import java.util.Map;

import com.company.project.core.Mapper;
import com.company.project.dto.TantiqueDTO;
import com.company.project.model.TAntique;

public interface TAntiqueMapper extends Mapper<TAntique> {
	List<TantiqueDTO>   selectTAntiqueByCondition(Map<String,Object> map);
}
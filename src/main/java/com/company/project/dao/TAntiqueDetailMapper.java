package com.company.project.dao;

import java.util.List;
import java.util.Map;

import com.company.project.core.Mapper;
import com.company.project.dto.TAntiqueDetailDTO;
import com.company.project.model.TAntiqueDetail;

public interface TAntiqueDetailMapper extends Mapper<TAntiqueDetail> {
	 List<TAntiqueDetailDTO>   selectTAntiqueDetailByCondition(Map<String,Object> map);
}
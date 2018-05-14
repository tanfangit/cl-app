package com.company.project.dao;

import java.util.List;
import java.util.Map;

import com.company.project.core.Mapper;
import com.company.project.dto.TAccommodationDTO;
import com.company.project.model.TAccommodation;

public interface TAccommodationMapper extends Mapper<TAccommodation> {
	List<TAccommodationDTO>   selectTAccommodationDTOByCondition(Map<String,Object> map);
}
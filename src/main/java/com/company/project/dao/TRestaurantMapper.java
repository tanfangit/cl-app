package com.company.project.dao;

import java.util.List;
import java.util.Map;

import com.company.project.core.Mapper;
import com.company.project.dto.TRestaurantDTO;
import com.company.project.model.TRestaurant;

public interface TRestaurantMapper extends Mapper<TRestaurant> {
	List<TRestaurantDTO>   selectTRestaurantDTOByCondition(Map<String,Object> map);
}
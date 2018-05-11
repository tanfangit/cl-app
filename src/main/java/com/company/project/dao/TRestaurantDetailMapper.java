package com.company.project.dao;

import java.util.List;
import java.util.Map;

import com.company.project.core.Mapper;
import com.company.project.model.TRestaurantDetail;

public interface TRestaurantDetailMapper extends Mapper<TRestaurantDetail> {
	List<TRestaurantDetail>   selectTRestaurantDetailByCondition(Map<String,Object> map);
}
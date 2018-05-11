package com.company.project.service;
import java.util.List;
import java.util.Map;

import com.company.project.core.Service;
import com.company.project.dto.TRestaurantDTO;
import com.company.project.model.TRestaurant;


/**
 * Created by tanfan on 2018/05/11.
 */
public interface TRestaurantService extends Service<TRestaurant> {
	List<TRestaurantDTO>   selectTRestaurantDTOByCondition(Map<String,Object> map);
}

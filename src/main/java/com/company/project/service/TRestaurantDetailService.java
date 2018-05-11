package com.company.project.service;
import java.util.List;
import java.util.Map;

import com.company.project.core.Service;
import com.company.project.model.TRestaurantDetail;


/**
 * Created by tanfan on 2018/05/11.
 */
public interface TRestaurantDetailService extends Service<TRestaurantDetail> {
	List<TRestaurantDetail>   selectTRestaurantDetailByCondition(Map<String,Object> map);

}

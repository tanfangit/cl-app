package com.company.project.service;
import java.util.List;
import java.util.Map;

import com.company.project.core.Service;
import com.company.project.dto.TAccommodationDTO;
import com.company.project.model.TAccommodation;


/**
 * Created by tanfan on 2018/05/14.
 */
public interface TAccommodationService extends Service<TAccommodation> {
	List<TAccommodationDTO>   selectTAccommodationDTOByCondition(Map<String,Object> map);
}

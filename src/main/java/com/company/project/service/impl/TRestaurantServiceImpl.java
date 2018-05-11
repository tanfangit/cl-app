package com.company.project.service.impl;

import com.company.project.dao.TRestaurantMapper;
import com.company.project.dto.TRestaurantDTO;
import com.company.project.model.TRestaurant;
import com.company.project.service.TRestaurantService;
import com.company.project.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;


/**
 * Created by tanfan on 2018/05/11.
 */
@Service
@Transactional
public class TRestaurantServiceImpl extends AbstractService<TRestaurant> implements TRestaurantService {
    @Resource
    private TRestaurantMapper tRestaurantMapper;

	@Override
	public List<TRestaurantDTO> selectTRestaurantDTOByCondition(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return tRestaurantMapper.selectTRestaurantDTOByCondition(map);
	}

}

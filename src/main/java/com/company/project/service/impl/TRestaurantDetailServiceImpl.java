package com.company.project.service.impl;

import com.company.project.dao.TRestaurantDetailMapper;
import com.company.project.model.TRestaurantDetail;
import com.company.project.service.TRestaurantDetailService;
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
public class TRestaurantDetailServiceImpl extends AbstractService<TRestaurantDetail> implements TRestaurantDetailService {
    @Resource
    private TRestaurantDetailMapper tRestaurantDetailMapper;

	@Override
	public List<TRestaurantDetail> selectTRestaurantDetailByCondition(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return tRestaurantDetailMapper.selectTRestaurantDetailByCondition(map);
	}

}

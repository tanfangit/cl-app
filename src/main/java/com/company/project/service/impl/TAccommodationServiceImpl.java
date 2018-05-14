package com.company.project.service.impl;

import com.company.project.dao.TAccommodationMapper;
import com.company.project.dto.TAccommodationDTO;
import com.company.project.model.TAccommodation;
import com.company.project.service.TAccommodationService;
import com.company.project.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;


/**
 * Created by tanfan on 2018/05/14.
 */
@Service
@Transactional
public class TAccommodationServiceImpl extends AbstractService<TAccommodation> implements TAccommodationService {
    @Resource
    private TAccommodationMapper tAccommodationMapper;

	@Override
	public List<TAccommodationDTO> selectTAccommodationDTOByCondition(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return tAccommodationMapper.selectTAccommodationDTOByCondition(map);
	}

}

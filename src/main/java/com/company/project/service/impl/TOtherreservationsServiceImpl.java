package com.company.project.service.impl;

import com.company.project.dao.TOtherreservationsMapper;
import com.company.project.dto.TOtherreservationsDTO;
import com.company.project.model.TOtherreservations;
import com.company.project.model.TOtherreservationsAccommodation;
import com.company.project.service.TOtherreservationsService;
import com.company.project.core.AbstractService;
import com.company.project.core.Result;
import com.company.project.core.ResultGenerator;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;


/**
 * Created by tanfan on 2018/05/15.
 */
@Service
@Transactional
public class TOtherreservationsServiceImpl extends AbstractService<TOtherreservations> implements TOtherreservationsService {
    @Resource
    private TOtherreservationsMapper tOtherreservationsMapper;

	@Override
	public Result signUp(TOtherreservationsDTO tOtherreservationsDTO) {
		// TODO Auto-generated method stub
		/**
		 * 
		 */
		tOtherreservationsMapper.insertTotherReservations(tOtherreservationsDTO);
		for(TOtherreservationsAccommodation tOtherreservationsAccommodation : tOtherreservationsDTO.getAccommodations()) {
			tOtherreservationsAccommodation.setOid(tOtherreservationsDTO.getId());
			tOtherreservationsMapper.insertTotherReservationsAccommodation(tOtherreservationsAccommodation);
		}
		return  ResultGenerator.genSuccessResult();
	}

	@Override
	public Result cancel(Integer id) {
		// TODO Auto-generated method stub
		tOtherreservationsMapper.deleteByPrimaryKey(id);
		tOtherreservationsMapper.deleteTotherReservationsAccommodationByOid(id);
		return ResultGenerator.genSuccessResult();
	}

}

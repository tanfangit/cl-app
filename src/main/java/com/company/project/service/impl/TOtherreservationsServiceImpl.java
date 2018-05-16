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

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
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
		if(tOtherreservationsDTO.getId()!=null) {
			// 要加 预约前 3天不能修改 取消
			Map map = new HashMap();
			map.put("id", tOtherreservationsDTO.getId());
			List<TOtherreservationsDTO> list = tOtherreservationsMapper.selectTOtherreservationsDTOByMap(map);
			if(list.size()>0) {
				Date sdate = list.get(0).getSdate();
				Calendar date = Calendar.getInstance();
				date.setTime(sdate);
				date.set(Calendar.DATE, date.get(Calendar.DATE) - 3);
				if(date.getTime().before(new Date())) {
					return	ResultGenerator.genFailResult("预约开始前3天不能修改");	
				}
			}else {
				return ResultGenerator.genFailResult("请检查参数,修改其它预约失败");	
			}
			
			tOtherreservationsMapper.deleteByPrimaryKey(tOtherreservationsDTO.getId());
			tOtherreservationsMapper.deleteTotherReservationsAccommodationByOid(tOtherreservationsDTO.getId());
		}
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
		// 要加 预约前 3天不能修改 取消
		
			// 要加 预约前 3天不能修改 取消
			Map map = new HashMap();
			map.put("id", id);
			List<TOtherreservationsDTO> list = tOtherreservationsMapper.selectTOtherreservationsDTOByMap(map);
			if(list.size()>0) {
				Date sdate = list.get(0).getSdate();
				Calendar date = Calendar.getInstance();
				date.setTime(sdate);
				date.set(Calendar.DATE, date.get(Calendar.DATE) - 3);
				if(date.getTime().before(new Date())) {
					return ResultGenerator.genFailResult("预约开始前3天不能修改");	
				}
			}else {
				return ResultGenerator.genFailResult("请检查参数,修改其它预约失败");	
			}
		
		tOtherreservationsMapper.deleteByPrimaryKey(id);
		tOtherreservationsMapper.deleteTotherReservationsAccommodationByOid(id);
		return ResultGenerator.genSuccessResult();
	}

	@Override
	public List<TOtherreservationsDTO> selectTOtherreservationsDTOByMap(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return tOtherreservationsMapper.selectTOtherreservationsDTOByMap(map);
	}

}

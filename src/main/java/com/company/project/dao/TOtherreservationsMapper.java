package com.company.project.dao;

import java.util.List;
import java.util.Map;

import com.company.project.core.Mapper;
import com.company.project.dto.TOtherreservationsDTO;
import com.company.project.model.TOtherreservations;
import com.company.project.model.TOtherreservationsAccommodation;

public interface TOtherreservationsMapper extends Mapper<TOtherreservations> {
	/*其它预约报名*/
	int insertTotherReservations(TOtherreservationsDTO tOtherreservationsDTO);
	/*其它预约 住宿*/
	int insertTotherReservationsAccommodation(TOtherreservationsAccommodation tOtherreservationsAccommodation);
	
	int deleteTotherReservationsAccommodationByOid(Integer oid);
	
	List<TOtherreservationsDTO> selectTOtherreservationsDTOByMap(Map<String,Object> map);
	
}
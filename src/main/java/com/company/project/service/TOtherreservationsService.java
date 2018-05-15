package com.company.project.service;
import com.company.project.model.TOtherreservations;
import com.company.project.model.TOtherreservationsAccommodation;

import java.util.List;
import java.util.Map;

import com.company.project.core.Result;
import com.company.project.core.Service;
import com.company.project.dto.TOtherreservationsDTO;


/**
 * Created by tanfan on 2018/05/15.
 */
public interface TOtherreservationsService extends Service<TOtherreservations> {
	 /*其它预约 报名*/
	 Result signUp(TOtherreservationsDTO tOtherreservationsDTO);
	 /*其它预约取消报名*/
	 Result cancel(Integer id);
}

package com.company.project.service;
import com.company.project.model.TExperienceDetail;

import java.util.List;
import java.util.Map;

import com.company.project.core.Service;


/**
 * Created by tanfan on 2018/05/11.
 */
public interface TExperienceDetailService extends Service<TExperienceDetail> {
	List<TExperienceDetail> selectTExperienceDetailByMap(Map<String,Object> map);

}

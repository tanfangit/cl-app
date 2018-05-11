package com.company.project.service;
import java.util.List;
import java.util.Map;

import com.company.project.core.Service;
import com.company.project.dto.TExperienceDTO;
import com.company.project.model.TExperience;


/**
 * Created by tanfan on 2018/05/11.
 */
public interface TExperienceService extends Service<TExperience> {
	List<TExperienceDTO>   selectTExperienceDTOByCondition(Map<String,Object> map);
}

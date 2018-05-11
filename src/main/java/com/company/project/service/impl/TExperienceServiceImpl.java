package com.company.project.service.impl;

import com.company.project.dao.TExperienceMapper;
import com.company.project.dto.TExperienceDTO;
import com.company.project.model.TExperience;
import com.company.project.service.TExperienceService;
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
public class TExperienceServiceImpl extends AbstractService<TExperience> implements TExperienceService {
    @Resource
    private TExperienceMapper tExperienceMapper;

	@Override
	public List<TExperienceDTO> selectTExperienceDTOByCondition(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return tExperienceMapper.selectTExperienceDTOByCondition(map);
	}

}

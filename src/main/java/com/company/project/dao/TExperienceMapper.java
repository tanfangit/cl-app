package com.company.project.dao;

import java.util.List;
import java.util.Map;

import com.company.project.core.Mapper;
import com.company.project.dto.TExperienceDTO;
import com.company.project.model.TExperience;

public interface TExperienceMapper extends Mapper<TExperience> {
	List<TExperienceDTO>   selectTExperienceDTOByCondition(Map<String,Object> map);
}
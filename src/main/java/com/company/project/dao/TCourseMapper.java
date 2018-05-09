package com.company.project.dao;

import java.util.List;
import java.util.Map;

import com.company.project.core.Mapper;
import com.company.project.dto.TCourseDTO;
import com.company.project.model.TCourse;

public interface TCourseMapper extends Mapper<TCourse> {
	List<TCourseDTO> selectTCourseByCondition(Map<String,Object> map);
}
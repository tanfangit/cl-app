package com.company.project.dao;

import java.util.List;
import java.util.Map;

import com.company.project.core.Mapper;
import com.company.project.model.TTeacher;

public interface TTeacherMapper extends Mapper<TTeacher> {
	 List<TTeacher>  selectTTeacherByCondition(Map<String,Object> map);
}
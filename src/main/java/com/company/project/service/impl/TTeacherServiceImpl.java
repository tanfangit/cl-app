package com.company.project.service.impl;

import com.company.project.dao.TTeacherMapper;
import com.company.project.model.TTeacher;
import com.company.project.service.TTeacherService;
import com.company.project.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;


/**
 * Created by tanfan on 2018/05/09.
 */
@Service
@Transactional
public class TTeacherServiceImpl extends AbstractService<TTeacher> implements TTeacherService {
    @Resource
    private TTeacherMapper tTeacherMapper;

	@Override
	public List<TTeacher> selectTTeacherByCondition(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return tTeacherMapper.selectTTeacherByCondition(map);
	}

}

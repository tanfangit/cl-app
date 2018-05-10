package com.company.project.service.impl;

import com.company.project.dao.TCourseMapper;
import com.company.project.dto.TCourseDTO;
import com.company.project.dto.TCourseDetailDTO;
import com.company.project.model.TCourse;
import com.company.project.service.TCourseService;
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
public class TCourseServiceImpl extends AbstractService<TCourse> implements TCourseService {
    @Resource
    private TCourseMapper tCourseMapper;

	@Override
	public List<TCourseDTO> selectTCourseByCondition(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return tCourseMapper.selectTCourseByCondition(map);
	}

	@Override
	public TCourseDetailDTO selectTCourseDetailByCondition(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return tCourseMapper.selectTCourseDetailByCondition(map);
	}

}

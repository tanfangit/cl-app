package com.company.project.service.impl;

import com.company.project.dao.TExperienceDetailMapper;
import com.company.project.model.TExperienceDetail;
import com.company.project.service.TExperienceDetailService;
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
public class TExperienceDetailServiceImpl extends AbstractService<TExperienceDetail> implements TExperienceDetailService {
    @Resource
    private TExperienceDetailMapper tExperienceDetailMapper;

	@Override
	public List<TExperienceDetail> selectTExperienceDetailByMap(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return tExperienceDetailMapper.selectTExperienceDetailByMap(map);
	}

}

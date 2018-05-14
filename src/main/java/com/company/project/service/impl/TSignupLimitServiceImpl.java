package com.company.project.service.impl;

import com.company.project.dao.TSignupLimitMapper;
import com.company.project.model.TSignupLimit;
import com.company.project.service.TSignupLimitService;
import com.company.project.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;


/**
 * Created by tanfan on 2018/05/14.
 */
@Service
@Transactional
public class TSignupLimitServiceImpl extends AbstractService<TSignupLimit> implements TSignupLimitService {
    @Resource
    private TSignupLimitMapper tSignupLimitMapper;

	@Override
	public List<TSignupLimit> selectTSignupLimitByMap(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return tSignupLimitMapper.selectTSignupLimitByMap(map);
	}

}

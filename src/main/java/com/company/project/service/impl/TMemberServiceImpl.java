package com.company.project.service.impl;

import com.company.project.dao.TMemberMapper;
import com.company.project.model.TMember;
import com.company.project.service.TMemberService;
import com.company.project.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

import javax.annotation.Resource;


/**
 * Created by tanfan on 2018/05/14.
 */
@Service
@Transactional
public class TMemberServiceImpl extends AbstractService<TMember> implements TMemberService {
    @Resource
    private TMemberMapper tMemberMapper;

	@Override
	public int insertTMemberByTMember(TMember tMember) {
		// TODO Auto-generated method stub
		return tMemberMapper.insertTMemberByTMember(tMember);
	}

	@Override
	public int updateTMemberByTMember(TMember tMember) {
		// TODO Auto-generated method stub
		return tMemberMapper.updateTMemberByTMember(tMember);
	}

	@Override
	public TMember selectTMemberByMap(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return tMemberMapper.selectTMemberByMap(map);
	}

	@Override
	public int deleteTMemberByMap(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return tMemberMapper.deleteTMemberByMap(map);
	}

}

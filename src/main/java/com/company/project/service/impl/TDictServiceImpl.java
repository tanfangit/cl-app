package com.company.project.service.impl;

import com.company.project.dao.TDictMapper;
import com.company.project.model.TDict;
import com.company.project.service.TDictService;
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
public class TDictServiceImpl extends AbstractService<TDict> implements TDictService {
    @Resource
    private TDictMapper tDictMapper;

	@Override
	public List<TDict> selectTDictByCondition(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return tDictMapper.selectTDictByCondition(map);
	}

	@Override
	public int selectCountTDictByMap(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return tDictMapper.selectCountTDictByMap(map);
	}

	@Override
	public int deleteCountTDict(TDict tDict) {
		// TODO Auto-generated method stub
		return tDictMapper.deleteCountTDict(tDict);
	}

	@Override
	public int insertCountTDict(TDict tDict) {
		// TODO Auto-generated method stub
		return tDictMapper.insertCountTDict(tDict);
	}

	@Override
	public int updateCountTDict(TDict tDict) {
		// TODO Auto-generated method stub
		return tDictMapper.updateCountTDict(tDict);
	}

}

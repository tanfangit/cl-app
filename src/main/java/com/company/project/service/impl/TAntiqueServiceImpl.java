package com.company.project.service.impl;

import com.company.project.dao.TAntiqueMapper;
import com.company.project.dto.TantiqueDTO;
import com.company.project.model.TAntique;
import com.company.project.service.TAntiqueService;
import com.company.project.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;


/**
 * Created by tanfan on 2018/05/10.
 */
@Service
@Transactional
public class TAntiqueServiceImpl extends AbstractService<TAntique> implements TAntiqueService {
    @Resource
    private TAntiqueMapper tAntiqueMapper;

	@Override
	public List<TantiqueDTO> selectTAntiqueByCondition(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return tAntiqueMapper.selectTAntiqueByCondition(map);
	}

}

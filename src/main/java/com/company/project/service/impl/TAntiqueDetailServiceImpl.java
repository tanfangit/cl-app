package com.company.project.service.impl;

import com.company.project.dao.TAntiqueDetailMapper;
import com.company.project.dto.TAntiqueDetailDTO;
import com.company.project.model.TAntiqueDetail;
import com.company.project.service.TAntiqueDetailService;
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
public class TAntiqueDetailServiceImpl extends AbstractService<TAntiqueDetail> implements TAntiqueDetailService {
    @Resource
    private TAntiqueDetailMapper tAntiqueDetailMapper;

	@Override
	public List<TAntiqueDetailDTO> selectTAntiqueDetailByCondition(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return tAntiqueDetailMapper.selectTAntiqueDetailByCondition(map);
	}

}

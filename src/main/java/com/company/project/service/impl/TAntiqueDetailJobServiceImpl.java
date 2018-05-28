package com.company.project.service.impl;

import com.company.project.dao.TAntiqueDetailJobMapper;
import com.company.project.model.TAntiqueDetailJob;
import com.company.project.service.TAntiqueDetailJobService;
import com.company.project.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by tanfan on 2018/05/28.
 */
@Service
@Transactional
public class TAntiqueDetailJobServiceImpl extends AbstractService<TAntiqueDetailJob> implements TAntiqueDetailJobService {
    @Resource
    private TAntiqueDetailJobMapper tAntiqueDetailJobMapper;

	@Override
	public TAntiqueDetailJob selectMaxTimeTAntiqueDetailJobByType(int type) {
		// TODO Auto-generated method stub
		return tAntiqueDetailJobMapper.selectMaxTimeTAntiqueDetailJobByType(type);
	}

}

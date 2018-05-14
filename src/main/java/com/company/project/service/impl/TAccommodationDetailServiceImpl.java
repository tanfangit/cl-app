package com.company.project.service.impl;

import com.company.project.dao.TAccommodationDetailMapper;
import com.company.project.model.TAccommodationDetail;
import com.company.project.service.TAccommodationDetailService;
import com.company.project.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by tanfan on 2018/05/14.
 */
@Service
@Transactional
public class TAccommodationDetailServiceImpl extends AbstractService<TAccommodationDetail> implements TAccommodationDetailService {
    @Resource
    private TAccommodationDetailMapper tAccommodationDetailMapper;

}

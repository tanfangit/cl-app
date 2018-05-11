package com.company.project.service.impl;

import com.company.project.dao.TAntiqueTypeMapper;
import com.company.project.model.TAntiqueType;
import com.company.project.service.TAntiqueTypeService;
import com.company.project.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by tanfan on 2018/05/11.
 */
@Service
@Transactional
public class TAntiqueTypeServiceImpl extends AbstractService<TAntiqueType> implements TAntiqueTypeService {
    @Resource
    private TAntiqueTypeMapper tAntiqueTypeMapper;

}

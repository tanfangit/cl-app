package com.company.project.service.impl;

import com.company.project.dao.TAntiqueSourceMapper;
import com.company.project.model.TAntiqueSource;
import com.company.project.service.TAntiqueSourceService;
import com.company.project.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by tanfan on 2018/05/11.
 */
@Service
@Transactional
public class TAntiqueSourceServiceImpl extends AbstractService<TAntiqueSource> implements TAntiqueSourceService {
    @Resource
    private TAntiqueSourceMapper tAntiqueSourceMapper;

}

package com.company.project.service.impl;

import com.company.project.dao.TCourseTypeMapper;
import com.company.project.model.TCourseType;
import com.company.project.service.TCourseTypeService;
import com.company.project.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by tanfan on 2018/05/09.
 */
@Service
@Transactional
public class TCourseTypeServiceImpl extends AbstractService<TCourseType> implements TCourseTypeService {
    @Resource
    private TCourseTypeMapper tCourseTypeMapper;

}

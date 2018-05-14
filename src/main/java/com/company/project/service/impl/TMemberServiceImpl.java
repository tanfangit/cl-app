package com.company.project.service.impl;

import com.company.project.dao.TMemberMapper;
import com.company.project.model.TMember;
import com.company.project.service.TMemberService;
import com.company.project.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by tanfan on 2018/05/14.
 */
@Service
@Transactional
public class TMemberServiceImpl extends AbstractService<TMember> implements TMemberService {
    @Resource
    private TMemberMapper tMemberMapper;

}

package com.company.project.service.impl;

import com.company.project.dao.TArticleMapper;
import com.company.project.model.TArticle;
import com.company.project.service.TArticleService;
import com.company.project.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by tanfan on 2018/05/10.
 */
@Service
@Transactional
public class TArticleServiceImpl extends AbstractService<TArticle> implements TArticleService {
    @Resource
    private TArticleMapper tArticleMapper;

}

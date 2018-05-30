package com.company.project.service;
import com.company.project.model.TArticle;

import java.util.List;
import java.util.Map;

import com.company.project.core.Service;


/**
 * Created by tanfan on 2018/05/10.
 */
public interface TArticleService extends Service<TArticle> {
     List<TArticle> selectTArticleByMap(Map<String,Object> map);
     
     /*新增查首页banner**/
     List<Map> selectpagehomebanner(Map<String,Object> map);
} 

package com.company.project.dao;

import java.util.List;
import java.util.Map;

import com.company.project.core.Mapper;
import com.company.project.model.TArticle;

public interface TArticleMapper extends Mapper<TArticle> {
	List<TArticle> selectTArticleByMap(Map<String,Object> map);
    /*新增查首页banner**/
    List<Map> selectpagehomebanner(Map<String,Object> map);
}
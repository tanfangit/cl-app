package com.company.project.dao;

import java.util.List;
import java.util.Map;

import com.company.project.core.Mapper;
import com.company.project.dto.TCourseCollectionsDTO;
import com.company.project.model.TCollections;

public interface TCollectionsMapper extends Mapper<TCollections> {
    /*查询课程收藏列表*/
	 List<TCourseCollectionsDTO> selectTCourseCollectionsDTOByMap(Map<String,Object> map);
}
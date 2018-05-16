package com.company.project.service;
import com.company.project.model.TCollections;

import java.util.List;
import java.util.Map;

import com.company.project.core.Service;
import com.company.project.dto.TCourseCollectionsDTO;


/**
 * Created by tanfan on 2018/05/16.
 */
public interface TCollectionsService extends Service<TCollections> {
     /*查询课程收藏列表*/
	 List<TCourseCollectionsDTO> selectTCourseCollectionsDTOByMap(Map<String,Object> map);
}

package com.company.project.dao;

import java.util.List;
import java.util.Map;

import com.company.project.core.Mapper;
import com.company.project.dto.TAccommodationCollectionsDTO;
import com.company.project.dto.TCourseCollectionsDTO;
import com.company.project.dto.TExperienceCollectionsDTO;
import com.company.project.dto.TRestauratCollectionsDTO;
import com.company.project.dto.TantiqueCollectionsDTO;
import com.company.project.model.TCollections;

public interface TCollectionsMapper extends Mapper<TCollections> {
    /*查询课程收藏列表*/
	 List<TCourseCollectionsDTO> selectTCourseCollectionsDTOByMap(Map<String,Object> map);
	 /*查询文玩收藏列表*/
	 List<TantiqueCollectionsDTO> selectTantiqueCollectionsDTOByMap(Map<String,Object> map);
	 /*查询体验项目收藏列表*/
	 List<TExperienceCollectionsDTO> selectTExperienceCollectionsDTOByMap(Map<String,Object> map);
	 /*查询餐饮菜品收藏列表*/
	 List<TRestauratCollectionsDTO> selectTRestauratCollectionsDTOByMap(Map<String,Object> map);
	 /*查询住宿房型收藏列表*/
	 List<TAccommodationCollectionsDTO> selectTAccommodationCollectionsDTOByMap(Map<String,Object> map); 
}
package com.company.project.service.impl;

import com.company.project.dao.TCollectionsMapper;
import com.company.project.dto.TAccommodationCollectionsDTO;
import com.company.project.dto.TCourseCollectionsDTO;
import com.company.project.dto.TExperienceCollectionsDTO;
import com.company.project.dto.TRestauratCollectionsDTO;
import com.company.project.dto.TantiqueCollectionsDTO;
import com.company.project.model.TCollections;
import com.company.project.service.TCollectionsService;
import com.company.project.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;


/**
 * Created by tanfan on 2018/05/16.
 */
@Service
@Transactional
public class TCollectionsServiceImpl extends AbstractService<TCollections> implements TCollectionsService {
    @Resource
    private TCollectionsMapper tCollectionsMapper;

	@Override
	public List<TCourseCollectionsDTO> selectTCourseCollectionsDTOByMap(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return tCollectionsMapper.selectTCourseCollectionsDTOByMap(map);
	}

	@Override
	public List<TantiqueCollectionsDTO> selectTantiqueCollectionsDTOByMap(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return tCollectionsMapper.selectTantiqueCollectionsDTOByMap(map);
	}

	@Override
	public List<TExperienceCollectionsDTO> selectTExperienceCollectionsDTOByMap(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return tCollectionsMapper.selectTExperienceCollectionsDTOByMap(map);
	}

	@Override
	public List<TRestauratCollectionsDTO> selectTRestauratCollectionsDTOByMap(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return tCollectionsMapper.selectTRestauratCollectionsDTOByMap(map);
	}

	@Override
	public List<TAccommodationCollectionsDTO> selectTAccommodationCollectionsDTOByMap(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return tCollectionsMapper.selectTAccommodationCollectionsDTOByMap(map);
	}

}

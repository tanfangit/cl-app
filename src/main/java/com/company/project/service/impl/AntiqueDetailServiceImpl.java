package com.company.project.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.company.project.dao.TAntiqueDetailMapper;
import com.company.project.dto.AntiqueDetailDTO;
import com.company.project.service.AntiqueDetailService;
/**
 * Created by tanfan on 2018/05/29.
 */
@Service
@Transactional
public class AntiqueDetailServiceImpl implements AntiqueDetailService {
	@Resource
	private TAntiqueDetailMapper tAntiqueDetailMapper;
	@Override
	public int selectCountAntiqueDetailDTO(AntiqueDetailDTO antiqueDetailDTO) {
		// TODO Auto-generated method stub
		return tAntiqueDetailMapper.selectCountAntiqueDetailDTO(antiqueDetailDTO);
	}

	@Override
	public int deleteCountAntiqueDetailDTO(AntiqueDetailDTO antiqueDetailDTO) {
		// TODO Auto-generated method stub
		return tAntiqueDetailMapper.deleteCountAntiqueDetailDTO(antiqueDetailDTO);
	}

	@Override
	public int updateCountAntiqueDetailDTO(AntiqueDetailDTO antiqueDetailDTO) {
		// TODO Auto-generated method stub
		return tAntiqueDetailMapper.updateCountAntiqueDetailDTO(antiqueDetailDTO);
	}

	@Override
	public int insertCountAntiqueDetailDTO(AntiqueDetailDTO antiqueDetailDTO) {
		// TODO Auto-generated method stub
		return tAntiqueDetailMapper.insertCountAntiqueDetailDTO(antiqueDetailDTO);
	}

}

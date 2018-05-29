package com.company.project.dao;

import java.util.List;
import java.util.Map;

import com.company.project.core.Mapper;
import com.company.project.dto.AntiqueDetailDTO;
import com.company.project.dto.TAntiqueDetailDTO;
import com.company.project.model.TAntiqueDetail;

public interface TAntiqueDetailMapper extends Mapper<TAntiqueDetail> {
	 List<TAntiqueDetailDTO>   selectTAntiqueDetailByCondition(Map<String,Object> map);
	 
	 	/*查询是否存在*/
		int selectCountAntiqueDetailDTO(AntiqueDetailDTO antiqueDetailDTO);
		/*删除*/
		int deleteCountAntiqueDetailDTO(AntiqueDetailDTO antiqueDetailDTO);
		/*更新*/
		int updateCountAntiqueDetailDTO(AntiqueDetailDTO antiqueDetailDTO);
		/*新增*/
		int insertCountAntiqueDetailDTO(AntiqueDetailDTO antiqueDetailDTO);
	 
}
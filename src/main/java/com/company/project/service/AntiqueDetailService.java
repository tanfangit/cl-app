package com.company.project.service;

import com.company.project.dto.AntiqueDetailDTO;

public interface AntiqueDetailService {
	/*查询是否存在*/
	int selectCountAntiqueDetailDTO(AntiqueDetailDTO antiqueDetailDTO);
	/*删除*/
	int deleteCountAntiqueDetailDTO(AntiqueDetailDTO antiqueDetailDTO);
	/*更新*/
	int updateCountAntiqueDetailDTO(AntiqueDetailDTO antiqueDetailDTO);
	/*新增*/
	int insertCountAntiqueDetailDTO(AntiqueDetailDTO antiqueDetailDTO);
}

package com.company.project.service;
import java.util.List;
import java.util.Map;

import com.company.project.core.Service;
import com.company.project.dto.TAntiqueDetailDTO;
import com.company.project.model.TAntiqueDetail;


/**
 * Created by tanfan on 2018/05/10.
 */
public interface TAntiqueDetailService extends Service<TAntiqueDetail> {
	 List<TAntiqueDetailDTO>   selectTAntiqueDetailByCondition(Map<String,Object> map);
}

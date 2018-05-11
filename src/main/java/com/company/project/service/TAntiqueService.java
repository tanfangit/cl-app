package com.company.project.service;
import java.util.List;
import java.util.Map;

import com.company.project.core.Service;
import com.company.project.dto.TantiqueDTO;
import com.company.project.model.TAntique;


/**
 * Created by tanfan on 2018/05/10.
 */
public interface TAntiqueService extends Service<TAntique> {
   List<TantiqueDTO>   selectTAntiqueByCondition(Map<String,Object> map);
}

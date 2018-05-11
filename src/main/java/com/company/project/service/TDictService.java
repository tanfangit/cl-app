package com.company.project.service;
import java.util.List;
import java.util.Map;

import com.company.project.core.Service;
import com.company.project.model.TDict;


/**
 * Created by tanfan on 2018/05/11.
 */
public interface TDictService extends Service<TDict> {
	List<TDict>   selectTDictByCondition(Map<String,Object> map);
}

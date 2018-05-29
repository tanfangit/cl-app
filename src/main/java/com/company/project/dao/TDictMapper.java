package com.company.project.dao;

import java.util.List;
import java.util.Map;

import com.company.project.core.Mapper;
import com.company.project.model.TDict;

public interface TDictMapper extends Mapper<TDict> {
	List<TDict>   selectTDictByCondition(Map<String,Object> map);
	/*查询字典是否存在*/
	int selectCountTDictByMap(Map<String,Object> map);
	/*删除字典*/
	int deleteCountTDict(TDict tDict);
	/*新增字典*/
	int insertCountTDict(TDict tDict);
	/*更新字典*/
	int updateCountTDict(TDict tDict);
}
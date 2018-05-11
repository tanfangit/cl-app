package com.company.project.service;
import com.company.project.model.TTeacher;

import java.util.List;
import java.util.Map;

import com.company.project.core.Service;


/**
 * Created by tanfan on 2018/05/09.
 */
public interface TTeacherService extends Service<TTeacher> {
    List<TTeacher>  selectTTeacherByCondition(Map<String,Object> map);
}

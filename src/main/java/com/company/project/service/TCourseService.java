package com.company.project.service;
import com.company.project.model.TCourse;

import java.util.List;
import java.util.Map;

import com.company.project.core.Service;
import com.company.project.dto.TCourseDTO;


/**
 * Created by tanfan on 2018/05/09.
 */
public interface TCourseService extends Service<TCourse> {
    List<TCourseDTO> selectTCourseByCondition(Map<String,Object> map);
}

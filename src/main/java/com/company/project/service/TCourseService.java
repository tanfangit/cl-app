package com.company.project.service;
import java.util.List;
import java.util.Map;

import com.company.project.core.Service;
import com.company.project.dto.TCourseDTO;
import com.company.project.dto.TCourseDetailDTO;
import com.company.project.model.TCourse;


/**
 * Created by tanfan on 2018/05/09.
 */
public interface TCourseService extends Service<TCourse> {
    List<TCourseDTO> selectTCourseByCondition(Map<String,Object> map);
    
    TCourseDetailDTO selectTCourseDetailByCondition(Map<String,Object> map);
}

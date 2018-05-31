package com.company.project.service;
import java.util.List;
import java.util.Map;

import com.company.project.core.Result;
import com.company.project.core.Service;
import com.company.project.dto.CourseMsgDTO;
import com.company.project.dto.TCourseDTO;
import com.company.project.dto.TCourseDetailDTO;
import com.company.project.dto.TCourseSignUpDTO;
import com.company.project.model.CourseReservation;
import com.company.project.model.CourseReservationDelete;
import com.company.project.model.TCourse;


/**
 * Created by tanfan on 2018/05/09.
 */
public interface TCourseService extends Service<TCourse> {
    List<TCourseDTO> selectTCourseByCondition(Map<String,Object> map);
    
    TCourseDetailDTO selectTCourseDetailByCondition(Map<String,Object> map);
    /* 预约课程 加 报名人数**/ 
    int updateTCourseACountByCondition(Map<String,Integer> map); 
    /* 课程预约 及取消*/
    Result tCourseOperation(Map<String,Integer> map);
    /* 查询报名信息  报名用*/
    CourseReservation selectCourseReservation(Map<String,Integer> map);
    /* 查询取消报名信息  取消报名用*/
    CourseReservationDelete selectCourseReservationDelete(Map<String,Integer> map);
    
    List<TCourseSignUpDTO> selectTCourseSignUpDTOByMap(Map<String,Object> map);
    
    /* 获取会员预约课程3天前的提醒消息**/
    List<CourseMsgDTO> selectCourseMsgDTOByThreeDay(Map<String,Object> map);
    /* 获取会员预约课程1天前的提醒消息**/
    List<CourseMsgDTO> selectCourseMsgDTOByOneDay(Map<String,Object> map);
    
    /*插入短信发送记录 避免重复发送短信*/
    int insertCoursereservationMsg(Map<String,Object> map);
}

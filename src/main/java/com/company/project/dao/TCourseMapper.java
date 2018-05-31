package com.company.project.dao;

import java.util.List;
import java.util.Map;

import com.company.project.core.Mapper;
import com.company.project.dto.CourseMsgDTO;
import com.company.project.dto.TCourseDTO;
import com.company.project.dto.TCourseDetailDTO;
import com.company.project.dto.TCourseSignUpDTO;
import com.company.project.model.CourseReservation;
import com.company.project.model.CourseReservationDelete;
import com.company.project.model.TCourse;

public interface TCourseMapper extends Mapper<TCourse> {
	List<TCourseDTO> selectTCourseByCondition(Map<String,Object> map);
	
	TCourseDetailDTO selectTCourseDetailByCondition(Map<String,Object> map);
	 /* 预约课程 加 报名人数**/ 
    int updateTCourseACountByCondition(Map<String,Integer> map); 
	/* 报名*/
	int insertTcourseReservation(CourseReservation courseReservation);
	
	 /* 查询报名信息  报名用*/
    CourseReservation selectCourseReservation(Map<String,Integer> map);
    /* 取消报名*/
    int deleteTcourseReservation(Map<String,Integer> map);
    /* 插入取消报名表*/
	int insertTcourseReservationDelete(Map<String,Object> map);
    /*
     	查询取消报名信息  取消报名用
    CourseReservationDelete selectCourseReservationDelete(Map<String,Integer> map);*/
	
	List<TCourseSignUpDTO> selectTCourseSignUpDTOByMap(Map<String,Object> map);
	
    /* 获取会员预约课程3天前的提醒消息**/
    List<CourseMsgDTO> selectCourseMsgDTOByThreeDay(Map<String,Object> map);
    /* 获取会员预约课程1天前的提醒消息**/
    List<CourseMsgDTO> selectCourseMsgDTOByOneDay(Map<String,Object> map);
}
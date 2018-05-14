package com.company.project.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.company.project.core.AbstractService;
import com.company.project.core.Result;
import com.company.project.core.ResultGenerator;
import com.company.project.dao.TCourseMapper;
import com.company.project.dto.TCourseDTO;
import com.company.project.dto.TCourseDetailDTO;
import com.company.project.model.CourseReservation;
import com.company.project.model.CourseReservationDelete;
import com.company.project.model.TCourse;
import com.company.project.model.TMember;
import com.company.project.model.TSignupLimit;
import com.company.project.service.TCourseService;
import com.company.project.service.TMemberService;
import com.company.project.service.TSignupLimitService;
import com.company.project.util.DateUtil;


/**
 * Created by tanfan on 2018/05/09.
 */
@Service
@Transactional
public class TCourseServiceImpl extends AbstractService<TCourse> implements TCourseService {
    @Resource
    private TCourseMapper tCourseMapper;
    @Resource
    private TMemberService tMemberService;
    @Resource
    private TSignupLimitService tSignupLimitService;
	@Override
	public List<TCourseDTO> selectTCourseByCondition(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return tCourseMapper.selectTCourseByCondition(map);
	}

	@Override
	public TCourseDetailDTO selectTCourseDetailByCondition(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return tCourseMapper.selectTCourseDetailByCondition(map);
	}

	@Override
	public Result tCourseOperation(Map<String, Integer> map) {
		// TODO Auto-generated method stub
		int type= map.get("type");
		int cid=  map.get("cid");
		int mid=  map.get("mid");
		if(type == 1) {
			// 预约  1.查询课程信息 判断是否在开课之前 2.查看会员是否存在 3.是否有报名名额 4.是否已报名 
			TCourse tCourse = this.findById(cid);
			if(tCourse == null) {
				return ResultGenerator.genFailResult("预约课程不存在");
			}
			TMember tMember = tMemberService.findById(mid);
			if(tMember == null) {
				return ResultGenerator.genFailResult("会员不存在");
			}
			if(tCourse.getStime().before(new Date())) {
				return ResultGenerator.genFailResult("课程报名时间已过");
			}
			if(tCourse.getAcount()>= tCourse.getCount()) {
				return ResultGenerator.genFailResult("课程报名人数已满");
			}
			if(this.selectCourseReservation(map)!=null) {
				return ResultGenerator.genFailResult("请不要重复报名");
			}
			// 预约限制 关联后台[预约限制]，开课时间在[预约限制]内的日期无法报名，提示“管理员已取消该日期内的报名”
			Map mapS = new HashMap();
			mapS.put("mtype", map.get("mtype"));
			mapS.put("type", 1);
			List<TSignupLimit> tSignupLimitList = tSignupLimitService.selectTSignupLimitByMap(mapS);
			for(TSignupLimit tSignupLimit:tSignupLimitList) {
				// 判断当前时间 是否在预约限制时间范围内
				if(DateUtil.isTimeInNow(tSignupLimit.getsTime(),tSignupLimit.getEndTime())) {
					return ResultGenerator.genFailResult("管理员已取消该日期内的报名");
				}
			}
			// 开始报名 
			map.put("ctype", 1);
			if(this.updateTCourseACountByCondition(map)>0) {
				if(tCourseMapper.insertTcourseReservation(map)>0) {
					return  ResultGenerator.genSuccessResult();
				}else{
					return ResultGenerator.genFailResult("报名失败,请稍后再试");
				}
			}else {
				return ResultGenerator.genFailResult("报名失败,请稍后再试");
			}
		}else if(type == 2){
			// 取消预约 1.是否已报名 2.查询课程信息 是否在开课之前 3.会员是否存在
			TCourse tCourse = this.findById(cid);
			if(tCourse == null) {
				return ResultGenerator.genFailResult("预约课程不存在");
			}
			TMember tMember = tMemberService.findById(mid);
			if(tMember == null) {
				return ResultGenerator.genFailResult("会员不存在");
			}
			CourseReservation courseReservation = this.selectCourseReservation(map);
			if( courseReservation == null) {
				return ResultGenerator.genFailResult("取消报名失败,查不到报名信息");
			}
			// 开始取消报名 
			map.put("ctype", 2);
			if(this.updateTCourseACountByCondition(map)>0) {
				if(tCourseMapper.deleteTcourseReservation(map)>0) {
					Map mapTmp = new HashMap<String,Object>();
					mapTmp.putAll(map);
					mapTmp.put("crateTime", courseReservation.getCrateTime());
					int day = DateUtil.daysBetween(new Date(), tCourse.getStime());
					mapTmp.put("day", day);
					tCourseMapper.insertTcourseReservationDelete(mapTmp);
					return  ResultGenerator.genSuccessResult();
				}else{
					return ResultGenerator.genFailResult("取消报名失败,请稍后再试");
				}
			}else {
				return ResultGenerator.genFailResult("报名失败,请稍后再试");
			}
			
			
			
		}else {
			return ResultGenerator.genFailResult("操作失败,请检查参数");
		}
	}

	@Override
	public CourseReservation selectCourseReservation(Map<String, Integer> map) {
		// TODO Auto-generated method stub
		return tCourseMapper.selectCourseReservation(map);
	}

	@Override
	public CourseReservationDelete selectCourseReservationDelete(Map<String, Integer> map) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateTCourseACountByCondition(Map<String, Integer> map) {
		// TODO Auto-generated method stub
		return tCourseMapper.updateTCourseACountByCondition(map);
	}

}

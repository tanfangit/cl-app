package com.company.project.timer;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.company.project.dto.CourseMsgDTO;
import com.company.project.service.TCourseService;
import com.company.project.util.SmsUtil;

@Component
public class SendMsgTask {
	Log log = LogFactory.getLog(SendMsgTask.class);
	@Autowired
	private TCourseService tCourseService;
	@Scheduled(cron = "0 0/2 * * * ?")
    public void execute() {
    	//getAccessToken();
		CourseMsgByThreeDay();
		CourseMsgByOneDay();
    }
	public void CourseMsgByThreeDay() {
		Map map = new HashMap();
		map.put("sendPhone", "1");
		String phone="";
		int cId =0;
		int mId =0;
		int type=1;
		String context="";
		List<CourseMsgDTO> list =  tCourseService.selectCourseMsgDTOByThreeDay(map);
		for(CourseMsgDTO courseMsgDTO : list) {
			context ="您预定的课程【"+courseMsgDTO.getCname()+"】将在三天后开始了;请您准时参与";
			phone = courseMsgDTO.getPhone();
			cId = courseMsgDTO.getCid();
			mId = courseMsgDTO.getMid();
			if(SmsUtil.sendSmsByContext(context, phone)) {
				map.put("cId", cId);
				map.put("mId", mId);
				map.put("type", 1);
				map.put("context", context);
				tCourseService.insertCoursereservationMsg(map);
			}
		}
	}
	public void CourseMsgByOneDay() {
		Map map = new HashMap();
		map.put("sendPhone", "1");
		String phone="";
		int cId =0;
		int mId =0;
		 
		String context="";
		List<CourseMsgDTO> list =  tCourseService.selectCourseMsgDTOByOneDay(map);
		for(CourseMsgDTO courseMsgDTO : list) {
			context ="您预定的课程【"+courseMsgDTO.getCname()+"】将在一天后开始了;请您准时参与";
			phone = courseMsgDTO.getPhone();
			cId = courseMsgDTO.getCid();
			mId = courseMsgDTO.getMid();
			if(SmsUtil.sendSmsByContext(context, phone)) {
				map.put("cId", cId);
				map.put("mId", mId);
				map.put("type", 2);
				map.put("context", context);
				tCourseService.insertCoursereservationMsg(map);
			}
		}
	}
}

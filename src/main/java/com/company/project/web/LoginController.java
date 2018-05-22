package com.company.project.web;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ane.mspf.smsClient.SmsClientUtil;
import com.company.project.core.Result;
import com.company.project.core.ResultGenerator;
import com.company.project.model.TMember;
import com.company.project.service.TMemberService;
import com.company.project.util.DateUtil;
import com.company.project.util.SmsUtil;
import com.company.project.util.StringUtils;

@RestController
@RequestMapping("/login")
public class LoginController {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	@Resource
	private TMemberService tMemberService;
	@PostMapping("/getCaptcha")
    public Result getCaptcha(@RequestParam String phone) {
		
         String captcha = StringUtils.getCheckCode(6);
         
         if(SmsUtil.sendSmsByCaptcha(captcha, phone)) {
        	 //查询phone 是否注册
        	 Map map = new HashMap();
        	 map.put("phone", phone);
        	 TMember tMember = tMemberService.selectTMemberByMap(map);
        	 TMember tmpMember = new TMember ();
    		 tmpMember.setPhone(phone);
    		 tmpMember.setCaptcha(captcha);
    		 tmpMember.setCaptchaTime(new Date());
        	 if(tMember!=null) {
        		  tMemberService.updateTMemberByTMember(tmpMember);
        	 }else {
        		 tMemberService.insertTMemberByTMember(tmpMember);
        	 }
         }else{
        	 return ResultGenerator.genFailResult("短信发送失败");
         };
        return ResultGenerator.genSuccessResult(captcha);
    }
	@PostMapping("/checkCaptcha")
    public Result checkCaptcha(@RequestParam String phone,@RequestParam String captcha) {
		
          
        	 //查询phone 是否注册
        	 Map map = new HashMap();
        	 map.put("phone", phone);
        	 TMember tMember = tMemberService.selectTMemberByMap(map);
        	 if(tMember!=null) {
        		   if(DateUtil.add_minute(tMember.getCaptchaTime(), 3).before(new Date())) {
        			   return ResultGenerator.genSuccessResult(3);
        		   }
        		   if(captcha.equals(tMember.getCaptcha())) {
        			   return ResultGenerator.genSuccessResult(1);
        		   }else {
        			   return ResultGenerator.genSuccessResult(2);
        		   }
        	 }else {
        		 
        	 }
          
        return ResultGenerator.genSuccessResult(4);
    }
	@PostMapping("/reg")
    public Result reg(HttpServletRequest request) {
		
          
        	 
          
        return ResultGenerator.genSuccessResult(4);
    }
}

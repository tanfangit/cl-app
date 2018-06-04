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
		try {
			
		
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
	        return ResultGenerator.genSuccessResult();
		} catch (Exception e) {
			// TODO: handle exception
			logger.error(e.getMessage(), e);
			return ResultGenerator.genServerResult("服务器异常");
		}
    }
	@PostMapping("/checkCaptcha")
    public Result checkCaptcha(@RequestParam String phone,@RequestParam String captcha) {
		try {
          
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
		} catch (Exception e) {
			// TODO: handle exception
			logger.error(e.getMessage(), e);
			return ResultGenerator.genServerResult("服务器异常");
		}
    }
	@PostMapping("/reg")
    public Result reg(TMember tMember,HttpServletRequest request) {
		try {
			/*String phone = request.getParameter("phone");
			String membername = request.getParameter("membername");  
			String captcha = request.getParameter("captcha");  	 
			String refereename = request.getParameter("refereename");  	  
			String refereephone = request.getParameter("refereephone"); 
			String password = request.getParameter("password"); 
			String openid = request.getParameter("openid"); 
			String wxaccount = request.getParameter("wxaccount"); 
			String acatar = request.getParameter("acatar"); */
			if(StringUtils.isEmpty(tMember.getPhone()) || StringUtils.isEmpty(tMember.getMembername()) || StringUtils.isEmpty(tMember.getCaptcha())
					|| StringUtils.isEmpty(tMember.getPassword()) || StringUtils.isEmpty(tMember.getOpenid()) || StringUtils.isEmpty(tMember.getWxaccount())
					|| StringUtils.isEmpty(tMember.getAcatar())) {
				 return ResultGenerator.genParmeterErrorResult();
			}
			//再次验证 验证码
			 Map map = new HashMap();
        	 map.put("phone", tMember.getPhone());
        	 TMember tMemberOld = tMemberService.selectTMemberByMap(map);
        	 if(tMemberOld!=null) {
        		   if(DateUtil.add_minute(tMemberOld.getCaptchaTime(), 3).before(new Date())) {
        			   return ResultGenerator.genFailResult("验证码已失效");
        		   }
        		   if(tMemberOld.getCaptcha().equals(tMember.getCaptcha())) {
        			   // 避免重复注册 判断 status 
        			   if(tMemberOld.getIstemp()!=null) {
        				   return ResultGenerator.genFailResult("请不要重复注册");
        			   }
        			   //tMember.setMembernumber(StringUtils.getMembernumber(4));
        			   tMember.setStatus(0);
        			   tMember.setIstemp(0);
        			   tMember.setOpentype(1);
        			   tMember.setOpenTime(new Date());
        			   tMember.setPassword(StringUtils.md5Password(tMember.getPassword()));
        			   tMemberService.updateTMemberByTMember(tMember);
        			   Map mapR  = new HashMap();
        			   mapR.put("phone", tMember.getPhone());
        	           TMember tMemberR = tMemberService.selectTMemberByMap(mapR);
        	           return ResultGenerator.genSuccessResult(tMemberR);
        		   }else {
        			   return ResultGenerator.genFailResult("验证码错误");
        		   }
        	 }else {
        		 return ResultGenerator.genFailResult("请重新发送验证码");
        	 }
			
	        
		} catch (Exception e) {
			// TODO: handle exception
			logger.error(e.getMessage(), e);
			return ResultGenerator.genServerResult("服务器异常");
		}
    }
	
	@PostMapping("/resetPassword")
    public Result resetPassword(@RequestParam String phone,@RequestParam String captcha,@RequestParam String password) {
		try {
			if(StringUtils.isEmpty(phone) || StringUtils.isEmpty(captcha) || StringUtils.isEmpty(password)) {
				 return ResultGenerator.genParmeterErrorResult();
			}
	        	 //查询phone 是否注册
	        	 Map map = new HashMap();
	        	 map.put("phone", phone);
	        	 TMember tMember = tMemberService.selectTMemberByMap(map);
	        	 if(tMember!=null) {
	        		   if(DateUtil.add_minute(tMember.getCaptchaTime(), 3).before(new Date())) {
	        			   return ResultGenerator.genSuccessResult(3);
	        		   }
	        		   if(captcha.equals(tMember.getCaptcha())) {
	        			   //
	        			   TMember tmp = new TMember();
	        			   tmp.setPhone(phone);
	        			   tmp.setPassword(StringUtils.md5Password(password));
	        			   tMemberService.updateTMemberByTMember(tmp);
	        			   return ResultGenerator.genSuccessResult(1);
	        		   }else {
	        			   return ResultGenerator.genSuccessResult(2);
	        		   }
	        	 }else {
	        		 
	        	 }
	          
	        return ResultGenerator.genSuccessResult(4);
		} catch (Exception e) {
			// TODO: handle exception
			logger.error(e.getMessage(), e);
			return ResultGenerator.genServerResult("服务器异常");
		}
    }
	/*
	 * 手机号快捷登录
	 * */
	@PostMapping("/phone")
    public Result phone(@RequestParam String phone,@RequestParam String captcha) {
		try {
			if(StringUtils.isEmpty(phone) || StringUtils.isEmpty(captcha) ) {
				 return ResultGenerator.genParmeterErrorResult();
			}
		
		   	 //查询phone 是否注册
		   	 Map map = new HashMap();
		   	 map.put("phone", phone);
		   	 TMember tMember = tMemberService.selectTMemberByMap(map);
		   	 if(tMember!=null) {
		   		   if(DateUtil.add_minute(tMember.getCaptchaTime(), 3).before(new Date())) {
		   			   return ResultGenerator.genFailResult("验证码失效");
		   		   }
		   		   if(captcha.equals(tMember.getCaptcha())) {
		   			   return ResultGenerator.genSuccessResult(tMember);
		   		   }else {
		   			   return ResultGenerator.genFailResult("验证码错误");
		   		   }
		   	 }else {
		   		 return ResultGenerator.genFailResult("请重新发送验证码");
		   	 }
		} catch (Exception e) {
			// TODO: handle exception
			logger.error(e.getMessage(), e);
			return ResultGenerator.genServerResult("服务器异常");
		}
	   
    }
	/*
	 * 账号密码登录
	 * */
	@PostMapping("/user")
    public Result user(@RequestParam String usernameOrPhone,@RequestParam String password) {
		try {
			if(StringUtils.isEmpty(usernameOrPhone) || StringUtils.isEmpty(password)  ) {
				 return ResultGenerator.genParmeterErrorResult();
			}
		
		   	 //查询phone 是否注册
		   	 Map map = new HashMap();
		   	  
		   	 map.put("usernameOrPhone", usernameOrPhone);
		   	 TMember tMember = tMemberService.selectTMemberByMap(map);
		   	 if(tMember!=null) {
		   		    
		   		   if(StringUtils.md5Password(password).equals(tMember.getPassword()) ) {
		   			   return ResultGenerator.genSuccessResult(tMember);
		   		   }else {
		   			   return ResultGenerator.genFailResult("密码错误");
		   		   }
		   	 }else {
		   		 return ResultGenerator.genFailResult("用户不存在");
		   	 }
		} catch (Exception e) {
			// TODO: handle exception
			logger.error(e.getMessage(), e);
			return ResultGenerator.genServerResult("服务器异常");
		}    
	   
    }
	@PostMapping("/updatePassword")
    public Result updatePassword(@RequestParam Integer id,@RequestParam String oldPassWord,@RequestParam String newPassWord) {
		try {
			if(id == null || StringUtils.isEmpty(oldPassWord)   || StringUtils.isEmpty(newPassWord)) {
				 return ResultGenerator.genParmeterErrorResult();
			}
		
		   	 //查询phone 是否注册
		   	 Map map = new HashMap();
		   	  
		   	 map.put("id", id);
		   	 TMember tMember = tMemberService.selectTMemberByMap(map);
		   	 if(tMember!=null) {
		   		    
		   		   if(StringUtils.md5Password(oldPassWord).equals(tMember.getPassword()) ) {
		   			   //修改密码
		   			 TMember tmp = new TMember();
	      			   tmp.setId(id);
	      			   tmp.setPassword(StringUtils.md5Password(newPassWord));
	      			   tMemberService.updateTMemberByTMember(tmp);
		   			   return ResultGenerator.genSuccessResult(1);
		   		   }else {
		   			   return ResultGenerator.genSuccessResult(2);
		   		   }
		   	 }else {
		   		 return ResultGenerator.genFailResult("用户不存在");
		   	 }
		} catch (Exception e) {
			// TODO: handle exception
			logger.error(e.getMessage(), e);
			return ResultGenerator.genServerResult("服务器异常");
		}    
	   
    }
	@PostMapping("/updatePhone")
    public Result updatePhone(@RequestParam Integer id,@RequestParam String newPhone,@RequestParam String captcha) {
		try {
			if(id == null || StringUtils.isEmpty(newPhone)   || StringUtils.isEmpty(captcha)) {
				 return ResultGenerator.genParmeterErrorResult();
			}
		
		   	 //查询phone 是否注册
		   	 Map map = new HashMap();
		   	  
		   	 map.put("phone", newPhone);
		   	 TMember tMember = tMemberService.selectTMemberByMap(map);
		   	 if(tMember!=null) {
		   		   if(DateUtil.add_minute(tMember.getCaptchaTime(), 3).before(new Date())) {
		   			   return ResultGenerator.genFailResult("验证码失效");
		   		   }
		   		   if(captcha.equals(tMember.getCaptcha())) {
		   			   // 因为现在短信验证码 都保证在 tMember 表 tMember phone 唯一 所以需删掉之前发送短信验证码的记录 再更新现在的user phone
		   			   tMemberService.deleteTMemberByMap(map);
		   			   // 修改手机号
		   			   TMember tmp = new TMember();
	      			   tmp.setId(id);
	      			   tmp.setPhone(newPhone);
	      			   tMemberService.updateTMemberByTMember(tmp);
		      		   Map mapR  = new HashMap();
	      			   mapR.put("id", id);
	      	           TMember tMemberR = tMemberService.selectTMemberByMap(mapR);
		   			   return ResultGenerator.genSuccessResult(tMemberR);
		   		   }else {
		   			   return ResultGenerator.genFailResult("验证码错误");
		   		   } 
		   		   
		   	 }else {
		   		 return ResultGenerator.genFailResult("请重新发送验证码");
		   	 }
		} catch (Exception e) {
			// TODO: handle exception
			logger.error(e.getMessage(), e);
			return ResultGenerator.genServerResult("服务器异常");
		}    
	   
    }
	
}

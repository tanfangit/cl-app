package com.company.project.timer;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.company.project.dao.AccessTokenDao;
import com.company.project.util.AccessTokenUtil;
import com.company.project.util.StringUtils;
import com.company.project.util.SysConfigConstants;
@Component
public class GetAccessTokenTimerTask {
	  Log log = LogFactory.getLog(GetAccessTokenTimerTask.class);
	  @Autowired
	  private  AccessTokenDao accessTokenDao;
	  	
	  //@Scheduled(cron = "0 0/2 * * * ?")
	  	@Scheduled(cron = "0 0 */1 * * ?")
	    public void execute() {
	    	getAccessToken();
	    	try {
				Thread.sleep(2*1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	getJsapi_ticket();
	    }
	    private void getAccessToken(){
	    	 log.info("获取微信AccessToken定时任务运行中");

		        String accessToken = AccessTokenUtil.getAccessToken(SysConfigConstants.APPID, SysConfigConstants.APPSCRET);
		        Map param = new HashMap();
	            if(!StringUtils.isEmpty(accessToken)){
	            	
	            	param.put("accessToken", accessToken);
	            	param.put("updateTime", new Date());
	            	accessTokenDao.updateAccessToken(param);
	            }else{
	            	//抛异常
	            	 
	            }
	    }
	    
	    private void getJsapi_ticket(){
	    	 log.info("获取微信jsapi_ticket定时任务运行中");
	    	 String accessToken = "";
	    	 String jsapi_ticket = "";
	    	 Map<String, Object> maps= accessTokenDao.selectAccessToken();
			 accessToken=maps.get("accessToken").toString();
	    	 
		         jsapi_ticket = AccessTokenUtil.getjsapi_ticket(accessToken);
		        Map param = new HashMap();
	            if(!StringUtils.isEmpty(jsapi_ticket)){
	            	
	            	param.put("jsapi_ticket", jsapi_ticket);
	            	param.put("updateTime", new Date());
	            	accessTokenDao.updatejsapi_ticket(param);
	            }else{
	            	//60秒后再次请求
	            	try {
						Thread.sleep(60*1000);
						jsapi_ticket =  AccessTokenUtil.getjsapi_ticket(accessToken);
			            if(!StringUtils.isEmpty(jsapi_ticket)){
			            	 param.clear();
			            	param.put("jsapi_ticket", jsapi_ticket);
			            	param.put("updateTime", new Date());
			            	accessTokenDao.updatejsapi_ticket(param);
			            }else{
			            	//发送短信提醒 
			            }
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						 log.error(e.getMessage(), e);
						 throw new RuntimeException("获取jsapi_ticket 异常");
					}
	            }
	    }
     
}

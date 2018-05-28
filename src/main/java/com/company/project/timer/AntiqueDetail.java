package com.company.project.timer;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.company.project.dto.TaskDictDTO;
import com.company.project.model.TAntiqueDetailJob;
import com.company.project.service.AntiqueDetailService;
import com.company.project.service.TAntiqueDetailJobService;
import com.company.project.util.URLUtil;

@Component
public class AntiqueDetail {
	Log log = LogFactory.getLog(AntiqueDetail.class);
	
	//@Autowired
	//private AntiqueDetailService antiqueDetailService;
	@Autowired
	private  TAntiqueDetailJobService tAntiqueDetailJobService;
	
	private  String appKey = "aneapsc";
	private  String appSecret = "123456";
	@Scheduled(cron = "0 0/2 * * * ?")
    public void execute() {
    	//getAccessToken();
		TaskDict();
    	 
    }
	
	public void TaskDict() {
		try {
			String url ="http://101.95.139.62:9969/apscws/services/antique/dictlist";
			String params ="";
			String sdate = "";
			String edate = "";
			Long timestamp = new Date().getTime();
			System.out.println(timestamp);
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			TAntiqueDetailJob tAntiqueDetailJob = tAntiqueDetailJobService.selectMaxTimeTAntiqueDetailJobByType(2);
			sdate = formatter.format(tAntiqueDetailJob.getSdate());
			edate = formatter.format(tAntiqueDetailJob.getEdate());
			params+="{\"sdate\":\""+sdate+"\",\"edate\":\""+edate+"\"}";
			String digest = Base64.encodeBase64String(DigestUtils.md5Hex(params+timestamp+appKey+appSecret).getBytes());
			Map<String, String> map = new HashMap();
			map.put("digest", digest);
			map.put("timestamp", timestamp+"");
			map.put("params", params);
			System.out.println(JSONObject.toJSON(map).toString());
			String rStr = URLUtil.sendPostByJson(url, JSONObject.toJSON(map).toString());
			JSONObject result = JSONObject.parseObject(rStr);
			JSONArray resultInfo =  result.getJSONArray("resultInfo");
			for(int i=0;i<resultInfo.size();i++) {
				JSONObject obj = (JSONObject) resultInfo.get(i);
				TaskDictDTO taskDictDTO = obj.toJavaObject(com.company.project.dto.TaskDictDTO.class);
				System.out.println(taskDictDTO);
			}
			System.out.println(rStr);
    	
			 
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//execute();

	}

}

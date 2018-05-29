package com.company.project.timer;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
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
import com.company.project.dto.AntiqueDetailDTO;
import com.company.project.dto.TaskDictDTO;
import com.company.project.model.TAntiqueDetailJob;
import com.company.project.model.TDict;
import com.company.project.model.TaskDict;
import com.company.project.service.AntiqueDetailService;
import com.company.project.service.TAntiqueDetailJobService;
import com.company.project.service.TDictService;
import com.company.project.util.URLUtil;

/*@Component*/
public class AntiqueDetail {
	Log log = LogFactory.getLog(AntiqueDetail.class);
	
	@Autowired
	private AntiqueDetailService antiqueDetailService;
	@Autowired
	private  TAntiqueDetailJobService tAntiqueDetailJobService;
	@Autowired
	private TDictService tDictService;
	private  String appKey = "aneapsc";
	private  String appSecret = "123456";
	@Scheduled(cron = "0 0/2 * * * ?")
    public void execute() {
    	//getAccessToken();
		//TaskDict();
		AntiqueDetail();
    }
	
	public void AntiqueDetail() {
		try {
			String url ="http://101.95.139.62:9969/apscws/services/antique/list";
			String params ="";
			String sdate = "";
			String edate = "";
			Long timestamp = new Date().getTime();
			System.out.println(timestamp);
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			TAntiqueDetailJob tAntiqueDetailJob = tAntiqueDetailJobService.selectMaxTimeTAntiqueDetailJobByType(1);
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
				AntiqueDetailDTO antiqueDetailDTO = obj.toJavaObject(com.company.project.dto.AntiqueDetailDTO.class);
				antiqueDetailDTO = setAntiqueDetailDTO(antiqueDetailDTO);
				if(antiqueDetailService.selectCountAntiqueDetailDTO(antiqueDetailDTO)>0) {
					// 更新
					if(antiqueDetailDTO.getIsdel()==0) {
						antiqueDetailService.updateCountAntiqueDetailDTO(antiqueDetailDTO);
					}else {
						antiqueDetailService.deleteCountAntiqueDetailDTO(antiqueDetailDTO);
					}
				}else {
					// 新增
					antiqueDetailService.insertCountAntiqueDetailDTO(antiqueDetailDTO);
				}
			}
			System.out.println(rStr);
    	
			 
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public AntiqueDetailDTO setAntiqueDetailDTO(AntiqueDetailDTO antiqueDetailDTO) {
		if(antiqueDetailDTO.getExhibitionAddress()==1) {
			antiqueDetailDTO.setAid(2);
		}else if(antiqueDetailDTO.getExhibitionAddress()==2) {
			antiqueDetailDTO.setAid(1);
		}else{
			antiqueDetailDTO.setAid(antiqueDetailDTO.getExhibitionAddress());
		}
		
		antiqueDetailDTO.setTypeid(antiqueDetailDTO.getCategory());
		antiqueDetailDTO.setSid(antiqueDetailDTO.getSource());
		antiqueDetailDTO.setYid(antiqueDetailDTO.getYears());
		return antiqueDetailDTO;
		
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
				List<TaskDict> list = taskDictDTO.getDetailList();
				for(TaskDict taskDict:list) {
					TDict tDict = new TDict();
					// 首先判断存在不存在
					Map maps = new HashMap();
					maps.put("code", taskDict.getCode());
					maps.put("type", taskDict.getType());
					if(tDictService.selectCountTDictByMap(maps)>0) {
							// 更新 判断是删除还是更新记录
						  if(taskDict.getIsDeleted()==0) {
							  // 更新 
							  	tDict.setKeyy(taskDict.getType());
								tDict.setValuee(taskDict.getTypeName());
								tDict.setTypeCode(taskDict.getCode());
								tDictService.updateCountTDict(tDict);
						  }else if(taskDict.getIsDeleted()==0) {
							  // 删除
								tDict.setKeyy(taskDict.getType());
								tDict.setTypeCode(taskDict.getCode());
								tDictService.deleteCountTDict(tDict);
						  }
					}else{
						   // 新增
						tDict.setKeyy(taskDict.getType());
						tDict.setValuee(taskDict.getTypeName());
						tDict.setTypeCode(taskDict.getCode());
						tDict.setTypeName(taskDict.getCode()+"-name");
						Map<String,String> mapV = getTableV(taskDict);
						tDict.setFieldName(mapV.get("fieldName"));
						tDict.setTableName(mapV.get("tableName")); 
						tDictService.insertCountTDict(tDict);
					};
				}
				System.out.println(taskDictDTO);
			}
			System.out.println(rStr);
    	
			 
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public Map<String,String> getTableV(TaskDict taskDict) {
		Map map = new HashMap();
		if(taskDict.getCode().equals("goods_category")) {
			map.put("fieldName", "typeid");
			map.put("tableName", "t_antique_detail");
			return map;
		}else if(taskDict.getCode().equals("goods_years")) {
			map.put("fieldName", "year");
			map.put("tableName", "t_antique_detail");
			return map;
		}else if(taskDict.getCode().equals("goods_source")) {
			map.put("fieldName", "sid");
			map.put("tableName", "t_antique_detail");
			return map;
		}else if(taskDict.getCode().equals("goods_status")) {
			map.put("fieldName", "status");
			map.put("tableName", "t_antique_detail");
			return map;
		}else if(taskDict.getCode().equals("exhibition_address")) {
			map.put("fieldName", "aid");
			map.put("tableName", "t_antique_detail");
			return map;
		}
		return map;
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//execute();

	}

}

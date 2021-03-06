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
import com.company.project.util.DateUtil;
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
	@Scheduled(cron = "0 0/5 * * * ?")
    public void execute() {
    	//getAccessToken();
		TaskDict();
		AntiqueDetail();
    }
	
	public void AntiqueDetail() {
		String sdate = "";
		String edate = "";
		try {
			String url ="http://101.95.139.62:9969/apscws/services/antique/list";
			String params ="";
			Date begDate = new Date();
			Long timestamp = new Date().getTime();
			//System.out.println(timestamp);
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
			log.info("AntiqueDetail 定时任务同步 post 数据"+JSONObject.toJSON(map).toString());
			String rStr = URLUtil.sendPostByJson(url, JSONObject.toJSON(map).toString());
			JSONObject result = JSONObject.parseObject(rStr);
			JSONArray resultInfo =  result.getJSONArray("resultInfo");
			log.info("AntiqueDetail 定时任务同步 "+sdate+"-"+edate+" 返回结果:"+rStr);
			for(int i=0;i<resultInfo.size();i++) {
				JSONObject obj = (JSONObject) resultInfo.get(i);
				log.info("正在同步 第"+(i+1)+"条数据  :"+obj.toJSONString());
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
			// 完事 更新状态 插入job
			tAntiqueDetailJobService.updateTAntiqueDetailJob(tAntiqueDetailJob);
			tAntiqueDetailJob.setSdate(tAntiqueDetailJob.getEdate());
			//tAntiqueDetailJob.setEdate(DateUtil.add_minute(tAntiqueDetailJob.getEdate(), 5));
			tAntiqueDetailJob.setEdate(begDate);
			tAntiqueDetailJobService.insertTAntiqueDetailJob(tAntiqueDetailJob);
			
			log.info("AntiqueDetail 定时任务同步 "+sdate+"-"+edate+" 同步完成 ");
			 
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			log.error(e.getMessage(), e);
			log.info("AntiqueDetail 定时任务同步 "+sdate+"-"+edate+" 同步异常 ");
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
		String sdate = "";
		String edate = "";
		try {
			String url ="http://101.95.139.62:9969/apscws/services/antique/dictlist";
			String params ="";
			Long timestamp = new Date().getTime();
			Date begDate = new Date(); 
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
			log.info("TaskDict 定时任务同步 post 数据"+JSONObject.toJSON(map).toString());
			String rStr = URLUtil.sendPostByJson(url, JSONObject.toJSON(map).toString());
			JSONObject result = JSONObject.parseObject(rStr);
			JSONArray resultInfo =  result.getJSONArray("resultInfo");
			log.info("TaskDict 定时任务同步 "+sdate+"-"+edate+" 返回结果:"+rStr);
			for(int i=0;i<resultInfo.size();i++) {
				JSONObject obj = (JSONObject) resultInfo.get(i);
				log.info("TaskDict 定时任务 正在同步  :"+obj.toJSONString());
				TaskDictDTO taskDictDTO = obj.toJavaObject(com.company.project.dto.TaskDictDTO.class);
				List<TaskDict> list = taskDictDTO.getDetailList();
				for(TaskDict taskDict:list) {
					log.info("TaskDict 定时任务 正在同步   :"+taskDict.toString());
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
			// 完事 更新状态 插入job
			
			tAntiqueDetailJobService.updateTAntiqueDetailJob(tAntiqueDetailJob);
			tAntiqueDetailJob.setSdate(tAntiqueDetailJob.getEdate());
			//tAntiqueDetailJob.setEdate(DateUtil.add_minute(tAntiqueDetailJob.getEdate(), 5));
			tAntiqueDetailJob.setEdate(begDate);
			tAntiqueDetailJobService.insertTAntiqueDetailJob(tAntiqueDetailJob); 
			log.info("TaskDict 定时任务同步 "+sdate+"-"+edate+" 同步完成 ");
			 
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			log.error(e.getMessage(), e);
			log.info("TaskDict 定时任务同步 "+sdate+"-"+edate+" 同步异常 ");
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

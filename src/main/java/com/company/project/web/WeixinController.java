package com.company.project.web;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.company.project.core.Result;
import com.company.project.core.ResultGenerator;
import com.company.project.dao.AccessTokenDao;
import com.company.project.dao.WeixinUserMapper;
import com.company.project.dto.UserDTO;
import com.company.project.model.TMember;
import com.company.project.service.TMemberService;
import com.company.project.util.AccessTokenUtil;
import com.company.project.util.StringUtils;
import com.company.project.util.SysConfigConstants;
import com.company.project.util.URLUtil;
import com.google.common.collect.Maps; 

@Controller
@RequestMapping(value = "/weixin")
public class WeixinController {
	Log log = LogFactory.getLog(WeixinController.class);
	@Resource
	 private  AccessTokenDao accessTokenDao;
	@Resource
	private WeixinUserMapper weixinUserMapper;
	@Resource
	private TMemberService tMemberService;
	/**
	 * 3.1.1	微信公众号接口授权获取access_token接口 作废
	 * @param auth
	 * @param info
	 * @return
	 */
	@PostMapping("/checkAccessToken") 
	public Result checkAccessToken( String accessToken) {
		
		 
		try {
			if (!StringUtils.isEmpty(accessToken)) {
				  
				  
				 String jsapi_ticket = "";
				 Map param = new HashMap();
				  
				  
				  String url="https://api.weixin.qq.com/cgi-bin/ticket/getticket";
				  JSONObject json2 = JSONObject.parseObject(URLUtil.sendGet(url,  "access_token="+accessToken+"&type=wx_card"));
				  log.info(json2.toString());
				 if(json2.getInteger("errcode")!=null&&json2.getInteger("errcode")==40001){
					
					 accessToken = AccessTokenUtil.getAccessToken(SysConfigConstants.APPID, SysConfigConstants.APPSCRET);
					 if(StringUtils.isEmpty(accessToken)){
						 return ResultGenerator.genFailResult("请稍后重试");
					 }else{
						 	param.put("accessToken", accessToken);
			            	param.put("updateTime", new Date());
			            	accessTokenDao.updateAccessToken(param);
					 }
					  jsapi_ticket = AccessTokenUtil.getjsapi_ticket(accessToken);
				         
			            if(!StringUtils.isEmpty(jsapi_ticket)){
			            	param.clear();
			            	param.put("jsapi_ticket", jsapi_ticket);
			            	param.put("updateTime", new Date());
			            	accessTokenDao.updatejsapi_ticket(param);
			            	return   ResultGenerator.genSuccessResult(2);
			            }else{
			            	return ResultGenerator.genFailResult("请稍后重试"); 
			            }
			           
				 }else{
					 return   ResultGenerator.genSuccessResult(1);
				 }
				 
			 
			} else {
				 return ResultGenerator.genParmeterErrorResult();
			}
		} catch (Exception e) {
			 log.error(e.getMessage(),e);
			 return ResultGenerator.genServerResult("服务器异常");
		}  
		 
	}
	/**
	 * 3.1.2	微信网页授权获取用户基本信息
	 * @param auth
	 * @param info
	 * @return
	 */
	@PostMapping("/user")
	public Result user(String code) {
		
		 
		try {
			if (!StringUtils.isBlank(code)) {
				 String accessToken="";
				 Map<String, String> params = new HashMap<String, String>();
				 
				params.put("appid", SysConfigConstants.APPID );
				params.put("secret", SysConfigConstants.APPSCRET );
				params.put("code",  code);
				params.put("grant_type",  "authorization_code" );
				String resultMsg = URLUtil.sendPost(SysConfigConstants.ACCESS_TOKEN_Url, params);
				 JSONObject result = JSONObject.parseObject(resultMsg);
				 String access_token = result.getString("access_token");
				 String expires_in = result.getString("expires_in");
				 String refresh_token = result.getString("refresh_token");
				 String openid = result.getString("openid");
				 String scope = result.getString("scope");
				 String errcode = result.getString("errcode");
				 String errmsg = result.getString("errmsg");
				 if(StringUtils.isBlank(resultMsg)){
					 return ResultGenerator.genFailResult("请稍后重试"); 
				 }
				 if(!StringUtils.isBlank(errcode)){
					 return ResultGenerator.genFailResult("请稍后重试"); 
				 }
				log.info("access_token:"+access_token);
				log.info("expires_in:"+expires_in);
				log.info("refresh_token:"+refresh_token);
				log.info("openid:"+openid);
				log.info("scope:"+scope);
				log.info("errcode:"+errcode);
				log.info("errmsg:"+errmsg);
			  Map<String,Object>  resultdata=new HashMap();
			  
			  
			  UserDTO userDTO=new UserDTO();
			
				String userinfo = URLUtil.sendGet(SysConfigConstants.USERINFO_Url, "access_token="+access_token+"&openid="+openid+"&lang=zh_CN");
				 JSONObject user = JSONObject.parseObject(userinfo);
				 String openid2 = user.getString("openid");
				 String nickname = user.getString("nickname");
				 String sex = user.getString("sex");
				 String province = user.getString("province");
				 String city = user.getString("city");
				 String country = user.getString("country");
				 String headimgurl = user.getString("headimgurl");
				 String privilege = user.getString("privilege");
				 String unionid = user.getString("unionid");
				 String errcode2 = user.getString("errcode");
				 String errmsg2 = user.getString("errmsg");
				 if(StringUtils.isBlank(userinfo)){
					 return ResultGenerator.genFailResult("请稍后重试"); 
				 }
				 if(!StringUtils.isBlank(errcode2)){
					 return ResultGenerator.genFailResult("请稍后重试"); 
				 }
				 StringBuffer sb=new StringBuffer();
				 sb.append("openid2:").append(openid2);
				 sb.append("nickname:").append(nickname);
				 sb.append("sex:").append(sex);
				 sb.append("province:").append(province);
				 sb.append("city:").append(city);
				 sb.append("country:").append(country);
				 sb.append("headimgurl:").append(headimgurl);
				 sb.append("privilege:").append(privilege);
				 sb.append("unionid:").append(unionid);
				 sb.append("errcode2:").append(errcode2);
				 sb.append("errmsg2:").append(errmsg2);
				 log.info(sb.toString());
				 userDTO.setOpenid(openid2);
				 userDTO.setNickname(nickname);
				 userDTO.setSex(sex);
				 userDTO.setProvince(province);
				 userDTO.setCity(city);
				 userDTO.setCountry(country);
				 userDTO.setHeadimgurl(headimgurl);
				 userDTO.setPrivilege(privilege);
				 userDTO.setUnionid(unionid);
			     /**
			      * 还需保存
			      */
				 weixinUserMapper.insertUserDTO(userDTO);
				 return ResultGenerator.genSuccessResult(userDTO);
			} else {
				return ResultGenerator.genParmeterErrorResult();  
			}
		} catch (Exception e) {
			 log.error(e.getMessage(),e);
			 return ResultGenerator.genServerResult("服务器异常");
		}  
		 
	}
	@PostMapping("/appUser")
	public Result appUser(String openid) {
		try {
			if (!StringUtils.isBlank(openid)) {
				 
				Map<String, Object> map=new HashMap();
				map.put("openid", openid);
				UserDTO userDTO =weixinUserMapper.selectUserDTO(map);
				TMember tMember = tMemberService.selectTMemberByMap(map);
				if(tMember!=null) {
					userDTO.settMember(tMember);
					userDTO.setRegstatus("1");
				}else {
					userDTO.setRegstatus("0");
				}
				return ResultGenerator.genSuccessResult(userDTO);
			} else {
				return ResultGenerator.genParmeterErrorResult();   
			}
		} catch (Exception e) {
			log.error(e.getMessage(),e);
			 return ResultGenerator.genServerResult("服务器异常");
		}  
		 
	}
	
	@PostMapping("/getJsSdkSignature")
	public Result getJsSdkSignature( String url) {
		
		 
		try {
			if (!StringUtils.isBlank(url)) {
				 
				 String jsapi_ticket="";
				 String accessToken="";
				 Map<String,String>  resultdata=new HashMap();
				 
					 Map<String, Object> mapss= accessTokenDao.selectAccessToken();
					 accessToken=mapss.get("accessToken").toString();
					 
					 Map<String, String> signMap=new HashMap<String, String>();
					Map<String,Object> maps =  accessTokenDao.selectjsapi_ticket();
					jsapi_ticket = maps.get("jsapi_ticket").toString();
					signMap= AccessTokenUtil.sign(jsapi_ticket, url);
					resultdata.put("appId",SysConfigConstants.APPID);
					resultdata.put("timestamp",signMap.get("timestamp"));
					resultdata.put("nonceStr",signMap.get("nonceStr"));
					resultdata.put("signature",signMap.get("signature"));
					resultdata.put("access_token",accessToken);
					
					return ResultGenerator.genSuccessResult(resultdata);	 
				  
			} else {
				return ResultGenerator.genParmeterErrorResult();   
			}
		} catch (Exception e) {
			 
			log.error(e.getMessage(),e);
			return ResultGenerator.genServerResult("服务器异常");
		}  
	}
	
	
	 
}

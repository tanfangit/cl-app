package com.company.project.dao;

import java.util.Map;

public interface AccessTokenDao {
	/**更新AccessToken**/
   int updateAccessToken(Map<String, Object> param);
   
   /**获取AccessToken**/
   Map<String, Object> selectAccessToken();
   
   /** 更新jsapi_ticket*/
   int updatejsapi_ticket(Map<String, Object> param);
   
   /**获取jsapi_ticket*/
   
   Map<String, Object> selectjsapi_ticket();
}

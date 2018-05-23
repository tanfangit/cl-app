package com.company.project.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Formatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import com.alibaba.fastjson.JSONObject;

public class AccessTokenUtil {
	static Log log = LogFactory.getLog(AccessTokenUtil.class);
	/**
	* 获取accessToken
	* @param appID
	微信公众号凭证
	* @param appScret
	微信公众号凭证秘钥
	* @return
	*/
	public static String getAccessToken(String appID, String appScret) {
		String access_token="";
	// 访问微信服务器
	String url = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=" + appID + "&secret="
	+ appScret;
	try {
	URL getUrl=new URL(url);
	HttpURLConnection http=(HttpURLConnection)getUrl.openConnection();
	http.setRequestMethod("GET"); 
	http.setRequestProperty("Content-Type",
	"application/x-www-form-urlencoded");
	http.setDoOutput(true);
	http.setDoInput(true);


	http.connect();
	InputStream is = http.getInputStream(); 
	int size = is.available(); 
	byte[] b = new byte[size];
	is.read(b);

	String message = new String(b, "UTF-8");

	JSONObject json = JSONObject.parseObject(message);


	access_token=json.getString("access_token");
	} catch (MalformedURLException e) {
		  log.error(e.getMessage(), e);
			throw new RuntimeException("获取access_token 异常");
	 
	} catch (IOException e) {
		  log.error(e.getMessage(), e);
			throw new RuntimeException("获取access_token 异常");
	}catch (Exception e) {
		  log.error(e.getMessage(), e);
			throw new RuntimeException("获取access_token 异常");
	}
	return access_token;
	}
	/**
	* 获取jsapi_ticket
	* @param appID
	微信公众号凭证
	* @param appScret
	微信公众号凭证秘钥
	* @return
	*/
	public static String getjsapi_ticket(String access_token) {
	 String ticket="";
	// 访问微信服务器
	String url = "https://api.weixin.qq.com/cgi-bin/ticket/getticket?access_token="+access_token+"&type=jsapi";
	try {
	URL getUrl=new URL(url);
	HttpURLConnection http=(HttpURLConnection)getUrl.openConnection();
	http.setRequestMethod("GET"); 
	http.setRequestProperty("Content-Type",
	"application/x-www-form-urlencoded");
	http.setDoOutput(true);
	http.setDoInput(true);


	http.connect();
	InputStream is = http.getInputStream(); 
	int size = is.available(); 
	byte[] b = new byte[size];
	is.read(b);

	String message = new String(b, "UTF-8");

	JSONObject json = JSONObject.parseObject(message);


	ticket=json.getString("ticket");
	} catch (MalformedURLException e) {
		  log.error(e.getMessage(), e);
			throw new RuntimeException("获取jsapi_ticket 异常");
	 
	} catch (IOException e) {
		  log.error(e.getMessage(), e);
			throw new RuntimeException("获取jsapi_ticket 异常");
	}catch (Exception e) {
		  log.error(e.getMessage(), e);
			throw new RuntimeException("获取jsapi_ticket 异常");
	}
	return ticket;
	}
	
	 public static Map<String, String> sign(String jsapi_ticket, String url) {
	        Map<String, String> ret = new HashMap<String, String>();
	        String nonce_str = create_nonce_str();
	        String timestamp = create_timestamp();
	        String string1;
	        String signature = "";

	        //注意这里参数名必须全部小写，且必须有序
	        string1 = "jsapi_ticket=" + jsapi_ticket +
	                  "&noncestr=" + nonce_str +
	                  "&timestamp=" + timestamp +
	                  "&url=" + url;
	        System.out.println(string1);

	        try
	        {
	            MessageDigest crypt = MessageDigest.getInstance("SHA-1");
	            crypt.reset();
	            crypt.update(string1.getBytes("UTF-8"));
	            signature = byteToHex(crypt.digest());
	        }
	        catch (NoSuchAlgorithmException e)
	        {
	            e.printStackTrace();
	        }
	        catch (UnsupportedEncodingException e)
	        {
	            e.printStackTrace();
	        }

	        ret.put("url", url);
	        ret.put("jsapi_ticket", jsapi_ticket);
	        ret.put("nonceStr", nonce_str);
	        ret.put("timestamp", timestamp);
	        ret.put("signature", signature);

	        return ret;
	    }
 
	 
	 /**
	  * 微信统一下单接口 2次加密供网页游览器调起支付 
	  * @param packages
	  * @return
	  */
	 public static  Map<String, String> signPay2(String packages,String nonceStr){
		 Map<String, String> ret = new HashMap<String, String>();
	      //  String nonce_str = create_nonce_str();
	        String timestamp = create_timestamp();
	        String string1;
	        String signature = "";
	        string1 =
	        		"appId=" + SysConfigConstants.APPID + 
	        		"&nonceStr=" + nonceStr +
	                   "&package=" + packages+
	                   "&signType=" + "MD5"+
	                  "&timeStamp=" + timestamp +
	                  "&key="+SysConfigConstants.PARTNER_KEY;
	        System.out.println(string1);
	        signature=textToMD5L32(string1).toUpperCase();
	        System.out.println(signature);
	        ret.put("appId", SysConfigConstants.APPID);
	        ret.put("noncestr", nonceStr);
	        ret.put("package", packages);
	        ret.put("signType", "MD5");
	        ret.put("timeStamp", timestamp);
	        ret.put("paySign", signature);
	        return ret;
	 } 
	 /**
	 * 1.对文本进行32位小写MD5加密
	 * @param plainText 要进行加密的文本
	 * @return 加密后的内容
	 */
	 public static String textToMD5L32(String plainText){
	 String result = null;
	 //首先判断是否为空
	 if(StringUtils.isEmpty(plainText)){
	 return null;
	 }
	 try{
	 //首先进行实例化和初始化
	 MessageDigest md = MessageDigest.getInstance("MD5");
	 //得到一个操作系统默认的字节编码格式的字节数组
	 byte[] btInput = plainText.getBytes();
	 //对得到的字节数组进行处理
	 md.update(btInput);
	 //进行哈希计算并返回结果
	 byte[] btResult = md.digest();
	 //进行哈希计算后得到的数据的长度
	 StringBuffer sb = new StringBuffer();
	 for(byte b : btResult){
	 int bt = b&0xff;
	 if(bt<16){
	 sb.append(0);
	 }
	 sb.append(Integer.toHexString(bt));
	 }
	 result = sb.toString();
	 }catch(NoSuchAlgorithmException e){
	 e.printStackTrace();
	 }
	 return result;
	 }
	 
	 private static String create_nonce_str() {
	        return UUID.randomUUID().toString();
	    }
	 private static String byteToHex(final byte[] hash) {
	        Formatter formatter = new Formatter();
	        for (byte b : hash)
	        {
	            formatter.format("%02x", b);
	        }
	        String result = formatter.toString();
	        formatter.close();
	        return result;
	    }
	 private static String create_timestamp() {
	        return Long.toString(System.currentTimeMillis() / 1000);
	 }
	 public static Map parseXml(String xml) throws Exception {
         Map map = new HashMap();
         Document document = DocumentHelper.parseText(xml);
         Element root = document.getRootElement();
         List<Element> elementList = root.elements();
         for (Element e : elementList)
         map.put(e.getName(), e.getText());
         return map;
}
}

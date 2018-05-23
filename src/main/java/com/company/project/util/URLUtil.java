package com.company.project.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.conn.ConnectTimeoutException;


public class URLUtil {
	public  static Log log = LogFactory.getLog(URLUtil.class);
	/**
     * 向指定 URL 发送POST方法的请求     
     * @param url 发送请求的 URL    
     * @param params 请求的参数集合     
     * @return 远程资源的响应结果
     */
	@SuppressWarnings("unused")
	public  static String sendPost(String url, Map<String, String> params) {
        OutputStreamWriter out = null;
        BufferedReader in = null;        
        StringBuilder result = new StringBuilder(); 
        try {
            URL realUrl = new URL(url);
            HttpURLConnection conn =(HttpURLConnection) realUrl.openConnection();
            // 发送POST请求必须设置如下两行
            conn.setDoOutput(true);
            conn.setDoInput(true);
            // POST方法
            conn.setRequestMethod("POST");
            // 设置通用的请求属性
            conn.setRequestProperty("accept", "*/*");
            conn.setRequestProperty("connection", "Keep-Alive");
            conn.setRequestProperty("user-agent",
                    "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            conn.setConnectTimeout(3000);
            conn.setReadTimeout(3000);//设置读超时时间
            conn.connect();
            // 获取URLConnection对象对应的输出流
            out = new OutputStreamWriter(conn.getOutputStream(), "UTF-8");
            // 发送请求参数            
            if (params != null) {
		          StringBuilder param = new StringBuilder(); 
		          for (Map.Entry<String, String> entry : params.entrySet()) {
		        	  if(param.length()>0){
		        		  param.append("&");
		        	  }	        	  
		        	  param.append(entry.getKey());
		        	  param.append("=");
		        	  param.append(entry.getValue());		        	  
		        	 
		          }
		      
		          out.write(param.toString());
            }
            // flush输出流的缓冲
            out.flush();
            // 定义BufferedReader输入流来读取URL的响应
            in = new BufferedReader(
                    new InputStreamReader(conn.getInputStream(), "UTF-8"));
            String line;
            while ((line = in.readLine()) != null) {
                result.append(line);
            }
        }catch(SocketTimeoutException e){
        	log.error(e.getMessage(),e);
        	result.append("E4000001");
        	log.error("获取数据请求超时");
        	
        }catch(ConnectTimeoutException e){
        	log.error(e.getMessage(),e);
        	result.append("E4000002");
        	log.error("连接超时");
		}catch (Exception e) {            
        	log.error(e.getMessage(),e);
        	result.append("E4000000");
        }
        //使用finally块来关闭输出流、输入流
        finally{
            try{
                if(out!=null){
                    out.close();
                }
                if(in!=null){
                    in.close();
                }
            }
            catch(IOException ex){
            	log.error(ex.getMessage(),ex);
            }
        }
        return result.toString();
    }
	
	/**
     * 向指定URL发送GET方法的请求
     * 
     * @param url
     *            发送请求的URL
     * @param param
     *            请求参数，请求参数应该是 name1=value1&name2=value2 的形式。
     * @return URL 所代表远程资源的响应结果
     */
    public static String sendGet(String url, String param) {
        String result = "";
        BufferedReader in = null;
        try {
            String urlNameString = url + "?" + param;
            URL realUrl = new URL(urlNameString);
            // 打开和URL之间的连接
            URLConnection connection = realUrl.openConnection();
            // 设置通用的请求属性
            connection.setRequestProperty("accept", "*/*");
            connection.setRequestProperty("connection", "Keep-Alive");
            connection.setRequestProperty("user-agent",
                    "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            // 建立实际的连接
            connection.connect();
            // 获取所有响应头字段
            Map<String, List<String>> map = connection.getHeaderFields();
            // 定义 BufferedReader输入流来读取URL的响应
            in = new BufferedReader(new InputStreamReader(
                    connection.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
        	log.error("发送GET请求出现异常！");
            log.error(e.getMessage(),e);
        }
        // 使用finally块来关闭输入流
        finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (Exception e2) {
            	log.error(e2.getMessage(),e2);
            }
        }
        return result;
    }
    /**
     * 向指定URL发送GET方法的请求
     * 
     * @param url
     *            发送请求的URL
     * @param param
     *            请求参数，请求参数应该是 Map<String,String>的形式。
     * @return URL 所代表远程资源的响应结果
     */
    public static String sendGet(String url, Map<String,String> param) {
        String result = "";
        BufferedReader in = null;
        String pam="";
        try {
        	for(String key:param.keySet()){
        		pam+=key+"="+param.get(key)+"&";
        	}
        	if(!StringUtils.isEmpty(pam)){
        		pam = pam.substring(0, pam.length());
        	}else{
        		return result;
        	}
            String urlNameString = url + "?" + pam;
            URL realUrl = new URL(urlNameString);
            // 打开和URL之间的连接
            URLConnection connection = realUrl.openConnection();
            // 设置通用的请求属性
            connection.setRequestProperty("accept", "*/*");
            connection.setRequestProperty("connection", "Keep-Alive");
            connection.setRequestProperty("user-agent",
                    "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            // 建立实际的连接
            connection.connect();
            // 获取所有响应头字段
            Map<String, List<String>> map = connection.getHeaderFields();
           
            // 定义 BufferedReader输入流来读取URL的响应
            in = new BufferedReader(new InputStreamReader(
                    connection.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
           log.error("发送GET请求出现异常！");
           log.error(e.getMessage(),e);
        }
        // 使用finally块来关闭输入流
        finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (Exception e2) {
            	log.error(e2.getMessage(),e2);
            }
        }
        return result;
    }
}

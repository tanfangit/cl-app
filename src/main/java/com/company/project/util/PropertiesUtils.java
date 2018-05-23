package com.company.project.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * com.lcworld.chaojishequ.utils.PropertiesUtils
 * @description 
 * 		获取配置文件信息工具类
 * @author yinyouyi@2016年6月17日
 *
 * @modified_by yinyouyi@2016年6月17日
 */
public class PropertiesUtils {
	static Log log = LogFactory.getLog(PropertiesUtils.class);
	static Properties p;
	static{
		p= new Properties();
		try {
			InputStream inputStream = PropertiesUtils.class.getClassLoader().getResourceAsStream(
					"SysConfig.properties");
			p.load(inputStream);
		} catch (IOException e1) {
			log.error(e1.getMessage(),e1);
		}
	}
	public static Properties getProperties() {
		return p;
	}
   public static void main(String[] args) {
	   System.out.println("test");
   }
}

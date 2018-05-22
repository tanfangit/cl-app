package com.company.project.util;

import java.util.Iterator;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import com.ane.mspf.smsClient.SmsClientUtil;
import com.ane.mspf.smsClient.entity.SmsEntity;

public class SmsUtil {
     private static String postIp = "http://58.215.167.97:18080/anesms/sendsm";
     private static String account ="wlsxy";
     private static String key ="WA48ASFA26A";
     
     public static boolean sendSmsByCaptcha(String code,String phone) {
    	 boolean flag = false;
    	 String sendInfo = SmsClientUtil.post(postIp, new SmsEntity(account, 1, phone, "验证码: "+code+", 如非本人操作请忽略! ", 1, "201501301055", key));
    	 try {
			Document document = DocumentHelper.parseText(sendInfo);
			Element root = document.getRootElement();
			for (Iterator i = root.elementIterator(); i.hasNext();) {

				Element el = (Element) i.next();

				if("id".equals(el.getName())){
					Attribute Attribute = el.attribute("code");
					if(Attribute != null) {
						if("1".equals(Attribute.getStringValue())) {
							flag = true;
							break;
						}else {
							break;
						}
					}
					
				}

		  }
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
    	 
     }
     public static void main(String[] args) {
    	 sendSmsByCaptcha("123456","18175164590");
     }
}

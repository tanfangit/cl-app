package com.company.project.sms;

import com.ane.mspf.smsClient.SmsClientUtil;
import com.ane.mspf.smsClient.entity.SmsEntity;

public class TestSMS {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String postIp = "http://58.215.167.97:18080/anesms/sendsm";
		String sendInfo = SmsClientUtil.post(postIp, new SmsEntity("wlsxy", 1, "18175164590", "ane ip validate success !!!", 1, "201501301055", "WA48ASFA26A"));
		System.out.println( sendInfo );

	}

}

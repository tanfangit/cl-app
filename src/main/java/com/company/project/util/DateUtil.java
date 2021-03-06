package com.company.project.util;

import java.util.Calendar;
import java.util.Date;

public class DateUtil {
	public static final int daysBetween(Date early, Date late) { 
	     
        java.util.Calendar calst = java.util.Calendar.getInstance();   
        java.util.Calendar caled = java.util.Calendar.getInstance();   
        calst.setTime(early);   
         caled.setTime(late);   
         //设置时间为0时   
         calst.set(java.util.Calendar.HOUR_OF_DAY, 0);   
         calst.set(java.util.Calendar.MINUTE, 0);   
         calst.set(java.util.Calendar.SECOND, 0);   
         caled.set(java.util.Calendar.HOUR_OF_DAY, 0);   
         caled.set(java.util.Calendar.MINUTE, 0);   
         caled.set(java.util.Calendar.SECOND, 0);   
        //得到两个日期相差的天数   
         int days = ((int) (caled.getTime().getTime() / 1000) - (int) (calst   
                .getTime().getTime() / 1000)) / 3600 / 24;   
         
        return days;   
   }  
	public static boolean isTimeInNow(Date sDate,Date eDate) {
		Date now = new Date();
		if(now.after(sDate) && now.before(eDate)) {
			return true;
		}else {
			return false;
		}
		
		
	}
	public static Date add_minute(Date date,Integer minute) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(Calendar.MINUTE, minute);
		return c.getTime();
	}
}

package com.design.util;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class TimeUtil {

	@SuppressWarnings("deprecation")
	public static java.sql.Date getDayBefore(String specifiedDay) {
		//可以用new Date().toLocalString()传递参数 
		if(specifiedDay==null){
			//specifiedDay = new java.sql.Date(System.currentTimeMillis()).toLocaleString();
			specifiedDay = "2016-02-25";
		}
        Calendar c = Calendar.getInstance();  
        java.util.Date date = null;  
        try {  
            date = new SimpleDateFormat("yy-MM-dd").parse(specifiedDay);  
        } catch (ParseException e) {  
            e.printStackTrace();  
        }  
        c.setTime(date);  
        int day = c.get(Calendar.DATE);  
        c.set(Calendar.DATE, day - 1);  
        java.sql.Date beforeday = new java.sql.Date(c.getTimeInMillis());
        return beforeday;  
    }  
	
	@SuppressWarnings("deprecation")
	public static java.sql.Date getDayBefore100Day(String specifiedDay) {
		//可以用new Date().toLocalString()传递参数 
		if(specifiedDay==null){
			//specifiedDay = new java.sql.Date(System.currentTimeMillis()).toLocaleString();
			specifiedDay = "2016-02-25";
		}
        Calendar c = Calendar.getInstance();
        java.util.Date date = null;  
        try {  
            date = new SimpleDateFormat("yy-MM-dd").parse(specifiedDay);  
        } catch (ParseException e) {  
            e.printStackTrace();  
        }  
        c.setTime(date);  
        int month = c.get(Calendar.MONTH);  
        c.set(Calendar.MONTH,month-3);  
        java.sql.Date beforeday = new java.sql.Date(c.getTimeInMillis());
        return beforeday;  
    }
	
	
	public static java.sql.Date JudgeStringTime(String time){
		if(time=="" || time == null){
			return null;
		}
		
		try{
			Date.valueOf(time);
		}catch(Exception e){
			return null;
		}
		
		return Date.valueOf(time);
	}
}

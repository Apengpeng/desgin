package com.design.dao;

import java.util.Calendar;

public class Test {

	
	@org.junit.Test
	public void test01(){
		Calendar   c   =   Calendar.getInstance();   
		c.add(Calendar.DAY_OF_MONTH, -1);  
		System.out.println(c.getTime());
		java.sql.Date date = new java.sql.Date(c.getTime().getTime());
		System.out.println(date);
	}
}

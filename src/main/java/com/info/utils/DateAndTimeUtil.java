package com.info.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateAndTimeUtil {
	
	//月份
	public final static int MONTH_Jan=1;
	public final static int MONTH_Feb=2;
	public final static int MONTH_Mar=3;
	public final static int MONTH_Apr=4;
	public final static int MONTH_May=5;
	public final static int MONTH_Jun=6;
	public final static int MONTH_Jul=7;
	public final static int MONTH_Aug=8;
	public final static int MONTH_Sep=9;
	public final static int MONTH_Oct=10;
	public final static int MONTH_Nov=11;
	public final static int MONTH_Dec=12;
	
	//农历年
	public final static String YEAR_Mouse="子鼠";
	public final static String YEAR_Ox="丑牛";
	public final static String YEAR_Tiger="寅虎";
	public final static String YEAR_Rabbit="卯兔";
	public final static String YEAR_Dragon="辰龙";
	public final static String YEAR_Snake="巳蛇";
	public final static String YEAR_Horse="午马";
	public final static String YEAR_Sheep="未羊";
	public final static String YEAR_Monkey="申猴";
	public final static String YEAR_Rooster="酉鸡";
	public final static String YEAR_Dog="戌狗";
	public final static String YEAR_Pig="亥猪";
	
	//根据Date返回月份
	public static int getMonthByDate(Date date){
		return 0;
	}
	
	// 使用当前月份,得到上一个月的月份:月份的格式是:yyyy-MM  
    public static String getPreMonth(String currentDate) { 
        //定义日期格式
    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");  
        //定义日期
    	Date date = null;
    	//解析参数日期
        try {  
            date = sdf.parse(currentDate + "-" + "01");  
        } catch (ParseException e) {  
            e.printStackTrace();  
        }  
        Calendar c = Calendar.getInstance();  
        c.setTime(date);
        if(c.get(Calendar.MONTH)==0) {
        	c.add(Calendar.YEAR, -1);
        	c.add(Calendar.MONTH, +11);
        }else{
        	c.add(Calendar.MONTH, -1);
        } 
  
        String preMonth = c.get(Calendar.YEAR) + "-"  
                + (c.get(Calendar.MONTH) + 1);  
  
        return preMonth; 
    }
    
    // 使用当前月份,得到下一个月的月份:月份的格式是:yyyy-MM  
    public static String getNextMonth(String currentDate) { 
        //定义日期格式
    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");  
        //定义日期
    	Date date = null;
    	//解析参数日期
        try {  
            date = sdf.parse(currentDate + "-" + "01");  
        } catch (ParseException e) {  
            e.printStackTrace();  
        }  
        Calendar c = Calendar.getInstance();  
        c.setTime(date);
        if(c.get(Calendar.MONTH)==11) {
        	c.add(Calendar.MONTH, -11);
        	c.add(Calendar.YEAR, +1);
        }else {
        	c.add(Calendar.MONTH, +1); 
        } 
  
        String nextMonth = c.get(Calendar.YEAR) + "-"  
                + (c.get(Calendar.MONTH) + 1);  
  
        return nextMonth;   
    }
}

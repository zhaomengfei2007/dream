package com.chuangjian.common;
/*
 * Copyright (C) 2016-2017 DreamResonance Inc.All Rights Reserved
 * 
 * FileName: Pager.java
 * 
 * Description: Data type conversion.
 * 
 * History:
 * version  author       date        operation
 * 1.1      zhaomengfei	 2017-12-16	 Create
 */

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;


/**
 * 提供了特定目的的数据类型转换的方法。
 * @author	zhaomengfei
 * @version	1.1
 */
public class Conversion {
	/**
	 *将上传的文件名转化为新的字符串。
	 *@param String fileName 文件名
	 *@return sdf+random+extension: 由日期、随机数和除后缀外文件名所组成的字符串
	 */
	public static String generateFileName(String fileName){
		String sdf=new SimpleDateFormat("yyMMddHHmmss").format(new Date());
		int random=new Random().nextInt();
		int position=fileName.lastIndexOf(".");
		String extension=fileName.substring(position);
		return sdf+random+extension;
	}
	/**
	 *将上传的文件名转化为新的字符串。
	 *@param fileName 文件名
	 *@return String: 由日期、随机数和除后缀外文件名所组成的字符串
	 */
	public static String repeatFileName(String fileName){
		int position=fileName.lastIndexOf(".");
		String extension1=fileName.substring(0, position);
		StringBuffer sb=new StringBuffer(extension1);
		String extension2=fileName.substring(position);
		sb.append("(新建)").append(extension2);
		return sb.toString();
	}
	
	/**
	 *将数字转化为汉字。
	 *@param int num 星期，仅限于0~6的所有整数。
	 *@return 星期数所对应的汉字。
	 */
	public static String numberToString(int num){
		switch(num){
			case 1: return "一";
			case 2: return "二";
			case 3: return "三";
			case 4: return "四";
			case 5: return "五";
			case 6: return "六";
			case 0: return "日";
		}
		return null;
	}
	/**
	 *将数字毫秒数转化为汉语表达的时间。
	 *@param long time 长整形数据表示的毫秒数。
	 *@return 星期数所对应的汉字。
	 */
	public static String getTimeInterval(long time){
		time = time / 1000;
		long t = 0;
		if((t = time / (365*24*3600)) > 0){
			return String.valueOf(t) + "年前";
		}else if((t = time / (30 * 24*3600)) > 0){
			return String.valueOf(t) + "个月前";
		}else if((t = time / (7 * 24*3600)) > 0){
			return String.valueOf(t) + "周前";
		}else if((t = time / (24*3600)) > 0){
			return String.valueOf(t) + "天前";
		}else if((t = time / (3600)) > 0){
			return String.valueOf(t) + "小时前";
		}else if((t = time / (60)) > 0){
			return String.valueOf(t) + "分钟前";
		}else{
			return String.valueOf(time) + "秒钟前";
		}
	}
	
	/**
	 *将系统格式的日期转化为汉语叙述方式。
	 *@param date 日期。
	 *@return 日期用汉语方式的表述，不包括时分秒。
	 */
	public static String dateToChinese(Date date){
		Calendar calendar=Calendar.getInstance();
		calendar.setTime(date);
		StringBuffer sb=new StringBuffer();
		return sb.append(calendar.get(Calendar.YEAR)).append("年").append(calendar.get(Calendar.MONTH)+1).append("月")
				.append(calendar.get(Calendar.DAY_OF_MONTH)).append("日-星期")
				.append(numberToString(calendar.get(Calendar.DAY_OF_WEEK)-1)).toString();
	}
	
	/**
	 *将系统格式的日期转化为字符串叙述方式。
	 *@param date 日期。
	 *@return 日期用汉语方式的表述，不包括时分秒。
	 */
	public static String dateToString(Date date){
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		return sdf.format(date);
	}
	
	/**
	 *将系统格式的日期转化为字符串叙述方式。
	 *@param date 日期。
	 *@return 日期用汉语方式的表述，包括时分秒。
	 */
	public static String timeToString(Date date){
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sdf.format(date);
	}
	
	/**
	 *将字符串转化为系统日期。
	 *@param date 格式必须是yyyy-MM-dd。
	 *@return 系统格式的日期，不包括具体的时分秒。
	 */
	public static Date stringToDate(String date){
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		Date newdate;
		try {
			newdate = sdf.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
		return newdate;
	}
	
	/**
	 *将字符串转化为系统日期时间。
	 *@param date 格式必须是yyyy-MM-dd HH:mm:ss。
	 *@return 系统格式的日期，包括具体的时分秒。
	 */
	public static Date stringToTime(String time){
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date newdate;
		try {
			newdate = sdf.parse(time);
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
		return newdate;
	}
	
	public static String getFckCode(String btype){
		SimpleDateFormat sdf=new SimpleDateFormat("yyMMddhhmmss");
		String nowDate=sdf.format(new Date());
		String iRandom = Math.round(Math.random()*900 )+100 +".txt";
		return nowDate + btype + iRandom; 
	}
	
	public static String shortName(String name,int len){
		if(name==null){
			return "";
		}else{
			byte temp[];
			int reallen=0;
			for(int i=0;i<name.length();i++){
				temp=(name.substring(i,i+1)).getBytes();
				reallen+=temp.length;
				if(reallen>len){
					name=name.substring(0,i);
					break;
				}
			}
		}
		return name;
	}
	
}

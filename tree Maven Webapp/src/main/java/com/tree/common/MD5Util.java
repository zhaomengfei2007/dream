package com.tree.common;
/*
 * Copyright (C) 2016-2017 DreamResonance Inc.All Rights Reserved
 * 
 * FileName: MD5Util.java
 * 
 * Description: Encryption using MD5 Technology.
 * 
 * History:
 * version  author       date        operation
 * 1.0      zhaomengfei	 2017-04-14	 Create
 */
import java.security.MessageDigest;
/**
 * 实现MD5Util加密。
 * @author	zhaomengfei
 * @version	1.0
 */
public class MD5Util {
	/**
	 *将字符转化为MD5加密后的字符。
	 *@param s 字符串，主要来自用户输入的密码。
	 *@return 完成加密的字符串。
	 *@exception NullPointException: 如果num为空可能产生空指针异常。
	 */
	 public final static String MD5(String s) {
	        char hexDigits[]={'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};       

	        try {
	            byte[] btInput = s.getBytes();
	            MessageDigest mdInst = MessageDigest.getInstance("MD5");
	            mdInst.update(btInput);
	            byte[] md = mdInst.digest();
	            int j = md.length;
	            char str[] = new char[j * 2];
	            int k = 0;
	            for (int i = 0; i < j; i++) {
	                byte byte0 = md[i];
	                str[k++] = hexDigits[byte0 >>> 4 & 0xf];
	                str[k++] = hexDigits[byte0 & 0xf];
	            }
	            return new String(str);
	        } catch (Exception e) {
	            e.printStackTrace();
	            return null;
	        }
	    }

	    public static void main(String[] args) {
	        System.out.println(MD5Util.MD5((MD5Util.MD5("123456"))));
	    }
}

package com.chuangjian.common;

/*
 * Copyright (C) 2016-2017 DreamResonance Inc.All Rights Reserved
 * 
 * FileName: DefaultCode.java
 * 
 * Description: A number of methods used to operate file flows are defined.
 * 
 * History:
 * version  author       date        operation
 * 1.1      zhaomengfei	 2017-12-16	 Create
 */

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class FileUtils {
	public static void nioBufferCopy(File source, File target) throws IOException {  
	    FileChannel in = null;  
	    FileChannel out = null;  
	    FileInputStream inStream = null;  
	    FileOutputStream outStream = null;
	    inStream = new FileInputStream(source);  
	    outStream = new FileOutputStream(target);  
	    in = inStream.getChannel();  
	    out = outStream.getChannel();  
	    ByteBuffer buffer = ByteBuffer.allocate(4096);  
	    while (in.read(buffer) != -1) {  
	        buffer.flip();  
	        out.write(buffer);  
	        buffer.clear();  
	    }
	    inStream.close();
	    in.close();
	    outStream.close();
	    out.close();
	}
	
	public static boolean createPath(String path){
		File file=new File(path);
		return file.exists()?false:file.mkdir();
	}

	public static String readerTxt(String path) throws IOException{
		FileReader reader=null;
		reader = new FileReader(path);
		BufferedReader bufferedReader = new BufferedReader(reader);
		StringBuffer txt = new StringBuffer();
		String temp = null;
		while((temp = bufferedReader.readLine()) != null) {
		    txt.append(temp);
		}
		return txt.toString();
	}
	
}

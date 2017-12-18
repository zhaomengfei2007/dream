package com.chuangjian.common;

/*
 * Copyright (C) 2016-2017 DreamResonance Inc.All Rights Reserved
 * 
 * FileName: DefaultCode.java
 * 
 * Description: Delete files.
 * 
 * History:
 * version  author       date        operation
 * 1.1      zhaomengfei	 2017-12-16	 Create
 */

import java.io.File;

public class DeleteFile implements Runnable {
	private File file;
	
	public DeleteFile(){}
	
	public DeleteFile(File file) {
		this.file = file;
	}

	public void run() {
		if(file.exists()){
			file.delete();
		}
	}

}

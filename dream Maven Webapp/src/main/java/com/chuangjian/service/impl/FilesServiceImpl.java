package com.chuangjian.service.impl;

/*
 * Copyright (C) 2016-2017 DreamResonance Inc.All Rights Reserved
 * 
 * FileName: FilesServiceImpl.java
 * 
 * Description: FilesService implementation class.
 * 
 * History:
 * version  author       date        operation
 * 1.0      zhaomengfei	 2017-12-15	 Create
 * 1.1      zhaomengfei	 2017-12-16	 Upgrade
 */

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.apache.struts2.ServletActionContext;

import com.chuangjian.common.DeleteFile;
import com.chuangjian.common.Pager;
import com.chuangjian.common.Validity;
import com.chuangjian.entity.Files;
import com.chuangjian.entity.User;
import com.chuangjian.exception.ServiceException;
import com.chuangjian.service.FilesService;

/**
 * Describe
 * @author	zhaomengfei
 * @version	1.1
 */

public class FilesServiceImpl extends BaseService implements FilesService {
	
	public List<Files> getFilesList() throws ServiceException {
		return filesDao.find(Files.class);
	}
	
	public BigDecimal getFilesSize(User user,int usage) throws ServiceException {
		return filesDao.getFilesSize(user,usage);
	}
	
	public Files getFilesById(int id) throws ServiceException {
		return filesDao.findById(id, Files.class);
	}
	
	public void addFiles(Files files) throws ServiceException {
		filesDao.add(files);
	}
	
	public boolean deleteFilesByUser(Files files) throws ServiceException {
		return filesDao.deleteFilesByUser(files)>0?true:false;
	}
	
	public boolean deleteFilesById(int id) throws ServiceException {
		return filesDao.deleteFilesById(id)>0?true:false;
	}
	
	public Pager<Files> getFilesListByUser(int currentPage,int pageSize,Files files,User user,int usage)
			throws ServiceException {
		return filesDao.getFilesListByUser(currentPage, pageSize, files,user,usage);
	}
	
	public boolean deleteOldFile(Files files) throws IOException {
		File oldFile=new File(ServletActionContext.getServletContext().getRealPath("uploadFile")+File.separator+files.getPath());
		boolean result=false;
		if(oldFile.exists()){
			result=oldFile.delete();
		}
		return result;
	}
	
	public List<Files> getFilesByUser(Files files) throws ServiceException {
		return filesDao.getFilesByUser(files);
	}
	
	public Files checkNameExists(String name) throws ServiceException {
		Files files=filesDao.getFilesByName(name);
		if(!Validity.isEmpty(files)){
			return files;
		}
		return null;
	}
	
	public void fileStream(FileInputStream input,FileOutputStream out) throws IOException {
		try{  
            byte[] b=new byte[1024];//每次写入的大小  
            int i=0;  
            while((i=input.read(b))>0){  
                out.write(b,0,i);  
            }  
        }catch(IOException e){  
            e.printStackTrace();  
        }finally{
            input.close();
            out.close();  
        }
	}

	public BigInteger getFilesCountByUser(User user) throws ServiceException {
		return filesDao.getFilesCountByUser(user);
	}

	public int deleteFilesByUser(User user) throws ServiceException, IOException {
		//List<Files> filesList=filesDao.getFileListByUser(user);
		String userPath=ServletActionContext.getServletContext().getRealPath("uploadFile")+File.separator+user.getId();
		/*for(Files f:filesList){
			Thread df = new Thread(new DeleteFile(new File(userPath+File.separator+f.getPath())));
			df.start();
		}*/
		File file = new File(userPath);
		if(!file.exists()){
			file.mkdir();
		}
		File[] listFiles = file.listFiles();
		if(listFiles.length>0){
			for(File f:listFiles){
				Thread df = new Thread(new DeleteFile(f));
				df.start();
			}
		}
		ExecutorService fixedThreadPool = Executors.newFixedThreadPool(10);
		for(File f:listFiles){
			final File i=f;
			fixedThreadPool.execute(new Runnable() {
				public void run() {
					i.delete();
				}
			});
		}
		fixedThreadPool.shutdown();
		while(true){
			if(fixedThreadPool.isTerminated()){
				file.delete();
				break;
			}
		}
		return filesDao.deleteFilesByUser(user);
	}

}

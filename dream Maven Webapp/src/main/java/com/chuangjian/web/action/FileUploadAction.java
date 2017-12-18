package com.chuangjian.web.action;

/*
 * Copyright (C) 2016-2017 DreamResonance Inc.All Rights Reserved
 * 
 * FileName: FileUploadAction.java
 * 
 * Description: A controller for file uploading.
 * 
 * History:
 * version  author       date        operation
 * 1.0      zhaomengfei	 2017-12-15	 Create
 * 1.1      zhaomengfei	 2017-12-16	 Upgrade
 */

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.chuangjian.common.Conversion;
import com.chuangjian.common.DefaultCode;
import com.chuangjian.common.Pager;
import com.chuangjian.common.RetCode;
import com.chuangjian.common.Validity;
import com.chuangjian.entity.Files;
import com.chuangjian.entity.User;
import com.chuangjian.exception.ServiceException;

/**
 * Describe
 * @author	zhaomengfei
 * @version	1.1
 */

public class FileUploadAction extends BaseAction{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Files files;
	private Pager<Files> pager;
	private File file;
	private String fileFileName;
	private String fileContentType;
	private String filePath;
	private User item;
	private Double totalSize;
	
	/**
	 *description 跳转到上传头像页面的action配置。
	 *@return "success"
	 */
	public String toUploadIcon(){
		return SUCCESS;
	}
	
	/**
	 *description 接收上传的头像图片，将其保存到项目文件夹uploadFile下，同时将获取旧文件信息及其对应的旧文件将其删除，删除成功后将新文件的信息保存到数据库中。
	 *@return "success"。
	 *@exception Exception: 如果session无用户信息，可能产生空指针异常。
	 */
	public String doUploadIcon(){
		try{
			item=(User) getFromSession("loginUser");
			File uploadFile=new File(ServletActionContext.getServletContext().getRealPath("UploadFile")+File.separator+item.getId());
			if(!uploadFile.exists()){
	            uploadFile.mkdir();
	        }
			fileFileName=Conversion.generateFileName(fileFileName);
			filePath=item.getId()+File.separator+fileFileName;
			filesService.fileStream(new FileInputStream(file), new FileOutputStream(uploadFile + File.separator +fileFileName));
			
			List<Files> icon1=filesService.getFilesByUser(files);
			if(!Validity.isEmpty(icon1)){
				files=icon1.get(0);
			}
			filesService.deleteOldFile(files);
			boolean result=filesService.deleteFilesByUser(new Files(item,DefaultCode.ICONID));
			if(result){
				Files newFiles=new Files(item,fileFileName,item.getId()+File.separator+fileFileName,file.length(),new Date(),DefaultCode.ICONID);
				filesService.addFiles(newFiles);
			}
			List<Files> icon2=filesService.getFilesByUser(files);
			if(!Validity.isEmpty(icon2)){
				files=icon2.get(0);
			}
			resultMap.put("retcode", RetCode.SUCCESS);
			resultMap.put("retmsg", "上传完成");
		}catch(Exception e){
			e.printStackTrace();
			log.error("doUpload is bug:{}",e);
		}
		return SUCCESS;
	}
	
	public String successUploadIcon(){
		item=(User) getFromSession("loginUser");
		try {
			List<Files> icon=filesService.getFilesByUser(files);
			if(!Validity.isEmpty(icon)){
				files=icon.get(0);
			}
		} catch (Exception e) {
			log.error("successUpload is bug:",e);
			e.printStackTrace();
		}
		return SUCCESS;
	}
	
	public String doUploadFiles(){
		item=(User) getFromSession("loginUser");
		File uploadFile=new File(ServletActionContext.getServletContext().getRealPath("UploadFile")+File.separator+item.getId());
		if(!uploadFile.exists()){
            uploadFile.mkdir();
        }
		try {
			Files oldFiles=filesService.checkNameExists(fileFileName);
			if(!Validity.isEmpty(oldFiles)){
				fileFileName=Conversion.repeatFileName(fileFileName);
			}
			FileInputStream input=new FileInputStream(file);
			FileOutputStream out=new FileOutputStream(uploadFile + File.separator +fileFileName);
			filesService.fileStream(input, out);
			
			Files newFiles=new Files(item,fileFileName,item.getId()+File.separator+fileFileName,file.length(),new Date(),DefaultCode.REGULAR);
			filesService.addFiles(newFiles);
			
			resultMap.put("retcode", RetCode.SUCCESS);
			resultMap.put("retmsg", "上传完成");
		} catch (Exception e) {
			e.printStackTrace();
			log.error("doUploadFiles is bug: {}",e);
			resultMap.put("retcode", RetCode.UNKOWN_WRONG);
			resultMap.put("retmsg", "上传时发生错误");
		}
		return SUCCESS;
	}
	
	public String findFiles(){
		item=(User) getFromSession("loginUser");
		try {
			if(Validity.isEmpty(pager)){
				pager=new Pager<Files>();
			}
			pager=filesService.getFilesListByUser(pager.getCurrentPage(), pager.getPageSize(), files,item,DefaultCode.REGULAR);
			//DecimalFormat df=new DecimalFormat("#.00");
			//Double a=Double.valueOf((filesService.getFilesSize(item.getId(),2)).toString())/1048576;
			//totalSize=Double.valueOf(df.format(a));
			//Long len=filesService.getFilesSize(item.getId(),2);
			//totalSize=(double) len/1048576;//
			BigDecimal bd =new BigDecimal("1048576");
			totalSize=pager.getTotal()==0?0:filesService.getFilesSize(item,DefaultCode.REGULAR).divide(bd).setScale(3, BigDecimal.ROUND_HALF_DOWN).doubleValue();
			//totalSize=filesService.getFilesSize(item.getId(),2).divide(bd).setScale(3, BigDecimal.ROUND_HALF_DOWN).doubleValue();
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			log.error("findFiles is bug: {}",e);
			return ERROR;
		}
	}
	
	public String toUploadFiles(){
		return SUCCESS;
	}
	
	public String deleteFiles(){
		try {
			files=filesService.getFilesById(files.getId());
			boolean result=filesService.deleteOldFile(files);
			if(result){
				filesService.deleteFilesById(files.getId());
				log.info("{} deleteFiles success,id:{}",files.getId());
				resultMap.put("retcode", RetCode.SUCCESS);
			}else{
				resultMap.put("retcode", RetCode.FAIL);
				resultMap.put("retmsg", "删除"+files.getName()+"失败，请确认数据的有效性。");
			}
		} catch (Exception e) {
			e.printStackTrace();
			log.error("deleteFiles is bug :{}",e);
			resultMap.put("retcode", RetCode.UNKOWN_WRONG);
			resultMap.put("retmsg", "删除"+files.getName()+"发生未知错误，请检查后台程序。");
		}
		return SUCCESS;
	}
	
	public String getFilesCountByUser(){
		try {
			resultMap.put("retcode", filesService.getFilesCountByUser(item));
		} catch (ServiceException e) {
			log.error("getFilesCountByUser is bug : {}",e);
			e.printStackTrace();
		}
		return SUCCESS;
	}

	public Pager<Files> getPager() {
		return pager;
	}

	public void setPager(Pager<Files> pager) {
		this.pager = pager;
	}

	public File getFile() {
		return file;
	}
	public void setFile(File file) {
		this.file = file;
	}
	public String getFileFileName() {
		return fileFileName;
	}
	public void setFileFileName(String fileFileName) {
		this.fileFileName = fileFileName;
	}
	public String getFileContentType() {
		return fileContentType;
	}
	public void setFileContentType(String fileContentType) {
		this.fileContentType = fileContentType;
	}
	public User getItem() {
		return item;
	}
	public void setItem(User item) {
		this.item = item;
	}
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public Files getFiles() {
		return files;
	}

	public void setFiles(Files files) {
		this.files = files;
	}

	public Double getTotalSize() {
		return totalSize;
	}

	public void setTotalSize(Double totalSize) {
		this.totalSize = totalSize;
	}

}

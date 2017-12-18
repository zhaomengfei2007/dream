package com.tree.common;
/*
 * Copyright (C) 2016-2017 DreamResonance Inc.All Rights Reserved
 * 
 * FileName: RetCode.java
 * 
 * Description: Action feedback on processing results.
 * 
 * History:
 * version  author       date        operation
 * 1.0      zhaomengfei	 2017-04-14	 Create
 */
/**
 * 定义了部分静态常量，用于描述action类内定义的部分方法所执行的结果。
 * @author	zhaomengfei
 * @version	1.0
 */
public class RetCode {

	/**程序运行成功的返回值 */
	public static final String SUCCESS = "0";

	/** 数据失效的返回值 */
	public static final String PARAMS_INVALID = "100";

	/** 程序运行失败的返回值 */
	public static final String FAIL = "101";

	/** 程序发生异常的返回值 */
	public static final String UNKOWN_WRONG = "1";
	
	/** 会话失效后的返回值*/
	public static final String INVALID_SESSION = "2";
}
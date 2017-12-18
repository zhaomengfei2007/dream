package com.chuangjian.dao;

/*
 * Copyright (C) 2016-2017 DreamResonance Inc.All Rights Reserved
 * 
 * FileName:IBaseDao.java
 * 
 * Description:Interface for operating a database.
 * 
 * History:
 * version  author       date        operation
 * 1.0      zhaomengfei	 2017-12-15	 Create
 */

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.chuangjian.common.Pager;
import com.chuangjian.exception.HibernateDaoSupportException;
/**
 * 定义所有DAO接口的父接口，用以提供一些通用的方法，并通过泛型实现一些DAO的通用功能 该接口继承自appfuse框架的GenericDao接口
 *   自定义DAO接口是，要继承该DAO，使用示例: UserDao extends BaseDao<User, Integer> { ... }
 * @author	zhaomengfei
 * @version	1.0
 */
public interface IBaseDao<T,PK extends Serializable> {


	 /**
     * The <code>queryList(PK startRecord, PK pageSize)</code> method is query
     * objects according startRecord and pagesize're number, object type is
     * according your implements this method's define type, and implements this
     * interface abstract class must be override all method and inject entity
     * type.
     * 
     * @param startRecord
     *            Where from the beginning to show this record
     * @param pageSize
     *            The number of records per page
     * @param clazz
     *            according class
     * @return List<T> T is your inject object's type, List is query all object
     *         connection
     * 
     * @throws HibernateDaoSupportException
     *             Throws HibernateDaoSupportException when accessing and
     *             manipulating database happen exception.
     */
    public List<T> queryList(int startRecord, int pageSize, Class<T> clazz)
            throws HibernateDaoSupportException;

    /**
     * The <code>getRecordCount()</code> method is used for getting the total
     * count of records.
     * 
     * @return PK return total of record counts
     * @throws HibernateDaoSupportException
     *             Throws HibernateDaoSupportException when accessing and
     *             manipulating database happen exception.
     */
    public long getRecordCount(Class<T> clazz)
            throws HibernateDaoSupportException;

    /**
     * The <code>find(T entity)</code> method is find object according object
     * type.
     * 
     * @param entity
     *            if you want to find class condition.
     * @return List<T> according entity to find object's connection.
     * @throws HibernateDaoSupportException
     *             Throws HibernateDaoSupportException when accessing and
     *             manipulating database happen exception.
     * 
     */
    public List<T> find(T entity) throws HibernateDaoSupportException;

    /**
     * The <code>findById(PK id)</code> method is find object according
     * primary key.
     * 
     * @param id
     *            if you want to find object's primary key
     * @return T insject object
     * @throws HibernateDaoSupportException
     *             Throws HibernateDaoSupportException when accessing and
     *             manipulating database happen exception.
     */
    public T findById(PK id, Class<T> clazz)
            throws HibernateDaoSupportException;

    /**
     * The <code>add(T entity)</code> method is add object to database.
     * 
     * @param entity
     *            if you want to add entity.
     * 
     * @throws HibernateDaoSupportException
     *             Throws HibernateDaoSupportException when accessing and
     *             manipulating database happen exception.
     */
    public PK add(T entity) throws HibernateDaoSupportException;

    /**
     * The <code>delete(T entity)</code> method is delete object to database.
     * 
     * @param entity
     *            if you want to delete entity.
     * 
     * @throws HibernateDaoSupportException
     *             Throws HibernateDaoSupportException when accessing and
     *             manipulating database happen exception.
     */
    public void delete(T entity) throws HibernateDaoSupportException;

    /**
     * The <code>modifty(T entity)</code> method is update object to database.
     * 
     * @param entity
     *            if you want to update entity.
     * @throws HibernateDaoSupportException
     *             Throws HibernateDaoSupportException when accessing and
     *             manipulating database happen exception.
     */
    public void modify(T entity) throws HibernateDaoSupportException;

    /**
     * find page object's connection with class
     * 
     * @param clazz
     *            according class
     * @param currentPage
     *            current page
     * @param pageSize
     *            the number of records per page
     * @return Object's connection
     * @throws HibernateDaoSupportException
     *             when accessing and manipulating database happen exception
     */
    public Pager<T> findPager(int currentPage, int pageSize, Class<T> clazz)
            throws HibernateDaoSupportException;

    /**
     * find page object's connection with hql and param map
     * 
     * @param hql
     *            according hql if class param is null
     * @param currentPage
     *            current page
     * @param pageSize
     *            the number of records per page
     * @param properties
     *            according param map
     * @return Object's connection
     * @throws HibernateDaoSupportException
     *             when accessing and manipulating database happen exception
     */
    public Pager<T> findPager(String hql, int currentPage, int pageSize,
            Map<String, Object> properties) throws HibernateDaoSupportException;

    /**
     * find object's connection with hql
     * 
     * @param hql
     *            according hql
     * @return Object's connection
     * @throws HibernateDaoSupportException
     *             when accessing and manipulating database happen exception
     */
    public List<T> getObjects(String hql) throws HibernateDaoSupportException;

    /**
     * find object's connection with hql and param map
     * 
     * @param hql
     *            according hql
     * @param properties
     *            according param map
     * @return Object's connection
     * @throws HibernateDaoSupportException
     *             when accessing and manipulating database happen exception
     */
    public List<T> getObjects(String hql, Map<String, Object> properties)
            throws HibernateDaoSupportException;

    /**
     * find object with hql and param map
     * 
     * @param hql
     *            according hql
     * @param properties
     *            according param map
     * @return Object which find
     * @throws HibernateDaoSupportException
     *             when accessing and manipulating database happen exception
     */
    public Object getUniqueBeanResult(String hql, Map<String, Object> properties)
            throws HibernateDaoSupportException;

    /**
     * find object with hql
     * 
     * @param hql
     *            according hql
     * @return Object which find
     * @throws HibernateDaoSupportException
     *             when accessing and manipulating database happen exception
     */
    public Object getUniqueBeanResult(String hql)
            throws HibernateDaoSupportException;

    /**
     * update entity with hql and param map
     * 
     * @param hql
     *            according hql
     * @param properties
     *            according param map
     * @return the count of success record
     * @throws HibernateDaoSupportException
     *             when accessing and manipulating database happen exception
     */
    public int executeUpdate(String hql, Map<String, Object> properties)
            throws HibernateDaoSupportException;

    /**
     * update entity with hql and param arrary
     * 
     * @param hql
     *            according hql
     * @param values
     *            according param arrary
     * @return the count of success record
     * @throws HibernateDaoSupportException
     *             when accessing and manipulating database happen exception
     */
    public int executeUpdate(String hql, Object[] values)
            throws HibernateDaoSupportException;

    /**
     * find object's connection with hql class and param map
     * 
     * @param hql
     *            according hql if class param is null
     * @param startRecord
     *            Where from the beginning to show this record
     * @param pageSize
     *            the number of records per page
     * @param clazz
     *            according class
     * @param properties
     *            according param map
     * @return Object's connection
     * @throws HibernateDaoSupportException
     *             when accessing and manipulating database happen exception
     */
    public List<T> queryList(String hql, int startRecord, int pageSize,
            Class<T> clazz, Map<String, Object> properties)
            throws HibernateDaoSupportException;

    /**
     * find object's connection with class
     * 
     * @param clazz
     *            according class
     * @return Object's connection
     * @throws HibernateDaoSupportException
     *             when accessing and manipulating database happen exception
     */
    public List<T> find(Class<T> clazz) throws HibernateDaoSupportException;

    /**
     * execute with sql and param arrary
     * 
     * @param sql
     *            according sql
     * @param values
     *            according param arrary
     * @return the count of success record
     * @throws HibernateDaoSupportException
     *             when accessing and manipulating database happen exception
     */
    public int executeSql(final String sql, final Map<String, Object> values)
            throws HibernateDaoSupportException;
    
    /**
     * set method is need CacheQueries
     * @param isCacheQueries is cache queries
     */
    public void setCacheQueries(boolean isCacheQueries);
    
    
    public void saveOrUpdateEntity(T entity);
    
    /**
     * find object's connection with sql class and param map
     * 
     * @param sql
     *            according sql if class param is null
     * @param startRecord
     *            Where from the beginning to show this record
     * @param pageSize
     *            the number of records per page
     * @param properties
     *            according param map
     * @return Object's connection
     * @throws HibernateDaoSupportException
     *             when accessing and manipulating database happen exception
     */
    
	public List queryListSql(final String sql, final int startRecord,
            final int pageSize, final Map<String, Object> properties)
            throws HibernateDaoSupportException;
    
	public Pager findPagerBySql(String sql, int currentPage,
            int pageSize, Map<String, Object> properties)
            throws HibernateDaoSupportException;
    
	    

    public List<T> queryListByHql(String hql,Class<T> clazz,Map<String, Object> properties) throws HibernateDaoSupportException;
    
    /**
     * ��ѯ
     * @param hql
     * @param properties
     * @return
     * @throws HibernateDaoSupportException
     */
	public List queryListByHql(String hql,final Map<String, Object> properties) throws HibernateDaoSupportException;
    
    
    //新增原生SQL查询
    public List<Object[]> queryListBySql(final String sql) throws HibernateDaoSupportException;
}

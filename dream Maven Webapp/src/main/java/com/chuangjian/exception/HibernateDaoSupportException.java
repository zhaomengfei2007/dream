package com.chuangjian.exception;

/**
 * Throws this exception when DB layer happened HibernateException.
 * 
 * 
 * @version 1.0
 */
public class HibernateDaoSupportException extends DAOException {

    private static final long serialVersionUID = -2088341483075416773L;

    /**
     * constructor
     * @param expDecription message
     */
    public HibernateDaoSupportException(String expDecription) {
        super(expDecription);
    }

}

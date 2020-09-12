package com.solvay.shiro.config.exception;

/**
 * @author: solvay
 * @date: 2018/6/21
 * @description:
 */
public class PrincipalIdNullException extends RuntimeException  {

    private static final String MESSAGE = "Principal Id shouldn't be null!";

    public PrincipalIdNullException(Class clazz, String idMethodName) {
        super(clazz + " id field: " +  idMethodName + ", value is null\n" + MESSAGE);
    }
}
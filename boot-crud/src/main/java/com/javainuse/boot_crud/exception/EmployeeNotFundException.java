package com.javainuse.boot_crud.exception;

public class EmployeeNotFundException extends Exception {

    private static final long serialVersionUID = 1L;

    public EmployeeNotFundException() {}

    public EmployeeNotFundException(String message) {
        super(message);
    }
}

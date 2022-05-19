package com.portal.v1.handler;

public class RequiredFieldException extends BusinessException{
    public RequiredFieldException(String field) {
        super("O campo %s é obrigatório", field);
    }
}

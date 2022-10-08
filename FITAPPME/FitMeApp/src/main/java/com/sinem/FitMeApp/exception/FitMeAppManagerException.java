package com.sinem.FitMeApp.exception;

import lombok.Getter;

@Getter
public class FitMeAppManagerException extends RuntimeException{
    private final ErrorType errorType;

    public FitMeAppManagerException(ErrorType errorType){
        super(errorType.getMessage());
        this.errorType = errorType;
    }

    public FitMeAppManagerException(ErrorType errorType, String message){
        super(message);
        this.errorType = errorType;
    }
}

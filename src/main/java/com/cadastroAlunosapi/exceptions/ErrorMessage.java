package com.cadastroAlunosapi.exceptions;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
public class ErrorMessage {
    private int statuscode;
    private Date timestamp;
    private String message;

    private String description;

    public ErrorMessage(int statuscode,Date timestamp, String message,String description){
        this.statuscode = statuscode;
        this.timestamp = timestamp;
        this.message = message;
        this.description=description;
    }
}

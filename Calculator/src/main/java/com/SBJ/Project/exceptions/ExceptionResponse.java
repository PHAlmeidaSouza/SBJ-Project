package com.SBJ.Project.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

@AllArgsConstructor
@Getter
@Setter
public class ExceptionResponse implements Serializable {

    private Date timestamp;
    private String message;
    private String details;

}

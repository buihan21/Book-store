package com.baitaplon.bookstore.exception;

import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@Data
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException{
    private String resourceName;
    private String fieldName;
    private Integer fieldValueInt;
    private String fieldValuesStr;

    public ResourceNotFoundException(String resourceName, String fieldName, Integer fieldValueInt) {
        super(String.format("%s not found with %s: %s", resourceName, fieldName, fieldValueInt));
        this.resourceName = resourceName;
        this.fieldName = fieldName;
        this.fieldValueInt = fieldValueInt;
    }

    public ResourceNotFoundException(String resourceName, String fieldName, String fieldValueStr) {
        super(String.format("%s not found with %s: %s", resourceName, fieldName, fieldValueStr));
        this.resourceName = resourceName;
        this.fieldName = fieldName;
        this.fieldValuesStr = fieldValueStr;
    }

}

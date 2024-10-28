package com.springlearning.socialmediablogapp.Exception;

public class ResourceNotFoundException extends RuntimeException{

    //resource
    //fieldName
    //FieldValue

    private String Resource;
    private String FieldName;
    private String FieldValue;

    public ResourceNotFoundException(String resource, String fieldName, String fieldValue) {
        //Post not found :: 1
        super(String.format("%s not found with %s :: %s", resource, fieldName, fieldValue));
        Resource = resource;
        FieldName = fieldName;
        FieldValue = fieldValue;
    }

    public String getResource() {
        return Resource;
    }

    public void setResource(String resource) {
        Resource = resource;
    }

    public String getFieldName() {
        return FieldName;
    }

    public void setFieldName(String fieldName) {
        FieldName = fieldName;
    }

    public String getFieldValue() {
        return FieldValue;
    }

    public void setFieldValue(String fieldValue) {
        FieldValue = fieldValue;
    }
}

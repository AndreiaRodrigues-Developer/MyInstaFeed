package com.andreiarodrigues.myinstafeed.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Model for Meta object
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class MetaModel {

    @JsonProperty(value = "code")
    private int code;

    @JsonProperty(value = "error_type")
    private int errorType;

    @JsonProperty(value = "error_message")
    private int errorMessage;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getErrorType() {
        return errorType;
    }

    public void setErrorType(int errorType) {
        this.errorType = errorType;
    }

    public int getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(int errorMessage) {
        this.errorMessage = errorMessage;
    }

}

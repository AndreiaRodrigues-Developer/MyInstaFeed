package com.andreiarodrigues.myinstafeed.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Model for users response
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserResponse extends BaseResponse {

    @JsonProperty(value = "data")
    private UserDataModel data;

    public UserDataModel getData() {
        return data;
    }

    public void setData(UserDataModel data) {
        this.data = data;
    }

}

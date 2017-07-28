package com.andreiarodrigues.myinstafeed.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * Model for users/media/recent response
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserMediaRecentResponse extends BaseResponse {

    @JsonProperty(value = "data")
    private List<UserRecentDataModel> data;

    public List<UserRecentDataModel> getData() {
        return data;
    }

    public void setData(List<UserRecentDataModel> data) {
        this.data = data;
    }

}

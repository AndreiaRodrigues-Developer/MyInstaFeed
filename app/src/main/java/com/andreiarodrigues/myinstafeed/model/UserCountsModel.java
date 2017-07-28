package com.andreiarodrigues.myinstafeed.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Model for User's count object
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserCountsModel {

    @JsonProperty(value = "media")
    private int media;

    @JsonProperty(value = "follows")
    private int follows;

    @JsonProperty(value = "followed_by")
    private int followedBy;

    public int getMedia() {
        return media;
    }

    public int getFollows() {
        return follows;
    }

    public int getFollowedBy() {
        return followedBy;
    }

}

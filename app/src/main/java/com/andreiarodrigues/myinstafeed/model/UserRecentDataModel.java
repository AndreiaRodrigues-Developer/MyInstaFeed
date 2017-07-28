package com.andreiarodrigues.myinstafeed.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Model for User's recent media object
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserRecentDataModel {

    @JsonProperty(value = "id")
    private String id;

    @JsonProperty(value = "images")
    private UserImagesModel images;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public UserImagesModel getImages() {
        return images;
    }

    public void setImages(UserImagesModel images) {
        this.images = images;
    }

}

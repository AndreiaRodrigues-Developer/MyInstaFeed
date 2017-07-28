package com.andreiarodrigues.myinstafeed.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Model for User's images object
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserImagesModel {

    @JsonProperty(value = "thumbnail")
    private ImagesModel thumbnail;

    @JsonProperty(value = "low_resolution")
    private ImagesModel lowResolution;

    @JsonProperty(value = "standard_resolution")
    private ImagesModel standardResolution;

    public ImagesModel getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(ImagesModel thumbnail) {
        this.thumbnail = thumbnail;
    }

    public ImagesModel getLowResolution() {
        return lowResolution;
    }

    public void setLowResolution(ImagesModel lowResolution) {
        this.lowResolution = lowResolution;
    }

    public ImagesModel getStandardResolution() {
        return standardResolution;
    }

    public void setStandardResolution(ImagesModel standardResolution) {
        this.standardResolution = standardResolution;
    }

}

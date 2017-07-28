package com.andreiarodrigues.myinstafeed.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Model for Images object
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ImagesModel {

    @JsonProperty(value = "width")
    private int width;

    @JsonProperty(value = "height")
    private int height;

    @JsonProperty(value = "url")
    private String url;

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

}

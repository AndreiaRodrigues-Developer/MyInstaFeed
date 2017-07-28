package com.andreiarodrigues.myinstafeed.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Base model for all responses
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class BaseResponse {

    @JsonProperty(value = "meta")
    private MetaModel meta;

    public MetaModel getMeta() {
        return meta;
    }

    public void setMeta(MetaModel meta) {
        this.meta = meta;
    }

}

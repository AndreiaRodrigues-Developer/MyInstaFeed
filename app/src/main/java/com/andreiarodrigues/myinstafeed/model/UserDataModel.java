package com.andreiarodrigues.myinstafeed.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Model for User's data object
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserDataModel {

    @JsonProperty(value = "id")
    private String id;

    @JsonProperty(value = "username")
    private String username;

    @JsonProperty(value = "full_name")
    private String fullName;

    @JsonProperty(value = "profile_picture")
    private String profilePicture;

    @JsonProperty(value = "bio")
    private String bio;

    @JsonProperty(value = "website")
    private String website;

    @JsonProperty(value = "counts")
    private UserCountsModel counts;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(String profilePicture) {
        this.profilePicture = profilePicture;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public UserCountsModel getCounts() {
        return counts;
    }

    public void setCounts(UserCountsModel counts) {
        this.counts = counts;
    }

}

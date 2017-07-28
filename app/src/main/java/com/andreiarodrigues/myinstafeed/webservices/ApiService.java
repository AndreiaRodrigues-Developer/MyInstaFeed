package com.andreiarodrigues.myinstafeed.webservices;

import com.andreiarodrigues.myinstafeed.model.UserMediaRecentResponse;
import com.andreiarodrigues.myinstafeed.model.UserResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Class for all Retrofit calls used on application
 */

public interface ApiService {

    @GET("users/self")
    Call<UserResponse> getUser(@Query("access_token") String accessToken);

    @GET("users/self/media/recent")
    Call<UserMediaRecentResponse> getUserMediaRecent(@Query("access_token") String accessToken);

}

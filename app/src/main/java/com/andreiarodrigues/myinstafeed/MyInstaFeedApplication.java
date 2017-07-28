package com.andreiarodrigues.myinstafeed;

import android.app.Application;

import com.andreiarodrigues.myinstafeed.helpers.Constants;
import com.andreiarodrigues.myinstafeed.webservices.ApiRepository;

/**
 * Application
 */

public class MyInstaFeedApplication extends Application {

    private static MyInstaFeedApplication sInstance;
    private ApiRepository sApiRepository;

    @Override
    public void onCreate() {
        super.onCreate();
    }


    public static MyInstaFeedApplication getInstance() {
        if (sInstance == null) {
            sInstance = new MyInstaFeedApplication();
        }
        return sInstance;
    }

    public ApiRepository getApiRepository() {
        if (sApiRepository == null) {
            sApiRepository = new ApiRepository(Constants.BASE_URL);
        }
        return sApiRepository;
    }
}

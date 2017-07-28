package com.andreiarodrigues.myinstafeed.view;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.Toast;

import com.andreiarodrigues.myinstafeed.MyInstaFeedApplication;
import com.andreiarodrigues.myinstafeed.R;
import com.andreiarodrigues.myinstafeed.helpers.MyUtils;
import com.andreiarodrigues.myinstafeed.model.UserMediaRecentResponse;
import com.andreiarodrigues.myinstafeed.model.UserRecentDataModel;

import java.util.ArrayList;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserLatestPhotosFragment extends Fragment implements Callback<UserMediaRecentResponse> {

    UserActivity activity;
    GridView gridView;

    public UserLatestPhotosFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_user_latest_photos, container, false);
        init(view);
        return view;
    }

    private void init(View view) {
        activity = (UserActivity) getActivity();
        gridView = (GridView) view.findViewById(R.id.gridview);

        MyInstaFeedApplication.getInstance().getApiRepository().getUserRecentMedia(MyUtils.readAccessToken(activity), this);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onResponse(@NonNull Call<UserMediaRecentResponse> call, @NonNull Response<UserMediaRecentResponse> response) {
        //Check if Access Token is still valid
        if (response.body() == null || response.code() != HttpsURLConnection.HTTP_OK) {
            if (response.code() != HttpsURLConnection.HTTP_BAD_REQUEST) {
                MyUtils.cleanAccessToken(activity);
                Toast.makeText(activity, getString(R.string.sign_in_access_token_expired), Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(activity, getString(R.string.sign_in_error), Toast.LENGTH_SHORT).show();
            }
            //Redirect to Login
            activity.finish();
            return;
        }

        List<UserRecentDataModel> userData = response.body().getData();

        if (userData != null) {
            List<String> images = new ArrayList<>();
            for (UserRecentDataModel image : userData) {
                images.add(image.getImages().getStandardResolution().getUrl());
            }
            gridView.setAdapter(new UserMediaRecentAdapter(activity, images));
        }
    }

    @Override
    public void onFailure(@NonNull Call<UserMediaRecentResponse> call, @NonNull Throwable t) {
        MyUtils.cleanAccessToken(activity);
        Toast.makeText(activity, getString(R.string.sign_in_error), Toast.LENGTH_SHORT).show();
        activity.finish();
    }

}

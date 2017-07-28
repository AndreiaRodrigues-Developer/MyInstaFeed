package com.andreiarodrigues.myinstafeed.view;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.andreiarodrigues.myinstafeed.MyInstaFeedApplication;
import com.andreiarodrigues.myinstafeed.R;
import com.andreiarodrigues.myinstafeed.helpers.MyUtils;
import com.andreiarodrigues.myinstafeed.model.UserDataModel;
import com.andreiarodrigues.myinstafeed.model.UserResponse;
import com.squareup.picasso.Picasso;

import javax.net.ssl.HttpsURLConnection;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserStatsFragment extends Fragment implements Callback<UserResponse> {

    UserActivity activity;

    TextView tvUserWelcome;
    TextView tvUserSignOut;
    ImageView ivUserProfilePicture;
    TextView tvUserPostsCount;
    TextView tvUserFollowingCount;
    TextView tvUserFollowersCount;

    String userFirstName;

    public UserStatsFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_user_stats, container, false);
        init(view);
        return view;
    }

    private void init(View view) {
        activity = (UserActivity) getActivity();

        tvUserWelcome = (TextView) view.findViewById(R.id.tv_user_welcome);
        tvUserSignOut = (TextView) view.findViewById(R.id.tv_user_sign_out);
        tvUserSignOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doesSignOut();
            }
        });
        ivUserProfilePicture = (ImageView) view.findViewById(R.id.iv_user_profile_picture);
        tvUserPostsCount = (TextView) view.findViewById(R.id.tv_user_posts_count);
        tvUserFollowingCount = (TextView) view.findViewById(R.id.tv_user_following_count);
        tvUserFollowersCount = (TextView) view.findViewById(R.id.tv_user_followers_count);

        MyInstaFeedApplication.getInstance().getApiRepository().getUser(MyUtils.readAccessToken(activity), this);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onResponse(@NonNull Call<UserResponse> call, @NonNull Response<UserResponse> response) {
        //Check if Access Token is still valid
        if (response.body() == null || response.code() != HttpsURLConnection.HTTP_OK) {
            if (response.code() != HttpsURLConnection.HTTP_BAD_REQUEST) {
                MyUtils.cleanAccessToken(activity);
                Toast.makeText(activity, getString(R.string.sign_in_access_token_expired), Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(activity, getString(R.string.sign_in_error), Toast.LENGTH_SHORT).show();
            }
            //Redirect to Login com dialog
            activity.finish();
            return;
        }

        UserDataModel userData = response.body().getData();

        if (userData != null) {
            Picasso.with(activity).load(userData.getProfilePicture()).into(ivUserProfilePicture);
            tvUserWelcome.setText(String.format(getString(R.string.user_hello),
                    userData.getFullName().substring(0, userData.getFullName().indexOf(" "))));
            userFirstName = userData.getFullName().substring(0, userData.getFullName().indexOf(" "));
            tvUserPostsCount.setText(String.format(getString(R.string.user_posts),
                    String.valueOf(userData.getCounts().getMedia())));
            tvUserFollowingCount.setText(String.format(getString(R.string.user_following),
                    String.valueOf(userData.getCounts().getFollows())));
            tvUserFollowersCount.setText(String.format(getString(R.string.user_followers),
                    String.valueOf(userData.getCounts().getFollowedBy())));
        }
    }

    @Override
    public void onFailure(@NonNull Call<UserResponse> call, @NonNull Throwable t) {
        MyUtils.cleanAccessToken(activity);
        Toast.makeText(activity, getString(R.string.sign_in_error), Toast.LENGTH_SHORT).show();
        activity.finish();
    }

    private void doesSignOut() {
        //Clear access token and/or clear cookies
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                activity);

        alertDialogBuilder.setTitle(getString(R.string.sign_out_dialog_title));
        alertDialogBuilder
                .setMessage(String.format(getString(R.string.sign_out_dialog_message), userFirstName))
                .setCancelable(false)
                .setPositiveButton(getString(R.string.sign_out_dialog_confirm), new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        MyUtils.cleanAccessToken(activity);
                        activity.finish();
                    }
                })
                .setNegativeButton(getString(R.string.sign_out_dialog_dismiss), new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });

        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }

}
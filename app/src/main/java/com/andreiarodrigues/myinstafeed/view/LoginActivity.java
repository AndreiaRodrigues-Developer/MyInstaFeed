package com.andreiarodrigues.myinstafeed.view;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.andreiarodrigues.myinstafeed.R;
import com.andreiarodrigues.myinstafeed.helpers.Constants;
import com.andreiarodrigues.myinstafeed.helpers.MyUtils;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    Button signInInstagram;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        checkInstagramAccessToken();

        signInInstagram = (Button) findViewById(R.id.sign_in_instagram);
        signInInstagram.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        doInstagramSignIn();
    }

    private void doInstagramSignIn() {
        //Checks if user is already logged in or not.
        if (MyUtils.readAccessToken(this).equals("")) {
            final Uri.Builder uriBuilder = new Uri.Builder();
            uriBuilder.scheme("https")
                    .authority("api.instagram.com")
                    .appendPath("oauth")
                    .appendPath("authorize")
                    .appendQueryParameter("client_id", Constants.CLIENT_ID)
                    .appendQueryParameter("redirect_uri", Constants.REDIRECT_URI)
                    .appendQueryParameter("response_type", "token");
            final Intent browser = new Intent(Intent.ACTION_VIEW, uriBuilder.build());
            startActivity(browser);
        } else {
            Intent intent = new Intent(this, UserActivity.class);
            startActivity(intent);
        }
    }

    private void checkInstagramAccessToken() {
        final Uri data = this.getIntent().getData();
        if (data != null && data.getHost().equals("localhost") && data.getFragment() != null) {
            final String accessToken = data.getFragment().replaceFirst("access_token=", "");
            if (accessToken != null) {
                //Save access token
                MyUtils.saveAccessToken(this, accessToken);
                //Redirect to user screen
                Intent intent = new Intent(this, UserActivity.class);
                startActivity(intent);
            } else {
                Toast.makeText(this, getString(R.string.error), Toast.LENGTH_SHORT).show();
            }
        }
    }

}

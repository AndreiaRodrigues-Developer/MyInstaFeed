package com.andreiarodrigues.myinstafeed.helpers;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.andreiarodrigues.myinstafeed.R;

/**
 * Util class related Access Token
 */
public class MyUtils {

    public static void saveAccessToken(Context context, String accessToken) {
        PreferenceManager.getDefaultSharedPreferences(context).edit().putString(context.getString(R.string.my_access_token),
                accessToken).apply();
    }

    public static String readAccessToken(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context)
                .getString(context.getString(R.string.my_access_token), "");
    }

    public static void cleanAccessToken(Context context) {
        SharedPreferences mySPrefs = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = mySPrefs.edit();
        editor.remove(context.getString(R.string.my_access_token));
        editor.apply();
    }

}

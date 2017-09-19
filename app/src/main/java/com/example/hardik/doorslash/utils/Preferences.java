package com.example.hardik.doorslash.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by hardik on 9/18/17.
 */

public class Preferences {

    private static final String APP_SETTINGS = "app_settings";

    private Preferences() {
    }

    private static SharedPreferences getSharedPreferences(Context context) {
        return context.getSharedPreferences(APP_SETTINGS, Context.MODE_PRIVATE);
    }


    public static Set<String> getFavorites(Context context) {
        return getSharedPreferences(context).getStringSet("set",new HashSet<String>());
    }

    public static void setFavorites(Context context,Set<String> values) {
        SharedPreferences.Editor editor = getSharedPreferences(context).edit();
        editor.remove("set");
        editor.apply();
        editor.putStringSet("set", values);
        editor.apply();

    }


}

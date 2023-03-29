package com.guy.class23b_and_2;

import android.content.Context;
import android.content.SharedPreferences;

public class MSPV1 {

    private static final String SP_FILE_NAME = "SP_FILE_NAME";

    public static void saveString(Context context, String key, String value) {
        SharedPreferences prefs = context.getSharedPreferences(SP_FILE_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString(key, value);
        editor.apply();
    }

    public static String readString(Context context, String key, String def) {
        SharedPreferences prefs = context.getSharedPreferences(SP_FILE_NAME, Context.MODE_PRIVATE);
        String value = prefs.getString(key, def);
        return value;
    }

    public static void saveInt(Context context, String key, int value) {
        SharedPreferences prefs = context.getSharedPreferences(SP_FILE_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putInt(key, value);
        editor.apply();
    }

    public static int readInt(Context context, String key, int def) {
        SharedPreferences prefs = context.getSharedPreferences(SP_FILE_NAME, Context.MODE_PRIVATE);
        int value = prefs.getInt(key, def);
        return value;
    }

}

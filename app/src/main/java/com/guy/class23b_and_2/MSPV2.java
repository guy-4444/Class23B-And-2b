package com.guy.class23b_and_2;

import android.content.Context;
import android.content.SharedPreferences;

public class MSPV2 {

    private static final String SP_FILE_NAME = "SP_FILE_NAME";

    private SharedPreferences prefs = null;

    public MSPV2(Context context) {
        this.prefs = context.getSharedPreferences(SP_FILE_NAME, Context.MODE_PRIVATE);
    }

    public void saveString(String key, String value) {
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString(key, value);
        editor.apply();
    }

    public String readString(String key, String def) {
        String value = prefs.getString(key, def);
        return value;
    }

    public void saveInt(String key, int value) {
        SharedPreferences.Editor editor = prefs.edit();
        editor.putInt(key, value);
        editor.apply();
    }

    public int readInt(String key, int def) {
        int value = prefs.getInt(key, def);
        return value;
    }

}

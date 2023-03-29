package com.guy.class23b_and_2;

import android.content.Context;
import android.content.SharedPreferences;

public class MSPV3 {

    private static final String SP_FILE_NAME = "SP_FILE_NAME";



    private SharedPreferences prefs = null;


    private static MSPV3 me;

    private MSPV3(Context context) {
        prefs = context.getApplicationContext().getSharedPreferences(SP_FILE_NAME, Context.MODE_PRIVATE);
    }

    public static void init(Context context) {
        if (me == null) {
            me = new MSPV3(context);
        }
    }

    public static MSPV3 getMe() {
        return me;
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

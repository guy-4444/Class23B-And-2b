package com.guy.class23b_and_2;

import android.app.Application;

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        MSPV3.init(this);
        MySignal.init(this);
    }
}

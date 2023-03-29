package com.guy.class23b_and_2;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.widget.Toast;

public class MySignal {


    private Context context;
    private Vibrator vibrator;


    private static MySignal mySignal;

    private MySignal(Context context) {
        this.context = context;
        vibrator = (Vibrator) context.getSystemService(Context.VIBRATOR_SERVICE);
    }

    public static void init(Context context) {
        if (mySignal == null) {
            mySignal = new MySignal(context.getApplicationContext());
        }
    }

    public static MySignal getInstance() {
        return mySignal;
    }






    public void vibrate() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            vibrator.vibrate(VibrationEffect.createOneShot(500, VibrationEffect.DEFAULT_AMPLITUDE));
        } else {
            //deprecated in API 26
            vibrator.vibrate(500);
        }
    }

    public void toast(String message) {
        new Handler(Looper.getMainLooper()).post(new Runnable() {
            @Override
            public void run() {
                try {
                    Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
                } catch (IllegalStateException ex) {}
            }
        });
    }

}

package com.guy.class23b_and_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.util.Log;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;
import com.google.gson.Gson;

public class MainActivity extends AppCompatActivity {

    private MaterialButton main_BTN_save;
    private MaterialButton main_BTN_load;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MyScreenUtils.hideSystemUI(this);

        main_BTN_save = findViewById(R.id.main_BTN_save);
        main_BTN_load = findViewById(R.id.main_BTN_load);
        main_BTN_save.setOnClickListener(v -> save());
        main_BTN_load.setOnClickListener(v -> load());



        User user = new User()
                .setName("Maylo")
                .setAge(20)
                .setCity("Tel-Aviv");


        String json = new Gson().toJson(user);
        MSPV3.getMe().saveString("USER", json);


        String json2 = MSPV3.getMe().readString("USER", "");
        User u2;
        try {
            u2 = new Gson().fromJson(json2, User.class);
        } catch (Exception ex) {
            u2 = new User();
        }
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus) {
            MyScreenUtils.hideSystemUI(this);
        }
    }




    private void load() {
        // V1
        //String name = MSPV1.readString(this,"Name", "NA");
        //String city = MSPV1.readString(this,"City", "NA");
        //int age     = MSPV1.readInt(this,"Age", 0);


        // V2
        //MSPV2 mspv2 = new MSPV2(this);
        //String name = mspv2.readString("Name", "NA");
        //String city = mspv2.readString("City", "NA");
        //int age     = mspv2.readInt("Age", 0);


        // V3
        String name = MSPV3.getMe().readString("Name", "NA");
        String city = MSPV3.getMe().readString("City", "NA");
        int age     = MSPV3.getMe().readInt("Age", 0);



        Log.d("pttt", "Name=" + name);
        Log.d("pttt", "City=" + city);
        Log.d("pttt", "Age=" + age);


        MySignal.getInstance().vibrate();
    }

    private void save() {
        MSPV1.saveString(this, "Name", "Michaela");
        MSPV1.saveString(this,"City", "Kfar Yona");
        MSPV1.saveInt(this,"Age", 24);
    }


}
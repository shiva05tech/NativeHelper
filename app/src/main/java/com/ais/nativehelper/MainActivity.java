package com.ais.nativehelper;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.Button;

import com.ais.nativehelper.global.GlobalController;
import com.ais.nativehelper.model.LoginControl;

public class MainActivity extends AppCompatActivity {
    String TAG="MainActivity.class";
    private String MESSAGE;
    Button button;
    private static int SPLASH_TIME_OUT = 5000;
    GlobalController global;
    private LoginControl loginControl;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        global= (GlobalController) getApplicationContext();

        new Handler().postDelayed(new Runnable() {

            /*
             * Showing splash screen with a timer. This will be useful when you
             * want to show case your app logo / company
             */

            //@Override
            public void run() {
                // This method will be executed once the timer is over
                // Start your app main activity
                /* Intent i = new Intent(MainActivity.this, BaseActivity.class);
                startActivity(i);*/

                Log.e("test","111111111111111111111");
                Log.e("test",""+global.isSignedIn(MainActivity.this));

                // if(global.isSignedIn(MainActivity.this)){



                if(true){
                    Log.e("test123","22222222222222");

                    loginControl=LoginControl.getLoginControl();
                    loginControl.getUserId(MainActivity.this);
                    //*Intent intent = new Intent(MainActivity.this, JobsListActivity.class);*//*


                    //* Intent intent = new Intent(MainActivity.this, HomeActivity.class);*//*
                    if(GlobalController.ACCESSTOKEN1!=null){
                        Intent intent = new Intent(MainActivity.this, HomeScrollingActivity.class);

                        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        startActivity(intent);
                    }
                    else{
                        Log.e("test456","22222222222222");

                        loginControl=LoginControl.getLoginControl();
                        loginControl.getUserId(MainActivity.this);
                    }


                }
                else{
                    Intent intent = new Intent(MainActivity.this,NetworkInfo.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);
                }


                /*LOGIN METHOD END*/

                // close this activity
                finish();
            }
        }, SPLASH_TIME_OUT);
    }

}
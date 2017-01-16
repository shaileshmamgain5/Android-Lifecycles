package com.androidanalysis.lifecyclesample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;

public class ActivityB extends AppCompatActivity {

    private final String className = "ActivityB";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b);
        Log.i(className,  " : onCreate");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(className,  " : onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(className,  " : onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(className,  " : onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(className,  " : onStop");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(className,  " : onRestart");
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(className,  " : onDestroy");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);

    }
}
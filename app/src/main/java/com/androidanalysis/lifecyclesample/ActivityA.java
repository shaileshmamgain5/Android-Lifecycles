package com.androidanalysis.lifecyclesample;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

public class ActivityA extends AppCompatActivity implements FragmentA.OnNewFragRequested {

    private final String className = "ActivityA";

    BoundService mService;
    boolean mBound = false;
    FrameLayout llFragmentLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        llFragmentLayout = (FrameLayout) findViewById(R.id.llFragmentLayout);


        Button btn = (Button) findViewById(R.id.btnB) ;
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i  =new Intent(ActivityA.this, ActivityB.class);
                startActivity(i);

            }
        });

        Button btnBoundService = (Button) findViewById(R.id.btnBoundService) ;
        btnBoundService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Bind to LocalService
                Intent intent = new Intent(ActivityA.this, BoundService.class);
                bindService(intent, mConnection, Context.BIND_AUTO_CREATE);

            }
        });

        Button btnIntentService = (Button) findViewById(R.id.btnIntentService) ;
        btnIntentService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Bind to LocalService
                Intent intent = new Intent(ActivityA.this, IntentServiceA.class);
                startService(intent);

            }
        });

        Button btnFragmentA = (Button) findViewById(R.id.btnFragmentA) ;
        btnFragmentA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FragmentA fragment = new FragmentA(ActivityA.this);
                llFragmentLayout.setVisibility(View.VISIBLE);

                // Add the fragment to the 'fragment_container' FrameLayout
                getSupportFragmentManager().beginTransaction()
                        .add(R.id.llFragmentLayout, fragment).addToBackStack("ActivityA").commit();

            }
        });



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
        Log.i(className," : onResume");
    }
    @Override
    protected void onPause() {
        super.onPause();
        Log.i(className, " : onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(className,  " : onStop");

        if (mBound) {
            Log.i(className," : Unbinding Service on onStop()");
            unbindService(mConnection);
            mBound = false;
        }
    }
    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(className," : onRestart");
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(className," : onDestroy");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        return super.onCreateOptionsMenu(menu);

    }

    /** Defines callbacks for service binding, passed to bindService() */
    private ServiceConnection mConnection = new ServiceConnection() {

        @Override
        public void onServiceConnected(ComponentName className,
                                       IBinder service) {
            // We've bound to LocalService, cast the IBinder and get LocalService instance
            BoundService.LocalBinder binder = (BoundService.LocalBinder) service;
            mService = binder.getService();
            mBound = true;

            Log.i("ActivityA"," : onServiceConnected");

        }

        @Override
        public void onServiceDisconnected(ComponentName arg0) {
            mBound = false;
            Log.i("ActivityA"," : onServiceDisconnected");
        }
    };
    int i = 1;

    @Override
    public void onFragmentRequested(boolean addToBackStack, boolean replaceFragment) {
        if(replaceFragment)
        {
            // Add the fragment to the 'fragment_container' FrameLayout
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.llFragmentLayout, new FragmentB()).addToBackStack("ActivityA-" + i).commit();
        }else if(addToBackStack) {
            // Add the fragment to the 'fragment_container' FrameLayout
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.llFragmentLayout, new FragmentB()).addToBackStack("ActivityA-" + i).commit();
            i++;
        }else
        {
            // Add the fragment to the 'fragment_container' FrameLayout
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.llFragmentLayout, new FragmentB()).commit();
        }
    }
}

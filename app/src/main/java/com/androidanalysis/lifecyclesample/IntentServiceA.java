package com.androidanalysis.lifecyclesample;

import android.app.IntentService;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;


public class IntentServiceA extends IntentService {

    private String className = "IntentServiceA";
    /** indicates how to behave if the service is killed */
    int mStartMode;

    /** interface for clients that bind */
    IBinder mBinder;

    /** indicates whether onRebind should be used */
    boolean mAllowRebind;


    public IntentServiceA() {
        super("IntentServiceA");
    }


    @Override
    protected void onHandleIntent(Intent intent) {

        Log.i(className,  " : onHandleIntent");
    }


    /** Called when the service is being created. */
    @Override
    public void onCreate() {
        Log.i(className,  " : onCreate");
    }

    /** The service is starting, due to a call to startService() */
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i(className,  " : onStartCommand");
        return mStartMode;

    }

    /** A client is binding to the service with bindService() */
    @Override
    public IBinder onBind(Intent intent) {
        Log.i(className,  " : onBind");
        return mBinder;
    }

    /** Called when all clients have unbound with unbindService() */
    @Override
    public boolean onUnbind(Intent intent) {
        Log.i(className,  " : onUnbind");
        return mAllowRebind;
    }

    /** Called when a client is binding to the service with bindService()*/
    @Override
    public void onRebind(Intent intent) {
        Log.i(className,  " : onRebind");
    }

    /** Called when The service is no longer used and is being destroyed */
    @Override
    public void onDestroy() {
        Log.i(className,  " : onDestroy");

    }

}

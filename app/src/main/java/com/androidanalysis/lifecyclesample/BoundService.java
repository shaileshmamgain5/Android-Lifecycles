package com.androidanalysis.lifecyclesample;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

public class BoundService extends Service {
    private String className = "BoundService";
    public BoundService() {
    }
    /** indicates how to behave if the service is killed */
    int mStartMode;

    /** interface for clients that bind */
    IBinder mBinder;

    /** indicates whether onRebind should be used */
    boolean mAllowRebind;

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

    /**
     * Class used for the client Binder.  Because we know this service always
     * runs in the same process as its clients, we don't need to deal with IPC.
     */
    public class LocalBinder extends Binder {
        BoundService getService() {
            // Return this instance of LocalService so clients can call public methods
            return BoundService.this;
        }
    }
}

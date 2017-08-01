package com.virtroop.aidlconsumertest;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import com.virtroop.aidlservicetest.AidlTest;

public class MainActivity extends AppCompatActivity {
    String TAG = "SARG_";
    AidlTest mIRemoteService;

    private ServiceConnection mConnection = new ServiceConnection() {
        // Called when the connection with the service is established
        public void onServiceConnected(ComponentName className, IBinder service) {
            Log.d(TAG, "onServiceConnected: ");
            mIRemoteService = AidlTest.Stub.asInterface(service);
        }

        // Called when the connection with the service disconnects unexpectedly
        public void onServiceDisconnected(ComponentName className) {
            mIRemoteService = null;
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = new Intent("com.virtroop.servicetest.ServiceTest");
        intent.setPackage("com.virtroop.servicetest");
//        bindService(intent, mConnection, Context.BIND_AUTO_CREATE);

//        Intent intent = new Intent();
//        intent.setComponent(new ComponentName("com.virtroop.aidlservicetest", "com.virtroop.aidlservicetest.ServiceTest"));
        Log.d(TAG, "" + bindService(intent, mConnection, Context.BIND_AUTO_CREATE));
    }

    public void executeServiceMethod(View v) {
        try {
            Log.d(TAG, "executeSimpleMethod: " + mIRemoteService.returnTrue());
            Log.d(TAG, "executePojoMethod: " + mIRemoteService.getTestPojo().toString());
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}

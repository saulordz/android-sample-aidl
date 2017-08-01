package com.virtroop.servicetest;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;

import com.virtroop.aidlservicetest.AidlTest;
import com.virtroop.aidlservicetest.PojoTest;

public class ServiceTest extends Service {
    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public IBinder onBind(Intent intent) {
        // Return the interface
        return mBinder;
    }

    private final AidlTest.Stub mBinder = new AidlTest.Stub() {

        @Override
        public boolean returnTrue() throws RemoteException {
            return true;
        }

        @Override
        public PojoTest getTestPojo() throws RemoteException {
            PojoTest pojoTest = new PojoTest();
            pojoTest.setId(12);
            pojoTest.setName("yomix");
            return pojoTest;
        }
    };
}

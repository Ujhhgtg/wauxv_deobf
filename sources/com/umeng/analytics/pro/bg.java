package com.umeng.analytics.pro;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import com.umeng.analytics.pro.a;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public class bg implements be {
    private static final String a = "Coolpad";
    private static final String b = "com.coolpad.deviceidsupport";
    private static final String c = "com.coolpad.deviceidsupport.DeviceIdService";
    private static a d;
    private CountDownLatch f;
    private Context g;
    private String e = "";
    private final ServiceConnection h = new ServiceConnection() { // from class: com.umeng.analytics.pro.bg.1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                a unused = bg.d = a.b.a(iBinder);
                bg.this.e = bg.d.b(bg.this.g.getPackageName());
                Log.d(bg.a, "onServiceConnected: oaid = " + bg.this.e);
            } catch (RemoteException | NullPointerException e) {
                Log.e(bg.a, "onServiceConnected failed e=" + e.getMessage());
            }
            bg.this.f.countDown();
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            Log.d(bg.a, "onServiceDisconnected");
            a unused = bg.d = null;
        }
    };

    private void b(Context context) {
        try {
            Intent intent = new Intent();
            intent.setComponent(new ComponentName(b, c));
            if (context.bindService(intent, this.h, 1)) {
                return;
            }
            Log.e(a, "bindService return false");
        } catch (Throwable th) {
            Log.e(a, "bindService failed. e=" + th.getMessage());
            this.f.countDown();
        }
    }

    private void c(Context context) {
        try {
            Log.d(a, "call unbindService.");
            context.unbindService(this.h);
        } catch (Throwable th) {
            Log.e(a, "unbindService failed. e=" + th.getMessage());
        }
    }

    @Override // com.umeng.analytics.pro.be
    public String a(Context context) {
        if (context == null) {
            return null;
        }
        this.g = context.getApplicationContext();
        this.f = new CountDownLatch(1);
        try {
            b(context);
            if (!this.f.await(500L, TimeUnit.MILLISECONDS)) {
                Log.e(a, "getOAID time-out");
            }
            return this.e;
        } catch (InterruptedException e) {
            Log.e(a, "getOAID interrupted. e=" + e.getMessage());
            return null;
        } finally {
            c(context);
        }
    }
}

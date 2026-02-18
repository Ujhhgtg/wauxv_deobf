package com.umeng.analytics.pro;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import com.umeng.analytics.pro.dx;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public class bk implements be {
    private static final String a = "Lenovo";
    private static final String b = "com.zui.deviceidservice";
    private static final String c = "com.zui.deviceidservice.DeviceidService";
    private volatile String d = "";
    private CountDownLatch e;
    private Context f;

    @Override // com.umeng.analytics.pro.be
    public String a(Context context) {
        if (context == null) {
            return null;
        }
        this.f = context.getApplicationContext();
        this.e = new CountDownLatch(1);
        ServiceConnection serviceConnection = new ServiceConnection() { // from class: com.umeng.analytics.pro.bk.1
            /* JADX WARN: Undo finally extract visitor
            jadx.core.utils.exceptions.JadxRuntimeException: Expected to find fallthrough terminus for handler TryEdge: [PREMATURE_EXIT B:21:0x0009 -> B:9:0x0033] - Handler: None
            	at jadx.core.dex.visitors.finaly.MarkFinallyVisitor.findCommonInsns(MarkFinallyVisitor.java:419)
            	at jadx.core.dex.visitors.finaly.MarkFinallyVisitor.extractFinally(MarkFinallyVisitor.java:302)
            	at jadx.core.dex.visitors.finaly.MarkFinallyVisitor.processTryBlock(MarkFinallyVisitor.java:222)
            	at jadx.core.dex.visitors.finaly.MarkFinallyVisitor.visit(MarkFinallyVisitor.java:150)
             */
            @Override // android.content.ServiceConnection
            public synchronized void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                bk bkVar;
                try {
                    dx dxVarA = dx.b.a(iBinder);
                    if (dxVarA != null) {
                        try {
                            bk.this.d = dxVarA.a();
                            Log.d(bk.a, "Service onServiceConnected oaid = " + bk.this.d);
                            bkVar = bk.this;
                        } catch (RemoteException unused) {
                            bkVar = bk.this;
                        } catch (Throwable th) {
                            bk.this.e.countDown();
                            throw th;
                        }
                        bkVar.e.countDown();
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }

            @Override // android.content.ServiceConnection
            public void onServiceDisconnected(ComponentName componentName) {
                Log.i(bk.a, "Service onServiceDisconnected");
            }
        };
        try {
            Intent intent = new Intent();
            intent.setClassName(b, c);
            this.f.bindService(intent, serviceConnection, 1);
            if (!this.e.await(500L, TimeUnit.MILLISECONDS)) {
                Log.e(a, "getOAID time-out");
            }
            String str = this.d;
            this.f.unbindService(serviceConnection);
            return str;
        } catch (Throwable th) {
            try {
                Log.e(a, "getOAID interrupted. e=" + th.getMessage());
                return null;
            } finally {
                this.f.unbindService(serviceConnection);
            }
        }
    }
}

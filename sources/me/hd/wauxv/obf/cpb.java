package me.hd.wauxv.obf;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Message;
import android.os.RemoteException;
import android.provider.Settings;
import android.util.Log;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class cpb implements Handler.Callback, ServiceConnection {
    public final Context a;
    public final Handler b;
    public final HashMap c = new HashMap();
    public HashSet d = new HashSet();

    public cpb(Context context) {
        this.a = context;
        HandlerThread handlerThread = new HandlerThread("NotificationManagerCompat");
        handlerThread.start();
        this.b = new Handler(handlerThread.getLooper(), this);
    }

    public final void e(cpa cpaVar) {
        boolean z;
        ArrayDeque arrayDeque = cpaVar.d;
        ComponentName componentName = cpaVar.a;
        if (Log.isLoggable("NotifManCompat", 3)) {
            Log.d("NotifManCompat", "Processing component " + componentName + ", " + arrayDeque.size() + " queued tasks");
        }
        if (arrayDeque.isEmpty()) {
            return;
        }
        if (cpaVar.b) {
            z = true;
        } else {
            Intent component = new Intent("android.support.BIND_NOTIFICATION_SIDE_CHANNEL").setComponent(componentName);
            Context context = this.a;
            boolean zBindService = context.bindService(component, this, 33);
            cpaVar.b = zBindService;
            if (zBindService) {
                cpaVar.e = 0;
            } else {
                Log.w("NotifManCompat", "Unable to bind to listener " + componentName);
                context.unbindService(this);
            }
            z = cpaVar.b;
        }
        if (!z || cpaVar.c == null) {
            f(cpaVar);
            return;
        }
        while (true) {
            coy coyVar = (coy) arrayDeque.peek();
            if (coyVar == null) {
                break;
            }
            try {
                if (Log.isLoggable("NotifManCompat", 3)) {
                    Log.d("NotifManCompat", "Sending task " + coyVar);
                }
                coyVar.d(cpaVar.c);
                arrayDeque.remove();
            } catch (DeadObjectException unused) {
                if (Log.isLoggable("NotifManCompat", 3)) {
                    Log.d("NotifManCompat", "Remote service has died: " + componentName);
                }
            } catch (RemoteException e) {
                Log.w("NotifManCompat", "RemoteException communicating with " + componentName, e);
            }
        }
        if (arrayDeque.isEmpty()) {
            return;
        }
        f(cpaVar);
    }

    public final void f(cpa cpaVar) {
        ComponentName componentName = cpaVar.a;
        ArrayDeque arrayDeque = cpaVar.d;
        Handler handler = this.b;
        if (handler.hasMessages(3, componentName)) {
            return;
        }
        int i = cpaVar.e;
        int i2 = i + 1;
        cpaVar.e = i2;
        if (i2 <= 6) {
            int i3 = (1 << i) * 1000;
            if (Log.isLoggable("NotifManCompat", 3)) {
                Log.d("NotifManCompat", "Scheduling retry for " + i3 + " ms");
            }
            handler.sendMessageDelayed(handler.obtainMessage(3, componentName), i3);
            return;
        }
        Log.w("NotifManCompat", "Giving up on delivering " + arrayDeque.size() + " tasks to " + componentName + " after " + cpaVar.e + " retries");
        arrayDeque.clear();
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        HashSet hashSet;
        int i = message.what;
        bnw bnwVar = null;
        if (i == 0) {
            coy coyVar = (coy) message.obj;
            String string = Settings.Secure.getString(this.a.getContentResolver(), "enabled_notification_listeners");
            synchronized (cpc.a) {
                if (string != null) {
                    try {
                        if (!string.equals(cpc.b)) {
                            String[] strArrSplit = string.split(":", -1);
                            HashSet hashSet2 = new HashSet(strArrSplit.length);
                            for (String str : strArrSplit) {
                                ComponentName componentNameUnflattenFromString = ComponentName.unflattenFromString(str);
                                if (componentNameUnflattenFromString != null) {
                                    hashSet2.add(componentNameUnflattenFromString.getPackageName());
                                }
                            }
                            cpc.c = hashSet2;
                            cpc.b = string;
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                hashSet = cpc.c;
            }
            if (!hashSet.equals(this.d)) {
                this.d = hashSet;
                List<ResolveInfo> listQueryIntentServices = this.a.getPackageManager().queryIntentServices(new Intent().setAction("android.support.BIND_NOTIFICATION_SIDE_CHANNEL"), 0);
                HashSet<ComponentName> hashSet3 = new HashSet();
                for (ResolveInfo resolveInfo : listQueryIntentServices) {
                    if (hashSet.contains(resolveInfo.serviceInfo.packageName)) {
                        ServiceInfo serviceInfo = resolveInfo.serviceInfo;
                        ComponentName componentName = new ComponentName(serviceInfo.packageName, serviceInfo.name);
                        if (resolveInfo.serviceInfo.permission != null) {
                            Log.w("NotifManCompat", "Permission present on component " + componentName + ", not adding listener record.");
                        } else {
                            hashSet3.add(componentName);
                        }
                    }
                }
                for (ComponentName componentName2 : hashSet3) {
                    if (!this.c.containsKey(componentName2)) {
                        if (Log.isLoggable("NotifManCompat", 3)) {
                            Log.d("NotifManCompat", "Adding listener record for " + componentName2);
                        }
                        this.c.put(componentName2, new cpa(componentName2));
                    }
                }
                Iterator it = this.c.entrySet().iterator();
                while (it.hasNext()) {
                    Map.Entry entry = (Map.Entry) it.next();
                    if (!hashSet3.contains(entry.getKey())) {
                        if (Log.isLoggable("NotifManCompat", 3)) {
                            Log.d("NotifManCompat", "Removing listener record for " + entry.getKey());
                        }
                        cpa cpaVar = (cpa) entry.getValue();
                        if (cpaVar.b) {
                            this.a.unbindService(this);
                            cpaVar.b = false;
                        }
                        cpaVar.c = null;
                        it.remove();
                    }
                }
            }
            for (cpa cpaVar2 : this.c.values()) {
                cpaVar2.d.add(coyVar);
                e(cpaVar2);
            }
        } else if (i == 1) {
            coz cozVar = (coz) message.obj;
            ComponentName componentName3 = cozVar.a;
            IBinder iBinder = cozVar.b;
            cpa cpaVar3 = (cpa) this.c.get(componentName3);
            if (cpaVar3 != null) {
                int i2 = bnv.a;
                if (iBinder != null) {
                    IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(bnw.b);
                    if (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof bnw)) {
                        bnu bnuVar = new bnu();
                        bnuVar.a = iBinder;
                        bnwVar = bnuVar;
                    } else {
                        bnwVar = (bnw) iInterfaceQueryLocalInterface;
                    }
                }
                cpaVar3.c = bnwVar;
                cpaVar3.e = 0;
                e(cpaVar3);
                return true;
            }
        } else if (i == 2) {
            cpa cpaVar4 = (cpa) this.c.get((ComponentName) message.obj);
            if (cpaVar4 != null) {
                if (cpaVar4.b) {
                    this.a.unbindService(this);
                    cpaVar4.b = false;
                }
                cpaVar4.c = null;
                return true;
            }
        } else {
            if (i != 3) {
                return false;
            }
            cpa cpaVar5 = (cpa) this.c.get((ComponentName) message.obj);
            if (cpaVar5 != null) {
                e(cpaVar5);
                return true;
            }
        }
        return true;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        if (Log.isLoggable("NotifManCompat", 3)) {
            Log.d("NotifManCompat", "Connected to service " + componentName);
        }
        this.b.obtainMessage(1, new coz(componentName, iBinder)).sendToTarget();
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        if (Log.isLoggable("NotifManCompat", 3)) {
            Log.d("NotifManCompat", "Disconnected from service " + componentName);
        }
        this.b.obtainMessage(2, componentName).sendToTarget();
    }
}

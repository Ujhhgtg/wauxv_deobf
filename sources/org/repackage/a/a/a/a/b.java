package org.repackage.a.a.a.a;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import org.repackage.a.a.a.a;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public class b implements ServiceConnection {
    public final /* synthetic */ c a;

    public b(c cVar) {
        this.cachedConstructors = cVar;
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        this.cachedConstructors.cachedConstructors = a.AbstractBinderC0020a.a(iBinder);
        synchronized (this.cachedConstructors.d) {
            this.cachedConstructors.d.notify();
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        this.cachedConstructors.cachedConstructors = null;
    }
}

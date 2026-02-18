package me.hd.wauxv.obf;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.util.Log;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class dqa implements Iterable {
    public final ArrayList a = new ArrayList();
    public final Context b;

    public dqa(Context context) {
        this.b = context;
    }

    public final void c(ComponentName componentName) {
        Context context = this.b;
        ArrayList arrayList = this.a;
        int size = arrayList.size();
        try {
            for (Intent intentW = cna.w(context, componentName); intentW != null; intentW = cna.w(context, intentW.getComponent())) {
                arrayList.add(size, intentW);
            }
        } catch (PackageManager.NameNotFoundException e) {
            Log.e("TaskStackBuilder", "Bad ComponentName while traversing activity parent metadata");
            throw new IllegalArgumentException(e);
        }
    }

    public final void d() {
        ArrayList arrayList = this.a;
        if (arrayList.isEmpty()) {
            throw new IllegalStateException("No intents added to TaskStackBuilder; cannot startActivities");
        }
        Intent[] intentArr = (Intent[]) arrayList.toArray(new Intent[0]);
        intentArr[0] = new Intent(intentArr[0]).addFlags(268484608);
        this.b.startActivities(intentArr, null);
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        return this.a.iterator();
    }
}

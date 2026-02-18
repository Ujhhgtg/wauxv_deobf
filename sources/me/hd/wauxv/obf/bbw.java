package me.hd.wauxv.obf;

import android.content.Context;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class bbw implements Callable {
    public final /* synthetic */ int a;
    public final /* synthetic */ String b;
    public final /* synthetic */ Context c;
    public final /* synthetic */ int d;
    public final /* synthetic */ Object e;

    public /* synthetic */ bbw(String str, Context context, Object obj, int i, int i2) {
        this.a = i2;
        this.b = str;
        this.c = context;
        this.e = obj;
        this.d = i;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        switch (this.a) {
            case 0:
                Object[] objArr = {(bbt) this.e};
                ArrayList arrayList = new ArrayList(1);
                Object obj = objArr[0];
                Objects.requireNonNull(obj);
                arrayList.add(obj);
                return bbz.f(this.b, this.c, Collections.unmodifiableList(arrayList), this.d);
            default:
                try {
                    return bbz.f(this.b, this.c, (ArrayList) this.e, this.d);
                } catch (Throwable unused) {
                    return new bby(-3);
                }
        }
    }
}

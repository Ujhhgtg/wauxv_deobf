package me.hd.wauxv.obf;

import android.os.Build;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class asz extends cnh {
    public final /* synthetic */ ata a;

    public asz(ata ataVar) {
        this.a = ataVar;
    }

    @Override // me.hd.wauxv.obf.cnh
    public final void b(Throwable th) {
        this.a.a.o(th);
    }

    @Override // me.hd.wauxv.obf.cnh
    public final void c(chm chmVar) {
        ata ataVar = this.a;
        ataVar.c = chmVar;
        chm chmVar2 = ataVar.c;
        atf atfVar = ataVar.a;
        ataVar.b = new jx(chmVar2, atfVar.i, atfVar.k, Build.VERSION.SDK_INT >= 34 ? atk.a() : dqc.bc());
        atf atfVar2 = ataVar.a;
        atfVar2.getClass();
        ArrayList arrayList = new ArrayList();
        atfVar2.c.writeLock().lock();
        try {
            atfVar2.e = 1;
            arrayList.addAll(atfVar2.d);
            atfVar2.d.clear();
            atfVar2.c.writeLock().unlock();
            atfVar2.f.post(new np(arrayList, atfVar2.e, (Throwable) null));
        } catch (Throwable th) {
            atfVar2.c.writeLock().unlock();
            throw th;
        }
    }
}

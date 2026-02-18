package me.hd.wauxv.obf;

import android.os.Message;
import android.util.Log;
import io.github.rosemoe.sora.widget.CodeEditor;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class lh extends Thread {
    public volatile boolean b;
    public aff c;
    public long d;
    public dnv f;
    public io g;
    public final ik h;
    public final /* synthetic */ lj i;
    public final LinkedBlockingQueue a = new LinkedBlockingQueue();
    public final ArrayList e = new ArrayList();

    public lh(lj ljVar) {
        this.i = ljVar;
        this.h = new ik(ljVar, this);
    }

    public final boolean j(Message message) {
        int i;
        int i2;
        try {
            this.d = this.i.c;
            this.h.b = Integer.MAX_VALUE;
            switch (message.what) {
                case 11451401:
                    this.c = (aff) message.obj;
                    if (!this.b && !isInterrupted()) {
                        k();
                    }
                    return true;
                case 11451402:
                    if (this.b || isInterrupted()) {
                        i = 0;
                        i2 = 0;
                    } else {
                        li liVar = (li) message.obj;
                        long j = liVar.a;
                        i2 = (int) (j >> 32);
                        long j2 = liVar.b;
                        int i3 = (int) (j2 >> 32);
                        CharSequence charSequence = liVar.c;
                        if (charSequence == null) {
                            this.c.r(i2, (int) (j & 4294967295L), i3, (int) (j2 & 4294967295L));
                            dmk dmkVar = i2 == 0 ? new dmk() : ((bow) this.e.get(i2 - 1)).a;
                            int i4 = i2 + 1;
                            if (i3 >= i4) {
                                List listSubList = this.e.subList(i4, i3 + 1);
                                Iterator it = listSubList.iterator();
                                while (it.hasNext()) {
                                    this.i.x(((bow) it.next()).a);
                                }
                                listSubList.clear();
                            }
                            io ioVar = this.g;
                            ioVar.getClass();
                            erp erpVar = new erp(ioVar, 6);
                            for (int i5 = i4; i5 <= i3; i5++) {
                                erpVar.x(i4);
                            }
                            i = i2;
                            while (i < this.c.a.size()) {
                                bow bowVarAf = ((brc) this.i).af(this.c.y(i), dmkVar);
                                erpVar.aa(i, ((brc) this.i).ae(bowVarAf));
                                bow bowVar = (bow) this.e.set(i, bowVarAf);
                                if (bowVar != null) {
                                    this.i.x(bowVar.a);
                                }
                                this.i.y(bowVarAf.a);
                                if (!(bowVar == null ? null : bowVar.a).equals(bowVarAf.a)) {
                                    dmkVar = bowVarAf.a;
                                    i++;
                                }
                            }
                        } else {
                            this.c.ab(i2, (int) (j & 4294967295L), charSequence);
                            dmk dmkVar2 = i2 == 0 ? new dmk() : ((bow) this.e.get(i2 - 1)).a;
                            erp erpVar2 = new erp(this.f.a, 6);
                            int i6 = i2;
                            while (i6 <= i3) {
                                bow bowVarAf2 = ((brc) this.i).af(this.c.y(i6), dmkVar2);
                                if (i6 == i2) {
                                    erpVar2.aa(i6, ((brc) this.i).ae(bowVarAf2));
                                    bow bowVar2 = (bow) this.e.set(i6, bowVarAf2);
                                    if (bowVar2 != null) {
                                        this.i.x(bowVar2.a);
                                    }
                                } else {
                                    ArrayList arrayListAe = ((brc) this.i).ae(bowVarAf2);
                                    io ioVar2 = (io) erpVar2.v;
                                    ReentrantLock reentrantLock = (ReentrantLock) ioVar2.c;
                                    reentrantLock.lock();
                                    try {
                                        ((ArrayList) ioVar2.d).add(i6, new lg(arrayListAe));
                                        reentrantLock.unlock();
                                        this.e.add(i6, bowVarAf2);
                                    } catch (Throwable th) {
                                        reentrantLock.unlock();
                                        throw th;
                                    }
                                }
                                this.i.y(bowVarAf2.a);
                                dmkVar2 = bowVarAf2.a;
                                i6++;
                            }
                            i = i6;
                            boolean z = true;
                            while (i < this.c.a.size() && z) {
                                bow bowVarAf3 = ((brc) this.i).af(this.c.y(i), dmkVar2);
                                if (bowVarAf3.a.equals(((bow) this.e.get(i)).a)) {
                                    z = false;
                                }
                                erpVar2.aa(i, ((brc) this.i).ae(bowVarAf3));
                                bow bowVar3 = (bow) this.e.set(i, bowVarAf3);
                                if (bowVar3 != null) {
                                    this.i.x(bowVar3.a);
                                }
                                this.i.y(bowVarAf3.a);
                                dmkVar2 = bowVarAf3.a;
                                i++;
                            }
                        }
                    }
                    ArrayList arrayListV = this.i.v(this.c, this.h);
                    if (this.h.t()) {
                        dnv dnvVar = this.f;
                        dnvVar.b = arrayListV;
                        dnvVar.d();
                        this.f.c = this.h.b;
                    }
                    if (!this.b) {
                        lj ljVar = this.i;
                        dnv dnvVar2 = this.f;
                        jx jxVar = (jx) ljVar.g;
                        if (jxVar != null) {
                            cjn cjnVar = new cjn(i2, i);
                            CodeEditor codeEditor = (CodeEditor) ((WeakReference) jxVar.e).get();
                            if (codeEditor != null && ljVar == codeEditor.getEditorLanguage().e()) {
                                jxVar.af(new ale(codeEditor, dnvVar2, cjnVar, 1));
                                return true;
                            }
                        }
                    }
                    return true;
                default:
                    return true;
            }
        } catch (Exception e) {
            Log.w("AsyncAnalysis", "Thread " + Thread.currentThread().getName() + " failed", e);
            return false;
        }
    }

    public final void k() {
        io ioVar = new io(7);
        this.g = ioVar;
        dnv dnvVar = new dnv();
        dnvVar.c = Integer.MAX_VALUE;
        dnvVar.a = ioVar;
        dnvVar.b = new ArrayList(128);
        this.f = dnvVar;
        dmk dmkVar = new dmk();
        io ioVar2 = this.g;
        ioVar2.getClass();
        int i = 0;
        while (i < this.c.a.size() && !this.b && !isInterrupted()) {
            bow bowVarAf = ((brc) this.i).af(this.c.y(i), dmkVar);
            dmk dmkVar2 = bowVarAf.a;
            ArrayList arrayListAe = ((brc) this.i).ae(bowVarAf);
            this.e.add(bowVarAf);
            this.i.y(bowVarAf.a);
            ReentrantLock reentrantLock = (ReentrantLock) ioVar2.c;
            reentrantLock.lock();
            try {
                ((ArrayList) ioVar2.d).add(i, new lg(arrayListAe));
                reentrantLock.unlock();
                i++;
                dmkVar = dmkVar2;
            } catch (Throwable th) {
                reentrantLock.unlock();
                throw th;
            }
        }
        this.f.b = this.i.v(this.c, this.h);
        dnv dnvVar2 = this.f;
        dnvVar2.c = this.h.b;
        dnvVar2.d();
        if (this.b) {
            return;
        }
        this.i.z(this.f);
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        while (!this.b && !isInterrupted()) {
            try {
                Message message = (Message) this.a.take();
                if (!j(message)) {
                    return;
                } else {
                    message.recycle();
                }
            } catch (InterruptedException unused) {
                return;
            }
        }
    }
}

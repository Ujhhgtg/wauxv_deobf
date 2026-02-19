package me.hd.wauxv.obf;

import android.os.Message;
import io.github.rosemoe.sora.widget.CodeEditor;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public abstract class lj extends hz {
    public static int a;
    public lh b;
    public volatile long c;

    @Override // me.hd.wauxv.obf.hz
    public final void j(ud udVar, ud udVar2) {
        if (this.b != null) {
            w();
            lh lhVar = this.b;
            li liVar = new li(KotlinHelpers.al(udVar.b, udVar.c), KotlinHelpers.al(udVar2.b, udVar2.c), null);
            lhVar.getClass();
            Message messageObtain = Message.obtain();
            messageObtain.what = 11451402;
            messageObtain.obj = liVar;
            lhVar.a.offer(messageObtain);
        }
    }

    @Override // me.hd.wauxv.obf.hz
    public final void k() {
        lh lhVar = this.b;
        if (lhVar != null) {
            if (lhVar.isAlive()) {
                this.b.interrupt();
            }
            this.b.b = true;
        }
        this.b = null;
        super.k();
    }

    @Override // me.hd.wauxv.obf.hz
    public final void p(ud udVar, ud udVar2, CharSequence charSequence) {
        if (this.b != null) {
            w();
            lh lhVar = this.b;
            li liVar = new li(KotlinHelpers.al(udVar.b, udVar.c), KotlinHelpers.al(udVar2.b, udVar2.c), charSequence);
            lhVar.getClass();
            Message messageObtain = Message.obtain();
            messageObtain.what = 11451402;
            messageObtain.obj = liVar;
            lhVar.a.offer(messageObtain);
        }
    }

    @Override // me.hd.wauxv.obf.hz
    public final void r() {
        int i;
        lh lhVar = this.b;
        if (lhVar != null) {
            if (lhVar.isAlive()) {
                this.b.interrupt();
                this.b.b = true;
            }
            this.b = null;
        }
        afq afqVar = (afq) this.h;
        if (afqVar != null) {
            aff affVar = (aff) afqVar.b;
            ArrayList arrayList = affVar.a;
            affVar.ae(false);
            try {
                aff affVar2 = new aff(null, false);
                ArrayList arrayList2 = affVar2.a;
                arrayList2.remove(0);
                arrayList2.ensureCapacity(arrayList.size());
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    arrayList2.add(new afo((afo) it.next()));
                }
                affVar2.d = affVar.d;
                affVar.ap(false);
                affVar2.ak(false);
                lh lhVar2 = new lh(this);
                this.b = lhVar2;
                StringBuilder sb = new StringBuilder("AsyncAnalyzer-");
                synchronized (lj.class) {
                    i = a + 1;
                    a = i;
                }
                sb.append(i);
                lhVar2.setName(sb.toString());
                lh lhVar3 = this.b;
                lhVar3.getClass();
                Message messageObtain = Message.obtain();
                messageObtain.what = 11451401;
                messageObtain.obj = affVar2;
                lhVar3.a.offer(messageObtain);
                w();
                z(null);
                this.b.start();
            } catch (Throwable th) {
                affVar.ap(false);
                throw th;
            }
        }
    }

    public abstract ArrayList v(aff affVar, ik ikVar);

    public final synchronized void w() {
        this.c++;
    }

    public abstract void x(dmk dmkVar);

    public abstract void y(dmk dmkVar);

    public final void z(dnv dnvVar) {
        CodeEditor codeEditor;
        FactoryPools factoryPoolsVar = (FactoryPools) this.g;
        if (factoryPoolsVar == null || (codeEditor = (CodeEditor) ((WeakReference) factoryPoolsVar.e).get()) == null || this != codeEditor.getEditorLanguage().e()) {
            return;
        }
        factoryPoolsVar.af(new hl(codeEditor, 3, dnvVar));
    }
}

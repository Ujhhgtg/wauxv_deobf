package me.hd.wauxv.obf;

import java.io.File;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class alu implements dft {
    public final /* synthetic */ int a;
    public final Object b;
    public final Object c;

    public alu(File file) {
        this.a = 1;
        this.b = file;
        this.c = bac.a;
    }

    @Override // me.hd.wauxv.obf.dft
    public final Iterator iterator() {
        switch (this.a) {
            case 0:
                return new alt(this);
            case 1:
                return new baa(this);
            default:
                return new bgy(this);
        }
    }

    public alu(IFunction0 bfuVar, IInvokable bgfVar) {
        this.a = 2;
        this.b = bfuVar;
        this.c = bgfVar;
    }

    public alu(CharSequence charSequence, bgj bgjVar) {
        this.a = 0;
        throwIfVar1IsNull(charSequence, "input");
        this.b = charSequence;
        this.c = bgjVar;
    }
}

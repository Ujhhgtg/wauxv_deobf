package me.hd.wauxv.obf;

import java.util.Iterator;
import java.util.regex.Matcher;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class bzw extends r {
    public final /* synthetic */ bzx b;

    public bzw(bzx bzxVar) {
        this.b = bzxVar;
    }

    @Override // me.hd.wauxv.obf.r
    public final int a() {
        return this.b.a.groupCount() + 1;
    }

    public final bzt c(int i) {
        Matcher matcher = this.b.a;
        bqi bqiVarBm = dqc.bm(matcher.start(i), matcher.end(i));
        if (bqiVarBm.a < 0) {
            return null;
        }
        String strGroup = matcher.group(i);
        throwIfVar1IsNull(strGroup, "group(...)");
        return new bzt(strGroup, bqiVarBm);
    }

    @Override // me.hd.wauxv.obf.r, java.util.Collection, java.util.List
    public final /* bridge */ boolean contains(Object obj) {
        if (obj == null ? true : obj instanceof bzt) {
            return super.contains((bzt) obj);
        }
        return false;
    }

    @Override // me.hd.wauxv.obf.r, java.util.Collection
    public final boolean isEmpty() {
        return false;
    }

    @Override // java.util.Collection, java.lang.Iterable
    public final Iterator iterator() {
        return new elf(new dpu(aaz.a(new bqi(0, a() - 1, 1)), new q(this, 6), 1));
    }
}

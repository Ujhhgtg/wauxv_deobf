package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class gx extends doo implements bne {
    public static final gx a = new gx(cnb.z(-410341175458602L));
    public static final String b = cnb.z(-410534448986922L);
    public static final String c = cnb.z(-410551628856106L);
    public static final String d = cnb.z(-410521564085034L);
    public static final boolean h = true;

    @Override // me.hd.wauxv.obf.bmf
    public final void e() {
    }

    @Override // me.hd.wauxv.obf.doo
    public final String f() {
        return c;
    }

    @Override // me.hd.wauxv.obf.doo
    public final String g() {
        return b;
    }

    public final void i(bmm bmmVar, CharSequence charSequence, boolean z) {
        if (z() && z) {
            boolean z2 = true;
            boolean z3 = charSequence.equals(cnb.z(-410225211341610L)) || charSequence.equals(cnb.z(-410250981145386L));
            boolean z4 = charSequence.equals(cnb.z(-410220916374314L)) || charSequence.equals(cnb.z(-410177966701354L));
            if (!charSequence.equals(cnb.z(-410130722061098L)) && !charSequence.equals(cnb.z(-410607463430954L))) {
                z2 = false;
            }
            if (z3 || z4 || z2) {
                bmmVar.getClass();
                new ek(bmmVar, 4, 8).q(Boolean.FALSE);
            }
        }
    }

    @Override // me.hd.wauxv.obf.doo
    public final String o() {
        return d;
    }

    @Override // me.hd.wauxv.obf.doo
    public final boolean q() {
        return h;
    }
}

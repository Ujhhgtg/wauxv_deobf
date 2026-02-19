package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class azf extends p {
    public final aze h;
    public String i;
    public final StringBuilder j;

    public azf(char c, int i, int i2) {
        aze azeVar = new aze();
        this.h = azeVar;
        this.j = new StringBuilder();
        azeVar.d = c;
        azeVar.e = i;
        azeVar._bl = i2;
    }

    @Override // me.hd.wauxv.obf.p
    public final void a(CharSequence charSequence) {
        if (this.i == null) {
            this.i = charSequence.toString();
            return;
        }
        StringBuilder sb = this.j;
        sb.append(charSequence);
        sb.append('\n');
    }

    @Override // me.hd.wauxv.obf.p
    public final void c() {
        String strE = awq.e(this.i.trim());
        aze azeVar = this.h;
        azeVar.g = strE;
        azeVar.h = this.j.toString();
    }

    @Override // me.hd.wauxv.obf.p
    public final pd d() {
        return this.h;
    }

    @Override // me.hd.wauxv.obf.p
    public final pf g(aph aphVar) {
        int i = aphVar.g;
        int i2 = aphVar.d;
        CharSequence charSequence = aphVar.c;
        int i3 = aphVar.i;
        aze azeVar = this.h;
        if (i3 < 4) {
            char c = azeVar.d;
            int i4 = azeVar.e;
            int iAu = StaticAndroidHelpers.au(c, i, charSequence.length(), charSequence) - i;
            if (iAu >= i4 && StaticAndroidHelpers.av(i + iAu, charSequence.length(), charSequence) == charSequence.length()) {
                return new pf(-1, -1, true);
            }
        }
        int length = charSequence.length();
        for (int i5 = azeVar._bl; i5 > 0 && i2 < length && charSequence.charAt(i2) == ' '; i5--) {
            i2++;
        }
        return pf.d(i2);
    }
}

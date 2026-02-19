package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class biv {
    public static final biu Companion = new biu();
    public static final IHasGetValue[] a = { null, null, null, null, ewz.am(btx.a, new amd(10)) };
    public final String b;
    public final int c;
    public final String d;
    public final boolean e;
    public final String[] f;

    public /* synthetic */ biv(int i, String str, int i2, String str2, boolean z, String[] strArr) {
        if (31 != (i & 31)) {
            ResourcesCompat.ah(i, 31, bit.b.getDescriptor());
            throw null;
        }
        this.b = str;
        this.c = i2;
        this.d = str2;
        this.e = z;
        this.f = strArr;
    }

    public final String g(String str) {
        Object next;
        KotlinEnumEntriesImpl kotlinEnumEntriesImplVar = bis.c;
        kotlinEnumEntriesImplVar.getClass();
        z zVar = new z(kotlinEnumEntriesImplVar, 0);
        do {
            if (!zVar.hasNext()) {
                next = null;
                break;
            }
            next = zVar.next();
        } while (!((bis) next).d.equals(str));
        bis bisVar = (bis) next;
        if (bisVar != null) {
            return bisVar.e;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(" where (username in " /* " where (username in " /* " where (username in " /* cnb.z(-593036199328554L)  */);
        return yg.decryptVar3UsingCnbZAndConcatToVar1(sb, SomeStaticHelpers.joinToString(this.f, null, "(" /* "(" /* "(" /* cnb.z(-592928825146154L)  */, ")" /* ")" /* ")" /* cnb.z(-592937415080746L)  */,
                new bep(2), 25), -592946005015338L);
    }

    public biv(String str, int i, String str2, String[] strArr) {
        this.b = str;
        this.c = i;
        this.d = str2;
        this.e = true;
        this.f = strArr;
    }
}

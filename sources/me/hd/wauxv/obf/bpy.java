package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class bpy implements IConvertableToInstant {
    public final String a;
    public String b;

    public bpy(String str) {
        this.a = str;
        this.b = "";
    }

    @Override // me.hd.wauxv.obf.bqa
    public Instant toInstant() {
        throw new bpx(this.a + " when parsing an Instant from \"" + FastKV.bg(64, this.b) + '\"');
    }

    public bpy(String str, String str2) {
        throwIfVar1IsNull(str, com.umeng.analytics.pro.f.U);
        this.a = str;
        this.b = str2;
    }
}

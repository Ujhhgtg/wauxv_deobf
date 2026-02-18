package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public interface avt {
    void aa(int i);

    void ab(long j);

    default void ac(btd btdVar, Object obj) {
        bzo.q(btdVar, "serializer");
        if (btdVar.getDescriptor().f()) {
            x(btdVar, obj);
        } else if (obj == null) {
            q();
        } else {
            x(btdVar, obj);
        }
    }

    void ad(String str);

    acn o(dfx dfxVar);

    cbm p();

    void q();

    avt r(dfx dfxVar);

    void s(double d);

    void t(short s);

    void u(byte b);

    acn v(dfx dfxVar, int i);

    void w(boolean z);

    void x(btd btdVar, Object obj);

    void y(float f);

    void z(char c);
}

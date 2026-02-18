package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public interface ero {
    default erk _bh(zc zcVar, chq chqVar) {
        return l(cnf.bd(zcVar), chqVar);
    }

    default erk b(Class cls) {
        throw new UnsupportedOperationException("`Factory.create(String, CreationExtras)` is not implemented. You may need to override the method and provide a custom implementation. Note that using `Factory.create(String)` is not supported and considered an error.");
    }

    default erk l(Class cls, chq chqVar) {
        return b(cls);
    }
}

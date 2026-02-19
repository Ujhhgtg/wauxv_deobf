package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public abstract class kv {
    public static final int a;

    static {
        Object objX;
        try {
            String property = System.getProperty("kotlinx.serialization.json.pool.size");
            objX = property != null ? dnq.bf(property) : null;
        } catch (Throwable th) {
            objX = FastKV.getFailureFromException(th);
        }
        Integer num = (Integer) (objX instanceof Failure ? null : objX);
        a = num != null ? num.intValue() : 2097152;
    }
}

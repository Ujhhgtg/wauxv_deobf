package me.hd.wauxv.obf;

import net.bytebuddy.pool.TypePool;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class cjq extends cju {
    public final Class a;

    public cjq(Class cls) {
        super(cls, 0);
        if (cls.isEnum()) {
            this.a = cls;
            return;
        }
        throw new IllegalArgumentException((cls + " is not an Enum type.").toString());
    }

    @Override // me.hd.wauxv.obf.cju, me.hd.wauxv.obf.cjv
    /*
     * JADX INFO: renamed from: d, reason: merged with bridge method
     * [inline-methods]
     */
    public final Enum i(String str) {
        Object obj;
        throwIfVar1IsNull(str, "value");
        Class cls = this.a;
        Object[] enumConstants = cls.getEnumConstants();
        throwIfVar1IsNull(enumConstants, "getEnumConstants(...)");
        int length = enumConstants.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                obj = null;
                break;
            }
            obj = enumConstants[i];
            if (dnr.bj(((Enum) obj).name(), str, true)) {
                break;
            }
            i++;
        }
        Enum r4 = (Enum) obj;
        if (r4 != null) {
            return r4;
        }
        StringBuilder sbZ = StaticHelpers6.concatAndToSb("Enum value ", str, " not found for type ");
        sbZ.append(cls.getName());
        sbZ.append(TypePool.Default.LazyTypeDescription.GenericTypeToken.INNER_CLASS_PATH);
        throw new IllegalArgumentException(sbZ.toString());
    }

    @Override // me.hd.wauxv.obf.cju, me.hd.wauxv.obf.cjv
    public final String g() {
        return this.a.getName();
    }
}

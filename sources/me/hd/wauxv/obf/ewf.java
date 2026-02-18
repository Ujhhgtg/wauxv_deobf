package me.hd.wauxv.obf;

import net.bytebuddy.pool.TypePool;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class ewf {
    public static final ewf a;
    public static final ewf b;
    public static final ewf c;
    public static final ewf d;
    public static final /* synthetic */ ewf[] e;
    public static final /* synthetic */ awn f;
    public final char g;
    public final char h;

    static {
        ewf ewfVar = new ewf("OBJ", 0, '{', '}');
        a = ewfVar;
        ewf ewfVar2 = new ewf("LIST", 1, TypePool.Default.LazyTypeDescription.GenericTypeToken.COMPONENT_TYPE_PATH, ']');
        b = ewfVar2;
        ewf ewfVar3 = new ewf("MAP", 2, '{', '}');
        c = ewfVar3;
        ewf ewfVar4 = new ewf("POLY_OBJ", 3, TypePool.Default.LazyTypeDescription.GenericTypeToken.COMPONENT_TYPE_PATH, ']');
        d = ewfVar4;
        ewf[] ewfVarArr = {ewfVar, ewfVar2, ewfVar3, ewfVar4};
        e = ewfVarArr;
        f = new awn(ewfVarArr);
    }

    public ewf(String str, int i, char c2, char c3) {
        this.g = c2;
        this.h = c3;
    }

    public static ewf valueOf(String str) {
        return (ewf) Enum.valueOf(ewf.class, str);
    }

    public static ewf[] values() {
        return (ewf[]) e.clone();
    }
}

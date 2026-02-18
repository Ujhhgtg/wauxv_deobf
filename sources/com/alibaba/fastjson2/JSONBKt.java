package com.alibaba.fastjson2;

import com.alibaba.fastjson2.JSONWriter;
import java.util.Arrays;
import me.hd.wauxv.obf.bzo;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class JSONBKt {
    public static final byte[] toJSONB(boolean z) {
        return JSONB.toBytes(z);
    }

    public static final byte[] toJSONB(int i) {
        return JSONB.toBytes(i);
    }

    public static final byte[] toJSONB(long j) {
        return JSONB.toBytes(j);
    }

    public static final byte[] toJSONB(Object obj) {
        return JSONB.toBytes(obj);
    }

    public static final byte[] toJSONB(Object obj, SymbolTable symbolTable) {
        bzo.q(symbolTable, "symbolTable");
        return JSONB.toBytes(obj, symbolTable);
    }

    public static final byte[] toJSONB(Object obj, SymbolTable symbolTable, JSONWriter.Feature... featureArr) {
        bzo.q(symbolTable, "symbolTable");
        bzo.q(featureArr, "features");
        return JSONB.toBytes(obj, symbolTable, (JSONWriter.Feature[]) Arrays.copyOf(featureArr, featureArr.length));
    }
}

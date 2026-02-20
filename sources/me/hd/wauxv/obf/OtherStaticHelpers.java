package me.hd.wauxv.obf;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public abstract class OtherStaticHelpers extends dqc {
    public static int af(List list) {
        throwIfVar1IsNull(list, "<this>");
        return list.size() - 1;
    }

    public static List argsToList(Object... objArr) {
        throwIfVar1IsNull(objArr, "elements");
        return objArr.length > 0 ? SomeStaticHelpers.toList(objArr) : EmptyReadonlyList.INSTANCE;
    }

    public static ArrayList ah(Object... objArr) {
        throwIfVar1IsNull(objArr, "elements");
        return objArr.length == 0 ? new ArrayList() : new ArrayList(new ReadonlyArray(objArr, true));
    }

    public static final List ai(List list) {
        int size = list.size();
        return size != 0 ? size != 1 ? list : dqc.toSingletonList(list.get(0)) : EmptyReadonlyList.INSTANCE;
    }

    public static void aj() {
        throw new ArithmeticException("Index overflow has happened.");
    }
}

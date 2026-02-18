package net.bytebuddy.utility;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public class CompoundList {
    private CompoundList() {
        throw new UnsupportedOperationException("This class is a utility class and not supposed to be instantiated");
    }

    public static <S> List<S> of(S s, List<? extends S> list) {
        if (list.isEmpty()) {
            return Collections.singletonList(s);
        }
        ArrayList arrayList = new ArrayList(list.size() + 1);
        arrayList.add(s);
        arrayList.addAll(list);
        return arrayList;
    }

    public static <S> List<S> of(List<? extends S> list, S s) {
        if (list.isEmpty()) {
            return Collections.singletonList(s);
        }
        ArrayList arrayList = new ArrayList(list.size() + 1);
        arrayList.addAll(list);
        arrayList.add(s);
        return arrayList;
    }

    public static <S> List<S> of(List<? extends S> list, List<? extends S> list2) {
        ArrayList arrayList = new ArrayList(list2.size() + list.size());
        arrayList.addAll(list);
        arrayList.addAll(list2);
        return arrayList;
    }

    public static <S> List<S> of(List<? extends S> list, List<? extends S> list2, List<? extends S> list3) {
        ArrayList arrayList = new ArrayList(list3.size() + list2.size() + list.size());
        arrayList.addAll(list);
        arrayList.addAll(list2);
        arrayList.addAll(list3);
        return arrayList;
    }
}

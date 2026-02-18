package me.hd.wauxv.obf;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class eoz {
    public static final eoz a = new eoz();

    public static String b(Object obj) {
        Class cls;
        if (obj instanceof eoz) {
            return "VagueType";
        }
        cls = eoz.class;
        if (obj instanceof Class) {
            Class<eoz> clsBf = cnf.bf(dal.b(cls));
            return !obj.equals(clsBf != null ? clsBf : eoz.class) ? ((Class) obj).toString() : "VagueType";
        }
        if (obj instanceof bsv) {
            return !obj.equals(dal.b(cls)) ? obj.toString() : "VagueType";
        }
        if (!(obj instanceof Collection)) {
            return obj.toString();
        }
        Iterable iterable = (Iterable) obj;
        ArrayList arrayList = new ArrayList(abb.ak(iterable, 10));
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            Object next = it.next();
            arrayList.add(next != null ? b(next) : null);
        }
        return arrayList.toString();
    }
}

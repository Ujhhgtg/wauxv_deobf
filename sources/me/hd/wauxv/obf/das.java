package me.hd.wauxv.obf;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class das {
    public final but a;
    public final avw b;
    public final but c;
    public final avw d;
    public final aji e;
    public final avw f;
    public final avw g;
    public final but h = new but(2);
    public final bwu i = new bwu();
    public final jx j;

    public das() {
        jx jxVar = new jx(new cux(20), new awp(4), new awp(5));
        this.j = jxVar;
        this.a = new but(jxVar);
        this.b = new avw(0);
        this.c = new but(7);
        this.d = new avw(2);
        this.e = new aji(0);
        this.f = new avw(3);
        this.g = new avw(1);
        List listAsList = Arrays.asList("Animation", "Bitmap", "BitmapDrawable");
        ArrayList arrayList = new ArrayList(listAsList.size());
        arrayList.add("legacy_prepend_all");
        Iterator it = listAsList.iterator();
        while (it.hasNext()) {
            arrayList.add((String) it.next());
        }
        arrayList.add("legacy_append");
        but butVar = this.c;
        synchronized (butVar) {
            try {
                ArrayList<String> arrayList2 = new ArrayList((ArrayList) butVar.c);
                ((ArrayList) butVar.c).clear();
                Iterator it2 = arrayList.iterator();
                while (it2.hasNext()) {
                    ((ArrayList) butVar.c).add((String) it2.next());
                }
                for (String str : arrayList2) {
                    if (!arrayList.contains(str)) {
                        ((ArrayList) butVar.c).add(str);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void k(Class cls, Class cls2, cdw cdwVar) {
        but butVar = this.a;
        synchronized (butVar) {
            chm chmVar = (chm) butVar.b;
            synchronized (chmVar) {
                try {
                    chl chlVar = new chl(cls, cls2, cdwVar);
                    ArrayList arrayList = (ArrayList) chmVar.c;
                    arrayList.add(arrayList.size(), chlVar);
                } catch (Throwable th) {
                    throw th;
                }
            }
            ((aji) butVar.c).b.clear();
        }
    }

    public final void l(Class cls, avu avuVar) {
        avw avwVar = this.b;
        synchronized (avwVar) {
            avwVar.a.add(new avv(cls, avuVar));
        }
    }

    public final void m(Class cls, dcm dcmVar) {
        avw avwVar = this.d;
        synchronized (avwVar) {
            avwVar.a.add(new dcn(cls, dcmVar));
        }
    }

    public final void n(String str, Class cls, Class cls2, dcj dcjVar) {
        but butVar = this.c;
        synchronized (butVar) {
            butVar.q(str).add(new dck(cls, cls2, dcjVar));
        }
    }

    public final ArrayList o() {
        ArrayList arrayList;
        avw avwVar = this.g;
        synchronized (avwVar) {
            arrayList = avwVar.a;
        }
        if (arrayList.isEmpty()) {
            throw new dar("Failed to find image header parser.");
        }
        return arrayList;
    }

    public final List p(Object obj) {
        List listUnmodifiableList;
        but butVar = this.a;
        butVar.getClass();
        Class<?> cls = obj.getClass();
        synchronized (butVar) {
            cdx cdxVar = (cdx) ((aji) butVar.c).b.get(cls);
            listUnmodifiableList = cdxVar == null ? null : cdxVar.a;
            if (listUnmodifiableList == null) {
                listUnmodifiableList = Collections.unmodifiableList(((chm) butVar.b).v(cls));
                if (((cdx) ((aji) butVar.c).b.put(cls, new cdx(listUnmodifiableList))) != null) {
                    throw new IllegalStateException("Already cached loaders for model: " + cls);
                }
            }
        }
        if (listUnmodifiableList.isEmpty()) {
            throw new dar(concatVar1GetClass(obj,
                    new StringBuilder("Failed to find any ModelLoaders registered for model class: ")));
        }
        int size = listUnmodifiableList.size();
        List arrayList = Collections.EMPTY_LIST;
        boolean z = true;
        for (int i = 0; i < size; i++) {
            cdv cdvVar = (cdv) listUnmodifiableList.get(i);
            if (cdvVar.d(obj)) {
                if (z) {
                    arrayList = new ArrayList(size - i);
                    z = false;
                }
                arrayList.add(cdvVar);
            }
        }
        if (!arrayList.isEmpty()) {
            return arrayList;
        }
        throw new dar("Found ModelLoaders for model class: " + listUnmodifiableList
                + ", but none that handle this specific model instance: " + obj);
    }

    public final ajh q(Object obj) {
        ajh ajhVarC;
        aji ajiVar = this.e;
        synchronized (ajiVar) {
            try {
                cmz.m(obj);
                ajg ajgVar = (ajg) ajiVar.b.get(obj.getClass());
                if (ajgVar == null) {
                    for (ajg ajgVar2 : ajiVar.b.values()) {
                        if (ajgVar2.b().isAssignableFrom(obj.getClass())) {
                            ajgVar = ajgVar2;
                            break;
                        }
                    }
                }
                if (ajgVar == null) {
                    ajgVar = aji.a;
                }
                ajhVarC = ajgVar.c(obj);
            } catch (Throwable th) {
                throw th;
            }
        }
        return ajhVarC;
    }

    public final void r(Class cls, Class cls2, dcq dcqVar) {
        avw avwVar = this.f;
        synchronized (avwVar) {
            avwVar.a.add(new ekz(cls, cls2, dcqVar));
        }
    }

    public final void s(ajg ajgVar) {
        aji ajiVar = this.e;
        synchronized (ajiVar) {
            ajiVar.b.put(ajgVar.b(), ajgVar);
        }
    }
}

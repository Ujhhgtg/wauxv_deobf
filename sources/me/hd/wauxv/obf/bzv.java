package me.hd.wauxv.obf;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class bzv extends ac {
    public final /* synthetic */ int b;
    public final Object c;

    public /* synthetic */ bzv(Object obj, int i) {
        this.b = i;
        this.c = obj;
    }

    @Override // me.hd.wauxv.obf.r
    public final int a() {
        switch (this.b) {
            case 0:
                return ((bzx) this.c).a.groupCount() + 1;
            case 1:
                return ((List) this.c).size();
            default:
                return ((ArrayList) this.c).size();
        }
    }

    @Override // me.hd.wauxv.obf.r, java.util.Collection, java.util.List
    public /* bridge */ boolean contains(Object obj) {
        switch (this.b) {
            case 0:
                if (obj instanceof String) {
                    return super.contains((String) obj);
                }
                return false;
            default:
                return super.contains(obj);
        }
    }

    @Override // java.util.List
    public final Object get(int i) {
        switch (this.b) {
            case 0:
                String strGroup = ((bzx) this.c).a.group(i);
                return strGroup == null ? "" : strGroup;
            case 1:
                List list = (List) this.c;
                if (i >= 0 && i <= OtherStaticHelpers.af(this)) {
                    return list.get(OtherStaticHelpers.af(this) - i);
                }
                StringBuilder sbR = yg.concatVar213(i, "Element index ", " must be in range [");
                sbR.append(new IntRange(0, OtherStaticHelpers.af(this), 1));
                sbR.append("].");
                throw new IndexOutOfBoundsException(sbR.toString());
            default:
                return ((ArrayList) this.c).get((r0.size() - 1) - i);
        }
    }

    @Override // me.hd.wauxv.obf.ac, java.util.List
    public /* bridge */ int indexOf(Object obj) {
        switch (this.b) {
            case 0:
                if (obj instanceof String) {
                    return super.indexOf((String) obj);
                }
                return -1;
            default:
                return super.indexOf(obj);
        }
    }

    @Override // me.hd.wauxv.obf.ac, java.util.Collection, java.lang.Iterable, java.util.List
    public Iterator iterator() {
        switch (this.b) {
            case 1:
                return new dcz(this, 0);
            default:
                return super.iterator();
        }
    }

    @Override // me.hd.wauxv.obf.ac, java.util.List
    public /* bridge */ int lastIndexOf(Object obj) {
        switch (this.b) {
            case 0:
                if (obj instanceof String) {
                    return super.lastIndexOf((String) obj);
                }
                return -1;
            default:
                return super.lastIndexOf(obj);
        }
    }

    @Override // me.hd.wauxv.obf.ac, java.util.List
    public ListIterator listIterator() {
        switch (this.b) {
            case 1:
                return new dcz(this, 0);
            default:
                return super.listIterator();
        }
    }

    @Override // me.hd.wauxv.obf.ac, java.util.List
    public ListIterator listIterator(int i) {
        switch (this.b) {
            case 1:
                return new dcz(this, i);
            default:
                return super.listIterator(i);
        }
    }
}

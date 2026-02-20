package me.hd.wauxv.obf;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import me.hd.wauxv.data.bean.ConversationBean;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class cxa implements bgj {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;

    public /* synthetic */ cxa(Object obj, int i) {
        this.a = i;
        this.b = obj;
    }

    /* JADX WARN: Found duplicated region for block: B:11:0x003a */
    /* JADX WARN: Found duplicated region for block: B:37:0x00a5 A[DONT_INVERT] */
    /*
     * JADX WARN: Found duplicated region for block: B:38:0x00a7 A[LOOP:0:
     * B:27:0x0076->B:38:0x00a7, LOOP_END]
     */
    /* JADX WARN: Found duplicated region for block: B:71:0x009b A[SYNTHETIC] */
    /* JADX WARN: Found duplicated region for block: B:72:0x003a A[SYNTHETIC] */
    @Override // me.hd.wauxv.obf.bgj
    public final Object g(Object obj, Object obj2) {
        int i;
        Object next;
        Pair pairVar;
        Object next2;
        String str;
        String str2;
        switch (this.a) {
            case 0:
                ConversationBean conversationBean = (ConversationBean) this.b;
                List list = (List) obj;
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    String str3 = ((adx) it.next()).a;
                    List listBf = dqc.toSingletonList(conversationBean.getUsername());
                    clu.a.getClass();
                    cme.b(cme.a, StaticHelpers7.toDexConstructor(clt.a).newInstance(str3, listBf, 0, null));
                }
                dnc.sendToast(null, 3, "已邀请至" /* "已邀请至" /* "已邀请至" /* "已邀请至" /* cnb.z(-527104156367658L)   */ + list.size() + "个群聊" /*
                                                                                            * "个群聊" /* "个群聊" /* "个群聊" /* cnb.z(-527048321792810L)  */
                                                                                            */);
                return Boolean.FALSE;
            case 1:
                char[] cArr = (char[]) this.b;
                CharSequence charSequence = (CharSequence) obj;
                int iIntValue = ((Integer) obj2).intValue();
                throwIfVar1IsNull(charSequence, "$this$DelimitedRangesSequence");
                int iAj = StringsKt.indexOfAny(charSequence, cArr, iIntValue, false);
                if (iAj < 0) {
                    return null;
                }
                return new Pair(Integer.valueOf(iAj), 1);
            default:
                List list2 = (List) this.b;
                CharSequence charSequence2 = (CharSequence) obj;
                int iIntValue2 = ((Integer) obj2).intValue();
                throwIfVar1IsNull(charSequence2, "$this$DelimitedRangesSequence");
                if (list2.size() == 1) {
                    int size = list2.size();
                    if (size == 0) {
                        throw new NoSuchElementException("List is empty.");
                    }
                    if (size != 1) {
                        throw new IllegalArgumentException("List has more than one element.");
                    }
                    String str4 = (String) list2.get(0);
                    int iAi = StringsKt.indexOf(charSequence2, str4, iIntValue2, false, 4);
                    pairVar = iAi < 0 ? null : new Pair(Integer.valueOf(iAi), str4);
                } else {
                    if (iIntValue2 < 0) {
                        iIntValue2 = 0;
                    }
                    IntRange intRangeVar = new IntRange(iIntValue2, charSequence2.length(), 1);
                    boolean z = charSequence2 instanceof String;
                    int i2 = intRangeVar.step;
                    int i3 = intRangeVar.last;
                    if (z) {
                        if ((i2 > 0 && iIntValue2 <= i3) || (i2 < 0 && i3 <= iIntValue2)) {
                            int i4 = iIntValue2;
                            while (true) {
                                Iterator it2 = list2.iterator();
                                do {
                                    if (it2.hasNext()) {
                                        next2 = it2.next();
                                        str2 = (String) next2;
                                    } else {
                                        next2 = null;
                                    }
                                    str = (String) next2;
                                    if (str != null) {
                                        pairVar = new Pair(Integer.valueOf(i4), str);
                                    } else if (i4 != i3) {
                                        i4 += i2;
                                    }
                                } while (!dnr.bl(0, i4, str2.length(), str2, (String) charSequence2, false));
                                str = (String) next2;
                                if (str != null) {
                                    pairVar = new Pair(Integer.valueOf(i4), str);
                                } else if (i4 != i3) {
                                    i4 += i2;
                                }
                            }
                        }
                    } else if ((i2 > 0 && iIntValue2 <= i3) || (i2 < 0 && i3 <= iIntValue2)) {
                        int i5 = iIntValue2;
                        while (true) {
                            Iterator it3 = list2.iterator();
                            while (true) {
                                if (it3.hasNext()) {
                                    next = it3.next();
                                    String str5 = (String) next;
                                    i = i3;
                                    if (!StringsKt.an(str5, 0, charSequence2, i5, str5.length(), false)) {
                                        i3 = i;
                                    }
                                } else {
                                    i = i3;
                                    next = null;
                                }
                            }
                            String str6 = (String) next;
                            if (str6 != null) {
                                pairVar = new Pair(Integer.valueOf(i5), str6);
                            } else if (i5 != i) {
                                i5 += i2;
                                i3 = i;
                            }
                        }
                    }
                }
                if (pairVar != null) {
                    return new Pair(pairVar.first, Integer.valueOf(((String) pairVar.second).length()));
                }
                return null;
        }
    }
}

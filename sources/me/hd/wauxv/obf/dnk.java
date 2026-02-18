package me.hd.wauxv.obf;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public abstract class dnk extends aye {
    public static String bb(String str) {
        List listBf;
        bzo.q(str, "<this>");
        if (dnj.ak("|")) {
            throw new IllegalArgumentException("marginPrefix must be non-blank string.");
        }
        bvn bvnVar = new bvn(str);
        if (bvnVar.hasNext()) {
            Object next = bvnVar.next();
            if (bvnVar.hasNext()) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(next);
                while (bvnVar.hasNext()) {
                    arrayList.add(bvnVar.next());
                }
                listBf = arrayList;
            } else {
                listBf = dqc.bf(next);
            }
        } else {
            listBf = avd.a;
        }
        int length = str.length();
        listBf.size();
        int iAf = aba.af(listBf);
        ArrayList arrayList2 = new ArrayList();
        int i = 0;
        for (Object obj : listBf) {
            int i2 = i + 1;
            String strSubstring = null;
            if (i < 0) {
                aba.aj();
                throw null;
            }
            String str2 = (String) obj;
            if ((i != 0 && i != iAf) || !dnj.ak(str2)) {
                int length2 = str2.length();
                int i3 = 0;
                while (true) {
                    if (i3 >= length2) {
                        i3 = -1;
                        break;
                    }
                    if (!cmz.ac(str2.charAt(i3))) {
                        break;
                    }
                    i3++;
                }
                if (i3 != -1 && dnr.bq(str2, false, i3, "|")) {
                    strSubstring = str2.substring("|".length() + i3);
                    bzo.p(strSubstring, "substring(...)");
                }
                if (strSubstring == null) {
                    strSubstring = str2;
                }
            }
            if (strSubstring != null) {
                arrayList2.add(strSubstring);
            }
            i = i2;
        }
        StringBuilder sb = new StringBuilder(length);
        aaz.i(arrayList2, sb, "\n", "", "", "...", null);
        return sb.toString();
    }
}

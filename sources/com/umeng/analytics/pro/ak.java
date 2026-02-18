package com.umeng.analytics.pro;

import android.text.TextUtils;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public class ak {
    private String a;
    private ArrayList<al> b = new ArrayList<>();

    public ak(String str) {
        this.a = "";
        this.a = str;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        a();
    }

    private void a() {
        try {
            if (!this.a.contains(",")) {
                String str = this.a;
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                String strTrim = str.trim();
                if (this.b != null) {
                    this.b.add(new al(strTrim));
                    return;
                }
                return;
            }
            for (String str2 : this.a.split(",")) {
                if (!TextUtils.isEmpty(str2)) {
                    String strTrim2 = str2.trim();
                    if (this.b != null) {
                        this.b.add(new al(strTrim2));
                    }
                }
            }
        } catch (Throwable unused) {
        }
    }

    public boolean a(int i) {
        try {
            ArrayList<al> arrayList = this.b;
            if (arrayList != null) {
                int size = arrayList.size();
                for (int i2 = 0; i2 < size; i2++) {
                    al alVar = this.b.get(i2);
                    if (alVar != null && alVar.a(i)) {
                        return true;
                    }
                }
            }
        } catch (Throwable unused) {
        }
        return false;
    }
}

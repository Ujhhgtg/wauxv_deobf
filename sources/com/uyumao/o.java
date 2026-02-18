package com.uyumao;

import android.content.Context;
import android.text.TextUtils;
import com.umeng.analytics.pro.bt;
import me.hd.wauxv.obf.dkz;
import me.hd.wauxv.obf.yg;
import net.bytebuddy.utility.JavaConstant;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public class o {
    public static volatile o a;
    public final Context b;
    public final a c = new a(this, "AZX");

    public o(Context context) {
        this.b = context.getApplicationContext();
    }

    public void a(long j) {
        this.c.b("smart_interval", j);
        this.c.b("smart_ts", System.currentTimeMillis());
    }

    public final boolean a(String str) {
        long jA = this.c.a(str + bt.aS, 0L);
        if (jA <= 0) {
            return true;
        }
        a aVar = this.c;
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append("ts");
        return Math.abs(System.currentTimeMillis() - aVar.a(sb.toString(), 0L)) / 1000 >= jA;
    }

    public long a() {
        return this.c.a("smart_lc", 0L);
    }

    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
    public class a {
        public final String a;

        public a(o oVar, String str) {
            this.a = TextUtils.isEmpty(str) ? str : dkz.s(str, JavaConstant.Dynamic.DEFAULT_NAME);
        }

        public final void a(String str, String str2) {
            try {
                if (n.c(e.a)) {
                    m mVarA = m.a();
                    mVarA.getClass();
                    if (TextUtils.isEmpty(str)) {
                        return;
                    }
                    mVarA.b.edit().putString(str, str2).apply();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        public void b(String str, long j) {
            a(yg.o(new StringBuilder(), this.a, str), String.valueOf(j));
        }

        public long a(String str, long j) {
            String strO = yg.o(new StringBuilder(), this.a, str);
            String strValueOf = String.valueOf(j);
            try {
                if (n.c(e.a)) {
                    strValueOf = m.a().b.getString(strO, strValueOf);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                return Long.parseLong(strValueOf);
            } catch (Exception unused) {
                return j;
            }
        }
    }
}

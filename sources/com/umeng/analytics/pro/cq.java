package com.umeng.analytics.pro;

import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;
import me.hd.wauxv.obf.yg;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public class cq {
    private final ByteArrayOutputStream a;
    private final ds b;
    private dg c;

    public cq() {
        this(new da.a());
    }

    public byte[] a(ch chVar) {
        this.a.reset();
        chVar.write(this.c);
        return this.a.toByteArray();
    }

    public String b(ch chVar) {
        return new String(a(chVar));
    }

    public cq(di diVar) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        this.a = byteArrayOutputStream;
        ds dsVar = new ds(byteArrayOutputStream);
        this.b = dsVar;
        this.c = diVar.a(dsVar);
    }

    public String a(ch chVar, String str) throws cn {
        try {
            return new String(a(chVar), str);
        } catch (UnsupportedEncodingException unused) {
            throw new cn(yg.concat("JVM DOES NOT SUPPORT ENCODING: ", str));
        }
    }
}

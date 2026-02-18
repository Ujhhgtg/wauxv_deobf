package me.hd.wauxv.obf;

import android.util.Log;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class sa implements ajb {
    public final /* synthetic */ int a;
    public final Object c;

    public /* synthetic */ sa(Object obj, int i) {
        this.a = i;
        this.c = obj;
    }

    private final void g() {
    }

    private final void h() {
    }

    private final void i() {
    }

    private final void j() {
    }

    @Override // me.hd.wauxv.obf.ajb
    public final Class b() {
        switch (this.a) {
            case 0:
                return ByteBuffer.class;
            default:
                return this.c.getClass();
        }
    }

    @Override // me.hd.wauxv.obf.ajb
    public final void cancel() {
        int i = this.a;
    }

    @Override // me.hd.wauxv.obf.ajb
    public final void d() {
        int i = this.a;
    }

    @Override // me.hd.wauxv.obf.ajb
    public final int e() {
        switch (this.a) {
        }
        return 1;
    }

    @Override // me.hd.wauxv.obf.ajb
    public final void f(cvq cvqVar, aja ajaVar) {
        switch (this.a) {
            case 0:
                try {
                    ajaVar._bo(sf.b((File) this.c));
                } catch (IOException e) {
                    if (Log.isLoggable("ByteBufferFileLoader", 3)) {
                        Log.d("ByteBufferFileLoader", "Failed to obtain ByteBuffer for file", e);
                    }
                    ajaVar.k(e);
                    return;
                }
                break;
            default:
                ajaVar._bo(this.c);
                break;
        }
    }
}

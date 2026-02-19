package me.hd.wauxv.obf;

import android.content.Context;
import android.content.ContextWrapper;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class bhw extends ContextWrapper {
    public static final bgz a;
    public final bva b;
    public final afr c;
    public final GifEncoder d;
    public final GifEncoder e;
    public final List f;
    public final ku g;
    public final awd h;
    public final bib i;
    public final int j;
    public dcd k;

    static {
        bgz bgzVar = new bgz();
        bgzVar.a = cog.a;
        a = bgzVar;
    }

    public bhw(Context context, bva bvaVar, ConnectivityMonitor connectivityMonitorVar, GifEncoder gifEncoderVar, GifEncoder gifEncoderVar2, ku kuVar, List list, awd awdVar, bib bibVar) {
        super(context.getApplicationContext());
        this.b = bvaVar;
        this.d = gifEncoderVar;
        this.e = gifEncoderVar2;
        this.f = list;
        this.g = kuVar;
        this.h = awdVar;
        this.i = bibVar;
        this.j = 4;
        this.c = new afr(connectivityMonitorVar);
    }

    public final das l() {
        return (das) this.c.get();
    }
}

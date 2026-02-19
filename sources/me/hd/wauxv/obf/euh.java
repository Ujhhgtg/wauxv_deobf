package me.hd.wauxv.obf;

import android.widget.ProgressBar;
import android.widget.TextView;
import java.io.Closeable;
import java.util.Iterator;
import java.util.List;
import org.luckypray.dexkit.DexKitBridge;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class euh extends doi implements bgk {
    public List a;
    public Closeable d;
    public DexKitBridge e;
    public Iterator f;
    public bng g;
    public int o;
    public int p;
    public int r;
    public int s;
    public int t;
    public long u;
    public long v;
    public int w;
    public /* synthetic */ TextView x;
    public /* synthetic */ ProgressBar y;

    @Override // me.hd.wauxv.obf.bgk
    public final Object b(Object obj, Object obj2, Object obj3) {
        euh euhVar = new euh(3, (kotlinx$coroutines$internal$DispatchedContinuation) obj3);
        euhVar.x = (TextView) obj;
        euhVar.y = (ProgressBar) obj2;
        return euhVar.i(Kotlin$Unit.INSTANCE);
    }

    /* JADX WARN: Found duplicated region for block: B:30:0x00cf A[Catch: all -> 0x016e, TRY_ENTER, TryCatch #9 {all -> 0x016e, blocks: (B:27:0x00c3, B:30:0x00cf, B:32:0x00d9, B:33:0x00df, B:35:0x00e3, B:37:0x00e7, B:39:0x010c, B:41:0x0122, B:43:0x0128, B:45:0x012c, B:47:0x0134, B:49:0x0138, B:51:0x013d, B:86:0x01db, B:88:0x01f6, B:90:0x0206, B:89:0x01fd, B:91:0x0228, B:92:0x022b), top: B:165:0x00c3 }] */
    /* JADX WARN: Found duplicated region for block: B:32:0x00d9 A[Catch: all -> 0x016e, MOVE_INLINED, TRY_LEAVE, TryCatch #9 {all -> 0x016e, blocks: (B:27:0x00c3, B:30:0x00cf, B:32:0x00d9, B:33:0x00df, B:35:0x00e3, B:37:0x00e7, B:39:0x010c, B:41:0x0122, B:43:0x0128, B:45:0x012c, B:47:0x0134, B:49:0x0138, B:51:0x013d, B:86:0x01db, B:88:0x01f6, B:90:0x0206, B:89:0x01fd, B:91:0x0228, B:92:0x022b), top: B:165:0x00c3 }] */
    /* JADX WARN: Found duplicated region for block: B:54:0x0147  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:54:0x0147 -> B:174:0x0156). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    @Override // me.hd.wauxv.obf.nc
    public final java.lang.Object i(java.lang.Object r30) {
        /*
            Method dump skipped, instruction units count: 880
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: me.hd.wauxv.obf.euh.i(java.lang.Object):java.lang.Object");
    }
}

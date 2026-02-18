package me.hd.wauxv.obf;

import java.io.File;
import net.bytebuddy.pool.TypePool;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class aon {
    public final String a;
    public final long[] b;
    public final File[] c;
    public final File[] d;
    public boolean e;
    public aom f;
    public final /* synthetic */ aoo g;

    public aon(aoo aooVar, String str) {
        this.g = aooVar;
        this.a = str;
        int i = aooVar.g;
        File file = aooVar.a;
        this.b = new long[i];
        this.c = new File[i];
        this.d = new File[i];
        StringBuilder sb = new StringBuilder(str);
        sb.append(TypePool.Default.LazyTypeDescription.GenericTypeToken.INNER_CLASS_PATH);
        int length = sb.length();
        for (int i2 = 0; i2 < i; i2++) {
            sb.append(i2);
            this.c[i2] = new File(file, sb.toString());
            sb.append(".tmp");
            this.d[i2] = new File(file, sb.toString());
            sb.setLength(length);
        }
    }

    public final String h() {
        StringBuilder sb = new StringBuilder();
        for (long j : this.b) {
            sb.append(' ');
            sb.append(j);
        }
        return sb.toString();
    }
}

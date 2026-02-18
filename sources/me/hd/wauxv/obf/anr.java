package me.hd.wauxv.obf;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.net.ConnectivityManager;
import java.io.InputStream;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class anr implements cdw, ate, bic {
    public final /* synthetic */ int a;
    public final Context b;

    public /* synthetic */ anr(Context context, int i) {
        this.a = i;
        this.b = context;
    }

    @Override // me.hd.wauxv.obf.ate
    public void c(cnh cnhVar) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, 1, 15L, TimeUnit.SECONDS, new LinkedBlockingDeque(), new acq("EmojiCompatInitializer"));
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        threadPoolExecutor.execute(new ale(this, cnhVar, threadPoolExecutor, 2));
    }

    @Override // me.hd.wauxv.obf.bic
    public Object get() {
        return (ConnectivityManager) this.b.getSystemService("connectivity");
    }

    @Override // me.hd.wauxv.obf.cdw
    public cdv u(chm chmVar) {
        switch (this.a) {
            case 0:
                return new le(this.b, this);
            case 1:
                return new le(this.b, this);
            case 2:
                return new le(this.b, this);
            case 3:
            case 4:
            case 8:
            default:
                return new le(this.b, chmVar.w(Integer.class, InputStream.class));
            case 5:
                return new cbd(this.b, 0);
            case 6:
                return new cbd(this.b, 1);
            case 7:
                return new cbd(this.b, 2);
            case 9:
                return new le(this.b, chmVar.w(Integer.class, AssetFileDescriptor.class));
        }
    }

    public anr(Context context) {
        this.a = 3;
        this.b = context.getApplicationContext();
    }
}

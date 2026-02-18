package me.hd.wauxv.obf;

import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.util.Log;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class azo implements ajb {
    public final String a;
    public final AssetManager c;
    public Object g;
    public final /* synthetic */ int h;

    public azo(AssetManager assetManager, String str, int i) {
        this.h = i;
        this.c = assetManager;
        this.a = str;
    }

    @Override // me.hd.wauxv.obf.ajb
    public final Class b() {
        switch (this.h) {
            case 0:
                return AssetFileDescriptor.class;
            default:
                return InputStream.class;
        }
    }

    @Override // me.hd.wauxv.obf.ajb
    public final void cancel() {
    }

    @Override // me.hd.wauxv.obf.ajb
    public final void d() {
        Object obj = this.g;
        if (obj == null) {
            return;
        }
        try {
            switch (this.h) {
                case 0:
                    ((AssetFileDescriptor) obj).close();
                    break;
                default:
                    ((InputStream) obj).close();
                    break;
            }
        } catch (IOException unused) {
        }
    }

    @Override // me.hd.wauxv.obf.ajb
    public final int e() {
        return 1;
    }

    @Override // me.hd.wauxv.obf.ajb
    public final void f(cvq cvqVar, aja ajaVar) {
        Object objOpenFd;
        try {
            AssetManager assetManager = this.c;
            String str = this.a;
            switch (this.h) {
                case 0:
                    objOpenFd = assetManager.openFd(str);
                    break;
                default:
                    objOpenFd = assetManager.open(str);
                    break;
            }
            this.g = objOpenFd;
            ajaVar._bo(objOpenFd);
        } catch (IOException e) {
            if (Log.isLoggable("AssetPathFetcher", 3)) {
                Log.d("AssetPathFetcher", "Failed to load data from asset manager", e);
            }
            ajaVar.k(e);
        }
    }
}

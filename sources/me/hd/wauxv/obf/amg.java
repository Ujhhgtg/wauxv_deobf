package me.hd.wauxv.obf;

import android.content.res.AssetManager;
import android.os.Build;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.Serializable;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class amg {
    public final Executor a;
    public final cvv b;
    public final byte[] c;
    public final File d;
    public final String e;
    public boolean f = false;
    public amr[] g;
    public byte[] h;

    public amg(AssetManager assetManager, Executor executor, cvv cvvVar, String str, File file) {
        byte[] bArr;
        this.a = executor;
        this.b = cvvVar;
        this.e = str;
        this.d = file;
        int i = Build.VERSION.SDK_INT;
        if (i < 31) {
            switch (i) {
                case 27:
                    bArr = StaticAndroidHelpers.t;
                    break;
                case 28:
                case 29:
                case 30:
                    bArr = StaticAndroidHelpers.s;
                    break;
                default:
                    bArr = null;
                    break;
            }
        } else {
            bArr = StaticAndroidHelpers.r;
        }
        this.c = bArr;
    }

    public final FileInputStream i(AssetManager assetManager, String str) {
        try {
            return assetManager.openFd(str).createInputStream();
        } catch (FileNotFoundException e) {
            String message = e.getMessage();
            if (message == null || !message.contains("compressed")) {
                return null;
            }
            this.b.i();
            return null;
        }
    }

    public final void j(int i, Serializable serializable) {
        this.a.execute(new acf(this, i, serializable, 2));
    }
}

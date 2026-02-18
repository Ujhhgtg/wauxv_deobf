package me.hd.wauxv.obf;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class ans implements ajb {
    public final Resources.Theme a;
    public final Resources c;
    public final anr g;
    public final int h;
    public Object i;

    public ans(Resources.Theme theme, Resources resources, anr anrVar, int i) {
        this.a = theme;
        this.c = resources;
        this.g = anrVar;
        this.h = i;
    }

    @Override // me.hd.wauxv.obf.ajb
    public final Class b() {
        switch (this.g.a) {
            case 0:
                return AssetFileDescriptor.class;
            case 1:
                return Drawable.class;
            default:
                return InputStream.class;
        }
    }

    @Override // me.hd.wauxv.obf.ajb
    public final void cancel() {
    }

    @Override // me.hd.wauxv.obf.ajb
    public final void d() {
        Object obj = this.i;
        if (obj != null) {
            try {
                switch (this.g.a) {
                    case 0:
                        ((AssetFileDescriptor) obj).close();
                        break;
                    case 1:
                        break;
                    default:
                        ((InputStream) obj).close();
                        break;
                }
            } catch (IOException unused) {
            }
        }
    }

    @Override // me.hd.wauxv.obf.ajb
    public final int e() {
        return 1;
    }

    @Override // me.hd.wauxv.obf.ajb
    public final void f(cvq cvqVar, aja ajaVar) {
        Object objOpenRawResourceFd;
        try {
            anr anrVar = this.g;
            Resources.Theme theme = this.a;
            Resources resources = this.c;
            int i = this.h;
            switch (anrVar.a) {
                case 0:
                    objOpenRawResourceFd = resources.openRawResourceFd(i);
                    break;
                case 1:
                    Context context = anrVar.b;
                    objOpenRawResourceFd = KotlinHelpers.u(context, context, i, theme);
                    break;
                default:
                    objOpenRawResourceFd = resources.openRawResource(i);
                    break;
            }
            this.i = objOpenRawResourceFd;
            ajaVar._bo(objOpenRawResourceFd);
        } catch (Resources.NotFoundException e) {
            ajaVar.k(e);
        }
    }
}

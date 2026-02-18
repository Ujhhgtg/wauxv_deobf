package me.hd.wauxv.obf;

import android.content.ClipData;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContentInfo;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class afk implements afj, afl {
    public final /* synthetic */ int a = 0;
    public ClipData b;
    public int c;
    public int d;
    public Uri e;
    public Bundle f;

    public /* synthetic */ afk() {
    }

    @Override // me.hd.wauxv.obf.afl
    public int _af() {
        return this.d;
    }

    @Override // me.hd.wauxv.obf.afl
    public ContentInfo _ag() {
        return null;
    }

    @Override // me.hd.wauxv.obf.afj
    public afm build() {
        return new afm(new afk(this));
    }

    @Override // me.hd.wauxv.obf.afl
    public ClipData g() {
        return this.b;
    }

    @Override // me.hd.wauxv.obf.afj
    public void j(Uri uri) {
        this.e = uri;
    }

    @Override // me.hd.wauxv.obf.afj
    public void k(int i) {
        this.d = i;
    }

    @Override // me.hd.wauxv.obf.afl
    public int l() {
        return this.c;
    }

    @Override // me.hd.wauxv.obf.afj
    public void setExtras(Bundle bundle) {
        this.f = bundle;
    }

    public String toString() {
        String str;
        switch (this.a) {
            case 1:
                Uri uri = this.e;
                StringBuilder sb = new StringBuilder("ContentInfoCompat{clip=");
                sb.append(this.b.getDescription());
                sb.append(", source=");
                int i = this.c;
                sb.append(i != 0 ? i != 1 ? i != 2 ? i != 3 ? i != 4 ? i != 5 ? String.valueOf(i) : "SOURCE_PROCESS_TEXT" : "SOURCE_AUTOFILL" : "SOURCE_DRAG_AND_DROP" : "SOURCE_INPUT_METHOD" : "SOURCE_CLIPBOARD" : "SOURCE_APP");
                sb.append(", flags=");
                int i2 = this.d;
                sb.append((i2 & 1) != 0 ? "FLAG_CONVERT_TO_PLAIN_TEXT" : String.valueOf(i2));
                if (uri == null) {
                    str = "";
                } else {
                    str = ", hasLinkUri(" + uri.toString().length() + ")";
                }
                sb.append(str);
                return yg.o(sb, this.f != null ? ", hasExtras" : "", "}");
            default:
                return super.toString();
        }
    }

    public afk(afk afkVar) {
        ClipData clipData = afkVar.b;
        clipData.getClass();
        this.b = clipData;
        int i = afkVar.c;
        if (i < 0) {
            Locale locale = Locale.US;
            throw new IllegalArgumentException("source is out of range of [0, 5] (too low)");
        }
        if (i > 5) {
            Locale locale2 = Locale.US;
            throw new IllegalArgumentException("source is out of range of [0, 5] (too high)");
        }
        this.c = i;
        int i2 = afkVar.d;
        if ((i2 & 1) == i2) {
            this.d = i2;
            this.e = afkVar.e;
            this.f = afkVar.f;
        } else {
            throw new IllegalArgumentException("Requested flags 0x" + Integer.toHexString(i2) + ", but only 0x" + Integer.toHexString(1) + " are allowed");
        }
    }
}

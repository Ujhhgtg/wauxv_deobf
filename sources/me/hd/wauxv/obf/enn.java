package me.hd.wauxv.obf;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class enn extends enm {
    public static final Parcelable.Creator<enn> CREATOR = new cu(22);
    public int f;
    public int g;
    public int h;
    public int i;
    public final transient long j = System.currentTimeMillis();
    public Object k;

    /* JADX WARN: Type inference failed for: r0v3, types: [java.lang.CharSequence, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v2, types: [java.lang.CharSequence, java.lang.Object] */
    @Override // me.hd.wauxv.obf.enm
    public final boolean b(enm enmVar) {
        if (!(enmVar instanceof enn)) {
            return false;
        }
        enn ennVar = (enn) enmVar;
        if (ennVar.i == this.h && ennVar.g == this.f) {
            return this.k.length() + ennVar.k.length() < 10000 && Math.abs(ennVar.j - this.j) < 8000;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v3, types: [java.lang.CharSequence, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v3, types: [java.lang.CharSequence, java.lang.Object] */
    @Override // me.hd.wauxv.obf.enm
    public final void c(enm enmVar) {
        StringBuilder sb;
        if (!b(enmVar)) {
            throw new IllegalArgumentException();
        }
        enn ennVar = (enn) enmVar;
        this.h = ennVar.h;
        this.f = ennVar.f;
        ?? r0 = this.k;
        if (r0 instanceof StringBuilder) {
            sb = (StringBuilder) r0;
        } else {
            StringBuilder sb2 = new StringBuilder((CharSequence) r0);
            this.k = sb2;
            sb = sb2;
        }
        sb.insert(0, (CharSequence) ennVar.k);
    }

    @Override // me.hd.wauxv.obf.enm
    public final void d(aff affVar) {
        affVar.r(this.f, this.h, this.g, this.i);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [java.lang.CharSequence, java.lang.Object] */
    @Override // me.hd.wauxv.obf.enm
    public final void e(aff affVar) {
        affVar.ab(this.f, this.h, this.k);
    }

    public final String toString() {
        return "DeleteAction{startLine=" + this.f + ", endLine=" + this.g + ", startColumn=" + this.h + ", endColumn=" + this.i + ", createTime=" + this.j + ", text=" + this.k + '}';
    }

    /* JADX WARN: Type inference failed for: r2v5, types: [java.lang.CharSequence, java.lang.Object] */
    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f);
        parcel.writeInt(this.h);
        parcel.writeInt(this.g);
        parcel.writeInt(this.i);
        parcel.writeString(this.k.toString());
    }
}

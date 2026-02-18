package me.hd.wauxv.obf;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class eno extends enm {
    public static final Parcelable.Creator<eno> CREATOR = new cu(23);
    public int f;
    public int g;
    public int h;
    public int i;
    public final transient long j = System.currentTimeMillis();
    public CharSequence k;

    @Override // me.hd.wauxv.obf.enm
    public final boolean b(enm enmVar) {
        if (enmVar instanceof eno) {
            eno enoVar = (eno) enmVar;
            if (enoVar.h == this.i && enoVar.f == this.g) {
                if (this.k.length() + enoVar.k.length() < 10000 && Math.abs(enoVar.j - this.j) < 8000) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // me.hd.wauxv.obf.enm
    public final void c(enm enmVar) {
        StringBuilder sb;
        if (!b(enmVar)) {
            throw new IllegalArgumentException();
        }
        eno enoVar = (eno) enmVar;
        this.i = enoVar.i;
        this.g = enoVar.g;
        CharSequence charSequence = this.k;
        if (charSequence instanceof StringBuilder) {
            sb = (StringBuilder) charSequence;
        } else {
            StringBuilder sb2 = new StringBuilder(charSequence);
            this.k = sb2;
            sb = sb2;
        }
        sb.append(enoVar.k);
    }

    @Override // me.hd.wauxv.obf.enm
    public final void d(aff affVar) {
        affVar.ab(this.f, this.h, this.k);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // me.hd.wauxv.obf.enm
    public final void e(aff affVar) {
        affVar.r(this.f, this.h, this.g, this.i);
    }

    public final String toString() {
        return "InsertAction{startLine=" + this.f + ", endLine=" + this.g + ", startColumn=" + this.h + ", endColumn=" + this.i + ", createTime=" + this.j + ", text=" + ((Object) this.k) + '}';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f);
        parcel.writeInt(this.h);
        parcel.writeInt(this.g);
        parcel.writeInt(this.i);
        parcel.writeString(this.k.toString());
    }
}

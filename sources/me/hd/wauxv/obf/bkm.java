package me.hd.wauxv.obf;

import java.io.Serializable;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class bkm extends p {
    public final /* synthetic */ int h;
    public final pd i;
    public final Serializable j;

    public bkm() {
        this.h = 1;
        this.i = new box();
        this.j = new ArrayList();
    }

    @Override // me.hd.wauxv.obf.p
    public void a(CharSequence charSequence) {
        switch (this.h) {
            case 1:
                ((ArrayList) this.j).add(charSequence);
                break;
        }
    }

    @Override // me.hd.wauxv.obf.p
    public void c() {
        int i;
        switch (this.h) {
            case 1:
                ArrayList arrayList = (ArrayList) this.j;
                int size = arrayList.size() - 1;
                while (true) {
                    if (size >= 0) {
                        CharSequence charSequence = (CharSequence) arrayList.get(size);
                        int length = charSequence.length();
                        int i2 = 0;
                        while (true) {
                            if (i2 < length) {
                                char cCharAt = charSequence.charAt(i2);
                                if (cCharAt != ' ') {
                                    switch (cCharAt) {
                                        case '\t':
                                        case '\n':
                                        case 11:
                                        case '\f':
                                        case '\r':
                                            break;
                                    }
                                }
                                i2++;
                            } else {
                                i2 = -1;
                            }
                        }
                        if (i2 == -1) {
                            size--;
                        }
                    }
                }
                StringBuilder sb = new StringBuilder();
                for (i = 0; i < size + 1; i++) {
                    sb.append((CharSequence) arrayList.get(i));
                    sb.append('\n');
                }
                ((box) this.i).d = sb.toString();
                break;
        }
    }

    @Override // me.hd.wauxv.obf.p
    public final pd d() {
        switch (this.h) {
            case 0:
                return (bkl) this.i;
            default:
                return (box) this.i;
        }
    }

    @Override // me.hd.wauxv.obf.p
    public void f(bpm bpmVar) {
        switch (this.h) {
            case 0:
                bpmVar.z((String) this.j, (bkl) this.i);
                break;
        }
    }

    @Override // me.hd.wauxv.obf.p
    public final pf g(aph aphVar) {
        switch (this.h) {
            case 0:
                return null;
            default:
                if (aphVar.i >= 4) {
                    return new pf(-1, aphVar.e + 4, false);
                }
                if (aphVar.j) {
                    return pf.d(aphVar.g);
                }
                return null;
        }
    }

    public bkm(int i, String str) {
        this.h = 0;
        bkl bklVar = new bkl();
        this.i = bklVar;
        bklVar.d = i;
        this.j = str;
    }
}

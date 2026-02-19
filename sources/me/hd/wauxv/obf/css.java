package me.hd.wauxv.obf;

import java.util.Locale;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class css extends p {
    public final csr h = new csr();
    public final bvq i = new bvq();

    /* JADX WARN: Found duplicated region for block: B:21:0x003c  */
    @Override // me.hd.wauxv.obf.p
    public final void a(CharSequence charSequence) {
        int iAa;
        int i;
        bvq bvqVar = this.i;
        StringBuilder sb = bvqVar.b;
        if (sb.length() != 0) {
            sb.append('\n');
        }
        sb.append(charSequence);
        int iAv = 0;
        while (iAv < charSequence.length()) {
            int iAe = StaticHelpers6.ae(bvqVar.a);
            if (iAe == 0) {
                int iAv2 = StaticAndroidHelpers.av(iAv, charSequence.length(), charSequence);
                if (iAv2 >= charSequence.length() || charSequence.charAt(iAv2) != '[') {
                    iAv = -1;
                } else {
                    bvqVar.a = 2;
                    bvqVar.d = new StringBuilder();
                    iAv = iAv2 + 1;
                    if (iAv >= charSequence.length()) {
                        bvqVar.d.append('\n');
                    }
                }
            } else if (iAe == 1) {
                iAa = ResourcesCompat.aa(iAv, charSequence);
                if (iAa == -1) {
                    iAv = -1;
                } else {
                    bvqVar.d.append(charSequence, iAv, iAa);
                    if (iAa >= charSequence.length()) {
                        bvqVar.d.append('\n');
                        iAv = iAa;
                    } else if (charSequence.charAt(iAa) != ']' || (i = iAa + 1) >= charSequence.length() || charSequence.charAt(i) != ':' || bvqVar.d.length() > 999) {
                        iAv = -1;
                    } else {
                        String string = bvqVar.d.toString();
                        Pattern pattern = awq.a;
                        String strReplaceAll = awq.c.matcher(string.trim().toLowerCase(Locale.ROOT)).replaceAll(" ");
                        if (strReplaceAll.isEmpty()) {
                            iAv = -1;
                        } else {
                            bvqVar.e = strReplaceAll;
                            bvqVar.a = 3;
                            iAv = StaticAndroidHelpers.av(iAa + 2, charSequence.length(), charSequence);
                        }
                    }
                }
            } else if (iAe == 2) {
                int iAv3 = StaticAndroidHelpers.av(iAv, charSequence.length(), charSequence);
                int iZ = ResourcesCompat.z(iAv3, charSequence);
                if (iZ != -1) {
                    bvqVar.f = charSequence.charAt(iAv3) == '<' ? charSequence.subSequence(iAv3 + 1, iZ - 1).toString() : charSequence.subSequence(iAv3, iZ).toString();
                    iAv = StaticAndroidHelpers.av(iZ, charSequence.length(), charSequence);
                    if (iAv >= charSequence.length()) {
                        bvqVar.i = true;
                        sb.setLength(0);
                    } else if (iAv == iZ) {
                        iAv = -1;
                    }
                    bvqVar.a = 4;
                } else {
                    iAv = -1;
                }
            } else if (iAe == 3) {
                iAv = StaticAndroidHelpers.av(iAv, charSequence.length(), charSequence);
                if (iAv >= charSequence.length()) {
                    bvqVar.a = 1;
                } else {
                    bvqVar.g = (char) 0;
                    char cCharAt = charSequence.charAt(iAv);
                    if (cCharAt == '\"' || cCharAt == '\'') {
                        bvqVar.g = cCharAt;
                    } else if (cCharAt == '(') {
                        bvqVar.g = ')';
                    }
                    if (bvqVar.g != 0) {
                        bvqVar.a = 5;
                        bvqVar.h = new StringBuilder();
                        iAv++;
                        if (iAv == charSequence.length()) {
                            bvqVar.h.append('\n');
                        }
                    } else {
                        bvqVar.j();
                        bvqVar.a = 1;
                    }
                }
            } else if (iAe == 4) {
                iAa = ResourcesCompat.ab(charSequence, iAv, bvqVar.g);
                if (iAa == -1) {
                    iAv = -1;
                } else {
                    bvqVar.h.append(charSequence.subSequence(iAv, iAa));
                    if (iAa >= charSequence.length()) {
                        bvqVar.h.append('\n');
                        iAv = iAa;
                    } else {
                        iAv = StaticAndroidHelpers.av(iAa + 1, charSequence.length(), charSequence);
                        if (iAv != charSequence.length()) {
                            iAv = -1;
                        } else {
                            bvqVar.i = true;
                            bvqVar.j();
                            sb.setLength(0);
                            bvqVar.a = 1;
                        }
                    }
                }
            } else if (iAe == 5) {
                return;
            }
            if (iAv == -1) {
                bvqVar.a = 6;
                return;
            }
        }
    }

    @Override // me.hd.wauxv.obf.p
    public final void c() {
        if (this.i.b.length() == 0) {
            this.h.o();
        }
    }

    @Override // me.hd.wauxv.obf.p
    public final pd d() {
        return this.h;
    }

    @Override // me.hd.wauxv.obf.p
    public final void f(bpm bpmVar) {
        StringBuilder sb = this.i.b;
        if (sb.length() > 0) {
            bpmVar.z(sb.toString(), this.h);
        }
    }

    @Override // me.hd.wauxv.obf.p
    public final pf g(aph aphVar) {
        if (aphVar.j) {
            return null;
        }
        return pf.d(aphVar.d);
    }
}

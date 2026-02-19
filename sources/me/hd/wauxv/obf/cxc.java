package me.hd.wauxv.obf;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.material.bottomsheet.BottomSheetBehavior;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public class cxc implements esn {
    public static final cxc g = new cxc(false, (dqs) null);
    public boolean h;
    public final Object i;

    public cxc() {
        this.i = new Handler(Looper.getMainLooper(), new nt(1));
    }

    public void b(String str) {
        byte b;
        throwIfVar1IsNull(str, "value");
        ek ekVar = (ek) this.i;
        ekVar.j(ekVar.c, str.length() + 2);
        char[] cArr = (char[]) ekVar.d;
        int i = ekVar.c;
        int i2 = i + 1;
        cArr[i] = '\"';
        int length = str.length();
        str.getChars(0, length, cArr, i2);
        int i3 = length + i2;
        int i4 = i2;
        while (i4 < i3) {
            char c = cArr[i4];
            byte[] bArr = dng.b;
            if (c < bArr.length && bArr[c] != 0) {
                int length2 = str.length();
                for (int i5 = i4 - i2; i5 < length2; i5++) {
                    ekVar.j(i4, 2);
                    char cCharAt = str.charAt(i5);
                    byte[] bArr2 = dng.b;
                    if (cCharAt >= bArr2.length || (b = bArr2[cCharAt]) == 0) {
                        int i6 = i4 + 1;
                        ((char[]) ekVar.d)[i4] = cCharAt;
                        i4 = i6;
                    } else if (b == 1) {
                        String str2 = dng.a[cCharAt];
                        throwIfVar1IsNull(str2);
                        ekVar.j(i4, str2.length());
                        str2.getChars(0, str2.length(), (char[]) ekVar.d, i4);
                        int length3 = str2.length() + i4;
                        ekVar.c = length3;
                        i4 = length3;
                    } else {
                        char[] cArr2 = (char[]) ekVar.d;
                        cArr2[i4] = '\\';
                        cArr2[i4 + 1] = (char) b;
                        i4 += 2;
                        ekVar.c = i4;
                    }
                }
                ekVar.j(i4, 1);
                ((char[]) ekVar.d)[i4] = '\"';
                ekVar.c = i4 + 1;
                return;
            }
            i4++;
        }
        cArr[i3] = '\"';
        ekVar.c = i3 + 1;
    }

    public void c(byte b) {
        ((ek) this.i).u(String.valueOf(b));
    }

    public void d(int i) {
        ((ek) this.i).u(String.valueOf(i));
    }

    public void e(long j) {
        ((ek) this.i).u(String.valueOf(j));
    }

    public void f(short s) {
        ((ek) this.i).u(String.valueOf(s));
    }

    public boolean j() {
        return this.h;
    }

    /* JADX WARN: Found duplicated region for block: B:21:0x0039 */
    public boolean k(int i, CharSequence charSequence) {
        if (charSequence == null || i < 0 || charSequence.length() - i < 0) {
            throw new IllegalArgumentException();
        }
        arj arjVar = (arj) this.i;
        if (arjVar == null) {
            return j();
        }
        arjVar.getClass();
        char c = 2;
        for (int i2 = 0; i2 < i && c == 2; i2++) {
            byte directionality = Character.getDirectionality(charSequence.charAt(i2));
            cxc cxcVar = dqi.a;
            if (directionality == 0) {
                c = 1;
                continue;
            } else if (directionality != 1 && directionality != 2) {
                switch (directionality) {
                    case 14:
                    case 15:
                        c = 1;
                        continue;
                    case 16:
                    case 17:
                        c = 0;
                        break;
                    default:
                        c = 2;
                        continue;
                }
            } else {
                c = 0;
            }
        }
        if (c == 0) {
            return true;
        }
        if (c != 1) {
            return j();
        }
        return false;
    }

    public void l() {
        this.h = false;
    }

    public void m(char c) {
        ek ekVar = (ek) this.i;
        ekVar.j(ekVar.c, 1);
        char[] cArr = (char[]) ekVar.d;
        int i = ekVar.c;
        ekVar.c = i + 1;
        cArr[i] = c;
    }

    public void n(String str) {
        throwIfVar1IsNull(str, "v");
        ((ek) this.i).u(str);
    }

    public synchronized void o(dcg dcgVar, boolean z) {
        try {
            if (this.h || z) {
                ((Handler) this.i).obtainMessage(1, dcgVar).sendToTarget();
            } else {
                this.h = true;
                dcgVar.c();
                this.h = false;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public void p() {
    }

    /* JADX WARN: Found duplicated region for block: B:33:0x007c */
    @Override // me.hd.wauxv.obf.esn
    public evr q(View view, evr evrVar, baw bawVar) {
        boolean z;
        evo evoVar = evrVar.b;
        bps bpsVarN = evoVar.n(519);
        bps bpsVarN2 = evoVar.n(32);
        BottomSheetBehavior bottomSheetBehavior = (BottomSheetBehavior) this.i;
        int i = bpsVarN.c;
        int i2 = bpsVarN.d;
        int i3 = bpsVarN.b;
        bottomSheetBehavior.ak = i;
        boolean zAl = StaticAndroidHelpers.al(view);
        int paddingBottom = view.getPaddingBottom();
        int paddingLeft = view.getPaddingLeft();
        int paddingRight = view.getPaddingRight();
        boolean z2 = bottomSheetBehavior.ac;
        if (z2) {
            int iE = evrVar.e();
            bottomSheetBehavior.aj = iE;
            paddingBottom = iE + bawVar.d;
        }
        if (bottomSheetBehavior.ad) {
            paddingLeft = (zAl ? bawVar.c : bawVar.a) + i3;
        }
        if (bottomSheetBehavior.ae) {
            paddingRight = (zAl ? bawVar.a : bawVar.c) + i2;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        boolean z3 = true;
        if (!bottomSheetBehavior.ag || marginLayoutParams.leftMargin == i3) {
            z = false;
        } else {
            marginLayoutParams.leftMargin = i3;
            z = true;
        }
        if (bottomSheetBehavior.ah && marginLayoutParams.rightMargin != i2) {
            marginLayoutParams.rightMargin = i2;
            z = true;
        }
        if (bottomSheetBehavior.ai) {
            int i4 = marginLayoutParams.topMargin;
            int i5 = bpsVarN.c;
            if (i4 != i5) {
                marginLayoutParams.topMargin = i5;
            } else {
                z3 = z;
            }
        } else {
            z3 = z;
        }
        if (z3) {
            view.setLayoutParams(marginLayoutParams);
        }
        view.setPadding(paddingLeft, view.getPaddingTop(), paddingRight, paddingBottom);
        boolean z4 = this.h;
        if (z4) {
            bottomSheetBehavior.aa = bpsVarN2.e;
        }
        if (!z2 && !z4) {
            return evrVar;
        }
        bottomSheetBehavior.cm();
        return evrVar;
    }

    public void r() {
    }

    public cxc(ek ekVar) {
        this.i = ekVar;
        this.h = true;
    }

    public cxc(boolean z, dqs dqsVar) {
        this.h = z;
        this.i = dqsVar;
    }

    public cxc(arj arjVar, boolean z) {
        this.i = arjVar;
        this.h = z;
    }

    public cxc(BottomSheetBehavior bottomSheetBehavior, boolean z) {
        this.i = bottomSheetBehavior;
        this.h = z;
    }
}

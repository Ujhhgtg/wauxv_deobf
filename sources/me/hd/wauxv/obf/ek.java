package me.hd.wauxv.obf;

import android.R;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.view.ContextThemeWrapper;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.appcompat.app.AlertController$RecycleListView;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import io.github.rosemoe.sora.widget.CodeEditor;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public class ek implements dcq, bm, sg {
    public final /* synthetic */ int a;
    public int c;
    public Object d;

    public /* synthetic */ ek(char c, int i) {
        this.a = i;
    }

    /* JADX WARN: Found duplicated region for block: B:30:0x009f */
    /* JADX WARN: Found duplicated region for block: B:31:0x00a3 A[DONT_INVERT] */
    /* JADX WARN: Found duplicated region for block: B:34:0x00ab */
    /* JADX WARN: Found duplicated region for block: B:7:0x0017 */
    public static final Object e(ek ekVar, ajx ajxVar, nc ncVar) throws Throwable {
        bst bstVar;
        LinkedHashMap linkedHashMap;
        ajx ajxVar2;
        byte bN;
        ek ekVar2;
        yi yiVar;
        yi yiVar2 = (yi) ekVar.d;
        if (ncVar instanceof bst) {
            bstVar = (bst) ncVar;
            int i = bstVar.q;
            if ((i & Integer.MIN_VALUE) != 0) {
                bstVar.q = i - Integer.MIN_VALUE;
            } else {
                bstVar = new bst(ekVar, ncVar);
            }
        } else {
            bstVar = new bst(ekVar, ncVar);
        }
        Object obj = bstVar.o;
        int i2 = bstVar.q;
        int i3 = 0;
        if (i2 != 0) {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            int i4 = bstVar.g;
            String str = bstVar.f;
            linkedHashMap = bstVar.e;
            ekVar2 = bstVar.d;
            ajxVar2 = bstVar.a;
            bhu.bd(obj);
            linkedHashMap.put(str, (brx) obj);
            bN = ((yi) ekVar2.d).n();
            if (bN == 4) {
                i3 = i4;
                ekVar = ekVar2;
            } else if (bN != 7) {
                yi.g((yi) ekVar2.d, "Expected end of the object or comma", 0, null, 6);
                throw null;
            }
            yiVar = (yi) ekVar2.d;
            if (bN == 6) {
                yiVar.o((byte) 7);
            } else if (bN == 4) {
                cnd.ay(yiVar, "object");
                throw null;
            }
            return new bsl(linkedHashMap);
        }
        bhu.bd(obj);
        byte bO = yiVar2.o((byte) 6);
        if (yiVar2.ae() == 4) {
            yi.g(yiVar2, "Unexpected leading comma", 0, null, 6);
            throw null;
        }
        linkedHashMap = new LinkedHashMap();
        ajxVar2 = ajxVar;
        bN = bO;
        yi yiVar3 = (yi) ekVar.d;
        if (!yiVar3.k()) {
            ekVar2 = ekVar;
            yiVar = (yi) ekVar2.d;
            if (bN == 6) {
                yiVar.o((byte) 7);
            } else if (bN == 4) {
                cnd.ay(yiVar, "object");
                throw null;
            }
            return new bsl(linkedHashMap);
        }
        String strR = yiVar3.r();
        yiVar3.o((byte) 5);
        bstVar.a = ajxVar2;
        bstVar.d = ekVar;
        bstVar.e = linkedHashMap;
        bstVar.f = strR;
        bstVar.g = i3;
        bstVar.q = 1;
        ajxVar2.getClass();
        ajxVar2.d = bstVar;
        return ahq.a;
    }

    public static void f(but butVar, String str, int i, int i2, Object obj) {
        char cCharAt = str.charAt(i);
        but butVar2 = (but) ((but) butVar.b).n(cCharAt);
        if (butVar2 == null) {
            butVar2 = new but(17);
            but butVar3 = (but) butVar.b;
            elz[] elzVarArr = (elz[]) butVar3.b;
            int iAbs = Math.abs(((cCharAt << 6) * ((cCharAt & 1) != 0 ? 3 : 1)) ^ cCharAt) % 64;
            elz[] elzVarArr2 = (elz[]) butVar3.c;
            if (elzVarArr2[iAbs] == null) {
                elz elzVar = new elz();
                elzVarArr2[iAbs] = elzVar;
                elzVarArr[iAbs] = elzVar;
                elz elzVar2 = elzVarArr2[iAbs];
                elzVar2.b = cCharAt;
                elzVar2.c = butVar2;
            } else {
                elz elzVar3 = elzVarArr[iAbs];
                while (true) {
                    if (elzVar3 == null) {
                        elzVar3 = null;
                        break;
                    } else if (elzVar3.b == cCharAt) {
                        break;
                    } else {
                        elzVar3 = elzVar3.a;
                    }
                }
                if (elzVar3 == null) {
                    elz elzVar4 = elzVarArr2[iAbs];
                    elz elzVar5 = new elz();
                    elzVar4.a = elzVar5;
                    elzVarArr2[iAbs] = elzVar5;
                    elzVar3 = elzVar5;
                }
                elzVar3.b = cCharAt;
                elzVar3.c = butVar2;
            }
        }
        if (i2 == 1) {
            butVar2.c = obj;
        } else {
            f(butVar2, str, i + 1, i2 - 1, obj);
        }
    }

    @Override // me.hd.wauxv.obf.bm
    public boolean _bm(View view) {
        ((BottomSheetBehavior) this.d).cf(this.c);
        return true;
    }

    @Override // me.hd.wauxv.obf.dcq
    public dcg g(dcg dcgVar, crw crwVar) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ((Bitmap) dcgVar.get()).compress((Bitmap.CompressFormat) this.d, this.c, byteArrayOutputStream);
        dcgVar.c();
        return new ez(byteArrayOutputStream.toByteArray());
    }

    public void h(MotionEvent motionEvent) {
        asv asvVar = (asv) this.d;
        aso asoVar = asvVar.b;
        CodeEditor codeEditor = asvVar.a;
        int i = this.c;
        dfo insertHandleDescriptor = i != 1
                ? i != 2 ? codeEditor.getInsertHandleDescriptor() : codeEditor.getRightHandleDescriptor()
                : codeEditor.getLeftHandleDescriptor();
        dfo rightHandleDescriptor = this.c == 1 ? codeEditor.getRightHandleDescriptor()
                : codeEditor.getLeftHandleDescriptor();
        float x = motionEvent.getX() + asoVar.b.getCurrX();
        int i2 = insertHandleDescriptor.b;
        RectF rectF = insertHandleDescriptor.a;
        float fWidth = ((i2 != 0 ? rectF.width() : 0.0f) * (insertHandleDescriptor.b == 1 ? 1 : -1)) + x;
        float y = (motionEvent.getY() + asoVar.b.getCurrY()) - rectF.height();
        int iF = (int) (codeEditor.j.f(0.0f - codeEditor.eb(), y) >> 32);
        if (iF < 0 || iF >= codeEditor.getLineCount()) {
            return;
        }
        int iF2 = (int) (codeEditor.j.f(fWidth - codeEditor.eb(), y) & 4294967295L);
        int i3 = this.c == 2 ? codeEditor.getCursor().d.b : codeEditor.getCursor().c.b;
        int i4 = this.c == 2 ? codeEditor.getCursor().d.c : codeEditor.getCursor().c.c;
        int i5 = this.c != 2 ? codeEditor.getCursor().d.b : codeEditor.getCursor().c.b;
        int i6 = this.c != 2 ? codeEditor.getCursor().d.c : codeEditor.getCursor().c.c;
        if (iF == i3 && iF2 == i4) {
            return;
        }
        int i7 = this.c;
        if (i7 != 0 && iF == i5 && iF2 == i6) {
            return;
        }
        if (i7 == 0) {
            codeEditor.bw = System.currentTimeMillis();
            codeEditor.eq(iF, iF2, 2, false);
            return;
        }
        if (i7 == 1) {
            dfo dfoVar = rightHandleDescriptor;
            int i8 = i5;
            if (i8 >= iF && (i8 != iF || i6 >= iF2)) {
                codeEditor.es(iF, false, iF2, i8, i6, 2);
                return;
            }
            if (RectF.intersects(rectF, dfoVar.a)) {
                return;
            }
            asvVar.av(asvVar.e, false);
            asvVar.e = 2;
            asvVar.av(2, true);
            this.c = 2;
            ek ekVar = asvVar.v;
            ekVar.c = 1;
            asvVar.v = asvVar.u;
            asvVar.u = ekVar;
            codeEditor.es(i8, false, i6, iF, iF2, 2);
            return;
        }
        if (i7 != 2) {
            return;
        }
        if (i5 <= iF && (i5 != iF || i6 <= iF2)) {
            codeEditor.es(i5, false, i6, iF, iF2, 2);
            return;
        }
        dfo dfoVar2 = rightHandleDescriptor;
        int i9 = i5;
        if (RectF.intersects(rectF, dfoVar2.a)) {
            return;
        }
        asvVar.av(asvVar.e, false);
        asvVar.e = 1;
        asvVar.av(1, true);
        this.c = 1;
        ek ekVar2 = asvVar.u;
        ekVar2.c = 2;
        ek ekVar3 = asvVar.v;
        asvVar.v = ekVar2;
        asvVar.u = ekVar3;
        codeEditor.es(iF, false, iF2, i9, i6, 2);
    }

    public el i() {
        eg egVar = (eg) this.d;
        el elVar = new el(egVar.a, this.c);
        View view = egVar.e;
        ej ejVar = elVar.c;
        if (view != null) {
            ejVar.w = view;
        } else {
            CharSequence charSequence = egVar.d;
            if (charSequence != null) {
                ejVar.d = charSequence;
                TextView textView = ejVar.u;
                if (textView != null) {
                    textView.setText(charSequence);
                }
            }
            Drawable drawable = egVar.c;
            if (drawable != null) {
                ejVar.s = drawable;
                ImageView imageView = ejVar.t;
                if (imageView != null) {
                    imageView.setVisibility(0);
                    ejVar.t.setImageDrawable(drawable);
                }
            }
        }
        String str = egVar.f;
        if (str != null) {
            ejVar.e = str;
            TextView textView2 = ejVar.v;
            if (textView2 != null) {
                textView2.setText(str);
            }
        }
        String str2 = egVar.g;
        if (str2 != null) {
            ejVar.ai(-1, str2, egVar.h);
        }
        String str3 = egVar.i;
        if (str3 != null) {
            ejVar.ai(-2, str3, egVar.j);
        }
        String str4 = egVar.k;
        if (str4 != null) {
            ejVar.ai(-3, str4, egVar.l);
        }
        if (egVar.p != null) {
            AlertController$RecycleListView alertController$RecycleListView = (AlertController$RecycleListView) egVar.b
                    .inflate(ejVar.aa, (ViewGroup) null);
            int i = egVar.s ? ejVar.ab : ejVar.ac;
            ListAdapter eiVar = egVar.p;
            if (eiVar == null) {
                eiVar = new ei(egVar.a, i, R.id.text1, null);
            }
            ejVar.x = eiVar;
            ejVar.y = egVar.t;
            if (egVar.q != null) {
                alertController$RecycleListView.setOnItemClickListener(new ef(egVar, ejVar));
            }
            if (egVar.s) {
                alertController$RecycleListView.setChoiceMode(1);
            }
            ejVar.f = alertController$RecycleListView;
        }
        View view2 = egVar.r;
        if (view2 != null) {
            ejVar.g = view2;
            ejVar.h = false;
        }
        elVar.setCancelable(egVar.m);
        if (egVar.m) {
            elVar.setCanceledOnTouchOutside(true);
        }
        elVar.setOnCancelListener(egVar.n);
        elVar.setOnDismissListener(null);
        cbx cbxVar = egVar.o;
        if (cbxVar != null) {
            elVar.setOnKeyListener(cbxVar);
        }
        return elVar;
    }

    public void j(int i, int i2) {
        int i3 = i2 + i;
        char[] cArr = (char[]) this.d;
        if (cArr.length <= i3) {
            int i4 = i * 2;
            if (i3 < i4) {
                i3 = i4;
            }
            char[] cArrCopyOf = Arrays.copyOf(cArr, i3);
            throwIfVar1IsNull(cArrCopyOf, "copyOf(...)");
            this.d = cArrCopyOf;
        }
    }

    public long k(int i) {
        if (i >= this.c || i < 0) {
            throw new ArrayIndexOutOfBoundsException(i);
        }
        return ((long[]) this.d)[i];
    }

    public float l(int i, int i2) {
        float[][] fArr = (float[][]) this.d;
        if (fArr.length == 1) {
            float[] fArr2 = fArr[0];
            return fArr2[i2] - fArr2[i];
        }
        int i3 = i / 262144;
        int i4 = i2 / 262144;
        float f = 0.0f;
        while (i3 <= i4) {
            int i5 = i3 * 262144;
            int i6 = i3 + 1;
            int iMin = Math.min(i6 * 262144, this.c);
            int iMax = Math.max(i, i5);
            int iMin2 = Math.min(i2, iMin);
            if (iMax < iMin2) {
                float[] fArr3 = fArr[i3];
                f = (fArr3[iMin2 - i5] - fArr3[iMax - i5]) + f;
            }
            i3 = i6;
        }
        return f;
    }

    public brx m() throws Throwable {
        brx bslVar;
        Object obj;
        yi yiVar = (yi) this.d;
        byte bAe = yiVar.ae();
        if (bAe == 1) {
            return o(true);
        }
        if (bAe == 0) {
            return o(false);
        }
        if (bAe != 6) {
            if (bAe == 8) {
                return n();
            }
            yi.g(yiVar, "Cannot read Json element because of unexpected ".concat(cnf.bo(bAe)), 0, null, 6);
            throw null;
        }
        int i = this.c + 1;
        this.c = i;
        if (i == 200) {
            bss bssVar = new bss(this, null);
            ajx ajxVar = new ajx();
            ajxVar.a = bssVar;
            ajxVar.d = ajxVar;
            ahq ahqVar = cna.a;
            ajxVar.e = ahqVar;
            while (true) {
                obj = ajxVar.e;
                afw afwVar = ajxVar.d;
                if (afwVar == null) {
                    break;
                }
                if (nullSafeIsEqual(ahqVar, obj)) {
                    try {
                        bss bssVar2 = ajxVar.a;
                        emc.af(3, bssVar2);
                        bss bssVar3 = new bss(bssVar2.e, afwVar);
                        bssVar3.d = ajxVar;
                        Object objI = bssVar3.i(ens.a);
                        if (objI != ahq.a) {
                            afwVar._bn(objI);
                        }
                    } catch (Throwable th) {
                        afwVar._bn(bhu.x(th));
                    }
                } else {
                    ajxVar.e = ahqVar;
                    afwVar._bn(obj);
                }
            }
            bhu.bd(obj);
            bslVar = (brx) obj;
        } else {
            byte bO = yiVar.o((byte) 6);
            if (yiVar.ae() == 4) {
                yi.g(yiVar, "Unexpected leading comma", 0, null, 6);
                throw null;
            }
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            while (yiVar.k()) {
                String strR = yiVar.r();
                yiVar.o((byte) 5);
                linkedHashMap.put(strR, m());
                bO = yiVar.n();
                if (bO != 4) {
                    if (bO == 7) {
                        break;
                    }
                    yi.g(yiVar, "Expected end of the object or comma", 0, null, 6);
                    throw null;
                }
            }
            if (bO == 6) {
                yiVar.o((byte) 7);
            } else if (bO == 4) {
                cnd.ay(yiVar, "object");
                throw null;
            }
            bslVar = new bsl(linkedHashMap);
        }
        this.c--;
        return bslVar;
    }

    public brp n() {
        yi yiVar = (yi) this.d;
        byte bN = yiVar.n();
        if (yiVar.ae() == 4) {
            yi.g(yiVar, "Unexpected leading comma", 0, null, 6);
            throw null;
        }
        ArrayList arrayList = new ArrayList();
        while (yiVar.k()) {
            arrayList.add(m());
            bN = yiVar.n();
            if (bN != 4) {
                boolean z = bN == 9;
                int i = yiVar.b;
                if (!z) {
                    yi.g(yiVar, "Expected end of the array or comma", i, null, 4);
                    throw null;
                }
            }
        }
        if (bN == 8) {
            yiVar.o((byte) 9);
        } else if (bN == 4) {
            cnd.ay(yiVar, "array");
            throw null;
        }
        return new brp(arrayList);
    }

    public bsp o(boolean z) {
        yi yiVar = (yi) this.d;
        String strS = !z ? yiVar.s() : yiVar.r();
        return (z || !nullSafeIsEqual(strS, "null")) ? new bsf(strS, z) : bsi.INSTANCE;
    }

    public void p() {
        tz tzVar = tz.a;
        char[] cArr = (char[]) this.d;
        tzVar.getClass();
        throwIfVar1IsNull(cArr, "array");
        synchronized (tzVar) {
            int i = tzVar.b;
            if (cArr.length + i < kv.a) {
                tzVar.b = i + cArr.length;
                ((km) tzVar.c).addLast(cArr);
            }
        }
    }

    public void q(Object obj) {
        HookParamWrapper hookParam = (HookParamWrapper) this.d;
        int i = this.c;
        if (i < 0) {
            throw new IllegalStateException("HookParam Method args index must be >= 0");
        }
        if (hookParam.getArgs().length == 0) {
            throw new IllegalStateException("HookParam Method args is empty, mabe not has args");
        }
        if (i > hookParam.getArgs().length - 1) {
            throw new IllegalStateException(
                    ("HookParam Method args index out of bounds, max is " + (hookParam.getArgs().length - 1))
                            .toString());
        }
        Object[] objArrI = hookParam.b.i();
        if (objArrI != null) {
            objArrI[i] = obj;
        }
    }

    public void r(String str, amw amwVar) {
        eg egVar = (eg) this.d;
        egVar.i = str;
        egVar.j = amwVar;
    }

    @Override // me.hd.wauxv.obf.sg
    public byte readByte() {
        byte[] bArr = (byte[]) this.d;
        int i = this.c;
        this.c = i + 1;
        return bArr[i];
    }

    public void s(String str, amw amwVar) {
        eg egVar = (eg) this.d;
        egVar.k = str;
        egVar.l = amwVar;
    }

    public void t(String str, amw amwVar) {
        eg egVar = (eg) this.d;
        egVar.g = str;
        egVar.h = amwVar;
    }

    public String toString() {
        switch (this.a) {
            case 8:
                return concatVar2Var1(this.c, "Args of index ");
            case 9:
                return new String((char[]) this.d, 0, this.c);
            default:
                return super.toString();
        }
    }

    public void u(String str) {
        throwIfVar1IsNull(str, "text");
        int length = str.length();
        if (length == 0) {
            return;
        }
        j(this.c, length);
        str.getChars(0, str.length(), (char[]) this.d, this.c);
        this.c += length;
    }

    public /* synthetic */ ek(Object obj, int i, int i2) {
        this.a = i2;
        this.d = obj;
        this.c = i;
    }

    public ek(brt brtVar, yi yiVar) {
        this.a = 10;
        throwIfVar1IsNull(brtVar, "configuration");
        this.d = yiVar;
    }

    public ek(byte b, int i) {
        this.a = i;
        switch (i) {
            case 7:
                this.c = 1;
                this.d = Collections.singletonList(null);
                break;
            case 11:
                this.d = new long[64];
                break;
            case 13:
                this.d = new but(17);
                this.c = 0;
                break;
            default:
                this.d = Bitmap.CompressFormat.JPEG;
                this.c = 100;
                break;
        }
    }

    public ek(byte[] bArr) {
        this.a = 3;
        this.d = bArr;
    }

    public ek(int i) {
        this.a = 12;
        if (i >= 0) {
            this.c = i;
            int i2 = (262143 + i) / 262144;
            this.d = new float[i2][];
            int i3 = 0;
            while (i3 < i2) {
                int i4 = i2 - 1;
                ((float[][]) this.d)[i3] = new float[(i3 == i4 ? i - (i4 * 262144) : 262144) + 1];
                i3++;
            }
            return;
        }
        throw new IllegalArgumentException(concatVar2Var1(i, "invalid size: "));
    }

    /*
     * JADX WARN: 'this' call moved to the top of the method (can break code
     * semantics)
     */
    public ek(Context context) {
        this(context, el.d(context, 0));
        this.a = 0;
    }

    public ek(Context context, int i) {
        this.a = 0;
        this.d = new eg(new ContextThemeWrapper(context, el.d(context, i)));
        this.c = i;
    }

    public ek(ArrayList arrayList) {
        this.a = 7;
        this.c = 0;
        this.d = arrayList;
    }
}

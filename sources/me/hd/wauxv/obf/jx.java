package me.hd.wauxv.obf;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Looper;
import android.os.ParcelFileDescriptor;
import android.os.Trace;
import android.text.Editable;
import android.text.Selection;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.util.TypedValue;
import android.view.KeyEvent;
import com.bumptech.glide.load.ImageHeaderParser$ImageType;
import io.github.rosemoe.sora.widget.CodeEditor;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.Stack;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import me.hd.wauxv.R;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public class jx implements dcq, cuv {
    public static volatile jx a;
    public static final Object b = new Object();
    public static jx c;
    public final /* synthetic */ int d;
    public Object e;
    public Object f;
    public Object h;

    public /* synthetic */ jx(int i, boolean z) {
        this.d = i;
    }

    private final void ai() {
    }

    private final void aj() {
    }

    public static boolean i(Editable editable, KeyEvent keyEvent, boolean z) {
        eml[] emlVarArr;
        if (KeyEvent.metaStateHasNoModifiers(keyEvent.getMetaState())) {
            int selectionStart = Selection.getSelectionStart(editable);
            int selectionEnd = Selection.getSelectionEnd(editable);
            if (selectionStart != -1 && selectionEnd != -1 && selectionStart == selectionEnd && (emlVarArr = (eml[]) editable.getSpans(selectionStart, selectionEnd, eml.class)) != null && emlVarArr.length > 0) {
                for (eml emlVar : emlVarArr) {
                    int spanStart = editable.getSpanStart(emlVar);
                    int spanEnd = editable.getSpanEnd(emlVar);
                    if ((z && spanStart == selectionStart) || ((!z && spanEnd == selectionStart) || (selectionStart > spanStart && selectionStart < spanEnd))) {
                        editable.delete(spanStart, spanEnd);
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static jx j(Context context) {
        if (a == null) {
            synchronized (b) {
                try {
                    if (a == null) {
                        a = new jx(context);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return a;
    }

    public static jx k(Context context, AttributeSet attributeSet, int[] iArr, int i) {
        return new jx(context, context.obtainStyledAttributes(attributeSet, iArr, i, 0));
    }

    public List aa(char c2) {
        jx jxVar;
        List arrayList = (List) ((HashMap) this.f).get(Character.valueOf(c2));
        if (arrayList == null && (jxVar = (jx) this.h) != null) {
            arrayList = new ArrayList(jxVar.aa(c2));
        }
        return arrayList == null ? Collections.EMPTY_LIST : arrayList;
    }

    public boolean ab(int i, adg adgVar, adq adqVar) {
        of ofVar = (of) this.f;
        int[] iArr = adqVar.bz;
        int[] iArr2 = adqVar.ad;
        ofVar.a = iArr[0];
        ofVar.b = iArr[1];
        ofVar.c = adqVar.cq();
        ofVar.d = adqVar.cm();
        ofVar.i = false;
        ofVar.j = i;
        boolean z = ofVar.a == 3;
        boolean z2 = ofVar.b == 3;
        boolean z3 = z && adqVar.bg > 0.0f;
        boolean z4 = z2 && adqVar.bg > 0.0f;
        if (z3 && iArr2[0] == 4) {
            ofVar.a = 1;
        }
        if (z4 && iArr2[1] == 4) {
            ofVar.b = 1;
        }
        adgVar.j(adqVar, ofVar);
        adqVar.dk(ofVar.e);
        adqVar.dh(ofVar.f);
        adqVar.ao = ofVar.h;
        adqVar.de(ofVar.g);
        ofVar.j = 0;
        return ofVar.i;
    }

    public Object ac(CharSequence charSequence, int i, int i2, int i3, boolean z, aui auiVar) {
        int i4;
        char c2;
        auk aukVar = new auk((cdd) ((chm) this.f).e);
        int iCodePointAt = Character.codePointAt(charSequence, i);
        int i5 = 0;
        boolean zP = true;
        int iCharCount = i;
        loop0: while (true) {
            i4 = iCharCount;
            while (true) {
                if (iCharCount < i2 && i5 < i3 && zP) {
                    SparseArray sparseArray = aukVar.c.a;
                    cdd cddVar = sparseArray == null ? null : (cdd) sparseArray.get(iCodePointAt);
                    if (aukVar.a == 2) {
                        if (cddVar != null) {
                            aukVar.c = cddVar;
                            aukVar.f++;
                        } else {
                            if (iCodePointAt == 65038) {
                                aukVar.g();
                            } else if (iCodePointAt != 65039) {
                                cdd cddVar2 = aukVar.c;
                                if (cddVar2.b != null) {
                                    if (aukVar.f != 1) {
                                        aukVar.d = cddVar2;
                                        aukVar.g();
                                    } else if (aukVar.h()) {
                                        aukVar.d = aukVar.c;
                                        aukVar.g();
                                    } else {
                                        aukVar.g();
                                    }
                                    c2 = 3;
                                } else {
                                    aukVar.g();
                                }
                            }
                            c2 = 1;
                        }
                        c2 = 2;
                    } else if (cddVar == null) {
                        aukVar.g();
                        c2 = 1;
                    } else {
                        aukVar.a = 2;
                        aukVar.c = cddVar;
                        aukVar.f = 1;
                        c2 = 2;
                    }
                    aukVar.e = iCodePointAt;
                    if (c2 == 1) {
                        iCharCount = Character.charCount(Character.codePointAt(charSequence, i4)) + i4;
                        if (iCharCount >= i2) {
                            break;
                        }
                        iCodePointAt = Character.codePointAt(charSequence, iCharCount);
                        break;
                    }
                    if (c2 == 2) {
                        int iCharCount2 = Character.charCount(iCodePointAt) + iCharCount;
                        if (iCharCount2 < i2) {
                            iCodePointAt = Character.codePointAt(charSequence, iCharCount2);
                        }
                        iCharCount = iCharCount2;
                    } else if (c2 == 3) {
                        if (!z && x(charSequence, i4, iCharCount, aukVar.d.b)) {
                            break;
                        }
                        zP = auiVar.p(charSequence, i4, iCharCount, aukVar.d.b);
                        i5++;
                        break;
                    }
                } else {
                    break loop0;
                }
            }
        }
        if (aukVar.a == 2 && aukVar.c.b != null && ((aukVar.f > 1 || aukVar.h()) && i5 < i3 && zP && (z || !x(charSequence, i4, iCharCount, aukVar.c.b)))) {
            auiVar.p(charSequence, i4, iCharCount, aukVar.c.b);
        }
        return auiVar.getResult();
    }

    @Override // me.hd.wauxv.obf.cuv
    public Object acquire() {
        Object objAcquire = ((cux) this.h).acquire();
        if (objAcquire == null) {
            objAcquire = ((axv) this.e).create();
            if (Log.isLoggable("FactoryPools", 2)) {
                Log.v("FactoryPools", "Created new " + objAcquire.getClass());
            }
        }
        if (objAcquire instanceof axw) {
            ((axw) objAcquire).al().a = false;
        }
        return objAcquire;
    }

    public void ad(char c2, dor dorVar) {
        ((HashMap) this.e).put(Character.valueOf(c2), dorVar);
    }

    public void ae() {
        ((TypedArray) this.e).recycle();
    }

    public void af(Runnable runnable) {
        CodeEditor codeEditor = (CodeEditor) ((WeakReference) this.e).get();
        if (codeEditor == null) {
            return;
        }
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            runnable.run();
        } else {
            codeEditor.ei(runnable);
        }
    }

    public void ag(adr adrVar, int i, int i2, int i3) {
        adrVar.getClass();
        int i4 = adrVar.bl;
        int i5 = adrVar.bm;
        adrVar.bl = 0;
        adrVar.bm = 0;
        adrVar.dk(i2);
        adrVar.dh(i3);
        if (i4 < 0) {
            adrVar.bl = 0;
        } else {
            adrVar.bl = i4;
        }
        if (i5 < 0) {
            adrVar.bm = 0;
        } else {
            adrVar.bm = i5;
        }
        adr adrVar2 = (adr) this.h;
        adrVar2.d = i;
        adrVar2.eh();
    }

    public void ah(adr adrVar) {
        ArrayList arrayList = (ArrayList) this.e;
        arrayList.clear();
        int size = adrVar.a.size();
        for (int i = 0; i < size; i++) {
            adq adqVar = (adq) adrVar.a.get(i);
            int[] iArr = adqVar.bz;
            if (iArr[0] == 3 || iArr[1] == 3) {
                arrayList.add(adqVar);
            }
        }
        adrVar.c.b = true;
    }

    @Override // me.hd.wauxv.obf.dcq
    public dcg g(dcg dcgVar, crw crwVar) {
        Drawable drawable = (Drawable) dcgVar.get();
        if (drawable instanceof BitmapDrawable) {
            return ((ek) this.f).g(pa.g(((BitmapDrawable) drawable).getBitmap(), (oz) this.e), crwVar);
        }
        if (drawable instanceof bha) {
            return ((awp) this.h).g(dcgVar, crwVar);
        }
        return null;
    }

    @Override // me.hd.wauxv.obf.cuv
    public boolean l(Object obj) {
        if (obj instanceof axw) {
            ((axw) obj).al().a = true;
        }
        switch (((awp) this.f).b) {
            case 3:
                break;
            default:
                ((List) obj).clear();
                break;
        }
        return ((cux) this.h).l(obj);
    }

    public synchronized void m(btj btjVar, awl awlVar) {
        de deVar = (de) ((HashMap) this.e).put(btjVar, new de(btjVar, awlVar, (ReferenceQueue) this.f));
        if (deVar != null) {
            deVar.c = null;
            deVar.clear();
        }
    }

    public void n(de deVar) {
        dcg dcgVar;
        synchronized (this) {
            ((HashMap) this.e).remove(deVar.a);
            if (deVar.b && (dcgVar = deVar.c) != null) {
                ((awd) this.h).n(deVar.a, new awl(dcgVar, true, false, deVar.a, (awd) this.h));
            }
        }
    }

    public Bitmap o(BitmapFactory.Options options) throws Throwable {
        switch (this.d) {
            case 11:
                return emc.aj(new se(sf.d((ByteBuffer) this.e)), options, this);
            case 12:
                cyp cypVar = (cyp) ((bmu) this.e).h;
                cypVar.reset();
                return emc.aj(cypVar, options, this);
            default:
                FileDescriptor fileDescriptor = ((com.bumptech.glide.load.data.a) this.h).b().getFileDescriptor();
                int i = Build.VERSION.SDK_INT;
                Bitmap bitmapAx = null;
                if (i == 34) {
                    if (((i == 34 && options.inPreferredConfig == Bitmap.Config.HARDWARE) ? ((Boolean) aye.c.get()).booleanValue() : false) && emc.at(this)) {
                        Bitmap.Config config = options.inPreferredConfig;
                        Bitmap.Config config2 = Bitmap.Config.HARDWARE;
                        cmz.k("", config == config2);
                        options.inPreferredConfig = Bitmap.Config.ARGB_8888;
                        try {
                            Bitmap bitmapDecodeFileDescriptor = BitmapFactory.decodeFileDescriptor(fileDescriptor, null, options);
                            if (bitmapDecodeFileDescriptor == null) {
                                if (bitmapDecodeFileDescriptor != null) {
                                }
                                options.inPreferredConfig = config2;
                                return bitmapAx;
                            }
                            try {
                                bitmapAx = emc.ax(bitmapDecodeFileDescriptor);
                            } catch (Throwable th) {
                                th = th;
                                bitmapAx = bitmapDecodeFileDescriptor;
                                if (bitmapAx != null) {
                                    bitmapAx.recycle();
                                }
                                options.inPreferredConfig = Bitmap.Config.HARDWARE;
                                throw th;
                            }
                            break;
                            bitmapDecodeFileDescriptor.recycle();
                            options.inPreferredConfig = config2;
                            return bitmapAx;
                        } catch (Throwable th2) {
                            th = th2;
                        }
                    }
                }
                return BitmapFactory.decodeFileDescriptor(fileDescriptor, null, options);
        }
    }

    public void p(Bundle bundle) {
        HashSet hashSet = (HashSet) this.f;
        String string = ((Context) this.h).getString(R.string.androidx_startup);
        if (bundle != null) {
            try {
                HashSet hashSet2 = new HashSet();
                for (String str : bundle.keySet()) {
                    if (string.equals(bundle.getString(str, null))) {
                        Class<?> cls = Class.forName(str);
                        if (bpf.class.isAssignableFrom(cls)) {
                            hashSet.add(cls);
                        }
                    }
                }
                Iterator it = hashSet.iterator();
                while (it.hasNext()) {
                    q((Class) it.next(), hashSet2);
                }
            } catch (ClassNotFoundException e) {
                throw new abt(e);
            }
        }
    }

    public Object q(Class cls, HashSet hashSet) {
        Object objB;
        HashMap map = (HashMap) this.e;
        if (cnf.bj()) {
            try {
                cnf.an(cls.getSimpleName());
            } catch (Throwable th) {
                Trace.endSection();
                throw th;
            }
        }
        if (hashSet.contains(cls)) {
            throw new IllegalStateException("Cannot initialize " + cls.getName() + ". Cycle detected.");
        }
        if (map.containsKey(cls)) {
            objB = map.get(cls);
        } else {
            hashSet.add(cls);
            try {
                bpf bpfVar = (bpf) cls.getDeclaredConstructor(null).newInstance(null);
                List<Class> listA = bpfVar.a();
                if (!listA.isEmpty()) {
                    for (Class cls2 : listA) {
                        if (!map.containsKey(cls2)) {
                            q(cls2, hashSet);
                        }
                    }
                }
                objB = bpfVar.b((Context) this.h);
                hashSet.remove(cls);
                map.put(cls, objB);
            } catch (Throwable th2) {
                throw new abt(th2);
            }
        }
        Trace.endSection();
        return objB;
    }

    public ColorStateList r(int i) {
        int resourceId;
        ColorStateList colorStateListV;
        TypedArray typedArray = (TypedArray) this.e;
        return (!typedArray.hasValue(i) || (resourceId = typedArray.getResourceId(i, 0)) == 0 || (colorStateListV = bht.v((Context) this.h, resourceId)) == null) ? typedArray.getColorStateList(i) : colorStateListV;
    }

    public Drawable s(int i) {
        int resourceId;
        TypedArray typedArray = (TypedArray) this.e;
        return (!typedArray.hasValue(i) || (resourceId = typedArray.getResourceId(i, 0)) == 0) ? typedArray.getDrawable(i) : cmz.y((Context) this.h, resourceId);
    }

    public Drawable t(int i) {
        int resourceId;
        Drawable drawableM;
        if (!((TypedArray) this.e).hasValue(i) || (resourceId = ((TypedArray) this.e).getResourceId(i, 0)) == 0) {
            return null;
        }
        C0023if c0023ifD = C0023if.d();
        Context context = (Context) this.h;
        synchronized (c0023ifD) {
            drawableM = c0023ifD.c.m(context, resourceId, true);
        }
        return drawableM;
    }

    public String toString() {
        switch (this.d) {
            case 17:
                String str = (String) this.h;
                String str2 = (String) this.f;
                StringBuilder sb = new StringBuilder("NavDeepLinkRequest{");
                Uri uri = (Uri) this.e;
                if (uri != null) {
                    sb.append(" uri=");
                    sb.append(String.valueOf(uri));
                }
                if (str2 != null) {
                    sb.append(" action=");
                    sb.append(str2);
                }
                if (str != null) {
                    sb.append(" mimetype=");
                    sb.append(str);
                }
                sb.append(" }");
                String string = sb.toString();
                bzo.p(string, "toString(...)");
                return string;
            default:
                return super.toString();
        }
    }

    public Typeface u(int i, int i2, jg jgVar) {
        int resourceId = ((TypedArray) this.e).getResourceId(i, 0);
        if (resourceId == 0) {
            return null;
        }
        if (((TypedValue) this.f) == null) {
            this.f = new TypedValue();
        }
        Context context = (Context) this.h;
        TypedValue typedValue = (TypedValue) this.f;
        ThreadLocal threadLocal = dcu.a;
        if (context.isRestricted()) {
            return null;
        }
        return dcu.e(context, resourceId, typedValue, i2, jgVar, true, false);
    }

    public ImageHeaderParser$ImageType v() throws Throwable {
        switch (this.d) {
            case 11:
                return bhv.aa((List) this.f, sf.d((ByteBuffer) this.e));
            case 12:
                List list = (List) this.h;
                cyp cypVar = (cyp) ((bmu) this.e).h;
                cypVar.reset();
                return bhv.z(list, cypVar, (bva) this.f);
            default:
                List list2 = (List) this.f;
                com.bumptech.glide.load.data.a aVar = (com.bumptech.glide.load.data.a) this.h;
                bva bvaVar = (bva) this.e;
                int size = list2.size();
                for (int i = 0; i < size; i++) {
                    bog bogVar = (bog) list2.get(i);
                    cyp cypVar2 = null;
                    try {
                        cyp cypVar3 = new cyp(new FileInputStream(aVar.b().getFileDescriptor()), bvaVar);
                        try {
                            ImageHeaderParser$ImageType imageHeaderParser$ImageTypeL = bogVar.l(cypVar3);
                            cypVar3.i();
                            aVar.b();
                            if (imageHeaderParser$ImageTypeL != ImageHeaderParser$ImageType.UNKNOWN) {
                                return imageHeaderParser$ImageTypeL;
                            }
                        } catch (Throwable th) {
                            th = th;
                            cypVar2 = cypVar3;
                            if (cypVar2 != null) {
                                cypVar2.i();
                            }
                            aVar.b();
                            throw th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                    }
                }
                return ImageHeaderParser$ImageType.UNKNOWN;
        }
    }

    public Class w() {
        String str = (String) this.e;
        if (((Class) this.h) == null) {
            bfu bfuVar = (bfu) this.f;
            this.h = zf.b(bfuVar != null ? (ClassLoader) bfuVar.invoke() : null, str);
        }
        Class cls = (Class) this.h;
        if (cls != null) {
            return cls;
        }
        throw new IllegalStateException("Exception has been thrown above.");
    }

    public boolean x(CharSequence charSequence, int i, int i2, emk emkVar) {
        if ((emkVar.d & 3) == 0) {
            atc atcVar = (atc) this.h;
            cdb cdbVarF = emkVar.f();
            int iF = cdbVarF.f(8);
            if (iF != 0) {
                ((ByteBuffer) cdbVarF.e).getShort(iF + cdbVarF.b);
            }
            akm akmVar = (akm) atcVar;
            akmVar.getClass();
            ThreadLocal threadLocal = akm.a;
            if (threadLocal.get() == null) {
                threadLocal.set(new StringBuilder());
            }
            StringBuilder sb = (StringBuilder) threadLocal.get();
            sb.setLength(0);
            while (i < i2) {
                sb.append(charSequence.charAt(i));
                i++;
            }
            TextPaint textPaint = akmVar.b;
            String string = sb.toString();
            int i3 = csl.a;
            boolean zHasGlyph = textPaint.hasGlyph(string);
            int i4 = emkVar.d & 4;
            emkVar.d = zHasGlyph ? i4 | 2 : i4 | 1;
        }
        return (emkVar.d & 3) == 2;
    }

    public boolean y() {
        switch (this.d) {
            case 11:
                List list = (List) this.f;
                ByteBuffer byteBufferD = sf.d((ByteBuffer) this.e);
                bva bvaVar = (bva) this.h;
                if (byteBufferD == null) {
                    return false;
                }
                int size = list.size();
                for (int i = 0; i < size; i++) {
                    try {
                        boolean zN = ((bog) list.get(i)).n(byteBufferD, bvaVar);
                        if (zN) {
                            return true;
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                return false;
            case 12:
                List list2 = (List) this.h;
                cyp cypVar = (cyp) ((bmu) this.e).h;
                cypVar.reset();
                bva bvaVar2 = (bva) this.f;
                cypVar.mark(5242880);
                int size2 = list2.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    try {
                        boolean zO = ((bog) list2.get(i2)).o(cypVar, bvaVar2);
                        cypVar.reset();
                        if (zO) {
                            return true;
                        }
                    } catch (Throwable th2) {
                        cypVar.reset();
                        throw th2;
                    }
                }
                return false;
            default:
                List list3 = (List) this.f;
                com.bumptech.glide.load.data.a aVar = (com.bumptech.glide.load.data.a) this.h;
                bva bvaVar3 = (bva) this.e;
                int size3 = list3.size();
                for (int i3 = 0; i3 < size3; i3++) {
                    bog bogVar = (bog) list3.get(i3);
                    cyp cypVar2 = null;
                    try {
                        cyp cypVar3 = new cyp(new FileInputStream(aVar.b().getFileDescriptor()), bvaVar3);
                        try {
                            boolean zO2 = bogVar.o(cypVar3, bvaVar3);
                            cypVar3.i();
                            aVar.b();
                            if (zO2) {
                                return true;
                            }
                        } catch (Throwable th3) {
                            th = th3;
                            cypVar2 = cypVar3;
                            if (cypVar2 != null) {
                                cypVar2.i();
                            }
                            aVar.b();
                            throw th;
                        }
                    } catch (Throwable th4) {
                        th = th4;
                    }
                }
                return false;
        }
    }

    public dor z(char c2) {
        jx jxVar;
        dor dorVar = (dor) ((HashMap) this.e).get(Character.valueOf(c2));
        return (dorVar != null || (jxVar = (jx) this.h) == null) ? dorVar : jxVar.z(c2);
    }

    public /* synthetic */ jx(Object obj, Object obj2, Object obj3, int i) {
        this.d = i;
        this.e = obj;
        this.f = obj2;
        this.h = obj3;
    }

    public jx(int i) {
        this.d = i;
        switch (i) {
            case 19:
                this.e = new HashMap();
                this.f = new HashMap();
                this.h = null;
                break;
            default:
                ExecutorService executorServiceNewSingleThreadExecutor = Executors.newSingleThreadExecutor(new dd(0));
                this.e = new HashMap();
                this.f = new ReferenceQueue();
                executorServiceNewSingleThreadExecutor.execute(new dc(this, 1));
                break;
        }
    }

    public jx(CodeEditor codeEditor, int i) {
        this.d = i;
        switch (i) {
            case 18:
                this.e = codeEditor;
                this.f = new ArrayList(64);
                this.h = new Stack();
                break;
            default:
                this.e = new WeakReference(codeEditor);
                codeEditor.i.l(dfn.class, new qp(this, 6));
                break;
        }
    }

    public jx(Context context, TypedArray typedArray) {
        this.d = 20;
        this.h = context;
        this.e = typedArray;
    }

    public jx(Runnable runnable) {
        this.d = 15;
        this.h = new CopyOnWriteArrayList();
        this.e = new HashMap();
        this.f = runnable;
    }

    public jx(Context context, LocationManager locationManager) {
        this.d = 21;
        this.f = new emb();
        this.h = context;
        this.e = locationManager;
    }

    public jx(Context context) {
        this.d = 0;
        this.h = context.getApplicationContext();
        this.f = new HashSet();
        this.e = new HashMap();
    }

    public jx(adr adrVar) {
        this.d = 2;
        this.e = new ArrayList();
        this.f = new of();
        this.h = adrVar;
    }

    public jx(String str, bfu bfuVar) {
        this.d = 14;
        this.e = str;
        this.f = bfuVar;
    }

    public jx(chm chmVar, nu nuVar, akm akmVar, Set set) {
        this.d = 8;
        this.e = nuVar;
        this.f = chmVar;
        this.h = akmVar;
        if (set.isEmpty()) {
            return;
        }
        Iterator it = set.iterator();
        while (it.hasNext()) {
            int[] iArr = (int[]) it.next();
            String str = new String(iArr, 0, iArr.length);
            ac(str, 0, str.length(), 1, true, new auj(str, 0));
        }
    }

    public jx(cux cuxVar, axv axvVar, awp awpVar) {
        this.d = 10;
        this.h = cuxVar;
        this.e = axvVar;
        this.f = awpVar;
    }

    public jx(bzp bzpVar, ArrayList arrayList, bva bvaVar) {
        this.d = 12;
        cmz.n(bvaVar, "Argument must not be null");
        this.f = bvaVar;
        cmz.n(arrayList, "Argument must not be null");
        this.h = arrayList;
        this.e = new bmu(bzpVar, bvaVar);
    }

    public jx(ParcelFileDescriptor parcelFileDescriptor, ArrayList arrayList, bva bvaVar) {
        this.d = 13;
        cmz.n(bvaVar, "Argument must not be null");
        this.e = bvaVar;
        cmz.n(arrayList, "Argument must not be null");
        this.f = arrayList;
        this.h = new com.bumptech.glide.load.data.a(parcelFileDescriptor);
    }

    public jx(awd awdVar, dht dhtVar, awh awhVar) {
        this.d = 9;
        this.h = awdVar;
        this.f = dhtVar;
        this.e = awhVar;
    }
}

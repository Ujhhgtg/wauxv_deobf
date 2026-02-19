package me.hd.wauxv.obf;

import android.R;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.util.Log;
import android.util.SparseArray;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.widget.ListView;
import androidx.viewpager2.widget.ViewPager2;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;
import net.bytebuddy.utility.JavaConstant;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class chm implements dom {
    public static final cbm a;
    public static final ent b;
    public Object c;
    public Object d;
    public Object e;
    public Object f;

    static {
        int i = 2;
        a = new cbm(i);
        b = new ent(i);
    }

    public /* synthetic */ chm(Object obj, Object obj2, Object obj3, Object obj4) {
        this.d = obj2;
        this.e = obj3;
        this.f = obj4;
        this.c = obj;
    }

    public static void g(String str, ArrayList arrayList) {
        if (arrayList.isEmpty() || !(StaticHelpers6.getLastNElem(1, arrayList) instanceof cts)) {
            arrayList.add(new cts(str));
            return;
        }
        cts ctsVar = (cts) StaticHelpers6.getLastNElem(1, arrayList);
        String str2 = ctsVar.a + str;
        throwIfVar1IsNull(str2, "<set-?>");
        ctsVar.a = str2;
    }

    public static int h(Object obj) {
        Object objX;
        boolean z = obj instanceof tw;
        String str = z ? ((tw) obj).a : "placeholder";
        if (z) {
            obj = ((tw) obj).b;
        }
        Bundle bundle = new Bundle();
        if (obj != null) {
            if (obj instanceof Boolean) {
                bundle.putBoolean(str, ((Boolean) obj).booleanValue());
            } else if (obj instanceof boolean[]) {
                bundle.putBooleanArray(str, (boolean[]) obj);
            } else if (obj instanceof Byte) {
                bundle.putByte(str, ((Number) obj).byteValue());
            } else if (obj instanceof byte[]) {
                bundle.putByteArray(str, (byte[]) obj);
            } else if (obj instanceof Character) {
                bundle.putChar(str, ((Character) obj).charValue());
            } else if (obj instanceof char[]) {
                bundle.putCharArray(str, (char[]) obj);
            } else if (obj instanceof Double) {
                bundle.putDouble(str, ((Number) obj).doubleValue());
            } else if (obj instanceof double[]) {
                bundle.putDoubleArray(str, (double[]) obj);
            } else if (obj instanceof Float) {
                bundle.putFloat(str, ((Number) obj).floatValue());
            } else if (obj instanceof float[]) {
                bundle.putFloatArray(str, (float[]) obj);
            } else if (obj instanceof Integer) {
                bundle.putInt(str, ((Number) obj).intValue());
            } else if (obj instanceof int[]) {
                bundle.putIntArray(str, (int[]) obj);
            } else if (obj instanceof Long) {
                bundle.putLong(str, ((Number) obj).longValue());
            } else if (obj instanceof long[]) {
                bundle.putLongArray(str, (long[]) obj);
            } else if (obj instanceof Short) {
                bundle.putShort(str, ((Number) obj).shortValue());
            } else if (obj instanceof short[]) {
                bundle.putShortArray(str, (short[]) obj);
            } else if (obj instanceof String) {
                bundle.putString(str, (String) obj);
            } else if (obj instanceof Object[]) {
                bundle.putSerializable(str, (Serializable) obj);
            } else if (obj instanceof CharSequence) {
                bundle.putCharSequence(str, (CharSequence) obj);
            } else if (obj instanceof Parcelable) {
                bundle.putParcelable(str, (Parcelable) obj);
            } else {
                if (!(obj instanceof Serializable)) {
                    throw new IllegalStateException(
                            ("Key-Value type " + obj.getClass().getName() + " is not allowed").toString());
                }
                bundle.putSerializable(str, (Serializable) obj);
            }
        }
        try {
            Parcel parcelObtain = Parcel.obtain();
            parcelObtain.writeBundle(bundle);
            int iDataSize = parcelObtain.dataSize();
            parcelObtain.recycle();
            objX = Integer.valueOf(iDataSize);
        } catch (Throwable th) {
            objX = FastKV.x(th);
        }
        if (objX instanceof dcx) {
            objX = null;
        }
        Integer num = (Integer) objX;
        if (num != null) {
            return num.intValue();
        }
        return -1;
    }

    /* JADX WARN: Found duplicated region for block: B:119:0x0274 */
    /* JADX WARN: Found duplicated region for block: B:122:0x027f */
    /* JADX WARN: Found duplicated region for block: B:131:0x02a7 */
    /* JADX WARN: Found duplicated region for block: B:138:0x02e5 */
    /* JADX WARN: Found duplicated region for block: B:151:0x02b2 A[SYNTHETIC] */
    /* JADX WARN: Found duplicated region for block: B:152:0x02d7 A[SYNTHETIC] */
    /* JADX WARN: Found duplicated region for block: B:153:0x02c6 A[SYNTHETIC] */
    /* JADX WARN: Found duplicated region for block: B:154:0x02a3 A[SYNTHETIC] */
    /* JADX WARN: Found duplicated region for block: B:188:0x0297 A[SYNTHETIC] */
    /* JADX WARN: Found duplicated region for block: B:189:0x0291 A[SYNTHETIC] */
    /* JADX WARN: Found duplicated region for block: B:190:0x028b A[SYNTHETIC] */
    /* JADX WARN: Found duplicated region for block: B:191:0x0285 A[SYNTHETIC] */
    public static aao i(String str) {
        String str2;
        adh adhVar;
        StringBuilder sb;
        String strO;
        String strO2;
        String str3;
        ArrayList arrayList = new ArrayList();
        chm chmVar = new chm();
        chmVar.c = str;
        chmVar.d = new ik(arrayList);
        chmVar.e = new aap(str);
        ik ikVar = (ik) chmVar.d;
        chmVar.f = ((aap) chmVar.e).f();
        while (true) {
            ekj ekjVar = ekj.Backslash;
            boolean zR = chmVar.r(ekjVar);
            str2 = "\\";
            ekj ekjVar2 = ekj.Backtick;
            ekj ekjVar3 = ekj.Dollar;
            ekj ekjVar4 = ekj.CurlyClose;
            if (zR) {
                String strP = chmVar.p(ekjVar4, ekjVar3, ekjVar, ekjVar2);
                ikVar.i(strP != null ? strP : "\\");
            } else {
                adh adhVar2 = (adh) chmVar.f;
                boolean zR2 = chmVar.r(ekjVar3);
                ekj ekjVar5 = ekj.VariableName;
                ekj ekjVar6 = ekj.Int;
                ctq ctqVar = null;
                if (zR2) {
                    String strO3 = chmVar.o(ekjVar6);
                    if (strO3 != null) {
                        ikVar.h(Integer.parseInt(strO3), null);
                    } else {
                        String strO4 = chmVar.o(ekjVar5);
                        if (strO4 != null) {
                            ((ArrayList) ikVar.d).add(new epb(ikVar.b, strO4, null, null));
                        } else {
                            chmVar.t(adhVar2);
                        }
                    }
                }
                epb epbVarQ = chmVar.q();
                if (epbVarQ != null) {
                    int i = ikVar.b;
                    epbVarQ.c = i;
                    epbVarQ.d = i;
                    ((ArrayList) ikVar.d).add(epbVarQ);
                }
                if (epbVarQ != null) {
                    continue;
                } else {
                    adh adhVar3 = (adh) chmVar.f;
                    boolean zR3 = chmVar.r(ekjVar3);
                    ekj ekjVar7 = ekj.EOF;
                    if (!zR3 || !chmVar.r(ekj.CurlyOpen) || (strO = chmVar.o(ekjVar6)) == null) {
                        chmVar.t(adhVar3);
                        adhVar = (adh) chmVar.f;
                        if (chmVar.r(ekjVar2)) {
                            sb = new StringBuilder();
                            while (true) {
                                if (chmVar.r(ekjVar2)) {
                                    ((ArrayList) ikVar.d).add(new bqm(sb.toString(), ikVar.b));
                                } else if (chmVar.r(ekjVar)) {
                                    if (chmVar.r(ekjVar2)) {
                                        sb.append('`');
                                    } else {
                                        sb.append('\\');
                                    }
                                } else if (((ekj) ((adh) chmVar.f).d) == ekjVar7) {
                                    chmVar.t(adhVar);
                                } else {
                                    sb.append(chmVar.p(new ekj[0]));
                                }
                            }
                        } else {
                            chmVar.t((adh) chmVar.f);
                        }
                        if (((ekj) ((adh) chmVar.f).d) == ekjVar7) {
                            return new aao((ArrayList) ikVar.d, (ArrayList) ikVar.c);
                        }
                        ikVar.i(chmVar.p(new ekj[0]));
                    } else if (chmVar.r(ekj.Colon)) {
                        ArrayList arrayList2 = new ArrayList();
                        while (true) {
                            if (chmVar.r(ekjVar4)) {
                                ikVar.g(Integer.parseInt(strO), arrayList2);
                            } else if (chmVar.r(ekjVar)) {
                                String strP2 = chmVar.p(ekjVar, ekjVar3, ekjVar4);
                                if (strP2 == null) {
                                    strP2 = str2;
                                }
                                g(strP2, arrayList2);
                            } else {
                                adh adhVar4 = (adh) chmVar.f;
                                if (((ekj) adhVar4.d) == ekjVar7) {
                                    chmVar.t(adhVar3);
                                    adhVar = (adh) chmVar.f;
                                    if (chmVar.r(ekjVar2)) {
                                        sb = new StringBuilder();
                                        while (true) {
                                            if (chmVar.r(ekjVar2)) {
                                                ((ArrayList) ikVar.d).add(new bqm(sb.toString(), ikVar.b));
                                            } else if (chmVar.r(ekjVar)) {
                                                if (chmVar.r(ekjVar2)) {
                                                    sb.append('`');
                                                } else {
                                                    sb.append('\\');
                                                }
                                            } else if (((ekj) ((adh) chmVar.f).d) == ekjVar7) {
                                                chmVar.t(adhVar);
                                            } else {
                                                sb.append(chmVar.p(new ekj[0]));
                                            }
                                        }
                                    } else {
                                        chmVar.t((adh) chmVar.f);
                                    }
                                    if (((ekj) ((adh) chmVar.f).d) == ekjVar7) {
                                        return new aao((ArrayList) ikVar.d, (ArrayList) ikVar.c);
                                    }
                                    ikVar.i(chmVar.p(new ekj[0]));
                                } else {
                                    if (!chmVar.r(ekjVar3) || (strO2 = chmVar.o(ekjVar5)) == null) {
                                        chmVar.t(adhVar4);
                                        strO2 = null;
                                    }
                                    if (strO2 != null) {
                                        str3 = str2;
                                        arrayList2.add(new epb(((adh) chmVar.f).b, strO2, "", null));
                                    } else {
                                        str3 = str2;
                                        epb epbVarQ2 = chmVar.q();
                                        if (epbVarQ2 != null) {
                                            int i2 = ((adh) chmVar.f).b;
                                            epbVarQ2.c = i2;
                                            epbVarQ2.d = i2;
                                            arrayList2.add(epbVarQ2);
                                        } else {
                                            String str4 = (String) chmVar.c;
                                            adh adhVar5 = (adh) chmVar.f;
                                            int i3 = adhVar5.b;
                                            g(str4.substring(i3, adhVar5.c + i3), arrayList2);
                                            chmVar.al();
                                        }
                                    }
                                    str2 = str3;
                                }
                            }
                        }
                    } else {
                        ekj ekjVar8 = ekj.Pipe;
                        if (chmVar.r(ekjVar8)) {
                            ArrayList arrayList3 = new ArrayList();
                            while (true) {
                                adh adhVar6 = (adh) chmVar.f;
                                StringBuilder sb2 = new StringBuilder();
                                while (true) {
                                    ekj ekjVar9 = (ekj) ((adh) chmVar.f).d;
                                    ekj ekjVar10 = ekj.Comma;
                                    if (ekjVar9 == ekjVar10 || ekjVar9 == ekjVar8) {
                                        if (sb2.length() == 0) {
                                            chmVar.t(adhVar6);
                                        } else {
                                            arrayList3.add(sb2.toString());
                                            if (!chmVar.r(ekjVar10)) {
                                                if (chmVar.r(ekjVar8) && chmVar.r(ekjVar4)) {
                                                    int i4 = Integer.parseInt(strO);
                                                    ikVar.getClass();
                                                    if (arrayList3.isEmpty()) {
                                                        ikVar.h(i4, null);
                                                    } else if (arrayList3.size() == 1) {
                                                        ikVar.h(i4, (String) arrayList3.get(0));
                                                    } else {
                                                        ikVar.h(i4, (String) arrayList3.get(0));
                                                        for (ctq ctqVar2 : (ArrayList) ikVar.c) {
                                                            if (ctqVar2.a == i4) {
                                                                ctqVar = ctqVar2;
                                                                break;
                                                            }
                                                        }
                                                        Objects.requireNonNull(ctqVar);
                                                        ctqVar.b = arrayList3;
                                                    }
                                                }
                                            }
                                        }
                                    } else if (chmVar.r(ekjVar)) {
                                        String strP3 = chmVar.p(ekjVar8, ekjVar10, ekjVar);
                                        if (strP3 != null) {
                                            sb2.append(strP3);
                                        } else {
                                            sb2.append('\\');
                                        }
                                    } else if (((ekj) ((adh) chmVar.f).d) != ekjVar7) {
                                        sb2.append(chmVar.p(new ekj[0]));
                                    } else {
                                        chmVar.t(adhVar6);
                                    }
                                    chmVar.t(adhVar3);
                                    adhVar = (adh) chmVar.f;
                                    if (chmVar.r(ekjVar2)) {
                                        sb = new StringBuilder();
                                        while (true) {
                                            if (chmVar.r(ekjVar2)) {
                                                ((ArrayList) ikVar.d).add(new bqm(sb.toString(), ikVar.b));
                                            } else if (chmVar.r(ekjVar)) {
                                                if (chmVar.r(ekjVar2)) {
                                                    sb.append('`');
                                                } else {
                                                    sb.append('\\');
                                                }
                                            } else if (((ekj) ((adh) chmVar.f).d) == ekjVar7) {
                                                chmVar.t(adhVar);
                                            } else {
                                                sb.append(chmVar.p(new ekj[0]));
                                            }
                                        }
                                    } else {
                                        chmVar.t((adh) chmVar.f);
                                    }
                                    if (((ekj) ((adh) chmVar.f).d) == ekjVar7) {
                                        return new aao((ArrayList) ikVar.d, (ArrayList) ikVar.c);
                                    }
                                    ikVar.i(chmVar.p(new ekj[0]));
                                }
                            }
                        } else if (chmVar.r(ekj.Forwardslash)) {
                            ConnectivityMonitor connectivityMonitorVar = new ConnectivityMonitor(3);
                            if (chmVar.ap(connectivityMonitorVar)) {
                                int i5 = Integer.parseInt(strO);
                                ikVar.h(i5, null);
                                for (ctq ctqVar3 : (ArrayList) ikVar.c) {
                                    if (ctqVar3.a == i5) {
                                        ctqVar = ctqVar3;
                                        break;
                                    }
                                }
                                Objects.requireNonNull(ctqVar);
                                ctqVar.d = connectivityMonitorVar;
                            } else {
                                chmVar.t(adhVar3);
                                adhVar = (adh) chmVar.f;
                                if (chmVar.r(ekjVar2)) {
                                    sb = new StringBuilder();
                                    while (true) {
                                        if (chmVar.r(ekjVar2)) {
                                            ((ArrayList) ikVar.d).add(new bqm(sb.toString(), ikVar.b));
                                        } else if (chmVar.r(ekjVar)) {
                                            if (chmVar.r(ekjVar2)) {
                                                sb.append('`');
                                            } else {
                                                sb.append('\\');
                                            }
                                        } else if (((ekj) ((adh) chmVar.f).d) == ekjVar7) {
                                            chmVar.t(adhVar);
                                        } else {
                                            sb.append(chmVar.p(new ekj[0]));
                                        }
                                    }
                                } else {
                                    chmVar.t((adh) chmVar.f);
                                }
                                if (((ekj) ((adh) chmVar.f).d) == ekjVar7) {
                                    return new aao((ArrayList) ikVar.d, (ArrayList) ikVar.c);
                                }
                                ikVar.i(chmVar.p(new ekj[0]));
                            }
                        } else if (chmVar.r(ekjVar4)) {
                            ikVar.h(Integer.parseInt(strO), null);
                        } else {
                            chmVar.t(adhVar3);
                            adhVar = (adh) chmVar.f;
                            if (chmVar.r(ekjVar2)) {
                                sb = new StringBuilder();
                                while (true) {
                                    if (chmVar.r(ekjVar2)) {
                                        ((ArrayList) ikVar.d).add(new bqm(sb.toString(), ikVar.b));
                                    } else if (chmVar.r(ekjVar)) {
                                        if (chmVar.r(ekjVar2)) {
                                            sb.append('`');
                                        } else {
                                            sb.append('\\');
                                        }
                                    } else if (((ekj) ((adh) chmVar.f).d) == ekjVar7) {
                                        chmVar.t(adhVar);
                                    } else {
                                        sb.append(chmVar.p(new ekj[0]));
                                    }
                                }
                            } else {
                                chmVar.t((adh) chmVar.f);
                            }
                            if (((ekj) ((adh) chmVar.f).d) == ekjVar7) {
                                return new aao((ArrayList) ikVar.d, (ArrayList) ikVar.c);
                            }
                            ikVar.i(chmVar.p(new ekj[0]));
                        }
                    }
                }
            }
        }
    }

    public static final void j(tx txVar, int i, String str) {
        ArrayList arrayList = ewq.a;
        tw twVar = txVar.e;
        String str2 = twVar.a;
        Object obj = twVar.b;
        ewq.g(6, "YukiHookDataChannel cannot send this data key of \"" + str2 + "\" type "
                + (obj != null ? obj.getClass() : null) + ", because it is too large (total " + (i / 1024.0f)
                + " KB, limit " + (exf.d / 1024.0f) + " KB) and cannot be segmented\n"
                + (!dnj.ak(str) ? str.concat("\n") : "")
                + "If you want to lift this restriction, use the allowSendTooLargeData function when calling, but this may cause the app crash",
                null);
    }

    public static final void k(tx txVar, int i, String str) {
        j(txVar, i, "Failed to segment " + str
                + " type because the size of its first element has exceeded the maximum limit");
    }

    public static tx l(tw twVar, String str, int i, int i2) {
        return new tx(str, i > 0, i, i2, twVar);
    }

    public static void n(final chm chmVar, final String str, final IInvokable bgfVar) {
        Context context = (Context) chmVar.c;
        final exf exfVar = (exf) chmVar.f;
        exfVar.g.put(
                StaticHelpers6.concat(str,
                        chmVar.ag() + JavaConstant.Dynamic.DEFAULT_NAME
                                + (exf.a ? "X" : context != null ? context.getClass().getName() : "M") + "_0"),
                new Pair(context, new bgj(exfVar, chmVar, str, bgfVar) { // from class: me.hd.wauxv.obf.exd
                    public final /* synthetic */ chm a;
                    public final /* synthetic */ String b;
                    public final /* synthetic */ IInvokable c;

                    {
                        this.a = chmVar;
                        this.b = str;
                        this.c = bgfVar;
                    }

                    /* JADX WARN: Found duplicated region for block: B:204:0x01ea */
                    /*
                     * JADX WARN: Undo finally extract visitor
                     * java.lang.NullPointerException
                     * at java.base/java.util.Objects.requireNonNull(Objects.java:209)
                     * at java.base/java.util.ArrayList.batchRemove(ArrayList.java:816)
                     * at java.base/java.util.ArrayList.removeAll(ArrayList.java:791)
                     * at jadx.core.dex.visitors.finaly.TryCatchEdgeBlockMap.getAllInScope(
                     * TryCatchEdgeBlockMap.java:91)
                     * at jadx.core.dex.visitors.finaly.MarkFinallyVisitor.getTryBlockData(
                     * MarkFinallyVisitor.java:204)
                     * at jadx.core.dex.visitors.finaly.MarkFinallyVisitor.visit(MarkFinallyVisitor.
                     * java:119)
                     */
                    @Override // me.hd.wauxv.obf.bgj
                    public final Object g(Object obj, Object obj2) {
                        Object objX;
                        Object objX2;
                        Throwable thB;
                        ArrayList arrayList;
                        ArrayList arrayList2;
                        ArrayList arrayList3;
                        ArrayList arrayList4;
                        String str2 = this.b;
                        String str3 = (String) obj;
                        Intent intent = (Intent) obj2;
                        boolean z = exf.a;
                        chm chmVar2 = this.a;
                        boolean zF = nullSafeIsEqual(str3, z ? exf.j((String) chmVar2.d) : exf.k((Context) chmVar2.c));
                        KotlinUnit kotlinUnitVar = KotlinUnit.INSTANCE;
                        if (zF) {
                            try {
                                Bundle extras = intent.getExtras();
                                Object serializable = extras != null ? extras.getSerializable(str2 + chmVar2.ag())
                                        : null;
                                objX = serializable instanceof tx ? (tx) serializable : null;
                            } catch (Throwable th) {
                                objX = FastKV.x(th);
                            }
                            if (objX instanceof dcx) {
                                objX = null;
                            }
                            tx txVar = (tx) objX;
                            ConcurrentHashMap concurrentHashMap = (ConcurrentHashMap) chmVar2.e;
                            if (cnb.k && txVar != null) {
                                tw twVar = txVar.e;
                                String str4 = twVar.a;
                                Object obj3 = twVar.b;
                                int i = txVar.c;
                                String str5 = txVar.a;
                                int i2 = txVar.d;
                                boolean z2 = txVar.b;
                                IInvokable bgfVar2 = this.c;
                                if (z2) {
                                    try {
                                        exe exeVar = (exe) concurrentHashMap.get(str5);
                                        if (exeVar == null) {
                                            ArrayList arrayList5 = new ArrayList();
                                            ArrayList arrayList6 = new ArrayList();
                                            ArrayList arrayList7 = new ArrayList();
                                            ArrayList arrayList8 = new ArrayList();
                                            exeVar = new exe();
                                            exeVar.a = arrayList5;
                                            exeVar.b = arrayList6;
                                            exeVar.c = arrayList7;
                                            exeVar.d = arrayList8;
                                            concurrentHashMap.put(str5, exeVar);
                                        }
                                        arrayList = exeVar.d;
                                        arrayList2 = exeVar.c;
                                        arrayList3 = exeVar.b;
                                        arrayList4 = exeVar.a;
                                    } catch (Throwable th2) {
                                        objX2 = FastKV.x(th2);
                                    }
                                    if (obj3 instanceof List) {
                                        objX2 = (List) obj3;
                                        if (!arrayList4.isEmpty() || i2 <= 0) {
                                            arrayList4.add(i2, objX2);
                                            if (arrayList4.size() == i) {
                                                ArrayList arrayList9 = new ArrayList();
                                                Iterator it = arrayList4.iterator();
                                                while (it.hasNext()) {
                                                    arrayList9.addAll((List) it.next());
                                                }
                                                bgfVar2.invoke(arrayList9);
                                                arrayList4.clear();
                                                concurrentHashMap.remove(str5);
                                            }
                                            thB = dcy.b(objX2);
                                            if (thB != null) {
                                                ArrayList arrayList10 = ewq.a;
                                                ewq.g(4, "YukiHookDataChannel cannot merge this segments data key of \""
                                                        + str4 + "\"", thB);
                                            }
                                        }
                                    } else if (obj3 instanceof Map) {
                                        objX2 = (Map) obj3;
                                        if (!arrayList3.isEmpty() || i2 <= 0) {
                                            arrayList3.add(i2, objX2);
                                            if (arrayList3.size() == i) {
                                                LinkedHashMap linkedHashMap = new LinkedHashMap();
                                                Iterator it2 = arrayList3.iterator();
                                                while (it2.hasNext()) {
                                                    for (Map.Entry entry : ((Map) it2.next()).entrySet()) {
                                                        linkedHashMap.put(entry.getKey(), entry.getValue());
                                                    }
                                                }
                                                bgfVar2.invoke(linkedHashMap);
                                                arrayList3.clear();
                                                concurrentHashMap.remove(str5);
                                            }
                                            thB = dcy.b(objX2);
                                            if (thB != null) {
                                                ArrayList arrayList102 = ewq.a;
                                                ewq.g(4, "YukiHookDataChannel cannot merge this segments data key of \""
                                                        + str4 + "\"", thB);
                                            }
                                        }
                                    } else if (obj3 instanceof Set) {
                                        objX2 = (Set) obj3;
                                        if (!arrayList2.isEmpty() || i2 <= 0) {
                                            arrayList2.add(i2, objX2);
                                            if (arrayList2.size() == i) {
                                                LinkedHashSet linkedHashSet = new LinkedHashSet();
                                                Iterator it3 = arrayList2.iterator();
                                                while (it3.hasNext()) {
                                                    linkedHashSet.addAll((Set) it3.next());
                                                }
                                                bgfVar2.invoke(linkedHashSet);
                                                arrayList2.clear();
                                                concurrentHashMap.remove(str5);
                                            }
                                            thB = dcy.b(objX2);
                                            if (thB != null) {
                                                ArrayList arrayList1022 = ewq.a;
                                                ewq.g(4, "YukiHookDataChannel cannot merge this segments data key of \""
                                                        + str4 + "\"", thB);
                                            }
                                        }
                                    } else {
                                        if (obj3 instanceof String) {
                                            objX2 = (String) obj3;
                                            if (!arrayList.isEmpty() || i2 <= 0) {
                                                arrayList.add(i2, objX2);
                                                if (arrayList.size() == i) {
                                                    StringBuilder sb = new StringBuilder();
                                                    Iterator it4 = arrayList.iterator();
                                                    while (it4.hasNext()) {
                                                        sb.append((String) it4.next());
                                                    }
                                                    bgfVar2.invoke(sb.toString());
                                                    arrayList.clear();
                                                    concurrentHashMap.remove(str5);
                                                }
                                            }
                                        } else {
                                            ArrayList arrayList11 = ewq.a;
                                            ewq.g(6, "Unsupported segments data key of \"" + str4 + "\"'s type", null);
                                            objX2 = kotlinUnitVar;
                                        }
                                        thB = dcy.b(objX2);
                                        if (thB != null) {
                                            ArrayList arrayList10222 = ewq.a;
                                            ewq.g(4, "YukiHookDataChannel cannot merge this segments data key of \""
                                                    + str4 + "\"", thB);
                                        }
                                    }
                                } else if (obj3 != null) {
                                    bgfVar2.invoke(obj3);
                                }
                            }
                        }
                        return kotlinUnitVar;
                    }
                }));
    }

    public SomeFragmentManager aa(String str) {
        for (FragmentManager fragmentManagerVar : ((HashMap) this.d).values()) {
            if (fragmentManagerVar != null) {
                SomeFragmentManager someFragmentManagerVarAa = fragmentManagerVar.c;
                if (!str.equals(someFragmentManagerVarAa.aw)) {
                    someFragmentManagerVarAa = someFragmentManagerVarAa.bo.c.aa(str);
                }
                if (someFragmentManagerVarAa != null) {
                    return someFragmentManagerVarAa;
                }
            }
        }
        return null;
    }

    public doc ab(da daVar) {
        ArrayList arrayList = (ArrayList) this.c;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            doc docVar = (doc) arrayList.get(i);
            if (docVar != null && docVar.b == daVar) {
                return docVar;
            }
        }
        doc docVar2 = new doc((Context) this.e, daVar);
        arrayList.add(docVar2);
        return docVar2;
    }

    public ArrayList ac() {
        ArrayList arrayList = new ArrayList();
        for (FragmentManager fragmentManagerVar : ((HashMap) this.d).values()) {
            if (fragmentManagerVar != null) {
                arrayList.add(fragmentManagerVar);
            }
        }
        return arrayList;
    }

    public ArrayList ad() {
        ArrayList arrayList = new ArrayList();
        for (FragmentManager fragmentManagerVar : ((HashMap) this.d).values()) {
            if (fragmentManagerVar != null) {
                arrayList.add(fragmentManagerVar.c);
            } else {
                arrayList.add(null);
            }
        }
        return arrayList;
    }

    public synchronized ArrayList ae(Class cls) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        for (chl chlVar : (ArrayList) this.c) {
            if (!arrayList.contains(chlVar.b) && chlVar.a.isAssignableFrom(cls)) {
                arrayList.add(chlVar.b);
            }
        }
        return arrayList;
    }

    public List af() {
        ArrayList arrayList;
        if (((ArrayList) this.c).isEmpty()) {
            return Collections.EMPTY_LIST;
        }
        synchronized (((ArrayList) this.c)) {
            arrayList = new ArrayList((ArrayList) this.c);
        }
        return arrayList;
    }

    public String ag() {
        return concatVar2Var1(((String) this.d).hashCode(), JavaConstant.Dynamic.DEFAULT_NAME);
    }

    /*
     * JADX WARN: Undo finally extract visitor
     * java.lang.NullPointerException: Cannot invoke
     * "jadx.core.dex.nodes.BlockNode.getInstructions()" because
     * "finallyBlockTerminus" is null
     * at
     * jadx.core.dex.visitors.finaly.traverser.state.TraverserActivePathState.<init>
     * (TraverserActivePathState.java:253)
     * at jadx.core.dex.visitors.finaly.MarkFinallyVisitor.findCommonInsns(
     * MarkFinallyVisitor.java:422)
     * at jadx.core.dex.visitors.finaly.MarkFinallyVisitor.extractFinally(
     * MarkFinallyVisitor.java:302)
     * at jadx.core.dex.visitors.finaly.MarkFinallyVisitor.processTryBlock(
     * MarkFinallyVisitor.java:222)
     * at jadx.core.dex.visitors.finaly.MarkFinallyVisitor.visit(MarkFinallyVisitor.
     * java:150)
     */
    public erk ah(String str, zc zcVar) {
        erk erkVar;
        boolean zIsInstance;
        erk erkVarB;
        throwIfVar1IsNull(str, "key");
        synchronized (((dop) this.f)) {
            try {
                erq erqVar = (erq) this.c;
                erqVar.getClass();
                erkVar = (erk) erqVar.a.get(str);
                Class clsBe = zcVar.c;
                throwIfVar1IsNull(clsBe, "jClass");
                Map map = zc.b;
                throwIfVar1IsNull(map,
                        "null cannot be cast to non-null type kotlin.collections.Map<K of kotlin.collections.MapsKt__MapsKt.get, V of kotlin.collections.MapsKt__MapsKt.get>");
                Integer num = (Integer) map.get(clsBe);
                if (num != null) {
                    zIsInstance = emc.as(num.intValue(), erkVar);
                } else {
                    if (clsBe.isPrimitive()) {
                        clsBe = HugeSyntheticPileOfHelpers.be(dal.b(clsBe));
                    }
                    zIsInstance = clsBe.isInstance(erkVar);
                }
                if (zIsInstance) {
                    ero eroVar = (ero) this.d;
                    if (eroVar instanceof deq) {
                        deq deqVar = (deq) eroVar;
                        throwIfVar1IsNull(erkVar);
                        deqVar.getClass();
                        bur burVar = deqVar.f;
                        if (burVar != null) {
                            but butVar = deqVar.g;
                            throwIfVar1IsNull(butVar);
                            aye.m(erkVar, butVar, burVar);
                        }
                    }
                    throwIfVar1IsNull(erkVar,
                            "null cannot be cast to non-null type T of androidx.lifecycle.viewmodel.ViewModelProviderImpl.getViewModel");
                } else {
                    chq chqVar = new chq((ahx) this.e);
                    chqVar.c.put(erp.s, str);
                    ero eroVar2 = (ero) this.d;
                    throwIfVar1IsNull(eroVar2, "factory");
                    try {
                        try {
                            erkVarB = eroVar2._bh(zcVar, chqVar);
                        } catch (AbstractMethodError unused) {
                            erkVarB = eroVar2.b(HugeSyntheticPileOfHelpers.getJavaClass(zcVar));
                        }
                    } catch (AbstractMethodError unused2) {
                        erkVarB = eroVar2.l(HugeSyntheticPileOfHelpers.getJavaClass(zcVar), chqVar);
                    }
                    erkVar = erkVarB;
                    erq erqVar2 = (erq) this.c;
                    erqVar2.getClass();
                    throwIfVar1IsNull(erkVar, "viewModel");
                    erk erkVar2 = (erk) erqVar2.a.put(str, erkVar);
                    if (erkVar2 != null) {
                        erkVar2.n();
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return erkVar;
    }

    public int ai() {
        return ((dll) this.e).a.length();
    }

    public void aj(FragmentManager fragmentManagerVar) {
        SomeFragmentManager someFragmentManagerVar = fragmentManagerVar.c;
        String str = someFragmentManagerVar.aw;
        HashMap map = (HashMap) this.d;
        if (map.get(str) != null) {
            return;
        }
        map.put(someFragmentManagerVar.aw, fragmentManagerVar);
        if (beg.ar(2)) {
            Log.v("FragmentManager", "Added fragment to active set " + someFragmentManagerVar);
        }
    }

    public void ak(FragmentManager fragmentManagerVar) {
        HashMap map = (HashMap) this.d;
        SomeFragmentManager someFragmentManagerVar = fragmentManagerVar.c;
        if (someFragmentManagerVar.bv) {
            ((bej) this.f).l(someFragmentManagerVar);
        }
        if (map.get(someFragmentManagerVar.aw) == fragmentManagerVar && ((FragmentManager) map.put(someFragmentManagerVar.aw, null)) != null && beg.ar(2)) {
            Log.v("FragmentManager", "Removed fragment from active set " + someFragmentManagerVar);
        }
    }

    public void al() {
        if (((ekj) ((adh) this.f).d) == ekj.EOF) {
            return;
        }
        this.f = ((aap) this.e).f();
    }

    public boolean am(da daVar, MenuItem menuItem) {
        return ((ActionMode.Callback) this.d).onActionItemClicked(ab(daVar), new ccd((Context) this.e, (dog) menuItem));
    }

    public boolean an(da daVar, Menu menu) {
        ActionMode.Callback callback = (ActionMode.Callback) this.d;
        doc docVarAb = ab(daVar);
        dhq dhqVar = (dhq) this.f;
        Menu ccpVar = (Menu) dhqVar.get(menu);
        if (ccpVar == null) {
            ccpVar = new ccp((Context) this.e, (cbw) menu);
            dhqVar.put(menu, ccpVar);
        }
        return callback.onCreateActionMode(docVarAb, ccpVar);
    }

    public void ao(tx txVar) {
        if (cnb.k) {
            String strS = arj.s();
            tw twVar = txVar.e;
            String str = twVar.a;
            int iH = h(twVar);
            if (iH < 0) {
                ArrayList arrayList = ewq.a;
                ewq.g(6, "YukiHookDataChannel cannot calculate the byte size of the data key of \"" + str
                        + "\" to be sent, so this data cannot be sent\nIf you want to lift this restriction, use the allowSendTooLargeData function when calling, but this may cause the app crash",
                        null);
                return;
            }
            if (txVar.b) {
                ar(txVar);
                return;
            }
            int i = exf.d;
            if (iH < i) {
                ar(txVar);
                return;
            }
            Object obj = twVar.b;
            int i2 = 0;
            if (obj instanceof List) {
                ArrayList arrayList2 = new ArrayList();
                ArrayList arrayList3 = new ArrayList();
                Iterator it = ((List) obj).iterator();
                while (it.hasNext()) {
                    arrayList3.add(it.next());
                    if (h(arrayList3) >= exf.d / exf.e) {
                        arrayList2.add(arrayList3);
                        arrayList3 = new ArrayList();
                    }
                }
                if (!arrayList3.isEmpty()) {
                    arrayList2.add(arrayList3);
                }
                arrayList2.size();
                ArrayList arrayList4 = !arrayList2.isEmpty() ? arrayList2 : null;
                if (arrayList4 == null) {
                    k(txVar, iH, "List");
                    return;
                }
                for (Object obj2 : arrayList4) {
                    int i3 = i2 + 1;
                    if (i2 < 0) {
                        OtherStaticHelpers.aj();
                        throw null;
                    }
                    ar(l(new tw(str, (List) obj2), strS, arrayList2.size(), i2));
                    i2 = i3;
                }
                return;
            }
            if (obj instanceof Map) {
                ArrayList arrayList5 = new ArrayList();
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                for (Map.Entry entry : ((Map) obj).entrySet()) {
                    linkedHashMap.put(entry.getKey(), entry.getValue());
                    if (h(linkedHashMap) >= exf.d / exf.e) {
                        arrayList5.add(linkedHashMap);
                        linkedHashMap = new LinkedHashMap();
                    }
                }
                if (!linkedHashMap.isEmpty()) {
                    arrayList5.add(linkedHashMap);
                }
                arrayList5.size();
                ArrayList arrayList6 = !arrayList5.isEmpty() ? arrayList5 : null;
                if (arrayList6 == null) {
                    k(txVar, iH, "Map");
                    return;
                }
                for (Object obj3 : arrayList6) {
                    int i4 = i2 + 1;
                    if (i2 < 0) {
                        OtherStaticHelpers.aj();
                        throw null;
                    }
                    ar(l(new tw(str, (Map) obj3), strS, arrayList5.size(), i2));
                    i2 = i4;
                }
                return;
            }
            if (obj instanceof Set) {
                ArrayList arrayList7 = new ArrayList();
                LinkedHashSet linkedHashSet = new LinkedHashSet();
                Iterator it2 = ((Set) obj).iterator();
                while (it2.hasNext()) {
                    linkedHashSet.add(it2.next());
                    if (h(linkedHashSet) >= exf.d / exf.e) {
                        arrayList7.add(linkedHashSet);
                        linkedHashSet = new LinkedHashSet();
                    }
                }
                if (!linkedHashSet.isEmpty()) {
                    arrayList7.add(linkedHashSet);
                }
                arrayList7.size();
                ArrayList arrayList8 = !arrayList7.isEmpty() ? arrayList7 : null;
                if (arrayList8 == null) {
                    k(txVar, iH, "Set");
                    return;
                }
                for (Object obj4 : arrayList8) {
                    int i5 = i2 + 1;
                    if (i2 < 0) {
                        OtherStaticHelpers.aj();
                        throw null;
                    }
                    ar(l(new tw(str, (Set) obj4), strS, arrayList7.size(), i2));
                    i2 = i5;
                }
                return;
            }
            if (!(obj instanceof String)) {
                if ((obj instanceof byte[]) || (obj instanceof char[]) || (obj instanceof short[])
                        || (obj instanceof int[]) || (obj instanceof long[]) || (obj instanceof float[])
                        || (obj instanceof double[]) || (obj instanceof boolean[]) || (obj instanceof Object[])) {
                    j(txVar, iH,
                            "Primitive Array type like String[], int[] ... cannot be segmented, the suggestion is send those data using List type");
                    return;
                } else {
                    j(txVar, iH, "");
                    return;
                }
            }
            String str2 = (String) obj;
            int i6 = i / 2;
            ArrayList arrayList9 = new ArrayList();
            int length = str2.length();
            if (i6 <= 0) {
                throw new IllegalArgumentException(yg.f(i6, "Step must be positive, was: ", "."));
            }
            int iAv = KotlinHelpers2.getProgressionLastElement(0, length, i6);
            if (iAv >= 0) {
                int i7 = 0;
                while (true) {
                    int i8 = i7 + i6;
                    if (i8 <= str2.length()) {
                        String strSubstring = str2.substring(i7, i8);
                        throwIfVar1IsNull(strSubstring, "substring(...)");
                        arrayList9.add(strSubstring);
                    } else {
                        String strSubstring2 = str2.substring(i7, str2.length());
                        throwIfVar1IsNull(strSubstring2, "substring(...)");
                        arrayList9.add(strSubstring2);
                    }
                    if (i7 == iAv) {
                        break;
                    } else {
                        i7 = i8;
                    }
                }
            }
            if (arrayList9.size() == 1) {
                ar(txVar);
                return;
            }
            arrayList9.size();
            ArrayList arrayList10 = !arrayList9.isEmpty() ? arrayList9 : null;
            if (arrayList10 == null) {
                k(txVar, iH, "String");
                return;
            }
            for (Object obj5 : arrayList10) {
                int i9 = i2 + 1;
                if (i2 < 0) {
                    OtherStaticHelpers.aj();
                    throw null;
                }
                ar(l(new tw(str, (String) obj5), strS, arrayList9.size(), i2));
                i2 = i9;
            }
        }
    }

    public boolean ap(ConnectivityMonitor connectivityMonitorVar) {
        adh adhVar = (adh) this.f;
        StringBuilder sb = new StringBuilder();
        while (true) {
            ekj ekjVar = ekj.Forwardslash;
            boolean zR = r(ekjVar);
            ekj ekjVar2 = ekj.Backslash;
            ekj ekjVar3 = ekj.EOF;
            if (!zR) {
                if (!r(ekjVar2)) {
                    if (((ekj) ((adh) this.f).d) == ekjVar3) {
                        break;
                    }
                    sb.append(p(new ekj[0]));
                } else if (r(ekjVar)) {
                    sb.append('/');
                } else {
                    sb.append('\\');
                }
            } else {
                ArrayList arrayList = new ArrayList();
                while (true) {
                    boolean zR2 = r(ekjVar);
                    ekj ekjVar4 = ekj.CurlyClose;
                    if (zR2) {
                        StringBuilder sb2 = new StringBuilder();
                        while (!r(ekjVar4)) {
                            if (((ekj) ((adh) this.f).d) == ekjVar3) {
                                break;
                            }
                            sb2.append(p(new ekj[0]));
                        }
                        try {
                            int i = sb2.indexOf(com.umeng.analytics.pro.bt.aA) != -1 ? 2 : 0;
                            if (sb2.indexOf("m") != -1) {
                                i |= 8;
                            }
                            connectivityMonitorVar.c = sb2.indexOf("g") != -1;
                            connectivityMonitorVar.d = Pattern.compile(sb.toString(), i);
                            connectivityMonitorVar.e = arrayList;
                            return true;
                        } catch (PatternSyntaxException unused) {
                            t(adhVar);
                            return false;
                        }
                    }
                    boolean zR3 = r(ekjVar2);
                    ekj ekjVar5 = ekj.VariableName;
                    if (zR3) {
                        String strP = p(ekjVar2, ekjVar);
                        if (strP != null) {
                            arrayList.add(new cof(strP));
                        } else {
                            String strO = o(ekjVar5);
                            if (strO == null) {
                                arrayList.add(new cof("\\"));
                            } else if (com.umeng.analytics.pro.bt.aF.equals(strO)) {
                                arrayList.add(new coc());
                            } else {
                                arrayList.add(new cof("\\".concat(strO)));
                            }
                        }
                    } else {
                        adh adhVar2 = (adh) this.f;
                        if (r(ekj.Dollar)) {
                            boolean zR4 = r(ekj.CurlyOpen);
                            String strO2 = o(ekj.Int);
                            if (strO2 == null) {
                                t(adhVar2);
                            } else {
                                int i2 = Integer.parseInt(strO2);
                                acs acsVar = new acs();
                                acsVar.a = i2;
                                if (zR4) {
                                    ekj ekjVar6 = ekj.Colon;
                                    if (r(ekjVar6)) {
                                        if (r(ekjVar)) {
                                            String strO3 = o(ekjVar5);
                                            if (strO3 != null && r(ekjVar4)) {
                                                acsVar.d = strO3;
                                                arrayList.add(acsVar);
                                            }
                                        } else if (r(ekj.Plus)) {
                                            String strAu = au(ekjVar4);
                                            if (strAu != null) {
                                                r(ekjVar4);
                                                acsVar.b = strAu;
                                                arrayList.add(acsVar);
                                            }
                                        } else if (r(ekj.Dash)) {
                                            String strAu2 = au(ekjVar4);
                                            if (strAu2 != null) {
                                                r(ekjVar4);
                                                acsVar.c = strAu2;
                                                arrayList.add(acsVar);
                                            }
                                        } else if (r(ekj.QuestionMark)) {
                                            String strAu3 = au(ekjVar6);
                                            r(ekjVar6);
                                            String strAu4 = au(ekjVar4);
                                            if (strAu3 != null && strAu4 != null) {
                                                r(ekjVar4);
                                                acsVar.b = strAu3;
                                                acsVar.c = strAu4;
                                                arrayList.add(acsVar);
                                            }
                                        } else {
                                            String strAu5 = au(ekjVar4);
                                            if (strAu5 != null) {
                                                r(ekjVar4);
                                                acsVar.c = strAu5;
                                                arrayList.add(acsVar);
                                            }
                                        }
                                    }
                                    t(adhVar2);
                                } else {
                                    arrayList.add(acsVar);
                                }
                            }
                        }
                        if (((ekj) ((adh) this.f).d) == ekjVar3) {
                            break;
                        }
                        arrayList.add(new cof(p(new ekj[0])));
                    }
                }
            }
        }
        return false;
    }

    public void aq(int i) {
        ListView listView = (ListView) this.c;
        long jUptimeMillis = SystemClock.uptimeMillis();
        MotionEvent motionEventObtain = MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 0, 0.0f, 0.0f, 0);
        listView.onTouchEvent(motionEventObtain);
        motionEventObtain.recycle();
        float f = i;
        MotionEvent motionEventObtain2 = MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 2, 0.0f, f, 0);
        listView.onTouchEvent(motionEventObtain2);
        motionEventObtain2.recycle();
        MotionEvent motionEventObtain3 = MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 3, 0.0f, f, 0);
        listView.onTouchEvent(motionEventObtain3);
        motionEventObtain3.recycle();
    }

    public void ar(tx txVar) {
        String str = (String) this.d;
        tw twVar = txVar.e;
        Context contextH = (Context) this.c;
        if (contextH == null) {
            ki.a.getClass();
            contextH = ki.h();
        }
        if (contextH == null) {
            ArrayList arrayList = ewq.a;
            ewq.g(6, "Failed to sendBroadcast like \"" + twVar.a + "\", because got null context in \"" + str + "\"",
                    null);
            return;
        }
        Intent intent = new Intent();
        if (!dnj.ak("")) {
            intent.setPackage("");
        }
        boolean z = exf.a;
        intent.setAction(z ? exf.k(null) : exf.j(str));
        if (!nullSafeIsEqual(str, "android")) {
            if (z) {
                str = exm.h;
            }
            intent.setPackage(str);
        }
        intent.putExtra(twVar.a + ag(), txVar);
        contextH.sendBroadcast(intent, null, null);
    }

    public Bundle as(String str, Bundle bundle) {
        HashMap map = (HashMap) this.e;
        return bundle != null ? (Bundle) map.put(str, bundle) : (Bundle) map.remove(str);
    }

    public void at(coi coiVar, int i) {
        Class<?> cls = coiVar.getClass();
        blq blqVar = (blq) this.c;
        pn pnVar = (pn) ((bib) blqVar.e).a.get(cls);
        if (pnVar != null) {
            Object objB = pnVar.b(blqVar, (aji) this.d);
            dll dllVar = (dll) this.e;
            StringBuilder sb = dllVar.a;
            int length = sb.length();
            int length2 = sb.length();
            if (length <= i || i < 0 || length > length2) {
                return;
            }
            dll.c(dllVar, objB, i, length);
        }
    }

    public String au(ekj ekjVar) {
        adh adhVar = (adh) this.f;
        StringBuilder sb = new StringBuilder();
        while (true) {
            ekj ekjVar2 = (ekj) ((adh) this.f).d;
            if (ekjVar2 == ekjVar) {
                return sb.toString();
            }
            if (ekjVar2 == ekj.EOF) {
                t(adhVar);
                return null;
            }
            ekj ekjVar3 = ekj.Backslash;
            if (r(ekjVar3)) {
                String strP = p(ekjVar3, ekj.Dollar, ekj.CurlyClose);
                if (strP == null) {
                    t(adhVar);
                    return null;
                }
                sb.append(strP);
            } else {
                sb.append(p(new ekj[0]));
            }
        }
    }

    public void av() {
        int iD;
        esa esaVar = (esa) this.d;
        esa esaVar2 = (esa) this.c;
        ViewPager2 viewPager2 = (ViewPager2) this.f;
        int i = R.id.accessibilityActionPageLeft;
        ViewCompat.p(viewPager2, R.id.accessibilityActionPageLeft);
        ViewCompat.notifyAccessibilityChange(viewPager2, 0);
        ViewCompat.p(viewPager2, R.id.accessibilityActionPageRight);
        ViewCompat.notifyAccessibilityChange(viewPager2, 0);
        ViewCompat.p(viewPager2, R.id.accessibilityActionPageUp);
        ViewCompat.notifyAccessibilityChange(viewPager2, 0);
        ViewCompat.p(viewPager2, R.id.accessibilityActionPageDown);
        ViewCompat.notifyAccessibilityChange(viewPager2, 0);
        if (viewPager2.getAdapter() == null || (iD = viewPager2.getAdapter().d()) == 0 || !viewPager2.r) {
            return;
        }
        if (viewPager2.getOrientation() != 0) {
            if (viewPager2.d < iD - 1) {
                ViewCompat.q(viewPager2, new ax(R.id.accessibilityActionPageDown), esaVar2);
            }
            if (viewPager2.d > 0) {
                ViewCompat.q(viewPager2, new ax(R.id.accessibilityActionPageUp), esaVar);
                return;
            }
            return;
        }
        boolean z = viewPager2.g.dp.getLayoutDirection() == 1;
        int i2 = z ? 16908360 : 16908361;
        if (z) {
            i = 16908361;
        }
        if (viewPager2.d < iD - 1) {
            ViewCompat.q(viewPager2, new ax(i2), esaVar2);
        }
        if (viewPager2.d > 0) {
            ViewCompat.q(viewPager2, new ax(i), esaVar);
        }
    }

    public void aw(coi coiVar) {
        bzs bzsVar = (bzs) ((Map) this.f).get(coiVar.getClass());
        if (bzsVar != null) {
            bzsVar.b(this, coiVar);
        } else {
            ax(coiVar);
        }
    }

    public void ax(coi coiVar) {
        coi coiVar2 = coiVar.j;
        while (coiVar2 != null) {
            coi coiVar3 = coiVar2.m;
            coiVar2.c(this);
            coiVar2 = coiVar3;
        }
    }

    public String o(ekj ekjVar) {
        adh adhVar = (adh) this.f;
        if (((ekj) adhVar.d) != ekjVar) {
            return null;
        }
        String str = (String) this.c;
        int i = adhVar.b;
        String strSubstring = str.substring(i, adhVar.c + i);
        al();
        return strSubstring;
    }

    public String p(ekj... ekjVarArr) {
        String str = (String) this.c;
        if (ekjVarArr.length == 0) {
            adh adhVar = (adh) this.f;
            int i = adhVar.b;
            String strSubstring = str.substring(i, adhVar.c + i);
            al();
            return strSubstring;
        }
        for (ekj ekjVar : ekjVarArr) {
            adh adhVar2 = (adh) this.f;
            if (((ekj) adhVar2.d) == ekjVar) {
                int i2 = adhVar2.b;
                String strSubstring2 = str.substring(i2, adhVar2.c + i2);
                al();
                return strSubstring2;
            }
        }
        return null;
    }

    public epb q() {
        String strO;
        adh adhVar = (adh) this.f;
        ekj ekjVar = ekj.Dollar;
        if (!r(ekjVar) || !r(ekj.CurlyOpen) || (strO = o(ekj.VariableName)) == null) {
            t(adhVar);
            return null;
        }
        boolean zR = r(ekj.Colon);
        ekj ekjVar2 = ekj.CurlyClose;
        if (!zR) {
            if (!r(ekj.Forwardslash)) {
                if (r(ekjVar2)) {
                    return new epb(-1, strO, "", null);
                }
                t(adhVar);
                return null;
            }
            ConnectivityMonitor connectivityMonitorVar = new ConnectivityMonitor(3);
            if (ap(connectivityMonitorVar)) {
                return new epb(-1, strO, null, connectivityMonitorVar);
            }
            t(adhVar);
            return null;
        }
        StringBuilder sb = new StringBuilder();
        while (!r(ekjVar2)) {
            ekj ekjVar3 = ekj.Backslash;
            if (r(ekjVar3)) {
                String strP = p(ekjVar3, ekjVar, ekjVar2);
                if (strP != null) {
                    sb.append(strP);
                } else {
                    sb.append('\\');
                }
            } else {
                adh adhVar2 = (adh) this.f;
                if (((ekj) adhVar2.d) == ekj.EOF) {
                    t(adhVar);
                    return null;
                }
                String str = (String) this.c;
                int i = adhVar2.b;
                sb.append((CharSequence) str, i, adhVar2.c + i);
                al();
            }
        }
        return new epb(-1, strO, sb.toString(), null);
    }

    public boolean r(ekj ekjVar) {
        if (((ekj) ((adh) this.f).d) != ekjVar) {
            return false;
        }
        al();
        return true;
    }

    public void s(SomeFragmentManager someFragmentManagerVar) {
        if (((ArrayList) this.c).contains(someFragmentManagerVar)) {
            throw new IllegalStateException("Fragment already added: " + someFragmentManagerVar);
        }
        synchronized (((ArrayList) this.c)) {
            ((ArrayList) this.c).add(someFragmentManagerVar);
        }
        someFragmentManagerVar.bc = true;
    }

    public void t(adh adhVar) {
        aap aapVar = (aap) this.e;
        aapVar.b = adhVar.b + adhVar.c;
        aapVar.c = 0;
        this.f = adhVar;
    }

    public void u(coi coiVar) {
        if (coiVar.m != null) {
            y();
            ((dll) this.e).d('\n');
        }
    }

    public synchronized ArrayList v(Class cls) {
        ArrayList arrayList;
        try {
            arrayList = new ArrayList();
            for (chl chlVar : (ArrayList) this.c) {
                if (!((HashSet) this.e).contains(chlVar) && chlVar.a.isAssignableFrom(cls)) {
                    ((HashSet) this.e).add(chlVar);
                    arrayList.add(chlVar.c.u(this));
                    ((HashSet) this.e).remove(chlVar);
                }
            }
        } catch (Throwable th) {
            ((HashSet) this.e).clear();
            throw th;
        }
        return arrayList;
    }

    public synchronized cdv w(Class cls, Class cls2) {
        try {
            ArrayList arrayList = new ArrayList();
            boolean z = false;
            for (chl chlVar : (ArrayList) this.c) {
                if (((HashSet) this.e).contains(chlVar)) {
                    z = true;
                } else if (chlVar.a.isAssignableFrom(cls) && chlVar.b.isAssignableFrom(cls2)) {
                    ((HashSet) this.e).add(chlVar);
                    arrayList.add(chlVar.c.u(this));
                    ((HashSet) this.e).remove(chlVar);
                }
            }
            if (arrayList.size() > 1) {
                cbm cbmVar = (cbm) this.d;
                FactoryPools factoryPoolsVar = (FactoryPools) this.f;
                cbmVar.getClass();
                return new le(arrayList, 2, factoryPoolsVar);
            }
            if (arrayList.size() == 1) {
                return (cdv) arrayList.get(0);
            }
            if (z) {
                return b;
            }
            throw new dar("Failed to find any ModelLoaders for model: " + cls + " and data: " + cls2);
        } catch (Throwable th) {
            ((HashSet) this.e).clear();
            throw th;
        }
    }

    public void x(Object obj, ArrayList arrayList, HashSet hashSet) {
        if (arrayList.contains(obj)) {
            return;
        }
        if (hashSet.contains(obj)) {
            throw new RuntimeException("This graph contains cyclic dependencies");
        }
        hashSet.add(obj);
        ArrayList arrayList2 = (ArrayList) ((dhq) this.f).get(obj);
        if (arrayList2 != null) {
            int size = arrayList2.size();
            for (int i = 0; i < size; i++) {
                x(arrayList2.get(i), arrayList, hashSet);
            }
        }
        hashSet.remove(obj);
        arrayList.add(obj);
    }

    public void y() {
        dll dllVar = (dll) this.e;
        StringBuilder sb = dllVar.a;
        if (sb.length() <= 0 || '\n' == sb.charAt(sb.length() - 1)) {
            return;
        }
        dllVar.d('\n');
    }

    public SomeFragmentManager z(String str) {
        FragmentManager fragmentManagerVar = (FragmentManager) ((HashMap) this.d).get(str);
        if (fragmentManagerVar != null) {
            return fragmentManagerVar.c;
        }
        return null;
    }

    public chm(int i) {
        switch (i) {
            case 5:
                this.d = new cuw(10);
                this.f = new dhq(0);
                this.c = new ArrayList();
                this.e = new HashSet();
                break;
            case 6:
                this.c = new ArrayList();
                this.d = new HashMap();
                this.e = new HashMap();
                break;
            case 12:
                this.c = new ku(0);
                this.d = new SparseArray();
                this.e = new byc();
                this.f = new ku(0);
                break;
            default:
                this.c = new ReentrantReadWriteLock();
                this.e = new HashMap();
                break;
        }
    }

    public chm(erq erqVar, ero eroVar, ahx ahxVar) {
        throwIfVar1IsNull(erqVar, "store");
        throwIfVar1IsNull(eroVar, "factory");
        throwIfVar1IsNull(ahxVar, "defaultExtras");
        this.c = erqVar;
        this.d = eroVar;
        this.e = ahxVar;
        this.f = new dop(4);
    }

    public chm(Typeface typeface, GenericMetadataIterator3 cdcVar) {
        int i;
        int i2;
        int i3;
        int i4;
        this.f = typeface;
        this.c = cdcVar;
        this.e = new cdd(1024);
        int iF = cdcVar.getVTableOffset(6);
        if (iF != 0) {
            int i5 = iF + cdcVar.b;
            i = ((ByteBuffer) cdcVar.e).getInt(((ByteBuffer) cdcVar.e).getInt(i5) + i5);
        } else {
            i = 0;
        }
        this.d = new char[i * 2];
        int iF2 = cdcVar.getVTableOffset(6);
        if (iF2 != 0) {
            int i6 = iF2 + cdcVar.b;
            i2 = ((ByteBuffer) cdcVar.e).getInt(((ByteBuffer) cdcVar.e).getInt(i6) + i6);
        } else {
            i2 = 0;
        }
        for (int i7 = 0; i7 < i2; i7++) {
            EmojiMetadata emojiMetadataVar = new EmojiMetadata(this, i7);
            FlatBufferTable cdbVarF = emojiMetadataVar.f();
            int iF3 = cdbVarF.getVTableOffset(4);
            Character.toChars(iF3 != 0 ? ((ByteBuffer) cdbVarF.e).getInt(iF3 + cdbVarF.b) : 0, (char[]) this.d, i7 * 2);
            FlatBufferTable cdbVarF2 = emojiMetadataVar.f();
            int iF4 = cdbVarF2.getVTableOffset(16);
            if (iF4 != 0) {
                int i8 = iF4 + cdbVarF2.b;
                i3 = ((ByteBuffer) cdbVarF2.e).getInt(((ByteBuffer) cdbVarF2.e).getInt(i8) + i8);
            } else {
                i3 = 0;
            }
            cna.g("invalid metadata codepoint length", i3 > 0);
            cdd cddVar = (cdd) this.e;
            FlatBufferTable cdbVarF3 = emojiMetadataVar.f();
            int iF5 = cdbVarF3.getVTableOffset(16);
            if (iF5 != 0) {
                int i9 = iF5 + cdbVarF3.b;
                i4 = ((ByteBuffer) cdbVarF3.e).getInt(((ByteBuffer) cdbVarF3.e).getInt(i9) + i9);
            } else {
                i4 = 0;
            }
            cddVar.c(emojiMetadataVar, 0, i4 - 1);
        }
    }
}

package me.hd.wauxv.obf;

import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Trace;
import java.util.List;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public abstract class bbz {
    public static final byj a = new byj(16);
    public static final ThreadPoolExecutor b;
    public static final Object c;
    public static final dhq d;

    static {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, 1, 10000, TimeUnit.MILLISECONDS,
                new LinkedBlockingDeque(), new dd(2));
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        b = threadPoolExecutor;
        c = new Object();
        d = new dhq(0);
    }

    public static String e(int i, List list) {
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < list.size(); i2++) {
            sb.append(((bbt) list.get(i2)).g);
            sb.append("-");
            sb.append(i);
            if (i2 < list.size() - 1) {
                sb.append(";");
            }
        }
        return sb.toString();
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
    public static bby f(String str, Context context, List list, int i) {
        int i2;
        Typeface typefaceT;
        byj byjVar = a;
        cnf.an("getFontSync");
        try {
            Typeface typeface = (Typeface) byjVar.o(str);
            if (typeface != null) {
                bby bbyVar = new bby(typeface);
                Trace.endSection();
                return bbyVar;
            }
            try {
                ek ekVarC = bbs.createInstanceWithArgs(context, list);
                List list2 = (List) ekVarC.d;
                int i3 = ekVarC.c;
                if (i3 == 0) {
                    bce[] bceVarArr = (bce[]) list2.get(0);
                    if (bceVarArr == null || bceVarArr.length == 0) {
                        i2 = 1;
                    } else {
                        int length = bceVarArr.length;
                        int i4 = 0;
                        while (true) {
                            if (i4 >= length) {
                                i2 = 0;
                                break;
                            }
                            int i5 = bceVarArr[i4].f;
                            if (i5 != 0) {
                                if (i5 >= 0) {
                                    i2 = i5;
                                    break;
                                }
                                i2 = -3;
                                break;
                            }
                            i4++;
                        }
                    }
                } else {
                    if (i3 != 1) {
                        i2 = -3;
                        break;
                    }
                    i2 = -2;
                }
                if (i2 != 0) {
                    bby bbyVar2 = new bby(i2);
                    Trace.endSection();
                    return bbyVar2;
                }
                if (list2.size() <= 1 || Build.VERSION.SDK_INT < 29) {
                    bce[] bceVarArr2 = (bce[]) list2.get(0);
                    emn emnVar = emf.a;
                    cnf.an("TypefaceCompat.createFromFontInfo");
                    try {
                        typefaceT = emf.a.t(context, bceVarArr2, i);
                        Trace.endSection();
                    } catch (Throwable th) {
                        Trace.endSection();
                        throw th;
                    }
                } else {
                    emn emnVar2 = emf.a;
                    cnf.an("TypefaceCompat.createFromFontInfoWithFallback");
                    try {
                        typefaceT = emf.a._ce(context, list2, i);
                        Trace.endSection();
                    } catch (Throwable th2) {
                        Trace.endSection();
                        throw th2;
                    }
                }
                if (typefaceT == null) {
                    bby bbyVar3 = new bby(-3);
                    Trace.endSection();
                    return bbyVar3;
                }
                byjVar.v(str, typefaceT);
                bby bbyVar4 = new bby(typefaceT);
                Trace.endSection();
                return bbyVar4;
            } catch (PackageManager.NameNotFoundException unused) {
                bby bbyVar5 = new bby(-1);
                Trace.endSection();
                return bbyVar5;
            }
        } catch (Throwable th3) {
            Trace.endSection();
            throw th3;
        }
    }
}

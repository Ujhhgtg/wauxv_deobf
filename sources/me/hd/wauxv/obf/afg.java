package me.hd.wauxv.obf;

import android.text.TextUtils;
import java.text.Bidi;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class afg implements afp {
    public final ek[] a = new ek[64];
    public boolean b;

    public afg(aff affVar) {
        affVar.k(this);
    }

    /* JADX WARN: Undo finally extract visitor
    java.lang.NullPointerException: Cannot invoke "jadx.core.dex.nodes.BlockNode.getInstructions()" because "finallyBlockTerminus" is null
    	at jadx.core.dex.visitors.finaly.traverser.state.TraverserActivePathState.<init>(TraverserActivePathState.java:253)
    	at jadx.core.dex.visitors.finaly.MarkFinallyVisitor.findCommonInsns(MarkFinallyVisitor.java:422)
    	at jadx.core.dex.visitors.finaly.MarkFinallyVisitor.extractFinally(MarkFinallyVisitor.java:302)
    	at jadx.core.dex.visitors.finaly.MarkFinallyVisitor.processTryBlock(MarkFinallyVisitor.java:222)
    	at jadx.core.dex.visitors.finaly.MarkFinallyVisitor.visit(MarkFinallyVisitor.java:150)
     */
    public final anu c(int i, afo afoVar) {
        anu anuVar;
        char[] cArr;
        char c = 0;
        long jAl = KotlinHelpers.al(0, 0);
        if (!this.b) {
            return new anu(new long[]{jAl}, afoVar.b);
        }
        synchronized (this) {
            int i2 = 0;
            while (true) {
                try {
                    ek[] ekVarArr = this.a;
                    if (i2 >= ekVarArr.length) {
                        int i3 = afoVar.b;
                        if (afoVar.c > 0) {
                            synchronized (dqc.class) {
                                try {
                                    cArr = dqc.as;
                                    dqc.as = null;
                                } catch (Throwable th) {
                                    throw th;
                                }
                            }
                            if (cArr == null || cArr.length < i3) {
                                cArr = new char[i3];
                            }
                            char[] cArr2 = cArr;
                            TextUtils.getChars(afoVar, 0, i3, cArr2, 0);
                            Bidi bidi = new Bidi(cArr2, 0, null, 0, afoVar.b, -2);
                            int runCount = bidi.getRunCount();
                            long[] jArr = new long[runCount];
                            for (int i4 = 0; i4 < runCount; i4++) {
                                jArr[i4] = KotlinHelpers.al(bidi.getRunStart(i4), bidi.getRunLevel(i4));
                            }
                            if (cArr2.length <= 1000) {
                                synchronized (dqc.class) {
                                    try {
                                        dqc.as = cArr2;
                                    } catch (Throwable th2) {
                                        throw th2;
                                    }
                                }
                            }
                            anuVar = new anu(jArr, i3);
                        } else {
                            anuVar = new anu(new long[]{jAl}, i3);
                        }
                        synchronized (this) {
                            try {
                                ek[] ekVarArr2 = this.a;
                                System.arraycopy(ekVarArr2, 0, ekVarArr2, 1, ekVarArr2.length - 1);
                                ek[] ekVarArr3 = this.a;
                                ek ekVar = new ek(c, 4);
                                ekVar.d = anuVar;
                                ekVar.c = i;
                                ekVarArr3[0] = ekVar;
                            } catch (Throwable th3) {
                                throw th3;
                            }
                        }
                        return anuVar;
                    }
                    ek ekVar2 = ekVarArr[i2];
                    if (ekVar2 != null && ekVar2.c == i) {
                        return (anu) ekVar2.d;
                    }
                    i2++;
                } catch (Throwable th4) {
                    throw th4;
                }
            }
        }
    }

    @Override // me.hd.wauxv.obf.afp
    public final void cy(aff affVar) {
    }

    @Override // me.hd.wauxv.obf.afp
    public final synchronized void cz(aff affVar, int i, int i2, int i3, int i4, CharSequence charSequence) {
        int i5 = i3 - i;
        int i6 = 0;
        while (true) {
            try {
                ek[] ekVarArr = this.a;
                if (i6 < ekVarArr.length) {
                    ek ekVar = ekVarArr[i6];
                    if (ekVar != null) {
                        int i7 = ekVar.c;
                        if (i7 > i) {
                            ekVar.c = i7 + i5;
                        } else if (i7 == i) {
                            ekVarArr[i6] = null;
                        }
                    }
                    i6++;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // me.hd.wauxv.obf.afp
    public final synchronized void db(aff affVar, int i, int i2, int i3, int i4, StringBuilder sb) {
        int i5;
        int i6 = i3 - i;
        int i7 = 0;
        while (true) {
            try {
                ek[] ekVarArr = this.a;
                if (i7 < ekVarArr.length) {
                    ek ekVar = ekVarArr[i7];
                    if (ekVar != null && (i5 = ekVar.c) >= i) {
                        if (i5 > i3) {
                            ekVar.c = i5 - i6;
                        } else {
                            ekVarArr[i7] = null;
                        }
                    }
                    i7++;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}

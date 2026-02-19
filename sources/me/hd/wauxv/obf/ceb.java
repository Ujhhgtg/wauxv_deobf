package me.hd.wauxv.obf;

import android.app.Application;
import java.util.Iterator;
import java.util.LinkedHashSet;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class ceb extends ClassLoader {
    public static ceb a;
    public static final LinkedHashSet b;
    public static final LinkedHashSet c;

    static {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        b = linkedHashSet;
        c = new LinkedHashSet();
        linkedHashSet.add("androidx.lifecycle.ReportFragment");
    }

    /*
     * JADX WARN: 'super' call moved to the top of the method (can break code
     * semantics)
     */
    public ceb() {
        super(ki.getHostClassLoader());
        ki.a.getClass();
    }

    /* JADX WARN: Found duplicated region for block: B:28:0x005e */
    /* JADX WARN: Found duplicated region for block: B:30:0x0061 */
    /* JADX WARN: Found duplicated region for block: B:33:0x006b */
    /*
     * JADX WARN: Found duplicated region for block: B:63:0x008a A[EXC_TOP_SPLITTER,
     * PHI: r0
     * 0x008a: PHI (r0v7 java.lang.ClassLoader) = (r0v6 java.lang.ClassLoader),
     * (r0v12 java.lang.ClassLoader) binds: [B:29:0x005f, B:32:0x0069]
     * A[DONT_GENERATE, DONT_INLINE], SYNTHETIC]
     */
    /* JADX WARN: Found duplicated region for block: B:73:0x0077 A[SYNTHETIC] */
    /* JADX WARN: Found duplicated region for block: B:76:0x0065 A[SYNTHETIC] */
    @Override // java.lang.ClassLoader
    public final Class loadClass(String str, boolean z) {
        ClassLoader classLoader;
        LinkedHashSet linkedHashSet;
        Object objX;
        Class<?> clsLoadClass;
        Iterator it;
        boolean z2 = exm.a;
        if (!exm.l()) {
            ki.a.getClass();
            return ki.getHostClassLoader().loadClass(str);
        }
        ki.a.getClass();
        Application applicationH = ki.tryGetApplication();
        if (applicationH != null && (classLoader = applicationH.getClassLoader()) != null) {
            LinkedHashSet linkedHashSet2 = b;
            if (linkedHashSet2.isEmpty()) {
                linkedHashSet2 = null;
            }
            if (linkedHashSet2 != null) {
                Iterator it2 = linkedHashSet2.iterator();
                while (true) {
                    if (it2.hasNext()) {
                        try {
                            if (nullSafeIsEqual(str, (String) it2.next())) {
                                clsLoadClass = classLoader.loadClass(str);
                            } else {
                                continue;
                            }
                        } catch (Throwable th) {
                            FastKV.getFailureFromException(th);
                        }
                    } else {
                        linkedHashSet = c;
                        if (linkedHashSet.isEmpty()) {
                            linkedHashSet = null;
                        }
                        if (linkedHashSet != null) {
                            it = linkedHashSet.iterator();
                            while (true) {
                                if (!it.hasNext()) {
                                    try {
                                        if (nullSafeIsEqual(str, (String) it.next())) {
                                            ki.a.getClass();
                                            clsLoadClass = ki.getHostClassLoader().loadClass(str);
                                        } else {
                                            continue;
                                        }
                                    } catch (Throwable th2) {
                                        FastKV.getFailureFromException(th2);
                                    }
                                } else {
                                    try {
                                        ki.a.getClass();
                                        clsLoadClass = ki.getHostClassLoader().loadClass(str);
                                    } catch (Throwable th3) {
                                        FastKV.getFailureFromException(th3);
                                        try {
                                            ki.a.getClass();
                                            objX = ki.getHostClassLoader().loadClass(str);
                                        } catch (Throwable th4) {
                                            objX = FastKV.getFailureFromException(th4);
                                        }
                                        Class<?> cls = (Class) (objX instanceof Failure ? null : objX);
                                        clsLoadClass = cls == null ? classLoader.loadClass(str) : cls;
                                    }
                                }
                            }
                        } else {
                            ki.a.getClass();
                            clsLoadClass = ki.getHostClassLoader().loadClass(str);
                        }
                    }
                }
            } else {
                linkedHashSet = c;
                if (linkedHashSet.isEmpty()) {
                    linkedHashSet = null;
                }
                if (linkedHashSet != null) {
                    it = linkedHashSet.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            ki.a.getClass();
                            clsLoadClass = ki.getHostClassLoader().loadClass(str);
                        } else if (nullSafeIsEqual(str, (String) it.next())) {
                            ki.a.getClass();
                            clsLoadClass = ki.getHostClassLoader().loadClass(str);
                        } else {
                            continue;
                        }
                    }
                } else {
                    ki.a.getClass();
                    clsLoadClass = ki.getHostClassLoader().loadClass(str);
                }
            }
            if (clsLoadClass != null) {
                return clsLoadClass;
            }
        }
        return super.loadClass(str, z);
    }
}

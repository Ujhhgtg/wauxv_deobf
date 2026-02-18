package me.hd.wauxv.obf;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Vector;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class awy {
    public final awy c;
    public final awz[][] e = new awz[5][];
    public boolean f = true;
    public final HashMap a = new HashMap();
    public final ReentrantReadWriteLock b = new ReentrantReadWriteLock();
    public final Vector d = new Vector();

    public awy(awy awyVar) {
        this.c = awyVar;
        if (awyVar != null) {
            awyVar.d.add(this);
        }
    }

    /* JADX WARN: Undo finally extract visitor
    java.lang.NullPointerException: Cannot invoke "jadx.core.dex.nodes.BlockNode.getInstructions()" because "finallyBlockTerminus" is null
    	at jadx.core.dex.visitors.finaly.traverser.state.TraverserActivePathState.<init>(TraverserActivePathState.java:253)
    	at jadx.core.dex.visitors.finaly.MarkFinallyVisitor.findCommonInsns(MarkFinallyVisitor.java:422)
    	at jadx.core.dex.visitors.finaly.MarkFinallyVisitor.extractFinally(MarkFinallyVisitor.java:302)
    	at jadx.core.dex.visitors.finaly.MarkFinallyVisitor.processTryBlock(MarkFinallyVisitor.java:222)
    	at jadx.core.dex.visitors.finaly.MarkFinallyVisitor.visit(MarkFinallyVisitor.java:150)
     */
    public final int g(ua uaVar) {
        int i;
        LinkedList linkedList;
        awz[] awzVarArr;
        awy awyVar;
        if (!this.f) {
            return uaVar.b;
        }
        awx awxVarH = h(uaVar.getClass());
        awxVarH.a.readLock().lock();
        try {
            int size = awxVarH.b.size();
            synchronized (this) {
                int i2 = 0;
                while (true) {
                    try {
                        awz[][] awzVarArr2 = this.e;
                        linkedList = null;
                        if (i2 >= awzVarArr2.length) {
                            awzVarArr = null;
                            break;
                        }
                        awzVarArr = awzVarArr2[i2];
                        if (awzVarArr != null && awzVarArr.length >= size) {
                            awzVarArr2[i2] = null;
                            break;
                        }
                        i2++;
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
            if (awzVarArr == null) {
                awzVarArr = new awz[size];
            }
            awxVarH.b.toArray(awzVarArr);
            awxVarH.a.readLock().unlock();
            try {
                afc afcVar = new afc(2);
                afcVar.b = false;
                LinkedList linkedList2 = null;
                for (int i3 = 0; i3 < size; i3++) {
                    try {
                        if ((uaVar.b & 1) != 0) {
                            break;
                        }
                        awz awzVar = awzVarArr[i3];
                        awzVar.g(uaVar, afcVar);
                        if (afcVar.b) {
                            if (linkedList2 == null) {
                                linkedList2 = new LinkedList();
                            }
                            linkedList2.add(awzVar);
                        }
                        afcVar.b = false;
                    } catch (Throwable th2) {
                        th = th2;
                        linkedList = linkedList2;
                        if (linkedList != null) {
                            awxVarH.a.writeLock().lock();
                            try {
                                awxVarH.b.removeAll(linkedList);
                                awxVarH.a.writeLock().unlock();
                            } catch (Throwable th3) {
                                awxVarH.a.writeLock().unlock();
                                throw th3;
                            }
                        }
                        i(awzVarArr);
                        throw th;
                    }
                }
                if (linkedList2 != null) {
                    awxVarH.a.writeLock().lock();
                    try {
                        awxVarH.b.removeAll(linkedList2);
                        awxVarH.a.writeLock().unlock();
                    } catch (Throwable th4) {
                        awxVarH.a.writeLock().unlock();
                        throw th4;
                    }
                }
                i(awzVarArr);
                for (i = 0; i < this.d.size() && (uaVar.b & 1) == 0; i++) {
                    try {
                        awyVar = (awy) this.d.get(i);
                    } catch (IndexOutOfBoundsException unused) {
                        awyVar = null;
                    }
                    if (awyVar != null) {
                        awyVar.g(uaVar);
                    }
                }
                return uaVar.b;
            } catch (Throwable th5) {
                th = th5;
            }
        } catch (Throwable th6) {
            awxVarH.a.readLock().unlock();
            throw th6;
        }
    }

    public final awx h(Class cls) {
        HashMap map = this.a;
        ReentrantReadWriteLock reentrantReadWriteLock = this.b;
        reentrantReadWriteLock.readLock().lock();
        try {
            awx awxVar = (awx) map.get(cls);
            reentrantReadWriteLock.readLock().unlock();
            if (awxVar != null) {
                return awxVar;
            }
            reentrantReadWriteLock.writeLock().lock();
            try {
                awx awxVar2 = (awx) map.get(cls);
                if (awxVar2 == null) {
                    awxVar2 = new awx();
                    awxVar2.a = new ReentrantReadWriteLock();
                    awxVar2.b = new ArrayList();
                    map.put(cls, awxVar2);
                }
                return awxVar2;
            } finally {
                reentrantReadWriteLock.writeLock().unlock();
            }
        } catch (Throwable th) {
            reentrantReadWriteLock.readLock().unlock();
            throw th;
        }
    }

    public final synchronized void i(awz[] awzVarArr) {
        int i = 0;
        while (true) {
            awz[][] awzVarArr2 = this.e;
            if (i >= awzVarArr2.length) {
                break;
            }
            if (awzVarArr2[i] == null) {
                Arrays.fill(awzVarArr, (Object) null);
                this.e[i] = awzVarArr;
                break;
            }
            i++;
        }
    }

    public final void j(boolean z) {
        if (this.c == null && !z) {
            throw new IllegalStateException("The event manager is set to be root, and can not be disabled");
        }
        this.f = z;
    }

    public final void k(Class cls, aww awwVar) {
        l(cls, new qp(awwVar, 7));
    }

    public final cbm l(Class cls, awz awzVar) {
        awx awxVarH = h(cls);
        ReentrantReadWriteLock reentrantReadWriteLock = awxVarH.a;
        reentrantReadWriteLock.writeLock().lock();
        try {
            ArrayList arrayList = awxVarH.b;
            if (arrayList.contains(awzVar)) {
                return new cbm(awzVar);
            }
            arrayList.add(awzVar);
            return new cbm(awzVar);
        } finally {
            reentrantReadWriteLock.writeLock().unlock();
        }
    }
}

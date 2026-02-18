package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class awe implements Runnable {
    public final /* synthetic */ int a;
    public final dht b;
    public final /* synthetic */ awh c;

    public /* synthetic */ awe(awh awhVar, dht dhtVar, int i) {
        this.a = i;
        this.c = awhVar;
        this.b = dhtVar;
    }

    /* JADX WARN: Undo finally extract visitor
    java.lang.NullPointerException: Cannot invoke "jadx.core.dex.nodes.BlockNode.getInstructions()" because "finallyBlockTerminus" is null
    	at jadx.core.dex.visitors.finaly.traverser.state.TraverserActivePathState.<init>(TraverserActivePathState.java:253)
    	at jadx.core.dex.visitors.finaly.MarkFinallyVisitor.findCommonInsns(MarkFinallyVisitor.java:422)
    	at jadx.core.dex.visitors.finaly.MarkFinallyVisitor.extractFinally(MarkFinallyVisitor.java:302)
    	at jadx.core.dex.visitors.finaly.MarkFinallyVisitor.processTryBlock(MarkFinallyVisitor.java:222)
    	at jadx.core.dex.visitors.finaly.MarkFinallyVisitor.visit(MarkFinallyVisitor.java:150)
     */
    @Override // java.lang.Runnable
    public final void run() {
        switch (this.a) {
            case 0:
                dht dhtVar = this.b;
                dhtVar.c.b();
                synchronized (dhtVar.d) {
                    try {
                        synchronized (this.c) {
                            try {
                                if (this.c.b.a.contains(new awf(this.b, emn.aa))) {
                                    awh awhVar = this.c;
                                    dht dhtVar2 = this.b;
                                    awhVar.getClass();
                                    try {
                                        dhtVar2.al(awhVar.r, 5);
                                    } catch (Throwable th) {
                                        throw new sx(th);
                                    }
                                }
                                this.c.z();
                            } catch (Throwable th2) {
                                throw th2;
                            }
                        }
                    } catch (Throwable th3) {
                        throw th3;
                    }
                    break;
                }
                return;
            default:
                dht dhtVar3 = this.b;
                dhtVar3.c.b();
                synchronized (dhtVar3.d) {
                    try {
                        synchronized (this.c) {
                            try {
                                if (this.c.b.a.contains(new awf(this.b, emn.aa))) {
                                    this.c.t.k();
                                    awh awhVar2 = this.c;
                                    dht dhtVar4 = this.b;
                                    awhVar2.getClass();
                                    try {
                                        dhtVar4.am(awhVar2.t, awhVar2.p, awhVar2.w);
                                        this.c.ad(this.b);
                                    } catch (Throwable th4) {
                                        throw new sx(th4);
                                    }
                                }
                                this.c.z();
                            } catch (Throwable th5) {
                                throw th5;
                            }
                        }
                    } catch (Throwable th6) {
                        throw th6;
                    }
                }
                return;
        }
    }
}

package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class drt implements dbw, dbs {
    public final dbw a;
    public final Object b;
    public volatile dht c;
    public volatile dbs d;
    public int e = 3;
    public int f = 3;
    public boolean r;

    public drt(Object obj, dbw dbwVar) {
        this.b = obj;
        this.a = dbwVar;
    }

    @Override // me.hd.wauxv.obf.dbs
    public final void clear() {
        synchronized (this.b) {
            this.r = false;
            this.e = 3;
            this.f = 3;
            this.d.clear();
            this.c.clear();
        }
    }

    @Override // me.hd.wauxv.obf.dbw, me.hd.wauxv.obf.dbs
    public final boolean g() {
        boolean z;
        synchronized (this.b) {
            try {
                z = this.d.g() || this.c.g();
            } catch (Throwable th) {
                throw th;
            }
        }
        return z;
    }

    @Override // me.hd.wauxv.obf.dbw
    public final dbw getRoot() {
        dbw root;
        synchronized (this.b) {
            try {
                dbw dbwVar = this.a;
                root = dbwVar != null ? dbwVar.getRoot() : this;
            } catch (Throwable th) {
                throw th;
            }
        }
        return root;
    }

    @Override // me.hd.wauxv.obf.dbw
    public final boolean h(dbs dbsVar) {
        boolean z;
        synchronized (this.b) {
            try {
                dbw dbwVar = this.a;
                z = (dbwVar == null || dbwVar.h(this)) && dbsVar.equals(this.c) && this.e != 2;
            } catch (Throwable th) {
                throw th;
            }
        }
        return z;
    }

    @Override // me.hd.wauxv.obf.dbw
    public final boolean i(dbs dbsVar) {
        boolean z;
        synchronized (this.b) {
            try {
                dbw dbwVar = this.a;
                z = (dbwVar == null || dbwVar.i(this)) && dbsVar.equals(this.c) && !g();
            } catch (Throwable th) {
                throw th;
            }
        }
        return z;
    }

    @Override // me.hd.wauxv.obf.dbs
    public final boolean isRunning() {
        boolean z;
        synchronized (this.b) {
            z = true;
            if (this.e != 1) {
                z = false;
            }
        }
        return z;
    }

    @Override // me.hd.wauxv.obf.dbs
    public final void j() {
        synchronized (this.b) {
            try {
                if (!bjs.b(this.f)) {
                    this.f = 2;
                    this.d.j();
                }
                if (!bjs.b(this.e)) {
                    this.e = 2;
                    this.c.j();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // me.hd.wauxv.obf.dbw
    public final void k(dbs dbsVar) {
        synchronized (this.b) {
            try {
                if (!dbsVar.equals(this.c)) {
                    this.f = 5;
                    return;
                }
                this.e = 5;
                dbw dbwVar = this.a;
                if (dbwVar != null) {
                    dbwVar.k(this);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // me.hd.wauxv.obf.dbs
    public final boolean l(dbs dbsVar) {
        if (!(dbsVar instanceof drt)) {
            return false;
        }
        drt drtVar = (drt) dbsVar;
        if (this.c == null) {
            if (drtVar.c != null) {
                return false;
            }
        } else if (!this.c.l(drtVar.c)) {
            return false;
        }
        return this.d == null ? drtVar.d == null : this.d.l(drtVar.d);
    }

    @Override // me.hd.wauxv.obf.dbs
    public final boolean m() {
        boolean z;
        synchronized (this.b) {
            z = this.e == 3;
        }
        return z;
    }

    /* JADX WARN: Undo finally extract visitor
    java.lang.NullPointerException: Cannot invoke "jadx.core.dex.nodes.BlockNode.getInstructions()" because "finallyBlockTerminus" is null
    	at jadx.core.dex.visitors.finaly.traverser.state.TraverserActivePathState.<init>(TraverserActivePathState.java:253)
    	at jadx.core.dex.visitors.finaly.MarkFinallyVisitor.findCommonInsns(MarkFinallyVisitor.java:422)
    	at jadx.core.dex.visitors.finaly.MarkFinallyVisitor.extractFinally(MarkFinallyVisitor.java:302)
    	at jadx.core.dex.visitors.finaly.MarkFinallyVisitor.processTryBlock(MarkFinallyVisitor.java:222)
    	at jadx.core.dex.visitors.finaly.MarkFinallyVisitor.visit(MarkFinallyVisitor.java:150)
     */
    @Override // me.hd.wauxv.obf.dbs
    public final void n() {
        synchronized (this.b) {
            try {
                this.r = true;
                try {
                    if (this.e != 4 && this.f != 1) {
                        this.f = 1;
                        this.d.n();
                    }
                    if (this.r && this.e != 1) {
                        this.e = 1;
                        this.c.n();
                    }
                    this.r = false;
                } catch (Throwable th) {
                    this.r = false;
                    throw th;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // me.hd.wauxv.obf.dbw
    public final void o(dbs dbsVar) {
        synchronized (this.b) {
            try {
                if (dbsVar.equals(this.d)) {
                    this.f = 4;
                    return;
                }
                this.e = 4;
                dbw dbwVar = this.a;
                if (dbwVar != null) {
                    dbwVar.o(this);
                }
                if (!bjs.b(this.f)) {
                    this.d.clear();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // me.hd.wauxv.obf.dbw
    public final boolean p(dbs dbsVar) {
        boolean z;
        synchronized (this.b) {
            try {
                dbw dbwVar = this.a;
                z = (dbwVar == null || dbwVar.p(this)) && (dbsVar.equals(this.c) || this.e != 4);
            } catch (Throwable th) {
                throw th;
            }
        }
        return z;
    }

    @Override // me.hd.wauxv.obf.dbs
    public final boolean q() {
        boolean z;
        synchronized (this.b) {
            z = this.e == 4;
        }
        return z;
    }
}

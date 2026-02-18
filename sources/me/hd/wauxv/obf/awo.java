package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class awo implements dbw, dbs {
    public final Object a;
    public final dbw b;
    public volatile dbs c;
    public volatile dbs d;
    public int e = 3;
    public int f = 3;

    public awo(Object obj, dbw dbwVar) {
        this.a = obj;
        this.b = dbwVar;
    }

    @Override // me.hd.wauxv.obf.dbs
    public final void clear() {
        synchronized (this.a) {
            try {
                this.e = 3;
                this.c.clear();
                if (this.f != 3) {
                    this.f = 3;
                    this.d.clear();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // me.hd.wauxv.obf.dbw, me.hd.wauxv.obf.dbs
    public final boolean g() {
        boolean z;
        synchronized (this.a) {
            try {
                z = this.c.g() || this.d.g();
            } catch (Throwable th) {
                throw th;
            }
        }
        return z;
    }

    @Override // me.hd.wauxv.obf.dbw
    public final dbw getRoot() {
        dbw root;
        synchronized (this.a) {
            try {
                dbw dbwVar = this.b;
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
        synchronized (this.a) {
            dbw dbwVar = this.b;
            z = (dbwVar == null || dbwVar.h(this)) && dbsVar.equals(this.c);
        }
        return z;
    }

    @Override // me.hd.wauxv.obf.dbw
    public final boolean i(dbs dbsVar) {
        boolean z;
        int i;
        synchronized (this.a) {
            dbw dbwVar = this.b;
            z = false;
            if (dbwVar == null || dbwVar.i(this)) {
                if (this.e != 5 ? dbsVar.equals(this.c) : dbsVar.equals(this.d) && ((i = this.f) == 4 || i == 5)) {
                    z = true;
                }
            }
        }
        return z;
    }

    @Override // me.hd.wauxv.obf.dbs
    public final boolean isRunning() {
        boolean z;
        synchronized (this.a) {
            try {
                z = true;
                if (this.e != 1 && this.f != 1) {
                    z = false;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return z;
    }

    @Override // me.hd.wauxv.obf.dbs
    public final void j() {
        synchronized (this.a) {
            try {
                if (this.e == 1) {
                    this.e = 2;
                    this.c.j();
                }
                if (this.f == 1) {
                    this.f = 2;
                    this.d.j();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // me.hd.wauxv.obf.dbw
    public final void k(dbs dbsVar) {
        synchronized (this.a) {
            try {
                if (dbsVar.equals(this.d)) {
                    this.f = 5;
                    dbw dbwVar = this.b;
                    if (dbwVar != null) {
                        dbwVar.k(this);
                    }
                    return;
                }
                this.e = 5;
                if (this.f != 1) {
                    this.f = 1;
                    this.d.n();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // me.hd.wauxv.obf.dbs
    public final boolean l(dbs dbsVar) {
        if (dbsVar instanceof awo) {
            awo awoVar = (awo) dbsVar;
            if (this.c.l(awoVar.c) && this.d.l(awoVar.d)) {
                return true;
            }
        }
        return false;
    }

    @Override // me.hd.wauxv.obf.dbs
    public final boolean m() {
        boolean z;
        synchronized (this.a) {
            try {
                z = this.e == 3 && this.f == 3;
            } catch (Throwable th) {
                throw th;
            }
        }
        return z;
    }

    @Override // me.hd.wauxv.obf.dbs
    public final void n() {
        synchronized (this.a) {
            try {
                if (this.e != 1) {
                    this.e = 1;
                    this.c.n();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // me.hd.wauxv.obf.dbw
    public final void o(dbs dbsVar) {
        synchronized (this.a) {
            try {
                if (dbsVar.equals(this.c)) {
                    this.e = 4;
                } else if (dbsVar.equals(this.d)) {
                    this.f = 4;
                }
                dbw dbwVar = this.b;
                if (dbwVar != null) {
                    dbwVar.o(this);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // me.hd.wauxv.obf.dbw
    public final boolean p(dbs dbsVar) {
        boolean z;
        synchronized (this.a) {
            dbw dbwVar = this.b;
            z = dbwVar == null || dbwVar.p(this);
        }
        return z;
    }

    @Override // me.hd.wauxv.obf.dbs
    public final boolean q() {
        boolean z;
        synchronized (this.a) {
            try {
                z = this.e == 4 || this.f == 4;
            } catch (Throwable th) {
                throw th;
            }
        }
        return z;
    }
}

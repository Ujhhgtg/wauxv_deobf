package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public abstract class doo extends bmf {
    public final String af;
    public final boolean ag = true;
    public final boolean ah = true;
    public final String[] ai = {ewi.a.e};

    public doo(String str) {
        this.af = str.concat(cnb.z(-50770808404778L));
    }

    @Override // me.hd.wauxv.obf.bmf
    public String[] _aa() {
        return this.ai;
    }

    public boolean _ab() {
        return this.ah;
    }

    public boolean _z() {
        return this.ag;
    }

    public final void aj(boolean z) {
        io ioVar = cnf.ah;
        if (ioVar == null) {
            throw new IllegalArgumentException(cnb.z(-5763846109994L).toString());
        }
        ioVar.at(this.af, z);
    }

    public abstract String f();

    public abstract String g();

    public String o() {
        return null;
    }

    public bgf p() {
        return null;
    }

    public boolean q() {
        return false;
    }

    @Override // me.hd.wauxv.obf.bmf
    public final boolean z() {
        io ioVar = cnf.ah;
        if (ioVar != null) {
            return ioVar.ah(this.af, false);
        }
        throw new IllegalArgumentException(cnb.z(-5763846109994L).toString());
    }
}

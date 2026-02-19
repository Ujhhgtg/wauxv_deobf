package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public abstract class SwitchHook extends BaseBaseHook {
    public final String af;
    public final boolean ag = true;
    public final boolean ah = true;
    public final String[] ai = { ewi.a.e };

    public SwitchHook(String str) {
        this.af = str.concat(".enabled" /* ".enabled" /* ".enabled" /* cnb.z(-50770808404778L)  */);
    }

    @Override // me.hd.wauxv.obf.SwitchHook
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
        DefaultConfig defaultConfig = cnf.ah;
        if (defaultConfig == null) {
            throw new IllegalArgumentException("DefaultConfig must be init" /* "DefaultConfig must be init" /* "DefaultConfig must be init" /* cnb.z(-5763846109994L)  */.toString());
        }
        defaultConfig.at(this.af, z);
    }

    // funcName
    public abstract String getName();

    // location
    public abstract String getCategory();

    // funcDesc
    public String getDescription() {
        return null;
    }

    public IInvokable getOnClick() {
        return null;
    }

    public boolean q() {
        return false;
    }

    @Override // me.hd.wauxv.obf.SwitchHook
    public final boolean getIsEnabled() {
        DefaultConfig ioVar = cnf.ah;
        if (ioVar != null) {
            return ioVar.ah(this.af, false);
        }
        throw new IllegalArgumentException("DefaultConfig must be init" /* "DefaultConfig must be init" /* "DefaultConfig must be init" /* cnb.z(-5763846109994L)  */.toString());
    }
}

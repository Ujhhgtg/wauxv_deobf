package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public abstract class ApiHookItem extends BaseBaseHook {
    public final String[] f = { APP_BRAND_ID_ENUM.APP_BRAND_HOST_PKG_NAME.strValue };

    @Override // me.hd.wauxv.obf.SwitchHook
    public String[] _aa() {
        return this.f;
    }

    @Override // me.hd.wauxv.obf.SwitchHook
    public final boolean getIsEnabled() {
        return true;
    }
}

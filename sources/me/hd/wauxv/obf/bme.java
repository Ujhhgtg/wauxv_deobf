package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class bme implements IInvokable {
    public final /* synthetic */ int a;
    public final /* synthetic */ IInvokable b;
    public final /* synthetic */ BaseBaseHook c;

    public /* synthetic */ bme(IInvokable bgfVar, BaseBaseHook bmfVar, int i) {
        this.a = i;
        this.b = bgfVar;
        this.c = bmfVar;
    }

    @Override // me.hd.wauxv.obf.bgf
    public final Object invoke(Object obj) {
        HookParam hookParam = (HookParam) obj;
        switch (this.a) {
            case 0:
                if (!this.c.getIsEnabled()) {
                    hookParam = null;
                }
                if (hookParam != null) {
                    this.b.invoke(hookParam);
                }
                break;
            default:
                if (!this.c.getIsEnabled()) {
                    hookParam = null;
                }
                if (hookParam != null) {
                    this.b.invoke(hookParam);
                }
                break;
        }
        return KotlinUnit.INSTANCE;
    }
}

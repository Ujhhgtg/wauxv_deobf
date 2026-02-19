package me.hd.wauxv.obf;

import android.view.MenuItem;
import android.widget.FrameLayout;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class wi implements bfu {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;

    public /* synthetic */ wi(Object obj, int i) {
        this.a = i;
        this.b = obj;
    }

    @Override // me.hd.wauxv.obf.bfu
    public final Object invoke() throws IllegalAccessException {
        int i = this.a;
        Object obj = this.b;
        switch (i) {
            case 0:
                int i2 = 0;
                MethodResolver methodResolverVarT = dqc.getWrapperConfiguration(obj).getMethodResolverBasedOnPreviouslyProvidedConfig();
                methodResolverVarT.returnType = dal.b(MenuItem.class);
                Class cls = Integer.TYPE;
                return (MethodHookWrapper) StaticHelpers6.n(
                        new Object[] { dal.b(cls), dal.b(cls), dal.b(cls), dal.b(CharSequence.class), dal.b(cls) }, 5,
                        methodResolverVarT);
            case 1:
                int i3 = 0;
                FieldResolver fieldResolverVarR = dqc.getWrapperConfiguration(obj).r();
                gp.a.getClass();
                fieldResolverVarR.fieldType = StaticHelpers7.bb(go.a).getDeclaringClass();
                Object objD = ((azk) StaticHelpers5.safeGetFirstInList(fieldResolverVarR.resolve())).d();
                throwIfVar1IsNull(objD);
                xx.a.getClass();
                FieldResolver fieldResolverVarR2 = dqc.getWrapperConfiguration(gp.b((Class) SomeStaticHelpers.p(StaticHelpers7.az(xw.a).getInterfaces()), objD)).r();
                uq.a.getClass();
                fieldResolverVarR2.fieldType = ajn.tryGetClassByClassName("com.tencent.mm.pluginsdk.ui.chat.ChatFooter" /* "com.tencent.mm.pluginsdk.ui.chat.ChatFooter" /* "com.tencent.mm.pluginsdk.ui.chat.ChatFooter" /* cnb.z(-75127567940394L)  */);
                Object objE = ((azk) StaticHelpers5.safeGetFirstInList(fieldResolverVarR2.resolve())).e();
                throwIfVar1IsNull(objE);
                return (FrameLayout) objE;
            default:
                return obj;
        }
    }
}

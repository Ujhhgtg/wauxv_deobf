package me.hd.wauxv.obf;

import android.view.MenuItem;
import android.widget.FrameLayout;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class wi implements IFunction0 {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;

    public /* synthetic */ wi(Object obj, int i) {
        this.a = i;
        this.b = obj;
    }

    @Override // me.hd.wauxv.obf.bfu
    public final Object invoke() throws IllegalAccessException {
        Object obj = this.b;
        switch (this.a) {
            case 0:
                MethodResolver methodResolverVarT = dqc.getWrapperConfiguration(obj).getMethodResolverBasedOnPreviouslyProvidedConfig();
                methodResolverVarT.returnType = dal.getKClassFromClass(MenuItem.class);
                Class cls = Integer.TYPE;
                return (MethodHookWrapper) StaticHelpers6.setParamsBasedOnVar1Var2AndResolveFirstMethod(
                        new Object[] { dal.getKClassFromClass(cls), dal.getKClassFromClass(cls), dal.getKClassFromClass(cls), dal.getKClassFromClass(CharSequence.class), dal.getKClassFromClass(cls) }, 5,
                        methodResolverVarT);
            case 1:
                FieldResolver fieldResolverVarR = dqc.getWrapperConfiguration(obj).createFieldResolver();
                fieldResolverVarR.fieldType = StaticHelpers7.toDexMethod(ApiManager$MethodGetApi.INSTANCE).getDeclaringClass();
                Object objD = ((BoundField) StaticHelpers5.safeGetFirstInList(fieldResolverVarR.resolve())).getValue();
                throwIfVar1IsNull(objD);
                FieldResolver fieldResolverVarR2 = dqc.getWrapperConfiguration(ApiManagerGetApiDexFindHook.getApi((Class) SomeStaticHelpers.getFirstInArray(StaticHelpers7.toDexClass(ChattingFoot$ClassChattingFoot.a).getInterfaces()), objD)).createFieldResolver();
                fieldResolverVarR2.fieldType = ajn.tryGetClassByClassName("com.tencent.mm.pluginsdk.ui.chat.ChatFooter");
                Object objE = ((BoundField) StaticHelpers5.safeGetFirstInList(fieldResolverVarR2.resolve())).getValue_();
                throwIfVar1IsNull(objE);
                return (FrameLayout) objE;
            default:
                return obj;
        }
    }
}

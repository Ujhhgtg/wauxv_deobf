package me.hd.wauxv.obf;

import android.app.Activity;
import android.content.ContextWrapper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class dmi extends bws {
    public static final dmi a = new dmi();
    public static final LinkedHashSet b = new LinkedHashSet();

    @Override // me.hd.wauxv.obf.SwitchHook
    public final void initOnce() {
        for (IEmpty5 bsvVar : OtherStaticHelpers.argsToList(dal.getKClassFromClass(ContextWrapper.class), dal.getKClassFromClass(Activity.class))) {
            int i = 0;
            MethodResolver methodResolverVarT = dqc.bg(bsvVar).getMethodResolverBasedOnPreviouslyProvidedConfig();
            methodResolverVarT.nameCondition = new SyntheticMessOfLambdas(15);
            List<MemberWrapper> listAj = methodResolverVarT.findMethods();
            dmi dmiVar = a;
            dmiVar.getClass();
            for (MemberWrapper memberWrapperVar : listAj) {
                if (!(memberWrapperVar instanceof ConstructorHookWrapper) && !(memberWrapperVar instanceof MethodHookWrapper)) {
                    throw new IllegalStateException(
                            ("This type [" + memberWrapperVar + "] not support to hook, supported are Constructors and Methods")
                                    .toString());
                }
            }
            ArrayList arrayList = new ArrayList(StaticHelpers4.ak(listAj, 10));
            Iterator it = listAj.iterator();
            while (it.hasNext()) {
                arrayList.add(((MemberWrapper) it.next()).getMember());
            }
            Throwable th = new Throwable("There is no hook class instance");
            erp erpVar = new erp(29, false);
            erpVar.v = th;
            HookManager hookManagerVar = new HookManager(new but(dmiVar), HookPriorityEnum.ENUM_DEFAULT, ResolutionStrategyEnum.ENUM_IMMEDIATE);
            if (!arrayList.isEmpty()) {
                LinkedHashSet linkedHashSet = (LinkedHashSet) hookManagerVar.members;
                linkedHashSet.clear();
                linkedHashSet.addAll(arrayList);
            }
            hookManagerVar.n(new SyntheticMessOfLambdas(16));
            hookManagerVar.initInstantCollectionAndApplyHooks();
        }
    }
}

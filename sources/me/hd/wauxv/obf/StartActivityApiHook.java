package me.hd.wauxv.obf;

import android.app.Activity;
import android.content.ContextWrapper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class StartActivityApiHook extends ApiHookItem {
    public static final StartActivityApiHook a = new StartActivityApiHook();
    public static final LinkedHashSet ALL_HOOKS = new LinkedHashSet();

    @Override // me.hd.wauxv.obf.SwitchHook
    public final void initOnce() {
        for (IEmpty5 bsvVar : OtherStaticHelpers.argsToList(dal.getKClassFromClass(ContextWrapper.class), dal.getKClassFromClass(Activity.class))) {
            MethodResolver methodResolverVarT = dqc.bg(bsvVar).getMethodResolverBasedOnPreviouslyProvidedConfig();
            methodResolverVarT.nameCondition = new SyntheticMessOfLambdas(15);
            List<MemberWrapper> listAj = methodResolverVarT.findMethods();
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
            HookManager hookManagerVar = new HookManager(new but(a), HookPriorityEnum.ENUM_DEFAULT, ResolutionStrategyEnum.ENUM_IMMEDIATE);
            if (!arrayList.isEmpty()) {
                LinkedHashSet linkedHashSet = (LinkedHashSet) hookManagerVar.members;
                linkedHashSet.clear();
                linkedHashSet.addAll(arrayList);
            }
            hookManagerVar.hookBefore(new SyntheticMessOfLambdas(16));
            hookManagerVar.initInstantCollectionAndApplyHooks();
        }
    }
}

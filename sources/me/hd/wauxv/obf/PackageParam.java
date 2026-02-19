package me.hd.wauxv.obf;

import android.app.AndroidAppHelper;
import java.lang.reflect.Constructor;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public class PackageParam {
    public csc aa = null;

    public static final aki ab(PackageParam packageParamVar, List list) {
        packageParamVar.getClass();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            Member member = (Member) it.next();
            if (!(member instanceof Constructor) && !(member instanceof Method)) {
                throw new IllegalStateException(("This type [" + member + "] not support to hook, supported are Constructors and Methods").toString());
            }
        }
        aki akiVar = new aki(new but(packageParamVar), HookPriorityEnum.ENUM_DEFAULT, ResolutionStrategyEnum.ENUM_LAZY_MEMBERS);
        if (!list.isEmpty()) {
            LinkedHashSet linkedHashSet = (LinkedHashSet) akiVar.members;
            linkedHashSet.clear();
            linkedHashSet.addAll(list);
        }
        return akiVar;
    }

    public final String ac() {
        Object objX;
        String str;
        csc cscVar = this.aa;
        if (cscVar != null) {
            return cscVar.c;
        }
        ki.a.getClass();
        try {
            objX = AndroidAppHelper.currentProcessName();
        } catch (Throwable th) {
            objX = FastKV.x(th);
        }
        String str2 = null;
        if (objX instanceof dcx) {
            objX = null;
        }
        String str3 = (String) objX;
        if (str3 != null) {
            return str3;
        }
        int i = 0;
        FactoryPools factoryPoolsVar = ki.e;
        btc btcVar = ki.b[0];
        SyntheticPileOfMess bmuVarBh = dqc.bh(factoryPoolsVar.w());
        Kotlin$Lazy kotlin$LazyVar = ep.a;
        ((Configuration) bmuVarBh.obj).processorResolver = FastKV.aa();
        bmuVarBh.setHookOptional(true);
        MethodResolver methodResolverVarT = bmuVarBh.getMethodResolverBasedOnPreviouslyProvidedConfig();
        methodResolverVarT.name = "currentPackageName";
        MethodHookWrapper methodHookWrapperVar = (MethodHookWrapper) StaticHelpers5.g(methodResolverVarT.findMethods());
        if (methodHookWrapperVar != null && (str = (String) methodHookWrapperVar.j(new Object[0])) != null && !dnj.ak(str)) {
            str2 = str;
        }
        return str2 == null ? "android" : str2;
    }

    public final aki ad(MemberWrapper memberWrapperVar, HookPriorityEnum hookPriorityEnumVar) {
        if (!(memberWrapperVar instanceof ConstructorHookWrapper) && !(memberWrapperVar instanceof MethodHookWrapper)) {
            throw new IllegalStateException(("This type [" + memberWrapperVar + "] not support to hook, supported are Constructors and Methods").toString());
        }
        List listBf = dqc.toSingletonList(memberWrapperVar.getMember());
        Throwable th = new Throwable("There is no hook class instance");
        erp erpVar = new erp(29, false);
        erpVar.v = th;
        aki akiVar = new aki(new but(this), hookPriorityEnumVar, ResolutionStrategyEnum.ENUM_IMMEDIATE);
        if (!listBf.isEmpty()) {
            LinkedHashSet linkedHashSet = (LinkedHashSet) akiVar.members;
            linkedHashSet.clear();
            linkedHashSet.addAll(listBf);
        }
        return akiVar;
    }

    public final void ae(ewy ewyVar) {
        csc cscVar = ewyVar.aa;
        if (cscVar == null) {
            ewyVar.ak(this);
            return;
        }
        if (dnj.ak(cscVar.b) || cscVar.a == bmk.a) {
            ewyVar.ak(this);
            return;
        }
        String str = cscVar.b;
        csc cscVar2 = this.aa;
        if (str.equals(cscVar2 != null ? cscVar2.b : null)) {
            ewyVar.ak(this);
            return;
        }
        ArrayList arrayList = ewq.a;
        String name = ewyVar.getClass().getName();
        csc cscVar3 = this.aa;
        ewq.h("This Hooker \"" + name + "\" is singleton or reused, but the current process has multiple package name \"" + (cscVar3 != null ? cscVar3.b : null) + "\", the original is \"" + cscVar.b + "\"\nMake sure your Hooker supports multiple instances for this situation\nThe process with package name \"" + (cscVar3 != null ? cscVar3.b : null) + "\" will be ignored");
    }

    public final String toString() {
        return "PackageParam(" + super.toString() + ") by " + this.aa;
    }
}

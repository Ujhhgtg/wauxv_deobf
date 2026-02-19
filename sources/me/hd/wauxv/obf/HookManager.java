package me.hd.wauxv.obf;

import java.lang.reflect.Member;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class HookManager {
    public boolean b;
    public Object hookPriority;
    public Object resolutionStrategy;
    public Object instantCollection;
    public Object f;
    public Object g;
    public Object activeUnhooks;
    public Object members;
    public Object hookingEngine;

    public /* synthetic */ HookManager() {
    }

    public static final void verifySignature(HookManager hookManagerVar, Class cls, Class cls2) {
        Class cls3;
        if (cls == null || cls2 == null) {
            return;
        }
        cls3 = Object.class;
        Class<Object> clsBf = HugeSyntheticPileOfHelpers.getPrimitiveTypeClassByJWrapperClass(dal.getKClassFromClass(cls3));
        if (cls.equals(clsBf != null ? clsBf : Object.class)) {
            return;
        }
        Class clsBd = StaticHelpers7.bd(cls);
        Class<?> clsBd2 = StaticHelpers7.bd(cls2);
        ConcurrentHashMap concurrentHashMap = ReflectionWrapper.cachedConstructors;
        if (clsBd2.isAssignableFrom(clsBd) || clsBd.isAssignableFrom(clsBd2)) {
            return;
        }
        throw new IllegalStateException(
                ("Hooked method return type match failed, required [" + cls + "] but got [" + cls2 + "]").toString());
    }

    public static void l(HookManager hookManagerVar) {
        InstantCollection instantCollectionVar = (InstantCollection) hookManagerVar.instantCollection;
        if (instantCollectionVar != null) {
            HookManager hookManagerVar2 = (HookManager) instantCollectionVar.instantBuilders;
            LinkedHashSet<exa> linkedHashSet = (LinkedHashSet) hookManagerVar2.activeUnhooks;
            if (linkedHashSet.isEmpty()) {
                linkedHashSet = null;
            }
            if (linkedHashSet != null) {
                but butVar = (but) hookManagerVar2.hookingEngine;
                for (exa exaVar : linkedHashSet) {
                    exaVar.b.invoke();
                    ArrayList arrayList = Logger.a;
                    Objects.toString(exaVar.a.xposedUnhook.getHookedMethod());
                    Logger.f();
                }
                try {
                    if (((LinkedHashMap) butVar.c).remove(hookManagerVar2.toString()) != null) {
                        throw new ClassCastException();
                    }
                } catch (Throwable th) {
                    FastKV.getFailureFromException(th);
                }
                linkedHashSet.clear();
            }
        }
    }

    public dop m(IInvokable bgfVar) {
        this.g = bgfVar;
        applyHooks(false);
        return new dop(25);
    }

    public dop n(IInvokable bgfVar) {
        this.f = bgfVar;
        applyHooks(false);
        return new dop(25);
    }

    public void initInstantCollectionAndApplyHooks() {
        this.instantCollection = new InstantCollection(this);
        applyHooks(true);
    }

    /* JADX WARN: Found duplicated region for block: B:6:0x0019 */
    public void logHookError(Throwable th, Member member) {
        String str;
        ArrayList arrayList = Logger.a;
        if (member != null) {
            str = "[" + member + "]";
            if (str == null) {
                str = "nothing";
            }
        } else {
            str = "nothing";
        }
        Logger.logException(4, "Try to hook " + str + " got an exception", th);
    }

    public void applyHooks(boolean z) {
        Object objX;
        ResolutionStrategyEnum resolutionStrategyEnumVar = (ResolutionStrategyEnum) this.resolutionStrategy;
        if ((z && resolutionStrategyEnumVar == ResolutionStrategyEnum.ENUM_LAZY_MEMBERS) || resolutionStrategyEnumVar == ResolutionStrategyEnum.ENUM_IMMEDIATE) {
            but butVar = (but) this.hookingEngine;
            if (bhs.r() != bmc.b) {
                csc cscVar = ((PackageParam) butVar.b).processInfo;
                if ((cscVar != null ? cscVar.hookScope : null) == HookScopeEnum.RESOURCES || this.b) {
                    return;
                }
                this.b = true;
                LinkedHashSet<Member> linkedHashSet = (LinkedHashSet) this.members;
                if (linkedHashSet.isEmpty()) {
                    linkedHashSet = null;
                }
                if (linkedHashSet == null) {
                    Throwable th = new Throwable("Finding Error isSetUpMember [false]");
                    if (resolutionStrategyEnumVar != ResolutionStrategyEnum.ENUM_LAZY_CLASSES) {
                        return;
                    }
                    Logger.logException(4, "Hooked Member cannot be null", th);
                    return;
                }
                for (Member member : linkedHashSet) {
                    try {
                        exh exhVarZ = cnh.z(member, new exj(butVar, this, member, (HookPriorityEnum) this.hookPriority));
                        exa exaVar = exhVarZ.a;
                        if ((exaVar != null ? exaVar.a.xposedUnhook.getHookedMethod() : null) == null) {
                            throw new IllegalStateException(("Hook Member [" + member + "] failed").toString());
                        }
                        ((LinkedHashSet) this.activeUnhooks).add(exhVarZ.a);
                        objX = exhVarZ;
                    } catch (Throwable th2) {
                        objX = FastKV.getFailureFromException(th2);
                    }
                    Throwable thB = Success.exceptionOrNull(objX);
                    if (thB != null) {
                        logHookError(thB, member);
                    }
                }
            }
        }
    }

    public HookManager(but butVar, HookPriorityEnum hookPriorityEnumVar, ResolutionStrategyEnum resolutionStrategyEnumVar) {
        this.hookingEngine = butVar;
        this.hookPriority = hookPriorityEnumVar;
        this.resolutionStrategy = resolutionStrategyEnumVar;
        this.activeUnhooks = new LinkedHashSet();
        this.members = new LinkedHashSet();
    }
}

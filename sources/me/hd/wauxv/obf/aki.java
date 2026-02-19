package me.hd.wauxv.obf;

import java.lang.reflect.Member;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class aki {
    public final /* synthetic */ int a = 0;
    public boolean b;
    public Object hookPriority;
    public Object resolutionStrategy;
    public Object e;
    public Object f;
    public Object g;
    public Object h;
    public Object members;
    public Object j;

    public /* synthetic */ aki() {
    }

    public static final void k(aki akiVar, Class cls, Class cls2) {
        Class cls3;
        if (cls == null || cls2 == null) {
            return;
        }
        cls3 = Object.class;
        Class<Object> clsBf = HugeSyntheticPileOfHelpers.bf(dal.b(cls3));
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

    public static void l(aki akiVar) {
        eru eruVar = (eru) akiVar.e;
        if (eruVar != null) {
            aki akiVar2 = (aki) eruVar.a;
            LinkedHashSet<exa> linkedHashSet = (LinkedHashSet) akiVar2.h;
            if (linkedHashSet.isEmpty()) {
                linkedHashSet = null;
            }
            if (linkedHashSet != null) {
                but butVar = (but) akiVar2.j;
                for (exa exaVar : linkedHashSet) {
                    exaVar.b.invoke();
                    ArrayList arrayList = ewq.a;
                    Objects.toString(exaVar.a.xposedUnhook.getHookedMethod());
                    ewq.f();
                }
                try {
                    if (((LinkedHashMap) butVar.c).remove(akiVar2.toString()) != null) {
                        throw new ClassCastException();
                    }
                } catch (Throwable th) {
                    FastKV.x(th);
                }
                linkedHashSet.clear();
            }
        }
    }

    public dop m(IInvokable bgfVar) {
        this.g = bgfVar;
        q(false);
        return new dop(25);
    }

    public dop n(IInvokable bgfVar) {
        this.f = bgfVar;
        q(false);
        return new dop(25);
    }

    public void o() {
        this.e = new eru(this);
        q(true);
    }

    /* JADX WARN: Found duplicated region for block: B:6:0x0019 */
    public void p(Throwable th, Member member) {
        String str;
        ArrayList arrayList = ewq.a;
        if (member != null) {
            str = "[" + member + "]";
            if (str == null) {
                str = "nothing";
            }
        } else {
            str = "nothing";
        }
        ewq.g(4, "Try to hook " + str + " got an exception", th);
    }

    public void q(boolean z) {
        Object objX;
        ResolutionStrategyEnum resolutionStrategyEnumVar = (ResolutionStrategyEnum) this.resolutionStrategy;
        if ((z && resolutionStrategyEnumVar == ResolutionStrategyEnum.ENUM_LAZY_MEMBERS) || resolutionStrategyEnumVar == ResolutionStrategyEnum.ENUM_IMMEDIATE) {
            but butVar = (but) this.j;
            if (bhs.r() != bmc.b) {
                csc cscVar = ((PackageParam) butVar.b).aa;
                if ((cscVar != null ? cscVar.a : null) == bmk.c || this.b) {
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
                    ewq.g(4, "Hooked Member cannot be null", th);
                    return;
                }
                for (Member member : linkedHashSet) {
                    try {
                        exh exhVarZ = cnh.z(member, new exj(butVar, this, member, (HookPriorityEnum) this.hookPriority));
                        exa exaVar = exhVarZ.a;
                        if ((exaVar != null ? exaVar.a.xposedUnhook.getHookedMethod() : null) == null) {
                            throw new IllegalStateException(("Hook Member [" + member + "] failed").toString());
                        }
                        ((LinkedHashSet) this.h).add(exhVarZ.a);
                        objX = exhVarZ;
                    } catch (Throwable th2) {
                        objX = FastKV.x(th2);
                    }
                    Throwable thB = dcy.b(objX);
                    if (thB != null) {
                        p(thB, member);
                    }
                }
            }
        }
    }

    public aki(but butVar, HookPriorityEnum hookPriorityEnumVar, ResolutionStrategyEnum resolutionStrategyEnumVar) {
        this.j = butVar;
        this.hookPriority = hookPriorityEnumVar;
        this.resolutionStrategy = resolutionStrategyEnumVar;
        this.h = new LinkedHashSet();
        this.members = new LinkedHashSet();
    }
}

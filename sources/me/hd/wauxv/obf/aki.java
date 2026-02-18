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
    public Object c;
    public Object d;
    public Object e;
    public Object f;
    public Object g;
    public Object h;
    public Object i;
    public Object j;

    public /* synthetic */ aki() {
    }

    public static final void k(aki akiVar, Class cls, Class cls2) {
        Class cls3;
        if (cls == null || cls2 == null) {
            return;
        }
        cls3 = Object.class;
        Class<Object> clsBf = cnf.bf(dal.b(cls3));
        if (cls.equals(clsBf != null ? clsBf : Object.class)) {
            return;
        }
        Class clsBd = emn.bd(cls);
        Class<?> clsBd2 = emn.bd(cls2);
        ConcurrentHashMap concurrentHashMap = zf.a;
        if (clsBd2.isAssignableFrom(clsBd) || clsBd.isAssignableFrom(clsBd2)) {
            return;
        }
        throw new IllegalStateException(("Hooked method return type match failed, required [" + cls + "] but got [" + cls2 + "]").toString());
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
                    Objects.toString(exaVar.a.b.getHookedMethod());
                    ewq.f();
                }
                try {
                    if (((LinkedHashMap) butVar.c).remove(akiVar2.toString()) != null) {
                        throw new ClassCastException();
                    }
                } catch (Throwable th) {
                    bhu.x(th);
                }
                linkedHashSet.clear();
            }
        }
    }

    public dop m(bgf bgfVar) {
        this.g = bgfVar;
        q(false);
        return new dop(25);
    }

    public dop n(bgf bgfVar) {
        this.f = bgfVar;
        q(false);
        return new dop(25);
    }

    public void o() {
        this.e = new eru(this);
        q(true);
    }

    /* JADX WARN: Found duplicated region for block: B:6:0x0019  */
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
        exi exiVar = (exi) this.d;
        if ((z && exiVar == exi.b) || exiVar == exi.c) {
            but butVar = (but) this.j;
            if (bhs.r() != bmc.b) {
                csc cscVar = ((csb) butVar.b).aa;
                if ((cscVar != null ? cscVar.a : null) == bmk.c || this.b) {
                    return;
                }
                this.b = true;
                LinkedHashSet<Member> linkedHashSet = (LinkedHashSet) this.i;
                if (linkedHashSet.isEmpty()) {
                    linkedHashSet = null;
                }
                if (linkedHashSet == null) {
                    Throwable th = new Throwable("Finding Error isSetUpMember [false]");
                    if (exiVar != exi.a) {
                        return;
                    }
                    ewq.g(4, "Hooked Member cannot be null", th);
                    return;
                }
                for (Member member : linkedHashSet) {
                    try {
                        exh exhVarZ = cnh.z(member, new exj(butVar, this, member, (exg) this.c));
                        exa exaVar = exhVarZ.a;
                        if ((exaVar != null ? exaVar.a.b.getHookedMethod() : null) == null) {
                            throw new IllegalStateException(("Hook Member [" + member + "] failed").toString());
                        }
                        ((LinkedHashSet) this.h).add(exhVarZ.a);
                        objX = exhVarZ;
                    } catch (Throwable th2) {
                        objX = bhu.x(th2);
                    }
                    Throwable thB = dcy.b(objX);
                    if (thB != null) {
                        p(thB, member);
                    }
                }
            }
        }
    }

    public String toString() {
        switch (this.a) {
            case 1:
                LinkedHashSet linkedHashSet = (LinkedHashSet) this.i;
                return "[priority] " + ((exg) this.c) + " [members] " + linkedHashSet;
            default:
                return super.toString();
        }
    }

    public aki(but butVar, exg exgVar, exi exiVar) {
        this.j = butVar;
        this.c = exgVar;
        this.d = exiVar;
        arj.s();
        arj.s();
        arj.s();
        this.h = new LinkedHashSet();
        this.i = new LinkedHashSet();
    }
}

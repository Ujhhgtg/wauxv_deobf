package me.hd.wauxv.obf;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class cbn implements bgf {
    public final /* synthetic */ int a;
    public final /* synthetic */ cbg b;

    public /* synthetic */ cbn(cbg cbgVar, int i) {
        this.a = i;
        this.b = cbgVar;
    }

    @Override // me.hd.wauxv.obf.bgf
    public final Object invoke(Object obj) {
        switch (this.a) {
            case 0:
                Member member = (Member) obj;
                bzo.o(member, "null cannot be cast to non-null type java.lang.reflect.Method");
                cdk cdkVar = new cdk((Method) member);
                Object obj2 = this.b.b;
                if (obj2 != null) {
                    cdkVar.c(obj2);
                }
                return cdkVar;
            case 1:
                Member member2 = (Member) obj;
                bzo.o(member2, "null cannot be cast to non-null type java.lang.reflect.Constructor<T of com.highcapable.kavaref.resolver.processor.MemberProcessor.resolve>");
                adu aduVar = new adu((Constructor) member2);
                Object obj3 = this.b.b;
                return aduVar;
            case 2:
                Member member3 = (Member) obj;
                bzo.o(member3, "null cannot be cast to non-null type java.lang.reflect.Field");
                azk azkVar = new azk((Field) member3);
                Object obj4 = this.b.b;
                if (obj4 != null) {
                    azkVar.c(obj4);
                }
                return azkVar;
            case 3:
                Member member4 = (Member) obj;
                bzo.o(member4, "null cannot be cast to non-null type java.lang.reflect.Method");
                cdk cdkVar2 = new cdk((Method) member4);
                Object obj5 = this.b.b;
                if (obj5 != null) {
                    cdkVar2.c(obj5);
                }
                return cdkVar2;
            case 4:
                Member member5 = (Member) obj;
                bzo.o(member5, "null cannot be cast to non-null type java.lang.reflect.Constructor<T of com.highcapable.kavaref.resolver.processor.MemberProcessor.resolve>");
                adu aduVar2 = new adu((Constructor) member5);
                Object obj6 = this.b.b;
                return aduVar2;
            case 5:
                Member member6 = (Member) obj;
                bzo.o(member6, "null cannot be cast to non-null type java.lang.reflect.Field");
                azk azkVar2 = new azk((Field) member6);
                Object obj7 = this.b.b;
                if (obj7 != null) {
                    azkVar2.c(obj7);
                }
                return azkVar2;
            case 6:
                Member member7 = (Member) obj;
                bzo.o(member7, "null cannot be cast to non-null type java.lang.reflect.Method");
                cdk cdkVar3 = new cdk((Method) member7);
                Object obj8 = this.b.b;
                if (obj8 != null) {
                    cdkVar3.c(obj8);
                }
                return cdkVar3;
            case 7:
                Member member8 = (Member) obj;
                bzo.o(member8, "null cannot be cast to non-null type java.lang.reflect.Constructor<T of com.highcapable.kavaref.resolver.processor.MemberProcessor.resolve>");
                adu aduVar3 = new adu((Constructor) member8);
                Object obj9 = this.b.b;
                return aduVar3;
            default:
                Member member9 = (Member) obj;
                bzo.o(member9, "null cannot be cast to non-null type java.lang.reflect.Field");
                azk azkVar3 = new azk((Field) member9);
                Object obj10 = this.b.b;
                if (obj10 != null) {
                    azkVar3.c(obj10);
                }
                return azkVar3;
        }
    }
}

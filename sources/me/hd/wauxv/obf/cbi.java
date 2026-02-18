package me.hd.wauxv.obf;

import java.lang.annotation.Annotation;
import java.lang.reflect.Executable;
import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class cbi implements bgj {
    public final /* synthetic */ int a;
    public final /* synthetic */ cbg b;

    public /* synthetic */ cbi(cbg cbgVar, int i) {
        this.a = i;
        this.b = cbgVar;
    }

    @Override // me.hd.wauxv.obf.bgj
    public final Object g(Object obj, Object obj2) {
        boolean zF;
        boolean zE;
        switch (this.a) {
            case 0:
                zF = nullSafeIsEqual(((Method) obj2).getReturnType(), cbp.t(obj, this.b, "Method: returnType"));
                return Boolean.valueOf(zF);
            case 1:
                zF = cbp.e((List) obj, la.ab(((Executable) obj2).getParameterTypes()), this.b);
                return Boolean.valueOf(zF);
            case 2:
                List list = (List) obj;
                Annotation[][] parameterAnnotations = ((Executable) obj2).getParameterAnnotations();
                ArrayList arrayList = new ArrayList(parameterAnnotations.length);
                boolean z = false;
                for (Annotation[] annotationArr : parameterAnnotations) {
                    ArrayList arrayList2 = new ArrayList(annotationArr.length);
                    for (Annotation annotation : annotationArr) {
                        arrayList2.add(cnf.bd(cnf.bb(annotation)));
                    }
                    arrayList.add(arrayList2);
                }
                if (list.size() == arrayList.size()) {
                    ArrayList arrayList3 = new ArrayList();
                    int i = 0;
                    for (Object obj3 : list) {
                        int i2 = i + 1;
                        if (i < 0) {
                            aba.aj();
                            throw null;
                        }
                        if (cbp.e((Collection) obj3, (List) arrayList.get(i), this.b)) {
                            arrayList3.add(obj3);
                        }
                        i = i2;
                    }
                    if (arrayList3.size() == arrayList.size()) {
                        z = true;
                    }
                }
                return Boolean.valueOf(z);
            case 3:
                List list2 = (List) obj;
                Annotation[][] parameterAnnotations2 = ((Executable) obj2).getParameterAnnotations();
                ArrayList arrayList4 = new ArrayList(parameterAnnotations2.length);
                boolean z2 = false;
                for (Annotation[] annotationArr2 : parameterAnnotations2) {
                    ArrayList arrayList5 = new ArrayList(annotationArr2.length);
                    for (Annotation annotation2 : annotationArr2) {
                        arrayList5.add(cnf.bd(cnf.bb(annotation2)));
                    }
                    arrayList4.add(arrayList5);
                }
                if (list2.size() == arrayList4.size()) {
                    ArrayList arrayList6 = new ArrayList();
                    int i3 = 0;
                    for (Object obj4 : list2) {
                        int i4 = i3 + 1;
                        if (i3 < 0) {
                            aba.aj();
                            throw null;
                        }
                        if (cbp.e((Collection) obj4, (List) arrayList4.get(i3), this.b)) {
                            arrayList6.add(obj4);
                        }
                        i3 = i4;
                    }
                    if (arrayList6.size() == arrayList4.size()) {
                        z2 = true;
                    }
                }
                zF = !z2;
                return Boolean.valueOf(zF);
            case 4:
                zF = cbp.g(this.b, (Set) obj, (Executable) obj2);
                return Boolean.valueOf(zF);
            case 5:
                zF = cbp.h(this.b, (Set) obj, (Executable) obj2);
                return Boolean.valueOf(zF);
            case 6:
                zF = cbp.i(this.b, (Set) obj, (Executable) obj2);
                return Boolean.valueOf(zF);
            case 7:
                zE = cbp.e((List) obj, la.ab(((Executable) obj2).getParameterTypes()), this.b);
                break;
            case 8:
                zF = cbp.j(this.b, (Set) obj, (Executable) obj2);
                return Boolean.valueOf(zF);
            case 9:
                zF = cbp.k(this.b, (Set) obj, (Executable) obj2);
                return Boolean.valueOf(zF);
            case 10:
                zF = cbp.l(this.b, (Set) obj, (Executable) obj2);
                return Boolean.valueOf(zF);
            case 11:
                zF = cbp.m(this.b, (Set) obj, (Executable) obj2);
                return Boolean.valueOf(zF);
            case 12:
                zF = cbp.n(this.b, (Set) obj, (Executable) obj2);
                return Boolean.valueOf(zF);
            case 13:
                zF = cbp.e((Set) obj, la.ab(((Executable) obj2).getExceptionTypes()), this.b);
                return Boolean.valueOf(zF);
            case 14:
                zE = cbp.e((Set) obj, la.ab(((Executable) obj2).getExceptionTypes()), this.b);
                break;
            case 15:
                Set set = (Set) obj;
                Annotation[] annotationArrP = cbp.p((Member) obj2);
                ArrayList arrayList7 = new ArrayList(annotationArrP.length);
                for (Annotation annotation3 : annotationArrP) {
                    arrayList7.add(cnf.bd(cnf.bb(annotation3)));
                }
                zF = cbp.e(set, arrayList7, this.b);
                return Boolean.valueOf(zF);
            case 16:
                Set set2 = (Set) obj;
                Annotation[] annotationArrP2 = cbp.p((Member) obj2);
                ArrayList arrayList8 = new ArrayList(annotationArrP2.length);
                for (Annotation annotation4 : annotationArrP2) {
                    arrayList8.add(cnf.bd(cnf.bb(annotation4)));
                }
                zE = cbp.e(set2, arrayList8, this.b);
                break;
            default:
                zF = nullSafeIsEqual(((Field) obj2).getType(), cbp.t(obj, this.b, "Field: type"));
                return Boolean.valueOf(zF);
        }
        zF = !zE;
        return Boolean.valueOf(zF);
    }
}

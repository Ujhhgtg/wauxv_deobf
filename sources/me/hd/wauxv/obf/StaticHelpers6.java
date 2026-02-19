package me.hd.wauxv.obf;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.android.dx.util.AnnotatedOutput;
import com.android.dx.util.Hex;
import java.util.ArrayList;
import java.util.Arrays;
import net.bytebuddy.description.method.MethodDescription;
import net.bytebuddy.description.type.TypeDefinition;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.implementation.bytecode.StackManipulation;
import net.bytebuddy.implementation.bytecode.assign.Assigner;
import net.bytebuddy.matcher.ElementMatcher;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public abstract /* synthetic */ class StaticHelpers6 {
    public static final /* synthetic */ int[] a = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };

    public static FieldResolver aa(HookParam hookParam) {
        return dqc.getWrapperConfiguration(hookParam.getThisObject()).r();
    }

    public static void ab(int i, StringBuilder sb, AnnotatedOutput annotatedOutput, int i2) {
        sb.append(Hex.u4(i));
        annotatedOutput.annotate(i2, sb.toString());
    }

    public static void ac(StringBuilder sb, int i, long j) {
        sb.append(i);
        sb.append(cnb.z(j));
    }

    public static void ad(StringBuilder sb, Long l, long j) {
        sb.append(l);
        sb.append(cnb.z(j));
    }

    public static /* synthetic */ int ae(int i) {
        if (i != 0) {
            return i - 1;
        }
        throw null;
    }

    public static /* synthetic */ int[] af(int i) {
        int[] iArr = new int[i];
        System.arraycopy(a, 0, iArr, 0, i);
        return iArr;
    }

    public static int b(MethodDescription.InDefinedShape inDefinedShape, int i, int i2) {
        return (inDefinedShape.hashCode() + i) * i2;
    }

    public static int c(MethodDescription methodDescription, int i, int i2) {
        return (methodDescription.hashCode() + i) * i2;
    }

    public static int d(TypeDefinition typeDefinition, int i) {
        return typeDefinition.getStackSize().getSize() + i;
    }

    public static int e(TypeDescription.Generic generic, int i, int i2) {
        return (generic.hashCode() + i) * i2;
    }

    public static int f(TypeDescription typeDescription, int i, int i2) {
        return (typeDescription.hashCode() + i) * i2;
    }

    public static int g(StackManipulation stackManipulation, int i, int i2) {
        return (stackManipulation.hashCode() + i) * i2;
    }

    public static int h(Assigner assigner, int i, int i2) {
        return (assigner.hashCode() + i) * i2;
    }

    public static int i(ElementMatcher elementMatcher, int i, int i2) {
        return (elementMatcher.hashCode() + i) * i2;
    }

    public static long j(long j, long j2, long j3, long j4) {
        return j4 - ((j / j2) + j3);
    }

    public static View k(View view, int i, ViewGroup viewGroup, boolean z) {
        return LayoutInflater.from(view.getContext()).inflate(i, viewGroup, z);
    }

    public static Object getLastNElem(int i, ArrayList arrayList) {
        return arrayList.get(arrayList.size() - i);
    }

    public static Object resolveFirstMethod(MethodResolver methodResolverVar) {
        methodResolverVar.enableSuperclass();
        return StaticHelpers5.safeGetFirstInList(methodResolverVar.findMethods());
    }

    public static Object n(Object[] objArr, int i, MethodResolver methodResolverVar) {
        methodResolverVar.setParams(Arrays.copyOf(objArr, i));
        return StaticHelpers5.safeGetFirstInList(methodResolverVar.findMethods());
    }

    public static String o(char c, String str, String str2) {
        return str + str2 + c;
    }

    public static String p(int i, String str, String str2, int i2) {
        return str + i + str2 + i2;
    }

    public static String q(int i, StringBuilder sb) {
        sb.append(Hex.u2(i));
        return sb.toString();
    }

    public static String concatVar2Var1(Object obj, String str) {
        return str + obj;
    }

    public static String concat(String str, String str2) {
        return str + str2;
    }

    public static String concat(String str, MethodDescription methodDescription) {
        return str + methodDescription;
    }

    public static String concat(String str, TypeDescription typeDescription) {
        return str + typeDescription;
    }

    public static String concatFromSb(StringBuilder sb, int i, char c) {
        sb.append(i);
        sb.append(c);
        return sb.toString();
    }

    public static String concatFromSb(StringBuilder sb, ElementMatcher elementMatcher, String str) {
        sb.append(elementMatcher);
        sb.append(str);
        return sb.toString();
    }

    public static String concat(TypeDescription typeDescription, String str) {
        return typeDescription + str;
    }

    public static StringBuilder toSb(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        return sb;
    }

    public static StringBuilder concatAndToSb(String str, String str2, String str3) {
        StringBuilder sb = new StringBuilder(str);
        sb.append(str2);
        sb.append(str3);
        return sb;
    }
}

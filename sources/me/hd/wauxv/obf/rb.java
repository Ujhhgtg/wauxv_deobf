package me.hd.wauxv.obf;

import bsh.BshMethod;
import bsh.ClassGeneratorUtil;
import bsh.ExternalNameSpace;
import bsh.Invocable;
import bsh.NameSpace;
import bsh.Reflect;
import bsh.StringUtil;
import bsh.classpath.BshClassPath;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.IntFunction;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class rb implements IntFunction {
    public final /* synthetic */ int a;

    public /* synthetic */ rb(int i) {
        this.a = i;
    }

    @Override // java.util.function.IntFunction
    public final Object apply(int i) {
        switch (this.a) {
            case 0:
                return BshClassPath.lambda$searchJarFSForClasses$8(i);
            case 1:
                return BshClassPath.lambda$searchJrtFSForClasses$7(i);
            case 2:
                return BshMethod.lambda$getParameterNames$1(i);
            case 3:
                return ClassGeneratorUtil.lambda$checkAbstractMethodImplementation$3(i);
            case 4:
                return ExternalNameSpace.lambda$getVariableNames$0(i);
            case 5:
                return Invocable.lambda$getParamTypeDescriptors$0(i);
            case 6:
                return NameSpace.lambda$getVariables$1(i);
            case 7:
                return NameSpace.lambda$getDeclaredVariables$5(i);
            case 8:
                return NameSpace.lambda$getVariableNames$0(i);
            case 9:
                return NameSpace.lambda$getMethods$4(i);
            case 10:
                return NameSpace.lambda$getMethodNames$2(i);
            case 11:
                return new AtomicInteger(i);
            case 12:
                return Reflect.lambda$constructObject$1(i);
            case 13:
                return Reflect.lambda$getVariables$5(i);
            case 14:
                return Reflect.lambda$getVariableNames$3(i);
            case 15:
                return StringUtil.lambda$getTypeNames$2(i);
            default:
                return StringUtil.lambda$getTypeNames$0(i);
        }
    }
}

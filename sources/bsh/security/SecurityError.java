package bsh.security;

import bsh.CallStack;
import bsh.EvalError;
import bsh.Node;
import bsh.Reflect;
import bsh.UtilEvalError;
import me.hd.wauxv.obf.yg;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public class SecurityError extends UtilEvalError {
    public SecurityError(String str) {
        super(yg.concat("SecurityError: ", str));
    }

    private static String argsTypesString(Object[] objArr) {
        String[] strArr = new String[objArr.length];
        for (int i = 0; i < objArr.length; i++) {
            Class<?> type = Reflect.getType(objArr[i]);
            strArr[i] = type != null ? type.getTypeName() : "null";
        }
        return String.join(", ", strArr);
    }

    public static SecurityError cantConstruct(Class<?> cls, Object[] objArr) {
        return new SecurityError("Can't call this construct: new " + cls.getName() + "(" + argsTypesString(objArr) + ")");
    }

    public static SecurityError cantExtends(Class<?> cls) {
        return new SecurityError("Can't extend this class: ".concat(cls.getName()));
    }

    public static SecurityError cantGetField(Object obj, String str) {
        return new SecurityError("Can't get this field: " + obj.getClass().getTypeName() + "." + str);
    }

    public static SecurityError cantGetStaticField(Class<?> cls, String str) {
        return new SecurityError("Can't get this static field: " + cls.getTypeName() + "." + str);
    }

    public static SecurityError cantImplements(Class<?> cls) {
        return new SecurityError("Can't implement this interface: ".concat(cls.getName()));
    }

    public static SecurityError cantInvokeLocalMethod(String str, Object[] objArr) {
        return new SecurityError("Can't invoke this local method: " + str + "(" + argsTypesString(objArr) + ")");
    }

    public static SecurityError cantInvokeMethod(Object obj, String str, Object[] objArr) {
        String typeName = obj.getClass().getTypeName();
        String strArgsTypesString = argsTypesString(objArr);
        StringBuilder sb = new StringBuilder("Can't invoke this method: ");
        sb.append(typeName);
        sb.append(".");
        sb.append(str);
        sb.append("(");
        return new SecurityError(yg.concatToVar1(sb, strArgsTypesString, ")"));
    }

    public static SecurityError cantInvokeStaticMethod(Class<?> cls, String str, Object[] objArr) {
        String typeName = cls.getTypeName();
        String strArgsTypesString = argsTypesString(objArr);
        StringBuilder sb = new StringBuilder("Can't invoke this static method: ");
        sb.append(typeName);
        sb.append(".");
        sb.append(str);
        sb.append("(");
        return new SecurityError(yg.concatToVar1(sb, strArgsTypesString, ")"));
    }

    public static SecurityError reflectCantConstruct(Class<?> cls, Object[] objArr) {
        return new SecurityError("Can't call this construct using reflection: new " + cls.getName() + "(" + argsTypesString(objArr) + ")");
    }

    public static SecurityError reflectCantGetField(Object obj, String str) {
        return new SecurityError("Can't get this field using reflection: " + obj.getClass().getTypeName() + "." + str);
    }

    public static SecurityError reflectCantGetStaticField(Class<?> cls, String str) {
        return new SecurityError("Can't get this static field using reflection: " + cls.getTypeName() + "." + str);
    }

    public static SecurityError reflectCantInvokeMethod(Object obj, String str, Object[] objArr) {
        String typeName = obj.getClass().getTypeName();
        String strArgsTypesString = argsTypesString(objArr);
        StringBuilder sb = new StringBuilder("Can't invoke this method using reflection: ");
        sb.append(typeName);
        sb.append(".");
        sb.append(str);
        sb.append("(");
        return new SecurityError(yg.concatToVar1(sb, strArgsTypesString, ")"));
    }

    public static SecurityError reflectCantInvokeStaticMethod(Class<?> cls, String str, Object[] objArr) {
        String typeName = cls.getTypeName();
        String strArgsTypesString = argsTypesString(objArr);
        StringBuilder sb = new StringBuilder("Can't invoke this static method using reflection: ");
        sb.append(typeName);
        sb.append(".");
        sb.append(str);
        sb.append("(");
        return new SecurityError(yg.concatToVar1(sb, strArgsTypesString, ")"));
    }

    @Override // bsh.UtilEvalError
    public EvalError toEvalError(String str, Node node, CallStack callStack) {
        return new EvalError(getMessage(), node, callStack);
    }

    @Override // bsh.UtilEvalError
    public EvalError toEvalError(Node node, CallStack callStack) {
        return new EvalError(getMessage(), node, callStack);
    }
}

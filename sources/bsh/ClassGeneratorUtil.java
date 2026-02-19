package bsh;

import bsh.org.objectweb.asm.ClassWriter;
import bsh.org.objectweb.asm.Label;
import bsh.org.objectweb.asm.MethodVisitor;
import bsh.org.objectweb.asm.Opcodes;
import bsh.org.objectweb.asm.Type;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import me.hd.wauxv.obf.dkz;
import me.hd.wauxv.obf.ok;
import me.hd.wauxv.obf.ra;
import me.hd.wauxv.obf.rb;
import me.hd.wauxv.obf.yg;
import me.hd.wauxv.obf.yz;
import me.hd.wauxv.obf.za;
import net.bytebuddy.description.method.MethodDescription;
import net.bytebuddy.pool.TypePool;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public class ClassGeneratorUtil implements Opcodes {
    static final int ACCESS_MODIFIERS = 7;
    static final int DEFAULTCONSTRUCTOR = -1;
    private static final String OBJECT = "Ljava/lang/Object;";
    private final String classDescript;
    private final Modifiers classModifiers;
    private final String className;
    private final DelayedEvalBshMethod[] constructors;
    private final String fqClassName;
    private final Class<?>[] interfaces;
    private final DelayedEvalBshMethod[] methods;
    private final Class<?> superClass;
    private final String superClassName;
    private final ClassGenerator.Type type;
    private final String uuid;
    private final Variable[] vars;

    public ClassGeneratorUtil(Modifiers modifiers, String str, String str2, Class<?> cls, Class<?>[] clsArr, Variable[] variableArr, DelayedEvalBshMethod[] delayedEvalBshMethodArr, NameSpace nameSpace, ClassGenerator.Type type) {
        this.classModifiers = modifiers;
        this.className = str;
        this.type = type;
        if (str2 != null) {
            this.fqClassName = str2.replace(TypePool.Default.LazyTypeDescription.GenericTypeToken.INNER_CLASS_PATH, '/') + "/" + str;
        } else {
            this.fqClassName = str;
        }
        this.classDescript = "L" + this.fqClassName.replace(TypePool.Default.LazyTypeDescription.GenericTypeToken.INNER_CLASS_PATH, '/') + ";";
        cls = cls == null ? type == ClassGenerator.Type.ENUM ? Enum.class : Object.class : cls;
        this.superClass = cls;
        this.superClassName = Type.getInternalName(cls);
        this.interfaces = clsArr == null ? Reflect.ZERO_TYPES : clsArr;
        this.vars = variableArr;
        nameSpace.isInterface = type == ClassGenerator.Type.INTERFACE;
        nameSpace.isEnum = type == ClassGenerator.Type.ENUM;
        Map<String, NameSpace> map = This.contextStore;
        String string = UUID.randomUUID().toString();
        this.uuid = string;
        map.put(string, nameSpace);
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        String baseName = Types.getBaseName(str);
        for (DelayedEvalBshMethod delayedEvalBshMethod : delayedEvalBshMethodArr) {
            if (delayedEvalBshMethod.getName().equals(baseName)) {
                if (!delayedEvalBshMethod.modifiers.isAppliedContext(5)) {
                    delayedEvalBshMethod.modifiers.changeContext(5);
                }
                arrayList.add(delayedEvalBshMethod);
            } else {
                arrayList2.add(delayedEvalBshMethod);
            }
        }
        this.constructors = (DelayedEvalBshMethod[]) arrayList.toArray(new DelayedEvalBshMethod[arrayList.size()]);
        this.methods = (DelayedEvalBshMethod[]) arrayList2.toArray(new DelayedEvalBshMethod[arrayList2.size()]);
        Interpreter.debug("Generate class ", type, " ", this.fqClassName, " cons:", Integer.valueOf(arrayList.size()), " meths:", Integer.valueOf(arrayList2.size()), " vars:", Integer.valueOf(variableArr.length));
        if (type == ClassGenerator.Type.INTERFACE && !modifiers.hasModifier("abstract")) {
            modifiers.addModifier("abstract");
        }
        if (type != ClassGenerator.Type.ENUM || modifiers.hasModifier("static")) {
            return;
        }
        modifiers.addModifier("static");
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [bsh.ClassGeneratorUtil$1Reflector] */
    public static void checkAbstractMethodImplementation(Class<?> cls) {
        final ArrayList arrayList = new ArrayList();
        new Object() { // from class: bsh.ClassGeneratorUtil.1Reflector
            public void gatherMethods(Class<?> cls2) {
                if (cls2.getSuperclass() != null) {
                    gatherMethods(cls2.getSuperclass());
                }
                arrayList.addAll(Arrays.asList(cls2.getDeclaredMethods()));
                for (Class<?> cls3 : cls2.getInterfaces()) {
                    gatherMethods(cls3);
                }
            }
        }.gatherMethods(cls);
        arrayList.stream().filter(new ra(3)).forEach(new ok(arrayList, cls));
    }

    public static boolean checkInheritanceRules(int i, int i2, Class<?> cls) {
        int i3 = i & 7;
        int i4 = i2 & 7;
        if (i4 == i3 || i3 == 2 || i4 == 1 || (i3 == 0 && i4 != 2)) {
            return true;
        }
        throw new RuntimeException("Cannot reduce the visibility of the inherited method from ".concat(cls.getName()));
    }

    public static Method classContainsMethod(Class<?> cls, String str, String[] strArr) {
        while (cls != null) {
            for (Method method : cls.getDeclaredMethods()) {
                if (method.getName().equals(str) && strArr.length == method.getParameterCount()) {
                    String[] typeDescriptors = getTypeDescriptors(method.getParameterTypes());
                    boolean zEquals = true;
                    for (int i = 0; i < strArr.length && (zEquals = strArr[i].equals(typeDescriptors[i])); i++) {
                    }
                    if (zEquals) {
                        return method;
                    }
                }
            }
            cls = cls.getSuperclass();
        }
        return null;
    }

    private static String descriptorToClassName(String str) {
        return (str.startsWith("[") || !str.startsWith("L")) ? str : yg.j(str, 1, 1);
    }

    /* JADX WARN: Found duplicated region for block: B:32:0x007c  */
    /* JADX WARN: Found duplicated region for block: B:33:0x007f  */
    /* JADX WARN: Found duplicated region for block: B:36:0x0094  */
    /* JADX WARN: Found duplicated region for block: B:42:0x009d A[SYNTHETIC] */
    private void doSwitchBranch(int i, String str, String[] strArr, Label label, Label[] labelArr, int i2, MethodVisitor methodVisitor) {
        int i3;
        String str2;
        String str3;
        methodVisitor.visitLabel(labelArr[i]);
        methodVisitor.visitVarInsn(25, 0);
        for (String str4 : strArr) {
            if (str4.equals("Z")) {
                str3 = "getBoolean";
            } else if (str4.equals("B")) {
                str3 = "getByte";
            } else if (str4.equals("C")) {
                str3 = "getChar";
            } else if (str4.equals("S")) {
                str3 = "getShort";
            } else if (str4.equals("I")) {
                str3 = "getInt";
            } else if (str4.equals("J")) {
                str3 = "getLong";
            } else if (str4.equals("D")) {
                str3 = "getDouble";
            } else {
                if (str4.equals("F")) {
                    str3 = "getFloat";
                } else {
                    i3 = i2;
                    str2 = "getObject";
                }
                methodVisitor.visitVarInsn(25, i3);
                methodVisitor.visitMethodInsn(182, "bsh/This$ConstructorArgs", str2, "()".concat(str2.equals("getObject") ? "Ljava/lang/Object;" : str4), false);
                if (str2.equals("getObject")) {
                    methodVisitor.visitTypeInsn(192, descriptorToClassName(str4));
                }
            }
            i3 = i2;
            str2 = str3;
            methodVisitor.visitVarInsn(25, i3);
            methodVisitor.visitMethodInsn(182, "bsh/This$ConstructorArgs", str2, "()".concat(str2.equals("getObject") ? "Ljava/lang/Object;" : str4), false);
            if (str2.equals("getObject")) {
                methodVisitor.visitTypeInsn(192, descriptorToClassName(str4));
            }
        }
        methodVisitor.visitMethodInsn(183, str, MethodDescription.CONSTRUCTOR_INTERNAL_NAME, getMethodDescriptor("V", strArr), false);
        methodVisitor.visitJumpInsn(167, label);
    }

    private void generateEnumStaticInit(String str, String str2, MethodVisitor methodVisitor) {
        String str3;
        MethodVisitor methodVisitor2;
        int i;
        Variable[] variableArr = this.vars;
        int length = variableArr.length;
        int i2 = 3;
        int i3 = 0;
        while (i3 < length) {
            Variable variable = variableArr[i3];
            if (variable.hasModifier("enum")) {
                methodVisitor.visitTypeInsn(187, str);
                methodVisitor.visitInsn(89);
                methodVisitor.visitLdcInsn(variable.getName());
                if (8 >= i2) {
                    i = i2 + 1;
                    methodVisitor.visitInsn(i2);
                } else {
                    i = i2 + 1;
                    methodVisitor.visitIntInsn(16, i2 - 3);
                }
                str3 = str;
                methodVisitor2 = methodVisitor;
                methodVisitor2.visitMethodInsn(183, str3, MethodDescription.CONSTRUCTOR_INTERNAL_NAME, "(Ljava/lang/String;I)V", false);
                methodVisitor2.visitFieldInsn(179, str3, variable.getName(), str2);
                i2 = i;
            } else {
                str3 = str;
                methodVisitor2 = methodVisitor;
            }
            i3++;
            methodVisitor = methodVisitor2;
            str = str3;
        }
    }

    private void generateEnumSupport(String str, String str2, String str3, ClassWriter classWriter) {
        MethodVisitor methodVisitorVisitMethod = classWriter.visitMethod(9, "values", yg.k("()[", str3), null, null);
        pushBshStatic(str, str2, methodVisitorVisitMethod);
        methodVisitorVisitMethod.visitMethodInsn(182, "bsh/This", "enumValues", "()[Ljava/lang/Object;", false);
        generatePlainReturnCode(yg.k("[", str3), methodVisitorVisitMethod);
        methodVisitorVisitMethod.visitMaxs(0, 0);
        MethodVisitor methodVisitorVisitMethod2 = classWriter.visitMethod(9, "valueOf", "(Ljava/lang/String;)" + str3, null, null);
        methodVisitorVisitMethod2.visitLdcInsn(Type.getType(str3));
        methodVisitorVisitMethod2.visitVarInsn(25, 0);
        methodVisitorVisitMethod2.visitMethodInsn(184, "java/lang/Enum", "valueOf", "(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;", false);
        generatePlainReturnCode(str3, methodVisitorVisitMethod2);
        methodVisitorVisitMethod2.visitMaxs(0, 0);
        MethodVisitor methodVisitorVisitMethod3 = classWriter.visitMethod(2, MethodDescription.CONSTRUCTOR_INTERNAL_NAME, "(Ljava/lang/String;I)V", null, null);
        methodVisitorVisitMethod3.visitVarInsn(25, 0);
        methodVisitorVisitMethod3.visitVarInsn(25, 1);
        methodVisitorVisitMethod3.visitVarInsn(21, 2);
        methodVisitorVisitMethod3.visitMethodInsn(183, "java/lang/Enum", MethodDescription.CONSTRUCTOR_INTERNAL_NAME, "(Ljava/lang/String;I)V", false);
        methodVisitorVisitMethod3.visitVarInsn(25, 0);
        methodVisitorVisitMethod3.visitLdcInsn(str2);
        generateParameterReifierCode(new String[0], false, methodVisitorVisitMethod3);
        methodVisitorVisitMethod3.visitMethodInsn(184, "bsh/This", "initInstance", "(Lbsh/GeneratedClass;Ljava/lang/String;[Ljava/lang/Object;)V", false);
        methodVisitorVisitMethod3.visitInsn(177);
        methodVisitorVisitMethod3.visitMaxs(0, 0);
    }

    private static void generateField(String str, String str2, int i, ClassWriter classWriter) {
        generateField(str, str2, i, null, classWriter);
    }

    private void generateMethod(String str, String str2, String str3, String str4, String[] strArr, int i, ClassWriter classWriter) {
        boolean z = (i & 8) != 0;
        String str5 = str4 == null ? "Ljava/lang/Object;" : str4;
        MethodVisitor methodVisitorVisitMethod = classWriter.visitMethod(i, str3, getMethodDescriptor(str5, strArr), getTypeParameterSignature(strArr), null);
        if ((i & 1024) != 0) {
            return;
        }
        if (z || this.type == ClassGenerator.Type.INTERFACE) {
            pushBshStatic(str2, str, methodVisitorVisitMethod);
        } else {
            pushBshThis(str2, str, methodVisitorVisitMethod);
        }
        methodVisitorVisitMethod.visitLdcInsn(str3);
        generateParameterReifierCode(strArr, z, methodVisitorVisitMethod);
        methodVisitorVisitMethod.visitInsn(4);
        methodVisitorVisitMethod.visitMethodInsn(182, "bsh/This", "invokeMethod", "(Ljava/lang/String;[Ljava/lang/Object;Z)Ljava/lang/Object;", false);
        generateReturnCode(str5, methodVisitorVisitMethod);
        methodVisitorVisitMethod.visitMaxs(0, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r19v0, types: [bsh.org.objectweb.asm.MethodVisitor] */
    /* JADX WARN: Type inference failed for: r9v0 */
    /* JADX WARN: Type inference failed for: r9v1, types: [int] */
    /* JADX WARN: Type inference failed for: r9v3 */
    private void generateParameterReifierCode(String[] strArr, boolean z, MethodVisitor methodVisitor) {
        methodVisitor.visitIntInsn(17, strArr.length);
        methodVisitor.visitTypeInsn(189, "java/lang/Object");
        ?? r9 = !z;
        int i = 0;
        while (i < strArr.length) {
            String str = strArr[i];
            methodVisitor.visitInsn(89);
            methodVisitor.visitIntInsn(17, i);
            if (isPrimitive(str)) {
                int i2 = str.equals("F") ? 23 : str.equals("D") ? 24 : str.equals("J") ? 22 : 21;
                methodVisitor.visitTypeInsn(187, "bsh/Primitive");
                methodVisitor.visitInsn(89);
                methodVisitor.visitVarInsn(i2, r9);
                methodVisitor.visitMethodInsn(183, "bsh/Primitive", MethodDescription.CONSTRUCTOR_INTERNAL_NAME, yg.concatToVar1(new StringBuilder("("), str, ")V"), false);
                methodVisitor.visitInsn(83);
            } else {
                methodVisitor.visitVarInsn(25, r9);
                Label label = new Label();
                methodVisitor.visitJumpInsn(199, label);
                methodVisitor.visitFieldInsn(178, "bsh/Primitive", "NULL", "Lbsh/Primitive;");
                methodVisitor.visitInsn(83);
                Label label2 = new Label();
                methodVisitor.visitJumpInsn(167, label2);
                methodVisitor.visitLabel(label);
                methodVisitor.visitVarInsn(25, r9);
                methodVisitor.visitInsn(83);
                methodVisitor.visitLabel(label2);
            }
            i++;
            r9 += (str.equals("D") || str.equals("J")) ? 2 : 1;
        }
    }

    private static void generatePlainReturnCode(String str, MethodVisitor methodVisitor) {
        if (str.equals("V")) {
            methodVisitor.visitInsn(177);
        } else if (isPrimitive(str)) {
            methodVisitor.visitInsn(str.equals("D") ? 175 : str.equals("F") ? 174 : str.equals("J") ? 173 : 172);
        } else {
            methodVisitor.visitTypeInsn(192, descriptorToClassName(str));
            methodVisitor.visitInsn(176);
        }
    }

    private void generateReturnCode(String str, MethodVisitor methodVisitor) {
        String str2;
        String str3;
        if (str.equals("V")) {
            methodVisitor.visitInsn(87);
            methodVisitor.visitInsn(177);
            return;
        }
        if (!isPrimitive(str)) {
            methodVisitor.visitTypeInsn(192, descriptorToClassName(str));
            methodVisitor.visitInsn(176);
            return;
        }
        int i = 172;
        if (str.equals("Z")) {
            str2 = "java/lang/Boolean";
            str3 = "booleanValue";
        } else if (str.equals("C")) {
            str2 = "java/lang/Character";
            str3 = "charValue";
        } else if (str.equals("B")) {
            str2 = "java/lang/Byte";
            str3 = "byteValue";
        } else if (str.equals("S")) {
            str2 = "java/lang/Short";
            str3 = "shortValue";
        } else if (str.equals("F")) {
            i = 174;
            str2 = "java/lang/Float";
            str3 = "floatValue";
        } else if (str.equals("J")) {
            i = 173;
            str2 = "java/lang/Long";
            str3 = "longValue";
        } else if (str.equals("D")) {
            i = 175;
            str2 = "java/lang/Double";
            str3 = "doubleValue";
        } else {
            str2 = "java/lang/Integer";
            str3 = "intValue";
        }
        String str4 = str2;
        String str5 = str3;
        methodVisitor.visitTypeInsn(192, str4);
        methodVisitor.visitMethodInsn(182, str4, str5, "()".concat(str), false);
        methodVisitor.visitInsn(i);
    }

    private void generateSuperDelegateMethod(Class<?> cls, String str, String str2, String str3, String[] strArr, int i, ClassWriter classWriter) {
        if (str3 == null) {
            str3 = "Ljava/lang/Object;";
        }
        String methodDescriptor = getMethodDescriptor(str3, strArr);
        MethodVisitor methodVisitorVisitMethod = classWriter.visitMethod(i, "_bshSuper" + cls.getSimpleName() + str2, methodDescriptor, getTypeParameterSignature(strArr), null);
        methodVisitorVisitMethod.visitVarInsn(25, 0);
        int length = strArr.length;
        int i2 = 1;
        for (int i3 = 0; i3 < length; i3++) {
            String str4 = strArr[i3];
            if (isPrimitive(str4)) {
                methodVisitorVisitMethod.visitVarInsn(21, i2);
            } else {
                methodVisitorVisitMethod.visitVarInsn(25, i2);
            }
            i2 += (str4.equals("D") || str4.equals("J")) ? 2 : 1;
        }
        methodVisitorVisitMethod.visitMethodInsn(183, str, str2, methodDescriptor, false);
        generatePlainReturnCode(str3, methodVisitorVisitMethod);
        methodVisitorVisitMethod.visitMaxs(0, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v17 */
    /* JADX WARN: Type inference failed for: r1v18 */
    /* JADX WARN: Type inference failed for: r1v19 */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v20 */
    /* JADX WARN: Type inference failed for: r1v21 */
    /* JADX WARN: Type inference failed for: r1v22 */
    /* JADX WARN: Type inference failed for: r1v23 */
    /* JADX WARN: Type inference failed for: r1v24 */
    /* JADX WARN: Type inference failed for: r1v25 */
    /* JADX WARN: Type inference failed for: r1v26 */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v5, types: [int] */
    private static int getASMModifiers(Modifiers modifiers) {
        boolean zHasModifier = modifiers.hasModifier(1);
        ?? r1 = zHasModifier;
        if (modifiers.hasModifier(2)) {
            r1 = (zHasModifier ? 1 : 0) | 2;
        }
        ?? r12 = r1;
        if (modifiers.hasModifier(4)) {
            r12 = (r1 == true ? 1 : 0) | 4;
        }
        ?? r13 = r12;
        if (modifiers.hasModifier(8)) {
            r13 = (r12 == true ? 1 : 0) | 8;
        }
        ?? r14 = r13;
        if (modifiers.hasModifier(32)) {
            r14 = (r13 == true ? 1 : 0) | 32;
        }
        ?? r15 = r14;
        if (modifiers.hasModifier(1024)) {
            r15 = (r14 == true ? 1 : 0) | 1024;
        }
        if ((modifiers.getModifiers() & 7) != 0) {
            return r15;
        }
        int i = r15 | 1;
        modifiers.addModifier(1);
        return i;
    }

    private static String getMethodDescriptor(String str, String[] strArr) {
        StringBuilder sb = new StringBuilder("(");
        for (String str2 : strArr) {
            sb.append(str2);
        }
        sb.append(')');
        sb.append(str);
        return sb.toString();
    }

    public static String[] getTypeDescriptors(Class<?>[] clsArr) {
        int length = clsArr.length;
        String[] strArr = new String[length];
        for (int i = 0; i < length; i++) {
            strArr[i] = BSHType.getTypeDescriptor(clsArr[i]);
        }
        return strArr;
    }

    private static String getTypeParameterSignature(String[] strArr) {
        StringBuilder sb = new StringBuilder("<");
        for (String str : strArr) {
            sb.append(str);
            sb.append(":");
        }
        return sb.toString();
    }

    private static boolean isPrimitive(String str) {
        return str.length() == 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$checkAbstractMethodImplementation$0(Method method) {
        return (method.getModifiers() & 1024) > 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$checkAbstractMethodImplementation$1(Method method, Method method2) {
        return method.getName().equals(method2.getName()) && (method2.getModifiers() & 1026) == 0 && Types.areSignaturesEqual(method.getParameterTypes(), method2.getParameterTypes());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int lambda$checkAbstractMethodImplementation$2(Method method, Method method2) {
        if ((method.getModifiers() & 1) > 0 || (method2.getModifiers() & 5) == 0) {
            return -1;
        }
        return (method.getModifiers() & 7) == (method2.getModifiers() & 7) ? 0 : 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Method[] lambda$checkAbstractMethodImplementation$3(int i) {
        return new Method[i];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$checkAbstractMethodImplementation$4(List list, Class cls, Method method) {
        int i = 0;
        Method[] methodArr = (Method[]) list.stream().filter(new yz(method, i)).sorted(new za(i)).toArray(new rb(3));
        if (methodArr.length != 0 || Reflect.getClassModifiers(cls).hasModifier("abstract")) {
            if (methodArr.length > 0) {
                checkInheritanceRules(method.getModifiers(), methodArr[0].getModifiers(), method.getDeclaringClass());
            }
        } else {
            throw new RuntimeException(cls.getSimpleName() + " is not abstract and does not override abstract method " + method.getName() + "() in " + method.getDeclaringClass().getSimpleName());
        }
    }

    private static void pushBshStatic(String str, String str2, MethodVisitor methodVisitor) {
        methodVisitor.visitFieldInsn(178, str, This.Keys.BSHSTATIC + str2, "Lbsh/This;");
    }

    private static void pushBshThis(String str, String str2, MethodVisitor methodVisitor) {
        methodVisitor.visitVarInsn(25, 0);
        methodVisitor.visitFieldInsn(180, str, This.Keys.BSHTHIS + str2, "Lbsh/This;");
    }

    public static void startInterpreterForClass(Class<?> cls) {
        String strSuffix = Name.suffix(cls.getName(), 1);
        String strS = dkz.s(strSuffix, ".bsh");
        if (cls.getResource(strS) == null) {
            throw new InterpreterError("Script (" + strS + ") for BeanShell generated class: " + cls + " not found.");
        }
        try {
            try {
                FileReader fileReader = new FileReader(cls.getResourceAsStream(strS));
                try {
                    Interpreter interpreter = new Interpreter();
                    NameSpace nameSpace = interpreter.getNameSpace();
                    nameSpace.setName("class_" + strSuffix + "_global");
                    nameSpace.getClassManager().associateClass(cls);
                    interpreter.eval(fileReader, nameSpace, strS);
                    fileReader.close();
                } catch (Throwable th) {
                    try {
                        fileReader.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                    throw th;
                }
            } catch (EvalError | IOException e) {
                System.out.println("Evaluation Error: " + e);
            }
        } catch (TargetError e2) {
            System.out.println("Script threw exception: " + e2);
            if (e2.inNativeCode()) {
                e2.printStackTrace(System.err);
            }
        }
    }

    public byte[] generateClass() {
        int i;
        Class<?>[] clsArr;
        ClassGeneratorUtil classGeneratorUtil = this;
        NameSpace nameSpace = This.contextStore.get(classGeneratorUtil.uuid);
        int aSMModifiers = getASMModifiers(classGeneratorUtil.classModifiers);
        ClassGenerator.Type type = classGeneratorUtil.type;
        if (type == ClassGenerator.Type.INTERFACE) {
            i = aSMModifiers | 1537;
        } else if (type == ClassGenerator.Type.ENUM) {
            i = aSMModifiers | 16433;
        } else {
            i = aSMModifiers | 33;
            if ((i & 1024) > 0) {
                i -= 1024;
            }
        }
        int i2 = i;
        String[] strArr = new String[classGeneratorUtil.interfaces.length + 1];
        int i3 = 0;
        while (true) {
            clsArr = classGeneratorUtil.interfaces;
            if (i3 >= clsArr.length) {
                break;
            }
            strArr[i3] = Type.getInternalName(clsArr[i3]);
            if (Reflect.isGeneratedClass(classGeneratorUtil.interfaces[i3])) {
                for (Variable variable : Reflect.getVariables(classGeneratorUtil.interfaces[i3])) {
                    nameSpace.setVariableImpl(variable);
                }
            }
            i3++;
        }
        strArr[clsArr.length] = Type.getInternalName(GeneratedClass.class);
        ClassWriter classWriter = new ClassWriter(2);
        classWriter.visit(52, i2, classGeneratorUtil.fqClassName, classGeneratorUtil.type == ClassGenerator.Type.ENUM ? yg.concatToVar1(new StringBuilder("Ljava/lang/Enum<"), classGeneratorUtil.classDescript, ">;") : null, classGeneratorUtil.superClassName, strArr);
        if (classGeneratorUtil.type != ClassGenerator.Type.INTERFACE) {
            generateField(This.Keys.BSHTHIS + classGeneratorUtil.className, "Lbsh/This;", 1, classWriter);
        }
        generateField(This.Keys.BSHSTATIC + classGeneratorUtil.className, "Lbsh/This;", 25, classWriter);
        generateField("UUID", "Ljava/lang/String;", 25, classGeneratorUtil.uuid, classWriter);
        for (Variable variable2 : classGeneratorUtil.vars) {
            if (!variable2.hasModifier("private")) {
                String typeDescriptor = variable2.getTypeDescriptor();
                int aSMModifiers2 = getASMModifiers(variable2.getModifiers());
                ClassGenerator.Type type2 = classGeneratorUtil.type;
                if (type2 == ClassGenerator.Type.INTERFACE) {
                    variable2.setConstant();
                    nameSpace.setVariableImpl(variable2);
                } else {
                    if (type2 == ClassGenerator.Type.ENUM && variable2.hasModifier("enum")) {
                        aSMModifiers2 |= 16400;
                        typeDescriptor = classGeneratorUtil.classDescript;
                    }
                    generateField(variable2.getName(), typeDescriptor, aSMModifiers2, classWriter);
                }
            }
        }
        if (classGeneratorUtil.type == ClassGenerator.Type.ENUM) {
            classGeneratorUtil.generateEnumSupport(classGeneratorUtil.fqClassName, classGeneratorUtil.className, classGeneratorUtil.classDescript, classWriter);
        }
        classGeneratorUtil.generateStaticInitializer(classWriter);
        int i4 = 0;
        boolean z = false;
        while (true) {
            DelayedEvalBshMethod[] delayedEvalBshMethodArr = classGeneratorUtil.constructors;
            if (i4 >= delayedEvalBshMethodArr.length) {
                break;
            }
            if (!delayedEvalBshMethodArr[i4].hasModifier("private")) {
                int aSMModifiers3 = getASMModifiers(classGeneratorUtil.constructors[i4].getModifiers());
                if (classGeneratorUtil.constructors[i4].isVarArgs()) {
                    aSMModifiers3 |= 128;
                }
                classGeneratorUtil.generateConstructor(i4, classGeneratorUtil.constructors[i4].getParamTypeDescriptors(), aSMModifiers3, classWriter);
                z = true;
            }
            i4++;
        }
        if (classGeneratorUtil.type == ClassGenerator.Type.CLASS && !z) {
            classGeneratorUtil.generateConstructor(-1, new String[0], 1, classWriter);
        }
        DelayedEvalBshMethod[] delayedEvalBshMethodArr2 = classGeneratorUtil.methods;
        int length = delayedEvalBshMethodArr2.length;
        int i5 = 0;
        while (i5 < length) {
            DelayedEvalBshMethod delayedEvalBshMethod = delayedEvalBshMethodArr2[i5];
            if (!delayedEvalBshMethod.hasModifier("private")) {
                if (classGeneratorUtil.type == ClassGenerator.Type.INTERFACE && !delayedEvalBshMethod.hasModifier("static") && !delayedEvalBshMethod.hasModifier("default") && !delayedEvalBshMethod.hasModifier("abstract")) {
                    delayedEvalBshMethod.getModifiers().addModifier("abstract");
                }
                int aSMModifiers4 = getASMModifiers(delayedEvalBshMethod.getModifiers());
                if (delayedEvalBshMethod.isVarArgs()) {
                    aSMModifiers4 |= 128;
                }
                int i6 = aSMModifiers4;
                boolean z2 = (i6 & 8) > 0;
                classGeneratorUtil.generateMethod(classGeneratorUtil.className, classGeneratorUtil.fqClassName, delayedEvalBshMethod.getName(), delayedEvalBshMethod.getReturnTypeDescriptor(), delayedEvalBshMethod.getParamTypeDescriptors(), i6, classWriter);
                if (classContainsMethod(classGeneratorUtil.superClass, delayedEvalBshMethod.getName(), delayedEvalBshMethod.getParamTypeDescriptors()) != null && !z2) {
                    classGeneratorUtil.generateSuperDelegateMethod(classGeneratorUtil.superClass, classGeneratorUtil.superClassName, delayedEvalBshMethod.getName(), delayedEvalBshMethod.getReturnTypeDescriptor(), delayedEvalBshMethod.getParamTypeDescriptors(), 1, classWriter);
                }
            }
            i5++;
            classGeneratorUtil = this;
        }
        return classWriter.toByteArray();
    }

    public void generateConstructor(int i, String[] strArr, int i2, ClassWriter classWriter) {
        int length = strArr.length + 1;
        int length2 = strArr.length + 2;
        MethodVisitor methodVisitorVisitMethod = classWriter.visitMethod(i2, MethodDescription.CONSTRUCTOR_INTERNAL_NAME, getMethodDescriptor("V", strArr), getTypeParameterSignature(strArr), null);
        generateParameterReifierCode(strArr, false, methodVisitorVisitMethod);
        methodVisitorVisitMethod.visitVarInsn(58, length);
        generateConstructorSwitch(i, length, length2, methodVisitorVisitMethod);
        methodVisitorVisitMethod.visitVarInsn(25, 0);
        methodVisitorVisitMethod.visitLdcInsn(this.className);
        methodVisitorVisitMethod.visitVarInsn(25, length);
        methodVisitorVisitMethod.visitMethodInsn(184, "bsh/This", "initInstance", "(Lbsh/GeneratedClass;Ljava/lang/String;[Ljava/lang/Object;)V", false);
        methodVisitorVisitMethod.visitInsn(177);
        methodVisitorVisitMethod.visitMaxs(0, 0);
    }

    public void generateConstructorSwitch(int i, int i2, int i3, MethodVisitor methodVisitor) {
        int i4 = i3;
        MethodVisitor methodVisitor2 = methodVisitor;
        Label label = new Label();
        Label label2 = new Label();
        List<Invocable> listMembers = BshClassManager.memberCache.get(this.superClass).members(this.superClass.getName());
        int size = listMembers.size() + this.constructors.length;
        Label[] labelArr = new Label[size];
        for (int i5 = 0; i5 < size; i5++) {
            labelArr[i5] = new Label();
        }
        methodVisitor2.visitLdcInsn(Type.getType(BSHType.getTypeDescriptor(this.superClass)));
        pushBshStatic(this.fqClassName, this.className, methodVisitor2);
        int i6 = 25;
        methodVisitor2.visitVarInsn(25, i2);
        methodVisitor2.visitIntInsn(16, i);
        methodVisitor2.visitMethodInsn(184, "bsh/This", "getConstructorArgs", "(Ljava/lang/Class;Lbsh/This;[Ljava/lang/Object;I)Lbsh/This$ConstructorArgs;", false);
        methodVisitor2.visitVarInsn(58, i4);
        methodVisitor2.visitVarInsn(25, i4);
        methodVisitor2.visitFieldInsn(180, "bsh/This$ConstructorArgs", "selector", "I");
        methodVisitor2.visitTableSwitchInsn(0, size - 1, label, labelArr);
        int i7 = 0;
        int i8 = 0;
        while (i8 < listMembers.size()) {
            doSwitchBranch(i7, this.superClassName, listMembers.get(i8).getParamTypeDescriptors(), label2, labelArr, i4, methodVisitor2);
            i8++;
            i7++;
            i4 = i3;
            methodVisitor2 = methodVisitor;
            i6 = i6;
        }
        int i9 = i6;
        int i10 = 0;
        while (true) {
            DelayedEvalBshMethod[] delayedEvalBshMethodArr = this.constructors;
            if (i10 >= delayedEvalBshMethodArr.length) {
                methodVisitor.visitLabel(label);
                methodVisitor.visitVarInsn(i9, 0);
                methodVisitor.visitMethodInsn(183, this.superClassName, MethodDescription.CONSTRUCTOR_INTERNAL_NAME, "()V", false);
                methodVisitor.visitLabel(label2);
                return;
            }
            doSwitchBranch(i7, this.fqClassName, delayedEvalBshMethodArr[i10].getParamTypeDescriptors(), label2, labelArr, i3, methodVisitor);
            i10++;
            i7++;
        }
    }

    public void generateStaticInitializer(ClassWriter classWriter) {
        MethodVisitor methodVisitorVisitMethod = classWriter.visitMethod(8, MethodDescription.TYPE_INITIALIZER_INTERNAL_NAME, "()V", null, null);
        methodVisitorVisitMethod.visitFieldInsn(178, this.fqClassName, "UUID", "Ljava/lang/String;");
        methodVisitorVisitMethod.visitMethodInsn(184, "bsh/This", "pullBshStatic", "(Ljava/lang/String;)Lbsh/This;", false);
        methodVisitorVisitMethod.visitFieldInsn(179, this.fqClassName, This.Keys.BSHSTATIC + this.className, "Lbsh/This;");
        if (this.type == ClassGenerator.Type.ENUM) {
            generateEnumStaticInit(this.fqClassName, this.classDescript, methodVisitorVisitMethod);
        }
        methodVisitorVisitMethod.visitLdcInsn(Type.getType(this.classDescript));
        methodVisitorVisitMethod.visitMethodInsn(184, "bsh/This", "initStatic", "(Ljava/lang/Class;)V", false);
        methodVisitorVisitMethod.visitInsn(177);
        methodVisitorVisitMethod.visitMaxs(0, 0);
    }

    public void initStaticNameSpace(NameSpace nameSpace, BSHBlock bSHBlock) {
        try {
            nameSpace.setLocalVariable("" + This.Keys.BSHCLASSMODIFIERS, this.classModifiers, false);
            nameSpace.setLocalVariable("" + This.Keys.BSHCONSTRUCTORS, this.constructors, false);
            nameSpace.setLocalVariable("" + This.Keys.BSHINIT, bSHBlock, false);
        } catch (UtilEvalError e) {
            throw new InterpreterError("Unable to init class static block: " + e, e);
        }
    }

    private static void generateField(String str, String str2, int i, Object obj, ClassWriter classWriter) {
        classWriter.visitField(i, str, str2, null, obj);
    }
}

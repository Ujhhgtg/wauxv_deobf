package bsh;

import bsh.org.objectweb.asm.ClassWriter;
import bsh.org.objectweb.asm.MethodVisitor;
import bsh.org.objectweb.asm.Type;
import bsh.util.DexClassLoaderHelper;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Parameter;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;
import net.bytebuddy.description.method.MethodDescription;
import net.bytebuddy.implementation.auxiliary.TypeProxy;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public abstract class BshLambda {
    protected final Class<?> dummyType;
    protected final Node expressionNode;
    private static final ByteClassLoader byteClassLoader = new ByteClassLoader(0);
    private static final WeakHashMap<BshLambda, Class<?>> dummyTypesLambdas = new WeakHashMap<>();
    private static volatile int dummyTypeCount = 1;
    private static Map<Class<?>, Class<?>> fiClasses = new HashMap();

    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
    public static class BshLambdaFromLambdaExpression extends BshLambda {
        private final Node bodyNode;
        private final NameSpace declaringNameSpace;
        private final Modifiers[] paramsModifiers;
        private final String[] paramsNames;
        private final Class<?>[] paramsTypes;

        public BshLambdaFromLambdaExpression(Node node, NameSpace nameSpace, Modifiers[] modifiersArr, Class<?>[] clsArr, String[] strArr, Node node2) {
            super(node, 0);
            this.declaringNameSpace = nameSpace != null ? nameSpace.toLambdaNameSpace() : null;
            this.paramsModifiers = modifiersArr;
            this.paramsTypes = clsArr;
            this.paramsNames = strArr;
            this.bodyNode = node2;
            if (modifiersArr.length != clsArr.length || clsArr.length != strArr.length) {
                throw new IllegalArgumentException("The length of 'paramsModifiers', 'paramsTypes' and 'paramsNames' can't be different!");
            }
        }

        private NameSpace initNameSpace(Object[] objArr) {
            NameSpace nameSpace = new NameSpace(this.declaringNameSpace, "LambdaExpression");
            int i = 0;
            while (true) {
                String[] strArr = this.paramsNames;
                if (i >= strArr.length) {
                    return nameSpace;
                }
                Class<?> cls = this.paramsTypes[i];
                if (cls != null) {
                    nameSpace.setTypedVariable(strArr[i], cls, objArr[i], this.paramsModifiers[i]);
                } else {
                    nameSpace.setVariable(strArr[i], objArr[i], false);
                }
                i++;
            }
        }

        @Override // bsh.BshLambda
        public final Object invokeImpl(Object[] objArr) throws UtilEvalError {
            if (objArr.length != this.paramsTypes.length) {
                throw new UtilEvalError("Wrong number of arguments!");
            }
            NameSpace nameSpaceInitNameSpace = initNameSpace(objArr);
            CallStack callStack = new CallStack(nameSpaceInitNameSpace);
            Interpreter interpreter = new Interpreter(nameSpaceInitNameSpace);
            Node node = this.bodyNode;
            if (!(node instanceof BSHBlock)) {
                return node.eval(callStack, interpreter);
            }
            Object objEval = node.eval(callStack, interpreter);
            if (!(objEval instanceof ReturnControl)) {
                return null;
            }
            ReturnControl returnControl = (ReturnControl) objEval;
            if (returnControl.kind == 47) {
                return returnControl.value;
            }
            return null;
        }

        @Override // bsh.BshLambda
        public boolean isAssignable(Method method, int i) {
            Class<?>[] parameterTypes = method.getParameterTypes();
            Class<?>[] clsArr = this.paramsTypes;
            if (clsArr.length != parameterTypes.length) {
                return false;
            }
            return Types.isSignatureAssignable(clsArr, parameterTypes, i);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
    public static class BshLambdaFromMethodReference extends BshLambda {
        private final String methodName;
        private final Object thisArg;

        public BshLambdaFromMethodReference(Node node, Object obj, String str) {
            super(node, 0);
            this.thisArg = obj;
            this.methodName = str;
        }

        @Override // bsh.BshLambda
        public final Object invokeImpl(Object[] objArr) throws TargetError {
            try {
                NameSpace nameSpace = new NameSpace("MethodReferenceLambda");
                CallStack callStack = new CallStack(nameSpace);
                Interpreter interpreter = new Interpreter(nameSpace);
                Object obj = this.thisArg;
                if (!(obj instanceof ClassIdentifier)) {
                    return Reflect.invokeObjectMethod(obj, this.methodName, objArr, interpreter, callStack, this.expressionNode);
                }
                Class<?> cls = ((ClassIdentifier) obj).clas;
                return this.methodName.equals("new") ? Reflect.constructObject(cls, objArr) : Reflect.invokeStaticMethod(nameSpace.getClassManager(), cls, this.methodName, objArr, this.expressionNode);
            } catch (InvocationTargetException e) {
                throw new TargetError(e.getTargetException(), this.expressionNode, null);
            }
        }

        @Override // bsh.BshLambda
        public boolean isAssignable(Method method, int i) {
            Object obj = this.thisArg;
            boolean z = obj instanceof ClassIdentifier;
            Class<?> cls = obj instanceof ClassIdentifier ? ((ClassIdentifier) obj).clas : obj.getClass();
            if ((this.thisArg instanceof ClassIdentifier) && this.methodName.equals("new")) {
                for (Constructor<?> constructor : cls.getConstructors()) {
                    if (Types.isSignatureAssignable(constructor.getParameterTypes(), method.getParameterTypes(), i) && Types.isAssignable(cls, method.getReturnType(), i)) {
                        return true;
                    }
                }
                return false;
            }
            for (Method method2 : cls.getMethods()) {
                if (this.methodName.equals(method2.getName()) && Reflect.isStatic(method2) == z && Types.isSignatureAssignable(method2.getParameterTypes(), method.getParameterTypes(), i) && Types.isAssignable(method2.getReturnType(), method.getReturnType(), i)) {
                    return true;
                }
            }
            return false;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
    public static class ByteClassLoader extends ClassLoader {
        public /* synthetic */ ByteClassLoader(int i) {
            this();
        }

        public Class<?> classFromBytes(String str, byte[] bArr) {
            return new DexClassLoaderHelper().loadClassInternal(str, bArr);
        }

        private ByteClassLoader() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
    public static class WrapperGenerator {
        private WrapperGenerator() {
        }

        public static <T> Class<T> generateClass(Class<T> cls) {
            String str = BshLambda.class.getName() + "Generated" + Base64.getEncoder().encodeToString(cls.getName().getBytes());
            return (Class<T>) BshLambda.byteClassLoader.classFromBytes(str, generateClassBytes(str.replace(".", "/"), cls));
        }

        private static byte[] generateClassBytes(String str, Class<?> cls) {
            ClassWriter classWriter = new ClassWriter(2);
            classWriter.visit(52, 1, str, null, "java/lang/Object", new String[]{Type.getInternalName(cls)});
            classWriter.visitField(2, "bshLambda", Type.getDescriptor(BshLambda.class), null, null).visitEnd();
            writeConstructor(classWriter, str);
            writeMethod(classWriter, str, BshLambda.methodFromFI(cls));
            classWriter.visitEnd();
            return classWriter.toByteArray();
        }

        private static String[] getInternalNames(Class<?>[] clsArr) {
            String[] strArr = new String[clsArr.length];
            for (int i = 0; i < clsArr.length; i++) {
                strArr[i] = Type.getInternalName(clsArr[i]);
            }
            return strArr;
        }

        private static void writeConstructor(ClassWriter classWriter, String str) {
            MethodVisitor methodVisitorVisitMethod = classWriter.visitMethod(1, MethodDescription.CONSTRUCTOR_INTERNAL_NAME, Type.getMethodDescriptor(Type.getType((Class<?>) Void.TYPE), Type.getType((Class<?>) BshLambda.class)), null, null);
            methodVisitorVisitMethod.visitCode();
            methodVisitorVisitMethod.visitVarInsn(25, 0);
            methodVisitorVisitMethod.visitMethodInsn(183, "java/lang/Object", MethodDescription.CONSTRUCTOR_INTERNAL_NAME, "()V", false);
            methodVisitorVisitMethod.visitVarInsn(25, 0);
            methodVisitorVisitMethod.visitVarInsn(25, 1);
            methodVisitorVisitMethod.visitFieldInsn(181, str, "bshLambda", Type.getDescriptor(BshLambda.class));
            methodVisitorVisitMethod.visitInsn(177);
            methodVisitorVisitMethod.visitMaxs(0, 0);
            methodVisitorVisitMethod.visitEnd();
        }

        /* JADX WARN: Found duplicated region for block: B:31:0x011f  */
        private static void writeMethod(ClassWriter classWriter, String str, Method method) {
            Class<?> cls;
            Class<?> cls2;
            Class<?> cls3;
            Class<?> cls4;
            Class<?> cls5;
            Class<?> cls6;
            Class<?> cls7;
            Class<?> cls8;
            int i;
            char c;
            String internalName = Type.getInternalName(BshLambda.class);
            Parameter[] parameters = method.getParameters();
            Class<?>[] exceptionTypes = method.getExceptionTypes();
            MethodVisitor methodVisitorVisitMethod = classWriter.visitMethod(1, method.getName(), Type.getMethodDescriptor(method), null, getInternalNames(exceptionTypes));
            methodVisitorVisitMethod.visitCode();
            methodVisitorVisitMethod.visitVarInsn(25, 0);
            methodVisitorVisitMethod.visitFieldInsn(180, str, "bshLambda", Type.getDescriptor(BshLambda.class));
            methodVisitorVisitMethod.visitLdcInsn(Integer.valueOf(parameters.length));
            methodVisitorVisitMethod.visitTypeInsn(189, "java/lang/Object");
            int i2 = 0;
            int i3 = 1;
            while (true) {
                int length = parameters.length;
                cls = Float.TYPE;
                cls2 = Integer.TYPE;
                cls3 = Short.TYPE;
                cls4 = Byte.TYPE;
                cls5 = Boolean.TYPE;
                cls6 = Character.TYPE;
                cls7 = Double.TYPE;
                cls8 = Long.TYPE;
                if (i2 >= length) {
                    break;
                }
                Class<?> type = parameters[i2].getType();
                methodVisitorVisitMethod.visitInsn(89);
                methodVisitorVisitMethod.visitLdcInsn(Integer.valueOf(i2));
                if (type == cls6) {
                    methodVisitorVisitMethod.visitVarInsn(21, i3);
                    i = 83;
                    methodVisitorVisitMethod.visitMethodInsn(184, "java/lang/Character", "valueOf", "(C)Ljava/lang/Character;", false);
                } else if (type == cls5) {
                    methodVisitorVisitMethod.visitVarInsn(21, i3);
                    i = 83;
                    methodVisitorVisitMethod.visitMethodInsn(184, "java/lang/Boolean", "valueOf", "(Z)Ljava/lang/Boolean;", false);
                } else {
                    i = 83;
                    if (type == cls4) {
                        methodVisitorVisitMethod.visitVarInsn(21, i3);
                        methodVisitorVisitMethod.visitMethodInsn(184, "java/lang/Byte", "valueOf", "(B)Ljava/lang/Byte;", false);
                    } else if (type == cls3) {
                        methodVisitorVisitMethod.visitVarInsn(21, i3);
                        methodVisitorVisitMethod.visitMethodInsn(184, "java/lang/Short", "valueOf", "(S)Ljava/lang/Short;", false);
                    } else if (type == cls2) {
                        methodVisitorVisitMethod.visitVarInsn(21, i3);
                        methodVisitorVisitMethod.visitMethodInsn(184, "java/lang/Integer", "valueOf", "(I)Ljava/lang/Integer;", false);
                    } else if (type == cls8) {
                        methodVisitorVisitMethod.visitVarInsn(22, i3);
                        methodVisitorVisitMethod.visitMethodInsn(184, "java/lang/Long", "valueOf", "(J)Ljava/lang/Long;", false);
                    } else if (type == cls) {
                        methodVisitorVisitMethod.visitVarInsn(23, i3);
                        methodVisitorVisitMethod.visitMethodInsn(184, "java/lang/Float", "valueOf", "(F)Ljava/lang/Float;", false);
                    } else {
                        if (type == cls7) {
                            methodVisitorVisitMethod.visitVarInsn(24, i3);
                            methodVisitorVisitMethod.visitMethodInsn(184, "java/lang/Double", "valueOf", "(D)Ljava/lang/Double;", false);
                        } else {
                            c = 25;
                            methodVisitorVisitMethod.visitVarInsn(25, i3);
                        }
                        methodVisitorVisitMethod.visitInsn(i);
                        i3 += (type != cls8 || type == cls7) ? 2 : 1;
                        i2++;
                    }
                }
                c = 25;
                methodVisitorVisitMethod.visitInsn(i);
                i3 += (type != cls8 || type == cls7) ? 2 : 1;
                i2++;
            }
            methodVisitorVisitMethod.visitLdcInsn(Integer.valueOf(exceptionTypes.length));
            methodVisitorVisitMethod.visitTypeInsn(189, TypeProxy.SilentConstruction.Appender.JAVA_LANG_CLASS_INTERNAL_NAME);
            for (int i4 = 0; i4 < exceptionTypes.length; i4++) {
                Class<?> cls9 = exceptionTypes[i4];
                methodVisitorVisitMethod.visitInsn(89);
                methodVisitorVisitMethod.visitLdcInsn(Integer.valueOf(i4));
                methodVisitorVisitMethod.visitLdcInsn(Type.getType(cls9));
                methodVisitorVisitMethod.visitInsn(83);
            }
            Class<?> returnType = method.getReturnType();
            if (returnType == Void.TYPE) {
                methodVisitorVisitMethod.visitMethodInsn(182, internalName, "invoke", "([Ljava/lang/Object;[Ljava/lang/Class;)Ljava/lang/Object;", false);
                methodVisitorVisitMethod.visitInsn(87);
                methodVisitorVisitMethod.visitInsn(177);
            } else if (returnType == cls5) {
                methodVisitorVisitMethod.visitMethodInsn(182, internalName, "invokeBoolean", "([Ljava/lang/Object;[Ljava/lang/Class;)Z", false);
                methodVisitorVisitMethod.visitInsn(172);
            } else if (returnType == cls6) {
                methodVisitorVisitMethod.visitMethodInsn(182, internalName, "invokeChar", "([Ljava/lang/Object;[Ljava/lang/Class;)C", false);
                methodVisitorVisitMethod.visitInsn(172);
            } else if (returnType == cls4) {
                methodVisitorVisitMethod.visitMethodInsn(182, internalName, "invokeByte", "([Ljava/lang/Object;[Ljava/lang/Class;)B", false);
                methodVisitorVisitMethod.visitInsn(172);
            } else if (returnType == cls3) {
                methodVisitorVisitMethod.visitMethodInsn(182, internalName, "invokeShort", "([Ljava/lang/Object;[Ljava/lang/Class;)S", false);
                methodVisitorVisitMethod.visitInsn(172);
            } else if (returnType == cls2) {
                methodVisitorVisitMethod.visitMethodInsn(182, internalName, "invokeInt", "([Ljava/lang/Object;[Ljava/lang/Class;)I", false);
                methodVisitorVisitMethod.visitInsn(172);
            } else if (returnType == cls8) {
                methodVisitorVisitMethod.visitMethodInsn(182, internalName, "invokeLong", "([Ljava/lang/Object;[Ljava/lang/Class;)J", false);
                methodVisitorVisitMethod.visitInsn(173);
            } else if (returnType == cls) {
                methodVisitorVisitMethod.visitMethodInsn(182, internalName, "invokeFloat", "([Ljava/lang/Object;[Ljava/lang/Class;)F", false);
                methodVisitorVisitMethod.visitInsn(174);
            } else if (returnType == cls7) {
                methodVisitorVisitMethod.visitMethodInsn(182, internalName, "invokeDouble", "([Ljava/lang/Object;[Ljava/lang/Class;)D", false);
                methodVisitorVisitMethod.visitInsn(175);
            } else {
                methodVisitorVisitMethod.visitLdcInsn(Type.getType(returnType));
                methodVisitorVisitMethod.visitMethodInsn(182, internalName, "invokeObject", "([Ljava/lang/Object;[Ljava/lang/Class;Ljava/lang/Class;)Ljava/lang/Object;", false);
                methodVisitorVisitMethod.visitInsn(176);
            }
            methodVisitorVisitMethod.visitMaxs(0, 0);
            methodVisitorVisitMethod.visitEnd();
        }
    }

    public /* synthetic */ BshLambda(Node node, int i) {
        this(node);
    }

    public static BshLambda fromLambdaExpression(Node node, NameSpace nameSpace, Modifiers[] modifiersArr, Class<?>[] clsArr, String[] strArr, Node node2) {
        return new BshLambdaFromLambdaExpression(node, nameSpace, modifiersArr, clsArr, strArr, node2);
    }

    public static BshLambda fromMethodReference(Node node, Object obj, String str) {
        return new BshLambdaFromMethodReference(node, obj, str);
    }

    private static Class<?> generateDummyType() {
        StringBuilder sb = new StringBuilder();
        sb.append(BshLambda.class.getName());
        sb.append("Type");
        int i = dummyTypeCount;
        dummyTypeCount = i + 1;
        sb.append(i);
        String string = sb.toString();
        ClassWriter classWriter = new ClassWriter(2);
        classWriter.visit(52, 1537, string.replace(".", "/"), null, "java/lang/Object", null);
        classWriter.visitEnd();
        return byteClassLoader.classFromBytes(string, classWriter.toByteArray());
    }

    public static <T> Class<T> getClassForFI(Class<T> cls) {
        if (fiClasses.containsKey(cls)) {
            return (Class) fiClasses.get(cls);
        }
        Class<T> clsGenerateClass = WrapperGenerator.generateClass(cls);
        fiClasses.put(cls, clsGenerateClass);
        return clsGenerateClass;
    }

    public static boolean isAssignable(Class<?> cls, Class<?> cls2, int i) {
        Method methodMethodFromFI = methodFromFI(cls2);
        for (Map.Entry<BshLambda, Class<?>> entry : dummyTypesLambdas.entrySet()) {
            if (entry.getValue() == cls) {
                return entry.getKey().isAssignable(methodMethodFromFI, i);
            }
        }
        return false;
    }

    public static Method methodFromFI(Class<?> cls) {
        for (Method method : cls.getMethods()) {
            if (Modifier.isAbstract(method.getModifiers())) {
                return method;
            }
        }
        throw new IllegalArgumentException("This class isn't a valid Functional Interface: ".concat(cls.getName()));
    }

    public <T> T convertTo(Class<T> cls) throws UtilEvalError {
        if (!isAssignable(this.dummyType, cls, 4)) {
            throw new UtilEvalError("This BshLambda can't be converted to ".concat(cls.getName()));
        }
        try {
            return (T) getClassForFI(cls).getConstructors()[0].newInstance(this);
        } catch (Throwable th) {
            throw new UtilEvalError("Can't create a instance for the generate class for the BshLambda: " + th.getMessage(), th);
        }
    }

    public final Object invoke(Object[] objArr, Class<?>[] clsArr) throws Throwable {
        try {
            return Primitive.unwrap(invokeImpl(objArr));
        } catch (TargetError e) {
            for (Class<?> cls : clsArr) {
                if (cls.isInstance(e.getTarget())) {
                    throw e.getTarget();
                }
            }
            throw new RuntimeEvalError("Can't invoke lambda: Unexpected Exception: " + e.getTarget().getMessage(), this.expressionNode, null, e.getTarget());
        } catch (EvalError e2) {
            throw new RuntimeEvalError("Can't invoke lambda: " + e2.getMessage(), this.expressionNode, null, e2);
        } catch (UtilEvalError e3) {
            throw new RuntimeEvalError(e3.toEvalError(this.expressionNode, null));
        }
    }

    public final boolean invokeBoolean(Object[] objArr, Class<?>[] clsArr) throws Throwable {
        Object objInvoke = invoke(objArr, clsArr);
        if (objInvoke instanceof Boolean) {
            return ((Boolean) objInvoke).booleanValue();
        }
        throw new RuntimeEvalError("Can't convert " + StringUtil.typeString(objInvoke) + " to boolean", this.expressionNode, null);
    }

    public final byte invokeByte(Object[] objArr, Class<?>[] clsArr) throws Throwable {
        Object objInvoke = invoke(objArr, clsArr);
        if (objInvoke instanceof Number) {
            return ((Number) objInvoke).byteValue();
        }
        throw new RuntimeEvalError("Can't convert " + StringUtil.typeString(objInvoke) + " to byte", this.expressionNode, null);
    }

    public final char invokeChar(Object[] objArr, Class<?>[] clsArr) throws Throwable {
        Object objInvoke = invoke(objArr, clsArr);
        if (objInvoke instanceof Character) {
            return ((Character) objInvoke).charValue();
        }
        throw new RuntimeEvalError("Can't convert " + StringUtil.typeString(objInvoke) + " to char", this.expressionNode, null);
    }

    public final double invokeDouble(Object[] objArr, Class<?>[] clsArr) throws Throwable {
        Object objInvoke = invoke(objArr, clsArr);
        if (objInvoke instanceof Number) {
            return ((Number) objInvoke).doubleValue();
        }
        throw new RuntimeEvalError("Can't convert " + StringUtil.typeString(objInvoke) + " to double", this.expressionNode, null);
    }

    public final float invokeFloat(Object[] objArr, Class<?>[] clsArr) throws Throwable {
        Object objInvoke = invoke(objArr, clsArr);
        if (objInvoke instanceof Number) {
            return ((Number) objInvoke).floatValue();
        }
        throw new RuntimeEvalError("Can't convert " + StringUtil.typeString(objInvoke) + " to float", this.expressionNode, null);
    }

    public abstract Object invokeImpl(Object[] objArr);

    public final int invokeInt(Object[] objArr, Class<?>[] clsArr) throws Throwable {
        Object objInvoke = invoke(objArr, clsArr);
        if (objInvoke instanceof Number) {
            return ((Number) objInvoke).intValue();
        }
        throw new RuntimeEvalError("Can't convert " + StringUtil.typeString(objInvoke) + " to int", this.expressionNode, null);
    }

    public final long invokeLong(Object[] objArr, Class<?>[] clsArr) throws Throwable {
        Object objInvoke = invoke(objArr, clsArr);
        if (objInvoke instanceof Number) {
            return ((Number) objInvoke).longValue();
        }
        throw new RuntimeEvalError("Can't convert " + StringUtil.typeString(objInvoke) + " to long", this.expressionNode, null);
    }

    public final <T> T invokeObject(Object[] objArr, Class<?>[] clsArr, Class<T> cls) throws Throwable {
        Object objInvoke = invoke(objArr, clsArr);
        if (objInvoke == null) {
            return null;
        }
        try {
            return (T) Types.castObject(objInvoke, cls, 1);
        } catch (UtilEvalError e) {
            throw new RuntimeEvalError(e.toEvalError(this.expressionNode, null));
        }
    }

    public final short invokeShort(Object[] objArr, Class<?>[] clsArr) throws Throwable {
        Object objInvoke = invoke(objArr, clsArr);
        if (objInvoke instanceof Number) {
            return ((Number) objInvoke).shortValue();
        }
        throw new RuntimeEvalError("Can't convert " + StringUtil.typeString(objInvoke) + " to short", this.expressionNode, null);
    }

    public abstract boolean isAssignable(Method method, int i);

    private BshLambda(Node node) {
        this.expressionNode = node;
        Class<?> clsGenerateDummyType = generateDummyType();
        this.dummyType = clsGenerateDummyType;
        dummyTypesLambdas.put(this, clsGenerateDummyType);
    }
}

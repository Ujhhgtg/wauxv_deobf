package bsh;

import bsh.BSHBlock;
import bsh.This;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import net.bytebuddy.dynamic.ClassFileLocator;
import net.bytebuddy.pool.TypePool;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class ClassGenerator {
    private static ClassGenerator cg;

    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
    public enum Type {
        CLASS,
        INTERFACE,
        ENUM
    }

    public static Class<?> generateClassImpl(String str, Modifiers modifiers, Class<?>[] clsArr, Class<?> cls, BSHBlock bSHBlock, Type type, CallStack callStack, Interpreter interpreter) {
        String str2;
        String str3;
        NameSpace pVar = callStack.top();
        String str4 = pVar.getPackage();
        if (pVar.isClass) {
            str2 = pVar.getName() + "$" + str;
        } else {
            str2 = str;
        }
        if (str4 == null) {
            str3 = str2;
        } else {
            str3 = str4 + "." + str2;
        }
        BshClassManager classManager = interpreter.getClassManager();
        NameSpace nameSpace = new NameSpace(pVar, str2);
        nameSpace.isClass = true;
        callStack.push(nameSpace);
        bSHBlock.evalBlock(callStack, interpreter, Boolean.TRUE, ClassNodeFilter.CLASSCLASSES);
        Variable[] declaredVariables = getDeclaredVariables(bSHBlock, callStack, interpreter, str4);
        DelayedEvalBshMethod[] declaredMethods = getDeclaredMethods(bSHBlock, callStack, interpreter, str4, cls);
        callStack.pop();
        nameSpace.getThis(interpreter);
        ClassGeneratorUtil classGeneratorUtil = new ClassGeneratorUtil(modifiers, str2, str4, cls, clsArr, declaredVariables, declaredMethods, nameSpace, type);
        classGeneratorUtil.initStaticNameSpace(nameSpace, bSHBlock);
        Class<?> associatedClass = classManager.getAssociatedClass(str3);
        if (associatedClass == null) {
            byte[] bArrGenerateClass = classGeneratorUtil.generateClass();
            if (Interpreter.getSaveClasses()) {
                saveClasses(str2, bArrGenerateClass);
            }
            associatedClass = classManager.defineClass(str3, bArrGenerateClass);
            Interpreter.debug("Define ", str3, " as ", associatedClass);
        }
        pVar.importClass(str3.replace('$', TypePool.Default.LazyTypeDescription.GenericTypeToken.INNER_CLASS_PATH));
        nameSpace.setClassStatic(associatedClass);
        Interpreter.debug(nameSpace);
        if (interpreter.getStrictJava()) {
            ClassGeneratorUtil.checkAbstractMethodImplementation(associatedClass);
        }
        return associatedClass;
    }

    public static ClassGenerator getClassGenerator() {
        if (cg == null) {
            cg = new ClassGenerator();
        }
        return cg;
    }

    public static DelayedEvalBshMethod[] getDeclaredMethods(BSHBlock bSHBlock, CallStack callStack, Interpreter interpreter, String str, Class<?> cls) {
        CallStack callStack2 = callStack;
        Interpreter interpreter2 = interpreter;
        ArrayList arrayList = new ArrayList();
        if (callStack2.top().getName().indexOf("$anon") > -1) {
            String baseName = Types.getBaseName(callStack2.top().getName());
            arrayList.add(new DelayedEvalBshMethod(baseName, BshClassManager.memberCache.get(cls).findMethod(cls.getName(), This.CONTEXT_ARGS.get().get(baseName)), callStack2.top()));
        }
        int i = 0;
        while (i < bSHBlock.jjtGetNumChildren()) {
            Node nodeJjtGetChild = bSHBlock.jjtGetChild(i);
            if (nodeJjtGetChild instanceof BSHMethodDeclaration) {
                BSHMethodDeclaration bSHMethodDeclaration = (BSHMethodDeclaration) nodeJjtGetChild;
                bSHMethodDeclaration.insureNodesParsed();
                Modifiers modifiers = bSHMethodDeclaration.modifiers;
                String str2 = bSHMethodDeclaration.name;
                String returnTypeDescriptor = bSHMethodDeclaration.getReturnTypeDescriptor(callStack2, interpreter2, str);
                BSHReturnType returnTypeNode = bSHMethodDeclaration.getReturnTypeNode();
                BSHFormalParameters bSHFormalParameters = bSHMethodDeclaration.paramsNode;
                arrayList.add(new DelayedEvalBshMethod(str2, returnTypeDescriptor, returnTypeNode, bSHMethodDeclaration.paramsNode.getParamNames(), bSHFormalParameters.getTypeDescriptors(callStack2, interpreter2, str), bSHFormalParameters, bSHMethodDeclaration.blockNode, null, modifiers, bSHMethodDeclaration.isVarArgs, callStack2, interpreter2));
            }
            i++;
            callStack2 = callStack;
            interpreter2 = interpreter;
        }
        return (DelayedEvalBshMethod[]) arrayList.toArray(new DelayedEvalBshMethod[arrayList.size()]);
    }

    public static Variable[] getDeclaredVariables(BSHBlock bSHBlock, CallStack callStack, Interpreter interpreter, String str) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < bSHBlock.jjtGetNumChildren(); i++) {
            Node nodeJjtGetChild = bSHBlock.jjtGetChild(i);
            if (nodeJjtGetChild instanceof BSHEnumConstant) {
                BSHEnumConstant bSHEnumConstant = (BSHEnumConstant) nodeJjtGetChild;
                try {
                    arrayList.add(new Variable(bSHEnumConstant.getName(), bSHEnumConstant.getType(), (Object) null, bSHEnumConstant.mods));
                } catch (UtilEvalError unused) {
                }
            } else if (nodeJjtGetChild instanceof BSHTypedVariableDeclaration) {
                BSHTypedVariableDeclaration bSHTypedVariableDeclaration = (BSHTypedVariableDeclaration) nodeJjtGetChild;
                Modifiers modifiers = bSHTypedVariableDeclaration.modifiers;
                for (BSHVariableDeclarator bSHVariableDeclarator : bSHTypedVariableDeclaration.getDeclarators()) {
                    try {
                        arrayList.add(new Variable(bSHVariableDeclarator.name, bSHTypedVariableDeclaration.evalType(callStack, interpreter), (Object) null, modifiers));
                    } catch (EvalError | UtilEvalError unused2) {
                    }
                }
            }
        }
        return (Variable[]) arrayList.toArray(new Variable[arrayList.size()]);
    }

    public static Object invokeSuperclassMethodImpl(BshClassManager bshClassManager, Object obj, Class<?> cls, String str, Object[] objArr) throws UtilEvalError {
        Class<? super Object> superclass = cls.getSuperclass();
        Invocable invocableResolveJavaMethod = Reflect.resolveJavaMethod(obj.getClass(), This.Keys.BSHSUPER + superclass.getSimpleName() + str, Types.getTypes(objArr), false);
        return invocableResolveJavaMethod != null ? invocableResolveJavaMethod.invoke(obj, objArr) : Reflect.resolveExpectedJavaMethod(bshClassManager, superclass, obj, str, objArr, false).invoke(obj, objArr);
    }

    private static void saveClasses(String str, byte[] bArr) {
        String saveClassesDir = Interpreter.getSaveClassesDir();
        if (saveClassesDir != null) {
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(saveClassesDir + "/" + str + ClassFileLocator.CLASS_FILE_EXTENSION);
                try {
                    fileOutputStream.write(bArr);
                    fileOutputStream.close();
                } catch (Throwable th) {
                    try {
                        fileOutputStream.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                    throw th;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public Class<?> generateClass(String str, Modifiers modifiers, Class<?>[] clsArr, Class<?> cls, BSHBlock bSHBlock, Type type, CallStack callStack, Interpreter interpreter) {
        return generateClassImpl(str, modifiers, clsArr, cls, bSHBlock, type, callStack, interpreter);
    }

    public Object invokeSuperclassMethod(BshClassManager bshClassManager, Object obj, Class<?> cls, String str, Object[] objArr) {
        return invokeSuperclassMethodImpl(bshClassManager, obj, cls, str, objArr);
    }

    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
    public static class ClassNodeFilter implements BSHBlock.NodeFilter {
        public static ClassNodeFilter CLASSCLASSES;
        public static ClassNodeFilter CLASSINSTANCEFIELDS;
        public static ClassNodeFilter CLASSINSTANCEMETHODS;
        public static ClassNodeFilter CLASSSTATICFIELDS;
        public static ClassNodeFilter CLASSSTATICMETHODS;
        Context context;
        Types types;

        /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
        public enum Context {
            STATIC,
            INSTANCE,
            CLASSES
        }

        /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
        public enum Types {
            ALL,
            METHODS,
            FIELDS
        }

        static {
            Context context = Context.STATIC;
            Types types = Types.FIELDS;
            CLASSSTATICFIELDS = new ClassNodeFilter(context, types);
            Types types2 = Types.METHODS;
            CLASSSTATICMETHODS = new ClassNodeFilter(context, types2);
            Context context2 = Context.INSTANCE;
            CLASSINSTANCEFIELDS = new ClassNodeFilter(context2, types);
            CLASSINSTANCEMETHODS = new ClassNodeFilter(context2, types2);
            CLASSCLASSES = new ClassNodeFilter(Context.CLASSES);
        }

        private ClassNodeFilter(Context context) {
            this.types = Types.ALL;
            this.context = context;
        }

        private boolean isInstanceMethod(Node node) {
            if (node instanceof BSHMethodDeclaration) {
                return !((BSHMethodDeclaration) node).modifiers.hasModifier("static");
            }
            return false;
        }

        private boolean isNonStatic(Node node) {
            if (node instanceof BSHMethodDeclaration) {
                return false;
            }
            return !isStatic(node);
        }

        private boolean isStatic(Node node) {
            if ((node.jjtGetParent().jjtGetParent() instanceof BSHClassDeclaration) && ((BSHClassDeclaration) node.jjtGetParent().jjtGetParent()).type == Type.INTERFACE) {
                return true;
            }
            if (node instanceof BSHTypedVariableDeclaration) {
                return ((BSHTypedVariableDeclaration) node).modifiers.hasModifier("static");
            }
            if (node instanceof BSHBlock) {
                return ((BSHBlock) node).isStatic;
            }
            return false;
        }

        private boolean isStaticMethod(Node node) {
            if (node instanceof BSHMethodDeclaration) {
                return ((BSHMethodDeclaration) node).modifiers.hasModifier("static");
            }
            return false;
        }

        @Override // bsh.BSHBlock.NodeFilter
        public boolean isVisible(Node node) {
            Context context = this.context;
            if (context == Context.CLASSES) {
                return node instanceof BSHClassDeclaration;
            }
            if (node instanceof BSHClassDeclaration) {
                return false;
            }
            return context == Context.STATIC ? this.types == Types.METHODS ? isStaticMethod(node) : isStatic(node) : this.types == Types.METHODS ? isInstanceMethod(node) : isNonStatic(node);
        }

        private ClassNodeFilter(Context context, Types types) {
            Types types2 = Types.ALL;
            this.context = context;
            this.types = types;
        }
    }
}

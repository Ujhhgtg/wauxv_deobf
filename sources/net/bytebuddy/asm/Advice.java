package net.bytebuddy.asm;

import com.umeng.analytics.pro.f;
import java.io.IOException;
import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;
import me.hd.wauxv.obf.bjs;
import me.hd.wauxv.obf.StaticHelpers6;
import me.hd.wauxv.obf.yg;
import net.bytebuddy.ClassFileVersion;
import net.bytebuddy.build.HashCodeAndEqualsPlugin;
import net.bytebuddy.build.RepeatedAnnotationPlugin;
import net.bytebuddy.description.annotation.AnnotationDescription;
import net.bytebuddy.description.annotation.AnnotationValue;
import net.bytebuddy.description.enumeration.EnumerationDescription;
import net.bytebuddy.description.field.FieldDescription;
import net.bytebuddy.description.method.MethodDescription;
import net.bytebuddy.description.method.MethodList;
import net.bytebuddy.description.method.ParameterDescription;
import net.bytebuddy.description.method.ParameterList;
import net.bytebuddy.description.type.TypeDefinition;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.description.type.TypeList;
import net.bytebuddy.dynamic.ClassFileLocator;
import net.bytebuddy.dynamic.TargetType;
import net.bytebuddy.dynamic.scaffold.FieldLocator;
import net.bytebuddy.dynamic.scaffold.InstrumentedType;
import net.bytebuddy.dynamic.scaffold.MethodGraph;
import net.bytebuddy.implementation.FieldAccessor;
import net.bytebuddy.implementation.Implementation;
import net.bytebuddy.implementation.SuperMethodCall;
import net.bytebuddy.implementation.bytecode.Addition;
import net.bytebuddy.implementation.bytecode.ByteCodeAppender;
import net.bytebuddy.implementation.bytecode.Duplication;
import net.bytebuddy.implementation.bytecode.Removal;
import net.bytebuddy.implementation.bytecode.StackManipulation;
import net.bytebuddy.implementation.bytecode.StackSize;
import net.bytebuddy.implementation.bytecode.Throw;
import net.bytebuddy.implementation.bytecode.assign.Assigner;
import net.bytebuddy.implementation.bytecode.collection.ArrayAccess;
import net.bytebuddy.implementation.bytecode.collection.ArrayFactory;
import net.bytebuddy.implementation.bytecode.constant.ClassConstant;
import net.bytebuddy.implementation.bytecode.constant.DefaultValue;
import net.bytebuddy.implementation.bytecode.constant.IntegerConstant;
import net.bytebuddy.implementation.bytecode.constant.JavaConstantValue;
import net.bytebuddy.implementation.bytecode.constant.MethodConstant;
import net.bytebuddy.implementation.bytecode.constant.NullConstant;
import net.bytebuddy.implementation.bytecode.constant.SerializedConstant;
import net.bytebuddy.implementation.bytecode.member.FieldAccess;
import net.bytebuddy.implementation.bytecode.member.Invokedynamic;
import net.bytebuddy.implementation.bytecode.member.MethodInvocation;
import net.bytebuddy.implementation.bytecode.member.MethodVariableAccess;
import net.bytebuddy.jar.asm.AnnotationVisitor;
import net.bytebuddy.jar.asm.Attribute;
import net.bytebuddy.jar.asm.ClassVisitor;
import net.bytebuddy.jar.asm.Label;
import net.bytebuddy.jar.asm.MethodVisitor;
import net.bytebuddy.jar.asm.Opcodes;
import net.bytebuddy.jar.asm.Type;
import net.bytebuddy.jar.asm.TypePath;
import net.bytebuddy.matcher.ElementMatcher;
import net.bytebuddy.matcher.ElementMatchers;
import net.bytebuddy.pool.TypePool;
import net.bytebuddy.utility.AsmClassReader;
import net.bytebuddy.utility.CompoundList;
import net.bytebuddy.utility.ConstantValue;
import net.bytebuddy.utility.JavaConstant;
import net.bytebuddy.utility.JavaType;
import net.bytebuddy.utility.OpenedClassReader;
import net.bytebuddy.utility.nullability.AlwaysNull;
import net.bytebuddy.utility.nullability.MaybeNull;
import net.bytebuddy.utility.visitor.ExceptionTableSensitiveMethodVisitor;
import net.bytebuddy.utility.visitor.LineNumberPrependingMethodVisitor;
import net.bytebuddy.utility.visitor.StackAwareMethodVisitor;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
@HashCodeAndEqualsPlugin.Enhance
public class Advice implements AsmVisitorWrapper.ForDeclaredMethods.MethodVisitorWrapper, Implementation {
    private static final MethodDescription.InDefinedShape BACKUP_ARGUMENTS;
    private static final MethodDescription.InDefinedShape INLINE_ENTER;
    private static final MethodDescription.InDefinedShape INLINE_EXIT;
    private static final MethodDescription.InDefinedShape ON_THROWABLE;
    private static final MethodDescription.InDefinedShape PREPEND_LINE_NUMBER;
    private static final MethodDescription.InDefinedShape REPEAT_ON;
    private static final MethodDescription.InDefinedShape REPEAT_ON_INDEX;
    private static final MethodDescription.InDefinedShape SKIP_ON;
    private static final MethodDescription.InDefinedShape SKIP_ON_INDEX;
    private static final MethodDescription.InDefinedShape SUPPRESS_ENTER;
    private static final MethodDescription.InDefinedShape SUPPRESS_EXIT;

    @AlwaysNull
    private static final AsmClassReader UNDEFINED = null;
    private final Assigner assigner;
    private final Implementation delegate;
    private final ExceptionHandler exceptionHandler;
    private final Dispatcher.Resolved.ForMethodEnter methodEnter;
    private final Dispatcher.Resolved.ForMethodExit methodExit;

    /*
     * JADX INFO: compiled from:
     * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
     */
    public static abstract class AdviceVisitor extends ExceptionTableSensitiveMethodVisitor
            implements Dispatcher.RelocationHandler.Relocation {
        private static final int THIS_VARIABLE_INDEX = 0;
        private static final String THIS_VARIABLE_NAME = "this";
        protected final ArgumentHandler.ForInstrumentedMethod argumentHandler;
        protected final MethodDescription instrumentedMethod;
        private final Dispatcher.Bound methodEnter;
        protected final Dispatcher.Bound methodExit;
        protected final MethodSizeHandler.ForInstrumentedMethod methodSizeHandler;
        private final Label preparationStart;
        protected final StackMapFrameHandler.ForInstrumentedMethod stackMapFrameHandler;

        /*
         * JADX INFO: compiled from:
         * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
         */
        public static abstract class WithExitAdvice extends AdviceVisitor {
            protected final Label returnHandler;

            /*
             * JADX INFO: compiled from:
             * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
             */
            public static class WithExceptionHandling extends WithExitAdvice {
                private final Label exceptionHandler;
                private final TypeDescription throwable;
                protected final Label userStart;

                public WithExceptionHandling(MethodVisitor methodVisitor, Implementation.Context context,
                        Assigner assigner, StackManipulation stackManipulation, TypeDescription typeDescription,
                        MethodDescription methodDescription, Dispatcher.Resolved.ForMethodEnter forMethodEnter,
                        Dispatcher.Resolved.ForMethodExit forMethodExit, int i, int i2,
                        TypeDescription typeDescription2) {
                    super(methodVisitor, context, assigner, stackManipulation, typeDescription, methodDescription,
                            forMethodEnter, forMethodExit,
                            methodDescription.getReturnType().represents(Void.TYPE)
                                    ? Collections.singletonList(TypeDescription.ForLoadedType.of(Throwable.class))
                                    : Arrays.asList(methodDescription.getReturnType().asErasure(),
                                            TypeDescription.ForLoadedType.of(Throwable.class)),
                            i, i2);
                    this.throwable = typeDescription2;
                    this.exceptionHandler = new Label();
                    this.userStart = new Label();
                }

                @Override // net.bytebuddy.asm.Advice.AdviceVisitor.WithExitAdvice
                public void onExitAdviceReturn() {
                    this.mv.visitVarInsn(25, this.argumentHandler.thrown());
                    Label label = new Label();
                    this.mv.visitJumpInsn(198, label);
                    this.mv.visitVarInsn(25, this.argumentHandler.thrown());
                    this.mv.visitInsn(191);
                    this.mv.visitLabel(label);
                    this.stackMapFrameHandler.injectPostCompletionFrame(this.mv);
                }

                @Override // net.bytebuddy.asm.Advice.AdviceVisitor
                public void onUserPrepare() {
                    this.mv.visitTryCatchBlock(this.userStart, this.returnHandler, this.exceptionHandler,
                            this.throwable.getInternalName());
                }

                @Override // net.bytebuddy.asm.Advice.AdviceVisitor.WithExitAdvice
                public void onUserReturn() {
                    this.stackMapFrameHandler.injectReturnFrame(this.mv);
                    TypeDescription.Generic returnType = this.instrumentedMethod.getReturnType();
                    Class cls = Boolean.TYPE;
                    boolean zRepresents = returnType.represents(cls);
                    Class cls2 = Void.TYPE;
                    Class cls3 = Double.TYPE;
                    Class cls4 = Float.TYPE;
                    Class cls5 = Long.TYPE;
                    Class cls6 = Integer.TYPE;
                    Class cls7 = Character.TYPE;
                    Class cls8 = Short.TYPE;
                    Class cls9 = Byte.TYPE;
                    if (zRepresents || this.instrumentedMethod.getReturnType().represents(cls9)
                            || this.instrumentedMethod.getReturnType().represents(cls8)
                            || this.instrumentedMethod.getReturnType().represents(cls7)
                            || this.instrumentedMethod.getReturnType().represents(cls6)) {
                        this.mv.visitVarInsn(54, this.argumentHandler.returned());
                    } else if (this.instrumentedMethod.getReturnType().represents(cls5)) {
                        this.mv.visitVarInsn(55, this.argumentHandler.returned());
                    } else if (this.instrumentedMethod.getReturnType().represents(cls4)) {
                        this.mv.visitVarInsn(56, this.argumentHandler.returned());
                    } else if (this.instrumentedMethod.getReturnType().represents(cls3)) {
                        this.mv.visitVarInsn(57, this.argumentHandler.returned());
                    } else if (!this.instrumentedMethod.getReturnType().represents(cls2)) {
                        this.mv.visitVarInsn(58, this.argumentHandler.returned());
                    }
                    this.mv.visitInsn(1);
                    this.mv.visitVarInsn(58, this.argumentHandler.thrown());
                    Label label = new Label();
                    this.mv.visitJumpInsn(167, label);
                    this.mv.visitLabel(this.exceptionHandler);
                    this.stackMapFrameHandler.injectExceptionFrame(this.mv);
                    this.mv.visitVarInsn(58, this.argumentHandler.thrown());
                    if (this.instrumentedMethod.getReturnType().represents(cls)
                            || this.instrumentedMethod.getReturnType().represents(cls9)
                            || this.instrumentedMethod.getReturnType().represents(cls8)
                            || this.instrumentedMethod.getReturnType().represents(cls7)
                            || this.instrumentedMethod.getReturnType().represents(cls6)) {
                        this.mv.visitInsn(3);
                        this.mv.visitVarInsn(54, this.argumentHandler.returned());
                    } else if (this.instrumentedMethod.getReturnType().represents(cls5)) {
                        this.mv.visitInsn(9);
                        this.mv.visitVarInsn(55, this.argumentHandler.returned());
                    } else if (this.instrumentedMethod.getReturnType().represents(cls4)) {
                        this.mv.visitInsn(11);
                        this.mv.visitVarInsn(56, this.argumentHandler.returned());
                    } else if (this.instrumentedMethod.getReturnType().represents(cls3)) {
                        this.mv.visitInsn(14);
                        this.mv.visitVarInsn(57, this.argumentHandler.returned());
                    } else if (!this.instrumentedMethod.getReturnType().represents(cls2)) {
                        this.mv.visitInsn(1);
                        this.mv.visitVarInsn(58, this.argumentHandler.returned());
                    }
                    this.mv.visitLabel(label);
                    this.methodSizeHandler.requireStackSize(StackSize.SINGLE.getSize());
                }

                @Override // net.bytebuddy.asm.Advice.AdviceVisitor
                public void onUserStart() {
                    this.mv.visitLabel(this.userStart);
                }
            }

            /*
             * JADX INFO: compiled from:
             * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
             */
            public static class WithoutExceptionHandling extends WithExitAdvice {
                public WithoutExceptionHandling(MethodVisitor methodVisitor, Implementation.Context context,
                        Assigner assigner, StackManipulation stackManipulation, TypeDescription typeDescription,
                        MethodDescription methodDescription, Dispatcher.Resolved.ForMethodEnter forMethodEnter,
                        Dispatcher.Resolved.ForMethodExit forMethodExit, int i, int i2) {
                    super(methodVisitor, context, assigner, stackManipulation, typeDescription, methodDescription,
                            forMethodEnter, forMethodExit,
                            methodDescription.getReturnType().represents(Void.TYPE) ? Collections.EMPTY_LIST
                                    : Collections.singletonList(methodDescription.getReturnType().asErasure()),
                            i, i2);
                }

                @Override // net.bytebuddy.asm.Advice.AdviceVisitor.WithExitAdvice
                public void onExitAdviceReturn() {
                }

                @Override // net.bytebuddy.asm.Advice.AdviceVisitor
                public void onUserPrepare() {
                }

                @Override // net.bytebuddy.asm.Advice.AdviceVisitor.WithExitAdvice
                public void onUserReturn() {
                    if (this.instrumentedMethod.getReturnType().represents(Boolean.TYPE)
                            || this.instrumentedMethod.getReturnType().represents(Byte.TYPE)
                            || this.instrumentedMethod.getReturnType().represents(Short.TYPE)
                            || this.instrumentedMethod.getReturnType().represents(Character.TYPE)
                            || this.instrumentedMethod.getReturnType().represents(Integer.TYPE)) {
                        this.stackMapFrameHandler.injectReturnFrame(this.mv);
                        this.mv.visitVarInsn(54, this.argumentHandler.returned());
                        return;
                    }
                    if (this.instrumentedMethod.getReturnType().represents(Long.TYPE)) {
                        this.stackMapFrameHandler.injectReturnFrame(this.mv);
                        this.mv.visitVarInsn(55, this.argumentHandler.returned());
                        return;
                    }
                    if (this.instrumentedMethod.getReturnType().represents(Float.TYPE)) {
                        this.stackMapFrameHandler.injectReturnFrame(this.mv);
                        this.mv.visitVarInsn(56, this.argumentHandler.returned());
                    } else if (this.instrumentedMethod.getReturnType().represents(Double.TYPE)) {
                        this.stackMapFrameHandler.injectReturnFrame(this.mv);
                        this.mv.visitVarInsn(57, this.argumentHandler.returned());
                    } else {
                        if (this.instrumentedMethod.getReturnType().represents(Void.TYPE)) {
                            return;
                        }
                        this.stackMapFrameHandler.injectReturnFrame(this.mv);
                        this.mv.visitVarInsn(58, this.argumentHandler.returned());
                    }
                }

                @Override // net.bytebuddy.asm.Advice.AdviceVisitor
                public void onUserStart() {
                }
            }

            public WithExitAdvice(MethodVisitor methodVisitor, Implementation.Context context, Assigner assigner,
                    StackManipulation stackManipulation, TypeDescription typeDescription,
                    MethodDescription methodDescription, Dispatcher.Resolved.ForMethodEnter forMethodEnter,
                    Dispatcher.Resolved.ForMethodExit forMethodExit, List<? extends TypeDescription> list, int i,
                    int i2) {
                super(StackAwareMethodVisitor.of(methodVisitor, methodDescription), context, assigner,
                        stackManipulation, typeDescription, methodDescription, forMethodEnter, forMethodExit, list, i,
                        i2);
                this.returnHandler = new Label();
            }

            @Override // net.bytebuddy.asm.Advice.Dispatcher.RelocationHandler.Relocation
            public void apply(MethodVisitor methodVisitor) {
                if (this.instrumentedMethod.getReturnType().represents(Boolean.TYPE)
                        || this.instrumentedMethod.getReturnType().represents(Byte.TYPE)
                        || this.instrumentedMethod.getReturnType().represents(Short.TYPE)
                        || this.instrumentedMethod.getReturnType().represents(Character.TYPE)
                        || this.instrumentedMethod.getReturnType().represents(Integer.TYPE)) {
                    methodVisitor.visitInsn(3);
                } else if (this.instrumentedMethod.getReturnType().represents(Long.TYPE)) {
                    methodVisitor.visitInsn(9);
                } else if (this.instrumentedMethod.getReturnType().represents(Float.TYPE)) {
                    methodVisitor.visitInsn(11);
                } else if (this.instrumentedMethod.getReturnType().represents(Double.TYPE)) {
                    methodVisitor.visitInsn(14);
                } else if (!this.instrumentedMethod.getReturnType().represents(Void.TYPE)) {
                    methodVisitor.visitInsn(1);
                }
                methodVisitor.visitJumpInsn(167, this.returnHandler);
            }

            public abstract void onExitAdviceReturn();

            @Override // net.bytebuddy.asm.Advice.AdviceVisitor
            public void onUserEnd() {
                this.mv.visitLabel(this.returnHandler);
                onUserReturn();
                this.stackMapFrameHandler.injectCompletionFrame(this.mv);
                this.methodExit.apply();
                onExitAdviceReturn();
                if (this.instrumentedMethod.getReturnType().represents(Boolean.TYPE)
                        || this.instrumentedMethod.getReturnType().represents(Byte.TYPE)
                        || this.instrumentedMethod.getReturnType().represents(Short.TYPE)
                        || this.instrumentedMethod.getReturnType().represents(Character.TYPE)
                        || this.instrumentedMethod.getReturnType().represents(Integer.TYPE)) {
                    this.mv.visitVarInsn(21, this.argumentHandler.returned());
                    this.mv.visitInsn(172);
                } else if (this.instrumentedMethod.getReturnType().represents(Long.TYPE)) {
                    this.mv.visitVarInsn(22, this.argumentHandler.returned());
                    this.mv.visitInsn(173);
                } else if (this.instrumentedMethod.getReturnType().represents(Float.TYPE)) {
                    this.mv.visitVarInsn(23, this.argumentHandler.returned());
                    this.mv.visitInsn(174);
                } else if (this.instrumentedMethod.getReturnType().represents(Double.TYPE)) {
                    this.mv.visitVarInsn(24, this.argumentHandler.returned());
                    this.mv.visitInsn(175);
                } else if (this.instrumentedMethod.getReturnType().represents(Void.TYPE)) {
                    this.mv.visitInsn(177);
                } else {
                    this.mv.visitVarInsn(25, this.argumentHandler.returned());
                    this.mv.visitInsn(176);
                }
                this.methodSizeHandler
                        .requireStackSize(this.instrumentedMethod.getReturnType().getStackSize().getSize());
            }

            public abstract void onUserReturn();

            @Override // net.bytebuddy.utility.visitor.ExceptionTableSensitiveMethodVisitor
            public void onVisitInsn(int i) {
                switch (i) {
                    case 172:
                        this.methodSizeHandler.requireLocalVariableLength(
                                ((StackAwareMethodVisitor) this.mv).drainStack(54, 21, StackSize.SINGLE));
                        break;
                    case 173:
                        this.methodSizeHandler.requireLocalVariableLength(
                                ((StackAwareMethodVisitor) this.mv).drainStack(55, 22, StackSize.DOUBLE));
                        break;
                    case 174:
                        this.methodSizeHandler.requireLocalVariableLength(
                                ((StackAwareMethodVisitor) this.mv).drainStack(56, 23, StackSize.SINGLE));
                        break;
                    case 175:
                        this.methodSizeHandler.requireLocalVariableLength(
                                ((StackAwareMethodVisitor) this.mv).drainStack(57, 24, StackSize.DOUBLE));
                        break;
                    case 176:
                        this.methodSizeHandler.requireLocalVariableLength(
                                ((StackAwareMethodVisitor) this.mv).drainStack(58, 25, StackSize.SINGLE));
                        break;
                    case 177:
                        ((StackAwareMethodVisitor) this.mv).drainStack();
                        break;
                    default:
                        this.mv.visitInsn(i);
                        return;
                }
                this.mv.visitJumpInsn(167, this.returnHandler);
            }
        }

        /*
         * JADX INFO: compiled from:
         * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
         */
        public static class WithoutExitAdvice extends AdviceVisitor {
            public WithoutExitAdvice(MethodVisitor methodVisitor, Implementation.Context context, Assigner assigner,
                    StackManipulation stackManipulation, TypeDescription typeDescription,
                    MethodDescription methodDescription, Dispatcher.Resolved.ForMethodEnter forMethodEnter, int i,
                    int i2) {
                super(methodVisitor, context, assigner, stackManipulation, typeDescription, methodDescription,
                        forMethodEnter, Dispatcher.Inactive.INSTANCE, Collections.EMPTY_LIST, i, i2);
            }

            @Override // net.bytebuddy.asm.Advice.Dispatcher.RelocationHandler.Relocation
            public void apply(MethodVisitor methodVisitor) {
                if (this.instrumentedMethod.getReturnType().represents(Boolean.TYPE)
                        || this.instrumentedMethod.getReturnType().represents(Byte.TYPE)
                        || this.instrumentedMethod.getReturnType().represents(Short.TYPE)
                        || this.instrumentedMethod.getReturnType().represents(Character.TYPE)
                        || this.instrumentedMethod.getReturnType().represents(Integer.TYPE)) {
                    methodVisitor.visitInsn(3);
                    methodVisitor.visitInsn(172);
                    return;
                }
                if (this.instrumentedMethod.getReturnType().represents(Long.TYPE)) {
                    methodVisitor.visitInsn(9);
                    methodVisitor.visitInsn(173);
                    return;
                }
                if (this.instrumentedMethod.getReturnType().represents(Float.TYPE)) {
                    methodVisitor.visitInsn(11);
                    methodVisitor.visitInsn(174);
                } else if (this.instrumentedMethod.getReturnType().represents(Double.TYPE)) {
                    methodVisitor.visitInsn(14);
                    methodVisitor.visitInsn(175);
                } else if (this.instrumentedMethod.getReturnType().represents(Void.TYPE)) {
                    methodVisitor.visitInsn(177);
                } else {
                    methodVisitor.visitInsn(1);
                    methodVisitor.visitInsn(176);
                }
            }

            @Override // net.bytebuddy.asm.Advice.AdviceVisitor
            public void onUserEnd() {
            }

            @Override // net.bytebuddy.asm.Advice.AdviceVisitor
            public void onUserPrepare() {
            }

            @Override // net.bytebuddy.asm.Advice.AdviceVisitor
            public void onUserStart() {
            }
        }

        public AdviceVisitor(MethodVisitor methodVisitor, Implementation.Context context, Assigner assigner,
                StackManipulation stackManipulation, TypeDescription typeDescription,
                MethodDescription methodDescription, Dispatcher.Resolved.ForMethodEnter forMethodEnter,
                Dispatcher.Resolved.ForMethodExit forMethodExit, List<? extends TypeDescription> list, int i, int i2) {
            super(OpenedClassReader.ASM_API, methodVisitor);
            this.instrumentedMethod = methodDescription;
            Label label = new Label();
            this.preparationStart = label;
            TreeMap treeMap = new TreeMap();
            treeMap.putAll(forMethodEnter.getNamedTypes());
            treeMap.putAll(forMethodExit.getNamedTypes());
            ArgumentHandler.ForInstrumentedMethod forInstrumentedMethodResolve = forMethodExit
                    .getArgumentHandlerFactory()
                    .resolve(methodDescription, forMethodEnter.getAdviceType(), forMethodExit.getAdviceType(), treeMap);
            this.argumentHandler = forInstrumentedMethodResolve;
            TypeDefinition adviceType = forMethodExit.getAdviceType();
            Class cls = Void.TYPE;
            List listOf = CompoundList.of(
                    adviceType.represents(cls) ? Collections.EMPTY_LIST
                            : Collections.singletonList(forMethodExit.getAdviceType().asErasure()),
                    (List) forInstrumentedMethodResolve.getNamedTypes());
            List listSingletonList = forMethodEnter.getActualAdviceType().represents(cls) ? Collections.EMPTY_LIST
                    : Collections.singletonList(forMethodEnter.getActualAdviceType().asErasure());
            List listSingletonList2 = forMethodEnter.getAdviceType().represents(cls) ? Collections.EMPTY_LIST
                    : Collections.singletonList(forMethodEnter.getAdviceType().asErasure());
            MethodSizeHandler.ForInstrumentedMethod forInstrumentedMethodOf = MethodSizeHandler.Default.of(
                    methodDescription, listOf, listSingletonList2, list,
                    forInstrumentedMethodResolve.isCopyingArguments(), i);
            this.methodSizeHandler = forInstrumentedMethodOf;
            StackMapFrameHandler.ForInstrumentedMethod forInstrumentedMethodOf2 = StackMapFrameHandler.Default.of(
                    typeDescription, methodDescription, listOf, listSingletonList, listSingletonList2, list,
                    forMethodExit.isAlive(), forInstrumentedMethodResolve.isCopyingArguments(),
                    context.getClassFileVersion(), i, i2);
            this.stackMapFrameHandler = forInstrumentedMethodOf2;
            this.methodEnter = forMethodEnter.bind(typeDescription, methodDescription, methodVisitor, context, assigner,
                    forInstrumentedMethodResolve, forInstrumentedMethodOf, forInstrumentedMethodOf2, stackManipulation,
                    this);
            this.methodExit = forMethodExit.bind(typeDescription, methodDescription, methodVisitor, context, assigner,
                    forInstrumentedMethodResolve, forInstrumentedMethodOf, forInstrumentedMethodOf2, stackManipulation,
                    new Dispatcher.RelocationHandler.Relocation.ForLabel(label));
        }

        @Override // net.bytebuddy.utility.visitor.ExceptionTableSensitiveMethodVisitor
        public void onAfterExceptionTable() {
            this.methodEnter.prepare();
            onUserPrepare();
            this.methodExit.prepare();
            this.methodEnter.initialize();
            this.methodExit.initialize();
            this.stackMapFrameHandler.injectInitializationFrame(this.mv);
            this.methodEnter.apply();
            this.mv.visitLabel(this.preparationStart);
            this.methodSizeHandler.requireStackSize(this.argumentHandler.prepare(this.mv));
            this.stackMapFrameHandler.injectStartFrame(this.mv);
            this.mv.visitInsn(0);
            onUserStart();
        }

        public abstract void onUserEnd();

        public abstract void onUserPrepare();

        public abstract void onUserStart();

        @Override // net.bytebuddy.utility.visitor.ExceptionTableSensitiveMethodVisitor
        public void onVisitFrame(int i, int i2, @MaybeNull Object[] objArr, int i3, @MaybeNull Object[] objArr2) {
            this.stackMapFrameHandler.translateFrame(this.mv, i, i2, objArr, i3, objArr2);
        }

        @Override // net.bytebuddy.utility.visitor.ExceptionTableSensitiveMethodVisitor
        public void onVisitIincInsn(int i, int i2) {
            this.mv.visitIincInsn(this.argumentHandler.argument(i), i2);
        }

        @Override // net.bytebuddy.utility.visitor.ExceptionTableSensitiveMethodVisitor
        public void onVisitVarInsn(int i, int i2) {
            this.mv.visitVarInsn(i, this.argumentHandler.argument(i2));
        }

        @Override // net.bytebuddy.jar.asm.MethodVisitor
        public void visitLocalVariable(String str, String str2, String str3, Label label, Label label2, int i) {
            MethodVisitor methodVisitor = this.mv;
            if (i != 0 || !THIS_VARIABLE_NAME.equals(str)) {
                i = this.argumentHandler.argument(i);
            }
            methodVisitor.visitLocalVariable(str, str2, str3, label, label2, i);
        }

        @Override // net.bytebuddy.jar.asm.MethodVisitor
        public AnnotationVisitor visitLocalVariableAnnotation(int i, TypePath typePath, Label[] labelArr,
                Label[] labelArr2, int[] iArr, String str, boolean z) {
            int[] iArr2 = new int[iArr.length];
            for (int i2 = 0; i2 < iArr.length; i2++) {
                iArr2[i2] = this.argumentHandler.argument(iArr[i2]);
            }
            return this.mv.visitLocalVariableAnnotation(i, typePath, labelArr, labelArr2, iArr2, str, z);
        }

        @Override // net.bytebuddy.jar.asm.MethodVisitor
        public void visitMaxs(int i, int i2) {
            onUserEnd();
            this.mv.visitMaxs(this.methodSizeHandler.compoundStackSize(i),
                    this.methodSizeHandler.compoundLocalVariableLength(i2));
        }
    }

    /*
     * JADX INFO: compiled from:
     * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
     */
    @Target({ ElementType.PARAMETER })
    @Documented
    @Retention(RetentionPolicy.RUNTIME)
    public @interface AllArguments {
        boolean includeSelf() default false;

        boolean nullIfEmpty() default false;

        boolean readOnly() default true;

        Assigner.Typing typing() default Assigner.Typing.STATIC;
    }

    /*
     * JADX INFO: compiled from:
     * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
     */
    @HashCodeAndEqualsPlugin.Enhance
    public static class Appender implements ByteCodeAppender {
        private final Advice advice;
        private final ByteCodeAppender delegate;
        private final Implementation.Target implementationTarget;

        /*
         * JADX INFO: compiled from:
         * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
         */
        public static class EmulatingMethodVisitor extends MethodVisitor {
            private final ByteCodeAppender delegate;
            private int localVariableLength;
            private int stackSize;

            public EmulatingMethodVisitor(MethodVisitor methodVisitor, ByteCodeAppender byteCodeAppender) {
                super(OpenedClassReader.ASM_API, methodVisitor);
                this.delegate = byteCodeAppender;
            }

            public ByteCodeAppender.Size resolve(MethodVisitor methodVisitor, Implementation.Context context,
                    MethodDescription methodDescription) {
                methodVisitor.visitCode();
                ByteCodeAppender.Size sizeApply = this.delegate.apply(methodVisitor, context, methodDescription);
                methodVisitor.visitMaxs(sizeApply.getOperandStackSize(), sizeApply.getLocalVariableSize());
                methodVisitor.visitEnd();
                return new ByteCodeAppender.Size(this.stackSize, this.localVariableLength);
            }

            @Override // net.bytebuddy.jar.asm.MethodVisitor
            public void visitCode() {
            }

            @Override // net.bytebuddy.jar.asm.MethodVisitor
            public void visitEnd() {
            }

            @Override // net.bytebuddy.jar.asm.MethodVisitor
            public void visitMaxs(int i, int i2) {
                this.stackSize = i;
                this.localVariableLength = i2;
            }
        }

        public Appender(Advice advice, Implementation.Target target, ByteCodeAppender byteCodeAppender) {
            this.advice = advice;
            this.implementationTarget = target;
            this.delegate = byteCodeAppender;
        }

        @Override // net.bytebuddy.implementation.bytecode.ByteCodeAppender
        public ByteCodeAppender.Size apply(MethodVisitor methodVisitor, Implementation.Context context,
                MethodDescription methodDescription) {
            EmulatingMethodVisitor emulatingMethodVisitor = new EmulatingMethodVisitor(methodVisitor, this.delegate);
            return emulatingMethodVisitor.resolve(this.advice.doWrap(this.implementationTarget.getInstrumentedType(),
                    methodDescription, emulatingMethodVisitor, context, 0, 0), context, methodDescription);
        }

        public boolean equals(@MaybeNull Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            Appender appender = (Appender) obj;
            return this.advice.equals(appender.advice)
                    && this.implementationTarget.equals(appender.implementationTarget)
                    && this.delegate.equals(appender.delegate);
        }

        public int hashCode() {
            return this.delegate.hashCode() + ((this.implementationTarget.hashCode()
                    + ((this.advice.hashCode() + (getClass().hashCode() * 31)) * 31)) * 31);
        }
    }

    /*
     * JADX INFO: compiled from:
     * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
     */
    @Target({ ElementType.PARAMETER })
    @Documented
    @Retention(RetentionPolicy.RUNTIME)
    public @interface Argument {
        boolean optional() default false;

        boolean readOnly() default true;

        Assigner.Typing typing() default Assigner.Typing.STATIC;

        int value();
    }

    /*
     * JADX INFO: compiled from:
     * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
     */
    public interface ArgumentHandler {
        public static final int THIS_REFERENCE = 0;

        /*
         * JADX INFO: compiled from:
         * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
         */
        public enum Factory {
            SIMPLE { // from class: net.bytebuddy.asm.Advice.ArgumentHandler.Factory.1
                @Override // net.bytebuddy.asm.Advice.ArgumentHandler.Factory
                public ForInstrumentedMethod resolve(MethodDescription methodDescription, TypeDefinition typeDefinition,
                        TypeDefinition typeDefinition2, SortedMap<String, TypeDefinition> sortedMap) {
                    return new ForInstrumentedMethod.Default.Simple(methodDescription, typeDefinition2, sortedMap,
                            typeDefinition);
                }
            },
            COPYING { // from class: net.bytebuddy.asm.Advice.ArgumentHandler.Factory.2
                @Override // net.bytebuddy.asm.Advice.ArgumentHandler.Factory
                public ForInstrumentedMethod resolve(MethodDescription methodDescription, TypeDefinition typeDefinition,
                        TypeDefinition typeDefinition2, SortedMap<String, TypeDefinition> sortedMap) {
                    return new ForInstrumentedMethod.Default.Copying(methodDescription, typeDefinition2, sortedMap,
                            typeDefinition);
                }
            };

            public abstract ForInstrumentedMethod resolve(MethodDescription methodDescription,
                    TypeDefinition typeDefinition, TypeDefinition typeDefinition2,
                    SortedMap<String, TypeDefinition> sortedMap);
        }

        /*
         * JADX INFO: compiled from:
         * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
         */
        public interface ForAdvice extends ArgumentHandler {

            /*
             * JADX INFO: compiled from:
             * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
             */
            public static abstract class Default implements ForAdvice {
                protected final TypeDefinition exitType;
                protected final MethodDescription instrumentedMethod;
                protected final SortedMap<String, TypeDefinition> namedTypes;
                protected final MethodDescription.TypeToken typeToken;

                /*
                 * JADX INFO: compiled from:
                 * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
                 */
                @HashCodeAndEqualsPlugin.Enhance
                public static class ForMethodEnter extends Default {
                    public ForMethodEnter(MethodDescription methodDescription, MethodDescription.TypeToken typeToken,
                            TypeDefinition typeDefinition, SortedMap<String, TypeDefinition> sortedMap) {
                        super(methodDescription, typeToken, typeDefinition, sortedMap);
                    }

                    public boolean equals(@MaybeNull Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        return obj != null && getClass() == obj.getClass();
                    }

                    public int hashCode() {
                        return getClass().hashCode();
                    }

                    @Override // net.bytebuddy.asm.Advice.ArgumentHandler.ForAdvice
                    public int mapped(int i) {
                        return ((StackSize.of(this.namedTypes.values())
                                + StaticHelpers6.d(this.exitType, this.instrumentedMethod.getStackSize()))
                                - StackSize.of(this.typeToken.getParameterTypes())) + i;
                    }

                    @Override // net.bytebuddy.asm.Advice.ArgumentHandler
                    public int returned() {
                        throw new IllegalStateException("Cannot resolve the return value offset during enter advice");
                    }

                    @Override // net.bytebuddy.asm.Advice.ArgumentHandler
                    public int thrown() {
                        throw new IllegalStateException("Cannot resolve the thrown value offset during enter advice");
                    }
                }

                /*
                 * JADX INFO: compiled from:
                 * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
                 */
                @HashCodeAndEqualsPlugin.Enhance
                public static class ForMethodExit extends Default {
                    private final TypeDefinition enterType;
                    private final StackSize throwableSize;

                    public ForMethodExit(MethodDescription methodDescription, MethodDescription.TypeToken typeToken,
                            TypeDefinition typeDefinition, SortedMap<String, TypeDefinition> sortedMap,
                            TypeDefinition typeDefinition2, StackSize stackSize) {
                        super(methodDescription, typeToken, typeDefinition, sortedMap);
                        this.enterType = typeDefinition2;
                        this.throwableSize = stackSize;
                    }

                    public boolean equals(@MaybeNull Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        if (obj == null || getClass() != obj.getClass()) {
                            return false;
                        }
                        ForMethodExit forMethodExit = (ForMethodExit) obj;
                        return this.throwableSize.equals(forMethodExit.throwableSize)
                                && this.enterType.equals(forMethodExit.enterType);
                    }

                    public int hashCode() {
                        return this.throwableSize.hashCode()
                                + ((this.enterType.hashCode() + (getClass().hashCode() * 31)) * 31);
                    }

                    @Override // net.bytebuddy.asm.Advice.ArgumentHandler.ForAdvice
                    public int mapped(int i) {
                        return ((this.throwableSize.getSize()
                                + (this.instrumentedMethod.getReturnType().getStackSize().getSize() + StaticHelpers6.d(
                                        this.enterType,
                                        StackSize.of(this.namedTypes.values())
                                                + StaticHelpers6.d(this.exitType, this.instrumentedMethod.getStackSize()))))
                                - StackSize.of(this.typeToken.getParameterTypes())) + i;
                    }

                    @Override // net.bytebuddy.asm.Advice.ArgumentHandler
                    public int returned() {
                        return StaticHelpers6.d(this.enterType, StackSize.of(this.namedTypes.values())
                                + StaticHelpers6.d(this.exitType, this.instrumentedMethod.getStackSize()));
                    }

                    @Override // net.bytebuddy.asm.Advice.ArgumentHandler
                    public int thrown() {
                        return this.instrumentedMethod.getReturnType().getStackSize().getSize()
                                + StaticHelpers6.d(this.enterType, StackSize.of(this.namedTypes.values())
                                        + StaticHelpers6.d(this.exitType, this.instrumentedMethod.getStackSize()));
                    }
                }

                public Default(MethodDescription methodDescription, MethodDescription.TypeToken typeToken,
                        TypeDefinition typeDefinition, SortedMap<String, TypeDefinition> sortedMap) {
                    this.instrumentedMethod = methodDescription;
                    this.typeToken = typeToken;
                    this.exitType = typeDefinition;
                    this.namedTypes = sortedMap;
                }

                @Override // net.bytebuddy.asm.Advice.ArgumentHandler
                public int argument(int i) {
                    return i;
                }

                @Override // net.bytebuddy.asm.Advice.ArgumentHandler
                public int enter() {
                    return StackSize.of(this.namedTypes.values())
                            + StaticHelpers6.d(this.exitType, this.instrumentedMethod.getStackSize());
                }

                @Override // net.bytebuddy.asm.Advice.ArgumentHandler
                public int exit() {
                    return this.instrumentedMethod.getStackSize();
                }

                @Override // net.bytebuddy.asm.Advice.ArgumentHandler
                public int named(String str) {
                    return StackSize.of(this.namedTypes.headMap(str).values())
                            + StaticHelpers6.d(this.exitType, this.instrumentedMethod.getStackSize());
                }
            }

            int mapped(int i);
        }

        /*
         * JADX INFO: compiled from:
         * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
         */
        public interface ForInstrumentedMethod extends ArgumentHandler {

            /*
             * JADX INFO: compiled from:
             * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
             */
            public static abstract class Default implements ForInstrumentedMethod {
                protected final TypeDefinition enterType;
                protected final TypeDefinition exitType;
                protected final MethodDescription instrumentedMethod;
                protected final SortedMap<String, TypeDefinition> namedTypes;

                /*
                 * JADX INFO: compiled from:
                 * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
                 */
                @HashCodeAndEqualsPlugin.Enhance
                public static class Copying extends Default {
                    public Copying(MethodDescription methodDescription, TypeDefinition typeDefinition,
                            SortedMap<String, TypeDefinition> sortedMap, TypeDefinition typeDefinition2) {
                        super(methodDescription, typeDefinition, sortedMap, typeDefinition2);
                    }

                    @Override // net.bytebuddy.asm.Advice.ArgumentHandler
                    public int argument(int i) {
                        return this.enterType.getStackSize().getSize() + StackSize.of(this.namedTypes.values())
                                + StaticHelpers6.d(this.exitType, this.instrumentedMethod.getStackSize()) + i;
                    }

                    public boolean equals(@MaybeNull Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        return obj != null && getClass() == obj.getClass();
                    }

                    public int hashCode() {
                        return getClass().hashCode();
                    }

                    @Override // net.bytebuddy.asm.Advice.ArgumentHandler.ForInstrumentedMethod
                    public boolean isCopyingArguments() {
                        return true;
                    }

                    @Override // net.bytebuddy.asm.Advice.ArgumentHandler.ForInstrumentedMethod
                    public int prepare(MethodVisitor methodVisitor) {
                        StackSize stackSizeMaximum;
                        if (this.instrumentedMethod.isStatic()) {
                            stackSizeMaximum = StackSize.ZERO;
                        } else {
                            methodVisitor.visitVarInsn(25, 0);
                            methodVisitor.visitVarInsn(58,
                                    this.enterType.getStackSize().getSize() + StackSize.of(this.namedTypes.values())
                                            + StaticHelpers6.d(this.exitType, this.instrumentedMethod.getStackSize()));
                            stackSizeMaximum = StackSize.SINGLE;
                        }
                        Iterator<?> it = this.instrumentedMethod.getParameters().iterator();
                        while (it.hasNext()) {
                            ParameterDescription parameterDescription = (ParameterDescription) it.next();
                            Type type = Type.getType(parameterDescription.getType().asErasure().getDescriptor());
                            methodVisitor.visitVarInsn(type.getOpcode(21), parameterDescription.getOffset());
                            methodVisitor.visitVarInsn(type.getOpcode(54),
                                    parameterDescription.getOffset()
                                            + StaticHelpers6.d(this.enterType, StackSize.of(this.namedTypes.values())
                                                    + StaticHelpers6.d(this.exitType, this.instrumentedMethod.getStackSize())));
                            stackSizeMaximum = stackSizeMaximum.maximum(parameterDescription.getType().getStackSize());
                        }
                        return stackSizeMaximum.getSize();
                    }
                }

                /*
                 * JADX INFO: compiled from:
                 * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
                 */
                @HashCodeAndEqualsPlugin.Enhance
                public static class Simple extends Default {
                    public Simple(MethodDescription methodDescription, TypeDefinition typeDefinition,
                            SortedMap<String, TypeDefinition> sortedMap, TypeDefinition typeDefinition2) {
                        super(methodDescription, typeDefinition, sortedMap, typeDefinition2);
                    }

                    @Override // net.bytebuddy.asm.Advice.ArgumentHandler
                    public int argument(int i) {
                        if (i < this.instrumentedMethod.getStackSize()) {
                            return i;
                        }
                        return StaticHelpers6.d(this.enterType, StackSize.of(this.namedTypes.values()) + StaticHelpers6.d(this.exitType, i));
                    }

                    public boolean equals(@MaybeNull Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        return obj != null && getClass() == obj.getClass();
                    }

                    public int hashCode() {
                        return getClass().hashCode();
                    }

                    @Override // net.bytebuddy.asm.Advice.ArgumentHandler.ForInstrumentedMethod
                    public boolean isCopyingArguments() {
                        return false;
                    }

                    @Override // net.bytebuddy.asm.Advice.ArgumentHandler.ForInstrumentedMethod
                    public int prepare(MethodVisitor methodVisitor) {
                        return 0;
                    }
                }

                public Default(MethodDescription methodDescription, TypeDefinition typeDefinition,
                        SortedMap<String, TypeDefinition> sortedMap, TypeDefinition typeDefinition2) {
                    this.instrumentedMethod = methodDescription;
                    this.namedTypes = sortedMap;
                    this.exitType = typeDefinition;
                    this.enterType = typeDefinition2;
                }

                @Override // net.bytebuddy.asm.Advice.ArgumentHandler.ForInstrumentedMethod
                public ForAdvice bindEnter(MethodDescription.TypeToken typeToken) {
                    return new ForAdvice.Default.ForMethodEnter(this.instrumentedMethod, typeToken, this.exitType,
                            this.namedTypes);
                }

                @Override // net.bytebuddy.asm.Advice.ArgumentHandler.ForInstrumentedMethod
                public ForAdvice bindExit(MethodDescription.TypeToken typeToken, boolean z) {
                    return new ForAdvice.Default.ForMethodExit(this.instrumentedMethod, typeToken, this.exitType,
                            this.namedTypes, this.enterType, z ? StackSize.ZERO : StackSize.SINGLE);
                }

                @Override // net.bytebuddy.asm.Advice.ArgumentHandler
                public int enter() {
                    return StackSize.of(this.namedTypes.values())
                            + StaticHelpers6.d(this.exitType, this.instrumentedMethod.getStackSize());
                }

                @Override // net.bytebuddy.asm.Advice.ArgumentHandler
                public int exit() {
                    return this.instrumentedMethod.getStackSize();
                }

                @Override // net.bytebuddy.asm.Advice.ArgumentHandler.ForInstrumentedMethod
                public List<TypeDescription> getNamedTypes() {
                    ArrayList arrayList = new ArrayList(this.namedTypes.size());
                    Iterator<TypeDefinition> it = this.namedTypes.values().iterator();
                    while (it.hasNext()) {
                        arrayList.add(it.next().asErasure());
                    }
                    return arrayList;
                }

                @Override // net.bytebuddy.asm.Advice.ArgumentHandler
                public int named(String str) {
                    return StackSize.of(this.namedTypes.headMap(str).values())
                            + StaticHelpers6.d(this.exitType, this.instrumentedMethod.getStackSize());
                }

                @Override // net.bytebuddy.asm.Advice.ArgumentHandler
                public int returned() {
                    return StaticHelpers6.d(this.enterType, StackSize.of(this.namedTypes.values())
                            + StaticHelpers6.d(this.exitType, this.instrumentedMethod.getStackSize()));
                }

                @Override // net.bytebuddy.asm.Advice.ArgumentHandler
                public int thrown() {
                    return this.instrumentedMethod.getReturnType().getStackSize().getSize()
                            + StaticHelpers6.d(this.enterType, StackSize.of(this.namedTypes.values())
                                    + StaticHelpers6.d(this.exitType, this.instrumentedMethod.getStackSize()));
                }
            }

            ForAdvice bindEnter(MethodDescription.TypeToken typeToken);

            ForAdvice bindExit(MethodDescription.TypeToken typeToken, boolean z);

            List<TypeDescription> getNamedTypes();

            boolean isCopyingArguments();

            int prepare(MethodVisitor methodVisitor);
        }

        int argument(int i);

        int enter();

        int exit();

        int named(String str);

        int returned();

        int thrown();
    }

    /*
     * JADX INFO: compiled from:
     * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
     */
    @HashCodeAndEqualsPlugin.Enhance
    public static abstract class AssignReturned implements PostProcessor {
        public static final int NO_INDEX = -1;
        protected final ExceptionHandler.Factory exceptionHandlerFactory;
        protected final boolean exit;
        protected final boolean skipOnDefaultValue;
        protected final TypeDescription typeDescription;

        /*
         * JADX INFO: compiled from:
         * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
         */
        @Target({ ElementType.METHOD })
        @Documented
        @Retention(RetentionPolicy.RUNTIME)
        public @interface AsScalar {
            boolean skipOnDefaultValue() default true;
        }

        /*
         * JADX INFO: compiled from:
         * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
         */
        @HashCodeAndEqualsPlugin.Enhance
        public static class DefaultValueSkip implements StackManipulation {
            private final Dispatcher dispatcher;
            private final int offset;
            private final StackManipulation stackManipulation;
            private final StackMapFrameHandler.ForPostProcessor stackMapFrameHandler;

            /*
             * JADX INFO: compiled from:
             * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
             */
            public enum Dispatcher {
                INTEGER { // from class:
                          // net.bytebuddy.asm.Advice.AssignReturned.DefaultValueSkip.Dispatcher.1
                    @Override // net.bytebuddy.asm.Advice.AssignReturned.DefaultValueSkip.Dispatcher
                    public StackManipulation.Size apply(MethodVisitor methodVisitor, int i, Label label) {
                        methodVisitor.visitVarInsn(21, i);
                        methodVisitor.visitJumpInsn(153, label);
                        return new StackManipulation.Size(0, 1);
                    }
                },
                LONG { // from class:
                       // net.bytebuddy.asm.Advice.AssignReturned.DefaultValueSkip.Dispatcher.2
                    @Override // net.bytebuddy.asm.Advice.AssignReturned.DefaultValueSkip.Dispatcher
                    public StackManipulation.Size apply(MethodVisitor methodVisitor, int i, Label label) {
                        methodVisitor.visitVarInsn(22, i);
                        methodVisitor.visitInsn(9);
                        methodVisitor.visitInsn(148);
                        methodVisitor.visitJumpInsn(153, label);
                        return new StackManipulation.Size(0, 4);
                    }
                },
                FLOAT { // from class:
                        // net.bytebuddy.asm.Advice.AssignReturned.DefaultValueSkip.Dispatcher.3
                    @Override // net.bytebuddy.asm.Advice.AssignReturned.DefaultValueSkip.Dispatcher
                    public StackManipulation.Size apply(MethodVisitor methodVisitor, int i, Label label) {
                        methodVisitor.visitVarInsn(23, i);
                        methodVisitor.visitInsn(11);
                        methodVisitor.visitInsn(149);
                        methodVisitor.visitJumpInsn(153, label);
                        return new StackManipulation.Size(0, 2);
                    }
                },
                DOUBLE { // from class:
                         // net.bytebuddy.asm.Advice.AssignReturned.DefaultValueSkip.Dispatcher.4
                    @Override // net.bytebuddy.asm.Advice.AssignReturned.DefaultValueSkip.Dispatcher
                    public StackManipulation.Size apply(MethodVisitor methodVisitor, int i, Label label) {
                        methodVisitor.visitVarInsn(24, i);
                        methodVisitor.visitInsn(14);
                        methodVisitor.visitInsn(151);
                        methodVisitor.visitJumpInsn(153, label);
                        return new StackManipulation.Size(0, 4);
                    }
                },
                REFERENCE { // from class:
                            // net.bytebuddy.asm.Advice.AssignReturned.DefaultValueSkip.Dispatcher.5
                    @Override // net.bytebuddy.asm.Advice.AssignReturned.DefaultValueSkip.Dispatcher
                    public StackManipulation.Size apply(MethodVisitor methodVisitor, int i, Label label) {
                        methodVisitor.visitVarInsn(25, i);
                        methodVisitor.visitJumpInsn(198, label);
                        return new StackManipulation.Size(0, 2);
                    }
                };

                public abstract StackManipulation.Size apply(MethodVisitor methodVisitor, int i, Label label);
            }

            public DefaultValueSkip(StackManipulation stackManipulation,
                    StackMapFrameHandler.ForPostProcessor forPostProcessor, int i, Dispatcher dispatcher) {
                this.stackManipulation = stackManipulation;
                this.stackMapFrameHandler = forPostProcessor;
                this.offset = i;
                this.dispatcher = dispatcher;
            }

            public static StackManipulation of(StackManipulation stackManipulation,
                    StackMapFrameHandler.ForPostProcessor forPostProcessor, int i, TypeDefinition typeDefinition) {
                Dispatcher dispatcher;
                if (!typeDefinition.isPrimitive()) {
                    dispatcher = Dispatcher.REFERENCE;
                } else if (typeDefinition.represents(Boolean.TYPE) || typeDefinition.represents(Byte.TYPE)
                        || typeDefinition.represents(Short.TYPE) || typeDefinition.represents(Character.TYPE)
                        || typeDefinition.represents(Integer.TYPE)) {
                    dispatcher = Dispatcher.INTEGER;
                } else if (typeDefinition.represents(Long.TYPE)) {
                    dispatcher = Dispatcher.LONG;
                } else if (typeDefinition.represents(Float.TYPE)) {
                    dispatcher = Dispatcher.FLOAT;
                } else {
                    if (!typeDefinition.represents(Double.TYPE)) {
                        throw new IllegalArgumentException("Cannot apply skip for " + typeDefinition);
                    }
                    dispatcher = Dispatcher.DOUBLE;
                }
                return new DefaultValueSkip(stackManipulation, forPostProcessor, i, dispatcher);
            }

            @Override // net.bytebuddy.implementation.bytecode.StackManipulation
            public StackManipulation.Size apply(MethodVisitor methodVisitor, Implementation.Context context) {
                Label label = new Label();
                StackManipulation.Size sizeAggregate = this.dispatcher.apply(methodVisitor, this.offset, label)
                        .aggregate(this.stackManipulation.apply(methodVisitor, context));
                methodVisitor.visitInsn(0);
                methodVisitor.visitLabel(label);
                this.stackMapFrameHandler.injectIntermediateFrame(methodVisitor, Collections.EMPTY_LIST);
                methodVisitor.visitInsn(0);
                return sizeAggregate;
            }

            public boolean equals(@MaybeNull Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || getClass() != obj.getClass()) {
                    return false;
                }
                DefaultValueSkip defaultValueSkip = (DefaultValueSkip) obj;
                return this.offset == defaultValueSkip.offset && this.dispatcher.equals(defaultValueSkip.dispatcher)
                        && this.stackManipulation.equals(defaultValueSkip.stackManipulation)
                        && this.stackMapFrameHandler.equals(defaultValueSkip.stackMapFrameHandler);
            }

            public int hashCode() {
                return this.dispatcher.hashCode() + ((((this.stackMapFrameHandler.hashCode()
                        + StaticHelpers6.g(this.stackManipulation, getClass().hashCode() * 31, 31)) * 31) + this.offset) * 31);
            }

            @Override // net.bytebuddy.implementation.bytecode.StackManipulation
            public boolean isValid() {
                return this.stackManipulation.isValid();
            }
        }

        /*
         * JADX INFO: compiled from:
         * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
         */
        @HashCodeAndEqualsPlugin.Enhance
        public static class ExceptionHandler implements StackManipulation {
            private final StackManipulation exceptionHandler;
            private final TypeDescription exceptionType;
            private final StackManipulation stackManipulation;
            private final StackMapFrameHandler.ForPostProcessor stackMapFrameHandler;

            /*
             * JADX INFO: compiled from:
             * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
             */
            public interface Factory {

                /*
                 * JADX INFO: compiled from:
                 * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
                 */
                @HashCodeAndEqualsPlugin.Enhance
                public static class Enabled implements Factory {
                    private final TypeDescription exceptionType;

                    public Enabled(TypeDescription typeDescription) {
                        this.exceptionType = typeDescription;
                    }

                    public boolean equals(@MaybeNull Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        return obj != null && getClass() == obj.getClass()
                                && this.exceptionType.equals(((Enabled) obj).exceptionType);
                    }

                    public int hashCode() {
                        return this.exceptionType.hashCode() + (getClass().hashCode() * 31);
                    }

                    @Override // net.bytebuddy.asm.Advice.AssignReturned.ExceptionHandler.Factory
                    public StackManipulation wrap(StackManipulation stackManipulation,
                            StackManipulation stackManipulation2,
                            StackMapFrameHandler.ForPostProcessor forPostProcessor) {
                        return new ExceptionHandler(stackManipulation, stackManipulation2, this.exceptionType,
                                forPostProcessor);
                    }
                }

                /*
                 * JADX INFO: compiled from:
                 * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
                 */
                public enum NoOp implements Factory {
                    INSTANCE;

                    @Override // net.bytebuddy.asm.Advice.AssignReturned.ExceptionHandler.Factory
                    public StackManipulation wrap(StackManipulation stackManipulation,
                            StackManipulation stackManipulation2,
                            StackMapFrameHandler.ForPostProcessor forPostProcessor) {
                        return stackManipulation;
                    }
                }

                StackManipulation wrap(StackManipulation stackManipulation, StackManipulation stackManipulation2,
                        StackMapFrameHandler.ForPostProcessor forPostProcessor);
            }

            public ExceptionHandler(StackManipulation stackManipulation, StackManipulation stackManipulation2,
                    TypeDescription typeDescription, StackMapFrameHandler.ForPostProcessor forPostProcessor) {
                this.stackManipulation = stackManipulation;
                this.exceptionHandler = stackManipulation2;
                this.exceptionType = typeDescription;
                this.stackMapFrameHandler = forPostProcessor;
            }

            @Override // net.bytebuddy.implementation.bytecode.StackManipulation
            public StackManipulation.Size apply(MethodVisitor methodVisitor, Implementation.Context context) {
                Label label = new Label();
                Label label2 = new Label();
                Label label3 = new Label();
                methodVisitor.visitTryCatchBlock(label, label2, label2, this.exceptionType.getInternalName());
                methodVisitor.visitLabel(label);
                StackManipulation.Size sizeApply = this.stackManipulation.apply(methodVisitor, context);
                methodVisitor.visitJumpInsn(167, label3);
                methodVisitor.visitLabel(label2);
                this.stackMapFrameHandler.injectIntermediateFrame(methodVisitor,
                        Collections.singletonList(this.exceptionType));
                StackManipulation.Size sizeAggregate = this.exceptionHandler.apply(methodVisitor, context)
                        .aggregate(sizeApply);
                methodVisitor.visitLabel(label3);
                this.stackMapFrameHandler.injectIntermediateFrame(methodVisitor, Collections.EMPTY_LIST);
                return sizeAggregate;
            }

            public boolean equals(@MaybeNull Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || getClass() != obj.getClass()) {
                    return false;
                }
                ExceptionHandler exceptionHandler = (ExceptionHandler) obj;
                return this.stackManipulation.equals(exceptionHandler.stackManipulation)
                        && this.exceptionHandler.equals(exceptionHandler.exceptionHandler)
                        && this.exceptionType.equals(exceptionHandler.exceptionType)
                        && this.stackMapFrameHandler.equals(exceptionHandler.stackMapFrameHandler);
            }

            public int hashCode() {
                return this.stackMapFrameHandler.hashCode() + StaticHelpers6.f(this.exceptionType,
                        StaticHelpers6.g(this.exceptionHandler, StaticHelpers6.g(this.stackManipulation, getClass().hashCode() * 31, 31), 31),
                        31);
            }

            @Override // net.bytebuddy.implementation.bytecode.StackManipulation
            public boolean isValid() {
                return this.stackManipulation.isValid() && this.exceptionHandler.isValid();
            }
        }

        /*
         * JADX INFO: compiled from:
         * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
         */
        @HashCodeAndEqualsPlugin.Enhance
        public static class Factory implements PostProcessor.Factory {
            private static final MethodDescription.InDefinedShape SKIP_ON_DEFAULT_VALUE = (MethodDescription.InDefinedShape) TypeDescription.ForLoadedType
                    .of(AsScalar.class).getDeclaredMethods().filter(ElementMatchers.named("skipOnDefaultValue"))
                    .getOnly();
            private final ExceptionHandler.Factory exceptionHandlerFactory;
            private final List<? extends Handler.Factory<?>> factories;

            public Factory() {
                this(Arrays.asList(ToArguments.Handler.Factory.INSTANCE, ToAllArguments.Handler.Factory.INSTANCE,
                        ToThis.Handler.Factory.INSTANCE, ToFields.Handler.Factory.INSTANCE,
                        ToReturned.Handler.Factory.INSTANCE, ToThrown.Handler.Factory.INSTANCE),
                        ExceptionHandler.Factory.NoOp.INSTANCE);
            }

            public boolean equals(@MaybeNull Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || getClass() != obj.getClass()) {
                    return false;
                }
                Factory factory = (Factory) obj;
                return this.factories.equals(factory.factories)
                        && this.exceptionHandlerFactory.equals(factory.exceptionHandlerFactory);
            }

            public int hashCode() {
                return this.exceptionHandlerFactory.hashCode() + bjs.g(this.factories, getClass().hashCode() * 31, 31);
            }

            @Override // net.bytebuddy.asm.Advice.PostProcessor.Factory
            public PostProcessor make(List<? extends AnnotationDescription> list, TypeDescription typeDescription,
                    boolean z) {
                if (typeDescription.represents(Void.TYPE)) {
                    return PostProcessor.NoOp.INSTANCE;
                }
                HashMap map = new HashMap();
                for (Handler.Factory<?> factory : this.factories) {
                    if (map.put(factory.getAnnotationType().getName(), factory) != null) {
                        throw new IllegalStateException(
                                "Duplicate registration of handler for " + factory.getAnnotationType());
                    }
                }
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                boolean z2 = false;
                boolean zBooleanValue = true;
                for (AnnotationDescription annotationDescription : list) {
                    if (annotationDescription.getAnnotationType().represents(AsScalar.class)) {
                        zBooleanValue = ((Boolean) annotationDescription.getValue(SKIP_ON_DEFAULT_VALUE)
                                .resolve(Boolean.class)).booleanValue();
                        z2 = true;
                    } else {
                        Handler.Factory factory2 = (Handler.Factory) map
                                .get(annotationDescription.getAnnotationType().getName());
                        if (factory2 != null
                                && linkedHashMap.put(factory2.getAnnotationType(), factory2.make(typeDescription, z,
                                        annotationDescription.prepare(factory2.getAnnotationType()))) != null) {
                            throw new IllegalStateException(
                                    "Duplicate handler registration for " + annotationDescription.getAnnotationType());
                        }
                    }
                }
                return linkedHashMap.isEmpty() ? PostProcessor.NoOp.INSTANCE
                        : (z2 || !typeDescription.isArray())
                                ? new ForScalar(typeDescription, this.exceptionHandlerFactory, z, zBooleanValue,
                                        linkedHashMap.values())
                                : new ForArray(typeDescription, this.exceptionHandlerFactory, z,
                                        linkedHashMap.values());
            }

            public Factory with(Class<? extends Annotation> cls, Handler... handlerArr) {
                return with(cls, Arrays.asList(handlerArr));
            }

            public PostProcessor.Factory withSuppressed(Class<? extends Throwable> cls) {
                return withSuppressed(TypeDescription.ForLoadedType.of(cls));
            }

            public Factory(List<? extends Handler.Factory<?>> list, ExceptionHandler.Factory factory) {
                this.factories = list;
                this.exceptionHandlerFactory = factory;
            }

            public Factory with(Class<? extends Annotation> cls, List<Handler> list) {
                return with(new Handler.Factory.Simple(cls, list));
            }

            public PostProcessor.Factory withSuppressed(TypeDescription typeDescription) {
                if (typeDescription.isAssignableTo(Throwable.class)) {
                    return new Factory(this.factories, new ExceptionHandler.Factory.Enabled(typeDescription));
                }
                throw new IllegalArgumentException(StaticHelpers6.concat(typeDescription, " is not a throwable type"));
            }

            public Factory with(Handler.Factory<?> factory) {
                return new Factory(CompoundList.of(this.factories, factory), this.exceptionHandlerFactory);
            }
        }

        /*
         * JADX INFO: compiled from:
         * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
         */
        @HashCodeAndEqualsPlugin.Enhance
        public static class ForArray extends AssignReturned {
            private final Map<Handler, Integer> handlers;

            public ForArray(TypeDescription typeDescription, ExceptionHandler.Factory factory, boolean z,
                    Collection<List<Handler>> collection) {
                super(typeDescription, factory, z, true);
                this.handlers = new LinkedHashMap();
                Iterator<List<Handler>> it = collection.iterator();
                while (it.hasNext()) {
                    for (Handler handler : it.next()) {
                        int index = handler.getIndex();
                        if (index <= -1) {
                            throw new IllegalStateException("Handler on array requires positive index for " + handler);
                        }
                        this.handlers.put(handler, Integer.valueOf(index));
                    }
                }
            }

            @Override // net.bytebuddy.asm.Advice.AssignReturned
            public boolean equals(@MaybeNull Object obj) {
                if (!super.equals(obj)) {
                    return false;
                }
                if (this == obj) {
                    return true;
                }
                return obj != null && getClass() == obj.getClass() && this.handlers.equals(((ForArray) obj).handlers);
            }

            @Override // net.bytebuddy.asm.Advice.AssignReturned
            public Collection<Handler> getHandlers() {
                return this.handlers.keySet();
            }

            @Override // net.bytebuddy.asm.Advice.AssignReturned
            public TypeDescription getType() {
                return this.typeDescription.getComponentType();
            }

            @Override // net.bytebuddy.asm.Advice.AssignReturned
            public int hashCode() {
                return this.handlers.hashCode() + (super.hashCode() * 31);
            }

            @Override // net.bytebuddy.asm.Advice.AssignReturned
            public StackManipulation toLoadInstruction(Handler handler, int i) {
                return new StackManipulation.Compound(MethodVariableAccess.REFERENCE.loadFrom(i),
                        IntegerConstant.forValue(this.handlers.get(handler).intValue()),
                        ArrayAccess.of(this.typeDescription.getComponentType()).load());
            }
        }

        /*
         * JADX INFO: compiled from:
         * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
         */
        @HashCodeAndEqualsPlugin.Enhance
        public static class ForScalar extends AssignReturned {
            private final List<Handler> handlers;

            public ForScalar(TypeDescription typeDescription, ExceptionHandler.Factory factory, boolean z, boolean z2,
                    Collection<List<Handler>> collection) {
                super(typeDescription, factory, z, z2);
                this.handlers = new ArrayList();
                Iterator<List<Handler>> it = collection.iterator();
                while (it.hasNext()) {
                    for (Handler handler : it.next()) {
                        if (handler.getIndex() > -1) {
                            throw new IllegalStateException("Handler on array requires negative index for " + handler);
                        }
                        this.handlers.add(handler);
                    }
                }
            }

            @Override // net.bytebuddy.asm.Advice.AssignReturned
            public boolean equals(@MaybeNull Object obj) {
                if (!super.equals(obj)) {
                    return false;
                }
                if (this == obj) {
                    return true;
                }
                return obj != null && getClass() == obj.getClass() && this.handlers.equals(((ForScalar) obj).handlers);
            }

            @Override // net.bytebuddy.asm.Advice.AssignReturned
            public Collection<Handler> getHandlers() {
                return this.handlers;
            }

            @Override // net.bytebuddy.asm.Advice.AssignReturned
            public TypeDescription getType() {
                return this.typeDescription;
            }

            @Override // net.bytebuddy.asm.Advice.AssignReturned
            public int hashCode() {
                return this.handlers.hashCode() + (super.hashCode() * 31);
            }

            @Override // net.bytebuddy.asm.Advice.AssignReturned
            public StackManipulation toLoadInstruction(Handler handler, int i) {
                return MethodVariableAccess.of(this.typeDescription).loadFrom(i);
            }
        }

        /*
         * JADX INFO: compiled from:
         * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
         */
        public interface Handler {

            /*
             * JADX INFO: compiled from:
             * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
             */
            public interface Factory<T extends Annotation> {

                /*
                 * JADX INFO: compiled from:
                 * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
                 */
                @HashCodeAndEqualsPlugin.Enhance
                public static class Simple<S extends Annotation> implements Factory<S> {
                    private final List<Handler> handlers;
                    private final Class<S> type;

                    public Simple(Class<S> cls, List<Handler> list) {
                        this.type = cls;
                        this.handlers = list;
                    }

                    public boolean equals(@MaybeNull Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        if (obj == null || getClass() != obj.getClass()) {
                            return false;
                        }
                        Simple simple = (Simple) obj;
                        return this.type.equals(simple.type) && this.handlers.equals(simple.handlers);
                    }

                    @Override // net.bytebuddy.asm.Advice.AssignReturned.Handler.Factory
                    public Class<S> getAnnotationType() {
                        return this.type;
                    }

                    public int hashCode() {
                        return this.handlers.hashCode() + bjs.d(getClass().hashCode() * 31, 31, this.type);
                    }

                    @Override // net.bytebuddy.asm.Advice.AssignReturned.Handler.Factory
                    public List<Handler> make(TypeDescription typeDescription, boolean z,
                            AnnotationDescription.Loadable<? extends S> loadable) {
                        return this.handlers;
                    }
                }

                Class<T> getAnnotationType();

                List<Handler> make(TypeDescription typeDescription, boolean z,
                        AnnotationDescription.Loadable<? extends T> loadable);
            }

            int getIndex();

            StackManipulation resolve(TypeDescription typeDescription, MethodDescription methodDescription,
                    Assigner assigner, ArgumentHandler argumentHandler, TypeDescription typeDescription2,
                    StackManipulation stackManipulation);
        }

        /*
         * JADX INFO: compiled from:
         * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
         */
        @Target({ ElementType.METHOD })
        @Documented
        @Retention(RetentionPolicy.RUNTIME)
        public @interface ToAllArguments {

            /*
             * JADX INFO: compiled from:
             * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
             */
            @HashCodeAndEqualsPlugin.Enhance
            public static class Handler implements Handler {
                private final int index;
                private final Assigner.Typing typing;

                /*
                 * JADX INFO: compiled from:
                 * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
                 */
                public enum Factory implements Handler.Factory<ToAllArguments> {
                    INSTANCE;

                    private static final MethodDescription.InDefinedShape TO_ALL_ARGUMENTS_INDEX;
                    private static final MethodDescription.InDefinedShape TO_ALL_ARGUMENTS_TYPING;

                    static {
                        MethodList<MethodDescription.InDefinedShape> declaredMethods = TypeDescription.ForLoadedType
                                .of(ToAllArguments.class).getDeclaredMethods();
                        TO_ALL_ARGUMENTS_INDEX = (MethodDescription.InDefinedShape) declaredMethods
                                .filter(ElementMatchers.named(com.umeng.ccg.a.H)).getOnly();
                        TO_ALL_ARGUMENTS_TYPING = (MethodDescription.InDefinedShape) declaredMethods
                                .filter(ElementMatchers.named("typing")).getOnly();
                    }

                    @Override // net.bytebuddy.asm.Advice.AssignReturned.Handler.Factory
                    public Class<ToAllArguments> getAnnotationType() {
                        return ToAllArguments.class;
                    }

                    @Override // net.bytebuddy.asm.Advice.AssignReturned.Handler.Factory
                    public List<Handler> make(TypeDescription typeDescription, boolean z,
                            AnnotationDescription.Loadable<? extends ToAllArguments> loadable) {
                        return Collections.singletonList(new Handler(
                                ((Integer) loadable.getValue(TO_ALL_ARGUMENTS_INDEX).resolve(Integer.class)).intValue(),
                                (Assigner.Typing) ((EnumerationDescription) loadable.getValue(TO_ALL_ARGUMENTS_TYPING)
                                        .resolve(EnumerationDescription.class)).load(Assigner.Typing.class)));
                    }
                }

                public Handler(int i, Assigner.Typing typing) {
                    this.index = i;
                    this.typing = typing;
                }

                public boolean equals(@MaybeNull Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (obj == null || getClass() != obj.getClass()) {
                        return false;
                    }
                    Handler handler = (Handler) obj;
                    return this.index == handler.index && this.typing.equals(handler.typing);
                }

                @Override // net.bytebuddy.asm.Advice.AssignReturned.Handler
                public int getIndex() {
                    return this.index;
                }

                public int hashCode() {
                    return this.typing.hashCode() + (((getClass().hashCode() * 31) + this.index) * 31);
                }

                @Override // net.bytebuddy.asm.Advice.AssignReturned.Handler
                public StackManipulation resolve(TypeDescription typeDescription, MethodDescription methodDescription,
                        Assigner assigner, ArgumentHandler argumentHandler, TypeDescription typeDescription2,
                        StackManipulation stackManipulation) {
                    ArrayList arrayList = new ArrayList(methodDescription.getParameters().size());
                    if (!typeDescription2.isArray()) {
                        StackManipulation stackManipulationAssign = assigner.assign(typeDescription2.asGenericType(),
                                TypeDefinition.Sort.describe(Object[].class), this.typing);
                        if (!stackManipulationAssign.isValid()) {
                            throw new IllegalStateException(
                                    "Cannot assign " + typeDescription2 + " to " + Object[].class);
                        }
                        typeDescription2 = TypeDescription.ForLoadedType.of(Object[].class);
                        stackManipulation = new StackManipulation.Compound(stackManipulation, stackManipulationAssign);
                    }
                    Iterator<?> it = methodDescription.getParameters().iterator();
                    while (it.hasNext()) {
                        ParameterDescription parameterDescription = (ParameterDescription) it.next();
                        StackManipulation stackManipulationAssign2 = assigner.assign(
                                typeDescription2.getComponentType().asGenericType(), parameterDescription.getType(),
                                this.typing);
                        if (!stackManipulationAssign2.isValid()) {
                            throw new IllegalStateException("Cannot assign " + typeDescription2.getComponentType()
                                    + " to " + parameterDescription);
                        }
                        arrayList.add(new StackManipulation.Compound(stackManipulationAssign2,
                                MethodVariableAccess.of(parameterDescription.getType())
                                        .storeAt(argumentHandler.argument(parameterDescription.getOffset()))));
                    }
                    return new StackManipulation.Compound(stackManipulation,
                            ArrayAccess.of(typeDescription2.getComponentType()).forEach(arrayList), Removal.SINGLE);
                }
            }

            int index() default -1;

            Assigner.Typing typing() default Assigner.Typing.STATIC;
        }

        /*
         * JADX INFO: compiled from:
         * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
         */
        @Target({ ElementType.METHOD })
        @Documented
        @Retention(RetentionPolicy.RUNTIME)
        public @interface ToArguments {

            /*
             * JADX INFO: compiled from:
             * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
             */
            @HashCodeAndEqualsPlugin.Enhance
            public static class Handler implements Handler {
                private final int index;
                private final Assigner.Typing typing;
                private final int value;

                /*
                 * JADX INFO: compiled from:
                 * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
                 */
                public enum Factory implements Handler.Factory<ToArguments> {
                    INSTANCE;

                    private static final MethodDescription.InDefinedShape TO_ARGUMENTS_VALUE = (MethodDescription.InDefinedShape) TypeDescription.ForLoadedType
                            .of(ToArguments.class).getDeclaredMethods().filter(ElementMatchers.named("value"))
                            .getOnly();
                    private static final MethodDescription.InDefinedShape TO_ARGUMENT_INDEX;
                    private static final MethodDescription.InDefinedShape TO_ARGUMENT_TYPING;
                    private static final MethodDescription.InDefinedShape TO_ARGUMENT_VALUE;

                    static {
                        MethodList<MethodDescription.InDefinedShape> declaredMethods = TypeDescription.ForLoadedType
                                .of(ToArgument.class).getDeclaredMethods();
                        TO_ARGUMENT_VALUE = (MethodDescription.InDefinedShape) declaredMethods
                                .filter(ElementMatchers.named("value")).getOnly();
                        TO_ARGUMENT_INDEX = (MethodDescription.InDefinedShape) declaredMethods
                                .filter(ElementMatchers.named(com.umeng.ccg.a.H)).getOnly();
                        TO_ARGUMENT_TYPING = (MethodDescription.InDefinedShape) declaredMethods
                                .filter(ElementMatchers.named("typing")).getOnly();
                    }

                    @Override // net.bytebuddy.asm.Advice.AssignReturned.Handler.Factory
                    public Class<ToArguments> getAnnotationType() {
                        return ToArguments.class;
                    }

                    @Override // net.bytebuddy.asm.Advice.AssignReturned.Handler.Factory
                    public List<Handler> make(TypeDescription typeDescription, boolean z,
                            AnnotationDescription.Loadable<? extends ToArguments> loadable) {
                        ArrayList arrayList = new ArrayList();
                        for (AnnotationDescription annotationDescription : (AnnotationDescription[]) loadable
                                .getValue(TO_ARGUMENTS_VALUE).resolve(AnnotationDescription[].class)) {
                            int iIntValue = ((Integer) annotationDescription.getValue(TO_ARGUMENT_VALUE)
                                    .resolve(Integer.class)).intValue();
                            if (iIntValue < 0) {
                                throw new IllegalStateException(
                                        StaticHelpers6.concat("An argument cannot have a negative index for ", typeDescription));
                            }
                            arrayList.add(new Handler(iIntValue,
                                    ((Integer) annotationDescription.getValue(TO_ARGUMENT_INDEX).resolve(Integer.class))
                                            .intValue(),
                                    (Assigner.Typing) ((EnumerationDescription) annotationDescription
                                            .getValue(TO_ARGUMENT_TYPING).resolve(EnumerationDescription.class))
                                            .load(Assigner.Typing.class)));
                        }
                        return arrayList;
                    }
                }

                public Handler(int i, int i2, Assigner.Typing typing) {
                    this.value = i;
                    this.index = i2;
                    this.typing = typing;
                }

                public boolean equals(@MaybeNull Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (obj == null || getClass() != obj.getClass()) {
                        return false;
                    }
                    Handler handler = (Handler) obj;
                    return this.value == handler.value && this.index == handler.index
                            && this.typing.equals(handler.typing);
                }

                @Override // net.bytebuddy.asm.Advice.AssignReturned.Handler
                public int getIndex() {
                    return this.index;
                }

                public int hashCode() {
                    return this.typing.hashCode()
                            + (((((getClass().hashCode() * 31) + this.value) * 31) + this.index) * 31);
                }

                @Override // net.bytebuddy.asm.Advice.AssignReturned.Handler
                public StackManipulation resolve(TypeDescription typeDescription, MethodDescription methodDescription,
                        Assigner assigner, ArgumentHandler argumentHandler, TypeDescription typeDescription2,
                        StackManipulation stackManipulation) {
                    if (methodDescription.getParameters().size() < this.value) {
                        StringBuilder sb = new StringBuilder();
                        sb.append(methodDescription);
                        sb.append(" declares less then ");
                        throw new IllegalStateException(yg.concatToVar1(sb, " parameters", this.value));
                    }
                    StackManipulation stackManipulationAssign = assigner.assign(typeDescription2.asGenericType(),
                            ((ParameterDescription) methodDescription.getParameters().get(this.value)).getType(),
                            this.typing);
                    if (stackManipulationAssign.isValid()) {
                        return new StackManipulation.Compound(stackManipulation, stackManipulationAssign,
                                MethodVariableAccess
                                        .of(((ParameterDescription) methodDescription.getParameters().get(this.value))
                                                .getType())
                                        .storeAt(argumentHandler.argument(((ParameterDescription) methodDescription
                                                .getParameters().get(this.value)).getOffset())));
                    }
                    throw new IllegalStateException("Cannot assign " + typeDescription2 + " to "
                            + ((ParameterDescription) methodDescription.getParameters().get(this.value)).getType());
                }
            }

            /*
             * JADX INFO: compiled from:
             * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
             */
            @Target({})
            @RepeatedAnnotationPlugin.Enhance(ToArguments.class)
            @Repeatable(ToArguments.class)
            public @interface ToArgument {
                int index() default -1;

                Assigner.Typing typing() default Assigner.Typing.STATIC;

                int value();
            }

            ToArgument[] value();
        }

        /*
         * JADX INFO: compiled from:
         * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
         */
        @Target({ ElementType.METHOD })
        @Documented
        @Retention(RetentionPolicy.RUNTIME)
        public @interface ToFields {

            /*
             * JADX INFO: compiled from:
             * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
             */
            @HashCodeAndEqualsPlugin.Enhance
            public static class Handler implements Handler {
                private final TypeDescription declaringType;
                private final int index;
                private final String name;
                private final Assigner.Typing typing;

                /*
                 * JADX INFO: compiled from:
                 * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
                 */
                public enum Factory implements Handler.Factory<ToFields> {
                    INSTANCE;

                    private static final MethodDescription.InDefinedShape TO_FIELDS_VALUE = (MethodDescription.InDefinedShape) TypeDescription.ForLoadedType
                            .of(ToFields.class).getDeclaredMethods().filter(ElementMatchers.named("value")).getOnly();
                    private static final MethodDescription.InDefinedShape TO_FIELD_DECLARING_TYPE;
                    private static final MethodDescription.InDefinedShape TO_FIELD_INDEX;
                    private static final MethodDescription.InDefinedShape TO_FIELD_TYPING;
                    private static final MethodDescription.InDefinedShape TO_FIELD_VALUE;

                    static {
                        MethodList<MethodDescription.InDefinedShape> declaredMethods = TypeDescription.ForLoadedType
                                .of(ToField.class).getDeclaredMethods();
                        TO_FIELD_VALUE = (MethodDescription.InDefinedShape) declaredMethods
                                .filter(ElementMatchers.named("value")).getOnly();
                        TO_FIELD_INDEX = (MethodDescription.InDefinedShape) declaredMethods
                                .filter(ElementMatchers.named(com.umeng.ccg.a.H)).getOnly();
                        TO_FIELD_DECLARING_TYPE = (MethodDescription.InDefinedShape) declaredMethods
                                .filter(ElementMatchers.named("declaringType")).getOnly();
                        TO_FIELD_TYPING = (MethodDescription.InDefinedShape) declaredMethods
                                .filter(ElementMatchers.named("typing")).getOnly();
                    }

                    @Override // net.bytebuddy.asm.Advice.AssignReturned.Handler.Factory
                    public Class<ToFields> getAnnotationType() {
                        return ToFields.class;
                    }

                    @Override // net.bytebuddy.asm.Advice.AssignReturned.Handler.Factory
                    public List<Handler> make(TypeDescription typeDescription, boolean z,
                            AnnotationDescription.Loadable<? extends ToFields> loadable) {
                        ArrayList arrayList = new ArrayList();
                        for (AnnotationDescription annotationDescription : (AnnotationDescription[]) loadable
                                .getValue(TO_FIELDS_VALUE).resolve(AnnotationDescription[].class)) {
                            arrayList.add(new Handler(
                                    ((Integer) annotationDescription.getValue(TO_FIELD_INDEX).resolve(Integer.class))
                                            .intValue(),
                                    (String) annotationDescription.getValue(TO_FIELD_VALUE).resolve(String.class),
                                    (TypeDescription) annotationDescription.getValue(TO_FIELD_DECLARING_TYPE)
                                            .resolve(TypeDescription.class),
                                    (Assigner.Typing) ((EnumerationDescription) annotationDescription
                                            .getValue(TO_FIELD_TYPING).resolve(EnumerationDescription.class))
                                            .load(Assigner.Typing.class)));
                        }
                        return arrayList;
                    }
                }

                public Handler(int i, String str, TypeDescription typeDescription, Assigner.Typing typing) {
                    this.index = i;
                    this.name = str;
                    this.declaringType = typeDescription;
                    this.typing = typing;
                }

                public boolean equals(@MaybeNull Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (obj == null || getClass() != obj.getClass()) {
                        return false;
                    }
                    Handler handler = (Handler) obj;
                    return this.index == handler.index && this.typing.equals(handler.typing)
                            && this.name.equals(handler.name) && this.declaringType.equals(handler.declaringType);
                }

                @Override // net.bytebuddy.asm.Advice.AssignReturned.Handler
                public int getIndex() {
                    return this.index;
                }

                public int hashCode() {
                    return this.typing.hashCode() + StaticHelpers6.f(this.declaringType,
                            bjs.e(this.name, ((getClass().hashCode() * 31) + this.index) * 31, 31), 31);
                }

                @Override // net.bytebuddy.asm.Advice.AssignReturned.Handler
                public StackManipulation resolve(TypeDescription typeDescription, MethodDescription methodDescription,
                        Assigner assigner, ArgumentHandler argumentHandler, TypeDescription typeDescription2,
                        StackManipulation stackManipulation) {
                    StackManipulation stackManipulationLoadThis;
                    FieldLocator forClassHierarchy = this.declaringType.represents(Void.TYPE)
                            ? new FieldLocator.ForClassHierarchy(typeDescription)
                            : new FieldLocator.ForExactType(this.declaringType);
                    FieldLocator.Resolution resolutionOfBeanAccessor = this.name.equals("")
                            ? FieldLocator.Resolution.Simple.ofBeanAccessor(forClassHierarchy, methodDescription)
                            : forClassHierarchy.locate(this.name);
                    if (!resolutionOfBeanAccessor.isResolved()) {
                        throw new IllegalStateException(
                                "Cannot resolve field " + this.name + " for " + typeDescription);
                    }
                    if (!resolutionOfBeanAccessor.getField().isVisibleTo(typeDescription)) {
                        throw new IllegalStateException(
                                resolutionOfBeanAccessor.getField() + " is not visible to " + typeDescription);
                    }
                    if (resolutionOfBeanAccessor.getField().isStatic()) {
                        stackManipulationLoadThis = StackManipulation.Trivial.INSTANCE;
                    } else {
                        if (methodDescription.isStatic()) {
                            throw new IllegalStateException("Cannot access member field "
                                    + resolutionOfBeanAccessor.getField() + " from static " + methodDescription);
                        }
                        if (!typeDescription
                                .isAssignableTo(resolutionOfBeanAccessor.getField().getDeclaringType().asErasure())) {
                            throw new IllegalStateException(
                                    typeDescription + " does not define " + resolutionOfBeanAccessor.getField());
                        }
                        stackManipulationLoadThis = MethodVariableAccess.loadThis();
                    }
                    StackManipulation stackManipulationAssign = assigner.assign(typeDescription2.asGenericType(),
                            resolutionOfBeanAccessor.getField().getType(), this.typing);
                    if (stackManipulationAssign.isValid()) {
                        return new StackManipulation.Compound(stackManipulationLoadThis, stackManipulation,
                                stackManipulationAssign,
                                FieldAccess.forField(resolutionOfBeanAccessor.getField()).write());
                    }
                    throw new IllegalStateException(
                            "Cannot assign " + typeDescription2 + " to " + resolutionOfBeanAccessor.getField());
                }
            }

            /*
             * JADX INFO: compiled from:
             * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
             */
            @Target({})
            @RepeatedAnnotationPlugin.Enhance(ToFields.class)
            @Repeatable(ToFields.class)
            public @interface ToField {
                Class<?> declaringType() default void.class;

                int index() default -1;

                Assigner.Typing typing() default Assigner.Typing.STATIC;

                String value() default "";
            }

            ToField[] value();
        }

        /*
         * JADX INFO: compiled from:
         * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
         */
        @Target({ ElementType.METHOD })
        @Documented
        @Retention(RetentionPolicy.RUNTIME)
        public @interface ToReturned {

            /*
             * JADX INFO: compiled from:
             * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
             */
            @HashCodeAndEqualsPlugin.Enhance
            public static class Handler implements Handler {
                private final int index;
                private final Assigner.Typing typing;

                /*
                 * JADX INFO: compiled from:
                 * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
                 */
                public enum Factory implements Handler.Factory<ToReturned> {
                    INSTANCE;

                    private static final MethodDescription.InDefinedShape TO_RETURNED_INDEX;
                    private static final MethodDescription.InDefinedShape TO_RETURNED_TYPING;

                    static {
                        MethodList<MethodDescription.InDefinedShape> declaredMethods = TypeDescription.ForLoadedType
                                .of(ToReturned.class).getDeclaredMethods();
                        TO_RETURNED_INDEX = (MethodDescription.InDefinedShape) declaredMethods
                                .filter(ElementMatchers.named(com.umeng.ccg.a.H)).getOnly();
                        TO_RETURNED_TYPING = (MethodDescription.InDefinedShape) declaredMethods
                                .filter(ElementMatchers.named("typing")).getOnly();
                    }

                    @Override // net.bytebuddy.asm.Advice.AssignReturned.Handler.Factory
                    public Class<ToReturned> getAnnotationType() {
                        return ToReturned.class;
                    }

                    @Override // net.bytebuddy.asm.Advice.AssignReturned.Handler.Factory
                    public List<Handler> make(TypeDescription typeDescription, boolean z,
                            AnnotationDescription.Loadable<? extends ToReturned> loadable) {
                        if (z) {
                            return Collections.singletonList(new Handler(
                                    ((Integer) loadable.getValue(TO_RETURNED_INDEX).resolve(Integer.class)).intValue(),
                                    (Assigner.Typing) ((EnumerationDescription) loadable.getValue(TO_RETURNED_TYPING)
                                            .resolve(EnumerationDescription.class)).load(Assigner.Typing.class)));
                        }
                        throw new IllegalStateException(
                                StaticHelpers6.concat("Cannot write returned value from enter advice for ", typeDescription));
                    }
                }

                public Handler(int i, Assigner.Typing typing) {
                    this.index = i;
                    this.typing = typing;
                }

                public boolean equals(@MaybeNull Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (obj == null || getClass() != obj.getClass()) {
                        return false;
                    }
                    Handler handler = (Handler) obj;
                    return this.index == handler.index && this.typing.equals(handler.typing);
                }

                @Override // net.bytebuddy.asm.Advice.AssignReturned.Handler
                public int getIndex() {
                    return this.index;
                }

                public int hashCode() {
                    return this.typing.hashCode() + (((getClass().hashCode() * 31) + this.index) * 31);
                }

                @Override // net.bytebuddy.asm.Advice.AssignReturned.Handler
                public StackManipulation resolve(TypeDescription typeDescription, MethodDescription methodDescription,
                        Assigner assigner, ArgumentHandler argumentHandler, TypeDescription typeDescription2,
                        StackManipulation stackManipulation) {
                    if (methodDescription.getReturnType().represents(Void.TYPE)) {
                        return StackManipulation.Trivial.INSTANCE;
                    }
                    StackManipulation stackManipulationAssign = assigner.assign(typeDescription2.asGenericType(),
                            methodDescription.getReturnType(), this.typing);
                    if (stackManipulationAssign.isValid()) {
                        return new StackManipulation.Compound(stackManipulation, stackManipulationAssign,
                                MethodVariableAccess.of(methodDescription.getReturnType())
                                        .storeAt(argumentHandler.returned()));
                    }
                    throw new IllegalStateException(
                            "Cannot assign " + typeDescription2 + " to " + methodDescription.getReturnType());
                }
            }

            int index() default -1;

            Assigner.Typing typing() default Assigner.Typing.STATIC;
        }

        /*
         * JADX INFO: compiled from:
         * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
         */
        @Target({ ElementType.METHOD })
        @Documented
        @Retention(RetentionPolicy.RUNTIME)
        public @interface ToThis {

            /*
             * JADX INFO: compiled from:
             * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
             */
            @HashCodeAndEqualsPlugin.Enhance
            public static class Handler implements Handler {
                private final boolean exit;
                private final int index;
                private final Assigner.Typing typing;

                /*
                 * JADX INFO: compiled from:
                 * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
                 */
                public enum Factory implements Handler.Factory<ToThis> {
                    INSTANCE;

                    private static final MethodDescription.InDefinedShape TO_THIS_INDEX;
                    private static final MethodDescription.InDefinedShape TO_THIS_TYPING;

                    static {
                        MethodList<MethodDescription.InDefinedShape> declaredMethods = TypeDescription.ForLoadedType
                                .of(ToThis.class).getDeclaredMethods();
                        TO_THIS_INDEX = (MethodDescription.InDefinedShape) declaredMethods
                                .filter(ElementMatchers.named(com.umeng.ccg.a.H)).getOnly();
                        TO_THIS_TYPING = (MethodDescription.InDefinedShape) declaredMethods
                                .filter(ElementMatchers.named("typing")).getOnly();
                    }

                    @Override // net.bytebuddy.asm.Advice.AssignReturned.Handler.Factory
                    public Class<ToThis> getAnnotationType() {
                        return ToThis.class;
                    }

                    @Override // net.bytebuddy.asm.Advice.AssignReturned.Handler.Factory
                    public List<Handler> make(TypeDescription typeDescription, boolean z,
                            AnnotationDescription.Loadable<? extends ToThis> loadable) {
                        return Collections
                                .singletonList(new Handler(
                                        ((Integer) loadable.getValue(TO_THIS_INDEX).resolve(Integer.class)).intValue(),
                                        (Assigner.Typing) ((EnumerationDescription) loadable.getValue(TO_THIS_TYPING)
                                                .resolve(EnumerationDescription.class)).load(Assigner.Typing.class),
                                        z));
                    }
                }

                public Handler(int i, Assigner.Typing typing, boolean z) {
                    this.index = i;
                    this.typing = typing;
                    this.exit = z;
                }

                public boolean equals(@MaybeNull Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (obj == null || getClass() != obj.getClass()) {
                        return false;
                    }
                    Handler handler = (Handler) obj;
                    return this.index == handler.index && this.exit == handler.exit
                            && this.typing.equals(handler.typing);
                }

                @Override // net.bytebuddy.asm.Advice.AssignReturned.Handler
                public int getIndex() {
                    return this.index;
                }

                public int hashCode() {
                    return ((this.typing.hashCode() + (((getClass().hashCode() * 31) + this.index) * 31)) * 31)
                            + (this.exit ? 1 : 0);
                }

                @Override // net.bytebuddy.asm.Advice.AssignReturned.Handler
                public StackManipulation resolve(TypeDescription typeDescription, MethodDescription methodDescription,
                        Assigner assigner, ArgumentHandler argumentHandler, TypeDescription typeDescription2,
                        StackManipulation stackManipulation) {
                    if (methodDescription.isStatic()) {
                        throw new IllegalStateException(
                                StaticHelpers6.concat("Cannot assign this reference for static method ", methodDescription));
                    }
                    if (!this.exit && methodDescription.isConstructor()) {
                        throw new IllegalStateException(
                                StaticHelpers6.concat("Cannot assign this reference in constructor prior to initialization for ",
                                        methodDescription));
                    }
                    StackManipulation stackManipulationAssign = assigner.assign(typeDescription2.asGenericType(),
                            typeDescription.asGenericType(), this.typing);
                    if (stackManipulationAssign.isValid()) {
                        return new StackManipulation.Compound(stackManipulation, stackManipulationAssign,
                                MethodVariableAccess.REFERENCE.storeAt(argumentHandler.argument(0)));
                    }
                    throw new IllegalStateException("Cannot assign " + typeDescription2 + " to " + typeDescription);
                }
            }

            int index() default -1;

            Assigner.Typing typing() default Assigner.Typing.STATIC;
        }

        /*
         * JADX INFO: compiled from:
         * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
         */
        @Target({ ElementType.METHOD })
        @Documented
        @Retention(RetentionPolicy.RUNTIME)
        public @interface ToThrown {

            /*
             * JADX INFO: compiled from:
             * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
             */
            @HashCodeAndEqualsPlugin.Enhance
            public static class Handler implements Handler {
                private final int index;
                private final Assigner.Typing typing;

                /*
                 * JADX INFO: compiled from:
                 * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
                 */
                public enum Factory implements Handler.Factory<ToThrown> {
                    INSTANCE;

                    private static final MethodDescription.InDefinedShape TO_THROWN_INDEX;
                    private static final MethodDescription.InDefinedShape TO_THROWN_TYPING;

                    static {
                        MethodList<MethodDescription.InDefinedShape> declaredMethods = TypeDescription.ForLoadedType
                                .of(ToThrown.class).getDeclaredMethods();
                        TO_THROWN_INDEX = (MethodDescription.InDefinedShape) declaredMethods
                                .filter(ElementMatchers.named(com.umeng.ccg.a.H)).getOnly();
                        TO_THROWN_TYPING = (MethodDescription.InDefinedShape) declaredMethods
                                .filter(ElementMatchers.named("typing")).getOnly();
                    }

                    @Override // net.bytebuddy.asm.Advice.AssignReturned.Handler.Factory
                    public Class<ToThrown> getAnnotationType() {
                        return ToThrown.class;
                    }

                    @Override // net.bytebuddy.asm.Advice.AssignReturned.Handler.Factory
                    public List<Handler> make(TypeDescription typeDescription, boolean z,
                            AnnotationDescription.Loadable<? extends ToThrown> loadable) {
                        if (z) {
                            return Collections.singletonList(new Handler(
                                    ((Integer) loadable.getValue(TO_THROWN_INDEX).resolve(Integer.class)).intValue(),
                                    (Assigner.Typing) ((EnumerationDescription) loadable.getValue(TO_THROWN_TYPING)
                                            .resolve(EnumerationDescription.class)).load(Assigner.Typing.class)));
                        }
                        throw new IllegalStateException(
                                StaticHelpers6.concat("Cannot assign thrown value from enter advice for ", typeDescription));
                    }
                }

                public Handler(int i, Assigner.Typing typing) {
                    this.index = i;
                    this.typing = typing;
                }

                public boolean equals(@MaybeNull Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (obj == null || getClass() != obj.getClass()) {
                        return false;
                    }
                    Handler handler = (Handler) obj;
                    return this.index == handler.index && this.typing.equals(handler.typing);
                }

                @Override // net.bytebuddy.asm.Advice.AssignReturned.Handler
                public int getIndex() {
                    return this.index;
                }

                public int hashCode() {
                    return this.typing.hashCode() + (((getClass().hashCode() * 31) + this.index) * 31);
                }

                @Override // net.bytebuddy.asm.Advice.AssignReturned.Handler
                public StackManipulation resolve(TypeDescription typeDescription, MethodDescription methodDescription,
                        Assigner assigner, ArgumentHandler argumentHandler, TypeDescription typeDescription2,
                        StackManipulation stackManipulation) {
                    StackManipulation stackManipulationAssign = assigner.assign(typeDescription2.asGenericType(),
                            TypeDefinition.Sort.describe(Throwable.class), this.typing);
                    if (stackManipulationAssign.isValid()) {
                        return new StackManipulation.Compound(stackManipulation, stackManipulationAssign,
                                MethodVariableAccess.REFERENCE.storeAt(argumentHandler.thrown()));
                    }
                    throw new IllegalStateException(
                            "Cannot assign " + typeDescription2 + " to " + Throwable.class.getName());
                }
            }

            int index() default -1;

            Assigner.Typing typing() default Assigner.Typing.STATIC;
        }

        public AssignReturned(TypeDescription typeDescription, ExceptionHandler.Factory factory, boolean z,
                boolean z2) {
            this.typeDescription = typeDescription;
            this.exceptionHandlerFactory = factory;
            this.exit = z;
            this.skipOnDefaultValue = z2;
        }

        public boolean equals(@MaybeNull Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            AssignReturned assignReturned = (AssignReturned) obj;
            return this.exit == assignReturned.exit && this.skipOnDefaultValue == assignReturned.skipOnDefaultValue
                    && this.typeDescription.equals(assignReturned.typeDescription)
                    && this.exceptionHandlerFactory.equals(assignReturned.exceptionHandlerFactory);
        }

        public abstract Collection<Handler> getHandlers();

        public abstract TypeDescription getType();

        public int hashCode() {
            return ((((this.exceptionHandlerFactory.hashCode()
                    + StaticHelpers6.f(this.typeDescription, getClass().hashCode() * 31, 31)) * 31) + (this.exit ? 1 : 0)) * 31)
                    + (this.skipOnDefaultValue ? 1 : 0);
        }

        @Override // net.bytebuddy.asm.Advice.PostProcessor
        public StackManipulation resolve(TypeDescription typeDescription, MethodDescription methodDescription,
                Assigner assigner, ArgumentHandler argumentHandler,
                StackMapFrameHandler.ForPostProcessor forPostProcessor, StackManipulation stackManipulation) {
            ArrayList arrayList = new ArrayList(getHandlers().size());
            for (Handler handler : getHandlers()) {
                arrayList.add(handler.resolve(typeDescription, methodDescription, assigner, argumentHandler, getType(),
                        toLoadInstruction(handler, this.exit ? argumentHandler.exit() : argumentHandler.enter())));
            }
            StackManipulation stackManipulationWrap = this.exceptionHandlerFactory
                    .wrap(new StackManipulation.Compound(arrayList), stackManipulation, forPostProcessor);
            if (this.skipOnDefaultValue) {
                return DefaultValueSkip.of(stackManipulationWrap, forPostProcessor,
                        this.exit ? argumentHandler.exit() : argumentHandler.enter(), this.typeDescription);
            }
            return stackManipulationWrap;
        }

        public abstract StackManipulation toLoadInstruction(Handler handler, int i);
    }

    /*
     * JADX INFO: compiled from:
     * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
     */
    public interface BootstrapArgumentResolver {

        /*
         * JADX INFO: compiled from:
         * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
         */
        public interface Factory {
            BootstrapArgumentResolver resolve(MethodDescription.InDefinedShape inDefinedShape, boolean z);
        }

        /*
         * JADX INFO: compiled from:
         * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
         */
        @HashCodeAndEqualsPlugin.Enhance
        public static class ForDefaultValues implements BootstrapArgumentResolver {
            private final MethodDescription.InDefinedShape adviceMethod;
            private final boolean exit;

            /*
             * JADX INFO: compiled from:
             * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
             */
            public enum Factory implements Factory {
                INSTANCE;

                @Override // net.bytebuddy.asm.Advice.BootstrapArgumentResolver.Factory
                public BootstrapArgumentResolver resolve(MethodDescription.InDefinedShape inDefinedShape, boolean z) {
                    return new ForDefaultValues(inDefinedShape, z);
                }
            }

            public ForDefaultValues(MethodDescription.InDefinedShape inDefinedShape, boolean z) {
                this.adviceMethod = inDefinedShape;
                this.exit = z;
            }

            public boolean equals(@MaybeNull Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || getClass() != obj.getClass()) {
                    return false;
                }
                ForDefaultValues forDefaultValues = (ForDefaultValues) obj;
                return this.exit == forDefaultValues.exit && this.adviceMethod.equals(forDefaultValues.adviceMethod);
            }

            public int hashCode() {
                return StaticHelpers6.b(this.adviceMethod, getClass().hashCode() * 31, 31) + (this.exit ? 1 : 0);
            }

            @Override // net.bytebuddy.asm.Advice.BootstrapArgumentResolver
            public List<JavaConstant> resolve(TypeDescription typeDescription, MethodDescription methodDescription) {
                return methodDescription.isTypeInitializer()
                        ? Arrays.asList(JavaConstant.Simple.ofLoaded(this.adviceMethod.getDeclaringType().getName()),
                                JavaConstant.Simple.ofLoaded(Integer.valueOf(this.exit ? 1 : 0)),
                                JavaConstant.Simple.of(typeDescription),
                                JavaConstant.Simple.ofLoaded(methodDescription.getInternalName()))
                        : Arrays.asList(JavaConstant.Simple.ofLoaded(this.adviceMethod.getDeclaringType().getName()),
                                JavaConstant.Simple.ofLoaded(Integer.valueOf(this.exit ? 1 : 0)),
                                JavaConstant.Simple.of(typeDescription),
                                JavaConstant.Simple.ofLoaded(methodDescription.getInternalName()),
                                JavaConstant.MethodHandle.of(methodDescription.asDefined()));
            }
        }

        List<JavaConstant> resolve(TypeDescription typeDescription, MethodDescription methodDescription);
    }

    /*
     * JADX INFO: compiled from:
     * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
     */
    public interface Delegator {

        /*
         * JADX INFO: compiled from:
         * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
         */
        public interface Factory {
            Delegator make(MethodDescription.InDefinedShape inDefinedShape, boolean z);
        }

        /*
         * JADX INFO: compiled from:
         * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
         */
        @HashCodeAndEqualsPlugin.Enhance
        public static class ForDynamicInvocation implements Delegator {
            private final MethodDescription.InDefinedShape bootstrapMethod;
            private final BootstrapArgumentResolver resolver;
            private final MethodDescription.SignatureToken signatureToken;

            /*
             * JADX INFO: compiled from:
             * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
             */
            @HashCodeAndEqualsPlugin.Enhance
            public static class Factory implements Factory {
                private final MethodDescription.InDefinedShape bootstrapMethod;
                private final BootstrapArgumentResolver.Factory resolverFactory;
                private final TypeDescription.Generic.Visitor<? extends TypeDescription.Generic> visitor;

                public Factory(MethodDescription.InDefinedShape inDefinedShape,
                        BootstrapArgumentResolver.Factory factory,
                        TypeDescription.Generic.Visitor<? extends TypeDescription.Generic> visitor) {
                    this.bootstrapMethod = inDefinedShape;
                    this.resolverFactory = factory;
                    this.visitor = visitor;
                }

                public boolean equals(@MaybeNull Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (obj == null || getClass() != obj.getClass()) {
                        return false;
                    }
                    Factory factory = (Factory) obj;
                    return this.bootstrapMethod.equals(factory.bootstrapMethod)
                            && this.resolverFactory.equals(factory.resolverFactory)
                            && this.visitor.equals(factory.visitor);
                }

                public int hashCode() {
                    return this.visitor.hashCode() + ((this.resolverFactory.hashCode()
                            + StaticHelpers6.b(this.bootstrapMethod, getClass().hashCode() * 31, 31)) * 31);
                }

                @Override // net.bytebuddy.asm.Advice.Delegator.Factory
                public Delegator make(MethodDescription.InDefinedShape inDefinedShape, boolean z) {
                    return new ForDynamicInvocation(this.bootstrapMethod,
                            new MethodDescription.SignatureToken(inDefinedShape.getInternalName(),
                                    ((TypeDescription.Generic) inDefinedShape.getReturnType().accept(this.visitor))
                                            .asErasure(),
                                    inDefinedShape.getParameters().asTypeList().accept(this.visitor).asErasures()),
                            this.resolverFactory.resolve(inDefinedShape, z));
                }
            }

            public ForDynamicInvocation(MethodDescription.InDefinedShape inDefinedShape,
                    MethodDescription.SignatureToken signatureToken,
                    BootstrapArgumentResolver bootstrapArgumentResolver) {
                this.bootstrapMethod = inDefinedShape;
                this.signatureToken = signatureToken;
                this.resolver = bootstrapArgumentResolver;
            }

            public static Factory of(MethodDescription.InDefinedShape inDefinedShape,
                    BootstrapArgumentResolver.Factory factory,
                    TypeDescription.Generic.Visitor<? extends TypeDescription.Generic> visitor) {
                if (inDefinedShape.isInvokeBootstrap()) {
                    return new Factory(inDefinedShape, factory, visitor);
                }
                throw new IllegalArgumentException("Not a suitable bootstrap target: " + inDefinedShape);
            }

            @Override // net.bytebuddy.asm.Advice.Delegator
            public StackManipulation apply(TypeDescription typeDescription, MethodDescription methodDescription) {
                List<JavaConstant> listResolve = this.resolver.resolve(typeDescription, methodDescription);
                if (this.bootstrapMethod
                        .isInvokeBootstrap(TypeList.Explicit.of((List<? extends JavaConstant>) listResolve))) {
                    return MethodInvocation.invoke(this.bootstrapMethod).dynamic(this.signatureToken.getName(),
                            this.signatureToken.getReturnType(), this.signatureToken.getParameterTypes(), listResolve);
                }
                throw new IllegalStateException(
                        "Cannot invoke " + this.bootstrapMethod + " with arguments: " + listResolve);
            }

            @Override // net.bytebuddy.asm.Advice.Delegator
            public void assertVisibility(TypeDescription typeDescription) {
                if (this.bootstrapMethod.isVisibleTo(typeDescription)) {
                    return;
                }
                throw new IllegalStateException(this.bootstrapMethod + " is not visible to " + typeDescription);
            }

            public boolean equals(@MaybeNull Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || getClass() != obj.getClass()) {
                    return false;
                }
                ForDynamicInvocation forDynamicInvocation = (ForDynamicInvocation) obj;
                return this.bootstrapMethod.equals(forDynamicInvocation.bootstrapMethod)
                        && this.signatureToken.equals(forDynamicInvocation.signatureToken)
                        && this.resolver.equals(forDynamicInvocation.resolver);
            }

            @Override // net.bytebuddy.asm.Advice.Delegator
            public MethodDescription.TypeToken getTypeToken() {
                return this.signatureToken.asTypeToken();
            }

            public int hashCode() {
                return this.resolver.hashCode() + ((this.signatureToken.hashCode()
                        + StaticHelpers6.b(this.bootstrapMethod, getClass().hashCode() * 31, 31)) * 31);
            }
        }

        /*
         * JADX INFO: compiled from:
         * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
         */
        @HashCodeAndEqualsPlugin.Enhance
        public static class ForRegularInvocation implements Delegator {
            private final MethodDescription.InDefinedShape adviceMethod;

            /*
             * JADX INFO: compiled from:
             * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
             */
            public enum Factory implements Factory {
                INSTANCE;

                @Override // net.bytebuddy.asm.Advice.Delegator.Factory
                public Delegator make(MethodDescription.InDefinedShape inDefinedShape, boolean z) {
                    return new ForRegularInvocation(inDefinedShape);
                }
            }

            public ForRegularInvocation(MethodDescription.InDefinedShape inDefinedShape) {
                this.adviceMethod = inDefinedShape;
            }

            @Override // net.bytebuddy.asm.Advice.Delegator
            public StackManipulation apply(TypeDescription typeDescription, MethodDescription methodDescription) {
                return MethodInvocation.invoke(this.adviceMethod);
            }

            @Override // net.bytebuddy.asm.Advice.Delegator
            public void assertVisibility(TypeDescription typeDescription) {
                if (this.adviceMethod.isVisibleTo(typeDescription)) {
                    return;
                }
                throw new IllegalStateException(this.adviceMethod + " is not visible to " + typeDescription);
            }

            public boolean equals(@MaybeNull Object obj) {
                if (this == obj) {
                    return true;
                }
                return obj != null && getClass() == obj.getClass()
                        && this.adviceMethod.equals(((ForRegularInvocation) obj).adviceMethod);
            }

            @Override // net.bytebuddy.asm.Advice.Delegator
            public MethodDescription.TypeToken getTypeToken() {
                return this.adviceMethod.asTypeToken();
            }

            public int hashCode() {
                return this.adviceMethod.hashCode() + (getClass().hashCode() * 31);
            }
        }

        StackManipulation apply(TypeDescription typeDescription, MethodDescription methodDescription);

        void assertVisibility(TypeDescription typeDescription);

        MethodDescription.TypeToken getTypeToken();
    }

    /*
     * JADX INFO: compiled from:
     * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
     */
    public interface Dispatcher {

        @AlwaysNull
        public static final AnnotationVisitor IGNORE_ANNOTATION = null;

        @AlwaysNull
        public static final MethodVisitor IGNORE_METHOD = null;

        /*
         * JADX INFO: compiled from:
         * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
         */
        public interface Bound {
            void apply();

            void initialize();

            void prepare();
        }

        /*
         * JADX INFO: compiled from:
         * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
         */
        @HashCodeAndEqualsPlugin.Enhance
        public static class Delegating implements Unresolved {
            protected final MethodDescription.InDefinedShape adviceMethod;
            protected final Delegator.Factory delegatorFactory;

            /*
             * JADX INFO: compiled from:
             * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
             */
            public static abstract class Resolved extends Resolved.AbstractBase {
                protected final Delegator delegator;

                /*
                 * JADX INFO: compiled from:
                 * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
                 */
                public static abstract class AdviceMethodWriter implements Bound {
                    protected final ArgumentHandler.ForAdvice argumentHandler;
                    private final Assigner assigner;
                    private final Delegator delegator;
                    private final StackManipulation exceptionHandler;
                    protected final Implementation.Context implementationContext;
                    private final MethodDescription instrumentedMethod;
                    private final TypeDescription instrumentedType;
                    protected final MethodSizeHandler.ForAdvice methodSizeHandler;
                    protected final MethodVisitor methodVisitor;
                    private final List<OffsetMapping.Target> offsetMappings;
                    private final PostProcessor postProcessor;
                    private final RelocationHandler.Bound relocationHandler;
                    protected final StackMapFrameHandler.ForAdvice stackMapFrameHandler;
                    private final SuppressionHandler.Bound suppressionHandler;
                    protected final MethodDescription.TypeToken typeToken;

                    /*
                     * JADX INFO: compiled from:
                     * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
                     */
                    public static class ForMethodEnter extends AdviceMethodWriter {
                        public ForMethodEnter(MethodDescription.TypeToken typeToken, TypeDescription typeDescription,
                                MethodDescription methodDescription, Assigner assigner, PostProcessor postProcessor,
                                List<OffsetMapping.Target> list, MethodVisitor methodVisitor,
                                Implementation.Context context, ArgumentHandler.ForAdvice forAdvice,
                                MethodSizeHandler.ForAdvice forAdvice2, StackMapFrameHandler.ForAdvice forAdvice3,
                                SuppressionHandler.Bound bound, RelocationHandler.Bound bound2,
                                StackManipulation stackManipulation, Delegator delegator) {
                            super(typeToken, typeDescription, methodDescription, assigner, postProcessor, list,
                                    methodVisitor, context, forAdvice, forAdvice2, forAdvice3, bound, bound2,
                                    stackManipulation, delegator);
                        }

                        @Override // net.bytebuddy.asm.Advice.Dispatcher.Bound
                        public void initialize() {
                        }

                        @Override // net.bytebuddy.asm.Advice.Dispatcher.Delegating.Resolved.AdviceMethodWriter
                        public boolean isExitAdvice() {
                            return false;
                        }
                    }

                    /*
                     * JADX INFO: compiled from:
                     * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
                     */
                    public static class ForMethodExit extends AdviceMethodWriter {
                        public ForMethodExit(MethodDescription.TypeToken typeToken, TypeDescription typeDescription,
                                MethodDescription methodDescription, Assigner assigner, PostProcessor postProcessor,
                                List<OffsetMapping.Target> list, MethodVisitor methodVisitor,
                                Implementation.Context context, ArgumentHandler.ForAdvice forAdvice,
                                MethodSizeHandler.ForAdvice forAdvice2, StackMapFrameHandler.ForAdvice forAdvice3,
                                SuppressionHandler.Bound bound, RelocationHandler.Bound bound2,
                                StackManipulation stackManipulation, Delegator delegator) {
                            super(typeToken, typeDescription, methodDescription, assigner, postProcessor, list,
                                    methodVisitor, context, forAdvice, forAdvice2, forAdvice3, bound, bound2,
                                    stackManipulation, delegator);
                        }

                        @Override // net.bytebuddy.asm.Advice.Dispatcher.Bound
                        public void initialize() {
                            if (this.typeToken.getReturnType().represents(Boolean.TYPE)
                                    || this.typeToken.getReturnType().represents(Byte.TYPE)
                                    || this.typeToken.getReturnType().represents(Short.TYPE)
                                    || this.typeToken.getReturnType().represents(Character.TYPE)
                                    || this.typeToken.getReturnType().represents(Integer.TYPE)) {
                                this.methodVisitor.visitInsn(3);
                                this.methodVisitor.visitVarInsn(54, this.argumentHandler.exit());
                            } else if (this.typeToken.getReturnType().represents(Long.TYPE)) {
                                this.methodVisitor.visitInsn(9);
                                this.methodVisitor.visitVarInsn(55, this.argumentHandler.exit());
                            } else if (this.typeToken.getReturnType().represents(Float.TYPE)) {
                                this.methodVisitor.visitInsn(11);
                                this.methodVisitor.visitVarInsn(56, this.argumentHandler.exit());
                            } else if (this.typeToken.getReturnType().represents(Double.TYPE)) {
                                this.methodVisitor.visitInsn(14);
                                this.methodVisitor.visitVarInsn(57, this.argumentHandler.exit());
                            } else if (!this.typeToken.getReturnType().represents(Void.TYPE)) {
                                this.methodVisitor.visitInsn(1);
                                this.methodVisitor.visitVarInsn(58, this.argumentHandler.exit());
                            }
                            this.methodSizeHandler
                                    .requireStackSize(this.typeToken.getReturnType().getStackSize().getSize());
                        }

                        @Override // net.bytebuddy.asm.Advice.Dispatcher.Delegating.Resolved.AdviceMethodWriter
                        public boolean isExitAdvice() {
                            return true;
                        }
                    }

                    public AdviceMethodWriter(MethodDescription.TypeToken typeToken, TypeDescription typeDescription,
                            MethodDescription methodDescription, Assigner assigner, PostProcessor postProcessor,
                            List<OffsetMapping.Target> list, MethodVisitor methodVisitor,
                            Implementation.Context context, ArgumentHandler.ForAdvice forAdvice,
                            MethodSizeHandler.ForAdvice forAdvice2, StackMapFrameHandler.ForAdvice forAdvice3,
                            SuppressionHandler.Bound bound, RelocationHandler.Bound bound2,
                            StackManipulation stackManipulation, Delegator delegator) {
                        this.typeToken = typeToken;
                        this.instrumentedType = typeDescription;
                        this.instrumentedMethod = methodDescription;
                        this.assigner = assigner;
                        this.postProcessor = postProcessor;
                        this.offsetMappings = list;
                        this.methodVisitor = methodVisitor;
                        this.implementationContext = context;
                        this.argumentHandler = forAdvice;
                        this.methodSizeHandler = forAdvice2;
                        this.stackMapFrameHandler = forAdvice3;
                        this.suppressionHandler = bound;
                        this.relocationHandler = bound2;
                        this.exceptionHandler = stackManipulation;
                        this.delegator = delegator;
                    }

                    @Override // net.bytebuddy.asm.Advice.Dispatcher.Bound
                    public void apply() {
                        this.suppressionHandler.onStart(this.methodVisitor);
                        int iMax = 0;
                        int size = 0;
                        int i = 0;
                        for (OffsetMapping.Target target : this.offsetMappings) {
                            size += this.typeToken.getParameterTypes().get(i).getStackSize().getSize();
                            iMax = Math.max(iMax, target.resolveRead()
                                    .apply(this.methodVisitor, this.implementationContext).getMaximalSize() + size);
                            i++;
                        }
                        int iMax2 = Math.max(iMax, this.delegator.apply(this.instrumentedType, this.instrumentedMethod)
                                .apply(this.methodVisitor, this.implementationContext).getMaximalSize());
                        this.suppressionHandler.onEndWithSkip(this.methodVisitor, this.implementationContext,
                                this.methodSizeHandler, this.stackMapFrameHandler, this.typeToken.getReturnType());
                        if (this.typeToken.getReturnType().represents(Boolean.TYPE)
                                || this.typeToken.getReturnType().represents(Byte.TYPE)
                                || this.typeToken.getReturnType().represents(Short.TYPE)
                                || this.typeToken.getReturnType().represents(Character.TYPE)
                                || this.typeToken.getReturnType().represents(Integer.TYPE)) {
                            this.methodVisitor.visitVarInsn(54,
                                    isExitAdvice() ? this.argumentHandler.exit() : this.argumentHandler.enter());
                        } else if (this.typeToken.getReturnType().represents(Long.TYPE)) {
                            this.methodVisitor.visitVarInsn(55,
                                    isExitAdvice() ? this.argumentHandler.exit() : this.argumentHandler.enter());
                        } else if (this.typeToken.getReturnType().represents(Float.TYPE)) {
                            this.methodVisitor.visitVarInsn(56,
                                    isExitAdvice() ? this.argumentHandler.exit() : this.argumentHandler.enter());
                        } else if (this.typeToken.getReturnType().represents(Double.TYPE)) {
                            this.methodVisitor.visitVarInsn(57,
                                    isExitAdvice() ? this.argumentHandler.exit() : this.argumentHandler.enter());
                        } else if (this.typeToken.getReturnType().represents(Void.TYPE)) {
                            this.methodVisitor.visitInsn(0);
                        } else {
                            this.methodVisitor.visitVarInsn(58,
                                    isExitAdvice() ? this.argumentHandler.exit() : this.argumentHandler.enter());
                        }
                        this.methodSizeHandler.requireStackSize(this.postProcessor
                                .resolve(this.instrumentedType, this.instrumentedMethod, this.assigner,
                                        this.argumentHandler, this.stackMapFrameHandler, this.exceptionHandler)
                                .apply(this.methodVisitor, this.implementationContext).getMaximalSize());
                        this.methodSizeHandler.requireStackSize(
                                this.relocationHandler.apply(this.methodVisitor, this.implementationContext,
                                        isExitAdvice() ? this.argumentHandler.exit() : this.argumentHandler.enter()));
                        this.stackMapFrameHandler.injectCompletionFrame(this.methodVisitor);
                        this.methodSizeHandler.requireStackSize(
                                Math.max(iMax2, this.typeToken.getReturnType().getStackSize().getSize()));
                        this.methodSizeHandler
                                .requireLocalVariableLength(this.typeToken.getReturnType().getStackSize().getSize()
                                        + this.instrumentedMethod.getStackSize());
                    }

                    public abstract boolean isExitAdvice();

                    @Override // net.bytebuddy.asm.Advice.Dispatcher.Bound
                    public void prepare() {
                        this.suppressionHandler.onPrepare(this.methodVisitor);
                    }
                }

                /*
                 * JADX INFO: compiled from:
                 * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
                 */
                @HashCodeAndEqualsPlugin.Enhance
                public static abstract class ForMethodEnter extends Resolved implements Resolved.ForMethodEnter {
                    private final boolean prependLineNumber;

                    /*
                     * JADX INFO: compiled from:
                     * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
                     */
                    public static class WithDiscardedEnterType extends ForMethodEnter {
                        public WithDiscardedEnterType(MethodDescription.InDefinedShape inDefinedShape,
                                PostProcessor postProcessor, List<? extends OffsetMapping.Factory<?>> list,
                                TypeDefinition typeDefinition, Delegator delegator) {
                            super(inDefinedShape, postProcessor, list, typeDefinition, delegator);
                        }

                        @Override // net.bytebuddy.asm.Advice.Dispatcher.Delegating.Resolved.ForMethodEnter
                        public Bound doResolve(TypeDescription typeDescription, MethodDescription methodDescription,
                                MethodVisitor methodVisitor, Implementation.Context context, Assigner assigner,
                                ArgumentHandler.ForAdvice forAdvice, MethodSizeHandler.ForAdvice forAdvice2,
                                StackMapFrameHandler.ForAdvice forAdvice3, SuppressionHandler.Bound bound,
                                RelocationHandler.Bound bound2, StackManipulation stackManipulation) {
                            forAdvice2.requireLocalVariableLengthPadding(
                                    this.delegator.getTypeToken().getReturnType().getStackSize().getSize());
                            return super.doResolve(typeDescription, methodDescription, methodVisitor, context, assigner,
                                    forAdvice, forAdvice2, forAdvice3, bound, bound2, stackManipulation);
                        }

                        @Override // net.bytebuddy.asm.Advice.Dispatcher
                        public TypeDefinition getAdviceType() {
                            return TypeDescription.ForLoadedType.of(Void.TYPE);
                        }
                    }

                    /*
                     * JADX INFO: compiled from:
                     * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
                     */
                    public static class WithRetainedEnterType extends ForMethodEnter {
                        public WithRetainedEnterType(MethodDescription.InDefinedShape inDefinedShape,
                                PostProcessor postProcessor, List<? extends OffsetMapping.Factory<?>> list,
                                TypeDefinition typeDefinition, Delegator delegator) {
                            super(inDefinedShape, postProcessor, list, typeDefinition, delegator);
                        }

                        @Override // net.bytebuddy.asm.Advice.Dispatcher
                        public TypeDefinition getAdviceType() {
                            return this.delegator.getTypeToken().getReturnType();
                        }
                    }

                    public ForMethodEnter(MethodDescription.InDefinedShape inDefinedShape, PostProcessor postProcessor,
                            List<? extends OffsetMapping.Factory<?>> list, TypeDefinition typeDefinition,
                            Delegator delegator) {
                        super(inDefinedShape, postProcessor,
                                CompoundList.of(Arrays.asList(OffsetMapping.ForArgument.Unresolved.Factory.INSTANCE,
                                        OffsetMapping.ForAllArguments.Factory.INSTANCE,
                                        OffsetMapping.ForThisReference.Factory.INSTANCE,
                                        OffsetMapping.ForField.Unresolved.Factory.INSTANCE,
                                        OffsetMapping.ForFieldHandle.Unresolved.ReaderFactory.INSTANCE,
                                        OffsetMapping.ForFieldHandle.Unresolved.WriterFactory.INSTANCE,
                                        OffsetMapping.ForOrigin.Factory.INSTANCE,
                                        OffsetMapping.ForSelfCallHandle.Factory.INSTANCE,
                                        OffsetMapping.ForHandle.Factory.INSTANCE,
                                        OffsetMapping.ForDynamicConstant.Factory.INSTANCE,
                                        OffsetMapping.ForUnusedValue.Factory.INSTANCE,
                                        OffsetMapping.ForStubValue.INSTANCE,
                                        OffsetMapping.ForExitValue.Factory.of(typeDefinition),
                                        new OffsetMapping.Factory.Illegal(Thrown.class),
                                        new OffsetMapping.Factory.Illegal(Enter.class),
                                        new OffsetMapping.Factory.Illegal(Local.class),
                                        new OffsetMapping.Factory.Illegal(Return.class)), (List) list),
                                (TypeDescription) inDefinedShape.getDeclaredAnnotations().ofType(OnMethodEnter.class)
                                        .getValue(Advice.SUPPRESS_ENTER).resolve(TypeDescription.class),
                                (TypeDescription) inDefinedShape.getDeclaredAnnotations().ofType(OnMethodEnter.class)
                                        .getValue(Advice.SKIP_ON).resolve(TypeDescription.class),
                                ((Integer) inDefinedShape.getDeclaredAnnotations().ofType(OnMethodEnter.class)
                                        .getValue(Advice.SKIP_ON_INDEX).resolve(Integer.class)).intValue(),
                                delegator);
                        this.prependLineNumber = ((Boolean) inDefinedShape.getDeclaredAnnotations()
                                .ofType(OnMethodEnter.class).getValue(Advice.PREPEND_LINE_NUMBER)
                                .resolve(Boolean.class)).booleanValue();
                    }

                    public static Resolved.ForMethodEnter of(MethodDescription.InDefinedShape inDefinedShape,
                            PostProcessor postProcessor, Delegator delegator,
                            List<? extends OffsetMapping.Factory<?>> list, TypeDefinition typeDefinition, boolean z) {
                        return z ? new WithRetainedEnterType(inDefinedShape, postProcessor, list, typeDefinition,
                                delegator)
                                : new WithDiscardedEnterType(inDefinedShape, postProcessor, list, typeDefinition,
                                        delegator);
                    }

                    public Bound doResolve(TypeDescription typeDescription, MethodDescription methodDescription,
                            MethodVisitor methodVisitor, Implementation.Context context, Assigner assigner,
                            ArgumentHandler.ForAdvice forAdvice, MethodSizeHandler.ForAdvice forAdvice2,
                            StackMapFrameHandler.ForAdvice forAdvice3, SuppressionHandler.Bound bound,
                            RelocationHandler.Bound bound2, StackManipulation stackManipulation) {
                        ArrayList arrayList = new ArrayList(this.offsetMappings.size());
                        Iterator<OffsetMapping> it = this.offsetMappings.values().iterator();
                        while (it.hasNext()) {
                            arrayList.add(it.next().resolve(typeDescription, methodDescription, assigner, forAdvice,
                                    OffsetMapping.Sort.ENTER));
                        }
                        return new AdviceMethodWriter.ForMethodEnter(this.delegator.getTypeToken(), typeDescription,
                                methodDescription, assigner, this.postProcessor, arrayList, methodVisitor, context,
                                forAdvice, forAdvice2, forAdvice3, bound, bound2, stackManipulation, this.delegator);
                    }

                    @Override // net.bytebuddy.asm.Advice.Dispatcher.Resolved.AbstractBase
                    public boolean equals(@MaybeNull Object obj) {
                        if (!super.equals(obj)) {
                            return false;
                        }
                        if (this == obj) {
                            return true;
                        }
                        return obj != null && getClass() == obj.getClass()
                                && this.prependLineNumber == ((ForMethodEnter) obj).prependLineNumber;
                    }

                    @Override // net.bytebuddy.asm.Advice.Dispatcher.Resolved.ForMethodEnter
                    public TypeDefinition getActualAdviceType() {
                        return this.delegator.getTypeToken().getReturnType();
                    }

                    @Override // net.bytebuddy.asm.Advice.Dispatcher.Resolved.AbstractBase
                    public int hashCode() {
                        return (super.hashCode() * 31) + (this.prependLineNumber ? 1 : 0);
                    }

                    @Override // net.bytebuddy.asm.Advice.Dispatcher.Resolved.ForMethodEnter
                    public boolean isPrependLineNumber() {
                        return this.prependLineNumber;
                    }

                    @Override // net.bytebuddy.asm.Advice.Dispatcher.Delegating.Resolved
                    public Bound resolve(TypeDescription typeDescription, MethodDescription methodDescription,
                            MethodVisitor methodVisitor, Implementation.Context context, Assigner assigner,
                            ArgumentHandler.ForInstrumentedMethod forInstrumentedMethod,
                            MethodSizeHandler.ForInstrumentedMethod forInstrumentedMethod2,
                            StackMapFrameHandler.ForInstrumentedMethod forInstrumentedMethod3,
                            StackManipulation stackManipulation, RelocationHandler.Relocation relocation) {
                        return doResolve(typeDescription, methodDescription, methodVisitor, context, assigner,
                                forInstrumentedMethod.bindEnter(this.delegator.getTypeToken()),
                                forInstrumentedMethod2.bindEnter(this.delegator.getTypeToken()),
                                forInstrumentedMethod3.bindEnter(this.delegator.getTypeToken()),
                                this.suppressionHandler.bind(stackManipulation),
                                this.relocationHandler.bind(methodDescription, relocation), stackManipulation);
                    }
                }

                /*
                 * JADX INFO: compiled from:
                 * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
                 */
                @HashCodeAndEqualsPlugin.Enhance
                public static abstract class ForMethodExit extends Resolved implements Resolved.ForMethodExit {
                    private final boolean backupArguments;

                    /*
                     * JADX INFO: compiled from:
                     * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
                     */
                    @HashCodeAndEqualsPlugin.Enhance
                    public static class WithExceptionHandler extends ForMethodExit {
                        private final TypeDescription throwable;

                        public WithExceptionHandler(MethodDescription.InDefinedShape inDefinedShape,
                                PostProcessor postProcessor, Map<String, TypeDefinition> map,
                                List<? extends OffsetMapping.Factory<?>> list, TypeDefinition typeDefinition,
                                TypeDescription typeDescription, Delegator delegator) {
                            super(inDefinedShape, postProcessor, map, list, typeDefinition, delegator);
                            this.throwable = typeDescription;
                        }

                        @Override // net.bytebuddy.asm.Advice.Dispatcher.Delegating.Resolved.ForMethodExit,
                                  // net.bytebuddy.asm.Advice.Dispatcher.Resolved.AbstractBase
                        public boolean equals(@MaybeNull Object obj) {
                            if (!super.equals(obj)) {
                                return false;
                            }
                            if (this == obj) {
                                return true;
                            }
                            return obj != null && getClass() == obj.getClass()
                                    && this.throwable.equals(((WithExceptionHandler) obj).throwable);
                        }

                        @Override // net.bytebuddy.asm.Advice.Dispatcher.Resolved.ForMethodExit
                        public TypeDescription getThrowable() {
                            return this.throwable;
                        }

                        @Override // net.bytebuddy.asm.Advice.Dispatcher.Delegating.Resolved.ForMethodExit,
                                  // net.bytebuddy.asm.Advice.Dispatcher.Resolved.AbstractBase
                        public int hashCode() {
                            return this.throwable.hashCode() + (super.hashCode() * 31);
                        }
                    }

                    /*
                     * JADX INFO: compiled from:
                     * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
                     */
                    public static class WithoutExceptionHandler extends ForMethodExit {
                        public WithoutExceptionHandler(MethodDescription.InDefinedShape inDefinedShape,
                                PostProcessor postProcessor, Map<String, TypeDefinition> map,
                                List<? extends OffsetMapping.Factory<?>> list, TypeDefinition typeDefinition,
                                Delegator delegator) {
                            super(inDefinedShape, postProcessor, map, list, typeDefinition, delegator);
                        }

                        @Override // net.bytebuddy.asm.Advice.Dispatcher.Resolved.ForMethodExit
                        public TypeDescription getThrowable() {
                            return NoExceptionHandler.DESCRIPTION;
                        }
                    }

                    public ForMethodExit(MethodDescription.InDefinedShape inDefinedShape, PostProcessor postProcessor,
                            Map<String, TypeDefinition> map, List<? extends OffsetMapping.Factory<?>> list,
                            TypeDefinition typeDefinition, Delegator delegator) {
                        super(inDefinedShape, postProcessor,
                                CompoundList.of(Arrays.asList(OffsetMapping.ForArgument.Unresolved.Factory.INSTANCE,
                                        OffsetMapping.ForAllArguments.Factory.INSTANCE,
                                        OffsetMapping.ForThisReference.Factory.INSTANCE,
                                        OffsetMapping.ForField.Unresolved.Factory.INSTANCE,
                                        OffsetMapping.ForFieldHandle.Unresolved.ReaderFactory.INSTANCE,
                                        OffsetMapping.ForFieldHandle.Unresolved.WriterFactory.INSTANCE,
                                        OffsetMapping.ForOrigin.Factory.INSTANCE,
                                        OffsetMapping.ForSelfCallHandle.Factory.INSTANCE,
                                        OffsetMapping.ForHandle.Factory.INSTANCE,
                                        OffsetMapping.ForDynamicConstant.Factory.INSTANCE,
                                        OffsetMapping.ForUnusedValue.Factory.INSTANCE,
                                        OffsetMapping.ForStubValue.INSTANCE,
                                        OffsetMapping.ForEnterValue.Factory.of(typeDefinition),
                                        OffsetMapping.ForExitValue.Factory.of(inDefinedShape.getReturnType()),
                                        new OffsetMapping.ForLocalValue.Factory(map),
                                        OffsetMapping.ForReturnValue.Factory.INSTANCE,
                                        OffsetMapping.ForThrowable.Factory.of(inDefinedShape)), (List) list),
                                (TypeDescription) inDefinedShape.getDeclaredAnnotations().ofType(OnMethodExit.class)
                                        .getValue(Advice.SUPPRESS_EXIT).resolve(TypeDescription.class),
                                (TypeDescription) inDefinedShape.getDeclaredAnnotations().ofType(OnMethodExit.class)
                                        .getValue(Advice.REPEAT_ON).resolve(TypeDescription.class),
                                ((Integer) inDefinedShape.getDeclaredAnnotations().ofType(OnMethodExit.class)
                                        .getValue(Advice.REPEAT_ON_INDEX).resolve(Integer.class)).intValue(),
                                delegator);
                        this.backupArguments = ((Boolean) inDefinedShape.getDeclaredAnnotations()
                                .ofType(OnMethodExit.class).getValue(Advice.BACKUP_ARGUMENTS).resolve(Boolean.class))
                                .booleanValue();
                    }

                    private Bound doResolve(TypeDescription typeDescription, MethodDescription methodDescription,
                            MethodVisitor methodVisitor, Implementation.Context context, Assigner assigner,
                            ArgumentHandler.ForAdvice forAdvice, MethodSizeHandler.ForAdvice forAdvice2,
                            StackMapFrameHandler.ForAdvice forAdvice3, SuppressionHandler.Bound bound,
                            RelocationHandler.Bound bound2, StackManipulation stackManipulation) {
                        ArrayList arrayList = new ArrayList(this.offsetMappings.size());
                        Iterator<OffsetMapping> it = this.offsetMappings.values().iterator();
                        while (it.hasNext()) {
                            arrayList.add(it.next().resolve(typeDescription, methodDescription, assigner, forAdvice,
                                    OffsetMapping.Sort.EXIT));
                        }
                        return new AdviceMethodWriter.ForMethodExit(this.delegator.getTypeToken(), typeDescription,
                                methodDescription, assigner, this.postProcessor, arrayList, methodVisitor, context,
                                forAdvice, forAdvice2, forAdvice3, bound, bound2, stackManipulation, this.delegator);
                    }

                    public static Resolved.ForMethodExit of(MethodDescription.InDefinedShape inDefinedShape,
                            PostProcessor postProcessor, Delegator delegator, Map<String, TypeDefinition> map,
                            List<? extends OffsetMapping.Factory<?>> list, TypeDefinition typeDefinition) {
                        TypeDescription typeDescription = (TypeDescription) inDefinedShape.getDeclaredAnnotations()
                                .ofType(OnMethodExit.class).getValue(Advice.ON_THROWABLE)
                                .resolve(TypeDescription.class);
                        return typeDescription.represents(NoExceptionHandler.class)
                                ? new WithoutExceptionHandler(inDefinedShape, postProcessor, map, list, typeDefinition,
                                        delegator)
                                : new WithExceptionHandler(inDefinedShape, postProcessor, map, list, typeDefinition,
                                        typeDescription, delegator);
                    }

                    @Override // net.bytebuddy.asm.Advice.Dispatcher.Resolved.AbstractBase
                    public boolean equals(@MaybeNull Object obj) {
                        if (!super.equals(obj)) {
                            return false;
                        }
                        if (this == obj) {
                            return true;
                        }
                        return obj != null && getClass() == obj.getClass()
                                && this.backupArguments == ((ForMethodExit) obj).backupArguments;
                    }

                    @Override // net.bytebuddy.asm.Advice.Dispatcher
                    public TypeDefinition getAdviceType() {
                        return this.delegator.getTypeToken().getReturnType();
                    }

                    @Override // net.bytebuddy.asm.Advice.Dispatcher.Resolved.ForMethodExit
                    public ArgumentHandler.Factory getArgumentHandlerFactory() {
                        return this.backupArguments ? ArgumentHandler.Factory.COPYING : ArgumentHandler.Factory.SIMPLE;
                    }

                    @Override // net.bytebuddy.asm.Advice.Dispatcher.Resolved.AbstractBase
                    public int hashCode() {
                        return (super.hashCode() * 31) + (this.backupArguments ? 1 : 0);
                    }

                    @Override // net.bytebuddy.asm.Advice.Dispatcher.Delegating.Resolved
                    public Bound resolve(TypeDescription typeDescription, MethodDescription methodDescription,
                            MethodVisitor methodVisitor, Implementation.Context context, Assigner assigner,
                            ArgumentHandler.ForInstrumentedMethod forInstrumentedMethod,
                            MethodSizeHandler.ForInstrumentedMethod forInstrumentedMethod2,
                            StackMapFrameHandler.ForInstrumentedMethod forInstrumentedMethod3,
                            StackManipulation stackManipulation, RelocationHandler.Relocation relocation) {
                        return doResolve(typeDescription, methodDescription, methodVisitor, context, assigner,
                                forInstrumentedMethod.bindExit(this.delegator.getTypeToken(),
                                        getThrowable().represents(NoExceptionHandler.class)),
                                forInstrumentedMethod2.bindExit(this.delegator.getTypeToken()),
                                forInstrumentedMethod3.bindExit(this.delegator.getTypeToken()),
                                this.suppressionHandler.bind(stackManipulation),
                                this.relocationHandler.bind(methodDescription, relocation), stackManipulation);
                    }
                }

                public Resolved(MethodDescription.InDefinedShape inDefinedShape, PostProcessor postProcessor,
                        List<? extends OffsetMapping.Factory<?>> list, TypeDescription typeDescription,
                        TypeDescription typeDescription2, int i, Delegator delegator) {
                    super(inDefinedShape, postProcessor, list, typeDescription, typeDescription2, i,
                            OffsetMapping.Factory.AdviceType.DELEGATION);
                    this.delegator = delegator;
                }

                @Override // net.bytebuddy.asm.Advice.Dispatcher.Resolved
                public Bound bind(TypeDescription typeDescription, MethodDescription methodDescription,
                        MethodVisitor methodVisitor, Implementation.Context context, Assigner assigner,
                        ArgumentHandler.ForInstrumentedMethod forInstrumentedMethod,
                        MethodSizeHandler.ForInstrumentedMethod forInstrumentedMethod2,
                        StackMapFrameHandler.ForInstrumentedMethod forInstrumentedMethod3,
                        StackManipulation stackManipulation, RelocationHandler.Relocation relocation) {
                    this.delegator.assertVisibility(typeDescription);
                    return resolve(typeDescription, methodDescription, methodVisitor, context, assigner,
                            forInstrumentedMethod, forInstrumentedMethod2, forInstrumentedMethod3, stackManipulation,
                            relocation);
                }

                @Override // net.bytebuddy.asm.Advice.Dispatcher.Resolved
                public Map<String, TypeDefinition> getNamedTypes() {
                    return Collections.EMPTY_MAP;
                }

                public abstract Bound resolve(TypeDescription typeDescription, MethodDescription methodDescription,
                        MethodVisitor methodVisitor, Implementation.Context context, Assigner assigner,
                        ArgumentHandler.ForInstrumentedMethod forInstrumentedMethod,
                        MethodSizeHandler.ForInstrumentedMethod forInstrumentedMethod2,
                        StackMapFrameHandler.ForInstrumentedMethod forInstrumentedMethod3,
                        StackManipulation stackManipulation, RelocationHandler.Relocation relocation);
            }

            public Delegating(MethodDescription.InDefinedShape inDefinedShape, Delegator.Factory factory) {
                this.adviceMethod = inDefinedShape;
                this.delegatorFactory = factory;
            }

            @Override // net.bytebuddy.asm.Advice.Dispatcher.Unresolved
            public Resolved.ForMethodEnter asMethodEnter(List<? extends OffsetMapping.Factory<?>> list,
                    @MaybeNull AsmClassReader asmClassReader, Unresolved unresolved, PostProcessor.Factory factory) {
                Delegator delegatorMake = this.delegatorFactory.make(this.adviceMethod, false);
                MethodDescription.InDefinedShape inDefinedShape = this.adviceMethod;
                return Resolved.ForMethodEnter.of(inDefinedShape,
                        factory.make(inDefinedShape.getDeclaredAnnotations(),
                                delegatorMake.getTypeToken().getReturnType(), false),
                        delegatorMake, list, unresolved.getAdviceType(), unresolved.isAlive());
            }

            @Override // net.bytebuddy.asm.Advice.Dispatcher.Unresolved
            public Resolved.ForMethodExit asMethodExit(List<? extends OffsetMapping.Factory<?>> list,
                    @MaybeNull AsmClassReader asmClassReader, Unresolved unresolved, PostProcessor.Factory factory) {
                Map<String, TypeDefinition> namedTypes = unresolved.getNamedTypes();
                for (ParameterDescription.InDefinedShape inDefinedShape : this.adviceMethod.getParameters()) {
                    AnnotationDescription.Loadable loadableOfType = inDefinedShape.getDeclaredAnnotations()
                            .ofType(Local.class);
                    if (loadableOfType != null) {
                        String str = (String) loadableOfType.getValue(OffsetMapping.ForLocalValue.Factory.LOCAL_VALUE)
                                .resolve(String.class);
                        TypeDefinition typeDefinition = namedTypes.get(str);
                        if (typeDefinition == null) {
                            throw new IllegalStateException(
                                    this.adviceMethod + " attempts use of undeclared local variable " + str);
                        }
                        if (!typeDefinition.equals(inDefinedShape.getType())) {
                            throw new IllegalStateException(
                                    this.adviceMethod + " does not read variable " + str + " as " + typeDefinition);
                        }
                    }
                }
                Delegator delegatorMake = this.delegatorFactory.make(this.adviceMethod, true);
                MethodDescription.InDefinedShape inDefinedShape2 = this.adviceMethod;
                return Resolved.ForMethodExit.of(inDefinedShape2,
                        factory.make(inDefinedShape2.getDeclaredAnnotations(),
                                delegatorMake.getTypeToken().getReturnType(), true),
                        delegatorMake, namedTypes, list, unresolved.getAdviceType());
            }

            public boolean equals(@MaybeNull Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || getClass() != obj.getClass()) {
                    return false;
                }
                Delegating delegating = (Delegating) obj;
                return this.adviceMethod.equals(delegating.adviceMethod)
                        && this.delegatorFactory.equals(delegating.delegatorFactory);
            }

            @Override // net.bytebuddy.asm.Advice.Dispatcher
            public TypeDefinition getAdviceType() {
                return this.adviceMethod.getReturnType();
            }

            @Override // net.bytebuddy.asm.Advice.Dispatcher.Unresolved
            public Map<String, TypeDefinition> getNamedTypes() {
                return Collections.EMPTY_MAP;
            }

            public int hashCode() {
                return this.delegatorFactory.hashCode() + StaticHelpers6.b(this.adviceMethod, getClass().hashCode() * 31, 31);
            }

            @Override // net.bytebuddy.asm.Advice.Dispatcher
            public boolean isAlive() {
                return true;
            }

            @Override // net.bytebuddy.asm.Advice.Dispatcher.Unresolved
            public boolean isBinary() {
                return false;
            }

            public String toString() {
                return "Delegate to " + this.adviceMethod;
            }
        }

        /*
         * JADX INFO: compiled from:
         * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
         */
        public enum Inactive implements Unresolved, Resolved.ForMethodEnter, Resolved.ForMethodExit, Bound {
            INSTANCE;

            @Override // net.bytebuddy.asm.Advice.Dispatcher.Bound
            public void apply() {
            }

            @Override // net.bytebuddy.asm.Advice.Dispatcher.Unresolved
            public Resolved.ForMethodEnter asMethodEnter(List<? extends OffsetMapping.Factory<?>> list,
                    @MaybeNull AsmClassReader asmClassReader, Unresolved unresolved, PostProcessor.Factory factory) {
                return this;
            }

            @Override // net.bytebuddy.asm.Advice.Dispatcher.Unresolved
            public Resolved.ForMethodExit asMethodExit(List<? extends OffsetMapping.Factory<?>> list,
                    @MaybeNull AsmClassReader asmClassReader, Unresolved unresolved, PostProcessor.Factory factory) {
                return this;
            }

            @Override // net.bytebuddy.asm.Advice.Dispatcher.Resolved
            public Bound bind(TypeDescription typeDescription, MethodDescription methodDescription,
                    MethodVisitor methodVisitor, Implementation.Context context, Assigner assigner,
                    ArgumentHandler.ForInstrumentedMethod forInstrumentedMethod,
                    MethodSizeHandler.ForInstrumentedMethod forInstrumentedMethod2,
                    StackMapFrameHandler.ForInstrumentedMethod forInstrumentedMethod3,
                    StackManipulation stackManipulation, RelocationHandler.Relocation relocation) {
                return this;
            }

            @Override // net.bytebuddy.asm.Advice.Dispatcher.Resolved.ForMethodEnter
            public TypeDefinition getActualAdviceType() {
                return TypeDescription.ForLoadedType.of(Void.TYPE);
            }

            @Override // net.bytebuddy.asm.Advice.Dispatcher.Resolved.ForMethodExit
            public ArgumentHandler.Factory getArgumentHandlerFactory() {
                return ArgumentHandler.Factory.SIMPLE;
            }

            @Override // net.bytebuddy.asm.Advice.Dispatcher.Unresolved
            public Map<String, TypeDefinition> getNamedTypes() {
                return Collections.EMPTY_MAP;
            }

            @Override // net.bytebuddy.asm.Advice.Dispatcher.Resolved.ForMethodExit
            public TypeDescription getThrowable() {
                return NoExceptionHandler.DESCRIPTION;
            }

            @Override // net.bytebuddy.asm.Advice.Dispatcher.Bound
            public void initialize() {
            }

            @Override // net.bytebuddy.asm.Advice.Dispatcher
            public boolean isAlive() {
                return false;
            }

            @Override // net.bytebuddy.asm.Advice.Dispatcher.Unresolved
            public boolean isBinary() {
                return false;
            }

            @Override // net.bytebuddy.asm.Advice.Dispatcher.Resolved.ForMethodEnter
            public boolean isPrependLineNumber() {
                return false;
            }

            @Override // net.bytebuddy.asm.Advice.Dispatcher.Bound
            public void prepare() {
            }

            @Override // net.bytebuddy.asm.Advice.Dispatcher
            public TypeDescription getAdviceType() {
                return TypeDescription.ForLoadedType.of(Void.TYPE);
            }
        }

        /*
         * JADX INFO: compiled from:
         * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
         */
        @HashCodeAndEqualsPlugin.Enhance
        public static class Inlining implements Unresolved {
            protected final MethodDescription.InDefinedShape adviceMethod;
            private final Map<String, TypeDefinition> namedTypes = new HashMap();

            /*
             * JADX INFO: compiled from:
             * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
             */
            public static class CodeTranslationVisitor extends MethodVisitor {
                protected final MethodDescription.InDefinedShape adviceMethod;
                protected final ArgumentHandler.ForAdvice argumentHandler;
                private final Assigner assigner;
                protected final Label endOfMethod;
                private final StackManipulation exceptionHandler;
                private final boolean exit;
                protected final Implementation.Context implementationContext;
                private final MethodDescription instrumentedMethod;
                private final TypeDescription instrumentedType;
                protected final MethodSizeHandler.ForAdvice methodSizeHandler;
                protected final MethodVisitor methodVisitor;
                private final Map<Integer, OffsetMapping.Target> offsetMappings;
                private final PostProcessor postProcessor;
                private final RelocationHandler.Bound relocationHandler;
                protected final StackMapFrameHandler.ForAdvice stackMapFrameHandler;
                private final SuppressionHandler.Bound suppressionHandler;

                public CodeTranslationVisitor(MethodVisitor methodVisitor, Implementation.Context context,
                        ArgumentHandler.ForAdvice forAdvice, MethodSizeHandler.ForAdvice forAdvice2,
                        StackMapFrameHandler.ForAdvice forAdvice3, TypeDescription typeDescription,
                        MethodDescription methodDescription, Assigner assigner,
                        MethodDescription.InDefinedShape inDefinedShape, Map<Integer, OffsetMapping.Target> map,
                        SuppressionHandler.Bound bound, RelocationHandler.Bound bound2,
                        StackManipulation stackManipulation, PostProcessor postProcessor, boolean z) {
                    super(OpenedClassReader.ASM_API, StackAwareMethodVisitor.of(methodVisitor, methodDescription));
                    this.methodVisitor = methodVisitor;
                    this.implementationContext = context;
                    this.argumentHandler = forAdvice;
                    this.methodSizeHandler = forAdvice2;
                    this.stackMapFrameHandler = forAdvice3;
                    this.instrumentedType = typeDescription;
                    this.instrumentedMethod = methodDescription;
                    this.assigner = assigner;
                    this.adviceMethod = inDefinedShape;
                    this.offsetMappings = map;
                    this.suppressionHandler = bound;
                    this.relocationHandler = bound2;
                    this.exceptionHandler = stackManipulation;
                    this.postProcessor = postProcessor;
                    this.exit = z;
                    this.endOfMethod = new Label();
                }

                public void propagateHandler(Label label) {
                    ((StackAwareMethodVisitor) this.mv).register(label, Collections.singletonList(StackSize.SINGLE));
                }

                @Override // net.bytebuddy.jar.asm.MethodVisitor
                public void visitAnnotableParameterCount(int i, boolean z) {
                }

                @Override // net.bytebuddy.jar.asm.MethodVisitor
                @MaybeNull
                public AnnotationVisitor visitAnnotation(String str, boolean z) {
                    return Dispatcher.IGNORE_ANNOTATION;
                }

                @Override // net.bytebuddy.jar.asm.MethodVisitor
                @MaybeNull
                public AnnotationVisitor visitAnnotationDefault() {
                    return Dispatcher.IGNORE_ANNOTATION;
                }

                @Override // net.bytebuddy.jar.asm.MethodVisitor
                public void visitAttribute(Attribute attribute) {
                }

                @Override // net.bytebuddy.jar.asm.MethodVisitor
                public void visitCode() {
                    this.suppressionHandler.onStart(this.methodVisitor);
                }

                @Override // net.bytebuddy.jar.asm.MethodVisitor
                public void visitEnd() {
                    this.suppressionHandler.onEnd(this.methodVisitor, this.implementationContext,
                            this.methodSizeHandler, this.stackMapFrameHandler, this.adviceMethod.getReturnType());
                    this.methodVisitor.visitLabel(this.endOfMethod);
                    if (this.adviceMethod.getReturnType().represents(Boolean.TYPE)
                            || this.adviceMethod.getReturnType().represents(Byte.TYPE)
                            || this.adviceMethod.getReturnType().represents(Short.TYPE)
                            || this.adviceMethod.getReturnType().represents(Character.TYPE)
                            || this.adviceMethod.getReturnType().represents(Integer.TYPE)) {
                        this.stackMapFrameHandler.injectReturnFrame(this.methodVisitor);
                        this.methodVisitor.visitVarInsn(54,
                                this.exit ? this.argumentHandler.exit() : this.argumentHandler.enter());
                    } else if (this.adviceMethod.getReturnType().represents(Long.TYPE)) {
                        this.stackMapFrameHandler.injectReturnFrame(this.methodVisitor);
                        this.methodVisitor.visitVarInsn(55,
                                this.exit ? this.argumentHandler.exit() : this.argumentHandler.enter());
                    } else if (this.adviceMethod.getReturnType().represents(Float.TYPE)) {
                        this.stackMapFrameHandler.injectReturnFrame(this.methodVisitor);
                        this.methodVisitor.visitVarInsn(56,
                                this.exit ? this.argumentHandler.exit() : this.argumentHandler.enter());
                    } else if (this.adviceMethod.getReturnType().represents(Double.TYPE)) {
                        this.stackMapFrameHandler.injectReturnFrame(this.methodVisitor);
                        this.methodVisitor.visitVarInsn(57,
                                this.exit ? this.argumentHandler.exit() : this.argumentHandler.enter());
                    } else if (!this.adviceMethod.getReturnType().represents(Void.TYPE)) {
                        this.stackMapFrameHandler.injectReturnFrame(this.methodVisitor);
                        this.methodVisitor.visitVarInsn(58,
                                this.exit ? this.argumentHandler.exit() : this.argumentHandler.enter());
                    }
                    this.methodSizeHandler.requireStackSize(this.postProcessor
                            .resolve(this.instrumentedType, this.instrumentedMethod, this.assigner,
                                    this.argumentHandler, this.stackMapFrameHandler, this.exceptionHandler)
                            .apply(this.methodVisitor, this.implementationContext).getMaximalSize());
                    this.methodSizeHandler.requireStackSize(
                            this.relocationHandler.apply(this.methodVisitor, this.implementationContext,
                                    this.exit ? this.argumentHandler.exit() : this.argumentHandler.enter()));
                    this.stackMapFrameHandler.injectCompletionFrame(this.methodVisitor);
                }

                @Override // net.bytebuddy.jar.asm.MethodVisitor
                public void visitFrame(int i, int i2, @MaybeNull Object[] objArr, int i3, @MaybeNull Object[] objArr2) {
                    this.stackMapFrameHandler.translateFrame(this.methodVisitor, i, i2, objArr, i3, objArr2);
                }

                @Override // net.bytebuddy.jar.asm.MethodVisitor
                public void visitIincInsn(int i, int i2) {
                    OffsetMapping.Target target = this.offsetMappings.get(Integer.valueOf(i));
                    if (target != null) {
                        this.methodSizeHandler.requireStackSizePadding(target.resolveIncrement(i2)
                                .apply(this.mv, this.implementationContext).getMaximalSize());
                    } else {
                        this.mv.visitIincInsn(this.argumentHandler.mapped(i), i2);
                    }
                }

                @Override // net.bytebuddy.jar.asm.MethodVisitor
                public void visitInsn(int i) {
                    switch (i) {
                        case 172:
                            this.methodSizeHandler.requireLocalVariableLength(
                                    ((StackAwareMethodVisitor) this.mv).drainStack(54, 21, StackSize.SINGLE));
                            break;
                        case 173:
                            this.methodSizeHandler.requireLocalVariableLength(
                                    ((StackAwareMethodVisitor) this.mv).drainStack(55, 22, StackSize.DOUBLE));
                            break;
                        case 174:
                            this.methodSizeHandler.requireLocalVariableLength(
                                    ((StackAwareMethodVisitor) this.mv).drainStack(56, 23, StackSize.SINGLE));
                            break;
                        case 175:
                            this.methodSizeHandler.requireLocalVariableLength(
                                    ((StackAwareMethodVisitor) this.mv).drainStack(57, 24, StackSize.DOUBLE));
                            break;
                        case 176:
                            this.methodSizeHandler.requireLocalVariableLength(
                                    ((StackAwareMethodVisitor) this.mv).drainStack(58, 25, StackSize.SINGLE));
                            break;
                        case 177:
                            ((StackAwareMethodVisitor) this.mv).drainStack();
                            break;
                        default:
                            this.mv.visitInsn(i);
                            return;
                    }
                    this.mv.visitJumpInsn(167, this.endOfMethod);
                }

                @Override // net.bytebuddy.jar.asm.MethodVisitor
                public void visitMaxs(int i, int i2) {
                    this.methodSizeHandler.recordMaxima(i, i2);
                }

                @Override // net.bytebuddy.jar.asm.MethodVisitor
                public void visitParameter(String str, int i) {
                }

                @Override // net.bytebuddy.jar.asm.MethodVisitor
                @MaybeNull
                public AnnotationVisitor visitParameterAnnotation(int i, String str, boolean z) {
                    return Dispatcher.IGNORE_ANNOTATION;
                }

                @Override // net.bytebuddy.jar.asm.MethodVisitor
                @MaybeNull
                public AnnotationVisitor visitTypeAnnotation(int i, @MaybeNull TypePath typePath, String str,
                        boolean z) {
                    return Dispatcher.IGNORE_ANNOTATION;
                }

                @Override // net.bytebuddy.jar.asm.MethodVisitor
                public void visitVarInsn(int i, int i2) {
                    StackManipulation stackManipulationResolveRead;
                    StackSize stackSize;
                    OffsetMapping.Target target = this.offsetMappings.get(Integer.valueOf(i2));
                    if (target == null) {
                        this.mv.visitVarInsn(i, this.argumentHandler.mapped(i2));
                        return;
                    }
                    switch (i) {
                        case 21:
                        case 23:
                        case 25:
                            stackManipulationResolveRead = target.resolveRead();
                            stackSize = StackSize.SINGLE;
                            break;
                        case 22:
                        case 24:
                            stackManipulationResolveRead = target.resolveRead();
                            stackSize = StackSize.DOUBLE;
                            break;
                        default:
                            switch (i) {
                                case 54:
                                case 55:
                                case 56:
                                case 57:
                                case 58:
                                    stackManipulationResolveRead = target.resolveWrite();
                                    stackSize = StackSize.ZERO;
                                    break;
                                default:
                                    throw new IllegalStateException(concatVar2Var1(i, "Unexpected opcode: "));
                            }
                            break;
                    }
                    this.methodSizeHandler.requireStackSizePadding(
                            stackManipulationResolveRead.apply(this.mv, this.implementationContext).getMaximalSize()
                                    - stackSize.getSize());
                }
            }

            /*
             * JADX INFO: compiled from:
             * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
             */
            public static abstract class Resolved extends Resolved.AbstractBase {
                protected final MethodDescription.InDefinedShape adviceMethod;
                protected final AsmClassReader classReader;

                /*
                 * JADX INFO: compiled from:
                 * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
                 */
                @HashCodeAndEqualsPlugin.Enhance
                public static abstract class ForMethodEnter extends Resolved implements Resolved.ForMethodEnter {
                    private final Map<String, TypeDefinition> namedTypes;
                    private final boolean prependLineNumber;

                    /*
                     * JADX INFO: compiled from:
                     * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
                     */
                    public static class WithDiscardedEnterType extends ForMethodEnter {
                        public WithDiscardedEnterType(MethodDescription.InDefinedShape inDefinedShape,
                                PostProcessor postProcessor, Map<String, TypeDefinition> map,
                                List<? extends OffsetMapping.Factory<?>> list, TypeDefinition typeDefinition,
                                AsmClassReader asmClassReader) {
                            super(inDefinedShape, postProcessor, map, list, typeDefinition, asmClassReader);
                        }

                        @Override // net.bytebuddy.asm.Advice.Dispatcher.Inlining.Resolved.ForMethodEnter
                        public MethodVisitor doApply(MethodVisitor methodVisitor, Implementation.Context context,
                                Assigner assigner, ArgumentHandler.ForAdvice forAdvice,
                                MethodSizeHandler.ForAdvice forAdvice2, StackMapFrameHandler.ForAdvice forAdvice3,
                                TypeDescription typeDescription, MethodDescription methodDescription,
                                SuppressionHandler.Bound bound, RelocationHandler.Bound bound2,
                                StackManipulation stackManipulation) {
                            forAdvice2.requireLocalVariableLengthPadding(
                                    this.adviceMethod.getReturnType().getStackSize().getSize());
                            return super.doApply(methodVisitor, context, assigner, forAdvice, forAdvice2, forAdvice3,
                                    typeDescription, methodDescription, bound, bound2, stackManipulation);
                        }

                        @Override // net.bytebuddy.asm.Advice.Dispatcher
                        public TypeDefinition getAdviceType() {
                            return TypeDescription.ForLoadedType.of(Void.TYPE);
                        }
                    }

                    /*
                     * JADX INFO: compiled from:
                     * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
                     */
                    public static class WithRetainedEnterType extends ForMethodEnter {
                        public WithRetainedEnterType(MethodDescription.InDefinedShape inDefinedShape,
                                PostProcessor postProcessor, Map<String, TypeDefinition> map,
                                List<? extends OffsetMapping.Factory<?>> list, TypeDefinition typeDefinition,
                                AsmClassReader asmClassReader) {
                            super(inDefinedShape, postProcessor, map, list, typeDefinition, asmClassReader);
                        }

                        @Override // net.bytebuddy.asm.Advice.Dispatcher
                        public TypeDefinition getAdviceType() {
                            return this.adviceMethod.getReturnType();
                        }
                    }

                    public ForMethodEnter(MethodDescription.InDefinedShape inDefinedShape, PostProcessor postProcessor,
                            Map<String, TypeDefinition> map, List<? extends OffsetMapping.Factory<?>> list,
                            TypeDefinition typeDefinition, AsmClassReader asmClassReader) {
                        super(inDefinedShape, postProcessor,
                                CompoundList.of(Arrays.asList(OffsetMapping.ForArgument.Unresolved.Factory.INSTANCE,
                                        OffsetMapping.ForAllArguments.Factory.INSTANCE,
                                        OffsetMapping.ForThisReference.Factory.INSTANCE,
                                        OffsetMapping.ForField.Unresolved.Factory.INSTANCE,
                                        OffsetMapping.ForFieldHandle.Unresolved.ReaderFactory.INSTANCE,
                                        OffsetMapping.ForFieldHandle.Unresolved.WriterFactory.INSTANCE,
                                        OffsetMapping.ForOrigin.Factory.INSTANCE,
                                        OffsetMapping.ForSelfCallHandle.Factory.INSTANCE,
                                        OffsetMapping.ForHandle.Factory.INSTANCE,
                                        OffsetMapping.ForDynamicConstant.Factory.INSTANCE,
                                        OffsetMapping.ForUnusedValue.Factory.INSTANCE,
                                        OffsetMapping.ForStubValue.INSTANCE,
                                        OffsetMapping.ForThrowable.Factory.INSTANCE,
                                        OffsetMapping.ForExitValue.Factory.of(typeDefinition),
                                        new OffsetMapping.ForLocalValue.Factory(map),
                                        new OffsetMapping.Factory.Illegal(Thrown.class),
                                        new OffsetMapping.Factory.Illegal(Enter.class),
                                        new OffsetMapping.Factory.Illegal(Return.class)), (List) list),
                                (TypeDescription) inDefinedShape.getDeclaredAnnotations().ofType(OnMethodEnter.class)
                                        .getValue(Advice.SUPPRESS_ENTER).resolve(TypeDescription.class),
                                (TypeDescription) inDefinedShape.getDeclaredAnnotations().ofType(OnMethodEnter.class)
                                        .getValue(Advice.SKIP_ON).resolve(TypeDescription.class),
                                ((Integer) inDefinedShape.getDeclaredAnnotations().ofType(OnMethodEnter.class)
                                        .getValue(Advice.SKIP_ON_INDEX).resolve(Integer.class)).intValue(),
                                asmClassReader);
                        this.namedTypes = map;
                        this.prependLineNumber = ((Boolean) inDefinedShape.getDeclaredAnnotations()
                                .ofType(OnMethodEnter.class).getValue(Advice.PREPEND_LINE_NUMBER)
                                .resolve(Boolean.class)).booleanValue();
                    }

                    public static Resolved.ForMethodEnter of(MethodDescription.InDefinedShape inDefinedShape,
                            PostProcessor postProcessor, Map<String, TypeDefinition> map,
                            List<? extends OffsetMapping.Factory<?>> list, TypeDefinition typeDefinition,
                            AsmClassReader asmClassReader, boolean z) {
                        return z ? new WithRetainedEnterType(inDefinedShape, postProcessor, map, list, typeDefinition,
                                asmClassReader)
                                : new WithDiscardedEnterType(inDefinedShape, postProcessor, map, list, typeDefinition,
                                        asmClassReader);
                    }

                    @Override // net.bytebuddy.asm.Advice.Dispatcher.Inlining.Resolved
                    public MethodVisitor apply(MethodVisitor methodVisitor, Implementation.Context context,
                            Assigner assigner, ArgumentHandler.ForInstrumentedMethod forInstrumentedMethod,
                            MethodSizeHandler.ForInstrumentedMethod forInstrumentedMethod2,
                            StackMapFrameHandler.ForInstrumentedMethod forInstrumentedMethod3,
                            TypeDescription typeDescription, MethodDescription methodDescription,
                            SuppressionHandler.Bound bound, RelocationHandler.Bound bound2,
                            StackManipulation stackManipulation) {
                        MethodDescription.TypeToken typeTokenAsTypeToken = this.adviceMethod.asTypeToken();
                        return doApply(methodVisitor, context, assigner,
                                forInstrumentedMethod.bindEnter(typeTokenAsTypeToken),
                                forInstrumentedMethod2.bindEnter(typeTokenAsTypeToken),
                                forInstrumentedMethod3.bindEnter(typeTokenAsTypeToken), typeDescription,
                                methodDescription, bound, bound2, stackManipulation);
                    }

                    @Override // net.bytebuddy.asm.Advice.Dispatcher.Resolved
                    public Bound bind(TypeDescription typeDescription, MethodDescription methodDescription,
                            MethodVisitor methodVisitor, Implementation.Context context, Assigner assigner,
                            ArgumentHandler.ForInstrumentedMethod forInstrumentedMethod,
                            MethodSizeHandler.ForInstrumentedMethod forInstrumentedMethod2,
                            StackMapFrameHandler.ForInstrumentedMethod forInstrumentedMethod3,
                            StackManipulation stackManipulation, RelocationHandler.Relocation relocation) {
                        return new AdviceMethodInliner(typeDescription, methodDescription, methodVisitor, context,
                                assigner, forInstrumentedMethod, forInstrumentedMethod2, forInstrumentedMethod3,
                                this.suppressionHandler.bind(stackManipulation),
                                this.relocationHandler.bind(methodDescription, relocation), stackManipulation,
                                this.classReader);
                    }

                    public MethodVisitor doApply(MethodVisitor methodVisitor, Implementation.Context context,
                            Assigner assigner, ArgumentHandler.ForAdvice forAdvice,
                            MethodSizeHandler.ForAdvice forAdvice2, StackMapFrameHandler.ForAdvice forAdvice3,
                            TypeDescription typeDescription, MethodDescription methodDescription,
                            SuppressionHandler.Bound bound, RelocationHandler.Bound bound2,
                            StackManipulation stackManipulation) {
                        HashMap map = new HashMap();
                        for (Map.Entry<Integer, OffsetMapping> entry : this.offsetMappings.entrySet()) {
                            map.put(entry.getKey(), entry.getValue().resolve(typeDescription, methodDescription,
                                    assigner, forAdvice, OffsetMapping.Sort.ENTER));
                        }
                        return new CodeTranslationVisitor(methodVisitor, context, forAdvice, forAdvice2, forAdvice3,
                                typeDescription, methodDescription, assigner, this.adviceMethod, map, bound, bound2,
                                stackManipulation, this.postProcessor, false);
                    }

                    @Override // net.bytebuddy.asm.Advice.Dispatcher.Resolved.AbstractBase
                    public boolean equals(@MaybeNull Object obj) {
                        if (!super.equals(obj)) {
                            return false;
                        }
                        if (this == obj) {
                            return true;
                        }
                        if (obj == null || getClass() != obj.getClass()) {
                            return false;
                        }
                        ForMethodEnter forMethodEnter = (ForMethodEnter) obj;
                        return this.prependLineNumber == forMethodEnter.prependLineNumber
                                && this.namedTypes.equals(forMethodEnter.namedTypes);
                    }

                    @Override // net.bytebuddy.asm.Advice.Dispatcher.Resolved.ForMethodEnter
                    public TypeDefinition getActualAdviceType() {
                        return this.adviceMethod.getReturnType();
                    }

                    @Override // net.bytebuddy.asm.Advice.Dispatcher.Resolved
                    public Map<String, TypeDefinition> getNamedTypes() {
                        return this.namedTypes;
                    }

                    @Override // net.bytebuddy.asm.Advice.Dispatcher.Resolved.AbstractBase
                    public int hashCode() {
                        return yg.c(this.namedTypes, super.hashCode() * 31, 31) + (this.prependLineNumber ? 1 : 0);
                    }

                    @Override // net.bytebuddy.asm.Advice.Dispatcher.Resolved.ForMethodEnter
                    public boolean isPrependLineNumber() {
                        return this.prependLineNumber;
                    }

                    @Override // net.bytebuddy.asm.Advice.Dispatcher.Inlining.Resolved
                    public Map<Integer, TypeDefinition> resolveInitializationTypes(ArgumentHandler argumentHandler) {
                        TreeMap treeMap = new TreeMap();
                        for (Map.Entry<String, TypeDefinition> entry : this.namedTypes.entrySet()) {
                            treeMap.put(Integer.valueOf(argumentHandler.named(entry.getKey())), entry.getValue());
                        }
                        return treeMap;
                    }
                }

                /*
                 * JADX INFO: compiled from:
                 * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
                 */
                @HashCodeAndEqualsPlugin.Enhance
                public static abstract class ForMethodExit extends Resolved implements Resolved.ForMethodExit {
                    private final boolean backupArguments;
                    private final Map<String, TypeDefinition> uninitializedNamedTypes;

                    /*
                     * JADX INFO: compiled from:
                     * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
                     */
                    @HashCodeAndEqualsPlugin.Enhance
                    public static class WithExceptionHandler extends ForMethodExit {
                        private final TypeDescription throwable;

                        public WithExceptionHandler(MethodDescription.InDefinedShape inDefinedShape,
                                PostProcessor postProcessor, Map<String, TypeDefinition> map,
                                Map<String, TypeDefinition> map2, List<? extends OffsetMapping.Factory<?>> list,
                                AsmClassReader asmClassReader, TypeDefinition typeDefinition,
                                TypeDescription typeDescription) {
                            super(inDefinedShape, postProcessor, map, map2, list, asmClassReader, typeDefinition);
                            this.throwable = typeDescription;
                        }

                        @Override // net.bytebuddy.asm.Advice.Dispatcher.Inlining.Resolved.ForMethodExit,
                                  // net.bytebuddy.asm.Advice.Dispatcher.Resolved.AbstractBase
                        public boolean equals(@MaybeNull Object obj) {
                            if (!super.equals(obj)) {
                                return false;
                            }
                            if (this == obj) {
                                return true;
                            }
                            return obj != null && getClass() == obj.getClass()
                                    && this.throwable.equals(((WithExceptionHandler) obj).throwable);
                        }

                        @Override // net.bytebuddy.asm.Advice.Dispatcher.Resolved.ForMethodExit
                        public TypeDescription getThrowable() {
                            return this.throwable;
                        }

                        @Override // net.bytebuddy.asm.Advice.Dispatcher.Inlining.Resolved.ForMethodExit,
                                  // net.bytebuddy.asm.Advice.Dispatcher.Resolved.AbstractBase
                        public int hashCode() {
                            return this.throwable.hashCode() + (super.hashCode() * 31);
                        }
                    }

                    /*
                     * JADX INFO: compiled from:
                     * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
                     */
                    public static class WithoutExceptionHandler extends ForMethodExit {
                        public WithoutExceptionHandler(MethodDescription.InDefinedShape inDefinedShape,
                                PostProcessor postProcessor, Map<String, TypeDefinition> map,
                                Map<String, TypeDefinition> map2, List<? extends OffsetMapping.Factory<?>> list,
                                AsmClassReader asmClassReader, TypeDefinition typeDefinition) {
                            super(inDefinedShape, postProcessor, map, map2, list, asmClassReader, typeDefinition);
                        }

                        @Override // net.bytebuddy.asm.Advice.Dispatcher.Resolved.ForMethodExit
                        public TypeDescription getThrowable() {
                            return NoExceptionHandler.DESCRIPTION;
                        }
                    }

                    public ForMethodExit(MethodDescription.InDefinedShape inDefinedShape, PostProcessor postProcessor,
                            Map<String, TypeDefinition> map, Map<String, TypeDefinition> map2,
                            List<? extends OffsetMapping.Factory<?>> list, AsmClassReader asmClassReader,
                            TypeDefinition typeDefinition) {
                        super(inDefinedShape, postProcessor,
                                CompoundList.of(Arrays.asList(OffsetMapping.ForArgument.Unresolved.Factory.INSTANCE,
                                        OffsetMapping.ForAllArguments.Factory.INSTANCE,
                                        OffsetMapping.ForThisReference.Factory.INSTANCE,
                                        OffsetMapping.ForField.Unresolved.Factory.INSTANCE,
                                        OffsetMapping.ForFieldHandle.Unresolved.ReaderFactory.INSTANCE,
                                        OffsetMapping.ForFieldHandle.Unresolved.WriterFactory.INSTANCE,
                                        OffsetMapping.ForOrigin.Factory.INSTANCE,
                                        OffsetMapping.ForSelfCallHandle.Factory.INSTANCE,
                                        OffsetMapping.ForHandle.Factory.INSTANCE,
                                        OffsetMapping.ForDynamicConstant.Factory.INSTANCE,
                                        OffsetMapping.ForUnusedValue.Factory.INSTANCE,
                                        OffsetMapping.ForStubValue.INSTANCE,
                                        OffsetMapping.ForEnterValue.Factory.of(typeDefinition),
                                        OffsetMapping.ForExitValue.Factory.of(inDefinedShape.getReturnType()),
                                        new OffsetMapping.ForLocalValue.Factory(map),
                                        OffsetMapping.ForReturnValue.Factory.INSTANCE,
                                        OffsetMapping.ForThrowable.Factory.of(inDefinedShape)), (List) list),
                                (TypeDescription) inDefinedShape.getDeclaredAnnotations().ofType(OnMethodExit.class)
                                        .getValue(Advice.SUPPRESS_EXIT).resolve(TypeDescription.class),
                                (TypeDescription) inDefinedShape.getDeclaredAnnotations().ofType(OnMethodExit.class)
                                        .getValue(Advice.REPEAT_ON).resolve(TypeDescription.class),
                                ((Integer) inDefinedShape.getDeclaredAnnotations().ofType(OnMethodExit.class)
                                        .getValue(Advice.REPEAT_ON_INDEX).resolve(Integer.class)).intValue(),
                                asmClassReader);
                        this.uninitializedNamedTypes = map2;
                        this.backupArguments = ((Boolean) inDefinedShape.getDeclaredAnnotations()
                                .ofType(OnMethodExit.class).getValue(Advice.BACKUP_ARGUMENTS).resolve(Boolean.class))
                                .booleanValue();
                    }

                    private MethodVisitor doApply(MethodVisitor methodVisitor, Implementation.Context context,
                            Assigner assigner, ArgumentHandler.ForAdvice forAdvice,
                            MethodSizeHandler.ForAdvice forAdvice2, StackMapFrameHandler.ForAdvice forAdvice3,
                            TypeDescription typeDescription, MethodDescription methodDescription,
                            SuppressionHandler.Bound bound, RelocationHandler.Bound bound2,
                            StackManipulation stackManipulation) {
                        HashMap map = new HashMap();
                        for (Map.Entry<Integer, OffsetMapping> entry : this.offsetMappings.entrySet()) {
                            map.put(entry.getKey(), entry.getValue().resolve(typeDescription, methodDescription,
                                    assigner, forAdvice, OffsetMapping.Sort.EXIT));
                        }
                        return new CodeTranslationVisitor(methodVisitor, context, forAdvice, forAdvice2, forAdvice3,
                                typeDescription, methodDescription, assigner, this.adviceMethod, map, bound, bound2,
                                stackManipulation, this.postProcessor, true);
                    }

                    public static Resolved.ForMethodExit of(MethodDescription.InDefinedShape inDefinedShape,
                            PostProcessor postProcessor, Map<String, TypeDefinition> map,
                            Map<String, TypeDefinition> map2, List<? extends OffsetMapping.Factory<?>> list,
                            AsmClassReader asmClassReader, TypeDefinition typeDefinition) {
                        TypeDescription typeDescription = (TypeDescription) inDefinedShape.getDeclaredAnnotations()
                                .ofType(OnMethodExit.class).getValue(Advice.ON_THROWABLE)
                                .resolve(TypeDescription.class);
                        return typeDescription.represents(NoExceptionHandler.class)
                                ? new WithoutExceptionHandler(inDefinedShape, postProcessor, map, map2, list,
                                        asmClassReader, typeDefinition)
                                : new WithExceptionHandler(inDefinedShape, postProcessor, map, map2, list,
                                        asmClassReader, typeDefinition, typeDescription);
                    }

                    @Override // net.bytebuddy.asm.Advice.Dispatcher.Inlining.Resolved
                    public MethodVisitor apply(MethodVisitor methodVisitor, Implementation.Context context,
                            Assigner assigner, ArgumentHandler.ForInstrumentedMethod forInstrumentedMethod,
                            MethodSizeHandler.ForInstrumentedMethod forInstrumentedMethod2,
                            StackMapFrameHandler.ForInstrumentedMethod forInstrumentedMethod3,
                            TypeDescription typeDescription, MethodDescription methodDescription,
                            SuppressionHandler.Bound bound, RelocationHandler.Bound bound2,
                            StackManipulation stackManipulation) {
                        MethodDescription.TypeToken typeTokenAsTypeToken = this.adviceMethod.asTypeToken();
                        return doApply(methodVisitor, context, assigner,
                                forInstrumentedMethod.bindExit(typeTokenAsTypeToken,
                                        getThrowable().represents(NoExceptionHandler.class)),
                                forInstrumentedMethod2.bindExit(typeTokenAsTypeToken),
                                forInstrumentedMethod3.bindExit(typeTokenAsTypeToken), typeDescription,
                                methodDescription, bound, bound2, stackManipulation);
                    }

                    @Override // net.bytebuddy.asm.Advice.Dispatcher.Resolved
                    public Bound bind(TypeDescription typeDescription, MethodDescription methodDescription,
                            MethodVisitor methodVisitor, Implementation.Context context, Assigner assigner,
                            ArgumentHandler.ForInstrumentedMethod forInstrumentedMethod,
                            MethodSizeHandler.ForInstrumentedMethod forInstrumentedMethod2,
                            StackMapFrameHandler.ForInstrumentedMethod forInstrumentedMethod3,
                            StackManipulation stackManipulation, RelocationHandler.Relocation relocation) {
                        return new AdviceMethodInliner(typeDescription, methodDescription, methodVisitor, context,
                                assigner, forInstrumentedMethod, forInstrumentedMethod2, forInstrumentedMethod3,
                                this.suppressionHandler.bind(stackManipulation),
                                this.relocationHandler.bind(methodDescription, relocation), stackManipulation,
                                this.classReader);
                    }

                    @Override // net.bytebuddy.asm.Advice.Dispatcher.Resolved.AbstractBase
                    public boolean equals(@MaybeNull Object obj) {
                        if (!super.equals(obj)) {
                            return false;
                        }
                        if (this == obj) {
                            return true;
                        }
                        if (obj == null || getClass() != obj.getClass()) {
                            return false;
                        }
                        ForMethodExit forMethodExit = (ForMethodExit) obj;
                        return this.backupArguments == forMethodExit.backupArguments
                                && this.uninitializedNamedTypes.equals(forMethodExit.uninitializedNamedTypes);
                    }

                    @Override // net.bytebuddy.asm.Advice.Dispatcher
                    public TypeDefinition getAdviceType() {
                        return this.adviceMethod.getReturnType();
                    }

                    @Override // net.bytebuddy.asm.Advice.Dispatcher.Resolved.ForMethodExit
                    public ArgumentHandler.Factory getArgumentHandlerFactory() {
                        return this.backupArguments ? ArgumentHandler.Factory.COPYING : ArgumentHandler.Factory.SIMPLE;
                    }

                    @Override // net.bytebuddy.asm.Advice.Dispatcher.Resolved
                    public Map<String, TypeDefinition> getNamedTypes() {
                        return this.uninitializedNamedTypes;
                    }

                    @Override // net.bytebuddy.asm.Advice.Dispatcher.Resolved.AbstractBase
                    public int hashCode() {
                        return yg.c(this.uninitializedNamedTypes, super.hashCode() * 31, 31)
                                + (this.backupArguments ? 1 : 0);
                    }

                    @Override // net.bytebuddy.asm.Advice.Dispatcher.Inlining.Resolved
                    public Map<Integer, TypeDefinition> resolveInitializationTypes(ArgumentHandler argumentHandler) {
                        TreeMap treeMap = new TreeMap();
                        for (Map.Entry<String, TypeDefinition> entry : this.uninitializedNamedTypes.entrySet()) {
                            treeMap.put(Integer.valueOf(argumentHandler.named(entry.getKey())), entry.getValue());
                        }
                        if (!this.adviceMethod.getReturnType().represents(Void.TYPE)) {
                            treeMap.put(Integer.valueOf(argumentHandler.exit()), this.adviceMethod.getReturnType());
                        }
                        return treeMap;
                    }
                }

                public Resolved(MethodDescription.InDefinedShape inDefinedShape, PostProcessor postProcessor,
                        List<? extends OffsetMapping.Factory<?>> list, TypeDescription typeDescription,
                        TypeDescription typeDescription2, int i, AsmClassReader asmClassReader) {
                    super(inDefinedShape, postProcessor, list, typeDescription, typeDescription2, i,
                            OffsetMapping.Factory.AdviceType.INLINING);
                    this.adviceMethod = inDefinedShape;
                    this.classReader = asmClassReader;
                }

                public abstract MethodVisitor apply(MethodVisitor methodVisitor, Implementation.Context context,
                        Assigner assigner, ArgumentHandler.ForInstrumentedMethod forInstrumentedMethod,
                        MethodSizeHandler.ForInstrumentedMethod forInstrumentedMethod2,
                        StackMapFrameHandler.ForInstrumentedMethod forInstrumentedMethod3,
                        TypeDescription typeDescription, MethodDescription methodDescription,
                        SuppressionHandler.Bound bound, RelocationHandler.Bound bound2,
                        StackManipulation stackManipulation);

                public abstract Map<Integer, TypeDefinition> resolveInitializationTypes(
                        ArgumentHandler argumentHandler);

                /*
                 * JADX INFO: compiled from:
                 * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
                 */
                public class AdviceMethodInliner extends ClassVisitor implements Bound {
                    protected final ArgumentHandler.ForInstrumentedMethod argumentHandler;
                    protected final Assigner assigner;
                    protected final AsmClassReader classReader;
                    protected final StackManipulation exceptionHandler;
                    protected final Implementation.Context implementationContext;
                    protected final MethodDescription instrumentedMethod;
                    protected final TypeDescription instrumentedType;
                    protected final List<Label> labels;
                    protected final MethodSizeHandler.ForInstrumentedMethod methodSizeHandler;
                    protected final MethodVisitor methodVisitor;
                    protected final RelocationHandler.Bound relocationHandler;
                    protected final StackMapFrameHandler.ForInstrumentedMethod stackMapFrameHandler;
                    protected final SuppressionHandler.Bound suppressionHandler;

                    /*
                     * JADX INFO: compiled from:
                     * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
                     */
                    public class ExceptionTableCollector extends MethodVisitor {
                        private final MethodVisitor methodVisitor;

                        public ExceptionTableCollector(MethodVisitor methodVisitor) {
                            super(OpenedClassReader.ASM_API);
                            this.methodVisitor = methodVisitor;
                        }

                        @Override // net.bytebuddy.jar.asm.MethodVisitor
                        @MaybeNull
                        public AnnotationVisitor visitTryCatchAnnotation(int i, @MaybeNull TypePath typePath,
                                String str, boolean z) {
                            return this.methodVisitor.visitTryCatchAnnotation(i, typePath, str, z);
                        }

                        @Override // net.bytebuddy.jar.asm.MethodVisitor
                        public void visitTryCatchBlock(Label label, Label label2, Label label3, @MaybeNull String str) {
                            this.methodVisitor.visitTryCatchBlock(label, label2, label3, str);
                            AdviceMethodInliner.this.labels.addAll(Arrays.asList(label, label2, label3));
                        }
                    }

                    /*
                     * JADX INFO: compiled from:
                     * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
                     */
                    public class ExceptionTableExtractor extends ClassVisitor {
                        public ExceptionTableExtractor() {
                            super(OpenedClassReader.ASM_API);
                        }

                        @Override // net.bytebuddy.jar.asm.ClassVisitor
                        @MaybeNull
                        public MethodVisitor visitMethod(int i, String str, String str2, @MaybeNull String str3,
                                @MaybeNull String[] strArr) {
                            if (!Resolved.this.adviceMethod.getInternalName().equals(str)
                                    || !Resolved.this.adviceMethod.getDescriptor().equals(str2)) {
                                return Dispatcher.IGNORE_METHOD;
                            }
                            AdviceMethodInliner adviceMethodInliner = AdviceMethodInliner.this;
                            return adviceMethodInliner.new ExceptionTableCollector(adviceMethodInliner.methodVisitor);
                        }
                    }

                    public AdviceMethodInliner(TypeDescription typeDescription, MethodDescription methodDescription,
                            MethodVisitor methodVisitor, Implementation.Context context, Assigner assigner,
                            ArgumentHandler.ForInstrumentedMethod forInstrumentedMethod,
                            MethodSizeHandler.ForInstrumentedMethod forInstrumentedMethod2,
                            StackMapFrameHandler.ForInstrumentedMethod forInstrumentedMethod3,
                            SuppressionHandler.Bound bound, RelocationHandler.Bound bound2,
                            StackManipulation stackManipulation, AsmClassReader asmClassReader) {
                        super(OpenedClassReader.ASM_API);
                        this.instrumentedType = typeDescription;
                        this.instrumentedMethod = methodDescription;
                        this.methodVisitor = methodVisitor;
                        this.implementationContext = context;
                        this.assigner = assigner;
                        this.argumentHandler = forInstrumentedMethod;
                        this.methodSizeHandler = forInstrumentedMethod2;
                        this.stackMapFrameHandler = forInstrumentedMethod3;
                        this.suppressionHandler = bound;
                        this.relocationHandler = bound2;
                        this.exceptionHandler = stackManipulation;
                        this.classReader = asmClassReader;
                        this.labels = new ArrayList();
                    }

                    @Override // net.bytebuddy.asm.Advice.Dispatcher.Bound
                    public void apply() {
                        this.classReader.accept(this, this.stackMapFrameHandler.getReaderHint() | 2);
                    }

                    @Override // net.bytebuddy.asm.Advice.Dispatcher.Bound
                    public void initialize() {
                        for (Map.Entry<Integer, TypeDefinition> entry : Resolved.this
                                .resolveInitializationTypes(this.argumentHandler).entrySet()) {
                            if (entry.getValue().represents(Boolean.TYPE) || entry.getValue().represents(Byte.TYPE)
                                    || entry.getValue().represents(Short.TYPE)
                                    || entry.getValue().represents(Character.TYPE)
                                    || entry.getValue().represents(Integer.TYPE)) {
                                this.methodVisitor.visitInsn(3);
                                this.methodVisitor.visitVarInsn(54, entry.getKey().intValue());
                            } else if (entry.getValue().represents(Long.TYPE)) {
                                this.methodVisitor.visitInsn(9);
                                this.methodVisitor.visitVarInsn(55, entry.getKey().intValue());
                            } else if (entry.getValue().represents(Float.TYPE)) {
                                this.methodVisitor.visitInsn(11);
                                this.methodVisitor.visitVarInsn(56, entry.getKey().intValue());
                            } else if (entry.getValue().represents(Double.TYPE)) {
                                this.methodVisitor.visitInsn(14);
                                this.methodVisitor.visitVarInsn(57, entry.getKey().intValue());
                            } else {
                                this.methodVisitor.visitInsn(1);
                                this.methodVisitor.visitVarInsn(58, entry.getKey().intValue());
                            }
                            this.methodSizeHandler.requireStackSize(entry.getValue().getStackSize().getSize());
                        }
                    }

                    @Override // net.bytebuddy.asm.Advice.Dispatcher.Bound
                    public void prepare() {
                        this.classReader.accept(new ExceptionTableExtractor(), 6);
                        this.suppressionHandler.onPrepare(this.methodVisitor);
                    }

                    @Override // net.bytebuddy.jar.asm.ClassVisitor
                    @MaybeNull
                    public MethodVisitor visitMethod(int i, String str, String str2, @MaybeNull String str3,
                            @MaybeNull String[] strArr) {
                        return (Resolved.this.adviceMethod.getInternalName().equals(str)
                                && Resolved.this.adviceMethod.getDescriptor().equals(str2))
                                        ? new ExceptionTableSubstitutor(Resolved.this.apply(this.methodVisitor,
                                                this.implementationContext, this.assigner, this.argumentHandler,
                                                this.methodSizeHandler, this.stackMapFrameHandler,
                                                this.instrumentedType, this.instrumentedMethod, this.suppressionHandler,
                                                this.relocationHandler, this.exceptionHandler))
                                        : Dispatcher.IGNORE_METHOD;
                    }

                    /*
                     * JADX INFO: compiled from:
                     * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
                     */
                    public class ExceptionTableSubstitutor extends MethodVisitor {
                        private int index;
                        private final Map<Label, Label> substitutions;

                        public ExceptionTableSubstitutor(MethodVisitor methodVisitor) {
                            super(OpenedClassReader.ASM_API, methodVisitor);
                            this.substitutions = new IdentityHashMap();
                        }

                        private Label[] resolve(Label[] labelArr) {
                            Label[] labelArr2 = new Label[labelArr.length];
                            int length = labelArr.length;
                            int i = 0;
                            int i2 = 0;
                            while (i < length) {
                                labelArr2[i2] = resolve(labelArr[i]);
                                i++;
                                i2++;
                            }
                            return labelArr2;
                        }

                        @Override // net.bytebuddy.jar.asm.MethodVisitor
                        public void visitJumpInsn(int i, Label label) {
                            super.visitJumpInsn(i, resolve(label));
                        }

                        @Override // net.bytebuddy.jar.asm.MethodVisitor
                        public void visitLabel(Label label) {
                            super.visitLabel(resolve(label));
                        }

                        @Override // net.bytebuddy.jar.asm.MethodVisitor
                        public void visitLookupSwitchInsn(Label label, int[] iArr, Label[] labelArr) {
                            super.visitLookupSwitchInsn(resolve(label), iArr, resolve(labelArr));
                        }

                        @Override // net.bytebuddy.jar.asm.MethodVisitor
                        public void visitTableSwitchInsn(int i, int i2, Label label, Label... labelArr) {
                            super.visitTableSwitchInsn(i, i2, label, resolve(labelArr));
                        }

                        @Override // net.bytebuddy.jar.asm.MethodVisitor
                        @MaybeNull
                        public AnnotationVisitor visitTryCatchAnnotation(int i, @MaybeNull TypePath typePath,
                                String str, boolean z) {
                            return Dispatcher.IGNORE_ANNOTATION;
                        }

                        @Override // net.bytebuddy.jar.asm.MethodVisitor
                        public void visitTryCatchBlock(Label label, Label label2, Label label3, String str) {
                            Map<Label, Label> map = this.substitutions;
                            List<Label> list = AdviceMethodInliner.this.labels;
                            int i = this.index;
                            this.index = i + 1;
                            map.put(label, list.get(i));
                            Map<Label, Label> map2 = this.substitutions;
                            List<Label> list2 = AdviceMethodInliner.this.labels;
                            int i2 = this.index;
                            this.index = i2 + 1;
                            map2.put(label2, list2.get(i2));
                            List<Label> list3 = AdviceMethodInliner.this.labels;
                            int i3 = this.index;
                            this.index = i3 + 1;
                            Label label4 = list3.get(i3);
                            this.substitutions.put(label3, label4);
                            ((CodeTranslationVisitor) this.mv).propagateHandler(label4);
                        }

                        private Label resolve(Label label) {
                            Label label2 = this.substitutions.get(label);
                            return label2 == null ? label : label2;
                        }
                    }
                }
            }

            public Inlining(MethodDescription.InDefinedShape inDefinedShape) {
                String str;
                TypeDefinition typeDefinitionPut;
                this.adviceMethod = inDefinedShape;
                for (ParameterDescription.InDefinedShape inDefinedShape2 : inDefinedShape.getParameters()) {
                    AnnotationDescription.Loadable loadableOfType = inDefinedShape2.getDeclaredAnnotations()
                            .ofType(Local.class);
                    if (loadableOfType != null
                            && (typeDefinitionPut = this.namedTypes.put((str = (String) loadableOfType
                                    .getValue(OffsetMapping.ForLocalValue.Factory.LOCAL_VALUE).resolve(String.class)),
                                    inDefinedShape2.getType())) != null
                            && !typeDefinitionPut.equals(inDefinedShape2.getType())) {
                        throw new IllegalStateException(
                                concat("Local variable for ", str, " is defined with inconsistent types"));
                    }
                }
            }

            @Override // net.bytebuddy.asm.Advice.Dispatcher.Unresolved
            public Resolved.ForMethodEnter asMethodEnter(List<? extends OffsetMapping.Factory<?>> list,
                    @MaybeNull AsmClassReader asmClassReader, Unresolved unresolved, PostProcessor.Factory factory) {
                if (asmClassReader == null) {
                    throw new IllegalStateException("Class reader not expected null");
                }
                MethodDescription.InDefinedShape inDefinedShape = this.adviceMethod;
                return Resolved.ForMethodEnter.of(inDefinedShape,
                        factory.make(inDefinedShape.getDeclaredAnnotations(),
                                this.adviceMethod.getReturnType().asErasure(), false),
                        this.namedTypes, list, unresolved.getAdviceType(), asmClassReader, unresolved.isAlive());
            }

            @Override // net.bytebuddy.asm.Advice.Dispatcher.Unresolved
            public Resolved.ForMethodExit asMethodExit(List<? extends OffsetMapping.Factory<?>> list,
                    @MaybeNull AsmClassReader asmClassReader, Unresolved unresolved, PostProcessor.Factory factory) {
                HashMap map = new HashMap(unresolved.getNamedTypes());
                HashMap map2 = new HashMap();
                for (Map.Entry<String, TypeDefinition> entry : this.namedTypes.entrySet()) {
                    TypeDefinition typeDefinition = (TypeDefinition) map.get(entry.getKey());
                    TypeDefinition typeDefinition2 = (TypeDefinition) map2.get(entry.getKey());
                    if (typeDefinition == null && typeDefinition2 == null) {
                        map.put(entry.getKey(), entry.getValue());
                        map2.put(entry.getKey(), entry.getValue());
                    } else {
                        if (typeDefinition == null) {
                            typeDefinition = typeDefinition2;
                        }
                        if (!typeDefinition.equals(entry.getValue())) {
                            throw new IllegalStateException(yg.concatToVar1(new StringBuilder("Local variable for "),
                                    entry.getKey(), " is defined with inconsistent types"));
                        }
                    }
                }
                MethodDescription.InDefinedShape inDefinedShape = this.adviceMethod;
                return Resolved.ForMethodExit.of(inDefinedShape,
                        factory.make(inDefinedShape.getDeclaredAnnotations(),
                                this.adviceMethod.getReturnType().asErasure(), true),
                        map, map2, list, asmClassReader, unresolved.getAdviceType());
            }

            public boolean equals(@MaybeNull Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || getClass() != obj.getClass()) {
                    return false;
                }
                Inlining inlining = (Inlining) obj;
                return this.adviceMethod.equals(inlining.adviceMethod) && this.namedTypes.equals(inlining.namedTypes);
            }

            @Override // net.bytebuddy.asm.Advice.Dispatcher.Unresolved
            public Map<String, TypeDefinition> getNamedTypes() {
                return this.namedTypes;
            }

            public int hashCode() {
                return this.namedTypes.hashCode() + StaticHelpers6.b(this.adviceMethod, getClass().hashCode() * 31, 31);
            }

            @Override // net.bytebuddy.asm.Advice.Dispatcher
            public boolean isAlive() {
                return true;
            }

            @Override // net.bytebuddy.asm.Advice.Dispatcher.Unresolved
            public boolean isBinary() {
                return true;
            }

            public String toString() {
                return "Delegate to " + this.adviceMethod;
            }

            @Override // net.bytebuddy.asm.Advice.Dispatcher
            public TypeDescription getAdviceType() {
                return this.adviceMethod.getReturnType().asErasure();
            }
        }

        /*
         * JADX INFO: compiled from:
         * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
         */
        public interface RelocationHandler {

            /*
             * JADX INFO: compiled from:
             * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
             */
            public interface Bound {
                public static final int NO_REQUIRED_SIZE = 0;

                int apply(MethodVisitor methodVisitor, Implementation.Context context, int i);
            }

            /*
             * JADX INFO: compiled from:
             * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
             */
            public enum Disabled implements RelocationHandler, Bound {
                INSTANCE;

                @Override // net.bytebuddy.asm.Advice.Dispatcher.RelocationHandler.Bound
                public int apply(MethodVisitor methodVisitor, Implementation.Context context, int i) {
                    return 0;
                }

                @Override // net.bytebuddy.asm.Advice.Dispatcher.RelocationHandler
                public Bound bind(MethodDescription methodDescription, Relocation relocation) {
                    return this;
                }
            }

            /*
             * JADX INFO: compiled from:
             * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
             */
            @HashCodeAndEqualsPlugin.Enhance
            public static class ForType implements RelocationHandler {
                private final int index;
                private final TypeDescription typeDescription;

                /*
                 * JADX INFO: compiled from:
                 * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
                 */
                @HashCodeAndEqualsPlugin.Enhance(includeSyntheticFields = true)
                public class Bound implements Bound {
                    private final MethodDescription instrumentedMethod;
                    private final Relocation relocation;

                    public Bound(MethodDescription methodDescription, Relocation relocation) {
                        this.instrumentedMethod = methodDescription;
                        this.relocation = relocation;
                    }

                    @Override // net.bytebuddy.asm.Advice.Dispatcher.RelocationHandler.Bound
                    public int apply(MethodVisitor methodVisitor, Implementation.Context context, int i) {
                        int maximalSize;
                        if (this.instrumentedMethod.isConstructor()) {
                            throw new IllegalStateException(
                                    "Cannot skip code execution from constructor: " + this.instrumentedMethod);
                        }
                        methodVisitor.visitVarInsn(25, i);
                        Label label = new Label();
                        if (ForType.this.index < 0) {
                            maximalSize = 0;
                        } else {
                            methodVisitor.visitJumpInsn(198, label);
                            methodVisitor.visitVarInsn(25, i);
                            maximalSize = IntegerConstant.forValue(ForType.this.index).apply(methodVisitor, context)
                                    .getMaximalSize() + 1;
                            methodVisitor.visitInsn(50);
                        }
                        methodVisitor.visitTypeInsn(193, ForType.this.typeDescription.getInternalName());
                        methodVisitor.visitJumpInsn(153, label);
                        this.relocation.apply(methodVisitor);
                        methodVisitor.visitLabel(label);
                        return maximalSize;
                    }

                    public boolean equals(@MaybeNull Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        if (obj == null || getClass() != obj.getClass()) {
                            return false;
                        }
                        Bound bound = (Bound) obj;
                        return this.instrumentedMethod.equals(bound.instrumentedMethod)
                                && this.relocation.equals(bound.relocation) && ForType.this.equals(ForType.this);
                    }

                    public int hashCode() {
                        return ForType.this.hashCode() + ((this.relocation.hashCode()
                                + StaticHelpers6.c(this.instrumentedMethod, getClass().hashCode() * 31, 31)) * 31);
                    }
                }

                public ForType(TypeDescription typeDescription, int i) {
                    this.typeDescription = typeDescription;
                    this.index = i;
                }

                public static RelocationHandler of(TypeDescription typeDescription, int i,
                        TypeDefinition typeDefinition) {
                    if (i >= 0) {
                        if (!typeDefinition.isArray()) {
                            throw new IllegalStateException(
                                    typeDefinition + " is not an array type but an index for a relocation is defined");
                        }
                        typeDefinition = typeDefinition.getComponentType();
                    }
                    if (typeDescription.represents(Void.TYPE)) {
                        return Disabled.INSTANCE;
                    }
                    if (typeDescription.represents(OnDefaultValue.class)) {
                        return ForValue.of(typeDefinition, i, false);
                    }
                    if (typeDescription.represents(OnNonDefaultValue.class)) {
                        return ForValue.of(typeDefinition, i, true);
                    }
                    if (typeDescription.isPrimitive() || typeDefinition.isPrimitive()) {
                        throw new IllegalStateException(
                                "Cannot relocate execution by instance type for primitive type");
                    }
                    return new ForType(typeDescription, i);
                }

                @Override // net.bytebuddy.asm.Advice.Dispatcher.RelocationHandler
                public Bound bind(MethodDescription methodDescription, Relocation relocation) {
                    return new Bound(methodDescription, relocation);
                }

                public boolean equals(@MaybeNull Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (obj == null || getClass() != obj.getClass()) {
                        return false;
                    }
                    ForType forType = (ForType) obj;
                    return this.index == forType.index && this.typeDescription.equals(forType.typeDescription);
                }

                public int hashCode() {
                    return StaticHelpers6.f(this.typeDescription, getClass().hashCode() * 31, 31) + this.index;
                }
            }

            /*
             * JADX INFO: compiled from:
             * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
             */
            public enum ForValue {
                BOOLEAN(21, 51, 154, 153, 0) { // from class:
                                               // net.bytebuddy.asm.Advice.Dispatcher.RelocationHandler.ForValue.1
                    @Override // net.bytebuddy.asm.Advice.Dispatcher.RelocationHandler.ForValue
                    public void convertValue(MethodVisitor methodVisitor) {
                    }
                },
                BYTE(21, 51, 154, 153, 0) { // from class:
                                            // net.bytebuddy.asm.Advice.Dispatcher.RelocationHandler.ForValue.2
                    @Override // net.bytebuddy.asm.Advice.Dispatcher.RelocationHandler.ForValue
                    public void convertValue(MethodVisitor methodVisitor) {
                    }
                },
                SHORT(21, 53, 154, 153, 0) { // from class:
                                             // net.bytebuddy.asm.Advice.Dispatcher.RelocationHandler.ForValue.3
                    @Override // net.bytebuddy.asm.Advice.Dispatcher.RelocationHandler.ForValue
                    public void convertValue(MethodVisitor methodVisitor) {
                    }
                },
                CHARACTER(21, 52, 154, 153, 0) { // from class:
                                                 // net.bytebuddy.asm.Advice.Dispatcher.RelocationHandler.ForValue.4
                    @Override // net.bytebuddy.asm.Advice.Dispatcher.RelocationHandler.ForValue
                    public void convertValue(MethodVisitor methodVisitor) {
                    }
                },
                INTEGER(21, 46, 154, 153, 0) { // from class:
                                               // net.bytebuddy.asm.Advice.Dispatcher.RelocationHandler.ForValue.5
                    @Override // net.bytebuddy.asm.Advice.Dispatcher.RelocationHandler.ForValue
                    public void convertValue(MethodVisitor methodVisitor) {
                    }
                },
                LONG(22, 47, 154, 153, 0) { // from class:
                                            // net.bytebuddy.asm.Advice.Dispatcher.RelocationHandler.ForValue.6
                    @Override // net.bytebuddy.asm.Advice.Dispatcher.RelocationHandler.ForValue
                    public void convertValue(MethodVisitor methodVisitor) {
                        methodVisitor.visitInsn(136);
                    }
                },
                FLOAT(23, 48, 154, 153, 2) { // from class:
                                             // net.bytebuddy.asm.Advice.Dispatcher.RelocationHandler.ForValue.7
                    @Override // net.bytebuddy.asm.Advice.Dispatcher.RelocationHandler.ForValue
                    public void convertValue(MethodVisitor methodVisitor) {
                        methodVisitor.visitInsn(11);
                        methodVisitor.visitInsn(149);
                    }
                },
                DOUBLE(24, 49, 154, 153, 4) { // from class:
                                              // net.bytebuddy.asm.Advice.Dispatcher.RelocationHandler.ForValue.8
                    @Override // net.bytebuddy.asm.Advice.Dispatcher.RelocationHandler.ForValue
                    public void convertValue(MethodVisitor methodVisitor) {
                        methodVisitor.visitInsn(14);
                        methodVisitor.visitInsn(151);
                    }
                },
                REFERENCE(25, 50, 199, 198, 0) { // from class:
                                                 // net.bytebuddy.asm.Advice.Dispatcher.RelocationHandler.ForValue.9
                    @Override // net.bytebuddy.asm.Advice.Dispatcher.RelocationHandler.ForValue
                    public void convertValue(MethodVisitor methodVisitor) {
                    }
                };

                private final int arrayLoad;
                private final int defaultJump;
                private final int load;
                private final int nonDefaultJump;
                private final int requiredSize;

                /*
                 * JADX INFO: compiled from:
                 * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
                 */
                @HashCodeAndEqualsPlugin.Enhance(includeSyntheticFields = true)
                public class Bound implements Bound {
                    private final int index;
                    private final MethodDescription instrumentedMethod;
                    private final boolean inverted;
                    private final Relocation relocation;

                    public Bound(MethodDescription methodDescription, Relocation relocation, int i, boolean z) {
                        this.instrumentedMethod = methodDescription;
                        this.relocation = relocation;
                        this.index = i;
                        this.inverted = z;
                    }

                    @Override // net.bytebuddy.asm.Advice.Dispatcher.RelocationHandler.Bound
                    public int apply(MethodVisitor methodVisitor, Implementation.Context context, int i) {
                        int iMax;
                        if (this.instrumentedMethod.isConstructor()) {
                            throw new IllegalStateException(
                                    "Cannot skip code execution from constructor: " + this.instrumentedMethod);
                        }
                        Label label = new Label();
                        if (this.index < 0) {
                            iMax = ForValue.this.requiredSize;
                            methodVisitor.visitVarInsn(ForValue.this.load, i);
                        } else {
                            methodVisitor.visitVarInsn(25, i);
                            methodVisitor.visitJumpInsn(198, label);
                            methodVisitor.visitVarInsn(25, i);
                            iMax = Math.max(ForValue.this.requiredSize,
                                    IntegerConstant.forValue(this.index).apply(methodVisitor, context).getMaximalSize()
                                            + 1);
                            methodVisitor.visitInsn(ForValue.this.arrayLoad);
                        }
                        ForValue.this.convertValue(methodVisitor);
                        methodVisitor.visitJumpInsn(
                                this.inverted ? ForValue.this.nonDefaultJump : ForValue.this.defaultJump, label);
                        this.relocation.apply(methodVisitor);
                        methodVisitor.visitLabel(label);
                        return iMax;
                    }

                    public boolean equals(@MaybeNull Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        if (obj == null || getClass() != obj.getClass()) {
                            return false;
                        }
                        Bound bound = (Bound) obj;
                        return this.index == bound.index && this.inverted == bound.inverted
                                && ForValue.this.equals(ForValue.this)
                                && this.instrumentedMethod.equals(bound.instrumentedMethod)
                                && this.relocation.equals(bound.relocation);
                    }

                    public int hashCode() {
                        return ForValue.this.hashCode() + ((((((this.relocation.hashCode()
                                + StaticHelpers6.c(this.instrumentedMethod, getClass().hashCode() * 31, 31)) * 31) + this.index)
                                * 31) + (this.inverted ? 1 : 0)) * 31);
                    }
                }

                /*
                 * JADX INFO: compiled from:
                 * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
                 */
                @HashCodeAndEqualsPlugin.Enhance(includeSyntheticFields = true)
                public class OfDefault implements RelocationHandler {
                    private final int index;

                    public OfDefault(int i) {
                        this.index = i;
                    }

                    @Override // net.bytebuddy.asm.Advice.Dispatcher.RelocationHandler
                    public Bound bind(MethodDescription methodDescription, Relocation relocation) {
                        return ForValue.this.new Bound(methodDescription, relocation, this.index, false);
                    }

                    public boolean equals(@MaybeNull Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        if (obj == null || getClass() != obj.getClass()) {
                            return false;
                        }
                        OfDefault ofDefault = (OfDefault) obj;
                        return this.index == ofDefault.index && ForValue.this.equals(ForValue.this);
                    }

                    public int hashCode() {
                        return ForValue.this.hashCode() + (((getClass().hashCode() * 31) + this.index) * 31);
                    }
                }

                /*
                 * JADX INFO: compiled from:
                 * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
                 */
                @HashCodeAndEqualsPlugin.Enhance(includeSyntheticFields = true)
                public class OfNonDefault implements RelocationHandler {
                    private final int index;

                    public OfNonDefault(int i) {
                        this.index = i;
                    }

                    @Override // net.bytebuddy.asm.Advice.Dispatcher.RelocationHandler
                    public Bound bind(MethodDescription methodDescription, Relocation relocation) {
                        return ForValue.this.new Bound(methodDescription, relocation, this.index, true);
                    }

                    public boolean equals(@MaybeNull Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        if (obj == null || getClass() != obj.getClass()) {
                            return false;
                        }
                        OfNonDefault ofNonDefault = (OfNonDefault) obj;
                        return this.index == ofNonDefault.index && ForValue.this.equals(ForValue.this);
                    }

                    public int hashCode() {
                        return ForValue.this.hashCode() + (((getClass().hashCode() * 31) + this.index) * 31);
                    }
                }

                public static RelocationHandler of(TypeDefinition typeDefinition, int i, boolean z) {
                    ForValue forValue;
                    if (typeDefinition.represents(Boolean.TYPE)) {
                        forValue = BOOLEAN;
                    } else if (typeDefinition.represents(Byte.TYPE)) {
                        forValue = BYTE;
                    } else if (typeDefinition.represents(Short.TYPE)) {
                        forValue = SHORT;
                    } else if (typeDefinition.represents(Character.TYPE)) {
                        forValue = CHARACTER;
                    } else if (typeDefinition.represents(Integer.TYPE)) {
                        forValue = INTEGER;
                    } else if (typeDefinition.represents(Long.TYPE)) {
                        forValue = LONG;
                    } else if (typeDefinition.represents(Float.TYPE)) {
                        forValue = FLOAT;
                    } else if (typeDefinition.represents(Double.TYPE)) {
                        forValue = DOUBLE;
                    } else {
                        if (typeDefinition.represents(Void.TYPE)) {
                            throw new IllegalStateException("Cannot skip on default value for void return type");
                        }
                        forValue = REFERENCE;
                    }
                    if (z) {
                        forValue.getClass();
                        return forValue.new OfNonDefault(i);
                    }
                    forValue.getClass();
                    return forValue.new OfDefault(i);
                }

                public abstract void convertValue(MethodVisitor methodVisitor);

                ForValue(int i, int i2, int i3, int i4, int i5) {
                    this.load = i;
                    this.arrayLoad = i2;
                    this.defaultJump = i3;
                    this.nonDefaultJump = i4;
                    this.requiredSize = i5;
                }
            }

            /*
             * JADX INFO: compiled from:
             * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
             */
            public interface Relocation {

                /*
                 * JADX INFO: compiled from:
                 * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
                 */
                @HashCodeAndEqualsPlugin.Enhance
                public static class ForLabel implements Relocation {
                    private final Label label;

                    public ForLabel(Label label) {
                        this.label = label;
                    }

                    @Override // net.bytebuddy.asm.Advice.Dispatcher.RelocationHandler.Relocation
                    public void apply(MethodVisitor methodVisitor) {
                        methodVisitor.visitJumpInsn(167, this.label);
                    }

                    public boolean equals(@MaybeNull Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        return obj != null && getClass() == obj.getClass() && this.label.equals(((ForLabel) obj).label);
                    }

                    public int hashCode() {
                        return this.label.hashCode() + (getClass().hashCode() * 31);
                    }
                }

                void apply(MethodVisitor methodVisitor);
            }

            Bound bind(MethodDescription methodDescription, Relocation relocation);
        }

        /*
         * JADX INFO: compiled from:
         * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
         */
        public interface Resolved extends Dispatcher {

            /*
             * JADX INFO: compiled from:
             * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
             */
            @HashCodeAndEqualsPlugin.Enhance
            public static abstract class AbstractBase implements Resolved {
                protected final Map<Integer, OffsetMapping> offsetMappings;
                protected final PostProcessor postProcessor;
                protected final RelocationHandler relocationHandler;
                protected final SuppressionHandler suppressionHandler;

                public AbstractBase(MethodDescription.InDefinedShape inDefinedShape, PostProcessor postProcessor,
                        List<? extends OffsetMapping.Factory<?>> list, TypeDescription typeDescription,
                        TypeDescription typeDescription2, int i, OffsetMapping.Factory.AdviceType adviceType) {
                    this.postProcessor = postProcessor;
                    HashMap map = new HashMap();
                    for (OffsetMapping.Factory<?> factory : list) {
                        map.put(TypeDescription.ForLoadedType.of(factory.getAnnotationType()), factory);
                    }
                    this.offsetMappings = new LinkedHashMap();
                    for (ParameterDescription.InDefinedShape inDefinedShape2 : inDefinedShape.getParameters()) {
                        OffsetMapping unresolved = null;
                        for (AnnotationDescription annotationDescription : inDefinedShape2.getDeclaredAnnotations()) {
                            OffsetMapping.Factory factory2 = (OffsetMapping.Factory) map
                                    .get(annotationDescription.getAnnotationType());
                            if (factory2 != null) {
                                OffsetMapping offsetMappingMake = factory2.make(inDefinedShape2,
                                        annotationDescription.prepare(factory2.getAnnotationType()), adviceType);
                                if (unresolved != null) {
                                    throw new IllegalStateException(inDefinedShape2 + " is bound to both "
                                            + offsetMappingMake + " and " + unresolved);
                                }
                                unresolved = offsetMappingMake;
                            }
                        }
                        Map<Integer, OffsetMapping> map2 = this.offsetMappings;
                        Integer numValueOf = Integer.valueOf(inDefinedShape2.getOffset());
                        if (unresolved == null) {
                            unresolved = new OffsetMapping.ForArgument.Unresolved(inDefinedShape2);
                        }
                        map2.put(numValueOf, unresolved);
                    }
                    this.suppressionHandler = SuppressionHandler.Suppressing.of(typeDescription);
                    this.relocationHandler = RelocationHandler.ForType.of(typeDescription2, i,
                            inDefinedShape.getReturnType());
                }

                public boolean equals(@MaybeNull Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (obj == null || getClass() != obj.getClass()) {
                        return false;
                    }
                    AbstractBase abstractBase = (AbstractBase) obj;
                    return this.postProcessor.equals(abstractBase.postProcessor)
                            && this.offsetMappings.equals(abstractBase.offsetMappings)
                            && this.suppressionHandler.equals(abstractBase.suppressionHandler)
                            && this.relocationHandler.equals(abstractBase.relocationHandler);
                }

                public int hashCode() {
                    return this.relocationHandler.hashCode()
                            + ((this.suppressionHandler.hashCode() + yg.c(this.offsetMappings,
                                    (this.postProcessor.hashCode() + (getClass().hashCode() * 31)) * 31, 31)) * 31);
                }

                @Override // net.bytebuddy.asm.Advice.Dispatcher
                public boolean isAlive() {
                    return true;
                }
            }

            /*
             * JADX INFO: compiled from:
             * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
             */
            public interface ForMethodEnter extends Resolved {
                TypeDefinition getActualAdviceType();

                boolean isPrependLineNumber();
            }

            /*
             * JADX INFO: compiled from:
             * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
             */
            public interface ForMethodExit extends Resolved {
                ArgumentHandler.Factory getArgumentHandlerFactory();

                TypeDescription getThrowable();
            }

            Bound bind(TypeDescription typeDescription, MethodDescription methodDescription,
                    MethodVisitor methodVisitor, Implementation.Context context, Assigner assigner,
                    ArgumentHandler.ForInstrumentedMethod forInstrumentedMethod,
                    MethodSizeHandler.ForInstrumentedMethod forInstrumentedMethod2,
                    StackMapFrameHandler.ForInstrumentedMethod forInstrumentedMethod3,
                    StackManipulation stackManipulation, RelocationHandler.Relocation relocation);

            Map<String, TypeDefinition> getNamedTypes();
        }

        /*
         * JADX INFO: compiled from:
         * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
         */
        public interface SuppressionHandler {

            /*
             * JADX INFO: compiled from:
             * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
             */
            public interface Bound {
                void onEnd(MethodVisitor methodVisitor, Implementation.Context context,
                        MethodSizeHandler.ForAdvice forAdvice, StackMapFrameHandler.ForAdvice forAdvice2,
                        TypeDefinition typeDefinition);

                void onEndWithSkip(MethodVisitor methodVisitor, Implementation.Context context,
                        MethodSizeHandler.ForAdvice forAdvice, StackMapFrameHandler.ForAdvice forAdvice2,
                        TypeDefinition typeDefinition);

                void onPrepare(MethodVisitor methodVisitor);

                void onStart(MethodVisitor methodVisitor);
            }

            /*
             * JADX INFO: compiled from:
             * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
             */
            public enum NoOp implements SuppressionHandler, Bound {
                INSTANCE;

                @Override // net.bytebuddy.asm.Advice.Dispatcher.SuppressionHandler
                public Bound bind(StackManipulation stackManipulation) {
                    return this;
                }

                @Override // net.bytebuddy.asm.Advice.Dispatcher.SuppressionHandler.Bound
                public void onEnd(MethodVisitor methodVisitor, Implementation.Context context,
                        MethodSizeHandler.ForAdvice forAdvice, StackMapFrameHandler.ForAdvice forAdvice2,
                        TypeDefinition typeDefinition) {
                }

                @Override // net.bytebuddy.asm.Advice.Dispatcher.SuppressionHandler.Bound
                public void onEndWithSkip(MethodVisitor methodVisitor, Implementation.Context context,
                        MethodSizeHandler.ForAdvice forAdvice, StackMapFrameHandler.ForAdvice forAdvice2,
                        TypeDefinition typeDefinition) {
                }

                @Override // net.bytebuddy.asm.Advice.Dispatcher.SuppressionHandler.Bound
                public void onPrepare(MethodVisitor methodVisitor) {
                }

                @Override // net.bytebuddy.asm.Advice.Dispatcher.SuppressionHandler.Bound
                public void onStart(MethodVisitor methodVisitor) {
                }
            }

            /*
             * JADX INFO: compiled from:
             * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
             */
            @HashCodeAndEqualsPlugin.Enhance
            public static class Suppressing implements SuppressionHandler {
                private final TypeDescription suppressedType;

                /*
                 * JADX INFO: compiled from:
                 * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
                 */
                public static class Bound implements Bound {
                    private final StackManipulation exceptionHandler;
                    private final TypeDescription suppressedType;
                    private final Label startOfMethod = new Label();
                    private final Label endOfMethod = new Label();

                    public Bound(TypeDescription typeDescription, StackManipulation stackManipulation) {
                        this.suppressedType = typeDescription;
                        this.exceptionHandler = stackManipulation;
                    }

                    @Override // net.bytebuddy.asm.Advice.Dispatcher.SuppressionHandler.Bound
                    public void onEnd(MethodVisitor methodVisitor, Implementation.Context context,
                            MethodSizeHandler.ForAdvice forAdvice, StackMapFrameHandler.ForAdvice forAdvice2,
                            TypeDefinition typeDefinition) {
                        methodVisitor.visitLabel(this.endOfMethod);
                        forAdvice2.injectExceptionFrame(methodVisitor);
                        forAdvice.requireStackSize(
                                this.exceptionHandler.apply(methodVisitor, context).getMaximalSize() + 1);
                        if (typeDefinition.represents(Boolean.TYPE) || typeDefinition.represents(Byte.TYPE)
                                || typeDefinition.represents(Short.TYPE) || typeDefinition.represents(Character.TYPE)
                                || typeDefinition.represents(Integer.TYPE)) {
                            methodVisitor.visitInsn(3);
                            return;
                        }
                        if (typeDefinition.represents(Long.TYPE)) {
                            methodVisitor.visitInsn(9);
                            return;
                        }
                        if (typeDefinition.represents(Float.TYPE)) {
                            methodVisitor.visitInsn(11);
                        } else if (typeDefinition.represents(Double.TYPE)) {
                            methodVisitor.visitInsn(14);
                        } else {
                            if (typeDefinition.represents(Void.TYPE)) {
                                return;
                            }
                            methodVisitor.visitInsn(1);
                        }
                    }

                    @Override // net.bytebuddy.asm.Advice.Dispatcher.SuppressionHandler.Bound
                    public void onEndWithSkip(MethodVisitor methodVisitor, Implementation.Context context,
                            MethodSizeHandler.ForAdvice forAdvice, StackMapFrameHandler.ForAdvice forAdvice2,
                            TypeDefinition typeDefinition) {
                        Label label = new Label();
                        methodVisitor.visitJumpInsn(167, label);
                        onEnd(methodVisitor, context, forAdvice, forAdvice2, typeDefinition);
                        methodVisitor.visitLabel(label);
                        forAdvice2.injectReturnFrame(methodVisitor);
                    }

                    @Override // net.bytebuddy.asm.Advice.Dispatcher.SuppressionHandler.Bound
                    public void onPrepare(MethodVisitor methodVisitor) {
                        Label label = this.startOfMethod;
                        Label label2 = this.endOfMethod;
                        methodVisitor.visitTryCatchBlock(label, label2, label2, this.suppressedType.getInternalName());
                    }

                    @Override // net.bytebuddy.asm.Advice.Dispatcher.SuppressionHandler.Bound
                    public void onStart(MethodVisitor methodVisitor) {
                        methodVisitor.visitLabel(this.startOfMethod);
                    }
                }

                public Suppressing(TypeDescription typeDescription) {
                    this.suppressedType = typeDescription;
                }

                public static SuppressionHandler of(TypeDescription typeDescription) {
                    return typeDescription.represents(NoExceptionHandler.class) ? NoOp.INSTANCE
                            : new Suppressing(typeDescription);
                }

                @Override // net.bytebuddy.asm.Advice.Dispatcher.SuppressionHandler
                public Bound bind(StackManipulation stackManipulation) {
                    return new Bound(this.suppressedType, stackManipulation);
                }

                public boolean equals(@MaybeNull Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    return obj != null && getClass() == obj.getClass()
                            && this.suppressedType.equals(((Suppressing) obj).suppressedType);
                }

                public int hashCode() {
                    return this.suppressedType.hashCode() + (getClass().hashCode() * 31);
                }
            }

            Bound bind(StackManipulation stackManipulation);
        }

        /*
         * JADX INFO: compiled from:
         * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
         */
        public interface Unresolved extends Dispatcher {
            Resolved.ForMethodEnter asMethodEnter(List<? extends OffsetMapping.Factory<?>> list,
                    @MaybeNull AsmClassReader asmClassReader, Unresolved unresolved, PostProcessor.Factory factory);

            Resolved.ForMethodExit asMethodExit(List<? extends OffsetMapping.Factory<?>> list,
                    @MaybeNull AsmClassReader asmClassReader, Unresolved unresolved, PostProcessor.Factory factory);

            Map<String, TypeDefinition> getNamedTypes();

            boolean isBinary();
        }

        TypeDefinition getAdviceType();

        boolean isAlive();
    }

    /*
     * JADX INFO: compiled from:
     * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
     */
    @Target({ ElementType.PARAMETER })
    @Documented
    @Retention(RetentionPolicy.RUNTIME)
    public @interface DynamicConstant {
        String bootstrapName();

        Class<?> bootstrapOwner() default void.class;

        Class<?>[] bootstrapParameterTypes();

        Class<?> bootstrapReturnType();

        JavaConstant.MethodHandle.HandleType bootstrapType();

        boolean invokedynamic() default false;

        String name() default "_";
    }

    /*
     * JADX INFO: compiled from:
     * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
     */
    @Target({ ElementType.PARAMETER })
    @Documented
    @Retention(RetentionPolicy.RUNTIME)
    public @interface Enter {
        boolean readOnly() default true;

        Assigner.Typing typing() default Assigner.Typing.STATIC;
    }

    /*
     * JADX INFO: compiled from:
     * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
     */
    public interface ExceptionHandler {

        /*
         * JADX INFO: compiled from:
         * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
         */
        public enum Default implements ExceptionHandler {
            SUPPRESSING { // from class: net.bytebuddy.asm.Advice.ExceptionHandler.Default.1
                @Override // net.bytebuddy.asm.Advice.ExceptionHandler
                public StackManipulation resolve(MethodDescription methodDescription, TypeDescription typeDescription) {
                    return Removal.SINGLE;
                }
            },
            PRINTING { // from class: net.bytebuddy.asm.Advice.ExceptionHandler.Default.2
                @Override // net.bytebuddy.asm.Advice.ExceptionHandler
                public StackManipulation resolve(MethodDescription methodDescription, TypeDescription typeDescription) {
                    try {
                        return MethodInvocation
                                .invoke((MethodDescription.InDefinedShape) new MethodDescription.ForLoadedMethod(
                                        Throwable.class.getMethod("printStackTrace", null)));
                    } catch (NoSuchMethodException unused) {
                        throw new IllegalStateException("Cannot locate Throwable::printStackTrace");
                    }
                }
            },
            RETHROWING { // from class: net.bytebuddy.asm.Advice.ExceptionHandler.Default.3
                @Override // net.bytebuddy.asm.Advice.ExceptionHandler
                public StackManipulation resolve(MethodDescription methodDescription, TypeDescription typeDescription) {
                    return Throw.INSTANCE;
                }
            }
        }

        /*
         * JADX INFO: compiled from:
         * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
         */
        @HashCodeAndEqualsPlugin.Enhance
        public static class Simple implements ExceptionHandler {
            private final StackManipulation stackManipulation;

            public Simple(StackManipulation stackManipulation) {
                this.stackManipulation = stackManipulation;
            }

            public boolean equals(@MaybeNull Object obj) {
                if (this == obj) {
                    return true;
                }
                return obj != null && getClass() == obj.getClass()
                        && this.stackManipulation.equals(((Simple) obj).stackManipulation);
            }

            public int hashCode() {
                return this.stackManipulation.hashCode() + (getClass().hashCode() * 31);
            }

            @Override // net.bytebuddy.asm.Advice.ExceptionHandler
            public StackManipulation resolve(MethodDescription methodDescription, TypeDescription typeDescription) {
                return this.stackManipulation;
            }
        }

        StackManipulation resolve(MethodDescription methodDescription, TypeDescription typeDescription);
    }

    /*
     * JADX INFO: compiled from:
     * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
     */
    @Target({ ElementType.PARAMETER })
    @Documented
    @Retention(RetentionPolicy.RUNTIME)
    public @interface Exit {
        boolean readOnly() default true;

        Assigner.Typing typing() default Assigner.Typing.STATIC;
    }

    /*
     * JADX INFO: compiled from:
     * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
     */
    @Target({ ElementType.PARAMETER })
    @Documented
    @Retention(RetentionPolicy.RUNTIME)
    public @interface FieldGetterHandle {
        Class<?> declaringType() default void.class;

        String value() default "";
    }

    /*
     * JADX INFO: compiled from:
     * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
     */
    @Target({ ElementType.PARAMETER })
    @Documented
    @Retention(RetentionPolicy.RUNTIME)
    public @interface FieldSetterHandle {
        Class<?> declaringType() default void.class;

        String value() default "";
    }

    /*
     * JADX INFO: compiled from:
     * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
     */
    @Target({ ElementType.PARAMETER })
    @Documented
    @Retention(RetentionPolicy.RUNTIME)
    public @interface FieldValue {
        Class<?> declaringType() default void.class;

        boolean readOnly() default true;

        Assigner.Typing typing() default Assigner.Typing.STATIC;

        String value() default "";
    }

    /*
     * JADX INFO: compiled from:
     * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
     */
    @Target({ ElementType.PARAMETER })
    @Documented
    @Retention(RetentionPolicy.RUNTIME)
    public @interface Handle {
        String name();

        Class<?> owner() default void.class;

        Class<?>[] parameterTypes();

        Class<?> returnType();

        JavaConstant.MethodHandle.HandleType type();
    }

    /*
     * JADX INFO: compiled from:
     * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
     */
    @Target({ ElementType.PARAMETER })
    @Documented
    @Retention(RetentionPolicy.RUNTIME)
    public @interface Local {
        String value();
    }

    /*
     * JADX INFO: compiled from:
     * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
     */
    public interface MethodSizeHandler {
        public static final int UNDEFINED_SIZE = 32767;

        /*
         * JADX INFO: compiled from:
         * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
         */
        public static abstract class Default implements ForInstrumentedMethod {
            protected final List<? extends TypeDescription> initialTypes;
            protected final MethodDescription instrumentedMethod;
            protected int localVariableLength;
            protected final List<? extends TypeDescription> postMethodTypes;
            protected final List<? extends TypeDescription> preMethodTypes;
            protected int stackSize;

            /*
             * JADX INFO: compiled from:
             * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
             */
            public class ForAdvice implements ForAdvice {
                private final int baseLocalVariableLength;
                private int localVariableLengthPadding;
                private int stackSizePadding;
                private final MethodDescription.TypeToken typeToken;

                public ForAdvice(MethodDescription.TypeToken typeToken, int i) {
                    this.typeToken = typeToken;
                    this.baseLocalVariableLength = i;
                }

                @Override // net.bytebuddy.asm.Advice.MethodSizeHandler.ForAdvice
                public void recordMaxima(int i, int i2) {
                    Default.this.requireStackSize(i + this.stackSizePadding);
                    Default.this.requireLocalVariableLength((i2 - StackSize.of(this.typeToken.getParameterTypes()))
                            + this.baseLocalVariableLength + this.localVariableLengthPadding);
                }

                @Override // net.bytebuddy.asm.Advice.MethodSizeHandler
                public void requireLocalVariableLength(int i) {
                    Default.this.requireLocalVariableLength(i);
                }

                @Override // net.bytebuddy.asm.Advice.MethodSizeHandler.ForAdvice
                public void requireLocalVariableLengthPadding(int i) {
                    this.localVariableLengthPadding = Math.max(this.localVariableLengthPadding, i);
                }

                @Override // net.bytebuddy.asm.Advice.MethodSizeHandler
                public void requireStackSize(int i) {
                    Default.this.requireStackSize(i);
                }

                @Override // net.bytebuddy.asm.Advice.MethodSizeHandler.ForAdvice
                public void requireStackSizePadding(int i) {
                    this.stackSizePadding = Math.max(this.stackSizePadding, i);
                }
            }

            /*
             * JADX INFO: compiled from:
             * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
             */
            public static class WithCopiedArguments extends Default {
                public WithCopiedArguments(MethodDescription methodDescription, List<? extends TypeDescription> list,
                        List<? extends TypeDescription> list2, List<? extends TypeDescription> list3) {
                    super(methodDescription, list, list2, list3);
                }

                @Override // net.bytebuddy.asm.Advice.MethodSizeHandler.ForInstrumentedMethod
                public ForAdvice bindExit(MethodDescription.TypeToken typeToken) {
                    return new ForAdvice(typeToken,
                            StackSize.of(this.postMethodTypes) + StackSize.of(this.preMethodTypes)
                                    + StackSize.of(this.initialTypes) + (this.instrumentedMethod.getStackSize() * 2));
                }

                @Override // net.bytebuddy.asm.Advice.MethodSizeHandler.Default,
                          // net.bytebuddy.asm.Advice.MethodSizeHandler.ForInstrumentedMethod
                public int compoundLocalVariableLength(int i) {
                    return Math.max(this.localVariableLength,
                            StackSize.of(this.preMethodTypes) + StackSize.of(this.initialTypes)
                                    + StackSize.of(this.postMethodTypes) + this.instrumentedMethod.getStackSize() + i);
                }
            }

            /*
             * JADX INFO: compiled from:
             * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
             */
            public static class WithRetainedArguments extends Default {
                public WithRetainedArguments(MethodDescription methodDescription, List<? extends TypeDescription> list,
                        List<? extends TypeDescription> list2, List<? extends TypeDescription> list3) {
                    super(methodDescription, list, list2, list3);
                }

                @Override // net.bytebuddy.asm.Advice.MethodSizeHandler.ForInstrumentedMethod
                public ForAdvice bindExit(MethodDescription.TypeToken typeToken) {
                    return new ForAdvice(typeToken, StackSize.of(this.preMethodTypes) + StackSize.of(this.initialTypes)
                            + StackSize.of(this.postMethodTypes) + this.instrumentedMethod.getStackSize());
                }

                @Override // net.bytebuddy.asm.Advice.MethodSizeHandler.Default,
                          // net.bytebuddy.asm.Advice.MethodSizeHandler.ForInstrumentedMethod
                public int compoundLocalVariableLength(int i) {
                    return Math.max(this.localVariableLength, StackSize.of(this.preMethodTypes)
                            + StackSize.of(this.initialTypes) + StackSize.of(this.postMethodTypes) + i);
                }
            }

            public Default(MethodDescription methodDescription, List<? extends TypeDescription> list,
                    List<? extends TypeDescription> list2, List<? extends TypeDescription> list3) {
                this.instrumentedMethod = methodDescription;
                this.initialTypes = list;
                this.preMethodTypes = list2;
                this.postMethodTypes = list3;
            }

            public static ForInstrumentedMethod of(MethodDescription methodDescription,
                    List<? extends TypeDescription> list, List<? extends TypeDescription> list2,
                    List<? extends TypeDescription> list3, boolean z, int i) {
                return (i & 3) != 0 ? NoOp.INSTANCE
                        : z ? new WithCopiedArguments(methodDescription, list, list2, list3)
                                : new WithRetainedArguments(methodDescription, list, list2, list3);
            }

            @Override // net.bytebuddy.asm.Advice.MethodSizeHandler.ForInstrumentedMethod
            public ForAdvice bindEnter(MethodDescription.TypeToken typeToken) {
                return new ForAdvice(typeToken,
                        StackSize.of(this.initialTypes) + this.instrumentedMethod.getStackSize());
            }

            @Override // net.bytebuddy.asm.Advice.MethodSizeHandler.ForInstrumentedMethod
            public int compoundLocalVariableLength(int i) {
                return Math.max(this.localVariableLength, StackSize.of(this.preMethodTypes)
                        + StackSize.of(this.initialTypes) + StackSize.of(this.postMethodTypes) + i);
            }

            @Override // net.bytebuddy.asm.Advice.MethodSizeHandler.ForInstrumentedMethod
            public int compoundStackSize(int i) {
                return Math.max(this.stackSize, i);
            }

            @Override // net.bytebuddy.asm.Advice.MethodSizeHandler
            public void requireLocalVariableLength(int i) {
                this.localVariableLength = Math.max(this.localVariableLength, i);
            }

            @Override // net.bytebuddy.asm.Advice.MethodSizeHandler
            public void requireStackSize(int i) {
                this.stackSize = Math.max(this.stackSize, i);
            }
        }

        /*
         * JADX INFO: compiled from:
         * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
         */
        public interface ForAdvice extends MethodSizeHandler {
            void recordMaxima(int i, int i2);

            void requireLocalVariableLengthPadding(int i);

            void requireStackSizePadding(int i);
        }

        /*
         * JADX INFO: compiled from:
         * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
         */
        public interface ForInstrumentedMethod extends MethodSizeHandler {
            ForAdvice bindEnter(MethodDescription.TypeToken typeToken);

            ForAdvice bindExit(MethodDescription.TypeToken typeToken);

            int compoundLocalVariableLength(int i);

            int compoundStackSize(int i);
        }

        /*
         * JADX INFO: compiled from:
         * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
         */
        public enum NoOp implements ForInstrumentedMethod, ForAdvice {
            INSTANCE;

            @Override // net.bytebuddy.asm.Advice.MethodSizeHandler.ForInstrumentedMethod
            public ForAdvice bindEnter(MethodDescription.TypeToken typeToken) {
                return this;
            }

            @Override // net.bytebuddy.asm.Advice.MethodSizeHandler.ForInstrumentedMethod
            public ForAdvice bindExit(MethodDescription.TypeToken typeToken) {
                return this;
            }

            @Override // net.bytebuddy.asm.Advice.MethodSizeHandler.ForInstrumentedMethod
            public int compoundLocalVariableLength(int i) {
                return MethodSizeHandler.UNDEFINED_SIZE;
            }

            @Override // net.bytebuddy.asm.Advice.MethodSizeHandler.ForInstrumentedMethod
            public int compoundStackSize(int i) {
                return MethodSizeHandler.UNDEFINED_SIZE;
            }

            @Override // net.bytebuddy.asm.Advice.MethodSizeHandler.ForAdvice
            public void recordMaxima(int i, int i2) {
            }

            @Override // net.bytebuddy.asm.Advice.MethodSizeHandler
            public void requireLocalVariableLength(int i) {
            }

            @Override // net.bytebuddy.asm.Advice.MethodSizeHandler.ForAdvice
            public void requireLocalVariableLengthPadding(int i) {
            }

            @Override // net.bytebuddy.asm.Advice.MethodSizeHandler
            public void requireStackSize(int i) {
            }

            @Override // net.bytebuddy.asm.Advice.MethodSizeHandler.ForAdvice
            public void requireStackSizePadding(int i) {
            }
        }

        void requireLocalVariableLength(int i);

        void requireStackSize(int i);
    }

    /*
     * JADX INFO: compiled from:
     * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
     */
    public static class NoExceptionHandler extends Throwable {
        private static final TypeDescription DESCRIPTION = TypeDescription.ForLoadedType.of(NoExceptionHandler.class);
        private static final long serialVersionUID = 1;

        private NoExceptionHandler() {
            throw new UnsupportedOperationException(
                    "This class only serves as a marker type and should not be instantiated");
        }
    }

    /*
     * JADX INFO: compiled from:
     * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
     */
    public interface OffsetMapping {

        /*
         * JADX INFO: compiled from:
         * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
         */
        public interface Factory<T extends Annotation> {

            /*
             * JADX INFO: compiled from:
             * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
             */
            public enum AdviceType {
                DELEGATION(true),
                INLINING(false);

                private final boolean delegation;

                AdviceType(boolean z) {
                    this.delegation = z;
                }

                public boolean isDelegation() {
                    return this.delegation;
                }
            }

            /*
             * JADX INFO: compiled from:
             * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
             */
            @HashCodeAndEqualsPlugin.Enhance
            public static class Illegal<T extends Annotation> implements Factory<T> {
                private final Class<T> annotationType;

                public Illegal(Class<T> cls) {
                    this.annotationType = cls;
                }

                public boolean equals(@MaybeNull Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    return obj != null && getClass() == obj.getClass()
                            && this.annotationType.equals(((Illegal) obj).annotationType);
                }

                @Override // net.bytebuddy.asm.Advice.OffsetMapping.Factory
                public Class<T> getAnnotationType() {
                    return this.annotationType;
                }

                public int hashCode() {
                    return this.annotationType.hashCode() + (getClass().hashCode() * 31);
                }

                @Override // net.bytebuddy.asm.Advice.OffsetMapping.Factory
                public OffsetMapping make(ParameterDescription.InDefinedShape inDefinedShape,
                        AnnotationDescription.Loadable<T> loadable, AdviceType adviceType) {
                    throw new IllegalStateException(
                            "Usage of " + this.annotationType + " is not allowed on " + inDefinedShape);
                }
            }

            /*
             * JADX INFO: compiled from:
             * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
             */
            @HashCodeAndEqualsPlugin.Enhance
            public static class Simple<T extends Annotation> implements Factory<T> {
                private final Class<T> annotationType;
                private final OffsetMapping offsetMapping;

                public Simple(Class<T> cls, OffsetMapping offsetMapping) {
                    this.annotationType = cls;
                    this.offsetMapping = offsetMapping;
                }

                public boolean equals(@MaybeNull Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (obj == null || getClass() != obj.getClass()) {
                        return false;
                    }
                    Simple simple = (Simple) obj;
                    return this.annotationType.equals(simple.annotationType)
                            && this.offsetMapping.equals(simple.offsetMapping);
                }

                @Override // net.bytebuddy.asm.Advice.OffsetMapping.Factory
                public Class<T> getAnnotationType() {
                    return this.annotationType;
                }

                public int hashCode() {
                    return this.offsetMapping.hashCode() + bjs.d(getClass().hashCode() * 31, 31, this.annotationType);
                }

                @Override // net.bytebuddy.asm.Advice.OffsetMapping.Factory
                public OffsetMapping make(ParameterDescription.InDefinedShape inDefinedShape,
                        AnnotationDescription.Loadable<T> loadable, AdviceType adviceType) {
                    return this.offsetMapping;
                }
            }

            Class<T> getAnnotationType();

            OffsetMapping make(ParameterDescription.InDefinedShape inDefinedShape,
                    AnnotationDescription.Loadable<T> loadable, AdviceType adviceType);
        }

        /*
         * JADX INFO: compiled from:
         * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
         */
        @HashCodeAndEqualsPlugin.Enhance
        public static class ForDynamicConstant implements OffsetMapping {
            private final List<JavaConstant> arguments;
            private final String bootstrapName;
            private final TypeDescription bootstrapOwner;
            private final List<? extends TypeDescription> bootstrapParameterTypes;
            private final TypeDescription bootstrapReturnType;
            private final JavaConstant.MethodHandle.HandleType bootstrapType;
            private final boolean invokedynamic;
            private final String name;
            private final TypeDescription typeDescription;

            /*
             * JADX INFO: compiled from:
             * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
             */
            public enum Factory implements Factory<DynamicConstant> {
                INSTANCE;

                private static final MethodDescription.InDefinedShape BOOTSTRAP_NAME;
                private static final MethodDescription.InDefinedShape BOOTSTRAP_OWNER;
                private static final MethodDescription.InDefinedShape BOOTSTRAP_PARAMETER_TYPES;
                private static final MethodDescription.InDefinedShape BOOTSTRAP_RETURN_TYPE;
                private static final MethodDescription.InDefinedShape BOOTSTRAP_TYPE;
                private static final MethodDescription.InDefinedShape INVOKEDYNAMIC;
                private static final MethodDescription.InDefinedShape NAME;

                static {
                    MethodList<MethodDescription.InDefinedShape> declaredMethods = TypeDescription.ForLoadedType
                            .of(DynamicConstant.class).getDeclaredMethods();
                    NAME = (MethodDescription.InDefinedShape) declaredMethods.filter(ElementMatchers.named("name"))
                            .getOnly();
                    BOOTSTRAP_TYPE = (MethodDescription.InDefinedShape) declaredMethods
                            .filter(ElementMatchers.named("bootstrapType")).getOnly();
                    BOOTSTRAP_OWNER = (MethodDescription.InDefinedShape) declaredMethods
                            .filter(ElementMatchers.named("bootstrapOwner")).getOnly();
                    BOOTSTRAP_NAME = (MethodDescription.InDefinedShape) declaredMethods
                            .filter(ElementMatchers.named("bootstrapName")).getOnly();
                    BOOTSTRAP_RETURN_TYPE = (MethodDescription.InDefinedShape) declaredMethods
                            .filter(ElementMatchers.named("bootstrapReturnType")).getOnly();
                    BOOTSTRAP_PARAMETER_TYPES = (MethodDescription.InDefinedShape) declaredMethods
                            .filter(ElementMatchers.named("bootstrapParameterTypes")).getOnly();
                    INVOKEDYNAMIC = (MethodDescription.InDefinedShape) declaredMethods
                            .filter(ElementMatchers.named("invokedynamic")).getOnly();
                }

                @Override // net.bytebuddy.asm.Advice.OffsetMapping.Factory
                public Class<DynamicConstant> getAnnotationType() {
                    return DynamicConstant.class;
                }

                @Override // net.bytebuddy.asm.Advice.OffsetMapping.Factory
                public OffsetMapping make(ParameterDescription.InDefinedShape inDefinedShape,
                        AnnotationDescription.Loadable<DynamicConstant> loadable, Factory.AdviceType adviceType) {
                    return new ForDynamicConstant((String) loadable.getValue(NAME).resolve(String.class),
                            inDefinedShape.getType().asErasure(),
                            (JavaConstant.MethodHandle.HandleType) ((EnumerationDescription) loadable
                                    .getValue(BOOTSTRAP_TYPE).resolve(EnumerationDescription.class))
                                    .load(JavaConstant.MethodHandle.HandleType.class),
                            (TypeDescription) loadable.getValue(BOOTSTRAP_OWNER).resolve(TypeDescription.class),
                            (String) loadable.getValue(BOOTSTRAP_NAME).resolve(String.class),
                            (TypeDescription) loadable.getValue(BOOTSTRAP_RETURN_TYPE).resolve(TypeDescription.class),
                            Arrays.asList((Object[]) loadable.getValue(BOOTSTRAP_PARAMETER_TYPES)
                                    .resolve(TypeDescription[].class)),
                            Collections.EMPTY_LIST,
                            ((Boolean) loadable.getValue(INVOKEDYNAMIC).resolve(Boolean.class)).booleanValue());
                }
            }

            public ForDynamicConstant(String str, TypeDescription typeDescription,
                    JavaConstant.MethodHandle.HandleType handleType, TypeDescription typeDescription2, String str2,
                    TypeDescription typeDescription3, List<? extends TypeDescription> list, List<JavaConstant> list2,
                    boolean z) {
                this.name = str;
                this.typeDescription = typeDescription;
                this.bootstrapType = handleType;
                this.bootstrapOwner = typeDescription2;
                this.bootstrapName = str2;
                this.bootstrapReturnType = typeDescription3;
                this.bootstrapParameterTypes = list;
                this.arguments = list2;
                this.invokedynamic = z;
            }

            public boolean equals(@MaybeNull Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || getClass() != obj.getClass()) {
                    return false;
                }
                ForDynamicConstant forDynamicConstant = (ForDynamicConstant) obj;
                return this.invokedynamic == forDynamicConstant.invokedynamic
                        && this.bootstrapType.equals(forDynamicConstant.bootstrapType)
                        && this.name.equals(forDynamicConstant.name)
                        && this.bootstrapName.equals(forDynamicConstant.bootstrapName)
                        && this.typeDescription.equals(forDynamicConstant.typeDescription)
                        && this.bootstrapOwner.equals(forDynamicConstant.bootstrapOwner)
                        && this.bootstrapReturnType.equals(forDynamicConstant.bootstrapReturnType)
                        && this.bootstrapParameterTypes.equals(forDynamicConstant.bootstrapParameterTypes)
                        && this.arguments.equals(forDynamicConstant.arguments);
            }

            public int hashCode() {
                return bjs.g(this.arguments,
                        bjs.g(this.bootstrapParameterTypes,
                                StaticHelpers6.f(this.bootstrapReturnType, bjs.e(this.bootstrapName, StaticHelpers6.f(this.bootstrapOwner,
                                        (this.bootstrapType.hashCode() + StaticHelpers6.f(this.typeDescription,
                                                bjs.e(this.name, getClass().hashCode() * 31, 31), 31)) * 31,
                                        31), 31), 31),
                                31),
                        31) + (this.invokedynamic ? 1 : 0);
            }

            @Override // net.bytebuddy.asm.Advice.OffsetMapping
            public Target resolve(TypeDescription typeDescription, MethodDescription methodDescription,
                    Assigner assigner, ArgumentHandler argumentHandler, Sort sort) {
                if (!this.bootstrapOwner.represents(Void.TYPE)) {
                    typeDescription = this.bootstrapOwner;
                }
                TypeDescription typeDescription2 = typeDescription;
                return this.invokedynamic
                        ? new Target.ForStackManipulation(new Invokedynamic(this.name,
                                JavaConstant.MethodType.of(this.typeDescription, new TypeDescription[0]),
                                new JavaConstant.MethodHandle(this.bootstrapType, typeDescription2, this.bootstrapName,
                                        this.bootstrapReturnType, this.bootstrapParameterTypes),
                                this.arguments))
                        : new Target.ForStackManipulation(
                                new JavaConstantValue(new JavaConstant.Dynamic(this.name, this.typeDescription,
                                        new JavaConstant.MethodHandle(this.bootstrapType, typeDescription2,
                                                this.bootstrapName, this.bootstrapReturnType,
                                                this.bootstrapParameterTypes),
                                        this.arguments)));
            }
        }

        /*
         * JADX INFO: compiled from:
         * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
         */
        @HashCodeAndEqualsPlugin.Enhance
        public static abstract class ForFieldHandle implements OffsetMapping {
            private final Access access;

            /*
             * JADX INFO: compiled from:
             * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
             */
            public enum Access {
                GETTER { // from class: net.bytebuddy.asm.Advice.OffsetMapping.ForFieldHandle.Access.1
                    @Override // net.bytebuddy.asm.Advice.OffsetMapping.ForFieldHandle.Access
                    public JavaConstant.MethodHandle resolve(FieldDescription.InDefinedShape inDefinedShape) {
                        return JavaConstant.MethodHandle.ofGetter(inDefinedShape);
                    }
                },
                SETTER { // from class: net.bytebuddy.asm.Advice.OffsetMapping.ForFieldHandle.Access.2
                    @Override // net.bytebuddy.asm.Advice.OffsetMapping.ForFieldHandle.Access
                    public JavaConstant.MethodHandle resolve(FieldDescription.InDefinedShape inDefinedShape) {
                        return JavaConstant.MethodHandle.ofSetter(inDefinedShape);
                    }
                };

                public abstract JavaConstant.MethodHandle resolve(FieldDescription.InDefinedShape inDefinedShape);
            }

            /*
             * JADX INFO: compiled from:
             * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
             */
            @HashCodeAndEqualsPlugin.Enhance
            public static class Resolved extends ForFieldHandle {
                private final FieldDescription fieldDescription;

                /*
                 * JADX INFO: compiled from:
                 * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
                 */
                @HashCodeAndEqualsPlugin.Enhance
                public static class Factory<T extends Annotation> implements Factory<T> {
                    private final Access access;
                    private final Class<T> annotationType;
                    private final FieldDescription fieldDescription;

                    public Factory(Class<T> cls, FieldDescription fieldDescription, Access access) {
                        this.annotationType = cls;
                        this.fieldDescription = fieldDescription;
                        this.access = access;
                    }

                    public boolean equals(@MaybeNull Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        if (obj == null || getClass() != obj.getClass()) {
                            return false;
                        }
                        Factory factory = (Factory) obj;
                        return this.access.equals(factory.access) && this.annotationType.equals(factory.annotationType)
                                && this.fieldDescription.equals(factory.fieldDescription);
                    }

                    @Override // net.bytebuddy.asm.Advice.OffsetMapping.Factory
                    public Class<T> getAnnotationType() {
                        return this.annotationType;
                    }

                    public int hashCode() {
                        return this.access.hashCode() + ((this.fieldDescription.hashCode()
                                + bjs.d(getClass().hashCode() * 31, 31, this.annotationType)) * 31);
                    }

                    @Override // net.bytebuddy.asm.Advice.OffsetMapping.Factory
                    public OffsetMapping make(ParameterDescription.InDefinedShape inDefinedShape,
                            AnnotationDescription.Loadable<T> loadable, Factory.AdviceType adviceType) {
                        if (inDefinedShape.getType().asErasure()
                                .isAssignableFrom(JavaType.METHOD_HANDLE.getTypeStub())) {
                            return new Resolved(this.access, this.fieldDescription);
                        }
                        throw new IllegalStateException("Cannot assign method handle to " + inDefinedShape);
                    }
                }

                public Resolved(Access access, FieldDescription fieldDescription) {
                    super(access);
                    this.fieldDescription = fieldDescription;
                }

                @Override // net.bytebuddy.asm.Advice.OffsetMapping.ForFieldHandle
                public boolean equals(@MaybeNull Object obj) {
                    if (!super.equals(obj)) {
                        return false;
                    }
                    if (this == obj) {
                        return true;
                    }
                    return obj != null && getClass() == obj.getClass()
                            && this.fieldDescription.equals(((Resolved) obj).fieldDescription);
                }

                @Override // net.bytebuddy.asm.Advice.OffsetMapping.ForFieldHandle
                public int hashCode() {
                    return this.fieldDescription.hashCode() + (super.hashCode() * 31);
                }

                @Override // net.bytebuddy.asm.Advice.OffsetMapping.ForFieldHandle
                public FieldDescription resolve(TypeDescription typeDescription, MethodDescription methodDescription) {
                    if (!this.fieldDescription.isStatic() && !this.fieldDescription.getDeclaringType().asErasure()
                            .isAssignableFrom(typeDescription)) {
                        throw new IllegalStateException(this.fieldDescription + " is no member of " + typeDescription);
                    }
                    if (this.fieldDescription.isVisibleTo(typeDescription)) {
                        return this.fieldDescription;
                    }
                    throw new IllegalStateException(
                            "Cannot access " + this.fieldDescription + " from " + typeDescription);
                }
            }

            /*
             * JADX INFO: compiled from:
             * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
             */
            @HashCodeAndEqualsPlugin.Enhance
            public static abstract class Unresolved extends ForFieldHandle {
                protected static final String BEAN_PROPERTY = "";
                private final String name;

                /*
                 * JADX INFO: compiled from:
                 * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
                 */
                public enum ReaderFactory implements Factory<FieldGetterHandle> {
                    INSTANCE;

                    private static final MethodDescription.InDefinedShape FIELD_GETTER_HANDLE_DECLARING_TYPE;
                    private static final MethodDescription.InDefinedShape FIELD_GETTER_HANDLE_VALUE;

                    static {
                        MethodList<MethodDescription.InDefinedShape> declaredMethods = TypeDescription.ForLoadedType
                                .of(FieldGetterHandle.class).getDeclaredMethods();
                        FIELD_GETTER_HANDLE_VALUE = (MethodDescription.InDefinedShape) declaredMethods
                                .filter(ElementMatchers.named("value")).getOnly();
                        FIELD_GETTER_HANDLE_DECLARING_TYPE = (MethodDescription.InDefinedShape) declaredMethods
                                .filter(ElementMatchers.named("declaringType")).getOnly();
                    }

                    @Override // net.bytebuddy.asm.Advice.OffsetMapping.Factory
                    public Class<FieldGetterHandle> getAnnotationType() {
                        return FieldGetterHandle.class;
                    }

                    @Override // net.bytebuddy.asm.Advice.OffsetMapping.Factory
                    public OffsetMapping make(ParameterDescription.InDefinedShape inDefinedShape,
                            AnnotationDescription.Loadable<FieldGetterHandle> loadable, Factory.AdviceType adviceType) {
                        if (inDefinedShape.getType().asErasure()
                                .isAssignableFrom(JavaType.METHOD_HANDLE.getTypeStub())) {
                            TypeDescription typeDescription = (TypeDescription) loadable
                                    .getValue(FIELD_GETTER_HANDLE_DECLARING_TYPE).resolve(TypeDescription.class);
                            return typeDescription.represents(Void.TYPE)
                                    ? new WithImplicitType(Access.GETTER,
                                            (String) loadable.getValue(FIELD_GETTER_HANDLE_VALUE).resolve(String.class))
                                    : new WithExplicitType(Access.GETTER,
                                            (String) loadable.getValue(FIELD_GETTER_HANDLE_VALUE).resolve(String.class),
                                            typeDescription);
                        }
                        throw new IllegalStateException("Cannot assign method handle to " + inDefinedShape);
                    }
                }

                /*
                 * JADX INFO: compiled from:
                 * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
                 */
                @HashCodeAndEqualsPlugin.Enhance
                public static class WithExplicitType extends Unresolved {
                    private final TypeDescription declaringType;

                    public WithExplicitType(Access access, String str, TypeDescription typeDescription) {
                        super(access, str);
                        this.declaringType = typeDescription;
                    }

                    @Override // net.bytebuddy.asm.Advice.OffsetMapping.ForFieldHandle.Unresolved,
                              // net.bytebuddy.asm.Advice.OffsetMapping.ForFieldHandle
                    public boolean equals(@MaybeNull Object obj) {
                        if (!super.equals(obj)) {
                            return false;
                        }
                        if (this == obj) {
                            return true;
                        }
                        return obj != null && getClass() == obj.getClass()
                                && this.declaringType.equals(((WithExplicitType) obj).declaringType);
                    }

                    @Override // net.bytebuddy.asm.Advice.OffsetMapping.ForFieldHandle.Unresolved
                    public FieldLocator fieldLocator(TypeDescription typeDescription) {
                        if (this.declaringType.represents(TargetType.class)
                                || typeDescription.isAssignableTo(this.declaringType)) {
                            return new FieldLocator.ForExactType(
                                    TargetType.resolve(this.declaringType, typeDescription));
                        }
                        throw new IllegalStateException(this.declaringType + " is no super type of " + typeDescription);
                    }

                    @Override // net.bytebuddy.asm.Advice.OffsetMapping.ForFieldHandle.Unresolved,
                              // net.bytebuddy.asm.Advice.OffsetMapping.ForFieldHandle
                    public int hashCode() {
                        return this.declaringType.hashCode() + (super.hashCode() * 31);
                    }
                }

                /*
                 * JADX INFO: compiled from:
                 * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
                 */
                public static class WithImplicitType extends Unresolved {
                    public WithImplicitType(Access access, String str) {
                        super(access, str);
                    }

                    @Override // net.bytebuddy.asm.Advice.OffsetMapping.ForFieldHandle.Unresolved
                    public FieldLocator fieldLocator(TypeDescription typeDescription) {
                        return new FieldLocator.ForClassHierarchy(typeDescription);
                    }
                }

                /*
                 * JADX INFO: compiled from:
                 * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
                 */
                public enum WriterFactory implements Factory<FieldSetterHandle> {
                    INSTANCE;

                    private static final MethodDescription.InDefinedShape FIELD_SETTER_HANDLE_DECLARING_TYPE;
                    private static final MethodDescription.InDefinedShape FIELD_SETTER_HANDLE_VALUE;

                    static {
                        MethodList<MethodDescription.InDefinedShape> declaredMethods = TypeDescription.ForLoadedType
                                .of(FieldSetterHandle.class).getDeclaredMethods();
                        FIELD_SETTER_HANDLE_VALUE = (MethodDescription.InDefinedShape) declaredMethods
                                .filter(ElementMatchers.named("value")).getOnly();
                        FIELD_SETTER_HANDLE_DECLARING_TYPE = (MethodDescription.InDefinedShape) declaredMethods
                                .filter(ElementMatchers.named("declaringType")).getOnly();
                    }

                    @Override // net.bytebuddy.asm.Advice.OffsetMapping.Factory
                    public Class<FieldSetterHandle> getAnnotationType() {
                        return FieldSetterHandle.class;
                    }

                    @Override // net.bytebuddy.asm.Advice.OffsetMapping.Factory
                    public OffsetMapping make(ParameterDescription.InDefinedShape inDefinedShape,
                            AnnotationDescription.Loadable<FieldSetterHandle> loadable, Factory.AdviceType adviceType) {
                        if (inDefinedShape.getType().asErasure()
                                .isAssignableFrom(JavaType.METHOD_HANDLE.getTypeStub())) {
                            TypeDescription typeDescription = (TypeDescription) loadable
                                    .getValue(FIELD_SETTER_HANDLE_DECLARING_TYPE).resolve(TypeDescription.class);
                            return typeDescription.represents(Void.TYPE)
                                    ? new WithImplicitType(Access.SETTER,
                                            (String) loadable.getValue(FIELD_SETTER_HANDLE_VALUE).resolve(String.class))
                                    : new WithExplicitType(Access.SETTER,
                                            (String) loadable.getValue(FIELD_SETTER_HANDLE_VALUE).resolve(String.class),
                                            typeDescription);
                        }
                        throw new IllegalStateException("Cannot assign method handle to " + inDefinedShape);
                    }
                }

                public Unresolved(Access access, String str) {
                    super(access);
                    this.name = str;
                }

                @Override // net.bytebuddy.asm.Advice.OffsetMapping.ForFieldHandle
                public boolean equals(@MaybeNull Object obj) {
                    if (!super.equals(obj)) {
                        return false;
                    }
                    if (this == obj) {
                        return true;
                    }
                    return obj != null && getClass() == obj.getClass() && this.name.equals(((Unresolved) obj).name);
                }

                public abstract FieldLocator fieldLocator(TypeDescription typeDescription);

                @Override // net.bytebuddy.asm.Advice.OffsetMapping.ForFieldHandle
                public int hashCode() {
                    return this.name.hashCode() + (super.hashCode() * 31);
                }

                @Override // net.bytebuddy.asm.Advice.OffsetMapping.ForFieldHandle
                public FieldDescription resolve(TypeDescription typeDescription, MethodDescription methodDescription) {
                    FieldLocator fieldLocator = fieldLocator(typeDescription);
                    FieldLocator.Resolution resolutionOfBeanAccessor = this.name.equals("")
                            ? FieldLocator.Resolution.Simple.ofBeanAccessor(fieldLocator, methodDescription)
                            : fieldLocator.locate(this.name);
                    if (resolutionOfBeanAccessor.isResolved()) {
                        return resolutionOfBeanAccessor.getField();
                    }
                    throw new IllegalStateException(
                            "Cannot locate field named " + this.name + " for " + typeDescription);
                }
            }

            public ForFieldHandle(Access access) {
                this.access = access;
            }

            public boolean equals(@MaybeNull Object obj) {
                if (this == obj) {
                    return true;
                }
                return obj != null && getClass() == obj.getClass() && this.access.equals(((ForFieldHandle) obj).access);
            }

            public int hashCode() {
                return this.access.hashCode() + (getClass().hashCode() * 31);
            }

            @Override // net.bytebuddy.asm.Advice.OffsetMapping
            public Target resolve(TypeDescription typeDescription, MethodDescription methodDescription,
                    Assigner assigner, ArgumentHandler argumentHandler, Sort sort) {
                FieldDescription fieldDescriptionResolve = resolve(typeDescription, methodDescription);
                if (!fieldDescriptionResolve.isStatic() && methodDescription.isStatic()) {
                    throw new IllegalStateException("Cannot access non-static field " + fieldDescriptionResolve
                            + " from static method " + methodDescription);
                }
                if (sort.isPremature(methodDescription) && !fieldDescriptionResolve.isStatic()) {
                    throw new IllegalStateException(
                            "Cannot access " + fieldDescriptionResolve + " before super constructor call");
                }
                if (fieldDescriptionResolve.isStatic()) {
                    return new Target.ForStackManipulation(
                            this.access.resolve(fieldDescriptionResolve.asDefined()).toStackManipulation());
                }
                StackManipulation stackManipulation = this.access.resolve(fieldDescriptionResolve.asDefined())
                        .toStackManipulation();
                StackManipulation stackManipulationLoadFrom = MethodVariableAccess.REFERENCE
                        .loadFrom(argumentHandler.argument(0));
                JavaType javaType = JavaType.METHOD_HANDLE;
                return new Target.ForStackManipulation(new StackManipulation.Compound(stackManipulation,
                        stackManipulationLoadFrom,
                        MethodInvocation.invoke((MethodDescription.InDefinedShape) new MethodDescription.Latent(
                                javaType.getTypeStub(),
                                new MethodDescription.Token("bindTo", 1, javaType.getTypeStub().asGenericType(),
                                        new TypeList.Generic.Explicit(TypeDefinition.Sort.describe(Object.class)))))));
            }

            public abstract FieldDescription resolve(TypeDescription typeDescription,
                    MethodDescription methodDescription);
        }

        /*
         * JADX INFO: compiled from:
         * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
         */
        @HashCodeAndEqualsPlugin.Enhance
        public static class ForHandle implements OffsetMapping {
            private final String name;
            private final TypeDescription owner;
            private final List<? extends TypeDescription> parameterTypes;
            private final TypeDescription returnType;
            private final JavaConstant.MethodHandle.HandleType type;

            /*
             * JADX INFO: compiled from:
             * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
             */
            public enum Factory implements Factory<Handle> {
                INSTANCE;

                private static final MethodDescription.InDefinedShape NAME;
                private static final MethodDescription.InDefinedShape OWNER;
                private static final MethodDescription.InDefinedShape PARAMETER_TYPES;
                private static final MethodDescription.InDefinedShape RETURN_TYPE;
                private static final MethodDescription.InDefinedShape TYPE;

                static {
                    MethodList<MethodDescription.InDefinedShape> declaredMethods = TypeDescription.ForLoadedType
                            .of(Handle.class).getDeclaredMethods();
                    TYPE = (MethodDescription.InDefinedShape) declaredMethods.filter(ElementMatchers.named(f.y))
                            .getOnly();
                    OWNER = (MethodDescription.InDefinedShape) declaredMethods.filter(ElementMatchers.named("owner"))
                            .getOnly();
                    NAME = (MethodDescription.InDefinedShape) declaredMethods.filter(ElementMatchers.named("name"))
                            .getOnly();
                    RETURN_TYPE = (MethodDescription.InDefinedShape) declaredMethods
                            .filter(ElementMatchers.named("returnType")).getOnly();
                    PARAMETER_TYPES = (MethodDescription.InDefinedShape) declaredMethods
                            .filter(ElementMatchers.named("parameterTypes")).getOnly();
                }

                @Override // net.bytebuddy.asm.Advice.OffsetMapping.Factory
                public Class<Handle> getAnnotationType() {
                    return Handle.class;
                }

                @Override // net.bytebuddy.asm.Advice.OffsetMapping.Factory
                public OffsetMapping make(ParameterDescription.InDefinedShape inDefinedShape,
                        AnnotationDescription.Loadable<Handle> loadable, Factory.AdviceType adviceType) {
                    if (inDefinedShape.getType().asErasure().isAssignableFrom(JavaType.METHOD_HANDLE.getTypeStub())) {
                        return new ForHandle(
                                (JavaConstant.MethodHandle.HandleType) ((EnumerationDescription) loadable.getValue(TYPE)
                                        .resolve(EnumerationDescription.class))
                                        .load(JavaConstant.MethodHandle.HandleType.class),
                                (TypeDescription) loadable.getValue(OWNER).resolve(TypeDescription.class),
                                (String) loadable.getValue(NAME).resolve(String.class),
                                (TypeDescription) loadable.getValue(RETURN_TYPE).resolve(TypeDescription.class),
                                Arrays.asList((Object[]) loadable.getValue(PARAMETER_TYPES)
                                        .resolve(TypeDescription[].class)));
                    }
                    throw new IllegalStateException("Cannot assign a MethodHandle to " + inDefinedShape);
                }
            }

            public ForHandle(JavaConstant.MethodHandle.HandleType handleType, TypeDescription typeDescription,
                    String str, TypeDescription typeDescription2, List<? extends TypeDescription> list) {
                this.type = handleType;
                this.owner = typeDescription;
                this.name = str;
                this.returnType = typeDescription2;
                this.parameterTypes = list;
            }

            public boolean equals(@MaybeNull Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || getClass() != obj.getClass()) {
                    return false;
                }
                ForHandle forHandle = (ForHandle) obj;
                return this.type.equals(forHandle.type) && this.name.equals(forHandle.name)
                        && this.owner.equals(forHandle.owner) && this.returnType.equals(forHandle.returnType)
                        && this.parameterTypes.equals(forHandle.parameterTypes);
            }

            public int hashCode() {
                return this.parameterTypes.hashCode() + StaticHelpers6.f(this.returnType,
                        bjs.e(this.name,
                                StaticHelpers6.f(this.owner, (this.type.hashCode() + (getClass().hashCode() * 31)) * 31, 31), 31),
                        31);
            }

            @Override // net.bytebuddy.asm.Advice.OffsetMapping
            public Target resolve(TypeDescription typeDescription, MethodDescription methodDescription,
                    Assigner assigner, ArgumentHandler argumentHandler, Sort sort) {
                JavaConstant.MethodHandle.HandleType handleType = this.type;
                if (!this.owner.represents(Void.TYPE)) {
                    typeDescription = this.owner;
                }
                return new Target.ForStackManipulation(new JavaConstantValue(new JavaConstant.MethodHandle(handleType,
                        typeDescription, this.name, this.returnType, this.parameterTypes)));
            }
        }

        /*
         * JADX INFO: compiled from:
         * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
         */
        public enum ForInstrumentedMethod implements OffsetMapping {
            METHOD { // from class: net.bytebuddy.asm.Advice.OffsetMapping.ForInstrumentedMethod.1
                @Override // net.bytebuddy.asm.Advice.OffsetMapping.ForInstrumentedMethod
                public boolean isRepresentable(MethodDescription methodDescription) {
                    return methodDescription.isMethod();
                }

                @Override // net.bytebuddy.asm.Advice.OffsetMapping.ForInstrumentedMethod
                public Target resolve(MethodDescription.InDefinedShape inDefinedShape) {
                    return Target.ForStackManipulation.of(inDefinedShape);
                }
            },
            CONSTRUCTOR { // from class: net.bytebuddy.asm.Advice.OffsetMapping.ForInstrumentedMethod.2
                @Override // net.bytebuddy.asm.Advice.OffsetMapping.ForInstrumentedMethod
                public boolean isRepresentable(MethodDescription methodDescription) {
                    return methodDescription.isConstructor();
                }

                @Override // net.bytebuddy.asm.Advice.OffsetMapping.ForInstrumentedMethod
                public Target resolve(MethodDescription.InDefinedShape inDefinedShape) {
                    return Target.ForStackManipulation.of(inDefinedShape);
                }
            },
            EXECUTABLE { // from class: net.bytebuddy.asm.Advice.OffsetMapping.ForInstrumentedMethod.3
                @Override // net.bytebuddy.asm.Advice.OffsetMapping.ForInstrumentedMethod
                public boolean isRepresentable(MethodDescription methodDescription) {
                    return true;
                }

                @Override // net.bytebuddy.asm.Advice.OffsetMapping.ForInstrumentedMethod
                public Target resolve(MethodDescription.InDefinedShape inDefinedShape) {
                    return Target.ForStackManipulation.of(inDefinedShape);
                }
            },
            MODIFIERS { // from class: net.bytebuddy.asm.Advice.OffsetMapping.ForInstrumentedMethod.4
                @Override // net.bytebuddy.asm.Advice.OffsetMapping.ForInstrumentedMethod
                public boolean isRepresentable(MethodDescription methodDescription) {
                    return true;
                }

                @Override // net.bytebuddy.asm.Advice.OffsetMapping.ForInstrumentedMethod
                public Target resolve(MethodDescription.InDefinedShape inDefinedShape) {
                    return Target.ForStackManipulation.of(Integer.valueOf(inDefinedShape.getModifiers()));
                }
            },
            METHOD_HANDLE { // from class: net.bytebuddy.asm.Advice.OffsetMapping.ForInstrumentedMethod.5
                @Override // net.bytebuddy.asm.Advice.OffsetMapping.ForInstrumentedMethod
                public boolean isRepresentable(MethodDescription methodDescription) {
                    return true;
                }

                @Override // net.bytebuddy.asm.Advice.OffsetMapping.ForInstrumentedMethod
                public Target resolve(MethodDescription.InDefinedShape inDefinedShape) {
                    return new Target.ForStackManipulation(
                            JavaConstant.MethodHandle.of(inDefinedShape).toStackManipulation());
                }
            },
            METHOD_TYPE { // from class: net.bytebuddy.asm.Advice.OffsetMapping.ForInstrumentedMethod.6
                @Override // net.bytebuddy.asm.Advice.OffsetMapping.ForInstrumentedMethod
                public boolean isRepresentable(MethodDescription methodDescription) {
                    return true;
                }

                @Override // net.bytebuddy.asm.Advice.OffsetMapping.ForInstrumentedMethod
                public Target resolve(MethodDescription.InDefinedShape inDefinedShape) {
                    return new Target.ForStackManipulation(
                            JavaConstant.MethodType.of(inDefinedShape).toStackManipulation());
                }
            };

            public abstract boolean isRepresentable(MethodDescription methodDescription);

            public abstract Target resolve(MethodDescription.InDefinedShape inDefinedShape);

            @Override // net.bytebuddy.asm.Advice.OffsetMapping
            public Target resolve(TypeDescription typeDescription, MethodDescription methodDescription,
                    Assigner assigner, ArgumentHandler argumentHandler, Sort sort) {
                if (isRepresentable(methodDescription)) {
                    return resolve(methodDescription.asDefined());
                }
                throw new IllegalStateException("Cannot represent " + methodDescription + " as the specified constant");
            }
        }

        /*
         * JADX INFO: compiled from:
         * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
         */
        public enum ForInstrumentedType implements OffsetMapping {
            INSTANCE;

            @Override // net.bytebuddy.asm.Advice.OffsetMapping
            public Target resolve(TypeDescription typeDescription, MethodDescription methodDescription,
                    Assigner assigner, ArgumentHandler argumentHandler, Sort sort) {
                return Target.ForStackManipulation.of(typeDescription);
            }
        }

        /*
         * JADX INFO: compiled from:
         * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
         */
        @HashCodeAndEqualsPlugin.Enhance
        public static class ForLocalValue implements OffsetMapping {
            private final TypeDescription.Generic localType;
            private final String name;
            private final TypeDescription.Generic target;

            /*
             * JADX INFO: compiled from:
             * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
             */
            @HashCodeAndEqualsPlugin.Enhance
            public static class Factory implements Factory<Local> {
                protected static final MethodDescription.InDefinedShape LOCAL_VALUE = (MethodDescription.InDefinedShape) TypeDescription.ForLoadedType
                        .of(Local.class).getDeclaredMethods().filter(ElementMatchers.named("value")).getOnly();
                private final Map<String, TypeDefinition> namedTypes;

                public Factory(Map<String, TypeDefinition> map) {
                    this.namedTypes = map;
                }

                public boolean equals(@MaybeNull Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    return obj != null && getClass() == obj.getClass()
                            && this.namedTypes.equals(((Factory) obj).namedTypes);
                }

                @Override // net.bytebuddy.asm.Advice.OffsetMapping.Factory
                public Class<Local> getAnnotationType() {
                    return Local.class;
                }

                public int hashCode() {
                    return this.namedTypes.hashCode() + (getClass().hashCode() * 31);
                }

                @Override // net.bytebuddy.asm.Advice.OffsetMapping.Factory
                public OffsetMapping make(ParameterDescription.InDefinedShape inDefinedShape,
                        AnnotationDescription.Loadable<Local> loadable, Factory.AdviceType adviceType) {
                    String str = (String) loadable.getValue(LOCAL_VALUE).resolve(String.class);
                    TypeDefinition typeDefinition = this.namedTypes.get(str);
                    if (typeDefinition != null) {
                        return new ForLocalValue(inDefinedShape.getType(), typeDefinition.asGenericType(), str);
                    }
                    throw new IllegalStateException(yg.concat("Named local variable is unknown: ", str));
                }
            }

            public ForLocalValue(TypeDescription.Generic generic, TypeDescription.Generic generic2, String str) {
                this.target = generic;
                this.localType = generic2;
                this.name = str;
            }

            public boolean equals(@MaybeNull Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || getClass() != obj.getClass()) {
                    return false;
                }
                ForLocalValue forLocalValue = (ForLocalValue) obj;
                return this.name.equals(forLocalValue.name) && this.target.equals(forLocalValue.target)
                        && this.localType.equals(forLocalValue.localType);
            }

            public int hashCode() {
                return this.name.hashCode()
                        + StaticHelpers6.e(this.localType, StaticHelpers6.e(this.target, getClass().hashCode() * 31, 31), 31);
            }

            @Override // net.bytebuddy.asm.Advice.OffsetMapping
            public Target resolve(TypeDescription typeDescription, MethodDescription methodDescription,
                    Assigner assigner, ArgumentHandler argumentHandler, Sort sort) {
                TypeDescription.Generic generic = this.localType;
                TypeDescription.Generic generic2 = this.target;
                Assigner.Typing typing = Assigner.Typing.STATIC;
                StackManipulation stackManipulationAssign = assigner.assign(generic, generic2, typing);
                StackManipulation stackManipulationAssign2 = assigner.assign(this.target, this.localType, typing);
                if (stackManipulationAssign.isValid() && stackManipulationAssign2.isValid()) {
                    return new Target.ForVariable.ReadWrite(this.target, argumentHandler.named(this.name),
                            stackManipulationAssign, stackManipulationAssign2);
                }
                throw new IllegalStateException("Cannot assign " + this.localType + " to " + this.target);
            }
        }

        /*
         * JADX INFO: compiled from:
         * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
         */
        @HashCodeAndEqualsPlugin.Enhance
        public static class ForOrigin implements OffsetMapping {
            private static final char DELIMITER = '#';
            private static final char ESCAPE = '\\';
            private final List<Renderer> renderers;

            /*
             * JADX INFO: compiled from:
             * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
             */
            public enum Factory implements Factory<Origin> {
                INSTANCE;

                private static final MethodDescription.InDefinedShape ORIGIN_VALUE = (MethodDescription.InDefinedShape) TypeDescription.ForLoadedType
                        .of(Origin.class).getDeclaredMethods().filter(ElementMatchers.named("value")).getOnly();

                @Override // net.bytebuddy.asm.Advice.OffsetMapping.Factory
                public Class<Origin> getAnnotationType() {
                    return Origin.class;
                }

                @Override // net.bytebuddy.asm.Advice.OffsetMapping.Factory
                public OffsetMapping make(ParameterDescription.InDefinedShape inDefinedShape,
                        AnnotationDescription.Loadable<Origin> loadable, Factory.AdviceType adviceType) {
                    if (inDefinedShape.getType().asErasure().represents(Class.class)) {
                        return ForInstrumentedType.INSTANCE;
                    }
                    if (inDefinedShape.getType().asErasure().represents(Method.class)) {
                        return ForInstrumentedMethod.METHOD;
                    }
                    if (inDefinedShape.getType().asErasure().represents(Constructor.class)) {
                        return ForInstrumentedMethod.CONSTRUCTOR;
                    }
                    if (JavaType.EXECUTABLE.getTypeStub().equals(inDefinedShape.getType().asErasure())) {
                        return ForInstrumentedMethod.EXECUTABLE;
                    }
                    if (inDefinedShape.getType().asErasure().represents(Integer.TYPE)) {
                        return ForInstrumentedMethod.MODIFIERS;
                    }
                    if (JavaType.METHOD_HANDLE.getTypeStub().equals(inDefinedShape.getType().asErasure())) {
                        return ForInstrumentedMethod.METHOD_HANDLE;
                    }
                    if (JavaType.METHOD_TYPE.getTypeStub().equals(inDefinedShape.getType().asErasure())) {
                        return ForInstrumentedMethod.METHOD_TYPE;
                    }
                    JavaType javaType = JavaType.METHOD_HANDLES_LOOKUP;
                    if (javaType.getTypeStub().equals(inDefinedShape.getType().asErasure())) {
                        return new ForStackManipulation(MethodInvocation.lookup(),
                                javaType.getTypeStub().asGenericType(), inDefinedShape.getType(),
                                Assigner.Typing.STATIC);
                    }
                    if (inDefinedShape.getType().asErasure().isAssignableFrom(String.class)) {
                        return ForOrigin.parse((String) loadable.getValue(ORIGIN_VALUE).resolve(String.class));
                    }
                    throw new IllegalStateException(
                            "Non-supported type " + inDefinedShape.getType() + " for @Origin annotation");
                }
            }

            /*
             * JADX INFO: compiled from:
             * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
             */
            public interface Renderer {

                /*
                 * JADX INFO: compiled from:
                 * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
                 */
                @HashCodeAndEqualsPlugin.Enhance
                public static class ForConstantValue implements Renderer {
                    private final String value;

                    public ForConstantValue(String str) {
                        this.value = str;
                    }

                    @Override // net.bytebuddy.asm.Advice.OffsetMapping.ForOrigin.Renderer
                    public String apply(TypeDescription typeDescription, MethodDescription methodDescription) {
                        return this.value;
                    }

                    public boolean equals(@MaybeNull Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        return obj != null && getClass() == obj.getClass()
                                && this.value.equals(((ForConstantValue) obj).value);
                    }

                    public int hashCode() {
                        return this.value.hashCode() + (getClass().hashCode() * 31);
                    }
                }

                /*
                 * JADX INFO: compiled from:
                 * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
                 */
                public enum ForDescriptor implements Renderer {
                    INSTANCE;

                    public static final char SYMBOL = 'd';

                    @Override // net.bytebuddy.asm.Advice.OffsetMapping.ForOrigin.Renderer
                    public String apply(TypeDescription typeDescription, MethodDescription methodDescription) {
                        return methodDescription.getDescriptor();
                    }
                }

                /*
                 * JADX INFO: compiled from:
                 * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
                 */
                public enum ForJavaSignature implements Renderer {
                    INSTANCE;

                    public static final char SYMBOL = 's';

                    @Override // net.bytebuddy.asm.Advice.OffsetMapping.ForOrigin.Renderer
                    public String apply(TypeDescription typeDescription, MethodDescription methodDescription) {
                        StringBuilder sb = new StringBuilder("(");
                        boolean z = false;
                        for (TypeDescription typeDescription2 : methodDescription.getParameters().asTypeList()
                                .asErasures()) {
                            if (z) {
                                sb.append(',');
                            } else {
                                z = true;
                            }
                            sb.append(typeDescription2.getName());
                        }
                        sb.append(')');
                        return sb.toString();
                    }
                }

                /*
                 * JADX INFO: compiled from:
                 * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
                 */
                public enum ForMethodName implements Renderer {
                    INSTANCE;

                    public static final char SYMBOL = 'm';

                    @Override // net.bytebuddy.asm.Advice.OffsetMapping.ForOrigin.Renderer
                    public String apply(TypeDescription typeDescription, MethodDescription methodDescription) {
                        return methodDescription.getInternalName();
                    }
                }

                /*
                 * JADX INFO: compiled from:
                 * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
                 */
                public enum ForPropertyName implements Renderer {
                    INSTANCE;

                    public static final char SYMBOL = 'p';

                    @Override // net.bytebuddy.asm.Advice.OffsetMapping.ForOrigin.Renderer
                    public String apply(TypeDescription typeDescription, MethodDescription methodDescription) {
                        return FieldAccessor.FieldNameExtractor.ForBeanProperty.INSTANCE.resolve(methodDescription);
                    }
                }

                /*
                 * JADX INFO: compiled from:
                 * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
                 */
                public enum ForReturnTypeName implements Renderer {
                    INSTANCE;

                    public static final char SYMBOL = 'r';

                    @Override // net.bytebuddy.asm.Advice.OffsetMapping.ForOrigin.Renderer
                    public String apply(TypeDescription typeDescription, MethodDescription methodDescription) {
                        return methodDescription.getReturnType().asErasure().getName();
                    }
                }

                /*
                 * JADX INFO: compiled from:
                 * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
                 */
                public enum ForStringRepresentation implements Renderer {
                    INSTANCE;

                    @Override // net.bytebuddy.asm.Advice.OffsetMapping.ForOrigin.Renderer
                    public String apply(TypeDescription typeDescription, MethodDescription methodDescription) {
                        return methodDescription.toString();
                    }
                }

                /*
                 * JADX INFO: compiled from:
                 * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
                 */
                public enum ForTypeName implements Renderer {
                    INSTANCE;

                    public static final char SYMBOL = 't';

                    @Override // net.bytebuddy.asm.Advice.OffsetMapping.ForOrigin.Renderer
                    public String apply(TypeDescription typeDescription, MethodDescription methodDescription) {
                        return typeDescription.getName();
                    }
                }

                String apply(TypeDescription typeDescription, MethodDescription methodDescription);
            }

            public ForOrigin(List<Renderer> list) {
                this.renderers = list;
            }

            /* JADX WARN: Found duplicated region for block: B:18:0x0063 */
            /* JADX WARN: Found duplicated region for block: B:20:0x006b */
            /* JADX WARN: Found duplicated region for block: B:22:0x0087 */
            /* JADX WARN: Found duplicated region for block: B:24:0x008b */
            /* JADX WARN: Found duplicated region for block: B:26:0x008f */
            /* JADX WARN: Found duplicated region for block: B:29:0x00b2 */
            /* JADX WARN: Found duplicated region for block: B:30:0x00b8 */
            /* JADX WARN: Found duplicated region for block: B:31:0x00be */
            /* JADX WARN: Found duplicated region for block: B:32:0x00c4 */
            /* JADX WARN: Found duplicated region for block: B:33:0x00ca */
            /* JADX WARN: Found duplicated region for block: B:34:0x00d0 */
            /* JADX WARN: Found duplicated region for block: B:42:0x00de A[SYNTHETIC] */
            /* JADX WARN: Found duplicated region for block: B:43:0x0092 A[SYNTHETIC] */
            public static OffsetMapping parse(String str) {
                int i;
                char cCharAt;
                int i2;
                if (str.equals("")) {
                    return new ForOrigin(Collections.singletonList(Renderer.ForStringRepresentation.INSTANCE));
                }
                ArrayList arrayList = new ArrayList(str.length());
                int iIndexOf = str.indexOf(35);
                int i3 = 0;
                while (iIndexOf != -1) {
                    if (iIndexOf != 0) {
                        int i4 = iIndexOf - 1;
                        if (str.charAt(i4) != '\\' || (iIndexOf != 1 && str.charAt(iIndexOf - 2) == '\\')) {
                            i = iIndexOf + 1;
                            if (str.length() != i) {
                                throw new IllegalStateException(
                                        "Missing sort descriptor for " + str + " at index " + iIndexOf);
                            }
                            arrayList.add(
                                    new Renderer.ForConstantValue(str.substring(i3, iIndexOf).replace("\\\\", "\\")));
                            cCharAt = str.charAt(i);
                            if (cCharAt != 'd') {
                                arrayList.add(Renderer.ForDescriptor.INSTANCE);
                            } else if (cCharAt != 'm') {
                                arrayList.add(Renderer.ForMethodName.INSTANCE);
                            } else if (cCharAt != 'p') {
                                switch (cCharAt) {
                                    case 'r':
                                        arrayList.add(Renderer.ForReturnTypeName.INSTANCE);
                                        break;
                                    case 's':
                                        arrayList.add(Renderer.ForJavaSignature.INSTANCE);
                                        break;
                                    case 't':
                                        arrayList.add(Renderer.ForTypeName.INSTANCE);
                                        break;
                                    default:
                                        throw new IllegalStateException(
                                                "Illegal sort descriptor " + str.charAt(i) + " for " + str);
                                }
                            } else {
                                arrayList.add(Renderer.ForPropertyName.INSTANCE);
                            }
                            i2 = iIndexOf + 2;
                        } else {
                            arrayList
                                    .add(new Renderer.ForConstantValue(str.substring(i3, Math.max(0, i4)) + DELIMITER));
                            i2 = iIndexOf + 1;
                        }
                    } else {
                        i = iIndexOf + 1;
                        if (str.length() != i) {
                            throw new IllegalStateException(
                                    "Missing sort descriptor for " + str + " at index " + iIndexOf);
                        }
                        arrayList.add(new Renderer.ForConstantValue(str.substring(i3, iIndexOf).replace("\\\\", "\\")));
                        cCharAt = str.charAt(i);
                        if (cCharAt != 'd') {
                            arrayList.add(Renderer.ForDescriptor.INSTANCE);
                        } else if (cCharAt != 'm') {
                            arrayList.add(Renderer.ForMethodName.INSTANCE);
                        } else if (cCharAt != 'p') {
                            switch (cCharAt) {
                                case 'r':
                                    arrayList.add(Renderer.ForReturnTypeName.INSTANCE);
                                    break;
                                case 's':
                                    arrayList.add(Renderer.ForJavaSignature.INSTANCE);
                                    break;
                                case 't':
                                    arrayList.add(Renderer.ForTypeName.INSTANCE);
                                    break;
                                default:
                                    throw new IllegalStateException(
                                            "Illegal sort descriptor " + str.charAt(i) + " for " + str);
                            }
                        } else {
                            arrayList.add(Renderer.ForPropertyName.INSTANCE);
                        }
                        i2 = iIndexOf + 2;
                    }
                    i3 = i2;
                    iIndexOf = str.indexOf(35, i3);
                }
                arrayList.add(new Renderer.ForConstantValue(str.substring(i3)));
                return new ForOrigin(arrayList);
            }

            public boolean equals(@MaybeNull Object obj) {
                if (this == obj) {
                    return true;
                }
                return obj != null && getClass() == obj.getClass()
                        && this.renderers.equals(((ForOrigin) obj).renderers);
            }

            public int hashCode() {
                return this.renderers.hashCode() + (getClass().hashCode() * 31);
            }

            @Override // net.bytebuddy.asm.Advice.OffsetMapping
            public Target resolve(TypeDescription typeDescription, MethodDescription methodDescription,
                    Assigner assigner, ArgumentHandler argumentHandler, Sort sort) {
                StringBuilder sb = new StringBuilder();
                Iterator<Renderer> it = this.renderers.iterator();
                while (it.hasNext()) {
                    sb.append(it.next().apply(typeDescription, methodDescription));
                }
                return Target.ForStackManipulation.of(sb.toString());
            }
        }

        /*
         * JADX INFO: compiled from:
         * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
         */
        public enum ForSelfCallHandle implements OffsetMapping {
            BOUND { // from class: net.bytebuddy.asm.Advice.OffsetMapping.ForSelfCallHandle.1
                @Override // net.bytebuddy.asm.Advice.OffsetMapping.ForSelfCallHandle
                public StackManipulation decorate(MethodDescription methodDescription,
                        StackManipulation stackManipulation) {
                    ArrayList arrayList = new ArrayList((methodDescription.getParameters().size() * 3)
                            + (methodDescription.isStatic() ? 0 : 2) + 1);
                    arrayList.add(stackManipulation);
                    if (!methodDescription.isStatic()) {
                        arrayList.add(MethodVariableAccess.loadThis());
                        JavaType javaType = JavaType.METHOD_HANDLE;
                        arrayList.add(MethodInvocation.invoke(
                                (MethodDescription.InDefinedShape) new MethodDescription.Latent(javaType.getTypeStub(),
                                        new MethodDescription.Token("bindTo", 1, javaType.getTypeStub().asGenericType(),
                                                new TypeList.Generic.Explicit(
                                                        TypeDefinition.Sort.describe(Object.class))))));
                    }
                    if (!methodDescription.getParameters().isEmpty()) {
                        ArrayList arrayList2 = new ArrayList(methodDescription.getParameters().size());
                        Iterator<?> it = methodDescription.getParameters().iterator();
                        while (it.hasNext()) {
                            ParameterDescription parameterDescription = (ParameterDescription) it.next();
                            arrayList2.add(parameterDescription.getType().isPrimitive()
                                    ? new StackManipulation.Compound(MethodVariableAccess.load(parameterDescription),
                                            Assigner.DEFAULT.assign(parameterDescription.getType(),
                                                    parameterDescription.getType().asErasure().asBoxed()
                                                            .asGenericType(),
                                                    Assigner.Typing.STATIC))
                                    : MethodVariableAccess.load(parameterDescription));
                        }
                        arrayList.add(IntegerConstant.forValue(0));
                        arrayList.add(
                                ArrayFactory.forType(TypeDescription.ForLoadedType.of(Object.class).asGenericType())
                                        .withValues(arrayList2));
                        TypeDescription typeStub = JavaType.METHOD_HANDLES.getTypeStub();
                        JavaType javaType2 = JavaType.METHOD_HANDLE;
                        arrayList.add(MethodInvocation
                                .invoke((MethodDescription.InDefinedShape) new MethodDescription.Latent(typeStub,
                                        new MethodDescription.Token("insertArguments", 9,
                                                javaType2.getTypeStub().asGenericType(),
                                                new TypeList.Generic.Explicit(javaType2.getTypeStub(),
                                                        TypeDefinition.Sort.describe(Integer.TYPE),
                                                        TypeDefinition.Sort.describe(Object[].class))))));
                    }
                    return new StackManipulation.Compound(arrayList);
                }
            },
            UNBOUND { // from class: net.bytebuddy.asm.Advice.OffsetMapping.ForSelfCallHandle.2
                @Override // net.bytebuddy.asm.Advice.OffsetMapping.ForSelfCallHandle
                public StackManipulation decorate(MethodDescription methodDescription,
                        StackManipulation stackManipulation) {
                    return stackManipulation;
                }
            };

            /*
             * JADX INFO: compiled from:
             * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
             */
            public enum Factory implements Factory<SelfCallHandle> {
                INSTANCE;

                private static final MethodDescription.InDefinedShape SELF_CALL_HANDLE_BOUND = (MethodDescription.InDefinedShape) TypeDescription.ForLoadedType
                        .of(SelfCallHandle.class).getDeclaredMethods().filter(ElementMatchers.named("bound")).getOnly();

                @Override // net.bytebuddy.asm.Advice.OffsetMapping.Factory
                public Class<SelfCallHandle> getAnnotationType() {
                    return SelfCallHandle.class;
                }

                @Override // net.bytebuddy.asm.Advice.OffsetMapping.Factory
                public OffsetMapping make(ParameterDescription.InDefinedShape inDefinedShape,
                        AnnotationDescription.Loadable<SelfCallHandle> loadable, Factory.AdviceType adviceType) {
                    if (inDefinedShape.getType().asErasure().isAssignableFrom(JavaType.METHOD_HANDLE.getTypeStub())) {
                        return ((Boolean) loadable.getValue(SELF_CALL_HANDLE_BOUND).resolve(Boolean.class))
                                .booleanValue() ? ForSelfCallHandle.BOUND : ForSelfCallHandle.UNBOUND;
                    }
                    throw new IllegalStateException("Cannot assign a MethodHandle to " + inDefinedShape);
                }
            }

            public abstract StackManipulation decorate(MethodDescription methodDescription,
                    StackManipulation stackManipulation);

            @Override // net.bytebuddy.asm.Advice.OffsetMapping
            public Target resolve(TypeDescription typeDescription, MethodDescription methodDescription,
                    Assigner assigner, ArgumentHandler argumentHandler, Sort sort) {
                if (methodDescription.isMethod()) {
                    return new Target.ForStackManipulation(decorate(methodDescription, (methodDescription.isStatic()
                            ? JavaConstant.MethodHandle.of(methodDescription.asDefined())
                            : JavaConstant.MethodHandle.ofSpecial(methodDescription.asDefined(), typeDescription))
                            .toStackManipulation()));
                }
                throw new IllegalStateException();
            }
        }

        /*
         * JADX INFO: compiled from:
         * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
         */
        @HashCodeAndEqualsPlugin.Enhance
        public static class ForSerializedValue implements OffsetMapping {
            private final StackManipulation deserialization;
            private final TypeDescription.Generic target;
            private final TypeDescription typeDescription;

            /*
             * JADX INFO: compiled from:
             * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
             */
            @HashCodeAndEqualsPlugin.Enhance
            public static class Factory<T extends Annotation> implements Factory<T> {
                private final Class<T> annotationType;
                private final StackManipulation deserialization;
                private final TypeDescription typeDescription;

                public Factory(Class<T> cls, TypeDescription typeDescription, StackManipulation stackManipulation) {
                    this.annotationType = cls;
                    this.typeDescription = typeDescription;
                    this.deserialization = stackManipulation;
                }

                public static <S extends Annotation, U extends Serializable> Factory<S> of(Class<S> cls, U u,
                        Class<? super U> cls2) {
                    if (cls2.isInstance(u)) {
                        return new Factory(cls, TypeDescription.ForLoadedType.of(cls2), SerializedConstant.of(u));
                    }
                    throw new IllegalArgumentException(u + " is no instance of " + cls2);
                }

                public boolean equals(@MaybeNull Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (obj == null || getClass() != obj.getClass()) {
                        return false;
                    }
                    Factory factory = (Factory) obj;
                    return this.annotationType.equals(factory.annotationType)
                            && this.typeDescription.equals(factory.typeDescription)
                            && this.deserialization.equals(factory.deserialization);
                }

                @Override // net.bytebuddy.asm.Advice.OffsetMapping.Factory
                public Class<T> getAnnotationType() {
                    return this.annotationType;
                }

                public int hashCode() {
                    return this.deserialization.hashCode() + StaticHelpers6.f(this.typeDescription,
                            bjs.d(getClass().hashCode() * 31, 31, this.annotationType), 31);
                }

                @Override // net.bytebuddy.asm.Advice.OffsetMapping.Factory
                public OffsetMapping make(ParameterDescription.InDefinedShape inDefinedShape,
                        AnnotationDescription.Loadable<T> loadable, Factory.AdviceType adviceType) {
                    return new ForSerializedValue(inDefinedShape.getType(), this.typeDescription, this.deserialization);
                }
            }

            public ForSerializedValue(TypeDescription.Generic generic, TypeDescription typeDescription,
                    StackManipulation stackManipulation) {
                this.target = generic;
                this.typeDescription = typeDescription;
                this.deserialization = stackManipulation;
            }

            public boolean equals(@MaybeNull Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || getClass() != obj.getClass()) {
                    return false;
                }
                ForSerializedValue forSerializedValue = (ForSerializedValue) obj;
                return this.target.equals(forSerializedValue.target)
                        && this.typeDescription.equals(forSerializedValue.typeDescription)
                        && this.deserialization.equals(forSerializedValue.deserialization);
            }

            public int hashCode() {
                return this.deserialization.hashCode()
                        + StaticHelpers6.f(this.typeDescription, StaticHelpers6.e(this.target, getClass().hashCode() * 31, 31), 31);
            }

            @Override // net.bytebuddy.asm.Advice.OffsetMapping
            public Target resolve(TypeDescription typeDescription, MethodDescription methodDescription,
                    Assigner assigner, ArgumentHandler argumentHandler, Sort sort) {
                StackManipulation stackManipulationAssign = assigner.assign(this.typeDescription.asGenericType(),
                        this.target, Assigner.Typing.DYNAMIC);
                if (stackManipulationAssign.isValid()) {
                    return new Target.ForStackManipulation(
                            new StackManipulation.Compound(this.deserialization, stackManipulationAssign));
                }
                throw new IllegalStateException("Cannot assign " + this.typeDescription + " to " + this.target);
            }
        }

        /*
         * JADX INFO: compiled from:
         * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
         */
        @HashCodeAndEqualsPlugin.Enhance
        public static class ForStackManipulation implements OffsetMapping {
            private final StackManipulation stackManipulation;
            private final TypeDescription.Generic targetType;
            private final TypeDescription.Generic typeDescription;
            private final Assigner.Typing typing;

            /*
             * JADX INFO: compiled from:
             * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
             */
            @HashCodeAndEqualsPlugin.Enhance
            public static class Factory<T extends Annotation> implements Factory<T> {
                private final Class<T> annotationType;
                private final StackManipulation stackManipulation;
                private final TypeDescription.Generic typeDescription;

                public Factory(Class<T> cls, TypeDescription typeDescription) {
                    this(cls, ClassConstant.of(typeDescription),
                            TypeDescription.ForLoadedType.of(Class.class).asGenericType());
                }

                public static <S extends Annotation> Factory<S> of(Class<S> cls, @MaybeNull Object obj) {
                    return obj == null ? new OfDefaultValue(cls) : new Factory(cls, ConstantValue.Simple.wrap(obj));
                }

                public boolean equals(@MaybeNull Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (obj == null || getClass() != obj.getClass()) {
                        return false;
                    }
                    Factory factory = (Factory) obj;
                    return this.annotationType.equals(factory.annotationType)
                            && this.stackManipulation.equals(factory.stackManipulation)
                            && this.typeDescription.equals(factory.typeDescription);
                }

                @Override // net.bytebuddy.asm.Advice.OffsetMapping.Factory
                public Class<T> getAnnotationType() {
                    return this.annotationType;
                }

                public int hashCode() {
                    return this.typeDescription.hashCode() + StaticHelpers6.g(this.stackManipulation,
                            bjs.d(getClass().hashCode() * 31, 31, this.annotationType), 31);
                }

                @Override // net.bytebuddy.asm.Advice.OffsetMapping.Factory
                public OffsetMapping make(ParameterDescription.InDefinedShape inDefinedShape,
                        AnnotationDescription.Loadable<T> loadable, Factory.AdviceType adviceType) {
                    return new ForStackManipulation(this.stackManipulation, this.typeDescription,
                            inDefinedShape.getType(), Assigner.Typing.STATIC);
                }

                public Factory(Class<T> cls, EnumerationDescription enumerationDescription) {
                    this(cls, FieldAccess.forEnumeration(enumerationDescription),
                            enumerationDescription.getEnumerationType().asGenericType());
                }

                public Factory(Class<T> cls, ConstantValue constantValue) {
                    this(cls, constantValue.toStackManipulation(), constantValue.getTypeDescription().asGenericType());
                }

                public Factory(Class<T> cls, StackManipulation stackManipulation, TypeDescription.Generic generic) {
                    this.annotationType = cls;
                    this.stackManipulation = stackManipulation;
                    this.typeDescription = generic;
                }
            }

            /*
             * JADX INFO: compiled from:
             * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
             */
            @HashCodeAndEqualsPlugin.Enhance
            public static class OfAnnotationProperty<T extends Annotation> implements Factory<T> {
                private final Class<T> annotationType;
                private final MethodDescription.InDefinedShape property;

                public OfAnnotationProperty(Class<T> cls, MethodDescription.InDefinedShape inDefinedShape) {
                    this.annotationType = cls;
                    this.property = inDefinedShape;
                }

                public static <S extends Annotation> Factory<S> of(Class<S> cls, String str) {
                    if (!cls.isAnnotation()) {
                        throw new IllegalArgumentException(concatVar2Var1(cls, "Not an annotation type: "));
                    }
                    try {
                        return new OfAnnotationProperty(cls,
                                new MethodDescription.ForLoadedMethod(cls.getMethod(str, null)));
                    } catch (NoSuchMethodException e) {
                        throw new IllegalArgumentException("Cannot find a property " + str + " on " + cls, e);
                    }
                }

                public boolean equals(@MaybeNull Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (obj == null || getClass() != obj.getClass()) {
                        return false;
                    }
                    OfAnnotationProperty ofAnnotationProperty = (OfAnnotationProperty) obj;
                    return this.annotationType.equals(ofAnnotationProperty.annotationType)
                            && this.property.equals(ofAnnotationProperty.property);
                }

                @Override // net.bytebuddy.asm.Advice.OffsetMapping.Factory
                public Class<T> getAnnotationType() {
                    return this.annotationType;
                }

                public int hashCode() {
                    return this.property.hashCode() + bjs.d(getClass().hashCode() * 31, 31, this.annotationType);
                }

                @Override // net.bytebuddy.asm.Advice.OffsetMapping.Factory
                public OffsetMapping make(ParameterDescription.InDefinedShape inDefinedShape,
                        AnnotationDescription.Loadable<T> loadable, Factory.AdviceType adviceType) {
                    ConstantValue constantValueWrapOrNull = ConstantValue.Simple
                            .wrapOrNull(loadable.getValue(this.property).resolve());
                    if (constantValueWrapOrNull != null) {
                        return new ForStackManipulation(constantValueWrapOrNull.toStackManipulation(),
                                constantValueWrapOrNull.getTypeDescription().asGenericType(), inDefinedShape.getType(),
                                Assigner.Typing.STATIC);
                    }
                    throw new IllegalStateException("Property does not represent a constant value: " + this.property);
                }
            }

            /*
             * JADX INFO: compiled from:
             * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
             */
            @HashCodeAndEqualsPlugin.Enhance
            public static class OfDefaultValue<T extends Annotation> implements Factory<T> {
                private final Class<T> annotationType;

                public OfDefaultValue(Class<T> cls) {
                    this.annotationType = cls;
                }

                public boolean equals(@MaybeNull Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    return obj != null && getClass() == obj.getClass()
                            && this.annotationType.equals(((OfDefaultValue) obj).annotationType);
                }

                @Override // net.bytebuddy.asm.Advice.OffsetMapping.Factory
                public Class<T> getAnnotationType() {
                    return this.annotationType;
                }

                public int hashCode() {
                    return this.annotationType.hashCode() + (getClass().hashCode() * 31);
                }

                @Override // net.bytebuddy.asm.Advice.OffsetMapping.Factory
                public OffsetMapping make(ParameterDescription.InDefinedShape inDefinedShape,
                        AnnotationDescription.Loadable<T> loadable, Factory.AdviceType adviceType) {
                    return new ForStackManipulation(DefaultValue.of(inDefinedShape.getType()), inDefinedShape.getType(),
                            inDefinedShape.getType(), Assigner.Typing.STATIC);
                }
            }

            /*
             * JADX INFO: compiled from:
             * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
             */
            @HashCodeAndEqualsPlugin.Enhance
            public static class OfDynamicInvocation<T extends Annotation> implements Factory<T> {
                private final Class<T> annotationType;
                private final List<? extends JavaConstant> arguments;
                private final MethodDescription.InDefinedShape bootstrapMethod;

                public OfDynamicInvocation(Class<T> cls, MethodDescription.InDefinedShape inDefinedShape,
                        List<? extends JavaConstant> list) {
                    this.annotationType = cls;
                    this.bootstrapMethod = inDefinedShape;
                    this.arguments = list;
                }

                public boolean equals(@MaybeNull Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (obj == null || getClass() != obj.getClass()) {
                        return false;
                    }
                    OfDynamicInvocation ofDynamicInvocation = (OfDynamicInvocation) obj;
                    return this.annotationType.equals(ofDynamicInvocation.annotationType)
                            && this.bootstrapMethod.equals(ofDynamicInvocation.bootstrapMethod)
                            && this.arguments.equals(ofDynamicInvocation.arguments);
                }

                @Override // net.bytebuddy.asm.Advice.OffsetMapping.Factory
                public Class<T> getAnnotationType() {
                    return this.annotationType;
                }

                public int hashCode() {
                    return this.arguments.hashCode() + StaticHelpers6.b(this.bootstrapMethod,
                            bjs.d(getClass().hashCode() * 31, 31, this.annotationType), 31);
                }

                @Override // net.bytebuddy.asm.Advice.OffsetMapping.Factory
                public OffsetMapping make(ParameterDescription.InDefinedShape inDefinedShape,
                        AnnotationDescription.Loadable<T> loadable, Factory.AdviceType adviceType) {
                    if (!inDefinedShape.getType().isInterface()) {
                        throw new IllegalArgumentException(inDefinedShape.getType() + " is not an interface");
                    }
                    if (!inDefinedShape.getType().getInterfaces().isEmpty()) {
                        throw new IllegalArgumentException(
                                inDefinedShape.getType() + " must not extend other interfaces");
                    }
                    if (!inDefinedShape.getType().isPublic()) {
                        throw new IllegalArgumentException(inDefinedShape.getType() + " is mot public");
                    }
                    MethodList methodListFilter = inDefinedShape.getType().getDeclaredMethods()
                            .filter(ElementMatchers.isAbstract());
                    if (methodListFilter.size() == 1) {
                        return new ForStackManipulation(
                                MethodInvocation.invoke(this.bootstrapMethod).dynamic(
                                        ((MethodDescription) methodListFilter.getOnly()).getInternalName(),
                                        inDefinedShape.getType().asErasure(), Collections.EMPTY_LIST, this.arguments),
                                inDefinedShape.getType(), inDefinedShape.getType(), Assigner.Typing.STATIC);
                    }
                    throw new IllegalArgumentException(
                            inDefinedShape.getType() + " must declare exactly one abstract method");
                }
            }

            public ForStackManipulation(StackManipulation stackManipulation, TypeDescription.Generic generic,
                    TypeDescription.Generic generic2, Assigner.Typing typing) {
                this.stackManipulation = stackManipulation;
                this.typeDescription = generic;
                this.targetType = generic2;
                this.typing = typing;
            }

            public boolean equals(@MaybeNull Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || getClass() != obj.getClass()) {
                    return false;
                }
                ForStackManipulation forStackManipulation = (ForStackManipulation) obj;
                return this.typing.equals(forStackManipulation.typing)
                        && this.stackManipulation.equals(forStackManipulation.stackManipulation)
                        && this.typeDescription.equals(forStackManipulation.typeDescription)
                        && this.targetType.equals(forStackManipulation.targetType);
            }

            public int hashCode() {
                return this.typing.hashCode() + StaticHelpers6.e(this.targetType,
                        StaticHelpers6.e(this.typeDescription, StaticHelpers6.g(this.stackManipulation, getClass().hashCode() * 31, 31), 31),
                        31);
            }

            @Override // net.bytebuddy.asm.Advice.OffsetMapping
            public Target resolve(TypeDescription typeDescription, MethodDescription methodDescription,
                    Assigner assigner, ArgumentHandler argumentHandler, Sort sort) {
                StackManipulation stackManipulationAssign = assigner.assign(this.typeDescription, this.targetType,
                        this.typing);
                if (stackManipulationAssign.isValid()) {
                    return new Target.ForStackManipulation(
                            new StackManipulation.Compound(this.stackManipulation, stackManipulationAssign));
                }
                throw new IllegalStateException("Cannot assign " + this.typeDescription + " to " + this.targetType);
            }
        }

        /*
         * JADX INFO: compiled from:
         * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
         */
        public enum ForStubValue implements OffsetMapping, Factory<StubValue> {
            INSTANCE;

            @Override // net.bytebuddy.asm.Advice.OffsetMapping.Factory
            public Class<StubValue> getAnnotationType() {
                return StubValue.class;
            }

            @Override // net.bytebuddy.asm.Advice.OffsetMapping.Factory
            public OffsetMapping make(ParameterDescription.InDefinedShape inDefinedShape,
                    AnnotationDescription.Loadable<StubValue> loadable, Factory.AdviceType adviceType) {
                if (inDefinedShape.getType().represents(Object.class)) {
                    return this;
                }
                throw new IllegalStateException("Cannot use StubValue on non-Object parameter type " + inDefinedShape);
            }

            @Override // net.bytebuddy.asm.Advice.OffsetMapping
            public Target resolve(TypeDescription typeDescription, MethodDescription methodDescription,
                    Assigner assigner, ArgumentHandler argumentHandler, Sort sort) {
                return new Target.ForDefaultValue.ReadOnly(methodDescription.getReturnType(),
                        assigner.assign(methodDescription.getReturnType(),
                                TypeDescription.Generic.OfNonGenericType.ForLoadedType.of(Object.class),
                                Assigner.Typing.DYNAMIC));
            }
        }

        /*
         * JADX INFO: compiled from:
         * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
         */
        @HashCodeAndEqualsPlugin.Enhance
        public static class ForUnusedValue implements OffsetMapping {
            private final TypeDefinition target;

            /*
             * JADX INFO: compiled from:
             * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
             */
            public enum Factory implements Factory<Unused> {
                INSTANCE;

                @Override // net.bytebuddy.asm.Advice.OffsetMapping.Factory
                public Class<Unused> getAnnotationType() {
                    return Unused.class;
                }

                @Override // net.bytebuddy.asm.Advice.OffsetMapping.Factory
                public OffsetMapping make(ParameterDescription.InDefinedShape inDefinedShape,
                        AnnotationDescription.Loadable<Unused> loadable, Factory.AdviceType adviceType) {
                    return new ForUnusedValue(inDefinedShape.getType());
                }
            }

            public ForUnusedValue(TypeDefinition typeDefinition) {
                this.target = typeDefinition;
            }

            public boolean equals(@MaybeNull Object obj) {
                if (this == obj) {
                    return true;
                }
                return obj != null && getClass() == obj.getClass() && this.target.equals(((ForUnusedValue) obj).target);
            }

            public int hashCode() {
                return this.target.hashCode() + (getClass().hashCode() * 31);
            }

            @Override // net.bytebuddy.asm.Advice.OffsetMapping
            public Target resolve(TypeDescription typeDescription, MethodDescription methodDescription,
                    Assigner assigner, ArgumentHandler argumentHandler, Sort sort) {
                return new Target.ForDefaultValue.ReadWrite(this.target);
            }
        }

        /*
         * JADX INFO: compiled from:
         * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
         */
        public enum Sort {
            ENTER { // from class: net.bytebuddy.asm.Advice.OffsetMapping.Sort.1
                @Override // net.bytebuddy.asm.Advice.OffsetMapping.Sort
                public boolean isPremature(MethodDescription methodDescription) {
                    return methodDescription.isConstructor();
                }
            },
            EXIT { // from class: net.bytebuddy.asm.Advice.OffsetMapping.Sort.2
                @Override // net.bytebuddy.asm.Advice.OffsetMapping.Sort
                public boolean isPremature(MethodDescription methodDescription) {
                    return false;
                }
            };

            public abstract boolean isPremature(MethodDescription methodDescription);
        }

        /*
         * JADX INFO: compiled from:
         * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
         */
        public interface Target {

            /*
             * JADX INFO: compiled from:
             * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
             */
            public static abstract class AbstractReadOnlyAdapter implements Target {
                @Override // net.bytebuddy.asm.Advice.OffsetMapping.Target
                public StackManipulation resolveIncrement(int i) {
                    throw new IllegalStateException("Cannot write to read-only value");
                }

                @Override // net.bytebuddy.asm.Advice.OffsetMapping.Target
                public StackManipulation resolveWrite() {
                    throw new IllegalStateException("Cannot write to read-only value");
                }
            }

            /*
             * JADX INFO: compiled from:
             * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
             */
            @HashCodeAndEqualsPlugin.Enhance
            public static abstract class ForArray implements Target {
                protected final TypeDescription.Generic target;
                protected final List<? extends StackManipulation> valueReads;

                /*
                 * JADX INFO: compiled from:
                 * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
                 */
                public static class ReadOnly extends ForArray {
                    public ReadOnly(TypeDescription.Generic generic, List<? extends StackManipulation> list) {
                        super(generic, list);
                    }

                    @Override // net.bytebuddy.asm.Advice.OffsetMapping.Target
                    public StackManipulation resolveWrite() {
                        throw new IllegalStateException("Cannot write to read-only array value");
                    }
                }

                /*
                 * JADX INFO: compiled from:
                 * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
                 */
                @HashCodeAndEqualsPlugin.Enhance
                public static class ReadWrite extends ForArray {
                    private final List<? extends StackManipulation> valueWrites;

                    public ReadWrite(TypeDescription.Generic generic, List<? extends StackManipulation> list,
                            List<? extends StackManipulation> list2) {
                        super(generic, list);
                        this.valueWrites = list2;
                    }

                    @Override // net.bytebuddy.asm.Advice.OffsetMapping.Target.ForArray
                    public boolean equals(@MaybeNull Object obj) {
                        if (!super.equals(obj)) {
                            return false;
                        }
                        if (this == obj) {
                            return true;
                        }
                        return obj != null && getClass() == obj.getClass()
                                && this.valueWrites.equals(((ReadWrite) obj).valueWrites);
                    }

                    @Override // net.bytebuddy.asm.Advice.OffsetMapping.Target.ForArray
                    public int hashCode() {
                        return this.valueWrites.hashCode() + (super.hashCode() * 31);
                    }

                    @Override // net.bytebuddy.asm.Advice.OffsetMapping.Target
                    public StackManipulation resolveWrite() {
                        return new StackManipulation.Compound(ArrayAccess.of(this.target).forEach(this.valueWrites),
                                Removal.SINGLE);
                    }
                }

                public ForArray(TypeDescription.Generic generic, List<? extends StackManipulation> list) {
                    this.target = generic;
                    this.valueReads = list;
                }

                public boolean equals(@MaybeNull Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (obj == null || getClass() != obj.getClass()) {
                        return false;
                    }
                    ForArray forArray = (ForArray) obj;
                    return this.target.equals(forArray.target) && this.valueReads.equals(forArray.valueReads);
                }

                public int hashCode() {
                    return this.valueReads.hashCode() + StaticHelpers6.e(this.target, getClass().hashCode() * 31, 31);
                }

                @Override // net.bytebuddy.asm.Advice.OffsetMapping.Target
                public StackManipulation resolveIncrement(int i) {
                    throw new IllegalStateException("Cannot increment read-only array value");
                }

                @Override // net.bytebuddy.asm.Advice.OffsetMapping.Target
                public StackManipulation resolveRead() {
                    return ArrayFactory.forType(this.target).withValues(this.valueReads);
                }
            }

            /*
             * JADX INFO: compiled from:
             * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
             */
            @HashCodeAndEqualsPlugin.Enhance
            public static abstract class ForDefaultValue implements Target {
                protected final StackManipulation readAssignment;
                protected final TypeDefinition typeDefinition;

                /*
                 * JADX INFO: compiled from:
                 * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
                 */
                public static class ReadOnly extends ForDefaultValue {
                    public ReadOnly(TypeDefinition typeDefinition) {
                        this(typeDefinition, StackManipulation.Trivial.INSTANCE);
                    }

                    @Override // net.bytebuddy.asm.Advice.OffsetMapping.Target
                    public StackManipulation resolveIncrement(int i) {
                        throw new IllegalStateException("Cannot write to read-only default value");
                    }

                    @Override // net.bytebuddy.asm.Advice.OffsetMapping.Target
                    public StackManipulation resolveWrite() {
                        throw new IllegalStateException("Cannot write to read-only default value");
                    }

                    public ReadOnly(TypeDefinition typeDefinition, StackManipulation stackManipulation) {
                        super(typeDefinition, stackManipulation);
                    }
                }

                /*
                 * JADX INFO: compiled from:
                 * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
                 */
                public static class ReadWrite extends ForDefaultValue {
                    public ReadWrite(TypeDefinition typeDefinition) {
                        this(typeDefinition, StackManipulation.Trivial.INSTANCE);
                    }

                    @Override // net.bytebuddy.asm.Advice.OffsetMapping.Target
                    public StackManipulation resolveIncrement(int i) {
                        return StackManipulation.Trivial.INSTANCE;
                    }

                    @Override // net.bytebuddy.asm.Advice.OffsetMapping.Target
                    public StackManipulation resolveWrite() {
                        return Removal.of(this.typeDefinition);
                    }

                    public ReadWrite(TypeDefinition typeDefinition, StackManipulation stackManipulation) {
                        super(typeDefinition, stackManipulation);
                    }
                }

                public ForDefaultValue(TypeDefinition typeDefinition, StackManipulation stackManipulation) {
                    this.typeDefinition = typeDefinition;
                    this.readAssignment = stackManipulation;
                }

                public boolean equals(@MaybeNull Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (obj == null || getClass() != obj.getClass()) {
                        return false;
                    }
                    ForDefaultValue forDefaultValue = (ForDefaultValue) obj;
                    return this.typeDefinition.equals(forDefaultValue.typeDefinition)
                            && this.readAssignment.equals(forDefaultValue.readAssignment);
                }

                public int hashCode() {
                    return this.readAssignment.hashCode()
                            + ((this.typeDefinition.hashCode() + (getClass().hashCode() * 31)) * 31);
                }

                @Override // net.bytebuddy.asm.Advice.OffsetMapping.Target
                public StackManipulation resolveRead() {
                    return new StackManipulation.Compound(DefaultValue.of(this.typeDefinition), this.readAssignment);
                }
            }

            /*
             * JADX INFO: compiled from:
             * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
             */
            @HashCodeAndEqualsPlugin.Enhance
            public static abstract class ForField implements Target {
                protected final FieldDescription fieldDescription;
                protected final StackManipulation readAssignment;

                /*
                 * JADX INFO: compiled from:
                 * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
                 */
                public static class ReadOnly extends ForField {
                    public ReadOnly(FieldDescription fieldDescription) {
                        this(fieldDescription, StackManipulation.Trivial.INSTANCE);
                    }

                    @Override // net.bytebuddy.asm.Advice.OffsetMapping.Target
                    public StackManipulation resolveIncrement(int i) {
                        throw new IllegalStateException("Cannot write to read-only field value");
                    }

                    @Override // net.bytebuddy.asm.Advice.OffsetMapping.Target
                    public StackManipulation resolveWrite() {
                        throw new IllegalStateException("Cannot write to read-only field value");
                    }

                    public ReadOnly(FieldDescription fieldDescription, StackManipulation stackManipulation) {
                        super(fieldDescription, stackManipulation);
                    }
                }

                /*
                 * JADX INFO: compiled from:
                 * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
                 */
                @HashCodeAndEqualsPlugin.Enhance
                public static class ReadWrite extends ForField {
                    private final StackManipulation writeAssignment;

                    /* JADX WARN: Illegal instructions before constructor call */
                    public ReadWrite(FieldDescription fieldDescription) {
                        StackManipulation.Trivial trivial = StackManipulation.Trivial.INSTANCE;
                        this(fieldDescription, trivial, trivial);
                    }

                    @Override // net.bytebuddy.asm.Advice.OffsetMapping.Target.ForField
                    public boolean equals(@MaybeNull Object obj) {
                        if (!super.equals(obj)) {
                            return false;
                        }
                        if (this == obj) {
                            return true;
                        }
                        return obj != null && getClass() == obj.getClass()
                                && this.writeAssignment.equals(((ReadWrite) obj).writeAssignment);
                    }

                    @Override // net.bytebuddy.asm.Advice.OffsetMapping.Target.ForField
                    public int hashCode() {
                        return this.writeAssignment.hashCode() + (super.hashCode() * 31);
                    }

                    @Override // net.bytebuddy.asm.Advice.OffsetMapping.Target
                    public StackManipulation resolveIncrement(int i) {
                        return new StackManipulation.Compound(resolveRead(), IntegerConstant.forValue(i),
                                Addition.INTEGER, resolveWrite());
                    }

                    @Override // net.bytebuddy.asm.Advice.OffsetMapping.Target
                    public StackManipulation resolveWrite() {
                        return new StackManipulation.Compound(this.writeAssignment, this.fieldDescription.isStatic()
                                ? StackManipulation.Trivial.INSTANCE
                                : new StackManipulation.Compound(MethodVariableAccess.loadThis(),
                                        Duplication.SINGLE.flipOver(this.fieldDescription.getType()), Removal.SINGLE),
                                FieldAccess.forField(this.fieldDescription).write());
                    }

                    public ReadWrite(FieldDescription fieldDescription, StackManipulation stackManipulation,
                            StackManipulation stackManipulation2) {
                        super(fieldDescription, stackManipulation);
                        this.writeAssignment = stackManipulation2;
                    }
                }

                /*
                 * JADX INFO: compiled from:
                 * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
                 */
                @HashCodeAndEqualsPlugin.Enhance
                public static class WriteOnly implements Target {
                    private final FieldDescription fieldDescription;
                    private final StackManipulation writeAssignment;

                    public WriteOnly(FieldDescription fieldDescription, StackManipulation stackManipulation) {
                        this.fieldDescription = fieldDescription;
                        this.writeAssignment = stackManipulation;
                    }

                    public boolean equals(@MaybeNull Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        if (obj == null || getClass() != obj.getClass()) {
                            return false;
                        }
                        WriteOnly writeOnly = (WriteOnly) obj;
                        return this.fieldDescription.equals(writeOnly.fieldDescription)
                                && this.writeAssignment.equals(writeOnly.writeAssignment);
                    }

                    public int hashCode() {
                        return this.writeAssignment.hashCode()
                                + ((this.fieldDescription.hashCode() + (getClass().hashCode() * 31)) * 31);
                    }

                    @Override // net.bytebuddy.asm.Advice.OffsetMapping.Target
                    public StackManipulation resolveIncrement(int i) {
                        throw new IllegalStateException("Cannot increment write-only field value");
                    }

                    @Override // net.bytebuddy.asm.Advice.OffsetMapping.Target
                    public StackManipulation resolveRead() {
                        throw new IllegalStateException("Cannot read write-only field value");
                    }

                    @Override // net.bytebuddy.asm.Advice.OffsetMapping.Target
                    public StackManipulation resolveWrite() {
                        return new StackManipulation.Compound(this.writeAssignment, this.fieldDescription.isStatic()
                                ? StackManipulation.Trivial.INSTANCE
                                : new StackManipulation.Compound(MethodVariableAccess.loadThis(),
                                        Duplication.SINGLE.flipOver(this.fieldDescription.getType()), Removal.SINGLE),
                                FieldAccess.forField(this.fieldDescription).write());
                    }
                }

                public ForField(FieldDescription fieldDescription, StackManipulation stackManipulation) {
                    this.fieldDescription = fieldDescription;
                    this.readAssignment = stackManipulation;
                }

                public boolean equals(@MaybeNull Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (obj == null || getClass() != obj.getClass()) {
                        return false;
                    }
                    ForField forField = (ForField) obj;
                    return this.fieldDescription.equals(forField.fieldDescription)
                            && this.readAssignment.equals(forField.readAssignment);
                }

                public int hashCode() {
                    return this.readAssignment.hashCode()
                            + ((this.fieldDescription.hashCode() + (getClass().hashCode() * 31)) * 31);
                }

                @Override // net.bytebuddy.asm.Advice.OffsetMapping.Target
                public StackManipulation resolveRead() {
                    return new StackManipulation.Compound(
                            this.fieldDescription.isStatic() ? StackManipulation.Trivial.INSTANCE
                                    : MethodVariableAccess.loadThis(),
                            FieldAccess.forField(this.fieldDescription).read(), this.readAssignment);
                }
            }

            /*
             * JADX INFO: compiled from:
             * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
             */
            @HashCodeAndEqualsPlugin.Enhance
            public static class ForStackManipulation implements Target {
                private final StackManipulation stackManipulation;

                /*
                 * JADX INFO: compiled from:
                 * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
                 */
                @HashCodeAndEqualsPlugin.Enhance
                public static class Writable implements Target {
                    private final StackManipulation read;
                    private final StackManipulation write;

                    public Writable(StackManipulation stackManipulation, StackManipulation stackManipulation2) {
                        this.read = stackManipulation;
                        this.write = stackManipulation2;
                    }

                    public boolean equals(@MaybeNull Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        if (obj == null || getClass() != obj.getClass()) {
                            return false;
                        }
                        Writable writable = (Writable) obj;
                        return this.read.equals(writable.read) && this.write.equals(writable.write);
                    }

                    public int hashCode() {
                        return this.write.hashCode() + StaticHelpers6.g(this.read, getClass().hashCode() * 31, 31);
                    }

                    @Override // net.bytebuddy.asm.Advice.OffsetMapping.Target
                    public StackManipulation resolveIncrement(int i) {
                        throw new IllegalStateException("Cannot increment mutable constant value: " + this.write);
                    }

                    @Override // net.bytebuddy.asm.Advice.OffsetMapping.Target
                    public StackManipulation resolveRead() {
                        return this.read;
                    }

                    @Override // net.bytebuddy.asm.Advice.OffsetMapping.Target
                    public StackManipulation resolveWrite() {
                        return this.write;
                    }
                }

                public ForStackManipulation(StackManipulation stackManipulation) {
                    this.stackManipulation = stackManipulation;
                }

                public static Target of(MethodDescription.InDefinedShape inDefinedShape) {
                    return new ForStackManipulation(MethodConstant.of(inDefinedShape));
                }

                public boolean equals(@MaybeNull Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    return obj != null && getClass() == obj.getClass()
                            && this.stackManipulation.equals(((ForStackManipulation) obj).stackManipulation);
                }

                public int hashCode() {
                    return this.stackManipulation.hashCode() + (getClass().hashCode() * 31);
                }

                @Override // net.bytebuddy.asm.Advice.OffsetMapping.Target
                public StackManipulation resolveIncrement(int i) {
                    throw new IllegalStateException("Cannot write to constant value: " + this.stackManipulation);
                }

                @Override // net.bytebuddy.asm.Advice.OffsetMapping.Target
                public StackManipulation resolveRead() {
                    return this.stackManipulation;
                }

                @Override // net.bytebuddy.asm.Advice.OffsetMapping.Target
                public StackManipulation resolveWrite() {
                    throw new IllegalStateException("Cannot write to constant value: " + this.stackManipulation);
                }

                public static Target of(TypeDescription typeDescription) {
                    return new ForStackManipulation(ClassConstant.of(typeDescription));
                }

                public static Target of(@MaybeNull Object obj) {
                    return new ForStackManipulation(
                            obj == null ? NullConstant.INSTANCE : ConstantValue.Simple.wrap(obj).toStackManipulation());
                }
            }

            /*
             * JADX INFO: compiled from:
             * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
             */
            @HashCodeAndEqualsPlugin.Enhance
            public static abstract class ForVariable implements Target {
                protected final int offset;
                protected final StackManipulation readAssignment;
                protected final TypeDefinition typeDefinition;

                /*
                 * JADX INFO: compiled from:
                 * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
                 */
                public static class ReadOnly extends ForVariable {
                    public ReadOnly(TypeDefinition typeDefinition, int i) {
                        this(typeDefinition, i, StackManipulation.Trivial.INSTANCE);
                    }

                    @Override // net.bytebuddy.asm.Advice.OffsetMapping.Target
                    public StackManipulation resolveIncrement(int i) {
                        throw new IllegalStateException(
                                "Cannot write to read-only variable " + this.typeDefinition + " at " + this.offset);
                    }

                    @Override // net.bytebuddy.asm.Advice.OffsetMapping.Target
                    public StackManipulation resolveWrite() {
                        throw new IllegalStateException(
                                "Cannot write to read-only parameter " + this.typeDefinition + " at " + this.offset);
                    }

                    public ReadOnly(TypeDefinition typeDefinition, int i, StackManipulation stackManipulation) {
                        super(typeDefinition, i, stackManipulation);
                    }
                }

                /*
                 * JADX INFO: compiled from:
                 * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
                 */
                @HashCodeAndEqualsPlugin.Enhance
                public static class ReadWrite extends ForVariable {
                    private final StackManipulation writeAssignment;

                    /* JADX WARN: Illegal instructions before constructor call */
                    public ReadWrite(TypeDefinition typeDefinition, int i) {
                        StackManipulation.Trivial trivial = StackManipulation.Trivial.INSTANCE;
                        this(typeDefinition, i, trivial, trivial);
                    }

                    @Override // net.bytebuddy.asm.Advice.OffsetMapping.Target.ForVariable
                    public boolean equals(@MaybeNull Object obj) {
                        if (!super.equals(obj)) {
                            return false;
                        }
                        if (this == obj) {
                            return true;
                        }
                        return obj != null && getClass() == obj.getClass()
                                && this.writeAssignment.equals(((ReadWrite) obj).writeAssignment);
                    }

                    @Override // net.bytebuddy.asm.Advice.OffsetMapping.Target.ForVariable
                    public int hashCode() {
                        return this.writeAssignment.hashCode() + (super.hashCode() * 31);
                    }

                    @Override // net.bytebuddy.asm.Advice.OffsetMapping.Target
                    public StackManipulation resolveIncrement(int i) {
                        return this.typeDefinition.represents(Integer.TYPE)
                                ? MethodVariableAccess.of(this.typeDefinition).increment(this.offset, i)
                                : new StackManipulation.Compound(resolveRead(), IntegerConstant.forValue(1),
                                        Addition.INTEGER, resolveWrite());
                    }

                    @Override // net.bytebuddy.asm.Advice.OffsetMapping.Target
                    public StackManipulation resolveWrite() {
                        return new StackManipulation.Compound(this.writeAssignment,
                                MethodVariableAccess.of(this.typeDefinition).storeAt(this.offset));
                    }

                    public ReadWrite(TypeDefinition typeDefinition, int i, StackManipulation stackManipulation,
                            StackManipulation stackManipulation2) {
                        super(typeDefinition, i, stackManipulation);
                        this.writeAssignment = stackManipulation2;
                    }
                }

                public ForVariable(TypeDefinition typeDefinition, int i, StackManipulation stackManipulation) {
                    this.typeDefinition = typeDefinition;
                    this.offset = i;
                    this.readAssignment = stackManipulation;
                }

                public boolean equals(@MaybeNull Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (obj == null || getClass() != obj.getClass()) {
                        return false;
                    }
                    ForVariable forVariable = (ForVariable) obj;
                    return this.offset == forVariable.offset && this.typeDefinition.equals(forVariable.typeDefinition)
                            && this.readAssignment.equals(forVariable.readAssignment);
                }

                public int hashCode() {
                    return this.readAssignment.hashCode()
                            + ((((this.typeDefinition.hashCode() + (getClass().hashCode() * 31)) * 31) + this.offset)
                                    * 31);
                }

                @Override // net.bytebuddy.asm.Advice.OffsetMapping.Target
                public StackManipulation resolveRead() {
                    return new StackManipulation.Compound(
                            MethodVariableAccess.of(this.typeDefinition).loadFrom(this.offset), this.readAssignment);
                }
            }

            StackManipulation resolveIncrement(int i);

            StackManipulation resolveRead();

            StackManipulation resolveWrite();
        }

        Target resolve(TypeDescription typeDescription, MethodDescription methodDescription, Assigner assigner,
                ArgumentHandler argumentHandler, Sort sort);

        /*
         * JADX INFO: compiled from:
         * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
         */
        @HashCodeAndEqualsPlugin.Enhance
        public static abstract class ForField implements OffsetMapping {
            private static final MethodDescription.InDefinedShape FIELD_DECLARING_TYPE;
            private static final MethodDescription.InDefinedShape FIELD_READ_ONLY;
            private static final MethodDescription.InDefinedShape FIELD_TYPING;
            private static final MethodDescription.InDefinedShape FIELD_VALUE;
            private final boolean readOnly;
            private final TypeDescription.Generic target;
            private final Assigner.Typing typing;

            /*
             * JADX INFO: compiled from:
             * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
             */
            @HashCodeAndEqualsPlugin.Enhance
            public static class Resolved extends ForField {
                private final FieldDescription fieldDescription;

                /*
                 * JADX INFO: compiled from:
                 * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
                 */
                @HashCodeAndEqualsPlugin.Enhance
                public static class Factory<T extends Annotation> implements Factory<T> {
                    private final Class<T> annotationType;
                    private final FieldDescription fieldDescription;
                    private final boolean readOnly;
                    private final Assigner.Typing typing;

                    public Factory(Class<T> cls, FieldDescription fieldDescription) {
                        this(cls, fieldDescription, true, Assigner.Typing.STATIC);
                    }

                    public boolean equals(@MaybeNull Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        if (obj == null || getClass() != obj.getClass()) {
                            return false;
                        }
                        Factory factory = (Factory) obj;
                        return this.readOnly == factory.readOnly && this.typing.equals(factory.typing)
                                && this.annotationType.equals(factory.annotationType)
                                && this.fieldDescription.equals(factory.fieldDescription);
                    }

                    @Override // net.bytebuddy.asm.Advice.OffsetMapping.Factory
                    public Class<T> getAnnotationType() {
                        return this.annotationType;
                    }

                    public int hashCode() {
                        return this.typing.hashCode() + ((((this.fieldDescription.hashCode()
                                + bjs.d(getClass().hashCode() * 31, 31, this.annotationType)) * 31)
                                + (this.readOnly ? 1 : 0)) * 31);
                    }

                    @Override // net.bytebuddy.asm.Advice.OffsetMapping.Factory
                    public OffsetMapping make(ParameterDescription.InDefinedShape inDefinedShape,
                            AnnotationDescription.Loadable<T> loadable, Factory.AdviceType adviceType) {
                        return new Resolved(inDefinedShape.getType(), this.readOnly, this.typing,
                                this.fieldDescription);
                    }

                    public Factory(Class<T> cls, FieldDescription fieldDescription, boolean z, Assigner.Typing typing) {
                        this.annotationType = cls;
                        this.fieldDescription = fieldDescription;
                        this.readOnly = z;
                        this.typing = typing;
                    }
                }

                public Resolved(TypeDescription.Generic generic, boolean z, Assigner.Typing typing,
                        FieldDescription fieldDescription) {
                    super(generic, z, typing);
                    this.fieldDescription = fieldDescription;
                }

                @Override // net.bytebuddy.asm.Advice.OffsetMapping.ForField
                public boolean equals(@MaybeNull Object obj) {
                    if (!super.equals(obj)) {
                        return false;
                    }
                    if (this == obj) {
                        return true;
                    }
                    return obj != null && getClass() == obj.getClass()
                            && this.fieldDescription.equals(((Resolved) obj).fieldDescription);
                }

                @Override // net.bytebuddy.asm.Advice.OffsetMapping.ForField
                public int hashCode() {
                    return this.fieldDescription.hashCode() + (super.hashCode() * 31);
                }

                @Override // net.bytebuddy.asm.Advice.OffsetMapping.ForField
                public FieldDescription resolve(TypeDescription typeDescription, MethodDescription methodDescription) {
                    if (!this.fieldDescription.isStatic() && !this.fieldDescription.getDeclaringType().asErasure()
                            .isAssignableFrom(typeDescription)) {
                        throw new IllegalStateException(this.fieldDescription + " is no member of " + typeDescription);
                    }
                    if (this.fieldDescription.isVisibleTo(typeDescription)) {
                        return this.fieldDescription;
                    }
                    throw new IllegalStateException(
                            "Cannot access " + this.fieldDescription + " from " + typeDescription);
                }
            }

            static {
                MethodList<MethodDescription.InDefinedShape> declaredMethods = TypeDescription.ForLoadedType
                        .of(FieldValue.class).getDeclaredMethods();
                FIELD_VALUE = (MethodDescription.InDefinedShape) declaredMethods.filter(ElementMatchers.named("value"))
                        .getOnly();
                FIELD_DECLARING_TYPE = (MethodDescription.InDefinedShape) declaredMethods
                        .filter(ElementMatchers.named("declaringType")).getOnly();
                FIELD_READ_ONLY = (MethodDescription.InDefinedShape) declaredMethods
                        .filter(ElementMatchers.named("readOnly")).getOnly();
                FIELD_TYPING = (MethodDescription.InDefinedShape) declaredMethods
                        .filter(ElementMatchers.named("typing")).getOnly();
            }

            public ForField(TypeDescription.Generic generic, boolean z, Assigner.Typing typing) {
                this.target = generic;
                this.readOnly = z;
                this.typing = typing;
            }

            public boolean equals(@MaybeNull Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || getClass() != obj.getClass()) {
                    return false;
                }
                ForField forField = (ForField) obj;
                return this.readOnly == forField.readOnly && this.typing.equals(forField.typing)
                        && this.target.equals(forField.target);
            }

            public int hashCode() {
                return this.typing.hashCode()
                        + ((StaticHelpers6.e(this.target, getClass().hashCode() * 31, 31) + (this.readOnly ? 1 : 0)) * 31);
            }

            @Override // net.bytebuddy.asm.Advice.OffsetMapping
            public Target resolve(TypeDescription typeDescription, MethodDescription methodDescription,
                    Assigner assigner, ArgumentHandler argumentHandler, Sort sort) {
                FieldDescription fieldDescriptionResolve = resolve(typeDescription, methodDescription);
                if (!fieldDescriptionResolve.isStatic() && methodDescription.isStatic()) {
                    throw new IllegalStateException("Cannot access non-static field " + fieldDescriptionResolve
                            + " from static method " + methodDescription);
                }
                if (sort.isPremature(methodDescription) && !fieldDescriptionResolve.isStatic()) {
                    if (this.readOnly) {
                        throw new IllegalStateException(
                                "Cannot read " + fieldDescriptionResolve + " before super constructor call");
                    }
                    StackManipulation stackManipulationAssign = assigner.assign(this.target,
                            fieldDescriptionResolve.getType(), this.typing);
                    if (stackManipulationAssign.isValid()) {
                        return new Target.ForField.WriteOnly(fieldDescriptionResolve.asDefined(),
                                stackManipulationAssign);
                    }
                    throw new IllegalStateException("Cannot assign " + this.target + " to " + fieldDescriptionResolve);
                }
                StackManipulation stackManipulationAssign2 = assigner.assign(fieldDescriptionResolve.getType(),
                        this.target, this.typing);
                if (!stackManipulationAssign2.isValid()) {
                    throw new IllegalStateException("Cannot assign " + fieldDescriptionResolve + " to " + this.target);
                }
                if (this.readOnly) {
                    return new Target.ForField.ReadOnly(fieldDescriptionResolve, stackManipulationAssign2);
                }
                StackManipulation stackManipulationAssign3 = assigner.assign(this.target,
                        fieldDescriptionResolve.getType(), this.typing);
                if (stackManipulationAssign3.isValid()) {
                    return new Target.ForField.ReadWrite(fieldDescriptionResolve.asDefined(), stackManipulationAssign2,
                            stackManipulationAssign3);
                }
                throw new IllegalStateException("Cannot assign " + this.target + " to " + fieldDescriptionResolve);
            }

            public abstract FieldDescription resolve(TypeDescription typeDescription,
                    MethodDescription methodDescription);

            /*
             * JADX INFO: compiled from:
             * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
             */
            @HashCodeAndEqualsPlugin.Enhance
            public static abstract class Unresolved extends ForField {
                protected static final String BEAN_PROPERTY = "";
                private final String name;

                /*
                 * JADX INFO: compiled from:
                 * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
                 */
                public enum Factory implements Factory<FieldValue> {
                    INSTANCE;

                    @Override // net.bytebuddy.asm.Advice.OffsetMapping.Factory
                    public Class<FieldValue> getAnnotationType() {
                        return FieldValue.class;
                    }

                    @Override // net.bytebuddy.asm.Advice.OffsetMapping.Factory
                    public OffsetMapping make(ParameterDescription.InDefinedShape inDefinedShape,
                            AnnotationDescription.Loadable<FieldValue> loadable, Factory.AdviceType adviceType) {
                        if (!adviceType.isDelegation()
                                || ((Boolean) loadable.getValue(ForField.FIELD_READ_ONLY).resolve(Boolean.class))
                                        .booleanValue()) {
                            TypeDescription typeDescription = (TypeDescription) loadable
                                    .getValue(ForField.FIELD_DECLARING_TYPE).resolve(TypeDescription.class);
                            return typeDescription.represents(Void.TYPE)
                                    ? new WithImplicitType(inDefinedShape.getType(), loadable)
                                    : new WithExplicitType(inDefinedShape.getType(), loadable, typeDescription);
                        }
                        throw new IllegalStateException(
                                "Cannot write to field for " + inDefinedShape + " in read-only context");
                    }
                }

                public Unresolved(TypeDescription.Generic generic, boolean z, Assigner.Typing typing, String str) {
                    super(generic, z, typing);
                    this.name = str;
                }

                @Override // net.bytebuddy.asm.Advice.OffsetMapping.ForField
                public boolean equals(@MaybeNull Object obj) {
                    if (!super.equals(obj)) {
                        return false;
                    }
                    if (this == obj) {
                        return true;
                    }
                    return obj != null && getClass() == obj.getClass() && this.name.equals(((Unresolved) obj).name);
                }

                public abstract FieldLocator fieldLocator(TypeDescription typeDescription);

                @Override // net.bytebuddy.asm.Advice.OffsetMapping.ForField
                public int hashCode() {
                    return this.name.hashCode() + (super.hashCode() * 31);
                }

                @Override // net.bytebuddy.asm.Advice.OffsetMapping.ForField
                public FieldDescription resolve(TypeDescription typeDescription, MethodDescription methodDescription) {
                    FieldLocator fieldLocator = fieldLocator(typeDescription);
                    FieldLocator.Resolution resolutionOfBeanAccessor = this.name.equals("")
                            ? FieldLocator.Resolution.Simple.ofBeanAccessor(fieldLocator, methodDescription)
                            : fieldLocator.locate(this.name);
                    if (resolutionOfBeanAccessor.isResolved()) {
                        return resolutionOfBeanAccessor.getField();
                    }
                    throw new IllegalStateException(
                            "Cannot locate field named " + this.name + " for " + typeDescription);
                }

                /*
                 * JADX INFO: compiled from:
                 * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
                 */
                @HashCodeAndEqualsPlugin.Enhance
                public static class WithExplicitType extends Unresolved {
                    private final TypeDescription declaringType;

                    public WithExplicitType(TypeDescription.Generic generic,
                            AnnotationDescription.Loadable<FieldValue> loadable, TypeDescription typeDescription) {
                        this(generic,
                                ((Boolean) loadable.getValue(ForField.FIELD_READ_ONLY).resolve(Boolean.class))
                                        .booleanValue(),
                                (Assigner.Typing) ((EnumerationDescription) loadable.getValue(ForField.FIELD_TYPING)
                                        .resolve(EnumerationDescription.class)).load(Assigner.Typing.class),
                                (String) loadable.getValue(ForField.FIELD_VALUE).resolve(String.class),
                                typeDescription);
                    }

                    @Override // net.bytebuddy.asm.Advice.OffsetMapping.ForField.Unresolved,
                              // net.bytebuddy.asm.Advice.OffsetMapping.ForField
                    public boolean equals(@MaybeNull Object obj) {
                        if (!super.equals(obj)) {
                            return false;
                        }
                        if (this == obj) {
                            return true;
                        }
                        return obj != null && getClass() == obj.getClass()
                                && this.declaringType.equals(((WithExplicitType) obj).declaringType);
                    }

                    @Override // net.bytebuddy.asm.Advice.OffsetMapping.ForField.Unresolved
                    public FieldLocator fieldLocator(TypeDescription typeDescription) {
                        if (this.declaringType.represents(TargetType.class)
                                || typeDescription.isAssignableTo(this.declaringType)) {
                            return new FieldLocator.ForExactType(
                                    TargetType.resolve(this.declaringType, typeDescription));
                        }
                        throw new IllegalStateException(this.declaringType + " is no super type of " + typeDescription);
                    }

                    @Override // net.bytebuddy.asm.Advice.OffsetMapping.ForField.Unresolved,
                              // net.bytebuddy.asm.Advice.OffsetMapping.ForField
                    public int hashCode() {
                        return this.declaringType.hashCode() + (super.hashCode() * 31);
                    }

                    public WithExplicitType(TypeDescription.Generic generic, boolean z, Assigner.Typing typing,
                            String str, TypeDescription typeDescription) {
                        super(generic, z, typing, str);
                        this.declaringType = typeDescription;
                    }
                }

                /*
                 * JADX INFO: compiled from:
                 * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
                 */
                public static class WithImplicitType extends Unresolved {
                    public WithImplicitType(TypeDescription.Generic generic,
                            AnnotationDescription.Loadable<FieldValue> loadable) {
                        this(generic,
                                ((Boolean) loadable.getValue(ForField.FIELD_READ_ONLY).resolve(Boolean.class))
                                        .booleanValue(),
                                (Assigner.Typing) ((EnumerationDescription) loadable.getValue(ForField.FIELD_TYPING)
                                        .resolve(EnumerationDescription.class)).load(Assigner.Typing.class),
                                (String) loadable.getValue(ForField.FIELD_VALUE).resolve(String.class));
                    }

                    @Override // net.bytebuddy.asm.Advice.OffsetMapping.ForField.Unresolved
                    public FieldLocator fieldLocator(TypeDescription typeDescription) {
                        return new FieldLocator.ForClassHierarchy(typeDescription);
                    }

                    public WithImplicitType(TypeDescription.Generic generic, boolean z, Assigner.Typing typing,
                            String str) {
                        super(generic, z, typing, str);
                    }
                }
            }
        }

        /*
         * JADX INFO: compiled from:
         * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
         */
        @HashCodeAndEqualsPlugin.Enhance
        public static abstract class ForArgument implements OffsetMapping {
            protected final boolean readOnly;
            protected final TypeDescription.Generic target;
            private final Assigner.Typing typing;

            /*
             * JADX INFO: compiled from:
             * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
             */
            @HashCodeAndEqualsPlugin.Enhance
            public static class Resolved extends ForArgument {
                private final ParameterDescription parameterDescription;

                /*
                 * JADX INFO: compiled from:
                 * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
                 */
                @HashCodeAndEqualsPlugin.Enhance
                public static class Factory<T extends Annotation> implements Factory<T> {
                    private final Class<T> annotationType;
                    private final ParameterDescription parameterDescription;
                    private final boolean readOnly;
                    private final Assigner.Typing typing;

                    public Factory(Class<T> cls, ParameterDescription parameterDescription) {
                        this(cls, parameterDescription, true, Assigner.Typing.STATIC);
                    }

                    public boolean equals(@MaybeNull Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        if (obj == null || getClass() != obj.getClass()) {
                            return false;
                        }
                        Factory factory = (Factory) obj;
                        return this.readOnly == factory.readOnly && this.typing.equals(factory.typing)
                                && this.annotationType.equals(factory.annotationType)
                                && this.parameterDescription.equals(factory.parameterDescription);
                    }

                    @Override // net.bytebuddy.asm.Advice.OffsetMapping.Factory
                    public Class<T> getAnnotationType() {
                        return this.annotationType;
                    }

                    public int hashCode() {
                        return this.typing.hashCode() + ((((this.parameterDescription.hashCode()
                                + bjs.d(getClass().hashCode() * 31, 31, this.annotationType)) * 31)
                                + (this.readOnly ? 1 : 0)) * 31);
                    }

                    @Override // net.bytebuddy.asm.Advice.OffsetMapping.Factory
                    public OffsetMapping make(ParameterDescription.InDefinedShape inDefinedShape,
                            AnnotationDescription.Loadable<T> loadable, Factory.AdviceType adviceType) {
                        return new Resolved(inDefinedShape.getType(), this.readOnly, this.typing,
                                this.parameterDescription);
                    }

                    public Factory(Class<T> cls, ParameterDescription parameterDescription, boolean z,
                            Assigner.Typing typing) {
                        this.annotationType = cls;
                        this.parameterDescription = parameterDescription;
                        this.readOnly = z;
                        this.typing = typing;
                    }
                }

                public Resolved(TypeDescription.Generic generic, boolean z, Assigner.Typing typing,
                        ParameterDescription parameterDescription) {
                    super(generic, z, typing);
                    this.parameterDescription = parameterDescription;
                }

                @Override // net.bytebuddy.asm.Advice.OffsetMapping.ForArgument
                public boolean equals(@MaybeNull Object obj) {
                    if (!super.equals(obj)) {
                        return false;
                    }
                    if (this == obj) {
                        return true;
                    }
                    return obj != null && getClass() == obj.getClass()
                            && this.parameterDescription.equals(((Resolved) obj).parameterDescription);
                }

                @Override // net.bytebuddy.asm.Advice.OffsetMapping.ForArgument
                public int hashCode() {
                    return this.parameterDescription.hashCode() + (super.hashCode() * 31);
                }

                @Override // net.bytebuddy.asm.Advice.OffsetMapping.ForArgument
                public ParameterDescription resolve(MethodDescription methodDescription) {
                    if (this.parameterDescription.getDeclaringMethod().equals(methodDescription)) {
                        return this.parameterDescription;
                    }
                    throw new IllegalStateException(
                            this.parameterDescription + " is not a parameter of " + methodDescription);
                }
            }

            public ForArgument(TypeDescription.Generic generic, boolean z, Assigner.Typing typing) {
                this.target = generic;
                this.readOnly = z;
                this.typing = typing;
            }

            public boolean equals(@MaybeNull Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || getClass() != obj.getClass()) {
                    return false;
                }
                ForArgument forArgument = (ForArgument) obj;
                return this.readOnly == forArgument.readOnly && this.typing.equals(forArgument.typing)
                        && this.target.equals(forArgument.target);
            }

            public int hashCode() {
                return this.typing.hashCode()
                        + ((StaticHelpers6.e(this.target, getClass().hashCode() * 31, 31) + (this.readOnly ? 1 : 0)) * 31);
            }

            @Override // net.bytebuddy.asm.Advice.OffsetMapping
            public Target resolve(TypeDescription typeDescription, MethodDescription methodDescription,
                    Assigner assigner, ArgumentHandler argumentHandler, Sort sort) {
                ParameterDescription parameterDescriptionResolve = resolve(methodDescription);
                StackManipulation stackManipulationAssign = assigner.assign(parameterDescriptionResolve.getType(),
                        this.target, this.typing);
                if (!stackManipulationAssign.isValid()) {
                    throw new IllegalStateException(
                            "Cannot assign " + parameterDescriptionResolve + " to " + this.target);
                }
                if (this.readOnly) {
                    return new Target.ForVariable.ReadOnly(parameterDescriptionResolve.getType(),
                            argumentHandler.argument(parameterDescriptionResolve.getOffset()), stackManipulationAssign);
                }
                StackManipulation stackManipulationAssign2 = assigner.assign(this.target,
                        parameterDescriptionResolve.getType(), this.typing);
                if (stackManipulationAssign2.isValid()) {
                    return new Target.ForVariable.ReadWrite(parameterDescriptionResolve.getType(),
                            argumentHandler.argument(parameterDescriptionResolve.getOffset()), stackManipulationAssign,
                            stackManipulationAssign2);
                }
                throw new IllegalStateException("Cannot assign " + parameterDescriptionResolve + " to " + this.target);
            }

            public abstract ParameterDescription resolve(MethodDescription methodDescription);

            /*
             * JADX INFO: compiled from:
             * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
             */
            @HashCodeAndEqualsPlugin.Enhance
            public static class Unresolved extends ForArgument {
                private final int index;
                private final boolean optional;

                /*
                 * JADX INFO: compiled from:
                 * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
                 */
                public enum Factory implements Factory<Argument> {
                    INSTANCE;

                    private static final MethodDescription.InDefinedShape ARGUMENT_OPTIONAL;
                    private static final MethodDescription.InDefinedShape ARGUMENT_READ_ONLY;
                    private static final MethodDescription.InDefinedShape ARGUMENT_TYPING;
                    private static final MethodDescription.InDefinedShape ARGUMENT_VALUE;

                    static {
                        MethodList<MethodDescription.InDefinedShape> declaredMethods = TypeDescription.ForLoadedType
                                .of(Argument.class).getDeclaredMethods();
                        ARGUMENT_VALUE = (MethodDescription.InDefinedShape) declaredMethods
                                .filter(ElementMatchers.named("value")).getOnly();
                        ARGUMENT_READ_ONLY = (MethodDescription.InDefinedShape) declaredMethods
                                .filter(ElementMatchers.named("readOnly")).getOnly();
                        ARGUMENT_TYPING = (MethodDescription.InDefinedShape) declaredMethods
                                .filter(ElementMatchers.named("typing")).getOnly();
                        ARGUMENT_OPTIONAL = (MethodDescription.InDefinedShape) declaredMethods
                                .filter(ElementMatchers.named("optional")).getOnly();
                    }

                    @Override // net.bytebuddy.asm.Advice.OffsetMapping.Factory
                    public Class<Argument> getAnnotationType() {
                        return Argument.class;
                    }

                    @Override // net.bytebuddy.asm.Advice.OffsetMapping.Factory
                    public OffsetMapping make(ParameterDescription.InDefinedShape inDefinedShape,
                            AnnotationDescription.Loadable<Argument> loadable, Factory.AdviceType adviceType) {
                        if (!adviceType.isDelegation()
                                || ((Boolean) loadable.getValue(ARGUMENT_READ_ONLY).resolve(Boolean.class))
                                        .booleanValue()) {
                            return new Unresolved(inDefinedShape.getType(), loadable);
                        }
                        throw new IllegalStateException(
                                "Cannot define writable field access for " + inDefinedShape + " when using delegation");
                    }
                }

                public Unresolved(TypeDescription.Generic generic, AnnotationDescription.Loadable<Argument> loadable) {
                    this(generic,
                            ((Boolean) loadable.getValue(Factory.ARGUMENT_READ_ONLY).resolve(Boolean.class))
                                    .booleanValue(),
                            (Assigner.Typing) ((EnumerationDescription) loadable.getValue(Factory.ARGUMENT_TYPING)
                                    .resolve(EnumerationDescription.class)).load(Assigner.Typing.class),
                            ((Integer) loadable.getValue(Factory.ARGUMENT_VALUE).resolve(Integer.class)).intValue(),
                            ((Boolean) loadable.getValue(Factory.ARGUMENT_OPTIONAL).resolve(Boolean.class))
                                    .booleanValue());
                }

                @Override // net.bytebuddy.asm.Advice.OffsetMapping.ForArgument
                public boolean equals(@MaybeNull Object obj) {
                    if (!super.equals(obj)) {
                        return false;
                    }
                    if (this == obj) {
                        return true;
                    }
                    if (obj == null || getClass() != obj.getClass()) {
                        return false;
                    }
                    Unresolved unresolved = (Unresolved) obj;
                    return this.index == unresolved.index && this.optional == unresolved.optional;
                }

                @Override // net.bytebuddy.asm.Advice.OffsetMapping.ForArgument
                public int hashCode() {
                    return (((super.hashCode() * 31) + this.index) * 31) + (this.optional ? 1 : 0);
                }

                @Override // net.bytebuddy.asm.Advice.OffsetMapping.ForArgument
                public ParameterDescription resolve(MethodDescription methodDescription) {
                    ParameterList<?> parameters = methodDescription.getParameters();
                    int size = parameters.size();
                    int i = this.index;
                    if (size > i) {
                        return (ParameterDescription) parameters.get(i);
                    }
                    throw new IllegalStateException(methodDescription + " does not define an index " + this.index);
                }

                @Override // net.bytebuddy.asm.Advice.OffsetMapping.ForArgument,
                          // net.bytebuddy.asm.Advice.OffsetMapping
                public Target resolve(TypeDescription typeDescription, MethodDescription methodDescription,
                        Assigner assigner, ArgumentHandler argumentHandler, Sort sort) {
                    if (!this.optional || methodDescription.getParameters().size() > this.index) {
                        return super.resolve(typeDescription, methodDescription, assigner, argumentHandler, sort);
                    }
                    return this.readOnly ? new Target.ForDefaultValue.ReadOnly(this.target)
                            : new Target.ForDefaultValue.ReadWrite(this.target);
                }

                public Unresolved(ParameterDescription parameterDescription) {
                    this(parameterDescription.getType(), true, Assigner.Typing.STATIC, parameterDescription.getIndex());
                }

                public Unresolved(TypeDescription.Generic generic, boolean z, Assigner.Typing typing, int i) {
                    this(generic, z, typing, i, false);
                }

                public Unresolved(TypeDescription.Generic generic, boolean z, Assigner.Typing typing, int i,
                        boolean z2) {
                    super(generic, z, typing);
                    this.index = i;
                    this.optional = z2;
                }
            }
        }

        /*
         * JADX INFO: compiled from:
         * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
         */
        @HashCodeAndEqualsPlugin.Enhance
        public static class ForEnterValue implements OffsetMapping {
            private final TypeDescription.Generic enterType;
            private final boolean readOnly;
            private final TypeDescription.Generic target;
            private final Assigner.Typing typing;

            /*
             * JADX INFO: compiled from:
             * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
             */
            @HashCodeAndEqualsPlugin.Enhance
            public static class Factory implements Factory<Enter> {
                private static final MethodDescription.InDefinedShape ENTER_READ_ONLY;
                private static final MethodDescription.InDefinedShape ENTER_TYPING;
                private final TypeDefinition enterType;

                static {
                    MethodList<MethodDescription.InDefinedShape> declaredMethods = TypeDescription.ForLoadedType
                            .of(Enter.class).getDeclaredMethods();
                    ENTER_READ_ONLY = (MethodDescription.InDefinedShape) declaredMethods
                            .filter(ElementMatchers.named("readOnly")).getOnly();
                    ENTER_TYPING = (MethodDescription.InDefinedShape) declaredMethods
                            .filter(ElementMatchers.named("typing")).getOnly();
                }

                public Factory(TypeDefinition typeDefinition) {
                    this.enterType = typeDefinition;
                }

                public static Factory<Enter> of(TypeDefinition typeDefinition) {
                    return typeDefinition.represents(Void.TYPE) ? new Factory.Illegal(Enter.class)
                            : new Factory(typeDefinition);
                }

                public boolean equals(@MaybeNull Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    return obj != null && getClass() == obj.getClass()
                            && this.enterType.equals(((Factory) obj).enterType);
                }

                @Override // net.bytebuddy.asm.Advice.OffsetMapping.Factory
                public Class<Enter> getAnnotationType() {
                    return Enter.class;
                }

                public int hashCode() {
                    return this.enterType.hashCode() + (getClass().hashCode() * 31);
                }

                @Override // net.bytebuddy.asm.Advice.OffsetMapping.Factory
                public OffsetMapping make(ParameterDescription.InDefinedShape inDefinedShape,
                        AnnotationDescription.Loadable<Enter> loadable, Factory.AdviceType adviceType) {
                    if (!adviceType.isDelegation()
                            || ((Boolean) loadable.getValue(ENTER_READ_ONLY).resolve(Boolean.class)).booleanValue()) {
                        return new ForEnterValue(inDefinedShape.getType(), this.enterType.asGenericType(), loadable);
                    }
                    throw new IllegalStateException(
                            "Cannot use writable " + inDefinedShape + " on read-only parameter");
                }
            }

            public ForEnterValue(TypeDescription.Generic generic, TypeDescription.Generic generic2,
                    AnnotationDescription.Loadable<Enter> loadable) {
                this(generic, generic2,
                        ((Boolean) loadable.getValue(Factory.ENTER_READ_ONLY).resolve(Boolean.class)).booleanValue(),
                        (Assigner.Typing) ((EnumerationDescription) loadable.getValue(Factory.ENTER_TYPING)
                                .resolve(EnumerationDescription.class)).load(Assigner.Typing.class));
            }

            public boolean equals(@MaybeNull Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || getClass() != obj.getClass()) {
                    return false;
                }
                ForEnterValue forEnterValue = (ForEnterValue) obj;
                return this.readOnly == forEnterValue.readOnly && this.typing.equals(forEnterValue.typing)
                        && this.target.equals(forEnterValue.target) && this.enterType.equals(forEnterValue.enterType);
            }

            public int hashCode() {
                return this.typing.hashCode()
                        + ((StaticHelpers6.e(this.enterType, StaticHelpers6.e(this.target, getClass().hashCode() * 31, 31), 31)
                                + (this.readOnly ? 1 : 0)) * 31);
            }

            @Override // net.bytebuddy.asm.Advice.OffsetMapping
            public Target resolve(TypeDescription typeDescription, MethodDescription methodDescription,
                    Assigner assigner, ArgumentHandler argumentHandler, Sort sort) {
                StackManipulation stackManipulationAssign = assigner.assign(this.enterType, this.target, this.typing);
                if (!stackManipulationAssign.isValid()) {
                    throw new IllegalStateException("Cannot assign " + this.enterType + " to " + this.target);
                }
                if (this.readOnly) {
                    return new Target.ForVariable.ReadOnly(this.target, argumentHandler.enter(),
                            stackManipulationAssign);
                }
                StackManipulation stackManipulationAssign2 = assigner.assign(this.target, this.enterType, this.typing);
                if (stackManipulationAssign2.isValid()) {
                    return new Target.ForVariable.ReadWrite(this.target, argumentHandler.enter(),
                            stackManipulationAssign, stackManipulationAssign2);
                }
                throw new IllegalStateException("Cannot assign " + this.target + " to " + this.enterType);
            }

            public ForEnterValue(TypeDescription.Generic generic, TypeDescription.Generic generic2, boolean z,
                    Assigner.Typing typing) {
                this.target = generic;
                this.enterType = generic2;
                this.readOnly = z;
                this.typing = typing;
            }
        }

        /*
         * JADX INFO: compiled from:
         * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
         */
        @HashCodeAndEqualsPlugin.Enhance
        public static class ForExitValue implements OffsetMapping {
            private final TypeDescription.Generic exitType;
            private final boolean readOnly;
            private final TypeDescription.Generic target;
            private final Assigner.Typing typing;

            /*
             * JADX INFO: compiled from:
             * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
             */
            @HashCodeAndEqualsPlugin.Enhance
            public static class Factory implements Factory<Exit> {
                private static final MethodDescription.InDefinedShape EXIT_READ_ONLY;
                private static final MethodDescription.InDefinedShape EXIT_TYPING;
                private final TypeDefinition exitType;

                static {
                    MethodList<MethodDescription.InDefinedShape> declaredMethods = TypeDescription.ForLoadedType
                            .of(Exit.class).getDeclaredMethods();
                    EXIT_READ_ONLY = (MethodDescription.InDefinedShape) declaredMethods
                            .filter(ElementMatchers.named("readOnly")).getOnly();
                    EXIT_TYPING = (MethodDescription.InDefinedShape) declaredMethods
                            .filter(ElementMatchers.named("typing")).getOnly();
                }

                public Factory(TypeDefinition typeDefinition) {
                    this.exitType = typeDefinition;
                }

                public static Factory<Exit> of(TypeDefinition typeDefinition) {
                    return typeDefinition.represents(Void.TYPE) ? new Factory.Illegal(Exit.class)
                            : new Factory(typeDefinition);
                }

                public boolean equals(@MaybeNull Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    return obj != null && getClass() == obj.getClass()
                            && this.exitType.equals(((Factory) obj).exitType);
                }

                @Override // net.bytebuddy.asm.Advice.OffsetMapping.Factory
                public Class<Exit> getAnnotationType() {
                    return Exit.class;
                }

                public int hashCode() {
                    return this.exitType.hashCode() + (getClass().hashCode() * 31);
                }

                @Override // net.bytebuddy.asm.Advice.OffsetMapping.Factory
                public OffsetMapping make(ParameterDescription.InDefinedShape inDefinedShape,
                        AnnotationDescription.Loadable<Exit> loadable, Factory.AdviceType adviceType) {
                    if (!adviceType.isDelegation()
                            || ((Boolean) loadable.getValue(EXIT_READ_ONLY).resolve(Boolean.class)).booleanValue()) {
                        return new ForExitValue(inDefinedShape.getType(), this.exitType.asGenericType(), loadable);
                    }
                    throw new IllegalStateException(
                            "Cannot use writable " + inDefinedShape + " on read-only parameter");
                }
            }

            public ForExitValue(TypeDescription.Generic generic, TypeDescription.Generic generic2,
                    AnnotationDescription.Loadable<Exit> loadable) {
                this(generic, generic2,
                        ((Boolean) loadable.getValue(Factory.EXIT_READ_ONLY).resolve(Boolean.class)).booleanValue(),
                        (Assigner.Typing) ((EnumerationDescription) loadable.getValue(Factory.EXIT_TYPING)
                                .resolve(EnumerationDescription.class)).load(Assigner.Typing.class));
            }

            public boolean equals(@MaybeNull Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || getClass() != obj.getClass()) {
                    return false;
                }
                ForExitValue forExitValue = (ForExitValue) obj;
                return this.readOnly == forExitValue.readOnly && this.typing.equals(forExitValue.typing)
                        && this.target.equals(forExitValue.target) && this.exitType.equals(forExitValue.exitType);
            }

            public int hashCode() {
                return this.typing.hashCode()
                        + ((StaticHelpers6.e(this.exitType, StaticHelpers6.e(this.target, getClass().hashCode() * 31, 31), 31)
                                + (this.readOnly ? 1 : 0)) * 31);
            }

            @Override // net.bytebuddy.asm.Advice.OffsetMapping
            public Target resolve(TypeDescription typeDescription, MethodDescription methodDescription,
                    Assigner assigner, ArgumentHandler argumentHandler, Sort sort) {
                StackManipulation stackManipulationAssign = assigner.assign(this.exitType, this.target, this.typing);
                if (!stackManipulationAssign.isValid()) {
                    throw new IllegalStateException("Cannot assign " + this.exitType + " to " + this.target);
                }
                if (this.readOnly) {
                    return new Target.ForVariable.ReadOnly(this.target, argumentHandler.exit(),
                            stackManipulationAssign);
                }
                StackManipulation stackManipulationAssign2 = assigner.assign(this.target, this.exitType, this.typing);
                if (stackManipulationAssign2.isValid()) {
                    return new Target.ForVariable.ReadWrite(this.target, argumentHandler.exit(),
                            stackManipulationAssign, stackManipulationAssign2);
                }
                throw new IllegalStateException("Cannot assign " + this.target + " to " + this.exitType);
            }

            public ForExitValue(TypeDescription.Generic generic, TypeDescription.Generic generic2, boolean z,
                    Assigner.Typing typing) {
                this.target = generic;
                this.exitType = generic2;
                this.readOnly = z;
                this.typing = typing;
            }
        }

        /*
         * JADX INFO: compiled from:
         * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
         */
        @HashCodeAndEqualsPlugin.Enhance
        public static class ForReturnValue implements OffsetMapping {
            private final boolean readOnly;
            private final TypeDescription.Generic target;
            private final Assigner.Typing typing;

            /*
             * JADX INFO: compiled from:
             * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
             */
            public enum Factory implements Factory<Return> {
                INSTANCE;

                private static final MethodDescription.InDefinedShape RETURN_READ_ONLY;
                private static final MethodDescription.InDefinedShape RETURN_TYPING;

                static {
                    MethodList<MethodDescription.InDefinedShape> declaredMethods = TypeDescription.ForLoadedType
                            .of(Return.class).getDeclaredMethods();
                    RETURN_READ_ONLY = (MethodDescription.InDefinedShape) declaredMethods
                            .filter(ElementMatchers.named("readOnly")).getOnly();
                    RETURN_TYPING = (MethodDescription.InDefinedShape) declaredMethods
                            .filter(ElementMatchers.named("typing")).getOnly();
                }

                @Override // net.bytebuddy.asm.Advice.OffsetMapping.Factory
                public Class<Return> getAnnotationType() {
                    return Return.class;
                }

                @Override // net.bytebuddy.asm.Advice.OffsetMapping.Factory
                public OffsetMapping make(ParameterDescription.InDefinedShape inDefinedShape,
                        AnnotationDescription.Loadable<Return> loadable, Factory.AdviceType adviceType) {
                    if (!adviceType.isDelegation()
                            || ((Boolean) loadable.getValue(RETURN_READ_ONLY).resolve(Boolean.class)).booleanValue()) {
                        return new ForReturnValue(inDefinedShape.getType(), loadable);
                    }
                    throw new IllegalStateException(
                            "Cannot write return value for " + inDefinedShape + " in read-only context");
                }
            }

            public ForReturnValue(TypeDescription.Generic generic, AnnotationDescription.Loadable<Return> loadable) {
                this(generic,
                        ((Boolean) loadable.getValue(Factory.RETURN_READ_ONLY).resolve(Boolean.class)).booleanValue(),
                        (Assigner.Typing) ((EnumerationDescription) loadable.getValue(Factory.RETURN_TYPING)
                                .resolve(EnumerationDescription.class)).load(Assigner.Typing.class));
            }

            public boolean equals(@MaybeNull Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || getClass() != obj.getClass()) {
                    return false;
                }
                ForReturnValue forReturnValue = (ForReturnValue) obj;
                return this.readOnly == forReturnValue.readOnly && this.typing.equals(forReturnValue.typing)
                        && this.target.equals(forReturnValue.target);
            }

            public int hashCode() {
                return this.typing.hashCode()
                        + ((StaticHelpers6.e(this.target, getClass().hashCode() * 31, 31) + (this.readOnly ? 1 : 0)) * 31);
            }

            @Override // net.bytebuddy.asm.Advice.OffsetMapping
            public Target resolve(TypeDescription typeDescription, MethodDescription methodDescription,
                    Assigner assigner, ArgumentHandler argumentHandler, Sort sort) {
                StackManipulation stackManipulationAssign = assigner.assign(methodDescription.getReturnType(),
                        this.target, this.typing);
                if (!stackManipulationAssign.isValid()) {
                    throw new IllegalStateException(
                            "Cannot assign " + methodDescription.getReturnType() + " to " + this.target);
                }
                boolean z = this.readOnly;
                Class cls = Void.TYPE;
                if (z) {
                    return methodDescription.getReturnType().represents(cls)
                            ? new Target.ForDefaultValue.ReadOnly(this.target)
                            : new Target.ForVariable.ReadOnly(methodDescription.getReturnType(),
                                    argumentHandler.returned(), stackManipulationAssign);
                }
                StackManipulation stackManipulationAssign2 = assigner.assign(this.target,
                        methodDescription.getReturnType(), this.typing);
                if (stackManipulationAssign2.isValid()) {
                    return methodDescription.getReturnType().represents(cls)
                            ? new Target.ForDefaultValue.ReadWrite(this.target)
                            : new Target.ForVariable.ReadWrite(methodDescription.getReturnType(),
                                    argumentHandler.returned(), stackManipulationAssign, stackManipulationAssign2);
                }
                throw new IllegalStateException(
                        "Cannot assign " + this.target + " to " + methodDescription.getReturnType());
            }

            public ForReturnValue(TypeDescription.Generic generic, boolean z, Assigner.Typing typing) {
                this.target = generic;
                this.readOnly = z;
                this.typing = typing;
            }
        }

        /*
         * JADX INFO: compiled from:
         * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
         */
        @HashCodeAndEqualsPlugin.Enhance
        public static class ForThrowable implements OffsetMapping {
            private final boolean readOnly;
            private final TypeDescription.Generic target;
            private final Assigner.Typing typing;

            /*
             * JADX INFO: compiled from:
             * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
             */
            public enum Factory implements Factory<Thrown> {
                INSTANCE;

                private static final MethodDescription.InDefinedShape THROWN_READ_ONLY;
                private static final MethodDescription.InDefinedShape THROWN_TYPING;

                static {
                    MethodList<MethodDescription.InDefinedShape> declaredMethods = TypeDescription.ForLoadedType
                            .of(Thrown.class).getDeclaredMethods();
                    THROWN_READ_ONLY = (MethodDescription.InDefinedShape) declaredMethods
                            .filter(ElementMatchers.named("readOnly")).getOnly();
                    THROWN_TYPING = (MethodDescription.InDefinedShape) declaredMethods
                            .filter(ElementMatchers.named("typing")).getOnly();
                }

                public static Factory<?> of(MethodDescription.InDefinedShape inDefinedShape) {
                    return ((TypeDescription) inDefinedShape.getDeclaredAnnotations().ofType(OnMethodExit.class)
                            .getValue(Advice.ON_THROWABLE).resolve(TypeDescription.class))
                            .represents(NoExceptionHandler.class) ? new Factory.Illegal(Thrown.class) : INSTANCE;
                }

                @Override // net.bytebuddy.asm.Advice.OffsetMapping.Factory
                public Class<Thrown> getAnnotationType() {
                    return Thrown.class;
                }

                @Override // net.bytebuddy.asm.Advice.OffsetMapping.Factory
                public OffsetMapping make(ParameterDescription.InDefinedShape inDefinedShape,
                        AnnotationDescription.Loadable<Thrown> loadable, Factory.AdviceType adviceType) {
                    if (!adviceType.isDelegation()
                            || ((Boolean) loadable.getValue(THROWN_READ_ONLY).resolve(Boolean.class)).booleanValue()) {
                        return new ForThrowable(inDefinedShape.getType(), loadable);
                    }
                    throw new IllegalStateException(
                            "Cannot use writable " + inDefinedShape + " on read-only parameter");
                }
            }

            public ForThrowable(TypeDescription.Generic generic, AnnotationDescription.Loadable<Thrown> loadable) {
                this(generic,
                        ((Boolean) loadable.getValue(Factory.THROWN_READ_ONLY).resolve(Boolean.class)).booleanValue(),
                        (Assigner.Typing) ((EnumerationDescription) loadable.getValue(Factory.THROWN_TYPING)
                                .resolve(EnumerationDescription.class)).load(Assigner.Typing.class));
            }

            public boolean equals(@MaybeNull Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || getClass() != obj.getClass()) {
                    return false;
                }
                ForThrowable forThrowable = (ForThrowable) obj;
                return this.readOnly == forThrowable.readOnly && this.typing.equals(forThrowable.typing)
                        && this.target.equals(forThrowable.target);
            }

            public int hashCode() {
                return this.typing.hashCode()
                        + ((StaticHelpers6.e(this.target, getClass().hashCode() * 31, 31) + (this.readOnly ? 1 : 0)) * 31);
            }

            @Override // net.bytebuddy.asm.Advice.OffsetMapping
            public Target resolve(TypeDescription typeDescription, MethodDescription methodDescription,
                    Assigner assigner, ArgumentHandler argumentHandler, Sort sort) {
                StackManipulation stackManipulationAssign = assigner.assign(
                        TypeDescription.ForLoadedType.of(Throwable.class).asGenericType(), this.target, this.typing);
                if (!stackManipulationAssign.isValid()) {
                    throw new IllegalStateException("Cannot assign Throwable to " + this.target);
                }
                if (this.readOnly) {
                    return new Target.ForVariable.ReadOnly(TypeDescription.ForLoadedType.of(Throwable.class),
                            argumentHandler.thrown(), stackManipulationAssign);
                }
                StackManipulation stackManipulationAssign2 = assigner.assign(this.target,
                        TypeDescription.ForLoadedType.of(Throwable.class).asGenericType(), this.typing);
                if (stackManipulationAssign2.isValid()) {
                    return new Target.ForVariable.ReadWrite(TypeDescription.ForLoadedType.of(Throwable.class),
                            argumentHandler.thrown(), stackManipulationAssign, stackManipulationAssign2);
                }
                throw new IllegalStateException("Cannot assign " + this.target + " to Throwable");
            }

            public ForThrowable(TypeDescription.Generic generic, boolean z, Assigner.Typing typing) {
                this.target = generic;
                this.readOnly = z;
                this.typing = typing;
            }
        }

        /*
         * JADX INFO: compiled from:
         * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
         */
        @HashCodeAndEqualsPlugin.Enhance
        public static class ForThisReference implements OffsetMapping {
            private final boolean optional;
            private final boolean readOnly;
            private final TypeDescription.Generic target;
            private final Assigner.Typing typing;

            /*
             * JADX INFO: compiled from:
             * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
             */
            public enum Factory implements Factory<This> {
                INSTANCE;

                private static final MethodDescription.InDefinedShape THIS_OPTIONAL;
                private static final MethodDescription.InDefinedShape THIS_READ_ONLY;
                private static final MethodDescription.InDefinedShape THIS_TYPING;

                static {
                    MethodList<MethodDescription.InDefinedShape> declaredMethods = TypeDescription.ForLoadedType
                            .of(This.class).getDeclaredMethods();
                    THIS_READ_ONLY = (MethodDescription.InDefinedShape) declaredMethods
                            .filter(ElementMatchers.named("readOnly")).getOnly();
                    THIS_TYPING = (MethodDescription.InDefinedShape) declaredMethods
                            .filter(ElementMatchers.named("typing")).getOnly();
                    THIS_OPTIONAL = (MethodDescription.InDefinedShape) declaredMethods
                            .filter(ElementMatchers.named("optional")).getOnly();
                }

                @Override // net.bytebuddy.asm.Advice.OffsetMapping.Factory
                public Class<This> getAnnotationType() {
                    return This.class;
                }

                @Override // net.bytebuddy.asm.Advice.OffsetMapping.Factory
                public OffsetMapping make(ParameterDescription.InDefinedShape inDefinedShape,
                        AnnotationDescription.Loadable<This> loadable, Factory.AdviceType adviceType) {
                    if (!adviceType.isDelegation()
                            || ((Boolean) loadable.getValue(THIS_READ_ONLY).resolve(Boolean.class)).booleanValue()) {
                        return new ForThisReference(inDefinedShape.getType(), loadable);
                    }
                    throw new IllegalStateException(
                            "Cannot write to this reference for " + inDefinedShape + " in read-only context");
                }
            }

            public ForThisReference(TypeDescription.Generic generic, AnnotationDescription.Loadable<This> loadable) {
                this(generic,
                        ((Boolean) loadable.getValue(Factory.THIS_READ_ONLY).resolve(Boolean.class)).booleanValue(),
                        (Assigner.Typing) ((EnumerationDescription) loadable.getValue(Factory.THIS_TYPING)
                                .resolve(EnumerationDescription.class)).load(Assigner.Typing.class),
                        ((Boolean) loadable.getValue(Factory.THIS_OPTIONAL).resolve(Boolean.class)).booleanValue());
            }

            public boolean equals(@MaybeNull Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || getClass() != obj.getClass()) {
                    return false;
                }
                ForThisReference forThisReference = (ForThisReference) obj;
                return this.readOnly == forThisReference.readOnly && this.optional == forThisReference.optional
                        && this.typing.equals(forThisReference.typing) && this.target.equals(forThisReference.target);
            }

            public int hashCode() {
                return ((this.typing.hashCode()
                        + ((StaticHelpers6.e(this.target, getClass().hashCode() * 31, 31) + (this.readOnly ? 1 : 0)) * 31)) * 31)
                        + (this.optional ? 1 : 0);
            }

            @Override // net.bytebuddy.asm.Advice.OffsetMapping
            public Target resolve(TypeDescription typeDescription, MethodDescription methodDescription,
                    Assigner assigner, ArgumentHandler argumentHandler, Sort sort) {
                if (methodDescription.isStatic() || sort.isPremature(methodDescription)) {
                    if (this.optional) {
                        return this.readOnly ? new Target.ForDefaultValue.ReadOnly(typeDescription)
                                : new Target.ForDefaultValue.ReadWrite(typeDescription);
                    }
                    throw new IllegalStateException(StaticHelpers6.concat(
                            "Cannot map this reference for static method or constructor start: ", methodDescription));
                }
                StackManipulation stackManipulationAssign = assigner.assign(typeDescription.asGenericType(),
                        this.target, this.typing);
                if (!stackManipulationAssign.isValid()) {
                    throw new IllegalStateException("Cannot assign " + typeDescription + " to " + this.target);
                }
                if (this.readOnly) {
                    return new Target.ForVariable.ReadOnly(typeDescription.asGenericType(), argumentHandler.argument(0),
                            stackManipulationAssign);
                }
                StackManipulation stackManipulationAssign2 = assigner.assign(this.target,
                        typeDescription.asGenericType(), this.typing);
                if (stackManipulationAssign2.isValid()) {
                    return new Target.ForVariable.ReadWrite(typeDescription.asGenericType(),
                            argumentHandler.argument(0), stackManipulationAssign, stackManipulationAssign2);
                }
                throw new IllegalStateException("Cannot assign " + this.target + " to " + typeDescription);
            }

            public ForThisReference(TypeDescription.Generic generic, boolean z, Assigner.Typing typing, boolean z2) {
                this.target = generic;
                this.readOnly = z;
                this.typing = typing;
                this.optional = z2;
            }
        }

        /*
         * JADX INFO: compiled from:
         * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
         */
        @HashCodeAndEqualsPlugin.Enhance
        public static class ForAllArguments implements OffsetMapping {
            private final boolean includeSelf;
            private final boolean nullIfEmpty;
            private final boolean readOnly;
            private final TypeDescription.Generic target;
            private final Assigner.Typing typing;

            /*
             * JADX INFO: compiled from:
             * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
             */
            public enum Factory implements Factory<AllArguments> {
                INSTANCE;

                private static final MethodDescription.InDefinedShape ALL_ARGUMENTS_INCLUDE_SELF;
                private static final MethodDescription.InDefinedShape ALL_ARGUMENTS_NULL_IF_EMPTY;
                private static final MethodDescription.InDefinedShape ALL_ARGUMENTS_READ_ONLY;
                private static final MethodDescription.InDefinedShape ALL_ARGUMENTS_TYPING;

                static {
                    MethodList<MethodDescription.InDefinedShape> declaredMethods = TypeDescription.ForLoadedType
                            .of(AllArguments.class).getDeclaredMethods();
                    ALL_ARGUMENTS_READ_ONLY = (MethodDescription.InDefinedShape) declaredMethods
                            .filter(ElementMatchers.named("readOnly")).getOnly();
                    ALL_ARGUMENTS_TYPING = (MethodDescription.InDefinedShape) declaredMethods
                            .filter(ElementMatchers.named("typing")).getOnly();
                    ALL_ARGUMENTS_INCLUDE_SELF = (MethodDescription.InDefinedShape) declaredMethods
                            .filter(ElementMatchers.named("includeSelf")).getOnly();
                    ALL_ARGUMENTS_NULL_IF_EMPTY = (MethodDescription.InDefinedShape) declaredMethods
                            .filter(ElementMatchers.named("nullIfEmpty")).getOnly();
                }

                @Override // net.bytebuddy.asm.Advice.OffsetMapping.Factory
                public Class<AllArguments> getAnnotationType() {
                    return AllArguments.class;
                }

                @Override // net.bytebuddy.asm.Advice.OffsetMapping.Factory
                public OffsetMapping make(ParameterDescription.InDefinedShape inDefinedShape,
                        AnnotationDescription.Loadable<AllArguments> loadable, Factory.AdviceType adviceType) {
                    if (!inDefinedShape.getType().represents(Object.class) && !inDefinedShape.getType().isArray()) {
                        throw new IllegalStateException("Cannot use AllArguments annotation on a non-array type");
                    }
                    if (!adviceType.isDelegation()
                            || ((Boolean) loadable.getValue(ALL_ARGUMENTS_READ_ONLY).resolve(Boolean.class))
                                    .booleanValue()) {
                        return new ForAllArguments(inDefinedShape.getType().represents(Object.class)
                                ? TypeDescription.Generic.OfNonGenericType.ForLoadedType.of(Object.class)
                                : inDefinedShape.getType().getComponentType(), loadable);
                    }
                    throw new IllegalStateException("Cannot define writable field access for " + inDefinedShape);
                }
            }

            public ForAllArguments(TypeDescription.Generic generic,
                    AnnotationDescription.Loadable<AllArguments> loadable) {
                this(generic,
                        ((Boolean) loadable.getValue(Factory.ALL_ARGUMENTS_READ_ONLY).resolve(Boolean.class))
                                .booleanValue(),
                        (Assigner.Typing) ((EnumerationDescription) loadable.getValue(Factory.ALL_ARGUMENTS_TYPING)
                                .resolve(EnumerationDescription.class)).load(Assigner.Typing.class),
                        ((Boolean) loadable.getValue(Factory.ALL_ARGUMENTS_INCLUDE_SELF).resolve(Boolean.class))
                                .booleanValue(),
                        ((Boolean) loadable.getValue(Factory.ALL_ARGUMENTS_NULL_IF_EMPTY).resolve(Boolean.class))
                                .booleanValue());
            }

            public boolean equals(@MaybeNull Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || getClass() != obj.getClass()) {
                    return false;
                }
                ForAllArguments forAllArguments = (ForAllArguments) obj;
                return this.readOnly == forAllArguments.readOnly && this.includeSelf == forAllArguments.includeSelf
                        && this.nullIfEmpty == forAllArguments.nullIfEmpty && this.typing.equals(forAllArguments.typing)
                        && this.target.equals(forAllArguments.target);
            }

            public int hashCode() {
                return ((((this.typing.hashCode()
                        + ((StaticHelpers6.e(this.target, getClass().hashCode() * 31, 31) + (this.readOnly ? 1 : 0)) * 31)) * 31)
                        + (this.includeSelf ? 1 : 0)) * 31) + (this.nullIfEmpty ? 1 : 0);
            }

            @Override // net.bytebuddy.asm.Advice.OffsetMapping
            public Target resolve(TypeDescription typeDescription, MethodDescription methodDescription,
                    Assigner assigner, ArgumentHandler argumentHandler, Sort sort) {
                if (this.nullIfEmpty && methodDescription.getParameters().isEmpty()
                        && (!this.includeSelf || methodDescription.isStatic())) {
                    return this.readOnly ? new Target.ForStackManipulation(NullConstant.INSTANCE)
                            : new Target.ForStackManipulation.Writable(NullConstant.INSTANCE, Removal.SINGLE);
                }
                ArrayList arrayList = new ArrayList(methodDescription.getParameters().size()
                        + ((!this.includeSelf || methodDescription.isStatic()) ? 0 : 1));
                if (this.includeSelf && !methodDescription.isStatic()) {
                    if (sort.isPremature(methodDescription) && methodDescription.isConstructor()) {
                        throw new IllegalStateException(
                                StaticHelpers6.concat("Cannot include self in all arguments array from ", methodDescription));
                    }
                    StackManipulation stackManipulationAssign = assigner
                            .assign(methodDescription.getDeclaringType().asGenericType(), this.target, this.typing);
                    if (!stackManipulationAssign.isValid()) {
                        throw new IllegalStateException(
                                "Cannot assign " + methodDescription.getDeclaringType() + " to " + this.target);
                    }
                    arrayList.add(new StackManipulation.Compound(
                            MethodVariableAccess.REFERENCE.loadFrom(argumentHandler.argument(0)),
                            stackManipulationAssign));
                }
                Iterator<?> it = methodDescription.getParameters().iterator();
                while (it.hasNext()) {
                    ParameterDescription parameterDescription = (ParameterDescription) it.next();
                    StackManipulation stackManipulationAssign2 = assigner.assign(parameterDescription.getType(),
                            this.target, this.typing);
                    if (!stackManipulationAssign2.isValid()) {
                        throw new IllegalStateException("Cannot assign " + parameterDescription + " to " + this.target);
                    }
                    arrayList.add(new StackManipulation.Compound(
                            MethodVariableAccess.of(parameterDescription.getType())
                                    .loadFrom(argumentHandler.argument(parameterDescription.getOffset())),
                            stackManipulationAssign2));
                }
                if (this.readOnly) {
                    return new Target.ForArray.ReadOnly(this.target, arrayList);
                }
                ArrayList arrayList2 = new ArrayList((methodDescription.getParameters().size()
                        + ((!this.includeSelf || methodDescription.isStatic()) ? 0 : 1)) * 2);
                if (this.includeSelf && !methodDescription.isStatic()) {
                    StackManipulation stackManipulationAssign3 = assigner.assign(this.target,
                            methodDescription.getDeclaringType().asGenericType(), this.typing);
                    if (!stackManipulationAssign3.isValid()) {
                        throw new IllegalStateException(
                                "Cannot assign " + this.target + " to " + methodDescription.getDeclaringType());
                    }
                    arrayList2.add(new StackManipulation.Compound(stackManipulationAssign3,
                            MethodVariableAccess.REFERENCE.storeAt(argumentHandler.argument(0))));
                }
                Iterator<?> it2 = methodDescription.getParameters().iterator();
                while (it2.hasNext()) {
                    ParameterDescription parameterDescription2 = (ParameterDescription) it2.next();
                    StackManipulation stackManipulationAssign4 = assigner.assign(this.target,
                            parameterDescription2.getType(), this.typing);
                    if (!stackManipulationAssign4.isValid()) {
                        throw new IllegalStateException(
                                "Cannot assign " + this.target + " to " + parameterDescription2);
                    }
                    arrayList2.add(new StackManipulation.Compound(stackManipulationAssign4,
                            MethodVariableAccess.of(parameterDescription2.getType())
                                    .storeAt(argumentHandler.argument(parameterDescription2.getOffset()))));
                }
                return new Target.ForArray.ReadWrite(this.target, arrayList, arrayList2);
            }

            public ForAllArguments(TypeDescription.Generic generic, boolean z, Assigner.Typing typing, boolean z2,
                    boolean z3) {
                this.target = generic;
                this.readOnly = z;
                this.typing = typing;
                this.includeSelf = z2;
                this.nullIfEmpty = z3;
            }
        }
    }

    /*
     * JADX INFO: compiled from:
     * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
     */
    public static final class OnDefaultValue {
        private OnDefaultValue() {
            throw new UnsupportedOperationException(
                    "This class only serves as a marker type and should not be instantiated");
        }
    }

    /*
     * JADX INFO: compiled from:
     * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
     */
    @Target({ ElementType.METHOD })
    @Documented
    @Retention(RetentionPolicy.RUNTIME)
    public @interface OnMethodEnter {
        boolean inline() default true;

        boolean prependLineNumber() default true;

        Class<?> skipOn() default void.class;

        int skipOnIndex() default -1;

        Class<? extends Throwable> suppress() default NoExceptionHandler.class;
    }

    /*
     * JADX INFO: compiled from:
     * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
     */
    @Target({ ElementType.METHOD })
    @Documented
    @Retention(RetentionPolicy.RUNTIME)
    public @interface OnMethodExit {
        boolean backupArguments() default true;

        boolean inline() default true;

        Class<? extends Throwable> onThrowable() default NoExceptionHandler.class;

        Class<?> repeatOn() default void.class;

        int repeatOnIndex() default -1;

        Class<? extends Throwable> suppress() default NoExceptionHandler.class;
    }

    /*
     * JADX INFO: compiled from:
     * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
     */
    public static final class OnNonDefaultValue {
        private OnNonDefaultValue() {
            throw new UnsupportedOperationException(
                    "This class only serves as a marker type and should not be instantiated");
        }
    }

    /*
     * JADX INFO: compiled from:
     * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
     */
    @Target({ ElementType.PARAMETER })
    @Documented
    @Retention(RetentionPolicy.RUNTIME)
    public @interface Origin {
        public static final String DEFAULT = "";

        String value() default "";
    }

    /*
     * JADX INFO: compiled from:
     * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
     */
    public interface PostProcessor {

        /*
         * JADX INFO: compiled from:
         * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
         */
        @HashCodeAndEqualsPlugin.Enhance
        public static class Compound implements PostProcessor {
            private final List<PostProcessor> postProcessors;

            public Compound(List<PostProcessor> list) {
                this.postProcessors = list;
            }

            public boolean equals(@MaybeNull Object obj) {
                if (this == obj) {
                    return true;
                }
                return obj != null && getClass() == obj.getClass()
                        && this.postProcessors.equals(((Compound) obj).postProcessors);
            }

            public int hashCode() {
                return this.postProcessors.hashCode() + (getClass().hashCode() * 31);
            }

            @Override // net.bytebuddy.asm.Advice.PostProcessor
            public StackManipulation resolve(TypeDescription typeDescription, MethodDescription methodDescription,
                    Assigner assigner, ArgumentHandler argumentHandler,
                    StackMapFrameHandler.ForPostProcessor forPostProcessor, StackManipulation stackManipulation) {
                ArrayList arrayList = new ArrayList(this.postProcessors.size());
                Iterator<PostProcessor> it = this.postProcessors.iterator();
                while (it.hasNext()) {
                    arrayList.add(it.next().resolve(typeDescription, methodDescription, assigner, argumentHandler,
                            forPostProcessor, stackManipulation));
                }
                return new StackManipulation.Compound(arrayList);
            }
        }

        /*
         * JADX INFO: compiled from:
         * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
         */
        public interface Factory {

            /*
             * JADX INFO: compiled from:
             * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
             */
            @HashCodeAndEqualsPlugin.Enhance
            public static class Compound implements Factory {
                private final List<Factory> factories;

                public Compound(Factory... factoryArr) {
                    this((List<? extends Factory>) Arrays.asList(factoryArr));
                }

                public boolean equals(@MaybeNull Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    return obj != null && getClass() == obj.getClass()
                            && this.factories.equals(((Compound) obj).factories);
                }

                public int hashCode() {
                    return this.factories.hashCode() + (getClass().hashCode() * 31);
                }

                @Override // net.bytebuddy.asm.Advice.PostProcessor.Factory
                public PostProcessor make(List<? extends AnnotationDescription> list, TypeDescription typeDescription,
                        boolean z) {
                    ArrayList arrayList = new ArrayList(this.factories.size());
                    Iterator<Factory> it = this.factories.iterator();
                    while (it.hasNext()) {
                        arrayList.add(it.next().make(list, typeDescription, z));
                    }
                    return new Compound(arrayList);
                }

                public Compound(List<? extends Factory> list) {
                    this.factories = new ArrayList();
                    for (Factory factory : list) {
                        if (factory instanceof Compound) {
                            this.factories.addAll(((Compound) factory).factories);
                        } else if (!(factory instanceof NoOp)) {
                            this.factories.add(factory);
                        }
                    }
                }
            }

            PostProcessor make(List<? extends AnnotationDescription> list, TypeDescription typeDescription, boolean z);
        }

        /*
         * JADX INFO: compiled from:
         * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
         */
        public enum NoOp implements PostProcessor, Factory {
            INSTANCE;

            @Override // net.bytebuddy.asm.Advice.PostProcessor.Factory
            public PostProcessor make(List<? extends AnnotationDescription> list, TypeDescription typeDescription,
                    boolean z) {
                return this;
            }

            @Override // net.bytebuddy.asm.Advice.PostProcessor
            public StackManipulation resolve(TypeDescription typeDescription, MethodDescription methodDescription,
                    Assigner assigner, ArgumentHandler argumentHandler,
                    StackMapFrameHandler.ForPostProcessor forPostProcessor, StackManipulation stackManipulation) {
                return StackManipulation.Trivial.INSTANCE;
            }
        }

        StackManipulation resolve(TypeDescription typeDescription, MethodDescription methodDescription,
                Assigner assigner, ArgumentHandler argumentHandler,
                StackMapFrameHandler.ForPostProcessor forPostProcessor, StackManipulation stackManipulation);
    }

    /*
     * JADX INFO: compiled from:
     * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
     */
    @Target({ ElementType.PARAMETER })
    @Documented
    @Retention(RetentionPolicy.RUNTIME)
    public @interface Return {
        boolean readOnly() default true;

        Assigner.Typing typing() default Assigner.Typing.STATIC;
    }

    /*
     * JADX INFO: compiled from:
     * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
     */
    @Target({ ElementType.PARAMETER })
    @Documented
    @Retention(RetentionPolicy.RUNTIME)
    public @interface SelfCallHandle {
        boolean bound() default true;
    }

    /*
     * JADX INFO: compiled from:
     * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
     */
    public interface StackMapFrameHandler {

        /*
         * JADX INFO: compiled from:
         * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
         */
        public static abstract class Default implements ForInstrumentedMethod {
            protected static final Object[] EMPTY = new Object[0];
            protected int currentFrameDivergence;
            protected final boolean expandFrames;
            protected final List<? extends TypeDescription> initialTypes;
            protected final MethodDescription instrumentedMethod;
            protected final TypeDescription instrumentedType;
            protected final List<? extends TypeDescription> latentTypes;
            protected final List<? extends TypeDescription> postMethodTypes;
            protected final List<? extends TypeDescription> preMethodTypes;

            /*
             * JADX INFO: compiled from:
             * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
             */
            public class ForAdvice implements ForAdvice {
                protected final List<? extends TypeDescription> endTypes;
                private final Initialization initialization;
                private boolean intermediate = false;
                private final List<? extends TypeDescription> intermediateTypes;
                protected final List<? extends TypeDescription> startTypes;
                protected final TranslationMode translationMode;
                protected final MethodDescription.TypeToken typeToken;

                public ForAdvice(MethodDescription.TypeToken typeToken, List<? extends TypeDescription> list,
                        List<? extends TypeDescription> list2, List<? extends TypeDescription> list3,
                        TranslationMode translationMode, Initialization initialization) {
                    this.typeToken = typeToken;
                    this.startTypes = list;
                    this.intermediateTypes = list2;
                    this.endTypes = list3;
                    this.translationMode = translationMode;
                    this.initialization = initialization;
                }

                @Override // net.bytebuddy.asm.Advice.StackMapFrameHandler
                public void injectCompletionFrame(MethodVisitor methodVisitor) {
                    Default r0 = Default.this;
                    if (r0.expandFrames) {
                        r0.injectFullFrame(methodVisitor, this.initialization,
                                CompoundList.of((List) this.startTypes, (List) this.endTypes), Collections.EMPTY_LIST);
                        return;
                    }
                    int i = 0;
                    if (r0.currentFrameDivergence != 0 || (!this.intermediate && this.endTypes.size() >= 4)) {
                        if (Default.this.currentFrameDivergence >= 3 || !this.endTypes.isEmpty()) {
                            Default.this.injectFullFrame(methodVisitor, this.initialization,
                                    CompoundList.of((List) this.startTypes, (List) this.endTypes),
                                    Collections.EMPTY_LIST);
                            return;
                        }
                        int i2 = Default.this.currentFrameDivergence;
                        Object[] objArr = Default.EMPTY;
                        methodVisitor.visitFrame(2, i2, objArr, objArr.length, objArr);
                        Default.this.currentFrameDivergence = 0;
                        return;
                    }
                    if (this.intermediate || this.endTypes.isEmpty()) {
                        Object[] objArr2 = Default.EMPTY;
                        methodVisitor.visitFrame(3, objArr2.length, objArr2, objArr2.length, objArr2);
                        return;
                    }
                    int size = this.endTypes.size();
                    Object[] objArr3 = new Object[size];
                    Iterator<? extends TypeDescription> it = this.endTypes.iterator();
                    while (it.hasNext()) {
                        objArr3[i] = Initialization.INITIALIZED.toFrame(it.next());
                        i++;
                    }
                    Object[] objArr4 = Default.EMPTY;
                    methodVisitor.visitFrame(1, size, objArr3, objArr4.length, objArr4);
                }

                @Override // net.bytebuddy.asm.Advice.StackMapFrameHandler
                public void injectExceptionFrame(MethodVisitor methodVisitor) {
                    Default r0 = Default.this;
                    if (r0.expandFrames || r0.currentFrameDivergence != 0) {
                        r0.injectFullFrame(methodVisitor, this.initialization, this.startTypes,
                                Collections.singletonList(TypeDescription.ForLoadedType.of(Throwable.class)));
                    } else {
                        Object[] objArr = Default.EMPTY;
                        methodVisitor.visitFrame(4, objArr.length, objArr, 1,
                                new Object[] { Type.getInternalName(Throwable.class) });
                    }
                }

                @Override // net.bytebuddy.asm.Advice.StackMapFrameHandler.ForPostProcessor
                public void injectIntermediateFrame(MethodVisitor methodVisitor, List<? extends TypeDescription> list) {
                    Default r2 = Default.this;
                    if (r2.expandFrames) {
                        r2.injectFullFrame(methodVisitor, this.initialization,
                                CompoundList.of((List) this.startTypes, (List) this.intermediateTypes), list);
                    } else {
                        int i = 0;
                        if (!this.intermediate || list.size() >= 2) {
                            if (Default.this.currentFrameDivergence != 0 || this.intermediateTypes.size() >= 4
                                    || (!list.isEmpty() && (list.size() >= 2 || !this.intermediateTypes.isEmpty()))) {
                                if (Default.this.currentFrameDivergence < 3 && this.intermediateTypes.isEmpty()
                                        && list.isEmpty()) {
                                    int i2 = Default.this.currentFrameDivergence;
                                    Object[] objArr = Default.EMPTY;
                                    methodVisitor.visitFrame(2, i2, objArr, objArr.length, objArr);
                                } else {
                                    Default.this.injectFullFrame(methodVisitor, this.initialization,
                                            CompoundList.of((List) this.startTypes, (List) this.intermediateTypes),
                                            list);
                                }
                            } else if (!this.intermediateTypes.isEmpty()) {
                                int size = this.intermediateTypes.size();
                                Object[] objArr2 = new Object[size];
                                Iterator<? extends TypeDescription> it = this.intermediateTypes.iterator();
                                while (it.hasNext()) {
                                    objArr2[i] = Initialization.INITIALIZED.toFrame(it.next());
                                    i++;
                                }
                                Object[] objArr3 = Default.EMPTY;
                                methodVisitor.visitFrame(1, size, objArr2, objArr3.length, objArr3);
                            } else if (list.isEmpty()) {
                                Object[] objArr4 = Default.EMPTY;
                                methodVisitor.visitFrame(3, objArr4.length, objArr4, objArr4.length, objArr4);
                            } else {
                                Object[] objArr5 = Default.EMPTY;
                                methodVisitor.visitFrame(4, objArr5.length, objArr5, 1,
                                        new Object[] { Initialization.INITIALIZED.toFrame(list.get(0)) });
                            }
                        } else if (list.isEmpty()) {
                            Object[] objArr6 = Default.EMPTY;
                            methodVisitor.visitFrame(3, objArr6.length, objArr6, objArr6.length, objArr6);
                        } else {
                            Object[] objArr7 = Default.EMPTY;
                            methodVisitor.visitFrame(4, objArr7.length, objArr7, 1,
                                    new Object[] { Initialization.INITIALIZED.toFrame(list.get(0)) });
                        }
                    }
                    Default.this.currentFrameDivergence = this.intermediateTypes.size() - this.endTypes.size();
                    this.intermediate = true;
                }

                @Override // net.bytebuddy.asm.Advice.StackMapFrameHandler
                public void injectReturnFrame(MethodVisitor methodVisitor) {
                    Default r0 = Default.this;
                    boolean z = r0.expandFrames;
                    Class cls = Void.TYPE;
                    if (z || r0.currentFrameDivergence != 0) {
                        r0.injectFullFrame(methodVisitor, this.initialization, this.startTypes,
                                this.typeToken.getReturnType().represents(cls) ? Collections.EMPTY_LIST
                                        : Collections.singletonList(this.typeToken.getReturnType()));
                    } else if (this.typeToken.getReturnType().represents(cls)) {
                        Object[] objArr = Default.EMPTY;
                        methodVisitor.visitFrame(3, objArr.length, objArr, objArr.length, objArr);
                    } else {
                        Object[] objArr2 = Default.EMPTY;
                        methodVisitor.visitFrame(4, objArr2.length, objArr2, 1,
                                new Object[] { Initialization.INITIALIZED.toFrame(this.typeToken.getReturnType()) });
                    }
                }

                @Override // net.bytebuddy.asm.Advice.StackMapFrameHandler
                public void translateFrame(MethodVisitor methodVisitor, int i, int i2, @MaybeNull Object[] objArr,
                        int i3, @MaybeNull Object[] objArr2) {
                    Default.this.translateFrame(methodVisitor, this.translationMode, true, this.typeToken,
                            this.startTypes, i, i2, objArr, i3, objArr2);
                }
            }

            /*
             * JADX INFO: compiled from:
             * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
             */
            public enum Initialization {
                UNITIALIZED { // from class:
                              // net.bytebuddy.asm.Advice.StackMapFrameHandler.Default.Initialization.1
                    @Override // net.bytebuddy.asm.Advice.StackMapFrameHandler.Default.Initialization
                    public Object toFrame(TypeDescription typeDescription) {
                        if (typeDescription.isPrimitive()) {
                            throw new IllegalArgumentException(
                                    StaticHelpers6.concat("Cannot assume primitive uninitialized value: ", typeDescription));
                        }
                        return Opcodes.UNINITIALIZED_THIS;
                    }
                },
                INITIALIZED { // from class:
                              // net.bytebuddy.asm.Advice.StackMapFrameHandler.Default.Initialization.2
                    @Override // net.bytebuddy.asm.Advice.StackMapFrameHandler.Default.Initialization
                    public Object toFrame(TypeDescription typeDescription) {
                        return (typeDescription.represents(Boolean.TYPE) || typeDescription.represents(Byte.TYPE)
                                || typeDescription.represents(Short.TYPE) || typeDescription.represents(Character.TYPE)
                                || typeDescription.represents(Integer.TYPE))
                                        ? Opcodes.INTEGER
                                        : typeDescription.represents(Long.TYPE) ? Opcodes.LONG
                                                : typeDescription.represents(Float.TYPE) ? Opcodes.FLOAT
                                                        : typeDescription.represents(Double.TYPE) ? Opcodes.DOUBLE
                                                                : typeDescription.getInternalName();
                    }
                };

                public abstract Object toFrame(TypeDescription typeDescription);
            }

            /*
             * JADX INFO: compiled from:
             * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
             */
            public enum TranslationMode {
                COPY { // from class:
                       // net.bytebuddy.asm.Advice.StackMapFrameHandler.Default.TranslationMode.1
                    @Override // net.bytebuddy.asm.Advice.StackMapFrameHandler.Default.TranslationMode
                    public int copy(TypeDescription typeDescription, MethodDescription methodDescription,
                            Object[] objArr, Object[] objArr2) {
                        int size = methodDescription.getParameters().size() + (!methodDescription.isStatic() ? 1 : 0);
                        System.arraycopy(objArr, 0, objArr2, 0, size);
                        return size;
                    }

                    @Override // net.bytebuddy.asm.Advice.StackMapFrameHandler.Default.TranslationMode
                    public boolean isPossibleThisFrameValue(TypeDescription typeDescription,
                            MethodDescription methodDescription, Object obj) {
                        return (methodDescription.isConstructor() && Opcodes.UNINITIALIZED_THIS.equals(obj))
                                || Initialization.INITIALIZED.toFrame(typeDescription).equals(obj);
                    }
                },
                ENTER { // from class:
                        // net.bytebuddy.asm.Advice.StackMapFrameHandler.Default.TranslationMode.2
                    @Override // net.bytebuddy.asm.Advice.StackMapFrameHandler.Default.TranslationMode
                    public int copy(TypeDescription typeDescription, MethodDescription methodDescription,
                            Object[] objArr, Object[] objArr2) {
                        int i = 0;
                        if (!methodDescription.isStatic()) {
                            objArr2[0] = methodDescription.isConstructor() ? Opcodes.UNINITIALIZED_THIS
                                    : Initialization.INITIALIZED.toFrame(typeDescription);
                            i = 1;
                        }
                        Iterator<TypeDescription> it = methodDescription.getParameters().asTypeList().asErasures()
                                .iterator();
                        while (it.hasNext()) {
                            objArr2[i] = Initialization.INITIALIZED.toFrame(it.next());
                            i++;
                        }
                        return i;
                    }

                    @Override // net.bytebuddy.asm.Advice.StackMapFrameHandler.Default.TranslationMode
                    public boolean isPossibleThisFrameValue(TypeDescription typeDescription,
                            MethodDescription methodDescription, Object obj) {
                        return methodDescription.isConstructor() ? Opcodes.UNINITIALIZED_THIS.equals(obj)
                                : Initialization.INITIALIZED.toFrame(typeDescription).equals(obj);
                    }
                },
                EXIT { // from class:
                       // net.bytebuddy.asm.Advice.StackMapFrameHandler.Default.TranslationMode.3
                    @Override // net.bytebuddy.asm.Advice.StackMapFrameHandler.Default.TranslationMode
                    public int copy(TypeDescription typeDescription, MethodDescription methodDescription,
                            Object[] objArr, Object[] objArr2) {
                        int i = 0;
                        if (!methodDescription.isStatic()) {
                            objArr2[0] = Initialization.INITIALIZED.toFrame(typeDescription);
                            i = 1;
                        }
                        Iterator<TypeDescription> it = methodDescription.getParameters().asTypeList().asErasures()
                                .iterator();
                        while (it.hasNext()) {
                            objArr2[i] = Initialization.INITIALIZED.toFrame(it.next());
                            i++;
                        }
                        return i;
                    }

                    @Override // net.bytebuddy.asm.Advice.StackMapFrameHandler.Default.TranslationMode
                    public boolean isPossibleThisFrameValue(TypeDescription typeDescription,
                            MethodDescription methodDescription, Object obj) {
                        return Initialization.INITIALIZED.toFrame(typeDescription).equals(obj);
                    }
                };

                public abstract int copy(TypeDescription typeDescription, MethodDescription methodDescription,
                        Object[] objArr, Object[] objArr2);

                public abstract boolean isPossibleThisFrameValue(TypeDescription typeDescription,
                        MethodDescription methodDescription, Object obj);
            }

            /*
             * JADX INFO: compiled from:
             * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
             */
            public static class Trivial extends Default {
                /* JADX WARN: Illegal instructions before constructor call */
                public Trivial(TypeDescription typeDescription, MethodDescription methodDescription,
                        List<? extends TypeDescription> list, boolean z) {
                    List list2 = Collections.EMPTY_LIST;
                    super(typeDescription, methodDescription, list2, list, list2, list2, z);
                }

                @Override // net.bytebuddy.asm.Advice.StackMapFrameHandler.ForInstrumentedMethod
                public ForAdvice bindExit(MethodDescription.TypeToken typeToken) {
                    throw new IllegalStateException(
                            "Did not expect exit advice " + typeToken + " for " + this.instrumentedMethod);
                }

                @Override // net.bytebuddy.asm.Advice.StackMapFrameHandler
                public void injectCompletionFrame(MethodVisitor methodVisitor) {
                    throw new IllegalStateException("Did not expect completion frame for " + this.instrumentedMethod);
                }

                @Override // net.bytebuddy.asm.Advice.StackMapFrameHandler
                public void injectExceptionFrame(MethodVisitor methodVisitor) {
                    throw new IllegalStateException("Did not expect exception frame for " + this.instrumentedMethod);
                }

                @Override // net.bytebuddy.asm.Advice.StackMapFrameHandler.ForInstrumentedMethod
                public void injectInitializationFrame(MethodVisitor methodVisitor) {
                }

                @Override // net.bytebuddy.asm.Advice.StackMapFrameHandler.ForInstrumentedMethod
                public void injectPostCompletionFrame(MethodVisitor methodVisitor) {
                    throw new IllegalStateException(
                            "Did not expect post completion frame for " + this.instrumentedMethod);
                }

                @Override // net.bytebuddy.asm.Advice.StackMapFrameHandler
                public void injectReturnFrame(MethodVisitor methodVisitor) {
                    throw new IllegalStateException("Did not expect return frame for " + this.instrumentedMethod);
                }

                @Override // net.bytebuddy.asm.Advice.StackMapFrameHandler.ForInstrumentedMethod
                public void injectStartFrame(MethodVisitor methodVisitor) {
                }

                @Override // net.bytebuddy.asm.Advice.StackMapFrameHandler
                public void translateFrame(MethodVisitor methodVisitor, int i, int i2, @MaybeNull Object[] objArr,
                        int i3, @MaybeNull Object[] objArr2) {
                    methodVisitor.visitFrame(i, i2, objArr, i3, objArr2);
                }
            }

            /*
             * JADX INFO: compiled from:
             * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
             */
            public static abstract class WithPreservedArguments extends Default {
                protected boolean allowCompactCompletionFrame;

                /*
                 * JADX INFO: compiled from:
                 * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
                 */
                public static class WithArgumentCopy extends WithPreservedArguments {
                    public WithArgumentCopy(TypeDescription typeDescription, MethodDescription methodDescription,
                            List<? extends TypeDescription> list, List<? extends TypeDescription> list2,
                            List<? extends TypeDescription> list3, List<? extends TypeDescription> list4, boolean z) {
                        super(typeDescription, methodDescription, list, list2, list3, list4, z, true);
                    }

                    /*
                     * JADX WARN: Found duplicated region for block: B:20:0x007f A[LOOP:0:
                     * B:18:0x0079->B:20:0x007f, LOOP_END]
                     */
                    /* JADX WARN: Found duplicated region for block: B:22:0x009c */
                    /* JADX WARN: Found duplicated region for block: B:24:0x00a5 */
                    /* JADX WARN: Found duplicated region for block: B:25:0x00a7 */
                    /* JADX WARN: Found duplicated region for block: B:28:0x00cd */
                    /* JADX WARN: Found duplicated region for block: B:30:0x00d3 */
                    /* JADX WARN: Found duplicated region for block: B:32:0x00db */
                    /* JADX WARN: Found duplicated region for block: B:33:0x00e6 */
                    /*
                     * JADX WARN: Found duplicated region for block: B:37:0x00ff A[LOOP:1:
                     * B:35:0x00f9->B:37:0x00ff, LOOP_END]
                     */
                    /*
                     * JADX WARN: Found duplicated region for block: B:41:0x011d A[LOOP:2:
                     * B:39:0x0117->B:41:0x011d, LOOP_END]
                     */
                    /*
                     * JADX WARN: Found duplicated region for block: B:45:0x013b A[LOOP:3:
                     * B:43:0x0135->B:45:0x013b, LOOP_END]
                     */
                    /* JADX WARN: Found duplicated region for block: B:48:0x0155 */
                    /* JADX WARN: Found duplicated region for block: B:50:0x015d */
                    /* JADX WARN: Found duplicated region for block: B:52:0x0165 */
                    /*
                     * JADX WARN: Found duplicated region for block: B:56:0x018a A[LOOP:4:
                     * B:54:0x0184->B:56:0x018a, LOOP_END]
                     */
                    /* JADX WARN: Found duplicated region for block: B:59:0x01a0 */
                    @Override // net.bytebuddy.asm.Advice.StackMapFrameHandler.ForInstrumentedMethod
                    public void injectStartFrame(MethodVisitor methodVisitor) {
                        Object[] objArr;
                        int i;
                        Iterator<TypeDescription> it;
                        Iterator<? extends TypeDescription> it2;
                        Iterator<? extends TypeDescription> it3;
                        int i2;
                        Iterator<TypeDescription> it4;
                        Iterator<TypeDescription> it5;
                        if (!this.instrumentedMethod.isStatic() || !this.instrumentedMethod.getParameters().isEmpty()) {
                            if (this.expandFrames) {
                                int size = this.preMethodTypes.size() + this.initialTypes.size()
                                        + (this.instrumentedMethod.getParameters().size() * 2)
                                        + (this.instrumentedMethod.isStatic() ? 0 : 2);
                                objArr = new Object[size];
                                if (this.instrumentedMethod.isConstructor()) {
                                    objArr[0] = Opcodes.UNINITIALIZED_THIS;
                                } else {
                                    if (this.instrumentedMethod.isStatic()) {
                                        i = 0;
                                    } else {
                                        objArr[0] = Initialization.INITIALIZED.toFrame(this.instrumentedType);
                                    }
                                    it = this.instrumentedMethod.getParameters().asTypeList().asErasures().iterator();
                                    while (it.hasNext()) {
                                        objArr[i] = Initialization.INITIALIZED.toFrame(it.next());
                                        i++;
                                    }
                                    it2 = this.initialTypes.iterator();
                                    while (it2.hasNext()) {
                                        objArr[i] = Initialization.INITIALIZED.toFrame(it2.next());
                                        i++;
                                    }
                                    it3 = this.preMethodTypes.iterator();
                                    while (it3.hasNext()) {
                                        objArr[i] = Initialization.INITIALIZED.toFrame(it3.next());
                                        i++;
                                    }
                                    if (this.instrumentedMethod.isConstructor()) {
                                        i2 = i + 1;
                                        objArr[i] = Opcodes.UNINITIALIZED_THIS;
                                    } else {
                                        if (!this.instrumentedMethod.isStatic()) {
                                            i2 = i + 1;
                                            objArr[i] = Initialization.INITIALIZED.toFrame(this.instrumentedType);
                                        }
                                        it4 = this.instrumentedMethod.getParameters().asTypeList().asErasures()
                                                .iterator();
                                        while (it4.hasNext()) {
                                            objArr[i] = Initialization.INITIALIZED.toFrame(it4.next());
                                            i++;
                                        }
                                        if (this.expandFrames) {
                                        }
                                        Object[] objArr2 = Default.EMPTY;
                                        methodVisitor.visitFrame(i, size, objArr, objArr2.length, objArr2);
                                    }
                                    i = i2;
                                    it4 = this.instrumentedMethod.getParameters().asTypeList().asErasures().iterator();
                                    while (it4.hasNext()) {
                                        objArr[i] = Initialization.INITIALIZED.toFrame(it4.next());
                                        i++;
                                    }
                                    if (this.expandFrames) {
                                    }
                                    Object[] objArr22 = Default.EMPTY;
                                    methodVisitor.visitFrame(i, size, objArr, objArr22.length, objArr22);
                                }
                                i = 1;
                                it = this.instrumentedMethod.getParameters().asTypeList().asErasures().iterator();
                                while (it.hasNext()) {
                                    objArr[i] = Initialization.INITIALIZED.toFrame(it.next());
                                    i++;
                                }
                                it2 = this.initialTypes.iterator();
                                while (it2.hasNext()) {
                                    objArr[i] = Initialization.INITIALIZED.toFrame(it2.next());
                                    i++;
                                }
                                it3 = this.preMethodTypes.iterator();
                                while (it3.hasNext()) {
                                    objArr[i] = Initialization.INITIALIZED.toFrame(it3.next());
                                    i++;
                                }
                                if (this.instrumentedMethod.isConstructor()) {
                                    i2 = i + 1;
                                    objArr[i] = Opcodes.UNINITIALIZED_THIS;
                                } else {
                                    if (!this.instrumentedMethod.isStatic()) {
                                        i2 = i + 1;
                                        objArr[i] = Initialization.INITIALIZED.toFrame(this.instrumentedType);
                                    }
                                    it4 = this.instrumentedMethod.getParameters().asTypeList().asErasures().iterator();
                                    while (it4.hasNext()) {
                                        objArr[i] = Initialization.INITIALIZED.toFrame(it4.next());
                                        i++;
                                    }
                                    if (this.expandFrames) {
                                    }
                                    Object[] objArr222 = Default.EMPTY;
                                    methodVisitor.visitFrame(i, size, objArr, objArr222.length, objArr222);
                                }
                                i = i2;
                                it4 = this.instrumentedMethod.getParameters().asTypeList().asErasures().iterator();
                                while (it4.hasNext()) {
                                    objArr[i] = Initialization.INITIALIZED.toFrame(it4.next());
                                    i++;
                                }
                                if (this.expandFrames) {
                                }
                                Object[] objArr2222 = Default.EMPTY;
                                methodVisitor.visitFrame(i, size, objArr, objArr2222.length, objArr2222);
                            } else {
                                if (this.instrumentedMethod.getParameters().size()
                                        + (!this.instrumentedMethod.isStatic() ? 1 : 0) < 4) {
                                    int size2 = this.instrumentedMethod.getParameters().size()
                                            + (!this.instrumentedMethod.isStatic() ? 1 : 0);
                                    Object[] objArr3 = new Object[size2];
                                    if (this.instrumentedMethod.isConstructor()) {
                                        objArr3[0] = Opcodes.UNINITIALIZED_THIS;
                                    } else {
                                        if (!this.instrumentedMethod.isStatic()) {
                                            objArr3[0] = Initialization.INITIALIZED.toFrame(this.instrumentedType);
                                        }
                                        it5 = this.instrumentedMethod.getParameters().asTypeList().asErasures()
                                                .iterator();
                                        while (it5.hasNext()) {
                                            objArr3[i] = Initialization.INITIALIZED.toFrame(it5.next());
                                            i++;
                                        }
                                        Object[] objArr4 = Default.EMPTY;
                                        methodVisitor.visitFrame(1, size2, objArr3, objArr4.length, objArr4);
                                    }
                                    i = 1;
                                    it5 = this.instrumentedMethod.getParameters().asTypeList().asErasures().iterator();
                                    while (it5.hasNext()) {
                                        objArr3[i] = Initialization.INITIALIZED.toFrame(it5.next());
                                        i++;
                                    }
                                    Object[] objArr42 = Default.EMPTY;
                                    methodVisitor.visitFrame(1, size2, objArr3, objArr42.length, objArr42);
                                } else {
                                    int size3 = this.preMethodTypes.size() + this.initialTypes.size()
                                            + (this.instrumentedMethod.getParameters().size() * 2)
                                            + (this.instrumentedMethod.isStatic() ? 0 : 2);
                                    objArr = new Object[size3];
                                    if (this.instrumentedMethod.isConstructor()) {
                                        objArr[0] = Opcodes.UNINITIALIZED_THIS;
                                    } else {
                                        if (this.instrumentedMethod.isStatic()) {
                                            objArr[0] = Initialization.INITIALIZED.toFrame(this.instrumentedType);
                                        } else {
                                            i = 0;
                                        }
                                        it = this.instrumentedMethod.getParameters().asTypeList().asErasures()
                                                .iterator();
                                        while (it.hasNext()) {
                                            objArr[i] = Initialization.INITIALIZED.toFrame(it.next());
                                            i++;
                                        }
                                        it2 = this.initialTypes.iterator();
                                        while (it2.hasNext()) {
                                            objArr[i] = Initialization.INITIALIZED.toFrame(it2.next());
                                            i++;
                                        }
                                        it3 = this.preMethodTypes.iterator();
                                        while (it3.hasNext()) {
                                            objArr[i] = Initialization.INITIALIZED.toFrame(it3.next());
                                            i++;
                                        }
                                        if (this.instrumentedMethod.isConstructor()) {
                                            i2 = i + 1;
                                            objArr[i] = Opcodes.UNINITIALIZED_THIS;
                                        } else {
                                            if (!this.instrumentedMethod.isStatic()) {
                                                i2 = i + 1;
                                                objArr[i] = Initialization.INITIALIZED.toFrame(this.instrumentedType);
                                            }
                                            it4 = this.instrumentedMethod.getParameters().asTypeList().asErasures()
                                                    .iterator();
                                            while (it4.hasNext()) {
                                                objArr[i] = Initialization.INITIALIZED.toFrame(it4.next());
                                                i++;
                                            }
                                            i = this.expandFrames ? -1 : 0;
                                            Object[] objArr22222 = Default.EMPTY;
                                            methodVisitor.visitFrame(i, size3, objArr, objArr22222.length, objArr22222);
                                        }
                                        i = i2;
                                        it4 = this.instrumentedMethod.getParameters().asTypeList().asErasures()
                                                .iterator();
                                        while (it4.hasNext()) {
                                            objArr[i] = Initialization.INITIALIZED.toFrame(it4.next());
                                            i++;
                                        }
                                        if (this.expandFrames) {
                                        }
                                        Object[] objArr222222 = Default.EMPTY;
                                        methodVisitor.visitFrame(i, size3, objArr, objArr222222.length, objArr222222);
                                    }
                                    i = 1;
                                    it = this.instrumentedMethod.getParameters().asTypeList().asErasures().iterator();
                                    while (it.hasNext()) {
                                        objArr[i] = Initialization.INITIALIZED.toFrame(it.next());
                                        i++;
                                    }
                                    it2 = this.initialTypes.iterator();
                                    while (it2.hasNext()) {
                                        objArr[i] = Initialization.INITIALIZED.toFrame(it2.next());
                                        i++;
                                    }
                                    it3 = this.preMethodTypes.iterator();
                                    while (it3.hasNext()) {
                                        objArr[i] = Initialization.INITIALIZED.toFrame(it3.next());
                                        i++;
                                    }
                                    if (this.instrumentedMethod.isConstructor()) {
                                        i2 = i + 1;
                                        objArr[i] = Opcodes.UNINITIALIZED_THIS;
                                    } else {
                                        if (!this.instrumentedMethod.isStatic()) {
                                            i2 = i + 1;
                                            objArr[i] = Initialization.INITIALIZED.toFrame(this.instrumentedType);
                                        }
                                        it4 = this.instrumentedMethod.getParameters().asTypeList().asErasures()
                                                .iterator();
                                        while (it4.hasNext()) {
                                            objArr[i] = Initialization.INITIALIZED.toFrame(it4.next());
                                            i++;
                                        }
                                        if (this.expandFrames) {
                                        }
                                        Object[] objArr2222222 = Default.EMPTY;
                                        methodVisitor.visitFrame(i, size3, objArr, objArr2222222.length, objArr2222222);
                                    }
                                    i = i2;
                                    it4 = this.instrumentedMethod.getParameters().asTypeList().asErasures().iterator();
                                    while (it4.hasNext()) {
                                        objArr[i] = Initialization.INITIALIZED.toFrame(it4.next());
                                        i++;
                                    }
                                    if (this.expandFrames) {
                                    }
                                    Object[] objArr22222222 = Default.EMPTY;
                                    methodVisitor.visitFrame(i, size3, objArr, objArr22222222.length, objArr22222222);
                                }
                            }
                        }
                        this.currentFrameDivergence = this.instrumentedMethod.getParameters().size()
                                + (!this.instrumentedMethod.isStatic() ? 1 : 0);
                    }

                    @Override // net.bytebuddy.asm.Advice.StackMapFrameHandler
                    public void translateFrame(MethodVisitor methodVisitor, int i, int i2, @MaybeNull Object[] objArr,
                            int i3, @MaybeNull Object[] objArr2) {
                        int i4 = 1;
                        if (i == -1 || i == 0) {
                            int size = this.preMethodTypes.size() + this.initialTypes.size()
                                    + this.instrumentedMethod.getParameters().size()
                                    + (!this.instrumentedMethod.isStatic() ? 1 : 0) + i2;
                            Object[] objArr3 = new Object[size];
                            if (this.instrumentedMethod.isConstructor()) {
                                Initialization initialization = Initialization.INITIALIZED;
                                for (int i5 = 0; i5 < i2; i5++) {
                                    if (objArr[i5] == Opcodes.UNINITIALIZED_THIS) {
                                        initialization = Initialization.UNITIALIZED;
                                        break;
                                    }
                                }
                                objArr3[0] = initialization.toFrame(this.instrumentedType);
                            } else if (this.instrumentedMethod.isStatic()) {
                                i4 = 0;
                            } else {
                                objArr3[0] = Initialization.INITIALIZED.toFrame(this.instrumentedType);
                            }
                            Iterator<TypeDescription> it = this.instrumentedMethod.getParameters().asTypeList()
                                    .asErasures().iterator();
                            while (it.hasNext()) {
                                objArr3[i4] = Initialization.INITIALIZED.toFrame(it.next());
                                i4++;
                            }
                            Iterator<? extends TypeDescription> it2 = this.initialTypes.iterator();
                            while (it2.hasNext()) {
                                objArr3[i4] = Initialization.INITIALIZED.toFrame(it2.next());
                                i4++;
                            }
                            Iterator<? extends TypeDescription> it3 = this.preMethodTypes.iterator();
                            while (it3.hasNext()) {
                                objArr3[i4] = Initialization.INITIALIZED.toFrame(it3.next());
                                i4++;
                            }
                            if (i2 > 0) {
                                System.arraycopy(objArr, 0, objArr3, i4, i2);
                            }
                            this.currentFrameDivergence = size;
                            objArr = objArr3;
                            i2 = size;
                        } else if (i == 1) {
                            this.currentFrameDivergence += i2;
                        } else if (i == 2) {
                            this.currentFrameDivergence -= i2;
                        } else if (i != 3 && i != 4) {
                            throw new IllegalArgumentException(concatVar2Var1(i, "Unexpected frame type: "));
                        }
                        if (!this.instrumentedMethod.isConstructor()
                                || this.currentFrameDivergence >= this.instrumentedMethod.getStackSize()) {
                            methodVisitor.visitFrame(i, i2, objArr, i3, objArr2);
                            return;
                        }
                        throw new IllegalStateException(this.instrumentedMethod + " dropped implicit 'this' frame");
                    }
                }

                /*
                 * JADX INFO: compiled from:
                 * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
                 */
                public static class WithoutArgumentCopy extends WithPreservedArguments {
                    public WithoutArgumentCopy(TypeDescription typeDescription, MethodDescription methodDescription,
                            List<? extends TypeDescription> list, List<? extends TypeDescription> list2,
                            List<? extends TypeDescription> list3, List<? extends TypeDescription> list4, boolean z,
                            boolean z2) {
                        super(typeDescription, methodDescription, list, list2, list3, list4, z, z2);
                    }

                    @Override // net.bytebuddy.asm.Advice.StackMapFrameHandler.ForInstrumentedMethod
                    public void injectStartFrame(MethodVisitor methodVisitor) {
                    }

                    @Override // net.bytebuddy.asm.Advice.StackMapFrameHandler
                    public void translateFrame(MethodVisitor methodVisitor, int i, int i2, @MaybeNull Object[] objArr,
                            int i3, @MaybeNull Object[] objArr2) {
                        translateFrame(methodVisitor, TranslationMode.COPY, this.instrumentedMethod.isStatic(),
                                this.instrumentedMethod.asTypeToken(),
                                CompoundList.of((List) this.initialTypes, (List) this.preMethodTypes), i, i2, objArr,
                                i3, objArr2);
                    }
                }

                public WithPreservedArguments(TypeDescription typeDescription, MethodDescription methodDescription,
                        List<? extends TypeDescription> list, List<? extends TypeDescription> list2,
                        List<? extends TypeDescription> list3, List<? extends TypeDescription> list4, boolean z,
                        boolean z2) {
                    super(typeDescription, methodDescription, list, list2, list3, list4, z);
                    this.allowCompactCompletionFrame = z2;
                }

                @Override // net.bytebuddy.asm.Advice.StackMapFrameHandler.ForInstrumentedMethod
                public ForAdvice bindExit(MethodDescription.TypeToken typeToken) {
                    List listOf = CompoundList.of(this.initialTypes, this.preMethodTypes, this.postMethodTypes);
                    List list = Collections.EMPTY_LIST;
                    return new ForAdvice(typeToken, listOf, list, list, TranslationMode.EXIT,
                            Initialization.INITIALIZED);
                }

                @Override // net.bytebuddy.asm.Advice.StackMapFrameHandler
                public void injectCompletionFrame(MethodVisitor methodVisitor) {
                    if (!this.allowCompactCompletionFrame || this.expandFrames || this.currentFrameDivergence != 0
                            || this.postMethodTypes.size() >= 4) {
                        injectFullFrame(methodVisitor, Initialization.INITIALIZED,
                                CompoundList.of(this.initialTypes, this.preMethodTypes, this.postMethodTypes),
                                Collections.EMPTY_LIST);
                        return;
                    }
                    if (this.postMethodTypes.isEmpty()) {
                        Object[] objArr = Default.EMPTY;
                        methodVisitor.visitFrame(3, objArr.length, objArr, objArr.length, objArr);
                        return;
                    }
                    int size = this.postMethodTypes.size();
                    Object[] objArr2 = new Object[size];
                    Iterator<? extends TypeDescription> it = this.postMethodTypes.iterator();
                    int i = 0;
                    while (it.hasNext()) {
                        objArr2[i] = Initialization.INITIALIZED.toFrame(it.next());
                        i++;
                    }
                    Object[] objArr3 = Default.EMPTY;
                    methodVisitor.visitFrame(1, size, objArr2, objArr3.length, objArr3);
                }

                @Override // net.bytebuddy.asm.Advice.StackMapFrameHandler
                public void injectExceptionFrame(MethodVisitor methodVisitor) {
                    if (this.expandFrames || this.currentFrameDivergence != 0) {
                        injectFullFrame(methodVisitor, Initialization.INITIALIZED,
                                CompoundList.of((List) this.initialTypes, (List) this.preMethodTypes),
                                Collections.singletonList(TypeDescription.ForLoadedType.of(Throwable.class)));
                    } else {
                        Object[] objArr = Default.EMPTY;
                        methodVisitor.visitFrame(4, objArr.length, objArr, 1,
                                new Object[] { Type.getInternalName(Throwable.class) });
                    }
                }

                @Override // net.bytebuddy.asm.Advice.StackMapFrameHandler.ForInstrumentedMethod
                public void injectInitializationFrame(MethodVisitor methodVisitor) {
                    if (this.initialTypes.isEmpty()) {
                        return;
                    }
                    if (!this.expandFrames && this.initialTypes.size() < 4) {
                        int size = this.initialTypes.size();
                        Object[] objArr = new Object[size];
                        Iterator<? extends TypeDescription> it = this.initialTypes.iterator();
                        while (it.hasNext()) {
                            objArr[i] = Initialization.INITIALIZED.toFrame(it.next());
                            i++;
                        }
                        Object[] objArr2 = Default.EMPTY;
                        methodVisitor.visitFrame(1, size, objArr, objArr2.length, objArr2);
                        return;
                    }
                    int i = 1;
                    int size2 = this.initialTypes.size() + this.instrumentedMethod.getParameters().size()
                            + (!this.instrumentedMethod.isStatic() ? 1 : 0);
                    Object[] objArr3 = new Object[size2];
                    if (this.instrumentedMethod.isConstructor()) {
                        objArr3[0] = Opcodes.UNINITIALIZED_THIS;
                    } else if (this.instrumentedMethod.isStatic()) {
                        i = 0;
                    } else {
                        objArr3[0] = Initialization.INITIALIZED.toFrame(this.instrumentedType);
                    }
                    Iterator<TypeDescription> it2 = this.instrumentedMethod.getParameters().asTypeList().asErasures()
                            .iterator();
                    while (it2.hasNext()) {
                        objArr3[i] = Initialization.INITIALIZED.toFrame(it2.next());
                        i++;
                    }
                    Iterator<? extends TypeDescription> it3 = this.initialTypes.iterator();
                    while (it3.hasNext()) {
                        objArr3[i] = Initialization.INITIALIZED.toFrame(it3.next());
                        i++;
                    }
                    i = this.expandFrames ? -1 : 0;
                    Object[] objArr4 = Default.EMPTY;
                    methodVisitor.visitFrame(i, size2, objArr3, objArr4.length, objArr4);
                }

                @Override // net.bytebuddy.asm.Advice.StackMapFrameHandler.ForInstrumentedMethod
                public void injectPostCompletionFrame(MethodVisitor methodVisitor) {
                    if (this.expandFrames || this.currentFrameDivergence != 0) {
                        injectFullFrame(methodVisitor, Initialization.INITIALIZED,
                                CompoundList.of(this.initialTypes, this.preMethodTypes, this.postMethodTypes),
                                Collections.EMPTY_LIST);
                    } else {
                        Object[] objArr = Default.EMPTY;
                        methodVisitor.visitFrame(3, objArr.length, objArr, objArr.length, objArr);
                    }
                }

                @Override // net.bytebuddy.asm.Advice.StackMapFrameHandler
                public void injectReturnFrame(MethodVisitor methodVisitor) {
                    boolean z = this.expandFrames;
                    Class cls = Void.TYPE;
                    if (z || this.currentFrameDivergence != 0) {
                        injectFullFrame(methodVisitor, Initialization.INITIALIZED,
                                CompoundList.of((List) this.initialTypes, (List) this.preMethodTypes),
                                this.instrumentedMethod.getReturnType().represents(cls) ? Collections.EMPTY_LIST
                                        : Collections
                                                .singletonList(this.instrumentedMethod.getReturnType().asErasure()));
                    } else if (this.instrumentedMethod.getReturnType().represents(cls)) {
                        Object[] objArr = Default.EMPTY;
                        methodVisitor.visitFrame(3, objArr.length, objArr, objArr.length, objArr);
                    } else {
                        Object[] objArr2 = Default.EMPTY;
                        methodVisitor.visitFrame(4, objArr2.length, objArr2, 1,
                                new Object[] { Initialization.INITIALIZED
                                        .toFrame(this.instrumentedMethod.getReturnType().asErasure()) });
                    }
                }

                @Override // net.bytebuddy.asm.Advice.StackMapFrameHandler.Default
                public void translateFrame(MethodVisitor methodVisitor, TranslationMode translationMode, boolean z,
                        MethodDescription.TypeToken typeToken, List<? extends TypeDescription> list, int i, int i2,
                        @MaybeNull Object[] objArr, int i3, @MaybeNull Object[] objArr2) {
                    if (i == 0 && i2 > 0 && objArr[0] != Opcodes.UNINITIALIZED_THIS) {
                        this.allowCompactCompletionFrame = true;
                    }
                    super.translateFrame(methodVisitor, translationMode, z, typeToken, list, i, i2, objArr, i3,
                            objArr2);
                }
            }

            public Default(TypeDescription typeDescription, MethodDescription methodDescription,
                    List<? extends TypeDescription> list, List<? extends TypeDescription> list2,
                    List<? extends TypeDescription> list3, List<? extends TypeDescription> list4, boolean z) {
                this.instrumentedType = typeDescription;
                this.instrumentedMethod = methodDescription;
                this.initialTypes = list;
                this.latentTypes = list2;
                this.preMethodTypes = list3;
                this.postMethodTypes = list4;
                this.expandFrames = z;
            }

            public static ForInstrumentedMethod of(TypeDescription typeDescription, MethodDescription methodDescription,
                    List<? extends TypeDescription> list, List<? extends TypeDescription> list2,
                    List<? extends TypeDescription> list3, List<? extends TypeDescription> list4, boolean z, boolean z2,
                    ClassFileVersion classFileVersion, int i, int i2) {
                boolean z3;
                TypeDescription typeDescription2;
                MethodDescription methodDescription2;
                List<? extends TypeDescription> list5;
                List<? extends TypeDescription> list6;
                List<? extends TypeDescription> list7;
                List<? extends TypeDescription> list8;
                if ((i & 2) != 0 || classFileVersion.isLessThan(ClassFileVersion.JAVA_V6)) {
                    return NoOp.INSTANCE;
                }
                if (!z && list.isEmpty()) {
                    return new Trivial(typeDescription, methodDescription, list2, (i2 & 8) != 0);
                }
                if (!z2) {
                    return new WithPreservedArguments.WithoutArgumentCopy(typeDescription, methodDescription, list,
                            list2, list3, list4, (i2 & 8) != 0, !methodDescription.isConstructor());
                }
                if ((i2 & 8) != 0) {
                    z3 = true;
                    methodDescription2 = methodDescription;
                    list5 = list;
                    list6 = list2;
                    list7 = list3;
                    list8 = list4;
                    typeDescription2 = typeDescription;
                } else {
                    z3 = false;
                    typeDescription2 = typeDescription;
                    methodDescription2 = methodDescription;
                    list5 = list;
                    list6 = list2;
                    list7 = list3;
                    list8 = list4;
                }
                return new WithPreservedArguments.WithArgumentCopy(typeDescription2, methodDescription2, list5, list6,
                        list7, list8, z3);
            }

            @Override // net.bytebuddy.asm.Advice.StackMapFrameHandler.ForInstrumentedMethod
            public ForAdvice bindEnter(MethodDescription.TypeToken typeToken) {
                return new ForAdvice(typeToken, this.initialTypes, this.latentTypes, this.preMethodTypes,
                        TranslationMode.ENTER, this.instrumentedMethod.isConstructor() ? Initialization.UNITIALIZED
                                : Initialization.INITIALIZED);
            }

            @Override // net.bytebuddy.asm.Advice.StackMapFrameHandler.ForInstrumentedMethod
            public int getReaderHint() {
                return this.expandFrames ? 8 : 0;
            }

            public void injectFullFrame(MethodVisitor methodVisitor, Initialization initialization,
                    List<? extends TypeDescription> list, List<? extends TypeDescription> list2) {
                int i = 1;
                int size = list.size() + this.instrumentedMethod.getParameters().size()
                        + (!this.instrumentedMethod.isStatic() ? 1 : 0);
                Object[] objArr = new Object[size];
                if (this.instrumentedMethod.isStatic()) {
                    i = 0;
                } else {
                    objArr[0] = initialization.toFrame(this.instrumentedType);
                }
                Iterator<TypeDescription> it = this.instrumentedMethod.getParameters().asTypeList().asErasures()
                        .iterator();
                while (it.hasNext()) {
                    objArr[i] = Initialization.INITIALIZED.toFrame(it.next());
                    i++;
                }
                Iterator<? extends TypeDescription> it2 = list.iterator();
                while (it2.hasNext()) {
                    objArr[i] = Initialization.INITIALIZED.toFrame(it2.next());
                    i++;
                }
                int size2 = list2.size();
                Object[] objArr2 = new Object[size2];
                Iterator<? extends TypeDescription> it3 = list2.iterator();
                int i2 = 0;
                while (it3.hasNext()) {
                    objArr2[i2] = Initialization.INITIALIZED.toFrame(it3.next());
                    i2++;
                }
                methodVisitor.visitFrame(this.expandFrames ? -1 : 0, size, objArr, size2, objArr2);
                this.currentFrameDivergence = 0;
            }

            public void translateFrame(MethodVisitor methodVisitor, TranslationMode translationMode, boolean z,
                    MethodDescription.TypeToken typeToken, List<? extends TypeDescription> list, int i, int i2,
                    @MaybeNull Object[] objArr, int i3, @MaybeNull Object[] objArr2) {
                int i4;
                MethodVisitor methodVisitor2;
                Object[] objArr3;
                int i5;
                int size = i2;
                Object[] objArr4 = objArr;
                if (i == -1 || i == 0) {
                    if (typeToken.getParameterTypes().size() + (!z ? 1 : 0) > size) {
                        throw new IllegalStateException("Inconsistent frame length for " + typeToken + ": " + size);
                    }
                    if (z) {
                        i4 = 0;
                    } else {
                        if (!translationMode.isPossibleThisFrameValue(this.instrumentedType, this.instrumentedMethod,
                                objArr4[0])) {
                            throw new IllegalStateException(
                                    typeToken + " is inconsistent for 'this' reference: " + objArr4[0]);
                        }
                        i4 = 1;
                    }
                    for (int i6 = 0; i6 < typeToken.getParameterTypes().size(); i6++) {
                        int i7 = i6 + i4;
                        if (!Initialization.INITIALIZED.toFrame(typeToken.getParameterTypes().get(i6))
                                .equals(objArr4[i7])) {
                            throw new IllegalStateException(
                                    typeToken + " is inconsistent at " + i6 + ": " + objArr4[i7]);
                        }
                    }
                    size = list.size() + this.instrumentedMethod.getParameters().size()
                            + ((size - (!z ? 1 : 0)) - typeToken.getParameterTypes().size())
                            + (!this.instrumentedMethod.isStatic() ? 1 : 0);
                    Object[] objArr5 = new Object[size];
                    int iCopy = translationMode.copy(this.instrumentedType, this.instrumentedMethod, objArr4, objArr5);
                    Iterator<? extends TypeDescription> it = list.iterator();
                    while (it.hasNext()) {
                        objArr5[iCopy] = Initialization.INITIALIZED.toFrame(it.next());
                        iCopy++;
                    }
                    if (size != iCopy) {
                        System.arraycopy(objArr4, typeToken.getParameterTypes().size() + (!z ? 1 : 0), objArr5, iCopy,
                                size - iCopy);
                    }
                    this.currentFrameDivergence = size - iCopy;
                    objArr4 = objArr5;
                    methodVisitor2 = methodVisitor;
                    objArr3 = objArr2;
                    i5 = i3;
                } else {
                    if (i == 1) {
                        this.currentFrameDivergence += size;
                    } else if (i == 2) {
                        int i8 = this.currentFrameDivergence - size;
                        this.currentFrameDivergence = i8;
                        if (i8 < 0) {
                            throw new IllegalStateException(typeToken + " dropped "
                                    + Math.abs(this.currentFrameDivergence) + " implicit frames");
                        }
                    } else if (i != 3 && i != 4) {
                        throw new IllegalArgumentException(concatVar2Var1(i, "Unexpected frame type: "));
                    }
                    methodVisitor2 = methodVisitor;
                    i5 = i3;
                    objArr3 = objArr2;
                }
                methodVisitor2.visitFrame(i, size, objArr4, i5, objArr3);
            }
        }

        /*
         * JADX INFO: compiled from:
         * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
         */
        public interface ForAdvice extends StackMapFrameHandler, ForPostProcessor {
        }

        /*
         * JADX INFO: compiled from:
         * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
         */
        public interface ForInstrumentedMethod extends StackMapFrameHandler {
            ForAdvice bindEnter(MethodDescription.TypeToken typeToken);

            ForAdvice bindExit(MethodDescription.TypeToken typeToken);

            int getReaderHint();

            void injectInitializationFrame(MethodVisitor methodVisitor);

            void injectPostCompletionFrame(MethodVisitor methodVisitor);

            void injectStartFrame(MethodVisitor methodVisitor);
        }

        /*
         * JADX INFO: compiled from:
         * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
         */
        public interface ForPostProcessor {
            void injectIntermediateFrame(MethodVisitor methodVisitor, List<? extends TypeDescription> list);
        }

        /*
         * JADX INFO: compiled from:
         * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
         */
        public enum NoOp implements ForInstrumentedMethod, ForAdvice {
            INSTANCE;

            @Override // net.bytebuddy.asm.Advice.StackMapFrameHandler.ForInstrumentedMethod
            public ForAdvice bindEnter(MethodDescription.TypeToken typeToken) {
                return this;
            }

            @Override // net.bytebuddy.asm.Advice.StackMapFrameHandler.ForInstrumentedMethod
            public ForAdvice bindExit(MethodDescription.TypeToken typeToken) {
                return this;
            }

            @Override // net.bytebuddy.asm.Advice.StackMapFrameHandler.ForInstrumentedMethod
            public int getReaderHint() {
                return 4;
            }

            @Override // net.bytebuddy.asm.Advice.StackMapFrameHandler
            public void injectCompletionFrame(MethodVisitor methodVisitor) {
            }

            @Override // net.bytebuddy.asm.Advice.StackMapFrameHandler
            public void injectExceptionFrame(MethodVisitor methodVisitor) {
            }

            @Override // net.bytebuddy.asm.Advice.StackMapFrameHandler.ForInstrumentedMethod
            public void injectInitializationFrame(MethodVisitor methodVisitor) {
            }

            @Override // net.bytebuddy.asm.Advice.StackMapFrameHandler.ForPostProcessor
            public void injectIntermediateFrame(MethodVisitor methodVisitor, List<? extends TypeDescription> list) {
            }

            @Override // net.bytebuddy.asm.Advice.StackMapFrameHandler.ForInstrumentedMethod
            public void injectPostCompletionFrame(MethodVisitor methodVisitor) {
            }

            @Override // net.bytebuddy.asm.Advice.StackMapFrameHandler
            public void injectReturnFrame(MethodVisitor methodVisitor) {
            }

            @Override // net.bytebuddy.asm.Advice.StackMapFrameHandler.ForInstrumentedMethod
            public void injectStartFrame(MethodVisitor methodVisitor) {
            }

            @Override // net.bytebuddy.asm.Advice.StackMapFrameHandler
            public void translateFrame(MethodVisitor methodVisitor, int i, int i2, @MaybeNull Object[] objArr, int i3,
                    @MaybeNull Object[] objArr2) {
            }
        }

        void injectCompletionFrame(MethodVisitor methodVisitor);

        void injectExceptionFrame(MethodVisitor methodVisitor);

        void injectReturnFrame(MethodVisitor methodVisitor);

        void translateFrame(MethodVisitor methodVisitor, int i, int i2, @MaybeNull Object[] objArr, int i3,
                @MaybeNull Object[] objArr2);
    }

    /*
     * JADX INFO: compiled from:
     * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
     */
    @Target({ ElementType.PARAMETER })
    @Documented
    @Retention(RetentionPolicy.RUNTIME)
    public @interface StubValue {
    }

    /*
     * JADX INFO: compiled from:
     * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
     */
    @Target({ ElementType.PARAMETER })
    @Documented
    @Retention(RetentionPolicy.RUNTIME)
    public @interface This {
        boolean optional() default false;

        boolean readOnly() default true;

        Assigner.Typing typing() default Assigner.Typing.STATIC;
    }

    /*
     * JADX INFO: compiled from:
     * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
     */
    @Target({ ElementType.PARAMETER })
    @Documented
    @Retention(RetentionPolicy.RUNTIME)
    public @interface Thrown {
        boolean readOnly() default true;

        Assigner.Typing typing() default Assigner.Typing.DYNAMIC;
    }

    /*
     * JADX INFO: compiled from:
     * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
     */
    @Target({ ElementType.PARAMETER })
    @Documented
    @Retention(RetentionPolicy.RUNTIME)
    public @interface Unused {
    }

    /*
     * JADX INFO: compiled from:
     * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
     */
    @HashCodeAndEqualsPlugin.Enhance
    public static class WithCustomMapping {
        private final AsmClassReader.Factory classReaderFactory;
        private final Delegator.Factory delegatorFactory;
        private final Map<Class<? extends Annotation>, OffsetMapping.Factory<?>> offsetMappings;
        private final PostProcessor.Factory postProcessorFactory;

        public WithCustomMapping() {
            this(PostProcessor.NoOp.INSTANCE, Collections.EMPTY_MAP, Delegator.ForRegularInvocation.Factory.INSTANCE,
                    AsmClassReader.Factory.Default.IMPLICIT);
        }

        public <T extends Annotation> WithCustomMapping bind(Class<T> cls, @MaybeNull Object obj) {
            return bind(OffsetMapping.ForStackManipulation.Factory.of(cls, obj));
        }

        public <T extends Annotation> WithCustomMapping bindDynamic(Class<T> cls, Method method, Object... objArr) {
            return bindDynamic(cls, method, Arrays.asList(objArr));
        }

        public <T extends Annotation> WithCustomMapping bindLambda(Class<T> cls, Constructor<?> constructor,
                Class<?> cls2) {
            return bindLambda(cls, new MethodDescription.ForLoadedConstructor(constructor),
                    TypeDescription.ForLoadedType.of(cls2));
        }

        public <T extends Annotation> WithCustomMapping bindProperty(Class<T> cls, String str) {
            return bind(OffsetMapping.ForStackManipulation.OfAnnotationProperty.of(cls, str));
        }

        public <T extends Annotation> WithCustomMapping bindSerialized(Class<T> cls, Serializable serializable) {
            return bindSerialized(cls, serializable, serializable.getClass());
        }

        public WithCustomMapping bootstrap(Constructor<?> constructor) {
            return bootstrap(new MethodDescription.ForLoadedConstructor(constructor));
        }

        public boolean equals(@MaybeNull Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            WithCustomMapping withCustomMapping = (WithCustomMapping) obj;
            return this.postProcessorFactory.equals(withCustomMapping.postProcessorFactory)
                    && this.delegatorFactory.equals(withCustomMapping.delegatorFactory)
                    && this.classReaderFactory.equals(withCustomMapping.classReaderFactory)
                    && this.offsetMappings.equals(withCustomMapping.offsetMappings);
        }

        public int hashCode() {
            return this.offsetMappings.hashCode()
                    + ((this.classReaderFactory.hashCode() + ((this.delegatorFactory.hashCode()
                            + ((this.postProcessorFactory.hashCode() + (getClass().hashCode() * 31)) * 31)) * 31))
                            * 31);
        }

        public Advice to(Class<?> cls) {
            return to(cls, ClassFileLocator.ForClassLoader.of(cls.getClassLoader()));
        }

        public WithCustomMapping with(PostProcessor.Factory factory) {
            return new WithCustomMapping(new PostProcessor.Factory.Compound(this.postProcessorFactory, factory),
                    this.offsetMappings, this.delegatorFactory, this.classReaderFactory);
        }

        public <T extends Annotation> WithCustomMapping bind(Class<T> cls, Field field) {
            return bind((Class) cls, (FieldDescription) new FieldDescription.ForLoadedField(field));
        }

        public <T extends Annotation> WithCustomMapping bindDynamic(Class<T> cls, Method method, List<?> list) {
            return bindDynamic(cls, new MethodDescription.ForLoadedMethod(method), list);
        }

        public <T extends Annotation, S extends Serializable> WithCustomMapping bindSerialized(Class<T> cls, S s,
                Class<? super S> cls2) {
            return bind(OffsetMapping.ForSerializedValue.Factory.of(cls, s, cls2));
        }

        public WithCustomMapping bootstrap(Constructor<?> constructor, BootstrapArgumentResolver.Factory factory) {
            return bootstrap(new MethodDescription.ForLoadedConstructor(constructor), factory);
        }

        public Advice to(Class<?> cls, ClassFileLocator classFileLocator) {
            return to(TypeDescription.ForLoadedType.of(cls), classFileLocator);
        }

        public WithCustomMapping with(AsmClassReader.Factory factory) {
            return new WithCustomMapping(this.postProcessorFactory, this.offsetMappings, this.delegatorFactory,
                    factory);
        }

        public <T extends Annotation> WithCustomMapping bind(Class<T> cls, FieldDescription fieldDescription) {
            return bind(new OffsetMapping.ForField.Resolved.Factory(cls, fieldDescription));
        }

        public <T extends Annotation> WithCustomMapping bindDynamic(Class<T> cls, Constructor<?> constructor,
                Object... objArr) {
            return bindDynamic(cls, constructor, Arrays.asList(objArr));
        }

        public WithCustomMapping bootstrap(Method method) {
            return bootstrap(new MethodDescription.ForLoadedMethod(method));
        }

        public Advice to(TypeDescription typeDescription, ClassFileLocator classFileLocator) {
            return Advice.to(typeDescription, this.postProcessorFactory, classFileLocator,
                    new ArrayList(this.offsetMappings.values()), this.delegatorFactory, this.classReaderFactory);
        }

        public WithCustomMapping(PostProcessor.Factory factory,
                Map<Class<? extends Annotation>, OffsetMapping.Factory<?>> map, Delegator.Factory factory2,
                AsmClassReader.Factory factory3) {
            this.postProcessorFactory = factory;
            this.offsetMappings = map;
            this.delegatorFactory = factory2;
            this.classReaderFactory = factory3;
        }

        public <T extends Annotation> WithCustomMapping bind(Class<T> cls, Method method, int i) {
            if (i >= 0) {
                if (method.getParameterTypes().length > i) {
                    return bind((Class) cls, (ParameterDescription) new MethodDescription.ForLoadedMethod(method)
                            .getParameters().get(i));
                }
                throw new IllegalArgumentException(method + " does not declare a parameter with index " + i);
            }
            throw new IllegalArgumentException(concatVar2Var1(i, "A parameter cannot be negative: "));
        }

        public <T extends Annotation> WithCustomMapping bindDynamic(Class<T> cls, Constructor<?> constructor,
                List<?> list) {
            return bindDynamic(cls, new MethodDescription.ForLoadedConstructor(constructor), list);
        }

        public <T extends Annotation> WithCustomMapping bindLambda(Class<T> cls, Constructor<?> constructor,
                Class<?> cls2, MethodGraph.Compiler compiler) {
            return bindLambda(cls, new MethodDescription.ForLoadedConstructor(constructor),
                    TypeDescription.ForLoadedType.of(cls2), compiler);
        }

        public WithCustomMapping bootstrap(Method method, BootstrapArgumentResolver.Factory factory) {
            return bootstrap(new MethodDescription.ForLoadedMethod(method), factory);
        }

        public <T extends Annotation> WithCustomMapping bindDynamic(Class<T> cls,
                MethodDescription.InDefinedShape inDefinedShape, Object... objArr) {
            return bindDynamic(cls, inDefinedShape, Arrays.asList(objArr));
        }

        public WithCustomMapping bootstrap(Method method, BootstrapArgumentResolver.Factory factory,
                TypeDescription.Generic.Visitor<? extends TypeDescription.Generic> visitor) {
            return bootstrap(new MethodDescription.ForLoadedMethod(method), factory, visitor);
        }

        public <T extends Annotation> WithCustomMapping bindDynamic(Class<T> cls,
                MethodDescription.InDefinedShape inDefinedShape, List<?> list) {
            List<JavaConstant> listWrap = JavaConstant.Simple.wrap(list);
            if (inDefinedShape.isInvokeBootstrap(TypeList.Explicit.of((List<? extends JavaConstant>) listWrap))) {
                return bind(new OffsetMapping.ForStackManipulation.OfDynamicInvocation(cls, inDefinedShape, listWrap));
            }
            throw new IllegalArgumentException("Not a valid bootstrap method " + inDefinedShape + " for " + listWrap);
        }

        public WithCustomMapping bootstrap(MethodDescription.InDefinedShape inDefinedShape) {
            return bootstrap(inDefinedShape, BootstrapArgumentResolver.ForDefaultValues.Factory.INSTANCE);
        }

        public Advice to(Class<?> cls, Class<?> cls2) {
            ClassFileLocator compound;
            ClassLoader classLoader = cls.getClassLoader();
            ClassLoader classLoader2 = cls2.getClassLoader();
            if (classLoader == classLoader2) {
                compound = ClassFileLocator.ForClassLoader.of(classLoader);
            } else {
                compound = new ClassFileLocator.Compound(ClassFileLocator.ForClassLoader.of(classLoader),
                        ClassFileLocator.ForClassLoader.of(classLoader2));
            }
            return to(cls, cls2, compound);
        }

        public <T extends Annotation> WithCustomMapping bindLambda(Class<T> cls, Method method, Class<?> cls2) {
            return bindLambda(cls, new MethodDescription.ForLoadedMethod(method),
                    TypeDescription.ForLoadedType.of(cls2));
        }

        public WithCustomMapping bootstrap(MethodDescription.InDefinedShape inDefinedShape,
                BootstrapArgumentResolver.Factory factory) {
            return bootstrap(inDefinedShape, factory, TypeDescription.Generic.Visitor.NoOp.INSTANCE);
        }

        public WithCustomMapping bootstrap(MethodDescription.InDefinedShape inDefinedShape,
                BootstrapArgumentResolver.Factory factory,
                TypeDescription.Generic.Visitor<? extends TypeDescription.Generic> visitor) {
            return new WithCustomMapping(this.postProcessorFactory, this.offsetMappings,
                    Delegator.ForDynamicInvocation.of(inDefinedShape, factory, visitor), this.classReaderFactory);
        }

        public <T extends Annotation> WithCustomMapping bindLambda(Class<T> cls, Method method, Class<?> cls2,
                MethodGraph.Compiler compiler) {
            return bindLambda(cls, new MethodDescription.ForLoadedMethod(method),
                    TypeDescription.ForLoadedType.of(cls2), compiler);
        }

        public Advice to(Class<?> cls, Class<?> cls2, ClassFileLocator classFileLocator) {
            return to(TypeDescription.ForLoadedType.of(cls), TypeDescription.ForLoadedType.of(cls2), classFileLocator);
        }

        public Advice to(TypeDescription typeDescription, TypeDescription typeDescription2) {
            return to(typeDescription, typeDescription2, ClassFileLocator.NoOp.INSTANCE);
        }

        public Advice to(TypeDescription typeDescription, TypeDescription typeDescription2,
                ClassFileLocator classFileLocator) {
            return Advice.to(typeDescription, typeDescription2, this.postProcessorFactory, classFileLocator,
                    new ArrayList(this.offsetMappings.values()), this.delegatorFactory, this.classReaderFactory);
        }

        public <T extends Annotation> WithCustomMapping bindLambda(Class<T> cls,
                MethodDescription.InDefinedShape inDefinedShape, TypeDescription typeDescription) {
            return bindLambda(cls, inDefinedShape, typeDescription, MethodGraph.Compiler.DEFAULT);
        }

        public <T extends Annotation> WithCustomMapping bind(Class<T> cls, Constructor<?> constructor, int i) {
            if (i >= 0) {
                if (constructor.getParameterTypes().length > i) {
                    return bind((Class) cls,
                            (ParameterDescription) new MethodDescription.ForLoadedConstructor(constructor)
                                    .getParameters().get(i));
                }
                throw new IllegalArgumentException(constructor + " does not declare a parameter with index " + i);
            }
            throw new IllegalArgumentException(concatVar2Var1(i, "A parameter cannot be negative: "));
        }

        public <T extends Annotation> WithCustomMapping bindLambda(Class<T> cls,
                MethodDescription.InDefinedShape inDefinedShape, TypeDescription typeDescription,
                MethodGraph.Compiler compiler) {
            if (typeDescription.isInterface()) {
                MethodList methodListFilter = compiler.compile((TypeDefinition) typeDescription).listNodes()
                        .asMethodList().filter(ElementMatchers.isAbstract());
                if (methodListFilter.size() == 1) {
                    TypeDescription.Latent latent = new TypeDescription.Latent("java.lang.invoke.LambdaMetafactory", 1,
                            TypeDescription.Generic.OfNonGenericType.ForLoadedType.of(Object.class),
                            new TypeDescription.Generic[0]);
                    List list = Collections.EMPTY_LIST;
                    TypeDescription.Generic genericAsGenericType = JavaType.CALL_SITE.getTypeStub().asGenericType();
                    ParameterDescription.Token token = new ParameterDescription.Token(
                            JavaType.METHOD_HANDLES_LOOKUP.getTypeStub().asGenericType());
                    ParameterDescription.Token token2 = new ParameterDescription.Token(
                            TypeDescription.ForLoadedType.of(String.class).asGenericType());
                    JavaType javaType = JavaType.METHOD_TYPE;
                    return bindDynamic(cls,
                            new MethodDescription.Latent(latent, "metafactory", 9, list, genericAsGenericType,
                                    Arrays.asList(token, token2,
                                            new ParameterDescription.Token(javaType.getTypeStub().asGenericType()),
                                            new ParameterDescription.Token(javaType.getTypeStub().asGenericType()),
                                            new ParameterDescription.Token(
                                                    JavaType.METHOD_HANDLE.getTypeStub().asGenericType()),
                                            new ParameterDescription.Token(javaType.getTypeStub().asGenericType())),
                                    list, list, AnnotationValue.UNDEFINED, TypeDescription.Generic.UNDEFINED),
                            JavaConstant.MethodType.ofSignature(methodListFilter.asDefined().getOnly()),
                            JavaConstant.MethodHandle.of(inDefinedShape),
                            JavaConstant.MethodType.ofSignature(methodListFilter.asDefined().getOnly()));
                }
                throw new IllegalArgumentException(
                        typeDescription + " does not define exactly one abstract method: " + methodListFilter);
            }
            throw new IllegalArgumentException(StaticHelpers6.concat(typeDescription, " is not an interface type"));
        }

        public <T extends Annotation> WithCustomMapping bind(Class<T> cls, ParameterDescription parameterDescription) {
            return bind(new OffsetMapping.ForArgument.Resolved.Factory(cls, parameterDescription));
        }

        public <T extends Annotation> WithCustomMapping bind(Class<T> cls, Class<?> cls2) {
            return bind((Class) cls, TypeDescription.ForLoadedType.of(cls2));
        }

        public <T extends Annotation> WithCustomMapping bind(Class<T> cls, TypeDescription typeDescription) {
            return bind(new OffsetMapping.ForStackManipulation.Factory(cls, typeDescription));
        }

        public <T extends Annotation> WithCustomMapping bind(Class<T> cls, Enum<?> r3) {
            return bind((Class) cls, (EnumerationDescription) new EnumerationDescription.ForLoadedEnumeration(r3));
        }

        public <T extends Annotation> WithCustomMapping bind(Class<T> cls,
                EnumerationDescription enumerationDescription) {
            return bind(new OffsetMapping.ForStackManipulation.Factory(cls, enumerationDescription));
        }

        public <T extends Annotation> WithCustomMapping bind(Class<T> cls, JavaConstant javaConstant) {
            return bind((Class) cls, (ConstantValue) javaConstant);
        }

        public <T extends Annotation> WithCustomMapping bind(Class<T> cls, ConstantValue constantValue) {
            return bind(new OffsetMapping.ForStackManipulation.Factory(cls, constantValue.toStackManipulation(),
                    constantValue.getTypeDescription().asGenericType()));
        }

        public <T extends Annotation> WithCustomMapping bind(Class<T> cls, StackManipulation stackManipulation,
                java.lang.reflect.Type type) {
            return bind(cls, stackManipulation, TypeDefinition.Sort.describe(type));
        }

        public <T extends Annotation> WithCustomMapping bind(Class<T> cls, StackManipulation stackManipulation,
                TypeDescription.Generic generic) {
            return bind(new OffsetMapping.ForStackManipulation.Factory(cls, stackManipulation, generic));
        }

        public <T extends Annotation> WithCustomMapping bind(Class<T> cls, OffsetMapping offsetMapping) {
            return bind(new OffsetMapping.Factory.Simple(cls, offsetMapping));
        }

        public WithCustomMapping bind(OffsetMapping.Factory<?> factory) {
            LinkedHashMap linkedHashMap = new LinkedHashMap(this.offsetMappings);
            if (factory.getAnnotationType().isAnnotation()) {
                if (linkedHashMap.put(factory.getAnnotationType(), factory) == null) {
                    return new WithCustomMapping(this.postProcessorFactory, linkedHashMap, this.delegatorFactory,
                            this.classReaderFactory);
                }
                throw new IllegalArgumentException("Annotation type already mapped: " + factory.getAnnotationType());
            }
            throw new IllegalArgumentException("Not an annotation type: " + factory.getAnnotationType());
        }
    }

    static {
        MethodList<MethodDescription.InDefinedShape> declaredMethods = TypeDescription.ForLoadedType
                .of(OnMethodEnter.class).getDeclaredMethods();
        SKIP_ON = (MethodDescription.InDefinedShape) declaredMethods.filter(ElementMatchers.named("skipOn")).getOnly();
        SKIP_ON_INDEX = (MethodDescription.InDefinedShape) declaredMethods.filter(ElementMatchers.named("skipOnIndex"))
                .getOnly();
        PREPEND_LINE_NUMBER = (MethodDescription.InDefinedShape) declaredMethods
                .filter(ElementMatchers.named("prependLineNumber")).getOnly();
        INLINE_ENTER = (MethodDescription.InDefinedShape) declaredMethods.filter(ElementMatchers.named("inline"))
                .getOnly();
        SUPPRESS_ENTER = (MethodDescription.InDefinedShape) declaredMethods.filter(ElementMatchers.named("suppress"))
                .getOnly();
        MethodList<MethodDescription.InDefinedShape> declaredMethods2 = TypeDescription.ForLoadedType
                .of(OnMethodExit.class).getDeclaredMethods();
        REPEAT_ON = (MethodDescription.InDefinedShape) declaredMethods2.filter(ElementMatchers.named("repeatOn"))
                .getOnly();
        REPEAT_ON_INDEX = (MethodDescription.InDefinedShape) declaredMethods2
                .filter(ElementMatchers.named("repeatOnIndex")).getOnly();
        ON_THROWABLE = (MethodDescription.InDefinedShape) declaredMethods2.filter(ElementMatchers.named("onThrowable"))
                .getOnly();
        BACKUP_ARGUMENTS = (MethodDescription.InDefinedShape) declaredMethods2
                .filter(ElementMatchers.named("backupArguments")).getOnly();
        INLINE_EXIT = (MethodDescription.InDefinedShape) declaredMethods2.filter(ElementMatchers.named("inline"))
                .getOnly();
        SUPPRESS_EXIT = (MethodDescription.InDefinedShape) declaredMethods2.filter(ElementMatchers.named("suppress"))
                .getOnly();
    }

    public Advice(Dispatcher.Resolved.ForMethodEnter forMethodEnter, Dispatcher.Resolved.ForMethodExit forMethodExit) {
        this(forMethodEnter, forMethodExit, Assigner.DEFAULT, ExceptionHandler.Default.SUPPRESSING,
                SuperMethodCall.INSTANCE);
    }

    private static Dispatcher.Unresolved locate(Class<? extends Annotation> cls,
            MethodDescription.InDefinedShape inDefinedShape, Dispatcher.Unresolved unresolved,
            MethodDescription.InDefinedShape inDefinedShape2, Delegator.Factory factory) {
        AnnotationDescription.Loadable loadableOfType = inDefinedShape2.getDeclaredAnnotations().ofType(cls);
        if (loadableOfType == null) {
            return unresolved;
        }
        if (unresolved.isAlive()) {
            throw new IllegalStateException("Duplicate advice for " + unresolved + " and " + inDefinedShape2);
        }
        if (inDefinedShape2.isStatic()) {
            return ((Boolean) loadableOfType.getValue(inDefinedShape).resolve(Boolean.class)).booleanValue()
                    ? new Dispatcher.Inlining(inDefinedShape2)
                    : new Dispatcher.Delegating(inDefinedShape2, factory);
        }
        throw new IllegalStateException("Advice for " + inDefinedShape2 + " is not static");
    }

    public static Advice to(Class<?> cls) {
        return to(cls, ClassFileLocator.ForClassLoader.of(cls.getClassLoader()));
    }

    public static WithCustomMapping withCustomMapping() {
        return new WithCustomMapping();
    }

    @Override // net.bytebuddy.implementation.Implementation
    public ByteCodeAppender appender(Implementation.Target target) {
        return new Appender(this, target, this.delegate.appender(target));
    }

    public MethodVisitor doWrap(TypeDescription typeDescription, MethodDescription methodDescription,
            MethodVisitor methodVisitor, Implementation.Context context, int i, int i2) {
        MethodVisitor lineNumberPrependingMethodVisitor = this.methodEnter.isPrependLineNumber()
                ? new LineNumberPrependingMethodVisitor(methodVisitor)
                : methodVisitor;
        if (!this.methodExit.isAlive()) {
            return new AdviceVisitor.WithoutExitAdvice(lineNumberPrependingMethodVisitor, context, this.assigner,
                    this.exceptionHandler.resolve(methodDescription, typeDescription), typeDescription,
                    methodDescription, this.methodEnter, i, i2);
        }
        if (this.methodExit.getThrowable().represents(NoExceptionHandler.class)) {
            return new AdviceVisitor.WithExitAdvice.WithoutExceptionHandling(lineNumberPrependingMethodVisitor, context,
                    this.assigner, this.exceptionHandler.resolve(methodDescription, typeDescription), typeDescription,
                    methodDescription, this.methodEnter, this.methodExit, i, i2);
        }
        if (methodDescription.isConstructor()) {
            throw new IllegalStateException(
                    StaticHelpers6.concat("Cannot catch exception during constructor call for ", methodDescription));
        }
        Assigner assigner = this.assigner;
        StackManipulation stackManipulationResolve = this.exceptionHandler.resolve(methodDescription, typeDescription);
        Dispatcher.Resolved.ForMethodEnter forMethodEnter = this.methodEnter;
        Dispatcher.Resolved.ForMethodExit forMethodExit = this.methodExit;
        return new AdviceVisitor.WithExitAdvice.WithExceptionHandling(lineNumberPrependingMethodVisitor, context,
                assigner, stackManipulationResolve, typeDescription, methodDescription, forMethodEnter, forMethodExit,
                i, i2, forMethodExit.getThrowable());
    }

    public boolean equals(@MaybeNull Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Advice advice = (Advice) obj;
        return this.methodEnter.equals(advice.methodEnter) && this.methodExit.equals(advice.methodExit)
                && this.assigner.equals(advice.assigner) && this.exceptionHandler.equals(advice.exceptionHandler)
                && this.delegate.equals(advice.delegate);
    }

    public int hashCode() {
        return this.delegate.hashCode() + ((this.exceptionHandler.hashCode() + StaticHelpers6.h(this.assigner,
                (this.methodExit.hashCode() + ((this.methodEnter.hashCode() + (getClass().hashCode() * 31)) * 31)) * 31,
                31)) * 31);
    }

    public AsmVisitorWrapper.ForDeclaredMethods on(ElementMatcher<? super MethodDescription> elementMatcher) {
        return new AsmVisitorWrapper.ForDeclaredMethods().invokable(elementMatcher, this);
    }

    @Override // net.bytebuddy.dynamic.scaffold.InstrumentedType.Prepareable
    public InstrumentedType prepare(InstrumentedType instrumentedType) {
        return this.delegate.prepare(instrumentedType);
    }

    public Advice withAssigner(Assigner assigner) {
        return new Advice(this.methodEnter, this.methodExit, assigner, this.exceptionHandler, this.delegate);
    }

    public Advice withExceptionHandler(StackManipulation stackManipulation) {
        return withExceptionHandler(new ExceptionHandler.Simple(stackManipulation));
    }

    public Advice withExceptionPrinting() {
        return withExceptionHandler(ExceptionHandler.Default.PRINTING);
    }

    @Override // net.bytebuddy.asm.AsmVisitorWrapper.ForDeclaredMethods.MethodVisitorWrapper
    public MethodVisitor wrap(TypeDescription typeDescription, MethodDescription methodDescription,
            MethodVisitor methodVisitor, Implementation.Context context, TypePool typePool, int i, int i2) {
        return (methodDescription.isAbstract() || methodDescription.isNative()) ? methodVisitor
                : doWrap(typeDescription, methodDescription, methodVisitor, context, i, i2);
    }

    private Advice(Dispatcher.Resolved.ForMethodEnter forMethodEnter, Dispatcher.Resolved.ForMethodExit forMethodExit,
            Assigner assigner, ExceptionHandler exceptionHandler, Implementation implementation) {
        this.methodEnter = forMethodEnter;
        this.methodExit = forMethodExit;
        this.assigner = assigner;
        this.exceptionHandler = exceptionHandler;
        this.delegate = implementation;
    }

    public static Advice to(Class<?> cls, ClassFileLocator classFileLocator) {
        return to(TypeDescription.ForLoadedType.of(cls), classFileLocator);
    }

    public Advice withExceptionHandler(ExceptionHandler exceptionHandler) {
        return new Advice(this.methodEnter, this.methodExit, this.assigner, exceptionHandler, this.delegate);
    }

    public static Advice to(TypeDescription typeDescription) {
        return to(typeDescription, ClassFileLocator.NoOp.INSTANCE);
    }

    public Implementation wrap(Implementation implementation) {
        return new Advice(this.methodEnter, this.methodExit, this.assigner, this.exceptionHandler, implementation);
    }

    public static Advice to(TypeDescription typeDescription, ClassFileLocator classFileLocator) {
        return to(typeDescription, PostProcessor.NoOp.INSTANCE, classFileLocator, Collections.EMPTY_LIST,
                Delegator.ForRegularInvocation.Factory.INSTANCE, AsmClassReader.Factory.Default.IMPLICIT);
    }

    public static Advice to(TypeDescription typeDescription, PostProcessor.Factory factory,
            ClassFileLocator classFileLocator, List<? extends OffsetMapping.Factory<?>> list,
            Delegator.Factory factory2, AsmClassReader.Factory factory3) {
        Dispatcher.Unresolved unresolvedLocate = Dispatcher.Inactive.INSTANCE;
        Dispatcher.Unresolved unresolvedLocate2 = unresolvedLocate;
        for (MethodDescription.InDefinedShape inDefinedShape : typeDescription.getDeclaredMethods()) {
            unresolvedLocate = locate(OnMethodEnter.class, INLINE_ENTER, unresolvedLocate, inDefinedShape, factory2);
            unresolvedLocate2 = locate(OnMethodExit.class, INLINE_EXIT, unresolvedLocate2, inDefinedShape, factory2);
        }
        if (!unresolvedLocate.isAlive() && !unresolvedLocate2.isAlive()) {
            throw new IllegalArgumentException(StaticHelpers6.concat("No advice defined by ", typeDescription));
        }
        try {
            AsmClassReader asmClassReaderMake = (unresolvedLocate.isBinary() || unresolvedLocate2.isBinary())
                    ? factory3.make(classFileLocator.locate(typeDescription.getName()).resolve())
                    : UNDEFINED;
            return new Advice(unresolvedLocate.asMethodEnter(list, asmClassReaderMake, unresolvedLocate2, factory),
                    unresolvedLocate2.asMethodExit(list, asmClassReaderMake, unresolvedLocate, factory));
        } catch (IOException e) {
            throw new IllegalStateException(StaticHelpers6.concat("Error reading class file of ", typeDescription), e);
        }
    }

    public static Advice to(Class<?> cls, Class<?> cls2) {
        ClassFileLocator compound;
        ClassLoader classLoader = cls.getClassLoader();
        ClassLoader classLoader2 = cls2.getClassLoader();
        if (classLoader == classLoader2) {
            compound = ClassFileLocator.ForClassLoader.of(classLoader);
        } else {
            compound = new ClassFileLocator.Compound(ClassFileLocator.ForClassLoader.of(classLoader),
                    ClassFileLocator.ForClassLoader.of(classLoader2));
        }
        return to(cls, cls2, compound);
    }

    public static Advice to(Class<?> cls, Class<?> cls2, ClassFileLocator classFileLocator) {
        return to(TypeDescription.ForLoadedType.of(cls), TypeDescription.ForLoadedType.of(cls2), classFileLocator);
    }

    public static Advice to(TypeDescription typeDescription, TypeDescription typeDescription2) {
        return to(typeDescription, typeDescription2, ClassFileLocator.NoOp.INSTANCE);
    }

    public static Advice to(TypeDescription typeDescription, TypeDescription typeDescription2,
            ClassFileLocator classFileLocator) {
        return to(typeDescription, typeDescription2, PostProcessor.NoOp.INSTANCE, classFileLocator,
                Collections.EMPTY_LIST, Delegator.ForRegularInvocation.Factory.INSTANCE,
                AsmClassReader.Factory.Default.IMPLICIT);
    }

    public static Advice to(TypeDescription typeDescription, TypeDescription typeDescription2,
            PostProcessor.Factory factory, ClassFileLocator classFileLocator,
            List<? extends OffsetMapping.Factory<?>> list, Delegator.Factory factory2,
            AsmClassReader.Factory factory3) {
        Dispatcher.Unresolved unresolvedLocate = Dispatcher.Inactive.INSTANCE;
        Iterator<MethodDescription.InDefinedShape> it = typeDescription.getDeclaredMethods().iterator();
        Dispatcher.Unresolved unresolvedLocate2 = unresolvedLocate;
        while (it.hasNext()) {
            unresolvedLocate2 = locate(OnMethodEnter.class, INLINE_ENTER, unresolvedLocate2, it.next(), factory2);
        }
        if (unresolvedLocate2.isAlive()) {
            Iterator<MethodDescription.InDefinedShape> it2 = typeDescription2.getDeclaredMethods().iterator();
            while (it2.hasNext()) {
                unresolvedLocate = locate(OnMethodExit.class, INLINE_EXIT, unresolvedLocate, it2.next(), factory2);
            }
            if (unresolvedLocate.isAlive()) {
                try {
                    return new Advice(
                            unresolvedLocate2
                                    .asMethodEnter(list,
                                            unresolvedLocate2
                                                    .isBinary()
                                                            ? factory3.make(classFileLocator
                                                                    .locate(typeDescription.getName()).resolve())
                                                            : UNDEFINED,
                                            unresolvedLocate, factory),
                            unresolvedLocate.asMethodExit(list,
                                    unresolvedLocate.isBinary()
                                            ? factory3
                                                    .make(classFileLocator.locate(typeDescription2.getName()).resolve())
                                            : UNDEFINED,
                                    unresolvedLocate2, factory));
                } catch (IOException e) {
                    throw new IllegalStateException(
                            "Error reading class file of " + typeDescription + " or " + typeDescription2, e);
                }
            }
            throw new IllegalArgumentException(StaticHelpers6.concat("No exit advice defined by ", typeDescription2));
        }
        throw new IllegalArgumentException(StaticHelpers6.concat("No enter advice defined by ", typeDescription));
    }
}

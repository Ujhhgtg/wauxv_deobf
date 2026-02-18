package net.bytebuddy.agent.builder;

import java.io.File;
import java.io.IOException;
import java.io.NotSerializableException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintStream;
import java.io.Serializable;
import java.lang.instrument.ClassDefinition;
import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.Instrumentation;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.net.URLClassLoader;
import java.security.AccessControlContext;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.security.ProtectionDomain;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import me.hd.wauxv.obf.bjs;
import me.hd.wauxv.obf.dkz;
import me.hd.wauxv.obf.dts;
import me.hd.wauxv.obf.yg;
import net.bytebuddy.ByteBuddy;
import net.bytebuddy.ClassFileVersion;
import net.bytebuddy.agent.builder.ResettableClassFileTransformer;
import net.bytebuddy.asm.Advice;
import net.bytebuddy.asm.AsmVisitorWrapper;
import net.bytebuddy.build.AccessControllerPlugin;
import net.bytebuddy.build.EntryPoint;
import net.bytebuddy.build.HashCodeAndEqualsPlugin;
import net.bytebuddy.build.Plugin;
import net.bytebuddy.build.SafeVarargsPlugin;
import net.bytebuddy.description.field.FieldDescription;
import net.bytebuddy.description.method.MethodDescription;
import net.bytebuddy.description.method.ParameterDescription;
import net.bytebuddy.description.modifier.FieldManifestation;
import net.bytebuddy.description.modifier.MethodManifestation;
import net.bytebuddy.description.modifier.Ownership;
import net.bytebuddy.description.modifier.TypeManifestation;
import net.bytebuddy.description.modifier.Visibility;
import net.bytebuddy.description.type.PackageDescription;
import net.bytebuddy.description.type.TypeDefinition;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.dynamic.ClassFileLocator;
import net.bytebuddy.dynamic.DynamicType;
import net.bytebuddy.dynamic.NexusAccessor;
import net.bytebuddy.dynamic.TypeResolutionStrategy;
import net.bytebuddy.dynamic.VisibilityBridgeStrategy;
import net.bytebuddy.dynamic.loading.ClassInjector;
import net.bytebuddy.dynamic.loading.ClassLoadingStrategy;
import net.bytebuddy.dynamic.loading.ClassReloadingStrategy;
import net.bytebuddy.dynamic.scaffold.InstrumentedType;
import net.bytebuddy.dynamic.scaffold.TypeValidation;
import net.bytebuddy.dynamic.scaffold.inline.MethodNameTransformer;
import net.bytebuddy.dynamic.scaffold.subclass.ConstructorStrategy;
import net.bytebuddy.implementation.ExceptionMethod;
import net.bytebuddy.implementation.Implementation;
import net.bytebuddy.implementation.LoadedTypeInitializer;
import net.bytebuddy.implementation.MethodCall;
import net.bytebuddy.implementation.auxiliary.AuxiliaryType;
import net.bytebuddy.implementation.auxiliary.TypeProxy;
import net.bytebuddy.implementation.bytecode.ByteCodeAppender;
import net.bytebuddy.implementation.bytecode.Duplication;
import net.bytebuddy.implementation.bytecode.StackManipulation;
import net.bytebuddy.implementation.bytecode.TypeCreation;
import net.bytebuddy.implementation.bytecode.assign.Assigner;
import net.bytebuddy.implementation.bytecode.assign.TypeCasting;
import net.bytebuddy.implementation.bytecode.collection.ArrayFactory;
import net.bytebuddy.implementation.bytecode.constant.ClassConstant;
import net.bytebuddy.implementation.bytecode.constant.IntegerConstant;
import net.bytebuddy.implementation.bytecode.constant.TextConstant;
import net.bytebuddy.implementation.bytecode.member.FieldAccess;
import net.bytebuddy.implementation.bytecode.member.MethodInvocation;
import net.bytebuddy.implementation.bytecode.member.MethodReturn;
import net.bytebuddy.implementation.bytecode.member.MethodVariableAccess;
import net.bytebuddy.jar.asm.ConstantDynamic;
import net.bytebuddy.jar.asm.Handle;
import net.bytebuddy.jar.asm.Label;
import net.bytebuddy.jar.asm.MethodVisitor;
import net.bytebuddy.jar.asm.Opcodes;
import net.bytebuddy.jar.asm.Type;
import net.bytebuddy.matcher.ElementMatcher;
import net.bytebuddy.matcher.ElementMatchers;
import net.bytebuddy.matcher.LatentMatcher;
import net.bytebuddy.pool.TypePool;
import net.bytebuddy.utility.CompoundList;
import net.bytebuddy.utility.JavaConstant;
import net.bytebuddy.utility.JavaModule;
import net.bytebuddy.utility.JavaType;
import net.bytebuddy.utility.dispatcher.JavaDispatcher;
import net.bytebuddy.utility.nullability.AlwaysNull;
import net.bytebuddy.utility.nullability.MaybeNull;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public interface AgentBuilder {

    /*
     * JADX INFO: compiled from:
     * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
     */
    public interface CircularityLock {

        /*
         * JADX INFO: compiled from:
         * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
         */
        @HashCodeAndEqualsPlugin.Enhance
        public static class Global extends WithInnerClassLoadingLock {
            private final Lock lock;
            private final long time;
            private final TimeUnit timeUnit;

            public Global() {
                this(100);
            }

            @Override // net.bytebuddy.agent.builder.AgentBuilder.CircularityLock.WithInnerClassLoadingLock
            public boolean doAcquire() {
                try {
                    long j = this.time;
                    return j == 0 ? this.lock.tryLock() : this.lock.tryLock(j, this.timeUnit);
                } catch (InterruptedException unused) {
                    return false;
                }
            }

            public boolean equals(@MaybeNull Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || getClass() != obj.getClass()) {
                    return false;
                }
                Global global = (Global) obj;
                return this.time == global.time && this.timeUnit.equals(global.timeUnit)
                        && this.lock.equals(global.lock);
            }

            public int hashCode() {
                int iHashCode = (this.lock.hashCode() + (getClass().hashCode() * 31)) * 31;
                long j = this.time;
                return this.timeUnit.hashCode() + ((iHashCode + ((int) (j ^ (j >>> 32)))) * 31);
            }

            @Override // net.bytebuddy.agent.builder.AgentBuilder.CircularityLock
            public void release() {
                this.lock.unlock();
            }

            public Global(long j, TimeUnit timeUnit) {
                this(100, j, timeUnit);
            }

            public Global(int i) {
                this(i, 0L, TimeUnit.MILLISECONDS);
            }

            public Global(int i, long j, TimeUnit timeUnit) {
                super(i);
                this.lock = new ReentrantLock();
                this.time = j;
                this.timeUnit = timeUnit;
            }
        }

        /*
         * JADX INFO: compiled from:
         * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
         */
        public enum Inactive implements CircularityLock {
            INSTANCE;

            @Override // net.bytebuddy.agent.builder.AgentBuilder.CircularityLock
            public boolean acquire() {
                return true;
            }

            @Override // net.bytebuddy.agent.builder.AgentBuilder.CircularityLock
            public void release() {
            }
        }

        /*
         * JADX INFO: compiled from:
         * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
         */
        public static abstract class WithInnerClassLoadingLock implements CircularityLock {
            protected static final int DEFAULT_SIZE = 100;
            private final TrivialLock[] lock;

            /*
             * JADX INFO: compiled from:
             * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
             */
            public static class TrivialLock {
                protected boolean locked;
            }

            public WithInnerClassLoadingLock(int i) {
                this.lock = new TrivialLock[i];
                for (int i2 = 0; i2 < i; i2++) {
                    this.lock[i2] = new TrivialLock();
                }
            }

            /*
             * JADX WARN: Undo finally extract visitor
             * java.lang.NullPointerException: Cannot invoke
             * "jadx.core.dex.nodes.BlockNode.getInstructions()" because
             * "finallyBlockTerminus" is null
             * at
             * jadx.core.dex.visitors.finaly.traverser.state.TraverserActivePathState.<init>
             * (TraverserActivePathState.java:253)
             * at jadx.core.dex.visitors.finaly.MarkFinallyVisitor.findCommonInsns(
             * MarkFinallyVisitor.java:422)
             * at jadx.core.dex.visitors.finaly.MarkFinallyVisitor.extractFinally(
             * MarkFinallyVisitor.java:302)
             * at jadx.core.dex.visitors.finaly.MarkFinallyVisitor.processTryBlock(
             * MarkFinallyVisitor.java:222)
             * at jadx.core.dex.visitors.finaly.MarkFinallyVisitor.visit(MarkFinallyVisitor.
             * java:150)
             */
            @Override // net.bytebuddy.agent.builder.AgentBuilder.CircularityLock
            public boolean acquire() {
                TrivialLock trivialLock;
                TrivialLock[] trivialLockArr = this.lock;
                if (trivialLockArr.length == 0) {
                    return doAcquire();
                }
                if (trivialLockArr.length == 1) {
                    trivialLock = trivialLockArr[0];
                } else {
                    int iIdentityHashCode = System.identityHashCode(Thread.currentThread());
                    trivialLock = this.lock[iIdentityHashCode == Integer.MIN_VALUE ? 0
                            : Math.abs(iIdentityHashCode) % this.lock.length];
                }
                synchronized (trivialLock) {
                    try {
                        if (trivialLock.locked) {
                            return false;
                        }
                        trivialLock.locked = true;
                        try {
                            boolean zDoAcquire = doAcquire();
                            trivialLock.locked = false;
                            return zDoAcquire;
                        } catch (Throwable th) {
                            trivialLock.locked = false;
                            throw th;
                        }
                    } catch (Throwable th2) {
                        throw th2;
                    }
                }
            }

            public abstract boolean doAcquire();
        }

        boolean acquire();

        void release();

        /*
         * JADX INFO: compiled from:
         * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
         */
        public static class Default extends WithInnerClassLoadingLock {
            private final ConcurrentMap<Thread, Boolean> threads;

            public Default() {
                super(100);
                this.threads = new ConcurrentHashMap();
            }

            @Override // net.bytebuddy.agent.builder.AgentBuilder.CircularityLock.WithInnerClassLoadingLock
            public boolean doAcquire() {
                return this.threads.putIfAbsent(Thread.currentThread(), Boolean.TRUE) == null;
            }

            public boolean isLocked() {
                return this.threads.containsKey(Thread.currentThread());
            }

            @Override // net.bytebuddy.agent.builder.AgentBuilder.CircularityLock
            public void release() {
                this.threads.remove(Thread.currentThread());
            }

            public Default(int i) {
                super(i);
                this.threads = new ConcurrentHashMap();
            }
        }
    }

    /*
     * JADX INFO: compiled from:
     * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
     */
    public interface ClassFileBufferStrategy {

        /*
         * JADX INFO: compiled from:
         * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
         */
        public enum Default implements ClassFileBufferStrategy {
            RETAINING { // from class:
                        // net.bytebuddy.agent.builder.AgentBuilder.ClassFileBufferStrategy.Default.1
                @Override // net.bytebuddy.agent.builder.AgentBuilder.ClassFileBufferStrategy
                public ClassFileLocator resolve(String str, byte[] bArr, @MaybeNull ClassLoader classLoader,
                        @MaybeNull JavaModule javaModule, @MaybeNull ProtectionDomain protectionDomain) {
                    return ClassFileLocator.Simple.of(str, bArr);
                }

                @Override // net.bytebuddy.agent.builder.AgentBuilder.ClassFileBufferStrategy
                public TypePool typePool(PoolStrategy poolStrategy, ClassFileLocator classFileLocator,
                        @MaybeNull ClassLoader classLoader, String str) {
                    return poolStrategy.typePool(classFileLocator, classLoader, str);
                }
            },
            DISCARDING { // from class:
                         // net.bytebuddy.agent.builder.AgentBuilder.ClassFileBufferStrategy.Default.2
                @Override // net.bytebuddy.agent.builder.AgentBuilder.ClassFileBufferStrategy
                public ClassFileLocator resolve(String str, byte[] bArr, @MaybeNull ClassLoader classLoader,
                        @MaybeNull JavaModule javaModule, @MaybeNull ProtectionDomain protectionDomain) {
                    return ClassFileLocator.NoOp.INSTANCE;
                }

                @Override // net.bytebuddy.agent.builder.AgentBuilder.ClassFileBufferStrategy
                public TypePool typePool(PoolStrategy poolStrategy, ClassFileLocator classFileLocator,
                        @MaybeNull ClassLoader classLoader, String str) {
                    return poolStrategy.typePool(classFileLocator, classLoader);
                }
            }
        }

        ClassFileLocator resolve(String str, byte[] bArr, @MaybeNull ClassLoader classLoader,
                @MaybeNull JavaModule javaModule, @MaybeNull ProtectionDomain protectionDomain);

        TypePool typePool(PoolStrategy poolStrategy, ClassFileLocator classFileLocator,
                @MaybeNull ClassLoader classLoader, String str);
    }

    /*
     * JADX INFO: compiled from:
     * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
     */
    @HashCodeAndEqualsPlugin.Enhance
    public static class Default implements AgentBuilder {
        private static final boolean ACCESS_CONTROLLER;
        private static final CircularityLock DEFAULT_LOCK;
        private static final Dispatcher DISPATCHER;
        private static final String INSTALLER_GETTER = "getInstrumentation";
        private static final String INSTALLER_TYPE = "net.bytebuddy.agent.Installer";

        @AlwaysNull
        private static final Class<?> NOT_PREVIOUSLY_DEFINED;

        @AlwaysNull
        private static final byte[] NO_TRANSFORMATION;
        protected final ByteBuddy byteBuddy;
        protected final CircularityLock circularityLock;
        protected final ClassFileBufferStrategy classFileBufferStrategy;
        protected final ClassFileLocator classFileLocator;
        protected final DescriptionStrategy descriptionStrategy;
        protected final FallbackStrategy fallbackStrategy;
        protected final RawMatcher ignoreMatcher;
        protected final InitializationStrategy initializationStrategy;
        protected final InjectionStrategy injectionStrategy;
        protected final InstallationListener installationListener;
        protected final LambdaInstrumentationStrategy lambdaInstrumentationStrategy;
        protected final Listener listener;
        protected final LocationStrategy locationStrategy;
        protected final NativeMethodStrategy nativeMethodStrategy;
        protected final PoolStrategy poolStrategy;
        protected final RedefinitionStrategy.BatchAllocator redefinitionBatchAllocator;
        protected final RedefinitionStrategy.DiscoveryStrategy redefinitionDiscoveryStrategy;
        protected final RedefinitionStrategy.Listener redefinitionListener;
        protected final RedefinitionStrategy.ResubmissionStrategy redefinitionResubmissionStrategy;
        protected final RedefinitionStrategy redefinitionStrategy;
        protected final List<Transformation> transformations;
        protected final TransformerDecorator transformerDecorator;
        protected final TypeStrategy typeStrategy;
        protected final WarmupStrategy warmupStrategy;

        /*
         * JADX INFO: compiled from:
         * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
         */
        public static abstract class Delegator implements AgentBuilder {

            /*
             * JADX INFO: compiled from:
             * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
             */
            public static abstract class Matchable<S extends Matchable<S>> extends Delegator implements Matchable<S> {
                @Override // net.bytebuddy.agent.builder.AgentBuilder.Matchable
                public S and(ElementMatcher<? super TypeDescription> elementMatcher) {
                    return (S) and(elementMatcher, ElementMatchers.any());
                }

                @Override // net.bytebuddy.agent.builder.AgentBuilder.Matchable
                public S or(ElementMatcher<? super TypeDescription> elementMatcher) {
                    return (S) or(elementMatcher, ElementMatchers.any());
                }

                @Override // net.bytebuddy.agent.builder.AgentBuilder.Matchable
                public S and(ElementMatcher<? super TypeDescription> elementMatcher,
                        ElementMatcher<? super ClassLoader> elementMatcher2) {
                    return (S) and(elementMatcher, elementMatcher2, ElementMatchers.any());
                }

                @Override // net.bytebuddy.agent.builder.AgentBuilder.Matchable
                public S or(ElementMatcher<? super TypeDescription> elementMatcher,
                        ElementMatcher<? super ClassLoader> elementMatcher2) {
                    return (S) or(elementMatcher, elementMatcher2, ElementMatchers.any());
                }

                @Override // net.bytebuddy.agent.builder.AgentBuilder.Matchable
                public S and(ElementMatcher<? super TypeDescription> elementMatcher,
                        ElementMatcher<? super ClassLoader> elementMatcher2,
                        ElementMatcher<? super JavaModule> elementMatcher3) {
                    return and(new RawMatcher.ForElementMatchers(elementMatcher, elementMatcher2, elementMatcher3));
                }

                @Override // net.bytebuddy.agent.builder.AgentBuilder.Matchable
                public S or(ElementMatcher<? super TypeDescription> elementMatcher,
                        ElementMatcher<? super ClassLoader> elementMatcher2,
                        ElementMatcher<? super JavaModule> elementMatcher3) {
                    return or(new RawMatcher.ForElementMatchers(elementMatcher, elementMatcher2, elementMatcher3));
                }
            }

            @Override // net.bytebuddy.agent.builder.AgentBuilder
            public AgentBuilder assureReadEdgeFromAndTo(Instrumentation instrumentation, Class<?>... clsArr) {
                return materialize().assureReadEdgeFromAndTo(instrumentation, clsArr);
            }

            @Override // net.bytebuddy.agent.builder.AgentBuilder
            public AgentBuilder assureReadEdgeTo(Instrumentation instrumentation, Class<?>... clsArr) {
                return materialize().assureReadEdgeTo(instrumentation, clsArr);
            }

            @Override // net.bytebuddy.agent.builder.AgentBuilder
            public AgentBuilder disableClassFormatChanges() {
                return materialize().disableClassFormatChanges();
            }

            @Override // net.bytebuddy.agent.builder.AgentBuilder
            public AgentBuilder disableNativeMethodPrefix() {
                return materialize().disableNativeMethodPrefix();
            }

            @Override // net.bytebuddy.agent.builder.AgentBuilder
            public AgentBuilder enableNativeMethodPrefix(String str) {
                return materialize().enableNativeMethodPrefix(str);
            }

            @Override // net.bytebuddy.agent.builder.AgentBuilder
            public Ignored ignore(ElementMatcher<? super TypeDescription> elementMatcher) {
                return materialize().ignore(elementMatcher);
            }

            @Override // net.bytebuddy.agent.builder.AgentBuilder
            public ResettableClassFileTransformer installOn(Instrumentation instrumentation) {
                return materialize().installOn(instrumentation);
            }

            @Override // net.bytebuddy.agent.builder.AgentBuilder
            public ResettableClassFileTransformer installOnByteBuddyAgent() {
                return materialize().installOnByteBuddyAgent();
            }

            @Override // net.bytebuddy.agent.builder.AgentBuilder
            public ClassFileTransformer makeRaw() {
                return materialize().makeRaw();
            }

            public abstract AgentBuilder materialize();

            @Override // net.bytebuddy.agent.builder.AgentBuilder
            public ResettableClassFileTransformer patchOn(Instrumentation instrumentation,
                    ResettableClassFileTransformer resettableClassFileTransformer) {
                return materialize().patchOn(instrumentation, resettableClassFileTransformer);
            }

            @Override // net.bytebuddy.agent.builder.AgentBuilder
            public ResettableClassFileTransformer patchOnByteBuddyAgent(
                    ResettableClassFileTransformer resettableClassFileTransformer) {
                return materialize().patchOnByteBuddyAgent(resettableClassFileTransformer);
            }

            @Override // net.bytebuddy.agent.builder.AgentBuilder
            public Identified.Narrowable type(ElementMatcher<? super TypeDescription> elementMatcher) {
                return materialize().type(elementMatcher);
            }

            @Override // net.bytebuddy.agent.builder.AgentBuilder
            public AgentBuilder warmUp(Class<?>... clsArr) {
                return materialize().warmUp(clsArr);
            }

            @Override // net.bytebuddy.agent.builder.AgentBuilder
            public AgentBuilder with(ByteBuddy byteBuddy) {
                return materialize().with(byteBuddy);
            }

            @Override // net.bytebuddy.agent.builder.AgentBuilder
            public AgentBuilder assureReadEdgeFromAndTo(Instrumentation instrumentation, JavaModule... javaModuleArr) {
                return materialize().assureReadEdgeFromAndTo(instrumentation, javaModuleArr);
            }

            @Override // net.bytebuddy.agent.builder.AgentBuilder
            public AgentBuilder assureReadEdgeTo(Instrumentation instrumentation, JavaModule... javaModuleArr) {
                return materialize().assureReadEdgeTo(instrumentation, javaModuleArr);
            }

            @Override // net.bytebuddy.agent.builder.AgentBuilder
            public Ignored ignore(ElementMatcher<? super TypeDescription> elementMatcher,
                    ElementMatcher<? super ClassLoader> elementMatcher2) {
                return materialize().ignore(elementMatcher, elementMatcher2);
            }

            @Override // net.bytebuddy.agent.builder.AgentBuilder
            public ResettableClassFileTransformer patchOn(Instrumentation instrumentation,
                    ResettableClassFileTransformer resettableClassFileTransformer, RawMatcher rawMatcher) {
                return materialize().patchOn(instrumentation, resettableClassFileTransformer, rawMatcher);
            }

            @Override // net.bytebuddy.agent.builder.AgentBuilder
            public ResettableClassFileTransformer patchOnByteBuddyAgent(
                    ResettableClassFileTransformer resettableClassFileTransformer, PatchMode patchMode) {
                return materialize().patchOnByteBuddyAgent(resettableClassFileTransformer, patchMode);
            }

            @Override // net.bytebuddy.agent.builder.AgentBuilder
            public Identified.Narrowable type(ElementMatcher<? super TypeDescription> elementMatcher,
                    ElementMatcher<? super ClassLoader> elementMatcher2) {
                return materialize().type(elementMatcher, elementMatcher2);
            }

            @Override // net.bytebuddy.agent.builder.AgentBuilder
            public AgentBuilder warmUp(Collection<Class<?>> collection) {
                return materialize().warmUp(collection);
            }

            @Override // net.bytebuddy.agent.builder.AgentBuilder
            public AgentBuilder with(Listener listener) {
                return materialize().with(listener);
            }

            @Override // net.bytebuddy.agent.builder.AgentBuilder
            public AgentBuilder assureReadEdgeFromAndTo(Instrumentation instrumentation,
                    Collection<? extends JavaModule> collection) {
                return materialize().assureReadEdgeFromAndTo(instrumentation, collection);
            }

            @Override // net.bytebuddy.agent.builder.AgentBuilder
            public AgentBuilder assureReadEdgeTo(Instrumentation instrumentation,
                    Collection<? extends JavaModule> collection) {
                return materialize().assureReadEdgeTo(instrumentation, collection);
            }

            @Override // net.bytebuddy.agent.builder.AgentBuilder
            public Ignored ignore(ElementMatcher<? super TypeDescription> elementMatcher,
                    ElementMatcher<? super ClassLoader> elementMatcher2,
                    ElementMatcher<? super JavaModule> elementMatcher3) {
                return materialize().ignore(elementMatcher, elementMatcher2, elementMatcher3);
            }

            @Override // net.bytebuddy.agent.builder.AgentBuilder
            public ResettableClassFileTransformer patchOn(Instrumentation instrumentation,
                    ResettableClassFileTransformer resettableClassFileTransformer, PatchMode patchMode) {
                return materialize().patchOn(instrumentation, resettableClassFileTransformer, patchMode);
            }

            @Override // net.bytebuddy.agent.builder.AgentBuilder
            public Identified.Narrowable type(ElementMatcher<? super TypeDescription> elementMatcher,
                    ElementMatcher<? super ClassLoader> elementMatcher2,
                    ElementMatcher<? super JavaModule> elementMatcher3) {
                return materialize().type(elementMatcher, elementMatcher2, elementMatcher3);
            }

            @Override // net.bytebuddy.agent.builder.AgentBuilder
            public AgentBuilder with(CircularityLock circularityLock) {
                return materialize().with(circularityLock);
            }

            @Override // net.bytebuddy.agent.builder.AgentBuilder
            public Ignored ignore(RawMatcher rawMatcher) {
                return materialize().ignore(rawMatcher);
            }

            @Override // net.bytebuddy.agent.builder.AgentBuilder
            public ResettableClassFileTransformer patchOn(Instrumentation instrumentation,
                    ResettableClassFileTransformer resettableClassFileTransformer, RawMatcher rawMatcher,
                    PatchMode patchMode) {
                return materialize().patchOn(instrumentation, resettableClassFileTransformer, rawMatcher, patchMode);
            }

            @Override // net.bytebuddy.agent.builder.AgentBuilder
            public Identified.Narrowable type(RawMatcher rawMatcher) {
                return materialize().type(rawMatcher);
            }

            @Override // net.bytebuddy.agent.builder.AgentBuilder
            public AgentBuilder with(TypeStrategy typeStrategy) {
                return materialize().with(typeStrategy);
            }

            @Override // net.bytebuddy.agent.builder.AgentBuilder
            public AgentBuilder with(PoolStrategy poolStrategy) {
                return materialize().with(poolStrategy);
            }

            @Override // net.bytebuddy.agent.builder.AgentBuilder
            public AgentBuilder with(LocationStrategy locationStrategy) {
                return materialize().with(locationStrategy);
            }

            @Override // net.bytebuddy.agent.builder.AgentBuilder
            public AgentBuilder with(ClassFileLocator classFileLocator) {
                return materialize().with(classFileLocator);
            }

            @Override // net.bytebuddy.agent.builder.AgentBuilder
            public AgentBuilder with(InitializationStrategy initializationStrategy) {
                return materialize().with(initializationStrategy);
            }

            @Override // net.bytebuddy.agent.builder.AgentBuilder
            public RedefinitionListenable.WithoutBatchStrategy with(RedefinitionStrategy redefinitionStrategy) {
                return materialize().with(redefinitionStrategy);
            }

            @Override // net.bytebuddy.agent.builder.AgentBuilder
            public AgentBuilder with(LambdaInstrumentationStrategy lambdaInstrumentationStrategy) {
                return materialize().with(lambdaInstrumentationStrategy);
            }

            @Override // net.bytebuddy.agent.builder.AgentBuilder
            public AgentBuilder with(DescriptionStrategy descriptionStrategy) {
                return materialize().with(descriptionStrategy);
            }

            @Override // net.bytebuddy.agent.builder.AgentBuilder
            public AgentBuilder with(FallbackStrategy fallbackStrategy) {
                return materialize().with(fallbackStrategy);
            }

            @Override // net.bytebuddy.agent.builder.AgentBuilder
            public AgentBuilder with(ClassFileBufferStrategy classFileBufferStrategy) {
                return materialize().with(classFileBufferStrategy);
            }

            @Override // net.bytebuddy.agent.builder.AgentBuilder
            public AgentBuilder with(InstallationListener installationListener) {
                return materialize().with(installationListener);
            }

            @Override // net.bytebuddy.agent.builder.AgentBuilder
            public AgentBuilder with(InjectionStrategy injectionStrategy) {
                return materialize().with(injectionStrategy);
            }

            @Override // net.bytebuddy.agent.builder.AgentBuilder
            public AgentBuilder with(TransformerDecorator transformerDecorator) {
                return materialize().with(transformerDecorator);
            }
        }

        /*
         * JADX INFO: compiled from:
         * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
         */
        @JavaDispatcher.Proxied("java.lang.instrument.Instrumentation")
        public interface Dispatcher {
            @JavaDispatcher.Proxied("addTransformer")
            void addTransformer(Instrumentation instrumentation, ClassFileTransformer classFileTransformer, boolean z);

            @JavaDispatcher.Defaults
            @JavaDispatcher.Proxied("isNativeMethodPrefixSupported")
            boolean isNativeMethodPrefixSupported(Instrumentation instrumentation);

            @JavaDispatcher.Proxied("setNativeMethodPrefix")
            void setNativeMethodPrefix(Instrumentation instrumentation, ClassFileTransformer classFileTransformer,
                    String str);
        }

        /*
         * JADX INFO: compiled from:
         * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
         */
        @HashCodeAndEqualsPlugin.Enhance(includeSyntheticFields = true)
        public class Ignoring extends Delegator.Matchable<Ignored> implements Ignored {
            private final RawMatcher rawMatcher;

            public Ignoring(RawMatcher rawMatcher) {
                this.rawMatcher = rawMatcher;
            }

            public boolean equals(@MaybeNull Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || getClass() != obj.getClass()) {
                    return false;
                }
                Ignoring ignoring = (Ignoring) obj;
                return this.rawMatcher.equals(ignoring.rawMatcher) && Default.this.equals(Default.this);
            }

            public int hashCode() {
                return Default.this.hashCode() + ((this.rawMatcher.hashCode() + (getClass().hashCode() * 31)) * 31);
            }

            @Override // net.bytebuddy.agent.builder.AgentBuilder.Default.Delegator
            public AgentBuilder materialize() {
                Default r2 = Default.this;
                return new Default(r2.byteBuddy, r2.listener, r2.circularityLock, r2.poolStrategy, r2.typeStrategy,
                        r2.locationStrategy, r2.classFileLocator, r2.nativeMethodStrategy, r2.warmupStrategy,
                        r2.transformerDecorator, r2.initializationStrategy, r2.redefinitionStrategy,
                        r2.redefinitionDiscoveryStrategy, r2.redefinitionBatchAllocator, r2.redefinitionListener,
                        r2.redefinitionResubmissionStrategy, r2.injectionStrategy, r2.lambdaInstrumentationStrategy,
                        r2.descriptionStrategy, r2.fallbackStrategy, r2.classFileBufferStrategy,
                        r2.installationListener, this.rawMatcher, r2.transformations);
            }

            @Override // net.bytebuddy.agent.builder.AgentBuilder.Matchable
            public Ignored and(RawMatcher rawMatcher) {
                return Default.this.new Ignoring(new RawMatcher.Conjunction(this.rawMatcher, rawMatcher));
            }

            @Override // net.bytebuddy.agent.builder.AgentBuilder.Matchable
            public Ignored or(RawMatcher rawMatcher) {
                return Default.this.new Ignoring(new RawMatcher.Disjunction(this.rawMatcher, rawMatcher));
            }
        }

        /*
         * JADX INFO: compiled from:
         * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
         */
        public interface NativeMethodStrategy {

            /*
             * JADX INFO: compiled from:
             * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
             */
            public enum Disabled implements NativeMethodStrategy {
                INSTANCE;

                @Override // net.bytebuddy.agent.builder.AgentBuilder.Default.NativeMethodStrategy
                public void apply(Instrumentation instrumentation, ClassFileTransformer classFileTransformer) {
                }

                @Override // net.bytebuddy.agent.builder.AgentBuilder.Default.NativeMethodStrategy
                public MethodNameTransformer resolve() {
                    return MethodNameTransformer.Suffixing.withRandomSuffix();
                }
            }

            /*
             * JADX INFO: compiled from:
             * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
             */
            @HashCodeAndEqualsPlugin.Enhance
            public static class ForPrefix implements NativeMethodStrategy {
                private final String prefix;

                public ForPrefix(String str) {
                    this.prefix = str;
                }

                public static NativeMethodStrategy of(String str) {
                    if (str.length() != 0) {
                        return new ForPrefix(str);
                    }
                    throw new IllegalArgumentException("A method name prefix must not be the empty string");
                }

                @Override // net.bytebuddy.agent.builder.AgentBuilder.Default.NativeMethodStrategy
                public void apply(Instrumentation instrumentation, ClassFileTransformer classFileTransformer) {
                    if (Default.DISPATCHER.isNativeMethodPrefixSupported(instrumentation)) {
                        Default.DISPATCHER.setNativeMethodPrefix(instrumentation, classFileTransformer, this.prefix);
                    } else {
                        throw new IllegalArgumentException(
                                "A prefix for native methods is not supported: " + instrumentation);
                    }
                }

                public boolean equals(@MaybeNull Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    return obj != null && getClass() == obj.getClass() && this.prefix.equals(((ForPrefix) obj).prefix);
                }

                public int hashCode() {
                    return this.prefix.hashCode() + (getClass().hashCode() * 31);
                }

                @Override // net.bytebuddy.agent.builder.AgentBuilder.Default.NativeMethodStrategy
                public MethodNameTransformer resolve() {
                    return new MethodNameTransformer.Prefixing(this.prefix);
                }
            }

            void apply(Instrumentation instrumentation, ClassFileTransformer classFileTransformer);

            MethodNameTransformer resolve();
        }

        /*
         * JADX INFO: compiled from:
         * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
         */
        @HashCodeAndEqualsPlugin.Enhance
        public static class Transformation {

            @AlwaysNull
            private static final byte[] NONE = null;
            private final RawMatcher matcher;
            private final boolean terminal;
            private final List<Transformer> transformers;

            /*
             * JADX INFO: compiled from:
             * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
             */
            @HashCodeAndEqualsPlugin.Enhance
            public static class DifferentialMatcher implements RawMatcher {
                private final ResettableClassFileTransformer classFileTransformer;
                private final RawMatcher ignoreMatcher;
                private final List<Transformation> transformations;

                public DifferentialMatcher(RawMatcher rawMatcher, List<Transformation> list,
                        ResettableClassFileTransformer resettableClassFileTransformer) {
                    this.ignoreMatcher = rawMatcher;
                    this.transformations = list;
                    this.classFileTransformer = resettableClassFileTransformer;
                }

                public boolean equals(@MaybeNull Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (obj == null || getClass() != obj.getClass()) {
                        return false;
                    }
                    DifferentialMatcher differentialMatcher = (DifferentialMatcher) obj;
                    return this.ignoreMatcher.equals(differentialMatcher.ignoreMatcher)
                            && this.transformations.equals(differentialMatcher.transformations)
                            && this.classFileTransformer.equals(differentialMatcher.classFileTransformer);
                }

                public int hashCode() {
                    return this.classFileTransformer.hashCode() + bjs.g(this.transformations,
                            (this.ignoreMatcher.hashCode() + (getClass().hashCode() * 31)) * 31, 31);
                }

                @Override // net.bytebuddy.agent.builder.AgentBuilder.RawMatcher
                public boolean matches(TypeDescription typeDescription, @MaybeNull ClassLoader classLoader,
                        @MaybeNull JavaModule javaModule, @MaybeNull Class<?> cls,
                        @MaybeNull ProtectionDomain protectionDomain) {
                    Iterator<Transformer> it = this.classFileTransformer.iterator(typeDescription, classLoader,
                            javaModule, cls, protectionDomain);
                    if (this.ignoreMatcher.matches(typeDescription, classLoader, javaModule, cls, protectionDomain)) {
                        return it.hasNext();
                    }
                    for (Transformation transformation : this.transformations) {
                        if (transformation.getMatcher().matches(typeDescription, classLoader, javaModule, cls,
                                protectionDomain)) {
                            for (Transformer transformer : transformation.getTransformers()) {
                                if (!it.hasNext() || !it.next().equals(transformer)) {
                                    return true;
                                }
                            }
                        }
                    }
                    return it.hasNext();
                }
            }

            /*
             * JADX INFO: compiled from:
             * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
             */
            @HashCodeAndEqualsPlugin.Enhance
            public static class SimpleMatcher implements RawMatcher {
                private final RawMatcher ignoreMatcher;
                private final List<Transformation> transformations;

                public SimpleMatcher(RawMatcher rawMatcher, List<Transformation> list) {
                    this.ignoreMatcher = rawMatcher;
                    this.transformations = list;
                }

                public boolean equals(@MaybeNull Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (obj == null || getClass() != obj.getClass()) {
                        return false;
                    }
                    SimpleMatcher simpleMatcher = (SimpleMatcher) obj;
                    return this.ignoreMatcher.equals(simpleMatcher.ignoreMatcher)
                            && this.transformations.equals(simpleMatcher.transformations);
                }

                public int hashCode() {
                    return this.transformations.hashCode()
                            + ((this.ignoreMatcher.hashCode() + (getClass().hashCode() * 31)) * 31);
                }

                @Override // net.bytebuddy.agent.builder.AgentBuilder.RawMatcher
                public boolean matches(TypeDescription typeDescription, @MaybeNull ClassLoader classLoader,
                        @MaybeNull JavaModule javaModule, @MaybeNull Class<?> cls,
                        @MaybeNull ProtectionDomain protectionDomain) {
                    if (this.ignoreMatcher.matches(typeDescription, classLoader, javaModule, cls, protectionDomain)) {
                        return false;
                    }
                    Iterator<Transformation> it = this.transformations.iterator();
                    while (it.hasNext()) {
                        if (it.next().getMatcher().matches(typeDescription, classLoader, javaModule, cls,
                                protectionDomain)) {
                            return true;
                        }
                    }
                    return false;
                }
            }

            /*
             * JADX INFO: compiled from:
             * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
             */
            public static class TransformerIterator implements Iterator<Transformer> {

                @MaybeNull
                private final Class<?> classBeingRedefined;

                @MaybeNull
                private final ClassLoader classLoader;

                @MaybeNull
                private final JavaModule module;

                @MaybeNull
                private final ProtectionDomain protectionDomain;
                private final Iterator<Transformation> transformations;
                private Iterator<Transformer> transformers;
                private final TypeDescription typeDescription;

                public TransformerIterator(TypeDescription typeDescription, @MaybeNull ClassLoader classLoader,
                        @MaybeNull JavaModule javaModule, @MaybeNull Class<?> cls,
                        @MaybeNull ProtectionDomain protectionDomain, List<Transformation> list) {
                    this.typeDescription = typeDescription;
                    this.classLoader = classLoader;
                    this.module = javaModule;
                    this.classBeingRedefined = cls;
                    this.protectionDomain = protectionDomain;
                    this.transformations = list.iterator();
                    this.transformers = Collections.EMPTY_SET.iterator();
                    while (!this.transformers.hasNext() && this.transformations.hasNext()) {
                        Transformation next = this.transformations.next();
                        TypeDescription typeDescription2 = typeDescription;
                        ClassLoader classLoader2 = classLoader;
                        JavaModule javaModule2 = javaModule;
                        Class<?> cls2 = cls;
                        ProtectionDomain protectionDomain2 = protectionDomain;
                        if (next.getMatcher().matches(typeDescription2, classLoader2, javaModule2, cls2,
                                protectionDomain2)) {
                            this.transformers = next.getTransformers().iterator();
                        }
                        typeDescription = typeDescription2;
                        classLoader = classLoader2;
                        javaModule = javaModule2;
                        cls = cls2;
                        protectionDomain = protectionDomain2;
                    }
                }

                @Override // java.util.Iterator
                public boolean hasNext() {
                    return this.transformers.hasNext();
                }

                @Override // java.util.Iterator
                public void remove() {
                    throw new UnsupportedOperationException("remove");
                }

                @Override // java.util.Iterator
                public Transformer next() {
                    boolean zHasNext;
                    try {
                        Transformer next = this.transformers.next();
                        while (!zHasNext) {
                            if (!zHasNext) {
                                break;
                            }
                            Transformation next2 = this.transformations.next();
                            if (next2.getMatcher().matches(this.typeDescription, this.classLoader, this.module,
                                    this.classBeingRedefined, this.protectionDomain)) {
                                this.transformers = next2.getTransformers().iterator();
                            }
                        }
                        return next;
                    } finally {
                        while (!this.transformers.hasNext() && this.transformations.hasNext()) {
                            Transformation next3 = this.transformations.next();
                            if (next3.getMatcher().matches(this.typeDescription, this.classLoader, this.module,
                                    this.classBeingRedefined, this.protectionDomain)) {
                                this.transformers = next3.getTransformers().iterator();
                            }
                        }
                    }
                }
            }

            public Transformation(RawMatcher rawMatcher, List<Transformer> list, boolean z) {
                this.matcher = rawMatcher;
                this.transformers = list;
                this.terminal = z;
            }

            public boolean equals(@MaybeNull Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || getClass() != obj.getClass()) {
                    return false;
                }
                Transformation transformation = (Transformation) obj;
                return this.terminal == transformation.terminal && this.matcher.equals(transformation.matcher)
                        && this.transformers.equals(transformation.transformers);
            }

            public RawMatcher getMatcher() {
                return this.matcher;
            }

            public List<Transformer> getTransformers() {
                return this.transformers;
            }

            public int hashCode() {
                return bjs.g(this.transformers, (this.matcher.hashCode() + (getClass().hashCode() * 31)) * 31, 31)
                        + (this.terminal ? 1 : 0);
            }

            public boolean isTerminal() {
                return this.terminal;
            }
        }

        /*
         * JADX INFO: compiled from:
         * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
         */
        @HashCodeAndEqualsPlugin.Enhance(includeSyntheticFields = true)
        public class Transforming extends Delegator.Matchable<Identified.Narrowable>
                implements Identified.Extendable, Identified.Narrowable {
            private final RawMatcher rawMatcher;
            private final boolean terminal;
            private final List<Transformer> transformers;

            public Transforming(RawMatcher rawMatcher, List<Transformer> list, boolean z) {
                this.rawMatcher = rawMatcher;
                this.transformers = list;
                this.terminal = z;
            }

            @Override // net.bytebuddy.agent.builder.AgentBuilder.Identified.Extendable
            public AgentBuilder asTerminalTransformation() {
                return Default.this.new Transforming(this.rawMatcher, this.transformers, true);
            }

            public boolean equals(@MaybeNull Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || getClass() != obj.getClass()) {
                    return false;
                }
                Transforming transforming = (Transforming) obj;
                return this.terminal == transforming.terminal && this.rawMatcher.equals(transforming.rawMatcher)
                        && this.transformers.equals(transforming.transformers) && Default.this.equals(Default.this);
            }

            public int hashCode() {
                return Default.this.hashCode()
                        + ((bjs.g(this.transformers, (this.rawMatcher.hashCode() + (getClass().hashCode() * 31)) * 31,
                                31) + (this.terminal ? 1 : 0)) * 31);
            }

            @Override // net.bytebuddy.agent.builder.AgentBuilder.Default.Delegator
            public AgentBuilder materialize() {
                Default r2 = Default.this;
                return new Default(r2.byteBuddy, r2.listener, r2.circularityLock, r2.poolStrategy, r2.typeStrategy,
                        r2.locationStrategy, r2.classFileLocator, r2.nativeMethodStrategy, r2.warmupStrategy,
                        r2.transformerDecorator, r2.initializationStrategy, r2.redefinitionStrategy,
                        r2.redefinitionDiscoveryStrategy, r2.redefinitionBatchAllocator, r2.redefinitionListener,
                        r2.redefinitionResubmissionStrategy, r2.injectionStrategy, r2.lambdaInstrumentationStrategy,
                        r2.descriptionStrategy, r2.fallbackStrategy, r2.classFileBufferStrategy,
                        r2.installationListener, r2.ignoreMatcher, CompoundList.of(r2.transformations,
                                new Transformation(this.rawMatcher, this.transformers, this.terminal)));
            }

            @Override // net.bytebuddy.agent.builder.AgentBuilder.Identified
            public Identified.Extendable transform(Transformer transformer) {
                return Default.this.new Transforming(this.rawMatcher, CompoundList.of(this.transformers, transformer),
                        this.terminal);
            }

            @Override // net.bytebuddy.agent.builder.AgentBuilder.Matchable
            public Identified.Narrowable and(RawMatcher rawMatcher) {
                return Default.this.new Transforming(new RawMatcher.Conjunction(this.rawMatcher, rawMatcher),
                        this.transformers, this.terminal);
            }

            @Override // net.bytebuddy.agent.builder.AgentBuilder.Matchable
            public Identified.Narrowable or(RawMatcher rawMatcher) {
                return Default.this.new Transforming(new RawMatcher.Disjunction(this.rawMatcher, rawMatcher),
                        this.transformers, this.terminal);
            }
        }

        /*
         * JADX INFO: compiled from:
         * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
         */
        public interface WarmupStrategy {

            /*
             * JADX INFO: compiled from:
             * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
             */
            @HashCodeAndEqualsPlugin.Enhance
            public static class Enabled implements WarmupStrategy {
                private static final Dispatcher DISPATCHER = (Dispatcher) Default
                        .doPrivileged(JavaDispatcher.of(Dispatcher.class));
                private final Set<Class<?>> types;

                /*
                 * JADX INFO: compiled from:
                 * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
                 */
                @JavaDispatcher.Proxied("java.lang.instrument.ClassFileTransformer")
                public interface Dispatcher {
                    @MaybeNull
                    @JavaDispatcher.Proxied("transform")
                    byte[] transform(ClassFileTransformer classFileTransformer,
                            @MaybeNull @JavaDispatcher.Proxied("java.lang.Module") Object obj,
                            @MaybeNull ClassLoader classLoader, String str, @MaybeNull Class<?> cls,
                            @MaybeNull ProtectionDomain protectionDomain, byte[] bArr);
                }

                public Enabled(Set<Class<?>> set) {
                    this.types = set;
                }

                @Override // net.bytebuddy.agent.builder.AgentBuilder.Default.WarmupStrategy
                public void apply(ResettableClassFileTransformer resettableClassFileTransformer,
                        LocationStrategy locationStrategy, RedefinitionStrategy redefinitionStrategy,
                        CircularityLock circularityLock, InstallationListener installationListener) {
                    Class<?> cls;
                    JavaModule javaModuleOfType;
                    byte[] bArrResolve;
                    Class<?> cls2;
                    byte[] bArrTransform;
                    Dispatcher dispatcher;
                    ResettableClassFileTransformer resettableClassFileTransformer2 = resettableClassFileTransformer;
                    installationListener.onBeforeWarmUp(this.types, resettableClassFileTransformer2);
                    LinkedHashMap linkedHashMap = new LinkedHashMap();
                    boolean z = false;
                    for (Class<?> cls3 : this.types) {
                        try {
                            javaModuleOfType = JavaModule.ofType(cls3);
                        } catch (Throwable th) {
                            th = th;
                        }
                        try {
                            bArrResolve = locationStrategy.classFileLocator(cls3.getClassLoader(), javaModuleOfType)
                                    .locate(cls3.getName()).resolve();
                            circularityLock.release();
                            circularityLock.acquire();
                            throw th;
                        } catch (Throwable th2) {
                            th = th2;
                            cls = cls3;
                            installationListener.onWarmUpError(cls, resettableClassFileTransformer2, th);
                            linkedHashMap.put(cls, Default.NO_TRANSFORMATION);
                        }
                        if (javaModuleOfType == null) {
                            try {
                                bArrTransform = resettableClassFileTransformer2.transform(cls3.getClassLoader(),
                                        Type.getInternalName(cls3), Default.NOT_PREVIOUSLY_DEFINED,
                                        cls3.getProtectionDomain(), bArrResolve);
                                z |= bArrTransform != null;
                                if (redefinitionStrategy.isEnabled()) {
                                    cls = cls3;
                                    try {
                                        bArrTransform = resettableClassFileTransformer.transform(cls3.getClassLoader(),
                                                Type.getInternalName(cls3), cls, cls3.getProtectionDomain(),
                                                bArrResolve);
                                        z |= bArrTransform != null;
                                        cls = cls;
                                        resettableClassFileTransformer2 = resettableClassFileTransformer;
                                    } catch (Throwable th3) {
                                        th = th3;
                                        resettableClassFileTransformer2 = resettableClassFileTransformer;
                                    }
                                } else {
                                    resettableClassFileTransformer2 = resettableClassFileTransformer;
                                    cls = cls3;
                                }
                            } catch (Throwable th4) {
                                th = th4;
                                cls2 = cls3;
                                resettableClassFileTransformer2 = resettableClassFileTransformer;
                                cls = cls2;
                            }
                            try {
                                linkedHashMap.put(cls, bArrTransform);
                                try {
                                    circularityLock.acquire();
                                } catch (Throwable th5) {
                                    th = th5;
                                    installationListener.onWarmUpError(cls, resettableClassFileTransformer2, th);
                                    linkedHashMap.put(cls, Default.NO_TRANSFORMATION);
                                }
                            } catch (Throwable th6) {
                                th = th6;
                                circularityLock.acquire();
                                throw th;
                            }
                        } else {
                            cls2 = cls3;
                            try {
                                dispatcher = DISPATCHER;
                            } catch (Throwable th7) {
                                th = th7;
                                resettableClassFileTransformer2 = resettableClassFileTransformer;
                                cls = cls2;
                                circularityLock.acquire();
                                throw th;
                            }
                            try {
                                byte[] bArrTransform2 = dispatcher.transform(resettableClassFileTransformer,
                                        javaModuleOfType.unwrap(), cls2.getClassLoader(), Type.getInternalName(cls2),
                                        Default.NOT_PREVIOUSLY_DEFINED, cls2.getProtectionDomain(), bArrResolve);
                                z |= bArrTransform2 != null;
                                if (redefinitionStrategy.isEnabled()) {
                                    try {
                                        bArrTransform = dispatcher.transform(resettableClassFileTransformer,
                                                javaModuleOfType.unwrap(), cls2.getClassLoader(),
                                                Type.getInternalName(cls2), cls2, cls2.getProtectionDomain(),
                                                bArrResolve);
                                        resettableClassFileTransformer2 = resettableClassFileTransformer;
                                        cls = cls2;
                                        z |= bArrTransform != null;
                                    } catch (Throwable th8) {
                                        th = th8;
                                        resettableClassFileTransformer2 = resettableClassFileTransformer;
                                        cls = cls2;
                                    }
                                } else {
                                    resettableClassFileTransformer2 = resettableClassFileTransformer;
                                    cls = cls2;
                                    bArrTransform = bArrTransform2;
                                }
                                linkedHashMap.put(cls, bArrTransform);
                                circularityLock.acquire();
                            } catch (Throwable th9) {
                                th = th9;
                                resettableClassFileTransformer2 = resettableClassFileTransformer;
                                cls = cls2;
                            }
                        }
                    }
                    installationListener.onAfterWarmUp(linkedHashMap, resettableClassFileTransformer2, z);
                }

                public boolean equals(@MaybeNull Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    return obj != null && getClass() == obj.getClass() && this.types.equals(((Enabled) obj).types);
                }

                public int hashCode() {
                    return this.types.hashCode() + (getClass().hashCode() * 31);
                }

                @Override // net.bytebuddy.agent.builder.AgentBuilder.Default.WarmupStrategy
                public WarmupStrategy with(Collection<Class<?>> collection) {
                    LinkedHashSet linkedHashSet = new LinkedHashSet(this.types);
                    linkedHashSet.addAll(collection);
                    return new Enabled(linkedHashSet);
                }
            }

            /*
             * JADX INFO: compiled from:
             * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
             */
            public enum NoOp implements WarmupStrategy {
                INSTANCE;

                @Override // net.bytebuddy.agent.builder.AgentBuilder.Default.WarmupStrategy
                public void apply(ResettableClassFileTransformer resettableClassFileTransformer,
                        LocationStrategy locationStrategy, RedefinitionStrategy redefinitionStrategy,
                        CircularityLock circularityLock, InstallationListener installationListener) {
                }

                @Override // net.bytebuddy.agent.builder.AgentBuilder.Default.WarmupStrategy
                public WarmupStrategy with(Collection<Class<?>> collection) {
                    return new Enabled(new LinkedHashSet(collection));
                }
            }

            void apply(ResettableClassFileTransformer resettableClassFileTransformer, LocationStrategy locationStrategy,
                    RedefinitionStrategy redefinitionStrategy, CircularityLock circularityLock,
                    InstallationListener installationListener);

            WarmupStrategy with(Collection<Class<?>> collection);
        }

        static {
            boolean z = false;
            try {
                Class.forName("java.security.AccessController", false, null);
                ACCESS_CONTROLLER = Boolean.parseBoolean(System.getProperty("net.bytebuddy.securitymanager", "true"));
            } catch (ClassNotFoundException unused) {
                ACCESS_CONTROLLER = z;
            } catch (SecurityException unused2) {
                z = true;
                ACCESS_CONTROLLER = z;
            }
            NO_TRANSFORMATION = null;
            NOT_PREVIOUSLY_DEFINED = null;
            DISPATCHER = (Dispatcher) doPrivileged(JavaDispatcher.of(Dispatcher.class));
            DEFAULT_LOCK = new CircularityLock.Default();
        }

        public Default() {
            this(new ByteBuddy());
        }

        private ResettableClassFileTransformer doInstall(Instrumentation instrumentation, RawMatcher rawMatcher,
                PatchMode.Handler handler) {
            RedefinitionStrategy.ResubmissionStrategy.Installation installation;
            ResettableClassFileTransformer resettableClassFileTransformer;
            if (!this.circularityLock.acquire()) {
                throw new IllegalStateException("Could not acquire the circularity lock upon installation.");
            }
            try {
                RedefinitionStrategy.ResubmissionStrategy.Installation installationApply = this.redefinitionResubmissionStrategy
                        .apply(instrumentation, this.poolStrategy, this.locationStrategy, this.descriptionStrategy,
                                this.fallbackStrategy, this.listener, this.installationListener, this.circularityLock,
                                new Transformation.SimpleMatcher(this.ignoreMatcher, this.transformations),
                                this.redefinitionStrategy, this.redefinitionBatchAllocator, this.redefinitionListener);
                ResettableClassFileTransformer resettableClassFileTransformerDecorate = this.transformerDecorator
                        .decorate(makeRaw(installationApply.getListener(), installationApply.getInstallationListener(),
                                installationApply.getResubmissionEnforcer()));
                installationApply.getInstallationListener().onBeforeInstall(instrumentation,
                        resettableClassFileTransformerDecorate);
                try {
                    this.warmupStrategy.apply(resettableClassFileTransformerDecorate, this.locationStrategy,
                            this.redefinitionStrategy, this.circularityLock,
                            installationApply.getInstallationListener());
                    try {
                        handler.onBeforeRegistration(instrumentation);
                        if (handler.onRegistration(resettableClassFileTransformerDecorate)) {
                            if (this.redefinitionStrategy.isRetransforming()) {
                                DISPATCHER.addTransformer(instrumentation, resettableClassFileTransformerDecorate,
                                        true);
                            } else {
                                instrumentation.addTransformer(resettableClassFileTransformerDecorate);
                            }
                        }
                        handler.onAfterRegistration(instrumentation);
                        this.nativeMethodStrategy.apply(instrumentation, resettableClassFileTransformerDecorate);
                        this.lambdaInstrumentationStrategy.apply(this.byteBuddy, instrumentation,
                                resettableClassFileTransformerDecorate);
                        resettableClassFileTransformerDecorate = resettableClassFileTransformerDecorate;
                        RedefinitionStrategy redefinitionStrategy = this.redefinitionStrategy;
                        PoolStrategy poolStrategy = this.poolStrategy;
                        LocationStrategy locationStrategy = this.locationStrategy;
                        try {
                            DescriptionStrategy descriptionStrategy = this.descriptionStrategy;
                            try {
                                FallbackStrategy fallbackStrategy = this.fallbackStrategy;
                                try {
                                    RedefinitionStrategy.DiscoveryStrategy discoveryStrategy = this.redefinitionDiscoveryStrategy;
                                    try {
                                        LambdaInstrumentationStrategy lambdaInstrumentationStrategy = this.lambdaInstrumentationStrategy;
                                        try {
                                            Listener listener = installationApply.getListener();
                                            try {
                                                installation = installationApply;
                                                resettableClassFileTransformer = resettableClassFileTransformerDecorate;
                                                try {
                                                    redefinitionStrategy.apply(instrumentation, poolStrategy,
                                                            locationStrategy, descriptionStrategy, fallbackStrategy,
                                                            discoveryStrategy, lambdaInstrumentationStrategy, listener,
                                                            this.redefinitionListener, rawMatcher,
                                                            this.redefinitionBatchAllocator, this.circularityLock);
                                                } catch (Throwable th) {
                                                    th = th;
                                                    Throwable thOnError = installation.getInstallationListener()
                                                            .onError(instrumentation, resettableClassFileTransformer,
                                                                    th);
                                                    if (thOnError != null) {
                                                        instrumentation
                                                                .removeTransformer(resettableClassFileTransformer);
                                                        throw new IllegalStateException(
                                                                "Could not install class file transformer", thOnError);
                                                    }
                                                }
                                            } catch (Throwable th2) {
                                                th = th2;
                                                installation = installationApply;
                                                resettableClassFileTransformer = resettableClassFileTransformerDecorate;
                                            }
                                        } catch (Throwable th3) {
                                            th = th3;
                                            installation = installationApply;
                                            resettableClassFileTransformer = resettableClassFileTransformerDecorate;
                                        }
                                    } catch (Throwable th4) {
                                        th = th4;
                                        installation = installationApply;
                                        resettableClassFileTransformer = resettableClassFileTransformerDecorate;
                                    }
                                } catch (Throwable th5) {
                                    th = th5;
                                    installation = installationApply;
                                    resettableClassFileTransformer = resettableClassFileTransformerDecorate;
                                }
                            } catch (Throwable th6) {
                                th = th6;
                                installation = installationApply;
                                resettableClassFileTransformer = resettableClassFileTransformerDecorate;
                            }
                        } catch (Throwable th7) {
                            th = th7;
                            installation = installationApply;
                            resettableClassFileTransformer = resettableClassFileTransformerDecorate;
                        }
                    } catch (Throwable th8) {
                        th = th8;
                        installation = installationApply;
                        resettableClassFileTransformer = resettableClassFileTransformerDecorate;
                    }
                } catch (Throwable th9) {
                    th = th9;
                    installation = installationApply;
                    resettableClassFileTransformer = resettableClassFileTransformerDecorate;
                }
                installation.getInstallationListener().onInstall(instrumentation, resettableClassFileTransformer);
                this.circularityLock.release();
                return resettableClassFileTransformer;
            } catch (Throwable th10) {
                this.circularityLock.release();
                throw th10;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        @AccessControllerPlugin.Enhance
        public static <T> T doPrivileged(PrivilegedAction<T> privilegedAction) {
            return ACCESS_CONTROLLER ? (T) AccessController.doPrivileged(privilegedAction) : privilegedAction.run();
        }

        public static AgentBuilder of(Plugin... pluginArr) {
            return of((List<? extends Plugin>) Arrays.asList(pluginArr));
        }

        private static Instrumentation resolveByteBuddyAgentInstrumentation() {
            try {
                Class<?> clsLoadClass = ClassLoader.getSystemClassLoader().loadClass(INSTALLER_TYPE);
                JavaModule javaModuleOfType = JavaModule.ofType(AgentBuilder.class);
                JavaModule javaModuleOfType2 = JavaModule.ofType(clsLoadClass);
                if (javaModuleOfType != null && !javaModuleOfType.canRead(javaModuleOfType2)) {
                    Class<?> cls = Class.forName("java.lang.Module");
                    cls.getMethod("addReads", cls).invoke(javaModuleOfType.unwrap(), javaModuleOfType2.unwrap());
                }
                return (Instrumentation) clsLoadClass.getMethod(INSTALLER_GETTER, null).invoke(null, null);
            } catch (RuntimeException e) {
                throw e;
            } catch (Exception e2) {
                throw new IllegalStateException("The Byte Buddy agent is not installed or not accessible", e2);
            }
        }

        @Override // net.bytebuddy.agent.builder.AgentBuilder
        public AgentBuilder assureReadEdgeFromAndTo(Instrumentation instrumentation, Class<?>... clsArr) {
            return JavaModule.isSupported() ? with(Listener.ModuleReadEdgeCompleting.of(instrumentation, true, clsArr))
                    : this;
        }

        @Override // net.bytebuddy.agent.builder.AgentBuilder
        public AgentBuilder assureReadEdgeTo(Instrumentation instrumentation, Class<?>... clsArr) {
            return JavaModule.isSupported() ? with(Listener.ModuleReadEdgeCompleting.of(instrumentation, false, clsArr))
                    : this;
        }

        @Override // net.bytebuddy.agent.builder.AgentBuilder
        public AgentBuilder disableClassFormatChanges() {
            ByteBuddy byteBuddyWith = this.byteBuddy.with(Implementation.Context.Disabled.Factory.INSTANCE);
            Listener listener = this.listener;
            CircularityLock circularityLock = this.circularityLock;
            PoolStrategy poolStrategy = this.poolStrategy;
            TypeStrategy typeStrategy = this.typeStrategy;
            TypeStrategy.Default r7 = TypeStrategy.Default.DECORATE;
            if (typeStrategy != r7) {
                r7 = TypeStrategy.Default.REDEFINE_FROZEN;
            }
            return new Default(byteBuddyWith, listener, circularityLock, poolStrategy, r7, this.locationStrategy,
                    this.classFileLocator, NativeMethodStrategy.Disabled.INSTANCE, this.warmupStrategy,
                    this.transformerDecorator, InitializationStrategy.NoOp.INSTANCE, this.redefinitionStrategy,
                    this.redefinitionDiscoveryStrategy, this.redefinitionBatchAllocator, this.redefinitionListener,
                    this.redefinitionResubmissionStrategy, this.injectionStrategy, this.lambdaInstrumentationStrategy,
                    this.descriptionStrategy, this.fallbackStrategy, this.classFileBufferStrategy,
                    this.installationListener, this.ignoreMatcher, this.transformations);
        }

        @Override // net.bytebuddy.agent.builder.AgentBuilder
        public AgentBuilder disableNativeMethodPrefix() {
            return new Default(this.byteBuddy, this.listener, this.circularityLock, this.poolStrategy,
                    this.typeStrategy, this.locationStrategy, this.classFileLocator,
                    NativeMethodStrategy.Disabled.INSTANCE, this.warmupStrategy, this.transformerDecorator,
                    this.initializationStrategy, this.redefinitionStrategy, this.redefinitionDiscoveryStrategy,
                    this.redefinitionBatchAllocator, this.redefinitionListener, this.redefinitionResubmissionStrategy,
                    this.injectionStrategy, this.lambdaInstrumentationStrategy, this.descriptionStrategy,
                    this.fallbackStrategy, this.classFileBufferStrategy, this.installationListener, this.ignoreMatcher,
                    this.transformations);
        }

        @Override // net.bytebuddy.agent.builder.AgentBuilder
        public AgentBuilder enableNativeMethodPrefix(String str) {
            return new Default(this.byteBuddy, this.listener, this.circularityLock, this.poolStrategy,
                    this.typeStrategy, this.locationStrategy, this.classFileLocator,
                    NativeMethodStrategy.ForPrefix.of(str), this.warmupStrategy, this.transformerDecorator,
                    this.initializationStrategy, this.redefinitionStrategy, this.redefinitionDiscoveryStrategy,
                    this.redefinitionBatchAllocator, this.redefinitionListener, this.redefinitionResubmissionStrategy,
                    this.injectionStrategy, this.lambdaInstrumentationStrategy, this.descriptionStrategy,
                    this.fallbackStrategy, this.classFileBufferStrategy, this.installationListener, this.ignoreMatcher,
                    this.transformations);
        }

        public boolean equals(@MaybeNull Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            Default r5 = (Default) obj;
            return this.redefinitionStrategy.equals(r5.redefinitionStrategy)
                    && this.lambdaInstrumentationStrategy.equals(r5.lambdaInstrumentationStrategy)
                    && this.byteBuddy.equals(r5.byteBuddy) && this.listener.equals(r5.listener)
                    && this.circularityLock.equals(r5.circularityLock) && this.poolStrategy.equals(r5.poolStrategy)
                    && this.typeStrategy.equals(r5.typeStrategy) && this.locationStrategy.equals(r5.locationStrategy)
                    && this.classFileLocator.equals(r5.classFileLocator)
                    && this.nativeMethodStrategy.equals(r5.nativeMethodStrategy)
                    && this.warmupStrategy.equals(r5.warmupStrategy)
                    && this.transformerDecorator.equals(r5.transformerDecorator)
                    && this.initializationStrategy.equals(r5.initializationStrategy)
                    && this.redefinitionDiscoveryStrategy.equals(r5.redefinitionDiscoveryStrategy)
                    && this.redefinitionBatchAllocator.equals(r5.redefinitionBatchAllocator)
                    && this.redefinitionListener.equals(r5.redefinitionListener)
                    && this.redefinitionResubmissionStrategy.equals(r5.redefinitionResubmissionStrategy)
                    && this.injectionStrategy.equals(r5.injectionStrategy)
                    && this.descriptionStrategy.equals(r5.descriptionStrategy)
                    && this.fallbackStrategy.equals(r5.fallbackStrategy)
                    && this.classFileBufferStrategy.equals(r5.classFileBufferStrategy)
                    && this.installationListener.equals(r5.installationListener)
                    && this.ignoreMatcher.equals(r5.ignoreMatcher) && this.transformations.equals(r5.transformations);
        }

        public int hashCode() {
            return this.transformations.hashCode() + ((this.ignoreMatcher.hashCode() + ((this.installationListener
                    .hashCode()
                    + ((this.classFileBufferStrategy.hashCode() + ((this.fallbackStrategy.hashCode()
                            + ((this.descriptionStrategy.hashCode() + ((this.lambdaInstrumentationStrategy.hashCode()
                                    + ((this.injectionStrategy.hashCode() + ((this.redefinitionResubmissionStrategy
                                            .hashCode()
                                            + ((this.redefinitionListener.hashCode() + ((this.redefinitionBatchAllocator
                                                    .hashCode()
                                                    + ((this.redefinitionDiscoveryStrategy.hashCode()
                                                            + ((this.redefinitionStrategy.hashCode()
                                                                    + ((this.initializationStrategy.hashCode()
                                                                            + ((this.transformerDecorator.hashCode()
                                                                                    + ((this.warmupStrategy.hashCode()
                                                                                            + ((this.nativeMethodStrategy
                                                                                                    .hashCode()
                                                                                                    + ((this.classFileLocator
                                                                                                            .hashCode()
                                                                                                            + ((this.locationStrategy
                                                                                                                    .hashCode()
                                                                                                                    + ((this.typeStrategy
                                                                                                                            .hashCode()
                                                                                                                            + ((this.poolStrategy
                                                                                                                                    .hashCode()
                                                                                                                                    + ((this.circularityLock
                                                                                                                                            .hashCode()
                                                                                                                                            + ((this.listener
                                                                                                                                                    .hashCode()
                                                                                                                                                    + ((this.byteBuddy
                                                                                                                                                            .hashCode()
                                                                                                                                                            + (getClass()
                                                                                                                                                                    .hashCode()
                                                                                                                                                                    * 31))
                                                                                                                                                            * 31))
                                                                                                                                                    * 31))
                                                                                                                                            * 31))
                                                                                                                                    * 31))
                                                                                                                            * 31))
                                                                                                                    * 31))
                                                                                                            * 31))
                                                                                                    * 31))
                                                                                            * 31))
                                                                                    * 31))
                                                                            * 31))
                                                                    * 31))
                                                            * 31))
                                                    * 31)) * 31))
                                            * 31)) * 31))
                                    * 31)) * 31))
                            * 31)) * 31))
                    * 31)) * 31);
        }

        @Override // net.bytebuddy.agent.builder.AgentBuilder
        public Ignored ignore(ElementMatcher<? super TypeDescription> elementMatcher) {
            return ignore(elementMatcher, ElementMatchers.any());
        }

        @Override // net.bytebuddy.agent.builder.AgentBuilder
        public ResettableClassFileTransformer installOn(Instrumentation instrumentation) {
            return doInstall(instrumentation,
                    new Transformation.SimpleMatcher(this.ignoreMatcher, this.transformations),
                    PatchMode.Handler.NoOp.INSTANCE);
        }

        @Override // net.bytebuddy.agent.builder.AgentBuilder
        public ResettableClassFileTransformer installOnByteBuddyAgent() {
            return installOn(resolveByteBuddyAgentInstrumentation());
        }

        @Override // net.bytebuddy.agent.builder.AgentBuilder
        public ResettableClassFileTransformer patchOn(Instrumentation instrumentation,
                ResettableClassFileTransformer resettableClassFileTransformer) {
            return patchOn(instrumentation, resettableClassFileTransformer,
                    PatchMode.of(resettableClassFileTransformer));
        }

        @Override // net.bytebuddy.agent.builder.AgentBuilder
        public ResettableClassFileTransformer patchOnByteBuddyAgent(
                ResettableClassFileTransformer resettableClassFileTransformer) {
            return patchOn(resolveByteBuddyAgentInstrumentation(), resettableClassFileTransformer);
        }

        @Override // net.bytebuddy.agent.builder.AgentBuilder
        public Identified.Narrowable type(RawMatcher rawMatcher) {
            return new Transforming(rawMatcher, Collections.EMPTY_LIST, false);
        }

        @Override // net.bytebuddy.agent.builder.AgentBuilder
        public AgentBuilder warmUp(Class<?>... clsArr) {
            return warmUp(Arrays.asList(clsArr));
        }

        @Override // net.bytebuddy.agent.builder.AgentBuilder
        public AgentBuilder with(ByteBuddy byteBuddy) {
            return new Default(byteBuddy, this.listener, this.circularityLock, this.poolStrategy, this.typeStrategy,
                    this.locationStrategy, this.classFileLocator, this.nativeMethodStrategy, this.warmupStrategy,
                    this.transformerDecorator, this.initializationStrategy, this.redefinitionStrategy,
                    this.redefinitionDiscoveryStrategy, this.redefinitionBatchAllocator, this.redefinitionListener,
                    this.redefinitionResubmissionStrategy, this.injectionStrategy, this.lambdaInstrumentationStrategy,
                    this.descriptionStrategy, this.fallbackStrategy, this.classFileBufferStrategy,
                    this.installationListener, this.ignoreMatcher, this.transformations);
        }

        public Default(ByteBuddy byteBuddy) {
            this(byteBuddy, Listener.NoOp.INSTANCE, DEFAULT_LOCK, PoolStrategy.Default.FAST,
                    TypeStrategy.Default.REBASE, LocationStrategy.ForClassLoader.STRONG, ClassFileLocator.NoOp.INSTANCE,
                    NativeMethodStrategy.Disabled.INSTANCE, WarmupStrategy.NoOp.INSTANCE,
                    TransformerDecorator.NoOp.INSTANCE, new InitializationStrategy.SelfInjection.Split(),
                    RedefinitionStrategy.DISABLED, RedefinitionStrategy.DiscoveryStrategy.SinglePass.INSTANCE,
                    RedefinitionStrategy.BatchAllocator.ForTotal.INSTANCE, RedefinitionStrategy.Listener.NoOp.INSTANCE,
                    RedefinitionStrategy.ResubmissionStrategy.Disabled.INSTANCE,
                    InjectionStrategy.UsingReflection.INSTANCE, LambdaInstrumentationStrategy.DISABLED,
                    DescriptionStrategy.Default.HYBRID, FallbackStrategy.ByThrowableType.ofOptionalTypes(),
                    ClassFileBufferStrategy.Default.RETAINING, InstallationListener.NoOp.INSTANCE,
                    new RawMatcher.Disjunction(
                            new RawMatcher.ForElementMatchers(ElementMatchers.any(),
                                    ElementMatchers.isBootstrapClassLoader()
                                            .or(ElementMatchers.isExtensionClassLoader())),
                            new RawMatcher.ForElementMatchers(ElementMatchers.nameStartsWith("net.bytebuddy.")
                                    .and(ElementMatchers.not(ElementMatchers.nameStartsWith("net.bytebuddy.renamed.")))
                                    .or(ElementMatchers.nameStartsWith("sun.reflect.")
                                            .or(ElementMatchers.nameStartsWith("jdk.internal.reflect.")))
                                    .or(ElementMatchers.isSynthetic()))),
                    Collections.EMPTY_LIST);
        }

        public static AgentBuilder of(List<? extends Plugin> list) {
            return of(EntryPoint.Default.REBASE, list);
        }

        @Override // net.bytebuddy.agent.builder.AgentBuilder
        public Ignored ignore(ElementMatcher<? super TypeDescription> elementMatcher,
                ElementMatcher<? super ClassLoader> elementMatcher2) {
            return ignore(elementMatcher, elementMatcher2, ElementMatchers.any());
        }

        @Override // net.bytebuddy.agent.builder.AgentBuilder
        public ResettableClassFileTransformer makeRaw() {
            return makeRaw(this.listener, InstallationListener.NoOp.INSTANCE,
                    RedefinitionStrategy.ResubmissionEnforcer.Disabled.INSTANCE);
        }

        @Override // net.bytebuddy.agent.builder.AgentBuilder
        public ResettableClassFileTransformer patchOn(Instrumentation instrumentation,
                ResettableClassFileTransformer resettableClassFileTransformer, RawMatcher rawMatcher) {
            return patchOn(instrumentation, resettableClassFileTransformer, rawMatcher,
                    PatchMode.of(resettableClassFileTransformer));
        }

        @Override // net.bytebuddy.agent.builder.AgentBuilder
        public ResettableClassFileTransformer patchOnByteBuddyAgent(
                ResettableClassFileTransformer resettableClassFileTransformer, PatchMode patchMode) {
            return patchOn(resolveByteBuddyAgentInstrumentation(), resettableClassFileTransformer, patchMode);
        }

        @Override // net.bytebuddy.agent.builder.AgentBuilder
        public Identified.Narrowable type(ElementMatcher<? super TypeDescription> elementMatcher) {
            return type(elementMatcher, ElementMatchers.any());
        }

        @Override // net.bytebuddy.agent.builder.AgentBuilder
        public AgentBuilder warmUp(Collection<Class<?>> collection) {
            if (collection.isEmpty()) {
                return this;
            }
            for (Class<?> cls : collection) {
                if (cls.isPrimitive() || cls.isArray()) {
                    throw new IllegalArgumentException(concatVar2Var1(cls, "Cannot warm up primitive or array type: "));
                }
            }
            return new Default(this.byteBuddy, this.listener, this.circularityLock, this.poolStrategy,
                    this.typeStrategy, this.locationStrategy, this.classFileLocator, this.nativeMethodStrategy,
                    this.warmupStrategy.with(collection), this.transformerDecorator, this.initializationStrategy,
                    this.redefinitionStrategy, this.redefinitionDiscoveryStrategy, this.redefinitionBatchAllocator,
                    this.redefinitionListener, this.redefinitionResubmissionStrategy, this.injectionStrategy,
                    this.lambdaInstrumentationStrategy, this.descriptionStrategy, this.fallbackStrategy,
                    this.classFileBufferStrategy, this.installationListener, this.ignoreMatcher, this.transformations);
        }

        @Override // net.bytebuddy.agent.builder.AgentBuilder
        public AgentBuilder with(Listener listener) {
            return new Default(this.byteBuddy, new Listener.Compound(this.listener, listener), this.circularityLock,
                    this.poolStrategy, this.typeStrategy, this.locationStrategy, this.classFileLocator,
                    this.nativeMethodStrategy, this.warmupStrategy, this.transformerDecorator,
                    this.initializationStrategy, this.redefinitionStrategy, this.redefinitionDiscoveryStrategy,
                    this.redefinitionBatchAllocator, this.redefinitionListener, this.redefinitionResubmissionStrategy,
                    this.injectionStrategy, this.lambdaInstrumentationStrategy, this.descriptionStrategy,
                    this.fallbackStrategy, this.classFileBufferStrategy, this.installationListener, this.ignoreMatcher,
                    this.transformations);
        }

        /*
         * JADX INFO: compiled from:
         * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
         */
        public static class Redefining extends Default implements RedefinitionListenable.WithoutBatchStrategy {

            /*
             * JADX INFO: compiled from:
             * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
             */
            public class WithResubmission extends Delegator
                    implements RedefinitionListenable.WithResubmissionSpecification {
                private final RedefinitionListenable.ResubmissionImmediateMatcher resubmissionImmediateMatcher;
                private final RedefinitionListenable.ResubmissionOnErrorMatcher resubmissionOnErrorMatcher;
                private final RedefinitionStrategy.ResubmissionScheduler resubmissionScheduler;

                public WithResubmission(RedefinitionStrategy.ResubmissionScheduler resubmissionScheduler,
                        RedefinitionListenable.ResubmissionOnErrorMatcher resubmissionOnErrorMatcher,
                        RedefinitionListenable.ResubmissionImmediateMatcher resubmissionImmediateMatcher) {
                    this.resubmissionScheduler = resubmissionScheduler;
                    this.resubmissionOnErrorMatcher = resubmissionOnErrorMatcher;
                    this.resubmissionImmediateMatcher = resubmissionImmediateMatcher;
                }

                @Override // net.bytebuddy.agent.builder.AgentBuilder.Default.Delegator
                public AgentBuilder materialize() {
                    Redefining redefining = Redefining.this;
                    ByteBuddy byteBuddy = redefining.byteBuddy;
                    Listener listener = redefining.listener;
                    CircularityLock circularityLock = redefining.circularityLock;
                    PoolStrategy poolStrategy = redefining.poolStrategy;
                    TypeStrategy typeStrategy = redefining.typeStrategy;
                    LocationStrategy locationStrategy = redefining.locationStrategy;
                    ClassFileLocator classFileLocator = redefining.classFileLocator;
                    NativeMethodStrategy nativeMethodStrategy = redefining.nativeMethodStrategy;
                    WarmupStrategy warmupStrategy = redefining.warmupStrategy;
                    TransformerDecorator transformerDecorator = redefining.transformerDecorator;
                    InitializationStrategy initializationStrategy = redefining.initializationStrategy;
                    RedefinitionStrategy redefinitionStrategy = redefining.redefinitionStrategy;
                    RedefinitionStrategy.DiscoveryStrategy discoveryStrategy = redefining.redefinitionDiscoveryStrategy;
                    RedefinitionStrategy.BatchAllocator batchAllocator = redefining.redefinitionBatchAllocator;
                    RedefinitionStrategy.Listener listener2 = redefining.redefinitionListener;
                    RedefinitionStrategy.ResubmissionStrategy.Enabled enabled = new RedefinitionStrategy.ResubmissionStrategy.Enabled(
                            this.resubmissionScheduler, this.resubmissionOnErrorMatcher,
                            this.resubmissionImmediateMatcher);
                    Redefining redefining2 = Redefining.this;
                    return new Default(byteBuddy, listener, circularityLock, poolStrategy, typeStrategy,
                            locationStrategy, classFileLocator, nativeMethodStrategy, warmupStrategy,
                            transformerDecorator, initializationStrategy, redefinitionStrategy, discoveryStrategy,
                            batchAllocator, listener2, enabled, redefining2.injectionStrategy,
                            redefining2.lambdaInstrumentationStrategy, redefining2.descriptionStrategy,
                            redefining2.fallbackStrategy, redefining2.classFileBufferStrategy,
                            redefining2.installationListener, redefining2.ignoreMatcher, redefining2.transformations);
                }

                @Override // net.bytebuddy.agent.builder.AgentBuilder.RedefinitionListenable.WithoutResubmissionSpecification
                public RedefinitionListenable.WithResubmissionSpecification resubmitImmediate() {
                    return resubmitImmediate(ElementMatchers.any());
                }

                @Override // net.bytebuddy.agent.builder.AgentBuilder.RedefinitionListenable.WithoutResubmissionSpecification
                public RedefinitionListenable.WithResubmissionSpecification resubmitOnError() {
                    return resubmitOnError(ElementMatchers.any());
                }

                @Override // net.bytebuddy.agent.builder.AgentBuilder.RedefinitionListenable.WithoutResubmissionSpecification
                public RedefinitionListenable.WithResubmissionSpecification resubmitImmediate(
                        ElementMatcher<String> elementMatcher) {
                    return resubmitImmediate(elementMatcher, ElementMatchers.any());
                }

                @Override // net.bytebuddy.agent.builder.AgentBuilder.RedefinitionListenable.WithoutResubmissionSpecification
                public RedefinitionListenable.WithResubmissionSpecification resubmitOnError(
                        ElementMatcher<? super Throwable> elementMatcher) {
                    return resubmitOnError(elementMatcher, ElementMatchers.any());
                }

                @Override // net.bytebuddy.agent.builder.AgentBuilder.RedefinitionListenable.WithoutResubmissionSpecification
                public RedefinitionListenable.WithResubmissionSpecification resubmitImmediate(
                        ElementMatcher<String> elementMatcher, ElementMatcher<? super ClassLoader> elementMatcher2) {
                    return resubmitImmediate(elementMatcher, elementMatcher2, ElementMatchers.any());
                }

                @Override // net.bytebuddy.agent.builder.AgentBuilder.RedefinitionListenable.WithoutResubmissionSpecification
                public RedefinitionListenable.WithResubmissionSpecification resubmitOnError(
                        ElementMatcher<? super Throwable> elementMatcher, ElementMatcher<String> elementMatcher2) {
                    return resubmitOnError(elementMatcher, elementMatcher2, ElementMatchers.any());
                }

                @Override // net.bytebuddy.agent.builder.AgentBuilder.RedefinitionListenable.WithoutResubmissionSpecification
                public RedefinitionListenable.WithResubmissionSpecification resubmitImmediate(
                        ElementMatcher<String> elementMatcher, ElementMatcher<? super ClassLoader> elementMatcher2,
                        ElementMatcher<? super JavaModule> elementMatcher3) {
                    return resubmitImmediate(new RedefinitionListenable.ResubmissionImmediateMatcher.ForElementMatchers(
                            elementMatcher, elementMatcher2, elementMatcher3));
                }

                @Override // net.bytebuddy.agent.builder.AgentBuilder.RedefinitionListenable.WithoutResubmissionSpecification
                public RedefinitionListenable.WithResubmissionSpecification resubmitOnError(
                        ElementMatcher<? super Throwable> elementMatcher, ElementMatcher<String> elementMatcher2,
                        ElementMatcher<? super ClassLoader> elementMatcher3) {
                    return resubmitOnError(elementMatcher, elementMatcher2, elementMatcher3, ElementMatchers.any());
                }

                @Override // net.bytebuddy.agent.builder.AgentBuilder.RedefinitionListenable.WithoutResubmissionSpecification
                public RedefinitionListenable.WithResubmissionSpecification resubmitImmediate(
                        RedefinitionListenable.ResubmissionImmediateMatcher resubmissionImmediateMatcher) {
                    return Redefining.this.new WithResubmission(this.resubmissionScheduler,
                            this.resubmissionOnErrorMatcher,
                            new RedefinitionListenable.ResubmissionImmediateMatcher.Disjunction(
                                    this.resubmissionImmediateMatcher, resubmissionImmediateMatcher));
                }

                @Override // net.bytebuddy.agent.builder.AgentBuilder.RedefinitionListenable.WithoutResubmissionSpecification
                public RedefinitionListenable.WithResubmissionSpecification resubmitOnError(
                        ElementMatcher<? super Throwable> elementMatcher, ElementMatcher<String> elementMatcher2,
                        ElementMatcher<? super ClassLoader> elementMatcher3,
                        ElementMatcher<? super JavaModule> elementMatcher4) {
                    return resubmitOnError(new RedefinitionListenable.ResubmissionOnErrorMatcher.ForElementMatchers(
                            elementMatcher, elementMatcher2, elementMatcher3, elementMatcher4));
                }

                @Override // net.bytebuddy.agent.builder.AgentBuilder.RedefinitionListenable.WithoutResubmissionSpecification
                public RedefinitionListenable.WithResubmissionSpecification resubmitOnError(
                        RedefinitionListenable.ResubmissionOnErrorMatcher resubmissionOnErrorMatcher) {
                    return Redefining.this.new WithResubmission(this.resubmissionScheduler,
                            new RedefinitionListenable.ResubmissionOnErrorMatcher.Disjunction(
                                    this.resubmissionOnErrorMatcher, resubmissionOnErrorMatcher),
                            this.resubmissionImmediateMatcher);
                }
            }

            public Redefining(ByteBuddy byteBuddy, Listener listener, CircularityLock circularityLock,
                    PoolStrategy poolStrategy, TypeStrategy typeStrategy, LocationStrategy locationStrategy,
                    ClassFileLocator classFileLocator, NativeMethodStrategy nativeMethodStrategy,
                    WarmupStrategy warmupStrategy, TransformerDecorator transformerDecorator,
                    InitializationStrategy initializationStrategy, RedefinitionStrategy redefinitionStrategy,
                    RedefinitionStrategy.DiscoveryStrategy discoveryStrategy,
                    RedefinitionStrategy.BatchAllocator batchAllocator, RedefinitionStrategy.Listener listener2,
                    RedefinitionStrategy.ResubmissionStrategy resubmissionStrategy, InjectionStrategy injectionStrategy,
                    LambdaInstrumentationStrategy lambdaInstrumentationStrategy,
                    DescriptionStrategy descriptionStrategy, FallbackStrategy fallbackStrategy,
                    ClassFileBufferStrategy classFileBufferStrategy, InstallationListener installationListener,
                    RawMatcher rawMatcher, List<Transformation> list) {
                super(byteBuddy, listener, circularityLock, poolStrategy, typeStrategy, locationStrategy,
                        classFileLocator, nativeMethodStrategy, warmupStrategy, transformerDecorator,
                        initializationStrategy, redefinitionStrategy, discoveryStrategy, batchAllocator, listener2,
                        resubmissionStrategy, injectionStrategy, lambdaInstrumentationStrategy, descriptionStrategy,
                        fallbackStrategy, classFileBufferStrategy, installationListener, rawMatcher, list);
            }

            @Override // net.bytebuddy.agent.builder.AgentBuilder.Default,
                      // net.bytebuddy.agent.builder.AgentBuilder
            public /* bridge */ /* synthetic */ ClassFileTransformer makeRaw() {
                return super.makeRaw();
            }

            @Override // net.bytebuddy.agent.builder.AgentBuilder.RedefinitionListenable.WithImplicitDiscoveryStrategy
            public RedefinitionListenable redefineOnly(Class<?>... clsArr) {
                return with(new RedefinitionStrategy.DiscoveryStrategy.Explicit(clsArr));
            }

            @Override // net.bytebuddy.agent.builder.AgentBuilder.RedefinitionListenable.WithoutBatchStrategy
            public RedefinitionListenable.WithImplicitDiscoveryStrategy with(
                    RedefinitionStrategy.BatchAllocator batchAllocator) {
                if (this.redefinitionStrategy.isEnabled()) {
                    return new Redefining(this.byteBuddy, this.listener, this.circularityLock, this.poolStrategy,
                            this.typeStrategy, this.locationStrategy, this.classFileLocator, this.nativeMethodStrategy,
                            this.warmupStrategy, this.transformerDecorator, this.initializationStrategy,
                            this.redefinitionStrategy, this.redefinitionDiscoveryStrategy, batchAllocator,
                            this.redefinitionListener, this.redefinitionResubmissionStrategy, this.injectionStrategy,
                            this.lambdaInstrumentationStrategy, this.descriptionStrategy, this.fallbackStrategy,
                            this.classFileBufferStrategy, this.installationListener, this.ignoreMatcher,
                            this.transformations);
                }
                throw new IllegalStateException(
                        "Cannot set redefinition batch allocator when redefinition is disabled");
            }

            @Override // net.bytebuddy.agent.builder.AgentBuilder.RedefinitionListenable
            public RedefinitionListenable.WithoutResubmissionSpecification withResubmission(
                    RedefinitionStrategy.ResubmissionScheduler resubmissionScheduler) {
                if (this.redefinitionStrategy.isEnabled()) {
                    return new WithResubmission(resubmissionScheduler,
                            RedefinitionListenable.ResubmissionOnErrorMatcher.Trivial.NON_MATCHING,
                            RedefinitionListenable.ResubmissionImmediateMatcher.Trivial.NON_MATCHING);
                }
                throw new IllegalStateException("Cannot enable resubmission when redefinition is disabled");
            }

            @Override // net.bytebuddy.agent.builder.AgentBuilder.RedefinitionListenable.WithImplicitDiscoveryStrategy
            public RedefinitionListenable with(RedefinitionStrategy.DiscoveryStrategy discoveryStrategy) {
                if (this.redefinitionStrategy.isEnabled()) {
                    return new Redefining(this.byteBuddy, this.listener, this.circularityLock, this.poolStrategy,
                            this.typeStrategy, this.locationStrategy, this.classFileLocator, this.nativeMethodStrategy,
                            this.warmupStrategy, this.transformerDecorator, this.initializationStrategy,
                            this.redefinitionStrategy, discoveryStrategy, this.redefinitionBatchAllocator,
                            this.redefinitionListener, this.redefinitionResubmissionStrategy, this.injectionStrategy,
                            this.lambdaInstrumentationStrategy, this.descriptionStrategy, this.fallbackStrategy,
                            this.classFileBufferStrategy, this.installationListener, this.ignoreMatcher,
                            this.transformations);
                }
                throw new IllegalStateException(
                        "Cannot set redefinition discovery strategy when redefinition is disabled");
            }

            @Override // net.bytebuddy.agent.builder.AgentBuilder.RedefinitionListenable
            public RedefinitionListenable with(RedefinitionStrategy.Listener listener) {
                if (this.redefinitionStrategy.isEnabled()) {
                    return new Redefining(this.byteBuddy, this.listener, this.circularityLock, this.poolStrategy,
                            this.typeStrategy, this.locationStrategy, this.classFileLocator, this.nativeMethodStrategy,
                            this.warmupStrategy, this.transformerDecorator, this.initializationStrategy,
                            this.redefinitionStrategy, this.redefinitionDiscoveryStrategy,
                            this.redefinitionBatchAllocator,
                            new RedefinitionStrategy.Listener.Compound(this.redefinitionListener, listener),
                            this.redefinitionResubmissionStrategy, this.injectionStrategy,
                            this.lambdaInstrumentationStrategy, this.descriptionStrategy, this.fallbackStrategy,
                            this.classFileBufferStrategy, this.installationListener, this.ignoreMatcher,
                            this.transformations);
                }
                throw new IllegalStateException("Cannot set redefinition listener when redefinition is disabled");
            }
        }

        private ResettableClassFileTransformer makeRaw(Listener listener, InstallationListener installationListener,
                RedefinitionStrategy.ResubmissionEnforcer resubmissionEnforcer) {
            return ExecutingTransformer.FACTORY.make(this.byteBuddy, listener, this.poolStrategy, this.typeStrategy,
                    this.locationStrategy, this.classFileLocator, this.nativeMethodStrategy,
                    this.initializationStrategy, this.injectionStrategy, this.lambdaInstrumentationStrategy,
                    this.descriptionStrategy, this.fallbackStrategy, this.classFileBufferStrategy, installationListener,
                    this.ignoreMatcher, resubmissionEnforcer, this.transformations, this.circularityLock);
        }

        public static AgentBuilder of(EntryPoint entryPoint, Plugin... pluginArr) {
            return of(entryPoint, (List<? extends Plugin>) Arrays.asList(pluginArr));
        }

        @Override // net.bytebuddy.agent.builder.AgentBuilder
        public AgentBuilder assureReadEdgeFromAndTo(Instrumentation instrumentation, JavaModule... javaModuleArr) {
            return assureReadEdgeFromAndTo(instrumentation, Arrays.asList(javaModuleArr));
        }

        @Override // net.bytebuddy.agent.builder.AgentBuilder
        public AgentBuilder assureReadEdgeTo(Instrumentation instrumentation, JavaModule... javaModuleArr) {
            return assureReadEdgeTo(instrumentation, Arrays.asList(javaModuleArr));
        }

        @Override // net.bytebuddy.agent.builder.AgentBuilder
        public Ignored ignore(ElementMatcher<? super TypeDescription> elementMatcher,
                ElementMatcher<? super ClassLoader> elementMatcher2,
                ElementMatcher<? super JavaModule> elementMatcher3) {
            return ignore(new RawMatcher.ForElementMatchers(elementMatcher, elementMatcher2,
                    ElementMatchers.not(ElementMatchers.supportsModules()).or(elementMatcher3)));
        }

        @Override // net.bytebuddy.agent.builder.AgentBuilder
        public ResettableClassFileTransformer patchOn(Instrumentation instrumentation,
                ResettableClassFileTransformer resettableClassFileTransformer, PatchMode patchMode) {
            return patchOn(instrumentation, resettableClassFileTransformer,
                    new Transformation.DifferentialMatcher(this.ignoreMatcher, this.transformations,
                            resettableClassFileTransformer instanceof ResettableClassFileTransformer.Substitutable
                                    ? ((ResettableClassFileTransformer.Substitutable) resettableClassFileTransformer)
                                            .unwrap()
                                    : resettableClassFileTransformer),
                    patchMode);
        }

        @Override // net.bytebuddy.agent.builder.AgentBuilder
        public Identified.Narrowable type(ElementMatcher<? super TypeDescription> elementMatcher,
                ElementMatcher<? super ClassLoader> elementMatcher2) {
            return type(elementMatcher, elementMatcher2, ElementMatchers.any());
        }

        @Override // net.bytebuddy.agent.builder.AgentBuilder
        public AgentBuilder with(CircularityLock circularityLock) {
            return new Default(this.byteBuddy, this.listener, circularityLock, this.poolStrategy, this.typeStrategy,
                    this.locationStrategy, this.classFileLocator, this.nativeMethodStrategy, this.warmupStrategy,
                    this.transformerDecorator, this.initializationStrategy, this.redefinitionStrategy,
                    this.redefinitionDiscoveryStrategy, this.redefinitionBatchAllocator, this.redefinitionListener,
                    this.redefinitionResubmissionStrategy, this.injectionStrategy, this.lambdaInstrumentationStrategy,
                    this.descriptionStrategy, this.fallbackStrategy, this.classFileBufferStrategy,
                    this.installationListener, this.ignoreMatcher, this.transformations);
        }

        public static AgentBuilder of(EntryPoint entryPoint, List<? extends Plugin> list) {
            return of(entryPoint, ClassFileVersion.ofThisVm(ClassFileVersion.JAVA_V5), list);
        }

        @Override // net.bytebuddy.agent.builder.AgentBuilder
        public AgentBuilder assureReadEdgeFromAndTo(Instrumentation instrumentation,
                Collection<? extends JavaModule> collection) {
            return with(new Listener.ModuleReadEdgeCompleting(instrumentation, true, new HashSet(collection)));
        }

        @Override // net.bytebuddy.agent.builder.AgentBuilder
        public AgentBuilder assureReadEdgeTo(Instrumentation instrumentation,
                Collection<? extends JavaModule> collection) {
            return with(new Listener.ModuleReadEdgeCompleting(instrumentation, false, new HashSet(collection)));
        }

        @Override // net.bytebuddy.agent.builder.AgentBuilder
        public Ignored ignore(RawMatcher rawMatcher) {
            return new Ignoring(rawMatcher);
        }

        @Override // net.bytebuddy.agent.builder.AgentBuilder
        public Identified.Narrowable type(ElementMatcher<? super TypeDescription> elementMatcher,
                ElementMatcher<? super ClassLoader> elementMatcher2,
                ElementMatcher<? super JavaModule> elementMatcher3) {
            return type(new RawMatcher.ForElementMatchers(elementMatcher, elementMatcher2,
                    ElementMatchers.not(ElementMatchers.supportsModules()).or(elementMatcher3)));
        }

        @Override // net.bytebuddy.agent.builder.AgentBuilder
        public AgentBuilder with(TypeStrategy typeStrategy) {
            return new Default(this.byteBuddy, this.listener, this.circularityLock, this.poolStrategy, typeStrategy,
                    this.locationStrategy, this.classFileLocator, this.nativeMethodStrategy, this.warmupStrategy,
                    this.transformerDecorator, this.initializationStrategy, this.redefinitionStrategy,
                    this.redefinitionDiscoveryStrategy, this.redefinitionBatchAllocator, this.redefinitionListener,
                    this.redefinitionResubmissionStrategy, this.injectionStrategy, this.lambdaInstrumentationStrategy,
                    this.descriptionStrategy, this.fallbackStrategy, this.classFileBufferStrategy,
                    this.installationListener, this.ignoreMatcher, this.transformations);
        }

        /*
         * JADX INFO: compiled from:
         * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
         */
        public static class ExecutingTransformer extends ResettableClassFileTransformer.AbstractBase {
            private static final boolean ACCESS_CONTROLLER;
            protected static final Factory FACTORY;

            @MaybeNull
            private final Object accessControlContext = getContext();
            private final ByteBuddy byteBuddy;
            private final CircularityLock circularityLock;
            private final ClassFileBufferStrategy classFileBufferStrategy;
            private final ClassFileLocator classFileLocator;
            private final DescriptionStrategy descriptionStrategy;
            private final FallbackStrategy fallbackStrategy;
            private final RawMatcher ignoreMatcher;
            private final InitializationStrategy initializationStrategy;
            private final InjectionStrategy injectionStrategy;
            private final InstallationListener installationListener;
            private final LambdaInstrumentationStrategy lambdaInstrumentationStrategy;
            private final Listener listener;
            private final LocationStrategy locationStrategy;
            private final NativeMethodStrategy nativeMethodStrategy;
            private final PoolStrategy poolStrategy;
            private final RedefinitionStrategy.ResubmissionEnforcer resubmissionEnforcer;
            private final List<Transformation> transformations;
            private final TypeStrategy typeStrategy;

            /*
             * JADX INFO: compiled from:
             * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
             */
            public interface Factory {

                /*
                 * JADX INFO: compiled from:
                 * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
                 */
                public enum CreationAction implements PrivilegedAction<Factory> {
                    INSTANCE;

                    @Override // java.security.PrivilegedAction
                    public Factory run() {
                        try {
                            return new ForJava9CapableVm(new ByteBuddy().with(TypeValidation.DISABLED)
                                    .subclass(ExecutingTransformer.class)
                                    .name(ExecutingTransformer.class.getName().concat("$ByteBuddy$ModuleSupport"))
                                    .method(ElementMatchers.named("transform")
                                            .and(ElementMatchers.takesArgument(0, JavaType.MODULE.load())))
                                    .intercept(
                                            MethodCall
                                                    .invoke(ExecutingTransformer.class.getDeclaredMethod("transform",
                                                            Object.class, ClassLoader.class, String.class, Class.class,
                                                            ProtectionDomain.class, byte[].class))
                                                    .onSuper().withAllArguments())
                                    .make()
                                    .load(ExecutingTransformer.class.getClassLoader(),
                                            ClassLoadingStrategy.Default.WRAPPER_PERSISTENT
                                                    .with(ExecutingTransformer.class.getProtectionDomain()))
                                    .getLoaded()
                                    .getDeclaredConstructor(ByteBuddy.class, Listener.class, PoolStrategy.class,
                                            TypeStrategy.class, LocationStrategy.class, ClassFileLocator.class,
                                            NativeMethodStrategy.class, InitializationStrategy.class,
                                            InjectionStrategy.class, LambdaInstrumentationStrategy.class,
                                            DescriptionStrategy.class, FallbackStrategy.class,
                                            ClassFileBufferStrategy.class, InstallationListener.class, RawMatcher.class,
                                            RedefinitionStrategy.ResubmissionEnforcer.class, List.class,
                                            CircularityLock.class));
                        } catch (Exception unused) {
                            return ForLegacyVm.INSTANCE;
                        }
                    }
                }

                /*
                 * JADX INFO: compiled from:
                 * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
                 */
                @HashCodeAndEqualsPlugin.Enhance
                public static class ForJava9CapableVm implements Factory {
                    private final Constructor<? extends ResettableClassFileTransformer> executingTransformer;

                    public ForJava9CapableVm(Constructor<? extends ResettableClassFileTransformer> constructor) {
                        this.executingTransformer = constructor;
                    }

                    public boolean equals(@MaybeNull Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        return obj != null && getClass() == obj.getClass()
                                && this.executingTransformer.equals(((ForJava9CapableVm) obj).executingTransformer);
                    }

                    public int hashCode() {
                        return this.executingTransformer.hashCode() + (getClass().hashCode() * 31);
                    }

                    @Override // net.bytebuddy.agent.builder.AgentBuilder.Default.ExecutingTransformer.Factory
                    public ResettableClassFileTransformer make(ByteBuddy byteBuddy, Listener listener,
                            PoolStrategy poolStrategy, TypeStrategy typeStrategy, LocationStrategy locationStrategy,
                            ClassFileLocator classFileLocator, NativeMethodStrategy nativeMethodStrategy,
                            InitializationStrategy initializationStrategy, InjectionStrategy injectionStrategy,
                            LambdaInstrumentationStrategy lambdaInstrumentationStrategy,
                            DescriptionStrategy descriptionStrategy, FallbackStrategy fallbackStrategy,
                            ClassFileBufferStrategy classFileBufferStrategy, InstallationListener installationListener,
                            RawMatcher rawMatcher, RedefinitionStrategy.ResubmissionEnforcer resubmissionEnforcer,
                            List<Transformation> list, CircularityLock circularityLock) {
                        try {
                            return this.executingTransformer.newInstance(byteBuddy, listener, poolStrategy,
                                    typeStrategy, locationStrategy, classFileLocator, nativeMethodStrategy,
                                    initializationStrategy, injectionStrategy, lambdaInstrumentationStrategy,
                                    descriptionStrategy, fallbackStrategy, classFileBufferStrategy,
                                    installationListener, rawMatcher, resubmissionEnforcer, list, circularityLock);
                        } catch (IllegalAccessException e) {
                            throw new IllegalStateException("Cannot access " + this.executingTransformer, e);
                        } catch (InstantiationException e2) {
                            throw new IllegalStateException(
                                    "Cannot instantiate " + this.executingTransformer.getDeclaringClass(), e2);
                        } catch (InvocationTargetException e3) {
                            throw new IllegalStateException("Cannot invoke " + this.executingTransformer,
                                    e3.getTargetException());
                        }
                    }
                }

                /*
                 * JADX INFO: compiled from:
                 * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
                 */
                public enum ForLegacyVm implements Factory {
                    INSTANCE;

                    @Override // net.bytebuddy.agent.builder.AgentBuilder.Default.ExecutingTransformer.Factory
                    public ResettableClassFileTransformer make(ByteBuddy byteBuddy, Listener listener,
                            PoolStrategy poolStrategy, TypeStrategy typeStrategy, LocationStrategy locationStrategy,
                            ClassFileLocator classFileLocator, NativeMethodStrategy nativeMethodStrategy,
                            InitializationStrategy initializationStrategy, InjectionStrategy injectionStrategy,
                            LambdaInstrumentationStrategy lambdaInstrumentationStrategy,
                            DescriptionStrategy descriptionStrategy, FallbackStrategy fallbackStrategy,
                            ClassFileBufferStrategy classFileBufferStrategy, InstallationListener installationListener,
                            RawMatcher rawMatcher, RedefinitionStrategy.ResubmissionEnforcer resubmissionEnforcer,
                            List<Transformation> list, CircularityLock circularityLock) {
                        return new ExecutingTransformer(byteBuddy, listener, poolStrategy, typeStrategy,
                                locationStrategy, classFileLocator, nativeMethodStrategy, initializationStrategy,
                                injectionStrategy, lambdaInstrumentationStrategy, descriptionStrategy, fallbackStrategy,
                                classFileBufferStrategy, installationListener, rawMatcher, resubmissionEnforcer, list,
                                circularityLock);
                    }
                }

                ResettableClassFileTransformer make(ByteBuddy byteBuddy, Listener listener, PoolStrategy poolStrategy,
                        TypeStrategy typeStrategy, LocationStrategy locationStrategy, ClassFileLocator classFileLocator,
                        NativeMethodStrategy nativeMethodStrategy, InitializationStrategy initializationStrategy,
                        InjectionStrategy injectionStrategy,
                        LambdaInstrumentationStrategy lambdaInstrumentationStrategy,
                        DescriptionStrategy descriptionStrategy, FallbackStrategy fallbackStrategy,
                        ClassFileBufferStrategy classFileBufferStrategy, InstallationListener installationListener,
                        RawMatcher rawMatcher, RedefinitionStrategy.ResubmissionEnforcer resubmissionEnforcer,
                        List<Transformation> list, CircularityLock circularityLock);
            }

            /*
             * JADX INFO: compiled from:
             * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
             */
            @HashCodeAndEqualsPlugin.Enhance(includeSyntheticFields = true)
            public class Java9CapableVmDispatcher implements PrivilegedAction<byte[]> {
                private final byte[] binaryRepresentation;

                @MaybeNull
                @HashCodeAndEqualsPlugin.ValueHandling(HashCodeAndEqualsPlugin.ValueHandling.Sort.REVERSE_NULLABILITY)
                private final Class<?> classBeingRedefined;

                @MaybeNull
                @HashCodeAndEqualsPlugin.ValueHandling(HashCodeAndEqualsPlugin.ValueHandling.Sort.REVERSE_NULLABILITY)
                private final ClassLoader classLoader;

                @MaybeNull
                @HashCodeAndEqualsPlugin.ValueHandling(HashCodeAndEqualsPlugin.ValueHandling.Sort.REVERSE_NULLABILITY)
                private final String internalName;

                @MaybeNull
                @HashCodeAndEqualsPlugin.ValueHandling(HashCodeAndEqualsPlugin.ValueHandling.Sort.REVERSE_NULLABILITY)
                private final ProtectionDomain protectionDomain;
                private final Object rawModule;

                public Java9CapableVmDispatcher(Object obj, @MaybeNull ClassLoader classLoader, @MaybeNull String str,
                        @MaybeNull Class<?> cls, @MaybeNull ProtectionDomain protectionDomain, byte[] bArr) {
                    this.rawModule = obj;
                    this.classLoader = classLoader;
                    this.internalName = str;
                    this.classBeingRedefined = cls;
                    this.protectionDomain = protectionDomain;
                    this.binaryRepresentation = bArr;
                }

                /*
                 * JADX WARN: Code restructure failed: missing block: B:17:0x0024, code lost:
                 * 
                 * if (r2 != null) goto L18;
                 */
                /*
                 * JADX WARN: Code restructure failed: missing block: B:28:0x0041, code lost:
                 * 
                 * if (r2 != null) goto L29;
                 */
                /*
                 * JADX WARN: Code restructure failed: missing block: B:36:0x0053, code lost:
                 * 
                 * if (r2 != null) goto L37;
                 */
                /*
                 * JADX WARN: Code restructure failed: missing block: B:44:0x0065, code lost:
                 * 
                 * if (r2 != null) goto L45;
                 */
                /*
                 * Code decompiled incorrectly, please refer to instructions dump.
                 * To view partially-correct add '--show-bad-code' argument
                 */
                public boolean equals(@net.bytebuddy.utility.nullability.MaybeNull java.lang.Object r5) {
                    /*
                     * r4 = this;
                     * r0 = 1
                     * if (r4 != r5) goto L4
                     * return r0
                     * L4:
                     * r1 = 0
                     * if (r5 != 0) goto L8
                     * return r1
                     * L8:
                     * java.lang.Class r2 = r4.getClass()
                     * java.lang.Class r3 = r5.getClass()
                     * if (r2 == r3) goto L13
                     * return r1
                     * L13:
                     * java.lang.String r2 = r4.internalName
                     * net.bytebuddy.agent.builder.
                     * AgentBuilder$Default$ExecutingTransformer$Java9CapableVmDispatcher r5 =
                     * (net.bytebuddy.agent.builder.AgentBuilder.Default.ExecutingTransformer.
                     * Java9CapableVmDispatcher) r5
                     * java.lang.String r3 = r5.internalName
                     * if (r3 == 0) goto L24
                     * if (r2 == 0) goto L26
                     * boolean r2 = r2.equals(r3)
                     * if (r2 != 0) goto L27
                     * return r1
                     * L24:
                     * if (r2 == 0) goto L27
                     * L26:
                     * return r1
                     * L27:
                     * java.lang.Object r2 = r4.rawModule
                     * java.lang.Object r3 = r5.rawModule
                     * boolean r2 = r2.equals(r3)
                     * if (r2 != 0) goto L32
                     * return r1
                     * L32:
                     * java.lang.ClassLoader r2 = r4.classLoader
                     * java.lang.ClassLoader r3 = r5.classLoader
                     * if (r3 == 0) goto L41
                     * if (r2 == 0) goto L43
                     * boolean r2 = r2.equals(r3)
                     * if (r2 != 0) goto L44
                     * return r1
                     * L41:
                     * if (r2 == 0) goto L44
                     * L43:
                     * return r1
                     * L44:
                     * java.lang.Class<?> r2 = r4.classBeingRedefined
                     * java.lang.Class<?> r3 = r5.classBeingRedefined
                     * if (r3 == 0) goto L53
                     * if (r2 == 0) goto L55
                     * boolean r2 = r2.equals(r3)
                     * if (r2 != 0) goto L56
                     * return r1
                     * L53:
                     * if (r2 == 0) goto L56
                     * L55:
                     * return r1
                     * L56:
                     * java.security.ProtectionDomain r2 = r4.protectionDomain
                     * java.security.ProtectionDomain r3 = r5.protectionDomain
                     * if (r3 == 0) goto L65
                     * if (r2 == 0) goto L67
                     * boolean r2 = r2.equals(r3)
                     * if (r2 != 0) goto L68
                     * return r1
                     * L65:
                     * if (r2 == 0) goto L68
                     * L67:
                     * return r1
                     * L68:
                     * byte[] r2 = r4.binaryRepresentation
                     * byte[] r3 = r5.binaryRepresentation
                     * boolean r2 = java.util.Arrays.equals(r2, r3)
                     * if (r2 != 0) goto L73
                     * return r1
                     * L73:
                     * net.bytebuddy.agent.builder.AgentBuilder$Default$ExecutingTransformer r2 =
                     * net.bytebuddy.agent.builder.AgentBuilder.Default.ExecutingTransformer.this
                     * net.bytebuddy.agent.builder.AgentBuilder$Default$ExecutingTransformer r5 =
                     * net.bytebuddy.agent.builder.AgentBuilder.Default.ExecutingTransformer.this
                     * boolean r5 = r2.equals(r5)
                     * if (r5 != 0) goto L7e
                     * return r1
                     * L7e:
                     * return r0
                     */
                    throw new UnsupportedOperationException(
                            "Method not decompiled: net.bytebuddy.agent.builder.AgentBuilder.Default.ExecutingTransformer.Java9CapableVmDispatcher.equals(java.lang.Object):boolean");
                }

                public int hashCode() {
                    int iHashCode = (this.rawModule.hashCode() + (getClass().hashCode() * 31)) * 31;
                    ClassLoader classLoader = this.classLoader;
                    if (classLoader != null) {
                        iHashCode += classLoader.hashCode();
                    }
                    int iHashCode2 = iHashCode * 31;
                    String str = this.internalName;
                    if (str != null) {
                        iHashCode2 += str.hashCode();
                    }
                    int iHashCode3 = iHashCode2 * 31;
                    Class<?> cls = this.classBeingRedefined;
                    if (cls != null) {
                        iHashCode3 += cls.hashCode();
                    }
                    int iHashCode4 = iHashCode3 * 31;
                    ProtectionDomain protectionDomain = this.protectionDomain;
                    if (protectionDomain != null) {
                        iHashCode4 += protectionDomain.hashCode();
                    }
                    return ExecutingTransformer.this.hashCode()
                            + ((Arrays.hashCode(this.binaryRepresentation) + (iHashCode4 * 31)) * 31);
                }

                @Override // java.security.PrivilegedAction
                @MaybeNull
                public byte[] run() {
                    return ExecutingTransformer.this.transform(JavaModule.of(this.rawModule), this.classLoader,
                            this.internalName, this.classBeingRedefined, this.protectionDomain,
                            this.binaryRepresentation);
                }
            }

            /*
             * JADX INFO: compiled from:
             * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
             */
            @HashCodeAndEqualsPlugin.Enhance(includeSyntheticFields = true)
            public class LegacyVmDispatcher implements PrivilegedAction<byte[]> {
                private final byte[] binaryRepresentation;

                @MaybeNull
                @HashCodeAndEqualsPlugin.ValueHandling(HashCodeAndEqualsPlugin.ValueHandling.Sort.REVERSE_NULLABILITY)
                private final Class<?> classBeingRedefined;

                @MaybeNull
                @HashCodeAndEqualsPlugin.ValueHandling(HashCodeAndEqualsPlugin.ValueHandling.Sort.REVERSE_NULLABILITY)
                private final ClassLoader classLoader;

                @MaybeNull
                @HashCodeAndEqualsPlugin.ValueHandling(HashCodeAndEqualsPlugin.ValueHandling.Sort.REVERSE_NULLABILITY)
                private final String internalName;

                @MaybeNull
                @HashCodeAndEqualsPlugin.ValueHandling(HashCodeAndEqualsPlugin.ValueHandling.Sort.REVERSE_NULLABILITY)
                private final ProtectionDomain protectionDomain;

                public LegacyVmDispatcher(@MaybeNull ClassLoader classLoader, @MaybeNull String str,
                        @MaybeNull Class<?> cls, @MaybeNull ProtectionDomain protectionDomain, byte[] bArr) {
                    this.classLoader = classLoader;
                    this.internalName = str;
                    this.classBeingRedefined = cls;
                    this.protectionDomain = protectionDomain;
                    this.binaryRepresentation = bArr;
                }

                /*
                 * JADX WARN: Code restructure failed: missing block: B:17:0x0024, code lost:
                 * 
                 * if (r2 != null) goto L18;
                 */
                /*
                 * JADX WARN: Code restructure failed: missing block: B:25:0x0036, code lost:
                 * 
                 * if (r2 != null) goto L26;
                 */
                /*
                 * JADX WARN: Code restructure failed: missing block: B:33:0x0048, code lost:
                 * 
                 * if (r2 != null) goto L34;
                 */
                /*
                 * JADX WARN: Code restructure failed: missing block: B:41:0x005a, code lost:
                 * 
                 * if (r2 != null) goto L42;
                 */
                /*
                 * Code decompiled incorrectly, please refer to instructions dump.
                 * To view partially-correct add '--show-bad-code' argument
                 */
                public boolean equals(@net.bytebuddy.utility.nullability.MaybeNull java.lang.Object r5) {
                    /*
                     * r4 = this;
                     * r0 = 1
                     * if (r4 != r5) goto L4
                     * return r0
                     * L4:
                     * r1 = 0
                     * if (r5 != 0) goto L8
                     * return r1
                     * L8:
                     * java.lang.Class r2 = r4.getClass()
                     * java.lang.Class r3 = r5.getClass()
                     * if (r2 == r3) goto L13
                     * return r1
                     * L13:
                     * java.lang.String r2 = r4.internalName
                     * net.bytebuddy.agent.builder.
                     * AgentBuilder$Default$ExecutingTransformer$LegacyVmDispatcher r5 =
                     * (net.bytebuddy.agent.builder.AgentBuilder.Default.ExecutingTransformer.
                     * LegacyVmDispatcher) r5
                     * java.lang.String r3 = r5.internalName
                     * if (r3 == 0) goto L24
                     * if (r2 == 0) goto L26
                     * boolean r2 = r2.equals(r3)
                     * if (r2 != 0) goto L27
                     * return r1
                     * L24:
                     * if (r2 == 0) goto L27
                     * L26:
                     * return r1
                     * L27:
                     * java.lang.ClassLoader r2 = r4.classLoader
                     * java.lang.ClassLoader r3 = r5.classLoader
                     * if (r3 == 0) goto L36
                     * if (r2 == 0) goto L38
                     * boolean r2 = r2.equals(r3)
                     * if (r2 != 0) goto L39
                     * return r1
                     * L36:
                     * if (r2 == 0) goto L39
                     * L38:
                     * return r1
                     * L39:
                     * java.lang.Class<?> r2 = r4.classBeingRedefined
                     * java.lang.Class<?> r3 = r5.classBeingRedefined
                     * if (r3 == 0) goto L48
                     * if (r2 == 0) goto L4a
                     * boolean r2 = r2.equals(r3)
                     * if (r2 != 0) goto L4b
                     * return r1
                     * L48:
                     * if (r2 == 0) goto L4b
                     * L4a:
                     * return r1
                     * L4b:
                     * java.security.ProtectionDomain r2 = r4.protectionDomain
                     * java.security.ProtectionDomain r3 = r5.protectionDomain
                     * if (r3 == 0) goto L5a
                     * if (r2 == 0) goto L5c
                     * boolean r2 = r2.equals(r3)
                     * if (r2 != 0) goto L5d
                     * return r1
                     * L5a:
                     * if (r2 == 0) goto L5d
                     * L5c:
                     * return r1
                     * L5d:
                     * byte[] r2 = r4.binaryRepresentation
                     * byte[] r3 = r5.binaryRepresentation
                     * boolean r2 = java.util.Arrays.equals(r2, r3)
                     * if (r2 != 0) goto L68
                     * return r1
                     * L68:
                     * net.bytebuddy.agent.builder.AgentBuilder$Default$ExecutingTransformer r2 =
                     * net.bytebuddy.agent.builder.AgentBuilder.Default.ExecutingTransformer.this
                     * net.bytebuddy.agent.builder.AgentBuilder$Default$ExecutingTransformer r5 =
                     * net.bytebuddy.agent.builder.AgentBuilder.Default.ExecutingTransformer.this
                     * boolean r5 = r2.equals(r5)
                     * if (r5 != 0) goto L73
                     * return r1
                     * L73:
                     * return r0
                     */
                    throw new UnsupportedOperationException(
                            "Method not decompiled: net.bytebuddy.agent.builder.AgentBuilder.Default.ExecutingTransformer.LegacyVmDispatcher.equals(java.lang.Object):boolean");
                }

                public int hashCode() {
                    int iHashCode = getClass().hashCode() * 31;
                    ClassLoader classLoader = this.classLoader;
                    if (classLoader != null) {
                        iHashCode += classLoader.hashCode();
                    }
                    int iHashCode2 = iHashCode * 31;
                    String str = this.internalName;
                    if (str != null) {
                        iHashCode2 += str.hashCode();
                    }
                    int iHashCode3 = iHashCode2 * 31;
                    Class<?> cls = this.classBeingRedefined;
                    if (cls != null) {
                        iHashCode3 += cls.hashCode();
                    }
                    int iHashCode4 = iHashCode3 * 31;
                    ProtectionDomain protectionDomain = this.protectionDomain;
                    if (protectionDomain != null) {
                        iHashCode4 += protectionDomain.hashCode();
                    }
                    return ExecutingTransformer.this.hashCode()
                            + ((Arrays.hashCode(this.binaryRepresentation) + (iHashCode4 * 31)) * 31);
                }

                @Override // java.security.PrivilegedAction
                @MaybeNull
                public byte[] run() {
                    return ExecutingTransformer.this.transform(JavaModule.UNSUPPORTED, this.classLoader,
                            this.internalName, this.classBeingRedefined, this.protectionDomain,
                            this.binaryRepresentation);
                }
            }

            static {
                boolean z = false;
                try {
                    Class.forName("java.security.AccessController", false, null);
                    ACCESS_CONTROLLER = Boolean
                            .parseBoolean(System.getProperty("net.bytebuddy.securitymanager", "true"));
                } catch (ClassNotFoundException unused) {
                    ACCESS_CONTROLLER = z;
                } catch (SecurityException unused2) {
                    z = true;
                    ACCESS_CONTROLLER = z;
                }
                FACTORY = (Factory) Default.doPrivileged(Factory.CreationAction.INSTANCE);
            }

            public ExecutingTransformer(ByteBuddy byteBuddy, Listener listener, PoolStrategy poolStrategy,
                    TypeStrategy typeStrategy, LocationStrategy locationStrategy, ClassFileLocator classFileLocator,
                    NativeMethodStrategy nativeMethodStrategy, InitializationStrategy initializationStrategy,
                    InjectionStrategy injectionStrategy, LambdaInstrumentationStrategy lambdaInstrumentationStrategy,
                    DescriptionStrategy descriptionStrategy, FallbackStrategy fallbackStrategy,
                    ClassFileBufferStrategy classFileBufferStrategy, InstallationListener installationListener,
                    RawMatcher rawMatcher, RedefinitionStrategy.ResubmissionEnforcer resubmissionEnforcer,
                    List<Transformation> list, CircularityLock circularityLock) {
                this.byteBuddy = byteBuddy;
                this.typeStrategy = typeStrategy;
                this.poolStrategy = poolStrategy;
                this.locationStrategy = locationStrategy;
                this.classFileLocator = classFileLocator;
                this.listener = listener;
                this.nativeMethodStrategy = nativeMethodStrategy;
                this.initializationStrategy = initializationStrategy;
                this.injectionStrategy = injectionStrategy;
                this.lambdaInstrumentationStrategy = lambdaInstrumentationStrategy;
                this.descriptionStrategy = descriptionStrategy;
                this.fallbackStrategy = fallbackStrategy;
                this.classFileBufferStrategy = classFileBufferStrategy;
                this.installationListener = installationListener;
                this.ignoreMatcher = rawMatcher;
                this.resubmissionEnforcer = resubmissionEnforcer;
                this.transformations = list;
                this.circularityLock = circularityLock;
            }

            @AccessControllerPlugin.Enhance
            private static <T> T doPrivileged(PrivilegedAction<T> privilegedAction, @MaybeNull Object obj) {
                return ACCESS_CONTROLLER
                        ? (T) AccessController.doPrivileged(privilegedAction, (AccessControlContext) obj)
                        : privilegedAction.run();
            }

            @MaybeNull
            private byte[] doTransform(@MaybeNull JavaModule javaModule, @MaybeNull ClassLoader classLoader, String str,
                    @MaybeNull Class<?> cls, boolean z, @MaybeNull ProtectionDomain protectionDomain, TypePool typePool,
                    ClassFileLocator classFileLocator) {
                TypeDescription typeDescriptionApply = this.descriptionStrategy.apply(str, cls, typePool,
                        this.circularityLock, classLoader, javaModule);
                ArrayList arrayList = new ArrayList();
                if (!this.ignoreMatcher.matches(typeDescriptionApply, classLoader, javaModule, cls, protectionDomain)) {
                    for (Transformation transformation : this.transformations) {
                        if (transformation.getMatcher().matches(typeDescriptionApply, classLoader, javaModule, cls,
                                protectionDomain)) {
                            arrayList.addAll(transformation.getTransformers());
                            if (transformation.isTerminal()) {
                                break;
                            }
                        }
                    }
                }
                if (arrayList.isEmpty()) {
                    this.listener.onIgnored(typeDescriptionApply, classLoader, javaModule, z);
                    return Transformation.NONE;
                }
                DynamicType.Builder<?> builder = this.typeStrategy.builder(typeDescriptionApply, this.byteBuddy,
                        classFileLocator, this.nativeMethodStrategy.resolve(), classLoader, javaModule,
                        protectionDomain);
                InitializationStrategy.Dispatcher dispatcher = this.initializationStrategy.dispatcher();
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    TypeDescription typeDescription = typeDescriptionApply;
                    builder = ((Transformer) it.next()).transform(builder, typeDescription, classLoader, javaModule,
                            protectionDomain);
                    typeDescriptionApply = typeDescription;
                }
                DynamicType.Unloaded<?> unloadedMake = dispatcher.apply(builder)
                        .make(TypeResolutionStrategy.Disabled.INSTANCE, typePool);
                dispatcher.register(unloadedMake, classLoader, protectionDomain, this.injectionStrategy);
                this.listener.onTransformation(typeDescriptionApply, classLoader, javaModule, z, unloadedMake);
                return unloadedMake.getBytes();
            }

            @MaybeNull
            @AccessControllerPlugin.Enhance
            private static Object getContext() {
                if (ACCESS_CONTROLLER) {
                    return AccessController.getContext();
                }
                return null;
            }

            @Override // net.bytebuddy.agent.builder.ResettableClassFileTransformer
            public Iterator<Transformer> iterator(TypeDescription typeDescription, @MaybeNull ClassLoader classLoader,
                    @MaybeNull JavaModule javaModule, @MaybeNull Class<?> cls,
                    @MaybeNull ProtectionDomain protectionDomain) {
                return this.ignoreMatcher.matches(typeDescription, classLoader, javaModule, cls, protectionDomain)
                        ? Collections.EMPTY_SET.iterator()
                        : new Transformation.TransformerIterator(typeDescription, classLoader, javaModule, cls,
                                protectionDomain, this.transformations);
            }

            @Override // net.bytebuddy.agent.builder.ResettableClassFileTransformer
            public synchronized boolean reset(Instrumentation instrumentation,
                    ResettableClassFileTransformer resettableClassFileTransformer,
                    RedefinitionStrategy redefinitionStrategy, RedefinitionStrategy.DiscoveryStrategy discoveryStrategy,
                    RedefinitionStrategy.BatchAllocator batchAllocator, RedefinitionStrategy.Listener listener) {
                if (!instrumentation.removeTransformer(resettableClassFileTransformer)) {
                    return false;
                }
                redefinitionStrategy.apply(instrumentation, this.poolStrategy, this.locationStrategy,
                        this.descriptionStrategy, this.fallbackStrategy, discoveryStrategy,
                        this.lambdaInstrumentationStrategy, Listener.NoOp.INSTANCE, listener,
                        new Transformation.SimpleMatcher(this.ignoreMatcher, this.transformations), batchAllocator,
                        CircularityLock.Inactive.INSTANCE);
                this.installationListener.onReset(instrumentation, resettableClassFileTransformer);
                return true;
            }

            @MaybeNull
            public byte[] transform(@MaybeNull ClassLoader classLoader, @MaybeNull String str, @MaybeNull Class<?> cls,
                    @MaybeNull ProtectionDomain protectionDomain, byte[] bArr) throws Throwable {
                ExecutingTransformer executingTransformer;
                if (!this.circularityLock.acquire()) {
                    return Default.NO_TRANSFORMATION;
                }
                try {
                    executingTransformer = this;
                    try {
                        byte[] bArr2 = (byte[]) doPrivileged(executingTransformer.new LegacyVmDispatcher(classLoader,
                                str, cls, protectionDomain, bArr), executingTransformer.accessControlContext);
                        executingTransformer.circularityLock.release();
                        return bArr2;
                    } catch (Throwable th) {
                        th = th;
                        Throwable th2 = th;
                        executingTransformer.circularityLock.release();
                        throw th2;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    executingTransformer = this;
                }
            }

            @MaybeNull
            public byte[] transform(Object obj, @MaybeNull ClassLoader classLoader, @MaybeNull String str,
                    @MaybeNull Class<?> cls, @MaybeNull ProtectionDomain protectionDomain, byte[] bArr)
                    throws Throwable {
                ExecutingTransformer executingTransformer;
                if (!this.circularityLock.acquire()) {
                    return Default.NO_TRANSFORMATION;
                }
                try {
                    executingTransformer = this;
                    try {
                        byte[] bArr2 = (byte[]) doPrivileged(executingTransformer.new Java9CapableVmDispatcher(obj,
                                classLoader, str, cls, protectionDomain, bArr),
                                executingTransformer.accessControlContext);
                        executingTransformer.circularityLock.release();
                        return bArr2;
                    } catch (Throwable th) {
                        th = th;
                        Throwable th2 = th;
                        executingTransformer.circularityLock.release();
                        throw th2;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    executingTransformer = this;
                }
            }

            /* JADX INFO: Access modifiers changed from: private */
            /* JADX WARN: Found duplicated region for block: B:67:0x00c4 */
            /* JADX WARN: Found duplicated region for block: B:69:0x00c7 */
            @MaybeNull
            public byte[] transform(@MaybeNull JavaModule javaModule, @MaybeNull ClassLoader classLoader,
                    @MaybeNull String str, @MaybeNull Class<?> cls, @MaybeNull ProtectionDomain protectionDomain,
                    byte[] bArr) {
                Class<?> cls2;
                Throwable th;
                Class<?> cls3;
                ClassLoader classLoader2 = classLoader;
                if (str == null || !this.lambdaInstrumentationStrategy.isInstrumented(cls)) {
                    return Default.NO_TRANSFORMATION;
                }
                String strReplace = str.replace('/',
                        TypePool.Default.LazyTypeDescription.GenericTypeToken.INNER_CLASS_PATH);
                try {
                    if (this.resubmissionEnforcer.isEnforced(strReplace, classLoader2, javaModule, cls)) {
                        try {
                            return Default.NO_TRANSFORMATION;
                        } catch (Throwable th2) {
                            th = th2;
                            cls2 = cls;
                            try {
                                this.listener.onDiscovery(strReplace, classLoader2, javaModule, cls2 != null);
                                this.listener.onError(strReplace, classLoader2, javaModule, cls2 != null, th);
                                throw new IllegalStateException(yg.k("Failed transformation of ", strReplace), th);
                            } catch (Throwable th3) {
                                this.listener.onError(strReplace, classLoader, javaModule, cls2 != null, th);
                                throw th3;
                            }
                        }
                    }
                    try {
                        this.listener.onDiscovery(strReplace, classLoader2, javaModule, cls != null);
                        try {
                            ClassFileLocator classFileLocatorResolve = this.classFileBufferStrategy.resolve(strReplace,
                                    bArr, classLoader2, javaModule, protectionDomain);
                            classLoader2 = classLoader2;
                            try {
                                ClassFileLocator.Compound compound = new ClassFileLocator.Compound(
                                        classFileLocatorResolve, this.classFileLocator,
                                        this.locationStrategy.classFileLocator(classLoader2, javaModule));
                                TypePool typePool = this.classFileBufferStrategy.typePool(this.poolStrategy, compound,
                                        classLoader2, strReplace);
                                try {
                                    byte[] bArrDoTransform = doTransform(javaModule, classLoader2, strReplace, cls,
                                            cls != null, protectionDomain, typePool, compound);
                                    this.listener.onComplete(strReplace, classLoader2, javaModule, cls != null);
                                    return bArrDoTransform;
                                } catch (Throwable th4) {
                                    classLoader2 = classLoader2;
                                    cls3 = cls;
                                    if (cls3 != null) {
                                        try {
                                            if (this.descriptionStrategy.isLoadedFirst()
                                                    && this.fallbackStrategy.isFallback(cls3, th4)) {
                                                try {
                                                    byte[] bArrDoTransform2 = doTransform(javaModule, classLoader2,
                                                            strReplace, Default.NOT_PREVIOUSLY_DEFINED, true,
                                                            protectionDomain, typePool, compound);
                                                    this.listener.onComplete(strReplace, classLoader2, javaModule,
                                                            true);
                                                    return bArrDoTransform2;
                                                } catch (Throwable th5) {
                                                    th = th5;
                                                    classLoader2 = classLoader2;
                                                    strReplace = strReplace;
                                                    Throwable th6 = th;
                                                    try {
                                                        this.listener.onError(strReplace, classLoader2, javaModule,
                                                                cls3 != null, th6);
                                                        throw new IllegalStateException(
                                                                "Failed transformation of " + strReplace, th6);
                                                    } catch (Throwable th7) {
                                                        this.listener.onComplete(strReplace, classLoader2, javaModule,
                                                                cls3 != null);
                                                        throw th7;
                                                    }
                                                }
                                            }
                                        } catch (Throwable th8) {
                                            th = th8;
                                        }
                                    }
                                    strReplace = strReplace;
                                    try {
                                        throw th4;
                                    } catch (Throwable th9) {
                                        th = th9;
                                        Throwable th62 = th;
                                        this.listener.onError(strReplace, classLoader2, javaModule, cls3 != null, th62);
                                        throw new IllegalStateException("Failed transformation of " + strReplace, th62);
                                    }
                                }
                            } catch (Throwable th10) {
                                th = th10;
                                cls3 = cls;
                                Throwable th622 = th;
                                this.listener.onError(strReplace, classLoader2, javaModule, cls3 != null, th622);
                                throw new IllegalStateException("Failed transformation of " + strReplace, th622);
                            }
                        } catch (Throwable th11) {
                            th = th11;
                            classLoader2 = classLoader2;
                        }
                    } catch (Throwable th12) {
                        th = th12;
                    }
                } catch (Throwable th13) {
                    cls2 = cls;
                    th = th13;
                }
            }
        }

        public static AgentBuilder of(ClassFileVersion classFileVersion, Plugin... pluginArr) {
            return of(classFileVersion, (List<? extends Plugin>) Arrays.asList(pluginArr));
        }

        @Override // net.bytebuddy.agent.builder.AgentBuilder
        public AgentBuilder with(PoolStrategy poolStrategy) {
            return new Default(this.byteBuddy, this.listener, this.circularityLock, poolStrategy, this.typeStrategy,
                    this.locationStrategy, this.classFileLocator, this.nativeMethodStrategy, this.warmupStrategy,
                    this.transformerDecorator, this.initializationStrategy, this.redefinitionStrategy,
                    this.redefinitionDiscoveryStrategy, this.redefinitionBatchAllocator, this.redefinitionListener,
                    this.redefinitionResubmissionStrategy, this.injectionStrategy, this.lambdaInstrumentationStrategy,
                    this.descriptionStrategy, this.fallbackStrategy, this.classFileBufferStrategy,
                    this.installationListener, this.ignoreMatcher, this.transformations);
        }

        public static AgentBuilder of(ClassFileVersion classFileVersion, List<? extends Plugin> list) {
            return of(EntryPoint.Default.REBASE, classFileVersion, list);
        }

        @Override // net.bytebuddy.agent.builder.AgentBuilder
        public ResettableClassFileTransformer patchOn(Instrumentation instrumentation,
                ResettableClassFileTransformer resettableClassFileTransformer, RawMatcher rawMatcher,
                PatchMode patchMode) {
            return doInstall(instrumentation, rawMatcher, patchMode.toHandler(resettableClassFileTransformer));
        }

        @Override // net.bytebuddy.agent.builder.AgentBuilder
        public AgentBuilder with(LocationStrategy locationStrategy) {
            return new Default(this.byteBuddy, this.listener, this.circularityLock, this.poolStrategy,
                    this.typeStrategy, locationStrategy, this.classFileLocator, this.nativeMethodStrategy,
                    this.warmupStrategy, this.transformerDecorator, this.initializationStrategy,
                    this.redefinitionStrategy, this.redefinitionDiscoveryStrategy, this.redefinitionBatchAllocator,
                    this.redefinitionListener, this.redefinitionResubmissionStrategy, this.injectionStrategy,
                    this.lambdaInstrumentationStrategy, this.descriptionStrategy, this.fallbackStrategy,
                    this.classFileBufferStrategy, this.installationListener, this.ignoreMatcher, this.transformations);
        }

        public static AgentBuilder of(EntryPoint entryPoint, ClassFileVersion classFileVersion, Plugin... pluginArr) {
            return of(entryPoint, classFileVersion, (List<? extends Plugin>) Arrays.asList(pluginArr));
        }

        @Override // net.bytebuddy.agent.builder.AgentBuilder
        public AgentBuilder with(ClassFileLocator classFileLocator) {
            return new Default(this.byteBuddy, this.listener, this.circularityLock, this.poolStrategy,
                    this.typeStrategy, this.locationStrategy,
                    new ClassFileLocator.Compound(this.classFileLocator, classFileLocator), this.nativeMethodStrategy,
                    this.warmupStrategy, this.transformerDecorator, this.initializationStrategy,
                    this.redefinitionStrategy, this.redefinitionDiscoveryStrategy, this.redefinitionBatchAllocator,
                    this.redefinitionListener, this.redefinitionResubmissionStrategy, this.injectionStrategy,
                    this.lambdaInstrumentationStrategy, this.descriptionStrategy, this.fallbackStrategy,
                    this.classFileBufferStrategy, this.installationListener, this.ignoreMatcher, this.transformations);
        }

        public static AgentBuilder of(EntryPoint entryPoint, ClassFileVersion classFileVersion,
                List<? extends Plugin> list) {
            AgentBuilder agentBuilderWith = new Default(entryPoint.byteBuddy(classFileVersion))
                    .with(new TypeStrategy.ForBuildEntryPoint(entryPoint));
            for (Plugin plugin : list) {
                agentBuilderWith = agentBuilderWith.type(plugin).transform(new Transformer.ForBuildPlugin(plugin));
            }
            return agentBuilderWith;
        }

        @Override // net.bytebuddy.agent.builder.AgentBuilder
        public AgentBuilder with(TransformerDecorator transformerDecorator) {
            return new Default(this.byteBuddy, this.listener, this.circularityLock, this.poolStrategy,
                    this.typeStrategy, this.locationStrategy, this.classFileLocator, this.nativeMethodStrategy,
                    this.warmupStrategy,
                    new TransformerDecorator.Compound(this.transformerDecorator, transformerDecorator),
                    this.initializationStrategy, this.redefinitionStrategy, this.redefinitionDiscoveryStrategy,
                    this.redefinitionBatchAllocator, this.redefinitionListener, this.redefinitionResubmissionStrategy,
                    this.injectionStrategy, this.lambdaInstrumentationStrategy, this.descriptionStrategy,
                    this.fallbackStrategy, this.classFileBufferStrategy, this.installationListener, this.ignoreMatcher,
                    this.transformations);
        }

        @Override // net.bytebuddy.agent.builder.AgentBuilder
        public RedefinitionListenable.WithoutBatchStrategy with(RedefinitionStrategy redefinitionStrategy) {
            return new Redefining(this.byteBuddy, this.listener, this.circularityLock, this.poolStrategy,
                    this.typeStrategy, this.locationStrategy, this.classFileLocator, this.nativeMethodStrategy,
                    this.warmupStrategy, this.transformerDecorator, this.initializationStrategy, redefinitionStrategy,
                    RedefinitionStrategy.DiscoveryStrategy.SinglePass.INSTANCE,
                    RedefinitionStrategy.BatchAllocator.ForTotal.INSTANCE, RedefinitionStrategy.Listener.NoOp.INSTANCE,
                    RedefinitionStrategy.ResubmissionStrategy.Disabled.INSTANCE, this.injectionStrategy,
                    this.lambdaInstrumentationStrategy, this.descriptionStrategy, this.fallbackStrategy,
                    this.classFileBufferStrategy, this.installationListener, this.ignoreMatcher, this.transformations);
        }

        @Override // net.bytebuddy.agent.builder.AgentBuilder
        public AgentBuilder with(InitializationStrategy initializationStrategy) {
            return new Default(this.byteBuddy, this.listener, this.circularityLock, this.poolStrategy,
                    this.typeStrategy, this.locationStrategy, this.classFileLocator, this.nativeMethodStrategy,
                    this.warmupStrategy, this.transformerDecorator, initializationStrategy, this.redefinitionStrategy,
                    this.redefinitionDiscoveryStrategy, this.redefinitionBatchAllocator, this.redefinitionListener,
                    this.redefinitionResubmissionStrategy, this.injectionStrategy, this.lambdaInstrumentationStrategy,
                    this.descriptionStrategy, this.fallbackStrategy, this.classFileBufferStrategy,
                    this.installationListener, this.ignoreMatcher, this.transformations);
        }

        public Default(ByteBuddy byteBuddy, Listener listener, CircularityLock circularityLock,
                PoolStrategy poolStrategy, TypeStrategy typeStrategy, LocationStrategy locationStrategy,
                ClassFileLocator classFileLocator, NativeMethodStrategy nativeMethodStrategy,
                WarmupStrategy warmupStrategy, TransformerDecorator transformerDecorator,
                InitializationStrategy initializationStrategy, RedefinitionStrategy redefinitionStrategy,
                RedefinitionStrategy.DiscoveryStrategy discoveryStrategy,
                RedefinitionStrategy.BatchAllocator batchAllocator, RedefinitionStrategy.Listener listener2,
                RedefinitionStrategy.ResubmissionStrategy resubmissionStrategy, InjectionStrategy injectionStrategy,
                LambdaInstrumentationStrategy lambdaInstrumentationStrategy, DescriptionStrategy descriptionStrategy,
                FallbackStrategy fallbackStrategy, ClassFileBufferStrategy classFileBufferStrategy,
                InstallationListener installationListener, RawMatcher rawMatcher, List<Transformation> list) {
            this.byteBuddy = byteBuddy;
            this.listener = listener;
            this.circularityLock = circularityLock;
            this.poolStrategy = poolStrategy;
            this.typeStrategy = typeStrategy;
            this.locationStrategy = locationStrategy;
            this.classFileLocator = classFileLocator;
            this.nativeMethodStrategy = nativeMethodStrategy;
            this.warmupStrategy = warmupStrategy;
            this.transformerDecorator = transformerDecorator;
            this.initializationStrategy = initializationStrategy;
            this.redefinitionStrategy = redefinitionStrategy;
            this.redefinitionDiscoveryStrategy = discoveryStrategy;
            this.redefinitionBatchAllocator = batchAllocator;
            this.redefinitionListener = listener2;
            this.redefinitionResubmissionStrategy = resubmissionStrategy;
            this.injectionStrategy = injectionStrategy;
            this.lambdaInstrumentationStrategy = lambdaInstrumentationStrategy;
            this.descriptionStrategy = descriptionStrategy;
            this.fallbackStrategy = fallbackStrategy;
            this.classFileBufferStrategy = classFileBufferStrategy;
            this.installationListener = installationListener;
            this.ignoreMatcher = rawMatcher;
            this.transformations = list;
        }

        @Override // net.bytebuddy.agent.builder.AgentBuilder
        public AgentBuilder with(LambdaInstrumentationStrategy lambdaInstrumentationStrategy) {
            return new Default(this.byteBuddy, this.listener, this.circularityLock, this.poolStrategy,
                    this.typeStrategy, this.locationStrategy, this.classFileLocator, this.nativeMethodStrategy,
                    this.warmupStrategy, this.transformerDecorator, this.initializationStrategy,
                    this.redefinitionStrategy, this.redefinitionDiscoveryStrategy, this.redefinitionBatchAllocator,
                    this.redefinitionListener, this.redefinitionResubmissionStrategy, this.injectionStrategy,
                    lambdaInstrumentationStrategy, this.descriptionStrategy, this.fallbackStrategy,
                    this.classFileBufferStrategy, this.installationListener, this.ignoreMatcher, this.transformations);
        }

        @Override // net.bytebuddy.agent.builder.AgentBuilder
        public AgentBuilder with(DescriptionStrategy descriptionStrategy) {
            return new Default(this.byteBuddy, this.listener, this.circularityLock, this.poolStrategy,
                    this.typeStrategy, this.locationStrategy, this.classFileLocator, this.nativeMethodStrategy,
                    this.warmupStrategy, this.transformerDecorator, this.initializationStrategy,
                    this.redefinitionStrategy, this.redefinitionDiscoveryStrategy, this.redefinitionBatchAllocator,
                    this.redefinitionListener, this.redefinitionResubmissionStrategy, this.injectionStrategy,
                    this.lambdaInstrumentationStrategy, descriptionStrategy, this.fallbackStrategy,
                    this.classFileBufferStrategy, this.installationListener, this.ignoreMatcher, this.transformations);
        }

        @Override // net.bytebuddy.agent.builder.AgentBuilder
        public AgentBuilder with(FallbackStrategy fallbackStrategy) {
            return new Default(this.byteBuddy, this.listener, this.circularityLock, this.poolStrategy,
                    this.typeStrategy, this.locationStrategy, this.classFileLocator, this.nativeMethodStrategy,
                    this.warmupStrategy, this.transformerDecorator, this.initializationStrategy,
                    this.redefinitionStrategy, this.redefinitionDiscoveryStrategy, this.redefinitionBatchAllocator,
                    this.redefinitionListener, this.redefinitionResubmissionStrategy, this.injectionStrategy,
                    this.lambdaInstrumentationStrategy, this.descriptionStrategy, fallbackStrategy,
                    this.classFileBufferStrategy, this.installationListener, this.ignoreMatcher, this.transformations);
        }

        @Override // net.bytebuddy.agent.builder.AgentBuilder
        public AgentBuilder with(ClassFileBufferStrategy classFileBufferStrategy) {
            return new Default(this.byteBuddy, this.listener, this.circularityLock, this.poolStrategy,
                    this.typeStrategy, this.locationStrategy, this.classFileLocator, this.nativeMethodStrategy,
                    this.warmupStrategy, this.transformerDecorator, this.initializationStrategy,
                    this.redefinitionStrategy, this.redefinitionDiscoveryStrategy, this.redefinitionBatchAllocator,
                    this.redefinitionListener, this.redefinitionResubmissionStrategy, this.injectionStrategy,
                    this.lambdaInstrumentationStrategy, this.descriptionStrategy, this.fallbackStrategy,
                    classFileBufferStrategy, this.installationListener, this.ignoreMatcher, this.transformations);
        }

        @Override // net.bytebuddy.agent.builder.AgentBuilder
        public AgentBuilder with(InstallationListener installationListener) {
            return new Default(this.byteBuddy, this.listener, this.circularityLock, this.poolStrategy,
                    this.typeStrategy, this.locationStrategy, this.classFileLocator, this.nativeMethodStrategy,
                    this.warmupStrategy, this.transformerDecorator, this.initializationStrategy,
                    this.redefinitionStrategy, this.redefinitionDiscoveryStrategy, this.redefinitionBatchAllocator,
                    this.redefinitionListener, this.redefinitionResubmissionStrategy, this.injectionStrategy,
                    this.lambdaInstrumentationStrategy, this.descriptionStrategy, this.fallbackStrategy,
                    this.classFileBufferStrategy,
                    new InstallationListener.Compound(this.installationListener, installationListener),
                    this.ignoreMatcher, this.transformations);
        }

        @Override // net.bytebuddy.agent.builder.AgentBuilder
        public AgentBuilder with(InjectionStrategy injectionStrategy) {
            return new Default(this.byteBuddy, this.listener, this.circularityLock, this.poolStrategy,
                    this.typeStrategy, this.locationStrategy, this.classFileLocator, this.nativeMethodStrategy,
                    this.warmupStrategy, this.transformerDecorator, this.initializationStrategy,
                    this.redefinitionStrategy, this.redefinitionDiscoveryStrategy, this.redefinitionBatchAllocator,
                    this.redefinitionListener, this.redefinitionResubmissionStrategy, injectionStrategy,
                    this.lambdaInstrumentationStrategy, this.descriptionStrategy, this.fallbackStrategy,
                    this.classFileBufferStrategy, this.installationListener, this.ignoreMatcher, this.transformations);
        }
    }

    /*
     * JADX INFO: compiled from:
     * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
     */
    public interface DescriptionStrategy {

        /*
         * JADX INFO: compiled from:
         * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
         */
        public enum Default implements DescriptionStrategy {
            HYBRID(true) { // from class:
                           // net.bytebuddy.agent.builder.AgentBuilder.DescriptionStrategy.Default.1
                @Override // net.bytebuddy.agent.builder.AgentBuilder.DescriptionStrategy
                public TypeDescription apply(String str, @MaybeNull Class<?> cls, TypePool typePool,
                        CircularityLock circularityLock, @MaybeNull ClassLoader classLoader,
                        @MaybeNull JavaModule javaModule) {
                    return cls == null ? typePool.describe(str).resolve() : TypeDescription.ForLoadedType.of(cls);
                }
            },
            POOL_ONLY(0 == true ? 1 : 0) { // from class:
                                           // net.bytebuddy.agent.builder.AgentBuilder.DescriptionStrategy.Default.2
                @Override // net.bytebuddy.agent.builder.AgentBuilder.DescriptionStrategy
                public TypeDescription apply(String str, @MaybeNull Class<?> cls, TypePool typePool,
                        CircularityLock circularityLock, @MaybeNull ClassLoader classLoader,
                        @MaybeNull JavaModule javaModule) {
                    return typePool.describe(str).resolve();
                }
            },
            POOL_FIRST(0 == true ? 1 : 0) { // from class:
                                            // net.bytebuddy.agent.builder.AgentBuilder.DescriptionStrategy.Default.3
                @Override // net.bytebuddy.agent.builder.AgentBuilder.DescriptionStrategy
                public TypeDescription apply(String str, @MaybeNull Class<?> cls, TypePool typePool,
                        CircularityLock circularityLock, @MaybeNull ClassLoader classLoader,
                        @MaybeNull JavaModule javaModule) {
                    TypePool.Resolution resolutionDescribe = typePool.describe(str);
                    return (resolutionDescribe.isResolved() || cls == null) ? resolutionDescribe.resolve()
                            : TypeDescription.ForLoadedType.of(cls);
                }
            };

            private final boolean loadedFirst;

            @Override // net.bytebuddy.agent.builder.AgentBuilder.DescriptionStrategy
            public boolean isLoadedFirst() {
                return this.loadedFirst;
            }

            public DescriptionStrategy withSuperTypeLoading() {
                return new SuperTypeLoading(this);
            }

            Default(boolean z) {
                this.loadedFirst = z;
            }

            public DescriptionStrategy withSuperTypeLoading(ExecutorService executorService) {
                return new SuperTypeLoading.Asynchronous(this, executorService);
            }
        }

        /*
         * JADX INFO: compiled from:
         * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
         */
        @HashCodeAndEqualsPlugin.Enhance
        public static class SuperTypeLoading implements DescriptionStrategy {
            private final DescriptionStrategy delegate;

            /*
             * JADX INFO: compiled from:
             * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
             */
            @HashCodeAndEqualsPlugin.Enhance
            public static class Asynchronous implements DescriptionStrategy {
                private final DescriptionStrategy delegate;
                private final ExecutorService executorService;

                /*
                 * JADX INFO: compiled from:
                 * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
                 */
                @HashCodeAndEqualsPlugin.Enhance
                public static class ThreadSwitchingClassLoadingDelegate
                        implements TypeDescription.SuperTypeLoading.ClassLoadingDelegate {
                    private final ExecutorService executorService;

                    /*
                     * JADX INFO: compiled from:
                     * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
                     */
                    @HashCodeAndEqualsPlugin.Enhance
                    public static class NotifyingClassLoadingAction implements Callable<Class<?>> {
                        private final ClassLoader classLoader;
                        private final String name;
                        private final AtomicBoolean signal;

                        public NotifyingClassLoadingAction(String str, ClassLoader classLoader,
                                AtomicBoolean atomicBoolean) {
                            this.name = str;
                            this.classLoader = classLoader;
                            this.signal = atomicBoolean;
                        }

                        public boolean equals(@MaybeNull Object obj) {
                            if (this == obj) {
                                return true;
                            }
                            if (obj == null || getClass() != obj.getClass()) {
                                return false;
                            }
                            NotifyingClassLoadingAction notifyingClassLoadingAction = (NotifyingClassLoadingAction) obj;
                            return this.name.equals(notifyingClassLoadingAction.name)
                                    && this.classLoader.equals(notifyingClassLoadingAction.classLoader)
                                    && this.signal.equals(notifyingClassLoadingAction.signal);
                        }

                        public int hashCode() {
                            return this.signal.hashCode()
                                    + ((this.classLoader.hashCode() + bjs.e(this.name, getClass().hashCode() * 31, 31))
                                            * 31);
                        }

                        /* JADX WARN: Can't rename method to resolve collision */
                        @Override // java.util.concurrent.Callable
                        public Class<?> call() {
                            Class<?> cls;
                            synchronized (this.classLoader) {
                                try {
                                    try {
                                        cls = Class.forName(this.name, false, this.classLoader);
                                        this.signal.set(false);
                                        this.classLoader.notifyAll();
                                    } catch (Throwable th) {
                                        this.signal.set(false);
                                        this.classLoader.notifyAll();
                                        throw th;
                                    }
                                } catch (Throwable th2) {
                                    throw th2;
                                }
                            }
                            return cls;
                        }
                    }

                    /*
                     * JADX INFO: compiled from:
                     * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
                     */
                    @HashCodeAndEqualsPlugin.Enhance
                    public static class SimpleClassLoadingAction implements Callable<Class<?>> {

                        @MaybeNull
                        @HashCodeAndEqualsPlugin.ValueHandling(HashCodeAndEqualsPlugin.ValueHandling.Sort.REVERSE_NULLABILITY)
                        private final ClassLoader classLoader;
                        private final String name;

                        public SimpleClassLoadingAction(String str, @MaybeNull ClassLoader classLoader) {
                            this.name = str;
                            this.classLoader = classLoader;
                        }

                        /* JADX WARN: Found duplicated region for block: B:22:0x0032 A[RETURN] */
                        public boolean equals(@MaybeNull Object obj) {
                            if (this == obj) {
                                return true;
                            }
                            if (obj == null || getClass() != obj.getClass()) {
                                return false;
                            }
                            SimpleClassLoadingAction simpleClassLoadingAction = (SimpleClassLoadingAction) obj;
                            if (!this.name.equals(simpleClassLoadingAction.name)) {
                                return false;
                            }
                            ClassLoader classLoader = this.classLoader;
                            ClassLoader classLoader2 = simpleClassLoadingAction.classLoader;
                            if (classLoader2 != null) {
                                return classLoader != null && classLoader.equals(classLoader2);
                            }
                            if (classLoader != null) {
                                return false;
                            }
                        }

                        public int hashCode() {
                            int iE = bjs.e(this.name, getClass().hashCode() * 31, 31);
                            ClassLoader classLoader = this.classLoader;
                            return classLoader != null ? classLoader.hashCode() + iE : iE;
                        }

                        /* JADX WARN: Can't rename method to resolve collision */
                        @Override // java.util.concurrent.Callable
                        public Class<?> call() {
                            return Class.forName(this.name, false, this.classLoader);
                        }
                    }

                    public ThreadSwitchingClassLoadingDelegate(ExecutorService executorService) {
                        this.executorService = executorService;
                    }

                    public boolean equals(@MaybeNull Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        return obj != null && getClass() == obj.getClass() && this.executorService
                                .equals(((ThreadSwitchingClassLoadingDelegate) obj).executorService);
                    }

                    public int hashCode() {
                        return this.executorService.hashCode() + (getClass().hashCode() * 31);
                    }

                    @Override // net.bytebuddy.description.type.TypeDescription.SuperTypeLoading.ClassLoadingDelegate
                    public Class<?> load(String str, @MaybeNull ClassLoader classLoader) {
                        boolean z = classLoader != null && Thread.holdsLock(classLoader);
                        AtomicBoolean atomicBoolean = new AtomicBoolean(z);
                        Future futureSubmit = this.executorService
                                .submit(z ? new NotifyingClassLoadingAction(str, classLoader, atomicBoolean)
                                        : new SimpleClassLoadingAction(str, classLoader));
                        while (z) {
                            try {
                                if (!atomicBoolean.get()) {
                                    break;
                                }
                                classLoader.wait();
                            } catch (ExecutionException e) {
                                throw new IllegalStateException(concat("Could not load ", str, " asynchronously"),
                                        e.getCause());
                            } catch (Exception e2) {
                                throw new IllegalStateException(concat("Could not load ", str, " asynchronously"), e2);
                            }
                        }
                        return (Class) futureSubmit.get();
                    }
                }

                public Asynchronous(DescriptionStrategy descriptionStrategy, ExecutorService executorService) {
                    this.delegate = descriptionStrategy;
                    this.executorService = executorService;
                }

                @Override // net.bytebuddy.agent.builder.AgentBuilder.DescriptionStrategy
                public TypeDescription apply(String str, @MaybeNull Class<?> cls, TypePool typePool,
                        CircularityLock circularityLock, @MaybeNull ClassLoader classLoader,
                        @MaybeNull JavaModule javaModule) {
                    TypeDescription typeDescriptionApply = this.delegate.apply(str, cls, typePool, circularityLock,
                            classLoader, javaModule);
                    return typeDescriptionApply instanceof TypeDescription.ForLoadedType ? typeDescriptionApply
                            : new TypeDescription.SuperTypeLoading(typeDescriptionApply, classLoader,
                                    new ThreadSwitchingClassLoadingDelegate(this.executorService));
                }

                public boolean equals(@MaybeNull Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (obj == null || getClass() != obj.getClass()) {
                        return false;
                    }
                    Asynchronous asynchronous = (Asynchronous) obj;
                    return this.delegate.equals(asynchronous.delegate)
                            && this.executorService.equals(asynchronous.executorService);
                }

                public int hashCode() {
                    return this.executorService.hashCode()
                            + ((this.delegate.hashCode() + (getClass().hashCode() * 31)) * 31);
                }

                @Override // net.bytebuddy.agent.builder.AgentBuilder.DescriptionStrategy
                public boolean isLoadedFirst() {
                    return this.delegate.isLoadedFirst();
                }
            }

            /*
             * JADX INFO: compiled from:
             * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
             */
            @HashCodeAndEqualsPlugin.Enhance
            public static class UnlockingClassLoadingDelegate
                    implements TypeDescription.SuperTypeLoading.ClassLoadingDelegate {
                private final CircularityLock circularityLock;

                public UnlockingClassLoadingDelegate(CircularityLock circularityLock) {
                    this.circularityLock = circularityLock;
                }

                public boolean equals(@MaybeNull Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    return obj != null && getClass() == obj.getClass()
                            && this.circularityLock.equals(((UnlockingClassLoadingDelegate) obj).circularityLock);
                }

                public int hashCode() {
                    return this.circularityLock.hashCode() + (getClass().hashCode() * 31);
                }

                @Override // net.bytebuddy.description.type.TypeDescription.SuperTypeLoading.ClassLoadingDelegate
                public Class<?> load(String str, @MaybeNull ClassLoader classLoader) {
                    this.circularityLock.release();
                    try {
                        return Class.forName(str, false, classLoader);
                    } finally {
                        this.circularityLock.acquire();
                    }
                }
            }

            public SuperTypeLoading(DescriptionStrategy descriptionStrategy) {
                this.delegate = descriptionStrategy;
            }

            @Override // net.bytebuddy.agent.builder.AgentBuilder.DescriptionStrategy
            public TypeDescription apply(String str, @MaybeNull Class<?> cls, TypePool typePool,
                    CircularityLock circularityLock, @MaybeNull ClassLoader classLoader,
                    @MaybeNull JavaModule javaModule) {
                TypeDescription typeDescriptionApply = this.delegate.apply(str, cls, typePool, circularityLock,
                        classLoader, javaModule);
                return typeDescriptionApply instanceof TypeDescription.ForLoadedType ? typeDescriptionApply
                        : new TypeDescription.SuperTypeLoading(typeDescriptionApply, classLoader,
                                new UnlockingClassLoadingDelegate(circularityLock));
            }

            public boolean equals(@MaybeNull Object obj) {
                if (this == obj) {
                    return true;
                }
                return obj != null && getClass() == obj.getClass()
                        && this.delegate.equals(((SuperTypeLoading) obj).delegate);
            }

            public int hashCode() {
                return this.delegate.hashCode() + (getClass().hashCode() * 31);
            }

            @Override // net.bytebuddy.agent.builder.AgentBuilder.DescriptionStrategy
            public boolean isLoadedFirst() {
                return this.delegate.isLoadedFirst();
            }
        }

        TypeDescription apply(String str, @MaybeNull Class<?> cls, TypePool typePool, CircularityLock circularityLock,
                @MaybeNull ClassLoader classLoader, @MaybeNull JavaModule javaModule);

        boolean isLoadedFirst();
    }

    /*
     * JADX INFO: compiled from:
     * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
     */
    public interface FallbackStrategy {

        /*
         * JADX INFO: compiled from:
         * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
         */
        @HashCodeAndEqualsPlugin.Enhance
        public static class ByThrowableType implements FallbackStrategy {
            private final Set<? extends Class<? extends Throwable>> types;

            @SafeVarargs
            @SafeVarargsPlugin.Enhance
            public ByThrowableType(Class<? extends Throwable>... clsArr) {
                this(new HashSet(Arrays.asList(clsArr)));
            }

            public static FallbackStrategy ofOptionalTypes() {
                return new ByThrowableType((Class<? extends Throwable>[]) new Class[] { LinkageError.class,
                        TypeNotPresentException.class });
            }

            public boolean equals(@MaybeNull Object obj) {
                if (this == obj) {
                    return true;
                }
                return obj != null && getClass() == obj.getClass() && this.types.equals(((ByThrowableType) obj).types);
            }

            public int hashCode() {
                return this.types.hashCode() + (getClass().hashCode() * 31);
            }

            @Override // net.bytebuddy.agent.builder.AgentBuilder.FallbackStrategy
            public boolean isFallback(Class<?> cls, Throwable th) {
                Iterator<? extends Class<? extends Throwable>> it = this.types.iterator();
                while (it.hasNext()) {
                    if (it.next().isInstance(th)) {
                        return true;
                    }
                }
                return false;
            }

            public ByThrowableType(Set<? extends Class<? extends Throwable>> set) {
                this.types = set;
            }
        }

        /*
         * JADX INFO: compiled from:
         * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
         */
        public enum Simple implements FallbackStrategy {
            ENABLED(true),
            DISABLED(false);

            private final boolean enabled;

            Simple(boolean z) {
                this.enabled = z;
            }

            @Override // net.bytebuddy.agent.builder.AgentBuilder.FallbackStrategy
            public boolean isFallback(Class<?> cls, Throwable th) {
                return this.enabled;
            }
        }

        boolean isFallback(Class<?> cls, Throwable th);
    }

    /*
     * JADX INFO: compiled from:
     * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
     */
    public interface Identified {

        /*
         * JADX INFO: compiled from:
         * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
         */
        public interface Extendable extends AgentBuilder, Identified {
            AgentBuilder asTerminalTransformation();
        }

        /*
         * JADX INFO: compiled from:
         * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
         */
        public interface Narrowable extends Matchable<Narrowable>, Identified {
        }

        Extendable transform(Transformer transformer);
    }

    /*
     * JADX INFO: compiled from:
     * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
     */
    public interface Ignored extends Matchable<Ignored>, AgentBuilder {
    }

    /*
     * JADX INFO: compiled from:
     * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
     */
    public interface InitializationStrategy {

        /*
         * JADX INFO: compiled from:
         * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
         */
        public interface Dispatcher {
            DynamicType.Builder<?> apply(DynamicType.Builder<?> builder);

            void register(DynamicType dynamicType, @MaybeNull ClassLoader classLoader,
                    @MaybeNull ProtectionDomain protectionDomain, InjectionStrategy injectionStrategy);
        }

        /*
         * JADX INFO: compiled from:
         * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
         */
        public enum Minimal implements InitializationStrategy, Dispatcher {
            INSTANCE;

            @Override // net.bytebuddy.agent.builder.AgentBuilder.InitializationStrategy.Dispatcher
            public DynamicType.Builder<?> apply(DynamicType.Builder<?> builder) {
                return builder;
            }

            @Override // net.bytebuddy.agent.builder.AgentBuilder.InitializationStrategy
            public Dispatcher dispatcher() {
                return this;
            }

            @Override // net.bytebuddy.agent.builder.AgentBuilder.InitializationStrategy.Dispatcher
            public void register(DynamicType dynamicType, @MaybeNull ClassLoader classLoader,
                    @MaybeNull ProtectionDomain protectionDomain, InjectionStrategy injectionStrategy) {
                Set<TypeDescription> auxiliaryTypeDescriptions = dynamicType.getAuxiliaryTypeDescriptions();
                Set<? extends TypeDescription> linkedHashSet = new LinkedHashSet<>(auxiliaryTypeDescriptions);
                for (TypeDescription typeDescription : auxiliaryTypeDescriptions) {
                    if (!typeDescription.getDeclaredAnnotations()
                            .isAnnotationPresent(AuxiliaryType.SignatureRelevant.class)) {
                        linkedHashSet.remove(typeDescription);
                    }
                }
                if (linkedHashSet.isEmpty()) {
                    return;
                }
                ClassInjector classInjectorResolve = injectionStrategy.resolve(classLoader, protectionDomain);
                Map<TypeDescription, LoadedTypeInitializer> loadedTypeInitializers = dynamicType
                        .getLoadedTypeInitializers();
                for (Map.Entry<TypeDescription, Class<?>> entry : classInjectorResolve
                        .inject(linkedHashSet, dynamicType).entrySet()) {
                    loadedTypeInitializers.get(entry.getKey()).onLoad(entry.getValue());
                }
            }
        }

        /*
         * JADX INFO: compiled from:
         * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
         */
        public enum NoOp implements InitializationStrategy, Dispatcher {
            INSTANCE;

            @Override // net.bytebuddy.agent.builder.AgentBuilder.InitializationStrategy.Dispatcher
            public DynamicType.Builder<?> apply(DynamicType.Builder<?> builder) {
                return builder;
            }

            @Override // net.bytebuddy.agent.builder.AgentBuilder.InitializationStrategy
            public Dispatcher dispatcher() {
                return this;
            }

            @Override // net.bytebuddy.agent.builder.AgentBuilder.InitializationStrategy.Dispatcher
            public void register(DynamicType dynamicType, @MaybeNull ClassLoader classLoader,
                    @MaybeNull ProtectionDomain protectionDomain, InjectionStrategy injectionStrategy) {
            }
        }

        /*
         * JADX INFO: compiled from:
         * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
         */
        @HashCodeAndEqualsPlugin.Enhance
        public static abstract class SelfInjection implements InitializationStrategy {
            protected final NexusAccessor nexusAccessor;

            /*
             * JADX INFO: compiled from:
             * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
             */
            @HashCodeAndEqualsPlugin.Enhance
            public static abstract class Dispatcher implements Dispatcher {
                protected final int identification;
                protected final NexusAccessor nexusAccessor;

                /*
                 * JADX INFO: compiled from:
                 * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
                 */
                @HashCodeAndEqualsPlugin.Enhance
                public static class InjectingInitializer implements LoadedTypeInitializer {
                    private final Set<TypeDescription> auxiliaryTypes;
                    private final ClassFileLocator classFileLocator;
                    private final ClassInjector classInjector;
                    private final TypeDescription instrumentedType;
                    private final Map<TypeDescription, LoadedTypeInitializer> loadedTypeInitializers;

                    public InjectingInitializer(TypeDescription typeDescription, Set<TypeDescription> set,
                            ClassFileLocator classFileLocator, Map<TypeDescription, LoadedTypeInitializer> map,
                            ClassInjector classInjector) {
                        this.instrumentedType = typeDescription;
                        this.auxiliaryTypes = set;
                        this.classFileLocator = classFileLocator;
                        this.loadedTypeInitializers = map;
                        this.classInjector = classInjector;
                    }

                    public boolean equals(@MaybeNull Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        if (obj == null || getClass() != obj.getClass()) {
                            return false;
                        }
                        InjectingInitializer injectingInitializer = (InjectingInitializer) obj;
                        return this.instrumentedType.equals(injectingInitializer.instrumentedType)
                                && this.auxiliaryTypes.equals(injectingInitializer.auxiliaryTypes)
                                && this.classFileLocator.equals(injectingInitializer.classFileLocator)
                                && this.loadedTypeInitializers.equals(injectingInitializer.loadedTypeInitializers)
                                && this.classInjector.equals(injectingInitializer.classInjector);
                    }

                    public int hashCode() {
                        return this.classInjector.hashCode() + yg.c(this.loadedTypeInitializers,
                                (this.classFileLocator.hashCode() + ((this.auxiliaryTypes.hashCode()
                                        + dkz.f(this.instrumentedType, getClass().hashCode() * 31, 31)) * 31)) * 31,
                                31);
                    }

                    @Override // net.bytebuddy.implementation.LoadedTypeInitializer
                    public boolean isAlive() {
                        return true;
                    }

                    @Override // net.bytebuddy.implementation.LoadedTypeInitializer
                    public void onLoad(Class<?> cls) {
                        for (Map.Entry<TypeDescription, Class<?>> entry : this.classInjector
                                .inject(this.auxiliaryTypes, this.classFileLocator).entrySet()) {
                            this.loadedTypeInitializers.get(entry.getKey()).onLoad(entry.getValue());
                        }
                        this.loadedTypeInitializers.get(this.instrumentedType).onLoad(cls);
                    }
                }

                public Dispatcher(NexusAccessor nexusAccessor, int i) {
                    this.nexusAccessor = nexusAccessor;
                    this.identification = i;
                }

                @Override // net.bytebuddy.agent.builder.AgentBuilder.InitializationStrategy.Dispatcher
                public DynamicType.Builder<?> apply(DynamicType.Builder<?> builder) {
                    return builder.initializer(new NexusAccessor.InitializationAppender(this.identification));
                }

                public boolean equals(@MaybeNull Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (obj == null || getClass() != obj.getClass()) {
                        return false;
                    }
                    Dispatcher dispatcher = (Dispatcher) obj;
                    return this.identification == dispatcher.identification
                            && this.nexusAccessor.equals(dispatcher.nexusAccessor);
                }

                public int hashCode() {
                    return ((this.nexusAccessor.hashCode() + (getClass().hashCode() * 31)) * 31) + this.identification;
                }
            }

            /*
             * JADX INFO: compiled from:
             * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
             */
            public static class Eager extends SelfInjection {

                /*
                 * JADX INFO: compiled from:
                 * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
                 */
                public static class Dispatcher extends Dispatcher {
                    public Dispatcher(NexusAccessor nexusAccessor, int i) {
                        super(nexusAccessor, i);
                    }

                    @Override // net.bytebuddy.agent.builder.AgentBuilder.InitializationStrategy.Dispatcher
                    public void register(DynamicType dynamicType, @MaybeNull ClassLoader classLoader,
                            @MaybeNull ProtectionDomain protectionDomain, InjectionStrategy injectionStrategy) {
                        Set<TypeDescription> auxiliaryTypeDescriptions = dynamicType.getAuxiliaryTypeDescriptions();
                        Map<TypeDescription, LoadedTypeInitializer> loadedTypeInitializers = dynamicType
                                .getLoadedTypeInitializers();
                        if (!auxiliaryTypeDescriptions.isEmpty()) {
                            for (Map.Entry<TypeDescription, Class<?>> entry : injectionStrategy
                                    .resolve(classLoader, protectionDomain)
                                    .inject(auxiliaryTypeDescriptions, dynamicType).entrySet()) {
                                loadedTypeInitializers.get(entry.getKey()).onLoad(entry.getValue());
                            }
                        }
                        this.nexusAccessor.register(dynamicType.getTypeDescription().getName(), classLoader,
                                this.identification, loadedTypeInitializers.get(dynamicType.getTypeDescription()));
                    }
                }

                public Eager() {
                    this(new NexusAccessor());
                }

                @Override // net.bytebuddy.agent.builder.AgentBuilder.InitializationStrategy.SelfInjection
                public Dispatcher dispatcher(int i) {
                    return new Dispatcher(this.nexusAccessor, i);
                }

                public Eager(NexusAccessor nexusAccessor) {
                    super(nexusAccessor);
                }
            }

            /*
             * JADX INFO: compiled from:
             * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
             */
            public static class Lazy extends SelfInjection {

                /*
                 * JADX INFO: compiled from:
                 * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
                 */
                public static class Dispatcher extends Dispatcher {
                    public Dispatcher(NexusAccessor nexusAccessor, int i) {
                        super(nexusAccessor, i);
                    }

                    @Override // net.bytebuddy.agent.builder.AgentBuilder.InitializationStrategy.Dispatcher
                    public void register(DynamicType dynamicType, @MaybeNull ClassLoader classLoader,
                            @MaybeNull ProtectionDomain protectionDomain, InjectionStrategy injectionStrategy) {
                        DynamicType dynamicType2;
                        LoadedTypeInitializer injectingInitializer;
                        Set<TypeDescription> auxiliaryTypeDescriptions = dynamicType.getAuxiliaryTypeDescriptions();
                        if (auxiliaryTypeDescriptions.isEmpty()) {
                            injectingInitializer = dynamicType.getLoadedTypeInitializers()
                                    .get(dynamicType.getTypeDescription());
                            dynamicType2 = dynamicType;
                        } else {
                            dynamicType2 = dynamicType;
                            injectingInitializer = new Dispatcher.InjectingInitializer(dynamicType.getTypeDescription(),
                                    auxiliaryTypeDescriptions, dynamicType2, dynamicType.getLoadedTypeInitializers(),
                                    injectionStrategy.resolve(classLoader, protectionDomain));
                        }
                        this.nexusAccessor.register(dynamicType2.getTypeDescription().getName(), classLoader,
                                this.identification, injectingInitializer);
                    }
                }

                public Lazy() {
                    this(new NexusAccessor());
                }

                @Override // net.bytebuddy.agent.builder.AgentBuilder.InitializationStrategy.SelfInjection
                public Dispatcher dispatcher(int i) {
                    return new Dispatcher(this.nexusAccessor, i);
                }

                public Lazy(NexusAccessor nexusAccessor) {
                    super(nexusAccessor);
                }
            }

            /*
             * JADX INFO: compiled from:
             * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
             */
            public static class Split extends SelfInjection {

                /*
                 * JADX INFO: compiled from:
                 * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
                 */
                public static class Dispatcher extends Dispatcher {
                    public Dispatcher(NexusAccessor nexusAccessor, int i) {
                        super(nexusAccessor, i);
                    }

                    @Override // net.bytebuddy.agent.builder.AgentBuilder.InitializationStrategy.Dispatcher
                    public void register(DynamicType dynamicType, @MaybeNull ClassLoader classLoader,
                            @MaybeNull ProtectionDomain protectionDomain, InjectionStrategy injectionStrategy) {
                        DynamicType dynamicType2;
                        LoadedTypeInitializer injectingInitializer;
                        Set<TypeDescription> auxiliaryTypeDescriptions = dynamicType.getAuxiliaryTypeDescriptions();
                        if (auxiliaryTypeDescriptions.isEmpty()) {
                            dynamicType2 = dynamicType;
                            injectingInitializer = dynamicType2.getLoadedTypeInitializers()
                                    .get(dynamicType2.getTypeDescription());
                        } else {
                            TypeDescription typeDescription = dynamicType.getTypeDescription();
                            ClassInjector classInjectorResolve = injectionStrategy.resolve(classLoader,
                                    protectionDomain);
                            LinkedHashSet linkedHashSet = new LinkedHashSet(auxiliaryTypeDescriptions);
                            LinkedHashSet linkedHashSet2 = new LinkedHashSet(auxiliaryTypeDescriptions);
                            for (TypeDescription typeDescription2 : auxiliaryTypeDescriptions) {
                                (typeDescription2.getDeclaredAnnotations().isAnnotationPresent(
                                        AuxiliaryType.SignatureRelevant.class) ? linkedHashSet2 : linkedHashSet)
                                        .remove(typeDescription2);
                            }
                            Map<TypeDescription, LoadedTypeInitializer> loadedTypeInitializers = dynamicType
                                    .getLoadedTypeInitializers();
                            if (!linkedHashSet.isEmpty()) {
                                for (Map.Entry<TypeDescription, Class<?>> entry : classInjectorResolve
                                        .inject(linkedHashSet, dynamicType).entrySet()) {
                                    loadedTypeInitializers.get(entry.getKey()).onLoad(entry.getValue());
                                }
                            }
                            HashMap map = new HashMap(loadedTypeInitializers);
                            loadedTypeInitializers.keySet().removeAll(linkedHashSet);
                            if (map.size() > 1) {
                                dynamicType2 = dynamicType;
                                injectingInitializer = new Dispatcher.InjectingInitializer(typeDescription,
                                        linkedHashSet2, dynamicType2, map, classInjectorResolve);
                            } else {
                                dynamicType2 = dynamicType;
                                injectingInitializer = (LoadedTypeInitializer) map.get(typeDescription);
                            }
                        }
                        this.nexusAccessor.register(dynamicType2.getTypeDescription().getName(), classLoader,
                                this.identification, injectingInitializer);
                    }
                }

                public Split() {
                    this(new NexusAccessor());
                }

                @Override // net.bytebuddy.agent.builder.AgentBuilder.InitializationStrategy.SelfInjection
                public Dispatcher dispatcher(int i) {
                    return new Dispatcher(this.nexusAccessor, i);
                }

                public Split(NexusAccessor nexusAccessor) {
                    super(nexusAccessor);
                }
            }

            public SelfInjection(NexusAccessor nexusAccessor) {
                this.nexusAccessor = nexusAccessor;
            }

            @Override // net.bytebuddy.agent.builder.AgentBuilder.InitializationStrategy
            public Dispatcher dispatcher() {
                return dispatcher(new Random().nextInt());
            }

            public abstract Dispatcher dispatcher(int i);

            public boolean equals(@MaybeNull Object obj) {
                if (this == obj) {
                    return true;
                }
                return obj != null && getClass() == obj.getClass()
                        && this.nexusAccessor.equals(((SelfInjection) obj).nexusAccessor);
            }

            public int hashCode() {
                return this.nexusAccessor.hashCode() + (getClass().hashCode() * 31);
            }
        }

        Dispatcher dispatcher();
    }

    /*
     * JADX INFO: compiled from:
     * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
     */
    public interface InjectionStrategy {

        /*
         * JADX INFO: compiled from:
         * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
         */
        public enum Disabled implements InjectionStrategy {
            INSTANCE;

            @Override // net.bytebuddy.agent.builder.AgentBuilder.InjectionStrategy
            public ClassInjector resolve(@MaybeNull ClassLoader classLoader,
                    @MaybeNull ProtectionDomain protectionDomain) {
                throw new IllegalStateException("Class injection is disabled");
            }
        }

        /*
         * JADX INFO: compiled from:
         * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
         */
        @HashCodeAndEqualsPlugin.Enhance
        public static class UsingInstrumentation implements InjectionStrategy {
            private final File folder;
            private final Instrumentation instrumentation;

            public UsingInstrumentation(Instrumentation instrumentation, File file) {
                this.instrumentation = instrumentation;
                this.folder = file;
            }

            public boolean equals(@MaybeNull Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || getClass() != obj.getClass()) {
                    return false;
                }
                UsingInstrumentation usingInstrumentation = (UsingInstrumentation) obj;
                return this.instrumentation.equals(usingInstrumentation.instrumentation)
                        && this.folder.equals(usingInstrumentation.folder);
            }

            public int hashCode() {
                return this.folder.hashCode() + ((this.instrumentation.hashCode() + (getClass().hashCode() * 31)) * 31);
            }

            @Override // net.bytebuddy.agent.builder.AgentBuilder.InjectionStrategy
            public ClassInjector resolve(@MaybeNull ClassLoader classLoader,
                    @MaybeNull ProtectionDomain protectionDomain) {
                return classLoader == null
                        ? ClassInjector.UsingInstrumentation.of(this.folder,
                                ClassInjector.UsingInstrumentation.Target.BOOTSTRAP, this.instrumentation)
                        : UsingReflection.INSTANCE.resolve(classLoader, protectionDomain);
            }
        }

        /*
         * JADX INFO: compiled from:
         * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
         */
        public enum UsingJna implements InjectionStrategy {
            INSTANCE;

            @Override // net.bytebuddy.agent.builder.AgentBuilder.InjectionStrategy
            public ClassInjector resolve(@MaybeNull ClassLoader classLoader,
                    @MaybeNull ProtectionDomain protectionDomain) {
                if (ClassInjector.UsingJna.isAvailable()) {
                    return new ClassInjector.UsingJna(classLoader, protectionDomain);
                }
                throw new IllegalStateException("JNA-based injection is not available on the current VM");
            }
        }

        /*
         * JADX INFO: compiled from:
         * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
         */
        public enum UsingReflection implements InjectionStrategy {
            INSTANCE;

            @Override // net.bytebuddy.agent.builder.AgentBuilder.InjectionStrategy
            public ClassInjector resolve(@MaybeNull ClassLoader classLoader,
                    @MaybeNull ProtectionDomain protectionDomain) {
                if (classLoader == null) {
                    throw new IllegalStateException(
                            "Cannot inject auxiliary class into bootstrap loader using reflection");
                }
                if (ClassInjector.UsingReflection.isAvailable()) {
                    return new ClassInjector.UsingReflection(classLoader, protectionDomain);
                }
                throw new IllegalStateException("Reflection-based injection is not available on the current VM");
            }
        }

        /*
         * JADX INFO: compiled from:
         * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
         */
        public enum UsingUnsafe implements InjectionStrategy {
            INSTANCE;

            /*
             * JADX INFO: compiled from:
             * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
             */
            @HashCodeAndEqualsPlugin.Enhance
            public static class OfFactory implements InjectionStrategy {
                private final ClassInjector.UsingUnsafe.Factory factory;

                public OfFactory(ClassInjector.UsingUnsafe.Factory factory) {
                    this.factory = factory;
                }

                public boolean equals(@MaybeNull Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    return obj != null && getClass() == obj.getClass()
                            && this.factory.equals(((OfFactory) obj).factory);
                }

                public int hashCode() {
                    return this.factory.hashCode() + (getClass().hashCode() * 31);
                }

                @Override // net.bytebuddy.agent.builder.AgentBuilder.InjectionStrategy
                public ClassInjector resolve(@MaybeNull ClassLoader classLoader,
                        @MaybeNull ProtectionDomain protectionDomain) {
                    return this.factory.make(classLoader, protectionDomain);
                }
            }

            @Override // net.bytebuddy.agent.builder.AgentBuilder.InjectionStrategy
            public ClassInjector resolve(@MaybeNull ClassLoader classLoader,
                    @MaybeNull ProtectionDomain protectionDomain) {
                if (ClassInjector.UsingUnsafe.isAvailable()) {
                    return new ClassInjector.UsingUnsafe(classLoader, protectionDomain);
                }
                throw new IllegalStateException("Unsafe-based injection is not available on the current VM");
            }
        }

        ClassInjector resolve(@MaybeNull ClassLoader classLoader, @MaybeNull ProtectionDomain protectionDomain);
    }

    /*
     * JADX INFO: compiled from:
     * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
     */
    public interface InstallationListener {

        @AlwaysNull
        public static final Throwable SUPPRESS_ERROR = null;

        /*
         * JADX INFO: compiled from:
         * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
         */
        public static abstract class Adapter implements InstallationListener {
            @Override // net.bytebuddy.agent.builder.AgentBuilder.InstallationListener
            public void onAfterWarmUp(Map<Class<?>, byte[]> map,
                    ResettableClassFileTransformer resettableClassFileTransformer, boolean z) {
            }

            @Override // net.bytebuddy.agent.builder.AgentBuilder.InstallationListener
            public void onBeforeInstall(Instrumentation instrumentation,
                    ResettableClassFileTransformer resettableClassFileTransformer) {
            }

            @Override // net.bytebuddy.agent.builder.AgentBuilder.InstallationListener
            public void onBeforeWarmUp(Set<Class<?>> set,
                    ResettableClassFileTransformer resettableClassFileTransformer) {
            }

            @Override // net.bytebuddy.agent.builder.AgentBuilder.InstallationListener
            public Throwable onError(Instrumentation instrumentation,
                    ResettableClassFileTransformer resettableClassFileTransformer, Throwable th) {
                return th;
            }

            @Override // net.bytebuddy.agent.builder.AgentBuilder.InstallationListener
            public void onInstall(Instrumentation instrumentation,
                    ResettableClassFileTransformer resettableClassFileTransformer) {
            }

            @Override // net.bytebuddy.agent.builder.AgentBuilder.InstallationListener
            public void onReset(Instrumentation instrumentation,
                    ResettableClassFileTransformer resettableClassFileTransformer) {
            }

            @Override // net.bytebuddy.agent.builder.AgentBuilder.InstallationListener
            public void onWarmUpError(Class<?> cls, ResettableClassFileTransformer resettableClassFileTransformer,
                    Throwable th) {
            }
        }

        /*
         * JADX INFO: compiled from:
         * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
         */
        @HashCodeAndEqualsPlugin.Enhance
        public static class Compound implements InstallationListener {
            private final List<InstallationListener> installationListeners;

            public Compound(InstallationListener... installationListenerArr) {
                this((List<? extends InstallationListener>) Arrays.asList(installationListenerArr));
            }

            public boolean equals(@MaybeNull Object obj) {
                if (this == obj) {
                    return true;
                }
                return obj != null && getClass() == obj.getClass()
                        && this.installationListeners.equals(((Compound) obj).installationListeners);
            }

            public int hashCode() {
                return this.installationListeners.hashCode() + (getClass().hashCode() * 31);
            }

            @Override // net.bytebuddy.agent.builder.AgentBuilder.InstallationListener
            public void onAfterWarmUp(Map<Class<?>, byte[]> map,
                    ResettableClassFileTransformer resettableClassFileTransformer, boolean z) {
                Iterator<InstallationListener> it = this.installationListeners.iterator();
                while (it.hasNext()) {
                    it.next().onAfterWarmUp(map, resettableClassFileTransformer, z);
                }
            }

            @Override // net.bytebuddy.agent.builder.AgentBuilder.InstallationListener
            public void onBeforeInstall(Instrumentation instrumentation,
                    ResettableClassFileTransformer resettableClassFileTransformer) {
                Iterator<InstallationListener> it = this.installationListeners.iterator();
                while (it.hasNext()) {
                    it.next().onBeforeInstall(instrumentation, resettableClassFileTransformer);
                }
            }

            @Override // net.bytebuddy.agent.builder.AgentBuilder.InstallationListener
            public void onBeforeWarmUp(Set<Class<?>> set,
                    ResettableClassFileTransformer resettableClassFileTransformer) {
                Iterator<InstallationListener> it = this.installationListeners.iterator();
                while (it.hasNext()) {
                    it.next().onBeforeWarmUp(set, resettableClassFileTransformer);
                }
            }

            @Override // net.bytebuddy.agent.builder.AgentBuilder.InstallationListener
            @MaybeNull
            public Throwable onError(Instrumentation instrumentation,
                    ResettableClassFileTransformer resettableClassFileTransformer, Throwable th) {
                for (InstallationListener installationListener : this.installationListeners) {
                    Throwable th2 = InstallationListener.SUPPRESS_ERROR;
                    if (th == th2) {
                        return th2;
                    }
                    th = installationListener.onError(instrumentation, resettableClassFileTransformer, th);
                }
                return th;
            }

            @Override // net.bytebuddy.agent.builder.AgentBuilder.InstallationListener
            public void onInstall(Instrumentation instrumentation,
                    ResettableClassFileTransformer resettableClassFileTransformer) {
                Iterator<InstallationListener> it = this.installationListeners.iterator();
                while (it.hasNext()) {
                    it.next().onInstall(instrumentation, resettableClassFileTransformer);
                }
            }

            @Override // net.bytebuddy.agent.builder.AgentBuilder.InstallationListener
            public void onReset(Instrumentation instrumentation,
                    ResettableClassFileTransformer resettableClassFileTransformer) {
                Iterator<InstallationListener> it = this.installationListeners.iterator();
                while (it.hasNext()) {
                    it.next().onReset(instrumentation, resettableClassFileTransformer);
                }
            }

            @Override // net.bytebuddy.agent.builder.AgentBuilder.InstallationListener
            public void onWarmUpError(Class<?> cls, ResettableClassFileTransformer resettableClassFileTransformer,
                    Throwable th) {
                Iterator<InstallationListener> it = this.installationListeners.iterator();
                while (it.hasNext()) {
                    it.next().onWarmUpError(cls, resettableClassFileTransformer, th);
                }
            }

            public Compound(List<? extends InstallationListener> list) {
                this.installationListeners = new ArrayList();
                for (InstallationListener installationListener : list) {
                    if (installationListener instanceof Compound) {
                        this.installationListeners.addAll(((Compound) installationListener).installationListeners);
                    } else if (!(installationListener instanceof NoOp)) {
                        this.installationListeners.add(installationListener);
                    }
                }
            }
        }

        /*
         * JADX INFO: compiled from:
         * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
         */
        public enum ErrorSuppressing implements InstallationListener {
            INSTANCE;

            @Override // net.bytebuddy.agent.builder.AgentBuilder.InstallationListener
            public void onAfterWarmUp(Map<Class<?>, byte[]> map,
                    ResettableClassFileTransformer resettableClassFileTransformer, boolean z) {
            }

            @Override // net.bytebuddy.agent.builder.AgentBuilder.InstallationListener
            public void onBeforeInstall(Instrumentation instrumentation,
                    ResettableClassFileTransformer resettableClassFileTransformer) {
            }

            @Override // net.bytebuddy.agent.builder.AgentBuilder.InstallationListener
            public void onBeforeWarmUp(Set<Class<?>> set,
                    ResettableClassFileTransformer resettableClassFileTransformer) {
            }

            @Override // net.bytebuddy.agent.builder.AgentBuilder.InstallationListener
            @MaybeNull
            public Throwable onError(Instrumentation instrumentation,
                    ResettableClassFileTransformer resettableClassFileTransformer, Throwable th) {
                return InstallationListener.SUPPRESS_ERROR;
            }

            @Override // net.bytebuddy.agent.builder.AgentBuilder.InstallationListener
            public void onInstall(Instrumentation instrumentation,
                    ResettableClassFileTransformer resettableClassFileTransformer) {
            }

            @Override // net.bytebuddy.agent.builder.AgentBuilder.InstallationListener
            public void onReset(Instrumentation instrumentation,
                    ResettableClassFileTransformer resettableClassFileTransformer) {
            }

            @Override // net.bytebuddy.agent.builder.AgentBuilder.InstallationListener
            public void onWarmUpError(Class<?> cls, ResettableClassFileTransformer resettableClassFileTransformer,
                    Throwable th) {
            }
        }

        /*
         * JADX INFO: compiled from:
         * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
         */
        public enum NoOp implements InstallationListener {
            INSTANCE;

            @Override // net.bytebuddy.agent.builder.AgentBuilder.InstallationListener
            public void onAfterWarmUp(Map<Class<?>, byte[]> map,
                    ResettableClassFileTransformer resettableClassFileTransformer, boolean z) {
            }

            @Override // net.bytebuddy.agent.builder.AgentBuilder.InstallationListener
            public void onBeforeInstall(Instrumentation instrumentation,
                    ResettableClassFileTransformer resettableClassFileTransformer) {
            }

            @Override // net.bytebuddy.agent.builder.AgentBuilder.InstallationListener
            public void onBeforeWarmUp(Set<Class<?>> set,
                    ResettableClassFileTransformer resettableClassFileTransformer) {
            }

            @Override // net.bytebuddy.agent.builder.AgentBuilder.InstallationListener
            public Throwable onError(Instrumentation instrumentation,
                    ResettableClassFileTransformer resettableClassFileTransformer, Throwable th) {
                return th;
            }

            @Override // net.bytebuddy.agent.builder.AgentBuilder.InstallationListener
            public void onInstall(Instrumentation instrumentation,
                    ResettableClassFileTransformer resettableClassFileTransformer) {
            }

            @Override // net.bytebuddy.agent.builder.AgentBuilder.InstallationListener
            public void onReset(Instrumentation instrumentation,
                    ResettableClassFileTransformer resettableClassFileTransformer) {
            }

            @Override // net.bytebuddy.agent.builder.AgentBuilder.InstallationListener
            public void onWarmUpError(Class<?> cls, ResettableClassFileTransformer resettableClassFileTransformer,
                    Throwable th) {
            }
        }

        /*
         * JADX INFO: compiled from:
         * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
         */
        @HashCodeAndEqualsPlugin.Enhance
        public static class StreamWriting implements InstallationListener {
            protected static final String PREFIX = "[Byte Buddy]";
            private final PrintStream printStream;

            public StreamWriting(PrintStream printStream) {
                this.printStream = printStream;
            }

            public static InstallationListener toSystemError() {
                return new StreamWriting(System.err);
            }

            public static InstallationListener toSystemOut() {
                return new StreamWriting(System.out);
            }

            public boolean equals(@MaybeNull Object obj) {
                if (this == obj) {
                    return true;
                }
                return obj != null && getClass() == obj.getClass()
                        && this.printStream.equals(((StreamWriting) obj).printStream);
            }

            public int hashCode() {
                return this.printStream.hashCode() + (getClass().hashCode() * 31);
            }

            @Override // net.bytebuddy.agent.builder.AgentBuilder.InstallationListener
            public void onAfterWarmUp(Map<Class<?>, byte[]> map,
                    ResettableClassFileTransformer resettableClassFileTransformer, boolean z) {
                this.printStream.printf("[Byte Buddy] AFTER_WARMUP %s %s on %s%n",
                        z ? "transformed" : "not transformed", resettableClassFileTransformer, map.keySet());
            }

            @Override // net.bytebuddy.agent.builder.AgentBuilder.InstallationListener
            public void onBeforeInstall(Instrumentation instrumentation,
                    ResettableClassFileTransformer resettableClassFileTransformer) {
                this.printStream.printf("[Byte Buddy] BEFORE_INSTALL %s on %s%n", resettableClassFileTransformer,
                        instrumentation);
            }

            @Override // net.bytebuddy.agent.builder.AgentBuilder.InstallationListener
            public void onBeforeWarmUp(Set<Class<?>> set,
                    ResettableClassFileTransformer resettableClassFileTransformer) {
                this.printStream.printf("[Byte Buddy] BEFORE_WARMUP %s on %s%n", resettableClassFileTransformer, set);
            }

            @Override // net.bytebuddy.agent.builder.AgentBuilder.InstallationListener
            public Throwable onError(Instrumentation instrumentation,
                    ResettableClassFileTransformer resettableClassFileTransformer, Throwable th) {
                synchronized (this.printStream) {
                    this.printStream.printf("[Byte Buddy] ERROR %s on %s%n", resettableClassFileTransformer,
                            instrumentation);
                    th.printStackTrace(this.printStream);
                }
                return th;
            }

            @Override // net.bytebuddy.agent.builder.AgentBuilder.InstallationListener
            public void onInstall(Instrumentation instrumentation,
                    ResettableClassFileTransformer resettableClassFileTransformer) {
                this.printStream.printf("[Byte Buddy] INSTALL %s on %s%n", resettableClassFileTransformer,
                        instrumentation);
            }

            @Override // net.bytebuddy.agent.builder.AgentBuilder.InstallationListener
            public void onReset(Instrumentation instrumentation,
                    ResettableClassFileTransformer resettableClassFileTransformer) {
                this.printStream.printf("[Byte Buddy] RESET %s on %s%n", resettableClassFileTransformer,
                        instrumentation);
            }

            @Override // net.bytebuddy.agent.builder.AgentBuilder.InstallationListener
            public void onWarmUpError(Class<?> cls, ResettableClassFileTransformer resettableClassFileTransformer,
                    Throwable th) {
                synchronized (this.printStream) {
                    this.printStream.printf("[Byte Buddy] ERROR_WARMUP %s on %s%n", resettableClassFileTransformer,
                            cls);
                    th.printStackTrace(this.printStream);
                }
            }
        }

        void onAfterWarmUp(Map<Class<?>, byte[]> map, ResettableClassFileTransformer resettableClassFileTransformer,
                boolean z);

        void onBeforeInstall(Instrumentation instrumentation,
                ResettableClassFileTransformer resettableClassFileTransformer);

        void onBeforeWarmUp(Set<Class<?>> set, ResettableClassFileTransformer resettableClassFileTransformer);

        @MaybeNull
        Throwable onError(Instrumentation instrumentation,
                ResettableClassFileTransformer resettableClassFileTransformer, Throwable th);

        void onInstall(Instrumentation instrumentation, ResettableClassFileTransformer resettableClassFileTransformer);

        void onReset(Instrumentation instrumentation, ResettableClassFileTransformer resettableClassFileTransformer);

        void onWarmUpError(Class<?> cls, ResettableClassFileTransformer resettableClassFileTransformer, Throwable th);
    }

    /*
     * JADX INFO: compiled from:
     * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
     */
    public enum LambdaInstrumentationStrategy {
        ENABLED { // from class:
                  // net.bytebuddy.agent.builder.AgentBuilder.LambdaInstrumentationStrategy.1
            @Override // net.bytebuddy.agent.builder.AgentBuilder.LambdaInstrumentationStrategy
            public void apply(ByteBuddy byteBuddy, Instrumentation instrumentation,
                    ClassFileTransformer classFileTransformer) {
                if (LambdaFactory.register(classFileTransformer, new LambdaInstanceFactory(byteBuddy))) {
                    try {
                        Class<?> cls = Class.forName("java.lang.invoke.LambdaMetafactory");
                        byteBuddy.with(Implementation.Context.Disabled.Factory.INSTANCE).redefine(cls)
                                .method(ElementMatchers.isPublic().and(ElementMatchers.named("metafactory")))
                                .intercept(new Implementation.Simple(LambdaMetafactoryFactory.REGULAR))
                                .method(ElementMatchers.isPublic().and(ElementMatchers.named("altMetafactory")))
                                .intercept(new Implementation.Simple(LambdaMetafactoryFactory.ALTERNATIVE)).make()
                                .load(cls.getClassLoader(), ClassReloadingStrategy.of(instrumentation));
                    } catch (ClassNotFoundException unused) {
                    }
                }
            }

            @Override // net.bytebuddy.agent.builder.AgentBuilder.LambdaInstrumentationStrategy
            public boolean isInstrumented(@MaybeNull Class<?> cls) {
                return true;
            }
        },
        DISABLED { // from class:
                   // net.bytebuddy.agent.builder.AgentBuilder.LambdaInstrumentationStrategy.2
            @Override // net.bytebuddy.agent.builder.AgentBuilder.LambdaInstrumentationStrategy
            public void apply(ByteBuddy byteBuddy, Instrumentation instrumentation,
                    ClassFileTransformer classFileTransformer) {
            }

            @Override // net.bytebuddy.agent.builder.AgentBuilder.LambdaInstrumentationStrategy
            public boolean isInstrumented(@MaybeNull Class<?> cls) {
                return cls == null || !cls.getName().contains("/");
            }
        };

        /*
         * JADX INFO: compiled from:
         * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
         */
        @HashCodeAndEqualsPlugin.Enhance
        public static class LambdaInstanceFactory {
            private static final String FIELD_PREFIX = "arg$";
            private static final String LAMBDA_FACTORY = "get$Lambda";
            private static final AtomicInteger LAMBDA_NAME_COUNTER = new AtomicInteger();
            private static final String LAMBDA_TYPE_INFIX = "$$Lambda$ByteBuddy$";

            @AlwaysNull
            private static final Class<?> NOT_PREVIOUSLY_DEFINED = null;
            private final ByteBuddy byteBuddy;

            /*
             * JADX INFO: compiled from:
             * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
             */
            @HashCodeAndEqualsPlugin.Enhance
            public static class BridgeMethodImplementation implements Implementation {
                private final JavaConstant.MethodType lambdaMethod;
                private final String lambdaMethodName;

                /*
                 * JADX INFO: compiled from:
                 * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
                 */
                @HashCodeAndEqualsPlugin.Enhance
                public static class Appender implements ByteCodeAppender {
                    private final Implementation.SpecialMethodInvocation bridgeTargetInvocation;

                    public Appender(Implementation.SpecialMethodInvocation specialMethodInvocation) {
                        this.bridgeTargetInvocation = specialMethodInvocation;
                    }

                    @Override // net.bytebuddy.implementation.bytecode.ByteCodeAppender
                    public ByteCodeAppender.Size apply(MethodVisitor methodVisitor, Implementation.Context context,
                            MethodDescription methodDescription) {
                        StackManipulation stackManipulationPrependThisReference = MethodVariableAccess
                                .allArgumentsOf(methodDescription)
                                .asBridgeOf(this.bridgeTargetInvocation.getMethodDescription()).prependThisReference();
                        Implementation.SpecialMethodInvocation specialMethodInvocation = this.bridgeTargetInvocation;
                        return new ByteCodeAppender.Compound(new ByteCodeAppender.Simple(
                                stackManipulationPrependThisReference, specialMethodInvocation,
                                specialMethodInvocation.getMethodDescription().getReturnType().asErasure()
                                        .isAssignableTo(methodDescription.getReturnType().asErasure())
                                                ? StackManipulation.Trivial.INSTANCE
                                                : TypeCasting.to(methodDescription.getReturnType()),
                                MethodReturn.of(methodDescription.getReturnType())))
                                .apply(methodVisitor, context, methodDescription);
                    }

                    public boolean equals(@MaybeNull Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        return obj != null && getClass() == obj.getClass()
                                && this.bridgeTargetInvocation.equals(((Appender) obj).bridgeTargetInvocation);
                    }

                    public int hashCode() {
                        return this.bridgeTargetInvocation.hashCode() + (getClass().hashCode() * 31);
                    }
                }

                public BridgeMethodImplementation(String str, JavaConstant.MethodType methodType) {
                    this.lambdaMethodName = str;
                    this.lambdaMethod = methodType;
                }

                @Override // net.bytebuddy.implementation.Implementation
                public ByteCodeAppender appender(Implementation.Target target) {
                    return new Appender(target.invokeSuper(new MethodDescription.SignatureToken(this.lambdaMethodName,
                            this.lambdaMethod.getReturnType(), this.lambdaMethod.getParameterTypes())));
                }

                public boolean equals(@MaybeNull Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (obj == null || getClass() != obj.getClass()) {
                        return false;
                    }
                    BridgeMethodImplementation bridgeMethodImplementation = (BridgeMethodImplementation) obj;
                    return this.lambdaMethodName.equals(bridgeMethodImplementation.lambdaMethodName)
                            && this.lambdaMethod.equals(bridgeMethodImplementation.lambdaMethod);
                }

                public int hashCode() {
                    return this.lambdaMethod.hashCode() + bjs.e(this.lambdaMethodName, getClass().hashCode() * 31, 31);
                }

                @Override // net.bytebuddy.dynamic.scaffold.InstrumentedType.Prepareable
                public InstrumentedType prepare(InstrumentedType instrumentedType) {
                    return instrumentedType;
                }
            }

            /*
             * JADX INFO: compiled from:
             * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
             */
            public enum ConstructorImplementation implements Implementation {
                INSTANCE;

                private final transient MethodDescription.InDefinedShape objectConstructor = (MethodDescription.InDefinedShape) TypeDescription.ForLoadedType
                        .of(Object.class).getDeclaredMethods().filter(ElementMatchers.isConstructor()).getOnly();

                /*
                 * JADX INFO: compiled from:
                 * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
                 */
                @HashCodeAndEqualsPlugin.Enhance
                public static class Appender implements ByteCodeAppender {
                    private final List<FieldDescription.InDefinedShape> declaredFields;

                    public Appender(List<FieldDescription.InDefinedShape> list) {
                        this.declaredFields = list;
                    }

                    @Override // net.bytebuddy.implementation.bytecode.ByteCodeAppender
                    public ByteCodeAppender.Size apply(MethodVisitor methodVisitor, Implementation.Context context,
                            MethodDescription methodDescription) {
                        ArrayList arrayList = new ArrayList(this.declaredFields.size() * 3);
                        Iterator<?> it = methodDescription.getParameters().iterator();
                        while (it.hasNext()) {
                            ParameterDescription parameterDescription = (ParameterDescription) it.next();
                            arrayList.add(MethodVariableAccess.loadThis());
                            arrayList.add(MethodVariableAccess.load(parameterDescription));
                            arrayList.add(FieldAccess.forField(this.declaredFields.get(parameterDescription.getIndex()))
                                    .write());
                        }
                        return new ByteCodeAppender.Size(
                                new StackManipulation.Compound(MethodVariableAccess.loadThis(),
                                        MethodInvocation.invoke(ConstructorImplementation.INSTANCE.objectConstructor),
                                        new StackManipulation.Compound(arrayList), MethodReturn.VOID)
                                        .apply(methodVisitor, context).getMaximalSize(),
                                methodDescription.getStackSize());
                    }

                    public boolean equals(@MaybeNull Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        return obj != null && getClass() == obj.getClass()
                                && this.declaredFields.equals(((Appender) obj).declaredFields);
                    }

                    public int hashCode() {
                        return this.declaredFields.hashCode() + (getClass().hashCode() * 31);
                    }
                }

                ConstructorImplementation() {
                }

                @Override // net.bytebuddy.implementation.Implementation
                public ByteCodeAppender appender(Implementation.Target target) {
                    return new Appender(target.getInstrumentedType().getDeclaredFields());
                }

                @Override // net.bytebuddy.dynamic.scaffold.InstrumentedType.Prepareable
                public InstrumentedType prepare(InstrumentedType instrumentedType) {
                    return instrumentedType;
                }
            }

            /*
             * JADX INFO: compiled from:
             * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
             */
            public enum FactoryImplementation implements Implementation {
                INSTANCE;

                /*
                 * JADX INFO: compiled from:
                 * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
                 */
                @HashCodeAndEqualsPlugin.Enhance
                public static class Appender implements ByteCodeAppender {
                    private final TypeDescription instrumentedType;

                    public Appender(TypeDescription typeDescription) {
                        this.instrumentedType = typeDescription;
                    }

                    @Override // net.bytebuddy.implementation.bytecode.ByteCodeAppender
                    public ByteCodeAppender.Size apply(MethodVisitor methodVisitor, Implementation.Context context,
                            MethodDescription methodDescription) {
                        return new ByteCodeAppender.Size(new StackManipulation.Compound(
                                TypeCreation.of(this.instrumentedType), Duplication.SINGLE,
                                MethodVariableAccess.allArgumentsOf(methodDescription),
                                MethodInvocation.invoke((MethodDescription.InDefinedShape) this.instrumentedType
                                        .getDeclaredMethods().filter(ElementMatchers.isConstructor()).getOnly()),
                                MethodReturn.REFERENCE).apply(methodVisitor, context).getMaximalSize(),
                                methodDescription.getStackSize());
                    }

                    public boolean equals(@MaybeNull Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        return obj != null && getClass() == obj.getClass()
                                && this.instrumentedType.equals(((Appender) obj).instrumentedType);
                    }

                    public int hashCode() {
                        return this.instrumentedType.hashCode() + (getClass().hashCode() * 31);
                    }
                }

                @Override // net.bytebuddy.implementation.Implementation
                public ByteCodeAppender appender(Implementation.Target target) {
                    return new Appender(target.getInstrumentedType());
                }

                @Override // net.bytebuddy.dynamic.scaffold.InstrumentedType.Prepareable
                public InstrumentedType prepare(InstrumentedType instrumentedType) {
                    return instrumentedType;
                }
            }

            /*
             * JADX INFO: compiled from:
             * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
             */
            @HashCodeAndEqualsPlugin.Enhance
            public static class LambdaMethodImplementation implements Implementation {
                private final JavaConstant.MethodType specializedLambdaMethod;
                private final JavaConstant.MethodHandle targetMethod;
                private final TypeDescription targetType;

                /*
                 * JADX INFO: compiled from:
                 * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
                 */
                @HashCodeAndEqualsPlugin.Enhance
                public static class Appender implements ByteCodeAppender {
                    private static final Dispatcher LOOKUP_DATA_DISPATCHER = dispatcher();
                    private final List<FieldDescription.InDefinedShape> declaredFields;
                    private final Dispatcher dispatcher;
                    private final JavaConstant.MethodType specializedLambdaMethod;
                    private final MethodDescription targetMethod;

                    /*
                     * JADX INFO: compiled from:
                     * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
                     */
                    public interface Dispatcher {

                        /*
                         * JADX INFO: compiled from:
                         * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
                         */
                        public enum UsingDirectInvocation implements Dispatcher {
                            INSTANCE;

                            @Override // net.bytebuddy.agent.builder.AgentBuilder.LambdaInstrumentationStrategy.LambdaInstanceFactory.LambdaMethodImplementation.Appender.Dispatcher
                            public StackManipulation initialize() {
                                return StackManipulation.Trivial.INSTANCE;
                            }

                            @Override // net.bytebuddy.agent.builder.AgentBuilder.LambdaInstrumentationStrategy.LambdaInstanceFactory.LambdaMethodImplementation.Appender.Dispatcher
                            public StackManipulation invoke(MethodDescription methodDescription) {
                                return MethodInvocation.invoke(methodDescription);
                            }
                        }

                        /*
                         * JADX INFO: compiled from:
                         * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
                         */
                        @HashCodeAndEqualsPlugin.Enhance
                        public static class UsingMethodHandle extends StackManipulation.AbstractBase
                                implements Dispatcher {
                            private final MethodDescription.InDefinedShape invokeExact;

                            public UsingMethodHandle(MethodDescription.InDefinedShape inDefinedShape) {
                                this.invokeExact = inDefinedShape;
                            }

                            @Override // net.bytebuddy.implementation.bytecode.StackManipulation
                            public StackManipulation.Size apply(MethodVisitor methodVisitor,
                                    Implementation.Context context) {
                                methodVisitor.visitLdcInsn(new ConstantDynamic(JavaConstant.Dynamic.DEFAULT_NAME,
                                        "Ljava/lang/invoke/MethodHandle;",
                                        new Handle(6, "java/lang/invoke/MethodHandles", "classData",
                                                "(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;",
                                                false),
                                        new Object[0]));
                                return new StackManipulation.Size(1, 1);
                            }

                            public boolean equals(@MaybeNull Object obj) {
                                if (this == obj) {
                                    return true;
                                }
                                return obj != null && getClass() == obj.getClass()
                                        && this.invokeExact.equals(((UsingMethodHandle) obj).invokeExact);
                            }

                            public int hashCode() {
                                return this.invokeExact.hashCode() + (getClass().hashCode() * 31);
                            }

                            @Override // net.bytebuddy.agent.builder.AgentBuilder.LambdaInstrumentationStrategy.LambdaInstanceFactory.LambdaMethodImplementation.Appender.Dispatcher
                            public StackManipulation initialize() {
                                return this;
                            }

                            @Override // net.bytebuddy.agent.builder.AgentBuilder.LambdaInstrumentationStrategy.LambdaInstanceFactory.LambdaMethodImplementation.Appender.Dispatcher
                            public StackManipulation invoke(MethodDescription methodDescription) {
                                return MethodInvocation.invoke(this.invokeExact);
                            }
                        }

                        StackManipulation initialize();

                        StackManipulation invoke(MethodDescription methodDescription);
                    }

                    public Appender(MethodDescription methodDescription, JavaConstant.MethodType methodType,
                            List<FieldDescription.InDefinedShape> list, Dispatcher dispatcher) {
                        this.targetMethod = methodDescription;
                        this.specializedLambdaMethod = methodType;
                        this.declaredFields = list;
                        this.dispatcher = dispatcher;
                    }

                    private static Dispatcher dispatcher() {
                        try {
                            Class<?> cls = Class.forName("java.lang.invoke.MethodHandles$Lookup", false, null);
                            cls.getMethod("classData", cls, String.class, Class.class);
                            return new Dispatcher.UsingMethodHandle(new MethodDescription.ForLoadedMethod(
                                    Class.forName("java.lang.invoke.MethodHandle", false, null).getMethod("invokeExact",
                                            Object[].class)));
                        } catch (Exception unused) {
                            return Dispatcher.UsingDirectInvocation.INSTANCE;
                        }
                    }

                    public static ByteCodeAppender of(MethodDescription methodDescription,
                            JavaConstant.MethodType methodType, List<FieldDescription.InDefinedShape> list,
                            JavaConstant.MethodHandle.HandleType handleType, TypeDescription typeDescription) {
                        return new Appender(methodDescription, methodType, list,
                                (handleType == JavaConstant.MethodHandle.HandleType.INVOKE_SPECIAL || !methodDescription
                                        .getDeclaringType().asErasure().isVisibleTo(typeDescription))
                                                ? LOOKUP_DATA_DISPATCHER
                                                : Dispatcher.UsingDirectInvocation.INSTANCE);
                    }

                    @Override // net.bytebuddy.implementation.bytecode.ByteCodeAppender
                    public ByteCodeAppender.Size apply(MethodVisitor methodVisitor, Implementation.Context context,
                            MethodDescription methodDescription) {
                        ArrayList arrayList = new ArrayList((this.declaredFields.size() * 2) + 1);
                        for (FieldDescription.InDefinedShape inDefinedShape : this.declaredFields) {
                            arrayList.add(MethodVariableAccess.loadThis());
                            arrayList.add(FieldAccess.forField(inDefinedShape).read());
                        }
                        ArrayList arrayList2 = new ArrayList(methodDescription.getParameters().size() * 2);
                        Iterator<?> it = methodDescription.getParameters().iterator();
                        while (it.hasNext()) {
                            ParameterDescription parameterDescription = (ParameterDescription) it.next();
                            arrayList2.add(MethodVariableAccess.load(parameterDescription));
                            arrayList2.add(Assigner.DEFAULT.assign(parameterDescription.getType(),
                                    this.specializedLambdaMethod.getParameterTypes()
                                            .get(parameterDescription.getIndex()).asGenericType(),
                                    Assigner.Typing.DYNAMIC));
                        }
                        return new ByteCodeAppender.Size(
                                new StackManipulation.Compound(
                                        this.targetMethod.isConstructor()
                                                ? new StackManipulation.Compound(
                                                        TypeCreation
                                                                .of(this.targetMethod.getDeclaringType().asErasure()),
                                                        Duplication.SINGLE)
                                                : StackManipulation.Trivial.INSTANCE,
                                        this.dispatcher.initialize(), new StackManipulation.Compound(arrayList),
                                        new StackManipulation.Compound(arrayList2),
                                        this.dispatcher.invoke(this.targetMethod),
                                        Assigner.DEFAULT.assign(
                                                this.targetMethod.isConstructor()
                                                        ? this.targetMethod.getDeclaringType().asGenericType()
                                                        : this.targetMethod.getReturnType(),
                                                this.specializedLambdaMethod.getReturnType().asGenericType(),
                                                Assigner.Typing.DYNAMIC),
                                        MethodReturn.of(this.specializedLambdaMethod.getReturnType()))
                                        .apply(methodVisitor, context).getMaximalSize(),
                                methodDescription.getStackSize());
                    }

                    public boolean equals(@MaybeNull Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        if (obj == null || getClass() != obj.getClass()) {
                            return false;
                        }
                        Appender appender = (Appender) obj;
                        return this.targetMethod.equals(appender.targetMethod)
                                && this.specializedLambdaMethod.equals(appender.specializedLambdaMethod)
                                && this.declaredFields.equals(appender.declaredFields)
                                && this.dispatcher.equals(appender.dispatcher);
                    }

                    public int hashCode() {
                        return this.dispatcher.hashCode()
                                + bjs.g(this.declaredFields, (this.specializedLambdaMethod.hashCode()
                                        + dkz.c(this.targetMethod, getClass().hashCode() * 31, 31)) * 31, 31);
                    }
                }

                public LambdaMethodImplementation(TypeDescription typeDescription,
                        JavaConstant.MethodHandle methodHandle, JavaConstant.MethodType methodType) {
                    this.targetType = typeDescription;
                    this.targetMethod = methodHandle;
                    this.specializedLambdaMethod = methodType;
                }

                @Override // net.bytebuddy.implementation.Implementation
                public ByteCodeAppender appender(Implementation.Target target) {
                    return Appender.of(
                            (MethodDescription) this.targetMethod.getOwnerType().getDeclaredMethods()
                                    .filter(ElementMatchers.hasMethodName(this.targetMethod.getName())
                                            .and(ElementMatchers.returns(this.targetMethod.getReturnType()))
                                            .and(ElementMatchers.takesArguments(this.targetMethod.getParameterTypes())))
                                    .getOnly(),
                            this.specializedLambdaMethod, target.getInstrumentedType().getDeclaredFields(),
                            this.targetMethod.getHandleType(), this.targetType);
                }

                public boolean equals(@MaybeNull Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (obj == null || getClass() != obj.getClass()) {
                        return false;
                    }
                    LambdaMethodImplementation lambdaMethodImplementation = (LambdaMethodImplementation) obj;
                    return this.targetType.equals(lambdaMethodImplementation.targetType)
                            && this.targetMethod.equals(lambdaMethodImplementation.targetMethod)
                            && this.specializedLambdaMethod.equals(lambdaMethodImplementation.specializedLambdaMethod);
                }

                public int hashCode() {
                    return this.specializedLambdaMethod.hashCode()
                            + ((this.targetMethod.hashCode() + dkz.f(this.targetType, getClass().hashCode() * 31, 31))
                                    * 31);
                }

                @Override // net.bytebuddy.dynamic.scaffold.InstrumentedType.Prepareable
                public InstrumentedType prepare(InstrumentedType instrumentedType) {
                    return instrumentedType;
                }
            }

            /*
             * JADX INFO: compiled from:
             * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
             */
            @HashCodeAndEqualsPlugin.Enhance
            public static class SerializationImplementation implements Implementation {
                private final JavaConstant.MethodType lambdaMethod;
                private final String lambdaMethodName;
                private final TypeDescription lambdaType;
                private final JavaConstant.MethodType specializedMethod;
                private final JavaConstant.MethodHandle targetMethod;
                private final TypeDescription targetType;

                public SerializationImplementation(TypeDescription typeDescription, TypeDescription typeDescription2,
                        String str, JavaConstant.MethodType methodType, JavaConstant.MethodHandle methodHandle,
                        JavaConstant.MethodType methodType2) {
                    this.targetType = typeDescription;
                    this.lambdaType = typeDescription2;
                    this.lambdaMethodName = str;
                    this.lambdaMethod = methodType;
                    this.targetMethod = methodHandle;
                    this.specializedMethod = methodType2;
                }

                @Override // net.bytebuddy.implementation.Implementation
                public ByteCodeAppender appender(Implementation.Target target) {
                    try {
                        TypeDescription typeDescriptionOf = TypeDescription.ForLoadedType
                                .of(Class.forName("java.lang.invoke.SerializedLambda"));
                        ArrayList arrayList = new ArrayList(target.getInstrumentedType().getDeclaredFields().size());
                        for (FieldDescription.InDefinedShape inDefinedShape : target.getInstrumentedType()
                                .getDeclaredFields()) {
                            arrayList.add(new StackManipulation.Compound(MethodVariableAccess.loadThis(),
                                    FieldAccess.forField(inDefinedShape).read(),
                                    Assigner.DEFAULT.assign(inDefinedShape.getType(),
                                            TypeDescription.Generic.OfNonGenericType.ForLoadedType.of(Object.class),
                                            Assigner.Typing.STATIC)));
                        }
                        return new ByteCodeAppender.Simple(new StackManipulation.Compound(
                                TypeCreation.of(typeDescriptionOf), Duplication.SINGLE,
                                ClassConstant.of(this.targetType), new TextConstant(this.lambdaType.getInternalName()),
                                new TextConstant(this.lambdaMethodName),
                                new TextConstant(this.lambdaMethod.getDescriptor()),
                                IntegerConstant.forValue(this.targetMethod.getHandleType().getIdentifier()),
                                new TextConstant(this.targetMethod.getOwnerType().getInternalName()),
                                new TextConstant(this.targetMethod.getName()),
                                new TextConstant(this.targetMethod.getDescriptor()),
                                new TextConstant(this.specializedMethod.getDescriptor()),
                                ArrayFactory
                                        .forType(
                                                TypeDescription.Generic.OfNonGenericType.ForLoadedType.of(Object.class))
                                        .withValues(arrayList),
                                MethodInvocation.invoke((MethodDescription.InDefinedShape) typeDescriptionOf
                                        .getDeclaredMethods().filter(ElementMatchers.isConstructor()).getOnly()),
                                MethodReturn.REFERENCE));
                    } catch (ClassNotFoundException e) {
                        throw new IllegalStateException("Cannot find class for lambda serialization", e);
                    }
                }

                public boolean equals(@MaybeNull Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (obj == null || getClass() != obj.getClass()) {
                        return false;
                    }
                    SerializationImplementation serializationImplementation = (SerializationImplementation) obj;
                    return this.lambdaMethodName.equals(serializationImplementation.lambdaMethodName)
                            && this.targetType.equals(serializationImplementation.targetType)
                            && this.lambdaType.equals(serializationImplementation.lambdaType)
                            && this.lambdaMethod.equals(serializationImplementation.lambdaMethod)
                            && this.targetMethod.equals(serializationImplementation.targetMethod)
                            && this.specializedMethod.equals(serializationImplementation.specializedMethod);
                }

                public int hashCode() {
                    return this.specializedMethod.hashCode()
                            + ((this.targetMethod.hashCode()
                                    + ((this.lambdaMethod.hashCode() + bjs.e(this.lambdaMethodName,
                                            dkz.f(this.lambdaType,
                                                    dkz.f(this.targetType, getClass().hashCode() * 31, 31), 31),
                                            31)) * 31))
                                    * 31);
                }

                @Override // net.bytebuddy.dynamic.scaffold.InstrumentedType.Prepareable
                public InstrumentedType prepare(InstrumentedType instrumentedType) {
                    return instrumentedType;
                }
            }

            public LambdaInstanceFactory(ByteBuddy byteBuddy) {
                this.byteBuddy = byteBuddy;
            }

            public boolean equals(@MaybeNull Object obj) {
                if (this == obj) {
                    return true;
                }
                return obj != null && getClass() == obj.getClass()
                        && this.byteBuddy.equals(((LambdaInstanceFactory) obj).byteBuddy);
            }

            public int hashCode() {
                return this.byteBuddy.hashCode() + (getClass().hashCode() * 31);
            }

            public byte[] make(Object obj, String str, Object obj2, Object obj3, Object obj4, Object obj5, boolean z,
                    List<Class<?>> list, List<?> list2, Collection<? extends ClassFileTransformer> collection) {
                String str2;
                byte[] bArr;
                JavaConstant.MethodType methodTypeOfLoaded = JavaConstant.MethodType.ofLoaded(obj2);
                JavaConstant.MethodType methodTypeOfLoaded2 = JavaConstant.MethodType.ofLoaded(obj3);
                JavaConstant.MethodHandle methodHandleOfLoaded = JavaConstant.MethodHandle.ofLoaded(obj4, obj);
                JavaConstant.MethodType methodTypeOfLoaded3 = JavaConstant.MethodType.ofLoaded(obj5);
                Class<?> clsLookupType = JavaConstant.MethodHandle.lookupType(obj);
                String str3 = clsLookupType.getName() + LAMBDA_TYPE_INFIX + LAMBDA_NAME_COUNTER.incrementAndGet();
                DynamicType.Builder<?> builderSubclass = this.byteBuddy.subclass(methodTypeOfLoaded.getReturnType(),
                        ConstructorStrategy.Default.NO_CONSTRUCTORS);
                Visibility visibility = Visibility.PUBLIC;
                DynamicType.Builder builderIntercept = builderSubclass.modifiers(TypeManifestation.FINAL, visibility)
                        .implement((List<? extends java.lang.reflect.Type>) list).name(str3)
                        .defineConstructor(visibility)
                        .withParameters((Collection<? extends TypeDefinition>) methodTypeOfLoaded.getParameterTypes())
                        .intercept(ConstructorImplementation.INSTANCE)
                        .method(ElementMatchers.named(str)
                                .and(ElementMatchers.takesArguments(methodTypeOfLoaded2.getParameterTypes()))
                                .and(ElementMatchers.returns(methodTypeOfLoaded2.getReturnType())))
                        .intercept(new LambdaMethodImplementation(TypeDescription.ForLoadedType.of(clsLookupType),
                                methodHandleOfLoaded, methodTypeOfLoaded3));
                int i = 0;
                for (TypeDescription typeDescription : methodTypeOfLoaded.getParameterTypes()) {
                    StringBuilder sb = new StringBuilder(FIELD_PREFIX);
                    i++;
                    sb.append(i);
                    builderIntercept = builderIntercept.defineField(sb.toString(), typeDescription, Visibility.PRIVATE,
                            FieldManifestation.FINAL);
                }
                if (!methodTypeOfLoaded.getParameterTypes().isEmpty()) {
                    builderIntercept = builderIntercept
                            .defineMethod(LAMBDA_FACTORY, methodTypeOfLoaded.getReturnType(), Visibility.PRIVATE,
                                    Ownership.STATIC)
                            .withParameters(
                                    (Collection<? extends TypeDefinition>) methodTypeOfLoaded.getParameterTypes())
                            .intercept(FactoryImplementation.INSTANCE);
                }
                if (z) {
                    if (!list.contains(Serializable.class)) {
                        builderIntercept = builderIntercept.implement(Serializable.class);
                    }
                    str2 = str;
                    builderIntercept = builderIntercept.defineMethod("writeReplace", Object.class, Visibility.PRIVATE)
                            .intercept(new SerializationImplementation(TypeDescription.ForLoadedType.of(clsLookupType),
                                    methodTypeOfLoaded.getReturnType(), str, methodTypeOfLoaded2, methodHandleOfLoaded,
                                    JavaConstant.MethodType.ofLoaded(obj5)));
                } else {
                    str2 = str;
                    if (methodTypeOfLoaded.getReturnType().isAssignableTo(Serializable.class)) {
                        Visibility visibility2 = Visibility.PRIVATE;
                        java.lang.reflect.Type type = Void.TYPE;
                        builderIntercept = builderIntercept.defineMethod("readObject", type, visibility2)
                                .withParameters(ObjectInputStream.class).throwing(NotSerializableException.class)
                                .intercept(ExceptionMethod.throwing(
                                        (Class<? extends Throwable>) NotSerializableException.class,
                                        "Non-serializable lambda"))
                                .defineMethod("writeObject", type, visibility2).withParameters(ObjectOutputStream.class)
                                .throwing(NotSerializableException.class)
                                .intercept(ExceptionMethod.throwing(
                                        (Class<? extends Throwable>) NotSerializableException.class,
                                        "Non-serializable lambda"));
                    }
                }
                Iterator<?> it = list2.iterator();
                while (it.hasNext()) {
                    JavaConstant.MethodType methodTypeOfLoaded4 = JavaConstant.MethodType.ofLoaded(it.next());
                    builderIntercept = builderIntercept
                            .defineMethod(str2, methodTypeOfLoaded4.getReturnType(), MethodManifestation.BRIDGE,
                                    Visibility.PUBLIC)
                            .withParameters(
                                    (Collection<? extends TypeDefinition>) methodTypeOfLoaded4.getParameterTypes())
                            .intercept(new BridgeMethodImplementation(str2, methodTypeOfLoaded2));
                }
                byte[] bytes = builderIntercept.make().getBytes();
                Iterator<? extends ClassFileTransformer> it2 = collection.iterator();
                while (it2.hasNext()) {
                    try {
                        byte[] bArr2 = bytes;
                        try {
                            bytes = it2.next().transform(clsLookupType.getClassLoader(),
                                    str3.replace(TypePool.Default.LazyTypeDescription.GenericTypeToken.INNER_CLASS_PATH,
                                            '/'),
                                    NOT_PREVIOUSLY_DEFINED, clsLookupType.getProtectionDomain(), bArr2);
                            bArr = bArr2;
                        } catch (Throwable unused) {
                            bArr = bArr2;
                        }
                    } catch (Throwable unused2) {
                        bArr = bytes;
                    }
                    if (bytes == null) {
                        bytes = bArr;
                    }
                }
                return bytes;
            }
        }

        /*
         * JADX WARN: Enum visitor error
         * jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'REGULAR'
         * uses external variables
         * at
         * jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.
         * java:451)
         * at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByRegister(EnumVisitor.
         * java:395)
         * at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(
         * EnumVisitor.java:324)
         * at
         * jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java
         * :262)
         * at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:151)
         * at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
         */
        /*
         * JADX WARN: Failed to restore enum class, 'enum' modifier and super class
         * removed
         */
        /*
         * JADX INFO: compiled from:
         * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
         */
        public static abstract class LambdaMetafactoryFactory implements ByteCodeAppender {
            private static final /* synthetic */ LambdaMetafactoryFactory[] $VALUES;
            public static final LambdaMetafactoryFactory ALTERNATIVE;
            private static final Loader LOADER;
            public static final LambdaMetafactoryFactory REGULAR;
            private final int localVariableLength;
            private final int stackSize;

            /*
             * JADX INFO: compiled from:
             * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
             */
            public interface Loader {

                /*
                 * JADX INFO: compiled from:
                 * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
                 */
                public enum Unavailable implements Loader {
                    INSTANCE;

                    @Override // net.bytebuddy.agent.builder.AgentBuilder.LambdaInstrumentationStrategy.LambdaMetafactoryFactory.Loader
                    public void apply(MethodVisitor methodVisitor) {
                        throw new IllegalStateException(
                                "No lambda expression loading strategy available on current VM");
                    }

                    @Override // net.bytebuddy.agent.builder.AgentBuilder.LambdaInstrumentationStrategy.LambdaMetafactoryFactory.Loader
                    public int getLocalVariableLength() {
                        throw new IllegalStateException(
                                "No lambda expression loading strategy available on current VM");
                    }

                    @Override // net.bytebuddy.agent.builder.AgentBuilder.LambdaInstrumentationStrategy.LambdaMetafactoryFactory.Loader
                    public int getStackSize() {
                        throw new IllegalStateException(
                                "No lambda expression loading strategy available on current VM");
                    }
                }

                /*
                 * JADX INFO: compiled from:
                 * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
                 */
                public enum UsingMethodHandleLookup implements Loader {
                    INSTANCE;

                    @Override // net.bytebuddy.agent.builder.AgentBuilder.LambdaInstrumentationStrategy.LambdaMetafactoryFactory.Loader
                    public void apply(MethodVisitor methodVisitor) {
                        methodVisitor.visitVarInsn(25, 0);
                        methodVisitor.visitVarInsn(25, 4);
                        methodVisitor.visitMethodInsn(182, "java/lang/invoke/MethodHandles$Lookup", "revealDirect",
                                "(Ljava/lang/invoke/MethodHandle;)Ljava/lang/invoke/MethodHandleInfo;", false);
                        methodVisitor.visitVarInsn(58, 10);
                        methodVisitor.visitVarInsn(25, 10);
                        methodVisitor.visitMethodInsn(185, "java/lang/invoke/MethodHandleInfo", "getModifiers", "()I",
                                true);
                        methodVisitor.visitMethodInsn(184, "java/lang/reflect/Modifier", "isProtected", "(I)Z", false);
                        Label label = new Label();
                        methodVisitor.visitJumpInsn(153, label);
                        methodVisitor.visitVarInsn(25, 0);
                        methodVisitor.visitMethodInsn(182, "java/lang/invoke/MethodHandles$Lookup", "lookupClass",
                                "()Ljava/lang/Class;", false);
                        methodVisitor.visitVarInsn(25, 10);
                        methodVisitor.visitMethodInsn(185, "java/lang/invoke/MethodHandleInfo", "getDeclaringClass",
                                "()Ljava/lang/Class;", true);
                        methodVisitor.visitMethodInsn(184, "sun/invoke/util/VerifyAccess", "isSamePackage",
                                "(Ljava/lang/Class;Ljava/lang/Class;)Z", false);
                        Label label2 = new Label();
                        methodVisitor.visitJumpInsn(153, label2);
                        methodVisitor.visitLabel(label);
                        Integer num = Opcodes.INTEGER;
                        methodVisitor.visitFrame(0, 11,
                                new Object[] { "java/lang/invoke/MethodHandles$Lookup", "java/lang/String",
                                        "java/lang/invoke/MethodType", "java/lang/invoke/MethodType",
                                        "java/lang/invoke/MethodHandle", "java/lang/invoke/MethodType", num,
                                        "java/util/List", "java/util/List", "[B", "java/lang/invoke/MethodHandleInfo" },
                                0, new Object[0]);
                        methodVisitor.visitVarInsn(25, 10);
                        methodVisitor.visitMethodInsn(185, "java/lang/invoke/MethodHandleInfo", "getReferenceKind",
                                "()I", true);
                        methodVisitor.visitIntInsn(16, 7);
                        Label label3 = new Label();
                        methodVisitor.visitJumpInsn(160, label3);
                        methodVisitor.visitLabel(label2);
                        methodVisitor.visitFrame(3, 0, null, 0, null);
                        methodVisitor.visitInsn(4);
                        Label label4 = new Label();
                        methodVisitor.visitJumpInsn(167, label4);
                        methodVisitor.visitLabel(label3);
                        methodVisitor.visitFrame(3, 0, null, 0, null);
                        methodVisitor.visitInsn(3);
                        methodVisitor.visitLabel(label4);
                        methodVisitor.visitFrame(4, 0, null, 1, new Object[] { num });
                        methodVisitor.visitVarInsn(54, 11);
                        methodVisitor.visitVarInsn(21, 11);
                        Label label5 = new Label();
                        methodVisitor.visitJumpInsn(153, label5);
                        methodVisitor.visitVarInsn(25, 0);
                        methodVisitor.visitVarInsn(25, 9);
                        methodVisitor.visitVarInsn(25, 10);
                        methodVisitor.visitInsn(4);
                        methodVisitor.visitInsn(5);
                        methodVisitor.visitTypeInsn(189, "java/lang/invoke/MethodHandles$Lookup$ClassOption");
                        methodVisitor.visitInsn(89);
                        methodVisitor.visitInsn(3);
                        methodVisitor.visitFieldInsn(178, "java/lang/invoke/MethodHandles$Lookup$ClassOption",
                                "NESTMATE", "Ljava/lang/invoke/MethodHandles$Lookup$ClassOption;");
                        methodVisitor.visitInsn(83);
                        methodVisitor.visitInsn(89);
                        methodVisitor.visitInsn(4);
                        methodVisitor.visitFieldInsn(178, "java/lang/invoke/MethodHandles$Lookup$ClassOption", "STRONG",
                                "Ljava/lang/invoke/MethodHandles$Lookup$ClassOption;");
                        methodVisitor.visitInsn(83);
                        methodVisitor.visitMethodInsn(182, "java/lang/invoke/MethodHandles$Lookup",
                                "defineHiddenClassWithClassData",
                                "([BLjava/lang/Object;Z[Ljava/lang/invoke/MethodHandles$Lookup$ClassOption;)Ljava/lang/invoke/MethodHandles$Lookup;",
                                false);
                        methodVisitor.visitVarInsn(58, 12);
                        methodVisitor.visitLabel(new Label());
                        Label label6 = new Label();
                        methodVisitor.visitJumpInsn(167, label6);
                        methodVisitor.visitLabel(label5);
                        methodVisitor.visitFrame(1, 1, new Object[] { num }, 0, null);
                        methodVisitor.visitVarInsn(25, 0);
                        methodVisitor.visitVarInsn(25, 9);
                        methodVisitor.visitInsn(4);
                        methodVisitor.visitInsn(5);
                        methodVisitor.visitTypeInsn(189, "java/lang/invoke/MethodHandles$Lookup$ClassOption");
                        methodVisitor.visitInsn(89);
                        methodVisitor.visitInsn(3);
                        methodVisitor.visitFieldInsn(178, "java/lang/invoke/MethodHandles$Lookup$ClassOption",
                                "NESTMATE", "Ljava/lang/invoke/MethodHandles$Lookup$ClassOption;");
                        methodVisitor.visitInsn(83);
                        methodVisitor.visitInsn(89);
                        methodVisitor.visitInsn(4);
                        methodVisitor.visitFieldInsn(178, "java/lang/invoke/MethodHandles$Lookup$ClassOption", "STRONG",
                                "Ljava/lang/invoke/MethodHandles$Lookup$ClassOption;");
                        methodVisitor.visitInsn(83);
                        methodVisitor.visitMethodInsn(182, "java/lang/invoke/MethodHandles$Lookup", "defineHiddenClass",
                                "([BZ[Ljava/lang/invoke/MethodHandles$Lookup$ClassOption;)Ljava/lang/invoke/MethodHandles$Lookup;",
                                false);
                        methodVisitor.visitVarInsn(58, 12);
                        methodVisitor.visitLabel(label6);
                        methodVisitor.visitFrame(1, 1, new Object[] { "java/lang/invoke/MethodHandles$Lookup" }, 0,
                                null);
                        methodVisitor.visitVarInsn(25, 12);
                        methodVisitor.visitMethodInsn(182, "java/lang/invoke/MethodHandles$Lookup", "lookupClass",
                                "()Ljava/lang/Class;", false);
                        methodVisitor.visitVarInsn(58, 10);
                        methodVisitor.visitFrame(0, 10, new Object[] { "java/lang/invoke/MethodHandles$Lookup",
                                "java/lang/String", "java/lang/invoke/MethodType", "java/lang/invoke/MethodType",
                                "java/lang/invoke/MethodHandle", "java/lang/invoke/MethodType", num, "java/util/List",
                                "java/util/List", TypeProxy.SilentConstruction.Appender.JAVA_LANG_CLASS_INTERNAL_NAME },
                                0, null);
                    }

                    @Override // net.bytebuddy.agent.builder.AgentBuilder.LambdaInstrumentationStrategy.LambdaMetafactoryFactory.Loader
                    public int getLocalVariableLength() {
                        return 15;
                    }

                    @Override // net.bytebuddy.agent.builder.AgentBuilder.LambdaInstrumentationStrategy.LambdaMetafactoryFactory.Loader
                    public int getStackSize() {
                        return 8;
                    }
                }

                /*
                 * JADX INFO: compiled from:
                 * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
                 */
                public enum UsingUnsafe implements Loader {
                    JDK_INTERNAL_MISC_UNSAFE("jdk/internal/misc/Unsafe"),
                    SUN_MISC_UNSAFE("sun/misc/Unsafe");

                    private final String type;

                    UsingUnsafe(String str) {
                        this.type = str;
                    }

                    @Override // net.bytebuddy.agent.builder.AgentBuilder.LambdaInstrumentationStrategy.LambdaMetafactoryFactory.Loader
                    public void apply(MethodVisitor methodVisitor) {
                        methodVisitor.visitMethodInsn(184, this.type, "getUnsafe",
                                yg.o(new StringBuilder("()L"), this.type, ";"), false);
                        methodVisitor.visitVarInsn(58, 11);
                        methodVisitor.visitVarInsn(25, 11);
                        methodVisitor.visitVarInsn(25, 0);
                        methodVisitor.visitMethodInsn(182, "java/lang/invoke/MethodHandles$Lookup", "lookupClass",
                                "()Ljava/lang/Class;", false);
                        methodVisitor.visitVarInsn(25, 9);
                        methodVisitor.visitInsn(1);
                        methodVisitor.visitMethodInsn(182, this.type, "defineAnonymousClass",
                                "(Ljava/lang/Class;[B[Ljava/lang/Object;)Ljava/lang/Class;", false);
                        methodVisitor.visitVarInsn(58, 10);
                        methodVisitor.visitVarInsn(25, 11);
                        methodVisitor.visitVarInsn(25, 10);
                        methodVisitor.visitMethodInsn(182, this.type, "ensureClassInitialized", "(Ljava/lang/Class;)V",
                                false);
                    }

                    @Override // net.bytebuddy.agent.builder.AgentBuilder.LambdaInstrumentationStrategy.LambdaMetafactoryFactory.Loader
                    public int getLocalVariableLength() {
                        return 13;
                    }

                    @Override // net.bytebuddy.agent.builder.AgentBuilder.LambdaInstrumentationStrategy.LambdaMetafactoryFactory.Loader
                    public int getStackSize() {
                        return 4;
                    }

                    public String getType() {
                        return this.type;
                    }
                }

                void apply(MethodVisitor methodVisitor);

                int getLocalVariableLength();

                int getStackSize();
            }

            static {
                int i = 6;
                LambdaMetafactoryFactory lambdaMetafactoryFactory = new LambdaMetafactoryFactory("REGULAR", 0, i, 11) { // from
                                                                                                                        // class:
                                                                                                                        // net.bytebuddy.agent.builder.AgentBuilder.LambdaInstrumentationStrategy.LambdaMetafactoryFactory.1
                    @Override // net.bytebuddy.agent.builder.AgentBuilder.LambdaInstrumentationStrategy.LambdaMetafactoryFactory
                    public void onDispatch(MethodVisitor methodVisitor) {
                        methodVisitor.visitInsn(3);
                        methodVisitor.visitVarInsn(54, 6);
                        methodVisitor.visitMethodInsn(184, "java/util/Collections", "emptyList", "()Ljava/util/List;",
                                false);
                        methodVisitor.visitVarInsn(58, 7);
                        methodVisitor.visitMethodInsn(184, "java/util/Collections", "emptyList", "()Ljava/util/List;",
                                false);
                        methodVisitor.visitVarInsn(58, 8);
                        methodVisitor.visitFrame(1, 3,
                                new Object[] { Opcodes.INTEGER, "java/util/List", "java/util/List" }, 0, null);
                    }
                };
                REGULAR = lambdaMetafactoryFactory;
                LambdaMetafactoryFactory lambdaMetafactoryFactory2 = new LambdaMetafactoryFactory("ALTERNATIVE", 1, i,
                        16) { // from class:
                              // net.bytebuddy.agent.builder.AgentBuilder.LambdaInstrumentationStrategy.LambdaMetafactoryFactory.2
                    @Override // net.bytebuddy.agent.builder.AgentBuilder.LambdaInstrumentationStrategy.LambdaMetafactoryFactory
                    public void onDispatch(MethodVisitor methodVisitor) {
                        methodVisitor.visitVarInsn(25, 3);
                        methodVisitor.visitInsn(6);
                        methodVisitor.visitInsn(50);
                        methodVisitor.visitTypeInsn(192, "java/lang/Integer");
                        methodVisitor.visitMethodInsn(182, "java/lang/Integer", "intValue", "()I", false);
                        methodVisitor.visitVarInsn(54, 4);
                        methodVisitor.visitInsn(7);
                        methodVisitor.visitVarInsn(54, 5);
                        methodVisitor.visitVarInsn(21, 4);
                        methodVisitor.visitInsn(5);
                        methodVisitor.visitInsn(126);
                        Label label = new Label();
                        methodVisitor.visitJumpInsn(153, label);
                        methodVisitor.visitVarInsn(25, 3);
                        methodVisitor.visitVarInsn(21, 5);
                        methodVisitor.visitIincInsn(5, 1);
                        methodVisitor.visitInsn(50);
                        methodVisitor.visitTypeInsn(192, "java/lang/Integer");
                        methodVisitor.visitMethodInsn(182, "java/lang/Integer", "intValue", "()I", false);
                        methodVisitor.visitVarInsn(54, 7);
                        methodVisitor.visitVarInsn(21, 7);
                        methodVisitor.visitTypeInsn(189,
                                TypeProxy.SilentConstruction.Appender.JAVA_LANG_CLASS_INTERNAL_NAME);
                        methodVisitor.visitVarInsn(58, 6);
                        methodVisitor.visitVarInsn(25, 3);
                        methodVisitor.visitVarInsn(21, 5);
                        methodVisitor.visitVarInsn(25, 6);
                        methodVisitor.visitInsn(3);
                        methodVisitor.visitVarInsn(21, 7);
                        methodVisitor.visitMethodInsn(184, "java/lang/System", "arraycopy",
                                "(Ljava/lang/Object;ILjava/lang/Object;II)V", false);
                        methodVisitor.visitVarInsn(21, 5);
                        methodVisitor.visitVarInsn(21, 7);
                        methodVisitor.visitInsn(96);
                        methodVisitor.visitVarInsn(54, 5);
                        Label label2 = new Label();
                        methodVisitor.visitJumpInsn(167, label2);
                        methodVisitor.visitLabel(label);
                        Integer num = Opcodes.INTEGER;
                        methodVisitor.visitFrame(1, 2, new Object[] { num, num }, 0, null);
                        methodVisitor.visitInsn(3);
                        methodVisitor.visitTypeInsn(189,
                                TypeProxy.SilentConstruction.Appender.JAVA_LANG_CLASS_INTERNAL_NAME);
                        methodVisitor.visitVarInsn(58, 6);
                        methodVisitor.visitLabel(label2);
                        methodVisitor.visitFrame(1, 1, new Object[] { "[Ljava/lang/Class;" }, 0, null);
                        methodVisitor.visitVarInsn(21, 4);
                        methodVisitor.visitInsn(5);
                        methodVisitor.visitInsn(126);
                        Label label3 = new Label();
                        methodVisitor.visitJumpInsn(153, label3);
                        methodVisitor.visitVarInsn(25, 3);
                        methodVisitor.visitVarInsn(21, 5);
                        methodVisitor.visitIincInsn(5, 1);
                        methodVisitor.visitInsn(50);
                        methodVisitor.visitTypeInsn(192, "java/lang/Integer");
                        methodVisitor.visitMethodInsn(182, "java/lang/Integer", "intValue", "()I", false);
                        methodVisitor.visitVarInsn(54, 8);
                        methodVisitor.visitVarInsn(21, 8);
                        methodVisitor.visitTypeInsn(189, "java/lang/invoke/MethodType");
                        methodVisitor.visitVarInsn(58, 7);
                        methodVisitor.visitVarInsn(25, 3);
                        methodVisitor.visitVarInsn(21, 5);
                        methodVisitor.visitVarInsn(25, 7);
                        methodVisitor.visitInsn(3);
                        methodVisitor.visitVarInsn(21, 8);
                        methodVisitor.visitMethodInsn(184, "java/lang/System", "arraycopy",
                                "(Ljava/lang/Object;ILjava/lang/Object;II)V", false);
                        Label label4 = new Label();
                        methodVisitor.visitJumpInsn(167, label4);
                        methodVisitor.visitLabel(label3);
                        methodVisitor.visitFrame(3, 0, null, 0, null);
                        methodVisitor.visitInsn(3);
                        methodVisitor.visitTypeInsn(189, "java/lang/invoke/MethodType");
                        methodVisitor.visitVarInsn(58, 7);
                        methodVisitor.visitLabel(label4);
                        methodVisitor.visitFrame(1, 1, new Object[] { "[Ljava/lang/invoke/MethodType;" }, 0, null);
                        methodVisitor.visitVarInsn(25, 3);
                        methodVisitor.visitInsn(3);
                        methodVisitor.visitInsn(50);
                        methodVisitor.visitTypeInsn(192, "java/lang/invoke/MethodType");
                        methodVisitor.visitVarInsn(58, 8);
                        methodVisitor.visitVarInsn(25, 3);
                        methodVisitor.visitInsn(4);
                        methodVisitor.visitInsn(50);
                        methodVisitor.visitTypeInsn(192, "java/lang/invoke/MethodHandle");
                        methodVisitor.visitVarInsn(58, 9);
                        methodVisitor.visitVarInsn(25, 3);
                        methodVisitor.visitInsn(5);
                        methodVisitor.visitInsn(50);
                        methodVisitor.visitTypeInsn(192, "java/lang/invoke/MethodType");
                        methodVisitor.visitVarInsn(58, 10);
                        methodVisitor.visitVarInsn(21, 4);
                        methodVisitor.visitInsn(4);
                        methodVisitor.visitInsn(126);
                        Label label5 = new Label();
                        methodVisitor.visitJumpInsn(153, label5);
                        methodVisitor.visitInsn(4);
                        Label label6 = new Label();
                        methodVisitor.visitJumpInsn(167, label6);
                        methodVisitor.visitLabel(label5);
                        methodVisitor
                                .visitFrame(
                                        1, 3, new Object[] { "java/lang/invoke/MethodType",
                                                "java/lang/invoke/MethodHandle", "java/lang/invoke/MethodType" },
                                        0, null);
                        methodVisitor.visitInsn(3);
                        methodVisitor.visitLabel(label6);
                        methodVisitor.visitFrame(4, 0, null, 1, new Object[] { num });
                        methodVisitor.visitVarInsn(54, 11);
                        methodVisitor.visitVarInsn(25, 6);
                        methodVisitor.visitMethodInsn(184, "java/util/Arrays", "asList",
                                "([Ljava/lang/Object;)Ljava/util/List;", false);
                        methodVisitor.visitVarInsn(58, 12);
                        methodVisitor.visitVarInsn(25, 7);
                        methodVisitor.visitMethodInsn(184, "java/util/Arrays", "asList",
                                "([Ljava/lang/Object;)Ljava/util/List;", false);
                        methodVisitor.visitVarInsn(58, 13);
                        methodVisitor.visitVarInsn(25, 8);
                        methodVisitor.visitVarInsn(58, 3);
                        methodVisitor.visitVarInsn(25, 9);
                        methodVisitor.visitVarInsn(58, 4);
                        methodVisitor.visitVarInsn(25, 10);
                        methodVisitor.visitVarInsn(58, 5);
                        methodVisitor.visitVarInsn(21, 11);
                        methodVisitor.visitVarInsn(54, 6);
                        methodVisitor.visitVarInsn(25, 12);
                        methodVisitor.visitVarInsn(58, 7);
                        methodVisitor.visitVarInsn(25, 13);
                        methodVisitor.visitVarInsn(58, 8);
                        methodVisitor.visitFrame(0, 9,
                                new Object[] { "java/lang/invoke/MethodHandles$Lookup", "java/lang/String",
                                        "java/lang/invoke/MethodType", "java/lang/invoke/MethodType",
                                        "java/lang/invoke/MethodHandle", "java/lang/invoke/MethodType", num,
                                        "java/util/List", "java/util/List" },
                                0, null);
                    }
                };
                ALTERNATIVE = lambdaMetafactoryFactory2;
                $VALUES = new LambdaMetafactoryFactory[] { lambdaMetafactoryFactory, lambdaMetafactoryFactory2 };
                LOADER = resolve();
            }

            private static Loader resolve() {
                try {
                    Class<?> cls = Class.forName("java.lang.invoke.MethodHandles$Lookup", false, null);
                    Class cls2 = Boolean.TYPE;
                    cls.getMethod("defineHiddenClass", byte[].class, cls2,
                            Class.forName("[Ljava.lang.invoke.MethodHandles$Lookup$ClassOption;", false, null));
                    cls.getMethod("defineHiddenClassWithClassData", byte[].class, Object.class, cls2,
                            Class.forName("[Ljava.lang.invoke.MethodHandles$Lookup$ClassOption;", false, null));
                    return Loader.UsingMethodHandleLookup.INSTANCE;
                } catch (Exception unused) {
                    for (Loader.UsingUnsafe usingUnsafe : Loader.UsingUnsafe.values()) {
                        try {
                            Class.forName(
                                    usingUnsafe.getType().replace('/',
                                            TypePool.Default.LazyTypeDescription.GenericTypeToken.INNER_CLASS_PATH),
                                    false, null)
                                    .getMethod("defineAnonymousClass", Class.class, byte[].class, Object[].class);
                            return usingUnsafe;
                        } catch (Exception unused2) {
                        }
                    }
                    return Loader.Unavailable.INSTANCE;
                }
            }

            public static LambdaMetafactoryFactory valueOf(String str) {
                return (LambdaMetafactoryFactory) Enum.valueOf(LambdaMetafactoryFactory.class, str);
            }

            public static LambdaMetafactoryFactory[] values() {
                return (LambdaMetafactoryFactory[]) $VALUES.clone();
            }

            @Override // net.bytebuddy.implementation.bytecode.ByteCodeAppender
            public ByteCodeAppender.Size apply(MethodVisitor methodVisitor, Implementation.Context context,
                    MethodDescription methodDescription) {
                onDispatch(methodVisitor);
                methodVisitor.visitMethodInsn(184, "java/lang/ClassLoader", "getSystemClassLoader",
                        "()Ljava/lang/ClassLoader;", false);
                methodVisitor.visitLdcInsn("net.bytebuddy.agent.builder.LambdaFactory");
                methodVisitor.visitMethodInsn(182, "java/lang/ClassLoader", "loadClass",
                        "(Ljava/lang/String;)Ljava/lang/Class;", false);
                methodVisitor.visitLdcInsn(TypeProxy.REFLECTION_METHOD);
                methodVisitor.visitIntInsn(16, 9);
                methodVisitor.visitTypeInsn(189, TypeProxy.SilentConstruction.Appender.JAVA_LANG_CLASS_INTERNAL_NAME);
                methodVisitor.visitInsn(89);
                methodVisitor.visitInsn(3);
                methodVisitor
                        .visitLdcInsn(Type.getType(TypeProxy.SilentConstruction.Appender.JAVA_LANG_OBJECT_DESCRIPTOR));
                methodVisitor.visitInsn(83);
                methodVisitor.visitInsn(89);
                methodVisitor.visitInsn(4);
                methodVisitor.visitLdcInsn(Type.getType("Ljava/lang/String;"));
                methodVisitor.visitInsn(83);
                methodVisitor.visitInsn(89);
                methodVisitor.visitInsn(5);
                methodVisitor
                        .visitLdcInsn(Type.getType(TypeProxy.SilentConstruction.Appender.JAVA_LANG_OBJECT_DESCRIPTOR));
                methodVisitor.visitInsn(83);
                methodVisitor.visitInsn(89);
                methodVisitor.visitInsn(6);
                methodVisitor
                        .visitLdcInsn(Type.getType(TypeProxy.SilentConstruction.Appender.JAVA_LANG_OBJECT_DESCRIPTOR));
                methodVisitor.visitInsn(83);
                methodVisitor.visitInsn(89);
                methodVisitor.visitInsn(7);
                methodVisitor
                        .visitLdcInsn(Type.getType(TypeProxy.SilentConstruction.Appender.JAVA_LANG_OBJECT_DESCRIPTOR));
                methodVisitor.visitInsn(83);
                methodVisitor.visitInsn(89);
                methodVisitor.visitInsn(8);
                methodVisitor
                        .visitLdcInsn(Type.getType(TypeProxy.SilentConstruction.Appender.JAVA_LANG_OBJECT_DESCRIPTOR));
                methodVisitor.visitInsn(83);
                methodVisitor.visitInsn(89);
                methodVisitor.visitIntInsn(16, 6);
                methodVisitor.visitFieldInsn(178, "java/lang/Boolean", "TYPE", "Ljava/lang/Class;");
                methodVisitor.visitInsn(83);
                methodVisitor.visitInsn(89);
                methodVisitor.visitIntInsn(16, 7);
                methodVisitor.visitLdcInsn(Type.getType("Ljava/util/List;"));
                methodVisitor.visitInsn(83);
                methodVisitor.visitInsn(89);
                methodVisitor.visitIntInsn(16, 8);
                methodVisitor.visitLdcInsn(Type.getType("Ljava/util/List;"));
                methodVisitor.visitInsn(83);
                methodVisitor.visitMethodInsn(182, TypeProxy.SilentConstruction.Appender.JAVA_LANG_CLASS_INTERNAL_NAME,
                        "getDeclaredMethod", "(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;", false);
                methodVisitor.visitInsn(1);
                methodVisitor.visitIntInsn(16, 9);
                methodVisitor.visitTypeInsn(189, "java/lang/Object");
                methodVisitor.visitInsn(89);
                methodVisitor.visitInsn(3);
                methodVisitor.visitVarInsn(25, 0);
                methodVisitor.visitInsn(83);
                methodVisitor.visitInsn(89);
                methodVisitor.visitInsn(4);
                methodVisitor.visitVarInsn(25, 1);
                methodVisitor.visitInsn(83);
                methodVisitor.visitInsn(89);
                methodVisitor.visitInsn(5);
                methodVisitor.visitVarInsn(25, 2);
                methodVisitor.visitInsn(83);
                methodVisitor.visitInsn(89);
                methodVisitor.visitInsn(6);
                methodVisitor.visitVarInsn(25, 3);
                methodVisitor.visitInsn(83);
                methodVisitor.visitInsn(89);
                methodVisitor.visitInsn(7);
                methodVisitor.visitVarInsn(25, 4);
                methodVisitor.visitInsn(83);
                methodVisitor.visitInsn(89);
                methodVisitor.visitInsn(8);
                methodVisitor.visitVarInsn(25, 5);
                methodVisitor.visitInsn(83);
                methodVisitor.visitInsn(89);
                methodVisitor.visitIntInsn(16, 6);
                methodVisitor.visitVarInsn(21, 6);
                methodVisitor.visitMethodInsn(184, "java/lang/Boolean", "valueOf", "(Z)Ljava/lang/Boolean;", false);
                methodVisitor.visitInsn(83);
                methodVisitor.visitInsn(89);
                methodVisitor.visitIntInsn(16, 7);
                methodVisitor.visitVarInsn(25, 7);
                methodVisitor.visitInsn(83);
                methodVisitor.visitInsn(89);
                methodVisitor.visitIntInsn(16, 8);
                methodVisitor.visitVarInsn(25, 8);
                methodVisitor.visitInsn(83);
                methodVisitor.visitMethodInsn(182, "java/lang/reflect/Method", "invoke",
                        "(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;", false);
                methodVisitor.visitTypeInsn(192, "[B");
                methodVisitor.visitVarInsn(58, 9);
                Loader loader = LOADER;
                loader.apply(methodVisitor);
                methodVisitor.visitVarInsn(25, 2);
                methodVisitor.visitMethodInsn(182, "java/lang/invoke/MethodType", "parameterCount", "()I", false);
                Label label = new Label();
                methodVisitor.visitJumpInsn(154, label);
                methodVisitor.visitTypeInsn(187, "java/lang/invoke/ConstantCallSite");
                methodVisitor.visitInsn(89);
                methodVisitor.visitVarInsn(25, 2);
                methodVisitor.visitMethodInsn(182, "java/lang/invoke/MethodType", "returnType", "()Ljava/lang/Class;",
                        false);
                methodVisitor.visitVarInsn(25, 10);
                methodVisitor.visitMethodInsn(182, TypeProxy.SilentConstruction.Appender.JAVA_LANG_CLASS_INTERNAL_NAME,
                        "getDeclaredConstructors", "()[Ljava/lang/reflect/Constructor;", false);
                methodVisitor.visitInsn(3);
                methodVisitor.visitInsn(50);
                methodVisitor.visitInsn(3);
                methodVisitor.visitTypeInsn(189, "java/lang/Object");
                methodVisitor.visitMethodInsn(182,
                        TypeProxy.SilentConstruction.Appender.JAVA_LANG_CONSTRUCTOR_INTERNAL_NAME,
                        TypeProxy.SilentConstruction.Appender.NEW_INSTANCE_METHOD_NAME,
                        TypeProxy.SilentConstruction.Appender.NEW_INSTANCE_METHOD_DESCRIPTOR, false);
                methodVisitor.visitMethodInsn(184, "java/lang/invoke/MethodHandles", "constant",
                        "(Ljava/lang/Class;Ljava/lang/Object;)Ljava/lang/invoke/MethodHandle;", false);
                methodVisitor.visitMethodInsn(183, "java/lang/invoke/ConstantCallSite",
                        MethodDescription.CONSTRUCTOR_INTERNAL_NAME, "(Ljava/lang/invoke/MethodHandle;)V", false);
                Label label2 = new Label();
                methodVisitor.visitJumpInsn(167, label2);
                methodVisitor.visitLabel(label);
                methodVisitor.visitFrame(0, 11,
                        new Object[] { "java/lang/invoke/MethodHandles$Lookup", "java/lang/String",
                                "java/lang/invoke/MethodType", "java/lang/invoke/MethodType",
                                "java/lang/invoke/MethodHandle", "java/lang/invoke/MethodType", Opcodes.INTEGER,
                                "java/util/List", "java/util/List", "[B",
                                TypeProxy.SilentConstruction.Appender.JAVA_LANG_CLASS_INTERNAL_NAME },
                        0, new Object[0]);
                methodVisitor.visitTypeInsn(187, "java/lang/invoke/ConstantCallSite");
                methodVisitor.visitInsn(89);
                methodVisitor.visitFieldInsn(178, "java/lang/invoke/MethodHandles$Lookup", "IMPL_LOOKUP",
                        "Ljava/lang/invoke/MethodHandles$Lookup;");
                methodVisitor.visitVarInsn(25, 10);
                methodVisitor.visitLdcInsn("get$Lambda");
                methodVisitor.visitVarInsn(25, 2);
                methodVisitor.visitMethodInsn(182, "java/lang/invoke/MethodHandles$Lookup", "findStatic",
                        "(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/MethodHandle;",
                        false);
                methodVisitor.visitMethodInsn(183, "java/lang/invoke/ConstantCallSite",
                        MethodDescription.CONSTRUCTOR_INTERNAL_NAME, "(Ljava/lang/invoke/MethodHandle;)V", false);
                methodVisitor.visitLabel(label2);
                methodVisitor.visitFrame(4, 0, null, 1, new Object[] { "java/lang/invoke/CallSite" });
                methodVisitor.visitInsn(176);
                return new ByteCodeAppender.Size(Math.max(this.stackSize, loader.getStackSize()),
                        Math.max(this.localVariableLength, loader.getLocalVariableLength()));
            }

            public abstract void onDispatch(MethodVisitor methodVisitor);

            private LambdaMetafactoryFactory(String str, int i, int i2, int i3) {
                this.stackSize = i2;
                this.localVariableLength = i3;
            }
        }

        public static LambdaInstrumentationStrategy of(boolean z) {
            return z ? ENABLED : DISABLED;
        }

        public static void release(ClassFileTransformer classFileTransformer, Instrumentation instrumentation) {
            if (LambdaFactory.release(classFileTransformer)) {
                try {
                    ClassReloadingStrategy.of(instrumentation)
                            .reset(Class.forName("java.lang.invoke.LambdaMetafactory"));
                } catch (Exception e) {
                    throw new IllegalStateException("Could not release lambda transformer", e);
                }
            }
        }

        public abstract void apply(ByteBuddy byteBuddy, Instrumentation instrumentation,
                ClassFileTransformer classFileTransformer);

        public boolean isEnabled() {
            return this == ENABLED;
        }

        public abstract boolean isInstrumented(@MaybeNull Class<?> cls);
    }

    /*
     * JADX INFO: compiled from:
     * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
     */
    public interface Listener {
        public static final boolean LOADED = true;

        /*
         * JADX INFO: compiled from:
         * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
         */
        public static abstract class Adapter implements Listener {
            @Override // net.bytebuddy.agent.builder.AgentBuilder.Listener
            public void onComplete(String str, @MaybeNull ClassLoader classLoader, @MaybeNull JavaModule javaModule,
                    boolean z) {
            }

            @Override // net.bytebuddy.agent.builder.AgentBuilder.Listener
            public void onDiscovery(String str, @MaybeNull ClassLoader classLoader, @MaybeNull JavaModule javaModule,
                    boolean z) {
            }

            @Override // net.bytebuddy.agent.builder.AgentBuilder.Listener
            public void onError(String str, @MaybeNull ClassLoader classLoader, @MaybeNull JavaModule javaModule,
                    boolean z, Throwable th) {
            }

            @Override // net.bytebuddy.agent.builder.AgentBuilder.Listener
            public void onIgnored(TypeDescription typeDescription, @MaybeNull ClassLoader classLoader,
                    @MaybeNull JavaModule javaModule, boolean z) {
            }

            @Override // net.bytebuddy.agent.builder.AgentBuilder.Listener
            public void onTransformation(TypeDescription typeDescription, @MaybeNull ClassLoader classLoader,
                    @MaybeNull JavaModule javaModule, boolean z, DynamicType dynamicType) {
            }
        }

        /*
         * JADX INFO: compiled from:
         * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
         */
        @HashCodeAndEqualsPlugin.Enhance
        public static class Compound implements Listener {
            private final List<Listener> listeners;

            public Compound(Listener... listenerArr) {
                this((List<? extends Listener>) Arrays.asList(listenerArr));
            }

            public boolean equals(@MaybeNull Object obj) {
                if (this == obj) {
                    return true;
                }
                return obj != null && getClass() == obj.getClass() && this.listeners.equals(((Compound) obj).listeners);
            }

            public int hashCode() {
                return this.listeners.hashCode() + (getClass().hashCode() * 31);
            }

            @Override // net.bytebuddy.agent.builder.AgentBuilder.Listener
            public void onComplete(String str, @MaybeNull ClassLoader classLoader, @MaybeNull JavaModule javaModule,
                    boolean z) {
                Iterator<Listener> it = this.listeners.iterator();
                while (it.hasNext()) {
                    it.next().onComplete(str, classLoader, javaModule, z);
                }
            }

            @Override // net.bytebuddy.agent.builder.AgentBuilder.Listener
            public void onDiscovery(String str, @MaybeNull ClassLoader classLoader, @MaybeNull JavaModule javaModule,
                    boolean z) {
                Iterator<Listener> it = this.listeners.iterator();
                while (it.hasNext()) {
                    it.next().onDiscovery(str, classLoader, javaModule, z);
                }
            }

            @Override // net.bytebuddy.agent.builder.AgentBuilder.Listener
            public void onError(String str, @MaybeNull ClassLoader classLoader, @MaybeNull JavaModule javaModule,
                    boolean z, Throwable th) {
                Iterator<Listener> it = this.listeners.iterator();
                while (it.hasNext()) {
                    it.next().onError(str, classLoader, javaModule, z, th);
                }
            }

            @Override // net.bytebuddy.agent.builder.AgentBuilder.Listener
            public void onIgnored(TypeDescription typeDescription, @MaybeNull ClassLoader classLoader,
                    @MaybeNull JavaModule javaModule, boolean z) {
                Iterator<Listener> it = this.listeners.iterator();
                while (it.hasNext()) {
                    it.next().onIgnored(typeDescription, classLoader, javaModule, z);
                }
            }

            @Override // net.bytebuddy.agent.builder.AgentBuilder.Listener
            public void onTransformation(TypeDescription typeDescription, @MaybeNull ClassLoader classLoader,
                    @MaybeNull JavaModule javaModule, boolean z, DynamicType dynamicType) {
                Iterator<Listener> it = this.listeners.iterator();
                while (it.hasNext()) {
                    it.next().onTransformation(typeDescription, classLoader, javaModule, z, dynamicType);
                }
            }

            public Compound(List<? extends Listener> list) {
                this.listeners = new ArrayList();
                for (Listener listener : list) {
                    if (listener instanceof Compound) {
                        this.listeners.addAll(((Compound) listener).listeners);
                    } else if (!(listener instanceof NoOp)) {
                        this.listeners.add(listener);
                    }
                }
            }
        }

        /*
         * JADX INFO: compiled from:
         * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
         */
        @HashCodeAndEqualsPlugin.Enhance
        public static class Filtering implements Listener {
            private final Listener delegate;
            private final ElementMatcher<? super String> matcher;

            public Filtering(ElementMatcher<? super String> elementMatcher, Listener listener) {
                this.matcher = elementMatcher;
                this.delegate = listener;
            }

            public boolean equals(@MaybeNull Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || getClass() != obj.getClass()) {
                    return false;
                }
                Filtering filtering = (Filtering) obj;
                return this.matcher.equals(filtering.matcher) && this.delegate.equals(filtering.delegate);
            }

            public int hashCode() {
                return this.delegate.hashCode() + dkz.i(this.matcher, getClass().hashCode() * 31, 31);
            }

            @Override // net.bytebuddy.agent.builder.AgentBuilder.Listener
            public void onComplete(String str, @MaybeNull ClassLoader classLoader, @MaybeNull JavaModule javaModule,
                    boolean z) {
                if (this.matcher.matches(str)) {
                    this.delegate.onComplete(str, classLoader, javaModule, z);
                }
            }

            @Override // net.bytebuddy.agent.builder.AgentBuilder.Listener
            public void onDiscovery(String str, @MaybeNull ClassLoader classLoader, @MaybeNull JavaModule javaModule,
                    boolean z) {
                if (this.matcher.matches(str)) {
                    this.delegate.onDiscovery(str, classLoader, javaModule, z);
                }
            }

            @Override // net.bytebuddy.agent.builder.AgentBuilder.Listener
            public void onError(String str, @MaybeNull ClassLoader classLoader, @MaybeNull JavaModule javaModule,
                    boolean z, Throwable th) {
                if (this.matcher.matches(str)) {
                    this.delegate.onError(str, classLoader, javaModule, z, th);
                }
            }

            @Override // net.bytebuddy.agent.builder.AgentBuilder.Listener
            public void onIgnored(TypeDescription typeDescription, @MaybeNull ClassLoader classLoader,
                    @MaybeNull JavaModule javaModule, boolean z) {
                if (this.matcher.matches(typeDescription.getName())) {
                    this.delegate.onIgnored(typeDescription, classLoader, javaModule, z);
                }
            }

            @Override // net.bytebuddy.agent.builder.AgentBuilder.Listener
            public void onTransformation(TypeDescription typeDescription, @MaybeNull ClassLoader classLoader,
                    @MaybeNull JavaModule javaModule, boolean z, DynamicType dynamicType) {
                if (this.matcher.matches(typeDescription.getName())) {
                    this.delegate.onTransformation(typeDescription, classLoader, javaModule, z, dynamicType);
                }
            }
        }

        /*
         * JADX INFO: compiled from:
         * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
         */
        @HashCodeAndEqualsPlugin.Enhance
        public static class ModuleReadEdgeCompleting extends Adapter {
            private final boolean addTargetEdge;
            private final Instrumentation instrumentation;
            private final Set<? extends JavaModule> modules;

            public ModuleReadEdgeCompleting(Instrumentation instrumentation, boolean z, Set<? extends JavaModule> set) {
                this.instrumentation = instrumentation;
                this.addTargetEdge = z;
                this.modules = set;
            }

            public static Listener of(Instrumentation instrumentation, boolean z, Class<?>... clsArr) {
                HashSet hashSet = new HashSet();
                for (Class<?> cls : clsArr) {
                    hashSet.add(JavaModule.ofType(cls));
                }
                return hashSet.isEmpty() ? NoOp.INSTANCE : new ModuleReadEdgeCompleting(instrumentation, z, hashSet);
            }

            public boolean equals(@MaybeNull Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || getClass() != obj.getClass()) {
                    return false;
                }
                ModuleReadEdgeCompleting moduleReadEdgeCompleting = (ModuleReadEdgeCompleting) obj;
                return this.addTargetEdge == moduleReadEdgeCompleting.addTargetEdge
                        && this.instrumentation.equals(moduleReadEdgeCompleting.instrumentation)
                        && this.modules.equals(moduleReadEdgeCompleting.modules);
            }

            public int hashCode() {
                return this.modules.hashCode()
                        + ((((this.instrumentation.hashCode() + (getClass().hashCode() * 31)) * 31)
                                + (this.addTargetEdge ? 1 : 0)) * 31);
            }

            @Override // net.bytebuddy.agent.builder.AgentBuilder.Listener.Adapter,
                      // net.bytebuddy.agent.builder.AgentBuilder.Listener
            public void onTransformation(TypeDescription typeDescription, @MaybeNull ClassLoader classLoader,
                    @MaybeNull JavaModule javaModule, boolean z, DynamicType dynamicType) {
                if (javaModule == JavaModule.UNSUPPORTED || !javaModule.isNamed()) {
                    return;
                }
                for (JavaModule javaModule2 : this.modules) {
                    if (!javaModule.canRead(javaModule2) || (this.addTargetEdge
                            && !javaModule.isOpened(typeDescription.getPackage(), javaModule2))) {
                        PackageDescription packageDescription = typeDescription.getPackage();
                        Instrumentation instrumentation = this.instrumentation;
                        Set setSingleton = Collections.singleton(javaModule2);
                        Map map = Collections.EMPTY_MAP;
                        ClassInjector.UsingInstrumentation
                                .redefineModule(instrumentation, javaModule, setSingleton, map,
                                        (!this.addTargetEdge || packageDescription == null
                                                || packageDescription.isDefault())
                                                        ? map
                                                        : Collections.singletonMap(packageDescription.getName(),
                                                                Collections.singleton(javaModule2)),
                                        Collections.EMPTY_SET, map);
                    }
                    if (this.addTargetEdge && !javaModule2.canRead(javaModule)) {
                        Instrumentation instrumentation2 = this.instrumentation;
                        Set setSingleton2 = Collections.singleton(javaModule);
                        Map map2 = Collections.EMPTY_MAP;
                        ClassInjector.UsingInstrumentation.redefineModule(instrumentation2, javaModule2, setSingleton2,
                                map2, map2, Collections.EMPTY_SET, map2);
                    }
                }
            }
        }

        /*
         * JADX INFO: compiled from:
         * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
         */
        public enum NoOp implements Listener {
            INSTANCE;

            @Override // net.bytebuddy.agent.builder.AgentBuilder.Listener
            public void onComplete(String str, @MaybeNull ClassLoader classLoader, @MaybeNull JavaModule javaModule,
                    boolean z) {
            }

            @Override // net.bytebuddy.agent.builder.AgentBuilder.Listener
            public void onDiscovery(String str, @MaybeNull ClassLoader classLoader, @MaybeNull JavaModule javaModule,
                    boolean z) {
            }

            @Override // net.bytebuddy.agent.builder.AgentBuilder.Listener
            public void onError(String str, @MaybeNull ClassLoader classLoader, @MaybeNull JavaModule javaModule,
                    boolean z, Throwable th) {
            }

            @Override // net.bytebuddy.agent.builder.AgentBuilder.Listener
            public void onIgnored(TypeDescription typeDescription, @MaybeNull ClassLoader classLoader,
                    @MaybeNull JavaModule javaModule, boolean z) {
            }

            @Override // net.bytebuddy.agent.builder.AgentBuilder.Listener
            public void onTransformation(TypeDescription typeDescription, @MaybeNull ClassLoader classLoader,
                    @MaybeNull JavaModule javaModule, boolean z, DynamicType dynamicType) {
            }
        }

        /*
         * JADX INFO: compiled from:
         * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
         */
        @HashCodeAndEqualsPlugin.Enhance
        public static class StreamWriting implements Listener {
            protected static final String PREFIX = "[Byte Buddy]";
            private final PrintStream printStream;

            public StreamWriting(PrintStream printStream) {
                this.printStream = printStream;
            }

            public static StreamWriting toSystemError() {
                return new StreamWriting(System.err);
            }

            public static StreamWriting toSystemOut() {
                return new StreamWriting(System.out);
            }

            public boolean equals(@MaybeNull Object obj) {
                if (this == obj) {
                    return true;
                }
                return obj != null && getClass() == obj.getClass()
                        && this.printStream.equals(((StreamWriting) obj).printStream);
            }

            public int hashCode() {
                return this.printStream.hashCode() + (getClass().hashCode() * 31);
            }

            @Override // net.bytebuddy.agent.builder.AgentBuilder.Listener
            public void onComplete(String str, @MaybeNull ClassLoader classLoader, @MaybeNull JavaModule javaModule,
                    boolean z) {
                this.printStream.printf("[Byte Buddy] COMPLETE %s [%s, %s, %s, loaded=%b]%n", str, classLoader,
                        javaModule, Thread.currentThread(), Boolean.valueOf(z));
            }

            @Override // net.bytebuddy.agent.builder.AgentBuilder.Listener
            public void onDiscovery(String str, @MaybeNull ClassLoader classLoader, @MaybeNull JavaModule javaModule,
                    boolean z) {
                this.printStream.printf("[Byte Buddy] DISCOVERY %s [%s, %s, %s, loaded=%b]%n", str, classLoader,
                        javaModule, Thread.currentThread(), Boolean.valueOf(z));
            }

            @Override // net.bytebuddy.agent.builder.AgentBuilder.Listener
            public void onError(String str, @MaybeNull ClassLoader classLoader, @MaybeNull JavaModule javaModule,
                    boolean z, Throwable th) {
                synchronized (this.printStream) {
                    this.printStream.printf("[Byte Buddy] ERROR %s [%s, %s, %s, loaded=%b]%n", str, classLoader,
                            javaModule, Thread.currentThread(), Boolean.valueOf(z));
                    th.printStackTrace(this.printStream);
                }
            }

            @Override // net.bytebuddy.agent.builder.AgentBuilder.Listener
            public void onIgnored(TypeDescription typeDescription, @MaybeNull ClassLoader classLoader,
                    @MaybeNull JavaModule javaModule, boolean z) {
                this.printStream.printf("[Byte Buddy] IGNORE %s [%s, %s, %s, loaded=%b]%n", typeDescription.getName(),
                        classLoader, javaModule, Thread.currentThread(), Boolean.valueOf(z));
            }

            @Override // net.bytebuddy.agent.builder.AgentBuilder.Listener
            public void onTransformation(TypeDescription typeDescription, @MaybeNull ClassLoader classLoader,
                    @MaybeNull JavaModule javaModule, boolean z, DynamicType dynamicType) {
                this.printStream.printf("[Byte Buddy] TRANSFORM %s [%s, %s, %s, loaded=%b]%n",
                        typeDescription.getName(), classLoader, javaModule, Thread.currentThread(), Boolean.valueOf(z));
            }

            public Listener withErrorsOnly() {
                return new WithErrorsOnly(this);
            }

            public Listener withTransformationsOnly() {
                return new WithTransformationsOnly(this);
            }
        }

        /*
         * JADX INFO: compiled from:
         * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
         */
        @HashCodeAndEqualsPlugin.Enhance
        public static class WithErrorsOnly extends Adapter {
            private final Listener delegate;

            public WithErrorsOnly(Listener listener) {
                this.delegate = listener;
            }

            public boolean equals(@MaybeNull Object obj) {
                if (this == obj) {
                    return true;
                }
                return obj != null && getClass() == obj.getClass()
                        && this.delegate.equals(((WithErrorsOnly) obj).delegate);
            }

            public int hashCode() {
                return this.delegate.hashCode() + (getClass().hashCode() * 31);
            }

            @Override // net.bytebuddy.agent.builder.AgentBuilder.Listener.Adapter,
                      // net.bytebuddy.agent.builder.AgentBuilder.Listener
            public void onError(String str, @MaybeNull ClassLoader classLoader, @MaybeNull JavaModule javaModule,
                    boolean z, Throwable th) {
                this.delegate.onError(str, classLoader, javaModule, z, th);
            }
        }

        /*
         * JADX INFO: compiled from:
         * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
         */
        @HashCodeAndEqualsPlugin.Enhance
        public static class WithTransformationsOnly extends Adapter {
            private final Listener delegate;

            public WithTransformationsOnly(Listener listener) {
                this.delegate = listener;
            }

            public boolean equals(@MaybeNull Object obj) {
                if (this == obj) {
                    return true;
                }
                return obj != null && getClass() == obj.getClass()
                        && this.delegate.equals(((WithTransformationsOnly) obj).delegate);
            }

            public int hashCode() {
                return this.delegate.hashCode() + (getClass().hashCode() * 31);
            }

            @Override // net.bytebuddy.agent.builder.AgentBuilder.Listener.Adapter,
                      // net.bytebuddy.agent.builder.AgentBuilder.Listener
            public void onError(String str, @MaybeNull ClassLoader classLoader, @MaybeNull JavaModule javaModule,
                    boolean z, Throwable th) {
                this.delegate.onError(str, classLoader, javaModule, z, th);
            }

            @Override // net.bytebuddy.agent.builder.AgentBuilder.Listener.Adapter,
                      // net.bytebuddy.agent.builder.AgentBuilder.Listener
            public void onTransformation(TypeDescription typeDescription, @MaybeNull ClassLoader classLoader,
                    @MaybeNull JavaModule javaModule, boolean z, DynamicType dynamicType) {
                this.delegate.onTransformation(typeDescription, classLoader, javaModule, z, dynamicType);
            }
        }

        void onComplete(String str, @MaybeNull ClassLoader classLoader, @MaybeNull JavaModule javaModule, boolean z);

        void onDiscovery(String str, @MaybeNull ClassLoader classLoader, @MaybeNull JavaModule javaModule, boolean z);

        void onError(String str, @MaybeNull ClassLoader classLoader, @MaybeNull JavaModule javaModule, boolean z,
                Throwable th);

        void onIgnored(TypeDescription typeDescription, @MaybeNull ClassLoader classLoader,
                @MaybeNull JavaModule javaModule, boolean z);

        void onTransformation(TypeDescription typeDescription, @MaybeNull ClassLoader classLoader,
                @MaybeNull JavaModule javaModule, boolean z, DynamicType dynamicType);
    }

    /*
     * JADX INFO: compiled from:
     * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
     */
    public interface LocationStrategy {

        /*
         * JADX INFO: compiled from:
         * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
         */
        @HashCodeAndEqualsPlugin.Enhance
        public static class Compound implements LocationStrategy {
            private final List<LocationStrategy> locationStrategies;

            public Compound(LocationStrategy... locationStrategyArr) {
                this((List<? extends LocationStrategy>) Arrays.asList(locationStrategyArr));
            }

            @Override // net.bytebuddy.agent.builder.AgentBuilder.LocationStrategy
            public ClassFileLocator classFileLocator(@MaybeNull ClassLoader classLoader,
                    @MaybeNull JavaModule javaModule) {
                ArrayList arrayList = new ArrayList(this.locationStrategies.size());
                Iterator<LocationStrategy> it = this.locationStrategies.iterator();
                while (it.hasNext()) {
                    arrayList.add(it.next().classFileLocator(classLoader, javaModule));
                }
                return new ClassFileLocator.Compound(arrayList);
            }

            public boolean equals(@MaybeNull Object obj) {
                if (this == obj) {
                    return true;
                }
                return obj != null && getClass() == obj.getClass()
                        && this.locationStrategies.equals(((Compound) obj).locationStrategies);
            }

            public int hashCode() {
                return this.locationStrategies.hashCode() + (getClass().hashCode() * 31);
            }

            public Compound(List<? extends LocationStrategy> list) {
                this.locationStrategies = new ArrayList();
                for (LocationStrategy locationStrategy : list) {
                    if (locationStrategy instanceof Compound) {
                        this.locationStrategies.addAll(((Compound) locationStrategy).locationStrategies);
                    } else if (!(locationStrategy instanceof NoOp)) {
                        this.locationStrategies.add(locationStrategy);
                    }
                }
            }
        }

        /*
         * JADX INFO: compiled from:
         * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
         */
        public enum ForClassLoader implements LocationStrategy {
            STRONG { // from class:
                     // net.bytebuddy.agent.builder.AgentBuilder.LocationStrategy.ForClassLoader.1
                @Override // net.bytebuddy.agent.builder.AgentBuilder.LocationStrategy
                public ClassFileLocator classFileLocator(@MaybeNull ClassLoader classLoader,
                        @MaybeNull JavaModule javaModule) {
                    return ClassFileLocator.ForClassLoader.of(classLoader);
                }
            },
            WEAK { // from class:
                   // net.bytebuddy.agent.builder.AgentBuilder.LocationStrategy.ForClassLoader.2
                @Override // net.bytebuddy.agent.builder.AgentBuilder.LocationStrategy
                public ClassFileLocator classFileLocator(@MaybeNull ClassLoader classLoader,
                        @MaybeNull JavaModule javaModule) {
                    return ClassFileLocator.ForClassLoader.WeaklyReferenced.of(classLoader);
                }
            };

            public LocationStrategy withFallbackTo(ClassFileLocator... classFileLocatorArr) {
                return withFallbackTo((Collection<? extends ClassFileLocator>) Arrays.asList(classFileLocatorArr));
            }

            public LocationStrategy withFallbackTo(Collection<? extends ClassFileLocator> collection) {
                ArrayList arrayList = new ArrayList(collection.size());
                Iterator<? extends ClassFileLocator> it = collection.iterator();
                while (it.hasNext()) {
                    arrayList.add(new Simple(it.next()));
                }
                return withFallbackTo((List<? extends LocationStrategy>) arrayList);
            }

            public LocationStrategy withFallbackTo(LocationStrategy... locationStrategyArr) {
                return withFallbackTo(Arrays.asList(locationStrategyArr));
            }

            public LocationStrategy withFallbackTo(List<? extends LocationStrategy> list) {
                ArrayList arrayList = new ArrayList(list.size() + 1);
                arrayList.add(this);
                arrayList.addAll(list);
                return new Compound(arrayList);
            }
        }

        /*
         * JADX INFO: compiled from:
         * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
         */
        public enum NoOp implements LocationStrategy {
            INSTANCE;

            @Override // net.bytebuddy.agent.builder.AgentBuilder.LocationStrategy
            public ClassFileLocator classFileLocator(@MaybeNull ClassLoader classLoader,
                    @MaybeNull JavaModule javaModule) {
                return ClassFileLocator.NoOp.INSTANCE;
            }
        }

        /*
         * JADX INFO: compiled from:
         * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
         */
        @HashCodeAndEqualsPlugin.Enhance
        public static class Simple implements LocationStrategy {
            private final ClassFileLocator classFileLocator;

            public Simple(ClassFileLocator classFileLocator) {
                this.classFileLocator = classFileLocator;
            }

            @Override // net.bytebuddy.agent.builder.AgentBuilder.LocationStrategy
            public ClassFileLocator classFileLocator(@MaybeNull ClassLoader classLoader,
                    @MaybeNull JavaModule javaModule) {
                return this.classFileLocator;
            }

            public boolean equals(@MaybeNull Object obj) {
                if (this == obj) {
                    return true;
                }
                return obj != null && getClass() == obj.getClass()
                        && this.classFileLocator.equals(((Simple) obj).classFileLocator);
            }

            public int hashCode() {
                return this.classFileLocator.hashCode() + (getClass().hashCode() * 31);
            }
        }

        ClassFileLocator classFileLocator(@MaybeNull ClassLoader classLoader, @MaybeNull JavaModule javaModule);
    }

    /*
     * JADX INFO: compiled from:
     * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
     */
    public interface Matchable<T extends Matchable<T>> {
        T and(RawMatcher rawMatcher);

        T and(ElementMatcher<? super TypeDescription> elementMatcher);

        T and(ElementMatcher<? super TypeDescription> elementMatcher,
                ElementMatcher<? super ClassLoader> elementMatcher2);

        T and(ElementMatcher<? super TypeDescription> elementMatcher,
                ElementMatcher<? super ClassLoader> elementMatcher2,
                ElementMatcher<? super JavaModule> elementMatcher3);

        T or(RawMatcher rawMatcher);

        T or(ElementMatcher<? super TypeDescription> elementMatcher);

        T or(ElementMatcher<? super TypeDescription> elementMatcher,
                ElementMatcher<? super ClassLoader> elementMatcher2);

        T or(ElementMatcher<? super TypeDescription> elementMatcher,
                ElementMatcher<? super ClassLoader> elementMatcher2,
                ElementMatcher<? super JavaModule> elementMatcher3);
    }

    /*
     * JADX INFO: compiled from:
     * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
     */
    public enum PatchMode {
        GAP { // from class: net.bytebuddy.agent.builder.AgentBuilder.PatchMode.1
            @Override // net.bytebuddy.agent.builder.AgentBuilder.PatchMode
            public Handler toHandler(ResettableClassFileTransformer resettableClassFileTransformer) {
                return new Handler.ForPatchWithGap(resettableClassFileTransformer);
            }
        },
        OVERLAP { // from class: net.bytebuddy.agent.builder.AgentBuilder.PatchMode.2
            @Override // net.bytebuddy.agent.builder.AgentBuilder.PatchMode
            public Handler toHandler(ResettableClassFileTransformer resettableClassFileTransformer) {
                return new Handler.ForPatchWithOverlap(resettableClassFileTransformer);
            }
        },
        SUBSTITUTE { // from class: net.bytebuddy.agent.builder.AgentBuilder.PatchMode.3
            @Override // net.bytebuddy.agent.builder.AgentBuilder.PatchMode
            public Handler toHandler(ResettableClassFileTransformer resettableClassFileTransformer) {
                if (resettableClassFileTransformer instanceof ResettableClassFileTransformer.Substitutable) {
                    return new Handler.ForPatchWithSubstitution(
                            (ResettableClassFileTransformer.Substitutable) resettableClassFileTransformer);
                }
                throw new IllegalArgumentException(
                        "Original class file transformer is not substitutable: " + resettableClassFileTransformer);
            }
        };

        /*
         * JADX INFO: compiled from:
         * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
         */
        public interface Handler {

            /*
             * JADX INFO: compiled from:
             * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
             */
            @HashCodeAndEqualsPlugin.Enhance
            public static class ForPatchWithGap implements Handler {
                private final ResettableClassFileTransformer classFileTransformer;

                public ForPatchWithGap(ResettableClassFileTransformer resettableClassFileTransformer) {
                    this.classFileTransformer = resettableClassFileTransformer;
                }

                public boolean equals(@MaybeNull Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    return obj != null && getClass() == obj.getClass()
                            && this.classFileTransformer.equals(((ForPatchWithGap) obj).classFileTransformer);
                }

                public int hashCode() {
                    return this.classFileTransformer.hashCode() + (getClass().hashCode() * 31);
                }

                @Override // net.bytebuddy.agent.builder.AgentBuilder.PatchMode.Handler
                public void onAfterRegistration(Instrumentation instrumentation) {
                }

                @Override // net.bytebuddy.agent.builder.AgentBuilder.PatchMode.Handler
                public void onBeforeRegistration(Instrumentation instrumentation) {
                    if (this.classFileTransformer.reset(instrumentation, RedefinitionStrategy.DISABLED)) {
                        return;
                    }
                    throw new IllegalArgumentException(
                            "Failed to deregister patched class file transformer: " + this.classFileTransformer);
                }

                @Override // net.bytebuddy.agent.builder.AgentBuilder.PatchMode.Handler
                public boolean onRegistration(ResettableClassFileTransformer resettableClassFileTransformer) {
                    return true;
                }
            }

            /*
             * JADX INFO: compiled from:
             * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
             */
            @HashCodeAndEqualsPlugin.Enhance
            public static class ForPatchWithOverlap implements Handler {
                private final ResettableClassFileTransformer classFileTransformer;

                public ForPatchWithOverlap(ResettableClassFileTransformer resettableClassFileTransformer) {
                    this.classFileTransformer = resettableClassFileTransformer;
                }

                public boolean equals(@MaybeNull Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    return obj != null && getClass() == obj.getClass()
                            && this.classFileTransformer.equals(((ForPatchWithOverlap) obj).classFileTransformer);
                }

                public int hashCode() {
                    return this.classFileTransformer.hashCode() + (getClass().hashCode() * 31);
                }

                @Override // net.bytebuddy.agent.builder.AgentBuilder.PatchMode.Handler
                public void onAfterRegistration(Instrumentation instrumentation) {
                    if (this.classFileTransformer.reset(instrumentation, RedefinitionStrategy.DISABLED)) {
                        return;
                    }
                    throw new IllegalArgumentException(
                            "Failed to deregister patched class file transformer: " + this.classFileTransformer);
                }

                @Override // net.bytebuddy.agent.builder.AgentBuilder.PatchMode.Handler
                public void onBeforeRegistration(Instrumentation instrumentation) {
                }

                @Override // net.bytebuddy.agent.builder.AgentBuilder.PatchMode.Handler
                public boolean onRegistration(ResettableClassFileTransformer resettableClassFileTransformer) {
                    return true;
                }
            }

            /*
             * JADX INFO: compiled from:
             * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
             */
            @HashCodeAndEqualsPlugin.Enhance
            public static class ForPatchWithSubstitution implements Handler {
                private final ResettableClassFileTransformer.Substitutable classFileTransformer;

                public ForPatchWithSubstitution(ResettableClassFileTransformer.Substitutable substitutable) {
                    this.classFileTransformer = substitutable;
                }

                public boolean equals(@MaybeNull Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    return obj != null && getClass() == obj.getClass()
                            && this.classFileTransformer.equals(((ForPatchWithSubstitution) obj).classFileTransformer);
                }

                public int hashCode() {
                    return this.classFileTransformer.hashCode() + (getClass().hashCode() * 31);
                }

                @Override // net.bytebuddy.agent.builder.AgentBuilder.PatchMode.Handler
                public void onAfterRegistration(Instrumentation instrumentation) {
                }

                @Override // net.bytebuddy.agent.builder.AgentBuilder.PatchMode.Handler
                public void onBeforeRegistration(Instrumentation instrumentation) {
                }

                @Override // net.bytebuddy.agent.builder.AgentBuilder.PatchMode.Handler
                public boolean onRegistration(ResettableClassFileTransformer resettableClassFileTransformer) {
                    this.classFileTransformer.substitute(resettableClassFileTransformer);
                    return false;
                }
            }

            /*
             * JADX INFO: compiled from:
             * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
             */
            public enum NoOp implements Handler {
                INSTANCE;

                @Override // net.bytebuddy.agent.builder.AgentBuilder.PatchMode.Handler
                public void onAfterRegistration(Instrumentation instrumentation) {
                }

                @Override // net.bytebuddy.agent.builder.AgentBuilder.PatchMode.Handler
                public void onBeforeRegistration(Instrumentation instrumentation) {
                }

                @Override // net.bytebuddy.agent.builder.AgentBuilder.PatchMode.Handler
                public boolean onRegistration(ResettableClassFileTransformer resettableClassFileTransformer) {
                    return true;
                }
            }

            void onAfterRegistration(Instrumentation instrumentation);

            void onBeforeRegistration(Instrumentation instrumentation);

            boolean onRegistration(ResettableClassFileTransformer resettableClassFileTransformer);
        }

        public static PatchMode of(ResettableClassFileTransformer resettableClassFileTransformer) {
            return resettableClassFileTransformer instanceof ResettableClassFileTransformer.Substitutable ? SUBSTITUTE
                    : OVERLAP;
        }

        public abstract Handler toHandler(ResettableClassFileTransformer resettableClassFileTransformer);
    }

    /*
     * JADX INFO: compiled from:
     * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
     */
    public interface PoolStrategy {

        /*
         * JADX INFO: compiled from:
         * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
         */
        public enum ClassLoading implements PoolStrategy {
            EXTENDED(TypePool.Default.ReaderMode.EXTENDED),
            FAST(TypePool.Default.ReaderMode.FAST);

            private final TypePool.Default.ReaderMode readerMode;

            ClassLoading(TypePool.Default.ReaderMode readerMode) {
                this.readerMode = readerMode;
            }

            @Override // net.bytebuddy.agent.builder.AgentBuilder.PoolStrategy
            public TypePool typePool(ClassFileLocator classFileLocator, @MaybeNull ClassLoader classLoader) {
                return TypePool.ClassLoading.of(classLoader, new TypePool.Default.WithLazyResolution(
                        TypePool.CacheProvider.Simple.withObjectType(), classFileLocator, this.readerMode));
            }

            @Override // net.bytebuddy.agent.builder.AgentBuilder.PoolStrategy
            public TypePool typePool(ClassFileLocator classFileLocator, @MaybeNull ClassLoader classLoader,
                    String str) {
                return typePool(classFileLocator, classLoader);
            }
        }

        /*
         * JADX INFO: compiled from:
         * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
         */
        public enum Default implements PoolStrategy {
            EXTENDED(TypePool.Default.ReaderMode.EXTENDED),
            FAST(TypePool.Default.ReaderMode.FAST);

            private final TypePool.Default.ReaderMode readerMode;

            Default(TypePool.Default.ReaderMode readerMode) {
                this.readerMode = readerMode;
            }

            @Override // net.bytebuddy.agent.builder.AgentBuilder.PoolStrategy
            public TypePool typePool(ClassFileLocator classFileLocator, @MaybeNull ClassLoader classLoader) {
                return new TypePool.LazyFacade(new TypePool.Default.WithLazyResolution(
                        TypePool.CacheProvider.Simple.withObjectType(), classFileLocator, this.readerMode));
            }

            @Override // net.bytebuddy.agent.builder.AgentBuilder.PoolStrategy
            public TypePool typePool(ClassFileLocator classFileLocator, @MaybeNull ClassLoader classLoader,
                    String str) {
                return typePool(classFileLocator, classLoader);
            }
        }

        /*
         * JADX INFO: compiled from:
         * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
         */
        public enum Eager implements PoolStrategy {
            EXTENDED(TypePool.Default.ReaderMode.EXTENDED),
            FAST(TypePool.Default.ReaderMode.FAST);

            private final TypePool.Default.ReaderMode readerMode;

            Eager(TypePool.Default.ReaderMode readerMode) {
                this.readerMode = readerMode;
            }

            @Override // net.bytebuddy.agent.builder.AgentBuilder.PoolStrategy
            public TypePool typePool(ClassFileLocator classFileLocator, @MaybeNull ClassLoader classLoader) {
                return new TypePool.Default(TypePool.CacheProvider.Simple.withObjectType(), classFileLocator,
                        this.readerMode);
            }

            @Override // net.bytebuddy.agent.builder.AgentBuilder.PoolStrategy
            public TypePool typePool(ClassFileLocator classFileLocator, @MaybeNull ClassLoader classLoader,
                    String str) {
                return typePool(classFileLocator, classLoader);
            }
        }

        /*
         * JADX INFO: compiled from:
         * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
         */
        public enum ExtraLazy implements PoolStrategy {
            EXTENDED(TypePool.Default.ReaderMode.EXTENDED),
            FAST(TypePool.Default.ReaderMode.FAST);

            private final TypePool.Default.ReaderMode readerMode;

            ExtraLazy(TypePool.Default.ReaderMode readerMode) {
                this.readerMode = readerMode;
            }

            @Override // net.bytebuddy.agent.builder.AgentBuilder.PoolStrategy
            public TypePool typePool(ClassFileLocator classFileLocator, @MaybeNull ClassLoader classLoader) {
                return new TypePool.LazyFacade(new TypePool.Default.WithLazyResolution(
                        TypePool.CacheProvider.Simple.withObjectType(), classFileLocator, this.readerMode,
                        TypePool.Default.WithLazyResolution.LazinessMode.EXTENDED));
            }

            @Override // net.bytebuddy.agent.builder.AgentBuilder.PoolStrategy
            public TypePool typePool(ClassFileLocator classFileLocator, @MaybeNull ClassLoader classLoader,
                    String str) {
                return typePool(classFileLocator, classLoader);
            }
        }

        /*
         * JADX INFO: compiled from:
         * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
         */
        @HashCodeAndEqualsPlugin.Enhance
        public static abstract class WithTypePoolCache implements PoolStrategy {
            protected final TypePool.Default.WithLazyResolution.LazinessMode lazinessMode;
            protected final TypePool.Default.ReaderMode readerMode;

            /*
             * JADX INFO: compiled from:
             * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
             */
            @HashCodeAndEqualsPlugin.Enhance
            public static class Simple extends WithTypePoolCache {
                private static final boolean ACCESS_CONTROLLER;
                private static final ClassLoader BOOTSTRAP_MARKER;
                private final ConcurrentMap<? super ClassLoader, TypePool.CacheProvider> cacheProviders;

                /*
                 * JADX INFO: compiled from:
                 * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
                 */
                public enum BootstrapMarkerAction implements PrivilegedAction<ClassLoader> {
                    INSTANCE;

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // java.security.PrivilegedAction
                    public ClassLoader run() {
                        return new URLClassLoader(new URL[0], ClassLoadingStrategy.BOOTSTRAP_LOADER);
                    }
                }

                static {
                    boolean z = false;
                    try {
                        Class.forName("java.security.AccessController", false, null);
                        ACCESS_CONTROLLER = Boolean
                                .parseBoolean(System.getProperty("net.bytebuddy.securitymanager", "true"));
                    } catch (ClassNotFoundException unused) {
                        ACCESS_CONTROLLER = z;
                    } catch (SecurityException unused2) {
                        z = true;
                        ACCESS_CONTROLLER = z;
                    }
                    BOOTSTRAP_MARKER = (ClassLoader) doPrivileged(BootstrapMarkerAction.INSTANCE);
                }

                public Simple(ConcurrentMap<? super ClassLoader, TypePool.CacheProvider> concurrentMap) {
                    this(TypePool.Default.ReaderMode.FAST, concurrentMap);
                }

                @AccessControllerPlugin.Enhance
                private static <T> T doPrivileged(PrivilegedAction<T> privilegedAction) {
                    return ACCESS_CONTROLLER ? (T) AccessController.doPrivileged(privilegedAction)
                            : privilegedAction.run();
                }

                @Override // net.bytebuddy.agent.builder.AgentBuilder.PoolStrategy.WithTypePoolCache
                public boolean equals(@MaybeNull Object obj) {
                    if (!super.equals(obj)) {
                        return false;
                    }
                    if (this == obj) {
                        return true;
                    }
                    return obj != null && getClass() == obj.getClass()
                            && this.cacheProviders.equals(((Simple) obj).cacheProviders);
                }

                public ClassLoader getBootstrapMarkerLoader() {
                    return BOOTSTRAP_MARKER;
                }

                @Override // net.bytebuddy.agent.builder.AgentBuilder.PoolStrategy.WithTypePoolCache
                public int hashCode() {
                    return this.cacheProviders.hashCode() + (super.hashCode() * 31);
                }

                @Override // net.bytebuddy.agent.builder.AgentBuilder.PoolStrategy.WithTypePoolCache
                public TypePool.CacheProvider locate(@MaybeNull ClassLoader classLoader) {
                    if (classLoader == null) {
                        classLoader = getBootstrapMarkerLoader();
                    }
                    TypePool.CacheProvider cacheProviderWithObjectType = this.cacheProviders.get(classLoader);
                    while (cacheProviderWithObjectType == null) {
                        cacheProviderWithObjectType = TypePool.CacheProvider.Simple.withObjectType();
                        TypePool.CacheProvider cacheProviderPutIfAbsent = this.cacheProviders.putIfAbsent(classLoader,
                                cacheProviderWithObjectType);
                        if (cacheProviderPutIfAbsent != null) {
                            cacheProviderWithObjectType = cacheProviderPutIfAbsent;
                        }
                    }
                    return cacheProviderWithObjectType;
                }

                public Simple(TypePool.Default.ReaderMode readerMode,
                        ConcurrentMap<? super ClassLoader, TypePool.CacheProvider> concurrentMap) {
                    super(readerMode);
                    this.cacheProviders = concurrentMap;
                }

                public Simple(TypePool.Default.ReaderMode readerMode,
                        TypePool.Default.WithLazyResolution.LazinessMode lazinessMode,
                        ConcurrentMap<? super ClassLoader, TypePool.CacheProvider> concurrentMap) {
                    super(readerMode, lazinessMode);
                    this.cacheProviders = concurrentMap;
                }
            }

            public WithTypePoolCache(TypePool.Default.ReaderMode readerMode) {
                this(readerMode, TypePool.Default.WithLazyResolution.LazinessMode.NAME);
            }

            public boolean equals(@MaybeNull Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || getClass() != obj.getClass()) {
                    return false;
                }
                WithTypePoolCache withTypePoolCache = (WithTypePoolCache) obj;
                return this.readerMode.equals(withTypePoolCache.readerMode)
                        && this.lazinessMode.equals(withTypePoolCache.lazinessMode);
            }

            public int hashCode() {
                return this.lazinessMode.hashCode()
                        + ((this.readerMode.hashCode() + (getClass().hashCode() * 31)) * 31);
            }

            public abstract TypePool.CacheProvider locate(@MaybeNull ClassLoader classLoader);

            @Override // net.bytebuddy.agent.builder.AgentBuilder.PoolStrategy
            public TypePool typePool(ClassFileLocator classFileLocator, @MaybeNull ClassLoader classLoader) {
                return new TypePool.LazyFacade(new TypePool.Default.WithLazyResolution(locate(classLoader),
                        classFileLocator, this.readerMode, this.lazinessMode));
            }

            public WithTypePoolCache(TypePool.Default.ReaderMode readerMode,
                    TypePool.Default.WithLazyResolution.LazinessMode lazinessMode) {
                this.readerMode = readerMode;
                this.lazinessMode = lazinessMode;
            }

            @Override // net.bytebuddy.agent.builder.AgentBuilder.PoolStrategy
            public TypePool typePool(ClassFileLocator classFileLocator, @MaybeNull ClassLoader classLoader,
                    String str) {
                return new TypePool.LazyFacade(new TypePool.Default.WithLazyResolution(
                        new TypePool.CacheProvider.Discriminating(ElementMatchers.is(str),
                                new TypePool.CacheProvider.Simple(), locate(classLoader)),
                        classFileLocator, this.readerMode, this.lazinessMode));
            }
        }

        TypePool typePool(ClassFileLocator classFileLocator, @MaybeNull ClassLoader classLoader);

        TypePool typePool(ClassFileLocator classFileLocator, @MaybeNull ClassLoader classLoader, String str);
    }

    /*
     * JADX INFO: compiled from:
     * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
     */
    public interface RawMatcher {

        /*
         * JADX INFO: compiled from:
         * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
         */
        @HashCodeAndEqualsPlugin.Enhance
        public static class Conjunction implements RawMatcher {
            private final List<RawMatcher> matchers;

            public Conjunction(RawMatcher... rawMatcherArr) {
                this((List<? extends RawMatcher>) Arrays.asList(rawMatcherArr));
            }

            public boolean equals(@MaybeNull Object obj) {
                if (this == obj) {
                    return true;
                }
                return obj != null && getClass() == obj.getClass()
                        && this.matchers.equals(((Conjunction) obj).matchers);
            }

            public int hashCode() {
                return this.matchers.hashCode() + (getClass().hashCode() * 31);
            }

            @Override // net.bytebuddy.agent.builder.AgentBuilder.RawMatcher
            public boolean matches(TypeDescription typeDescription, @MaybeNull ClassLoader classLoader,
                    @MaybeNull JavaModule javaModule, @MaybeNull Class<?> cls,
                    @MaybeNull ProtectionDomain protectionDomain) {
                Iterator<RawMatcher> it = this.matchers.iterator();
                while (it.hasNext()) {
                    TypeDescription typeDescription2 = typeDescription;
                    ClassLoader classLoader2 = classLoader;
                    JavaModule javaModule2 = javaModule;
                    Class<?> cls2 = cls;
                    ProtectionDomain protectionDomain2 = protectionDomain;
                    if (!it.next().matches(typeDescription2, classLoader2, javaModule2, cls2, protectionDomain2)) {
                        return false;
                    }
                    typeDescription = typeDescription2;
                    classLoader = classLoader2;
                    javaModule = javaModule2;
                    cls = cls2;
                    protectionDomain = protectionDomain2;
                }
                return true;
            }

            public Conjunction(List<? extends RawMatcher> list) {
                this.matchers = new ArrayList(list.size());
                for (RawMatcher rawMatcher : list) {
                    if (rawMatcher instanceof Conjunction) {
                        this.matchers.addAll(((Conjunction) rawMatcher).matchers);
                    } else if (rawMatcher != Trivial.MATCHING) {
                        this.matchers.add(rawMatcher);
                    }
                }
            }
        }

        /*
         * JADX INFO: compiled from:
         * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
         */
        @HashCodeAndEqualsPlugin.Enhance
        public static class Disjunction implements RawMatcher {
            private final List<RawMatcher> matchers;

            public Disjunction(RawMatcher... rawMatcherArr) {
                this((List<? extends RawMatcher>) Arrays.asList(rawMatcherArr));
            }

            public boolean equals(@MaybeNull Object obj) {
                if (this == obj) {
                    return true;
                }
                return obj != null && getClass() == obj.getClass()
                        && this.matchers.equals(((Disjunction) obj).matchers);
            }

            public int hashCode() {
                return this.matchers.hashCode() + (getClass().hashCode() * 31);
            }

            @Override // net.bytebuddy.agent.builder.AgentBuilder.RawMatcher
            public boolean matches(TypeDescription typeDescription, @MaybeNull ClassLoader classLoader,
                    @MaybeNull JavaModule javaModule, @MaybeNull Class<?> cls,
                    @MaybeNull ProtectionDomain protectionDomain) {
                Iterator<RawMatcher> it = this.matchers.iterator();
                while (it.hasNext()) {
                    TypeDescription typeDescription2 = typeDescription;
                    ClassLoader classLoader2 = classLoader;
                    JavaModule javaModule2 = javaModule;
                    Class<?> cls2 = cls;
                    ProtectionDomain protectionDomain2 = protectionDomain;
                    if (it.next().matches(typeDescription2, classLoader2, javaModule2, cls2, protectionDomain2)) {
                        return true;
                    }
                    typeDescription = typeDescription2;
                    classLoader = classLoader2;
                    javaModule = javaModule2;
                    cls = cls2;
                    protectionDomain = protectionDomain2;
                }
                return false;
            }

            public Disjunction(List<? extends RawMatcher> list) {
                this.matchers = new ArrayList(list.size());
                for (RawMatcher rawMatcher : list) {
                    if (rawMatcher instanceof Disjunction) {
                        this.matchers.addAll(((Disjunction) rawMatcher).matchers);
                    } else if (rawMatcher != Trivial.NON_MATCHING) {
                        this.matchers.add(rawMatcher);
                    }
                }
            }
        }

        /*
         * JADX INFO: compiled from:
         * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
         */
        @HashCodeAndEqualsPlugin.Enhance
        public static class ForElementMatchers implements RawMatcher {
            private final ElementMatcher<? super ClassLoader> classLoaderMatcher;
            private final ElementMatcher<? super JavaModule> moduleMatcher;
            private final ElementMatcher<? super TypeDescription> typeMatcher;

            public ForElementMatchers(ElementMatcher<? super TypeDescription> elementMatcher) {
                this(elementMatcher, ElementMatchers.any());
            }

            public boolean equals(@MaybeNull Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || getClass() != obj.getClass()) {
                    return false;
                }
                ForElementMatchers forElementMatchers = (ForElementMatchers) obj;
                return this.typeMatcher.equals(forElementMatchers.typeMatcher)
                        && this.classLoaderMatcher.equals(forElementMatchers.classLoaderMatcher)
                        && this.moduleMatcher.equals(forElementMatchers.moduleMatcher);
            }

            public int hashCode() {
                return this.moduleMatcher.hashCode()
                        + dkz.i(this.classLoaderMatcher, dkz.i(this.typeMatcher, getClass().hashCode() * 31, 31), 31);
            }

            @Override // net.bytebuddy.agent.builder.AgentBuilder.RawMatcher
            public boolean matches(TypeDescription typeDescription, @MaybeNull ClassLoader classLoader,
                    @MaybeNull JavaModule javaModule, @MaybeNull Class<?> cls,
                    @MaybeNull ProtectionDomain protectionDomain) {
                return this.moduleMatcher.matches(javaModule) && this.classLoaderMatcher.matches(classLoader)
                        && this.typeMatcher.matches(typeDescription);
            }

            public ForElementMatchers(ElementMatcher<? super TypeDescription> elementMatcher,
                    ElementMatcher<? super ClassLoader> elementMatcher2) {
                this(elementMatcher, elementMatcher2, ElementMatchers.any());
            }

            public ForElementMatchers(ElementMatcher<? super TypeDescription> elementMatcher,
                    ElementMatcher<? super ClassLoader> elementMatcher2,
                    ElementMatcher<? super JavaModule> elementMatcher3) {
                this.typeMatcher = elementMatcher;
                this.classLoaderMatcher = elementMatcher2;
                this.moduleMatcher = elementMatcher3;
            }
        }

        /*
         * JADX INFO: compiled from:
         * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
         */
        public enum ForLoadState implements RawMatcher {
            LOADED(false),
            UNLOADED(true);

            private final boolean unloaded;

            ForLoadState(boolean z) {
                this.unloaded = z;
            }

            @Override // net.bytebuddy.agent.builder.AgentBuilder.RawMatcher
            public boolean matches(TypeDescription typeDescription, @MaybeNull ClassLoader classLoader,
                    @MaybeNull JavaModule javaModule, @MaybeNull Class<?> cls,
                    @MaybeNull ProtectionDomain protectionDomain) {
                return (cls == null) == this.unloaded;
            }
        }

        /*
         * JADX INFO: compiled from:
         * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
         */
        public enum ForResolvableTypes implements RawMatcher {
            INSTANCE;

            public RawMatcher inverted() {
                return new Inversion(this);
            }

            @Override // net.bytebuddy.agent.builder.AgentBuilder.RawMatcher
            public boolean matches(TypeDescription typeDescription, @MaybeNull ClassLoader classLoader,
                    @MaybeNull JavaModule javaModule, @MaybeNull Class<?> cls,
                    @MaybeNull ProtectionDomain protectionDomain) {
                if (cls != null) {
                    return Class.forName(cls.getName(), true, classLoader) == cls;
                }
                return true;
            }
        }

        /*
         * JADX INFO: compiled from:
         * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
         */
        @HashCodeAndEqualsPlugin.Enhance
        public static class Inversion implements RawMatcher {
            private final RawMatcher matcher;

            public Inversion(RawMatcher rawMatcher) {
                this.matcher = rawMatcher;
            }

            public boolean equals(@MaybeNull Object obj) {
                if (this == obj) {
                    return true;
                }
                return obj != null && getClass() == obj.getClass() && this.matcher.equals(((Inversion) obj).matcher);
            }

            public int hashCode() {
                return this.matcher.hashCode() + (getClass().hashCode() * 31);
            }

            @Override // net.bytebuddy.agent.builder.AgentBuilder.RawMatcher
            public boolean matches(TypeDescription typeDescription, @MaybeNull ClassLoader classLoader,
                    @MaybeNull JavaModule javaModule, @MaybeNull Class<?> cls,
                    @MaybeNull ProtectionDomain protectionDomain) {
                return !this.matcher.matches(typeDescription, classLoader, javaModule, cls, protectionDomain);
            }
        }

        /*
         * JADX INFO: compiled from:
         * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
         */
        public enum Trivial implements RawMatcher {
            MATCHING(true),
            NON_MATCHING(false);

            private final boolean matches;

            Trivial(boolean z) {
                this.matches = z;
            }

            @Override // net.bytebuddy.agent.builder.AgentBuilder.RawMatcher
            public boolean matches(TypeDescription typeDescription, @MaybeNull ClassLoader classLoader,
                    @MaybeNull JavaModule javaModule, @MaybeNull Class<?> cls,
                    @MaybeNull ProtectionDomain protectionDomain) {
                return this.matches;
            }
        }

        boolean matches(TypeDescription typeDescription, @MaybeNull ClassLoader classLoader,
                @MaybeNull JavaModule javaModule, @MaybeNull Class<?> cls,
                @MaybeNull ProtectionDomain protectionDomain);
    }

    /*
     * JADX INFO: compiled from:
     * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
     */
    public interface RedefinitionListenable extends AgentBuilder {

        /*
         * JADX INFO: compiled from:
         * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
         */
        public interface ResubmissionImmediateMatcher {

            /*
             * JADX INFO: compiled from:
             * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
             */
            @HashCodeAndEqualsPlugin.Enhance
            public static class Conjunction implements ResubmissionImmediateMatcher {
                private final List<ResubmissionImmediateMatcher> matchers;

                public Conjunction(ResubmissionImmediateMatcher... resubmissionImmediateMatcherArr) {
                    this((List<? extends ResubmissionImmediateMatcher>) Arrays.asList(resubmissionImmediateMatcherArr));
                }

                public boolean equals(@MaybeNull Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    return obj != null && getClass() == obj.getClass()
                            && this.matchers.equals(((Conjunction) obj).matchers);
                }

                public int hashCode() {
                    return this.matchers.hashCode() + (getClass().hashCode() * 31);
                }

                @Override // net.bytebuddy.agent.builder.AgentBuilder.RedefinitionListenable.ResubmissionImmediateMatcher
                public boolean matches(String str, @MaybeNull ClassLoader classLoader,
                        @MaybeNull JavaModule javaModule) {
                    Iterator<ResubmissionImmediateMatcher> it = this.matchers.iterator();
                    while (it.hasNext()) {
                        if (!it.next().matches(str, classLoader, javaModule)) {
                            return false;
                        }
                    }
                    return true;
                }

                public Conjunction(List<? extends ResubmissionImmediateMatcher> list) {
                    this.matchers = new ArrayList(list.size());
                    for (ResubmissionImmediateMatcher resubmissionImmediateMatcher : list) {
                        if (resubmissionImmediateMatcher instanceof Conjunction) {
                            this.matchers.addAll(((Conjunction) resubmissionImmediateMatcher).matchers);
                        } else if (resubmissionImmediateMatcher != Trivial.NON_MATCHING) {
                            this.matchers.add(resubmissionImmediateMatcher);
                        }
                    }
                }
            }

            /*
             * JADX INFO: compiled from:
             * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
             */
            @HashCodeAndEqualsPlugin.Enhance
            public static class Disjunction implements ResubmissionImmediateMatcher {
                private final List<ResubmissionImmediateMatcher> matchers;

                public Disjunction(ResubmissionImmediateMatcher... resubmissionImmediateMatcherArr) {
                    this((List<? extends ResubmissionImmediateMatcher>) Arrays.asList(resubmissionImmediateMatcherArr));
                }

                public boolean equals(@MaybeNull Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    return obj != null && getClass() == obj.getClass()
                            && this.matchers.equals(((Disjunction) obj).matchers);
                }

                public int hashCode() {
                    return this.matchers.hashCode() + (getClass().hashCode() * 31);
                }

                @Override // net.bytebuddy.agent.builder.AgentBuilder.RedefinitionListenable.ResubmissionImmediateMatcher
                public boolean matches(String str, @MaybeNull ClassLoader classLoader,
                        @MaybeNull JavaModule javaModule) {
                    Iterator<ResubmissionImmediateMatcher> it = this.matchers.iterator();
                    while (it.hasNext()) {
                        if (it.next().matches(str, classLoader, javaModule)) {
                            return true;
                        }
                    }
                    return false;
                }

                public Disjunction(List<? extends ResubmissionImmediateMatcher> list) {
                    this.matchers = new ArrayList(list.size());
                    for (ResubmissionImmediateMatcher resubmissionImmediateMatcher : list) {
                        if (resubmissionImmediateMatcher instanceof Disjunction) {
                            this.matchers.addAll(((Disjunction) resubmissionImmediateMatcher).matchers);
                        } else if (resubmissionImmediateMatcher != Trivial.NON_MATCHING) {
                            this.matchers.add(resubmissionImmediateMatcher);
                        }
                    }
                }
            }

            /*
             * JADX INFO: compiled from:
             * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
             */
            @HashCodeAndEqualsPlugin.Enhance
            public static class ForElementMatchers implements ResubmissionImmediateMatcher {
                private final ElementMatcher<? super ClassLoader> classLoaderMatcher;
                private final ElementMatcher<? super JavaModule> moduleMatcher;
                private final ElementMatcher<String> typeNameMatcher;

                public ForElementMatchers(ElementMatcher<String> elementMatcher,
                        ElementMatcher<? super ClassLoader> elementMatcher2,
                        ElementMatcher<? super JavaModule> elementMatcher3) {
                    this.typeNameMatcher = elementMatcher;
                    this.classLoaderMatcher = elementMatcher2;
                    this.moduleMatcher = elementMatcher3;
                }

                public boolean equals(@MaybeNull Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (obj == null || getClass() != obj.getClass()) {
                        return false;
                    }
                    ForElementMatchers forElementMatchers = (ForElementMatchers) obj;
                    return this.typeNameMatcher.equals(forElementMatchers.typeNameMatcher)
                            && this.classLoaderMatcher.equals(forElementMatchers.classLoaderMatcher)
                            && this.moduleMatcher.equals(forElementMatchers.moduleMatcher);
                }

                public int hashCode() {
                    return this.moduleMatcher.hashCode() + dkz.i(this.classLoaderMatcher,
                            dkz.i(this.typeNameMatcher, getClass().hashCode() * 31, 31), 31);
                }

                @Override // net.bytebuddy.agent.builder.AgentBuilder.RedefinitionListenable.ResubmissionImmediateMatcher
                public boolean matches(String str, @MaybeNull ClassLoader classLoader,
                        @MaybeNull JavaModule javaModule) {
                    return this.typeNameMatcher.matches(str) && this.classLoaderMatcher.matches(classLoader)
                            && this.moduleMatcher.matches(javaModule);
                }
            }

            /*
             * JADX INFO: compiled from:
             * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
             */
            public enum Trivial implements ResubmissionImmediateMatcher {
                MATCHING(true),
                NON_MATCHING(false);

                private final boolean matching;

                Trivial(boolean z) {
                    this.matching = z;
                }

                @Override // net.bytebuddy.agent.builder.AgentBuilder.RedefinitionListenable.ResubmissionImmediateMatcher
                public boolean matches(String str, @MaybeNull ClassLoader classLoader,
                        @MaybeNull JavaModule javaModule) {
                    return this.matching;
                }
            }

            boolean matches(String str, @MaybeNull ClassLoader classLoader, @MaybeNull JavaModule javaModule);
        }

        /*
         * JADX INFO: compiled from:
         * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
         */
        public interface ResubmissionOnErrorMatcher {

            /*
             * JADX INFO: compiled from:
             * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
             */
            @HashCodeAndEqualsPlugin.Enhance
            public static class Conjunction implements ResubmissionOnErrorMatcher {
                private final List<ResubmissionOnErrorMatcher> matchers;

                public Conjunction(ResubmissionOnErrorMatcher... resubmissionOnErrorMatcherArr) {
                    this((List<? extends ResubmissionOnErrorMatcher>) Arrays.asList(resubmissionOnErrorMatcherArr));
                }

                public boolean equals(@MaybeNull Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    return obj != null && getClass() == obj.getClass()
                            && this.matchers.equals(((Conjunction) obj).matchers);
                }

                public int hashCode() {
                    return this.matchers.hashCode() + (getClass().hashCode() * 31);
                }

                @Override // net.bytebuddy.agent.builder.AgentBuilder.RedefinitionListenable.ResubmissionOnErrorMatcher
                public boolean matches(Throwable th, String str, @MaybeNull ClassLoader classLoader,
                        @MaybeNull JavaModule javaModule) {
                    Iterator<ResubmissionOnErrorMatcher> it = this.matchers.iterator();
                    while (it.hasNext()) {
                        if (!it.next().matches(th, str, classLoader, javaModule)) {
                            return false;
                        }
                    }
                    return true;
                }

                public Conjunction(List<? extends ResubmissionOnErrorMatcher> list) {
                    this.matchers = new ArrayList(list.size());
                    for (ResubmissionOnErrorMatcher resubmissionOnErrorMatcher : list) {
                        if (resubmissionOnErrorMatcher instanceof Conjunction) {
                            this.matchers.addAll(((Conjunction) resubmissionOnErrorMatcher).matchers);
                        } else if (resubmissionOnErrorMatcher != Trivial.MATCHING) {
                            this.matchers.add(resubmissionOnErrorMatcher);
                        }
                    }
                }
            }

            /*
             * JADX INFO: compiled from:
             * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
             */
            @HashCodeAndEqualsPlugin.Enhance
            public static class Disjunction implements ResubmissionOnErrorMatcher {
                private final List<ResubmissionOnErrorMatcher> matchers;

                public Disjunction(ResubmissionOnErrorMatcher... resubmissionOnErrorMatcherArr) {
                    this((List<? extends ResubmissionOnErrorMatcher>) Arrays.asList(resubmissionOnErrorMatcherArr));
                }

                public boolean equals(@MaybeNull Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    return obj != null && getClass() == obj.getClass()
                            && this.matchers.equals(((Disjunction) obj).matchers);
                }

                public int hashCode() {
                    return this.matchers.hashCode() + (getClass().hashCode() * 31);
                }

                @Override // net.bytebuddy.agent.builder.AgentBuilder.RedefinitionListenable.ResubmissionOnErrorMatcher
                public boolean matches(Throwable th, String str, @MaybeNull ClassLoader classLoader,
                        @MaybeNull JavaModule javaModule) {
                    Iterator<ResubmissionOnErrorMatcher> it = this.matchers.iterator();
                    while (it.hasNext()) {
                        if (it.next().matches(th, str, classLoader, javaModule)) {
                            return true;
                        }
                    }
                    return false;
                }

                public Disjunction(List<? extends ResubmissionOnErrorMatcher> list) {
                    this.matchers = new ArrayList(list.size());
                    for (ResubmissionOnErrorMatcher resubmissionOnErrorMatcher : list) {
                        if (resubmissionOnErrorMatcher instanceof Disjunction) {
                            this.matchers.addAll(((Disjunction) resubmissionOnErrorMatcher).matchers);
                        } else if (resubmissionOnErrorMatcher != Trivial.NON_MATCHING) {
                            this.matchers.add(resubmissionOnErrorMatcher);
                        }
                    }
                }
            }

            /*
             * JADX INFO: compiled from:
             * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
             */
            @HashCodeAndEqualsPlugin.Enhance
            public static class ForElementMatchers implements ResubmissionOnErrorMatcher {
                private final ElementMatcher<? super ClassLoader> classLoaderMatcher;
                private final ElementMatcher<? super Throwable> exceptionMatcher;
                private final ElementMatcher<? super JavaModule> moduleMatcher;
                private final ElementMatcher<String> typeNameMatcher;

                public ForElementMatchers(ElementMatcher<? super Throwable> elementMatcher,
                        ElementMatcher<String> elementMatcher2, ElementMatcher<? super ClassLoader> elementMatcher3,
                        ElementMatcher<? super JavaModule> elementMatcher4) {
                    this.exceptionMatcher = elementMatcher;
                    this.typeNameMatcher = elementMatcher2;
                    this.classLoaderMatcher = elementMatcher3;
                    this.moduleMatcher = elementMatcher4;
                }

                public boolean equals(@MaybeNull Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (obj == null || getClass() != obj.getClass()) {
                        return false;
                    }
                    ForElementMatchers forElementMatchers = (ForElementMatchers) obj;
                    return this.exceptionMatcher.equals(forElementMatchers.exceptionMatcher)
                            && this.typeNameMatcher.equals(forElementMatchers.typeNameMatcher)
                            && this.classLoaderMatcher.equals(forElementMatchers.classLoaderMatcher)
                            && this.moduleMatcher.equals(forElementMatchers.moduleMatcher);
                }

                public int hashCode() {
                    return this.moduleMatcher.hashCode() + dkz.i(this.classLoaderMatcher, dkz.i(this.typeNameMatcher,
                            dkz.i(this.exceptionMatcher, getClass().hashCode() * 31, 31), 31), 31);
                }

                @Override // net.bytebuddy.agent.builder.AgentBuilder.RedefinitionListenable.ResubmissionOnErrorMatcher
                public boolean matches(Throwable th, String str, @MaybeNull ClassLoader classLoader,
                        @MaybeNull JavaModule javaModule) {
                    return this.exceptionMatcher.matches(th) && this.typeNameMatcher.matches(str)
                            && this.classLoaderMatcher.matches(classLoader) && this.moduleMatcher.matches(javaModule);
                }
            }

            /*
             * JADX INFO: compiled from:
             * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
             */
            public enum Trivial implements ResubmissionOnErrorMatcher {
                MATCHING(true),
                NON_MATCHING(false);

                private final boolean matching;

                Trivial(boolean z) {
                    this.matching = z;
                }

                @Override // net.bytebuddy.agent.builder.AgentBuilder.RedefinitionListenable.ResubmissionOnErrorMatcher
                public boolean matches(Throwable th, String str, @MaybeNull ClassLoader classLoader,
                        @MaybeNull JavaModule javaModule) {
                    return this.matching;
                }
            }

            boolean matches(Throwable th, String str, @MaybeNull ClassLoader classLoader,
                    @MaybeNull JavaModule javaModule);
        }

        /*
         * JADX INFO: compiled from:
         * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
         */
        public interface WithImplicitDiscoveryStrategy extends RedefinitionListenable {
            RedefinitionListenable redefineOnly(Class<?>... clsArr);

            RedefinitionListenable with(RedefinitionStrategy.DiscoveryStrategy discoveryStrategy);
        }

        /*
         * JADX INFO: compiled from:
         * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
         */
        public interface WithResubmissionSpecification extends WithoutResubmissionSpecification, AgentBuilder {
        }

        /*
         * JADX INFO: compiled from:
         * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
         */
        public interface WithoutBatchStrategy extends WithImplicitDiscoveryStrategy {
            WithImplicitDiscoveryStrategy with(RedefinitionStrategy.BatchAllocator batchAllocator);
        }

        /*
         * JADX INFO: compiled from:
         * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
         */
        public interface WithoutResubmissionSpecification {
            WithResubmissionSpecification resubmitImmediate();

            WithResubmissionSpecification resubmitImmediate(ResubmissionImmediateMatcher resubmissionImmediateMatcher);

            WithResubmissionSpecification resubmitImmediate(ElementMatcher<String> elementMatcher);

            WithResubmissionSpecification resubmitImmediate(ElementMatcher<String> elementMatcher,
                    ElementMatcher<? super ClassLoader> elementMatcher2);

            WithResubmissionSpecification resubmitImmediate(ElementMatcher<String> elementMatcher,
                    ElementMatcher<? super ClassLoader> elementMatcher2,
                    ElementMatcher<? super JavaModule> elementMatcher3);

            WithResubmissionSpecification resubmitOnError();

            WithResubmissionSpecification resubmitOnError(ResubmissionOnErrorMatcher resubmissionOnErrorMatcher);

            WithResubmissionSpecification resubmitOnError(ElementMatcher<? super Throwable> elementMatcher);

            WithResubmissionSpecification resubmitOnError(ElementMatcher<? super Throwable> elementMatcher,
                    ElementMatcher<String> elementMatcher2);

            WithResubmissionSpecification resubmitOnError(ElementMatcher<? super Throwable> elementMatcher,
                    ElementMatcher<String> elementMatcher2, ElementMatcher<? super ClassLoader> elementMatcher3);

            WithResubmissionSpecification resubmitOnError(ElementMatcher<? super Throwable> elementMatcher,
                    ElementMatcher<String> elementMatcher2, ElementMatcher<? super ClassLoader> elementMatcher3,
                    ElementMatcher<? super JavaModule> elementMatcher4);
        }

        RedefinitionListenable with(RedefinitionStrategy.Listener listener);

        WithoutResubmissionSpecification withResubmission(
                RedefinitionStrategy.ResubmissionScheduler resubmissionScheduler);
    }

    /*
     * JADX INFO: compiled from:
     * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
     */
    public enum RedefinitionStrategy {
        DISABLED(0 == true ? 1 : 0, 0 == true ? 1 : 0) { // from class:
                                                         // net.bytebuddy.agent.builder.AgentBuilder.RedefinitionStrategy.1
            @Override // net.bytebuddy.agent.builder.AgentBuilder.RedefinitionStrategy
            public void apply(Instrumentation instrumentation, PoolStrategy poolStrategy,
                    LocationStrategy locationStrategy, DescriptionStrategy descriptionStrategy,
                    FallbackStrategy fallbackStrategy, DiscoveryStrategy discoveryStrategy,
                    LambdaInstrumentationStrategy lambdaInstrumentationStrategy, Listener listener, Listener listener2,
                    RawMatcher rawMatcher, BatchAllocator batchAllocator, CircularityLock circularityLock) {
            }

            @Override // net.bytebuddy.agent.builder.AgentBuilder.RedefinitionStrategy
            public void check(Instrumentation instrumentation) {
                throw new IllegalStateException("Cannot apply redefinition on disabled strategy");
            }

            @Override // net.bytebuddy.agent.builder.AgentBuilder.RedefinitionStrategy
            public Collector make(PoolStrategy poolStrategy, LocationStrategy locationStrategy,
                    DescriptionStrategy descriptionStrategy, FallbackStrategy fallbackStrategy, Listener listener,
                    RawMatcher rawMatcher, CircularityLock circularityLock) {
                throw new IllegalStateException("A disabled redefinition strategy cannot create a collector");
            }
        },
        REDEFINITION(1 == true ? 1 : 0, 0 == true ? 1 : 0) { // from class:
                                                             // net.bytebuddy.agent.builder.AgentBuilder.RedefinitionStrategy.2
            @Override // net.bytebuddy.agent.builder.AgentBuilder.RedefinitionStrategy
            public void check(Instrumentation instrumentation) {
                if (instrumentation.isRedefineClassesSupported()) {
                    return;
                }
                throw new IllegalStateException("Cannot apply redefinition on " + instrumentation);
            }

            @Override // net.bytebuddy.agent.builder.AgentBuilder.RedefinitionStrategy
            public Collector make(PoolStrategy poolStrategy, LocationStrategy locationStrategy,
                    DescriptionStrategy descriptionStrategy, FallbackStrategy fallbackStrategy, Listener listener,
                    RawMatcher rawMatcher, CircularityLock circularityLock) {
                return new Collector.ForRedefinition(rawMatcher, poolStrategy, locationStrategy, descriptionStrategy,
                        listener, fallbackStrategy, circularityLock);
            }
        },
        RETRANSFORMATION(1 == true ? 1 : 0, 1 == true ? 1 : 0) { // from class:
                                                                 // net.bytebuddy.agent.builder.AgentBuilder.RedefinitionStrategy.3
            @Override // net.bytebuddy.agent.builder.AgentBuilder.RedefinitionStrategy
            public void check(Instrumentation instrumentation) {
                if (RedefinitionStrategy.DISPATCHER.isRetransformClassesSupported(instrumentation)) {
                    return;
                }
                throw new IllegalStateException("Cannot apply retransformation on " + instrumentation);
            }

            @Override // net.bytebuddy.agent.builder.AgentBuilder.RedefinitionStrategy
            public Collector make(PoolStrategy poolStrategy, LocationStrategy locationStrategy,
                    DescriptionStrategy descriptionStrategy, FallbackStrategy fallbackStrategy, Listener listener,
                    RawMatcher rawMatcher, CircularityLock circularityLock) {
                return new Collector.ForRetransformation(rawMatcher, poolStrategy, locationStrategy,
                        descriptionStrategy, listener, fallbackStrategy, circularityLock);
            }
        };

        protected static final Dispatcher DISPATCHER = (Dispatcher) Default
                .doPrivileged(JavaDispatcher.of(Dispatcher.class));
        private final boolean enabled;
        private final boolean retransforming;

        /*
         * JADX INFO: compiled from:
         * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
         */
        public interface BatchAllocator {
            public static final int FIRST_BATCH = 0;

            /*
             * JADX INFO: compiled from:
             * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
             */
            @HashCodeAndEqualsPlugin.Enhance
            public static class ForFixedSize implements BatchAllocator {
                private final int size;

                public ForFixedSize(int i) {
                    this.size = i;
                }

                public static BatchAllocator ofSize(int i) {
                    if (i > 0) {
                        return new ForFixedSize(i);
                    }
                    if (i == 0) {
                        return ForTotal.INSTANCE;
                    }
                    throw new IllegalArgumentException(
                            concatVar2Var1(i, "Cannot define a batch with a negative size: "));
                }

                @Override // net.bytebuddy.agent.builder.AgentBuilder.RedefinitionStrategy.BatchAllocator
                public Iterable<? extends List<Class<?>>> batch(List<Class<?>> list) {
                    ArrayList arrayList = new ArrayList();
                    int i = 0;
                    while (i < list.size()) {
                        arrayList.add(new ArrayList(list.subList(i, Math.min(list.size(), this.size + i))));
                        i += this.size;
                    }
                    return arrayList;
                }

                public boolean equals(@MaybeNull Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    return obj != null && getClass() == obj.getClass() && this.size == ((ForFixedSize) obj).size;
                }

                public int hashCode() {
                    return (getClass().hashCode() * 31) + this.size;
                }
            }

            /*
             * JADX INFO: compiled from:
             * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
             */
            @HashCodeAndEqualsPlugin.Enhance
            public static class ForMatchedGrouping implements BatchAllocator {
                private final Collection<? extends ElementMatcher<? super TypeDescription>> matchers;

                @SafeVarargs
                @SafeVarargsPlugin.Enhance
                public ForMatchedGrouping(ElementMatcher<? super TypeDescription>... elementMatcherArr) {
                    this(new LinkedHashSet(Arrays.asList(elementMatcherArr)));
                }

                @Override // net.bytebuddy.agent.builder.AgentBuilder.RedefinitionStrategy.BatchAllocator
                public Iterable<? extends List<Class<?>>> batch(List<Class<?>> list) {
                    LinkedHashMap linkedHashMap = new LinkedHashMap();
                    ArrayList arrayList = new ArrayList();
                    Iterator<? extends ElementMatcher<? super TypeDescription>> it = this.matchers.iterator();
                    while (it.hasNext()) {
                        linkedHashMap.put(it.next(), new ArrayList());
                    }
                    for (Class<?> cls : list) {
                        Iterator<? extends ElementMatcher<? super TypeDescription>> it2 = this.matchers.iterator();
                        while (true) {
                            if (!it2.hasNext()) {
                                arrayList.add(cls);
                                break;
                            }
                            ElementMatcher<? super TypeDescription> next = it2.next();
                            if (next.matches(TypeDescription.ForLoadedType.of(cls))) {
                                ((List) linkedHashMap.get(next)).add(cls);
                                break;
                            }
                        }
                    }
                    ArrayList arrayList2 = new ArrayList(this.matchers.size() + 1);
                    for (List list2 : linkedHashMap.values()) {
                        if (!list2.isEmpty()) {
                            arrayList2.add(list2);
                        }
                    }
                    if (!arrayList.isEmpty()) {
                        arrayList2.add(arrayList);
                    }
                    return arrayList2;
                }

                public boolean equals(@MaybeNull Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    return obj != null && getClass() == obj.getClass()
                            && this.matchers.equals(((ForMatchedGrouping) obj).matchers);
                }

                public int hashCode() {
                    return this.matchers.hashCode() + (getClass().hashCode() * 31);
                }

                public BatchAllocator withMaximum(int i) {
                    return Slicing.withMaximum(i, this);
                }

                public BatchAllocator withMinimum(int i) {
                    return Slicing.withMinimum(i, this);
                }

                public BatchAllocator withinRange(int i, int i2) {
                    return Slicing.withinRange(i, i2, this);
                }

                public ForMatchedGrouping(Collection<? extends ElementMatcher<? super TypeDescription>> collection) {
                    this.matchers = collection;
                }
            }

            /*
             * JADX INFO: compiled from:
             * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
             */
            public enum ForTotal implements BatchAllocator {
                INSTANCE;

                @Override // net.bytebuddy.agent.builder.AgentBuilder.RedefinitionStrategy.BatchAllocator
                public Iterable<? extends List<Class<?>>> batch(List<Class<?>> list) {
                    return list.isEmpty() ? Collections.EMPTY_SET : Collections.singleton(list);
                }
            }

            /*
             * JADX INFO: compiled from:
             * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
             */
            @HashCodeAndEqualsPlugin.Enhance
            public static class Partitioning implements BatchAllocator {
                private final int parts;

                public Partitioning(int i) {
                    this.parts = i;
                }

                public static BatchAllocator of(int i) {
                    if (i >= 1) {
                        return new Partitioning(i);
                    }
                    throw new IllegalArgumentException(concatVar2Var1(i, "A batch size must be positive: "));
                }

                @Override // net.bytebuddy.agent.builder.AgentBuilder.RedefinitionStrategy.BatchAllocator
                public Iterable<? extends List<Class<?>>> batch(List<Class<?>> list) {
                    if (list.isEmpty()) {
                        return Collections.EMPTY_LIST;
                    }
                    ArrayList arrayList = new ArrayList();
                    int size = list.size() / this.parts;
                    int size2 = list.size() % this.parts;
                    int i = size2;
                    while (i < list.size()) {
                        int i2 = i + size;
                        arrayList.add(new ArrayList(list.subList(i, i2)));
                        i = i2;
                    }
                    if (arrayList.isEmpty()) {
                        return Collections.singletonList(list);
                    }
                    ((List) arrayList.get(0)).addAll(0, list.subList(0, size2));
                    return arrayList;
                }

                public boolean equals(@MaybeNull Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    return obj != null && getClass() == obj.getClass() && this.parts == ((Partitioning) obj).parts;
                }

                public int hashCode() {
                    return (getClass().hashCode() * 31) + this.parts;
                }
            }

            /*
             * JADX INFO: compiled from:
             * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
             */
            @HashCodeAndEqualsPlugin.Enhance
            public static class Slicing implements BatchAllocator {
                private final BatchAllocator batchAllocator;
                private final int maximum;
                private final int minimum;

                /*
                 * JADX INFO: compiled from:
                 * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
                 */
                public static class SlicingIterable implements Iterable<List<Class<?>>> {
                    private final Iterable<? extends List<Class<?>>> iterable;
                    private final int maximum;
                    private final int minimum;

                    /*
                     * JADX INFO: compiled from:
                     * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
                     */
                    public static class SlicingIterator implements Iterator<List<Class<?>>> {
                        private List<Class<?>> buffer = new ArrayList();
                        private final Iterator<? extends List<Class<?>>> iterator;
                        private final int maximum;
                        private final int minimum;

                        public SlicingIterator(int i, int i2, Iterator<? extends List<Class<?>>> it) {
                            this.minimum = i;
                            this.maximum = i2;
                            this.iterator = it;
                        }

                        @Override // java.util.Iterator
                        public boolean hasNext() {
                            return !this.buffer.isEmpty() || this.iterator.hasNext();
                        }

                        @Override // java.util.Iterator
                        public void remove() {
                            throw new UnsupportedOperationException("remove");
                        }

                        @Override // java.util.Iterator
                        public List<Class<?>> next() {
                            if (this.buffer.isEmpty()) {
                                this.buffer = this.iterator.next();
                            }
                            while (this.buffer.size() < this.minimum && this.iterator.hasNext()) {
                                this.buffer.addAll(this.iterator.next());
                            }
                            int size = this.buffer.size();
                            int i = this.maximum;
                            if (size <= i) {
                                try {
                                    return this.buffer;
                                } finally {
                                    this.buffer = new ArrayList();
                                }
                            }
                            try {
                                return this.buffer.subList(0, i);
                            } finally {
                                List<Class<?>> list = this.buffer;
                                this.buffer = new ArrayList(list.subList(this.maximum, list.size()));
                            }
                        }
                    }

                    public SlicingIterable(int i, int i2, Iterable<? extends List<Class<?>>> iterable) {
                        this.minimum = i;
                        this.maximum = i2;
                        this.iterable = iterable;
                    }

                    @Override // java.lang.Iterable
                    public Iterator<List<Class<?>>> iterator() {
                        return new SlicingIterator(this.minimum, this.maximum, this.iterable.iterator());
                    }
                }

                public Slicing(int i, int i2, BatchAllocator batchAllocator) {
                    this.minimum = i;
                    this.maximum = i2;
                    this.batchAllocator = batchAllocator;
                }

                public static BatchAllocator withMaximum(int i, BatchAllocator batchAllocator) {
                    return withinRange(1, i, batchAllocator);
                }

                public static BatchAllocator withMinimum(int i, BatchAllocator batchAllocator) {
                    return withinRange(i, Integer.MAX_VALUE, batchAllocator);
                }

                public static BatchAllocator withinRange(int i, int i2, BatchAllocator batchAllocator) {
                    if (i <= 0) {
                        throw new IllegalArgumentException(concatVar2Var1(i, "Minimum must be a positive number: "));
                    }
                    if (i <= i2) {
                        return new Slicing(i, i2, batchAllocator);
                    }
                    throw new IllegalArgumentException(dkz.p(i, "Minimum must not be bigger than maximum: ", " >", i2));
                }

                @Override // net.bytebuddy.agent.builder.AgentBuilder.RedefinitionStrategy.BatchAllocator
                public Iterable<? extends List<Class<?>>> batch(List<Class<?>> list) {
                    return new SlicingIterable(this.minimum, this.maximum, this.batchAllocator.batch(list));
                }

                public boolean equals(@MaybeNull Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (obj == null || getClass() != obj.getClass()) {
                        return false;
                    }
                    Slicing slicing = (Slicing) obj;
                    return this.minimum == slicing.minimum && this.maximum == slicing.maximum
                            && this.batchAllocator.equals(slicing.batchAllocator);
                }

                public int hashCode() {
                    return this.batchAllocator.hashCode()
                            + (((((getClass().hashCode() * 31) + this.minimum) * 31) + this.maximum) * 31);
                }
            }

            Iterable<? extends List<Class<?>>> batch(List<Class<?>> list);
        }

        /*
         * JADX INFO: compiled from:
         * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
         */
        public static abstract class Collector {
            protected final CircularityLock circularityLock;
            private final DescriptionStrategy descriptionStrategy;
            private final FallbackStrategy fallbackStrategy;
            protected final Listener listener;
            protected final LocationStrategy locationStrategy;
            private final RawMatcher matcher;
            private final PoolStrategy poolStrategy;
            protected final List<Class<?>> types = new ArrayList();

            /*
             * JADX INFO: compiled from:
             * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
             */
            public static class ForRedefinition extends Collector {
                public ForRedefinition(RawMatcher rawMatcher, PoolStrategy poolStrategy,
                        LocationStrategy locationStrategy, DescriptionStrategy descriptionStrategy, Listener listener,
                        FallbackStrategy fallbackStrategy, CircularityLock circularityLock) {
                    super(rawMatcher, poolStrategy, locationStrategy, descriptionStrategy, listener, fallbackStrategy,
                            circularityLock);
                }

                /*
                 * JADX WARN: Undo finally extract visitor
                 * java.lang.NullPointerException
                 * at java.base/java.util.Objects.requireNonNull(Objects.java:209)
                 * at java.base/java.util.ArrayList.batchRemove(ArrayList.java:816)
                 * at java.base/java.util.ArrayList.removeAll(ArrayList.java:791)
                 * at jadx.core.dex.visitors.finaly.TryCatchEdgeBlockMap.getAllInScope(
                 * TryCatchEdgeBlockMap.java:91)
                 * at jadx.core.dex.visitors.finaly.MarkFinallyVisitor.getTryBlockData(
                 * MarkFinallyVisitor.java:204)
                 * at jadx.core.dex.visitors.finaly.MarkFinallyVisitor.visit(MarkFinallyVisitor.
                 * java:119)
                 */
                @Override // net.bytebuddy.agent.builder.AgentBuilder.RedefinitionStrategy.Collector
                public void doApply(Instrumentation instrumentation, List<Class<?>> list) {
                    ArrayList arrayList = new ArrayList(list.size());
                    for (Class<?> cls : list) {
                        try {
                            arrayList.add(new ClassDefinition(cls,
                                    this.locationStrategy.classFileLocator(cls.getClassLoader(), JavaModule.ofType(cls))
                                            .locate(TypeDescription.ForLoadedType.getName(cls)).resolve()));
                        } catch (Throwable th) {
                            try {
                                JavaModule javaModuleOfType = JavaModule.ofType(cls);
                                try {
                                    this.listener.onDiscovery(TypeDescription.ForLoadedType.getName(cls),
                                            cls.getClassLoader(), javaModuleOfType, true);
                                    try {
                                        this.listener.onError(TypeDescription.ForLoadedType.getName(cls),
                                                cls.getClassLoader(), javaModuleOfType, true, th);
                                        this.listener.onComplete(TypeDescription.ForLoadedType.getName(cls),
                                                cls.getClassLoader(), javaModuleOfType, true);
                                    } catch (Throwable th2) {
                                        this.listener.onComplete(TypeDescription.ForLoadedType.getName(cls),
                                                cls.getClassLoader(), javaModuleOfType, true);
                                        throw th2;
                                    }
                                } catch (Throwable th3) {
                                    try {
                                        this.listener.onError(TypeDescription.ForLoadedType.getName(cls),
                                                cls.getClassLoader(), javaModuleOfType, true, th);
                                        this.listener.onComplete(TypeDescription.ForLoadedType.getName(cls),
                                                cls.getClassLoader(), javaModuleOfType, true);
                                        throw th3;
                                    } catch (Throwable th4) {
                                        this.listener.onComplete(TypeDescription.ForLoadedType.getName(cls),
                                                cls.getClassLoader(), javaModuleOfType, true);
                                        throw th4;
                                    }
                                }
                            } catch (Throwable unused) {
                                continue;
                            }
                        }
                    }
                    if (arrayList.isEmpty()) {
                        return;
                    }
                    this.circularityLock.release();
                    try {
                        instrumentation.redefineClasses((ClassDefinition[]) arrayList.toArray(new ClassDefinition[0]));
                        this.circularityLock.acquire();
                    } catch (Throwable th5) {
                        this.circularityLock.acquire();
                        throw th5;
                    }
                }
            }

            /*
             * JADX INFO: compiled from:
             * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
             */
            public static class ForRetransformation extends Collector {
                public ForRetransformation(RawMatcher rawMatcher, PoolStrategy poolStrategy,
                        LocationStrategy locationStrategy, DescriptionStrategy descriptionStrategy, Listener listener,
                        FallbackStrategy fallbackStrategy, CircularityLock circularityLock) {
                    super(rawMatcher, poolStrategy, locationStrategy, descriptionStrategy, listener, fallbackStrategy,
                            circularityLock);
                }

                @Override // net.bytebuddy.agent.builder.AgentBuilder.RedefinitionStrategy.Collector
                public void doApply(Instrumentation instrumentation, List<Class<?>> list) {
                    if (list.isEmpty()) {
                        return;
                    }
                    this.circularityLock.release();
                    try {
                        RedefinitionStrategy.DISPATCHER.retransformClasses(instrumentation,
                                (Class[]) list.toArray(new Class[0]));
                    } finally {
                        this.circularityLock.acquire();
                    }
                }
            }

            /*
             * JADX INFO: compiled from:
             * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
             */
            public static class PrependableIterator implements Iterator<List<Class<?>>> {
                private final List<Iterator<? extends List<Class<?>>>> backlog = new ArrayList();
                private Iterator<? extends List<Class<?>>> current;

                public PrependableIterator(Iterable<? extends List<Class<?>>> iterable) {
                    this.current = iterable.iterator();
                }

                @Override // java.util.Iterator
                public boolean hasNext() {
                    return this.current.hasNext();
                }

                public void prepend(Iterable<? extends List<Class<?>>> iterable) {
                    Iterator<? extends List<Class<?>>> it = iterable.iterator();
                    if (it.hasNext()) {
                        if (this.current.hasNext()) {
                            this.backlog.add(this.current);
                        }
                        this.current = it;
                    }
                }

                @Override // java.util.Iterator
                public void remove() {
                    throw new UnsupportedOperationException("remove");
                }

                @Override // java.util.Iterator
                public List<Class<?>> next() {
                    boolean zIsEmpty;
                    try {
                        List<Class<?>> next = this.current.next();
                        while (!zHasNext) {
                            if (zIsEmpty) {
                                break;
                            }
                            this.current = this.backlog.remove(r1.size() - 1);
                        }
                        return next;
                    } finally {
                        while (!this.current.hasNext() && !this.backlog.isEmpty()) {
                            this.current = this.backlog.remove(r1.size() - 1);
                        }
                    }
                }
            }

            public Collector(RawMatcher rawMatcher, PoolStrategy poolStrategy, LocationStrategy locationStrategy,
                    DescriptionStrategy descriptionStrategy, Listener listener, FallbackStrategy fallbackStrategy,
                    CircularityLock circularityLock) {
                this.matcher = rawMatcher;
                this.poolStrategy = poolStrategy;
                this.locationStrategy = locationStrategy;
                this.descriptionStrategy = descriptionStrategy;
                this.listener = listener;
                this.fallbackStrategy = fallbackStrategy;
                this.circularityLock = circularityLock;
            }

            private void doConsider(RawMatcher rawMatcher, Listener listener, TypeDescription typeDescription,
                    Class<?> cls, @MaybeNull Class<?> cls2, @MaybeNull JavaModule javaModule, boolean z) {
                String name;
                ClassLoader classLoader;
                if (z && rawMatcher.matches(typeDescription, cls.getClassLoader(), javaModule, cls2,
                        cls.getProtectionDomain())) {
                    this.types.add(cls);
                    return;
                }
                try {
                    try {
                        listener.onDiscovery(TypeDescription.ForLoadedType.getName(cls), cls.getClassLoader(),
                                javaModule, cls2 != null);
                        listener.onIgnored(typeDescription, cls.getClassLoader(), javaModule, cls2 != null);
                        name = TypeDescription.ForLoadedType.getName(cls);
                        classLoader = cls.getClassLoader();
                    } catch (Throwable th) {
                        try {
                            listener.onError(TypeDescription.ForLoadedType.getName(cls), cls.getClassLoader(),
                                    javaModule, cls2 != null, th);
                            name = TypeDescription.ForLoadedType.getName(cls);
                            classLoader = cls.getClassLoader();
                            if (cls2 != null) {
                            }
                        } catch (Throwable th2) {
                            listener.onComplete(TypeDescription.ForLoadedType.getName(cls), cls.getClassLoader(),
                                    javaModule, cls2 != null);
                            throw th2;
                        }
                    }
                    if (cls2 != null) {
                        z = true;
                    }
                    listener.onComplete(name, classLoader, javaModule, z);
                } catch (Throwable unused) {
                }
            }

            public int apply(Instrumentation instrumentation, BatchAllocator batchAllocator, Listener listener, int i) {
                HashMap map = new HashMap();
                PrependableIterator prependableIterator = new PrependableIterator(batchAllocator.batch(this.types));
                while (prependableIterator.hasNext()) {
                    List<Class<?>> next = prependableIterator.next();
                    listener.onBatch(i, next, this.types);
                    try {
                        doApply(instrumentation, next);
                    } catch (Throwable th) {
                        prependableIterator.prepend(listener.onError(i, next, th, this.types));
                        map.put(next, th);
                    }
                    i++;
                }
                listener.onComplete(i, this.types, map);
                return i;
            }

            /* JADX WARN: Found duplicated region for block: B:40:0x008a */
            public void consider(Class<?> cls, boolean z) {
                Class<?> cls2;
                Collector collector;
                Throwable th;
                Class<?> cls3;
                TypePool typePool;
                Collector collector2;
                Throwable th2;
                RawMatcher rawMatcher;
                Listener listener;
                TypeDescription typeDescriptionApply;
                JavaModule javaModuleOfType = JavaModule.ofType(cls);
                try {
                    TypePool typePool2 = this.poolStrategy.typePool(
                            this.locationStrategy.classFileLocator(cls.getClassLoader(), javaModuleOfType),
                            cls.getClassLoader());
                    try {
                        rawMatcher = this.matcher;
                        listener = this.listener;
                        try {
                            try {
                                typeDescriptionApply = this.descriptionStrategy.apply(
                                        TypeDescription.ForLoadedType.getName(cls), cls, typePool2,
                                        this.circularityLock, cls.getClassLoader(), javaModuleOfType);
                                cls3 = cls;
                                typePool = typePool2;
                                collector2 = this;
                            } catch (Throwable th3) {
                                th = th3;
                                collector2 = this;
                                cls3 = cls;
                                typePool = typePool2;
                                javaModuleOfType = javaModuleOfType;
                                th2 = th;
                                try {
                                    if (collector2.descriptionStrategy.isLoadedFirst()
                                            || !collector2.fallbackStrategy.isFallback(cls3, th2)) {
                                        collector = collector2;
                                        cls2 = cls3;
                                        try {
                                            throw th2;
                                        } catch (Throwable th4) {
                                            th = th4;
                                            th = th;
                                            try {
                                                collector.listener.onDiscovery(
                                                        TypeDescription.ForLoadedType.getName(cls2),
                                                        cls2.getClassLoader(), javaModuleOfType, true);
                                                collector.listener.onError(TypeDescription.ForLoadedType.getName(cls2),
                                                        cls2.getClassLoader(), javaModuleOfType, true, th);
                                            } catch (Throwable th5) {
                                                try {
                                                    collector.listener.onError(
                                                            TypeDescription.ForLoadedType.getName(cls2),
                                                            cls2.getClassLoader(), javaModuleOfType, true, th);
                                                    throw th5;
                                                } finally {
                                                    collector.listener.onComplete(
                                                            TypeDescription.ForLoadedType.getName(cls2),
                                                            cls2.getClassLoader(), javaModuleOfType, true);
                                                }
                                            }
                                        }
                                    }
                                    JavaModule javaModule = javaModuleOfType;
                                    try {
                                    } catch (Throwable th6) {
                                        th = th6;
                                        collector = collector2;
                                        javaModuleOfType = javaModule;
                                        cls2 = cls3;
                                        th = th;
                                        collector.listener.onDiscovery(TypeDescription.ForLoadedType.getName(cls2),
                                                cls2.getClassLoader(), javaModuleOfType, true);
                                        collector.listener.onError(TypeDescription.ForLoadedType.getName(cls2),
                                                cls2.getClassLoader(), javaModuleOfType, true, th);
                                    }
                                    try {
                                        collector2.doConsider(collector2.matcher, collector2.listener, typePool
                                                .describe(TypeDescription.ForLoadedType.getName(cls3)).resolve(), cls3,
                                                null, javaModule, true);
                                        return;
                                    } catch (Throwable th7) {
                                        th = th7;
                                        collector = collector2;
                                        cls2 = cls3;
                                        javaModuleOfType = javaModule;
                                        th = th;
                                        collector.listener.onDiscovery(TypeDescription.ForLoadedType.getName(cls2),
                                                cls2.getClassLoader(), javaModuleOfType, true);
                                        collector.listener.onError(TypeDescription.ForLoadedType.getName(cls2),
                                                cls2.getClassLoader(), javaModuleOfType, true, th);
                                    }
                                } catch (Throwable th8) {
                                    th = th8;
                                    collector = collector2;
                                }
                                th = th;
                                try {
                                    collector.listener.onDiscovery(TypeDescription.ForLoadedType.getName(cls2),
                                            cls2.getClassLoader(), javaModuleOfType, true);
                                    try {
                                        collector.listener.onError(TypeDescription.ForLoadedType.getName(cls2),
                                                cls2.getClassLoader(), javaModuleOfType, true, th);
                                    } finally {
                                        collector.listener.onComplete(TypeDescription.ForLoadedType.getName(cls2),
                                                cls2.getClassLoader(), javaModuleOfType, true);
                                    }
                                } catch (Throwable unused) {
                                    return;
                                }
                            }
                        } catch (Throwable th9) {
                            th = th9;
                            collector2 = this;
                            cls3 = cls;
                        }
                    } catch (Throwable th10) {
                        th = th10;
                        cls3 = cls;
                        typePool = typePool2;
                        collector2 = this;
                    }
                    try {
                        collector2.doConsider(rawMatcher, listener, typeDescriptionApply, cls3, cls3, javaModuleOfType,
                                z);
                    } catch (Throwable th11) {
                        th = th11;
                        javaModuleOfType = javaModuleOfType;
                        th2 = th;
                        if (collector2.descriptionStrategy.isLoadedFirst()) {
                            collector = collector2;
                            cls2 = cls3;
                            throw th2;
                        }
                        collector = collector2;
                        cls2 = cls3;
                        throw th2;
                        th = th;
                        collector.listener.onDiscovery(TypeDescription.ForLoadedType.getName(cls2),
                                cls2.getClassLoader(), javaModuleOfType, true);
                        collector.listener.onError(TypeDescription.ForLoadedType.getName(cls2), cls2.getClassLoader(),
                                javaModuleOfType, true, th);
                    }
                } catch (Throwable th12) {
                    th = th12;
                    cls2 = cls;
                    collector = this;
                }
            }

            public abstract void doApply(Instrumentation instrumentation, List<Class<?>> list);
        }

        /*
         * JADX INFO: compiled from:
         * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
         */
        public interface DiscoveryStrategy {

            /*
             * JADX INFO: compiled from:
             * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
             */
            @HashCodeAndEqualsPlugin.Enhance
            public static class Explicit implements DiscoveryStrategy {
                private final Set<Class<?>> types;

                public Explicit(Class<?>... clsArr) {
                    this(new LinkedHashSet(Arrays.asList(clsArr)));
                }

                public boolean equals(@MaybeNull Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    return obj != null && getClass() == obj.getClass() && this.types.equals(((Explicit) obj).types);
                }

                public int hashCode() {
                    return this.types.hashCode() + (getClass().hashCode() * 31);
                }

                @Override // net.bytebuddy.agent.builder.AgentBuilder.RedefinitionStrategy.DiscoveryStrategy
                public Iterable<Iterable<Class<?>>> resolve(Instrumentation instrumentation) {
                    return Collections.singleton(this.types);
                }

                public Explicit(Set<Class<?>> set) {
                    this.types = set;
                }
            }

            /*
             * JADX INFO: compiled from:
             * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
             */
            public enum Reiterating implements DiscoveryStrategy {
                INSTANCE;

                /*
                 * JADX INFO: compiled from:
                 * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
                 */
                @HashCodeAndEqualsPlugin.Enhance
                public static class ReiteratingIterable implements Iterable<Iterable<Class<?>>> {
                    private final Instrumentation instrumentation;

                    public ReiteratingIterable(Instrumentation instrumentation) {
                        this.instrumentation = instrumentation;
                    }

                    public boolean equals(@MaybeNull Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        return obj != null && getClass() == obj.getClass()
                                && this.instrumentation.equals(((ReiteratingIterable) obj).instrumentation);
                    }

                    public int hashCode() {
                        return this.instrumentation.hashCode() + (getClass().hashCode() * 31);
                    }

                    @Override // java.lang.Iterable
                    public Iterator<Iterable<Class<?>>> iterator() {
                        return new ReiteratingIterator(this.instrumentation);
                    }
                }

                /*
                 * JADX INFO: compiled from:
                 * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
                 */
                public static class ReiteratingIterator implements Iterator<Iterable<Class<?>>> {
                    private final Instrumentation instrumentation;
                    private final Set<Class<?>> processed = new HashSet();

                    @MaybeNull
                    private List<Class<?>> types;

                    public ReiteratingIterator(Instrumentation instrumentation) {
                        this.instrumentation = instrumentation;
                    }

                    @Override // java.util.Iterator
                    public boolean hasNext() {
                        if (this.types == null) {
                            this.types = new ArrayList();
                            for (Class<?> cls : this.instrumentation.getAllLoadedClasses()) {
                                if (cls != null && this.processed.add(cls)) {
                                    this.types.add(cls);
                                }
                            }
                        }
                        return !this.types.isEmpty();
                    }

                    @Override // java.util.Iterator
                    public void remove() {
                        throw new UnsupportedOperationException("remove");
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // java.util.Iterator
                    public Iterable<Class<?>> next() {
                        if (!hasNext()) {
                            throw new NoSuchElementException();
                        }
                        try {
                            return this.types;
                        } finally {
                            this.types = null;
                        }
                    }
                }

                /*
                 * JADX INFO: compiled from:
                 * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
                 */
                public enum WithSortOrderAssumption implements DiscoveryStrategy {
                    INSTANCE;

                    /*
                     * JADX INFO: compiled from:
                     * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
                     */
                    @HashCodeAndEqualsPlugin.Enhance
                    public static class OrderedReiteratingIterable implements Iterable<Iterable<Class<?>>> {
                        private final Instrumentation instrumentation;

                        public OrderedReiteratingIterable(Instrumentation instrumentation) {
                            this.instrumentation = instrumentation;
                        }

                        public boolean equals(@MaybeNull Object obj) {
                            if (this == obj) {
                                return true;
                            }
                            return obj != null && getClass() == obj.getClass()
                                    && this.instrumentation.equals(((OrderedReiteratingIterable) obj).instrumentation);
                        }

                        public int hashCode() {
                            return this.instrumentation.hashCode() + (getClass().hashCode() * 31);
                        }

                        @Override // java.lang.Iterable
                        public Iterator<Iterable<Class<?>>> iterator() {
                            return new OrderedReiteratingIterator(this.instrumentation);
                        }
                    }

                    /*
                     * JADX INFO: compiled from:
                     * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
                     */
                    public static class OrderedReiteratingIterator implements Iterator<Iterable<Class<?>>> {
                        private int index = 0;
                        private final Instrumentation instrumentation;

                        @MaybeNull
                        private List<Class<?>> types;

                        public OrderedReiteratingIterator(Instrumentation instrumentation) {
                            this.instrumentation = instrumentation;
                        }

                        @Override // java.util.Iterator
                        public boolean hasNext() {
                            if (this.types == null) {
                                Class[] allLoadedClasses = this.instrumentation.getAllLoadedClasses();
                                this.types = new ArrayList(
                                        Arrays.asList(allLoadedClasses).subList(this.index, allLoadedClasses.length));
                                this.index = allLoadedClasses.length;
                            }
                            return !this.types.isEmpty();
                        }

                        @Override // java.util.Iterator
                        public void remove() {
                            throw new UnsupportedOperationException("remove");
                        }

                        /* JADX WARN: Can't rename method to resolve collision */
                        @Override // java.util.Iterator
                        public Iterable<Class<?>> next() {
                            if (!hasNext()) {
                                throw new NoSuchElementException();
                            }
                            try {
                                return this.types;
                            } finally {
                                this.types = null;
                            }
                        }
                    }

                    @Override // net.bytebuddy.agent.builder.AgentBuilder.RedefinitionStrategy.DiscoveryStrategy
                    public Iterable<Iterable<Class<?>>> resolve(Instrumentation instrumentation) {
                        return new OrderedReiteratingIterable(instrumentation);
                    }
                }

                @Override // net.bytebuddy.agent.builder.AgentBuilder.RedefinitionStrategy.DiscoveryStrategy
                public Iterable<Iterable<Class<?>>> resolve(Instrumentation instrumentation) {
                    return new ReiteratingIterable(instrumentation);
                }
            }

            /*
             * JADX INFO: compiled from:
             * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
             */
            public enum SinglePass implements DiscoveryStrategy {
                INSTANCE;

                @Override // net.bytebuddy.agent.builder.AgentBuilder.RedefinitionStrategy.DiscoveryStrategy
                public Iterable<Iterable<Class<?>>> resolve(Instrumentation instrumentation) {
                    return Collections.singleton(Arrays.asList(instrumentation.getAllLoadedClasses()));
                }
            }

            Iterable<Iterable<Class<?>>> resolve(Instrumentation instrumentation);
        }

        /*
         * JADX INFO: compiled from:
         * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
         */
        @JavaDispatcher.Proxied("java.lang.instrument.Instrumentation")
        public interface Dispatcher {
            @JavaDispatcher.Proxied("isModifiableClass")
            boolean isModifiableClass(Instrumentation instrumentation, Class<?> cls);

            @JavaDispatcher.Defaults
            @JavaDispatcher.Proxied("isRetransformClassesSupported")
            boolean isRetransformClassesSupported(Instrumentation instrumentation);

            @JavaDispatcher.Proxied("retransformClasses")
            void retransformClasses(Instrumentation instrumentation, Class<?>[] clsArr);
        }

        /*
         * JADX INFO: compiled from:
         * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
         */
        public interface Listener {

            /*
             * JADX INFO: compiled from:
             * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
             */
            @HashCodeAndEqualsPlugin.Enhance
            public static abstract class Adapter implements Listener {
                public boolean equals(@MaybeNull Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    return obj != null && getClass() == obj.getClass();
                }

                public int hashCode() {
                    return getClass().hashCode();
                }

                @Override // net.bytebuddy.agent.builder.AgentBuilder.RedefinitionStrategy.Listener
                public void onBatch(int i, List<Class<?>> list, List<Class<?>> list2) {
                }

                @Override // net.bytebuddy.agent.builder.AgentBuilder.RedefinitionStrategy.Listener
                public void onComplete(int i, List<Class<?>> list, Map<List<Class<?>>, Throwable> map) {
                }

                @Override // net.bytebuddy.agent.builder.AgentBuilder.RedefinitionStrategy.Listener
                public Iterable<? extends List<Class<?>>> onError(int i, List<Class<?>> list, Throwable th,
                        List<Class<?>> list2) {
                    return Collections.EMPTY_LIST;
                }
            }

            /*
             * JADX INFO: compiled from:
             * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
             */
            @HashCodeAndEqualsPlugin.Enhance
            public static class BatchReallocator extends Adapter {
                private final BatchAllocator batchAllocator;

                public BatchReallocator(BatchAllocator batchAllocator) {
                    this.batchAllocator = batchAllocator;
                }

                public static Listener splitting() {
                    return new BatchReallocator(new BatchAllocator.Partitioning(2));
                }

                @Override // net.bytebuddy.agent.builder.AgentBuilder.RedefinitionStrategy.Listener.Adapter
                public boolean equals(@MaybeNull Object obj) {
                    if (!super.equals(obj)) {
                        return false;
                    }
                    if (this == obj) {
                        return true;
                    }
                    return obj != null && getClass() == obj.getClass()
                            && this.batchAllocator.equals(((BatchReallocator) obj).batchAllocator);
                }

                @Override // net.bytebuddy.agent.builder.AgentBuilder.RedefinitionStrategy.Listener.Adapter
                public int hashCode() {
                    return this.batchAllocator.hashCode() + (super.hashCode() * 31);
                }

                @Override // net.bytebuddy.agent.builder.AgentBuilder.RedefinitionStrategy.Listener.Adapter,
                          // net.bytebuddy.agent.builder.AgentBuilder.RedefinitionStrategy.Listener
                public Iterable<? extends List<Class<?>>> onError(int i, List<Class<?>> list, Throwable th,
                        List<Class<?>> list2) {
                    return list.size() < 2 ? Collections.EMPTY_LIST : this.batchAllocator.batch(list);
                }
            }

            /*
             * JADX INFO: compiled from:
             * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
             */
            @HashCodeAndEqualsPlugin.Enhance
            public static class Compound implements Listener {
                private final List<Listener> listeners;

                /*
                 * JADX INFO: compiled from:
                 * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
                 */
                @HashCodeAndEqualsPlugin.Enhance
                public static class CompoundIterable implements Iterable<List<Class<?>>> {
                    private final List<Iterable<? extends List<Class<?>>>> iterables;

                    /*
                     * JADX INFO: compiled from:
                     * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
                     */
                    public static class CompoundIterator implements Iterator<List<Class<?>>> {
                        private final List<Iterable<? extends List<Class<?>>>> backlog;

                        @MaybeNull
                        private Iterator<? extends List<Class<?>>> current;

                        public CompoundIterator(List<Iterable<? extends List<Class<?>>>> list) {
                            this.backlog = list;
                            forward();
                        }

                        private void forward() {
                            while (true) {
                                Iterator<? extends List<Class<?>>> it = this.current;
                                if ((it != null && it.hasNext()) || this.backlog.isEmpty()) {
                                    return;
                                } else {
                                    this.current = this.backlog.remove(0).iterator();
                                }
                            }
                        }

                        @Override // java.util.Iterator
                        public boolean hasNext() {
                            Iterator<? extends List<Class<?>>> it = this.current;
                            return it != null && it.hasNext();
                        }

                        @Override // java.util.Iterator
                        public void remove() {
                            throw new UnsupportedOperationException("remove");
                        }

                        @Override // java.util.Iterator
                        public List<Class<?>> next() {
                            try {
                                Iterator<? extends List<Class<?>>> it = this.current;
                                if (it == null) {
                                    throw new NoSuchElementException();
                                }
                                List<Class<?>> next = it.next();
                                forward();
                                return next;
                            } catch (Throwable th) {
                                forward();
                                throw th;
                            }
                        }
                    }

                    public CompoundIterable(List<Iterable<? extends List<Class<?>>>> list) {
                        this.iterables = list;
                    }

                    public boolean equals(@MaybeNull Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        return obj != null && getClass() == obj.getClass()
                                && this.iterables.equals(((CompoundIterable) obj).iterables);
                    }

                    public int hashCode() {
                        return this.iterables.hashCode() + (getClass().hashCode() * 31);
                    }

                    @Override // java.lang.Iterable
                    public Iterator<List<Class<?>>> iterator() {
                        return new CompoundIterator(new ArrayList(this.iterables));
                    }
                }

                public Compound(Listener... listenerArr) {
                    this((List<? extends Listener>) Arrays.asList(listenerArr));
                }

                public boolean equals(@MaybeNull Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    return obj != null && getClass() == obj.getClass()
                            && this.listeners.equals(((Compound) obj).listeners);
                }

                public int hashCode() {
                    return this.listeners.hashCode() + (getClass().hashCode() * 31);
                }

                @Override // net.bytebuddy.agent.builder.AgentBuilder.RedefinitionStrategy.Listener
                public void onBatch(int i, List<Class<?>> list, List<Class<?>> list2) {
                    Iterator<Listener> it = this.listeners.iterator();
                    while (it.hasNext()) {
                        it.next().onBatch(i, list, list2);
                    }
                }

                @Override // net.bytebuddy.agent.builder.AgentBuilder.RedefinitionStrategy.Listener
                public void onComplete(int i, List<Class<?>> list, Map<List<Class<?>>, Throwable> map) {
                    Iterator<Listener> it = this.listeners.iterator();
                    while (it.hasNext()) {
                        it.next().onComplete(i, list, map);
                    }
                }

                @Override // net.bytebuddy.agent.builder.AgentBuilder.RedefinitionStrategy.Listener
                public Iterable<? extends List<Class<?>>> onError(int i, List<Class<?>> list, Throwable th,
                        List<Class<?>> list2) {
                    ArrayList arrayList = new ArrayList();
                    Iterator<Listener> it = this.listeners.iterator();
                    while (it.hasNext()) {
                        arrayList.add(it.next().onError(i, list, th, list2));
                    }
                    return new CompoundIterable(arrayList);
                }

                public Compound(List<? extends Listener> list) {
                    this.listeners = new ArrayList();
                    for (Listener listener : list) {
                        if (listener instanceof Compound) {
                            this.listeners.addAll(((Compound) listener).listeners);
                        } else if (!(listener instanceof NoOp)) {
                            this.listeners.add(listener);
                        }
                    }
                }
            }

            /*
             * JADX INFO: compiled from:
             * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
             */
            public enum ErrorEscalating implements Listener {
                FAIL_FAST { // from class:
                            // net.bytebuddy.agent.builder.AgentBuilder.RedefinitionStrategy.Listener.ErrorEscalating.1
                    @Override // net.bytebuddy.agent.builder.AgentBuilder.RedefinitionStrategy.Listener
                    public void onComplete(int i, List<Class<?>> list, Map<List<Class<?>>, Throwable> map) {
                    }

                    @Override // net.bytebuddy.agent.builder.AgentBuilder.RedefinitionStrategy.Listener
                    public Iterable<? extends List<Class<?>>> onError(int i, List<Class<?>> list, Throwable th,
                            List<Class<?>> list2) {
                        throw new IllegalStateException("Could not transform any of " + list, th);
                    }
                },
                FAIL_LAST { // from class:
                            // net.bytebuddy.agent.builder.AgentBuilder.RedefinitionStrategy.Listener.ErrorEscalating.2
                    @Override // net.bytebuddy.agent.builder.AgentBuilder.RedefinitionStrategy.Listener
                    public void onComplete(int i, List<Class<?>> list, Map<List<Class<?>>, Throwable> map) {
                        if (map.isEmpty()) {
                            return;
                        }
                        throw new IllegalStateException("Could not transform any of " + map);
                    }

                    @Override // net.bytebuddy.agent.builder.AgentBuilder.RedefinitionStrategy.Listener
                    public Iterable<? extends List<Class<?>>> onError(int i, List<Class<?>> list, Throwable th,
                            List<Class<?>> list2) {
                        return Collections.EMPTY_LIST;
                    }
                };

                @Override // net.bytebuddy.agent.builder.AgentBuilder.RedefinitionStrategy.Listener
                public void onBatch(int i, List<Class<?>> list, List<Class<?>> list2) {
                }
            }

            /*
             * JADX INFO: compiled from:
             * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
             */
            public enum NoOp implements Listener {
                INSTANCE;

                @Override // net.bytebuddy.agent.builder.AgentBuilder.RedefinitionStrategy.Listener
                public void onBatch(int i, List<Class<?>> list, List<Class<?>> list2) {
                }

                @Override // net.bytebuddy.agent.builder.AgentBuilder.RedefinitionStrategy.Listener
                public void onComplete(int i, List<Class<?>> list, Map<List<Class<?>>, Throwable> map) {
                }

                @Override // net.bytebuddy.agent.builder.AgentBuilder.RedefinitionStrategy.Listener
                public Iterable<? extends List<Class<?>>> onError(int i, List<Class<?>> list, Throwable th,
                        List<Class<?>> list2) {
                    return Collections.EMPTY_LIST;
                }
            }

            /*
             * JADX INFO: compiled from:
             * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
             */
            @HashCodeAndEqualsPlugin.Enhance
            public static class Pausing extends Adapter {
                private final long value;

                public Pausing(long j) {
                    this.value = j;
                }

                public static Listener of(long j, TimeUnit timeUnit) {
                    if (j > 0) {
                        return new Pausing(timeUnit.toMillis(j));
                    }
                    if (j == 0) {
                        return NoOp.INSTANCE;
                    }
                    throw new IllegalArgumentException(dts.b(j, "Cannot sleep for a non-positive amount of time: "));
                }

                @Override // net.bytebuddy.agent.builder.AgentBuilder.RedefinitionStrategy.Listener.Adapter
                public boolean equals(@MaybeNull Object obj) {
                    if (!super.equals(obj)) {
                        return false;
                    }
                    if (this == obj) {
                        return true;
                    }
                    return obj != null && getClass() == obj.getClass() && this.value == ((Pausing) obj).value;
                }

                @Override // net.bytebuddy.agent.builder.AgentBuilder.RedefinitionStrategy.Listener.Adapter
                public int hashCode() {
                    int iHashCode = super.hashCode() * 31;
                    long j = this.value;
                    return iHashCode + ((int) (j ^ (j >>> 32)));
                }

                @Override // net.bytebuddy.agent.builder.AgentBuilder.RedefinitionStrategy.Listener.Adapter,
                          // net.bytebuddy.agent.builder.AgentBuilder.RedefinitionStrategy.Listener
                public void onBatch(int i, List<Class<?>> list, List<Class<?>> list2) {
                    if (i > 0) {
                        try {
                            Thread.sleep(this.value);
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                            throw new IllegalStateException(e);
                        }
                    }
                }
            }

            /*
             * JADX INFO: compiled from:
             * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
             */
            @HashCodeAndEqualsPlugin.Enhance
            public static class StreamWriting implements Listener {
                private final PrintStream printStream;

                public StreamWriting(PrintStream printStream) {
                    this.printStream = printStream;
                }

                public static Listener toSystemError() {
                    return new StreamWriting(System.err);
                }

                public static Listener toSystemOut() {
                    return new StreamWriting(System.out);
                }

                public boolean equals(@MaybeNull Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    return obj != null && getClass() == obj.getClass()
                            && this.printStream.equals(((StreamWriting) obj).printStream);
                }

                public int hashCode() {
                    return this.printStream.hashCode() + (getClass().hashCode() * 31);
                }

                @Override // net.bytebuddy.agent.builder.AgentBuilder.RedefinitionStrategy.Listener
                public void onBatch(int i, List<Class<?>> list, List<Class<?>> list2) {
                    this.printStream.printf("[Byte Buddy] REDEFINE BATCH #%d [%d of %d type(s)]%n", Integer.valueOf(i),
                            Integer.valueOf(list.size()), Integer.valueOf(list2.size()));
                }

                @Override // net.bytebuddy.agent.builder.AgentBuilder.RedefinitionStrategy.Listener
                public void onComplete(int i, List<Class<?>> list, Map<List<Class<?>>, Throwable> map) {
                    this.printStream.printf(
                            "[Byte Buddy] REDEFINE COMPLETE %d batch(es) containing %d types [%d failed batch(es)]%n",
                            Integer.valueOf(i), Integer.valueOf(list.size()), Integer.valueOf(map.size()));
                }

                @Override // net.bytebuddy.agent.builder.AgentBuilder.RedefinitionStrategy.Listener
                public Iterable<? extends List<Class<?>>> onError(int i, List<Class<?>> list, Throwable th,
                        List<Class<?>> list2) {
                    synchronized (this.printStream) {
                        this.printStream.printf("[Byte Buddy] REDEFINE ERROR #%d [%d of %d type(s)]%n",
                                Integer.valueOf(i), Integer.valueOf(list.size()), Integer.valueOf(list2.size()));
                        th.printStackTrace(this.printStream);
                    }
                    return Collections.EMPTY_LIST;
                }
            }

            /*
             * JADX INFO: compiled from:
             * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
             */
            public enum Yielding implements Listener {
                INSTANCE;

                @Override // net.bytebuddy.agent.builder.AgentBuilder.RedefinitionStrategy.Listener
                public void onBatch(int i, List<Class<?>> list, List<Class<?>> list2) {
                    if (i > 0) {
                        Thread.yield();
                    }
                }

                @Override // net.bytebuddy.agent.builder.AgentBuilder.RedefinitionStrategy.Listener
                public void onComplete(int i, List<Class<?>> list, Map<List<Class<?>>, Throwable> map) {
                }

                @Override // net.bytebuddy.agent.builder.AgentBuilder.RedefinitionStrategy.Listener
                public Iterable<? extends List<Class<?>>> onError(int i, List<Class<?>> list, Throwable th,
                        List<Class<?>> list2) {
                    return Collections.EMPTY_LIST;
                }
            }

            void onBatch(int i, List<Class<?>> list, List<Class<?>> list2);

            void onComplete(int i, List<Class<?>> list, Map<List<Class<?>>, Throwable> map);

            Iterable<? extends List<Class<?>>> onError(int i, List<Class<?>> list, Throwable th, List<Class<?>> list2);
        }

        /*
         * JADX INFO: compiled from:
         * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
         */
        public interface ResubmissionEnforcer {

            /*
             * JADX INFO: compiled from:
             * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
             */
            public enum Disabled implements ResubmissionEnforcer {
                INSTANCE;

                @Override // net.bytebuddy.agent.builder.AgentBuilder.RedefinitionStrategy.ResubmissionEnforcer
                public boolean isEnforced(String str, @MaybeNull ClassLoader classLoader,
                        @MaybeNull JavaModule javaModule, @MaybeNull Class<?> cls) {
                    return false;
                }
            }

            boolean isEnforced(String str, @MaybeNull ClassLoader classLoader, @MaybeNull JavaModule javaModule,
                    @MaybeNull Class<?> cls);
        }

        /*
         * JADX INFO: compiled from:
         * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
         */
        public interface ResubmissionScheduler {

            /*
             * JADX INFO: compiled from:
             * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
             */
            @HashCodeAndEqualsPlugin.Enhance
            public static class AtFixedRate implements ResubmissionScheduler {
                private final ScheduledExecutorService scheduledExecutorService;
                private final long time;
                private final TimeUnit timeUnit;

                public AtFixedRate(ScheduledExecutorService scheduledExecutorService, long j, TimeUnit timeUnit) {
                    this.scheduledExecutorService = scheduledExecutorService;
                    this.time = j;
                    this.timeUnit = timeUnit;
                }

                public boolean equals(@MaybeNull Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (obj == null || getClass() != obj.getClass()) {
                        return false;
                    }
                    AtFixedRate atFixedRate = (AtFixedRate) obj;
                    return this.time == atFixedRate.time && this.timeUnit.equals(atFixedRate.timeUnit)
                            && this.scheduledExecutorService.equals(atFixedRate.scheduledExecutorService);
                }

                public int hashCode() {
                    int iHashCode = (this.scheduledExecutorService.hashCode() + (getClass().hashCode() * 31)) * 31;
                    long j = this.time;
                    return this.timeUnit.hashCode() + ((iHashCode + ((int) (j ^ (j >>> 32)))) * 31);
                }

                @Override // net.bytebuddy.agent.builder.AgentBuilder.RedefinitionStrategy.ResubmissionScheduler
                public boolean isAlive() {
                    return !this.scheduledExecutorService.isShutdown();
                }

                @Override // net.bytebuddy.agent.builder.AgentBuilder.RedefinitionStrategy.ResubmissionScheduler
                public Cancelable schedule(Runnable runnable) {
                    ScheduledExecutorService scheduledExecutorService = this.scheduledExecutorService;
                    long j = this.time;
                    return new Cancelable.ForFuture(
                            scheduledExecutorService.scheduleAtFixedRate(runnable, j, j, this.timeUnit));
                }
            }

            /*
             * JADX INFO: compiled from:
             * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
             */
            public interface Cancelable {

                /*
                 * JADX INFO: compiled from:
                 * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
                 */
                @HashCodeAndEqualsPlugin.Enhance
                public static class ForFuture implements Cancelable {
                    private final Future<?> future;

                    public ForFuture(Future<?> future) {
                        this.future = future;
                    }

                    @Override // net.bytebuddy.agent.builder.AgentBuilder.RedefinitionStrategy.ResubmissionScheduler.Cancelable
                    public void cancel() {
                        this.future.cancel(true);
                    }

                    public boolean equals(@MaybeNull Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        return obj != null && getClass() == obj.getClass()
                                && this.future.equals(((ForFuture) obj).future);
                    }

                    public int hashCode() {
                        return this.future.hashCode() + (getClass().hashCode() * 31);
                    }
                }

                /*
                 * JADX INFO: compiled from:
                 * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
                 */
                public enum NoOp implements Cancelable {
                    INSTANCE;

                    @Override // net.bytebuddy.agent.builder.AgentBuilder.RedefinitionStrategy.ResubmissionScheduler.Cancelable
                    public void cancel() {
                    }
                }

                void cancel();
            }

            /*
             * JADX INFO: compiled from:
             * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
             */
            public enum NoOp implements ResubmissionScheduler {
                INSTANCE;

                @Override // net.bytebuddy.agent.builder.AgentBuilder.RedefinitionStrategy.ResubmissionScheduler
                public boolean isAlive() {
                    return false;
                }

                @Override // net.bytebuddy.agent.builder.AgentBuilder.RedefinitionStrategy.ResubmissionScheduler
                public Cancelable schedule(Runnable runnable) {
                    return Cancelable.NoOp.INSTANCE;
                }
            }

            /*
             * JADX INFO: compiled from:
             * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
             */
            @HashCodeAndEqualsPlugin.Enhance
            public static class WithFixedDelay implements ResubmissionScheduler {
                private final ScheduledExecutorService scheduledExecutorService;
                private final long time;
                private final TimeUnit timeUnit;

                public WithFixedDelay(ScheduledExecutorService scheduledExecutorService, long j, TimeUnit timeUnit) {
                    this.scheduledExecutorService = scheduledExecutorService;
                    this.time = j;
                    this.timeUnit = timeUnit;
                }

                public boolean equals(@MaybeNull Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (obj == null || getClass() != obj.getClass()) {
                        return false;
                    }
                    WithFixedDelay withFixedDelay = (WithFixedDelay) obj;
                    return this.time == withFixedDelay.time && this.timeUnit.equals(withFixedDelay.timeUnit)
                            && this.scheduledExecutorService.equals(withFixedDelay.scheduledExecutorService);
                }

                public int hashCode() {
                    int iHashCode = (this.scheduledExecutorService.hashCode() + (getClass().hashCode() * 31)) * 31;
                    long j = this.time;
                    return this.timeUnit.hashCode() + ((iHashCode + ((int) (j ^ (j >>> 32)))) * 31);
                }

                @Override // net.bytebuddy.agent.builder.AgentBuilder.RedefinitionStrategy.ResubmissionScheduler
                public boolean isAlive() {
                    return !this.scheduledExecutorService.isShutdown();
                }

                @Override // net.bytebuddy.agent.builder.AgentBuilder.RedefinitionStrategy.ResubmissionScheduler
                public Cancelable schedule(Runnable runnable) {
                    ScheduledExecutorService scheduledExecutorService = this.scheduledExecutorService;
                    long j = this.time;
                    return new Cancelable.ForFuture(
                            scheduledExecutorService.scheduleWithFixedDelay(runnable, j, j, this.timeUnit));
                }
            }

            boolean isAlive();

            Cancelable schedule(Runnable runnable);
        }

        /*
         * JADX INFO: compiled from:
         * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
         */
        public interface ResubmissionStrategy {

            /*
             * JADX INFO: compiled from:
             * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
             */
            public enum Disabled implements ResubmissionStrategy {
                INSTANCE;

                @Override // net.bytebuddy.agent.builder.AgentBuilder.RedefinitionStrategy.ResubmissionStrategy
                public Installation apply(Instrumentation instrumentation, PoolStrategy poolStrategy,
                        LocationStrategy locationStrategy, DescriptionStrategy descriptionStrategy,
                        FallbackStrategy fallbackStrategy, Listener listener, InstallationListener installationListener,
                        CircularityLock circularityLock, RawMatcher rawMatcher,
                        RedefinitionStrategy redefinitionStrategy, BatchAllocator batchAllocator, Listener listener2) {
                    return new Installation(listener, installationListener, ResubmissionEnforcer.Disabled.INSTANCE);
                }
            }

            /*
             * JADX INFO: compiled from:
             * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
             */
            @HashCodeAndEqualsPlugin.Enhance
            public static class Enabled implements ResubmissionStrategy {
                private final RedefinitionListenable.ResubmissionImmediateMatcher resubmissionImmediateMatcher;
                private final RedefinitionListenable.ResubmissionOnErrorMatcher resubmissionOnErrorMatcher;
                private final ResubmissionScheduler resubmissionScheduler;

                /*
                 * JADX INFO: compiled from:
                 * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
                 */
                public static class LookupKey {

                    @MaybeNull
                    private final ClassLoader classLoader;
                    private final int hashCode;

                    public LookupKey(@MaybeNull ClassLoader classLoader) {
                        this.classLoader = classLoader;
                        this.hashCode = System.identityHashCode(classLoader);
                    }

                    public boolean equals(@MaybeNull Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        if (obj instanceof LookupKey) {
                            return this.classLoader == ((LookupKey) obj).classLoader;
                        }
                        if (obj instanceof StorageKey) {
                            StorageKey storageKey = (StorageKey) obj;
                            if (this.hashCode == storageKey.hashCode && this.classLoader == storageKey.get()) {
                                return true;
                            }
                        }
                        return false;
                    }

                    public int hashCode() {
                        return this.hashCode;
                    }
                }

                /*
                 * JADX INFO: compiled from:
                 * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
                 */
                public static class ResubmissionInstallationListener extends InstallationListener.Adapter
                        implements Runnable {

                    @MaybeNull
                    private volatile ResubmissionScheduler.Cancelable cancelable;
                    private final CircularityLock circularityLock;
                    private final DescriptionStrategy descriptionStrategy;
                    private final FallbackStrategy fallbackStrategy;
                    private final Instrumentation instrumentation;
                    private final Listener listener;
                    private final LocationStrategy locationStrategy;
                    private final RawMatcher matcher;
                    private final PoolStrategy poolStrategy;
                    private final BatchAllocator redefinitionBatchAllocator;
                    private final Listener redefinitionBatchListener;
                    private final RedefinitionStrategy redefinitionStrategy;
                    private final ResubmissionScheduler resubmissionScheduler;
                    private final ConcurrentMap<StorageKey, Set<String>> types;

                    public ResubmissionInstallationListener(Instrumentation instrumentation,
                            ResubmissionScheduler resubmissionScheduler, PoolStrategy poolStrategy,
                            LocationStrategy locationStrategy, DescriptionStrategy descriptionStrategy,
                            FallbackStrategy fallbackStrategy, Listener listener, CircularityLock circularityLock,
                            RawMatcher rawMatcher, RedefinitionStrategy redefinitionStrategy,
                            BatchAllocator batchAllocator, Listener listener2,
                            ConcurrentMap<StorageKey, Set<String>> concurrentMap) {
                        this.instrumentation = instrumentation;
                        this.resubmissionScheduler = resubmissionScheduler;
                        this.poolStrategy = poolStrategy;
                        this.locationStrategy = locationStrategy;
                        this.descriptionStrategy = descriptionStrategy;
                        this.fallbackStrategy = fallbackStrategy;
                        this.listener = listener;
                        this.circularityLock = circularityLock;
                        this.matcher = rawMatcher;
                        this.redefinitionStrategy = redefinitionStrategy;
                        this.redefinitionBatchAllocator = batchAllocator;
                        this.redefinitionBatchListener = listener2;
                        this.types = concurrentMap;
                    }

                    @Override // net.bytebuddy.agent.builder.AgentBuilder.InstallationListener.Adapter,
                              // net.bytebuddy.agent.builder.AgentBuilder.InstallationListener
                    public void onInstall(Instrumentation instrumentation,
                            ResettableClassFileTransformer resettableClassFileTransformer) {
                        this.cancelable = this.resubmissionScheduler.schedule(this);
                    }

                    @Override // net.bytebuddy.agent.builder.AgentBuilder.InstallationListener.Adapter,
                              // net.bytebuddy.agent.builder.AgentBuilder.InstallationListener
                    public void onReset(Instrumentation instrumentation,
                            ResettableClassFileTransformer resettableClassFileTransformer) {
                        ResubmissionScheduler.Cancelable cancelable = this.cancelable;
                        if (cancelable != null) {
                            cancelable.cancel();
                        }
                    }

                    /* JADX WARN: Found duplicated region for block: B:34:0x00a8 */
                    @Override // java.lang.Runnable
                    public void run() {
                        boolean z;
                        boolean zAcquire = this.circularityLock.acquire();
                        try {
                            Collector collectorMake = this.redefinitionStrategy.make(this.poolStrategy,
                                    this.locationStrategy, this.descriptionStrategy, this.fallbackStrategy,
                                    this.listener, this.matcher, this.circularityLock);
                            Iterator<Map.Entry<StorageKey, Set<String>>> it = this.types.entrySet().iterator();
                            while (it.hasNext()) {
                                if (!Thread.interrupted()) {
                                    Map.Entry<StorageKey, Set<String>> next = it.next();
                                    ClassLoader classLoader = next.getKey().get();
                                    if (classLoader != null || next.getKey().isBootstrapLoader()) {
                                        Iterator<String> it2 = next.getValue().iterator();
                                        while (it2.hasNext()) {
                                            if (!Thread.interrupted()) {
                                                try {
                                                    Class<?> cls = Class.forName(it2.next(), false, classLoader);
                                                    if (cls.isArray() || cls.isPrimitive()) {
                                                        z = false;
                                                    } else {
                                                        if (!RedefinitionStrategy.DISPATCHER
                                                                .isModifiableClass(this.instrumentation, cls)) {
                                                            ClassFileVersion classFileVersion = ClassFileVersion.JAVA_V5;
                                                            if (!ClassFileVersion.ofThisVm(classFileVersion)
                                                                    .isAtMost(classFileVersion)) {
                                                                z = false;
                                                            }
                                                        }
                                                        z = true;
                                                    }
                                                    collectorMake.consider(cls, z);
                                                } catch (Throwable unused) {
                                                }
                                                it2.remove();
                                            } else if (!zAcquire) {
                                                return;
                                            }
                                        }
                                    } else {
                                        it.remove();
                                    }
                                } else if (!zAcquire) {
                                    return;
                                }
                            }
                            collectorMake.apply(this.instrumentation, this.redefinitionBatchAllocator,
                                    this.redefinitionBatchListener, 0);
                        } finally {
                            if (zAcquire) {
                                this.circularityLock.release();
                            }
                        }
                    }
                }

                /*
                 * JADX INFO: compiled from:
                 * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
                 */
                public static class Resubmitter extends Listener.Adapter implements ResubmissionEnforcer {
                    private final RedefinitionListenable.ResubmissionImmediateMatcher resubmissionImmediateMatcher;
                    private final RedefinitionListenable.ResubmissionOnErrorMatcher resubmissionOnErrorMatcher;
                    private final ConcurrentMap<StorageKey, Set<String>> types;

                    /*
                     * JADX INFO: compiled from:
                     * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
                     */
                    public static class ConcurrentHashSet<T> extends AbstractSet<T> {
                        private final ConcurrentMap<T, Boolean> delegate = new ConcurrentHashMap();

                        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
                        public boolean add(T t) {
                            return this.delegate.put(t, Boolean.TRUE) == null;
                        }

                        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable,
                                  // java.util.Set
                        public Iterator<T> iterator() {
                            return this.delegate.keySet().iterator();
                        }

                        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
                        public boolean remove(Object obj) {
                            return this.delegate.remove(obj) != null;
                        }

                        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
                        public int size() {
                            return this.delegate.size();
                        }
                    }

                    public Resubmitter(RedefinitionListenable.ResubmissionOnErrorMatcher resubmissionOnErrorMatcher,
                            RedefinitionListenable.ResubmissionImmediateMatcher resubmissionImmediateMatcher,
                            ConcurrentMap<StorageKey, Set<String>> concurrentMap) {
                        this.resubmissionOnErrorMatcher = resubmissionOnErrorMatcher;
                        this.resubmissionImmediateMatcher = resubmissionImmediateMatcher;
                        this.types = concurrentMap;
                    }

                    @Override // net.bytebuddy.agent.builder.AgentBuilder.RedefinitionStrategy.ResubmissionEnforcer
                    public boolean isEnforced(String str, @MaybeNull ClassLoader classLoader,
                            @MaybeNull JavaModule javaModule, @MaybeNull Class<?> cls) {
                        Set<String> setPutIfAbsent;
                        if (cls != null || !this.resubmissionImmediateMatcher.matches(str, classLoader, javaModule)) {
                            return false;
                        }
                        Set<String> concurrentHashSet = this.types.get(new LookupKey(classLoader));
                        if (concurrentHashSet == null
                                && (setPutIfAbsent = this.types.putIfAbsent(new StorageKey(classLoader),
                                        (concurrentHashSet = new ConcurrentHashSet<>()))) != null) {
                            concurrentHashSet = setPutIfAbsent;
                        }
                        concurrentHashSet.add(str);
                        return true;
                    }

                    @Override // net.bytebuddy.agent.builder.AgentBuilder.Listener.Adapter,
                              // net.bytebuddy.agent.builder.AgentBuilder.Listener
                    public void onError(String str, @MaybeNull ClassLoader classLoader,
                            @MaybeNull JavaModule javaModule, boolean z, Throwable th) {
                        Set<String> setPutIfAbsent;
                        if (z || !this.resubmissionOnErrorMatcher.matches(th, str, classLoader, javaModule)) {
                            return;
                        }
                        Set<String> concurrentHashSet = this.types.get(new LookupKey(classLoader));
                        if (concurrentHashSet == null
                                && (setPutIfAbsent = this.types.putIfAbsent(new StorageKey(classLoader),
                                        (concurrentHashSet = new ConcurrentHashSet<>()))) != null) {
                            concurrentHashSet = setPutIfAbsent;
                        }
                        concurrentHashSet.add(str);
                    }
                }

                /*
                 * JADX INFO: compiled from:
                 * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
                 */
                public static class StorageKey extends WeakReference<ClassLoader> {
                    private final int hashCode;

                    public StorageKey(@MaybeNull ClassLoader classLoader) {
                        super(classLoader);
                        this.hashCode = System.identityHashCode(classLoader);
                    }

                    public boolean equals(@MaybeNull Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        if (obj instanceof LookupKey) {
                            LookupKey lookupKey = (LookupKey) obj;
                            return this.hashCode == lookupKey.hashCode && get() == lookupKey.classLoader;
                        }
                        if (obj instanceof StorageKey) {
                            StorageKey storageKey = (StorageKey) obj;
                            if (this.hashCode == storageKey.hashCode && get() == storageKey.get()) {
                                return true;
                            }
                        }
                        return false;
                    }

                    public int hashCode() {
                        return this.hashCode;
                    }

                    public boolean isBootstrapLoader() {
                        return this.hashCode == 0;
                    }
                }

                public Enabled(ResubmissionScheduler resubmissionScheduler,
                        RedefinitionListenable.ResubmissionOnErrorMatcher resubmissionOnErrorMatcher,
                        RedefinitionListenable.ResubmissionImmediateMatcher resubmissionImmediateMatcher) {
                    this.resubmissionScheduler = resubmissionScheduler;
                    this.resubmissionOnErrorMatcher = resubmissionOnErrorMatcher;
                    this.resubmissionImmediateMatcher = resubmissionImmediateMatcher;
                }

                @Override // net.bytebuddy.agent.builder.AgentBuilder.RedefinitionStrategy.ResubmissionStrategy
                public Installation apply(Instrumentation instrumentation, PoolStrategy poolStrategy,
                        LocationStrategy locationStrategy, DescriptionStrategy descriptionStrategy,
                        FallbackStrategy fallbackStrategy, Listener listener, InstallationListener installationListener,
                        CircularityLock circularityLock, RawMatcher rawMatcher,
                        RedefinitionStrategy redefinitionStrategy, BatchAllocator batchAllocator, Listener listener2) {
                    if (this.resubmissionScheduler.isAlive()) {
                        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
                        Resubmitter resubmitter = new Resubmitter(this.resubmissionOnErrorMatcher,
                                this.resubmissionImmediateMatcher, concurrentHashMap);
                        return new Installation(new Listener.Compound(resubmitter, listener),
                                new InstallationListener.Compound(new ResubmissionInstallationListener(instrumentation,
                                        this.resubmissionScheduler, poolStrategy, locationStrategy, descriptionStrategy,
                                        fallbackStrategy, listener, circularityLock, rawMatcher, redefinitionStrategy,
                                        batchAllocator, listener2, concurrentHashMap), installationListener),
                                resubmitter);
                    }
                    throw new IllegalStateException(
                            "Resubmission scheduler " + this.resubmissionScheduler + " is not alive");
                }

                public boolean equals(@MaybeNull Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (obj == null || getClass() != obj.getClass()) {
                        return false;
                    }
                    Enabled enabled = (Enabled) obj;
                    return this.resubmissionScheduler.equals(enabled.resubmissionScheduler)
                            && this.resubmissionOnErrorMatcher.equals(enabled.resubmissionOnErrorMatcher)
                            && this.resubmissionImmediateMatcher.equals(enabled.resubmissionImmediateMatcher);
                }

                public int hashCode() {
                    return this.resubmissionImmediateMatcher.hashCode() + ((this.resubmissionOnErrorMatcher.hashCode()
                            + ((this.resubmissionScheduler.hashCode() + (getClass().hashCode() * 31)) * 31)) * 31);
                }
            }

            /*
             * JADX INFO: compiled from:
             * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
             */
            @HashCodeAndEqualsPlugin.Enhance
            public static class Installation {
                private final InstallationListener installationListener;
                private final Listener listener;
                private final ResubmissionEnforcer resubmissionEnforcer;

                public Installation(Listener listener, InstallationListener installationListener,
                        ResubmissionEnforcer resubmissionEnforcer) {
                    this.listener = listener;
                    this.installationListener = installationListener;
                    this.resubmissionEnforcer = resubmissionEnforcer;
                }

                public boolean equals(@MaybeNull Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (obj == null || getClass() != obj.getClass()) {
                        return false;
                    }
                    Installation installation = (Installation) obj;
                    return this.listener.equals(installation.listener)
                            && this.installationListener.equals(installation.installationListener)
                            && this.resubmissionEnforcer.equals(installation.resubmissionEnforcer);
                }

                public InstallationListener getInstallationListener() {
                    return this.installationListener;
                }

                public Listener getListener() {
                    return this.listener;
                }

                public ResubmissionEnforcer getResubmissionEnforcer() {
                    return this.resubmissionEnforcer;
                }

                public int hashCode() {
                    return this.resubmissionEnforcer.hashCode() + ((this.installationListener.hashCode()
                            + ((this.listener.hashCode() + (getClass().hashCode() * 31)) * 31)) * 31);
                }
            }

            Installation apply(Instrumentation instrumentation, PoolStrategy poolStrategy,
                    LocationStrategy locationStrategy, DescriptionStrategy descriptionStrategy,
                    FallbackStrategy fallbackStrategy, Listener listener, InstallationListener installationListener,
                    CircularityLock circularityLock, RawMatcher rawMatcher, RedefinitionStrategy redefinitionStrategy,
                    BatchAllocator batchAllocator, Listener listener2);
        }

        /* JADX WARN: Found duplicated region for block: B:23:0x006b */
        public void apply(Instrumentation instrumentation, PoolStrategy poolStrategy, LocationStrategy locationStrategy,
                DescriptionStrategy descriptionStrategy, FallbackStrategy fallbackStrategy,
                DiscoveryStrategy discoveryStrategy, LambdaInstrumentationStrategy lambdaInstrumentationStrategy,
                Listener listener, Listener listener2, RawMatcher rawMatcher, BatchAllocator batchAllocator,
                CircularityLock circularityLock) {
            boolean z;
            check(instrumentation);
            int iApply = 0;
            for (Iterable<Class<?>> iterable : discoveryStrategy.resolve(instrumentation)) {
                Collector collectorMake = make(poolStrategy, locationStrategy, descriptionStrategy, fallbackStrategy,
                        listener, rawMatcher, circularityLock);
                for (Class<?> cls : iterable) {
                    if (cls != null && !cls.isArray() && !cls.isPrimitive()) {
                        if (lambdaInstrumentationStrategy.isInstrumented(cls)) {
                            if (!DISPATCHER.isModifiableClass(instrumentation, cls)) {
                                ClassFileVersion classFileVersion = ClassFileVersion.JAVA_V5;
                                z = ClassFileVersion.ofThisVm(classFileVersion).isAtMost(classFileVersion);
                            }
                            collectorMake.consider(cls, z);
                        }
                    }
                }
                iApply = collectorMake.apply(instrumentation, batchAllocator, listener2, iApply);
            }
        }

        public abstract void check(Instrumentation instrumentation);

        public boolean isEnabled() {
            return this.enabled;
        }

        public boolean isRetransforming() {
            return this.retransforming;
        }

        public abstract Collector make(PoolStrategy poolStrategy, LocationStrategy locationStrategy,
                DescriptionStrategy descriptionStrategy, FallbackStrategy fallbackStrategy, Listener listener,
                RawMatcher rawMatcher, CircularityLock circularityLock);

        RedefinitionStrategy(boolean z, boolean z2) {
            this.enabled = z;
            this.retransforming = z2;
        }
    }

    /*
     * JADX INFO: compiled from:
     * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
     */
    public interface Transformer {

        /*
         * JADX INFO: compiled from:
         * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
         */
        @HashCodeAndEqualsPlugin.Enhance
        public static class ForAdvice implements Transformer {
            private final Advice.WithCustomMapping advice;
            private final Assigner assigner;
            private final List<String> auxiliaries;
            private final ClassFileLocator classFileLocator;
            private final List<Entry> entries;
            private final Advice.ExceptionHandler exceptionHandler;
            private final LocationStrategy locationStrategy;
            private final PoolStrategy poolStrategy;

            /*
             * JADX INFO: compiled from:
             * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
             */
            @HashCodeAndEqualsPlugin.Enhance
            public static abstract class Entry {
                private final LatentMatcher<? super MethodDescription> matcher;

                /*
                 * JADX INFO: compiled from:
                 * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
                 */
                @HashCodeAndEqualsPlugin.Enhance
                public static class ForSplitAdvice extends Entry {
                    private final String enter;
                    private final String exit;

                    public ForSplitAdvice(LatentMatcher<? super MethodDescription> latentMatcher, String str,
                            String str2) {
                        super(latentMatcher);
                        this.enter = str;
                        this.exit = str2;
                    }

                    @Override // net.bytebuddy.agent.builder.AgentBuilder.Transformer.ForAdvice.Entry
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
                        ForSplitAdvice forSplitAdvice = (ForSplitAdvice) obj;
                        return this.enter.equals(forSplitAdvice.enter) && this.exit.equals(forSplitAdvice.exit);
                    }

                    @Override // net.bytebuddy.agent.builder.AgentBuilder.Transformer.ForAdvice.Entry
                    public int hashCode() {
                        return this.exit.hashCode() + bjs.e(this.enter, super.hashCode() * 31, 31);
                    }

                    @Override // net.bytebuddy.agent.builder.AgentBuilder.Transformer.ForAdvice.Entry
                    public Advice resolve(Advice.WithCustomMapping withCustomMapping, TypePool typePool,
                            ClassFileLocator classFileLocator) {
                        return withCustomMapping.to(typePool.describe(this.enter).resolve(),
                                typePool.describe(this.exit).resolve(), classFileLocator);
                    }
                }

                /*
                 * JADX INFO: compiled from:
                 * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
                 */
                @HashCodeAndEqualsPlugin.Enhance
                public static class ForUnifiedAdvice extends Entry {
                    protected final String name;

                    public ForUnifiedAdvice(LatentMatcher<? super MethodDescription> latentMatcher, String str) {
                        super(latentMatcher);
                        this.name = str;
                    }

                    @Override // net.bytebuddy.agent.builder.AgentBuilder.Transformer.ForAdvice.Entry
                    public boolean equals(@MaybeNull Object obj) {
                        if (!super.equals(obj)) {
                            return false;
                        }
                        if (this == obj) {
                            return true;
                        }
                        return obj != null && getClass() == obj.getClass()
                                && this.name.equals(((ForUnifiedAdvice) obj).name);
                    }

                    @Override // net.bytebuddy.agent.builder.AgentBuilder.Transformer.ForAdvice.Entry
                    public int hashCode() {
                        return this.name.hashCode() + (super.hashCode() * 31);
                    }

                    @Override // net.bytebuddy.agent.builder.AgentBuilder.Transformer.ForAdvice.Entry
                    public Advice resolve(Advice.WithCustomMapping withCustomMapping, TypePool typePool,
                            ClassFileLocator classFileLocator) {
                        return withCustomMapping.to(typePool.describe(this.name).resolve(), classFileLocator);
                    }
                }

                public Entry(LatentMatcher<? super MethodDescription> latentMatcher) {
                    this.matcher = latentMatcher;
                }

                public boolean equals(@MaybeNull Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    return obj != null && getClass() == obj.getClass() && this.matcher.equals(((Entry) obj).matcher);
                }

                public LatentMatcher<? super MethodDescription> getMatcher() {
                    return this.matcher;
                }

                public int hashCode() {
                    return this.matcher.hashCode() + (getClass().hashCode() * 31);
                }

                public abstract Advice resolve(Advice.WithCustomMapping withCustomMapping, TypePool typePool,
                        ClassFileLocator classFileLocator);
            }

            /*
             * JADX INFO: compiled from:
             * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
             */
            @HashCodeAndEqualsPlugin.Enhance
            public static class LazyDynamicType extends DynamicType.AbstractBase {
                private final ClassFileLocator classFileLocator;
                private final TypeDescription typeDescription;

                public LazyDynamicType(TypeDescription typeDescription, ClassFileLocator classFileLocator) {
                    this.typeDescription = typeDescription;
                    this.classFileLocator = classFileLocator;
                }

                @Override // net.bytebuddy.dynamic.DynamicType.AbstractBase
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
                    LazyDynamicType lazyDynamicType = (LazyDynamicType) obj;
                    return this.typeDescription.equals(lazyDynamicType.typeDescription)
                            && this.classFileLocator.equals(lazyDynamicType.classFileLocator);
                }

                @Override // net.bytebuddy.dynamic.DynamicType
                public List<? extends DynamicType> getAuxiliaries() {
                    return Collections.EMPTY_LIST;
                }

                @Override // net.bytebuddy.dynamic.DynamicType
                public byte[] getBytes() {
                    try {
                        return this.classFileLocator.locate(this.typeDescription.getName()).resolve();
                    } catch (IOException e) {
                        throw new IllegalStateException("Failed to resolve class file for " + this.typeDescription, e);
                    }
                }

                @Override // net.bytebuddy.dynamic.DynamicType
                public LoadedTypeInitializer getLoadedTypeInitializer() {
                    return LoadedTypeInitializer.NoOp.INSTANCE;
                }

                @Override // net.bytebuddy.dynamic.DynamicType
                public TypeDescription getTypeDescription() {
                    return this.typeDescription;
                }

                @Override // net.bytebuddy.dynamic.DynamicType.AbstractBase
                public int hashCode() {
                    return this.classFileLocator.hashCode() + dkz.f(this.typeDescription, super.hashCode() * 31, 31);
                }
            }

            public ForAdvice() {
                this(Advice.withCustomMapping());
            }

            public ForAdvice advice(ElementMatcher<? super MethodDescription> elementMatcher, String str) {
                return advice(new LatentMatcher.Resolved(elementMatcher), str);
            }

            public ForAdvice auxiliary(String... strArr) {
                return auxiliary(Arrays.asList(strArr));
            }

            public boolean equals(@MaybeNull Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || getClass() != obj.getClass()) {
                    return false;
                }
                ForAdvice forAdvice = (ForAdvice) obj;
                return this.advice.equals(forAdvice.advice) && this.exceptionHandler.equals(forAdvice.exceptionHandler)
                        && this.assigner.equals(forAdvice.assigner)
                        && this.classFileLocator.equals(forAdvice.classFileLocator)
                        && this.poolStrategy.equals(forAdvice.poolStrategy)
                        && this.locationStrategy.equals(forAdvice.locationStrategy)
                        && this.entries.equals(forAdvice.entries) && this.auxiliaries.equals(forAdvice.auxiliaries);
            }

            public int hashCode() {
                return this.auxiliaries.hashCode() + bjs.g(this.entries, (this.locationStrategy.hashCode()
                        + ((this.poolStrategy.hashCode() + ((this.classFileLocator.hashCode() + dkz.h(this.assigner,
                                (this.exceptionHandler.hashCode()
                                        + ((this.advice.hashCode() + (getClass().hashCode() * 31)) * 31)) * 31,
                                31)) * 31)) * 31))
                        * 31, 31);
            }

            public ForAdvice include(ClassLoader... classLoaderArr) {
                LinkedHashSet linkedHashSet = new LinkedHashSet();
                for (ClassLoader classLoader : classLoaderArr) {
                    linkedHashSet.add(ClassFileLocator.ForClassLoader.of(classLoader));
                }
                return include(new ArrayList(linkedHashSet));
            }

            public ForAdvice make(Advice.WithCustomMapping withCustomMapping, Advice.ExceptionHandler exceptionHandler,
                    Assigner assigner, ClassFileLocator classFileLocator, PoolStrategy poolStrategy,
                    LocationStrategy locationStrategy, List<Entry> list, List<String> list2) {
                return new ForAdvice(withCustomMapping, exceptionHandler, assigner, classFileLocator, poolStrategy,
                        locationStrategy, list, list2);
            }

            @Override // net.bytebuddy.agent.builder.AgentBuilder.Transformer
            public DynamicType.Builder<?> transform(DynamicType.Builder<?> builder, TypeDescription typeDescription,
                    @MaybeNull ClassLoader classLoader, @MaybeNull JavaModule javaModule,
                    @MaybeNull ProtectionDomain protectionDomain) {
                ClassLoader classLoader2 = classLoader;
                JavaModule javaModule2 = javaModule;
                ClassFileLocator.Compound compound = new ClassFileLocator.Compound(this.classFileLocator,
                        this.locationStrategy.classFileLocator(classLoader2, javaModule2));
                TypePool typePool = this.poolStrategy.typePool(compound, classLoader2);
                Iterator<String> it = this.auxiliaries.iterator();
                while (it.hasNext()) {
                    builder = builder.require(new LazyDynamicType(typePool.describe(it.next()).resolve(), compound));
                }
                AsmVisitorWrapper.ForDeclaredMethods forDeclaredMethods = new AsmVisitorWrapper.ForDeclaredMethods();
                AsmVisitorWrapper.ForDeclaredMethods forDeclaredMethodsInvokable = forDeclaredMethods;
                for (Entry entry : this.entries) {
                    forDeclaredMethodsInvokable = forDeclaredMethodsInvokable.invokable(
                            (ElementMatcher<? super MethodDescription>) entry.getMatcher().resolve(typeDescription),
                            wrap(typeDescription, classLoader2, javaModule2, protectionDomain,
                                    entry.resolve(this.advice, typePool, compound).withAssigner(this.assigner)
                                            .withExceptionHandler(this.exceptionHandler)));
                    classLoader2 = classLoader;
                    javaModule2 = javaModule;
                }
                return builder.visit(forDeclaredMethodsInvokable);
            }

            public ForAdvice with(PoolStrategy poolStrategy) {
                return make(this.advice, this.exceptionHandler, this.assigner, this.classFileLocator, poolStrategy,
                        this.locationStrategy, this.entries, this.auxiliaries);
            }

            public ForAdvice withExceptionHandler(Advice.ExceptionHandler exceptionHandler) {
                return make(this.advice, exceptionHandler, this.assigner, this.classFileLocator, this.poolStrategy,
                        this.locationStrategy, this.entries, this.auxiliaries);
            }

            public AsmVisitorWrapper.ForDeclaredMethods.MethodVisitorWrapper wrap(TypeDescription typeDescription,
                    @MaybeNull ClassLoader classLoader, @MaybeNull JavaModule javaModule,
                    @MaybeNull ProtectionDomain protectionDomain, Advice advice) {
                return advice;
            }

            /* JADX WARN: Illegal instructions before constructor call */
            public ForAdvice(Advice.WithCustomMapping withCustomMapping) {
                Advice.ExceptionHandler.Default r2 = Advice.ExceptionHandler.Default.SUPPRESSING;
                Assigner assigner = Assigner.DEFAULT;
                ClassFileLocator.NoOp noOp = ClassFileLocator.NoOp.INSTANCE;
                PoolStrategy.Default r5 = PoolStrategy.Default.FAST;
                LocationStrategy.ForClassLoader forClassLoader = LocationStrategy.ForClassLoader.STRONG;
                List list = Collections.EMPTY_LIST;
                this(withCustomMapping, r2, assigner, noOp, r5, forClassLoader, list, list);
            }

            public ForAdvice advice(LatentMatcher<? super MethodDescription> latentMatcher, String str) {
                return make(this.advice, this.exceptionHandler, this.assigner, this.classFileLocator, this.poolStrategy,
                        this.locationStrategy,
                        CompoundList.of(this.entries, new Entry.ForUnifiedAdvice(latentMatcher, str)),
                        this.auxiliaries);
            }

            public ForAdvice auxiliary(List<String> list) {
                return make(this.advice, this.exceptionHandler, this.assigner, this.classFileLocator, this.poolStrategy,
                        this.locationStrategy, this.entries, CompoundList.of((List) this.auxiliaries, (List) list));
            }

            public ForAdvice with(LocationStrategy locationStrategy) {
                return make(this.advice, this.exceptionHandler, this.assigner, this.classFileLocator, this.poolStrategy,
                        locationStrategy, this.entries, this.auxiliaries);
            }

            public ForAdvice with(Assigner assigner) {
                return make(this.advice, this.exceptionHandler, assigner, this.classFileLocator, this.poolStrategy,
                        this.locationStrategy, this.entries, this.auxiliaries);
            }

            public ForAdvice(Advice.WithCustomMapping withCustomMapping, Advice.ExceptionHandler exceptionHandler,
                    Assigner assigner, ClassFileLocator classFileLocator, PoolStrategy poolStrategy,
                    LocationStrategy locationStrategy, List<Entry> list, List<String> list2) {
                this.advice = withCustomMapping;
                this.exceptionHandler = exceptionHandler;
                this.assigner = assigner;
                this.classFileLocator = classFileLocator;
                this.poolStrategy = poolStrategy;
                this.locationStrategy = locationStrategy;
                this.entries = list;
                this.auxiliaries = list2;
            }

            public ForAdvice advice(ElementMatcher<? super MethodDescription> elementMatcher, String str, String str2) {
                return advice(new LatentMatcher.Resolved(elementMatcher), str, str2);
            }

            public ForAdvice include(ClassFileLocator... classFileLocatorArr) {
                return include(Arrays.asList(classFileLocatorArr));
            }

            public ForAdvice advice(LatentMatcher<? super MethodDescription> latentMatcher, String str, String str2) {
                return make(this.advice, this.exceptionHandler, this.assigner, this.classFileLocator, this.poolStrategy,
                        this.locationStrategy,
                        CompoundList.of(this.entries, new Entry.ForSplitAdvice(latentMatcher, str, str2)),
                        this.auxiliaries);
            }

            public ForAdvice include(List<? extends ClassFileLocator> list) {
                return make(this.advice, this.exceptionHandler, this.assigner,
                        new ClassFileLocator.Compound(
                                (List<? extends ClassFileLocator>) CompoundList.of(this.classFileLocator, list)),
                        this.poolStrategy, this.locationStrategy, this.entries, this.auxiliaries);
            }
        }

        /*
         * JADX INFO: compiled from:
         * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
         */
        @HashCodeAndEqualsPlugin.Enhance
        public static class ForBuildPlugin implements Transformer {
            private final Plugin plugin;

            public ForBuildPlugin(Plugin plugin) {
                this.plugin = plugin;
            }

            public boolean equals(@MaybeNull Object obj) {
                if (this == obj) {
                    return true;
                }
                return obj != null && getClass() == obj.getClass() && this.plugin.equals(((ForBuildPlugin) obj).plugin);
            }

            public int hashCode() {
                return this.plugin.hashCode() + (getClass().hashCode() * 31);
            }

            @Override // net.bytebuddy.agent.builder.AgentBuilder.Transformer
            public DynamicType.Builder<?> transform(DynamicType.Builder<?> builder, TypeDescription typeDescription,
                    @MaybeNull ClassLoader classLoader, @MaybeNull JavaModule javaModule,
                    @MaybeNull ProtectionDomain protectionDomain) {
                return this.plugin.apply(builder, typeDescription, ClassFileLocator.ForClassLoader.of(classLoader));
            }
        }

        DynamicType.Builder<?> transform(DynamicType.Builder<?> builder, TypeDescription typeDescription,
                @MaybeNull ClassLoader classLoader, @MaybeNull JavaModule javaModule,
                @MaybeNull ProtectionDomain protectionDomain);
    }

    /*
     * JADX INFO: compiled from:
     * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
     */
    public interface TransformerDecorator {

        /*
         * JADX INFO: compiled from:
         * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
         */
        @HashCodeAndEqualsPlugin.Enhance
        public static class Compound implements TransformerDecorator {
            private final List<TransformerDecorator> transformerDecorators;

            public Compound(TransformerDecorator... transformerDecoratorArr) {
                this((List<? extends TransformerDecorator>) Arrays.asList(transformerDecoratorArr));
            }

            @Override // net.bytebuddy.agent.builder.AgentBuilder.TransformerDecorator
            public ResettableClassFileTransformer decorate(
                    ResettableClassFileTransformer resettableClassFileTransformer) {
                Iterator<TransformerDecorator> it = this.transformerDecorators.iterator();
                while (it.hasNext()) {
                    resettableClassFileTransformer = it.next().decorate(resettableClassFileTransformer);
                }
                return resettableClassFileTransformer;
            }

            public boolean equals(@MaybeNull Object obj) {
                if (this == obj) {
                    return true;
                }
                return obj != null && getClass() == obj.getClass()
                        && this.transformerDecorators.equals(((Compound) obj).transformerDecorators);
            }

            public int hashCode() {
                return this.transformerDecorators.hashCode() + (getClass().hashCode() * 31);
            }

            public Compound(List<? extends TransformerDecorator> list) {
                this.transformerDecorators = new ArrayList();
                for (TransformerDecorator transformerDecorator : list) {
                    if (transformerDecorator instanceof Compound) {
                        this.transformerDecorators.addAll(((Compound) transformerDecorator).transformerDecorators);
                    } else if (!(transformerDecorator instanceof NoOp)) {
                        this.transformerDecorators.add(transformerDecorator);
                    }
                }
            }
        }

        /*
         * JADX INFO: compiled from:
         * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
         */
        public enum ForSubstitution implements TransformerDecorator {
            INSTANCE;

            @Override // net.bytebuddy.agent.builder.AgentBuilder.TransformerDecorator
            public ResettableClassFileTransformer decorate(
                    ResettableClassFileTransformer resettableClassFileTransformer) {
                return ResettableClassFileTransformer.WithDelegation.Substitutable.of(resettableClassFileTransformer);
            }
        }

        /*
         * JADX INFO: compiled from:
         * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
         */
        public enum NoOp implements TransformerDecorator {
            INSTANCE;

            @Override // net.bytebuddy.agent.builder.AgentBuilder.TransformerDecorator
            public ResettableClassFileTransformer decorate(
                    ResettableClassFileTransformer resettableClassFileTransformer) {
                return resettableClassFileTransformer;
            }
        }

        ResettableClassFileTransformer decorate(ResettableClassFileTransformer resettableClassFileTransformer);
    }

    /*
     * JADX INFO: compiled from:
     * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
     */
    public interface TypeStrategy {

        /*
         * JADX INFO: compiled from:
         * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
         */
        public enum Default implements TypeStrategy {
            REBASE { // from class: net.bytebuddy.agent.builder.AgentBuilder.TypeStrategy.Default.1
                @Override // net.bytebuddy.agent.builder.AgentBuilder.TypeStrategy
                public DynamicType.Builder<?> builder(TypeDescription typeDescription, ByteBuddy byteBuddy,
                        ClassFileLocator classFileLocator, MethodNameTransformer methodNameTransformer,
                        @MaybeNull ClassLoader classLoader, @MaybeNull JavaModule javaModule,
                        @MaybeNull ProtectionDomain protectionDomain) {
                    return byteBuddy.rebase(typeDescription, classFileLocator, methodNameTransformer);
                }
            },
            REDEFINE { // from class: net.bytebuddy.agent.builder.AgentBuilder.TypeStrategy.Default.2
                @Override // net.bytebuddy.agent.builder.AgentBuilder.TypeStrategy
                public DynamicType.Builder<?> builder(TypeDescription typeDescription, ByteBuddy byteBuddy,
                        ClassFileLocator classFileLocator, MethodNameTransformer methodNameTransformer,
                        @MaybeNull ClassLoader classLoader, @MaybeNull JavaModule javaModule,
                        @MaybeNull ProtectionDomain protectionDomain) {
                    return byteBuddy.redefine(typeDescription, classFileLocator);
                }
            },
            REDEFINE_FROZEN { // from class: net.bytebuddy.agent.builder.AgentBuilder.TypeStrategy.Default.3
                @Override // net.bytebuddy.agent.builder.AgentBuilder.TypeStrategy
                public DynamicType.Builder<?> builder(TypeDescription typeDescription, ByteBuddy byteBuddy,
                        ClassFileLocator classFileLocator, MethodNameTransformer methodNameTransformer,
                        @MaybeNull ClassLoader classLoader, @MaybeNull JavaModule javaModule,
                        @MaybeNull ProtectionDomain protectionDomain) {
                    return byteBuddy.with(InstrumentedType.Factory.Default.FROZEN)
                            .with(VisibilityBridgeStrategy.Default.NEVER).redefine(typeDescription, classFileLocator)
                            .ignoreAlso(LatentMatcher.ForSelfDeclaredMethod.NOT_DECLARED);
                }
            },
            DECORATE { // from class: net.bytebuddy.agent.builder.AgentBuilder.TypeStrategy.Default.4
                @Override // net.bytebuddy.agent.builder.AgentBuilder.TypeStrategy
                public DynamicType.Builder<?> builder(TypeDescription typeDescription, ByteBuddy byteBuddy,
                        ClassFileLocator classFileLocator, MethodNameTransformer methodNameTransformer,
                        @MaybeNull ClassLoader classLoader, @MaybeNull JavaModule javaModule,
                        @MaybeNull ProtectionDomain protectionDomain) {
                    return byteBuddy.decorate(typeDescription, classFileLocator);
                }
            }
        }

        /*
         * JADX INFO: compiled from:
         * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
         */
        @HashCodeAndEqualsPlugin.Enhance
        public static class ForBuildEntryPoint implements TypeStrategy {
            private final EntryPoint entryPoint;

            public ForBuildEntryPoint(EntryPoint entryPoint) {
                this.entryPoint = entryPoint;
            }

            @Override // net.bytebuddy.agent.builder.AgentBuilder.TypeStrategy
            public DynamicType.Builder<?> builder(TypeDescription typeDescription, ByteBuddy byteBuddy,
                    ClassFileLocator classFileLocator, MethodNameTransformer methodNameTransformer,
                    @MaybeNull ClassLoader classLoader, @MaybeNull JavaModule javaModule,
                    @MaybeNull ProtectionDomain protectionDomain) {
                return this.entryPoint.transform(typeDescription, byteBuddy, classFileLocator, methodNameTransformer);
            }

            public boolean equals(@MaybeNull Object obj) {
                if (this == obj) {
                    return true;
                }
                return obj != null && getClass() == obj.getClass()
                        && this.entryPoint.equals(((ForBuildEntryPoint) obj).entryPoint);
            }

            public int hashCode() {
                return this.entryPoint.hashCode() + (getClass().hashCode() * 31);
            }
        }

        DynamicType.Builder<?> builder(TypeDescription typeDescription, ByteBuddy byteBuddy,
                ClassFileLocator classFileLocator, MethodNameTransformer methodNameTransformer,
                @MaybeNull ClassLoader classLoader, @MaybeNull JavaModule javaModule,
                @MaybeNull ProtectionDomain protectionDomain);
    }

    AgentBuilder assureReadEdgeFromAndTo(Instrumentation instrumentation, Collection<? extends JavaModule> collection);

    AgentBuilder assureReadEdgeFromAndTo(Instrumentation instrumentation, Class<?>... clsArr);

    AgentBuilder assureReadEdgeFromAndTo(Instrumentation instrumentation, JavaModule... javaModuleArr);

    AgentBuilder assureReadEdgeTo(Instrumentation instrumentation, Collection<? extends JavaModule> collection);

    AgentBuilder assureReadEdgeTo(Instrumentation instrumentation, Class<?>... clsArr);

    AgentBuilder assureReadEdgeTo(Instrumentation instrumentation, JavaModule... javaModuleArr);

    AgentBuilder disableClassFormatChanges();

    AgentBuilder disableNativeMethodPrefix();

    AgentBuilder enableNativeMethodPrefix(String str);

    Ignored ignore(RawMatcher rawMatcher);

    Ignored ignore(ElementMatcher<? super TypeDescription> elementMatcher);

    Ignored ignore(ElementMatcher<? super TypeDescription> elementMatcher,
            ElementMatcher<? super ClassLoader> elementMatcher2);

    Ignored ignore(ElementMatcher<? super TypeDescription> elementMatcher,
            ElementMatcher<? super ClassLoader> elementMatcher2, ElementMatcher<? super JavaModule> elementMatcher3);

    ResettableClassFileTransformer installOn(Instrumentation instrumentation);

    ResettableClassFileTransformer installOnByteBuddyAgent();

    ClassFileTransformer makeRaw();

    ResettableClassFileTransformer patchOn(Instrumentation instrumentation,
            ResettableClassFileTransformer resettableClassFileTransformer);

    ResettableClassFileTransformer patchOn(Instrumentation instrumentation,
            ResettableClassFileTransformer resettableClassFileTransformer, PatchMode patchMode);

    ResettableClassFileTransformer patchOn(Instrumentation instrumentation,
            ResettableClassFileTransformer resettableClassFileTransformer, RawMatcher rawMatcher);

    ResettableClassFileTransformer patchOn(Instrumentation instrumentation,
            ResettableClassFileTransformer resettableClassFileTransformer, RawMatcher rawMatcher, PatchMode patchMode);

    ResettableClassFileTransformer patchOnByteBuddyAgent(ResettableClassFileTransformer resettableClassFileTransformer);

    ResettableClassFileTransformer patchOnByteBuddyAgent(ResettableClassFileTransformer resettableClassFileTransformer,
            PatchMode patchMode);

    Identified.Narrowable type(RawMatcher rawMatcher);

    Identified.Narrowable type(ElementMatcher<? super TypeDescription> elementMatcher);

    Identified.Narrowable type(ElementMatcher<? super TypeDescription> elementMatcher,
            ElementMatcher<? super ClassLoader> elementMatcher2);

    Identified.Narrowable type(ElementMatcher<? super TypeDescription> elementMatcher,
            ElementMatcher<? super ClassLoader> elementMatcher2, ElementMatcher<? super JavaModule> elementMatcher3);

    AgentBuilder warmUp(Collection<Class<?>> collection);

    AgentBuilder warmUp(Class<?>... clsArr);

    RedefinitionListenable.WithoutBatchStrategy with(RedefinitionStrategy redefinitionStrategy);

    AgentBuilder with(ByteBuddy byteBuddy);

    AgentBuilder with(CircularityLock circularityLock);

    AgentBuilder with(ClassFileBufferStrategy classFileBufferStrategy);

    AgentBuilder with(DescriptionStrategy descriptionStrategy);

    AgentBuilder with(FallbackStrategy fallbackStrategy);

    AgentBuilder with(InitializationStrategy initializationStrategy);

    AgentBuilder with(InjectionStrategy injectionStrategy);

    AgentBuilder with(InstallationListener installationListener);

    AgentBuilder with(LambdaInstrumentationStrategy lambdaInstrumentationStrategy);

    AgentBuilder with(Listener listener);

    AgentBuilder with(LocationStrategy locationStrategy);

    AgentBuilder with(PoolStrategy poolStrategy);

    AgentBuilder with(TransformerDecorator transformerDecorator);

    AgentBuilder with(TypeStrategy typeStrategy);

    AgentBuilder with(ClassFileLocator classFileLocator);
}

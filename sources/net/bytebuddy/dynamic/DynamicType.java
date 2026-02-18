package net.bytebuddy.dynamic;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.jar.Attributes;
import java.util.jar.JarEntry;
import java.util.jar.JarInputStream;
import java.util.jar.JarOutputStream;
import java.util.jar.Manifest;
import me.hd.wauxv.obf.bjs;
import me.hd.wauxv.obf.dkz;
import me.hd.wauxv.obf.yg;
import net.bytebuddy.ClassFileVersion;
import net.bytebuddy.asm.AsmVisitorWrapper;
import net.bytebuddy.build.HashCodeAndEqualsPlugin;
import net.bytebuddy.description.annotation.AnnotationDescription;
import net.bytebuddy.description.annotation.AnnotationList;
import net.bytebuddy.description.annotation.AnnotationValue;
import net.bytebuddy.description.field.FieldDescription;
import net.bytebuddy.description.method.MethodDescription;
import net.bytebuddy.description.method.ParameterDescription;
import net.bytebuddy.description.method.ParameterList;
import net.bytebuddy.description.modifier.FieldManifestation;
import net.bytebuddy.description.modifier.MethodManifestation;
import net.bytebuddy.description.modifier.ModifierContributor;
import net.bytebuddy.description.modifier.Ownership;
import net.bytebuddy.description.modifier.Visibility;
import net.bytebuddy.description.module.ModuleDescription;
import net.bytebuddy.description.type.RecordComponentDescription;
import net.bytebuddy.description.type.TypeDefinition;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.description.type.TypeList;
import net.bytebuddy.description.type.TypeVariableToken;
import net.bytebuddy.dynamic.ClassFileLocator;
import net.bytebuddy.dynamic.Transformer;
import net.bytebuddy.dynamic.TypeResolutionStrategy;
import net.bytebuddy.dynamic.loading.ClassLoadingStrategy;
import net.bytebuddy.dynamic.loading.InjectionClassLoader;
import net.bytebuddy.dynamic.scaffold.FieldRegistry;
import net.bytebuddy.dynamic.scaffold.InstrumentedType;
import net.bytebuddy.dynamic.scaffold.MethodGraph;
import net.bytebuddy.dynamic.scaffold.MethodRegistry;
import net.bytebuddy.dynamic.scaffold.RecordComponentRegistry;
import net.bytebuddy.dynamic.scaffold.TypeValidation;
import net.bytebuddy.dynamic.scaffold.TypeWriter;
import net.bytebuddy.implementation.EqualsMethod;
import net.bytebuddy.implementation.FieldAccessor;
import net.bytebuddy.implementation.HashCodeMethod;
import net.bytebuddy.implementation.Implementation;
import net.bytebuddy.implementation.LoadedTypeInitializer;
import net.bytebuddy.implementation.ToStringMethod;
import net.bytebuddy.implementation.attribute.AnnotationRetention;
import net.bytebuddy.implementation.attribute.AnnotationValueFilter;
import net.bytebuddy.implementation.attribute.FieldAttributeAppender;
import net.bytebuddy.implementation.attribute.MethodAttributeAppender;
import net.bytebuddy.implementation.attribute.RecordComponentAttributeAppender;
import net.bytebuddy.implementation.attribute.TypeAttributeAppender;
import net.bytebuddy.implementation.auxiliary.AuxiliaryType;
import net.bytebuddy.implementation.bytecode.ByteCodeAppender;
import net.bytebuddy.jar.asm.ClassVisitor;
import net.bytebuddy.matcher.ElementMatcher;
import net.bytebuddy.matcher.ElementMatchers;
import net.bytebuddy.matcher.LatentMatcher;
import net.bytebuddy.pool.TypePool;
import net.bytebuddy.utility.AsmClassReader;
import net.bytebuddy.utility.AsmClassWriter;
import net.bytebuddy.utility.CompoundList;
import net.bytebuddy.utility.FileSystem;
import net.bytebuddy.utility.nullability.MaybeNull;
import net.bytebuddy.utility.visitor.ContextClassVisitor;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public interface DynamicType extends ClassFileLocator {

    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
    public interface Builder<T> {

        /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
        public static abstract class AbstractBase<S> implements Builder<S> {

            /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
            @HashCodeAndEqualsPlugin.Enhance
            public static abstract class Adapter<U> extends UsingTypeWriter<U> {
                protected final AnnotationRetention annotationRetention;
                protected final AnnotationValueFilter.Factory annotationValueFilterFactory;
                protected final AsmVisitorWrapper asmVisitorWrapper;
                protected final AuxiliaryType.NamingStrategy auxiliaryTypeNamingStrategy;
                protected final List<? extends DynamicType> auxiliaryTypes;
                protected final ClassFileVersion classFileVersion;
                protected final AsmClassReader.Factory classReaderFactory;
                protected final AsmClassWriter.Factory classWriterFactory;
                protected final FieldRegistry fieldRegistry;
                protected final LatentMatcher<? super MethodDescription> ignoredMethods;
                protected final Implementation.Context.Factory implementationContextFactory;
                protected final InstrumentedType.WithFlexibleName instrumentedType;
                protected final MethodGraph.Compiler methodGraphCompiler;
                protected final MethodRegistry methodRegistry;
                protected final RecordComponentRegistry recordComponentRegistry;
                protected final TypeAttributeAppender typeAttributeAppender;
                protected final TypeValidation typeValidation;
                protected final VisibilityBridgeStrategy visibilityBridgeStrategy;

                /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
                @HashCodeAndEqualsPlugin.Enhance(includeSyntheticFields = true)
                public class InnerTypeDefinitionForMethodAdapter extends Delegator<U> implements InnerTypeDefinition<U> {
                    private final MethodDescription.InDefinedShape methodDescription;

                    public InnerTypeDefinitionForMethodAdapter(MethodDescription.InDefinedShape inDefinedShape) {
                        this.methodDescription = inDefinedShape;
                    }

                    @Override // net.bytebuddy.dynamic.DynamicType.Builder.InnerTypeDefinition
                    public Builder<U> asAnonymousType() {
                        Adapter adapter = Adapter.this;
                        InstrumentedType.WithFlexibleName withFlexibleNameWithAnonymousClass = adapter.instrumentedType.withDeclaringType(TypeDescription.UNDEFINED).withEnclosingMethod(this.methodDescription).withAnonymousClass(true);
                        Adapter adapter2 = Adapter.this;
                        return adapter.materialize(withFlexibleNameWithAnonymousClass, adapter2.fieldRegistry, adapter2.methodRegistry, adapter2.recordComponentRegistry, adapter2.typeAttributeAppender, adapter2.asmVisitorWrapper, adapter2.classFileVersion, adapter2.auxiliaryTypeNamingStrategy, adapter2.annotationValueFilterFactory, adapter2.annotationRetention, adapter2.implementationContextFactory, adapter2.methodGraphCompiler, adapter2.typeValidation, adapter2.visibilityBridgeStrategy, adapter2.classReaderFactory, adapter2.classWriterFactory, adapter2.ignoredMethods, adapter2.auxiliaryTypes);
                    }

                    public boolean equals(@MaybeNull Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        if (obj == null || getClass() != obj.getClass()) {
                            return false;
                        }
                        InnerTypeDefinitionForMethodAdapter innerTypeDefinitionForMethodAdapter = (InnerTypeDefinitionForMethodAdapter) obj;
                        return this.methodDescription.equals(innerTypeDefinitionForMethodAdapter.methodDescription) && Adapter.this.equals(Adapter.this);
                    }

                    public int hashCode() {
                        return Adapter.this.hashCode() + dkz.b(this.methodDescription, getClass().hashCode() * 31, 31);
                    }

                    @Override // net.bytebuddy.dynamic.DynamicType.Builder.AbstractBase.Delegator
                    public Builder<U> materialize() {
                        Adapter adapter = Adapter.this;
                        InstrumentedType.WithFlexibleName withFlexibleNameWithLocalClass = adapter.instrumentedType.withDeclaringType(TypeDescription.UNDEFINED).withEnclosingMethod(this.methodDescription).withLocalClass(true);
                        Adapter adapter2 = Adapter.this;
                        return adapter.materialize(withFlexibleNameWithLocalClass, adapter2.fieldRegistry, adapter2.methodRegistry, adapter2.recordComponentRegistry, adapter2.typeAttributeAppender, adapter2.asmVisitorWrapper, adapter2.classFileVersion, adapter2.auxiliaryTypeNamingStrategy, adapter2.annotationValueFilterFactory, adapter2.annotationRetention, adapter2.implementationContextFactory, adapter2.methodGraphCompiler, adapter2.typeValidation, adapter2.visibilityBridgeStrategy, adapter2.classReaderFactory, adapter2.classWriterFactory, adapter2.ignoredMethods, adapter2.auxiliaryTypes);
                    }
                }

                /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
                @HashCodeAndEqualsPlugin.Enhance(includeSyntheticFields = true)
                public class InnerTypeDefinitionForTypeAdapter extends Delegator<U> implements InnerTypeDefinition.ForType<U> {
                    private final TypeDescription typeDescription;

                    public InnerTypeDefinitionForTypeAdapter(TypeDescription typeDescription) {
                        this.typeDescription = typeDescription;
                    }

                    @Override // net.bytebuddy.dynamic.DynamicType.Builder.InnerTypeDefinition
                    public Builder<U> asAnonymousType() {
                        Adapter adapter = Adapter.this;
                        InstrumentedType.WithFlexibleName withFlexibleNameWithAnonymousClass = adapter.instrumentedType.withDeclaringType(TypeDescription.UNDEFINED).withEnclosingType(this.typeDescription).withAnonymousClass(true);
                        Adapter adapter2 = Adapter.this;
                        return adapter.materialize(withFlexibleNameWithAnonymousClass, adapter2.fieldRegistry, adapter2.methodRegistry, adapter2.recordComponentRegistry, adapter2.typeAttributeAppender, adapter2.asmVisitorWrapper, adapter2.classFileVersion, adapter2.auxiliaryTypeNamingStrategy, adapter2.annotationValueFilterFactory, adapter2.annotationRetention, adapter2.implementationContextFactory, adapter2.methodGraphCompiler, adapter2.typeValidation, adapter2.visibilityBridgeStrategy, adapter2.classReaderFactory, adapter2.classWriterFactory, adapter2.ignoredMethods, adapter2.auxiliaryTypes);
                    }

                    @Override // net.bytebuddy.dynamic.DynamicType.Builder.InnerTypeDefinition.ForType
                    public Builder<U> asMemberType() {
                        Adapter adapter = Adapter.this;
                        InstrumentedType.WithFlexibleName withFlexibleNameWithLocalClass = adapter.instrumentedType.withDeclaringType(this.typeDescription).withEnclosingType(this.typeDescription).withAnonymousClass(false).withLocalClass(false);
                        Adapter adapter2 = Adapter.this;
                        return adapter.materialize(withFlexibleNameWithLocalClass, adapter2.fieldRegistry, adapter2.methodRegistry, adapter2.recordComponentRegistry, adapter2.typeAttributeAppender, adapter2.asmVisitorWrapper, adapter2.classFileVersion, adapter2.auxiliaryTypeNamingStrategy, adapter2.annotationValueFilterFactory, adapter2.annotationRetention, adapter2.implementationContextFactory, adapter2.methodGraphCompiler, adapter2.typeValidation, adapter2.visibilityBridgeStrategy, adapter2.classReaderFactory, adapter2.classWriterFactory, adapter2.ignoredMethods, adapter2.auxiliaryTypes);
                    }

                    public boolean equals(@MaybeNull Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        if (obj == null || getClass() != obj.getClass()) {
                            return false;
                        }
                        InnerTypeDefinitionForTypeAdapter innerTypeDefinitionForTypeAdapter = (InnerTypeDefinitionForTypeAdapter) obj;
                        return this.typeDescription.equals(innerTypeDefinitionForTypeAdapter.typeDescription) && Adapter.this.equals(Adapter.this);
                    }

                    public int hashCode() {
                        return Adapter.this.hashCode() + dkz.f(this.typeDescription, getClass().hashCode() * 31, 31);
                    }

                    @Override // net.bytebuddy.dynamic.DynamicType.Builder.AbstractBase.Delegator
                    public Builder<U> materialize() {
                        Adapter adapter = Adapter.this;
                        InstrumentedType.WithFlexibleName withFlexibleNameWithLocalClass = adapter.instrumentedType.withDeclaringType(TypeDescription.UNDEFINED).withEnclosingType(this.typeDescription).withLocalClass(true);
                        Adapter adapter2 = Adapter.this;
                        return adapter.materialize(withFlexibleNameWithLocalClass, adapter2.fieldRegistry, adapter2.methodRegistry, adapter2.recordComponentRegistry, adapter2.typeAttributeAppender, adapter2.asmVisitorWrapper, adapter2.classFileVersion, adapter2.auxiliaryTypeNamingStrategy, adapter2.annotationValueFilterFactory, adapter2.annotationRetention, adapter2.implementationContextFactory, adapter2.methodGraphCompiler, adapter2.typeValidation, adapter2.visibilityBridgeStrategy, adapter2.classReaderFactory, adapter2.classWriterFactory, adapter2.ignoredMethods, adapter2.auxiliaryTypes);
                    }
                }

                /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
                @HashCodeAndEqualsPlugin.Enhance(includeSyntheticFields = true)
                public class MethodDefinitionAdapter extends MethodDefinition.ParameterDefinition.Initial.AbstractBase<U> {
                    private final MethodDescription.Token token;

                    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
                    @HashCodeAndEqualsPlugin.Enhance(includeSyntheticFields = true)
                    public class AnnotationAdapter extends MethodDefinition.AbstractBase.Adapter<U> {
                        public AnnotationAdapter(MethodDefinitionAdapter methodDefinitionAdapter, MethodRegistry.Handler handler) {
                            this(handler, MethodAttributeAppender.ForInstrumentedMethod.INCLUDING_RECEIVER, Transformer.NoOp.make());
                        }

                        @Override // net.bytebuddy.dynamic.DynamicType.Builder.MethodDefinition
                        public MethodDefinition<U> annotateMethod(Collection<? extends AnnotationDescription> collection) {
                            MethodDefinitionAdapter methodDefinitionAdapter = MethodDefinitionAdapter.this;
                            return new MethodDefinitionAdapter(new MethodDescription.Token(methodDefinitionAdapter.token.getName(), MethodDefinitionAdapter.this.token.getModifiers(), MethodDefinitionAdapter.this.token.getTypeVariableTokens(), MethodDefinitionAdapter.this.token.getReturnType(), MethodDefinitionAdapter.this.token.getParameterTokens(), MethodDefinitionAdapter.this.token.getExceptionTypes(), CompoundList.of((List) MethodDefinitionAdapter.this.token.getAnnotations(), (List) new ArrayList(collection)), MethodDefinitionAdapter.this.token.getDefaultValue(), MethodDefinitionAdapter.this.token.getReceiverType())).new AnnotationAdapter(this.handler, this.methodAttributeAppenderFactory, this.transformer);
                        }

                        @Override // net.bytebuddy.dynamic.DynamicType.Builder.MethodDefinition
                        public MethodDefinition<U> annotateParameter(int i, Collection<? extends AnnotationDescription> collection) {
                            ArrayList arrayList = new ArrayList(MethodDefinitionAdapter.this.token.getParameterTokens());
                            arrayList.set(i, new ParameterDescription.Token(((ParameterDescription.Token) MethodDefinitionAdapter.this.token.getParameterTokens().get(i)).getType(), CompoundList.of((List) ((ParameterDescription.Token) MethodDefinitionAdapter.this.token.getParameterTokens().get(i)).getAnnotations(), (List) new ArrayList(collection)), ((ParameterDescription.Token) MethodDefinitionAdapter.this.token.getParameterTokens().get(i)).getName(), ((ParameterDescription.Token) MethodDefinitionAdapter.this.token.getParameterTokens().get(i)).getModifiers()));
                            MethodDefinitionAdapter methodDefinitionAdapter = MethodDefinitionAdapter.this;
                            return new MethodDefinitionAdapter(new MethodDescription.Token(methodDefinitionAdapter.token.getName(), MethodDefinitionAdapter.this.token.getModifiers(), MethodDefinitionAdapter.this.token.getTypeVariableTokens(), MethodDefinitionAdapter.this.token.getReturnType(), arrayList, MethodDefinitionAdapter.this.token.getExceptionTypes(), MethodDefinitionAdapter.this.token.getAnnotations(), MethodDefinitionAdapter.this.token.getDefaultValue(), MethodDefinitionAdapter.this.token.getReceiverType())).new AnnotationAdapter(this.handler, this.methodAttributeAppenderFactory, this.transformer);
                        }

                        @Override // net.bytebuddy.dynamic.DynamicType.Builder.MethodDefinition.AbstractBase.Adapter
                        public boolean equals(@MaybeNull Object obj) {
                            if (!super.equals(obj)) {
                                return false;
                            }
                            if (this == obj) {
                                return true;
                            }
                            return obj != null && getClass() == obj.getClass() && MethodDefinitionAdapter.this.equals(MethodDefinitionAdapter.this);
                        }

                        @Override // net.bytebuddy.dynamic.DynamicType.Builder.MethodDefinition.AbstractBase.Adapter
                        public int hashCode() {
                            return MethodDefinitionAdapter.this.hashCode() + (super.hashCode() * 31);
                        }

                        @Override // net.bytebuddy.dynamic.DynamicType.Builder.MethodDefinition.AbstractBase.Adapter
                        public MethodDefinition<U> materialize(MethodRegistry.Handler handler, MethodAttributeAppender.Factory factory, Transformer<MethodDescription> transformer) {
                            return MethodDefinitionAdapter.this.new AnnotationAdapter(handler, factory, transformer);
                        }

                        @Override // net.bytebuddy.dynamic.DynamicType.Builder.MethodDefinition.ReceiverTypeDefinition
                        public MethodDefinition<U> receiverType(TypeDescription.Generic generic) {
                            MethodDefinitionAdapter methodDefinitionAdapter = MethodDefinitionAdapter.this;
                            return new MethodDefinitionAdapter(new MethodDescription.Token(methodDefinitionAdapter.token.getName(), MethodDefinitionAdapter.this.token.getModifiers(), MethodDefinitionAdapter.this.token.getTypeVariableTokens(), MethodDefinitionAdapter.this.token.getReturnType(), MethodDefinitionAdapter.this.token.getParameterTokens(), MethodDefinitionAdapter.this.token.getExceptionTypes(), MethodDefinitionAdapter.this.token.getAnnotations(), MethodDefinitionAdapter.this.token.getDefaultValue(), generic)).new AnnotationAdapter(this.handler, this.methodAttributeAppenderFactory, this.transformer);
                        }

                        @Override // net.bytebuddy.dynamic.DynamicType.Builder.AbstractBase.Delegator
                        public Builder<U> materialize() {
                            MethodDefinitionAdapter methodDefinitionAdapter = MethodDefinitionAdapter.this;
                            Adapter adapter = Adapter.this;
                            InstrumentedType.WithFlexibleName withFlexibleNameWithMethod = adapter.instrumentedType.withMethod(methodDefinitionAdapter.token);
                            MethodDefinitionAdapter methodDefinitionAdapter2 = MethodDefinitionAdapter.this;
                            Adapter adapter2 = Adapter.this;
                            FieldRegistry fieldRegistry = adapter2.fieldRegistry;
                            MethodRegistry methodRegistryPrepend = adapter2.methodRegistry.prepend(new LatentMatcher.ForMethodToken(methodDefinitionAdapter2.token), this.handler, this.methodAttributeAppenderFactory, this.transformer);
                            Adapter adapter3 = Adapter.this;
                            return adapter.materialize(withFlexibleNameWithMethod, fieldRegistry, methodRegistryPrepend, adapter3.recordComponentRegistry, adapter3.typeAttributeAppender, adapter3.asmVisitorWrapper, adapter3.classFileVersion, adapter3.auxiliaryTypeNamingStrategy, adapter3.annotationValueFilterFactory, adapter3.annotationRetention, adapter3.implementationContextFactory, adapter3.methodGraphCompiler, adapter3.typeValidation, adapter3.visibilityBridgeStrategy, adapter3.classReaderFactory, adapter3.classWriterFactory, adapter3.ignoredMethods, adapter3.auxiliaryTypes);
                        }

                        public AnnotationAdapter(MethodRegistry.Handler handler, MethodAttributeAppender.Factory factory, Transformer<MethodDescription> transformer) {
                            super(handler, factory, transformer);
                        }
                    }

                    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
                    @HashCodeAndEqualsPlugin.Enhance(includeSyntheticFields = true)
                    public class ParameterAnnotationAdapter extends MethodDefinition.ParameterDefinition.Annotatable.AbstractBase.Adapter<U> {
                        private final ParameterDescription.Token token;

                        public ParameterAnnotationAdapter(ParameterDescription.Token token) {
                            this.token = token;
                        }

                        @Override // net.bytebuddy.dynamic.DynamicType.Builder.MethodDefinition.ParameterDefinition.Annotatable
                        public MethodDefinition.ParameterDefinition.Annotatable<U> annotateParameter(Collection<? extends AnnotationDescription> collection) {
                            return MethodDefinitionAdapter.this.new ParameterAnnotationAdapter(new ParameterDescription.Token(this.token.getType(), CompoundList.of((List) this.token.getAnnotations(), (List) new ArrayList(collection)), this.token.getName(), this.token.getModifiers()));
                        }

                        public boolean equals(@MaybeNull Object obj) {
                            if (this == obj) {
                                return true;
                            }
                            if (obj == null || getClass() != obj.getClass()) {
                                return false;
                            }
                            ParameterAnnotationAdapter parameterAnnotationAdapter = (ParameterAnnotationAdapter) obj;
                            return this.token.equals(parameterAnnotationAdapter.token) && MethodDefinitionAdapter.this.equals(MethodDefinitionAdapter.this);
                        }

                        public int hashCode() {
                            return MethodDefinitionAdapter.this.hashCode() + ((this.token.hashCode() + (getClass().hashCode() * 31)) * 31);
                        }

                        @Override // net.bytebuddy.dynamic.DynamicType.Builder.MethodDefinition.ParameterDefinition.Annotatable.AbstractBase.Adapter
                        public MethodDefinition.ParameterDefinition<U> materialize() {
                            MethodDefinitionAdapter methodDefinitionAdapter = MethodDefinitionAdapter.this;
                            return new MethodDefinitionAdapter(new MethodDescription.Token(methodDefinitionAdapter.token.getName(), MethodDefinitionAdapter.this.token.getModifiers(), MethodDefinitionAdapter.this.token.getTypeVariableTokens(), MethodDefinitionAdapter.this.token.getReturnType(), CompoundList.of(MethodDefinitionAdapter.this.token.getParameterTokens(), this.token), MethodDefinitionAdapter.this.token.getExceptionTypes(), MethodDefinitionAdapter.this.token.getAnnotations(), MethodDefinitionAdapter.this.token.getDefaultValue(), MethodDefinitionAdapter.this.token.getReceiverType()));
                        }
                    }

                    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
                    @HashCodeAndEqualsPlugin.Enhance(includeSyntheticFields = true)
                    public class SimpleParameterAnnotationAdapter extends MethodDefinition.ParameterDefinition.Simple.Annotatable.AbstractBase.Adapter<U> {
                        private final ParameterDescription.Token token;

                        public SimpleParameterAnnotationAdapter(ParameterDescription.Token token) {
                            this.token = token;
                        }

                        @Override // net.bytebuddy.dynamic.DynamicType.Builder.MethodDefinition.ParameterDefinition.Simple.Annotatable
                        public MethodDefinition.ParameterDefinition.Simple.Annotatable<U> annotateParameter(Collection<? extends AnnotationDescription> collection) {
                            return MethodDefinitionAdapter.this.new SimpleParameterAnnotationAdapter(new ParameterDescription.Token(this.token.getType(), CompoundList.of((List) this.token.getAnnotations(), (List) new ArrayList(collection)), this.token.getName(), this.token.getModifiers()));
                        }

                        public boolean equals(@MaybeNull Object obj) {
                            if (this == obj) {
                                return true;
                            }
                            if (obj == null || getClass() != obj.getClass()) {
                                return false;
                            }
                            SimpleParameterAnnotationAdapter simpleParameterAnnotationAdapter = (SimpleParameterAnnotationAdapter) obj;
                            return this.token.equals(simpleParameterAnnotationAdapter.token) && MethodDefinitionAdapter.this.equals(MethodDefinitionAdapter.this);
                        }

                        public int hashCode() {
                            return MethodDefinitionAdapter.this.hashCode() + ((this.token.hashCode() + (getClass().hashCode() * 31)) * 31);
                        }

                        @Override // net.bytebuddy.dynamic.DynamicType.Builder.MethodDefinition.ParameterDefinition.Simple.Annotatable.AbstractBase.Adapter
                        public MethodDefinition.ParameterDefinition.Simple<U> materialize() {
                            MethodDefinitionAdapter methodDefinitionAdapter = MethodDefinitionAdapter.this;
                            return new MethodDefinitionAdapter(new MethodDescription.Token(methodDefinitionAdapter.token.getName(), MethodDefinitionAdapter.this.token.getModifiers(), MethodDefinitionAdapter.this.token.getTypeVariableTokens(), MethodDefinitionAdapter.this.token.getReturnType(), CompoundList.of(MethodDefinitionAdapter.this.token.getParameterTokens(), this.token), MethodDefinitionAdapter.this.token.getExceptionTypes(), MethodDefinitionAdapter.this.token.getAnnotations(), MethodDefinitionAdapter.this.token.getDefaultValue(), MethodDefinitionAdapter.this.token.getReceiverType()));
                        }
                    }

                    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
                    @HashCodeAndEqualsPlugin.Enhance(includeSyntheticFields = true)
                    public class TypeVariableAnnotationAdapter extends MethodDefinition.TypeVariableDefinition.Annotatable.AbstractBase.Adapter<U> {
                        private final TypeVariableToken token;

                        public TypeVariableAnnotationAdapter(TypeVariableToken typeVariableToken) {
                            this.token = typeVariableToken;
                        }

                        @Override // net.bytebuddy.dynamic.DynamicType.Builder.MethodDefinition.TypeVariableDefinition.Annotatable
                        public MethodDefinition.TypeVariableDefinition.Annotatable<U> annotateTypeVariable(Collection<? extends AnnotationDescription> collection) {
                            return MethodDefinitionAdapter.this.new TypeVariableAnnotationAdapter(new TypeVariableToken(this.token.getSymbol(), this.token.getBounds(), CompoundList.of((List) this.token.getAnnotations(), (List) new ArrayList(collection))));
                        }

                        public boolean equals(@MaybeNull Object obj) {
                            if (this == obj) {
                                return true;
                            }
                            if (obj == null || getClass() != obj.getClass()) {
                                return false;
                            }
                            TypeVariableAnnotationAdapter typeVariableAnnotationAdapter = (TypeVariableAnnotationAdapter) obj;
                            return this.token.equals(typeVariableAnnotationAdapter.token) && MethodDefinitionAdapter.this.equals(MethodDefinitionAdapter.this);
                        }

                        public int hashCode() {
                            return MethodDefinitionAdapter.this.hashCode() + ((this.token.hashCode() + (getClass().hashCode() * 31)) * 31);
                        }

                        @Override // net.bytebuddy.dynamic.DynamicType.Builder.MethodDefinition.TypeVariableDefinition.Annotatable.AbstractBase.Adapter
                        public MethodDefinition.ParameterDefinition<U> materialize() {
                            MethodDefinitionAdapter methodDefinitionAdapter = MethodDefinitionAdapter.this;
                            return new MethodDefinitionAdapter(new MethodDescription.Token(methodDefinitionAdapter.token.getName(), MethodDefinitionAdapter.this.token.getModifiers(), CompoundList.of(MethodDefinitionAdapter.this.token.getTypeVariableTokens(), this.token), MethodDefinitionAdapter.this.token.getReturnType(), MethodDefinitionAdapter.this.token.getParameterTokens(), MethodDefinitionAdapter.this.token.getExceptionTypes(), MethodDefinitionAdapter.this.token.getAnnotations(), MethodDefinitionAdapter.this.token.getDefaultValue(), MethodDefinitionAdapter.this.token.getReceiverType()));
                        }
                    }

                    public MethodDefinitionAdapter(MethodDescription.Token token) {
                        this.token = token;
                    }

                    private MethodDefinition.ReceiverTypeDefinition<U> materialize(MethodRegistry.Handler handler) {
                        return new AnnotationAdapter(this, handler);
                    }

                    @Override // net.bytebuddy.dynamic.DynamicType.Builder.MethodDefinition.ImplementationDefinition
                    public MethodDefinition.ReceiverTypeDefinition<U> defaultValue(AnnotationValue<?, ?> annotationValue) {
                        return new MethodDefinitionAdapter(new MethodDescription.Token(this.token.getName(), ModifierContributor.Resolver.of(MethodManifestation.ABSTRACT).resolve(this.token.getModifiers()), this.token.getTypeVariableTokens(), this.token.getReturnType(), this.token.getParameterTokens(), this.token.getExceptionTypes(), this.token.getAnnotations(), annotationValue, this.token.getReceiverType())).materialize(new MethodRegistry.Handler.ForAnnotationValue(annotationValue));
                    }

                    public boolean equals(@MaybeNull Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        if (obj == null || getClass() != obj.getClass()) {
                            return false;
                        }
                        MethodDefinitionAdapter methodDefinitionAdapter = (MethodDefinitionAdapter) obj;
                        return this.token.equals(methodDefinitionAdapter.token) && Adapter.this.equals(Adapter.this);
                    }

                    public int hashCode() {
                        return Adapter.this.hashCode() + ((this.token.hashCode() + (getClass().hashCode() * 31)) * 31);
                    }

                    @Override // net.bytebuddy.dynamic.DynamicType.Builder.MethodDefinition.ImplementationDefinition
                    public MethodDefinition.ReceiverTypeDefinition<U> intercept(Implementation implementation) {
                        return materialize(new MethodRegistry.Handler.ForImplementation(implementation));
                    }

                    @Override // net.bytebuddy.dynamic.DynamicType.Builder.MethodDefinition.ExceptionDefinition
                    public MethodDefinition.ExceptionDefinition<U> throwing(Collection<? extends TypeDefinition> collection) {
                        return new MethodDefinitionAdapter(new MethodDescription.Token(this.token.getName(), this.token.getModifiers(), this.token.getTypeVariableTokens(), this.token.getReturnType(), this.token.getParameterTokens(), CompoundList.of((List) this.token.getExceptionTypes(), (List) new TypeList.Generic.Explicit(new ArrayList(collection))), this.token.getAnnotations(), this.token.getDefaultValue(), this.token.getReceiverType()));
                    }

                    @Override // net.bytebuddy.dynamic.DynamicType.Builder.MethodDefinition.TypeVariableDefinition
                    public MethodDefinition.TypeVariableDefinition.Annotatable<U> typeVariable(String str, Collection<? extends TypeDefinition> collection) {
                        return new TypeVariableAnnotationAdapter(new TypeVariableToken(str, new TypeList.Generic.Explicit(new ArrayList(collection))));
                    }

                    @Override // net.bytebuddy.dynamic.DynamicType.Builder.MethodDefinition.ParameterDefinition
                    public MethodDefinition.ParameterDefinition.Annotatable<U> withParameter(TypeDefinition typeDefinition, String str, int i) {
                        return new ParameterAnnotationAdapter(new ParameterDescription.Token(typeDefinition.asGenericType(), str, Integer.valueOf(i)));
                    }

                    @Override // net.bytebuddy.dynamic.DynamicType.Builder.MethodDefinition.ImplementationDefinition
                    public MethodDefinition.ReceiverTypeDefinition<U> withoutCode() {
                        return new MethodDefinitionAdapter(new MethodDescription.Token(this.token.getName(), (this.token.getModifiers() & 256) == 0 ? ModifierContributor.Resolver.of(MethodManifestation.ABSTRACT).resolve(this.token.getModifiers()) : this.token.getModifiers(), this.token.getTypeVariableTokens(), this.token.getReturnType(), this.token.getParameterTokens(), this.token.getExceptionTypes(), this.token.getAnnotations(), this.token.getDefaultValue(), this.token.getReceiverType())).materialize(MethodRegistry.Handler.ForAbstractMethod.INSTANCE);
                    }

                    @Override // net.bytebuddy.dynamic.DynamicType.Builder.MethodDefinition.ParameterDefinition.Simple
                    public MethodDefinition.ParameterDefinition.Simple.Annotatable<U> withParameter(TypeDefinition typeDefinition) {
                        return new SimpleParameterAnnotationAdapter(new ParameterDescription.Token(typeDefinition.asGenericType()));
                    }
                }

                /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
                @HashCodeAndEqualsPlugin.Enhance(includeSyntheticFields = true)
                public class MethodMatchAdapter extends MethodDefinition.ImplementationDefinition.AbstractBase<U> {
                    private final LatentMatcher<? super MethodDescription> matcher;

                    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
                    @HashCodeAndEqualsPlugin.Enhance(includeSyntheticFields = true)
                    public class AnnotationAdapter extends MethodDefinition.AbstractBase.Adapter<U> {
                        public AnnotationAdapter(MethodMatchAdapter methodMatchAdapter, MethodRegistry.Handler handler) {
                            this(handler, MethodAttributeAppender.NoOp.INSTANCE, Transformer.NoOp.make());
                        }

                        @Override // net.bytebuddy.dynamic.DynamicType.Builder.MethodDefinition
                        public MethodDefinition<U> annotateMethod(Collection<? extends AnnotationDescription> collection) {
                            return MethodMatchAdapter.this.new AnnotationAdapter(this.handler, new MethodAttributeAppender.Factory.Compound(this.methodAttributeAppenderFactory, new MethodAttributeAppender.Explicit(new ArrayList(collection))), this.transformer);
                        }

                        @Override // net.bytebuddy.dynamic.DynamicType.Builder.MethodDefinition
                        public MethodDefinition<U> annotateParameter(int i, Collection<? extends AnnotationDescription> collection) {
                            return MethodMatchAdapter.this.new AnnotationAdapter(this.handler, new MethodAttributeAppender.Factory.Compound(this.methodAttributeAppenderFactory, new MethodAttributeAppender.Explicit(i, new ArrayList(collection))), this.transformer);
                        }

                        @Override // net.bytebuddy.dynamic.DynamicType.Builder.MethodDefinition.AbstractBase.Adapter
                        public boolean equals(@MaybeNull Object obj) {
                            if (!super.equals(obj)) {
                                return false;
                            }
                            if (this == obj) {
                                return true;
                            }
                            return obj != null && getClass() == obj.getClass() && MethodMatchAdapter.this.equals(MethodMatchAdapter.this);
                        }

                        @Override // net.bytebuddy.dynamic.DynamicType.Builder.MethodDefinition.AbstractBase.Adapter
                        public int hashCode() {
                            return MethodMatchAdapter.this.hashCode() + (super.hashCode() * 31);
                        }

                        @Override // net.bytebuddy.dynamic.DynamicType.Builder.MethodDefinition.AbstractBase.Adapter
                        public MethodDefinition<U> materialize(MethodRegistry.Handler handler, MethodAttributeAppender.Factory factory, Transformer<MethodDescription> transformer) {
                            return MethodMatchAdapter.this.new AnnotationAdapter(handler, factory, transformer);
                        }

                        @Override // net.bytebuddy.dynamic.DynamicType.Builder.MethodDefinition.ReceiverTypeDefinition
                        public MethodDefinition<U> receiverType(TypeDescription.Generic generic) {
                            return MethodMatchAdapter.this.new AnnotationAdapter(this.handler, new MethodAttributeAppender.Factory.Compound(this.methodAttributeAppenderFactory, new MethodAttributeAppender.ForReceiverType(generic)), this.transformer);
                        }

                        public AnnotationAdapter(MethodRegistry.Handler handler, MethodAttributeAppender.Factory factory, Transformer<MethodDescription> transformer) {
                            super(handler, factory, transformer);
                        }

                        @Override // net.bytebuddy.dynamic.DynamicType.Builder.AbstractBase.Delegator
                        public Builder<U> materialize() {
                            MethodMatchAdapter methodMatchAdapter = MethodMatchAdapter.this;
                            Adapter adapter = Adapter.this;
                            InstrumentedType.WithFlexibleName withFlexibleName = adapter.instrumentedType;
                            FieldRegistry fieldRegistry = adapter.fieldRegistry;
                            MethodRegistry methodRegistryPrepend = adapter.methodRegistry.prepend(methodMatchAdapter.matcher, this.handler, this.methodAttributeAppenderFactory, this.transformer);
                            Adapter adapter2 = Adapter.this;
                            return adapter.materialize(withFlexibleName, fieldRegistry, methodRegistryPrepend, adapter2.recordComponentRegistry, adapter2.typeAttributeAppender, adapter2.asmVisitorWrapper, adapter2.classFileVersion, adapter2.auxiliaryTypeNamingStrategy, adapter2.annotationValueFilterFactory, adapter2.annotationRetention, adapter2.implementationContextFactory, adapter2.methodGraphCompiler, adapter2.typeValidation, adapter2.visibilityBridgeStrategy, adapter2.classReaderFactory, adapter2.classWriterFactory, adapter2.ignoredMethods, adapter2.auxiliaryTypes);
                        }
                    }

                    public MethodMatchAdapter(LatentMatcher<? super MethodDescription> latentMatcher) {
                        this.matcher = latentMatcher;
                    }

                    private MethodDefinition.ReceiverTypeDefinition<U> materialize(MethodRegistry.Handler handler) {
                        return new AnnotationAdapter(this, handler);
                    }

                    @Override // net.bytebuddy.dynamic.DynamicType.Builder.MethodDefinition.ImplementationDefinition
                    public MethodDefinition.ReceiverTypeDefinition<U> defaultValue(AnnotationValue<?, ?> annotationValue) {
                        return materialize(new MethodRegistry.Handler.ForAnnotationValue(annotationValue));
                    }

                    public boolean equals(@MaybeNull Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        if (obj == null || getClass() != obj.getClass()) {
                            return false;
                        }
                        MethodMatchAdapter methodMatchAdapter = (MethodMatchAdapter) obj;
                        return this.matcher.equals(methodMatchAdapter.matcher) && Adapter.this.equals(Adapter.this);
                    }

                    public int hashCode() {
                        return Adapter.this.hashCode() + ((this.matcher.hashCode() + (getClass().hashCode() * 31)) * 31);
                    }

                    @Override // net.bytebuddy.dynamic.DynamicType.Builder.MethodDefinition.ImplementationDefinition
                    public MethodDefinition.ReceiverTypeDefinition<U> intercept(Implementation implementation) {
                        return materialize(new MethodRegistry.Handler.ForImplementation(implementation));
                    }

                    @Override // net.bytebuddy.dynamic.DynamicType.Builder.MethodDefinition.ImplementationDefinition
                    public MethodDefinition.ReceiverTypeDefinition<U> withoutCode() {
                        return materialize(MethodRegistry.Handler.ForAbstractMethod.INSTANCE);
                    }
                }

                /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
                @HashCodeAndEqualsPlugin.Enhance(includeSyntheticFields = true)
                public class ModuleDefinitionAdapter extends ModuleDefinition.AbstractBase<U> {
                    private final Map<String, ModuleDescription.Exports> exports;

                    @MaybeNull
                    @HashCodeAndEqualsPlugin.ValueHandling(HashCodeAndEqualsPlugin.ValueHandling.Sort.REVERSE_NULLABILITY)
                    private final String mainClass;
                    private final int modifiers;
                    private final String name;
                    private final Map<String, ModuleDescription.Opens> opens;
                    private final Set<String> packages;
                    private final Map<String, ModuleDescription.Provides> provides;
                    private final Map<String, ModuleDescription.Requires> requires;
                    private final Set<String> uses;

                    @MaybeNull
                    @HashCodeAndEqualsPlugin.ValueHandling(HashCodeAndEqualsPlugin.ValueHandling.Sort.REVERSE_NULLABILITY)
                    private final String version;

                    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
                    @HashCodeAndEqualsPlugin.Enhance(includeSyntheticFields = true)
                    public class ExportsDefinitionAdapter extends ModuleDefinition.ExportsDefinition.Delegator<U> {
                        private final String aPackage;
                        private final int modifiers;
                        private final Set<String> targets;

                        public ExportsDefinitionAdapter(ModuleDefinitionAdapter moduleDefinitionAdapter, String str, int i) {
                            this(str, i, Collections.EMPTY_SET);
                        }

                        public boolean equals(@MaybeNull Object obj) {
                            if (this == obj) {
                                return true;
                            }
                            if (obj == null || getClass() != obj.getClass()) {
                                return false;
                            }
                            ExportsDefinitionAdapter exportsDefinitionAdapter = (ExportsDefinitionAdapter) obj;
                            return this.modifiers == exportsDefinitionAdapter.modifiers && this.aPackage.equals(exportsDefinitionAdapter.aPackage) && this.targets.equals(exportsDefinitionAdapter.targets) && ModuleDefinitionAdapter.this.equals(ModuleDefinitionAdapter.this);
                        }

                        public int hashCode() {
                            return ModuleDefinitionAdapter.this.hashCode() + ((this.targets.hashCode() + ((bjs.e(this.aPackage, getClass().hashCode() * 31, 31) + this.modifiers) * 31)) * 31);
                        }

                        @Override // net.bytebuddy.dynamic.DynamicType.Builder.ModuleDefinition.ExportsDefinition
                        public ModuleDefinition.ExportsDefinition<U> to(Collection<String> collection) {
                            LinkedHashSet linkedHashSet = new LinkedHashSet(this.targets);
                            linkedHashSet.addAll(collection);
                            return ModuleDefinitionAdapter.this.new ExportsDefinitionAdapter(this.aPackage, this.modifiers, linkedHashSet);
                        }

                        public ExportsDefinitionAdapter(String str, int i, Set<String> set) {
                            this.aPackage = str;
                            this.modifiers = i;
                            this.targets = set;
                        }

                        @Override // net.bytebuddy.dynamic.DynamicType.Builder.ModuleDefinition.AbstractBase.Delegator, net.bytebuddy.dynamic.DynamicType.Builder.AbstractBase.Delegator
                        public ModuleDefinition<U> materialize() {
                            LinkedHashMap linkedHashMap = new LinkedHashMap(ModuleDefinitionAdapter.this.exports);
                            linkedHashMap.put(this.aPackage, new ModuleDescription.Exports.Simple(this.targets, this.modifiers));
                            ModuleDefinitionAdapter moduleDefinitionAdapter = ModuleDefinitionAdapter.this;
                            return new ModuleDefinitionAdapter(moduleDefinitionAdapter.name, ModuleDefinitionAdapter.this.modifiers, ModuleDefinitionAdapter.this.version, ModuleDefinitionAdapter.this.mainClass, ModuleDefinitionAdapter.this.packages, ModuleDefinitionAdapter.this.requires, linkedHashMap, ModuleDefinitionAdapter.this.opens, ModuleDefinitionAdapter.this.uses, ModuleDefinitionAdapter.this.provides);
                        }
                    }

                    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
                    @HashCodeAndEqualsPlugin.Enhance(includeSyntheticFields = true)
                    public class OpensDefinitionAdapter extends ModuleDefinition.OpensDefinition.Delegator<U> {
                        private final String aPackage;
                        private final int modifiers;
                        private final Set<String> targets;

                        public OpensDefinitionAdapter(ModuleDefinitionAdapter moduleDefinitionAdapter, String str, int i) {
                            this(str, i, Collections.EMPTY_SET);
                        }

                        public boolean equals(@MaybeNull Object obj) {
                            if (this == obj) {
                                return true;
                            }
                            if (obj == null || getClass() != obj.getClass()) {
                                return false;
                            }
                            OpensDefinitionAdapter opensDefinitionAdapter = (OpensDefinitionAdapter) obj;
                            return this.modifiers == opensDefinitionAdapter.modifiers && this.aPackage.equals(opensDefinitionAdapter.aPackage) && this.targets.equals(opensDefinitionAdapter.targets) && ModuleDefinitionAdapter.this.equals(ModuleDefinitionAdapter.this);
                        }

                        public int hashCode() {
                            return ModuleDefinitionAdapter.this.hashCode() + ((this.targets.hashCode() + ((bjs.e(this.aPackage, getClass().hashCode() * 31, 31) + this.modifiers) * 31)) * 31);
                        }

                        @Override // net.bytebuddy.dynamic.DynamicType.Builder.ModuleDefinition.OpensDefinition
                        public ModuleDefinition.OpensDefinition<U> to(Collection<String> collection) {
                            LinkedHashSet linkedHashSet = new LinkedHashSet(this.targets);
                            linkedHashSet.addAll(collection);
                            return ModuleDefinitionAdapter.this.new OpensDefinitionAdapter(this.aPackage, this.modifiers, linkedHashSet);
                        }

                        public OpensDefinitionAdapter(String str, int i, Set<String> set) {
                            this.aPackage = str;
                            this.modifiers = i;
                            this.targets = set;
                        }

                        @Override // net.bytebuddy.dynamic.DynamicType.Builder.ModuleDefinition.AbstractBase.Delegator, net.bytebuddy.dynamic.DynamicType.Builder.AbstractBase.Delegator
                        public ModuleDefinition<U> materialize() {
                            LinkedHashMap linkedHashMap = new LinkedHashMap(ModuleDefinitionAdapter.this.opens);
                            linkedHashMap.put(this.aPackage, new ModuleDescription.Opens.Simple(this.targets, this.modifiers));
                            ModuleDefinitionAdapter moduleDefinitionAdapter = ModuleDefinitionAdapter.this;
                            return new ModuleDefinitionAdapter(moduleDefinitionAdapter.name, ModuleDefinitionAdapter.this.modifiers, ModuleDefinitionAdapter.this.version, ModuleDefinitionAdapter.this.mainClass, ModuleDefinitionAdapter.this.packages, ModuleDefinitionAdapter.this.requires, ModuleDefinitionAdapter.this.exports, linkedHashMap, ModuleDefinitionAdapter.this.uses, ModuleDefinitionAdapter.this.provides);
                        }
                    }

                    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
                    @HashCodeAndEqualsPlugin.Enhance(includeSyntheticFields = true)
                    public class RequiresDefinitionAdapter extends ModuleDefinition.RequiresDefinition.Delegator<U> {
                        private final int modifiers;
                        private final String module;

                        @MaybeNull
                        @HashCodeAndEqualsPlugin.ValueHandling(HashCodeAndEqualsPlugin.ValueHandling.Sort.REVERSE_NULLABILITY)
                        private final String version;

                        public RequiresDefinitionAdapter(ModuleDefinitionAdapter moduleDefinitionAdapter, String str, int i) {
                            this(str, i, null);
                        }

                        /* JADX WARN: Code restructure failed: missing block: B:23:0x0036, code lost:
                        
                            if (r2 != null) goto L24;
                         */
                        /*
                            Code decompiled incorrectly, please refer to instructions dump.
                            To view partially-correct add '--show-bad-code' argument
                        */
                        public boolean equals(@net.bytebuddy.utility.nullability.MaybeNull java.lang.Object r5) {
                            /*
                                r4 = this;
                                r0 = 1
                                if (r4 != r5) goto L4
                                return r0
                            L4:
                                r1 = 0
                                if (r5 != 0) goto L8
                                return r1
                            L8:
                                java.lang.Class r2 = r4.getClass()
                                java.lang.Class r3 = r5.getClass()
                                if (r2 == r3) goto L13
                                return r1
                            L13:
                                int r2 = r4.modifiers
                                net.bytebuddy.dynamic.DynamicType$Builder$AbstractBase$Adapter$ModuleDefinitionAdapter$RequiresDefinitionAdapter r5 = (net.bytebuddy.dynamic.DynamicType.Builder.AbstractBase.Adapter.ModuleDefinitionAdapter.RequiresDefinitionAdapter) r5
                                int r3 = r5.modifiers
                                if (r2 == r3) goto L1c
                                return r1
                            L1c:
                                java.lang.String r2 = r4.module
                                java.lang.String r3 = r5.module
                                boolean r2 = r2.equals(r3)
                                if (r2 != 0) goto L27
                                return r1
                            L27:
                                java.lang.String r2 = r4.version
                                java.lang.String r3 = r5.version
                                if (r3 == 0) goto L36
                                if (r2 == 0) goto L38
                                boolean r2 = r2.equals(r3)
                                if (r2 != 0) goto L39
                                return r1
                            L36:
                                if (r2 == 0) goto L39
                            L38:
                                return r1
                            L39:
                                net.bytebuddy.dynamic.DynamicType$Builder$AbstractBase$Adapter$ModuleDefinitionAdapter r2 = net.bytebuddy.dynamic.DynamicType.Builder.AbstractBase.Adapter.ModuleDefinitionAdapter.this
                                net.bytebuddy.dynamic.DynamicType$Builder$AbstractBase$Adapter$ModuleDefinitionAdapter r5 = net.bytebuddy.dynamic.DynamicType.Builder.AbstractBase.Adapter.ModuleDefinitionAdapter.this
                                boolean r5 = r2.equals(r5)
                                if (r5 != 0) goto L44
                                return r1
                            L44:
                                return r0
                            */
                            throw new UnsupportedOperationException("Method not decompiled: net.bytebuddy.dynamic.DynamicType.Builder.AbstractBase.Adapter.ModuleDefinitionAdapter.RequiresDefinitionAdapter.equals(java.lang.Object):boolean");
                        }

                        public int hashCode() {
                            int iE = (bjs.e(this.module, getClass().hashCode() * 31, 31) + this.modifiers) * 31;
                            String str = this.version;
                            if (str != null) {
                                iE += str.hashCode();
                            }
                            return ModuleDefinitionAdapter.this.hashCode() + (iE * 31);
                        }

                        @Override // net.bytebuddy.dynamic.DynamicType.Builder.ModuleDefinition.RequiresDefinition
                        public ModuleDefinition.RequiresDefinition<U> requiredVersion(@MaybeNull String str) {
                            return ModuleDefinitionAdapter.this.new RequiresDefinitionAdapter(this.module, this.modifiers, str);
                        }

                        public RequiresDefinitionAdapter(String str, int i, @MaybeNull String str2) {
                            this.module = str;
                            this.modifiers = i;
                            this.version = str2;
                        }

                        @Override // net.bytebuddy.dynamic.DynamicType.Builder.ModuleDefinition.AbstractBase.Delegator, net.bytebuddy.dynamic.DynamicType.Builder.AbstractBase.Delegator
                        public ModuleDefinition<U> materialize() {
                            LinkedHashMap linkedHashMap = new LinkedHashMap(ModuleDefinitionAdapter.this.requires);
                            linkedHashMap.put(this.module, new ModuleDescription.Requires.Simple(this.version, this.modifiers));
                            ModuleDefinitionAdapter moduleDefinitionAdapter = ModuleDefinitionAdapter.this;
                            return new ModuleDefinitionAdapter(moduleDefinitionAdapter.name, ModuleDefinitionAdapter.this.modifiers, ModuleDefinitionAdapter.this.version, ModuleDefinitionAdapter.this.mainClass, ModuleDefinitionAdapter.this.packages, linkedHashMap, ModuleDefinitionAdapter.this.exports, ModuleDefinitionAdapter.this.opens, ModuleDefinitionAdapter.this.uses, ModuleDefinitionAdapter.this.provides);
                        }
                    }

                    /* JADX WARN: Illegal instructions before constructor call */
                    public ModuleDefinitionAdapter(Adapter adapter, String str, int i) {
                        Set set = Collections.EMPTY_SET;
                        Map mapSingletonMap = "java.base".equals(str) ? Collections.EMPTY_MAP : Collections.singletonMap("java.base", new ModuleDescription.Requires.Simple(null, 32768));
                        Map map = Collections.EMPTY_MAP;
                        this(str, i, null, null, set, mapSingletonMap, map, map, set, map);
                    }

                    /* JADX WARN: Code restructure failed: missing block: B:23:0x0036, code lost:
                    
                        if (r2 != null) goto L24;
                     */
                    /* JADX WARN: Code restructure failed: missing block: B:31:0x0048, code lost:
                    
                        if (r2 != null) goto L32;
                     */
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                        To view partially-correct add '--show-bad-code' argument
                    */
                    public boolean equals(@net.bytebuddy.utility.nullability.MaybeNull java.lang.Object r5) {
                        /*
                            r4 = this;
                            r0 = 1
                            if (r4 != r5) goto L4
                            return r0
                        L4:
                            r1 = 0
                            if (r5 != 0) goto L8
                            return r1
                        L8:
                            java.lang.Class r2 = r4.getClass()
                            java.lang.Class r3 = r5.getClass()
                            if (r2 == r3) goto L13
                            return r1
                        L13:
                            int r2 = r4.modifiers
                            net.bytebuddy.dynamic.DynamicType$Builder$AbstractBase$Adapter$ModuleDefinitionAdapter r5 = (net.bytebuddy.dynamic.DynamicType.Builder.AbstractBase.Adapter.ModuleDefinitionAdapter) r5
                            int r3 = r5.modifiers
                            if (r2 == r3) goto L1c
                            return r1
                        L1c:
                            java.lang.String r2 = r4.name
                            java.lang.String r3 = r5.name
                            boolean r2 = r2.equals(r3)
                            if (r2 != 0) goto L27
                            return r1
                        L27:
                            java.lang.String r2 = r4.version
                            java.lang.String r3 = r5.version
                            if (r3 == 0) goto L36
                            if (r2 == 0) goto L38
                            boolean r2 = r2.equals(r3)
                            if (r2 != 0) goto L39
                            return r1
                        L36:
                            if (r2 == 0) goto L39
                        L38:
                            return r1
                        L39:
                            java.lang.String r2 = r4.mainClass
                            java.lang.String r3 = r5.mainClass
                            if (r3 == 0) goto L48
                            if (r2 == 0) goto L4a
                            boolean r2 = r2.equals(r3)
                            if (r2 != 0) goto L4b
                            return r1
                        L48:
                            if (r2 == 0) goto L4b
                        L4a:
                            return r1
                        L4b:
                            java.util.Set<java.lang.String> r2 = r4.packages
                            java.util.Set<java.lang.String> r3 = r5.packages
                            boolean r2 = r2.equals(r3)
                            if (r2 != 0) goto L56
                            return r1
                        L56:
                            java.util.Map<java.lang.String, net.bytebuddy.description.module.ModuleDescription$Requires> r2 = r4.requires
                            java.util.Map<java.lang.String, net.bytebuddy.description.module.ModuleDescription$Requires> r3 = r5.requires
                            boolean r2 = r2.equals(r3)
                            if (r2 != 0) goto L61
                            return r1
                        L61:
                            java.util.Map<java.lang.String, net.bytebuddy.description.module.ModuleDescription$Exports> r2 = r4.exports
                            java.util.Map<java.lang.String, net.bytebuddy.description.module.ModuleDescription$Exports> r3 = r5.exports
                            boolean r2 = r2.equals(r3)
                            if (r2 != 0) goto L6c
                            return r1
                        L6c:
                            java.util.Map<java.lang.String, net.bytebuddy.description.module.ModuleDescription$Opens> r2 = r4.opens
                            java.util.Map<java.lang.String, net.bytebuddy.description.module.ModuleDescription$Opens> r3 = r5.opens
                            boolean r2 = r2.equals(r3)
                            if (r2 != 0) goto L77
                            return r1
                        L77:
                            java.util.Set<java.lang.String> r2 = r4.uses
                            java.util.Set<java.lang.String> r3 = r5.uses
                            boolean r2 = r2.equals(r3)
                            if (r2 != 0) goto L82
                            return r1
                        L82:
                            java.util.Map<java.lang.String, net.bytebuddy.description.module.ModuleDescription$Provides> r2 = r4.provides
                            java.util.Map<java.lang.String, net.bytebuddy.description.module.ModuleDescription$Provides> r3 = r5.provides
                            boolean r2 = r2.equals(r3)
                            if (r2 != 0) goto L8d
                            return r1
                        L8d:
                            net.bytebuddy.dynamic.DynamicType$Builder$AbstractBase$Adapter r2 = net.bytebuddy.dynamic.DynamicType.Builder.AbstractBase.Adapter.this
                            net.bytebuddy.dynamic.DynamicType$Builder$AbstractBase$Adapter r5 = net.bytebuddy.dynamic.DynamicType.Builder.AbstractBase.Adapter.this
                            boolean r5 = r2.equals(r5)
                            if (r5 != 0) goto L98
                            return r1
                        L98:
                            return r0
                        */
                        throw new UnsupportedOperationException("Method not decompiled: net.bytebuddy.dynamic.DynamicType.Builder.AbstractBase.Adapter.ModuleDefinitionAdapter.equals(java.lang.Object):boolean");
                    }

                    public int hashCode() {
                        int iE = (bjs.e(this.name, getClass().hashCode() * 31, 31) + this.modifiers) * 31;
                        String str = this.version;
                        if (str != null) {
                            iE += str.hashCode();
                        }
                        int iHashCode = iE * 31;
                        String str2 = this.mainClass;
                        if (str2 != null) {
                            iHashCode += str2.hashCode();
                        }
                        return Adapter.this.hashCode() + yg.c(this.provides, (this.uses.hashCode() + yg.c(this.opens, yg.c(this.exports, yg.c(this.requires, (this.packages.hashCode() + (iHashCode * 31)) * 31, 31), 31), 31)) * 31, 31);
                    }

                    @Override // net.bytebuddy.dynamic.DynamicType.Builder.ModuleDefinition
                    public ModuleDefinition<U> mainClass(@MaybeNull String str) {
                        return new ModuleDefinitionAdapter(this.name, this.modifiers, this.version, str, this.packages, this.requires, this.exports, this.opens, this.uses, this.provides);
                    }

                    @Override // net.bytebuddy.dynamic.DynamicType.Builder.AbstractBase.Delegator
                    public Builder<U> materialize() {
                        Adapter adapter = Adapter.this;
                        InstrumentedType.WithFlexibleName withFlexibleName = adapter.instrumentedType;
                        InstrumentedType.WithFlexibleName withFlexibleNameWithModifiers = withFlexibleName.withModuleDescription((ModuleDescription) new ModuleDescription.Latent(this.name, this.modifiers, this.version, this.mainClass, this.packages, this.requires, this.exports, this.opens, this.uses, this.provides, withFlexibleName.getDeclaredAnnotations())).withModifiers(this.modifiers);
                        Adapter adapter2 = Adapter.this;
                        return adapter.materialize(withFlexibleNameWithModifiers, adapter2.fieldRegistry, adapter2.methodRegistry, adapter2.recordComponentRegistry, adapter2.typeAttributeAppender, adapter2.asmVisitorWrapper, adapter2.classFileVersion, adapter2.auxiliaryTypeNamingStrategy, adapter2.annotationValueFilterFactory, adapter2.annotationRetention, adapter2.implementationContextFactory, adapter2.methodGraphCompiler, adapter2.typeValidation, adapter2.visibilityBridgeStrategy, adapter2.classReaderFactory, adapter2.classWriterFactory, adapter2.ignoredMethods, adapter2.auxiliaryTypes);
                    }

                    @Override // net.bytebuddy.dynamic.DynamicType.Builder.ModuleDefinition
                    public ModuleDefinition<U> packages(Collection<String> collection) {
                        LinkedHashSet linkedHashSet = new LinkedHashSet(this.packages);
                        linkedHashSet.addAll(collection);
                        return new ModuleDefinitionAdapter(this.name, this.modifiers, this.version, this.mainClass, linkedHashSet, this.requires, this.exports, this.opens, this.uses, this.provides);
                    }

                    @Override // net.bytebuddy.dynamic.DynamicType.Builder.ModuleDefinition
                    public ModuleDefinition<U> provides(String str, Collection<String> collection) {
                        LinkedHashMap linkedHashMap = new LinkedHashMap(this.provides);
                        linkedHashMap.put(str, new ModuleDescription.Provides.Simple(new LinkedHashSet(collection)));
                        return new ModuleDefinitionAdapter(this.name, this.modifiers, this.version, this.mainClass, this.packages, this.requires, this.exports, this.opens, this.uses, linkedHashMap);
                    }

                    @Override // net.bytebuddy.dynamic.DynamicType.Builder.ModuleDefinition
                    public ModuleDefinition.RequiresDefinition<U> require(String str, int i) {
                        return new RequiresDefinitionAdapter(this, str, i);
                    }

                    @Override // net.bytebuddy.dynamic.DynamicType.Builder.ModuleDefinition
                    public ModuleDefinition<U> uses(Collection<String> collection) {
                        LinkedHashSet linkedHashSet = new LinkedHashSet(this.uses);
                        linkedHashSet.addAll(collection);
                        return new ModuleDefinitionAdapter(this.name, this.modifiers, this.version, this.mainClass, this.packages, this.requires, this.exports, this.opens, linkedHashSet, this.provides);
                    }

                    @Override // net.bytebuddy.dynamic.DynamicType.Builder.ModuleDefinition
                    public ModuleDefinition<U> version(@MaybeNull String str) {
                        return new ModuleDefinitionAdapter(this.name, this.modifiers, str, this.mainClass, this.packages, this.requires, this.exports, this.opens, this.uses, this.provides);
                    }

                    @Override // net.bytebuddy.dynamic.DynamicType.Builder.ModuleDefinition
                    public ModuleDefinition.ExportsDefinition<U> export(String str, int i) {
                        return new ExportsDefinitionAdapter(this, str, i);
                    }

                    @Override // net.bytebuddy.dynamic.DynamicType.Builder.ModuleDefinition
                    public ModuleDefinition.OpensDefinition<U> open(String str, int i) {
                        return new OpensDefinitionAdapter(this, str, i);
                    }

                    public ModuleDefinitionAdapter(String str, int i, @MaybeNull String str2, @MaybeNull String str3, Set<String> set, Map<String, ModuleDescription.Requires> map, Map<String, ModuleDescription.Exports> map2, Map<String, ModuleDescription.Opens> map3, Set<String> set2, Map<String, ModuleDescription.Provides> map4) {
                        this.name = str;
                        this.modifiers = i;
                        this.version = str2;
                        this.mainClass = str3;
                        this.packages = set;
                        this.requires = map;
                        this.exports = map2;
                        this.opens = map3;
                        this.uses = set2;
                        this.provides = map4;
                    }
                }

                /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
                @HashCodeAndEqualsPlugin.Enhance(includeSyntheticFields = true)
                public class OptionalMethodMatchAdapter extends Delegator<U> implements MethodDefinition.ImplementationDefinition.Optional<U> {
                    private final TypeList.Generic interfaces;

                    public OptionalMethodMatchAdapter(TypeList.Generic generic) {
                        this.interfaces = generic;
                    }

                    private MethodDefinition.ImplementationDefinition<U> interfaceType() {
                        ElementMatcher.Junction junctionNone = ElementMatchers.none();
                        Iterator<TypeDescription> it = this.interfaces.asErasures().iterator();
                        while (it.hasNext()) {
                            junctionNone = junctionNone.or(ElementMatchers.isSuperTypeOf(it.next()));
                        }
                        return materialize().invokable(ElementMatchers.isDeclaredBy(ElementMatchers.isInterface().and(junctionNone)));
                    }

                    @Override // net.bytebuddy.dynamic.DynamicType.Builder.MethodDefinition.ImplementationDefinition
                    public MethodDefinition.ReceiverTypeDefinition<U> defaultValue(AnnotationValue<?, ?> annotationValue) {
                        return interfaceType().defaultValue(annotationValue);
                    }

                    public boolean equals(@MaybeNull Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        if (obj == null || getClass() != obj.getClass()) {
                            return false;
                        }
                        OptionalMethodMatchAdapter optionalMethodMatchAdapter = (OptionalMethodMatchAdapter) obj;
                        return this.interfaces.equals(optionalMethodMatchAdapter.interfaces) && Adapter.this.equals(Adapter.this);
                    }

                    public int hashCode() {
                        return Adapter.this.hashCode() + ((this.interfaces.hashCode() + (getClass().hashCode() * 31)) * 31);
                    }

                    @Override // net.bytebuddy.dynamic.DynamicType.Builder.MethodDefinition.ImplementationDefinition
                    public MethodDefinition.ReceiverTypeDefinition<U> intercept(Implementation implementation) {
                        return interfaceType().intercept(implementation);
                    }

                    @Override // net.bytebuddy.dynamic.DynamicType.Builder.AbstractBase.Delegator
                    public Builder<U> materialize() {
                        Adapter adapter = Adapter.this;
                        InstrumentedType.WithFlexibleName withFlexibleNameWithInterfaces = adapter.instrumentedType.withInterfaces(this.interfaces);
                        Adapter adapter2 = Adapter.this;
                        return adapter.materialize(withFlexibleNameWithInterfaces, adapter2.fieldRegistry, adapter2.methodRegistry, adapter2.recordComponentRegistry, adapter2.typeAttributeAppender, adapter2.asmVisitorWrapper, adapter2.classFileVersion, adapter2.auxiliaryTypeNamingStrategy, adapter2.annotationValueFilterFactory, adapter2.annotationRetention, adapter2.implementationContextFactory, adapter2.methodGraphCompiler, adapter2.typeValidation, adapter2.visibilityBridgeStrategy, adapter2.classReaderFactory, adapter2.classWriterFactory, adapter2.ignoredMethods, adapter2.auxiliaryTypes);
                    }

                    @Override // net.bytebuddy.dynamic.DynamicType.Builder.MethodDefinition.ImplementationDefinition
                    public MethodDefinition.ReceiverTypeDefinition<U> withoutCode() {
                        return interfaceType().withoutCode();
                    }

                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // net.bytebuddy.dynamic.DynamicType.Builder.MethodDefinition.ImplementationDefinition
                    public <V> MethodDefinition.ReceiverTypeDefinition<U> defaultValue(V v, Class<? extends V> cls) {
                        return interfaceType().defaultValue(v, cls);
                    }
                }

                /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
                public class RecordComponentMatchAdapter extends RecordComponentDefinition.Optional.AbstractBase<U> {
                    private final LatentMatcher<? super RecordComponentDescription> matcher;
                    private final RecordComponentAttributeAppender.Factory recordComponentAttributeAppenderFactory;
                    private final Transformer<RecordComponentDescription> transformer;

                    public RecordComponentMatchAdapter(Adapter adapter, LatentMatcher<? super RecordComponentDescription> latentMatcher) {
                        this(latentMatcher, RecordComponentAttributeAppender.NoOp.INSTANCE, Transformer.NoOp.make());
                    }

                    @Override // net.bytebuddy.dynamic.DynamicType.Builder.RecordComponentDefinition
                    public RecordComponentDefinition.Optional<U> annotateRecordComponent(Collection<? extends AnnotationDescription> collection) {
                        return attribute(new RecordComponentAttributeAppender.Explicit(new ArrayList(collection)));
                    }

                    @Override // net.bytebuddy.dynamic.DynamicType.Builder.RecordComponentDefinition
                    public RecordComponentDefinition.Optional<U> attribute(RecordComponentAttributeAppender.Factory factory) {
                        return new RecordComponentMatchAdapter(this.matcher, new RecordComponentAttributeAppender.Factory.Compound(this.recordComponentAttributeAppenderFactory, factory), this.transformer);
                    }

                    @Override // net.bytebuddy.dynamic.DynamicType.Builder.AbstractBase.Delegator
                    public Builder<U> materialize() {
                        Adapter adapter = Adapter.this;
                        InstrumentedType.WithFlexibleName withFlexibleName = adapter.instrumentedType;
                        FieldRegistry fieldRegistry = adapter.fieldRegistry;
                        MethodRegistry methodRegistry = adapter.methodRegistry;
                        RecordComponentRegistry recordComponentRegistryPrepend = adapter.recordComponentRegistry.prepend(this.matcher, this.recordComponentAttributeAppenderFactory, this.transformer);
                        Adapter adapter2 = Adapter.this;
                        return adapter.materialize(withFlexibleName, fieldRegistry, methodRegistry, recordComponentRegistryPrepend, adapter2.typeAttributeAppender, adapter2.asmVisitorWrapper, adapter2.classFileVersion, adapter2.auxiliaryTypeNamingStrategy, adapter2.annotationValueFilterFactory, adapter2.annotationRetention, adapter2.implementationContextFactory, adapter2.methodGraphCompiler, adapter2.typeValidation, adapter2.visibilityBridgeStrategy, adapter2.classReaderFactory, adapter2.classWriterFactory, adapter2.ignoredMethods, adapter2.auxiliaryTypes);
                    }

                    @Override // net.bytebuddy.dynamic.DynamicType.Builder.RecordComponentDefinition
                    public RecordComponentDefinition.Optional<U> transform(Transformer<RecordComponentDescription> transformer) {
                        return new RecordComponentMatchAdapter(this.matcher, this.recordComponentAttributeAppenderFactory, new Transformer.Compound(this.transformer, transformer));
                    }

                    public RecordComponentMatchAdapter(LatentMatcher<? super RecordComponentDescription> latentMatcher, RecordComponentAttributeAppender.Factory factory, Transformer<RecordComponentDescription> transformer) {
                        this.matcher = latentMatcher;
                        this.recordComponentAttributeAppenderFactory = factory;
                        this.transformer = transformer;
                    }
                }

                /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
                @HashCodeAndEqualsPlugin.Enhance(includeSyntheticFields = true)
                public class TypeVariableDefinitionAdapter extends TypeVariableDefinition.AbstractBase<U> {
                    private final TypeVariableToken token;

                    public TypeVariableDefinitionAdapter(TypeVariableToken typeVariableToken) {
                        this.token = typeVariableToken;
                    }

                    @Override // net.bytebuddy.dynamic.DynamicType.Builder.TypeVariableDefinition
                    public TypeVariableDefinition<U> annotateTypeVariable(Collection<? extends AnnotationDescription> collection) {
                        return new TypeVariableDefinitionAdapter(new TypeVariableToken(this.token.getSymbol(), this.token.getBounds(), CompoundList.of((List) this.token.getAnnotations(), (List) new ArrayList(collection))));
                    }

                    public boolean equals(@MaybeNull Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        if (obj == null || getClass() != obj.getClass()) {
                            return false;
                        }
                        TypeVariableDefinitionAdapter typeVariableDefinitionAdapter = (TypeVariableDefinitionAdapter) obj;
                        return this.token.equals(typeVariableDefinitionAdapter.token) && Adapter.this.equals(Adapter.this);
                    }

                    public int hashCode() {
                        return Adapter.this.hashCode() + ((this.token.hashCode() + (getClass().hashCode() * 31)) * 31);
                    }

                    @Override // net.bytebuddy.dynamic.DynamicType.Builder.AbstractBase.Delegator
                    public Builder<U> materialize() {
                        Adapter adapter = Adapter.this;
                        InstrumentedType.WithFlexibleName withFlexibleNameWithTypeVariable = adapter.instrumentedType.withTypeVariable(this.token);
                        Adapter adapter2 = Adapter.this;
                        return adapter.materialize(withFlexibleNameWithTypeVariable, adapter2.fieldRegistry, adapter2.methodRegistry, adapter2.recordComponentRegistry, adapter2.typeAttributeAppender, adapter2.asmVisitorWrapper, adapter2.classFileVersion, adapter2.auxiliaryTypeNamingStrategy, adapter2.annotationValueFilterFactory, adapter2.annotationRetention, adapter2.implementationContextFactory, adapter2.methodGraphCompiler, adapter2.typeValidation, adapter2.visibilityBridgeStrategy, adapter2.classReaderFactory, adapter2.classWriterFactory, adapter2.ignoredMethods, adapter2.auxiliaryTypes);
                    }
                }

                public Adapter(InstrumentedType.WithFlexibleName withFlexibleName, FieldRegistry fieldRegistry, MethodRegistry methodRegistry, RecordComponentRegistry recordComponentRegistry, TypeAttributeAppender typeAttributeAppender, AsmVisitorWrapper asmVisitorWrapper, ClassFileVersion classFileVersion, AuxiliaryType.NamingStrategy namingStrategy, AnnotationValueFilter.Factory factory, AnnotationRetention annotationRetention, Implementation.Context.Factory factory2, MethodGraph.Compiler compiler, TypeValidation typeValidation, VisibilityBridgeStrategy visibilityBridgeStrategy, AsmClassReader.Factory factory3, AsmClassWriter.Factory factory4, LatentMatcher<? super MethodDescription> latentMatcher, List<? extends DynamicType> list) {
                    this.instrumentedType = withFlexibleName;
                    this.fieldRegistry = fieldRegistry;
                    this.methodRegistry = methodRegistry;
                    this.recordComponentRegistry = recordComponentRegistry;
                    this.typeAttributeAppender = typeAttributeAppender;
                    this.asmVisitorWrapper = asmVisitorWrapper;
                    this.classFileVersion = classFileVersion;
                    this.auxiliaryTypeNamingStrategy = namingStrategy;
                    this.annotationValueFilterFactory = factory;
                    this.annotationRetention = annotationRetention;
                    this.implementationContextFactory = factory2;
                    this.methodGraphCompiler = compiler;
                    this.typeValidation = typeValidation;
                    this.visibilityBridgeStrategy = visibilityBridgeStrategy;
                    this.classReaderFactory = factory3;
                    this.classWriterFactory = factory4;
                    this.ignoredMethods = latentMatcher;
                    this.auxiliaryTypes = list;
                }

                @Override // net.bytebuddy.dynamic.DynamicType.Builder
                public ModuleDefinition<U> adjustModule(Collection<? extends ModifierContributor.ForModule> collection) {
                    ModuleDescription moduleDescription = this.instrumentedType.toModuleDescription();
                    if (moduleDescription != null) {
                        return new ModuleDefinitionAdapter(moduleDescription.getActualName(), ModifierContributor.Resolver.of(collection).resolve(moduleDescription.getModifiers()), moduleDescription.getVersion(), moduleDescription.getMainClass(), moduleDescription.getPackages(), moduleDescription.getRequires(), moduleDescription.getExports(), moduleDescription.getOpens(), moduleDescription.getUses(), moduleDescription.getProvides());
                    }
                    throw new IllegalStateException("Expected previous module description for " + this.instrumentedType);
                }

                @Override // net.bytebuddy.dynamic.DynamicType.Builder
                public Builder<U> annotateType(Collection<? extends AnnotationDescription> collection) {
                    ModuleDescription moduleDescription = this.instrumentedType.toModuleDescription();
                    return materialize(this.instrumentedType.withAnnotations((List<? extends AnnotationDescription>) new ArrayList(collection)).withModuleDescription(moduleDescription == null ? ModuleDescription.UNDEFINED : new ModuleDescription.Latent(moduleDescription.getActualName(), moduleDescription.getModifiers(), moduleDescription.getVersion(), moduleDescription.getMainClass(), moduleDescription.getPackages(), moduleDescription.getRequires(), moduleDescription.getExports(), moduleDescription.getOpens(), moduleDescription.getUses(), moduleDescription.getProvides(), CompoundList.of((List) this.instrumentedType.getDeclaredAnnotations(), (List) new ArrayList(collection)))), this.fieldRegistry, this.methodRegistry, this.recordComponentRegistry, this.typeAttributeAppender, this.asmVisitorWrapper, this.classFileVersion, this.auxiliaryTypeNamingStrategy, this.annotationValueFilterFactory, this.annotationRetention, this.implementationContextFactory, this.methodGraphCompiler, this.typeValidation, this.visibilityBridgeStrategy, this.classReaderFactory, this.classWriterFactory, this.ignoredMethods, this.auxiliaryTypes);
                }

                @Override // net.bytebuddy.dynamic.DynamicType.Builder
                public Builder<U> attribute(TypeAttributeAppender typeAttributeAppender) {
                    return materialize(this.instrumentedType, this.fieldRegistry, this.methodRegistry, this.recordComponentRegistry, new TypeAttributeAppender.Compound(this.typeAttributeAppender, typeAttributeAppender), this.asmVisitorWrapper, this.classFileVersion, this.auxiliaryTypeNamingStrategy, this.annotationValueFilterFactory, this.annotationRetention, this.implementationContextFactory, this.methodGraphCompiler, this.typeValidation, this.visibilityBridgeStrategy, this.classReaderFactory, this.classWriterFactory, this.ignoredMethods, this.auxiliaryTypes);
                }

                @Override // net.bytebuddy.dynamic.DynamicType.Builder
                public Builder<U> declaredTypes(Collection<? extends TypeDescription> collection) {
                    return materialize(this.instrumentedType.withDeclaredTypes((TypeList) new TypeList.Explicit(new ArrayList(collection))), this.fieldRegistry, this.methodRegistry, this.recordComponentRegistry, this.typeAttributeAppender, this.asmVisitorWrapper, this.classFileVersion, this.auxiliaryTypeNamingStrategy, this.annotationValueFilterFactory, this.annotationRetention, this.implementationContextFactory, this.methodGraphCompiler, this.typeValidation, this.visibilityBridgeStrategy, this.classReaderFactory, this.classWriterFactory, this.ignoredMethods, this.auxiliaryTypes);
                }

                @Override // net.bytebuddy.dynamic.DynamicType.Builder
                public MethodDefinition.ParameterDefinition.Initial<U> defineConstructor(int i) {
                    return new MethodDefinitionAdapter(new MethodDescription.Token(i));
                }

                @Override // net.bytebuddy.dynamic.DynamicType.Builder
                public FieldDefinition.Optional.Valuable<U> defineField(String str, TypeDefinition typeDefinition, int i) {
                    return new FieldDefinitionAdapter(this, new FieldDescription.Token(str, i, typeDefinition.asGenericType()));
                }

                @Override // net.bytebuddy.dynamic.DynamicType.Builder
                public MethodDefinition.ParameterDefinition.Initial<U> defineMethod(String str, TypeDefinition typeDefinition, int i) {
                    return new MethodDefinitionAdapter(new MethodDescription.Token(str, i, typeDefinition.asGenericType()));
                }

                @Override // net.bytebuddy.dynamic.DynamicType.Builder
                public RecordComponentDefinition.Optional<U> defineRecordComponent(String str, TypeDefinition typeDefinition) {
                    return new RecordComponentDefinitionAdapter(this, new RecordComponentDescription.Token(str, typeDefinition.asGenericType()));
                }

                public boolean equals(@MaybeNull Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (obj == null || getClass() != obj.getClass()) {
                        return false;
                    }
                    Adapter adapter = (Adapter) obj;
                    return this.annotationRetention.equals(adapter.annotationRetention) && this.typeValidation.equals(adapter.typeValidation) && this.instrumentedType.equals(adapter.instrumentedType) && this.fieldRegistry.equals(adapter.fieldRegistry) && this.methodRegistry.equals(adapter.methodRegistry) && this.recordComponentRegistry.equals(adapter.recordComponentRegistry) && this.typeAttributeAppender.equals(adapter.typeAttributeAppender) && this.asmVisitorWrapper.equals(adapter.asmVisitorWrapper) && this.classFileVersion.equals(adapter.classFileVersion) && this.auxiliaryTypeNamingStrategy.equals(adapter.auxiliaryTypeNamingStrategy) && this.annotationValueFilterFactory.equals(adapter.annotationValueFilterFactory) && this.implementationContextFactory.equals(adapter.implementationContextFactory) && this.methodGraphCompiler.equals(adapter.methodGraphCompiler) && this.visibilityBridgeStrategy.equals(adapter.visibilityBridgeStrategy) && this.classReaderFactory.equals(adapter.classReaderFactory) && this.classWriterFactory.equals(adapter.classWriterFactory) && this.ignoredMethods.equals(adapter.ignoredMethods) && this.auxiliaryTypes.equals(adapter.auxiliaryTypes);
                }

                @Override // net.bytebuddy.dynamic.DynamicType.Builder
                public FieldDefinition.Valuable<U> field(LatentMatcher<? super FieldDescription> latentMatcher) {
                    return new FieldMatchAdapter(this, latentMatcher);
                }

                public int hashCode() {
                    return this.auxiliaryTypes.hashCode() + ((this.ignoredMethods.hashCode() + ((this.classWriterFactory.hashCode() + ((this.classReaderFactory.hashCode() + ((this.visibilityBridgeStrategy.hashCode() + ((this.typeValidation.hashCode() + ((this.methodGraphCompiler.hashCode() + ((this.implementationContextFactory.hashCode() + ((this.annotationRetention.hashCode() + ((this.annotationValueFilterFactory.hashCode() + ((this.auxiliaryTypeNamingStrategy.hashCode() + ((this.classFileVersion.hashCode() + ((this.asmVisitorWrapper.hashCode() + ((this.typeAttributeAppender.hashCode() + ((this.recordComponentRegistry.hashCode() + ((this.methodRegistry.hashCode() + ((this.fieldRegistry.hashCode() + ((this.instrumentedType.hashCode() + (getClass().hashCode() * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31);
                }

                @Override // net.bytebuddy.dynamic.DynamicType.Builder
                public Builder<U> ignoreAlso(LatentMatcher<? super MethodDescription> latentMatcher) {
                    return materialize(this.instrumentedType, this.fieldRegistry, this.methodRegistry, this.recordComponentRegistry, this.typeAttributeAppender, this.asmVisitorWrapper, this.classFileVersion, this.auxiliaryTypeNamingStrategy, this.annotationValueFilterFactory, this.annotationRetention, this.implementationContextFactory, this.methodGraphCompiler, this.typeValidation, this.visibilityBridgeStrategy, this.classReaderFactory, this.classWriterFactory, new LatentMatcher.Disjunction(this.ignoredMethods, latentMatcher), this.auxiliaryTypes);
                }

                @Override // net.bytebuddy.dynamic.DynamicType.Builder
                public MethodDefinition.ImplementationDefinition.Optional<U> implement(Collection<? extends TypeDefinition> collection) {
                    return new OptionalMethodMatchAdapter(new TypeList.Generic.Explicit(new ArrayList(collection)));
                }

                @Override // net.bytebuddy.dynamic.DynamicType.Builder
                public Builder<U> initializer(ByteCodeAppender byteCodeAppender) {
                    return materialize(this.instrumentedType.withInitializer(byteCodeAppender), this.fieldRegistry, this.methodRegistry, this.recordComponentRegistry, this.typeAttributeAppender, this.asmVisitorWrapper, this.classFileVersion, this.auxiliaryTypeNamingStrategy, this.annotationValueFilterFactory, this.annotationRetention, this.implementationContextFactory, this.methodGraphCompiler, this.typeValidation, this.visibilityBridgeStrategy, this.classReaderFactory, this.classWriterFactory, this.ignoredMethods, this.auxiliaryTypes);
                }

                @Override // net.bytebuddy.dynamic.DynamicType.Builder
                public InnerTypeDefinition.ForType<U> innerTypeOf(TypeDescription typeDescription) {
                    return new InnerTypeDefinitionForTypeAdapter(typeDescription);
                }

                @Override // net.bytebuddy.dynamic.DynamicType.Builder
                public MethodDefinition.ImplementationDefinition<U> invokable(LatentMatcher<? super MethodDescription> latentMatcher) {
                    return new MethodMatchAdapter(latentMatcher);
                }

                public abstract Builder<U> materialize(InstrumentedType.WithFlexibleName withFlexibleName, FieldRegistry fieldRegistry, MethodRegistry methodRegistry, RecordComponentRegistry recordComponentRegistry, TypeAttributeAppender typeAttributeAppender, AsmVisitorWrapper asmVisitorWrapper, ClassFileVersion classFileVersion, AuxiliaryType.NamingStrategy namingStrategy, AnnotationValueFilter.Factory factory, AnnotationRetention annotationRetention, Implementation.Context.Factory factory2, MethodGraph.Compiler compiler, TypeValidation typeValidation, VisibilityBridgeStrategy visibilityBridgeStrategy, AsmClassReader.Factory factory3, AsmClassWriter.Factory factory4, LatentMatcher<? super MethodDescription> latentMatcher, List<? extends DynamicType> list);

                @Override // net.bytebuddy.dynamic.DynamicType.Builder
                public Builder<U> merge(Collection<? extends ModifierContributor.ForType> collection) {
                    return materialize(this.instrumentedType.withModifiers(ModifierContributor.Resolver.of(collection).resolve(this.instrumentedType.getModifiers())), this.fieldRegistry, this.methodRegistry, this.recordComponentRegistry, this.typeAttributeAppender, this.asmVisitorWrapper, this.classFileVersion, this.auxiliaryTypeNamingStrategy, this.annotationValueFilterFactory, this.annotationRetention, this.implementationContextFactory, this.methodGraphCompiler, this.typeValidation, this.visibilityBridgeStrategy, this.classReaderFactory, this.classWriterFactory, this.ignoredMethods, this.auxiliaryTypes);
                }

                @Override // net.bytebuddy.dynamic.DynamicType.Builder
                public Builder<U> modifiers(int i) {
                    return materialize(this.instrumentedType.withModifiers(i), this.fieldRegistry, this.methodRegistry, this.recordComponentRegistry, this.typeAttributeAppender, this.asmVisitorWrapper, this.classFileVersion, this.auxiliaryTypeNamingStrategy, this.annotationValueFilterFactory, this.annotationRetention, this.implementationContextFactory, this.methodGraphCompiler, this.typeValidation, this.visibilityBridgeStrategy, this.classReaderFactory, this.classWriterFactory, this.ignoredMethods, this.auxiliaryTypes);
                }

                @Override // net.bytebuddy.dynamic.DynamicType.Builder
                public ModuleDefinition<U> module(String str, int i) {
                    return new ModuleDefinitionAdapter(this, str, i);
                }

                @Override // net.bytebuddy.dynamic.DynamicType.Builder
                public Builder<U> name(String str) {
                    return materialize(this.instrumentedType.withName(str), this.fieldRegistry, this.methodRegistry, this.recordComponentRegistry, this.typeAttributeAppender, this.asmVisitorWrapper, this.classFileVersion, this.auxiliaryTypeNamingStrategy, this.annotationValueFilterFactory, this.annotationRetention, this.implementationContextFactory, this.methodGraphCompiler, this.typeValidation, this.visibilityBridgeStrategy, this.classReaderFactory, this.classWriterFactory, this.ignoredMethods, this.auxiliaryTypes);
                }

                @Override // net.bytebuddy.dynamic.DynamicType.Builder
                public Builder<U> nestHost(TypeDescription typeDescription) {
                    return materialize(this.instrumentedType.withNestHost(typeDescription), this.fieldRegistry, this.methodRegistry, this.recordComponentRegistry, this.typeAttributeAppender, this.asmVisitorWrapper, this.classFileVersion, this.auxiliaryTypeNamingStrategy, this.annotationValueFilterFactory, this.annotationRetention, this.implementationContextFactory, this.methodGraphCompiler, this.typeValidation, this.visibilityBridgeStrategy, this.classReaderFactory, this.classWriterFactory, this.ignoredMethods, this.auxiliaryTypes);
                }

                @Override // net.bytebuddy.dynamic.DynamicType.Builder
                public Builder<U> nestMembers(Collection<? extends TypeDescription> collection) {
                    return materialize(this.instrumentedType.withNestMembers((TypeList) new TypeList.Explicit(new ArrayList(collection))), this.fieldRegistry, this.methodRegistry, this.recordComponentRegistry, this.typeAttributeAppender, this.asmVisitorWrapper, this.classFileVersion, this.auxiliaryTypeNamingStrategy, this.annotationValueFilterFactory, this.annotationRetention, this.implementationContextFactory, this.methodGraphCompiler, this.typeValidation, this.visibilityBridgeStrategy, this.classReaderFactory, this.classWriterFactory, this.ignoredMethods, this.auxiliaryTypes);
                }

                @Override // net.bytebuddy.dynamic.DynamicType.Builder
                public Builder<U> permittedSubclass(Collection<? extends TypeDescription> collection) {
                    return materialize(this.instrumentedType.withPermittedSubclasses((TypeList) new TypeList.Explicit(new ArrayList(collection))), this.fieldRegistry, this.methodRegistry, this.recordComponentRegistry, this.typeAttributeAppender, this.asmVisitorWrapper, this.classFileVersion, this.auxiliaryTypeNamingStrategy, this.annotationValueFilterFactory, this.annotationRetention, this.implementationContextFactory, this.methodGraphCompiler, this.typeValidation, this.visibilityBridgeStrategy, this.classReaderFactory, this.classWriterFactory, this.ignoredMethods, this.auxiliaryTypes);
                }

                @Override // net.bytebuddy.dynamic.DynamicType.Builder
                public RecordComponentDefinition<U> recordComponent(LatentMatcher<? super RecordComponentDescription> latentMatcher) {
                    return new RecordComponentMatchAdapter(this, latentMatcher);
                }

                @Override // net.bytebuddy.dynamic.DynamicType.Builder
                public Builder<U> require(Collection<DynamicType> collection) {
                    return materialize(this.instrumentedType, this.fieldRegistry, this.methodRegistry, this.recordComponentRegistry, this.typeAttributeAppender, this.asmVisitorWrapper, this.classFileVersion, this.auxiliaryTypeNamingStrategy, this.annotationValueFilterFactory, this.annotationRetention, this.implementationContextFactory, this.methodGraphCompiler, this.typeValidation, this.visibilityBridgeStrategy, this.classReaderFactory, this.classWriterFactory, this.ignoredMethods, CompoundList.of((List) this.auxiliaryTypes, (List) new ArrayList(collection)));
                }

                @Override // net.bytebuddy.dynamic.DynamicType.Builder
                public Builder<U> suffix(String str) {
                    return name(this.instrumentedType.getName() + "$" + str);
                }

                @Override // net.bytebuddy.dynamic.DynamicType.Builder
                public TypeDescription toTypeDescription() {
                    return this.instrumentedType;
                }

                @Override // net.bytebuddy.dynamic.DynamicType.Builder
                public Builder<U> topLevelType() {
                    InstrumentedType.WithFlexibleName withFlexibleName = this.instrumentedType;
                    TypeDescription typeDescription = TypeDescription.UNDEFINED;
                    return materialize(withFlexibleName.withDeclaringType(typeDescription).withEnclosingType(typeDescription).withLocalClass(false), this.fieldRegistry, this.methodRegistry, this.recordComponentRegistry, this.typeAttributeAppender, this.asmVisitorWrapper, this.classFileVersion, this.auxiliaryTypeNamingStrategy, this.annotationValueFilterFactory, this.annotationRetention, this.implementationContextFactory, this.methodGraphCompiler, this.typeValidation, this.visibilityBridgeStrategy, this.classReaderFactory, this.classWriterFactory, this.ignoredMethods, this.auxiliaryTypes);
                }

                @Override // net.bytebuddy.dynamic.DynamicType.Builder
                public Builder<U> transform(ElementMatcher<? super TypeDescription.Generic> elementMatcher, Transformer<TypeVariableToken> transformer) {
                    return materialize(this.instrumentedType.withTypeVariables(elementMatcher, transformer), this.fieldRegistry, this.methodRegistry, this.recordComponentRegistry, this.typeAttributeAppender, this.asmVisitorWrapper, this.classFileVersion, this.auxiliaryTypeNamingStrategy, this.annotationValueFilterFactory, this.annotationRetention, this.implementationContextFactory, this.methodGraphCompiler, this.typeValidation, this.visibilityBridgeStrategy, this.classReaderFactory, this.classWriterFactory, this.ignoredMethods, this.auxiliaryTypes);
                }

                @Override // net.bytebuddy.dynamic.DynamicType.Builder
                public TypeVariableDefinition<U> typeVariable(String str, Collection<? extends TypeDefinition> collection) {
                    return new TypeVariableDefinitionAdapter(new TypeVariableToken(str, new TypeList.Generic.Explicit(new ArrayList(collection))));
                }

                @Override // net.bytebuddy.dynamic.DynamicType.Builder
                public Builder<U> unsealed() {
                    return materialize(this.instrumentedType.withPermittedSubclasses(TypeList.UNDEFINED), this.fieldRegistry, this.methodRegistry, this.recordComponentRegistry, this.typeAttributeAppender, this.asmVisitorWrapper, this.classFileVersion, this.auxiliaryTypeNamingStrategy, this.annotationValueFilterFactory, this.annotationRetention, this.implementationContextFactory, this.methodGraphCompiler, this.typeValidation, this.visibilityBridgeStrategy, this.classReaderFactory, this.classWriterFactory, this.ignoredMethods, this.auxiliaryTypes);
                }

                @Override // net.bytebuddy.dynamic.DynamicType.Builder
                public Builder<U> visit(AsmVisitorWrapper asmVisitorWrapper) {
                    return materialize(this.instrumentedType, this.fieldRegistry, this.methodRegistry, this.recordComponentRegistry, this.typeAttributeAppender, new AsmVisitorWrapper.Compound(this.asmVisitorWrapper, asmVisitorWrapper), this.classFileVersion, this.auxiliaryTypeNamingStrategy, this.annotationValueFilterFactory, this.annotationRetention, this.implementationContextFactory, this.methodGraphCompiler, this.typeValidation, this.visibilityBridgeStrategy, this.classReaderFactory, this.classWriterFactory, this.ignoredMethods, this.auxiliaryTypes);
                }

                @Override // net.bytebuddy.dynamic.DynamicType.Builder
                public Builder<U> initializer(LoadedTypeInitializer loadedTypeInitializer) {
                    return materialize(this.instrumentedType.withInitializer(loadedTypeInitializer), this.fieldRegistry, this.methodRegistry, this.recordComponentRegistry, this.typeAttributeAppender, this.asmVisitorWrapper, this.classFileVersion, this.auxiliaryTypeNamingStrategy, this.annotationValueFilterFactory, this.annotationRetention, this.implementationContextFactory, this.methodGraphCompiler, this.typeValidation, this.visibilityBridgeStrategy, this.classReaderFactory, this.classWriterFactory, this.ignoredMethods, this.auxiliaryTypes);
                }

                @Override // net.bytebuddy.dynamic.DynamicType.Builder
                public InnerTypeDefinition<U> innerTypeOf(MethodDescription.InDefinedShape inDefinedShape) {
                    return inDefinedShape.isTypeInitializer() ? new InnerTypeDefinitionForTypeAdapter(inDefinedShape.getDeclaringType()) : new InnerTypeDefinitionForMethodAdapter(inDefinedShape);
                }

                /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
                @HashCodeAndEqualsPlugin.Enhance(includeSyntheticFields = true)
                public class FieldDefinitionAdapter extends FieldDefinition.Optional.Valuable.AbstractBase.Adapter<U> {
                    private final FieldDescription.Token token;

                    public FieldDefinitionAdapter(Adapter adapter, FieldDescription.Token token) {
                        this(FieldAttributeAppender.ForInstrumentedField.INSTANCE, Transformer.NoOp.make(), FieldDescription.NO_DEFAULT_VALUE, token);
                    }

                    @Override // net.bytebuddy.dynamic.DynamicType.Builder.FieldDefinition
                    public FieldDefinition.Optional<U> annotateField(Collection<? extends AnnotationDescription> collection) {
                        return new FieldDefinitionAdapter(this.fieldAttributeAppenderFactory, this.transformer, this.defaultValue, new FieldDescription.Token(this.token.getName(), this.token.getModifiers(), this.token.getType(), CompoundList.of((List) this.token.getAnnotations(), (List) new ArrayList(collection))));
                    }

                    @Override // net.bytebuddy.dynamic.DynamicType.Builder.FieldDefinition.Optional.Valuable.AbstractBase.Adapter
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
                        FieldDefinitionAdapter fieldDefinitionAdapter = (FieldDefinitionAdapter) obj;
                        return this.token.equals(fieldDefinitionAdapter.token) && Adapter.this.equals(Adapter.this);
                    }

                    @Override // net.bytebuddy.dynamic.DynamicType.Builder.FieldDefinition.Optional.Valuable.AbstractBase.Adapter
                    public int hashCode() {
                        return Adapter.this.hashCode() + ((this.token.hashCode() + (super.hashCode() * 31)) * 31);
                    }

                    @Override // net.bytebuddy.dynamic.DynamicType.Builder.AbstractBase.Delegator
                    public Builder<U> materialize() {
                        Adapter adapter = Adapter.this;
                        InstrumentedType.WithFlexibleName withFlexibleNameWithField = adapter.instrumentedType.withField(this.token);
                        FieldRegistry fieldRegistryPrepend = Adapter.this.fieldRegistry.prepend(new LatentMatcher.ForFieldToken(this.token), this.fieldAttributeAppenderFactory, this.defaultValue, this.transformer);
                        Adapter adapter2 = Adapter.this;
                        return adapter.materialize(withFlexibleNameWithField, fieldRegistryPrepend, adapter2.methodRegistry, adapter2.recordComponentRegistry, adapter2.typeAttributeAppender, adapter2.asmVisitorWrapper, adapter2.classFileVersion, adapter2.auxiliaryTypeNamingStrategy, adapter2.annotationValueFilterFactory, adapter2.annotationRetention, adapter2.implementationContextFactory, adapter2.methodGraphCompiler, adapter2.typeValidation, adapter2.visibilityBridgeStrategy, adapter2.classReaderFactory, adapter2.classWriterFactory, adapter2.ignoredMethods, adapter2.auxiliaryTypes);
                    }

                    public FieldDefinitionAdapter(FieldAttributeAppender.Factory factory, Transformer<FieldDescription> transformer, @MaybeNull Object obj, FieldDescription.Token token) {
                        super(factory, transformer, obj);
                        this.token = token;
                    }

                    @Override // net.bytebuddy.dynamic.DynamicType.Builder.FieldDefinition.Optional.Valuable.AbstractBase.Adapter
                    public FieldDefinition.Optional<U> materialize(FieldAttributeAppender.Factory factory, Transformer<FieldDescription> transformer, @MaybeNull Object obj) {
                        return new FieldDefinitionAdapter(factory, transformer, obj, this.token);
                    }
                }

                /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
                @HashCodeAndEqualsPlugin.Enhance(includeSyntheticFields = true)
                public class FieldMatchAdapter extends FieldDefinition.Optional.Valuable.AbstractBase.Adapter<U> {
                    private final LatentMatcher<? super FieldDescription> matcher;

                    public FieldMatchAdapter(Adapter adapter, LatentMatcher<? super FieldDescription> latentMatcher) {
                        this(FieldAttributeAppender.NoOp.INSTANCE, Transformer.NoOp.make(), FieldDescription.NO_DEFAULT_VALUE, latentMatcher);
                    }

                    @Override // net.bytebuddy.dynamic.DynamicType.Builder.FieldDefinition
                    public FieldDefinition.Optional<U> annotateField(Collection<? extends AnnotationDescription> collection) {
                        return attribute(new FieldAttributeAppender.Explicit(new ArrayList(collection)));
                    }

                    @Override // net.bytebuddy.dynamic.DynamicType.Builder.FieldDefinition.Optional.Valuable.AbstractBase.Adapter
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
                        FieldMatchAdapter fieldMatchAdapter = (FieldMatchAdapter) obj;
                        return this.matcher.equals(fieldMatchAdapter.matcher) && Adapter.this.equals(Adapter.this);
                    }

                    @Override // net.bytebuddy.dynamic.DynamicType.Builder.FieldDefinition.Optional.Valuable.AbstractBase.Adapter
                    public int hashCode() {
                        return Adapter.this.hashCode() + ((this.matcher.hashCode() + (super.hashCode() * 31)) * 31);
                    }

                    @Override // net.bytebuddy.dynamic.DynamicType.Builder.AbstractBase.Delegator
                    public Builder<U> materialize() {
                        Adapter adapter = Adapter.this;
                        InstrumentedType.WithFlexibleName withFlexibleName = adapter.instrumentedType;
                        FieldRegistry fieldRegistryPrepend = adapter.fieldRegistry.prepend(this.matcher, this.fieldAttributeAppenderFactory, this.defaultValue, this.transformer);
                        Adapter adapter2 = Adapter.this;
                        return adapter.materialize(withFlexibleName, fieldRegistryPrepend, adapter2.methodRegistry, adapter2.recordComponentRegistry, adapter2.typeAttributeAppender, adapter2.asmVisitorWrapper, adapter2.classFileVersion, adapter2.auxiliaryTypeNamingStrategy, adapter2.annotationValueFilterFactory, adapter2.annotationRetention, adapter2.implementationContextFactory, adapter2.methodGraphCompiler, adapter2.typeValidation, adapter2.visibilityBridgeStrategy, adapter2.classReaderFactory, adapter2.classWriterFactory, adapter2.ignoredMethods, adapter2.auxiliaryTypes);
                    }

                    public FieldMatchAdapter(FieldAttributeAppender.Factory factory, Transformer<FieldDescription> transformer, @MaybeNull Object obj, LatentMatcher<? super FieldDescription> latentMatcher) {
                        super(factory, transformer, obj);
                        this.matcher = latentMatcher;
                    }

                    @Override // net.bytebuddy.dynamic.DynamicType.Builder.FieldDefinition.Optional.Valuable.AbstractBase.Adapter
                    public FieldDefinition.Optional<U> materialize(FieldAttributeAppender.Factory factory, Transformer<FieldDescription> transformer, @MaybeNull Object obj) {
                        return new FieldMatchAdapter(factory, transformer, obj, this.matcher);
                    }
                }

                /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
                @HashCodeAndEqualsPlugin.Enhance(includeSyntheticFields = true)
                public class RecordComponentDefinitionAdapter extends RecordComponentDefinition.Optional.AbstractBase<U> {
                    private final RecordComponentAttributeAppender.Factory recordComponentAttributeAppenderFactory;
                    private final RecordComponentDescription.Token token;
                    private final Transformer<RecordComponentDescription> transformer;

                    public RecordComponentDefinitionAdapter(Adapter adapter, RecordComponentDescription.Token token) {
                        this(RecordComponentAttributeAppender.ForInstrumentedRecordComponent.INSTANCE, Transformer.NoOp.make(), token);
                    }

                    @Override // net.bytebuddy.dynamic.DynamicType.Builder.RecordComponentDefinition
                    public RecordComponentDefinition.Optional<U> annotateRecordComponent(Collection<? extends AnnotationDescription> collection) {
                        return new RecordComponentDefinitionAdapter(this.recordComponentAttributeAppenderFactory, this.transformer, new RecordComponentDescription.Token(this.token.getName(), this.token.getType(), CompoundList.of((List) this.token.getAnnotations(), (List) new ArrayList(collection))));
                    }

                    @Override // net.bytebuddy.dynamic.DynamicType.Builder.RecordComponentDefinition
                    public RecordComponentDefinition.Optional<U> attribute(RecordComponentAttributeAppender.Factory factory) {
                        return new RecordComponentDefinitionAdapter(new RecordComponentAttributeAppender.Factory.Compound(this.recordComponentAttributeAppenderFactory, factory), this.transformer, this.token);
                    }

                    public boolean equals(@MaybeNull Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        if (obj == null || getClass() != obj.getClass()) {
                            return false;
                        }
                        RecordComponentDefinitionAdapter recordComponentDefinitionAdapter = (RecordComponentDefinitionAdapter) obj;
                        return this.recordComponentAttributeAppenderFactory.equals(recordComponentDefinitionAdapter.recordComponentAttributeAppenderFactory) && this.token.equals(recordComponentDefinitionAdapter.token) && this.transformer.equals(recordComponentDefinitionAdapter.transformer) && Adapter.this.equals(Adapter.this);
                    }

                    public int hashCode() {
                        return Adapter.this.hashCode() + ((this.transformer.hashCode() + ((this.token.hashCode() + ((this.recordComponentAttributeAppenderFactory.hashCode() + (getClass().hashCode() * 31)) * 31)) * 31)) * 31);
                    }

                    @Override // net.bytebuddy.dynamic.DynamicType.Builder.AbstractBase.Delegator
                    public Builder<U> materialize() {
                        Adapter adapter = Adapter.this;
                        InstrumentedType.WithFlexibleName withFlexibleNameWithRecordComponent = adapter.instrumentedType.withRecordComponent(this.token);
                        Adapter adapter2 = Adapter.this;
                        FieldRegistry fieldRegistry = adapter2.fieldRegistry;
                        MethodRegistry methodRegistry = adapter2.methodRegistry;
                        RecordComponentRegistry recordComponentRegistryPrepend = adapter2.recordComponentRegistry.prepend(new LatentMatcher.ForRecordComponentToken(this.token), this.recordComponentAttributeAppenderFactory, this.transformer);
                        Adapter adapter3 = Adapter.this;
                        return adapter.materialize(withFlexibleNameWithRecordComponent, fieldRegistry, methodRegistry, recordComponentRegistryPrepend, adapter3.typeAttributeAppender, adapter3.asmVisitorWrapper, adapter3.classFileVersion, adapter3.auxiliaryTypeNamingStrategy, adapter3.annotationValueFilterFactory, adapter3.annotationRetention, adapter3.implementationContextFactory, adapter3.methodGraphCompiler, adapter3.typeValidation, adapter3.visibilityBridgeStrategy, adapter3.classReaderFactory, adapter3.classWriterFactory, adapter3.ignoredMethods, adapter3.auxiliaryTypes);
                    }

                    @Override // net.bytebuddy.dynamic.DynamicType.Builder.RecordComponentDefinition
                    public RecordComponentDefinition.Optional<U> transform(Transformer<RecordComponentDescription> transformer) {
                        return new RecordComponentDefinitionAdapter(this.recordComponentAttributeAppenderFactory, new Transformer.Compound(this.transformer, transformer), this.token);
                    }

                    public RecordComponentDefinitionAdapter(RecordComponentAttributeAppender.Factory factory, Transformer<RecordComponentDescription> transformer, RecordComponentDescription.Token token) {
                        this.recordComponentAttributeAppenderFactory = factory;
                        this.transformer = transformer;
                        this.token = token;
                    }
                }
            }

            /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
            public static abstract class Delegator<U> extends AbstractBase<U> {
                @Override // net.bytebuddy.dynamic.DynamicType.Builder.AbstractBase, net.bytebuddy.dynamic.DynamicType.Builder
                public ModuleDefinition<U> adjustModule(ModifierContributor.ForModule... forModuleArr) {
                    return materialize().adjustModule(forModuleArr);
                }

                @Override // net.bytebuddy.dynamic.DynamicType.Builder
                public Builder<U> annotateType(Collection<? extends AnnotationDescription> collection) {
                    return materialize().annotateType(collection);
                }

                @Override // net.bytebuddy.dynamic.DynamicType.Builder
                public Builder<U> attribute(TypeAttributeAppender typeAttributeAppender) {
                    return materialize().attribute(typeAttributeAppender);
                }

                @Override // net.bytebuddy.dynamic.DynamicType.Builder
                public Builder<U> declaredTypes(Collection<? extends TypeDescription> collection) {
                    return materialize().declaredTypes(collection);
                }

                @Override // net.bytebuddy.dynamic.DynamicType.Builder.AbstractBase, net.bytebuddy.dynamic.DynamicType.Builder
                public RecordComponentDefinition.Optional<U> define(RecordComponentDescription recordComponentDescription) {
                    return materialize().define(recordComponentDescription);
                }

                @Override // net.bytebuddy.dynamic.DynamicType.Builder
                public MethodDefinition.ParameterDefinition.Initial<U> defineConstructor(int i) {
                    return materialize().defineConstructor(i);
                }

                @Override // net.bytebuddy.dynamic.DynamicType.Builder
                public FieldDefinition.Optional.Valuable<U> defineField(String str, TypeDefinition typeDefinition, int i) {
                    return materialize().defineField(str, typeDefinition, i);
                }

                @Override // net.bytebuddy.dynamic.DynamicType.Builder
                public MethodDefinition.ParameterDefinition.Initial<U> defineMethod(String str, TypeDefinition typeDefinition, int i) {
                    return materialize().defineMethod(str, typeDefinition, i);
                }

                @Override // net.bytebuddy.dynamic.DynamicType.Builder
                public RecordComponentDefinition.Optional<U> defineRecordComponent(String str, TypeDefinition typeDefinition) {
                    return materialize().defineRecordComponent(str, typeDefinition);
                }

                @Override // net.bytebuddy.dynamic.DynamicType.Builder
                public FieldDefinition.Valuable<U> field(LatentMatcher<? super FieldDescription> latentMatcher) {
                    return materialize().field(latentMatcher);
                }

                @Override // net.bytebuddy.dynamic.DynamicType.Builder.AbstractBase, net.bytebuddy.dynamic.DynamicType.Builder
                public Builder<U> ignoreAlso(ElementMatcher<? super MethodDescription> elementMatcher) {
                    return materialize().ignoreAlso(elementMatcher);
                }

                @Override // net.bytebuddy.dynamic.DynamicType.Builder
                public MethodDefinition.ImplementationDefinition.Optional<U> implement(Collection<? extends TypeDefinition> collection) {
                    return materialize().implement(collection);
                }

                @Override // net.bytebuddy.dynamic.DynamicType.Builder
                public Builder<U> initializer(LoadedTypeInitializer loadedTypeInitializer) {
                    return materialize().initializer(loadedTypeInitializer);
                }

                @Override // net.bytebuddy.dynamic.DynamicType.Builder
                public InnerTypeDefinition.ForType<U> innerTypeOf(TypeDescription typeDescription) {
                    return materialize().innerTypeOf(typeDescription);
                }

                @Override // net.bytebuddy.dynamic.DynamicType.Builder
                public MethodDefinition.ImplementationDefinition<U> invokable(LatentMatcher<? super MethodDescription> latentMatcher) {
                    return materialize().invokable(latentMatcher);
                }

                @Override // net.bytebuddy.dynamic.DynamicType.Builder.AbstractBase, net.bytebuddy.dynamic.DynamicType.Builder
                public Unloaded<U> make() {
                    return materialize().make();
                }

                public abstract Builder<U> materialize();

                @Override // net.bytebuddy.dynamic.DynamicType.Builder
                public Builder<U> merge(Collection<? extends ModifierContributor.ForType> collection) {
                    return materialize().merge(collection);
                }

                @Override // net.bytebuddy.dynamic.DynamicType.Builder
                public Builder<U> modifiers(int i) {
                    return materialize().modifiers(i);
                }

                @Override // net.bytebuddy.dynamic.DynamicType.Builder
                public ModuleDefinition<U> module(String str, int i) {
                    return materialize().module(str, i);
                }

                @Override // net.bytebuddy.dynamic.DynamicType.Builder
                public Builder<U> name(String str) {
                    return materialize().name(str);
                }

                @Override // net.bytebuddy.dynamic.DynamicType.Builder
                public Builder<U> nestHost(TypeDescription typeDescription) {
                    return materialize().nestHost(typeDescription);
                }

                @Override // net.bytebuddy.dynamic.DynamicType.Builder
                public Builder<U> nestMembers(Collection<? extends TypeDescription> collection) {
                    return materialize().nestMembers(collection);
                }

                @Override // net.bytebuddy.dynamic.DynamicType.Builder
                public Builder<U> permittedSubclass(Collection<? extends TypeDescription> collection) {
                    return materialize().permittedSubclass(collection);
                }

                @Override // net.bytebuddy.dynamic.DynamicType.Builder.AbstractBase, net.bytebuddy.dynamic.DynamicType.Builder
                public RecordComponentDefinition<U> recordComponent(ElementMatcher<? super RecordComponentDescription> elementMatcher) {
                    return materialize().recordComponent(elementMatcher);
                }

                @Override // net.bytebuddy.dynamic.DynamicType.Builder
                public Builder<U> require(Collection<DynamicType> collection) {
                    return materialize().require(collection);
                }

                @Override // net.bytebuddy.dynamic.DynamicType.Builder
                public Builder<U> suffix(String str) {
                    return materialize().suffix(str);
                }

                @Override // net.bytebuddy.dynamic.DynamicType.Builder
                public TypeDescription toTypeDescription() {
                    return materialize().toTypeDescription();
                }

                @Override // net.bytebuddy.dynamic.DynamicType.Builder
                public Builder<U> topLevelType() {
                    return materialize().topLevelType();
                }

                @Override // net.bytebuddy.dynamic.DynamicType.Builder
                public Builder<U> transform(ElementMatcher<? super TypeDescription.Generic> elementMatcher, Transformer<TypeVariableToken> transformer) {
                    return materialize().transform(elementMatcher, transformer);
                }

                @Override // net.bytebuddy.dynamic.DynamicType.Builder
                public TypeVariableDefinition<U> typeVariable(String str, Collection<? extends TypeDefinition> collection) {
                    return materialize().typeVariable(str, collection);
                }

                @Override // net.bytebuddy.dynamic.DynamicType.Builder
                public Builder<U> unsealed() {
                    return materialize().unsealed();
                }

                @Override // net.bytebuddy.dynamic.DynamicType.Builder
                public Builder<U> visit(AsmVisitorWrapper asmVisitorWrapper) {
                    return materialize().visit(asmVisitorWrapper);
                }

                @Override // net.bytebuddy.dynamic.DynamicType.Builder
                public ContextClassVisitor wrap(ClassVisitor classVisitor, int i, int i2) {
                    return materialize().wrap(classVisitor, i, i2);
                }

                @Override // net.bytebuddy.dynamic.DynamicType.Builder
                public ModuleDefinition<U> adjustModule(Collection<? extends ModifierContributor.ForModule> collection) {
                    return materialize().adjustModule(collection);
                }

                @Override // net.bytebuddy.dynamic.DynamicType.Builder
                public Builder<U> ignoreAlso(LatentMatcher<? super MethodDescription> latentMatcher) {
                    return materialize().ignoreAlso(latentMatcher);
                }

                @Override // net.bytebuddy.dynamic.DynamicType.Builder
                public Builder<U> initializer(ByteCodeAppender byteCodeAppender) {
                    return materialize().initializer(byteCodeAppender);
                }

                @Override // net.bytebuddy.dynamic.DynamicType.Builder
                public InnerTypeDefinition<U> innerTypeOf(MethodDescription.InDefinedShape inDefinedShape) {
                    return materialize().innerTypeOf(inDefinedShape);
                }

                @Override // net.bytebuddy.dynamic.DynamicType.Builder
                public Unloaded<U> make(TypeResolutionStrategy typeResolutionStrategy) {
                    return materialize().make(typeResolutionStrategy);
                }

                @Override // net.bytebuddy.dynamic.DynamicType.Builder
                public RecordComponentDefinition<U> recordComponent(LatentMatcher<? super RecordComponentDescription> latentMatcher) {
                    return materialize().recordComponent(latentMatcher);
                }

                @Override // net.bytebuddy.dynamic.DynamicType.Builder
                public ContextClassVisitor wrap(ClassVisitor classVisitor, TypePool typePool, int i, int i2) {
                    return materialize().wrap(classVisitor, typePool, i, i2);
                }

                @Override // net.bytebuddy.dynamic.DynamicType.Builder.AbstractBase, net.bytebuddy.dynamic.DynamicType.Builder
                public Unloaded<U> make(TypePool typePool) {
                    return materialize().make(typePool);
                }

                @Override // net.bytebuddy.dynamic.DynamicType.Builder
                public Unloaded<U> make(TypeResolutionStrategy typeResolutionStrategy, TypePool typePool) {
                    return materialize().make(typeResolutionStrategy, typePool);
                }
            }

            /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
            public static abstract class UsingTypeWriter<U> extends AbstractBase<U> {
                @Override // net.bytebuddy.dynamic.DynamicType.Builder
                public Unloaded<U> make(TypeResolutionStrategy typeResolutionStrategy) {
                    return toTypeWriter().make(typeResolutionStrategy.resolve());
                }

                public abstract TypeWriter<U> toTypeWriter();

                public abstract TypeWriter<U> toTypeWriter(TypePool typePool);

                @Override // net.bytebuddy.dynamic.DynamicType.Builder
                public ContextClassVisitor wrap(ClassVisitor classVisitor, int i, int i2) {
                    return toTypeWriter().wrap(classVisitor, i, i2);
                }

                @Override // net.bytebuddy.dynamic.DynamicType.Builder
                public Unloaded<U> make(TypeResolutionStrategy typeResolutionStrategy, TypePool typePool) {
                    return toTypeWriter(typePool).make(typeResolutionStrategy.resolve());
                }

                @Override // net.bytebuddy.dynamic.DynamicType.Builder
                public ContextClassVisitor wrap(ClassVisitor classVisitor, TypePool typePool, int i, int i2) {
                    return toTypeWriter(typePool).wrap(classVisitor, i, i2);
                }
            }

            @Override // net.bytebuddy.dynamic.DynamicType.Builder
            public ModuleDefinition<S> adjustModule(ModifierContributor.ForModule... forModuleArr) {
                return adjustModule(Arrays.asList(forModuleArr));
            }

            @Override // net.bytebuddy.dynamic.DynamicType.Builder
            public Builder<S> annotateType(Annotation... annotationArr) {
                return annotateType(Arrays.asList(annotationArr));
            }

            @Override // net.bytebuddy.dynamic.DynamicType.Builder
            public MethodDefinition.ImplementationDefinition<S> constructor(ElementMatcher<? super MethodDescription> elementMatcher) {
                return invokable(ElementMatchers.isConstructor().and(elementMatcher));
            }

            @Override // net.bytebuddy.dynamic.DynamicType.Builder
            public Builder<S> declaredTypes(Class<?>... clsArr) {
                return declaredTypes(Arrays.asList(clsArr));
            }

            @Override // net.bytebuddy.dynamic.DynamicType.Builder
            public RecordComponentDefinition.Optional<S> define(RecordComponentDescription recordComponentDescription) {
                return defineRecordComponent(recordComponentDescription.getActualName(), recordComponentDescription.getType());
            }

            @Override // net.bytebuddy.dynamic.DynamicType.Builder
            public MethodDefinition.ParameterDefinition.Initial<S> defineConstructor(ModifierContributor.ForMethod... forMethodArr) {
                return defineConstructor(Arrays.asList(forMethodArr));
            }

            @Override // net.bytebuddy.dynamic.DynamicType.Builder
            public FieldDefinition.Optional.Valuable<S> defineField(String str, Type type, ModifierContributor.ForField... forFieldArr) {
                return defineField(str, type, Arrays.asList(forFieldArr));
            }

            @Override // net.bytebuddy.dynamic.DynamicType.Builder
            public MethodDefinition.ParameterDefinition.Initial<S> defineMethod(String str, Type type, ModifierContributor.ForMethod... forMethodArr) {
                return defineMethod(str, type, Arrays.asList(forMethodArr));
            }

            @Override // net.bytebuddy.dynamic.DynamicType.Builder
            public FieldDefinition.Optional<S> defineProperty(String str, Type type) {
                return defineProperty(str, TypeDefinition.Sort.describe(type));
            }

            @Override // net.bytebuddy.dynamic.DynamicType.Builder
            public RecordComponentDefinition.Optional<S> defineRecordComponent(String str, Type type) {
                return defineRecordComponent(str, TypeDefinition.Sort.describe(type));
            }

            @Override // net.bytebuddy.dynamic.DynamicType.Builder
            public FieldDefinition.Valuable<S> field(ElementMatcher<? super FieldDescription> elementMatcher) {
                return field(new LatentMatcher.Resolved(elementMatcher));
            }

            @Override // net.bytebuddy.dynamic.DynamicType.Builder
            public Builder<S> ignoreAlso(ElementMatcher<? super MethodDescription> elementMatcher) {
                return ignoreAlso(new LatentMatcher.Resolved(elementMatcher));
            }

            @Override // net.bytebuddy.dynamic.DynamicType.Builder
            public MethodDefinition.ImplementationDefinition.Optional<S> implement(Type... typeArr) {
                return implement(Arrays.asList(typeArr));
            }

            @Override // net.bytebuddy.dynamic.DynamicType.Builder
            public InnerTypeDefinition.ForType<S> innerTypeOf(Class<?> cls) {
                return innerTypeOf(TypeDescription.ForLoadedType.of(cls));
            }

            @Override // net.bytebuddy.dynamic.DynamicType.Builder
            public MethodDefinition.ImplementationDefinition<S> invokable(ElementMatcher<? super MethodDescription> elementMatcher) {
                return invokable(new LatentMatcher.Resolved(elementMatcher));
            }

            @Override // net.bytebuddy.dynamic.DynamicType.Builder
            public Unloaded<S> make(TypePool typePool) {
                return make(TypeResolutionStrategy.Passive.INSTANCE, typePool);
            }

            @Override // net.bytebuddy.dynamic.DynamicType.Builder
            public Builder<S> merge(ModifierContributor.ForType... forTypeArr) {
                return merge(Arrays.asList(forTypeArr));
            }

            @Override // net.bytebuddy.dynamic.DynamicType.Builder
            public MethodDefinition.ImplementationDefinition<S> method(ElementMatcher<? super MethodDescription> elementMatcher) {
                return invokable(ElementMatchers.isMethod().and(elementMatcher));
            }

            @Override // net.bytebuddy.dynamic.DynamicType.Builder
            public Builder<S> modifiers(ModifierContributor.ForType... forTypeArr) {
                return modifiers(Arrays.asList(forTypeArr));
            }

            @Override // net.bytebuddy.dynamic.DynamicType.Builder
            public ModuleDefinition<S> module(String str, ModifierContributor.ForModule... forModuleArr) {
                return module(str, Arrays.asList(forModuleArr));
            }

            @Override // net.bytebuddy.dynamic.DynamicType.Builder
            public Builder<S> nestHost(Class<?> cls) {
                return nestHost(TypeDescription.ForLoadedType.of(cls));
            }

            @Override // net.bytebuddy.dynamic.DynamicType.Builder
            public Builder<S> nestMembers(Class<?>... clsArr) {
                return nestMembers(Arrays.asList(clsArr));
            }

            @Override // net.bytebuddy.dynamic.DynamicType.Builder
            public Builder<S> noNestMate() {
                return nestHost(TargetType.DESCRIPTION);
            }

            @Override // net.bytebuddy.dynamic.DynamicType.Builder
            public Builder<S> permittedSubclass(Class<?>... clsArr) {
                return permittedSubclass(Arrays.asList(clsArr));
            }

            @Override // net.bytebuddy.dynamic.DynamicType.Builder
            public RecordComponentDefinition<S> recordComponent(ElementMatcher<? super RecordComponentDescription> elementMatcher) {
                return recordComponent(new LatentMatcher.Resolved(elementMatcher));
            }

            @Override // net.bytebuddy.dynamic.DynamicType.Builder
            public Builder<S> require(TypeDescription typeDescription, byte[] bArr) {
                return require(typeDescription, bArr, LoadedTypeInitializer.NoOp.INSTANCE);
            }

            @Override // net.bytebuddy.dynamic.DynamicType.Builder
            public FieldDefinition.Optional<S> serialVersionUid(long j) {
                return defineField("serialVersionUID", Long.TYPE, Visibility.PRIVATE, FieldManifestation.FINAL, Ownership.STATIC).value(j);
            }

            @Override // net.bytebuddy.dynamic.DynamicType.Builder
            public TypeVariableDefinition<S> typeVariable(String str) {
                return typeVariable(str, TypeDescription.Generic.OfNonGenericType.ForLoadedType.of(Object.class));
            }

            @Override // net.bytebuddy.dynamic.DynamicType.Builder
            public Builder<S> withHashCodeEquals() {
                return method(ElementMatchers.isHashCode()).intercept(HashCodeMethod.usingDefaultOffset().withIgnoredFields(ElementMatchers.isSynthetic())).method(ElementMatchers.isEquals()).intercept(EqualsMethod.isolated().withIgnoredFields(ElementMatchers.isSynthetic()));
            }

            @Override // net.bytebuddy.dynamic.DynamicType.Builder
            public Builder<S> withToString() {
                return method(ElementMatchers.isToString()).intercept(ToStringMethod.prefixedBySimpleClassName());
            }

            @Override // net.bytebuddy.dynamic.DynamicType.Builder
            public ContextClassVisitor wrap(ClassVisitor classVisitor) {
                return wrap(classVisitor, 0, 0);
            }

            @Override // net.bytebuddy.dynamic.DynamicType.Builder
            public Builder<S> annotateType(List<? extends Annotation> list) {
                return annotateType((Collection<? extends AnnotationDescription>) new AnnotationList.ForLoadedAnnotations(list));
            }

            @Override // net.bytebuddy.dynamic.DynamicType.Builder
            public Builder<S> declaredTypes(TypeDescription... typeDescriptionArr) {
                return declaredTypes((Collection<? extends TypeDescription>) Arrays.asList(typeDescriptionArr));
            }

            @Override // net.bytebuddy.dynamic.DynamicType.Builder
            public FieldDefinition.Optional.Valuable<S> define(Field field) {
                return define(new FieldDescription.ForLoadedField(field));
            }

            @Override // net.bytebuddy.dynamic.DynamicType.Builder
            public MethodDefinition.ParameterDefinition.Initial<S> defineConstructor(Collection<? extends ModifierContributor.ForMethod> collection) {
                return defineConstructor(ModifierContributor.Resolver.of(collection).resolve());
            }

            @Override // net.bytebuddy.dynamic.DynamicType.Builder
            public FieldDefinition.Optional.Valuable<S> defineField(String str, Type type, Collection<? extends ModifierContributor.ForField> collection) {
                return defineField(str, type, ModifierContributor.Resolver.of(collection).resolve());
            }

            @Override // net.bytebuddy.dynamic.DynamicType.Builder
            public MethodDefinition.ParameterDefinition.Initial<S> defineMethod(String str, Type type, Collection<? extends ModifierContributor.ForMethod> collection) {
                return defineMethod(str, type, ModifierContributor.Resolver.of(collection).resolve());
            }

            @Override // net.bytebuddy.dynamic.DynamicType.Builder
            public FieldDefinition.Optional<S> defineProperty(String str, Type type, boolean z) {
                return defineProperty(str, TypeDefinition.Sort.describe(type), z);
            }

            @Override // net.bytebuddy.dynamic.DynamicType.Builder
            public MethodDefinition.ImplementationDefinition.Optional<S> implement(List<? extends Type> list) {
                return implement((Collection<? extends TypeDefinition>) new TypeList.Generic.ForLoadedTypes(list));
            }

            @Override // net.bytebuddy.dynamic.DynamicType.Builder
            public InnerTypeDefinition<S> innerTypeOf(Method method) {
                return innerTypeOf(new MethodDescription.ForLoadedMethod(method));
            }

            @Override // net.bytebuddy.dynamic.DynamicType.Builder
            public Unloaded<S> make() {
                return make(TypeResolutionStrategy.Passive.INSTANCE);
            }

            @Override // net.bytebuddy.dynamic.DynamicType.Builder
            public Builder<S> modifiers(Collection<? extends ModifierContributor.ForType> collection) {
                return modifiers(ModifierContributor.Resolver.of(collection).resolve());
            }

            @Override // net.bytebuddy.dynamic.DynamicType.Builder
            public ModuleDefinition<S> module(String str, Collection<? extends ModifierContributor.ForModule> collection) {
                return module(str, ModifierContributor.Resolver.of(collection).resolve());
            }

            @Override // net.bytebuddy.dynamic.DynamicType.Builder
            public Builder<S> nestMembers(TypeDescription... typeDescriptionArr) {
                return nestMembers((Collection<? extends TypeDescription>) Arrays.asList(typeDescriptionArr));
            }

            @Override // net.bytebuddy.dynamic.DynamicType.Builder
            public Builder<S> permittedSubclass(TypeDescription... typeDescriptionArr) {
                return permittedSubclass((Collection<? extends TypeDescription>) Arrays.asList(typeDescriptionArr));
            }

            @Override // net.bytebuddy.dynamic.DynamicType.Builder
            public Builder<S> require(TypeDescription typeDescription, byte[] bArr, LoadedTypeInitializer loadedTypeInitializer) {
                return require(new Default(typeDescription, bArr, loadedTypeInitializer, Collections.EMPTY_LIST));
            }

            @Override // net.bytebuddy.dynamic.DynamicType.Builder
            public TypeVariableDefinition<S> typeVariable(String str, Type... typeArr) {
                return typeVariable(str, Arrays.asList(typeArr));
            }

            @Override // net.bytebuddy.dynamic.DynamicType.Builder
            public ContextClassVisitor wrap(ClassVisitor classVisitor, TypePool typePool) {
                return wrap(classVisitor, typePool, 0, 0);
            }

            @Override // net.bytebuddy.dynamic.DynamicType.Builder
            public Builder<S> annotateType(AnnotationDescription... annotationDescriptionArr) {
                return annotateType((Collection<? extends AnnotationDescription>) Arrays.asList(annotationDescriptionArr));
            }

            @Override // net.bytebuddy.dynamic.DynamicType.Builder
            public Builder<S> declaredTypes(List<? extends Class<?>> list) {
                return declaredTypes((Collection<? extends TypeDescription>) new TypeList.ForLoadedTypes(list));
            }

            @Override // net.bytebuddy.dynamic.DynamicType.Builder
            public FieldDefinition.Optional.Valuable<S> define(FieldDescription fieldDescription) {
                return defineField(fieldDescription.getName(), fieldDescription.getType(), fieldDescription.getModifiers());
            }

            @Override // net.bytebuddy.dynamic.DynamicType.Builder
            public FieldDefinition.Optional.Valuable<S> defineField(String str, Type type, int i) {
                return defineField(str, TypeDefinition.Sort.describe(type), i);
            }

            @Override // net.bytebuddy.dynamic.DynamicType.Builder
            public MethodDefinition.ParameterDefinition.Initial<S> defineMethod(String str, Type type, int i) {
                return defineMethod(str, TypeDefinition.Sort.describe(type), i);
            }

            @Override // net.bytebuddy.dynamic.DynamicType.Builder
            public FieldDefinition.Optional<S> defineProperty(String str, TypeDefinition typeDefinition) {
                return defineProperty(str, typeDefinition, false);
            }

            @Override // net.bytebuddy.dynamic.DynamicType.Builder
            public MethodDefinition.ImplementationDefinition.Optional<S> implement(TypeDefinition... typeDefinitionArr) {
                return implement((Collection<? extends TypeDefinition>) Arrays.asList(typeDefinitionArr));
            }

            @Override // net.bytebuddy.dynamic.DynamicType.Builder
            public InnerTypeDefinition<S> innerTypeOf(Constructor<?> constructor) {
                return innerTypeOf(new MethodDescription.ForLoadedConstructor(constructor));
            }

            @Override // net.bytebuddy.dynamic.DynamicType.Builder
            public Builder<S> nestMembers(List<? extends Class<?>> list) {
                return nestMembers((Collection<? extends TypeDescription>) new TypeList.ForLoadedTypes(list));
            }

            @Override // net.bytebuddy.dynamic.DynamicType.Builder
            public Builder<S> permittedSubclass(List<? extends Class<?>> list) {
                return permittedSubclass((Collection<? extends TypeDescription>) new TypeList.ForLoadedTypes(list));
            }

            @Override // net.bytebuddy.dynamic.DynamicType.Builder
            public Builder<S> require(DynamicType... dynamicTypeArr) {
                return require(Arrays.asList(dynamicTypeArr));
            }

            @Override // net.bytebuddy.dynamic.DynamicType.Builder
            public TypeVariableDefinition<S> typeVariable(String str, List<? extends Type> list) {
                return typeVariable(str, (Collection<? extends TypeDefinition>) new TypeList.Generic.ForLoadedTypes(list));
            }

            @Override // net.bytebuddy.dynamic.DynamicType.Builder
            public MethodDefinition.ImplementationDefinition<S> define(Method method) {
                return define(new MethodDescription.ForLoadedMethod(method));
            }

            @Override // net.bytebuddy.dynamic.DynamicType.Builder
            public FieldDefinition.Optional.Valuable<S> defineField(String str, TypeDefinition typeDefinition, ModifierContributor.ForField... forFieldArr) {
                return defineField(str, typeDefinition, Arrays.asList(forFieldArr));
            }

            @Override // net.bytebuddy.dynamic.DynamicType.Builder
            public MethodDefinition.ParameterDefinition.Initial<S> defineMethod(String str, TypeDefinition typeDefinition, ModifierContributor.ForMethod... forMethodArr) {
                return defineMethod(str, typeDefinition, Arrays.asList(forMethodArr));
            }

            @Override // net.bytebuddy.dynamic.DynamicType.Builder
            public FieldDefinition.Optional<S> defineProperty(String str, TypeDefinition typeDefinition, boolean z) {
                FieldManifestation fieldManifestation;
                Builder builderIntercept;
                if (str.length() != 0) {
                    Class cls = Void.TYPE;
                    if (!typeDefinition.represents(cls)) {
                        if (!z) {
                            builderIntercept = defineMethod("set" + Character.toUpperCase(str.charAt(0)) + str.substring(1), cls, Visibility.PUBLIC).withParameters(typeDefinition).intercept(FieldAccessor.ofField(str));
                            fieldManifestation = FieldManifestation.PLAIN;
                        } else {
                            fieldManifestation = FieldManifestation.FINAL;
                            builderIntercept = this;
                        }
                        StringBuilder sb = new StringBuilder();
                        sb.append(typeDefinition.represents(Boolean.TYPE) ? "is" : "get");
                        sb.append(Character.toUpperCase(str.charAt(0)));
                        sb.append(str.substring(1));
                        return builderIntercept.defineMethod(sb.toString(), typeDefinition, Visibility.PUBLIC).intercept(FieldAccessor.ofField(str)).defineField(str, typeDefinition, Visibility.PRIVATE, fieldManifestation);
                    }
                    throw new IllegalArgumentException("A bean property cannot have a void type");
                }
                throw new IllegalArgumentException("A bean property cannot have an empty name");
            }

            @Override // net.bytebuddy.dynamic.DynamicType.Builder
            public TypeVariableDefinition<S> typeVariable(String str, TypeDefinition... typeDefinitionArr) {
                return typeVariable(str, (Collection<? extends TypeDefinition>) Arrays.asList(typeDefinitionArr));
            }

            @Override // net.bytebuddy.dynamic.DynamicType.Builder
            public MethodDefinition.ImplementationDefinition<S> define(Constructor<?> constructor) {
                return define(new MethodDescription.ForLoadedConstructor(constructor));
            }

            @Override // net.bytebuddy.dynamic.DynamicType.Builder
            public FieldDefinition.Optional.Valuable<S> defineField(String str, TypeDefinition typeDefinition, Collection<? extends ModifierContributor.ForField> collection) {
                return defineField(str, typeDefinition, ModifierContributor.Resolver.of(collection).resolve());
            }

            @Override // net.bytebuddy.dynamic.DynamicType.Builder
            public MethodDefinition.ParameterDefinition.Initial<S> defineMethod(String str, TypeDefinition typeDefinition, Collection<? extends ModifierContributor.ForMethod> collection) {
                return defineMethod(str, typeDefinition, ModifierContributor.Resolver.of(collection).resolve());
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r0v17 */
            /* JADX WARN: Type inference failed for: r0v18 */
            /* JADX WARN: Type inference failed for: r0v4, types: [net.bytebuddy.dynamic.DynamicType$Builder$MethodDefinition$ExceptionDefinition] */
            /* JADX WARN: Type inference failed for: r0v5, types: [net.bytebuddy.dynamic.DynamicType$Builder$MethodDefinition$ExceptionDefinition] */
            /* JADX WARN: Type inference failed for: r0v9, types: [net.bytebuddy.dynamic.DynamicType$Builder$MethodDefinition$ParameterDefinition] */
            @Override // net.bytebuddy.dynamic.DynamicType.Builder
            public MethodDefinition.ImplementationDefinition<S> define(MethodDescription methodDescription) {
                MethodDefinition.ParameterDefinition.Initial initialDefineMethod;
                ?? WithParameters;
                if (methodDescription.isConstructor()) {
                    initialDefineMethod = defineConstructor(methodDescription.getModifiers());
                } else {
                    initialDefineMethod = defineMethod(methodDescription.getInternalName(), methodDescription.getReturnType(), methodDescription.getModifiers());
                }
                ParameterList<?> parameters = methodDescription.getParameters();
                if (parameters.hasExplicitMetaData()) {
                    Iterator<?> it = parameters.iterator();
                    WithParameters = initialDefineMethod;
                    while (it.hasNext()) {
                        ParameterDescription parameterDescription = (ParameterDescription) it.next();
                        WithParameters = WithParameters.withParameter(parameterDescription.getType(), parameterDescription.getName(), parameterDescription.getModifiers());
                    }
                } else {
                    WithParameters = initialDefineMethod.withParameters((Collection<? extends TypeDefinition>) parameters.asTypeList());
                }
                MethodDefinition.TypeVariableDefinition typeVariableDefinitionThrowing = WithParameters.throwing(methodDescription.getExceptionTypes());
                for (TypeDescription.Generic generic : methodDescription.getTypeVariables()) {
                    typeVariableDefinitionThrowing = typeVariableDefinitionThrowing.typeVariable(generic.getSymbol(), (Collection<? extends TypeDefinition>) generic.getUpperBounds());
                }
                return typeVariableDefinitionThrowing;
            }
        }

        /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
        public interface FieldDefinition<S> {

            /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
            public interface Optional<U> extends FieldDefinition<U>, Builder<U> {

                /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
                public static abstract class AbstractBase<U> extends AbstractBase.Delegator<U> implements Optional<U> {
                    @Override // net.bytebuddy.dynamic.DynamicType.Builder.FieldDefinition
                    public Optional<U> annotateField(Annotation... annotationArr) {
                        return annotateField(Arrays.asList(annotationArr));
                    }

                    @Override // net.bytebuddy.dynamic.DynamicType.Builder.FieldDefinition
                    public Optional<U> annotateField(List<? extends Annotation> list) {
                        return annotateField((Collection<? extends AnnotationDescription>) new AnnotationList.ForLoadedAnnotations(list));
                    }

                    @Override // net.bytebuddy.dynamic.DynamicType.Builder.FieldDefinition
                    public Optional<U> annotateField(AnnotationDescription... annotationDescriptionArr) {
                        return annotateField((Collection<? extends AnnotationDescription>) Arrays.asList(annotationDescriptionArr));
                    }
                }

                /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
                public interface Valuable<V> extends Valuable<V>, Optional<V> {

                    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
                    public static abstract class AbstractBase<U> extends AbstractBase<U> implements Valuable<U> {

                        /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
                        @HashCodeAndEqualsPlugin.Enhance
                        public static abstract class Adapter<V> extends AbstractBase<V> {

                            @MaybeNull
                            @HashCodeAndEqualsPlugin.ValueHandling(HashCodeAndEqualsPlugin.ValueHandling.Sort.REVERSE_NULLABILITY)
                            protected final Object defaultValue;
                            protected final FieldAttributeAppender.Factory fieldAttributeAppenderFactory;
                            protected final Transformer<FieldDescription> transformer;

                            public Adapter(FieldAttributeAppender.Factory factory, Transformer<FieldDescription> transformer, @MaybeNull Object obj) {
                                this.fieldAttributeAppenderFactory = factory;
                                this.transformer = transformer;
                                this.defaultValue = obj;
                            }

                            @Override // net.bytebuddy.dynamic.DynamicType.Builder.FieldDefinition
                            public Optional<V> attribute(FieldAttributeAppender.Factory factory) {
                                return materialize(new FieldAttributeAppender.Factory.Compound(this.fieldAttributeAppenderFactory, factory), this.transformer, this.defaultValue);
                            }

                            @Override // net.bytebuddy.dynamic.DynamicType.Builder.FieldDefinition.Optional.Valuable.AbstractBase
                            public Optional<V> defaultValue(Object obj) {
                                return materialize(this.fieldAttributeAppenderFactory, this.transformer, obj);
                            }

                            /* JADX WARN: Found duplicated region for block: B:25:0x003d A[RETURN] */
                            public boolean equals(@MaybeNull Object obj) {
                                if (this == obj) {
                                    return true;
                                }
                                if (obj == null || getClass() != obj.getClass()) {
                                    return false;
                                }
                                Adapter adapter = (Adapter) obj;
                                if (!this.fieldAttributeAppenderFactory.equals(adapter.fieldAttributeAppenderFactory) || !this.transformer.equals(adapter.transformer)) {
                                    return false;
                                }
                                Object obj2 = this.defaultValue;
                                Object obj3 = adapter.defaultValue;
                                if (obj3 != null) {
                                    return obj2 != null && obj2.equals(obj3);
                                }
                                if (obj2 != null) {
                                    return false;
                                }
                            }

                            public int hashCode() {
                                int iHashCode = (this.transformer.hashCode() + ((this.fieldAttributeAppenderFactory.hashCode() + (getClass().hashCode() * 31)) * 31)) * 31;
                                Object obj = this.defaultValue;
                                return obj != null ? obj.hashCode() + iHashCode : iHashCode;
                            }

                            public abstract Optional<V> materialize(FieldAttributeAppender.Factory factory, Transformer<FieldDescription> transformer, @MaybeNull Object obj);

                            @Override // net.bytebuddy.dynamic.DynamicType.Builder.FieldDefinition
                            public Optional<V> transform(Transformer<FieldDescription> transformer) {
                                return materialize(this.fieldAttributeAppenderFactory, new Transformer.Compound(this.transformer, transformer), this.defaultValue);
                            }
                        }

                        public abstract Optional<U> defaultValue(Object obj);

                        @Override // net.bytebuddy.dynamic.DynamicType.Builder.FieldDefinition.Valuable
                        public Optional<U> value(boolean z) {
                            return defaultValue(Integer.valueOf(z ? 1 : 0));
                        }

                        @Override // net.bytebuddy.dynamic.DynamicType.Builder.FieldDefinition.Valuable
                        public Optional<U> value(int i) {
                            return defaultValue(Integer.valueOf(i));
                        }

                        @Override // net.bytebuddy.dynamic.DynamicType.Builder.FieldDefinition.Valuable
                        public Optional<U> value(long j) {
                            return defaultValue(Long.valueOf(j));
                        }

                        @Override // net.bytebuddy.dynamic.DynamicType.Builder.FieldDefinition.Valuable
                        public Optional<U> value(float f) {
                            return defaultValue(Float.valueOf(f));
                        }

                        @Override // net.bytebuddy.dynamic.DynamicType.Builder.FieldDefinition.Valuable
                        public Optional<U> value(double d) {
                            return defaultValue(Double.valueOf(d));
                        }

                        @Override // net.bytebuddy.dynamic.DynamicType.Builder.FieldDefinition.Valuable
                        public Optional<U> value(String str) {
                            if (str != null) {
                                return defaultValue(str);
                            }
                            throw new IllegalArgumentException("Cannot define 'null' as constant value");
                        }
                    }
                }
            }

            /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
            public interface Valuable<U> extends FieldDefinition<U> {
                Optional<U> value(double d);

                Optional<U> value(float f);

                Optional<U> value(int i);

                Optional<U> value(long j);

                Optional<U> value(String str);

                Optional<U> value(boolean z);
            }

            Optional<S> annotateField(Collection<? extends AnnotationDescription> collection);

            Optional<S> annotateField(List<? extends Annotation> list);

            Optional<S> annotateField(Annotation... annotationArr);

            Optional<S> annotateField(AnnotationDescription... annotationDescriptionArr);

            Optional<S> attribute(FieldAttributeAppender.Factory factory);

            Optional<S> transform(Transformer<FieldDescription> transformer);
        }

        /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
        public interface InnerTypeDefinition<S> extends Builder<S> {

            /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
            public interface ForType<U> extends InnerTypeDefinition<U> {
                Builder<U> asMemberType();
            }

            Builder<S> asAnonymousType();
        }

        /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
        public interface MethodDefinition<S> extends Builder<S> {

            /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
            public static abstract class AbstractBase<U> extends AbstractBase.Delegator<U> implements MethodDefinition<U> {

                /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
                @HashCodeAndEqualsPlugin.Enhance
                public static abstract class Adapter<V> extends ReceiverTypeDefinition.AbstractBase<V> {
                    protected final MethodRegistry.Handler handler;
                    protected final MethodAttributeAppender.Factory methodAttributeAppenderFactory;
                    protected final Transformer<MethodDescription> transformer;

                    public Adapter(MethodRegistry.Handler handler, MethodAttributeAppender.Factory factory, Transformer<MethodDescription> transformer) {
                        this.handler = handler;
                        this.methodAttributeAppenderFactory = factory;
                        this.transformer = transformer;
                    }

                    @Override // net.bytebuddy.dynamic.DynamicType.Builder.MethodDefinition
                    public MethodDefinition<V> attribute(MethodAttributeAppender.Factory factory) {
                        return materialize(this.handler, new MethodAttributeAppender.Factory.Compound(this.methodAttributeAppenderFactory, factory), this.transformer);
                    }

                    public boolean equals(@MaybeNull Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        if (obj == null || getClass() != obj.getClass()) {
                            return false;
                        }
                        Adapter adapter = (Adapter) obj;
                        return this.handler.equals(adapter.handler) && this.methodAttributeAppenderFactory.equals(adapter.methodAttributeAppenderFactory) && this.transformer.equals(adapter.transformer);
                    }

                    public int hashCode() {
                        return this.transformer.hashCode() + ((this.methodAttributeAppenderFactory.hashCode() + ((this.handler.hashCode() + (getClass().hashCode() * 31)) * 31)) * 31);
                    }

                    public abstract MethodDefinition<V> materialize(MethodRegistry.Handler handler, MethodAttributeAppender.Factory factory, Transformer<MethodDescription> transformer);

                    @Override // net.bytebuddy.dynamic.DynamicType.Builder.MethodDefinition
                    public MethodDefinition<V> transform(Transformer<MethodDescription> transformer) {
                        return materialize(this.handler, this.methodAttributeAppenderFactory, new Transformer.Compound(this.transformer, transformer));
                    }
                }

                @Override // net.bytebuddy.dynamic.DynamicType.Builder.MethodDefinition
                public MethodDefinition<U> annotateMethod(Annotation... annotationArr) {
                    return annotateMethod(Arrays.asList(annotationArr));
                }

                @Override // net.bytebuddy.dynamic.DynamicType.Builder.MethodDefinition
                public MethodDefinition<U> annotateParameter(int i, Annotation... annotationArr) {
                    return annotateParameter(i, Arrays.asList(annotationArr));
                }

                @Override // net.bytebuddy.dynamic.DynamicType.Builder.MethodDefinition
                public MethodDefinition<U> annotateMethod(List<? extends Annotation> list) {
                    return annotateMethod((Collection<? extends AnnotationDescription>) new AnnotationList.ForLoadedAnnotations(list));
                }

                @Override // net.bytebuddy.dynamic.DynamicType.Builder.MethodDefinition
                public MethodDefinition<U> annotateParameter(int i, List<? extends Annotation> list) {
                    return annotateParameter(i, (Collection<? extends AnnotationDescription>) new AnnotationList.ForLoadedAnnotations(list));
                }

                @Override // net.bytebuddy.dynamic.DynamicType.Builder.MethodDefinition
                public MethodDefinition<U> annotateMethod(AnnotationDescription... annotationDescriptionArr) {
                    return annotateMethod((Collection<? extends AnnotationDescription>) Arrays.asList(annotationDescriptionArr));
                }

                @Override // net.bytebuddy.dynamic.DynamicType.Builder.MethodDefinition
                public MethodDefinition<U> annotateParameter(int i, AnnotationDescription... annotationDescriptionArr) {
                    return annotateParameter(i, (Collection<? extends AnnotationDescription>) Arrays.asList(annotationDescriptionArr));
                }
            }

            /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
            public interface ExceptionDefinition<U> extends TypeVariableDefinition<U> {

                /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
                public static abstract class AbstractBase<V> extends TypeVariableDefinition.AbstractBase<V> implements ExceptionDefinition<V> {
                    @Override // net.bytebuddy.dynamic.DynamicType.Builder.MethodDefinition.ExceptionDefinition
                    public ExceptionDefinition<V> throwing(Type... typeArr) {
                        return throwing(Arrays.asList(typeArr));
                    }

                    @Override // net.bytebuddy.dynamic.DynamicType.Builder.MethodDefinition.ExceptionDefinition
                    public ExceptionDefinition<V> throwing(List<? extends Type> list) {
                        return throwing((Collection<? extends TypeDefinition>) new TypeList.Generic.ForLoadedTypes(list));
                    }

                    @Override // net.bytebuddy.dynamic.DynamicType.Builder.MethodDefinition.ExceptionDefinition
                    public ExceptionDefinition<V> throwing(TypeDefinition... typeDefinitionArr) {
                        return throwing((Collection<? extends TypeDefinition>) Arrays.asList(typeDefinitionArr));
                    }
                }

                ExceptionDefinition<U> throwing(Collection<? extends TypeDefinition> collection);

                ExceptionDefinition<U> throwing(List<? extends Type> list);

                ExceptionDefinition<U> throwing(Type... typeArr);

                ExceptionDefinition<U> throwing(TypeDefinition... typeDefinitionArr);
            }

            /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
            public interface ImplementationDefinition<U> {

                /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
                public static abstract class AbstractBase<V> implements ImplementationDefinition<V> {
                    @Override // net.bytebuddy.dynamic.DynamicType.Builder.MethodDefinition.ImplementationDefinition
                    public <W> ReceiverTypeDefinition<V> defaultValue(W w, Class<? extends W> cls) {
                        return defaultValue(AnnotationDescription.ForLoadedAnnotation.asValue(w, cls));
                    }
                }

                /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
                public interface Optional<V> extends ImplementationDefinition<V>, Builder<V> {
                }

                <W> ReceiverTypeDefinition<U> defaultValue(W w, Class<? extends W> cls);

                ReceiverTypeDefinition<U> defaultValue(AnnotationValue<?, ?> annotationValue);

                ReceiverTypeDefinition<U> intercept(Implementation implementation);

                ReceiverTypeDefinition<U> withoutCode();
            }

            /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
            public interface ParameterDefinition<U> extends ExceptionDefinition<U> {

                /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
                public static abstract class AbstractBase<V> extends ExceptionDefinition.AbstractBase<V> implements ParameterDefinition<V> {
                    @Override // net.bytebuddy.dynamic.DynamicType.Builder.MethodDefinition.ParameterDefinition
                    public Annotatable<V> withParameter(Type type, String str, ModifierContributor.ForParameter... forParameterArr) {
                        return withParameter(type, str, Arrays.asList(forParameterArr));
                    }

                    @Override // net.bytebuddy.dynamic.DynamicType.Builder.MethodDefinition.ParameterDefinition
                    public Annotatable<V> withParameter(Type type, String str, Collection<? extends ModifierContributor.ForParameter> collection) {
                        return withParameter(type, str, ModifierContributor.Resolver.of(collection).resolve());
                    }

                    @Override // net.bytebuddy.dynamic.DynamicType.Builder.MethodDefinition.ParameterDefinition
                    public Annotatable<V> withParameter(Type type, String str, int i) {
                        return withParameter(TypeDefinition.Sort.describe(type), str, i);
                    }

                    @Override // net.bytebuddy.dynamic.DynamicType.Builder.MethodDefinition.ParameterDefinition
                    public Annotatable<V> withParameter(TypeDefinition typeDefinition, String str, ModifierContributor.ForParameter... forParameterArr) {
                        return withParameter(typeDefinition, str, Arrays.asList(forParameterArr));
                    }

                    @Override // net.bytebuddy.dynamic.DynamicType.Builder.MethodDefinition.ParameterDefinition
                    public Annotatable<V> withParameter(TypeDefinition typeDefinition, String str, Collection<? extends ModifierContributor.ForParameter> collection) {
                        return withParameter(typeDefinition, str, ModifierContributor.Resolver.of(collection).resolve());
                    }
                }

                /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
                public interface Annotatable<V> extends ParameterDefinition<V> {

                    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
                    public static abstract class AbstractBase<W> extends AbstractBase<W> implements Annotatable<W> {

                        /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
                        public static abstract class Adapter<X> extends AbstractBase<X> {
                            @Override // net.bytebuddy.dynamic.DynamicType.Builder.MethodDefinition.ImplementationDefinition
                            public ReceiverTypeDefinition<X> defaultValue(AnnotationValue<?, ?> annotationValue) {
                                return materialize().defaultValue(annotationValue);
                            }

                            @Override // net.bytebuddy.dynamic.DynamicType.Builder.MethodDefinition.ImplementationDefinition
                            public ReceiverTypeDefinition<X> intercept(Implementation implementation) {
                                return materialize().intercept(implementation);
                            }

                            public abstract ParameterDefinition<X> materialize();

                            @Override // net.bytebuddy.dynamic.DynamicType.Builder.MethodDefinition.ExceptionDefinition
                            public ExceptionDefinition<X> throwing(Collection<? extends TypeDefinition> collection) {
                                return materialize().throwing(collection);
                            }

                            @Override // net.bytebuddy.dynamic.DynamicType.Builder.MethodDefinition.TypeVariableDefinition
                            public TypeVariableDefinition.Annotatable<X> typeVariable(String str, Collection<? extends TypeDefinition> collection) {
                                return materialize().typeVariable(str, collection);
                            }

                            @Override // net.bytebuddy.dynamic.DynamicType.Builder.MethodDefinition.ParameterDefinition
                            public Annotatable<X> withParameter(TypeDefinition typeDefinition, String str, int i) {
                                return materialize().withParameter(typeDefinition, str, i);
                            }

                            @Override // net.bytebuddy.dynamic.DynamicType.Builder.MethodDefinition.ImplementationDefinition
                            public ReceiverTypeDefinition<X> withoutCode() {
                                return materialize().withoutCode();
                            }

                            /* JADX WARN: Multi-variable type inference failed */
                            @Override // net.bytebuddy.dynamic.DynamicType.Builder.MethodDefinition.ImplementationDefinition.AbstractBase, net.bytebuddy.dynamic.DynamicType.Builder.MethodDefinition.ImplementationDefinition
                            public <V> ReceiverTypeDefinition<X> defaultValue(V v, Class<? extends V> cls) {
                                return materialize().defaultValue(v, cls);
                            }
                        }

                        @Override // net.bytebuddy.dynamic.DynamicType.Builder.MethodDefinition.ParameterDefinition.Annotatable
                        public Annotatable<W> annotateParameter(Annotation... annotationArr) {
                            return annotateParameter(Arrays.asList(annotationArr));
                        }

                        @Override // net.bytebuddy.dynamic.DynamicType.Builder.MethodDefinition.ParameterDefinition.Annotatable
                        public Annotatable<W> annotateParameter(List<? extends Annotation> list) {
                            return annotateParameter((Collection<? extends AnnotationDescription>) new AnnotationList.ForLoadedAnnotations(list));
                        }

                        @Override // net.bytebuddy.dynamic.DynamicType.Builder.MethodDefinition.ParameterDefinition.Annotatable
                        public Annotatable<W> annotateParameter(AnnotationDescription... annotationDescriptionArr) {
                            return annotateParameter((Collection<? extends AnnotationDescription>) Arrays.asList(annotationDescriptionArr));
                        }
                    }

                    Annotatable<V> annotateParameter(Collection<? extends AnnotationDescription> collection);

                    Annotatable<V> annotateParameter(List<? extends Annotation> list);

                    Annotatable<V> annotateParameter(Annotation... annotationArr);

                    Annotatable<V> annotateParameter(AnnotationDescription... annotationDescriptionArr);
                }

                /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
                public interface Initial<V> extends ParameterDefinition<V>, Simple<V> {

                    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
                    public static abstract class AbstractBase<W> extends AbstractBase<W> implements Initial<W> {
                        @Override // net.bytebuddy.dynamic.DynamicType.Builder.MethodDefinition.ParameterDefinition.Simple
                        public Simple.Annotatable<W> withParameter(Type type) {
                            return withParameter(TypeDefinition.Sort.describe(type));
                        }

                        @Override // net.bytebuddy.dynamic.DynamicType.Builder.MethodDefinition.ParameterDefinition.Initial
                        public ExceptionDefinition<W> withParameters(Type... typeArr) {
                            return withParameters(Arrays.asList(typeArr));
                        }

                        @Override // net.bytebuddy.dynamic.DynamicType.Builder.MethodDefinition.ParameterDefinition.Initial
                        public ExceptionDefinition<W> withParameters(List<? extends Type> list) {
                            return withParameters((Collection<? extends TypeDefinition>) new TypeList.Generic.ForLoadedTypes(list));
                        }

                        @Override // net.bytebuddy.dynamic.DynamicType.Builder.MethodDefinition.ParameterDefinition.Initial
                        public ExceptionDefinition<W> withParameters(TypeDefinition... typeDefinitionArr) {
                            return withParameters((Collection<? extends TypeDefinition>) Arrays.asList(typeDefinitionArr));
                        }

                        @Override // net.bytebuddy.dynamic.DynamicType.Builder.MethodDefinition.ParameterDefinition.Initial
                        public ExceptionDefinition<W> withParameters(Collection<? extends TypeDefinition> collection) {
                            Iterator<? extends TypeDefinition> it = collection.iterator();
                            Simple simpleWithParameter = this;
                            while (it.hasNext()) {
                                simpleWithParameter = simpleWithParameter.withParameter(it.next());
                            }
                            return simpleWithParameter;
                        }
                    }

                    ExceptionDefinition<V> withParameters(Collection<? extends TypeDefinition> collection);

                    ExceptionDefinition<V> withParameters(List<? extends Type> list);

                    ExceptionDefinition<V> withParameters(Type... typeArr);

                    ExceptionDefinition<V> withParameters(TypeDefinition... typeDefinitionArr);
                }

                /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
                public interface Simple<V> extends ExceptionDefinition<V> {

                    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
                    public static abstract class AbstractBase<W> extends ExceptionDefinition.AbstractBase<W> implements Simple<W> {
                        @Override // net.bytebuddy.dynamic.DynamicType.Builder.MethodDefinition.ParameterDefinition.Simple
                        public Annotatable<W> withParameter(Type type) {
                            return withParameter(TypeDefinition.Sort.describe(type));
                        }
                    }

                    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
                    public interface Annotatable<V> extends Simple<V> {

                        /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
                        public static abstract class AbstractBase<W> extends AbstractBase<W> implements Annotatable<W> {

                            /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
                            public static abstract class Adapter<X> extends AbstractBase<X> {
                                @Override // net.bytebuddy.dynamic.DynamicType.Builder.MethodDefinition.ImplementationDefinition
                                public ReceiverTypeDefinition<X> defaultValue(AnnotationValue<?, ?> annotationValue) {
                                    return materialize().defaultValue(annotationValue);
                                }

                                @Override // net.bytebuddy.dynamic.DynamicType.Builder.MethodDefinition.ImplementationDefinition
                                public ReceiverTypeDefinition<X> intercept(Implementation implementation) {
                                    return materialize().intercept(implementation);
                                }

                                public abstract Simple<X> materialize();

                                @Override // net.bytebuddy.dynamic.DynamicType.Builder.MethodDefinition.ExceptionDefinition
                                public ExceptionDefinition<X> throwing(Collection<? extends TypeDefinition> collection) {
                                    return materialize().throwing(collection);
                                }

                                @Override // net.bytebuddy.dynamic.DynamicType.Builder.MethodDefinition.TypeVariableDefinition
                                public TypeVariableDefinition.Annotatable<X> typeVariable(String str, Collection<? extends TypeDefinition> collection) {
                                    return materialize().typeVariable(str, collection);
                                }

                                @Override // net.bytebuddy.dynamic.DynamicType.Builder.MethodDefinition.ParameterDefinition.Simple
                                public Annotatable<X> withParameter(TypeDefinition typeDefinition) {
                                    return materialize().withParameter(typeDefinition);
                                }

                                @Override // net.bytebuddy.dynamic.DynamicType.Builder.MethodDefinition.ImplementationDefinition
                                public ReceiverTypeDefinition<X> withoutCode() {
                                    return materialize().withoutCode();
                                }

                                /* JADX WARN: Multi-variable type inference failed */
                                @Override // net.bytebuddy.dynamic.DynamicType.Builder.MethodDefinition.ImplementationDefinition.AbstractBase, net.bytebuddy.dynamic.DynamicType.Builder.MethodDefinition.ImplementationDefinition
                                public <V> ReceiverTypeDefinition<X> defaultValue(V v, Class<? extends V> cls) {
                                    return materialize().defaultValue(v, cls);
                                }
                            }

                            @Override // net.bytebuddy.dynamic.DynamicType.Builder.MethodDefinition.ParameterDefinition.Simple.Annotatable
                            public Annotatable<W> annotateParameter(Annotation... annotationArr) {
                                return annotateParameter(Arrays.asList(annotationArr));
                            }

                            @Override // net.bytebuddy.dynamic.DynamicType.Builder.MethodDefinition.ParameterDefinition.Simple.Annotatable
                            public Annotatable<W> annotateParameter(List<? extends Annotation> list) {
                                return annotateParameter((Collection<? extends AnnotationDescription>) new AnnotationList.ForLoadedAnnotations(list));
                            }

                            @Override // net.bytebuddy.dynamic.DynamicType.Builder.MethodDefinition.ParameterDefinition.Simple.Annotatable
                            public Annotatable<W> annotateParameter(AnnotationDescription... annotationDescriptionArr) {
                                return annotateParameter((Collection<? extends AnnotationDescription>) Arrays.asList(annotationDescriptionArr));
                            }
                        }

                        Annotatable<V> annotateParameter(Collection<? extends AnnotationDescription> collection);

                        Annotatable<V> annotateParameter(List<? extends Annotation> list);

                        Annotatable<V> annotateParameter(Annotation... annotationArr);

                        Annotatable<V> annotateParameter(AnnotationDescription... annotationDescriptionArr);
                    }

                    Annotatable<V> withParameter(Type type);

                    Annotatable<V> withParameter(TypeDefinition typeDefinition);
                }

                Annotatable<U> withParameter(Type type, String str, int i);

                Annotatable<U> withParameter(Type type, String str, Collection<? extends ModifierContributor.ForParameter> collection);

                Annotatable<U> withParameter(Type type, String str, ModifierContributor.ForParameter... forParameterArr);

                Annotatable<U> withParameter(TypeDefinition typeDefinition, String str, int i);

                Annotatable<U> withParameter(TypeDefinition typeDefinition, String str, Collection<? extends ModifierContributor.ForParameter> collection);

                Annotatable<U> withParameter(TypeDefinition typeDefinition, String str, ModifierContributor.ForParameter... forParameterArr);
            }

            /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
            public interface ReceiverTypeDefinition<U> extends MethodDefinition<U> {

                /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
                public static abstract class AbstractBase<V> extends AbstractBase<V> implements ReceiverTypeDefinition<V> {
                    @Override // net.bytebuddy.dynamic.DynamicType.Builder.MethodDefinition.ReceiverTypeDefinition
                    public MethodDefinition<V> receiverType(AnnotatedElement annotatedElement) {
                        return receiverType(TypeDefinition.Sort.describeAnnotated(annotatedElement));
                    }
                }

                MethodDefinition<U> receiverType(AnnotatedElement annotatedElement);

                MethodDefinition<U> receiverType(TypeDescription.Generic generic);
            }

            /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
            public interface TypeVariableDefinition<U> extends ImplementationDefinition<U> {

                /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
                public static abstract class AbstractBase<V> extends ImplementationDefinition.AbstractBase<V> implements TypeVariableDefinition<V> {
                    @Override // net.bytebuddy.dynamic.DynamicType.Builder.MethodDefinition.TypeVariableDefinition
                    public Annotatable<V> typeVariable(String str) {
                        return typeVariable(str, Collections.singletonList(Object.class));
                    }

                    @Override // net.bytebuddy.dynamic.DynamicType.Builder.MethodDefinition.TypeVariableDefinition
                    public Annotatable<V> typeVariable(String str, Type... typeArr) {
                        return typeVariable(str, Arrays.asList(typeArr));
                    }

                    @Override // net.bytebuddy.dynamic.DynamicType.Builder.MethodDefinition.TypeVariableDefinition
                    public Annotatable<V> typeVariable(String str, List<? extends Type> list) {
                        return typeVariable(str, (Collection<? extends TypeDefinition>) new TypeList.Generic.ForLoadedTypes(list));
                    }

                    @Override // net.bytebuddy.dynamic.DynamicType.Builder.MethodDefinition.TypeVariableDefinition
                    public Annotatable<V> typeVariable(String str, TypeDefinition... typeDefinitionArr) {
                        return typeVariable(str, (Collection<? extends TypeDefinition>) Arrays.asList(typeDefinitionArr));
                    }
                }

                /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
                public interface Annotatable<V> extends TypeVariableDefinition<V> {

                    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
                    public static abstract class AbstractBase<W> extends AbstractBase<W> implements Annotatable<W> {

                        /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
                        public static abstract class Adapter<X> extends AbstractBase<X> {
                            @Override // net.bytebuddy.dynamic.DynamicType.Builder.MethodDefinition.ImplementationDefinition
                            public ReceiverTypeDefinition<X> defaultValue(AnnotationValue<?, ?> annotationValue) {
                                return materialize().defaultValue(annotationValue);
                            }

                            @Override // net.bytebuddy.dynamic.DynamicType.Builder.MethodDefinition.ImplementationDefinition
                            public ReceiverTypeDefinition<X> intercept(Implementation implementation) {
                                return materialize().intercept(implementation);
                            }

                            public abstract ParameterDefinition<X> materialize();

                            @Override // net.bytebuddy.dynamic.DynamicType.Builder.MethodDefinition.TypeVariableDefinition
                            public Annotatable<X> typeVariable(String str, Collection<? extends TypeDefinition> collection) {
                                return materialize().typeVariable(str, collection);
                            }

                            @Override // net.bytebuddy.dynamic.DynamicType.Builder.MethodDefinition.ImplementationDefinition
                            public ReceiverTypeDefinition<X> withoutCode() {
                                return materialize().withoutCode();
                            }

                            /* JADX WARN: Multi-variable type inference failed */
                            @Override // net.bytebuddy.dynamic.DynamicType.Builder.MethodDefinition.ImplementationDefinition.AbstractBase, net.bytebuddy.dynamic.DynamicType.Builder.MethodDefinition.ImplementationDefinition
                            public <V> ReceiverTypeDefinition<X> defaultValue(V v, Class<? extends V> cls) {
                                return materialize().defaultValue(v, cls);
                            }
                        }

                        @Override // net.bytebuddy.dynamic.DynamicType.Builder.MethodDefinition.TypeVariableDefinition.Annotatable
                        public Annotatable<W> annotateTypeVariable(Annotation... annotationArr) {
                            return annotateTypeVariable(Arrays.asList(annotationArr));
                        }

                        @Override // net.bytebuddy.dynamic.DynamicType.Builder.MethodDefinition.TypeVariableDefinition.Annotatable
                        public Annotatable<W> annotateTypeVariable(List<? extends Annotation> list) {
                            return annotateTypeVariable((Collection<? extends AnnotationDescription>) new AnnotationList.ForLoadedAnnotations(list));
                        }

                        @Override // net.bytebuddy.dynamic.DynamicType.Builder.MethodDefinition.TypeVariableDefinition.Annotatable
                        public Annotatable<W> annotateTypeVariable(AnnotationDescription... annotationDescriptionArr) {
                            return annotateTypeVariable((Collection<? extends AnnotationDescription>) Arrays.asList(annotationDescriptionArr));
                        }
                    }

                    Annotatable<V> annotateTypeVariable(Collection<? extends AnnotationDescription> collection);

                    Annotatable<V> annotateTypeVariable(List<? extends Annotation> list);

                    Annotatable<V> annotateTypeVariable(Annotation... annotationArr);

                    Annotatable<V> annotateTypeVariable(AnnotationDescription... annotationDescriptionArr);
                }

                Annotatable<U> typeVariable(String str);

                Annotatable<U> typeVariable(String str, Collection<? extends TypeDefinition> collection);

                Annotatable<U> typeVariable(String str, List<? extends Type> list);

                Annotatable<U> typeVariable(String str, Type... typeArr);

                Annotatable<U> typeVariable(String str, TypeDefinition... typeDefinitionArr);
            }

            MethodDefinition<S> annotateMethod(Collection<? extends AnnotationDescription> collection);

            MethodDefinition<S> annotateMethod(List<? extends Annotation> list);

            MethodDefinition<S> annotateMethod(Annotation... annotationArr);

            MethodDefinition<S> annotateMethod(AnnotationDescription... annotationDescriptionArr);

            MethodDefinition<S> annotateParameter(int i, Collection<? extends AnnotationDescription> collection);

            MethodDefinition<S> annotateParameter(int i, List<? extends Annotation> list);

            MethodDefinition<S> annotateParameter(int i, Annotation... annotationArr);

            MethodDefinition<S> annotateParameter(int i, AnnotationDescription... annotationDescriptionArr);

            MethodDefinition<S> attribute(MethodAttributeAppender.Factory factory);

            MethodDefinition<S> transform(Transformer<MethodDescription> transformer);
        }

        /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
        public interface ModuleDefinition<S> extends Builder<S> {

            /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
            public static abstract class AbstractBase<U> extends AbstractBase.Delegator<U> implements ModuleDefinition<U> {

                /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
                public static abstract class Delegator<V> extends AbstractBase<V> {
                    @Override // net.bytebuddy.dynamic.DynamicType.Builder.ModuleDefinition
                    public ModuleDefinition<V> export(String str, int i) {
                        return materialize().export(str, i);
                    }

                    @Override // net.bytebuddy.dynamic.DynamicType.Builder.ModuleDefinition
                    public ModuleDefinition<V> mainClass(@MaybeNull String str) {
                        return materialize().mainClass(str);
                    }

                    @Override // net.bytebuddy.dynamic.DynamicType.Builder.AbstractBase.Delegator
                    public abstract ModuleDefinition<V> materialize();

                    @Override // net.bytebuddy.dynamic.DynamicType.Builder.ModuleDefinition
                    public ModuleDefinition<V> open(String str, int i) {
                        return materialize().open(str, i);
                    }

                    @Override // net.bytebuddy.dynamic.DynamicType.Builder.ModuleDefinition
                    public ModuleDefinition<V> packages(Collection<String> collection) {
                        return materialize().packages(collection);
                    }

                    @Override // net.bytebuddy.dynamic.DynamicType.Builder.ModuleDefinition
                    public ModuleDefinition<V> provides(String str, Collection<String> collection) {
                        return materialize().provides(str, collection);
                    }

                    @Override // net.bytebuddy.dynamic.DynamicType.Builder.ModuleDefinition
                    public RequiresDefinition<V> require(String str, int i) {
                        return materialize().require(str, i);
                    }

                    @Override // net.bytebuddy.dynamic.DynamicType.Builder.ModuleDefinition
                    public ModuleDefinition<V> uses(Collection<String> collection) {
                        return materialize().uses(collection);
                    }

                    @Override // net.bytebuddy.dynamic.DynamicType.Builder.ModuleDefinition
                    public ModuleDefinition<V> version(@MaybeNull String str) {
                        return materialize().version(str);
                    }
                }

                @Override // net.bytebuddy.dynamic.DynamicType.Builder.ModuleDefinition
                public ModuleDefinition<U> export(String str, ModifierContributor.ForModule.OfExport... ofExportArr) {
                    return export(str, Arrays.asList(ofExportArr));
                }

                @Override // net.bytebuddy.dynamic.DynamicType.Builder.ModuleDefinition
                public ModuleDefinition<U> exports(String... strArr) {
                    return exports(Arrays.asList(strArr));
                }

                @Override // net.bytebuddy.dynamic.DynamicType.Builder.ModuleDefinition
                public ModuleDefinition<U> mainClass(@MaybeNull Class<?> cls) {
                    return mainClass(cls == null ? null : TypeDescription.ForLoadedType.of(cls));
                }

                @Override // net.bytebuddy.dynamic.DynamicType.Builder.ModuleDefinition
                public ModuleDefinition<U> open(String str, ModifierContributor.ForModule.OfOpen... ofOpenArr) {
                    return open(str, Arrays.asList(ofOpenArr));
                }

                @Override // net.bytebuddy.dynamic.DynamicType.Builder.ModuleDefinition
                public ModuleDefinition<U> opens(String... strArr) {
                    return opens(Arrays.asList(strArr));
                }

                @Override // net.bytebuddy.dynamic.DynamicType.Builder.ModuleDefinition
                public ModuleDefinition<U> packages(String... strArr) {
                    return packages(Arrays.asList(strArr));
                }

                @Override // net.bytebuddy.dynamic.DynamicType.Builder.ModuleDefinition
                public ModuleDefinition<U> provides(Class<?> cls, Class<?>... clsArr) {
                    return provides(cls, Arrays.asList(clsArr));
                }

                @Override // net.bytebuddy.dynamic.DynamicType.Builder.ModuleDefinition
                public RequiresDefinition<U> require(String str, ModifierContributor.ForModule.OfRequire... ofRequireArr) {
                    return require(str, Arrays.asList(ofRequireArr));
                }

                @Override // net.bytebuddy.dynamic.DynamicType.Builder.ModuleDefinition
                public ModuleDefinition<U> requires(String... strArr) {
                    return requires(Arrays.asList(strArr));
                }

                @Override // net.bytebuddy.dynamic.DynamicType.Builder.ModuleDefinition
                public ModuleDefinition<U> uses(Class<?>... clsArr) {
                    return uses((List<TypeDescription>) new TypeList.ForLoadedTypes(clsArr));
                }

                @Override // net.bytebuddy.dynamic.DynamicType.Builder.ModuleDefinition
                public ModuleDefinition<U> export(String str, Collection<? extends ModifierContributor.ForModule.OfExport> collection) {
                    return export(str, ModifierContributor.Resolver.of(collection).resolve());
                }

                @Override // net.bytebuddy.dynamic.DynamicType.Builder.ModuleDefinition
                public ModuleDefinition<U> exports(Collection<String> collection) {
                    Iterator<String> it = collection.iterator();
                    ModuleDefinition<U> moduleDefinitionExport = this;
                    while (it.hasNext()) {
                        moduleDefinitionExport = moduleDefinitionExport.export(it.next(), new ModifierContributor.ForModule.OfExport[0]);
                    }
                    return moduleDefinitionExport;
                }

                @Override // net.bytebuddy.dynamic.DynamicType.Builder.ModuleDefinition
                public ModuleDefinition<U> open(String str, Collection<? extends ModifierContributor.ForModule.OfOpen> collection) {
                    return open(str, ModifierContributor.Resolver.of(collection).resolve());
                }

                @Override // net.bytebuddy.dynamic.DynamicType.Builder.ModuleDefinition
                public ModuleDefinition<U> opens(Collection<String> collection) {
                    Iterator<String> it = collection.iterator();
                    ModuleDefinition<U> moduleDefinitionOpen = this;
                    while (it.hasNext()) {
                        moduleDefinitionOpen = moduleDefinitionOpen.open(it.next(), new ModifierContributor.ForModule.OfOpen[0]);
                    }
                    return moduleDefinitionOpen;
                }

                @Override // net.bytebuddy.dynamic.DynamicType.Builder.ModuleDefinition
                public ModuleDefinition<U> provides(Class<?> cls, Collection<Class<?>> collection) {
                    return provides(TypeDescription.ForLoadedType.of(cls), new TypeList.ForLoadedTypes(new ArrayList(collection)));
                }

                @Override // net.bytebuddy.dynamic.DynamicType.Builder.ModuleDefinition
                public RequiresDefinition<U> require(String str, Collection<? extends ModifierContributor.ForModule.OfRequire> collection) {
                    return require(str, ModifierContributor.Resolver.of(collection).resolve());
                }

                @Override // net.bytebuddy.dynamic.DynamicType.Builder.ModuleDefinition
                public ModuleDefinition<U> requires(Collection<String> collection) {
                    Iterator<String> it = collection.iterator();
                    ModuleDefinition<U> moduleDefinitionRequires = this;
                    while (it.hasNext()) {
                        moduleDefinitionRequires = moduleDefinitionRequires.requires(it.next());
                    }
                    return moduleDefinitionRequires;
                }

                @Override // net.bytebuddy.dynamic.DynamicType.Builder.ModuleDefinition
                public ModuleDefinition<U> uses(TypeDescription... typeDescriptionArr) {
                    return uses(Arrays.asList(typeDescriptionArr));
                }

                private ModuleDefinition<U> uses(List<TypeDescription> list) {
                    ArrayList arrayList = new ArrayList(list.size());
                    for (TypeDescription typeDescription : list) {
                        if (!typeDescription.isArray() && !typeDescription.isPrimitive()) {
                            arrayList.add(typeDescription.getName());
                        } else {
                            throw new IllegalArgumentException(dkz.u("A service can only be provided by a regular class: ", typeDescription));
                        }
                    }
                    return uses((Collection<String>) arrayList);
                }

                @Override // net.bytebuddy.dynamic.DynamicType.Builder.ModuleDefinition
                public ModuleDefinition<U> mainClass(@MaybeNull TypeDescription typeDescription) {
                    if (typeDescription != null && (typeDescription.isArray() || typeDescription.isPrimitive())) {
                        throw new IllegalArgumentException(dkz.u("Cannot use primitive types for main class: ", typeDescription));
                    }
                    return mainClass(typeDescription == null ? null : typeDescription.getName());
                }

                @Override // net.bytebuddy.dynamic.DynamicType.Builder.ModuleDefinition
                public ModuleDefinition<U> provides(TypeDescription typeDescription, TypeDescription... typeDescriptionArr) {
                    return provides(typeDescription, Arrays.asList(typeDescriptionArr));
                }

                @Override // net.bytebuddy.dynamic.DynamicType.Builder.ModuleDefinition
                public ModuleDefinition<U> provides(TypeDescription typeDescription, Collection<TypeDescription> collection) {
                    if (!typeDescription.isArray() && !typeDescription.isPrimitive()) {
                        ArrayList arrayList = new ArrayList(collection.size());
                        for (TypeDescription typeDescription2 : collection) {
                            if (!typeDescription2.isArray() && !typeDescription2.isPrimitive() && !typeDescription2.isAbstract()) {
                                arrayList.add(typeDescription2.getName());
                            } else {
                                throw new IllegalArgumentException(dkz.u("Service implementation must be a regular, non-abstract class: ", typeDescription2));
                            }
                        }
                        return provides(typeDescription.getName(), arrayList);
                    }
                    throw new IllegalArgumentException(dkz.u("Service must be a regular class: ", typeDescription));
                }

                @Override // net.bytebuddy.dynamic.DynamicType.Builder.ModuleDefinition
                public ModuleDefinition<U> uses(String... strArr) {
                    return uses((Collection<String>) Arrays.asList(strArr));
                }

                @Override // net.bytebuddy.dynamic.DynamicType.Builder.ModuleDefinition
                public ModuleDefinition<U> provides(String str, String... strArr) {
                    return provides(str, Arrays.asList(strArr));
                }
            }

            /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
            public interface ExportsDefinition<U> extends ModuleDefinition<U> {

                /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
                public static abstract class Delegator<V> extends AbstractBase.Delegator<V> implements ExportsDefinition<V> {
                    @Override // net.bytebuddy.dynamic.DynamicType.Builder.ModuleDefinition.ExportsDefinition
                    public ExportsDefinition<V> to(String... strArr) {
                        return to(Arrays.asList(strArr));
                    }
                }

                ExportsDefinition<U> to(Collection<String> collection);

                ExportsDefinition<U> to(String... strArr);
            }

            /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
            public interface OpensDefinition<S> extends ModuleDefinition<S> {

                /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
                public static abstract class Delegator<V> extends AbstractBase.Delegator<V> implements OpensDefinition<V> {
                    @Override // net.bytebuddy.dynamic.DynamicType.Builder.ModuleDefinition.OpensDefinition
                    public OpensDefinition<V> to(String... strArr) {
                        return to(Arrays.asList(strArr));
                    }
                }

                OpensDefinition<S> to(Collection<String> collection);

                OpensDefinition<S> to(String... strArr);
            }

            /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
            public interface RequiresDefinition<U> extends ModuleDefinition<U> {

                /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
                public static abstract class Delegator<V> extends AbstractBase.Delegator<V> implements RequiresDefinition<V> {
                }

                RequiresDefinition<U> requiredVersion(@MaybeNull String str);
            }

            ModuleDefinition<S> export(String str, int i);

            ModuleDefinition<S> export(String str, Collection<? extends ModifierContributor.ForModule.OfExport> collection);

            ModuleDefinition<S> export(String str, ModifierContributor.ForModule.OfExport... ofExportArr);

            ModuleDefinition<S> exports(Collection<String> collection);

            ModuleDefinition<S> exports(String... strArr);

            ModuleDefinition<S> mainClass(@MaybeNull Class<?> cls);

            ModuleDefinition<S> mainClass(@MaybeNull String str);

            ModuleDefinition<S> mainClass(@MaybeNull TypeDescription typeDescription);

            ModuleDefinition<S> open(String str, int i);

            ModuleDefinition<S> open(String str, Collection<? extends ModifierContributor.ForModule.OfOpen> collection);

            ModuleDefinition<S> open(String str, ModifierContributor.ForModule.OfOpen... ofOpenArr);

            ModuleDefinition<S> opens(Collection<String> collection);

            ModuleDefinition<S> opens(String... strArr);

            ModuleDefinition<S> packages(Collection<String> collection);

            ModuleDefinition<S> packages(String... strArr);

            ModuleDefinition<S> provides(Class<?> cls, Collection<Class<?>> collection);

            ModuleDefinition<S> provides(Class<?> cls, Class<?>... clsArr);

            ModuleDefinition<S> provides(String str, Collection<String> collection);

            ModuleDefinition<S> provides(String str, String... strArr);

            ModuleDefinition<S> provides(TypeDescription typeDescription, Collection<TypeDescription> collection);

            ModuleDefinition<S> provides(TypeDescription typeDescription, TypeDescription... typeDescriptionArr);

            RequiresDefinition<S> require(String str, int i);

            RequiresDefinition<S> require(String str, Collection<? extends ModifierContributor.ForModule.OfRequire> collection);

            RequiresDefinition<S> require(String str, ModifierContributor.ForModule.OfRequire... ofRequireArr);

            ModuleDefinition<S> requires(Collection<String> collection);

            ModuleDefinition<S> requires(String... strArr);

            ModuleDefinition<S> uses(Collection<String> collection);

            ModuleDefinition<S> uses(Class<?>... clsArr);

            ModuleDefinition<S> uses(String... strArr);

            ModuleDefinition<S> uses(TypeDescription... typeDescriptionArr);

            ModuleDefinition<S> version(@MaybeNull String str);
        }

        /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
        public interface RecordComponentDefinition<S> {

            /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
            public interface Optional<U> extends RecordComponentDefinition<U>, Builder<U> {

                /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
                public static abstract class AbstractBase<U> extends AbstractBase.Delegator<U> implements Optional<U> {
                    @Override // net.bytebuddy.dynamic.DynamicType.Builder.RecordComponentDefinition
                    public Optional<U> annotateRecordComponent(Annotation... annotationArr) {
                        return annotateRecordComponent(Arrays.asList(annotationArr));
                    }

                    @Override // net.bytebuddy.dynamic.DynamicType.Builder.RecordComponentDefinition
                    public Optional<U> annotateRecordComponent(List<? extends Annotation> list) {
                        return annotateRecordComponent((Collection<? extends AnnotationDescription>) new AnnotationList.ForLoadedAnnotations(list));
                    }

                    @Override // net.bytebuddy.dynamic.DynamicType.Builder.RecordComponentDefinition
                    public Optional<U> annotateRecordComponent(AnnotationDescription... annotationDescriptionArr) {
                        return annotateRecordComponent((Collection<? extends AnnotationDescription>) Arrays.asList(annotationDescriptionArr));
                    }
                }
            }

            Optional<S> annotateRecordComponent(Collection<? extends AnnotationDescription> collection);

            Optional<S> annotateRecordComponent(List<? extends Annotation> list);

            Optional<S> annotateRecordComponent(Annotation... annotationArr);

            Optional<S> annotateRecordComponent(AnnotationDescription... annotationDescriptionArr);

            Optional<S> attribute(RecordComponentAttributeAppender.Factory factory);

            Optional<S> transform(Transformer<RecordComponentDescription> transformer);
        }

        /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
        public interface TypeVariableDefinition<S> extends Builder<S> {

            /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
            public static abstract class AbstractBase<U> extends AbstractBase.Delegator<U> implements TypeVariableDefinition<U> {
                @Override // net.bytebuddy.dynamic.DynamicType.Builder.TypeVariableDefinition
                public TypeVariableDefinition<U> annotateTypeVariable(Annotation... annotationArr) {
                    return annotateTypeVariable(Arrays.asList(annotationArr));
                }

                @Override // net.bytebuddy.dynamic.DynamicType.Builder.TypeVariableDefinition
                public TypeVariableDefinition<U> annotateTypeVariable(List<? extends Annotation> list) {
                    return annotateTypeVariable((Collection<? extends AnnotationDescription>) new AnnotationList.ForLoadedAnnotations(list));
                }

                @Override // net.bytebuddy.dynamic.DynamicType.Builder.TypeVariableDefinition
                public TypeVariableDefinition<U> annotateTypeVariable(AnnotationDescription... annotationDescriptionArr) {
                    return annotateTypeVariable((Collection<? extends AnnotationDescription>) Arrays.asList(annotationDescriptionArr));
                }
            }

            TypeVariableDefinition<S> annotateTypeVariable(Collection<? extends AnnotationDescription> collection);

            TypeVariableDefinition<S> annotateTypeVariable(List<? extends Annotation> list);

            TypeVariableDefinition<S> annotateTypeVariable(Annotation... annotationArr);

            TypeVariableDefinition<S> annotateTypeVariable(AnnotationDescription... annotationDescriptionArr);
        }

        ModuleDefinition<T> adjustModule(Collection<? extends ModifierContributor.ForModule> collection);

        ModuleDefinition<T> adjustModule(ModifierContributor.ForModule... forModuleArr);

        Builder<T> annotateType(Collection<? extends AnnotationDescription> collection);

        Builder<T> annotateType(List<? extends Annotation> list);

        Builder<T> annotateType(Annotation... annotationArr);

        Builder<T> annotateType(AnnotationDescription... annotationDescriptionArr);

        Builder<T> attribute(TypeAttributeAppender typeAttributeAppender);

        MethodDefinition.ImplementationDefinition<T> constructor(ElementMatcher<? super MethodDescription> elementMatcher);

        Builder<T> declaredTypes(Collection<? extends TypeDescription> collection);

        Builder<T> declaredTypes(List<? extends Class<?>> list);

        Builder<T> declaredTypes(Class<?>... clsArr);

        Builder<T> declaredTypes(TypeDescription... typeDescriptionArr);

        FieldDefinition.Optional.Valuable<T> define(Field field);

        FieldDefinition.Optional.Valuable<T> define(FieldDescription fieldDescription);

        MethodDefinition.ImplementationDefinition<T> define(Constructor<?> constructor);

        MethodDefinition.ImplementationDefinition<T> define(Method method);

        MethodDefinition.ImplementationDefinition<T> define(MethodDescription methodDescription);

        RecordComponentDefinition.Optional<T> define(RecordComponentDescription recordComponentDescription);

        MethodDefinition.ParameterDefinition.Initial<T> defineConstructor(int i);

        MethodDefinition.ParameterDefinition.Initial<T> defineConstructor(Collection<? extends ModifierContributor.ForMethod> collection);

        MethodDefinition.ParameterDefinition.Initial<T> defineConstructor(ModifierContributor.ForMethod... forMethodArr);

        FieldDefinition.Optional.Valuable<T> defineField(String str, Type type, int i);

        FieldDefinition.Optional.Valuable<T> defineField(String str, Type type, Collection<? extends ModifierContributor.ForField> collection);

        FieldDefinition.Optional.Valuable<T> defineField(String str, Type type, ModifierContributor.ForField... forFieldArr);

        FieldDefinition.Optional.Valuable<T> defineField(String str, TypeDefinition typeDefinition, int i);

        FieldDefinition.Optional.Valuable<T> defineField(String str, TypeDefinition typeDefinition, Collection<? extends ModifierContributor.ForField> collection);

        FieldDefinition.Optional.Valuable<T> defineField(String str, TypeDefinition typeDefinition, ModifierContributor.ForField... forFieldArr);

        MethodDefinition.ParameterDefinition.Initial<T> defineMethod(String str, Type type, int i);

        MethodDefinition.ParameterDefinition.Initial<T> defineMethod(String str, Type type, Collection<? extends ModifierContributor.ForMethod> collection);

        MethodDefinition.ParameterDefinition.Initial<T> defineMethod(String str, Type type, ModifierContributor.ForMethod... forMethodArr);

        MethodDefinition.ParameterDefinition.Initial<T> defineMethod(String str, TypeDefinition typeDefinition, int i);

        MethodDefinition.ParameterDefinition.Initial<T> defineMethod(String str, TypeDefinition typeDefinition, Collection<? extends ModifierContributor.ForMethod> collection);

        MethodDefinition.ParameterDefinition.Initial<T> defineMethod(String str, TypeDefinition typeDefinition, ModifierContributor.ForMethod... forMethodArr);

        FieldDefinition.Optional<T> defineProperty(String str, Type type);

        FieldDefinition.Optional<T> defineProperty(String str, Type type, boolean z);

        FieldDefinition.Optional<T> defineProperty(String str, TypeDefinition typeDefinition);

        FieldDefinition.Optional<T> defineProperty(String str, TypeDefinition typeDefinition, boolean z);

        RecordComponentDefinition.Optional<T> defineRecordComponent(String str, Type type);

        RecordComponentDefinition.Optional<T> defineRecordComponent(String str, TypeDefinition typeDefinition);

        FieldDefinition.Valuable<T> field(ElementMatcher<? super FieldDescription> elementMatcher);

        FieldDefinition.Valuable<T> field(LatentMatcher<? super FieldDescription> latentMatcher);

        Builder<T> ignoreAlso(ElementMatcher<? super MethodDescription> elementMatcher);

        Builder<T> ignoreAlso(LatentMatcher<? super MethodDescription> latentMatcher);

        MethodDefinition.ImplementationDefinition.Optional<T> implement(Collection<? extends TypeDefinition> collection);

        MethodDefinition.ImplementationDefinition.Optional<T> implement(List<? extends Type> list);

        MethodDefinition.ImplementationDefinition.Optional<T> implement(Type... typeArr);

        MethodDefinition.ImplementationDefinition.Optional<T> implement(TypeDefinition... typeDefinitionArr);

        Builder<T> initializer(LoadedTypeInitializer loadedTypeInitializer);

        Builder<T> initializer(ByteCodeAppender byteCodeAppender);

        InnerTypeDefinition.ForType<T> innerTypeOf(Class<?> cls);

        InnerTypeDefinition.ForType<T> innerTypeOf(TypeDescription typeDescription);

        InnerTypeDefinition<T> innerTypeOf(Constructor<?> constructor);

        InnerTypeDefinition<T> innerTypeOf(Method method);

        InnerTypeDefinition<T> innerTypeOf(MethodDescription.InDefinedShape inDefinedShape);

        MethodDefinition.ImplementationDefinition<T> invokable(ElementMatcher<? super MethodDescription> elementMatcher);

        MethodDefinition.ImplementationDefinition<T> invokable(LatentMatcher<? super MethodDescription> latentMatcher);

        Unloaded<T> make();

        Unloaded<T> make(TypeResolutionStrategy typeResolutionStrategy);

        Unloaded<T> make(TypeResolutionStrategy typeResolutionStrategy, TypePool typePool);

        Unloaded<T> make(TypePool typePool);

        Builder<T> merge(Collection<? extends ModifierContributor.ForType> collection);

        Builder<T> merge(ModifierContributor.ForType... forTypeArr);

        MethodDefinition.ImplementationDefinition<T> method(ElementMatcher<? super MethodDescription> elementMatcher);

        Builder<T> modifiers(int i);

        Builder<T> modifiers(Collection<? extends ModifierContributor.ForType> collection);

        Builder<T> modifiers(ModifierContributor.ForType... forTypeArr);

        ModuleDefinition<T> module(String str, int i);

        ModuleDefinition<T> module(String str, Collection<? extends ModifierContributor.ForModule> collection);

        ModuleDefinition<T> module(String str, ModifierContributor.ForModule... forModuleArr);

        Builder<T> name(String str);

        Builder<T> nestHost(Class<?> cls);

        Builder<T> nestHost(TypeDescription typeDescription);

        Builder<T> nestMembers(Collection<? extends TypeDescription> collection);

        Builder<T> nestMembers(List<? extends Class<?>> list);

        Builder<T> nestMembers(Class<?>... clsArr);

        Builder<T> nestMembers(TypeDescription... typeDescriptionArr);

        Builder<T> noNestMate();

        Builder<T> permittedSubclass(Collection<? extends TypeDescription> collection);

        Builder<T> permittedSubclass(List<? extends Class<?>> list);

        Builder<T> permittedSubclass(Class<?>... clsArr);

        Builder<T> permittedSubclass(TypeDescription... typeDescriptionArr);

        RecordComponentDefinition<T> recordComponent(ElementMatcher<? super RecordComponentDescription> elementMatcher);

        RecordComponentDefinition<T> recordComponent(LatentMatcher<? super RecordComponentDescription> latentMatcher);

        Builder<T> require(Collection<DynamicType> collection);

        Builder<T> require(TypeDescription typeDescription, byte[] bArr);

        Builder<T> require(TypeDescription typeDescription, byte[] bArr, LoadedTypeInitializer loadedTypeInitializer);

        Builder<T> require(DynamicType... dynamicTypeArr);

        FieldDefinition.Optional<T> serialVersionUid(long j);

        Builder<T> suffix(String str);

        TypeDescription toTypeDescription();

        Builder<T> topLevelType();

        Builder<T> transform(ElementMatcher<? super TypeDescription.Generic> elementMatcher, Transformer<TypeVariableToken> transformer);

        TypeVariableDefinition<T> typeVariable(String str);

        TypeVariableDefinition<T> typeVariable(String str, Collection<? extends TypeDefinition> collection);

        TypeVariableDefinition<T> typeVariable(String str, List<? extends Type> list);

        TypeVariableDefinition<T> typeVariable(String str, Type... typeArr);

        TypeVariableDefinition<T> typeVariable(String str, TypeDefinition... typeDefinitionArr);

        Builder<T> unsealed();

        Builder<T> visit(AsmVisitorWrapper asmVisitorWrapper);

        Builder<T> withHashCodeEquals();

        Builder<T> withToString();

        ContextClassVisitor wrap(ClassVisitor classVisitor);

        ContextClassVisitor wrap(ClassVisitor classVisitor, int i, int i2);

        ContextClassVisitor wrap(ClassVisitor classVisitor, TypePool typePool);

        ContextClassVisitor wrap(ClassVisitor classVisitor, TypePool typePool, int i, int i2);
    }

    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
    @HashCodeAndEqualsPlugin.Enhance
    public static class Default extends AbstractBase {
        protected final List<? extends DynamicType> auxiliaryTypes;
        protected final byte[] binaryRepresentation;
        protected final LoadedTypeInitializer loadedTypeInitializer;
        protected final TypeDescription typeDescription;

        /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
        @HashCodeAndEqualsPlugin.Enhance
        public static class Loaded<T> extends Default implements Loaded<T> {
            private final Map<TypeDescription, Class<?>> loadedTypes;

            public Loaded(TypeDescription typeDescription, byte[] bArr, LoadedTypeInitializer loadedTypeInitializer, List<? extends DynamicType> list, Map<TypeDescription, Class<?>> map) {
                super(typeDescription, bArr, loadedTypeInitializer, list);
                this.loadedTypes = map;
            }

            @Override // net.bytebuddy.dynamic.DynamicType.Default, net.bytebuddy.dynamic.DynamicType.AbstractBase
            public boolean equals(@MaybeNull Object obj) {
                if (!super.equals(obj)) {
                    return false;
                }
                if (this == obj) {
                    return true;
                }
                return obj != null && getClass() == obj.getClass() && this.loadedTypes.equals(((Loaded) obj).loadedTypes);
            }

            @Override // net.bytebuddy.dynamic.DynamicType.Loaded
            public Map<TypeDescription, Class<?>> getAllLoaded() {
                return new HashMap(this.loadedTypes);
            }

            @Override // net.bytebuddy.dynamic.DynamicType.Loaded
            public Class<? extends T> getLoaded() {
                Class<? extends T> cls = (Class) this.loadedTypes.get(this.typeDescription);
                if (cls != null) {
                    return cls;
                }
                throw new IllegalStateException(this.typeDescription + " cannot be loaded explicitly");
            }

            @Override // net.bytebuddy.dynamic.DynamicType.Loaded
            public Map<TypeDescription, Class<?>> getLoadedAuxiliaryTypes() {
                HashMap map = new HashMap(this.loadedTypes);
                map.remove(this.typeDescription);
                return map;
            }

            @Override // net.bytebuddy.dynamic.DynamicType.Default, net.bytebuddy.dynamic.DynamicType.AbstractBase
            public int hashCode() {
                return this.loadedTypes.hashCode() + (super.hashCode() * 31);
            }
        }

        /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
        @HashCodeAndEqualsPlugin.Enhance
        public static class Unloaded<T> extends Default implements Unloaded<T> {
            private final TypeResolutionStrategy.Resolved typeResolutionStrategy;

            public Unloaded(TypeDescription typeDescription, byte[] bArr, LoadedTypeInitializer loadedTypeInitializer, List<? extends DynamicType> list, TypeResolutionStrategy.Resolved resolved) {
                super(typeDescription, bArr, loadedTypeInitializer, list);
                this.typeResolutionStrategy = resolved;
            }

            @Override // net.bytebuddy.dynamic.DynamicType.Default, net.bytebuddy.dynamic.DynamicType.AbstractBase
            public boolean equals(@MaybeNull Object obj) {
                if (!super.equals(obj)) {
                    return false;
                }
                if (this == obj) {
                    return true;
                }
                return obj != null && getClass() == obj.getClass() && this.typeResolutionStrategy.equals(((Unloaded) obj).typeResolutionStrategy);
            }

            @Override // net.bytebuddy.dynamic.DynamicType.Default, net.bytebuddy.dynamic.DynamicType.AbstractBase
            public int hashCode() {
                return this.typeResolutionStrategy.hashCode() + (super.hashCode() * 31);
            }

            @Override // net.bytebuddy.dynamic.DynamicType.Unloaded
            public Unloaded<T> include(DynamicType... dynamicTypeArr) {
                return include(Arrays.asList(dynamicTypeArr));
            }

            @Override // net.bytebuddy.dynamic.DynamicType.Unloaded
            public Loaded<T> load(@MaybeNull ClassLoader classLoader) {
                if (classLoader instanceof InjectionClassLoader) {
                    InjectionClassLoader injectionClassLoader = (InjectionClassLoader) classLoader;
                    if (!injectionClassLoader.isSealed()) {
                        return load(injectionClassLoader, InjectionClassLoader.Strategy.INSTANCE);
                    }
                }
                return load(classLoader, ClassLoadingStrategy.Default.WRAPPER);
            }

            @Override // net.bytebuddy.dynamic.DynamicType.Unloaded
            public Unloaded<T> include(List<? extends DynamicType> list) {
                return new Unloaded(this.typeDescription, this.binaryRepresentation, this.loadedTypeInitializer, CompoundList.of((List) this.auxiliaryTypes, (List) list), this.typeResolutionStrategy);
            }

            @Override // net.bytebuddy.dynamic.DynamicType.Unloaded
            public <S extends ClassLoader> Loaded<T> load(@MaybeNull S s, ClassLoadingStrategy<? super S> classLoadingStrategy) {
                return new Loaded(this.typeDescription, this.binaryRepresentation, this.loadedTypeInitializer, this.auxiliaryTypes, this.typeResolutionStrategy.initialize(this, s, classLoadingStrategy));
            }
        }

        public Default(TypeDescription typeDescription, byte[] bArr, LoadedTypeInitializer loadedTypeInitializer, List<? extends DynamicType> list) {
            this.typeDescription = typeDescription;
            this.binaryRepresentation = bArr;
            this.loadedTypeInitializer = loadedTypeInitializer;
            this.auxiliaryTypes = list;
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
            Default r5 = (Default) obj;
            return this.typeDescription.equals(r5.typeDescription) && Arrays.equals(this.binaryRepresentation, r5.binaryRepresentation) && this.loadedTypeInitializer.equals(r5.loadedTypeInitializer) && this.auxiliaryTypes.equals(r5.auxiliaryTypes);
        }

        @Override // net.bytebuddy.dynamic.DynamicType
        public List<? extends DynamicType> getAuxiliaries() {
            return this.auxiliaryTypes;
        }

        @Override // net.bytebuddy.dynamic.DynamicType
        public byte[] getBytes() {
            return this.binaryRepresentation;
        }

        @Override // net.bytebuddy.dynamic.DynamicType
        public LoadedTypeInitializer getLoadedTypeInitializer() {
            return this.loadedTypeInitializer;
        }

        @Override // net.bytebuddy.dynamic.DynamicType
        public TypeDescription getTypeDescription() {
            return this.typeDescription;
        }

        @Override // net.bytebuddy.dynamic.DynamicType.AbstractBase
        public int hashCode() {
            return this.auxiliaryTypes.hashCode() + ((this.loadedTypeInitializer.hashCode() + ((Arrays.hashCode(this.binaryRepresentation) + dkz.f(this.typeDescription, super.hashCode() * 31, 31)) * 31)) * 31);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
    public interface Loaded<T> extends DynamicType {
        Map<TypeDescription, Class<?>> getAllLoaded();

        Class<? extends T> getLoaded();

        Map<TypeDescription, Class<?>> getLoadedAuxiliaryTypes();
    }

    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
    public interface Unloaded<T> extends DynamicType {
        Unloaded<T> include(List<? extends DynamicType> list);

        Unloaded<T> include(DynamicType... dynamicTypeArr);

        Loaded<T> load(@MaybeNull ClassLoader classLoader);

        <S extends ClassLoader> Loaded<T> load(@MaybeNull S s, ClassLoadingStrategy<? super S> classLoadingStrategy);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    void close();

    Set<TypeDescription> getAllTypeDescriptions();

    Map<TypeDescription, byte[]> getAllTypes();

    List<? extends DynamicType> getAuxiliaries();

    Set<TypeDescription> getAuxiliaryTypeDescriptions();

    Map<TypeDescription, byte[]> getAuxiliaryTypes();

    byte[] getBytes();

    LoadedTypeInitializer getLoadedTypeInitializer();

    Map<TypeDescription, LoadedTypeInitializer> getLoadedTypeInitializers();

    TypeDescription getTypeDescription();

    boolean hasAliveLoadedTypeInitializers();

    File inject(File file);

    File inject(File file, File file2);

    Map<TypeDescription, File> saveIn(File file);

    File toJar(File file);

    File toJar(File file, Manifest manifest);

    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
    @HashCodeAndEqualsPlugin.Enhance
    public static abstract class AbstractBase implements DynamicType {
        private static final String MANIFEST_VERSION = "1.0";
        private static final String TEMP_SUFFIX = "tmp";

        /* JADX WARN: Undo finally extract visitor
        java.lang.NullPointerException
         */
        private File doInject(File file, File file2) throws IOException {
            FileInputStream fileInputStream = new FileInputStream(file);
            try {
                JarInputStream jarInputStream = new JarInputStream(fileInputStream);
                if (!file2.isFile() && !file2.createNewFile()) {
                    throw new IllegalArgumentException("Could not create file: " + file2);
                }
                Manifest manifest = jarInputStream.getManifest();
                FileOutputStream fileOutputStream = new FileOutputStream(file2);
                try {
                    JarOutputStream jarOutputStream = manifest == null ? new JarOutputStream(fileOutputStream) : new JarOutputStream(fileOutputStream, manifest);
                    Map<TypeDescription, byte[]> auxiliaryTypes = getAuxiliaryTypes();
                    HashMap map = new HashMap();
                    for (Map.Entry<TypeDescription, byte[]> entry : auxiliaryTypes.entrySet()) {
                        map.put(entry.getKey().getInternalName() + ClassFileLocator.CLASS_FILE_EXTENSION, entry.getValue());
                    }
                    map.put(getTypeDescription().getInternalName() + ClassFileLocator.CLASS_FILE_EXTENSION, getBytes());
                    while (true) {
                        JarEntry nextJarEntry = jarInputStream.getNextJarEntry();
                        if (nextJarEntry == null) {
                            break;
                        }
                        byte[] bArr = (byte[]) map.remove(nextJarEntry.getName());
                        if (bArr == null) {
                            jarOutputStream.putNextEntry(nextJarEntry);
                            byte[] bArr2 = new byte[1024];
                            while (true) {
                                int i = jarInputStream.read(bArr2);
                                if (i != -1) {
                                    jarOutputStream.write(bArr2, 0, i);
                                }
                            }
                        } else {
                            jarOutputStream.putNextEntry(new JarEntry(nextJarEntry.getName()));
                            jarOutputStream.write(bArr);
                        }
                        jarInputStream.closeEntry();
                        jarOutputStream.closeEntry();
                    }
                    for (Map.Entry entry2 : map.entrySet()) {
                        jarOutputStream.putNextEntry(new JarEntry((String) entry2.getKey()));
                        jarOutputStream.write((byte[]) entry2.getValue());
                        jarOutputStream.closeEntry();
                    }
                    jarOutputStream.close();
                    fileOutputStream.close();
                    jarInputStream.close();
                    fileInputStream.close();
                    return file2;
                } catch (Throwable th) {
                    fileOutputStream.close();
                    throw th;
                }
            } catch (Throwable th2) {
                fileInputStream.close();
                throw th2;
            }
        }

        @Override // net.bytebuddy.dynamic.DynamicType, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
        }

        public boolean equals(@MaybeNull Object obj) {
            if (this == obj) {
                return true;
            }
            return obj != null && getClass() == obj.getClass();
        }

        @Override // net.bytebuddy.dynamic.DynamicType
        public Set<TypeDescription> getAllTypeDescriptions() {
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            linkedHashSet.add(getTypeDescription());
            Iterator<? extends DynamicType> it = getAuxiliaries().iterator();
            while (it.hasNext()) {
                linkedHashSet.addAll(it.next().getAllTypeDescriptions());
            }
            return linkedHashSet;
        }

        @Override // net.bytebuddy.dynamic.DynamicType
        public Map<TypeDescription, byte[]> getAllTypes() {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put(getTypeDescription(), getBytes());
            Iterator<? extends DynamicType> it = getAuxiliaries().iterator();
            while (it.hasNext()) {
                linkedHashMap.putAll(it.next().getAllTypes());
            }
            return linkedHashMap;
        }

        @Override // net.bytebuddy.dynamic.DynamicType
        public Set<TypeDescription> getAuxiliaryTypeDescriptions() {
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            Iterator<? extends DynamicType> it = getAuxiliaries().iterator();
            while (it.hasNext()) {
                linkedHashSet.addAll(it.next().getAllTypeDescriptions());
            }
            return linkedHashSet;
        }

        @Override // net.bytebuddy.dynamic.DynamicType
        public Map<TypeDescription, byte[]> getAuxiliaryTypes() {
            HashMap map = new HashMap();
            for (DynamicType dynamicType : getAuxiliaries()) {
                map.put(dynamicType.getTypeDescription(), dynamicType.getBytes());
                map.putAll(dynamicType.getAuxiliaryTypes());
            }
            return map;
        }

        @Override // net.bytebuddy.dynamic.DynamicType
        public Map<TypeDescription, LoadedTypeInitializer> getLoadedTypeInitializers() {
            HashMap map = new HashMap();
            Iterator<? extends DynamicType> it = getAuxiliaries().iterator();
            while (it.hasNext()) {
                map.putAll(it.next().getLoadedTypeInitializers());
            }
            map.put(getTypeDescription(), getLoadedTypeInitializer());
            return map;
        }

        @Override // net.bytebuddy.dynamic.DynamicType
        public boolean hasAliveLoadedTypeInitializers() {
            if (getLoadedTypeInitializer().isAlive()) {
                return true;
            }
            Iterator<? extends DynamicType> it = getAuxiliaries().iterator();
            while (it.hasNext()) {
                if (it.next().hasAliveLoadedTypeInitializers()) {
                    return true;
                }
            }
            return false;
        }

        public int hashCode() {
            return getClass().hashCode();
        }

        @Override // net.bytebuddy.dynamic.DynamicType
        public File inject(File file, File file2) {
            return file.equals(file2) ? inject(file) : doInject(file, file2);
        }

        @Override // net.bytebuddy.dynamic.ClassFileLocator
        public ClassFileLocator.Resolution locate(String str) {
            if (getTypeDescription().getName().equals(str)) {
                return new ClassFileLocator.Resolution.Explicit(getBytes());
            }
            Iterator<? extends DynamicType> it = getAuxiliaries().iterator();
            while (it.hasNext()) {
                ClassFileLocator.Resolution resolutionLocate = it.next().locate(str);
                if (resolutionLocate.isResolved()) {
                    return resolutionLocate;
                }
            }
            return new ClassFileLocator.Resolution.Illegal(str);
        }

        @Override // net.bytebuddy.dynamic.DynamicType
        public Map<TypeDescription, File> saveIn(File file) throws IOException {
            HashMap map = new HashMap();
            File file2 = new File(file, getTypeDescription().getName().replace(TypePool.Default.LazyTypeDescription.GenericTypeToken.INNER_CLASS_PATH, File.separatorChar) + ClassFileLocator.CLASS_FILE_EXTENSION);
            if (file2.getParentFile() != null && !file2.getParentFile().isDirectory() && !file2.getParentFile().mkdirs()) {
                throw new IllegalArgumentException("Could not create directory: " + file2.getParentFile());
            }
            FileOutputStream fileOutputStream = new FileOutputStream(file2);
            try {
                fileOutputStream.write(getBytes());
                fileOutputStream.close();
                map.put(getTypeDescription(), file2);
                Iterator<? extends DynamicType> it = getAuxiliaries().iterator();
                while (it.hasNext()) {
                    map.putAll(it.next().saveIn(file));
                }
                return map;
            } catch (Throwable th) {
                fileOutputStream.close();
                throw th;
            }
        }

        @Override // net.bytebuddy.dynamic.DynamicType
        public File toJar(File file) {
            Manifest manifest = new Manifest();
            manifest.getMainAttributes().put(Attributes.Name.MANIFEST_VERSION, "1.0");
            return toJar(file, manifest);
        }

        @Override // net.bytebuddy.dynamic.DynamicType
        public File inject(File file) {
            FileSystem.getInstance().move(doInject(file, File.createTempFile(file.getName(), TEMP_SUFFIX)), file);
            return file;
        }

        @Override // net.bytebuddy.dynamic.DynamicType
        public File toJar(File file, Manifest manifest) throws IOException {
            if (!file.isFile() && !file.createNewFile()) {
                throw new IllegalArgumentException("Could not create file: " + file);
            }
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            try {
                JarOutputStream jarOutputStream = new JarOutputStream(fileOutputStream, manifest);
                for (Map.Entry<TypeDescription, byte[]> entry : getAuxiliaryTypes().entrySet()) {
                    jarOutputStream.putNextEntry(new JarEntry(entry.getKey().getInternalName() + ClassFileLocator.CLASS_FILE_EXTENSION));
                    jarOutputStream.write(entry.getValue());
                    jarOutputStream.closeEntry();
                }
                jarOutputStream.putNextEntry(new JarEntry(getTypeDescription().getInternalName() + ClassFileLocator.CLASS_FILE_EXTENSION));
                jarOutputStream.write(getBytes());
                jarOutputStream.closeEntry();
                jarOutputStream.close();
                return file;
            } finally {
                fileOutputStream.close();
            }
        }
    }
}

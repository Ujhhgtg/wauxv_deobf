package net.bytebuddy.dynamic.scaffold.inline;

import java.util.Collections;
import java.util.List;
import net.bytebuddy.ClassFileVersion;
import net.bytebuddy.asm.AsmVisitorWrapper;
import net.bytebuddy.description.method.MethodDescription;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.dynamic.ClassFileLocator;
import net.bytebuddy.dynamic.DynamicType;
import net.bytebuddy.dynamic.VisibilityBridgeStrategy;
import net.bytebuddy.dynamic.scaffold.FieldRegistry;
import net.bytebuddy.dynamic.scaffold.InstrumentedType;
import net.bytebuddy.dynamic.scaffold.MethodGraph;
import net.bytebuddy.dynamic.scaffold.MethodRegistry;
import net.bytebuddy.dynamic.scaffold.RecordComponentRegistry;
import net.bytebuddy.dynamic.scaffold.TypeValidation;
import net.bytebuddy.dynamic.scaffold.TypeWriter;
import net.bytebuddy.implementation.Implementation;
import net.bytebuddy.implementation.attribute.AnnotationRetention;
import net.bytebuddy.implementation.attribute.AnnotationValueFilter;
import net.bytebuddy.implementation.attribute.TypeAttributeAppender;
import net.bytebuddy.implementation.auxiliary.AuxiliaryType;
import net.bytebuddy.matcher.LatentMatcher;
import net.bytebuddy.pool.TypePool;
import net.bytebuddy.utility.AsmClassReader;
import net.bytebuddy.utility.AsmClassWriter;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public class RedefinitionDynamicTypeBuilder<T> extends AbstractInliningDynamicTypeBuilder<T> {
    public RedefinitionDynamicTypeBuilder(InstrumentedType.WithFlexibleName withFlexibleName, ClassFileVersion classFileVersion, AuxiliaryType.NamingStrategy namingStrategy, AnnotationValueFilter.Factory factory, AnnotationRetention annotationRetention, Implementation.Context.Factory factory2, MethodGraph.Compiler compiler, TypeValidation typeValidation, VisibilityBridgeStrategy visibilityBridgeStrategy, AsmClassReader.Factory factory3, AsmClassWriter.Factory factory4, LatentMatcher<? super MethodDescription> latentMatcher, TypeDescription typeDescription, ClassFileLocator classFileLocator) {
        TypeDescription typeDescription2;
        TypeAttributeAppender differentiating;
        FieldRegistry.Default r2 = new FieldRegistry.Default();
        MethodRegistry.Default r3 = new MethodRegistry.Default();
        RecordComponentRegistry.Default r4 = new RecordComponentRegistry.Default();
        if (annotationRetention.isEnabled()) {
            typeDescription2 = typeDescription;
            differentiating = new TypeAttributeAppender.ForInstrumentedType.Differentiating(typeDescription2);
        } else {
            typeDescription2 = typeDescription;
            differentiating = TypeAttributeAppender.ForInstrumentedType.INSTANCE;
        }
        this(withFlexibleName, r2, r3, r4, differentiating, AsmVisitorWrapper.NoOp.INSTANCE, classFileVersion, namingStrategy, factory, annotationRetention, factory2, compiler, typeValidation, visibilityBridgeStrategy, factory3, factory4, latentMatcher, Collections.EMPTY_LIST, typeDescription2, classFileLocator);
    }

    @Override // net.bytebuddy.dynamic.DynamicType.Builder.AbstractBase.Adapter
    public DynamicType.Builder<T> materialize(InstrumentedType.WithFlexibleName withFlexibleName, FieldRegistry fieldRegistry, MethodRegistry methodRegistry, RecordComponentRegistry recordComponentRegistry, TypeAttributeAppender typeAttributeAppender, AsmVisitorWrapper asmVisitorWrapper, ClassFileVersion classFileVersion, AuxiliaryType.NamingStrategy namingStrategy, AnnotationValueFilter.Factory factory, AnnotationRetention annotationRetention, Implementation.Context.Factory factory2, MethodGraph.Compiler compiler, TypeValidation typeValidation, VisibilityBridgeStrategy visibilityBridgeStrategy, AsmClassReader.Factory factory3, AsmClassWriter.Factory factory4, LatentMatcher<? super MethodDescription> latentMatcher, List<? extends DynamicType> list) {
        return new RedefinitionDynamicTypeBuilder(withFlexibleName, fieldRegistry, methodRegistry, recordComponentRegistry, typeAttributeAppender, asmVisitorWrapper, classFileVersion, namingStrategy, factory, annotationRetention, factory2, compiler, typeValidation, visibilityBridgeStrategy, factory3, factory4, latentMatcher, list, this.originalType, this.classFileLocator);
    }

    @Override // net.bytebuddy.dynamic.DynamicType.Builder.AbstractBase.UsingTypeWriter
    public TypeWriter<T> toTypeWriter(TypePool typePool) {
        MethodRegistry.Prepared preparedPrepare = this.methodRegistry.prepare(this.instrumentedType, this.methodGraphCompiler, this.typeValidation, this.visibilityBridgeStrategy, InliningImplementationMatcher.of(this.ignoredMethods, this.originalType));
        return TypeWriter.Default.forRedefinition(preparedPrepare, this.auxiliaryTypes, this.fieldRegistry.compile(preparedPrepare.getInstrumentedType()), this.recordComponentRegistry.compile(preparedPrepare.getInstrumentedType()), this.typeAttributeAppender, this.asmVisitorWrapper, this.classFileVersion, this.annotationValueFilterFactory, this.annotationRetention, this.auxiliaryTypeNamingStrategy, this.implementationContextFactory, this.typeValidation, this.classReaderFactory, this.classWriterFactory, TypePool.Explicit.wrap(this.instrumentedType, this.auxiliaryTypes, typePool), this.originalType, this.classFileLocator);
    }

    public RedefinitionDynamicTypeBuilder(InstrumentedType.WithFlexibleName withFlexibleName, FieldRegistry fieldRegistry, MethodRegistry methodRegistry, RecordComponentRegistry recordComponentRegistry, TypeAttributeAppender typeAttributeAppender, AsmVisitorWrapper asmVisitorWrapper, ClassFileVersion classFileVersion, AuxiliaryType.NamingStrategy namingStrategy, AnnotationValueFilter.Factory factory, AnnotationRetention annotationRetention, Implementation.Context.Factory factory2, MethodGraph.Compiler compiler, TypeValidation typeValidation, VisibilityBridgeStrategy visibilityBridgeStrategy, AsmClassReader.Factory factory3, AsmClassWriter.Factory factory4, LatentMatcher<? super MethodDescription> latentMatcher, List<? extends DynamicType> list, TypeDescription typeDescription, ClassFileLocator classFileLocator) {
        super(withFlexibleName, fieldRegistry, methodRegistry, recordComponentRegistry, typeAttributeAppender, asmVisitorWrapper, classFileVersion, namingStrategy, factory, annotationRetention, factory2, compiler, typeValidation, visibilityBridgeStrategy, factory3, factory4, latentMatcher, list, typeDescription, classFileLocator);
    }
}

package net.bytebuddy.implementation.attribute;

import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Array;
import java.util.Iterator;
import java.util.List;
import me.hd.wauxv.obf.bjs;
import net.bytebuddy.build.HashCodeAndEqualsPlugin;
import net.bytebuddy.description.annotation.AnnotationDescription;
import net.bytebuddy.description.enumeration.EnumerationDescription;
import net.bytebuddy.description.method.MethodDescription;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.description.type.TypeList;
import net.bytebuddy.implementation.attribute.AnnotationValueFilter;
import net.bytebuddy.jar.asm.AnnotationVisitor;
import net.bytebuddy.jar.asm.ClassVisitor;
import net.bytebuddy.jar.asm.FieldVisitor;
import net.bytebuddy.jar.asm.MethodVisitor;
import net.bytebuddy.jar.asm.RecordComponentVisitor;
import net.bytebuddy.jar.asm.Type;
import net.bytebuddy.jar.asm.TypePath;
import net.bytebuddy.jar.asm.TypeReference;
import net.bytebuddy.utility.nullability.AlwaysNull;
import net.bytebuddy.utility.nullability.MaybeNull;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public interface AnnotationAppender {

    @AlwaysNull
    public static final String NO_NAME = null;

    /* JADX INFO: renamed from: net.bytebuddy.implementation.attribute.AnnotationAppender$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$java$lang$annotation$RetentionPolicy;

        static {
            int[] iArr = new int[RetentionPolicy.values().length];
            $SwitchMap$java$lang$annotation$RetentionPolicy = iArr;
            try {
                iArr[RetentionPolicy.RUNTIME.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$java$lang$annotation$RetentionPolicy[RetentionPolicy.CLASS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$java$lang$annotation$RetentionPolicy[RetentionPolicy.SOURCE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
    @HashCodeAndEqualsPlugin.Enhance
    public static class ForTypeAnnotations implements TypeDescription.Generic.Visitor<AnnotationAppender> {
        private static final char COMPONENT_TYPE_PATH = '[';
        private static final String EMPTY_TYPE_PATH = "";
        private static final char INDEXED_TYPE_DELIMITER = ';';
        private static final char INNER_CLASS_PATH = '.';
        private static final int SUPER_CLASS_INDEX = -1;
        public static final boolean VARIABLE_ON_INVOKEABLE = false;
        public static final boolean VARIABLE_ON_TYPE = true;
        private static final char WILDCARD_TYPE_PATH = '*';
        private final AnnotationAppender annotationAppender;
        private final AnnotationValueFilter annotationValueFilter;
        private final String typePath;
        private final int typeReference;

        public ForTypeAnnotations(AnnotationAppender annotationAppender, AnnotationValueFilter annotationValueFilter, TypeReference typeReference) {
            this(annotationAppender, annotationValueFilter, typeReference.getValue(), "");
        }

        private AnnotationAppender apply(TypeDescription.Generic generic, String str) {
            AnnotationAppender annotationAppenderAppend = this.annotationAppender;
            Iterator<AnnotationDescription> it = generic.getDeclaredAnnotations().iterator();
            while (it.hasNext()) {
                annotationAppenderAppend = annotationAppenderAppend.append(it.next(), this.annotationValueFilter, this.typeReference, str);
            }
            return annotationAppenderAppend;
        }

        public static TypeDescription.Generic.Visitor<AnnotationAppender> ofExceptionType(AnnotationAppender annotationAppender, AnnotationValueFilter annotationValueFilter, int i) {
            return new ForTypeAnnotations(annotationAppender, annotationValueFilter, TypeReference.newExceptionReference(i));
        }

        public static TypeDescription.Generic.Visitor<AnnotationAppender> ofFieldType(AnnotationAppender annotationAppender, AnnotationValueFilter annotationValueFilter) {
            return new ForTypeAnnotations(annotationAppender, annotationValueFilter, TypeReference.newTypeReference(19));
        }

        public static TypeDescription.Generic.Visitor<AnnotationAppender> ofInterfaceType(AnnotationAppender annotationAppender, AnnotationValueFilter annotationValueFilter, int i) {
            return new ForTypeAnnotations(annotationAppender, annotationValueFilter, TypeReference.newSuperTypeReference(i));
        }

        public static TypeDescription.Generic.Visitor<AnnotationAppender> ofMethodParameterType(AnnotationAppender annotationAppender, AnnotationValueFilter annotationValueFilter, int i) {
            return new ForTypeAnnotations(annotationAppender, annotationValueFilter, TypeReference.newFormalParameterReference(i));
        }

        public static TypeDescription.Generic.Visitor<AnnotationAppender> ofMethodReturnType(AnnotationAppender annotationAppender, AnnotationValueFilter annotationValueFilter) {
            return new ForTypeAnnotations(annotationAppender, annotationValueFilter, TypeReference.newTypeReference(20));
        }

        public static TypeDescription.Generic.Visitor<AnnotationAppender> ofReceiverType(AnnotationAppender annotationAppender, AnnotationValueFilter annotationValueFilter) {
            return new ForTypeAnnotations(annotationAppender, annotationValueFilter, TypeReference.newTypeReference(21));
        }

        public static TypeDescription.Generic.Visitor<AnnotationAppender> ofSuperClass(AnnotationAppender annotationAppender, AnnotationValueFilter annotationValueFilter) {
            return new ForTypeAnnotations(annotationAppender, annotationValueFilter, TypeReference.newSuperTypeReference(-1));
        }

        public static AnnotationAppender ofTypeVariable(AnnotationAppender annotationAppender, AnnotationValueFilter annotationValueFilter, boolean z, List<? extends TypeDescription.Generic> list) {
            return ofTypeVariable(annotationAppender, annotationValueFilter, z, 0, list);
        }

        public boolean equals(@MaybeNull Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            ForTypeAnnotations forTypeAnnotations = (ForTypeAnnotations) obj;
            return this.typeReference == forTypeAnnotations.typeReference && this.typePath.equals(forTypeAnnotations.typePath) && this.annotationAppender.equals(forTypeAnnotations.annotationAppender) && this.annotationValueFilter.equals(forTypeAnnotations.annotationValueFilter);
        }

        public int hashCode() {
            return this.typePath.hashCode() + ((((this.annotationValueFilter.hashCode() + ((this.annotationAppender.hashCode() + (getClass().hashCode() * 31)) * 31)) * 31) + this.typeReference) * 31);
        }

        public ForTypeAnnotations(AnnotationAppender annotationAppender, AnnotationValueFilter annotationValueFilter, int i, String str) {
            this.annotationAppender = annotationAppender;
            this.annotationValueFilter = annotationValueFilter;
            this.typeReference = i;
            this.typePath = str;
        }

        public static AnnotationAppender ofTypeVariable(AnnotationAppender annotationAppender, AnnotationValueFilter annotationValueFilter, boolean z, int i, List<? extends TypeDescription.Generic> list) {
            int i2;
            int i3;
            if (z) {
                i2 = 17;
                i3 = 0;
            } else {
                i2 = 18;
                i3 = 1;
            }
            for (TypeDescription.Generic generic : list.subList(i, list.size())) {
                int value = TypeReference.newTypeParameterReference(i3, i).getValue();
                Iterator<AnnotationDescription> it = generic.getDeclaredAnnotations().iterator();
                while (it.hasNext()) {
                    annotationAppender = annotationAppender.append(it.next(), annotationValueFilter, value, "");
                }
                int i4 = (generic.getUpperBounds().get(0).getSort().isTypeVariable() || !generic.getUpperBounds().get(0).isInterface()) ? 0 : 1;
                Iterator<TypeDescription.Generic> it2 = generic.getUpperBounds().iterator();
                while (it2.hasNext()) {
                    annotationAppender = (AnnotationAppender) it2.next().accept(new ForTypeAnnotations(annotationAppender, annotationValueFilter, TypeReference.newTypeParameterBoundReference(i2, i, i4)));
                    i4++;
                }
                i++;
            }
            return annotationAppender;
        }

        @Override // net.bytebuddy.description.type.TypeDescription.Generic.Visitor
        public AnnotationAppender onGenericArray(TypeDescription.Generic generic) {
            return (AnnotationAppender) generic.getComponentType().accept(new ForTypeAnnotations(apply(generic, this.typePath), this.annotationValueFilter, this.typeReference, bjs.q(new StringBuilder(), this.typePath, '[')));
        }

        @Override // net.bytebuddy.description.type.TypeDescription.Generic.Visitor
        public AnnotationAppender onNonGenericType(TypeDescription.Generic generic) {
            StringBuilder sb = new StringBuilder(this.typePath);
            for (int i = 0; i < generic.asErasure().getInnerClassCount(); i++) {
                sb.append('.');
            }
            AnnotationAppender annotationAppenderApply = apply(generic, sb.toString());
            TypeDescription.Generic componentType = generic.getComponentType();
            return componentType != null ? (AnnotationAppender) componentType.accept(new ForTypeAnnotations(annotationAppenderApply, this.annotationValueFilter, this.typeReference, bjs.q(new StringBuilder(), this.typePath, '['))) : annotationAppenderApply;
        }

        @Override // net.bytebuddy.description.type.TypeDescription.Generic.Visitor
        public AnnotationAppender onParameterizedType(TypeDescription.Generic generic) {
            StringBuilder sb = new StringBuilder(this.typePath);
            int i = 0;
            for (int i2 = 0; i2 < generic.asErasure().getInnerClassCount(); i2++) {
                sb.append('.');
            }
            AnnotationAppender annotationAppenderApply = apply(generic, sb.toString());
            TypeDescription.Generic ownerType = generic.getOwnerType();
            if (ownerType != null) {
                annotationAppenderApply = (AnnotationAppender) ownerType.accept(new ForTypeAnnotations(annotationAppenderApply, this.annotationValueFilter, this.typeReference, this.typePath));
            }
            Iterator<TypeDescription.Generic> it = generic.getTypeArguments().iterator();
            while (it.hasNext()) {
                annotationAppenderApply = (AnnotationAppender) it.next().accept(new ForTypeAnnotations(annotationAppenderApply, this.annotationValueFilter, this.typeReference, sb.toString() + i + ';'));
                i++;
            }
            return annotationAppenderApply;
        }

        @Override // net.bytebuddy.description.type.TypeDescription.Generic.Visitor
        public AnnotationAppender onTypeVariable(TypeDescription.Generic generic) {
            return apply(generic, this.typePath);
        }

        @Override // net.bytebuddy.description.type.TypeDescription.Generic.Visitor
        public AnnotationAppender onWildcard(TypeDescription.Generic generic) {
            TypeList.Generic lowerBounds = generic.getLowerBounds();
            return (AnnotationAppender) (lowerBounds.isEmpty() ? generic.getUpperBounds().getOnly() : lowerBounds.getOnly()).accept(new ForTypeAnnotations(apply(generic, this.typePath), this.annotationValueFilter, this.typeReference, bjs.q(new StringBuilder(), this.typePath, '*')));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
    public interface Target {

        /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
        @HashCodeAndEqualsPlugin.Enhance
        public static class OnField implements Target {
            private final FieldVisitor fieldVisitor;

            public OnField(FieldVisitor fieldVisitor) {
                this.fieldVisitor = fieldVisitor;
            }

            public boolean equals(@MaybeNull Object obj) {
                if (this == obj) {
                    return true;
                }
                return obj != null && getClass() == obj.getClass() && this.fieldVisitor.equals(((OnField) obj).fieldVisitor);
            }

            public int hashCode() {
                return this.fieldVisitor.hashCode() + (getClass().hashCode() * 31);
            }

            @Override // net.bytebuddy.implementation.attribute.AnnotationAppender.Target
            @MaybeNull
            public AnnotationVisitor visit(String str, boolean z) {
                return this.fieldVisitor.visitAnnotation(str, z);
            }

            @Override // net.bytebuddy.implementation.attribute.AnnotationAppender.Target
            @MaybeNull
            public AnnotationVisitor visit(String str, boolean z, int i, String str2) {
                return this.fieldVisitor.visitTypeAnnotation(i, TypePath.fromString(str2), str, z);
            }
        }

        /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
        @HashCodeAndEqualsPlugin.Enhance
        public static class OnMethod implements Target {
            private final MethodVisitor methodVisitor;

            public OnMethod(MethodVisitor methodVisitor) {
                this.methodVisitor = methodVisitor;
            }

            public boolean equals(@MaybeNull Object obj) {
                if (this == obj) {
                    return true;
                }
                return obj != null && getClass() == obj.getClass() && this.methodVisitor.equals(((OnMethod) obj).methodVisitor);
            }

            public int hashCode() {
                return this.methodVisitor.hashCode() + (getClass().hashCode() * 31);
            }

            @Override // net.bytebuddy.implementation.attribute.AnnotationAppender.Target
            @MaybeNull
            public AnnotationVisitor visit(String str, boolean z) {
                return this.methodVisitor.visitAnnotation(str, z);
            }

            @Override // net.bytebuddy.implementation.attribute.AnnotationAppender.Target
            @MaybeNull
            public AnnotationVisitor visit(String str, boolean z, int i, String str2) {
                return this.methodVisitor.visitTypeAnnotation(i, TypePath.fromString(str2), str, z);
            }
        }

        /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
        @HashCodeAndEqualsPlugin.Enhance
        public static class OnMethodParameter implements Target {
            private final MethodVisitor methodVisitor;
            private final int parameterIndex;

            public OnMethodParameter(MethodVisitor methodVisitor, int i) {
                this.methodVisitor = methodVisitor;
                this.parameterIndex = i;
            }

            public boolean equals(@MaybeNull Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || getClass() != obj.getClass()) {
                    return false;
                }
                OnMethodParameter onMethodParameter = (OnMethodParameter) obj;
                return this.parameterIndex == onMethodParameter.parameterIndex && this.methodVisitor.equals(onMethodParameter.methodVisitor);
            }

            public int hashCode() {
                return ((this.methodVisitor.hashCode() + (getClass().hashCode() * 31)) * 31) + this.parameterIndex;
            }

            @Override // net.bytebuddy.implementation.attribute.AnnotationAppender.Target
            @MaybeNull
            public AnnotationVisitor visit(String str, boolean z) {
                return this.methodVisitor.visitParameterAnnotation(this.parameterIndex, str, z);
            }

            @Override // net.bytebuddy.implementation.attribute.AnnotationAppender.Target
            @MaybeNull
            public AnnotationVisitor visit(String str, boolean z, int i, String str2) {
                return this.methodVisitor.visitTypeAnnotation(i, TypePath.fromString(str2), str, z);
            }
        }

        /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
        @HashCodeAndEqualsPlugin.Enhance
        public static class OnRecordComponent implements Target {
            private final RecordComponentVisitor recordComponentVisitor;

            public OnRecordComponent(RecordComponentVisitor recordComponentVisitor) {
                this.recordComponentVisitor = recordComponentVisitor;
            }

            public boolean equals(@MaybeNull Object obj) {
                if (this == obj) {
                    return true;
                }
                return obj != null && getClass() == obj.getClass() && this.recordComponentVisitor.equals(((OnRecordComponent) obj).recordComponentVisitor);
            }

            public int hashCode() {
                return this.recordComponentVisitor.hashCode() + (getClass().hashCode() * 31);
            }

            @Override // net.bytebuddy.implementation.attribute.AnnotationAppender.Target
            @MaybeNull
            public AnnotationVisitor visit(String str, boolean z) {
                return this.recordComponentVisitor.visitAnnotation(str, z);
            }

            @Override // net.bytebuddy.implementation.attribute.AnnotationAppender.Target
            @MaybeNull
            public AnnotationVisitor visit(String str, boolean z, int i, String str2) {
                return this.recordComponentVisitor.visitTypeAnnotation(i, TypePath.fromString(str2), str, z);
            }
        }

        /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
        @HashCodeAndEqualsPlugin.Enhance
        public static class OnType implements Target {
            private final ClassVisitor classVisitor;

            public OnType(ClassVisitor classVisitor) {
                this.classVisitor = classVisitor;
            }

            public boolean equals(@MaybeNull Object obj) {
                if (this == obj) {
                    return true;
                }
                return obj != null && getClass() == obj.getClass() && this.classVisitor.equals(((OnType) obj).classVisitor);
            }

            public int hashCode() {
                return this.classVisitor.hashCode() + (getClass().hashCode() * 31);
            }

            @Override // net.bytebuddy.implementation.attribute.AnnotationAppender.Target
            @MaybeNull
            public AnnotationVisitor visit(String str, boolean z) {
                return this.classVisitor.visitAnnotation(str, z);
            }

            @Override // net.bytebuddy.implementation.attribute.AnnotationAppender.Target
            @MaybeNull
            public AnnotationVisitor visit(String str, boolean z, int i, String str2) {
                return this.classVisitor.visitTypeAnnotation(i, TypePath.fromString(str2), str, z);
            }
        }

        @MaybeNull
        AnnotationVisitor visit(String str, boolean z);

        @MaybeNull
        AnnotationVisitor visit(String str, boolean z, int i, String str2);
    }

    AnnotationAppender append(AnnotationDescription annotationDescription, AnnotationValueFilter annotationValueFilter);

    AnnotationAppender append(AnnotationDescription annotationDescription, AnnotationValueFilter annotationValueFilter, int i, String str);

    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
    @HashCodeAndEqualsPlugin.Enhance
    public static class Default implements AnnotationAppender {
        private final Target target;

        public Default(Target target) {
            this.target = target;
        }

        public static void apply(AnnotationVisitor annotationVisitor, TypeDescription typeDescription, @MaybeNull String str, Object obj) {
            if (typeDescription.isArray()) {
                AnnotationVisitor annotationVisitorVisitArray = annotationVisitor.visitArray(str);
                int length = Array.getLength(obj);
                TypeDescription componentType = typeDescription.getComponentType();
                for (int i = 0; i < length; i++) {
                    apply(annotationVisitorVisitArray, componentType, AnnotationAppender.NO_NAME, Array.get(obj, i));
                }
                annotationVisitorVisitArray.visitEnd();
                return;
            }
            if (typeDescription.isAnnotation()) {
                handle(annotationVisitor.visitAnnotation(str, typeDescription.getDescriptor()), (AnnotationDescription) obj, AnnotationValueFilter.Default.APPEND_DEFAULTS);
                return;
            }
            if (typeDescription.isEnum()) {
                annotationVisitor.visitEnum(str, typeDescription.getDescriptor(), ((EnumerationDescription) obj).getValue());
            } else if (typeDescription.represents(Class.class)) {
                annotationVisitor.visit(str, Type.getType(((TypeDescription) obj).getDescriptor()));
            } else {
                annotationVisitor.visit(str, obj);
            }
        }

        private void doAppend(AnnotationDescription annotationDescription, boolean z, AnnotationValueFilter annotationValueFilter) {
            AnnotationVisitor annotationVisitorVisit = this.target.visit(annotationDescription.getAnnotationType().getDescriptor(), z);
            if (annotationVisitorVisit != null) {
                handle(annotationVisitorVisit, annotationDescription, annotationValueFilter);
            }
        }

        private static void handle(AnnotationVisitor annotationVisitor, AnnotationDescription annotationDescription, AnnotationValueFilter annotationValueFilter) {
            for (MethodDescription.InDefinedShape inDefinedShape : annotationDescription.getAnnotationType().getDeclaredMethods()) {
                if (annotationValueFilter.isRelevant(annotationDescription, inDefinedShape)) {
                    apply(annotationVisitor, inDefinedShape.getReturnType().asErasure(), inDefinedShape.getName(), annotationDescription.getValue(inDefinedShape).resolve());
                }
            }
            annotationVisitor.visitEnd();
        }

        @Override // net.bytebuddy.implementation.attribute.AnnotationAppender
        public AnnotationAppender append(AnnotationDescription annotationDescription, AnnotationValueFilter annotationValueFilter) {
            int i = AnonymousClass1.$SwitchMap$java$lang$annotation$RetentionPolicy[annotationDescription.getRetention().ordinal()];
            if (i == 1) {
                doAppend(annotationDescription, true, annotationValueFilter);
                return this;
            }
            if (i == 2) {
                doAppend(annotationDescription, false, annotationValueFilter);
                return this;
            }
            if (i == 3) {
                return this;
            }
            throw new IllegalStateException("Unexpected retention policy: " + annotationDescription.getRetention());
        }

        public boolean equals(@MaybeNull Object obj) {
            if (this == obj) {
                return true;
            }
            return obj != null && getClass() == obj.getClass() && this.target.equals(((Default) obj).target);
        }

        public int hashCode() {
            return this.target.hashCode() + (getClass().hashCode() * 31);
        }

        private void doAppend(AnnotationDescription annotationDescription, boolean z, AnnotationValueFilter annotationValueFilter, int i, String str) {
            AnnotationVisitor annotationVisitorVisit = this.target.visit(annotationDescription.getAnnotationType().getDescriptor(), z, i, str);
            if (annotationVisitorVisit != null) {
                handle(annotationVisitorVisit, annotationDescription, annotationValueFilter);
            }
        }

        @Override // net.bytebuddy.implementation.attribute.AnnotationAppender
        public AnnotationAppender append(AnnotationDescription annotationDescription, AnnotationValueFilter annotationValueFilter, int i, String str) {
            int i2 = AnonymousClass1.$SwitchMap$java$lang$annotation$RetentionPolicy[annotationDescription.getRetention().ordinal()];
            if (i2 == 1) {
                doAppend(annotationDescription, true, annotationValueFilter, i, str);
                return this;
            }
            if (i2 == 2) {
                doAppend(annotationDescription, false, annotationValueFilter, i, str);
                return this;
            }
            if (i2 == 3) {
                return this;
            }
            throw new IllegalStateException("Unexpected retention policy: " + annotationDescription.getRetention());
        }
    }
}

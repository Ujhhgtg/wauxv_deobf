package net.bytebuddy.asm;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import me.hd.wauxv.obf.bjs;
import me.hd.wauxv.obf.dkz;
import net.bytebuddy.asm.AsmVisitorWrapper;
import net.bytebuddy.build.HashCodeAndEqualsPlugin;
import net.bytebuddy.description.annotation.AnnotationDescription;
import net.bytebuddy.description.field.FieldDescription;
import net.bytebuddy.description.field.FieldList;
import net.bytebuddy.description.method.MethodDescription;
import net.bytebuddy.description.method.MethodList;
import net.bytebuddy.description.method.ParameterDescription;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.implementation.Implementation;
import net.bytebuddy.jar.asm.AnnotationVisitor;
import net.bytebuddy.jar.asm.ClassVisitor;
import net.bytebuddy.jar.asm.FieldVisitor;
import net.bytebuddy.jar.asm.MethodVisitor;
import net.bytebuddy.matcher.ElementMatcher;
import net.bytebuddy.matcher.ElementMatchers;
import net.bytebuddy.pool.TypePool;
import net.bytebuddy.utility.CompoundList;
import net.bytebuddy.utility.OpenedClassReader;
import net.bytebuddy.utility.nullability.MaybeNull;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
@HashCodeAndEqualsPlugin.Enhance
public class AnnotationRemoval extends AsmVisitorWrapper.AbstractBase {
    private static final int METHOD_ALL = -3;
    private static final int METHOD_NONE = -4;
    private static final int METHOD_ONLY = -2;
    private static final int METHOD_PARAMETERS = -1;
    private final ElementMatcher<? super AnnotationDescription> annotationMatcher;
    private final ElementMatcher<? super FieldDescription.InDefinedShape> fieldMatcher;
    private final ElementMatcher<? super MethodDescription> methodMatcher;
    private final int parameters;
    private final boolean type;

    /*
     * JADX INFO: compiled from:
     * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
     */
    public static class AnnotationRemovingClassVisitor extends ClassVisitor {
        private final ElementMatcher<? super AnnotationDescription> annotationMatcher;
        private final Map<String, AnnotationDescription> annotations;
        private final ElementMatcher<? super FieldDescription.InDefinedShape> fieldMatcher;
        private final Map<String, FieldDescription.InDefinedShape> fields;
        private final ElementMatcher<? super MethodDescription> methodMatcher;
        private final Map<String, MethodDescription> methods;
        private final int parameters;

        @Override // net.bytebuddy.jar.asm.ClassVisitor
        @MaybeNull
        public AnnotationVisitor visitAnnotation(String str, boolean z) {
            AnnotationDescription annotationDescription = this.annotations.get(str);
            if (annotationDescription == null || !this.annotationMatcher.matches(annotationDescription)) {
                return super.visitAnnotation(str, z);
            }
            return null;
        }

        @Override // net.bytebuddy.jar.asm.ClassVisitor
        @MaybeNull
        public FieldVisitor visitField(int i, String str, String str2, String str3, Object obj) {
            FieldVisitor fieldVisitorVisitField = super.visitField(i, str, str2, str3, obj);
            if (fieldVisitorVisitField == null) {
                return null;
            }
            FieldDescription.InDefinedShape inDefinedShape = this.fields.get(str + str2);
            if (inDefinedShape == null || !this.fieldMatcher.matches(inDefinedShape)) {
                return fieldVisitorVisitField;
            }
            HashMap map = new HashMap();
            for (AnnotationDescription annotationDescription : inDefinedShape.getDeclaredAnnotations()) {
                map.put(annotationDescription.getAnnotationType().getDescriptor(), annotationDescription);
            }
            return new AnnotationRemovingFieldVisitor(fieldVisitorVisitField, this.annotationMatcher, map);
        }

        @Override // net.bytebuddy.jar.asm.ClassVisitor
        @MaybeNull
        public MethodVisitor visitMethod(int i, String str, String str2, String str3, String[] strArr) {
            MethodVisitor methodVisitorVisitMethod = super.visitMethod(i, str, str2, str3, strArr);
            if (methodVisitorVisitMethod == null) {
                return null;
            }
            MethodDescription methodDescription = this.methods.get(str + str2);
            if (methodDescription == null || !this.methodMatcher.matches(methodDescription)) {
                return methodVisitorVisitMethod;
            }
            HashMap map = new HashMap();
            int i2 = this.parameters;
            if (i2 >= 0 || i2 == -1 || i2 == AnnotationRemoval.METHOD_ALL) {
                Iterator<?> it = methodDescription.getParameters().iterator();
                while (it.hasNext()) {
                    ParameterDescription parameterDescription = (ParameterDescription) it.next();
                    HashMap map2 = new HashMap();
                    int index = parameterDescription.getIndex();
                    int i3 = this.parameters;
                    if (index == i3 || i3 < 0) {
                        for (AnnotationDescription annotationDescription : parameterDescription
                                .getDeclaredAnnotations()) {
                            map2.put(annotationDescription.getAnnotationType().getDescriptor(), annotationDescription);
                        }
                    }
                    map.put(Integer.valueOf(parameterDescription.getIndex()), map2);
                }
            }
            HashMap map3 = new HashMap();
            int i4 = this.parameters;
            if (i4 == AnnotationRemoval.METHOD_ONLY || i4 == AnnotationRemoval.METHOD_ALL) {
                for (AnnotationDescription annotationDescription2 : methodDescription.getDeclaredAnnotations()) {
                    map3.put(annotationDescription2.getAnnotationType().getDescriptor(), annotationDescription2);
                }
            }
            return new AnnotationRemovingMethodVisitor(methodVisitorVisitMethod, this.annotationMatcher, map, map3);
        }

        private AnnotationRemovingClassVisitor(ClassVisitor classVisitor,
                ElementMatcher<? super FieldDescription.InDefinedShape> elementMatcher,
                ElementMatcher<? super MethodDescription> elementMatcher2,
                ElementMatcher<? super AnnotationDescription> elementMatcher3, int i,
                Map<String, FieldDescription.InDefinedShape> map, Map<String, MethodDescription> map2,
                Map<String, AnnotationDescription> map3) {
            super(OpenedClassReader.ASM_API, classVisitor);
            this.fieldMatcher = elementMatcher;
            this.methodMatcher = elementMatcher2;
            this.annotationMatcher = elementMatcher3;
            this.parameters = i;
            this.fields = map;
            this.methods = map2;
            this.annotations = map3;
        }
    }

    /*
     * JADX INFO: compiled from:
     * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
     */
    public static class AnnotationRemovingFieldVisitor extends FieldVisitor {
        private final ElementMatcher<? super AnnotationDescription> annotationMatcher;
        private final Map<String, AnnotationDescription> annotations;

        @Override // net.bytebuddy.jar.asm.FieldVisitor
        @MaybeNull
        public AnnotationVisitor visitAnnotation(String str, boolean z) {
            AnnotationDescription annotationDescription = this.annotations.get(str);
            if (annotationDescription == null || !this.annotationMatcher.matches(annotationDescription)) {
                return super.visitAnnotation(str, z);
            }
            return null;
        }

        private AnnotationRemovingFieldVisitor(FieldVisitor fieldVisitor,
                ElementMatcher<? super AnnotationDescription> elementMatcher, Map<String, AnnotationDescription> map) {
            super(OpenedClassReader.ASM_API, fieldVisitor);
            this.annotationMatcher = elementMatcher;
            this.annotations = map;
        }
    }

    /*
     * JADX INFO: compiled from:
     * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
     */
    public static class AnnotationRemovingMethodVisitor extends MethodVisitor {
        private final ElementMatcher<? super AnnotationDescription> annotationMatcher;
        private final Map<String, AnnotationDescription> annotations;
        private final Map<Integer, Map<String, AnnotationDescription>> parameterAnnotations;

        @Override // net.bytebuddy.jar.asm.MethodVisitor
        @MaybeNull
        public AnnotationVisitor visitAnnotation(String str, boolean z) {
            AnnotationDescription annotationDescription = this.annotations.get(str);
            if (annotationDescription == null || !this.annotationMatcher.matches(annotationDescription)) {
                return super.visitAnnotation(str, z);
            }
            return null;
        }

        @Override // net.bytebuddy.jar.asm.MethodVisitor
        @MaybeNull
        public AnnotationVisitor visitParameterAnnotation(int i, String str, boolean z) {
            Map<String, AnnotationDescription> map = this.parameterAnnotations.get(Integer.valueOf(i));
            if (map == null) {
                return super.visitParameterAnnotation(i, str, z);
            }
            AnnotationDescription annotationDescription = map.get(str);
            if (annotationDescription == null || !this.annotationMatcher.matches(annotationDescription)) {
                return super.visitParameterAnnotation(i, str, z);
            }
            return null;
        }

        private AnnotationRemovingMethodVisitor(MethodVisitor methodVisitor,
                ElementMatcher<? super AnnotationDescription> elementMatcher,
                Map<Integer, Map<String, AnnotationDescription>> map, Map<String, AnnotationDescription> map2) {
            super(OpenedClassReader.ASM_API, methodVisitor);
            this.annotationMatcher = elementMatcher;
            this.parameterAnnotations = map;
            this.annotations = map2;
        }
    }

    public AnnotationRemoval(boolean z, ElementMatcher<? super FieldDescription.InDefinedShape> elementMatcher,
            ElementMatcher<? super MethodDescription> elementMatcher2,
            ElementMatcher<? super AnnotationDescription> elementMatcher3, int i) {
        this.type = z;
        this.fieldMatcher = elementMatcher;
        this.methodMatcher = elementMatcher2;
        this.annotationMatcher = elementMatcher3;
        this.parameters = i;
    }

    public static AnnotationRemoval strip(ElementMatcher<? super AnnotationDescription> elementMatcher) {
        return new AnnotationRemoval(true, ElementMatchers.any(), ElementMatchers.any(), elementMatcher, METHOD_ALL);
    }

    public boolean equals(@MaybeNull Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        AnnotationRemoval annotationRemoval = (AnnotationRemoval) obj;
        return this.type == annotationRemoval.type && this.parameters == annotationRemoval.parameters
                && this.fieldMatcher.equals(annotationRemoval.fieldMatcher)
                && this.methodMatcher.equals(annotationRemoval.methodMatcher)
                && this.annotationMatcher.equals(annotationRemoval.annotationMatcher);
    }

    public int hashCode() {
        return dkz.i(this.annotationMatcher,
                dkz.i(this.methodMatcher,
                        dkz.i(this.fieldMatcher, ((getClass().hashCode() * 31) + (this.type ? 1 : 0)) * 31, 31), 31),
                31) + this.parameters;
    }

    public AsmVisitorWrapper onConstructorParameter(ElementMatcher<? super MethodDescription> elementMatcher, int i) {
        return onInvokableParameter(ElementMatchers.isConstructor().and(elementMatcher), i);
    }

    public AsmVisitorWrapper onConstructorParameters(ElementMatcher<? super MethodDescription> elementMatcher) {
        return onInvokableParameters(ElementMatchers.isConstructor().and(elementMatcher));
    }

    public AsmVisitorWrapper onConstructors(ElementMatcher<? super MethodDescription> elementMatcher) {
        return onInvokables(ElementMatchers.isConstructor().and(elementMatcher));
    }

    public AsmVisitorWrapper onConstructorsAndParameters(ElementMatcher<? super MethodDescription> elementMatcher) {
        return onInvokablesAndParameters(ElementMatchers.isConstructor().and(elementMatcher));
    }

    public AsmVisitorWrapper onFields(ElementMatcher<? super FieldDescription> elementMatcher) {
        return new AnnotationRemoval(false, elementMatcher, ElementMatchers.none(), this.annotationMatcher, -4);
    }

    public AsmVisitorWrapper onInvokableParameter(ElementMatcher<? super MethodDescription> elementMatcher, int i) {
        if (i >= 0) {
            return new AnnotationRemoval(false, ElementMatchers.none(), elementMatcher, this.annotationMatcher, i);
        }
        throw new IllegalArgumentException(concatVar2Var1(i, "Parameter index cannot be negative: "));
    }

    public AsmVisitorWrapper onInvokableParameters(ElementMatcher<? super MethodDescription> elementMatcher) {
        return new AnnotationRemoval(false, ElementMatchers.none(), elementMatcher, this.annotationMatcher, -1);
    }

    public AsmVisitorWrapper onInvokables(ElementMatcher<? super MethodDescription> elementMatcher) {
        return new AnnotationRemoval(false, ElementMatchers.none(), elementMatcher, this.annotationMatcher,
                METHOD_ONLY);
    }

    public AsmVisitorWrapper onInvokablesAndParameters(ElementMatcher<? super MethodDescription> elementMatcher) {
        return new AnnotationRemoval(false, ElementMatchers.none(), elementMatcher, this.annotationMatcher, METHOD_ALL);
    }

    public AsmVisitorWrapper onMethodParameter(ElementMatcher<? super MethodDescription> elementMatcher, int i) {
        return onInvokableParameter(ElementMatchers.isMethod().and(elementMatcher), i);
    }

    public AsmVisitorWrapper onMethodParameters(ElementMatcher<? super MethodDescription> elementMatcher) {
        return onInvokableParameters(ElementMatchers.isMethod().and(elementMatcher));
    }

    public AsmVisitorWrapper onMethods(ElementMatcher<? super MethodDescription> elementMatcher) {
        return onInvokables(ElementMatchers.isMethod().and(elementMatcher));
    }

    public AsmVisitorWrapper onMethodsAndParameters(ElementMatcher<? super MethodDescription> elementMatcher) {
        return onInvokablesAndParameters(ElementMatchers.isMethod().and(elementMatcher));
    }

    public AsmVisitorWrapper onType() {
        return new AnnotationRemoval(true, ElementMatchers.none(), ElementMatchers.none(), this.annotationMatcher, -4);
    }

    @Override // net.bytebuddy.asm.AsmVisitorWrapper
    public ClassVisitor wrap(TypeDescription typeDescription, ClassVisitor classVisitor, Implementation.Context context,
            TypePool typePool, FieldList<FieldDescription.InDefinedShape> fieldList, MethodList<?> methodList, int i,
            int i2) {
        HashMap map = new HashMap();
        if (this.type) {
            for (AnnotationDescription annotationDescription : typeDescription.getDeclaredAnnotations()) {
                map.put(annotationDescription.getAnnotationType().getDescriptor(), annotationDescription);
            }
        }
        HashMap map2 = new HashMap();
        for (FieldDescription.InDefinedShape inDefinedShape : fieldList) {
            map2.put(inDefinedShape.getInternalName() + inDefinedShape.getDescriptor(), inDefinedShape);
        }
        HashMap map3 = new HashMap();
        for (MethodDescription methodDescription : CompoundList.of(methodList,
                new MethodDescription.Latent.TypeInitializer(typeDescription))) {
            map3.put(methodDescription.getInternalName() + methodDescription.getDescriptor(), methodDescription);
        }
        return new AnnotationRemovingClassVisitor(classVisitor, this.fieldMatcher, this.methodMatcher,
                this.annotationMatcher, this.parameters, map2, map3, map);
    }
}

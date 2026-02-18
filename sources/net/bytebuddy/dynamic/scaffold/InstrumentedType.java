package net.bytebuddy.dynamic.scaffold;

import java.lang.annotation.ElementType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import me.hd.wauxv.obf.dkz;
import net.bytebuddy.ClassFileVersion;
import net.bytebuddy.description.annotation.AnnotationDescription;
import net.bytebuddy.description.annotation.AnnotationList;
import net.bytebuddy.description.annotation.AnnotationValue;
import net.bytebuddy.description.field.FieldDescription;
import net.bytebuddy.description.field.FieldList;
import net.bytebuddy.description.method.MethodDescription;
import net.bytebuddy.description.method.MethodList;
import net.bytebuddy.description.method.ParameterDescription;
import net.bytebuddy.description.modifier.ModifierContributor;
import net.bytebuddy.description.module.ModuleDescription;
import net.bytebuddy.description.type.PackageDescription;
import net.bytebuddy.description.type.RecordComponentDescription;
import net.bytebuddy.description.type.RecordComponentList;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.description.type.TypeList;
import net.bytebuddy.description.type.TypeVariableToken;
import net.bytebuddy.dynamic.TargetType;
import net.bytebuddy.dynamic.Transformer;
import net.bytebuddy.dynamic.scaffold.TypeInitializer;
import net.bytebuddy.implementation.LoadedTypeInitializer;
import net.bytebuddy.implementation.bytecode.ByteCodeAppender;
import net.bytebuddy.matcher.ElementMatcher;
import net.bytebuddy.utility.CompoundList;
import net.bytebuddy.utility.JavaType;
import net.bytebuddy.utility.nullability.MaybeNull;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public interface InstrumentedType extends TypeDescription {

    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
    public static class Default extends TypeDescription.AbstractBase.OfSimpleType implements WithFlexibleName {
        private static final Set<String> KEYWORDS = new HashSet(Arrays.asList("abstract", "continue", "for", "new", "switch", "assert", "default", "goto", "package", "synchronized", "boolean", "do", "if", "private", "this", "break", "double", "implements", "protected", "throw", "byte", "else", "import", "public", "throws", "case", "enum", "instanceof", "return", "transient", "catch", "extends", "int", "short", "try", "char", "final", "interface", "static", "void", "class", "finally", "long", "strictfp", "volatile", "const", "float", "native", "super", "while"));
        private final List<? extends AnnotationDescription> annotationDescriptions;
        private final boolean anonymousClass;
        private final Map<String, Object> auxiliaryFields;
        private final List<? extends TypeDescription> declaredTypes;

        @MaybeNull
        private final TypeDescription declaringType;

        @MaybeNull
        private final MethodDescription.InDefinedShape enclosingMethod;

        @MaybeNull
        private final TypeDescription enclosingType;
        private final List<? extends FieldDescription.Token> fieldTokens;
        private final List<? extends TypeDescription.Generic> interfaceTypes;
        private final LoadedTypeInitializer loadedTypeInitializer;
        private final boolean localClass;
        private final List<? extends MethodDescription.Token> methodTokens;
        private final int modifiers;

        @MaybeNull
        private final ModuleDescription moduleDescription;
        private final String name;
        private final TypeDescription nestHost;
        private final List<? extends TypeDescription> nestMembers;

        @MaybeNull
        private final List<? extends TypeDescription> permittedSubclasses;
        private final boolean record;
        private final List<? extends RecordComponentDescription.Token> recordComponentTokens;

        @MaybeNull
        private final TypeDescription.Generic superClass;
        private final TypeInitializer typeInitializer;
        private final List<? extends TypeVariableToken> typeVariables;

        public Default(String str, int i, @MaybeNull ModuleDescription moduleDescription, List<? extends TypeVariableToken> list, @MaybeNull TypeDescription.Generic generic, List<? extends TypeDescription.Generic> list2, List<? extends FieldDescription.Token> list3, Map<String, Object> map, List<? extends MethodDescription.Token> list4, List<? extends RecordComponentDescription.Token> list5, List<? extends AnnotationDescription> list6, TypeInitializer typeInitializer, LoadedTypeInitializer loadedTypeInitializer, @MaybeNull TypeDescription typeDescription, @MaybeNull MethodDescription.InDefinedShape inDefinedShape, @MaybeNull TypeDescription typeDescription2, List<? extends TypeDescription> list7, @MaybeNull List<? extends TypeDescription> list8, boolean z, boolean z2, boolean z3, TypeDescription typeDescription3, List<? extends TypeDescription> list9) {
            this.name = str;
            this.modifiers = i;
            this.moduleDescription = moduleDescription;
            this.typeVariables = list;
            this.superClass = generic;
            this.interfaceTypes = list2;
            this.fieldTokens = list3;
            this.auxiliaryFields = map;
            this.methodTokens = list4;
            this.recordComponentTokens = list5;
            this.annotationDescriptions = list6;
            this.typeInitializer = typeInitializer;
            this.loadedTypeInitializer = loadedTypeInitializer;
            this.declaringType = typeDescription;
            this.enclosingMethod = inDefinedShape;
            this.enclosingType = typeDescription2;
            this.declaredTypes = list7;
            this.permittedSubclasses = list8;
            this.anonymousClass = z;
            this.localClass = z2;
            this.record = z3;
            this.nestHost = typeDescription3;
            this.nestMembers = list9;
        }

        private static boolean isValidIdentifier(String[] strArr) {
            if (strArr.length == 0) {
                return false;
            }
            for (String str : strArr) {
                if (!isValidIdentifier(str)) {
                    return false;
                }
            }
            return true;
        }

        private static boolean isValidMethodIdentifier(String str) {
            if (str.length() == 0) {
                return false;
            }
            if (!str.equals(MethodDescription.TYPE_INITIALIZER_INTERNAL_NAME) && !str.equals(MethodDescription.CONSTRUCTOR_INTERNAL_NAME)) {
                for (int i = 0; i < str.length(); i++) {
                    char cCharAt = str.charAt(i);
                    if (cCharAt == '.' || cCharAt == '/' || cCharAt == ';' || cCharAt == '<' || cCharAt == '>' || cCharAt == '[') {
                        return false;
                    }
                }
            }
            return true;
        }

        private static boolean isValidUnqualifiedNameIdentifier(String str) {
            if (str.length() == 0) {
                return false;
            }
            for (int i = 0; i < str.length(); i++) {
                char cCharAt = str.charAt(i);
                if (cCharAt == '.' || cCharAt == '/' || cCharAt == ';' || cCharAt == '[') {
                    return false;
                }
            }
            return true;
        }

        public static InstrumentedType of(String str, TypeDescription.Generic generic, ModifierContributor.ForType... forTypeArr) {
            return of(str, generic, ModifierContributor.Resolver.of(forTypeArr).resolve());
        }

        @Override // net.bytebuddy.description.annotation.AnnotationSource
        public AnnotationList getDeclaredAnnotations() {
            return new AnnotationList.Explicit(this.annotationDescriptions);
        }

        @Override // net.bytebuddy.description.type.TypeDescription, net.bytebuddy.description.type.TypeDefinition
        public FieldList<FieldDescription.InDefinedShape> getDeclaredFields() {
            return new FieldList.ForTokens(this, this.fieldTokens);
        }

        @Override // net.bytebuddy.description.type.TypeDescription, net.bytebuddy.description.type.TypeDefinition
        public MethodList<MethodDescription.InDefinedShape> getDeclaredMethods() {
            return new MethodList.ForTokens(this, this.methodTokens);
        }

        @Override // net.bytebuddy.description.type.TypeDescription
        public TypeList getDeclaredTypes() {
            return new TypeList.Explicit(this.declaredTypes);
        }

        @Override // net.bytebuddy.description.type.TypeDescription
        @MaybeNull
        public MethodDescription.InDefinedShape getEnclosingMethod() {
            return this.enclosingMethod;
        }

        @Override // net.bytebuddy.description.type.TypeDescription
        @MaybeNull
        public TypeDescription getEnclosingType() {
            return this.enclosingType;
        }

        @Override // net.bytebuddy.description.type.TypeDefinition
        public TypeList.Generic getInterfaces() {
            return new TypeList.Generic.ForDetachedTypes.WithResolvedErasure(this.interfaceTypes, TypeDescription.Generic.Visitor.Substitutor.ForAttachment.of(this));
        }

        @Override // net.bytebuddy.dynamic.scaffold.InstrumentedType
        public LoadedTypeInitializer getLoadedTypeInitializer() {
            return this.loadedTypeInitializer;
        }

        @Override // net.bytebuddy.description.ModifierReviewable
        public int getModifiers() {
            return this.modifiers;
        }

        @Override // net.bytebuddy.description.NamedElement.WithRuntimeName
        public String getName() {
            return this.name;
        }

        @Override // net.bytebuddy.description.type.TypeDescription
        public TypeDescription getNestHost() {
            return this.nestHost.represents(TargetType.class) ? this : this.nestHost;
        }

        @Override // net.bytebuddy.description.type.TypeDescription
        public TypeList getNestMembers() {
            return this.nestHost.represents(TargetType.class) ? new TypeList.Explicit((List<? extends TypeDescription>) CompoundList.of(this, (List<? extends Default>) this.nestMembers)) : this.nestHost.getNestMembers();
        }

        @Override // net.bytebuddy.description.type.TypeDescription
        @MaybeNull
        public PackageDescription getPackage() {
            int iLastIndexOf = this.name.lastIndexOf(46);
            return iLastIndexOf == -1 ? PackageDescription.DEFAULT : new PackageDescription.Simple(this.name.substring(0, iLastIndexOf));
        }

        @Override // net.bytebuddy.description.type.TypeDescription
        public TypeList getPermittedSubtypes() {
            return this.permittedSubclasses == null ? new TypeList.Empty() : new TypeList.Explicit(this.permittedSubclasses);
        }

        @Override // net.bytebuddy.description.type.TypeDescription, net.bytebuddy.description.type.TypeDefinition
        public RecordComponentList<RecordComponentDescription.InDefinedShape> getRecordComponents() {
            return new RecordComponentList.ForTokens(this, this.recordComponentTokens);
        }

        @Override // net.bytebuddy.description.type.TypeDefinition
        @MaybeNull
        public TypeDescription.Generic getSuperClass() {
            TypeDescription.Generic generic = this.superClass;
            return generic == null ? TypeDescription.Generic.UNDEFINED : new TypeDescription.Generic.LazyProjection.WithResolvedErasure(generic, TypeDescription.Generic.Visitor.Substitutor.ForAttachment.of(this));
        }

        @Override // net.bytebuddy.dynamic.scaffold.InstrumentedType
        public TypeInitializer getTypeInitializer() {
            return this.typeInitializer;
        }

        @Override // net.bytebuddy.description.TypeVariableSource
        public TypeList.Generic getTypeVariables() {
            return TypeList.Generic.ForDetachedTypes.attachVariables(this, this.typeVariables);
        }

        @Override // net.bytebuddy.description.type.TypeDescription
        public boolean isAnonymousType() {
            return this.anonymousClass;
        }

        @Override // net.bytebuddy.description.type.TypeDescription
        public boolean isLocalType() {
            return this.localClass;
        }

        @Override // net.bytebuddy.description.type.TypeDefinition
        public boolean isRecord() {
            return this.record && this.superClass != null && getSuperClass().asErasure().equals(JavaType.RECORD.getTypeStub());
        }

        @Override // net.bytebuddy.description.type.TypeDescription.AbstractBase, net.bytebuddy.description.type.TypeDescription
        public boolean isSealed() {
            return this.permittedSubclasses != null;
        }

        @Override // net.bytebuddy.description.type.TypeDescription
        @MaybeNull
        public ModuleDescription toModuleDescription() {
            return this.moduleDescription;
        }

        @Override // net.bytebuddy.dynamic.scaffold.InstrumentedType
        public TypeDescription validated() {
            String str;
            Default r1;
            AnnotationDescription next;
            if (!isValidIdentifier(getName().split("\\."))) {
                throw new IllegalStateException("Illegal type name: " + getName() + " for " + this);
            }
            String str2 = "Illegal modifiers ";
            if ((getModifiers() & (-163392)) != 0) {
                throw new IllegalStateException("Illegal modifiers " + getModifiers() + " for " + this);
            }
            if (isPackageType() && getModifiers() != 5632) {
                throw new IllegalStateException("Illegal modifiers " + getModifiers() + " for package " + this);
            }
            if (isModuleType() && getModifiers() != 0) {
                throw new IllegalStateException("Illegal modifiers " + getModifiers() + " for module " + this);
            }
            TypeDescription.Generic superClass = getSuperClass();
            if (superClass != null) {
                if (!((Boolean) superClass.accept(TypeDescription.Generic.Visitor.Validator.SUPER_CLASS)).booleanValue()) {
                    throw new IllegalStateException("Illegal super class " + superClass + " for " + this);
                }
                if (!((Boolean) superClass.accept(TypeDescription.Generic.Visitor.Validator.ForTypeAnnotations.INSTANCE)).booleanValue()) {
                    throw new IllegalStateException("Illegal type annotations on super class " + superClass + " for " + this);
                }
                if (!superClass.asErasure().isVisibleTo(this)) {
                    throw new IllegalStateException("Invisible super type " + superClass + " for " + this);
                }
            }
            HashSet hashSet = new HashSet();
            for (TypeDescription.Generic generic : getInterfaces()) {
                if (!((Boolean) generic.accept(TypeDescription.Generic.Visitor.Validator.INTERFACE)).booleanValue()) {
                    throw new IllegalStateException("Illegal interface " + generic + " for " + this);
                }
                if (!((Boolean) generic.accept(TypeDescription.Generic.Visitor.Validator.ForTypeAnnotations.INSTANCE)).booleanValue()) {
                    throw new IllegalStateException("Illegal type annotations on interface " + generic + " for " + this);
                }
                if (!hashSet.add(generic.asErasure())) {
                    throw new IllegalStateException("Already implemented interface " + generic + " for " + this);
                }
                if (!generic.asErasure().isVisibleTo(this)) {
                    throw new IllegalStateException("Invisible interface type " + generic + " for " + this);
                }
            }
            TypeList.Generic typeVariables = getTypeVariables();
            if (!typeVariables.isEmpty() && isAssignableTo(Throwable.class)) {
                throw new IllegalStateException("Cannot define throwable " + this + " to be generic");
            }
            HashSet hashSet2 = new HashSet();
            Iterator<TypeDescription.Generic> it = typeVariables.iterator();
            while (true) {
                String str3 = " does not define at least one bound";
                String str4 = "Type variable ";
                String str5 = "Illegal type variable name '";
                String str6 = "Duplicate type variable symbol '";
                String str7 = "' for ";
                if (!it.hasNext()) {
                    TypeDescription enclosingType = getEnclosingType();
                    if (enclosingType != null && (enclosingType.isArray() || enclosingType.isPrimitive())) {
                        throw new IllegalStateException("Cannot define array type or primitive type " + enclosingType + " + as enclosing type for " + this);
                    }
                    MethodDescription.InDefinedShape enclosingMethod = getEnclosingMethod();
                    if (enclosingMethod != null && enclosingMethod.isTypeInitializer()) {
                        throw new IllegalStateException("Cannot enclose type declaration in class initializer " + enclosingMethod);
                    }
                    TypeDescription declaringType = getDeclaringType();
                    if (declaringType != null) {
                        if (declaringType.isPrimitive() || declaringType.isArray()) {
                            throw new IllegalStateException("Cannot define array type or primitive type " + declaringType + " as declaring type for " + this);
                        }
                    } else if (enclosingType == null && enclosingMethod == null && (isLocalType() || isAnonymousType())) {
                        throw new IllegalStateException("Cannot define an anonymous or local class without a declaring type for " + this);
                    }
                    HashSet hashSet3 = new HashSet();
                    Iterator<TypeDescription> it2 = getDeclaredTypes().iterator();
                    while (it2.hasNext()) {
                        Iterator<TypeDescription> it3 = it2;
                        TypeDescription next2 = it2.next();
                        if (next2.isArray() || next2.isPrimitive()) {
                            throw new IllegalStateException("Cannot define array type or primitive type " + next2 + " + as declared type for " + this);
                        }
                        if (!hashSet3.add(next2)) {
                            throw new IllegalStateException(dkz.u("Duplicate definition of declared type ", next2));
                        }
                        it2 = it3;
                    }
                    TypeDescription nestHost = getNestHost();
                    if (nestHost.equals(this)) {
                        HashSet hashSet4 = new HashSet();
                        Iterator<TypeDescription> it4 = getNestMembers().iterator();
                        while (it4.hasNext()) {
                            Iterator<TypeDescription> it5 = it4;
                            TypeDescription next3 = it4.next();
                            if (next3.isArray() || next3.isPrimitive()) {
                                throw new IllegalStateException("Cannot define array type or primitive type " + next3 + " + as nest member of " + this);
                            }
                            if (!next3.isSamePackage(this)) {
                                throw new IllegalStateException("Cannot define nest member " + next3 + " + within different package then " + this);
                            }
                            if (!hashSet4.add(next3)) {
                                throw new IllegalStateException(dkz.u("Duplicate definition of nest member ", next3));
                            }
                            it4 = it5;
                        }
                    } else {
                        if (nestHost.isArray() || nestHost.isPrimitive()) {
                            throw new IllegalStateException("Cannot define array type or primitive type " + nestHost + " + as nest host for " + this);
                        }
                        if (!nestHost.isSamePackage(this)) {
                            throw new IllegalStateException("Cannot define nest host " + nestHost + " within different package then " + this);
                        }
                    }
                    for (TypeDescription typeDescription : getPermittedSubtypes()) {
                        if (!typeDescription.isAssignableTo(this) || typeDescription.equals(this)) {
                            throw new IllegalStateException("Cannot assign permitted subclass " + typeDescription + " to " + this);
                        }
                    }
                    HashSet hashSet5 = new HashSet();
                    Iterator<AnnotationDescription> it6 = getDeclaredAnnotations().iterator();
                    while (true) {
                        Iterator<AnnotationDescription> it7 = it6;
                        String str8 = " on ";
                        String str9 = str2;
                        if (it6.hasNext()) {
                            String str10 = str6;
                            next = it7.next();
                            String str11 = str5;
                            if (!next.isSupportedOn(ElementType.TYPE) && ((!isAnnotation() || !next.isSupportedOn(ElementType.ANNOTATION_TYPE)) && ((!isPackageType() || !next.isSupportedOn(ElementType.PACKAGE)) && (!isModuleType() || !next.isSupportedOn("MODULE"))))) {
                                break;
                            }
                            if (!hashSet5.add(next.getAnnotationType())) {
                                throw new IllegalStateException("Duplicate annotation " + next + " for " + this);
                            }
                            it6 = it7;
                            str5 = str11;
                            str2 = str9;
                            str6 = str10;
                        } else {
                            String str12 = str5;
                            String str13 = str6;
                            HashSet hashSet6 = new HashSet();
                            Iterator<FieldDescription.InDefinedShape> it8 = getDeclaredFields().iterator();
                            while (true) {
                                boolean zHasNext = it8.hasNext();
                                Iterator<FieldDescription.InDefinedShape> it9 = it8;
                                String str14 = "Illegal type annotations on ";
                                if (!zHasNext) {
                                    String str15 = str7;
                                    HashSet hashSet7 = new HashSet();
                                    Iterator<MethodDescription.InDefinedShape> it10 = getDeclaredMethods().iterator();
                                    while (it10.hasNext()) {
                                        MethodDescription.InDefinedShape next4 = it10.next();
                                        Iterator<MethodDescription.InDefinedShape> it11 = it10;
                                        if (!hashSet7.add(next4.asSignatureToken())) {
                                            throw new IllegalStateException("Duplicate method signature for " + next4);
                                        }
                                        if ((next4.getModifiers() & (-7680)) != 0) {
                                            throw new IllegalStateException(str9 + next4.getModifiers() + " for " + next4);
                                        }
                                        if (next4.isAbstract() && (next4.getModifiers() & 2048) != 0) {
                                            throw new IllegalStateException("Cannot declare strict computations for " + next4);
                                        }
                                        if (isInterface() && !next4.isPublic() && !next4.isPrivate()) {
                                            throw new IllegalStateException("Methods declared by an interface must be public or private " + next4);
                                        }
                                        HashSet hashSet8 = new HashSet();
                                        for (TypeDescription.Generic generic2 : next4.getTypeVariables()) {
                                            HashSet hashSet9 = hashSet7;
                                            String str16 = str14;
                                            String symbol = generic2.getSymbol();
                                            if (!hashSet8.add(symbol)) {
                                                throw new IllegalStateException(str13 + generic2 + str15 + next4);
                                            }
                                            if (!isValidIdentifier(symbol)) {
                                                throw new IllegalStateException(str12 + generic2 + str15 + next4);
                                            }
                                            if (!TypeDescription.Generic.Visitor.Validator.ForTypeAnnotations.ofFormalTypeVariable(generic2)) {
                                                throw new IllegalStateException("Illegal type annotation on '" + generic2 + str15 + next4);
                                            }
                                            HashSet hashSet10 = new HashSet();
                                            boolean z = false;
                                            for (TypeDescription.Generic generic3 : generic2.getUpperBounds()) {
                                                HashSet hashSet11 = hashSet8;
                                                String str17 = str8;
                                                if (!((Boolean) generic3.accept(TypeDescription.Generic.Visitor.Validator.TYPE_VARIABLE)).booleanValue()) {
                                                    throw new IllegalStateException("Illegal type variable bound " + generic3 + " of " + generic2 + " for " + next4);
                                                }
                                                if (!((Boolean) generic3.accept(TypeDescription.Generic.Visitor.Validator.ForTypeAnnotations.INSTANCE)).booleanValue()) {
                                                    throw new IllegalStateException("Illegal type annotations on bound " + generic3 + " of " + generic2 + " for " + this);
                                                }
                                                if (!hashSet10.add(generic3)) {
                                                    throw new IllegalStateException("Duplicate bound " + generic3 + " of " + generic2 + " for " + next4);
                                                }
                                                if (z && (generic3.getSort().isTypeVariable() || !generic3.isInterface())) {
                                                    throw new IllegalStateException("Illegal interface bound " + generic3 + " of " + generic2 + " for " + next4);
                                                }
                                                str8 = str17;
                                                hashSet8 = hashSet11;
                                                z = true;
                                            }
                                            String str18 = str8;
                                            HashSet hashSet12 = hashSet8;
                                            if (!z) {
                                                throw new IllegalStateException(str4 + generic2 + " for " + next4 + str3);
                                            }
                                            str14 = str16;
                                            hashSet7 = hashSet9;
                                            str8 = str18;
                                            hashSet8 = hashSet12;
                                        }
                                        HashSet hashSet13 = hashSet7;
                                        String str19 = str8;
                                        String str20 = str14;
                                        String str21 = str12;
                                        String str22 = str13;
                                        String str23 = str15;
                                        TypeDescription.Generic returnType = next4.getReturnType();
                                        if (next4.isTypeInitializer()) {
                                            throw new IllegalStateException("Illegal explicit declaration of a type initializer by " + this);
                                        }
                                        if (next4.isConstructor()) {
                                            str15 = str23;
                                            if (!returnType.represents(Void.TYPE)) {
                                                throw new IllegalStateException("A constructor must return void " + next4);
                                            }
                                            if (!returnType.getDeclaredAnnotations().isEmpty()) {
                                                throw new IllegalStateException("The void non-type must not be annotated for " + next4);
                                            }
                                        } else {
                                            str15 = str23;
                                            if (!isValidMethodIdentifier(next4.getInternalName())) {
                                                throw new IllegalStateException("Illegal method name " + returnType + " for " + next4);
                                            }
                                            if (!((Boolean) returnType.accept(TypeDescription.Generic.Visitor.Validator.METHOD_RETURN)).booleanValue()) {
                                                throw new IllegalStateException("Illegal return type " + returnType + " for " + next4);
                                            }
                                            if (!((Boolean) returnType.accept(TypeDescription.Generic.Visitor.Validator.ForTypeAnnotations.INSTANCE)).booleanValue()) {
                                                throw new IllegalStateException("Illegal type annotations on return type " + returnType + " for " + next4);
                                            }
                                            if (!next4.isSynthetic() && !next4.getReturnType().asErasure().isVisibleTo(this)) {
                                                throw new IllegalStateException("Invisible return type " + next4.getReturnType() + " for " + next4);
                                            }
                                        }
                                        HashSet hashSet14 = new HashSet();
                                        Iterator<ParameterDescription.InDefinedShape> it12 = next4.getParameters().iterator();
                                        while (it12.hasNext()) {
                                            Iterator<ParameterDescription.InDefinedShape> it13 = it12;
                                            ParameterDescription.InDefinedShape next5 = it12.next();
                                            String str24 = str3;
                                            TypeDescription.Generic type = next5.getType();
                                            String str25 = str4;
                                            if (!((Boolean) type.accept(TypeDescription.Generic.Visitor.Validator.METHOD_PARAMETER)).booleanValue()) {
                                                throw new IllegalStateException("Illegal parameter type of " + next5 + " for " + next4);
                                            }
                                            if (!((Boolean) type.accept(TypeDescription.Generic.Visitor.Validator.ForTypeAnnotations.INSTANCE)).booleanValue()) {
                                                throw new IllegalStateException("Illegal type annotations on parameter " + next5 + " for " + next4);
                                            }
                                            if (!next4.isSynthetic() && !type.asErasure().isVisibleTo(this)) {
                                                throw new IllegalStateException("Invisible parameter type of " + next5 + " for " + next4);
                                            }
                                            if (next5.isNamed()) {
                                                String name = next5.getName();
                                                if (!hashSet14.add(name)) {
                                                    throw new IllegalStateException("Duplicate parameter name of " + next5 + " for " + next4);
                                                }
                                                if (!isValidUnqualifiedNameIdentifier(name)) {
                                                    throw new IllegalStateException("Illegal parameter name of " + next5 + " for " + next4);
                                                }
                                            }
                                            if (next5.hasModifiers() && (next5.getModifiers() & (-36881)) != 0) {
                                                throw new IllegalStateException("Illegal modifiers of " + next5 + " for " + next4);
                                            }
                                            HashSet hashSet15 = new HashSet();
                                            Iterator<AnnotationDescription> it14 = next5.getDeclaredAnnotations().iterator();
                                            while (it14.hasNext()) {
                                                HashSet hashSet16 = hashSet14;
                                                AnnotationDescription next6 = it14.next();
                                                Iterator<AnnotationDescription> it15 = it14;
                                                if (!next6.isSupportedOn(ElementType.PARAMETER)) {
                                                    throw new IllegalStateException("Cannot add " + next6 + str19 + next5);
                                                }
                                                if (!hashSet15.add(next6.getAnnotationType())) {
                                                    throw new IllegalStateException("Duplicate annotation " + next6 + " of " + next5 + " for " + next4);
                                                }
                                                it14 = it15;
                                                hashSet14 = hashSet16;
                                            }
                                            str3 = str24;
                                            it12 = it13;
                                            str4 = str25;
                                        }
                                        String str26 = str3;
                                        String str27 = str4;
                                        for (TypeDescription.Generic generic4 : next4.getExceptionTypes()) {
                                            if (!((Boolean) generic4.accept(TypeDescription.Generic.Visitor.Validator.EXCEPTION)).booleanValue()) {
                                                throw new IllegalStateException("Illegal exception type " + generic4 + " for " + next4);
                                            }
                                            if (!((Boolean) generic4.accept(TypeDescription.Generic.Visitor.Validator.ForTypeAnnotations.INSTANCE)).booleanValue()) {
                                                throw new IllegalStateException(str20 + generic4 + " for " + next4);
                                            }
                                            if (!next4.isSynthetic() && !generic4.asErasure().isVisibleTo(this)) {
                                                throw new IllegalStateException("Invisible exception type " + generic4 + " for " + next4);
                                            }
                                        }
                                        String str28 = str20;
                                        HashSet hashSet17 = new HashSet();
                                        Iterator<AnnotationDescription> it16 = next4.getDeclaredAnnotations().iterator();
                                        while (it16.hasNext()) {
                                            String str29 = str28;
                                            AnnotationDescription next7 = it16.next();
                                            Iterator<AnnotationDescription> it17 = it16;
                                            if (!next7.isSupportedOn(next4.isMethod() ? ElementType.METHOD : ElementType.CONSTRUCTOR)) {
                                                throw new IllegalStateException("Cannot add " + next7 + str19 + next4);
                                            }
                                            if (!hashSet17.add(next7.getAnnotationType())) {
                                                throw new IllegalStateException("Duplicate annotation " + next7 + " for " + next4);
                                            }
                                            str28 = str29;
                                            it16 = it17;
                                        }
                                        String str30 = str28;
                                        AnnotationValue<?, ?> defaultValue = next4.getDefaultValue();
                                        if (defaultValue != null && !next4.isDefaultValue(defaultValue)) {
                                            throw new IllegalStateException("Illegal default value " + defaultValue + "for " + next4);
                                        }
                                        TypeDescription.Generic receiverType = next4.getReceiverType();
                                        if (receiverType != null && !((Boolean) receiverType.accept(TypeDescription.Generic.Visitor.Validator.RECEIVER)).booleanValue()) {
                                            throw new IllegalStateException("Illegal receiver type " + receiverType + " for " + next4);
                                        }
                                        if (next4.isStatic()) {
                                            if (receiverType != null) {
                                                throw new IllegalStateException("Static method " + next4 + " defines a non-null receiver " + receiverType);
                                            }
                                            str = str19;
                                        } else {
                                            if (next4.isConstructor()) {
                                                if (receiverType != null) {
                                                    TypeDescription typeDescriptionAsErasure = receiverType.asErasure();
                                                    if (enclosingType == null) {
                                                        str = str19;
                                                        r1 = this;
                                                    } else {
                                                        str = str19;
                                                        r1 = enclosingType;
                                                    }
                                                    if (typeDescriptionAsErasure.equals(r1)) {
                                                    }
                                                }
                                                throw new IllegalStateException("Constructor " + next4 + " defines an illegal receiver " + receiverType);
                                            }
                                            if (receiverType == null || !equals(receiverType.asErasure())) {
                                                str = str19;
                                                throw new IllegalStateException("Method " + next4 + " defines an illegal receiver " + receiverType);
                                            }
                                            str = str19;
                                        }
                                        str13 = str22;
                                        str3 = str26;
                                        str4 = str27;
                                        str14 = str30;
                                        hashSet7 = hashSet13;
                                        str8 = str;
                                        str12 = str21;
                                        it10 = it11;
                                    }
                                    return this;
                                }
                                FieldDescription.InDefinedShape next8 = it9.next();
                                String name2 = next8.getName();
                                String str31 = str7;
                                if (!hashSet6.add(next8.asSignatureToken())) {
                                    throw new IllegalStateException("Duplicate field definition for " + next8);
                                }
                                if (!isValidUnqualifiedNameIdentifier(name2)) {
                                    throw new IllegalStateException("Illegal field name for " + next8);
                                }
                                if ((next8.getModifiers() & (-151776)) != 0) {
                                    throw new IllegalStateException("Illegal field modifiers " + next8.getModifiers() + " for " + next8);
                                }
                                TypeDescription.Generic type2 = next8.getType();
                                HashSet hashSet18 = hashSet6;
                                if (!((Boolean) type2.accept(TypeDescription.Generic.Visitor.Validator.FIELD)).booleanValue()) {
                                    throw new IllegalStateException("Illegal field type " + type2 + " for " + next8);
                                }
                                if (!((Boolean) type2.accept(TypeDescription.Generic.Visitor.Validator.ForTypeAnnotations.INSTANCE)).booleanValue()) {
                                    throw new IllegalStateException("Illegal type annotations on " + type2 + " for " + this);
                                }
                                if (!next8.isSynthetic() && !type2.asErasure().isVisibleTo(this)) {
                                    throw new IllegalStateException("Invisible field type " + next8.getType() + " for " + next8);
                                }
                                HashSet hashSet19 = new HashSet();
                                Iterator<AnnotationDescription> it18 = next8.getDeclaredAnnotations().iterator();
                                while (it18.hasNext()) {
                                    AnnotationDescription next9 = it18.next();
                                    Iterator<AnnotationDescription> it19 = it18;
                                    if (!next9.isSupportedOn(ElementType.FIELD)) {
                                        throw new IllegalStateException("Cannot add " + next9 + " on " + next8);
                                    }
                                    if (!hashSet19.add(next9.getAnnotationType())) {
                                        throw new IllegalStateException("Duplicate annotation " + next9 + " for " + next8);
                                    }
                                    it18 = it19;
                                }
                                it8 = it9;
                                hashSet6 = hashSet18;
                                str7 = str31;
                            }
                        }
                    }
                    throw new IllegalStateException("Cannot add " + next + " on " + this);
                }
                TypeDescription.Generic next10 = it.next();
                Iterator<TypeDescription.Generic> it20 = it;
                String symbol2 = next10.getSymbol();
                if (!hashSet2.add(symbol2)) {
                    throw new IllegalStateException("Duplicate type variable symbol '" + next10 + "' for " + this);
                }
                if (!isValidIdentifier(symbol2)) {
                    throw new IllegalStateException("Illegal type variable name '" + next10 + "' for " + this);
                }
                if (!TypeDescription.Generic.Visitor.Validator.ForTypeAnnotations.ofFormalTypeVariable(next10)) {
                    throw new IllegalStateException("Illegal type annotation on '" + next10 + "' for " + this);
                }
                HashSet hashSet20 = new HashSet();
                boolean z2 = false;
                for (TypeDescription.Generic generic5 : next10.getUpperBounds()) {
                    if (!((Boolean) generic5.accept(TypeDescription.Generic.Visitor.Validator.TYPE_VARIABLE)).booleanValue()) {
                        throw new IllegalStateException("Illegal type variable bound " + generic5 + " of " + next10 + " for " + this);
                    }
                    if (!((Boolean) generic5.accept(TypeDescription.Generic.Visitor.Validator.ForTypeAnnotations.INSTANCE)).booleanValue()) {
                        throw new IllegalStateException("Illegal type annotations on type variable " + generic5 + " for " + this);
                    }
                    if (!hashSet20.add(generic5)) {
                        throw new IllegalStateException("Duplicate bound " + generic5 + " of " + next10 + " for " + this);
                    }
                    if (z2 && (generic5.getSort().isTypeVariable() || !generic5.isInterface())) {
                        throw new IllegalStateException("Illegal interface bound " + generic5 + " of " + next10 + " for " + this);
                    }
                    z2 = true;
                }
                if (!z2) {
                    throw new IllegalStateException("Type variable " + next10 + " for " + this + " does not define at least one bound");
                }
                it = it20;
            }
        }

        @Override // net.bytebuddy.dynamic.scaffold.InstrumentedType
        public /* bridge */ /* synthetic */ InstrumentedType withAnnotations(List list) {
            return withAnnotations((List<? extends AnnotationDescription>) list);
        }

        @Override // net.bytebuddy.dynamic.scaffold.InstrumentedType.WithFlexibleName
        public WithFlexibleName withName(String str) {
            return new Default(str, this.modifiers, this.moduleDescription, this.typeVariables, this.superClass, this.interfaceTypes, this.fieldTokens, this.auxiliaryFields, this.methodTokens, this.recordComponentTokens, this.annotationDescriptions, this.typeInitializer, this.loadedTypeInitializer, this.declaringType, this.enclosingMethod, this.enclosingType, this.declaredTypes, this.permittedSubclasses, this.anonymousClass, this.localClass, this.record, this.nestHost, this.nestMembers);
        }

        @Override // net.bytebuddy.dynamic.scaffold.InstrumentedType.WithFlexibleName
        public WithFlexibleName withTypeVariables(ElementMatcher<? super TypeDescription.Generic> elementMatcher, Transformer<TypeVariableToken> transformer) {
            ArrayList arrayList = new ArrayList(this.typeVariables.size());
            int i = 0;
            for (TypeVariableToken typeVariableTokenTransform : this.typeVariables) {
                int i2 = i + 1;
                if (elementMatcher.matches(getTypeVariables().get(i))) {
                    typeVariableTokenTransform = transformer.transform(this, typeVariableTokenTransform);
                }
                arrayList.add(typeVariableTokenTransform);
                i = i2;
            }
            return new Default(this.name, this.modifiers, this.moduleDescription, arrayList, this.superClass, this.interfaceTypes, this.fieldTokens, this.auxiliaryFields, this.methodTokens, this.recordComponentTokens, this.annotationDescriptions, this.typeInitializer, this.loadedTypeInitializer, this.declaringType, this.enclosingMethod, this.enclosingType, this.declaredTypes, this.permittedSubclasses, this.anonymousClass, this.localClass, this.record, this.nestHost, this.nestMembers);
        }

        public static InstrumentedType of(String str, TypeDescription.Generic generic, int i) {
            return Factory.Default.MODIFIABLE.subclass(str, i, generic);
        }

        @Override // net.bytebuddy.description.DeclaredByType
        @MaybeNull
        public TypeDescription getDeclaringType() {
            return this.declaringType;
        }

        @Override // net.bytebuddy.dynamic.scaffold.InstrumentedType.WithFlexibleName, net.bytebuddy.dynamic.scaffold.InstrumentedType
        public WithFlexibleName withAnnotations(List<? extends AnnotationDescription> list) {
            return new Default(this.name, this.modifiers, this.moduleDescription, this.typeVariables, this.superClass, this.interfaceTypes, this.fieldTokens, this.auxiliaryFields, this.methodTokens, this.recordComponentTokens, CompoundList.of((List) this.annotationDescriptions, (List) list), this.typeInitializer, this.loadedTypeInitializer, this.declaringType, this.enclosingMethod, this.enclosingType, this.declaredTypes, this.permittedSubclasses, this.anonymousClass, this.localClass, this.record, this.nestHost, this.nestMembers);
        }

        @Override // net.bytebuddy.dynamic.scaffold.InstrumentedType
        public WithFlexibleName withAnonymousClass(boolean z) {
            return new Default(this.name, this.modifiers, this.moduleDescription, this.typeVariables, this.superClass, this.interfaceTypes, this.fieldTokens, this.auxiliaryFields, this.methodTokens, this.recordComponentTokens, this.annotationDescriptions, this.typeInitializer, this.loadedTypeInitializer, this.declaringType, this.enclosingMethod, this.enclosingType, this.declaredTypes, this.permittedSubclasses, z, false, this.record, this.nestHost, this.nestMembers);
        }

        @Override // net.bytebuddy.dynamic.scaffold.InstrumentedType
        public WithFlexibleName withAuxiliaryField(FieldDescription.Token token, Object obj) {
            HashMap map = new HashMap(this.auxiliaryFields);
            Object objPut = map.put(token.getName(), obj);
            if (objPut == null) {
                return new Default(this.name, this.modifiers, this.moduleDescription, this.typeVariables, this.superClass, this.interfaceTypes, CompoundList.of(this.fieldTokens, token.accept((TypeDescription.Generic.Visitor<? extends TypeDescription.Generic>) TypeDescription.Generic.Visitor.Substitutor.ForDetachment.of(this))), map, this.methodTokens, this.recordComponentTokens, this.annotationDescriptions, this.typeInitializer, new LoadedTypeInitializer.Compound(this.loadedTypeInitializer, new LoadedTypeInitializer.ForStaticField(token.getName(), obj)), this.declaringType, this.enclosingMethod, this.enclosingType, this.declaredTypes, this.permittedSubclasses, this.anonymousClass, this.localClass, this.record, this.nestHost, this.nestMembers);
            }
            if (objPut == obj) {
                return this;
            }
            throw new IllegalStateException("Field " + token.getName() + " for " + this + " already mapped to " + objPut + " and not " + obj);
        }

        @Override // net.bytebuddy.dynamic.scaffold.InstrumentedType
        public WithFlexibleName withDeclaredTypes(TypeList typeList) {
            return new Default(this.name, this.modifiers, this.moduleDescription, this.typeVariables, this.superClass, this.interfaceTypes, this.fieldTokens, this.auxiliaryFields, this.methodTokens, this.recordComponentTokens, this.annotationDescriptions, this.typeInitializer, this.loadedTypeInitializer, this.declaringType, this.enclosingMethod, this.enclosingType, CompoundList.of((List) this.declaredTypes, (List) typeList), this.permittedSubclasses, this.anonymousClass, this.localClass, this.record, this.nestHost, this.nestMembers);
        }

        @Override // net.bytebuddy.dynamic.scaffold.InstrumentedType
        public WithFlexibleName withDeclaringType(@MaybeNull TypeDescription typeDescription) {
            return new Default(this.name, this.modifiers, this.moduleDescription, this.typeVariables, this.superClass, this.interfaceTypes, this.fieldTokens, this.auxiliaryFields, this.methodTokens, this.recordComponentTokens, this.annotationDescriptions, this.typeInitializer, this.loadedTypeInitializer, typeDescription, this.enclosingMethod, this.enclosingType, this.declaredTypes, this.permittedSubclasses, this.anonymousClass, this.localClass, this.record, this.nestHost, this.nestMembers);
        }

        @Override // net.bytebuddy.dynamic.scaffold.InstrumentedType
        public WithFlexibleName withEnclosingMethod(MethodDescription.InDefinedShape inDefinedShape) {
            return new Default(this.name, this.modifiers, this.moduleDescription, this.typeVariables, this.superClass, this.interfaceTypes, this.fieldTokens, this.auxiliaryFields, this.methodTokens, this.recordComponentTokens, this.annotationDescriptions, this.typeInitializer, this.loadedTypeInitializer, this.declaringType, inDefinedShape, inDefinedShape.getDeclaringType(), this.declaredTypes, this.permittedSubclasses, this.anonymousClass, this.localClass, this.record, this.nestHost, this.nestMembers);
        }

        @Override // net.bytebuddy.dynamic.scaffold.InstrumentedType
        public WithFlexibleName withEnclosingType(@MaybeNull TypeDescription typeDescription) {
            return new Default(this.name, this.modifiers, this.moduleDescription, this.typeVariables, this.superClass, this.interfaceTypes, this.fieldTokens, this.auxiliaryFields, this.methodTokens, this.recordComponentTokens, this.annotationDescriptions, this.typeInitializer, this.loadedTypeInitializer, this.declaringType, MethodDescription.UNDEFINED, typeDescription, this.declaredTypes, this.permittedSubclasses, this.anonymousClass, this.localClass, this.record, this.nestHost, this.nestMembers);
        }

        @Override // net.bytebuddy.dynamic.scaffold.InstrumentedType
        public WithFlexibleName withField(FieldDescription.Token token) {
            return new Default(this.name, this.modifiers, this.moduleDescription, this.typeVariables, this.superClass, this.interfaceTypes, CompoundList.of(this.fieldTokens, token.accept((TypeDescription.Generic.Visitor<? extends TypeDescription.Generic>) TypeDescription.Generic.Visitor.Substitutor.ForDetachment.of(this))), this.auxiliaryFields, this.methodTokens, this.recordComponentTokens, this.annotationDescriptions, this.typeInitializer, this.loadedTypeInitializer, this.declaringType, this.enclosingMethod, this.enclosingType, this.declaredTypes, this.permittedSubclasses, this.anonymousClass, this.localClass, this.record, this.nestHost, this.nestMembers);
        }

        @Override // net.bytebuddy.dynamic.scaffold.InstrumentedType
        public WithFlexibleName withInterfaces(TypeList.Generic generic) {
            return new Default(this.name, this.modifiers, this.moduleDescription, this.typeVariables, this.superClass, CompoundList.of((List) this.interfaceTypes, (List) generic.accept(TypeDescription.Generic.Visitor.Substitutor.ForDetachment.of(this))), this.fieldTokens, this.auxiliaryFields, this.methodTokens, this.recordComponentTokens, this.annotationDescriptions, this.typeInitializer, this.loadedTypeInitializer, this.declaringType, this.enclosingMethod, this.enclosingType, this.declaredTypes, this.permittedSubclasses, this.anonymousClass, this.localClass, this.record, this.nestHost, this.nestMembers);
        }

        @Override // net.bytebuddy.dynamic.scaffold.InstrumentedType
        public WithFlexibleName withLocalClass(boolean z) {
            return new Default(this.name, this.modifiers, this.moduleDescription, this.typeVariables, this.superClass, this.interfaceTypes, this.fieldTokens, this.auxiliaryFields, this.methodTokens, this.recordComponentTokens, this.annotationDescriptions, this.typeInitializer, this.loadedTypeInitializer, this.declaringType, this.enclosingMethod, this.enclosingType, this.declaredTypes, this.permittedSubclasses, false, z, this.record, this.nestHost, this.nestMembers);
        }

        @Override // net.bytebuddy.dynamic.scaffold.InstrumentedType
        public WithFlexibleName withMethod(MethodDescription.Token token) {
            return new Default(this.name, this.modifiers, this.moduleDescription, this.typeVariables, this.superClass, this.interfaceTypes, this.fieldTokens, this.auxiliaryFields, CompoundList.of(this.methodTokens, token.accept((TypeDescription.Generic.Visitor<? extends TypeDescription.Generic>) TypeDescription.Generic.Visitor.Substitutor.ForDetachment.of(this))), this.recordComponentTokens, this.annotationDescriptions, this.typeInitializer, this.loadedTypeInitializer, this.declaringType, this.enclosingMethod, this.enclosingType, this.declaredTypes, this.permittedSubclasses, this.anonymousClass, this.localClass, this.record, this.nestHost, this.nestMembers);
        }

        @Override // net.bytebuddy.dynamic.scaffold.InstrumentedType
        public WithFlexibleName withModifiers(int i) {
            return new Default(this.name, i, this.moduleDescription, this.typeVariables, this.superClass, this.interfaceTypes, this.fieldTokens, this.auxiliaryFields, this.methodTokens, this.recordComponentTokens, this.annotationDescriptions, this.typeInitializer, this.loadedTypeInitializer, this.declaringType, this.enclosingMethod, this.enclosingType, this.declaredTypes, this.permittedSubclasses, this.anonymousClass, this.localClass, this.record, this.nestHost, this.nestMembers);
        }

        @Override // net.bytebuddy.dynamic.scaffold.InstrumentedType
        public WithFlexibleName withModuleDescription(@MaybeNull ModuleDescription moduleDescription) {
            return new Default(this.name, this.modifiers, moduleDescription, this.typeVariables, this.superClass, this.interfaceTypes, this.fieldTokens, this.auxiliaryFields, this.methodTokens, this.recordComponentTokens, this.annotationDescriptions, this.typeInitializer, this.loadedTypeInitializer, this.declaringType, this.enclosingMethod, this.enclosingType, this.declaredTypes, this.permittedSubclasses, this.anonymousClass, this.localClass, this.record, this.nestHost, this.nestMembers);
        }

        @Override // net.bytebuddy.dynamic.scaffold.InstrumentedType
        public WithFlexibleName withNestHost(TypeDescription typeDescription) {
            String str = this.name;
            int i = this.modifiers;
            ModuleDescription moduleDescription = this.moduleDescription;
            List<? extends TypeVariableToken> list = this.typeVariables;
            TypeDescription.Generic generic = this.superClass;
            List<? extends TypeDescription.Generic> list2 = this.interfaceTypes;
            List<? extends FieldDescription.Token> list3 = this.fieldTokens;
            Map<String, Object> map = this.auxiliaryFields;
            List<? extends MethodDescription.Token> list4 = this.methodTokens;
            List<? extends RecordComponentDescription.Token> list5 = this.recordComponentTokens;
            List<? extends AnnotationDescription> list6 = this.annotationDescriptions;
            TypeInitializer typeInitializer = this.typeInitializer;
            LoadedTypeInitializer loadedTypeInitializer = this.loadedTypeInitializer;
            TypeDescription typeDescription2 = this.declaringType;
            MethodDescription.InDefinedShape inDefinedShape = this.enclosingMethod;
            TypeDescription typeDescription3 = this.enclosingType;
            List<? extends TypeDescription> list7 = this.declaredTypes;
            List<? extends TypeDescription> list8 = this.permittedSubclasses;
            boolean z = this.anonymousClass;
            boolean z2 = this.localClass;
            boolean z3 = this.record;
            TypeDescription typeDescription4 = typeDescription;
            if (typeDescription4.equals(this)) {
                typeDescription4 = TargetType.DESCRIPTION;
            }
            return new Default(str, i, moduleDescription, list, generic, list2, list3, map, list4, list5, list6, typeInitializer, loadedTypeInitializer, typeDescription2, inDefinedShape, typeDescription3, list7, list8, z, z2, z3, typeDescription4, Collections.EMPTY_LIST);
        }

        @Override // net.bytebuddy.dynamic.scaffold.InstrumentedType
        public WithFlexibleName withNestMembers(TypeList typeList) {
            return new Default(this.name, this.modifiers, this.moduleDescription, this.typeVariables, this.superClass, this.interfaceTypes, this.fieldTokens, this.auxiliaryFields, this.methodTokens, this.recordComponentTokens, this.annotationDescriptions, this.typeInitializer, this.loadedTypeInitializer, this.declaringType, this.enclosingMethod, this.enclosingType, this.declaredTypes, this.permittedSubclasses, this.anonymousClass, this.localClass, this.record, TargetType.DESCRIPTION, CompoundList.of((List) this.nestMembers, (List) typeList));
        }

        @Override // net.bytebuddy.dynamic.scaffold.InstrumentedType
        public WithFlexibleName withPermittedSubclasses(@MaybeNull TypeList typeList) {
            List<? extends TypeDescription> list;
            List listOf = typeList;
            String str = this.name;
            int i = this.modifiers;
            ModuleDescription moduleDescription = this.moduleDescription;
            List<? extends TypeVariableToken> list2 = this.typeVariables;
            TypeDescription.Generic generic = this.superClass;
            List<? extends TypeDescription.Generic> list3 = this.interfaceTypes;
            List<? extends FieldDescription.Token> list4 = this.fieldTokens;
            Map<String, Object> map = this.auxiliaryFields;
            List<? extends MethodDescription.Token> list5 = this.methodTokens;
            List<? extends RecordComponentDescription.Token> list6 = this.recordComponentTokens;
            List<? extends AnnotationDescription> list7 = this.annotationDescriptions;
            TypeInitializer typeInitializer = this.typeInitializer;
            LoadedTypeInitializer loadedTypeInitializer = this.loadedTypeInitializer;
            TypeDescription typeDescription = this.declaringType;
            MethodDescription.InDefinedShape inDefinedShape = this.enclosingMethod;
            TypeDescription typeDescription2 = this.enclosingType;
            List<? extends TypeDescription> list8 = this.declaredTypes;
            if (listOf != null && (list = this.permittedSubclasses) != null) {
                listOf = CompoundList.of((List) list, listOf);
            }
            return new Default(str, i, moduleDescription, list2, generic, list3, list4, map, list5, list6, list7, typeInitializer, loadedTypeInitializer, typeDescription, inDefinedShape, typeDescription2, list8, listOf, this.anonymousClass, this.localClass, this.record, this.nestHost, this.nestMembers);
        }

        @Override // net.bytebuddy.dynamic.scaffold.InstrumentedType
        public WithFlexibleName withRecord(boolean z) {
            return new Default(this.name, this.modifiers, this.moduleDescription, this.typeVariables, this.superClass, this.interfaceTypes, this.fieldTokens, this.auxiliaryFields, this.methodTokens, z ? this.recordComponentTokens : Collections.EMPTY_LIST, this.annotationDescriptions, this.typeInitializer, this.loadedTypeInitializer, this.declaringType, this.enclosingMethod, this.enclosingType, this.declaredTypes, this.permittedSubclasses, this.anonymousClass, this.localClass, z, this.nestHost, this.nestMembers);
        }

        @Override // net.bytebuddy.dynamic.scaffold.InstrumentedType
        public WithFlexibleName withRecordComponent(RecordComponentDescription.Token token) {
            return new Default(this.name, this.modifiers, this.moduleDescription, this.typeVariables, this.superClass, this.interfaceTypes, this.fieldTokens, this.auxiliaryFields, this.methodTokens, CompoundList.of(this.recordComponentTokens, token.accept((TypeDescription.Generic.Visitor<? extends TypeDescription.Generic>) TypeDescription.Generic.Visitor.Substitutor.ForDetachment.of(this))), this.annotationDescriptions, this.typeInitializer, this.loadedTypeInitializer, this.declaringType, this.enclosingMethod, this.enclosingType, this.declaredTypes, this.permittedSubclasses, this.anonymousClass, this.localClass, true, this.nestHost, this.nestMembers);
        }

        @Override // net.bytebuddy.dynamic.scaffold.InstrumentedType
        public WithFlexibleName withTypeVariable(TypeVariableToken typeVariableToken) {
            return new Default(this.name, this.modifiers, this.moduleDescription, CompoundList.of(this.typeVariables, typeVariableToken.accept((TypeDescription.Generic.Visitor<? extends TypeDescription.Generic>) TypeDescription.Generic.Visitor.Substitutor.ForDetachment.of(this))), this.superClass, this.interfaceTypes, this.fieldTokens, this.auxiliaryFields, this.methodTokens, this.recordComponentTokens, this.annotationDescriptions, this.typeInitializer, this.loadedTypeInitializer, this.declaringType, this.enclosingMethod, this.enclosingType, this.declaredTypes, this.permittedSubclasses, this.anonymousClass, this.localClass, this.record, this.nestHost, this.nestMembers);
        }

        @Override // net.bytebuddy.dynamic.scaffold.InstrumentedType
        public WithFlexibleName withInitializer(LoadedTypeInitializer loadedTypeInitializer) {
            return new Default(this.name, this.modifiers, this.moduleDescription, this.typeVariables, this.superClass, this.interfaceTypes, this.fieldTokens, this.auxiliaryFields, this.methodTokens, this.recordComponentTokens, this.annotationDescriptions, this.typeInitializer, new LoadedTypeInitializer.Compound(this.loadedTypeInitializer, loadedTypeInitializer), this.declaringType, this.enclosingMethod, this.enclosingType, this.declaredTypes, this.permittedSubclasses, this.anonymousClass, this.localClass, this.record, this.nestHost, this.nestMembers);
        }

        private static boolean isValidIdentifier(String str) {
            if (KEYWORDS.contains(str) || str.length() == 0 || !(Character.isJavaIdentifierStart(str.charAt(0)) || Character.isUnicodeIdentifierStart(str.charAt(0)))) {
                return false;
            }
            if (!str.equals(PackageDescription.PACKAGE_CLASS_NAME) && !str.equals(ModuleDescription.MODULE_CLASS_NAME)) {
                for (int i = 1; i < str.length(); i++) {
                    if (!Character.isJavaIdentifierPart(str.charAt(i)) && !Character.isUnicodeIdentifierPart(str.charAt(i))) {
                        return false;
                    }
                }
            }
            return true;
        }

        @Override // net.bytebuddy.dynamic.scaffold.InstrumentedType
        public WithFlexibleName withInitializer(ByteCodeAppender byteCodeAppender) {
            return new Default(this.name, this.modifiers, this.moduleDescription, this.typeVariables, this.superClass, this.interfaceTypes, this.fieldTokens, this.auxiliaryFields, this.methodTokens, this.recordComponentTokens, this.annotationDescriptions, this.typeInitializer.expandWith(byteCodeAppender), this.loadedTypeInitializer, this.declaringType, this.enclosingMethod, this.enclosingType, this.declaredTypes, this.permittedSubclasses, this.anonymousClass, this.localClass, this.record, this.nestHost, this.nestMembers);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
    public interface Factory {

        /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
        public enum Default implements Factory {
            MODIFIABLE { // from class: net.bytebuddy.dynamic.scaffold.InstrumentedType.Factory.Default.1
                /*  JADX ERROR: NullPointerException in pass: ConstructorVisitor
                    java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.RegisterArg.sameRegAndSVar(jadx.core.dex.instructions.args.InsnArg)" because "resultArg" is null
                    	at jadx.core.dex.visitors.MoveInlineVisitor.processMove(MoveInlineVisitor.java:54)
                    	at jadx.core.dex.visitors.MoveInlineVisitor.moveInline(MoveInlineVisitor.java:42)
                    	at jadx.core.dex.visitors.ConstructorVisitor.visit(ConstructorVisitor.java:43)
                    */
                @Override // net.bytebuddy.dynamic.scaffold.InstrumentedType.Factory
                public net.bytebuddy.dynamic.scaffold.InstrumentedType.WithFlexibleName represent(
                /*  JADX ERROR: Method generation error
                    jadx.core.utils.exceptions.JadxRuntimeException: Code variable not set in r27v0 ??
                    	at jadx.core.dex.instructions.args.SSAVar.getCodeVar(SSAVar.java:236)
                    	at jadx.core.codegen.MethodGen.addMethodArguments(MethodGen.java:224)
                    	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:169)
                    	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:407)
                    	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:337)
                    	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:303)
                    	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
                    	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                    	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                    */
                /*  JADX ERROR: NullPointerException in pass: ConstructorVisitor
                    java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.RegisterArg.sameRegAndSVar(jadx.core.dex.instructions.args.InsnArg)" because "resultArg" is null
                    	at jadx.core.dex.visitors.MoveInlineVisitor.processMove(MoveInlineVisitor.java:54)
                    	at jadx.core.dex.visitors.MoveInlineVisitor.moveInline(MoveInlineVisitor.java:42)
                    */
            },
            FROZEN { // from class: net.bytebuddy.dynamic.scaffold.InstrumentedType.Factory.Default.2
                @Override // net.bytebuddy.dynamic.scaffold.InstrumentedType.Factory
                public WithFlexibleName represent(TypeDescription typeDescription) {
                    return new Frozen(typeDescription, LoadedTypeInitializer.NoOp.INSTANCE);
                }
            };

            @Override // net.bytebuddy.dynamic.scaffold.InstrumentedType.Factory
            public WithFlexibleName subclass(String str, int i, @MaybeNull TypeDescription.Generic generic) {
                ModuleDescription moduleDescription = ModuleDescription.UNDEFINED;
                List list = Collections.EMPTY_LIST;
                Map map = Collections.EMPTY_MAP;
                TypeInitializer.None none = TypeInitializer.None.INSTANCE;
                LoadedTypeInitializer.NoOp noOp = LoadedTypeInitializer.NoOp.INSTANCE;
                TypeDescription typeDescription = TypeDescription.UNDEFINED;
                return new Default(str, i, moduleDescription, list, generic, list, list, map, list, list, list, none, noOp, typeDescription, MethodDescription.UNDEFINED, typeDescription, list, TypeList.UNDEFINED, false, false, false, TargetType.DESCRIPTION, list);
            }
        }

        WithFlexibleName represent(TypeDescription typeDescription);

        WithFlexibleName subclass(String str, int i, @MaybeNull TypeDescription.Generic generic);
    }

    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
    public static class Frozen extends TypeDescription.AbstractBase.OfSimpleType implements WithFlexibleName {
        private final LoadedTypeInitializer loadedTypeInitializer;
        private final TypeDescription typeDescription;

        public Frozen(TypeDescription typeDescription, LoadedTypeInitializer loadedTypeInitializer) {
            this.typeDescription = typeDescription;
            this.loadedTypeInitializer = loadedTypeInitializer;
        }

        @Override // net.bytebuddy.description.type.TypeDescription.AbstractBase, net.bytebuddy.description.type.TypeDescription
        public int getActualModifiers(boolean z) {
            return this.typeDescription.getActualModifiers(z);
        }

        @Override // net.bytebuddy.description.type.TypeDescription.AbstractBase, net.bytebuddy.description.type.TypeDescription
        @MaybeNull
        public ClassFileVersion getClassFileVersion() {
            return this.typeDescription.getClassFileVersion();
        }

        @Override // net.bytebuddy.description.annotation.AnnotationSource
        public AnnotationList getDeclaredAnnotations() {
            return this.typeDescription.getDeclaredAnnotations();
        }

        @Override // net.bytebuddy.description.type.TypeDescription, net.bytebuddy.description.type.TypeDefinition
        public FieldList<FieldDescription.InDefinedShape> getDeclaredFields() {
            return this.typeDescription.getDeclaredFields();
        }

        @Override // net.bytebuddy.description.type.TypeDescription, net.bytebuddy.description.type.TypeDefinition
        public MethodList<MethodDescription.InDefinedShape> getDeclaredMethods() {
            return this.typeDescription.getDeclaredMethods();
        }

        @Override // net.bytebuddy.description.type.TypeDescription
        public TypeList getDeclaredTypes() {
            return this.typeDescription.getDeclaredTypes();
        }

        @Override // net.bytebuddy.description.type.TypeDescription
        @MaybeNull
        public MethodDescription.InDefinedShape getEnclosingMethod() {
            return this.typeDescription.getEnclosingMethod();
        }

        @Override // net.bytebuddy.description.type.TypeDescription
        @MaybeNull
        public TypeDescription getEnclosingType() {
            return this.typeDescription.getEnclosingType();
        }

        @Override // net.bytebuddy.description.type.TypeDescription.AbstractBase, net.bytebuddy.description.NamedElement.WithDescriptor
        @MaybeNull
        public String getGenericSignature() {
            return this.typeDescription.getGenericSignature();
        }

        @Override // net.bytebuddy.description.type.TypeDefinition
        public TypeList.Generic getInterfaces() {
            return this.typeDescription.getInterfaces();
        }

        @Override // net.bytebuddy.dynamic.scaffold.InstrumentedType
        public LoadedTypeInitializer getLoadedTypeInitializer() {
            return this.loadedTypeInitializer;
        }

        @Override // net.bytebuddy.description.ModifierReviewable
        public int getModifiers() {
            return this.typeDescription.getModifiers();
        }

        @Override // net.bytebuddy.description.NamedElement.WithRuntimeName
        public String getName() {
            return this.typeDescription.getName();
        }

        @Override // net.bytebuddy.description.type.TypeDescription
        public TypeDescription getNestHost() {
            return this.typeDescription.getNestHost();
        }

        @Override // net.bytebuddy.description.type.TypeDescription
        public TypeList getNestMembers() {
            return this.typeDescription.getNestMembers();
        }

        @Override // net.bytebuddy.description.type.TypeDescription
        @MaybeNull
        public PackageDescription getPackage() {
            return this.typeDescription.getPackage();
        }

        @Override // net.bytebuddy.description.type.TypeDescription
        public TypeList getPermittedSubtypes() {
            return this.typeDescription.getPermittedSubtypes();
        }

        @Override // net.bytebuddy.description.type.TypeDescription, net.bytebuddy.description.type.TypeDefinition
        public RecordComponentList<RecordComponentDescription.InDefinedShape> getRecordComponents() {
            return this.typeDescription.getRecordComponents();
        }

        @Override // net.bytebuddy.description.type.TypeDefinition
        @MaybeNull
        public TypeDescription.Generic getSuperClass() {
            return this.typeDescription.getSuperClass();
        }

        @Override // net.bytebuddy.dynamic.scaffold.InstrumentedType
        public TypeInitializer getTypeInitializer() {
            return TypeInitializer.None.INSTANCE;
        }

        @Override // net.bytebuddy.description.TypeVariableSource
        public TypeList.Generic getTypeVariables() {
            return this.typeDescription.getTypeVariables();
        }

        @Override // net.bytebuddy.description.type.TypeDescription
        public boolean isAnonymousType() {
            return this.typeDescription.isAnonymousType();
        }

        @Override // net.bytebuddy.description.type.TypeDescription
        public boolean isLocalType() {
            return this.typeDescription.isLocalType();
        }

        @Override // net.bytebuddy.description.type.TypeDefinition
        public boolean isRecord() {
            return this.typeDescription.isRecord();
        }

        @Override // net.bytebuddy.description.type.TypeDescription.AbstractBase, net.bytebuddy.description.type.TypeDescription
        public boolean isSealed() {
            return this.typeDescription.isSealed();
        }

        @Override // net.bytebuddy.description.type.TypeDescription
        @MaybeNull
        public ModuleDescription toModuleDescription() {
            return this.typeDescription.toModuleDescription();
        }

        @Override // net.bytebuddy.dynamic.scaffold.InstrumentedType
        public TypeDescription validated() {
            return this.typeDescription;
        }

        @Override // net.bytebuddy.dynamic.scaffold.InstrumentedType
        public /* bridge */ /* synthetic */ InstrumentedType withAnnotations(List list) {
            return withAnnotations((List<? extends AnnotationDescription>) list);
        }

        @Override // net.bytebuddy.dynamic.scaffold.InstrumentedType.WithFlexibleName
        public WithFlexibleName withName(String str) {
            throw new IllegalStateException("Cannot change name of frozen type: " + this.typeDescription);
        }

        @Override // net.bytebuddy.dynamic.scaffold.InstrumentedType.WithFlexibleName
        public WithFlexibleName withTypeVariables(ElementMatcher<? super TypeDescription.Generic> elementMatcher, Transformer<TypeVariableToken> transformer) {
            throw new IllegalStateException("Cannot add type variables of frozen type: " + this.typeDescription);
        }

        @Override // net.bytebuddy.description.DeclaredByType
        @MaybeNull
        public TypeDescription getDeclaringType() {
            return this.typeDescription.getDeclaringType();
        }

        @Override // net.bytebuddy.dynamic.scaffold.InstrumentedType.WithFlexibleName, net.bytebuddy.dynamic.scaffold.InstrumentedType
        public WithFlexibleName withAnnotations(List<? extends AnnotationDescription> list) {
            throw new IllegalStateException("Cannot add annotation to frozen type: " + this.typeDescription);
        }

        @Override // net.bytebuddy.dynamic.scaffold.InstrumentedType
        public WithFlexibleName withAnonymousClass(boolean z) {
            throw new IllegalStateException("Cannot define anonymous class state for frozen type: " + this.typeDescription);
        }

        @Override // net.bytebuddy.dynamic.scaffold.InstrumentedType
        public WithFlexibleName withAuxiliaryField(FieldDescription.Token token, Object obj) {
            throw new IllegalStateException("Cannot define auxiliary field for frozen type: " + this.typeDescription);
        }

        @Override // net.bytebuddy.dynamic.scaffold.InstrumentedType
        public WithFlexibleName withDeclaredTypes(TypeList typeList) {
            throw new IllegalStateException("Cannot add declared types to frozen type: " + this.typeDescription);
        }

        @Override // net.bytebuddy.dynamic.scaffold.InstrumentedType
        public WithFlexibleName withDeclaringType(@MaybeNull TypeDescription typeDescription) {
            throw new IllegalStateException("Cannot add declaring type to frozen type: " + this.typeDescription);
        }

        @Override // net.bytebuddy.dynamic.scaffold.InstrumentedType
        public WithFlexibleName withEnclosingMethod(MethodDescription.InDefinedShape inDefinedShape) {
            throw new IllegalStateException("Cannot set enclosing method of frozen type: " + this.typeDescription);
        }

        @Override // net.bytebuddy.dynamic.scaffold.InstrumentedType
        public WithFlexibleName withEnclosingType(@MaybeNull TypeDescription typeDescription) {
            throw new IllegalStateException("Cannot set enclosing type of frozen type: " + this.typeDescription);
        }

        @Override // net.bytebuddy.dynamic.scaffold.InstrumentedType
        public WithFlexibleName withField(FieldDescription.Token token) {
            throw new IllegalStateException("Cannot define field for frozen type: " + this.typeDescription);
        }

        @Override // net.bytebuddy.dynamic.scaffold.InstrumentedType
        public WithFlexibleName withInterfaces(TypeList.Generic generic) {
            throw new IllegalStateException("Cannot add interfaces for frozen type: " + this.typeDescription);
        }

        @Override // net.bytebuddy.dynamic.scaffold.InstrumentedType
        public WithFlexibleName withLocalClass(boolean z) {
            throw new IllegalStateException("Cannot define local class state for frozen type: " + this.typeDescription);
        }

        @Override // net.bytebuddy.dynamic.scaffold.InstrumentedType
        public WithFlexibleName withMethod(MethodDescription.Token token) {
            throw new IllegalStateException("Cannot define method for frozen type: " + this.typeDescription);
        }

        @Override // net.bytebuddy.dynamic.scaffold.InstrumentedType
        public WithFlexibleName withModifiers(int i) {
            throw new IllegalStateException("Cannot change modifiers for frozen type: " + this.typeDescription);
        }

        @Override // net.bytebuddy.dynamic.scaffold.InstrumentedType
        public WithFlexibleName withModuleDescription(@MaybeNull ModuleDescription moduleDescription) {
            throw new IllegalStateException("Cannot define module meta data for frozen type: " + this.typeDescription);
        }

        @Override // net.bytebuddy.dynamic.scaffold.InstrumentedType
        public WithFlexibleName withNestHost(TypeDescription typeDescription) {
            throw new IllegalStateException("Cannot set nest host of frozen type: " + this.typeDescription);
        }

        @Override // net.bytebuddy.dynamic.scaffold.InstrumentedType
        public WithFlexibleName withNestMembers(TypeList typeList) {
            throw new IllegalStateException("Cannot add nest members to frozen type: " + this.typeDescription);
        }

        @Override // net.bytebuddy.dynamic.scaffold.InstrumentedType
        public WithFlexibleName withPermittedSubclasses(@MaybeNull TypeList typeList) {
            throw new IllegalStateException("Cannot add permitted subclasses to frozen type: " + this.typeDescription);
        }

        @Override // net.bytebuddy.dynamic.scaffold.InstrumentedType
        public WithFlexibleName withRecord(boolean z) {
            throw new IllegalStateException("Cannot define record state for frozen type: " + this.typeDescription);
        }

        @Override // net.bytebuddy.dynamic.scaffold.InstrumentedType
        public WithFlexibleName withRecordComponent(RecordComponentDescription.Token token) {
            throw new IllegalStateException("Cannot define record component for frozen type: " + this.typeDescription);
        }

        @Override // net.bytebuddy.dynamic.scaffold.InstrumentedType
        public WithFlexibleName withTypeVariable(TypeVariableToken typeVariableToken) {
            throw new IllegalStateException("Cannot define type variable for frozen type: " + this.typeDescription);
        }

        @Override // net.bytebuddy.dynamic.scaffold.InstrumentedType
        public WithFlexibleName withInitializer(LoadedTypeInitializer loadedTypeInitializer) {
            return new Frozen(this.typeDescription, new LoadedTypeInitializer.Compound(this.loadedTypeInitializer, loadedTypeInitializer));
        }

        @Override // net.bytebuddy.dynamic.scaffold.InstrumentedType
        public WithFlexibleName withInitializer(ByteCodeAppender byteCodeAppender) {
            throw new IllegalStateException("Cannot add initializer to frozen type: " + this.typeDescription);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
    public interface Prepareable {

        /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
        public enum NoOp implements Prepareable {
            INSTANCE;

            @Override // net.bytebuddy.dynamic.scaffold.InstrumentedType.Prepareable
            public InstrumentedType prepare(InstrumentedType instrumentedType) {
                return instrumentedType;
            }
        }

        InstrumentedType prepare(InstrumentedType instrumentedType);
    }

    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
    public interface WithFlexibleName extends InstrumentedType {
        @Override // net.bytebuddy.dynamic.scaffold.InstrumentedType
        WithFlexibleName withAnnotations(List<? extends AnnotationDescription> list);

        @Override // net.bytebuddy.dynamic.scaffold.InstrumentedType
        WithFlexibleName withAnonymousClass(boolean z);

        @Override // net.bytebuddy.dynamic.scaffold.InstrumentedType
        WithFlexibleName withAuxiliaryField(FieldDescription.Token token, Object obj);

        @Override // net.bytebuddy.dynamic.scaffold.InstrumentedType
        WithFlexibleName withDeclaredTypes(TypeList typeList);

        @Override // net.bytebuddy.dynamic.scaffold.InstrumentedType
        WithFlexibleName withDeclaringType(@MaybeNull TypeDescription typeDescription);

        @Override // net.bytebuddy.dynamic.scaffold.InstrumentedType
        WithFlexibleName withEnclosingMethod(MethodDescription.InDefinedShape inDefinedShape);

        @Override // net.bytebuddy.dynamic.scaffold.InstrumentedType
        WithFlexibleName withEnclosingType(@MaybeNull TypeDescription typeDescription);

        @Override // net.bytebuddy.dynamic.scaffold.InstrumentedType
        WithFlexibleName withField(FieldDescription.Token token);

        @Override // net.bytebuddy.dynamic.scaffold.InstrumentedType
        WithFlexibleName withInitializer(LoadedTypeInitializer loadedTypeInitializer);

        @Override // net.bytebuddy.dynamic.scaffold.InstrumentedType
        WithFlexibleName withInitializer(ByteCodeAppender byteCodeAppender);

        @Override // net.bytebuddy.dynamic.scaffold.InstrumentedType
        WithFlexibleName withInterfaces(TypeList.Generic generic);

        @Override // net.bytebuddy.dynamic.scaffold.InstrumentedType
        WithFlexibleName withLocalClass(boolean z);

        @Override // net.bytebuddy.dynamic.scaffold.InstrumentedType
        WithFlexibleName withMethod(MethodDescription.Token token);

        @Override // net.bytebuddy.dynamic.scaffold.InstrumentedType
        WithFlexibleName withModifiers(int i);

        @Override // net.bytebuddy.dynamic.scaffold.InstrumentedType
        WithFlexibleName withModuleDescription(@MaybeNull ModuleDescription moduleDescription);

        WithFlexibleName withName(String str);

        @Override // net.bytebuddy.dynamic.scaffold.InstrumentedType
        WithFlexibleName withNestHost(TypeDescription typeDescription);

        @Override // net.bytebuddy.dynamic.scaffold.InstrumentedType
        WithFlexibleName withNestMembers(TypeList typeList);

        @Override // net.bytebuddy.dynamic.scaffold.InstrumentedType
        WithFlexibleName withPermittedSubclasses(@MaybeNull TypeList typeList);

        @Override // net.bytebuddy.dynamic.scaffold.InstrumentedType
        WithFlexibleName withRecord(boolean z);

        @Override // net.bytebuddy.dynamic.scaffold.InstrumentedType
        WithFlexibleName withRecordComponent(RecordComponentDescription.Token token);

        @Override // net.bytebuddy.dynamic.scaffold.InstrumentedType
        WithFlexibleName withTypeVariable(TypeVariableToken typeVariableToken);

        WithFlexibleName withTypeVariables(ElementMatcher<? super TypeDescription.Generic> elementMatcher, Transformer<TypeVariableToken> transformer);
    }

    LoadedTypeInitializer getLoadedTypeInitializer();

    TypeInitializer getTypeInitializer();

    TypeDescription validated();

    InstrumentedType withAnnotations(List<? extends AnnotationDescription> list);

    InstrumentedType withAnonymousClass(boolean z);

    InstrumentedType withAuxiliaryField(FieldDescription.Token token, Object obj);

    InstrumentedType withDeclaredTypes(TypeList typeList);

    InstrumentedType withDeclaringType(@MaybeNull TypeDescription typeDescription);

    InstrumentedType withEnclosingMethod(MethodDescription.InDefinedShape inDefinedShape);

    InstrumentedType withEnclosingType(TypeDescription typeDescription);

    InstrumentedType withField(FieldDescription.Token token);

    InstrumentedType withInitializer(LoadedTypeInitializer loadedTypeInitializer);

    InstrumentedType withInitializer(ByteCodeAppender byteCodeAppender);

    InstrumentedType withInterfaces(TypeList.Generic generic);

    InstrumentedType withLocalClass(boolean z);

    InstrumentedType withMethod(MethodDescription.Token token);

    InstrumentedType withModifiers(int i);

    InstrumentedType withModuleDescription(@MaybeNull ModuleDescription moduleDescription);

    InstrumentedType withNestHost(TypeDescription typeDescription);

    InstrumentedType withNestMembers(TypeList typeList);

    InstrumentedType withPermittedSubclasses(@MaybeNull TypeList typeList);

    InstrumentedType withRecord(boolean z);

    InstrumentedType withRecordComponent(RecordComponentDescription.Token token);

    InstrumentedType withTypeVariable(TypeVariableToken typeVariableToken);
}

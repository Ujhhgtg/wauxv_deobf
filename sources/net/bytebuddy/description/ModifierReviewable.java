package net.bytebuddy.description;

import me.hd.wauxv.obf.bjs;
import net.bytebuddy.description.modifier.EnumerationState;
import net.bytebuddy.description.modifier.FieldManifestation;
import net.bytebuddy.description.modifier.FieldPersistence;
import net.bytebuddy.description.modifier.Mandate;
import net.bytebuddy.description.modifier.MethodManifestation;
import net.bytebuddy.description.modifier.MethodStrictness;
import net.bytebuddy.description.modifier.Openness;
import net.bytebuddy.description.modifier.Ownership;
import net.bytebuddy.description.modifier.ParameterManifestation;
import net.bytebuddy.description.modifier.ProvisioningState;
import net.bytebuddy.description.modifier.RequiredPhase;
import net.bytebuddy.description.modifier.SynchronizationState;
import net.bytebuddy.description.modifier.SyntheticState;
import net.bytebuddy.description.modifier.Transitivity;
import net.bytebuddy.description.modifier.TypeManifestation;
import net.bytebuddy.description.modifier.Visibility;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public interface ModifierReviewable {
    public static final int EMPTY_MASK = 0;

    /*
     * JADX INFO: compiled from:
     * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
     */
    public static abstract class AbstractBase implements ForTypeDefinition, ForFieldDescription, ForMethodDescription,
            ForParameterDescription, ForModuleDescription, ForModuleRequirement {
        private boolean matchesMask(int i) {
            return (getModifiers() & i) == i;
        }

        @Override // net.bytebuddy.description.ModifierReviewable.OfEnumeration
        public EnumerationState getEnumerationState() {
            return isEnum() ? EnumerationState.ENUMERATION : EnumerationState.PLAIN;
        }

        @Override // net.bytebuddy.description.ModifierReviewable.ForFieldDescription
        public FieldManifestation getFieldManifestation() {
            int modifiers = getModifiers();
            int i = modifiers & 80;
            if (i == 0) {
                return FieldManifestation.PLAIN;
            }
            if (i == 16) {
                return FieldManifestation.FINAL;
            }
            if (i == 64) {
                return FieldManifestation.VOLATILE;
            }
            throw new IllegalStateException(concatVar2Var1(modifiers, "Unexpected modifiers: "));
        }

        @Override // net.bytebuddy.description.ModifierReviewable.ForFieldDescription
        public FieldPersistence getFieldPersistence() {
            int modifiers = getModifiers();
            int i = modifiers & 128;
            if (i == 0) {
                return FieldPersistence.PLAIN;
            }
            if (i == 128) {
                return FieldPersistence.TRANSIENT;
            }
            throw new IllegalStateException(concatVar2Var1(modifiers, "Unexpected modifiers: "));
        }

        @Override // net.bytebuddy.description.ModifierReviewable.OfMandatable
        public Mandate getMandate() {
            return isMandated() ? Mandate.MANDATED : Mandate.PLAIN;
        }

        @Override // net.bytebuddy.description.ModifierReviewable.ForMethodDescription
        public MethodManifestation getMethodManifestation() {
            int modifiers = getModifiers();
            int i = modifiers & 1360;
            if (i == 0) {
                return MethodManifestation.PLAIN;
            }
            if (i == 16) {
                return MethodManifestation.FINAL;
            }
            if (i == 64) {
                return MethodManifestation.BRIDGE;
            }
            if (i == 80) {
                return MethodManifestation.FINAL_BRIDGE;
            }
            if (i == 256) {
                return MethodManifestation.NATIVE;
            }
            if (i == 272) {
                return MethodManifestation.FINAL_NATIVE;
            }
            if (i == 1024) {
                return MethodManifestation.ABSTRACT;
            }
            throw new IllegalStateException(concatVar2Var1(modifiers, "Unexpected modifiers: "));
        }

        @Override // net.bytebuddy.description.ModifierReviewable.ForMethodDescription
        public MethodStrictness getMethodStrictness() {
            return isStrict() ? MethodStrictness.STRICT : MethodStrictness.PLAIN;
        }

        @Override // net.bytebuddy.description.ModifierReviewable.ForModuleDescription
        public Openness getOpenness() {
            return isOpen() ? Openness.OPEN : Openness.CLOSED;
        }

        @Override // net.bytebuddy.description.ModifierReviewable.OfByteCodeElement
        public Ownership getOwnership() {
            return isStatic() ? Ownership.STATIC : Ownership.MEMBER;
        }

        @Override // net.bytebuddy.description.ModifierReviewable.ForParameterDescription
        public ParameterManifestation getParameterManifestation() {
            return isFinal() ? ParameterManifestation.FINAL : ParameterManifestation.PLAIN;
        }

        @Override // net.bytebuddy.description.ModifierReviewable.ForParameterDescription
        public ProvisioningState getProvisioningState() {
            return isMandated() ? ProvisioningState.MANDATED : ProvisioningState.PLAIN;
        }

        @Override // net.bytebuddy.description.ModifierReviewable.ForModuleRequirement
        public RequiredPhase getRequiredPhase() {
            return isStaticPhase() ? RequiredPhase.STATIC : RequiredPhase.ALWAYS;
        }

        @Override // net.bytebuddy.description.ModifierReviewable.ForMethodDescription
        public SynchronizationState getSynchronizationState() {
            return isSynchronized() ? SynchronizationState.SYNCHRONIZED : SynchronizationState.PLAIN;
        }

        @Override // net.bytebuddy.description.ModifierReviewable
        public SyntheticState getSyntheticState() {
            return isSynthetic() ? SyntheticState.SYNTHETIC : SyntheticState.PLAIN;
        }

        @Override // net.bytebuddy.description.ModifierReviewable.ForModuleRequirement
        public Transitivity getTransitivity() {
            return isTransitive() ? Transitivity.TRANSITIVE : Transitivity.NONE;
        }

        @Override // net.bytebuddy.description.ModifierReviewable.ForTypeDefinition
        public TypeManifestation getTypeManifestation() {
            int modifiers = getModifiers();
            int i = modifiers & 9744;
            if (i == 0) {
                return TypeManifestation.PLAIN;
            }
            if (i == 16) {
                return TypeManifestation.FINAL;
            }
            if (i == 1024) {
                return TypeManifestation.ABSTRACT;
            }
            if (i == 1536) {
                return TypeManifestation.INTERFACE;
            }
            if (i == 9728) {
                return TypeManifestation.ANNOTATION;
            }
            throw new IllegalStateException(concatVar2Var1(modifiers, "Unexpected modifiers: "));
        }

        @Override // net.bytebuddy.description.ModifierReviewable.OfByteCodeElement
        public Visibility getVisibility() {
            int modifiers = getModifiers();
            int i = modifiers & 7;
            if (i == 0) {
                return Visibility.PACKAGE_PRIVATE;
            }
            if (i == 1) {
                return Visibility.PUBLIC;
            }
            if (i == 2) {
                return Visibility.PRIVATE;
            }
            if (i == 4) {
                return Visibility.PROTECTED;
            }
            throw new IllegalStateException(concatVar2Var1(modifiers, "Unexpected modifiers: "));
        }

        @Override // net.bytebuddy.description.ModifierReviewable.OfAbstraction
        public boolean isAbstract() {
            return matchesMask(1024);
        }

        @Override // net.bytebuddy.description.ModifierReviewable.ForTypeDefinition
        public boolean isAnnotation() {
            return matchesMask(8192);
        }

        @Override // net.bytebuddy.description.ModifierReviewable.ForMethodDescription
        public boolean isBridge() {
            return matchesMask(64);
        }

        @Override // net.bytebuddy.description.ModifierReviewable.OfByteCodeElement
        public boolean isDeprecated() {
            return matchesMask(131072);
        }

        @Override // net.bytebuddy.description.ModifierReviewable.OfEnumeration
        public boolean isEnum() {
            return matchesMask(16384);
        }

        @Override // net.bytebuddy.description.ModifierReviewable
        public boolean isFinal() {
            return matchesMask(16);
        }

        @Override // net.bytebuddy.description.ModifierReviewable.ForTypeDefinition
        public boolean isInterface() {
            return matchesMask(512);
        }

        @Override // net.bytebuddy.description.ModifierReviewable.OfMandatable
        public boolean isMandated() {
            return matchesMask(32768);
        }

        @Override // net.bytebuddy.description.ModifierReviewable.ForMethodDescription
        public boolean isNative() {
            return matchesMask(256);
        }

        @Override // net.bytebuddy.description.ModifierReviewable.ForModuleDescription
        public boolean isOpen() {
            return matchesMask(32);
        }

        @Override // net.bytebuddy.description.ModifierReviewable.OfByteCodeElement
        public boolean isPackagePrivate() {
            return (isPublic() || isProtected() || isPrivate()) ? false : true;
        }

        @Override // net.bytebuddy.description.ModifierReviewable.OfByteCodeElement
        public boolean isPrivate() {
            return matchesMask(2);
        }

        @Override // net.bytebuddy.description.ModifierReviewable.OfByteCodeElement
        public boolean isProtected() {
            return matchesMask(4);
        }

        @Override // net.bytebuddy.description.ModifierReviewable.OfByteCodeElement
        public boolean isPublic() {
            return matchesMask(1);
        }

        @Override // net.bytebuddy.description.ModifierReviewable.OfByteCodeElement
        public boolean isStatic() {
            return matchesMask(8);
        }

        @Override // net.bytebuddy.description.ModifierReviewable.ForModuleRequirement
        public boolean isStaticPhase() {
            return matchesMask(64);
        }

        @Override // net.bytebuddy.description.ModifierReviewable.ForMethodDescription
        public boolean isStrict() {
            return matchesMask(2048);
        }

        @Override // net.bytebuddy.description.ModifierReviewable.ForMethodDescription
        public boolean isSynchronized() {
            return matchesMask(32);
        }

        @Override // net.bytebuddy.description.ModifierReviewable
        public boolean isSynthetic() {
            return matchesMask(4096);
        }

        @Override // net.bytebuddy.description.ModifierReviewable.ForFieldDescription
        public boolean isTransient() {
            return matchesMask(128);
        }

        @Override // net.bytebuddy.description.ModifierReviewable.ForModuleRequirement
        public boolean isTransitive() {
            return matchesMask(32);
        }

        @Override // net.bytebuddy.description.ModifierReviewable.ForMethodDescription
        public boolean isVarArgs() {
            return matchesMask(128);
        }

        @Override // net.bytebuddy.description.ModifierReviewable.ForFieldDescription
        public boolean isVolatile() {
            return matchesMask(64);
        }
    }

    /*
     * JADX INFO: compiled from:
     * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
     */
    public interface ForFieldDescription extends OfEnumeration {
        FieldManifestation getFieldManifestation();

        FieldPersistence getFieldPersistence();

        boolean isTransient();

        boolean isVolatile();
    }

    /*
     * JADX INFO: compiled from:
     * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
     */
    public interface ForMethodDescription extends OfAbstraction {
        MethodManifestation getMethodManifestation();

        MethodStrictness getMethodStrictness();

        SynchronizationState getSynchronizationState();

        boolean isBridge();

        boolean isNative();

        boolean isStrict();

        boolean isSynchronized();

        boolean isVarArgs();
    }

    /*
     * JADX INFO: compiled from:
     * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
     */
    public interface ForModuleDescription extends ModifierReviewable {
        Openness getOpenness();

        boolean isOpen();
    }

    /*
     * JADX INFO: compiled from:
     * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
     */
    public interface ForModuleRequirement extends OfMandatable {
        RequiredPhase getRequiredPhase();

        Transitivity getTransitivity();

        boolean isStaticPhase();

        boolean isTransitive();
    }

    /*
     * JADX INFO: compiled from:
     * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
     */
    public interface ForParameterDescription extends OfMandatable {
        ParameterManifestation getParameterManifestation();

        ProvisioningState getProvisioningState();
    }

    /*
     * JADX INFO: compiled from:
     * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
     */
    public interface ForTypeDefinition extends OfAbstraction, OfEnumeration {
        TypeManifestation getTypeManifestation();

        boolean isAnnotation();

        boolean isInterface();
    }

    /*
     * JADX INFO: compiled from:
     * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
     */
    public interface OfAbstraction extends OfByteCodeElement {
        boolean isAbstract();
    }

    /*
     * JADX INFO: compiled from:
     * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
     */
    public interface OfByteCodeElement extends ModifierReviewable {
        Ownership getOwnership();

        Visibility getVisibility();

        boolean isDeprecated();

        boolean isPackagePrivate();

        boolean isPrivate();

        boolean isProtected();

        boolean isPublic();

        boolean isStatic();
    }

    /*
     * JADX INFO: compiled from:
     * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
     */
    public interface OfEnumeration extends OfByteCodeElement {
        EnumerationState getEnumerationState();

        boolean isEnum();
    }

    /*
     * JADX INFO: compiled from:
     * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
     */
    public interface OfMandatable extends ModifierReviewable {
        Mandate getMandate();

        boolean isMandated();
    }

    int getModifiers();

    SyntheticState getSyntheticState();

    boolean isFinal();

    boolean isSynthetic();
}

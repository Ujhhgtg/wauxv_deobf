package net.bytebuddy.implementation.bind;

import me.hd.wauxv.obf.dkz;
import net.bytebuddy.description.method.MethodDescription;
import net.bytebuddy.description.method.ParameterDescription;
import net.bytebuddy.description.method.ParameterList;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.implementation.bind.MethodDelegationBinder;
import net.bytebuddy.utility.nullability.MaybeNull;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public enum ArgumentTypeResolver implements MethodDelegationBinder.AmbiguityResolver {
    INSTANCE;

    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
    public static class ParameterIndexToken {
        private final int parameterIndex;

        public ParameterIndexToken(int i) {
            this.parameterIndex = i;
        }

        public boolean equals(@MaybeNull Object obj) {
            if (this == obj) {
                return true;
            }
            return obj != null && getClass() == obj.getClass() && this.parameterIndex == ((ParameterIndexToken) obj).parameterIndex;
        }

        public int hashCode() {
            return this.parameterIndex;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
    public enum PrimitiveTypePrecedence {
        BOOLEAN(0),
        BYTE(1),
        SHORT(2),
        INTEGER(3),
        CHARACTER(4),
        LONG(5),
        FLOAT(6),
        DOUBLE(7);

        private final int score;

        PrimitiveTypePrecedence(int i) {
            this.score = i;
        }

        public static PrimitiveTypePrecedence forPrimitive(TypeDescription typeDescription) {
            if (typeDescription.represents(Boolean.TYPE)) {
                return BOOLEAN;
            }
            if (typeDescription.represents(Byte.TYPE)) {
                return BYTE;
            }
            if (typeDescription.represents(Short.TYPE)) {
                return SHORT;
            }
            if (typeDescription.represents(Integer.TYPE)) {
                return INTEGER;
            }
            if (typeDescription.represents(Character.TYPE)) {
                return CHARACTER;
            }
            if (typeDescription.represents(Long.TYPE)) {
                return LONG;
            }
            if (typeDescription.represents(Float.TYPE)) {
                return FLOAT;
            }
            if (typeDescription.represents(Double.TYPE)) {
                return DOUBLE;
            }
            throw new IllegalArgumentException(dkz.u("Not a non-void, primitive type ", typeDescription));
        }

        public MethodDelegationBinder.AmbiguityResolver.Resolution resolve(PrimitiveTypePrecedence primitiveTypePrecedence) {
            int i = this.score;
            int i2 = primitiveTypePrecedence.score;
            return i - i2 == 0 ? MethodDelegationBinder.AmbiguityResolver.Resolution.UNKNOWN : i - i2 > 0 ? MethodDelegationBinder.AmbiguityResolver.Resolution.RIGHT : MethodDelegationBinder.AmbiguityResolver.Resolution.LEFT;
        }
    }

    private static MethodDelegationBinder.AmbiguityResolver.Resolution resolveByScore(int i) {
        return i == 0 ? MethodDelegationBinder.AmbiguityResolver.Resolution.AMBIGUOUS : i > 0 ? MethodDelegationBinder.AmbiguityResolver.Resolution.LEFT : MethodDelegationBinder.AmbiguityResolver.Resolution.RIGHT;
    }

    private static MethodDelegationBinder.AmbiguityResolver.Resolution resolveRivalBinding(TypeDescription typeDescription, int i, MethodDelegationBinder.MethodBinding methodBinding, int i2, MethodDelegationBinder.MethodBinding methodBinding2) {
        TypeDescription typeDescriptionAsErasure = ((ParameterDescription) methodBinding.getTarget().getParameters().get(i)).getType().asErasure();
        TypeDescription typeDescriptionAsErasure2 = ((ParameterDescription) methodBinding2.getTarget().getParameters().get(i2)).getType().asErasure();
        return !typeDescriptionAsErasure.equals(typeDescriptionAsErasure2) ? (typeDescriptionAsErasure.isPrimitive() && typeDescriptionAsErasure2.isPrimitive()) ? PrimitiveTypePrecedence.forPrimitive(typeDescriptionAsErasure).resolve(PrimitiveTypePrecedence.forPrimitive(typeDescriptionAsErasure2)) : typeDescriptionAsErasure.isPrimitive() ? typeDescription.isPrimitive() ? MethodDelegationBinder.AmbiguityResolver.Resolution.LEFT : MethodDelegationBinder.AmbiguityResolver.Resolution.RIGHT : typeDescriptionAsErasure2.isPrimitive() ? typeDescription.isPrimitive() ? MethodDelegationBinder.AmbiguityResolver.Resolution.RIGHT : MethodDelegationBinder.AmbiguityResolver.Resolution.LEFT : typeDescriptionAsErasure.isAssignableFrom(typeDescriptionAsErasure2) ? MethodDelegationBinder.AmbiguityResolver.Resolution.RIGHT : typeDescriptionAsErasure2.isAssignableFrom(typeDescriptionAsErasure) ? MethodDelegationBinder.AmbiguityResolver.Resolution.LEFT : MethodDelegationBinder.AmbiguityResolver.Resolution.AMBIGUOUS : MethodDelegationBinder.AmbiguityResolver.Resolution.UNKNOWN;
    }

    @Override // net.bytebuddy.implementation.bind.MethodDelegationBinder.AmbiguityResolver
    public MethodDelegationBinder.AmbiguityResolver.Resolution resolve(MethodDescription methodDescription, MethodDelegationBinder.MethodBinding methodBinding, MethodDelegationBinder.MethodBinding methodBinding2) {
        MethodDelegationBinder.AmbiguityResolver.Resolution resolutionMerge = MethodDelegationBinder.AmbiguityResolver.Resolution.UNKNOWN;
        ParameterList<?> parameters = methodDescription.getParameters();
        int i = 0;
        int i2 = 0;
        for (int i3 = 0; i3 < parameters.size(); i3++) {
            ParameterIndexToken parameterIndexToken = new ParameterIndexToken(i3);
            Integer targetParameterIndex = methodBinding.getTargetParameterIndex(parameterIndexToken);
            Integer targetParameterIndex2 = methodBinding2.getTargetParameterIndex(parameterIndexToken);
            if (targetParameterIndex != null && targetParameterIndex2 != null) {
                resolutionMerge = resolutionMerge.merge(resolveRivalBinding(((ParameterDescription) parameters.get(i3)).getType().asErasure(), targetParameterIndex.intValue(), methodBinding, targetParameterIndex2.intValue(), methodBinding2));
            } else if (targetParameterIndex != null) {
                i++;
            } else if (targetParameterIndex2 != null) {
                i2++;
            }
        }
        return resolutionMerge == MethodDelegationBinder.AmbiguityResolver.Resolution.UNKNOWN ? resolveByScore(i - i2) : resolutionMerge;
    }
}

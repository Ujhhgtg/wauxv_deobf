package net.bytebuddy.implementation.bind;

import net.bytebuddy.description.method.MethodDescription;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.implementation.bind.MethodDelegationBinder;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public enum DeclaringTypeResolver implements MethodDelegationBinder.AmbiguityResolver {
    INSTANCE;

    @Override // net.bytebuddy.implementation.bind.MethodDelegationBinder.AmbiguityResolver
    public MethodDelegationBinder.AmbiguityResolver.Resolution resolve(MethodDescription methodDescription, MethodDelegationBinder.MethodBinding methodBinding, MethodDelegationBinder.MethodBinding methodBinding2) {
        TypeDescription typeDescriptionAsErasure = methodBinding.getTarget().getDeclaringType().asErasure();
        TypeDescription typeDescriptionAsErasure2 = methodBinding2.getTarget().getDeclaringType().asErasure();
        return typeDescriptionAsErasure.equals(typeDescriptionAsErasure2) ? MethodDelegationBinder.AmbiguityResolver.Resolution.AMBIGUOUS : typeDescriptionAsErasure.isAssignableFrom(typeDescriptionAsErasure2) ? MethodDelegationBinder.AmbiguityResolver.Resolution.RIGHT : typeDescriptionAsErasure.isAssignableTo(typeDescriptionAsErasure2) ? MethodDelegationBinder.AmbiguityResolver.Resolution.LEFT : MethodDelegationBinder.AmbiguityResolver.Resolution.AMBIGUOUS;
    }
}

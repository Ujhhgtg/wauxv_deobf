package net.bytebuddy.implementation.bind;

import net.bytebuddy.description.method.MethodDescription;
import net.bytebuddy.implementation.bind.MethodDelegationBinder;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public enum ParameterLengthResolver implements MethodDelegationBinder.AmbiguityResolver {
    INSTANCE;

    @Override // net.bytebuddy.implementation.bind.MethodDelegationBinder.AmbiguityResolver
    public MethodDelegationBinder.AmbiguityResolver.Resolution resolve(MethodDescription methodDescription, MethodDelegationBinder.MethodBinding methodBinding, MethodDelegationBinder.MethodBinding methodBinding2) {
        int size = methodBinding.getTarget().getParameters().size();
        int size2 = methodBinding2.getTarget().getParameters().size();
        return size == size2 ? MethodDelegationBinder.AmbiguityResolver.Resolution.AMBIGUOUS : size < size2 ? MethodDelegationBinder.AmbiguityResolver.Resolution.RIGHT : MethodDelegationBinder.AmbiguityResolver.Resolution.LEFT;
    }
}

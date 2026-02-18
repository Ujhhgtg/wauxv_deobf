package net.bytebuddy.description;

import javax.annotation.Nonnull;
import net.bytebuddy.description.type.TypeDefinition;
import net.bytebuddy.utility.nullability.MaybeNull;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public interface DeclaredByType {

    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
    public interface WithMandatoryDeclaration extends DeclaredByType {
        @Override // net.bytebuddy.description.DeclaredByType
        @Nonnull
        TypeDefinition getDeclaringType();
    }

    @MaybeNull
    TypeDefinition getDeclaringType();
}

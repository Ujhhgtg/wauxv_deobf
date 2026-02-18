package net.bytebuddy.build;

import net.bytebuddy.description.type.TypeDescription;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public interface AndroidDescriptor {

    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
    public enum Trivial implements AndroidDescriptor {
        LOCAL(TypeScope.LOCAL),
        EXTERNAL(TypeScope.EXTERNAL);

        private final TypeScope typeScope;

        Trivial(TypeScope typeScope) {
            this.typeScope = typeScope;
        }

        @Override // net.bytebuddy.build.AndroidDescriptor
        public TypeScope getTypeScope(TypeDescription typeDescription) {
            return this.typeScope;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
    public enum TypeScope {
        LOCAL,
        EXTERNAL
    }

    TypeScope getTypeScope(TypeDescription typeDescription);
}

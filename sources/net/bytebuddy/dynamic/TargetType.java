package net.bytebuddy.dynamic;

import net.bytebuddy.description.type.TypeDescription;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class TargetType {
    public static final TypeDescription DESCRIPTION = TypeDescription.ForLoadedType.of(TargetType.class);

    private TargetType() {
        throw new UnsupportedOperationException("This class only serves as a marker type and should not be instantiated");
    }

    public static TypeDescription resolve(TypeDescription typeDescription, TypeDescription typeDescription2) {
        int i = 0;
        TypeDescription componentType = typeDescription;
        while (componentType.isArray()) {
            componentType = componentType.getComponentType();
            i++;
        }
        return componentType.represents(TargetType.class) ? TypeDescription.ArrayProjection.of(typeDescription2, i) : typeDescription;
    }
}

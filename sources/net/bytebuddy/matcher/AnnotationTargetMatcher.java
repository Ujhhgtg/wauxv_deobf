package net.bytebuddy.matcher;

import java.lang.annotation.ElementType;
import net.bytebuddy.build.HashCodeAndEqualsPlugin;
import net.bytebuddy.description.annotation.AnnotationDescription;
import net.bytebuddy.matcher.ElementMatcher;
import net.bytebuddy.utility.nullability.MaybeNull;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
@HashCodeAndEqualsPlugin.Enhance
public class AnnotationTargetMatcher<T extends AnnotationDescription> extends ElementMatcher.Junction.ForNonNullValues<T> {
    private final ElementType elementType;

    public AnnotationTargetMatcher(ElementType elementType) {
        this.elementType = elementType;
    }

    @Override // net.bytebuddy.matcher.ElementMatcher.Junction.ForNonNullValues
    public boolean equals(@MaybeNull Object obj) {
        if (!super.equals(obj)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        return obj != null && getClass() == obj.getClass() && this.elementType.equals(((AnnotationTargetMatcher) obj).elementType);
    }

    @Override // net.bytebuddy.matcher.ElementMatcher.Junction.ForNonNullValues
    public int hashCode() {
        return this.elementType.hashCode() + (super.hashCode() * 31);
    }

    public String toString() {
        return "targetsElement(" + this.elementType + ")";
    }

    @Override // net.bytebuddy.matcher.ElementMatcher.Junction.ForNonNullValues
    public boolean doMatch(T t) {
        return t.isSupportedOn(this.elementType);
    }
}

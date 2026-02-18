package net.bytebuddy.matcher;

import net.bytebuddy.build.HashCodeAndEqualsPlugin;
import net.bytebuddy.description.ByteCodeElement;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.matcher.ElementMatcher;
import net.bytebuddy.utility.nullability.MaybeNull;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
@HashCodeAndEqualsPlugin.Enhance
public class VisibilityMatcher<T extends ByteCodeElement> extends ElementMatcher.Junction.ForNonNullValues<T> {
    private final TypeDescription typeDescription;

    public VisibilityMatcher(TypeDescription typeDescription) {
        this.typeDescription = typeDescription;
    }

    @Override // net.bytebuddy.matcher.ElementMatcher.Junction.ForNonNullValues
    public boolean equals(@MaybeNull Object obj) {
        if (!super.equals(obj)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        return obj != null && getClass() == obj.getClass() && this.typeDescription.equals(((VisibilityMatcher) obj).typeDescription);
    }

    @Override // net.bytebuddy.matcher.ElementMatcher.Junction.ForNonNullValues
    public int hashCode() {
        return this.typeDescription.hashCode() + (super.hashCode() * 31);
    }

    public String toString() {
        return "isVisibleTo(" + this.typeDescription + ")";
    }

    @Override // net.bytebuddy.matcher.ElementMatcher.Junction.ForNonNullValues
    public boolean doMatch(T t) {
        return t.isVisibleTo(this.typeDescription);
    }
}

package net.bytebuddy.matcher;

import net.bytebuddy.build.HashCodeAndEqualsPlugin;
import net.bytebuddy.matcher.ElementMatcher;
import net.bytebuddy.utility.nullability.MaybeNull;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
@HashCodeAndEqualsPlugin.Enhance
public class EqualityMatcher<T> extends ElementMatcher.Junction.AbstractBase<T> {
    private final Object value;

    public EqualityMatcher(Object obj) {
        this.value = obj;
    }

    public boolean equals(@MaybeNull Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && getClass() == obj.getClass() && this.value.equals(((EqualityMatcher) obj).value);
    }

    public int hashCode() {
        return this.value.hashCode() + (getClass().hashCode() * 31);
    }

    @Override // net.bytebuddy.matcher.ElementMatcher
    public boolean matches(@MaybeNull T t) {
        return this.value.equals(t);
    }

    public String toString() {
        return "is(" + this.value + ")";
    }
}

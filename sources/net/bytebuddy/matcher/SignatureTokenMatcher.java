package net.bytebuddy.matcher;

import me.hd.wauxv.obf.dkz;
import net.bytebuddy.build.HashCodeAndEqualsPlugin;
import net.bytebuddy.description.method.MethodDescription;
import net.bytebuddy.matcher.ElementMatcher;
import net.bytebuddy.utility.nullability.MaybeNull;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
@HashCodeAndEqualsPlugin.Enhance
public class SignatureTokenMatcher<T extends MethodDescription> extends ElementMatcher.Junction.ForNonNullValues<T> {
    private final ElementMatcher<? super MethodDescription.SignatureToken> matcher;

    public SignatureTokenMatcher(ElementMatcher<? super MethodDescription.SignatureToken> elementMatcher) {
        this.matcher = elementMatcher;
    }

    @Override // net.bytebuddy.matcher.ElementMatcher.Junction.ForNonNullValues
    public boolean equals(@MaybeNull Object obj) {
        if (!super.equals(obj)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        return obj != null && getClass() == obj.getClass() && this.matcher.equals(((SignatureTokenMatcher) obj).matcher);
    }

    @Override // net.bytebuddy.matcher.ElementMatcher.Junction.ForNonNullValues
    public int hashCode() {
        return this.matcher.hashCode() + (super.hashCode() * 31);
    }

    public String toString() {
        return dkz.w(new StringBuilder("signature("), this.matcher, ")");
    }

    @Override // net.bytebuddy.matcher.ElementMatcher.Junction.ForNonNullValues
    public boolean doMatch(T t) {
        return this.matcher.matches(t.asSignatureToken());
    }
}

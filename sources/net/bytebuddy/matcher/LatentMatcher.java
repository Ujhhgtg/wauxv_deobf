package net.bytebuddy.matcher;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import net.bytebuddy.build.HashCodeAndEqualsPlugin;
import net.bytebuddy.build.SafeVarargsPlugin;
import net.bytebuddy.description.field.FieldDescription;
import net.bytebuddy.description.method.MethodDescription;
import net.bytebuddy.description.type.RecordComponentDescription;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.matcher.ElementMatcher;
import net.bytebuddy.utility.nullability.MaybeNull;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public interface LatentMatcher<T> {

    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
    @HashCodeAndEqualsPlugin.Enhance
    public static class Conjunction<S> implements LatentMatcher<S> {
        private final List<? extends LatentMatcher<? super S>> matchers;

        @SafeVarargs
        @SafeVarargsPlugin.Enhance
        public Conjunction(LatentMatcher<? super S>... latentMatcherArr) {
            this(Arrays.asList(latentMatcherArr));
        }

        public boolean equals(@MaybeNull Object obj) {
            if (this == obj) {
                return true;
            }
            return obj != null && getClass() == obj.getClass() && this.matchers.equals(((Conjunction) obj).matchers);
        }

        public int hashCode() {
            return this.matchers.hashCode() + (getClass().hashCode() * 31);
        }

        @Override // net.bytebuddy.matcher.LatentMatcher
        public ElementMatcher<? super S> resolve(TypeDescription typeDescription) {
            ElementMatcher.Junction junctionAny = ElementMatchers.any();
            Iterator<? extends LatentMatcher<? super S>> it = this.matchers.iterator();
            while (it.hasNext()) {
                junctionAny = junctionAny.and(it.next().resolve(typeDescription));
            }
            return junctionAny;
        }

        public Conjunction(List<? extends LatentMatcher<? super S>> list) {
            this.matchers = list;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
    @HashCodeAndEqualsPlugin.Enhance
    public static class Disjunction<S> implements LatentMatcher<S> {
        private final List<? extends LatentMatcher<? super S>> matchers;

        @SafeVarargs
        @SafeVarargsPlugin.Enhance
        public Disjunction(LatentMatcher<? super S>... latentMatcherArr) {
            this(Arrays.asList(latentMatcherArr));
        }

        public boolean equals(@MaybeNull Object obj) {
            if (this == obj) {
                return true;
            }
            return obj != null && getClass() == obj.getClass() && this.matchers.equals(((Disjunction) obj).matchers);
        }

        public int hashCode() {
            return this.matchers.hashCode() + (getClass().hashCode() * 31);
        }

        @Override // net.bytebuddy.matcher.LatentMatcher
        public ElementMatcher<? super S> resolve(TypeDescription typeDescription) {
            ElementMatcher.Junction junctionNone = ElementMatchers.none();
            Iterator<? extends LatentMatcher<? super S>> it = this.matchers.iterator();
            while (it.hasNext()) {
                junctionNone = junctionNone.or(it.next().resolve(typeDescription));
            }
            return junctionNone;
        }

        public Disjunction(List<? extends LatentMatcher<? super S>> list) {
            this.matchers = list;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
    @HashCodeAndEqualsPlugin.Enhance
    public static class ForFieldToken implements LatentMatcher<FieldDescription> {
        private final FieldDescription.Token token;

        /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
        @HashCodeAndEqualsPlugin.Enhance
        public static class ResolvedMatcher extends ElementMatcher.Junction.ForNonNullValues<FieldDescription> {
            private final FieldDescription.SignatureToken signatureToken;

            public ResolvedMatcher(FieldDescription.SignatureToken signatureToken) {
                this.signatureToken = signatureToken;
            }

            @Override // net.bytebuddy.matcher.ElementMatcher.Junction.ForNonNullValues
            public boolean equals(@MaybeNull Object obj) {
                if (!super.equals(obj)) {
                    return false;
                }
                if (this == obj) {
                    return true;
                }
                return obj != null && getClass() == obj.getClass() && this.signatureToken.equals(((ResolvedMatcher) obj).signatureToken);
            }

            @Override // net.bytebuddy.matcher.ElementMatcher.Junction.ForNonNullValues
            public int hashCode() {
                return this.signatureToken.hashCode() + (super.hashCode() * 31);
            }

            @Override // net.bytebuddy.matcher.ElementMatcher.Junction.ForNonNullValues
            public boolean doMatch(FieldDescription fieldDescription) {
                return fieldDescription.asSignatureToken().equals(this.signatureToken);
            }
        }

        public ForFieldToken(FieldDescription.Token token) {
            this.token = token;
        }

        public boolean equals(@MaybeNull Object obj) {
            if (this == obj) {
                return true;
            }
            return obj != null && getClass() == obj.getClass() && this.token.equals(((ForFieldToken) obj).token);
        }

        public int hashCode() {
            return this.token.hashCode() + (getClass().hashCode() * 31);
        }

        @Override // net.bytebuddy.matcher.LatentMatcher
        public ElementMatcher<? super FieldDescription> resolve(TypeDescription typeDescription) {
            return new ResolvedMatcher(this.token.asSignatureToken(typeDescription));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
    @HashCodeAndEqualsPlugin.Enhance
    public static class ForMethodToken implements LatentMatcher<MethodDescription> {
        private final MethodDescription.Token token;

        /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
        @HashCodeAndEqualsPlugin.Enhance
        public static class ResolvedMatcher extends ElementMatcher.Junction.ForNonNullValues<MethodDescription> {
            private final MethodDescription.SignatureToken signatureToken;

            public ResolvedMatcher(MethodDescription.SignatureToken signatureToken) {
                this.signatureToken = signatureToken;
            }

            @Override // net.bytebuddy.matcher.ElementMatcher.Junction.ForNonNullValues
            public boolean equals(@MaybeNull Object obj) {
                if (!super.equals(obj)) {
                    return false;
                }
                if (this == obj) {
                    return true;
                }
                return obj != null && getClass() == obj.getClass() && this.signatureToken.equals(((ResolvedMatcher) obj).signatureToken);
            }

            @Override // net.bytebuddy.matcher.ElementMatcher.Junction.ForNonNullValues
            public int hashCode() {
                return this.signatureToken.hashCode() + (super.hashCode() * 31);
            }

            @Override // net.bytebuddy.matcher.ElementMatcher.Junction.ForNonNullValues
            public boolean doMatch(MethodDescription methodDescription) {
                return methodDescription.asSignatureToken().equals(this.signatureToken);
            }
        }

        public ForMethodToken(MethodDescription.Token token) {
            this.token = token;
        }

        public boolean equals(@MaybeNull Object obj) {
            if (this == obj) {
                return true;
            }
            return obj != null && getClass() == obj.getClass() && this.token.equals(((ForMethodToken) obj).token);
        }

        public int hashCode() {
            return this.token.hashCode() + (getClass().hashCode() * 31);
        }

        @Override // net.bytebuddy.matcher.LatentMatcher
        public ElementMatcher<? super MethodDescription> resolve(TypeDescription typeDescription) {
            return new ResolvedMatcher(this.token.asSignatureToken(typeDescription));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
    @HashCodeAndEqualsPlugin.Enhance
    public static class ForRecordComponentToken implements LatentMatcher<RecordComponentDescription> {
        private final RecordComponentDescription.Token token;

        public ForRecordComponentToken(RecordComponentDescription.Token token) {
            this.token = token;
        }

        public boolean equals(@MaybeNull Object obj) {
            if (this == obj) {
                return true;
            }
            return obj != null && getClass() == obj.getClass() && this.token.equals(((ForRecordComponentToken) obj).token);
        }

        public int hashCode() {
            return this.token.hashCode() + (getClass().hashCode() * 31);
        }

        @Override // net.bytebuddy.matcher.LatentMatcher
        public ElementMatcher<? super RecordComponentDescription> resolve(TypeDescription typeDescription) {
            return ElementMatchers.named(this.token.getName());
        }
    }

    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
    public enum ForSelfDeclaredMethod implements LatentMatcher<MethodDescription> {
        DECLARED(false),
        NOT_DECLARED(true);

        private final boolean inverted;

        ForSelfDeclaredMethod(boolean z) {
            this.inverted = z;
        }

        @Override // net.bytebuddy.matcher.LatentMatcher
        public ElementMatcher<? super MethodDescription> resolve(TypeDescription typeDescription) {
            return this.inverted ? ElementMatchers.not(ElementMatchers.isDeclaredBy(typeDescription)) : ElementMatchers.isDeclaredBy(typeDescription);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
    @HashCodeAndEqualsPlugin.Enhance
    public static class Resolved<S> implements LatentMatcher<S> {
        private final ElementMatcher<? super S> matcher;

        public Resolved(ElementMatcher<? super S> elementMatcher) {
            this.matcher = elementMatcher;
        }

        public boolean equals(@MaybeNull Object obj) {
            if (this == obj) {
                return true;
            }
            return obj != null && getClass() == obj.getClass() && this.matcher.equals(((Resolved) obj).matcher);
        }

        public int hashCode() {
            return this.matcher.hashCode() + (getClass().hashCode() * 31);
        }

        @Override // net.bytebuddy.matcher.LatentMatcher
        public ElementMatcher<? super S> resolve(TypeDescription typeDescription) {
            return this.matcher;
        }
    }

    ElementMatcher<? super T> resolve(TypeDescription typeDescription);
}

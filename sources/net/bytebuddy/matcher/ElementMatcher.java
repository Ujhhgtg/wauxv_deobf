package net.bytebuddy.matcher;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import net.bytebuddy.build.HashCodeAndEqualsPlugin;
import net.bytebuddy.build.SafeVarargsPlugin;
import net.bytebuddy.utility.nullability.MaybeNull;
import net.bytebuddy.utility.nullability.UnknownNull;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public interface ElementMatcher<T> {

    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
    public interface Junction<S> extends ElementMatcher<S> {

        /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
        public static abstract class AbstractBase<V> implements Junction<V> {
            @Override // net.bytebuddy.matcher.ElementMatcher.Junction
            public <U extends V> Junction<U> and(ElementMatcher<? super U> elementMatcher) {
                return new Conjunction(this, elementMatcher);
            }

            @Override // net.bytebuddy.matcher.ElementMatcher.Junction
            public <U extends V> Junction<U> or(ElementMatcher<? super U> elementMatcher) {
                return new Disjunction(this, elementMatcher);
            }
        }

        /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
        @HashCodeAndEqualsPlugin.Enhance
        public static class Conjunction<W> extends AbstractBase<W> {
            private final List<ElementMatcher<? super W>> matchers;

            @SafeVarargs
            @SafeVarargsPlugin.Enhance
            public Conjunction(ElementMatcher<? super W>... elementMatcherArr) {
                this(Arrays.asList(elementMatcherArr));
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

            @Override // net.bytebuddy.matcher.ElementMatcher
            public boolean matches(@UnknownNull W w) {
                Iterator<ElementMatcher<? super W>> it = this.matchers.iterator();
                while (it.hasNext()) {
                    if (!it.next().matches(w)) {
                        return false;
                    }
                }
                return true;
            }

            public String toString() {
                StringBuilder sb = new StringBuilder("(");
                boolean z = true;
                for (ElementMatcher<? super W> elementMatcher : this.matchers) {
                    if (z) {
                        z = false;
                    } else {
                        sb.append(" and ");
                    }
                    sb.append(elementMatcher);
                }
                sb.append(")");
                return sb.toString();
            }

            public Conjunction(List<ElementMatcher<? super W>> list) {
                this.matchers = new ArrayList(list.size());
                for (ElementMatcher<? super W> elementMatcher : list) {
                    if (elementMatcher instanceof Conjunction) {
                        this.matchers.addAll(((Conjunction) elementMatcher).matchers);
                    } else {
                        this.matchers.add(elementMatcher);
                    }
                }
            }
        }

        /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
        @HashCodeAndEqualsPlugin.Enhance
        public static class Disjunction<W> extends AbstractBase<W> {
            private final List<ElementMatcher<? super W>> matchers;

            @SafeVarargs
            @SafeVarargsPlugin.Enhance
            public Disjunction(ElementMatcher<? super W>... elementMatcherArr) {
                this(Arrays.asList(elementMatcherArr));
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

            @Override // net.bytebuddy.matcher.ElementMatcher
            public boolean matches(@UnknownNull W w) {
                Iterator<ElementMatcher<? super W>> it = this.matchers.iterator();
                while (it.hasNext()) {
                    if (it.next().matches(w)) {
                        return true;
                    }
                }
                return false;
            }

            public String toString() {
                StringBuilder sb = new StringBuilder("(");
                boolean z = true;
                for (ElementMatcher<? super W> elementMatcher : this.matchers) {
                    if (z) {
                        z = false;
                    } else {
                        sb.append(" or ");
                    }
                    sb.append(elementMatcher);
                }
                sb.append(")");
                return sb.toString();
            }

            public Disjunction(List<ElementMatcher<? super W>> list) {
                this.matchers = new ArrayList(list.size());
                for (ElementMatcher<? super W> elementMatcher : list) {
                    if (elementMatcher instanceof Disjunction) {
                        this.matchers.addAll(((Disjunction) elementMatcher).matchers);
                    } else {
                        this.matchers.add(elementMatcher);
                    }
                }
            }
        }

        /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
        @HashCodeAndEqualsPlugin.Enhance
        public static abstract class ForNonNullValues<W> extends AbstractBase<W> {
            public abstract boolean doMatch(W w);

            public boolean equals(@MaybeNull Object obj) {
                if (this == obj) {
                    return true;
                }
                return obj != null && getClass() == obj.getClass();
            }

            public int hashCode() {
                return getClass().hashCode();
            }

            @Override // net.bytebuddy.matcher.ElementMatcher
            public boolean matches(@MaybeNull W w) {
                return w != null && doMatch(w);
            }
        }

        <U extends S> Junction<U> and(ElementMatcher<? super U> elementMatcher);

        <U extends S> Junction<U> or(ElementMatcher<? super U> elementMatcher);
    }

    boolean matches(@UnknownNull T t);
}

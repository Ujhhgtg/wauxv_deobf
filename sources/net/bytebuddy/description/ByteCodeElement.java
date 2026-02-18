package net.bytebuddy.description;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import net.bytebuddy.description.DeclaredByType;
import net.bytebuddy.description.ModifierReviewable;
import net.bytebuddy.description.NamedElement;
import net.bytebuddy.description.annotation.AnnotationSource;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.matcher.ElementMatcher;
import net.bytebuddy.matcher.FilterableList;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public interface ByteCodeElement extends NamedElement.WithRuntimeName, NamedElement.WithDescriptor, ModifierReviewable.OfByteCodeElement, DeclaredByType, AnnotationSource {

    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
    public interface Member extends DeclaredByType.WithMandatoryDeclaration, ByteCodeElement, NamedElement.WithGenericName {
    }

    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
    public interface Token<T extends Token<T>> {

        /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
        public static class TokenList<S extends Token<S>> extends FilterableList.AbstractBase<S, TokenList<S>> {
            private final List<? extends S> tokens;

            public TokenList(S... sArr) {
                this(Arrays.asList(sArr));
            }

            public TokenList<S> accept(TypeDescription.Generic.Visitor<? extends TypeDescription.Generic> visitor) {
                ArrayList arrayList = new ArrayList(this.tokens.size());
                Iterator<? extends S> it = this.tokens.iterator();
                while (it.hasNext()) {
                    arrayList.add(it.next().accept(visitor));
                }
                return new TokenList<>(arrayList);
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
            public int size() {
                return this.tokens.size();
            }

            public TokenList(List<? extends S> list) {
                this.tokens = list;
            }

            @Override // java.util.AbstractList, java.util.List
            public S get(int i) {
                return this.tokens.get(i);
            }

            @Override // net.bytebuddy.matcher.FilterableList.AbstractBase
            public TokenList<S> wrap(List<S> list) {
                return new TokenList<>(list);
            }
        }

        T accept(TypeDescription.Generic.Visitor<? extends TypeDescription.Generic> visitor);
    }

    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
    public interface TypeDependant<T extends TypeDependant<?, S>, S extends Token<S>> {
        T asDefined();

        S asToken(ElementMatcher<? super TypeDescription> elementMatcher);
    }

    boolean isAccessibleTo(TypeDescription typeDescription);

    boolean isVisibleTo(TypeDescription typeDescription);
}

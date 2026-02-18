package net.bytebuddy.description.modifier;

import java.util.Arrays;
import java.util.Collection;
import net.bytebuddy.build.HashCodeAndEqualsPlugin;
import net.bytebuddy.utility.nullability.MaybeNull;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public interface ModifierContributor {
    public static final int EMPTY_MASK = 0;

    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
    public interface ForField extends ModifierContributor {
        public static final int MASK = 151775;
    }

    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
    public interface ForMethod extends ModifierContributor {
        public static final int MASK = 7679;
    }

    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
    public interface ForModule extends ModifierContributor {
        public static final int MASK = 36896;

        /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
        public interface OfExport extends ModifierContributor {
            public static final int MASK = 36864;
        }

        /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
        public interface OfOpen extends ModifierContributor {
            public static final int MASK = 36864;
        }

        /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
        public interface OfRequire extends ModifierContributor {
            public static final int MASK = 36960;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
    public interface ForParameter extends ModifierContributor {
        public static final int MASK = 36880;
    }

    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
    public interface ForType extends ModifierContributor {
        public static final int MASK = 163391;
    }

    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
    @HashCodeAndEqualsPlugin.Enhance
    public static class Resolver<T extends ModifierContributor> {
        private final Collection<? extends T> modifierContributors;

        public Resolver(Collection<? extends T> collection) {
            this.modifierContributors = collection;
        }

        public static Resolver<ForType> of(ForType... forTypeArr) {
            return of(Arrays.asList(forTypeArr));
        }

        public boolean equals(@MaybeNull Object obj) {
            if (this == obj) {
                return true;
            }
            return obj != null && getClass() == obj.getClass() && this.modifierContributors.equals(((Resolver) obj).modifierContributors);
        }

        public int hashCode() {
            return this.modifierContributors.hashCode() + (getClass().hashCode() * 31);
        }

        public int resolve() {
            return resolve(0);
        }

        public static Resolver<ForModule> of(ForModule... forModuleArr) {
            return of(Arrays.asList(forModuleArr));
        }

        public int resolve(int i) {
            for (T t : this.modifierContributors) {
                i = (i & (~t.getRange())) | t.getMask();
            }
            return i;
        }

        public static Resolver<ForModule.OfRequire> of(ForModule.OfRequire... ofRequireArr) {
            return of(Arrays.asList(ofRequireArr));
        }

        public static Resolver<ForModule.OfExport> of(ForModule.OfExport... ofExportArr) {
            return of(Arrays.asList(ofExportArr));
        }

        public static Resolver<ForModule.OfOpen> of(ForModule.OfOpen... ofOpenArr) {
            return of(Arrays.asList(ofOpenArr));
        }

        public static Resolver<ForField> of(ForField... forFieldArr) {
            return of(Arrays.asList(forFieldArr));
        }

        public static Resolver<ForMethod> of(ForMethod... forMethodArr) {
            return of(Arrays.asList(forMethodArr));
        }

        public static Resolver<ForParameter> of(ForParameter... forParameterArr) {
            return of(Arrays.asList(forParameterArr));
        }

        public static <S extends ModifierContributor> Resolver<S> of(Collection<? extends S> collection) {
            return new Resolver<>(collection);
        }
    }

    int getMask();

    int getRange();

    boolean isDefault();
}

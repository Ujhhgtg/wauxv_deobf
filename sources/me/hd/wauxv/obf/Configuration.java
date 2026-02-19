package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class Configuration {
    public final Class declaringClass;
    public final Object memberInstance;
    public cbm processorResolver = null;
    public boolean superclass = false;
    public OptionalType optional = OptionalType.ENUM_NO;

    public Configuration(Class cls, Object obj) {
        this.declaringClass = cls;
        this.memberInstance = obj;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Configuration)) {
            return false;
        }
        Configuration configurationVar = (Configuration) obj;
        return nullSafeIsEqual(this.declaringClass, configurationVar.declaringClass) && nullSafeIsEqual(this.memberInstance, configurationVar.memberInstance)
                && nullSafeIsEqual(this.processorResolver, configurationVar.processorResolver) && this.superclass == configurationVar.superclass && this.optional == configurationVar.optional;
    }

    public final int hashCode() {
        int iHashCode = this.declaringClass.hashCode() * 31;
        Object obj = this.memberInstance;
        int iHashCode2 = (iHashCode + (obj == null ? 0 : obj.hashCode())) * 31;
        cbm cbmVar = this.processorResolver;
        return this.optional.hashCode()
                + ((Boolean.hashCode(this.superclass) + ((iHashCode2 + (cbmVar != null ? cbmVar.hashCode() : 0)) * 31)) * 31);
    }

    public final String toString() {
        return "Configuration(declaringClass=" + this.declaringClass + ", memberInstance=" + this.memberInstance + ", processorResolver=" + this.processorResolver
                + ", superclass=" + this.superclass + ", optional=" + this.optional + ")";
    }
}

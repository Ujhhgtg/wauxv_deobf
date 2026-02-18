package bsh;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public class ClassIdentifier {
    Class<?> clas;

    public ClassIdentifier(Class<?> cls) {
        this.clas = cls;
    }

    public Class<?> getTargetClass() {
        return this.clas;
    }

    public String toString() {
        return "Class Identifier: ".concat(this.clas.getName());
    }
}

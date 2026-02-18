package bsh;

import java.util.function.Function;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class b implements Function {
    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        return BSHType.getTypeDescriptor((Class) obj);
    }
}

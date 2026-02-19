package me.hd.wauxv.obf;

import java.lang.reflect.Field;
import java.lang.reflect.Member;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class azk extends InstanceResolver {
    public final Field a;

    public azk(Field field) {
        this.a = field;
    }

    @Override // me.hd.wauxv.obf.cbq
    public final Member getMember() {
        return this.a;
    }

    @Override // me.hd.wauxv.obf.bpu
    public final InstanceResolver copy(Object obj) {
        bindInstance(obj);
        return this;
    }

    public final Object d() {
        Field field = this.a;
        Field field2 = field != null ? field : null;
        if (field2 != null && !field2.isAccessible()) {
            field2.setAccessible(true);
        }
        return field.get(this.boundInstance);
    }

    public final Object e() throws IllegalAccessException {
        Field field = this.a;
        Field field2 = field != null ? field : null;
        if (field2 != null && !field2.isAccessible()) {
            field2.setAccessible(true);
        }
        Object obj = field.get(this.boundInstance);
        if (obj == null) {
            return null;
        }
        return obj;
    }

    public final void f(Object obj) throws IllegalAccessException {
        Field field = this.a;
        Field field2 = field != null ? field : null;
        if (field2 != null && !field2.isAccessible()) {
            field2.setAccessible(true);
        }
        field.set(this.boundInstance, obj);
    }
}

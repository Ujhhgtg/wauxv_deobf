package net.bytebuddy.utility;

import java.lang.reflect.Field;
import java.util.Comparator;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public enum FieldComparator implements Comparator<Field> {
    INSTANCE;

    @Override // java.util.Comparator
    public int compare(Field field, Field field2) {
        if (field == field2) {
            return 0;
        }
        int iCompareTo = field.getName().compareTo(field2.getName());
        return iCompareTo == 0 ? field.getType().getName().compareTo(field2.getType().getName()) : iCompareTo;
    }
}

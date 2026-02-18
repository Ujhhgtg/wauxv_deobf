package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public abstract class cyj {
    public static final ae f;

    static {
        Integer num = bqz.a;
        f = (num == null || num.intValue() >= 34) ? new ctv() : new aya();
    }

    public int _bi(int i) {
        int iB;
        int i2;
        if (i <= 0) {
            throw new IllegalArgumentException(("Random range is empty: [" + ((Object) 0) + ", " + Integer.valueOf(i) + ").").toString());
        }
        if (i > 0 || i == Integer.MIN_VALUE) {
            if (((-i) & i) == i) {
                return a(31 - Integer.numberOfLeadingZeros(i));
            }
            do {
                iB = b() >>> 1;
                i2 = iB % i;
            } while ((i - 1) + (iB - i2) < 0);
            return i2;
        }
        while (true) {
            int iB2 = b();
            if (iB2 >= 0 && iB2 < i) {
                return iB2;
            }
        }
    }

    public abstract int a(int i);

    public abstract int b();

    public abstract int c(int i);
}

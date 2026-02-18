package com.umeng.analytics.pro;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public class dv extends cn {
    public static final int a = 0;
    public static final int b = 1;
    public static final int c = 2;
    public static final int d = 3;
    public static final int e = 4;
    private static final long g = 1;
    protected int f;

    public dv() {
        this.f = 0;
    }

    public int a() {
        return this.f;
    }

    public dv(int i) {
        this.f = i;
    }

    public dv(int i, String str) {
        super(str);
        this.f = i;
    }

    public dv(String str) {
        super(str);
        this.f = 0;
    }

    public dv(int i, Throwable th) {
        super(th);
        this.f = i;
    }

    public dv(Throwable th) {
        super(th);
        this.f = 0;
    }

    public dv(String str, Throwable th) {
        super(str, th);
        this.f = 0;
    }

    public dv(int i, String str, Throwable th) {
        super(str, th);
        this.f = i;
    }
}

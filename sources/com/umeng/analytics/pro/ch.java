package com.umeng.analytics.pro;

import com.umeng.analytics.pro.ch;
import com.umeng.analytics.pro.co;
import java.io.Serializable;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public interface ch<T extends ch<?, ?>, F extends co> extends Serializable {
    void clear();

    ch<T, F> deepCopy();

    F fieldForId(int i);

    void read(dg dgVar);

    void write(dg dgVar);
}

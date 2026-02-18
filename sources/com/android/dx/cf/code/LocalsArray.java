package com.android.dx.cf.code;

import com.android.dx.rop.code.RegisterSpec;
import com.android.dx.rop.type.Type;
import com.android.dx.rop.type.TypeBearer;
import com.android.dx.util.MutabilityControl;
import com.android.dx.util.ToHuman;
import me.hd.wauxv.obf.axc;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public abstract class LocalsArray extends MutabilityControl implements ToHuman {
    public LocalsArray(boolean z) {
        super(z);
    }

    public abstract void annotate(axc axcVar);

    public abstract LocalsArray copy();

    public abstract TypeBearer get(int i);

    public abstract TypeBearer getCategory1(int i);

    public abstract TypeBearer getCategory2(int i);

    public abstract int getMaxLocals();

    public abstract TypeBearer getOrNull(int i);

    public abstract OneLocalsArray getPrimary();

    public abstract void invalidate(int i);

    public abstract void makeInitialized(Type type);

    public abstract LocalsArray merge(LocalsArray localsArray);

    public abstract LocalsArraySet mergeWithSubroutineCaller(LocalsArray localsArray, int i);

    public abstract void set(int i, TypeBearer typeBearer);

    public abstract void set(RegisterSpec registerSpec);
}

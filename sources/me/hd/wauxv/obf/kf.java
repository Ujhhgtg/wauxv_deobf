package me.hd.wauxv.obf;

import de.robv.android.xposed.XposedBridge;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class kf extends nh {
    public final HookPriorityEnum a;
    public final /* synthetic */ int b;

    /* JADX WARN: Illegal instructions before constructor call */
    public kf(int i) {
        this.b = i;
        HookPriorityEnum hookPriorityEnumVar = HookPriorityEnum.ENUM_DEFAULT;
        super(hookPriorityEnumVar);
        this.a = hookPriorityEnumVar;
    }

    @Override // me.hd.wauxv.obf.nh
    public final void c(blq blqVar) {
    }

    @Override // me.hd.wauxv.obf.nh
    public final void d(blq blqVar) {
        ((bmi) blqVar.d).g(f(blqVar), Boolean.TRUE);
    }

    @Override // me.hd.wauxv.obf.nh
    public final HookPriorityEnum e() {
        return this.a;
    }

    public final Object f(blq blqVar) {
        int i;
        Object objX;
        switch (this.b) {
            case 0:
                int iOrdinal = bhs.r().ordinal();
                if (iOrdinal == 0) {
                    i = 0;
                } else {
                    if (iOrdinal != 1) {
                        throw new QueryDidNotReturnUniqueResultRuntimeException();
                    }
                    i = -1;
                }
                return Integer.valueOf(i);
            case 1:
                return Boolean.TRUE;
            case 2:
                return Boolean.TRUE;
            case 3:
                return bhs.s();
            case 4:
                int iOrdinal2 = bhs.r().ordinal();
                int iIntValue = -1;
                if (iOrdinal2 == 0) {
                    try {
                        objX = Integer.valueOf(XposedBridge.getXposedVersion());
                    } catch (Throwable th) {
                        objX = FastKV.x(th);
                    }
                    if (objX instanceof dcx) {
                        objX = null;
                    }
                    Integer num = (Integer) objX;
                    if (num != null) {
                        iIntValue = num.intValue();
                    }
                    break;
                } else if (iOrdinal2 != 1) {
                    throw new QueryDidNotReturnUniqueResultRuntimeException();
                }
                return Integer.valueOf(iIntValue);
            default:
                int iOrdinal3 = bhs.r().ordinal();
                if (iOrdinal3 == 0) {
                    return "unsupported";
                }
                if (iOrdinal3 == 1) {
                    return "unknown";
                }
                throw new QueryDidNotReturnUniqueResultRuntimeException();
        }
    }
}

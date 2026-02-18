package me.hd.wauxv.obf;

import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class mg extends LinkedHashMap {
    public final /* synthetic */ int a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ mg(int i, float f, boolean z, int i2) {
        super(i, f, z);
        this.a = i2;
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ boolean containsKey(Object obj) {
        switch (this.a) {
            case 0:
                if (obj instanceof Long) {
                    return super.containsKey((Long) obj);
                }
                return false;
            case 1:
                if (obj instanceof csm) {
                    return super.containsKey((csm) obj);
                }
                return false;
            default:
                if (obj instanceof csm) {
                    return super.containsKey((csm) obj);
                }
                return false;
        }
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ boolean containsValue(Object obj) {
        switch (this.a) {
            case 0:
                if (obj instanceof Boolean) {
                    return super.containsValue((Boolean) obj);
                }
                return false;
            case 1:
                if (obj instanceof Boolean) {
                    return super.containsValue((Boolean) obj);
                }
                return false;
            default:
                if (obj instanceof Boolean) {
                    return super.containsValue((Boolean) obj);
                }
                return false;
        }
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ Object get(Object obj) {
        switch (this.a) {
            case 0:
                if (obj instanceof Long) {
                    return (Boolean) super.get((Long) obj);
                }
                return null;
            case 1:
                if (obj instanceof csm) {
                    return (Boolean) super.get((csm) obj);
                }
                return null;
            default:
                if (obj instanceof csm) {
                    return (Boolean) super.get((csm) obj);
                }
                return null;
        }
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.Map
    public final /* bridge */ Object getOrDefault(Object obj, Object obj2) {
        switch (this.a) {
            case 0:
                return !(obj instanceof Long) ? obj2 : (Boolean) super.getOrDefault((Long) obj, (Boolean) obj2);
            case 1:
                return !(obj instanceof csm) ? obj2 : (Boolean) super.getOrDefault((csm) obj, (Boolean) obj2);
            default:
                return !(obj instanceof csm) ? obj2 : (Boolean) super.getOrDefault((csm) obj, (Boolean) obj2);
        }
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ Object remove(Object obj) {
        switch (this.a) {
            case 0:
                if (obj instanceof Long) {
                    return (Boolean) super.remove((Long) obj);
                }
                return null;
            case 1:
                if (obj instanceof csm) {
                    return (Boolean) super.remove((csm) obj);
                }
                return null;
            default:
                if (obj instanceof csm) {
                    return (Boolean) super.remove((csm) obj);
                }
                return null;
        }
    }

    @Override // java.util.LinkedHashMap
    public final boolean removeEldestEntry(Map.Entry entry) {
        switch (this.a) {
            case 0:
                return super.size() > 100;
            case 1:
                return super.size() > 100;
            default:
                return super.size() > 100;
        }
    }

    @Override // java.util.HashMap, java.util.Map
    public final /* bridge */ boolean remove(Object obj, Object obj2) {
        switch (this.a) {
            case 0:
                if ((obj instanceof Long) && (obj2 instanceof Boolean)) {
                    return super.remove((Long) obj, (Boolean) obj2);
                }
                return false;
            case 1:
                if ((obj instanceof csm) && (obj2 instanceof Boolean)) {
                    return super.remove((csm) obj, (Boolean) obj2);
                }
                return false;
            default:
                if ((obj instanceof csm) && (obj2 instanceof Boolean)) {
                    return super.remove((csm) obj, (Boolean) obj2);
                }
                return false;
        }
    }
}

package me.hd.wauxv.obf;

import android.graphics.Bitmap;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;
import net.bytebuddy.pool.TypePool;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class dib {
    public static final Bitmap.Config[] a;
    public static final Bitmap.Config[] b;
    public static final Bitmap.Config[] c;
    public static final Bitmap.Config[] d;
    public static final Bitmap.Config[] e;
    public final byf f = new byf(1);
    public final io g = new io(24);
    public final HashMap h = new HashMap();

    static {
        Bitmap.Config[] configArr = (Bitmap.Config[]) Arrays.copyOf(new Bitmap.Config[]{Bitmap.Config.ARGB_8888, null}, 3);
        configArr[configArr.length - 1] = Bitmap.Config.RGBA_F16;
        a = configArr;
        b = configArr;
        c = new Bitmap.Config[]{Bitmap.Config.RGB_565};
        d = new Bitmap.Config[]{Bitmap.Config.ARGB_4444};
        e = new Bitmap.Config[]{Bitmap.Config.ALPHA_8};
    }

    public static String i(int i, Bitmap.Config config) {
        return "[" + i + "](" + config + ")";
    }

    public final void j(Integer num, Bitmap bitmap) {
        NavigableMap navigableMapL = l(bitmap.getConfig());
        Integer num2 = (Integer) navigableMapL.get(num);
        if (num2 != null) {
            if (num2.intValue() == 1) {
                navigableMapL.remove(num);
                return;
            } else {
                navigableMapL.put(num, Integer.valueOf(num2.intValue() - 1));
                return;
            }
        }
        throw new NullPointerException("Tried to decrement empty size, size: " + num + ", removed: " + i(eot.f(bitmap), bitmap.getConfig()) + ", this: " + this);
    }

    public final Bitmap k(int i, int i2, Bitmap.Config config) {
        Bitmap.Config[] configArr;
        int iG = eot.g(config) * i * i2;
        byf byfVar = this.f;
        cut cutVarB = (cut) ((ArrayDeque) byfVar.g).poll();
        if (cutVarB == null) {
            cutVarB = byfVar.b();
        }
        dia diaVar = (dia) cutVarB;
        diaVar.b = iG;
        diaVar.c = config;
        if (Bitmap.Config.RGBA_F16.equals(config)) {
            configArr = b;
        } else {
            int i3 = dhz.a[config.ordinal()];
            configArr = i3 != 1 ? i3 != 2 ? i3 != 3 ? i3 != 4 ? new Bitmap.Config[]{config} : e : d : c : a;
        }
        for (Bitmap.Config config2 : configArr) {
            Integer num = (Integer) l(config2).ceilingKey(Integer.valueOf(iG));
            if (num != null && num.intValue() <= iG * 8) {
                if (num.intValue() == iG && (config2 != null ? config2.equals(config) : config == null)) {
                    break;
                    break;
                }
                byfVar.i(diaVar);
                int iIntValue = num.intValue();
                cut cutVarB2 = (cut) ((ArrayDeque) byfVar.g).poll();
                if (cutVarB2 == null) {
                    cutVarB2 = byfVar.b();
                }
                diaVar = (dia) cutVarB2;
                diaVar.b = iIntValue;
                diaVar.c = config2;
                break;
            }
        }
        Bitmap bitmap = (Bitmap) this.g.ag(diaVar);
        if (bitmap != null) {
            j(Integer.valueOf(diaVar.b), bitmap);
            bitmap.reconfigure(i, i2, config);
        }
        return bitmap;
    }

    public final NavigableMap l(Bitmap.Config config) {
        HashMap map = this.h;
        NavigableMap navigableMap = (NavigableMap) map.get(config);
        if (navigableMap != null) {
            return navigableMap;
        }
        TreeMap treeMap = new TreeMap();
        map.put(config, treeMap);
        return treeMap;
    }

    public final void m(Bitmap bitmap) {
        int iF = eot.f(bitmap);
        Bitmap.Config config = bitmap.getConfig();
        byf byfVar = this.f;
        cut cutVarB = (cut) ((ArrayDeque) byfVar.g).poll();
        if (cutVarB == null) {
            cutVarB = byfVar.b();
        }
        dia diaVar = (dia) cutVarB;
        diaVar.b = iF;
        diaVar.c = config;
        this.g.as(diaVar, bitmap);
        NavigableMap navigableMapL = l(bitmap.getConfig());
        Integer num = (Integer) navigableMapL.get(Integer.valueOf(diaVar.b));
        navigableMapL.put(Integer.valueOf(diaVar.b), Integer.valueOf(num != null ? 1 + num.intValue() : 1));
    }

    public final String toString() {
        StringBuilder sbY = dkz.y("SizeConfigStrategy{groupedMap=");
        sbY.append(this.g);
        sbY.append(", sortedSizes=(");
        HashMap map = this.h;
        for (Map.Entry entry : map.entrySet()) {
            sbY.append(entry.getKey());
            sbY.append(TypePool.Default.LazyTypeDescription.GenericTypeToken.COMPONENT_TYPE_PATH);
            sbY.append(entry.getValue());
            sbY.append("], ");
        }
        if (!map.isEmpty()) {
            sbY.replace(sbY.length() - 2, sbY.length(), "");
        }
        sbY.append(")}");
        return sbY.toString();
    }
}

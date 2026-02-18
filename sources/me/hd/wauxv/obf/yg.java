package me.hd.wauxv.obf;

import android.database.Cursor;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.fastjson2.JSONReader;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public abstract /* synthetic */ class yg {
    public static float a(float f, float f2, float f3, float f4) {
        return ((f - f2) * f3) + f4;
    }

    public static int b(int i, int i2, int i3, int i4) {
        return ((i - i2) * i3) + i4;
    }

    public static int c(Map map, int i, int i2) {
        return (map.hashCode() + i) * i2;
    }

    public static ClassCastException d(Iterator it) {
        it.next().getClass();
        return new ClassCastException();
    }

    public static Object e(azg azgVar) {
        azgVar.ah();
        return aaz.e(azgVar.c());
    }

    public static String f(int i, String str, String str2) {
        return str + i + str2;
    }

    public static String g(long j, Cursor cursor) {
        return cursor.getString(cursor.getColumnIndex(cnb.z(j)));
    }

    public static String h(long j, StringBuilder sb) {
        sb.append(cnb.z(j));
        return sb.toString();
    }

    public static String i(RecyclerView recyclerView, StringBuilder sb) {
        sb.append(recyclerView.dm());
        return sb.toString();
    }

    public static String j(String str, int i, int i2) {
        return str.substring(i2, str.length() - i);
    }

    public static String k(String str, String str2) {
        return str + str2;
    }

    public static String l(String str, bdj bdjVar, String str2) {
        return str + bdjVar + str2;
    }

    public static String m(StringBuilder sb, String str, int i) {
        sb.append(i);
        sb.append(str);
        return sb.toString();
    }

    public static String n(StringBuilder sb, String str, long j) {
        sb.append(str);
        sb.append(cnb.z(j));
        return sb.toString();
    }

    public static String o(StringBuilder sb, String str, String str2) {
        sb.append(str);
        sb.append(str2);
        return sb.toString();
    }

    public static String p(StringBuilder sb, String str, String str2, JSONReader jSONReader) {
        sb.append(str);
        sb.append(str2);
        return jSONReader.info(sb.toString());
    }

    public static StringBuilder q(int i, int i2, String str, String str2, String str3) {
        StringBuilder sb = new StringBuilder(str);
        sb.append(i);
        sb.append(str2);
        sb.append(i2);
        sb.append(str3);
        return sb;
    }

    public static StringBuilder r(int i, String str, String str2) {
        StringBuilder sb = new StringBuilder(str);
        sb.append(i);
        sb.append(str2);
        return sb;
    }

    public static bmu s(long j) {
        return dqc.bh(ajn.ag(cnb.z(j)));
    }

    public static /* synthetic */ void t(Object obj) {
        if (obj != null) {
            throw new ClassCastException();
        }
    }

    public static void u(StringBuilder sb, String str, long j) {
        sb.append(str);
        sb.append(cnb.z(j));
    }

    public static void v(StringBuilder sb, List list, long j) {
        sb.append(list);
        sb.append(cnb.z(j));
    }

    public static /* synthetic */ String w(int i) {
        switch (i) {
            case 1:
                return "NONE";
            case 2:
                return "LEFT";
            case 3:
                return "TOP";
            case 4:
                return "RIGHT";
            case 5:
                return "BOTTOM";
            case 6:
                return "BASELINE";
            case 7:
                return "CENTER";
            case 8:
                return "CENTER_X";
            case 9:
                return "CENTER_Y";
            default:
                throw null;
        }
    }

    public static /* synthetic */ String x(int i) {
        return i != 1 ? i != 2 ? i != 3 ? i != 4 ? i != 5 ? "null" : "MEMORY_CACHE" : "RESOURCE_DISK_CACHE" : "DATA_DISK_CACHE" : "REMOTE" : "LOCAL";
    }

    public static /* synthetic */ String y(int i) {
        switch (i) {
            case 1:
                return "INITIALIZE";
            case 2:
                return "RESOURCE_CACHE";
            case 3:
                return "DATA_CACHE";
            case 4:
                return "SOURCE";
            case 5:
                return "ENCODE";
            case 6:
                return "FINISHED";
            default:
                return "null";
        }
    }
}

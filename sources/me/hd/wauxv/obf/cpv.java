package me.hd.wauxv.obf;

import bsh.Reflect;
import bsh.StringUtil;
import com.alibaba.fastjson2.reader.ObjectReaderImplList;
import com.alibaba.fastjson2.reader.ObjectReaderImplListStr;
import com.alibaba.fastjson2.reader.ObjectReaderImplMap;
import com.alibaba.fastjson2.util.TypeUtils;
import com.alibaba.fastjson2.writer.ObjectWriterBaseModule;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.NavigableMap;
import java.util.SortedMap;
import java.util.function.Function;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class cpv implements Function {
    public final /* synthetic */ int a;

    public /* synthetic */ cpv(int i) {
        this.a = i;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        switch (this.a) {
            case 0:
                return ObjectReaderImplList.lambda$of$4(obj);
            case 1:
                return ObjectReaderImplList.lambda$of$5(obj);
            case 2:
                return ObjectReaderImplListStr.lambda$readJSONBObject$0((Collection) obj);
            case 3:
                return ObjectReaderImplListStr.lambda$readJSONBObject$1((Collection) obj);
            case 4:
                return Collections.synchronizedMap((Map) obj);
            case 5:
                return Collections.synchronizedNavigableMap((NavigableMap) obj);
            case 6:
                return Collections.synchronizedSortedMap((SortedMap) obj);
            case 7:
                return Collections.unmodifiableMap((Map) obj);
            case 8:
                return Collections.unmodifiableSortedMap((SortedMap) obj);
            case 9:
                return Collections.unmodifiableNavigableMap((NavigableMap) obj);
            case 10:
                return ObjectReaderImplMap.lambda$of$1((Map) obj);
            case 11:
                return ObjectReaderImplMap.lambda$static$0(obj);
            case 12:
                return ObjectWriterBaseModule.lambda$getObjectWriter$0(obj);
            case 13:
                return ((Method) obj).getParameterTypes();
            case 14:
                return ((Field) obj).getDeclaringClass();
            case 15:
                return ((Field) obj).getName();
            case 16:
                return ((ParameterizedType) obj).getActualTypeArguments();
            case 17:
                return ((ParameterizedType) obj).getOwnerType();
            case 18:
                return ((ParameterizedType) obj).getRawType();
            case 19:
                return ((StackTraceElement) obj).getFileName();
            case 20:
                return ((StackTraceElement) obj).getClassName();
            case 21:
                return ((StackTraceElement) obj).getMethodName();
            case 22:
                return ((Method) obj).getDeclaringClass();
            case 23:
                return ((Method) obj).getName();
            case 24:
                return obj.toString();
            case 25:
                return Reflect.lambda$getEnumConstants$7((Field) obj);
            case 26:
                return StringUtil.getTypeName((Class) obj);
            default:
                return TypeUtils.toAsciiCharArray((byte[]) obj);
        }
    }
}

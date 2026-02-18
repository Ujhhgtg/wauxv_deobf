package me.hd.wauxv.obf;

import bsh.BshMethod;
import bsh.Invocable;
import bsh.StringUtil;
import bsh.Variable;
import bsh.classpath.BshClassPath;
import com.alibaba.fastjson2.JSONObject;
import com.alibaba.fastjson2.JSONPath;
import com.alibaba.fastjson2.reader.ObjectReaderBaseModule;
import com.alibaba.fastjson2.schema.JSONSchema;
import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.URI;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.file.Path;
import java.text.SimpleDateFormat;
import java.time.Period;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicIntegerArray;
import java.util.concurrent.atomic.AtomicLongArray;
import java.util.function.Function;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ky implements Function {
    public final /* synthetic */ int a;

    public /* synthetic */ ky(int i) {
        this.a = i;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        switch (this.a) {
            case 0:
                return JSONSchema.of((JSONObject) obj);
            case 1:
                return ((Path) obj).toString();
            case 2:
                return BshClassPath.canonicalizeClassName((String) obj);
            case 3:
                return BshMethod.lambda$getParameterNames$0((Integer) obj);
            case 4:
                return StringUtil.variableString((Variable) obj);
            case 5:
                return "    ".concat((String) obj);
            case 6:
                return StringUtil.methodString((BshMethod) obj);
            case 7:
                return StringUtil.variableString((Field) obj);
            case 8:
                return StringUtil.methodString((Method) obj);
            case 9:
                return Character.toChars(((Integer) obj).intValue());
            case 10:
                return String.valueOf((char[]) obj);
            case 11:
                return new chr(0);
            case 12:
                return Invocable.lambda$hashCode$1((Class) obj);
            case 13:
                return JSONPath.lambda$of$0((JSONPath) obj);
            case 14:
                return ((List) obj).stream();
            case 15:
                return new AtomicIntegerArray((int[]) obj);
            case 16:
                return new AtomicLongArray((long[]) obj);
            case 17:
                return ObjectReaderBaseModule.lambda$getObjectReader$10((String) obj);
            case 18:
                return Period.parse((String) obj);
            case 19:
                return new SimpleDateFormat((String) obj);
            case 20:
                return ByteBuffer.wrap((byte[]) obj);
            case 21:
                return new AtomicBoolean(((Boolean) obj).booleanValue());
            case 22:
                return URI.create((String) obj);
            case 23:
                return Charset.forName((String) obj);
            case 24:
                return new File((String) obj);
            case 25:
                return ObjectReaderBaseModule.lambda$getObjectReader$8((String) obj);
            case 26:
                return ObjectReaderBaseModule.lambda$getObjectReader$9((String) obj);
            case 27:
                return Pattern.compile((String) obj);
            case 28:
                return ObjectReaderBaseModule.lambda$init$0(obj);
            default:
                return ObjectReaderBaseModule.lambda$init$1(obj);
        }
    }
}

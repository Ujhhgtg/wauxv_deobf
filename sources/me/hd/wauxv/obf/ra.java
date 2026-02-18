package me.hd.wauxv.obf;

import bsh.ClassGeneratorUtil;
import bsh.Invocable;
import bsh.Reflect;
import bsh.Variable;
import bsh.classpath.BshClassPath;
import com.alibaba.fastjson2.schema.StringSchema;
import com.alibaba.fastjson2.util.DateUtils;
import com.alibaba.fastjson2.util.TypeUtils;
import com.alibaba.fastjson2.writer.FieldWriter;
import java.lang.reflect.Method;
import java.util.Objects;
import java.util.function.Predicate;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ra implements Predicate {
    public final /* synthetic */ int a;

    public /* synthetic */ ra(int i) {
        this.a = i;
    }

    @Override // java.util.function.Predicate
    public final boolean test(Object obj) {
        switch (this.a) {
            case 0:
                return ((Invocable) obj).isStatic();
            case 1:
                return BshClassPath.isClassFileName((String) obj);
            case 2:
                return Reflect.isGeneratedClass((Class) obj);
            case 3:
                return ClassGeneratorUtil.lambda$checkAbstractMethodImplementation$0((Method) obj);
            case 4:
                return Objects.nonNull((FieldWriter) obj);
            case 5:
                return Objects.nonNull((Variable) obj);
            case 6:
                return Objects.nonNull(obj);
            case 7:
                return Reflect.lambda$getVariableNames$2((String) obj);
            case 8:
                return Reflect.lambda$static$0((String) obj);
            case 9:
                return StringSchema.isEmail((String) obj);
            case 10:
                return TypeUtils.validateIPv4((String) obj);
            case 11:
                return TypeUtils.validateIPv6((String) obj);
            case 12:
                return StringSchema.lambda$new$0((String) obj);
            case 13:
                return DateUtils.isDate((String) obj);
            case 14:
                return DateUtils.isLocalDate((String) obj);
            case 15:
                return DateUtils.isLocalTime((String) obj);
            case 16:
                return StringSchema.lambda$new$1((String) obj);
            default:
                return TypeUtils.isUUID((String) obj);
        }
    }
}

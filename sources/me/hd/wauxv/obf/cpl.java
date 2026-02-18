package me.hd.wauxv.obf;

import com.alibaba.fastjson2.reader.ObjectReaderBaseModule;
import com.alibaba.fastjson2.reader.ObjectReaderCreatorASM;
import com.alibaba.fastjson2.reader.ObjectReaderImplList;
import java.time.Duration;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.NavigableSet;
import java.util.Set;
import java.util.SortedSet;
import java.util.TimeZone;
import java.util.function.Function;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class cpl implements Function {
    public final /* synthetic */ int a;

    public /* synthetic */ cpl(int i) {
        this.a = i;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        switch (this.a) {
            case 0:
                return ObjectReaderBaseModule.lambda$init$2(obj);
            case 1:
                return ObjectReaderBaseModule.lambda$init$3(obj);
            case 2:
                return Duration.parse((String) obj);
            case 3:
                return ZoneOffset.of((String) obj);
            case 4:
                return ZoneId.of((String) obj);
            case 5:
                return TimeZone.getTimeZone((String) obj);
            case 6:
                return ((List) obj).stream();
            case 7:
                return ObjectReaderCreatorASM.lambda$genMethodReadJSONBObject$4((Integer) obj);
            case 8:
                return ObjectReaderCreatorASM.lambda$genMethodGetFieldReader$2((Integer) obj);
            case 9:
                return ObjectReaderCreatorASM.lambda$genMethodGetFieldReaderLCase$3((Integer) obj);
            case 10:
                return ObjectReaderCreatorASM.lambda$genMethodReadObject$5((Integer) obj);
            case 11:
                return ObjectReaderImplList.lambda$of$6(obj);
            case 12:
                return ObjectReaderImplList.lambda$of$7(obj);
            case 13:
                return ObjectReaderImplList.lambda$of$8(obj);
            case 14:
                return Collections.synchronizedList((List) obj);
            case 15:
                return Collections.unmodifiableCollection((Collection) obj);
            case 16:
                return Collections.unmodifiableList((List) obj);
            case 17:
                return Collections.unmodifiableSet((Set) obj);
            case 18:
                return Collections.unmodifiableSortedSet((SortedSet) obj);
            case 19:
                return Collections.unmodifiableNavigableSet((NavigableSet) obj);
            case 20:
                return ObjectReaderImplList.lambda$readJSONBObject$9((Collection) obj);
            case 21:
                return Collections.synchronizedCollection((Collection) obj);
            case 22:
                return ObjectReaderImplList.lambda$readJSONBObject$10((List) obj);
            case 23:
                return ObjectReaderImplList.lambda$readJSONBObject$11((Collection) obj);
            case 24:
                return Collections.synchronizedSet((Set) obj);
            case 25:
                return Collections.synchronizedSortedSet((SortedSet) obj);
            case 26:
                return Collections.synchronizedNavigableSet((NavigableSet) obj);
            case 27:
                return ObjectReaderImplList.lambda$of$1(obj);
            case 28:
                return ObjectReaderImplList.lambda$of$2(obj);
            default:
                return ObjectReaderImplList.lambda$of$3(obj);
        }
    }
}

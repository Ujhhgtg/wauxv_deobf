package me.hd.wauxv.obf;

import java.io.File;
import java.io.FileOutputStream;
import java.lang.reflect.Executable;
import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import me.hd.wauxv.data.bean.MsgInfoBean;
import net.bytebuddy.jar.asm.signature.SignatureVisitor;
import net.bytebuddy.pool.TypePool;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class fq implements bgj {
    public final /* synthetic */ int a;

    public /* synthetic */ fq(int i) {
        this.a = i;
    }

    /*
     * JADX WARN: Undo finally extract visitor
     * java.lang.NullPointerException
     * at java.base/java.util.Objects.requireNonNull(Objects.java:209)
     * at java.base/java.util.ArrayList.batchRemove(ArrayList.java:816)
     * at java.base/java.util.ArrayList.removeAll(ArrayList.java:791)
     * at jadx.core.dex.visitors.finaly.TryCatchEdgeBlockMap.getAllInScope(
     * TryCatchEdgeBlockMap.java:91)
     * at jadx.core.dex.visitors.finaly.MarkFinallyVisitor.getTryBlockData(
     * MarkFinallyVisitor.java:204)
     * at jadx.core.dex.visitors.finaly.MarkFinallyVisitor.visit(MarkFinallyVisitor.
     * java:119)
     */
    @Override // me.hd.wauxv.obf.bgj
    public final Object g(Object obj, Object obj2) {
        abj abjVar;
        Object objX;
        Object objX2;
        Object objX3;
        Object objX4;
        Object objX5;
        Object objX6;
        int modifiers;
        ArrayList arrayList;
        Iterator it;
        switch (this.a) {
            case 0:
                List list = (List) obj;
                fr frVar = fr.a;
                ArrayList arrayList2 = new ArrayList(StaticHelpers4.ak(list, 10));
                Iterator it2 = list.iterator();
                while (it2.hasNext()) {
                    arrayList2.add(((adx) it2.next()).a);
                }
                frVar.t(StaticHelpers5.ad(arrayList2));
                dnc.sendToast(null, 3, "已屏蔽" /* "已屏蔽" /* "已屏蔽" /* cnb.z(-491026431081258L)  */);
                return Boolean.FALSE;
            case 1:
                String str = (String) obj;
                ahf ahfVar = (ahf) obj2;
                throwIfVar1IsNull(str, "acc");
                throwIfVar1IsNull(ahfVar, "element");
                if (str.length() == 0) {
                    return ahfVar.toString();
                }
                return str + ", " + ahfVar;
            case 2:
                return Boolean.FALSE;
            case 3:
                ahh ahhVar = (ahh) obj;
                ahf ahfVar2 = (ahf) obj2;
                throwIfVar1IsNull(ahhVar, "acc");
                throwIfVar1IsNull(ahfVar2, "element");
                ahh ahhVar_t = ahhVar._t(ahfVar2.getKey());
                EmptyCoroutineContext emptyCoroutineContextVar = EmptyCoroutineContext.INSTANCE;
                if (ahhVar_t == emptyCoroutineContextVar) {
                    return ahfVar2;
                }
                arj arjVar = arj.a;
                afy afyVar = (afy) ahhVar_t._w(arjVar);
                if (afyVar == null) {
                    abjVar = new abj(ahfVar2, ahhVar_t);
                } else {
                    ahh ahhVar_t2 = ahhVar_t._t(arjVar);
                    if (ahhVar_t2 == emptyCoroutineContextVar) {
                        return new abj(afyVar, ahfVar2);
                    }
                    abjVar = new abj(afyVar, new abj(ahfVar2, ahhVar_t2));
                }
                return abjVar;
            case 4:
                return ((ahh) obj)._v((ahf) obj2);
            case 5:
                return ((ahh) obj)._v((ahf) obj2);
            case 6:
                Boolean bool = (Boolean) obj;
                bool.booleanValue();
                return bool;
            case 7:
                MsgInfoBean msgInfoBean = (MsgInfoBean) obj2;
                Kotlin$Unit kotlinUnitVar = Kotlin$Unit.INSTANCE;
                long msgId = msgInfoBean.getMsgId();
                String imgPath = msgInfoBean.getImgPath();
                throwIfVar1IsNull(imgPath);
                EmojiInfoStorageDexFind.a.getClass();
                Object objB = EmojiInfoStorageDexFind.getEmojiInfoByMd5(imgPath);
                atp.a.getClass();
                int i = 0;
                MethodResolver methodResolverVarT = dqc.bh(StaticHelpers7.toDexClass(ato.a)).getMethodResolverBasedOnPreviouslyProvidedConfig();
                methodResolverVarT.addAccessModifiers(AccessModifierEnum.STATIC);
                Object objE = ((MethodHookWrapper) bjs.resolveFirstMethodWithoutParams(methodResolverVarT)).invokeAndThrowIfFailed(new Object[0]);
                throwIfVar1IsNull(objE);
                MethodResolver methodResolverVarT2 = dqc.getWrapperConfiguration(objE).getMethodResolverBasedOnPreviouslyProvidedConfig();
                methodResolverVarT2.returnType = dal.getKClassFromClass(byte[].class);
                Object objJ = ((MethodHookWrapper) StaticHelpers6
                        .setParamsBasedOnVar1Var2AndResolveFirstMethod(new Object[] { "com.tencent.mm.api.IEmojiInfo" /* "com.tencent.mm.api.IEmojiInfo" /* "com.tencent.mm.api.IEmojiInfo" /* cnb.z(-90430536416042L)  */ }, 1, methodResolverVarT2))
                        .invoke(objB);
                throwIfVar1IsNull(objJ);
                byte[] bArr = (byte[]) objJ;
                try {
                    File file = new File(aum.a.o());
                    file.mkdirs();
                    StringBuilder sb = new StringBuilder();
                    sb.append(msgId);
                    sb.append(SignatureVisitor.SUPER);
                    sb.append(imgPath);
                    sb.append(SignatureVisitor.SUPER);
                    sb.append(System.currentTimeMillis());
                    sb.append(TypePool.Default.LazyTypeDescription.GenericTypeToken.INNER_CLASS_PATH);
                    sb.append(
                            cna.ac(bArr) ? "gif" /* "gif" /* "gif" /* cnb.z(-519106927262506L)  */ : "png" /* "png" /* "png" /* cnb.z(-519055387654954L)  */);
                    String string = sb.toString();
                    File file2 = new File(file, string);
                    if (cna.ac(bArr)) {
                        MethodResolver methodResolverVarT3 = dqc.bh(ajn.tryGetClassByClassName("com.tencent.mm.plugin.gif.MMWXGFJNI" /*
                                                                                            * "com.tencent.mm.plugin.gif.MMWXGFJNI" /* "com.tencent.mm.plugin.gif.MMWXGFJNI" /* cnb.z(-119803817753386L)  */
                                                                                            */)).getMethodResolverBasedOnPreviouslyProvidedConfig();
                        methodResolverVarT3.name = "nativeWxamToGif" /* "nativeWxamToGif" /* "nativeWxamToGif" /* cnb.z(-119614839192362L)  */;
                        Object objJ2 = ((MethodHookWrapper) StaticHelpers5.safeGetFirstInList(methodResolverVarT3.findMethods())).invoke(bArr);
                        throwIfVar1IsNull(objJ2);
                        bArr = (byte[]) objJ2;
                    }
                    FileOutputStream fileOutputStream = new FileOutputStream(file2);
                    try {
                        fileOutputStream.write(bArr);
                        fileOutputStream.close();
                        dnc.sendToast(null, 3, "已保存到: " /* "已保存到: " /* "已保存到: " /* cnb.z(-519072567524138L)  */ + file.getAbsolutePath() + '/' + string);
                        objX = kotlinUnitVar;
                    } catch (Throwable th) {
                        try {
                            throw th;
                        } catch (Throwable th2) {
                            cnh.m(fileOutputStream, th);
                            throw th2;
                        }
                    }
                } catch (Throwable th3) {
                    objX = FastKV.getFailureFromException(th3);
                }
                Throwable thB = Success.exceptionOrNull(objX);
                if (thB != null) {
                    String strZ = "保存失败: " /* "保存失败: " /* "保存失败: " /* cnb.z(-519025322883882L)  */;
                    String message = thB.getMessage();
                    dnc.sendToast(null, 3, strZ.concat(message != null ? StringsKt.az(50, message) : "未知错误" /*
                                                                                               * cnb.z(-
                                                                                               * 518995258112810L)
                                                                                               */));
                }
                return kotlinUnitVar;
            case 8:
                if (obj != null) {
                    throw new ClassCastException();
                }
                ((Field) obj2).getGenericType();
                throw null;
            case 9:
                Boolean bool2 = (Boolean) ((IInvokable) obj).invoke(((Field) obj2).getGenericType());
                bool2.booleanValue();
                return bool2;
            case 10:
                Set set = (Set) obj;
                List listAb = SomeStaticHelpers.arrayToList(((Executable) obj2).getGenericExceptionTypes());
                if (set.size() == listAb.size()) {
                    ArrayList arrayList3 = new ArrayList();
                    Iterator it3 = set.iterator();
                    if (it3.hasNext()) {
                        yg.throwIfVarNotNull(it3.next());
                        throw null;
                    }
                    if (arrayList3.size() == listAb.size()) {
                        z = true;
                    }
                }
                return Boolean.valueOf(!z);
            case 11:
                Set set2 = (Set) obj;
                List listAb2 = SomeStaticHelpers.arrayToList(((Executable) obj2).getGenericParameterTypes());
                if (set2.size() == listAb2.size()) {
                    ArrayList arrayList4 = new ArrayList();
                    Iterator it4 = set2.iterator();
                    if (it4.hasNext()) {
                        yg.throwIfVarNotNull(it4.next());
                        throw null;
                    }
                    if (arrayList4.size() == listAb2.size()) {
                        z = true;
                    }
                }
                return Boolean.valueOf(z);
            case 12:
                Set set3 = (Set) obj;
                List listAb3 = SomeStaticHelpers.arrayToList(((Executable) obj2).getGenericParameterTypes());
                if (set3.size() == listAb3.size()) {
                    ArrayList arrayList5 = new ArrayList();
                    Iterator it5 = set3.iterator();
                    if (it5.hasNext()) {
                        yg.throwIfVarNotNull(it5.next());
                        throw null;
                    }
                    if (arrayList5.size() == listAb3.size()) {
                        z = true;
                    }
                }
                return Boolean.valueOf(!z);
            case 13:
                return Boolean.valueOf(((Executable) obj2).isVarArgs() == ((Boolean) obj).booleanValue());
            case 14:
                return Boolean.valueOf(((Executable) obj2).isVarArgs() != ((Boolean) obj).booleanValue());
            case 15:
                try {
                    objX2 = (Boolean) ((IInvokable) obj).invoke(((Method) obj2).getReturnType());
                    objX2.getClass();
                    break;
                } catch (Throwable th4) {
                    objX2 = FastKV.getFailureFromException(th4);
                }
                Object obj3 = Boolean.FALSE;
                if (objX2 instanceof Failure) {
                    objX2 = obj3;
                }
                return (Boolean) objX2;
            case 16:
                try {
                    objX3 = (Boolean) ((IInvokable) obj).invoke(SomeStaticHelpers.arrayToList(((Executable) obj2).getParameterTypes()));
                    objX3.getClass();
                    break;
                } catch (Throwable th5) {
                    objX3 = FastKV.getFailureFromException(th5);
                }
                Object obj4 = Boolean.FALSE;
                if (objX3 instanceof Failure) {
                    objX3 = obj4;
                }
                return (Boolean) objX3;
            case 17:
                return Boolean.valueOf(((Method) obj2).isBridge() == ((Boolean) obj).booleanValue());
            case 18:
                return Boolean.valueOf(((Executable) obj2).getParameterCount() == ((Integer) obj).intValue());
            case 19:
                try {
                    objX4 = (Boolean) ((IInvokable) obj).invoke(Integer.valueOf(((Executable) obj2).getParameterCount()));
                    objX4.getClass();
                    break;
                } catch (Throwable th6) {
                    objX4 = FastKV.getFailureFromException(th6);
                }
                Object obj5 = Boolean.FALSE;
                if (objX4 instanceof Failure) {
                    objX4 = obj5;
                }
                return (Boolean) objX4;
            case 20:
                Set set4 = (Set) obj;
                List listAb4 = SomeStaticHelpers.arrayToList(((Executable) obj2).getTypeParameters());
                if (set4.size() == listAb4.size()) {
                    ArrayList arrayList6 = new ArrayList();
                    Iterator it6 = set4.iterator();
                    if (it6.hasNext()) {
                        yg.throwIfVarNotNull(it6.next());
                        throw null;
                    }
                    if (arrayList6.size() == listAb4.size()) {
                        z = true;
                    }
                }
                return Boolean.valueOf(z);
            case 21:
                Set set5 = (Set) obj;
                List listAb5 = SomeStaticHelpers.arrayToList(((Executable) obj2).getTypeParameters());
                if (set5.size() == listAb5.size()) {
                    ArrayList arrayList7 = new ArrayList();
                    Iterator it7 = set5.iterator();
                    if (it7.hasNext()) {
                        yg.throwIfVarNotNull(it7.next());
                        throw null;
                    }
                    if (arrayList7.size() == listAb5.size()) {
                        z = true;
                    }
                }
                return Boolean.valueOf(!z);
            case 22:
                Set set6 = (Set) obj;
                List listAb6 = SomeStaticHelpers.arrayToList(((Executable) obj2).getGenericExceptionTypes());
                if (set6.size() == listAb6.size()) {
                    ArrayList arrayList8 = new ArrayList();
                    Iterator it8 = set6.iterator();
                    if (it8.hasNext()) {
                        yg.throwIfVarNotNull(it8.next());
                        throw null;
                    }
                    if (arrayList8.size() == listAb6.size()) {
                        z = true;
                    }
                }
                return Boolean.valueOf(z);
            case 23:
                return Boolean.valueOf(nullSafeIsEqual(((Member) obj2).getName(), (String) obj));
            case 24:
                try {
                    objX5 = (Boolean) ((IInvokable) obj).invoke(((Member) obj2).getName());
                    objX5.getClass();
                    break;
                } catch (Throwable th7) {
                    objX5 = FastKV.getFailureFromException(th7);
                }
                Object obj6 = Boolean.FALSE;
                if (objX5 instanceof Failure) {
                    objX5 = obj6;
                }
                return (Boolean) objX5;
            case 25:
                return Boolean.valueOf(((Method) obj2).isBridge() != ((Boolean) obj).booleanValue());
            case 26:
                Set set7 = (Set) obj;
                Member member = (Member) obj2;
                if (set7 == null || !set7.isEmpty()) {
                    Iterator it9 = set7.iterator();
                    while (it9.hasNext()) {
                        if ((((AccessModifierEnum) it9.next()).mask & member.getModifiers()) != 0) {
                        }
                    }
                    z = true;
                } else {
                    z = true;
                }
                return Boolean.valueOf(z);
            case 27:
                Set set8 = (Set) obj;
                Member member2 = (Member) obj2;
                if (set8 == null || !set8.isEmpty()) {
                    Iterator it10 = set8.iterator();
                    while (it10.hasNext()) {
                        if ((((AccessModifierEnum) it10.next()).mask & member2.getModifiers()) != 0) {
                        }
                    }
                    z = true;
                } else {
                    z = true;
                }
                return Boolean.valueOf(z);
            case 28:
                IInvokable bgfVar = (IInvokable) obj;
                Member member3 = (Member) obj2;
                try {
                    cbm cbmVar = AccessModifierEnum.a;
                    modifiers = member3.getModifiers();
                    cbmVar.getClass();
                    KotlinEnumEntriesImpl kotlinEnumEntriesImplVar = AccessModifierEnum.ENUM_ENTRIES;
                    arrayList = new ArrayList();
                    it = kotlinEnumEntriesImplVar.iterator();
                } catch (Throwable th8) {
                    objX6 = FastKV.getFailureFromException(th8);
                }
                while (true) {
                    z zVar = (z) it;
                    if (!zVar.hasNext()) {
                        objX6 = (Boolean) bgfVar.invoke(StaticHelpers5.ad(arrayList));
                        objX6.getClass();
                        break;
                    } else {
                        Object next = zVar.next();
                        if ((((AccessModifierEnum) next).mask & modifiers) != 0) {
                            arrayList.add(next);
                        }
                    }
                    Object obj7 = Boolean.FALSE;
                    if (objX6 instanceof Failure) {
                        objX6 = obj7;
                    }
                    return (Boolean) objX6;
                }
            default:
                return Boolean.valueOf(((Member) obj2).isSynthetic() == ((Boolean) obj).booleanValue());
        }
    }
}

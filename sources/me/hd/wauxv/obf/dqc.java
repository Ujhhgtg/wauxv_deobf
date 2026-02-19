package me.hd.wauxv.obf;

import android.net.Uri;
import android.os.Build;
import android.util.Log;
import android.view.ViewGroup;
import java.io.IOException;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import net.bytebuddy.pool.TypePool;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public abstract class dqc {
    public static char[] as = null;
    public static final String[] at = { "standard", "accelerate", "decelerate", "linear" };
    public static final btd[] au = new btd[0];
    public static boolean av = true;

    public static final dfz aw(String str, emc emcVar, dfx[] dfxVarArr, IInvokable bgfVar) {
        throwIfVar1IsNull(str, "serialName");
        if (dnj.ak(str)) {
            throw new IllegalArgumentException("Blank serial names are prohibited");
        }
        if (emcVar.equals(dnt.a)) {
            throw new IllegalArgumentException(
                    "For StructureKind.CLASS please use 'buildClassSerialDescriptor' instead");
        }
        zd zdVar = new zd(str);
        bgfVar.invoke(zdVar);
        return new dfz(str, emcVar, zdVar.b.size(), SomeStaticHelpers.ab(dfxVarArr), zdVar);
    }

    public static dfz ax(String str, emc emcVar, dfx[] dfxVarArr) {
        throwIfVar1IsNull(str, "serialName");
        if (dnj.ak(str)) {
            throw new IllegalArgumentException("Blank serial names are prohibited");
        }
        if (emcVar.equals(dnt.a)) {
            throw new IllegalArgumentException(
                    "For StructureKind.CLASS please use 'buildClassSerialDescriptor' instead");
        }
        zd zdVar = new zd(str);
        return new dfz(str, emcVar, zdVar.b.size(), SomeStaticHelpers.ab(dfxVarArr), zdVar);
    }

    public static MethodHookWrapper ay(String str) {
        MethodHookWrapper methodHookWrapperVar = null;
        String str2 = "com.highcapable.yukihookapi.hook.xposed.bridge.status.YukiXposedModuleStatus_Impl_Impl_me_hd_wauxv" instanceof dcx
                ? null
                : "com.highcapable.yukihookapi.hook.xposed.bridge.status.YukiXposedModuleStatus_Impl_Impl_me_hd_wauxv";
        if (str2 == null) {
            str2 = "";
        }
        Class clsF = ReflectionWrapper.f(str2, 3, null);
        if (clsF != null) {
            int i = 0;
            SyntheticPileOfMess bmuVarBh = bh(clsF);
            bmuVarBh.setHookOptional(true);
            MethodResolver methodResolverVarT = bmuVarBh.getMethodResolverBasedOnPreviouslyProvidedConfig();
            methodResolverVarT.name = str;
            methodHookWrapperVar = (MethodHookWrapper) StaticHelpers5.g(methodResolverVarT.findMethods());
        }
        if (methodHookWrapperVar == null) {
            ewq.h("Failed to initialize YukiXposedModuleStatus");
        }
        return methodHookWrapperVar;
    }

    public static long az(long j) {
        if (j < -4611686018427387903L) {
            return -4611686018427387903L;
        }
        if (j > 4611686018427387903L) {
            return 4611686018427387903L;
        }
        return j;
    }

    public static final Object ba(long j, doi doiVar) {
        if (j > 0) {
            CancellableContinuation cancellableContinuationVar = new CancellableContinuation(cmz.ab(doiVar));
            aox aoxVarU = cancellableContinuationVar.u();
            if (aoxVarU != null && !(CancellableContinuation.d.get(cancellableContinuationVar) instanceof coo)) {
                aoxVarU.e();
                CancellableContinuation.e.set(cancellableContinuationVar, con.b);
            }
            if (j < Long.MAX_VALUE) {
                ahf ahfVar_w = cancellableContinuationVar.g._w(arj.a);
                als alsVar = ahfVar_w instanceof als ? (als) ahfVar_w : null;
                if (alsVar == null) {
                    alsVar = akl.a;
                }
                alsVar._av(j, cancellableContinuationVar);
            }
            Object objT = cancellableContinuationVar.t();
            if (objT == ahq.a) {
                return objT;
            }
        }
        return KotlinUnit.INSTANCE;
    }

    /* JADX WARN: Found duplicated region for block: B:49:0x0167 */
    public static void bb(ayd aydVar, int i) {
        int i2;
        MappedByteBuffer mappedByteBufferAw;
        ArrayList arrayList = aydVar.s;
        if (!arrayList.isEmpty()) {
            Collections.sort(arrayList);
            dfk dfkVar = (dfk) arrayList.get(0);
            int size = arrayList.size();
            int i3 = 0;
            for (int i4 = 1; i4 < size; i4++) {
                dfk dfkVar2 = (dfk) arrayList.get(i4);
                if (dfkVar2.a == dfkVar.b) {
                    dfkVar.b = dfkVar2.b;
                } else {
                    i3++;
                    if (i3 != i4) {
                        arrayList.set(i3, dfkVar2);
                    }
                    dfkVar = dfkVar2;
                }
            }
            int i5 = i3 + 1;
            if (size > i5) {
                arrayList.subList(i5, size).clear();
            }
        }
        dfk dfkVar3 = (dfk) arrayList.get(0);
        int i6 = dfkVar3.a;
        int i7 = aydVar.h;
        int i8 = i7 - aydVar.r;
        int i9 = i8 - 12;
        int i10 = i8 - i6;
        int i11 = i7 - i6;
        boolean z = i9 < i11 + i10;
        if (!z) {
            aydVar.i ^= aydVar.l.l(i6, i11);
        }
        int size2 = arrayList.size();
        int i12 = size2 - 1;
        int i13 = aydVar.h - ((dfk) arrayList.get(i12)).b;
        int i14 = i13 > 0 ? size2 : i12;
        int[] iArr = new int[i14];
        int[] iArr2 = new int[i14];
        int i15 = dfkVar3.a;
        int i16 = dfkVar3.b;
        int i17 = 1;
        while (i17 < size2) {
            ArrayList arrayList2 = arrayList;
            dfk dfkVar4 = (dfk) arrayList.get(i17);
            int i18 = i17;
            int i19 = dfkVar4.a - i16;
            int i20 = size2;
            byte[] bArr = (byte[]) aydVar.l.d;
            System.arraycopy(bArr, i16, bArr, i15, i19);
            int i21 = i18 - 1;
            iArr[i21] = i16;
            iArr2[i21] = i16 - i15;
            i15 += i19;
            i16 = dfkVar4.b;
            i17 = i18 + 1;
            arrayList = arrayList2;
            size2 = i20;
        }
        ArrayList arrayList3 = arrayList;
        if (i13 > 0) {
            byte[] bArr2 = (byte[]) aydVar.l.d;
            System.arraycopy(bArr2, i16, bArr2, i15, i13);
            iArr[i12] = i16;
            iArr2[i12] = i16 - i15;
        }
        aydVar.r = 0;
        arrayList3.clear();
        if (z) {
            aydVar.i = aydVar.l.l(12, i9);
        } else {
            aydVar.i ^= aydVar.l.l(i6, i10);
        }
        aydVar.h = i8;
        if (aydVar.g != null) {
            i9 |= 1073741824;
        }
        if (aydVar.aa == 0) {
            aydVar.x.putInt(0, -1);
            aydVar.x.putLong(4, aydVar.i);
            aydVar.x.position(i6);
            aydVar.x.put((byte[]) aydVar.l.d, i6, i10);
            aydVar.x.putInt(0, i9);
            aydVar.y.putInt(0, i9);
            aydVar.y.putLong(4, aydVar.i);
            aydVar.y.position(i6);
            aydVar.y.put((byte[]) aydVar.l.d, i6, i10);
        } else {
            aydVar.l.z(0, i9);
            aydVar.l.aa(4, aydVar.i);
        }
        int i22 = aydVar.h + i;
        if (((byte[]) aydVar.l.d).length - i22 > 32768) {
            int i23 = ayd.c;
            int iAc = FastKV.ac(i23, i22 + i23);
            byte[] bArr3 = (byte[]) aydVar.l.d;
            if (iAc >= bArr3.length) {
                i2 = 0;
            } else {
                byte[] bArr4 = new byte[iAc];
                i2 = 0;
                System.arraycopy(bArr3, 0, bArr4, 0, aydVar.h);
                aydVar.l.d = bArr4;
                if (aydVar.aa == 0) {
                    FileChannel fileChannel = aydVar.v;
                    long j = iAc;
                    MappedByteBuffer mappedByteBufferAw2 = null;
                    try {
                        fileChannel.truncate(j);
                        mappedByteBufferAw = FastKV.aw(fileChannel, iAc);
                    } catch (IOException unused) {
                        mappedByteBufferAw = null;
                    }
                    FileChannel fileChannel2 = aydVar.w;
                    try {
                        fileChannel2.truncate(j);
                        mappedByteBufferAw2 = FastKV.aw(fileChannel2, iAc);
                    } catch (IOException unused2) {
                    }
                    if (mappedByteBufferAw == null || mappedByteBufferAw2 == null) {
                        Log.e("FastKV", aydVar.e, new Exception("map failed"));
                        FastKV.be(aydVar);
                    } else {
                        aydVar.x = mappedByteBufferAw;
                        aydVar.y = mappedByteBufferAw2;
                    }
                }
                bhv.ab(aydVar, "truncate finish");
            }
        } else {
            i2 = 0;
        }
        for (aet aetVar : aydVar.j.values()) {
            int i24 = aetVar.b;
            if (i24 > i6) {
                int i25 = i14 - 1;
                int i26 = i2;
                while (i26 <= i25) {
                    int i27 = (i26 + i25) >>> 1;
                    int i28 = iArr[i27];
                    if (i28 >= i24) {
                        if (i28 <= i24) {
                            i25 = i27;
                            break;
                        }
                        i25 = i27 - 1;
                    } else {
                        i26 = i27 + 1;
                    }
                }
                int i29 = iArr2[i25];
                aetVar.b -= i29;
                if (aetVar.a() >= 6) {
                    ((afb) aetVar).j -= i29;
                }
            }
        }
        bhv.ab(aydVar, "gc finish");
    }

    public static Set bc() {
        try {
            Object objInvoke = Class.forName("android.text.EmojiConsistency").getMethod("getEmojiConsistencySet", null)
                    .invoke(null, null);
            if (objInvoke == null) {
                return Collections.EMPTY_SET;
            }
            Set set = (Set) objInvoke;
            Iterator it = set.iterator();
            while (it.hasNext()) {
                if (!(it.next() instanceof int[])) {
                    return Collections.EMPTY_SET;
                }
            }
            return set;
        } catch (Throwable unused) {
            return Collections.EMPTY_SET;
        }
    }

    public static boolean bd(Uri uri) {
        return uri != null && "content".equals(uri.getScheme()) && "media".equals(uri.getAuthority());
    }

    public static CharSequence coerceIn5120Chars(CharSequence charSequence) {
        return charSequence.length() > 5120 ? charSequence.subSequence(0, 5120) : charSequence;
    }

    public static List toSingletonList(Object obj) {
        List listSingletonList = Collections.singletonList(obj);
        throwIfVar1IsNull(listSingletonList, "singletonList(...)");
        return listSingletonList;
    }

    public static /* synthetic */ SyntheticPileOfMess bg(IEmpty5 bsvVar) {
        return new SyntheticPileOfMess(GifEncoder.initConfig(null, HugeSyntheticPileOfHelpers.getJavaClass(bsvVar), 15));
    }

    public static SyntheticPileOfMess bh(Class cls) {
        return new SyntheticPileOfMess(GifEncoder.initConfig(null, cls, 15));
    }

    public static SyntheticPileOfMess getWrapperConfiguration(Object obj) {
        return obj instanceof IEmpty5 ? new SyntheticPileOfMess(GifEncoder.initConfig(obj, HugeSyntheticPileOfHelpers.getJavaClass((IEmpty5) obj), 14))
                : obj instanceof Class ? new SyntheticPileOfMess(GifEncoder.initConfig(obj, (Class) obj, 14)) : new SyntheticPileOfMess(GifEncoder.initConfig(obj, obj.getClass(), 14));
    }

    public static KotlinIntProgression bj(IntRange intRangeVar, int i) {
        throwIfVar1IsNull(intRangeVar, "<this>");
        boolean z = i > 0;
        Integer numValueOf = Integer.valueOf(i);
        if (!z) {
            throw new IllegalArgumentException("Step must be positive, was: " + numValueOf
                    + TypePool.Default.LazyTypeDescription.GenericTypeToken.INNER_CLASS_PATH);
        }
        int i2 = intRangeVar.first;
        int i3 = intRangeVar.last;
        if (intRangeVar.step <= 0) {
            i = -i;
        }
        return new KotlinIntProgression(i2, i3, i);
    }

    public static void tryGetClassByName(ViewGroup viewGroup, boolean z) {
        if (Build.VERSION.SDK_INT >= 29) {
            erd.tryGetClassByName(viewGroup, z);
        } else if (av) {
            try {
                erd.tryGetClassByName(viewGroup, z);
            } catch (NoSuchMethodError unused) {
                av = false;
            }
        }
    }

    public static final void throwSomething(String str, zc zcVar) {
        String strO;
        String str2 = "in the polymorphic scope of '" + zcVar.d() + '\'';
        if (str == null) {
            strO = StaticHelpers6.o(TypePool.Default.LazyTypeDescription.GenericTypeToken.INNER_CLASS_PATH,
                    "Class discriminator was missing and no default serializers were registered ", str2);
        } else {
            strO = "Serializer for subclass '" + str + "' is not found " + str2 + ".\nCheck if class with serial name '"
                    + str
                    + "' exists and serializer is registered in a corresponding SerializersModule.\nTo be registered automatically, class '"
                    + str + "' has to be '@Serializable', and the base class '" + zcVar.d()
                    + "' has to be sealed and '@Serializable'.";
        }
        throw new SomeIllegalArgumentException(strO);
    }

    public static IntRange bm(int i, int i2) {
        if (i2 > Integer.MIN_VALUE) {
            return new IntRange(i, i2 - 1, 1);
        }
        IntRange intRangeVar = IntRange.EMPTY_RANGE_INSTANCE;
        return IntRange.EMPTY_RANGE_INSTANCE;
    }

    public abstract int c(bbb bbbVar);
}

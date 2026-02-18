package me.hd.wauxv.obf;

import android.database.Cursor;
import android.net.Uri;
import android.util.Pair;
import com.android.dx.io.Opcodes;
import de.robv.android.xposed.XC_MethodHook;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public class arj implements ahg, bvc, cdw, dcq, evw, ccl, bui {
    public static final /* synthetic */ arj a = new arj();
    public static final /* synthetic */ arj b = new arj();
    public static final arj e = new arj();
    public static final arj f = new arj();
    public static final arj h = new arj();
    public static final /* synthetic */ arj i = new arj();
    public static final arj j = new arj();
    public static final arj k = new arj();
    public static final /* synthetic */ arj l = new arj();
    public static final arj m = new arj();
    public static final arj n = new arj();
    public static final arj o = new arj();
    public static final arj p = new arj();
    public static final arj q = new arj();

    public static long aa(long j2, long j3) {
        return (j2 & (-72057594037927936L)) | (j3 & 72057594037927935L);
    }

    public static void ab(String str, List list) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        clw clwVar = clw.a;
        LinkedList linkedList = new LinkedList();
        adz.a.getClass();
        Object objC = zf.c(emn.az(ady.a), new Object[0]);
        int i2 = bte.a;
        azg azgVarR = dqc.bi(objC).r();
        azgVarR.ab = cnb.z(-115581864901418L);
        ((azk) aaz.e(azgVarR.c())).f(str);
        ArrayList arrayList = new ArrayList(abb.ak(list, 10));
        Iterator it = list.iterator();
        while (it.hasNext()) {
            String str2 = (String) it.next();
            aeg.a.getClass();
            Method methodBb = emn.bb(aee.a);
            aec.a.getClass();
            Object objInvoke = methodBb.invoke(aec.b(), str2);
            bzo.o(objInvoke, cnb.z(-385198436907818L));
            arrayList.add((String) objInvoke);
        }
        String strK = !arrayList.isEmpty() ? aaz.k(arrayList, cnb.z(-115521735359274L), null, cnb.z(-115530325293866L), null, 58) : cnb.z(-115538915228458L);
        int i3 = bte.a;
        azg azgVarR2 = dqc.bi(objC).r();
        azgVarR2.ab = cnb.z(-115551800130346L);
        ((azk) aaz.e(azgVarR2.c())).f(strK);
        linkedList.push(objC);
        clwVar.getClass();
        cme.b(cme.a, emn.ba(clv.a).newInstance(linkedList));
    }

    public static Cursor ac(String str) {
        int i2 = bte.a;
        dlx.a.getClass();
        cde cdeVarT = dqc.bi(dlx.b()).t();
        cdeVarT.ab = cnb.z(-103246718827306L);
        Object objJ = ((cdk) dkz.n(new Object[]{dal.b(String.class), dal.b(Object[].class)}, 2, cdeVarT)).j(str, null);
        bzo.n(objJ);
        return (Cursor) objJ;
    }

    public static void ad(String str, String str2, String str3) throws JSONException, IllegalAccessException, InstantiationException, InvocationTargetException {
        String string;
        cmt cmtVar = cmt.a;
        acx.a.getClass();
        String strB = acx.b();
        if (str3 != null) {
            JSONObject jSONObject = new JSONObject();
            String strZ = cnb.z(-117037858814762L);
            JSONObject jSONObject2 = new JSONObject();
            String strZ2 = cnb.z(-117055038683946L);
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put(cnb.z(-117020678945578L), str3);
            jSONObject2.put(strZ2, jSONObject3);
            jSONObject.put(strZ, jSONObject2);
            HashSet hashSet = new HashSet();
            HashSet hashSet2 = new HashSet();
            bsr bsrVar = new bsr();
            bsrVar.b = jSONObject;
            bsrVar.c = hashSet;
            bsrVar.d = hashSet2;
            string = bsrVar.toString();
        } else {
            string = null;
        }
        String str4 = string;
        String strZ3 = cnb.z(-137181255433002L);
        cmtVar.getClass();
        cme.b(cme.a, emn.ba(cms.a).newInstance(4, strB, str, str2, 1, null, 0, str4, strZ3, Boolean.TRUE, 0));
    }

    public static void ae(String str, String str2, String str3, String str4, String str5, String str6) throws JSONException {
        cly clyVar = cly.a;
        JSONObject jSONObject = new JSONObject();
        String strZ = cnb.z(-118291989265194L);
        JSONObject jSONObject2 = new JSONObject();
        String strZ2 = cnb.z(-118240449657642L);
        JSONObject jSONObject3 = new JSONObject();
        jSONObject3.put(cnb.z(-118201794951978L), str2);
        jSONObject3.put(cnb.z(-118717191027498L), str3);
        jSONObject3.put(cnb.z(-118742960831274L), str4);
        jSONObject3.put(cnb.z(-118682831289130L), str5);
        jSONObject3.put(cnb.z(-118691421223722L), str6);
        jSONObject2.put(strZ2, jSONObject3);
        jSONObject.put(strZ, jSONObject2);
        HashSet hashSet = new HashSet();
        HashSet hashSet2 = new HashSet();
        hashSet.add(cnb.z(-118648471550762L));
        hashSet.add(cnb.z(-118605521877802L));
        hashSet.add(cnb.z(-118485262793514L));
        hashSet.add(cnb.z(-117866787502890L));
        hashSet.add(cnb.z(-117798068026154L));
        bsr bsrVar = new bsr();
        bsrVar.b = jSONObject;
        bsrVar.c = hashSet;
        bsrVar.d = hashSet2;
        cme.b(cme.a, cly.c(clyVar, str, bsrVar.toString(), ewg.g.w, 24));
    }

    public static void af(String str, String str2) {
        dap dapVar = new dap(cnb.z(-116367843916586L));
        List listAk = dfv.ak(new dpu(dap.b(dapVar, str2), new clo(5), 1));
        cly clyVar = cly.a;
        if (!listAk.isEmpty()) {
            bzo.q(str2, "input");
            bzx bzxVarD = dapVar.d(str2);
            if (bzxVarD == null) {
                str2 = str2.toString();
            } else {
                int length = str2.length();
                StringBuilder sb = new StringBuilder(length);
                int i2 = 0;
                do {
                    sb.append((CharSequence) str2, i2, bzxVarD.f().a);
                    StringBuilder sb2 = new StringBuilder("@");
                    Cursor cursorAc = ac(cnb.z(-85083302132522L) + ((String) ((bzv) bzxVarD.e()).get(1)) + '\'');
                    cursorAc.moveToFirst();
                    sb2.append(cnb.s(cursorAc).getNickname());
                    sb.append((CharSequence) sb2.toString());
                    i2 = bzxVarD.f().b + 1;
                    bzxVarD = bzxVarD.g();
                    if (i2 >= length) {
                        break;
                    }
                } while (bzxVarD != null);
                if (i2 < length) {
                    sb.append((CharSequence) str2, i2, length);
                }
                str2 = sb.toString();
                bzo.p(str2, "toString(...)");
            }
        }
        int i3 = ewg.a.w;
        boolean z = !listAk.isEmpty();
        clyVar.getClass();
        cme.b(cme.a, cly.b(str, str2, i3, z, listAk));
    }

    public static void ag(String str, String str2) throws IllegalAccessException, NoSuchMethodException, InstantiationException, InvocationTargetException {
        bos.a.getClass();
        Constructor constructorBa = emn.ba(bor.a);
        bmo.a.getClass();
        Object objNewInstance = constructorBa.newInstance(bmo.n(), dqc.bf(str2), null, str, 2, null, Boolean.TRUE);
        bzo.o(objNewInstance, cnb.z(-375839703169834L));
        dds ddsVar = dds.a;
        String strZ = cnb.z(-116299124439850L);
        ddsVar.getClass();
        emn.bb(ddr.a).invoke(null, (Thread) objNewInstance, strZ);
    }

    public static void ah(String str, String str2, int i2) throws IllegalAccessException, InstantiationException, InvocationTargetException {
        etu etuVar = etu.a;
        String strZ = cnb.z(-105630425676586L);
        etuVar.getClass();
        int i3 = bte.a;
        ets etsVar = ets.a;
        cde cdeVarT = dqc.bh(emn.az(etsVar)).t();
        cdeVarT.a = dal.b(String.class);
        Object objJ = ((cdk) dkz.n(new Object[]{dal.b(String.class), dal.b(String.class)}, 2, cdeVarT)).j(str, strZ);
        bzo.n(objJ);
        String str3 = (String) objJ;
        bad.a(new File(str2), new File(etu.b(etuVar, str3)));
        cde cdeVarT2 = dqc.bh(emn.az(etsVar)).t();
        cdeVarT2.a = dal.b(Boolean.TYPE);
        cdeVarT2.d = new epy(8);
        cdk cdkVar = (cdk) aaz.e(cdeVarT2.aj());
        if (cdkVar.a.getParameterCount() == 4) {
            cdkVar.e(str3, Integer.valueOf(i2), 0, null);
        } else {
            cdkVar.e(str3, Integer.valueOf(i2), 0);
        }
        cmv.a.getClass();
        cme.b(cme.a, emn.ba(cmu.a).newInstance(str3, 0));
    }

    public static void ai(String str, String str2) {
        kb.a.getClass();
        int i2 = bte.a;
        ka kaVar = ka.a;
        cde cdeVarT = dqc.bh(emn.az(kaVar)).t();
        cdy cdyVar = cdy.c;
        cdeVarT.ak(cdyVar);
        cdeVarT.a = emn.az(kaVar);
        Object objE = ((cdk) dkz.n(new Object[]{dal.b(String.class)}, 1, cdeVarT)).e(str2);
        bzo.n(objE);
        kd kdVar = kd.a;
        String strZ = cnb.z(-120125940300586L);
        String strZ2 = cnb.z(-120138825202474L);
        String strZ3 = cnb.z(-120134530235178L);
        kdVar.getClass();
        cde cdeVarT2 = dqc.bh(emn.bb(kc.a).getDeclaringClass()).t();
        cdeVarT2.ak(cdyVar);
        cdeVarT2.a = dal.b(Pair.class);
        ((cdk) dkz.n(new Object[]{emn.az(kaVar), dal.b(String.class), dal.b(String.class), dal.b(String.class), dal.b(String.class), dal.b(byte[].class)}, 6, cdeVarT2)).e(objE, strZ, strZ2, str, strZ3, null);
    }

    public static void aj(String str, List list, String str2, String str3) throws IllegalAccessException, InvocationTargetException {
        Object objC = eog.c(eog.a, ewj.a.h);
        eog.d(objC, str);
        ArrayList arrayList = new ArrayList(abb.ak(list, 10));
        Iterator it = list.iterator();
        while (it.hasNext()) {
            String str4 = (String) it.next();
            djx.a.getClass();
            arrayList.add(emn.ba(djw.a).newInstance(str4, 2));
        }
        emn.bb(eof.a).invoke(objC, arrayList);
        if (str2 != null) {
            if (str2.length() == 0) {
                str2 = null;
            }
            if (str2 != null) {
                eog.a.getClass();
                eog.i(objC, str2);
            }
        }
        if (str3 != null) {
            if (str3.length() == 0) {
                str3 = null;
            }
            if (str3 != null) {
                eog.a.getClass();
                eog.g(objC, str3);
            }
        }
        eog.a.getClass();
        eog.b(objC);
    }

    public static void ak(String str, String str2, int i2, int i3) throws IllegalAccessException, NoSuchMethodException, InstantiationException, InvocationTargetException {
        Object objNewInstance;
        cmy cmyVar = cmy.a;
        String strZ = cnb.z(-137477608176426L);
        cmyVar.getClass();
        Constructor constructorBa = emn.ba(cmw.a);
        int parameterCount = constructorBa.getParameterCount();
        if (parameterCount == 6) {
            objNewInstance = constructorBa.newInstance(3, str, str2, Integer.valueOf(i2), strZ, Integer.valueOf(i3));
        } else if (parameterCount == 7) {
            objNewInstance = constructorBa.newInstance(3, str, str2, Integer.valueOf(i2), strZ, Integer.valueOf(i3), null);
        } else {
            if (parameterCount != 8) {
                StringBuilder sb = new StringBuilder();
                sb.append(cnb.z(-137615047129898L));
                sb.append(constructorBa.getParameterCount());
                throw new NoSuchMethodException(yg.h(-137640816933674L, sb));
            }
            objNewInstance = constructorBa.newInstance(3, str, str2, Integer.valueOf(i2), strZ, Integer.valueOf(i3), null, null);
        }
        cme.b(cme.a, objNewInstance);
    }

    public static final blq r(XC_MethodHook.MethodHookParam methodHookParam) {
        return new blq(new bmh(methodHookParam, 0), new bmh(methodHookParam, 1), new bmh(methodHookParam, 2), new bmi(methodHookParam, 0), new bmi(methodHookParam, 1));
    }

    public static String s() {
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < 15; i2++) {
            ae aeVar = cyj.f;
            sb.append("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789".charAt(cyj.f.c(62)));
        }
        return sb.toString();
    }

    public static void t(byte[] bArr, BigInteger bigInteger) {
        if (bArr.length == 0 || bArr.length < 131072) {
            return;
        }
        cyh cyhVar = new cyh(bigInteger);
        bqf bqfVarBj = dqc.bj(dqc.bm(0, 131072), 8);
        int i2 = bqfVarBj.a;
        int i3 = bqfVarBj.b;
        int i4 = bqfVarBj.c;
        if ((i4 <= 0 || i2 > i3) && (i4 >= 0 || i3 > i2)) {
            return;
        }
        while (true) {
            int i5 = cyhVar.f;
            BigInteger bigInteger2 = cyhVar.c[i5];
            if (i5 == 0) {
                cyhVar.h();
                cyhVar.f = Opcodes.CONST_METHOD_TYPE;
            } else {
                cyhVar.f = i5 - 1;
            }
            byte[] bArr2 = new byte[8];
            for (int i6 = 0; i6 < 8; i6++) {
                BigInteger bigIntegerShiftRight = bigInteger2.shiftRight(i6 * 8);
                bzo.p(bigIntegerShiftRight, cnb.z(-583570091408170L));
                BigInteger bigIntegerValueOf = BigInteger.valueOf(Opcodes.CONST_METHOD_TYPE);
                bzo.p(bigIntegerValueOf, cnb.z(-582951616117546L));
                bArr2[7 - i6] = bigIntegerShiftRight.and(bigIntegerValueOf).byteValue();
            }
            for (int i7 = 0; i7 < 8; i7++) {
                int i8 = i2 + i7;
                if (i8 >= 131072) {
                    return;
                }
                bArr[i8] = (byte) (bArr[i8] ^ bArr2[i7]);
            }
            if (i2 == i3) {
                return;
            } else {
                i2 += i4;
            }
        }
    }

    public static void v(String str, String str2, BigInteger bigInteger) throws IOException {
        FileOutputStream fileOutputStream;
        byte[] bArr;
        FileInputStream fileInputStream = new FileInputStream(new File(str));
        try {
            fileOutputStream = new FileOutputStream(new File(str2));
            try {
                bArr = new byte[33554432];
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    cnh.m(fileOutputStream, th);
                    throw th2;
                }
            }
        } catch (Throwable th3) {
            try {
                throw th3;
            } catch (Throwable th4) {
                cnh.m(fileInputStream, th3);
                throw th4;
            }
        }
        while (true) {
            int i2 = fileInputStream.read(bArr);
            if (i2 == -1) {
                fileOutputStream.close();
                fileInputStream.close();
                return;
            } else {
                t(bArr, bigInteger);
                fileOutputStream.write(bArr, 0, i2);
            }
            throw th3;
        }
    }

    public static String w(String str) {
        bzo.q(str, com.umeng.analytics.pro.bt.az);
        String strEncode = Uri.encode(str, null);
        bzo.p(strEncode, "encode(...)");
        return strEncode;
    }

    public static Object x(String str, String str2, byte[] bArr, Object obj) throws IllegalAccessException {
        Object objC = zf.c(ajn.ag(cnb.z(-92565135162154L)), new Object[0]);
        int i2 = bte.a;
        bmu bmuVarBi = dqc.bi(objC);
        azg azgVarR = bmuVarBi.r();
        azgVarR.ab = cnb.z(-92895847643946L);
        ((azk) aaz.e(azgVarR.c())).f(str);
        azg azgVarR2 = bmuVarBi.r();
        azgVarR2.ab = cnb.z(-92852897970986L);
        ((azk) aaz.e(azgVarR2.c())).f(str2);
        azg azgVarR3 = bmuVarBi.r();
        azgVarR3.ab = cnb.z(-92835718101802L);
        ((azk) aaz.e(azgVarR3.c())).f(bArr);
        azg azgVarR4 = bmuVarBi.r();
        azgVarR4.ab = cnb.z(-92741228821290L);
        ((azk) aaz.e(azgVarR4.c())).f(obj);
        return objC;
    }

    public static /* synthetic */ Object y(String str, String str2, Object obj, int i2) {
        if ((i2 & 1) != 0) {
            str = cnb.z(-92724048952106L);
        }
        if ((i2 & 2) != 0) {
            str2 = cnb.z(-92736933853994L);
        }
        return x(str, str2, null, obj);
    }

    public static long z(long j2, bhu bhuVar) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (bhuVar.equals(agd.f)) {
            return aa(j2, jCurrentTimeMillis) | 6917529027641081856L;
        }
        if (bhuVar.equals(agd.d)) {
            return aa(j2, jCurrentTimeMillis) & (-6917529027641081857L);
        }
        if (bhuVar.equals(agd.b)) {
            return aa(j2, jCurrentTimeMillis) & 6917529027641081856L;
        }
        if (bhuVar.equals(agd.e)) {
            return aa(j2, jCurrentTimeMillis) | (-6917529027641081856L);
        }
        if (bhuVar.equals(agd.c)) {
            return aa(j2, jCurrentTimeMillis) & 6917529027641081855L;
        }
        if (bhuVar.equals(agd.a)) {
            return aa(j2, jCurrentTimeMillis) & (-6917529027641081856L);
        }
        throw new abt();
    }

    @Override // me.hd.wauxv.obf.bui
    public void al(bun bunVar) {
        bunVar.q();
    }

    @Override // me.hd.wauxv.obf.evw
    public int am(int i2, int i3) {
        return i3;
    }

    @Override // me.hd.wauxv.obf.bui
    public void an(bun bunVar) {
    }

    public boolean ao() {
        return this instanceof bzq;
    }

    public void ap(float f2, float f3, float f4, dgw dgwVar) {
        dgwVar.k(f2, 0.0f);
    }

    @Override // me.hd.wauxv.obf.ccl
    public void c(cbw cbwVar, boolean z) {
    }

    @Override // me.hd.wauxv.obf.ccl
    public boolean d(cbw cbwVar) {
        return false;
    }

    @Override // me.hd.wauxv.obf.dcq
    public dcg g(dcg dcgVar, crw crwVar) {
        return dcgVar;
    }

    @Override // me.hd.wauxv.obf.cdw
    public cdv u(chm chmVar) {
        return ent.a;
    }
}

package me.hd.wauxv.obf;

import android.text.Editable;
import android.text.Selection;
import io.github.rosemoe.sora.widget.CodeEditor;
import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import me.hd.wauxv.data.bean.MsgInfoBean;
import net.bytebuddy.jar.asm.signature.SignatureVisitor;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class dfq implements bgj {
    public final /* synthetic */ int a;

    public /* synthetic */ dfq(int i) {
        this.a = i;
    }

    @Override // me.hd.wauxv.obf.bgj
    public final Object g(Object obj, Object obj2) throws JSONException {
        long jAl;
        long jAl2;
        Object objX;
        int i = this.a;
        ens ensVar = ens.a;
        int i2 = 0;
        switch (i) {
            case 0:
                CodeEditor codeEditor = (CodeEditor) obj;
                ud udVar = (ud) obj2;
                throwIfVar1IsNull(codeEditor, "editor");
                throwIfVar1IsNull(udVar, "pos");
                int i3 = codeEditor.getText().y(udVar.b).b;
                if (!codeEditor.getProps().v) {
                    return codeEditor.getText().x().o(udVar.b, i3);
                }
                afo afoVarY = codeEditor.getText().y(udVar.b);
                int iR = (int) (cna.r(afoVarY, 0, afoVarY.b) & 4294967295L);
                return udVar.c != iR ? codeEditor.getText().x().o(udVar.b, iR) : codeEditor.getText().x().o(udVar.b, i3);
            case 1:
                throwIfVar1IsNull((CodeEditor) obj, "<unused var>");
                throwIfVar1IsNull((ud) obj2, "<unused var>");
                ud udVar2 = new ud();
                udVar2.c = 0;
                udVar2.b = 0;
                udVar2.a = 0;
                return udVar2;
            case 2:
                CodeEditor codeEditor2 = (CodeEditor) obj;
                throwIfVar1IsNull(codeEditor2, "editor");
                throwIfVar1IsNull((ud) obj2, "<unused var>");
                return codeEditor2.getText().x().n(codeEditor2.getText().d);
            case 3:
                CodeEditor codeEditor3 = (CodeEditor) obj;
                ud udVar3 = (ud) obj2;
                throwIfVar1IsNull(codeEditor3, "editor");
                throwIfVar1IsNull(udVar3, "pos");
                y yVar = codeEditor3.j;
                int iL = yVar.l(udVar3.a);
                ddm ddmVarQ = yVar.q(iL);
                int i4 = iL + 1;
                int i5 = (i4 == yVar.e() || yVar.q(i4).a != ddmVarQ.a) ? ddmVarQ.e : ddmVarQ.e - 1;
                if (!codeEditor3.getProps().v) {
                    return codeEditor3.getText().x().o(ddmVarQ.a, ddmVarQ.d);
                }
                int iR2 = (int) (cna.r(codeEditor3.getText().y(udVar3.b), ddmVarQ.d, i5) >> 32);
                return (udVar3.c == iR2 || iR2 == i5) ? codeEditor3.getText().x().o(udVar3.b, ddmVarQ.d) : codeEditor3.getText().x().o(udVar3.b, iR2);
            case 4:
                CodeEditor codeEditor4 = (CodeEditor) obj;
                ud udVar4 = (ud) obj2;
                throwIfVar1IsNull(codeEditor4, "editor");
                throwIfVar1IsNull(udVar4, "pos");
                y yVar2 = codeEditor4.j;
                int iL2 = yVar2.l(udVar4.a);
                ddm ddmVarQ2 = yVar2.q(iL2);
                int i6 = iL2 + 1;
                int i7 = (i6 == yVar2.e() || yVar2.q(i6).a != ddmVarQ2.a) ? ddmVarQ2.e : ddmVarQ2.e - 1;
                if (!codeEditor4.getProps().v) {
                    return codeEditor4.getText().x().o(ddmVarQ2.a, i7);
                }
                int iR3 = (int) (cna.r(codeEditor4.getText().y(udVar4.b), ddmVarQ2.d, i7) & 4294967295L);
                return udVar4.c != iR3 ? codeEditor4.getText().x().o(udVar4.b, iR3) : codeEditor4.getText().x().o(udVar4.b, i7);
            case 5:
                CodeEditor codeEditor5 = (CodeEditor) obj;
                ud udVar5 = (ud) obj2;
                throwIfVar1IsNull(codeEditor5, "editor");
                throwIfVar1IsNull(udVar5, "pos");
                long j = codeEditor5.j.j(udVar5.b, udVar5.c);
                return codeEditor5.getText().x().o((int) (j >> 32), (int) (j & 4294967295L));
            case 6:
                CodeEditor codeEditor6 = (CodeEditor) obj;
                ud udVar6 = (ud) obj2;
                throwIfVar1IsNull(codeEditor6, "editor");
                throwIfVar1IsNull(udVar6, "pos");
                ahy cursor = codeEditor6.getCursor();
                long jAl3 = KotlinHelpers.al(udVar6.b, udVar6.c);
                cursor.getClass();
                int i8 = (int) (jAl3 >> 32);
                int i9 = (int) (jAl3 & 4294967295L);
                dqq dqqVarD = dqq.d();
                aff affVar = cursor.a;
                int iE = dqqVarD.e(i9, affVar.y(i8));
                if (iE != i9 || i9 != 0) {
                    jAl = KotlinHelpers.al(i8, iE);
                } else if (i8 == 0) {
                    jAl = 0;
                } else {
                    int i10 = i8 - 1;
                    jAl = KotlinHelpers.al(i10, affVar.y(i10).b);
                }
                return codeEditor6.getText().x().o((int) (jAl >> 32), (int) (jAl & 4294967295L));
            case 7:
                CodeEditor codeEditor7 = (CodeEditor) obj;
                ud udVar7 = (ud) obj2;
                throwIfVar1IsNull(codeEditor7, "editor");
                throwIfVar1IsNull(udVar7, "pos");
                ahy cursor2 = codeEditor7.getCursor();
                long jAl4 = KotlinHelpers.al(udVar7.b, udVar7.c);
                int i11 = (int) (jAl4 >> 32);
                int i12 = (int) (jAl4 & 4294967295L);
                aff affVar2 = cursor2.a;
                int i13 = affVar2.y(i11).b;
                dqq dqqVarD2 = dqq.d();
                afo afoVarY2 = affVar2.y(i11);
                int iMax = Math.max(0, i12 - 64);
                Editable editable = dqqVarD2.b;
                editable.append((CharSequence) afoVarY2, iMax, Math.min(afoVarY2.b, i12 + 65));
                Selection.setSelection(editable, Math.min(i12 - iMax, editable.length()));
                Selection.moveRight(editable, dqqVarD2.c);
                int selectionStart = Selection.getSelectionStart(editable);
                editable.clear();
                Selection.removeSelection(editable);
                int i14 = selectionStart + iMax;
                if (i14 == i13 && i12 == i14) {
                    int i15 = i11 + 1;
                    jAl2 = i15 == affVar2.a.size() ? KotlinHelpers.al(i11, i13) : KotlinHelpers.al(i15, 0);
                } else {
                    jAl2 = KotlinHelpers.al(i11, i14);
                }
                return codeEditor7.getText().x().o((int) (jAl2 >> 32), (int) (jAl2 & 4294967295L));
            case 8:
                return Integer.valueOf(KotlinHelpers.r(((ctr) obj).a.a, ((ctr) obj2).a.a));
            case 9:
                int iIntValue = ((Integer) obj).intValue();
                long jLongValue = ((Long) obj2).longValue();
                dlh dlhVar = new dlh();
                dlhVar.b = iIntValue;
                dlhVar.c = jLongValue;
                return dlhVar;
            case 10:
                ahf ahfVar = (ahf) obj2;
                if (!(ahfVar instanceof drn)) {
                    return obj;
                }
                Integer num = obj instanceof Integer ? (Integer) obj : null;
                int iIntValue2 = num != null ? num.intValue() : 1;
                return iIntValue2 == 0 ? ahfVar : Integer.valueOf(iIntValue2 + 1);
            case 11:
                drn drnVar = (drn) obj;
                ahf ahfVar2 = (ahf) obj2;
                if (drnVar != null) {
                    return drnVar;
                }
                if (ahfVar2 instanceof drn) {
                    return (drn) ahfVar2;
                }
                return null;
            case 12:
                return (drq) obj;
            case 13:
                int iIntValue3 = ((Integer) obj).intValue();
                List list = (List) obj2;
                if (iIntValue3 == 2) {
                    StringBuilder sb = new StringBuilder();
                    for (Object obj3 : list) {
                        int i16 = i2 + 1;
                        if (i2 < 0) {
                            aba.aj();
                            throw null;
                        }
                        JSONObject jSONObject = (JSONObject) obj3;
                        sb.append("第" + i16 + (char) 24352);
                        sb.append('\n');
                        sb.append("链接: " /* cnb.z(-588406224583466L) */ + jSONObject.getString("url" /* cnb.z(-588414814518058L) */) + jSONObject.getString("url_token" /* cnb.z(-588431994387242L) */));
                        sb.append('\n');
                        i2 = i16;
                    }
                    dnc.c(sb.toString());
                    dnc.g(null, 3, "复制图片成功" /* cnb.z(-588367569877802L) */);
                } else if (iIntValue3 == 4) {
                    JSONObject jSONObject2 = (JSONObject) list.get(0);
                    int i17 = jSONObject2.getInt("videoDuration" /* cnb.z(-588320325237546L) */);
                    Locale locale = Locale.CHINA;
                    String str = String.format(locale, "%02d:%02d:%02d" /* cnb.z(-588243015826218L) */, Arrays.copyOf(new Object[]{Integer.valueOf(i17 / 3600), Integer.valueOf((i17 % 3600) / 60), Integer.valueOf(i17 % 60)}, 3));
                    "format(...)" /* cnb.z(-588728347130666L) */;
                    String str2 = String.format(locale, "%.2f MB" /* cnb.z(-588672512555818L) */, Arrays.copyOf(new Object[]{Double.valueOf((((double) jSONObject2.getInt("fileSize" /* cnb.z(-588711167261482L) */)) / 1024.0d) / 1024.0d)}, 1));
                    "format(...)" /* cnb.z(-588638152817450L) */;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("时长: " /* cnb.z(-588552253471530L) */.concat(str));
                    sb2.append('\n');
                    sb2.append("大小: " /* cnb.z(-588582318242602L) */.concat(str2));
                    sb2.append('\n');
                    JSONObject jSONObjectOptJSONObject = jSONObject2.optJSONObject("media_cdn_info" /* cnb.z(-588526483667754L) */);
                    if (jSONObjectOptJSONObject == null || !jSONObjectOptJSONObject.has("pcdn_url" /* cnb.z(-585713280088874L) */)) {
                        String string = jSONObject2.getString("url" /* cnb.z(-585597315971882L) */);
                        String string2 = jSONObject2.getString("url_token" /* cnb.z(-585614495841066L) */);
                        String string3 = jSONObject2.getString("decodeKey" /* cnb.z(-585588726037290L) */);
                        sb2.append("密链: " /* cnb.z(-585494236756778L) */ + string + string2);
                        sb2.append('\n');
                        sb2.append("密钥: " /* cnb.z(-585524301527850L) */ + string3);
                        sb2.append('\n');
                    } else {
                        sb2.append("直链: " /* cnb.z(-585674625383210L) */ + jSONObjectOptJSONObject.getString("pcdn_url" /* cnb.z(-585635970677546L) */));
                        sb2.append('\n');
                    }
                    dnc.c(sb2.toString());
                    dnc.g(null, 3, "复制视频成功" /* cnb.z(-586018222766890L) */);
                }
                return ensVar;
            case 14:
                int iIntValue4 = ((Integer) obj).intValue();
                List list2 = (List) obj2;
                afw afwVar = null;
                if (iIntValue4 == 2) {
                    for (Object obj4 : list2) {
                        int i18 = i2 + 1;
                        if (i2 < 0) {
                            aba.aj();
                            throw null;
                        }
                        JSONObject jSONObject3 = (JSONObject) obj4;
                        String string4 = jSONObject3.getString("md5sum" /* cnb.z(-585988157995818L) */);
                        String string5 = jSONObject3.getString("url" /* cnb.z(-585940913355562L) */);
                        String string6 = jSONObject3.getString("url_token" /* cnb.z(-585958093224746L) */);
                        alc alcVar = aou.a;
                        cnd.bf(akq.f, new etb("第" + i18 + (char) 24352, string4, string5, string6, null, 0));
                        i2 = i18;
                    }
                } else if (iIntValue4 == 4) {
                    JSONObject jSONObject4 = (JSONObject) list2.get(0);
                    String string7 = jSONObject4.getString("md5sum" /* cnb.z(-585932323420970L) */);
                    String str3 = String.format(Locale.CHINA, "%.2fMB" /* cnb.z(-585863603944234L) */, Arrays.copyOf(new Object[]{Double.valueOf((((double) jSONObject4.getInt("fileSize" /* cnb.z(-585902258649898L) */)) / 1024.0d) / 1024.0d)}, 1));
                    "format(...)" /* cnb.z(-585833539173162L) */;
                    JSONObject jSONObjectOptJSONObject2 = jSONObject4.optJSONObject("media_cdn_info" /* cnb.z(-585197884013354L) */);
                    if (jSONObjectOptJSONObject2 == null || !jSONObjectOptJSONObject2.has("pcdn_url" /* cnb.z(-585116279634730L) */)) {
                        String string8 = jSONObject4.getString("url" /* cnb.z(-585094804798250L) */);
                        String string9 = jSONObject4.getString("url_token" /* cnb.z(-585111984667434L) */);
                        String string10 = jSONObject4.getString("decodeKey" /* cnb.z(-585017495386922L) */);
                        alc alcVar2 = aou.a;
                        cnd.bf(akq.f, new etd(str3, string7, string10, string8, string9, null, 0));
                    } else {
                        alc alcVar3 = aou.a;
                        cnd.bf(akq.f, new etc(str3, string7, jSONObjectOptJSONObject2, afwVar, 0));
                    }
                }
                return ensVar;
            case 15:
                int iIntValue5 = ((Integer) obj).intValue();
                List list3 = (List) obj2;
                if (iIntValue5 == 2) {
                    StringBuilder sb3 = new StringBuilder();
                    for (Object obj5 : list3) {
                        int i19 = i2 + 1;
                        if (i2 < 0) {
                            aba.aj();
                            throw null;
                        }
                        JSONObject jSONObject5 = (JSONObject) obj5;
                        sb3.append("第" + i19 + (char) 24352);
                        sb3.append('\n');
                        sb3.append("链接: " /* cnb.z(-610735759555370L) */ + jSONObject5.getString("url" /* cnb.z(-610263313152810L) */) + jSONObject5.getString("url_token" /* cnb.z(-610761529359146L) */));
                        sb3.append('\n');
                        i2 = i19;
                    }
                    dnc.c(sb3.toString());
                    dnc.g(null, 3, "复制图片成功" /* cnb.z(-610679924980522L) */);
                } else if (iIntValue5 == 4) {
                    JSONObject jSONObject6 = (JSONObject) list3.get(0);
                    int i20 = jSONObject6.getInt("videoDuration" /* cnb.z(-610649860209450L) */);
                    Locale locale2 = Locale.CHINA;
                    String str4 = String.format(locale2, "%02d:%02d:%02d" /* cnb.z(-610641270274858L) */, Arrays.copyOf(new Object[]{Integer.valueOf(i20 / 3600), Integer.valueOf((i20 % 3600) / 60), Integer.valueOf(i20 % 60)}, 3));
                    "format(...)" /* cnb.z(-610559665896234L) */;
                    String str5 = String.format(locale2, "%.2f MB" /* cnb.z(-607703512644394L) */, Arrays.copyOf(new Object[]{Double.valueOf((((double) jSONObject6.getInt("fileSize" /* cnb.z(-607724987480874L) */)) / 1024.0d) / 1024.0d)}, 1));
                    "format(...)" /* cnb.z(-607669152906026L) */;
                    StringBuilder sb4 = new StringBuilder();
                    sb4.append("时长: " /* cnb.z(-607651973036842L) */.concat(str4));
                    sb4.append('\n');
                    sb4.append("大小: " /* cnb.z(-607596138461994L) */.concat(str5));
                    sb4.append('\n');
                    JSONObject jSONObjectOptJSONObject3 = jSONObject6.optJSONObject("media_cdn_info" /* cnb.z(-607557483756330L) */);
                    if (jSONObjectOptJSONObject3 == null || !jSONObjectOptJSONObject3.has("pcdn_url" /* cnb.z(-607544598854442L) */)) {
                        String string11 = jSONObject6.getString("url" /* cnb.z(-607995570420522L) */);
                        String string12 = jSONObject6.getString("url_token" /* cnb.z(-607944030812970L) */);
                        String string13 = jSONObject6.getString("decodeKey" /* cnb.z(-607918261009194L) */);
                        sb4.append("密链: " /* cnb.z(-607892491205418L) */ + string11 + string12);
                        sb4.append('\n');
                        sb4.append("密钥: " /* cnb.z(-607836656630570L) */ + string13);
                        sb4.append('\n');
                    } else {
                        sb4.append("直链: " /* cnb.z(-608004160355114L) */ + jSONObjectOptJSONObject3.getString("pcdn_url" /* cnb.z(-608017045257002L) */));
                        sb4.append('\n');
                    }
                    dnc.c(sb4.toString());
                    dnc.g(null, 3, "复制视频成功" /* cnb.z(-607798001924906L) */);
                }
                return ensVar;
            case 16:
                int iIntValue6 = ((Integer) obj).intValue();
                List list4 = (List) obj2;
                afw afwVar2 = null;
                if (iIntValue6 == 2) {
                    for (Object obj6 : list4) {
                        int i21 = i2 + 1;
                        if (i2 < 0) {
                            aba.aj();
                            throw null;
                        }
                        JSONObject jSONObject7 = (JSONObject) obj6;
                        String string14 = jSONObject7.getString("md5sum" /* cnb.z(-607819476761386L) */);
                        String string15 = jSONObject7.getString("url" /* cnb.z(-607789411990314L) */);
                        String string16 = jSONObject7.getString("url_token" /* cnb.z(-607188116568874L) */);
                        alc alcVar4 = aou.a;
                        cnd.bf(akq.f, new etb("第" + i21 + (char) 24352, string14, string15, string16, null, 1));
                        i2 = i21;
                    }
                } else if (iIntValue6 == 4) {
                    JSONObject jSONObject8 = (JSONObject) list4.get(0);
                    String string17 = jSONObject8.getString("md5sum" /* cnb.z(-607162346765098L) */);
                    String str6 = String.format(Locale.CHINA, "%.2fMB" /* cnb.z(-607093627288362L) */, Arrays.copyOf(new Object[]{Double.valueOf((((double) jSONObject8.getInt("fileSize" /* cnb.z(-607115102124842L) */)) / 1024.0d) / 1024.0d)}, 1));
                    "format(...)" /* cnb.z(-607046382648106L) */;
                    JSONObject jSONObjectOptJSONObject4 = jSONObject8.optJSONObject("media_cdn_info" /* cnb.z(-607029202778922L) */);
                    if (jSONObjectOptJSONObject4 == null || !jSONObjectOptJSONObject4.has("pcdn_url" /* cnb.z(-606964778269482L) */)) {
                        String string18 = jSONObject8.getString("url" /* cnb.z(-607475879377706L) */);
                        String string19 = jSONObject8.getString("url_token" /* cnb.z(-607424339770154L) */);
                        String string20 = jSONObject8.getString("decodeKey" /* cnb.z(-607398569966378L) */);
                        alc alcVar5 = aou.a;
                        cnd.bf(akq.f, new etd(str6, string17, string20, string18, string19, null, 1));
                    } else {
                        alc alcVar6 = aou.a;
                        cnd.bf(akq.f, new etc(str6, string17, jSONObjectOptJSONObject4, afwVar2, 1));
                    }
                }
                return ensVar;
            case 17:
                MsgInfoBean msgInfoBean = (MsgInfoBean) obj2;
                String imgPath = msgInfoBean.getImgPath();
                throwIfVar1IsNull(imgPath);
                ewz.aq(etl.a, new etk(etu.b(etu.a, imgPath), Integer.parseInt(msgInfoBean.getContent()), i2));
                return ensVar;
            default:
                MsgInfoBean msgInfoBean2 = (MsgInfoBean) obj2;
                long msgId = msgInfoBean2.getMsgId();
                String imgPath2 = msgInfoBean2.getImgPath();
                throwIfVar1IsNull(imgPath2);
                String strB = etu.b(etu.a, imgPath2);
                try {
                    File file = new File(etv.a.o());
                    file.mkdirs();
                    String str7 = msgId + SignatureVisitor.SUPER + imgPath2 + SignatureVisitor.SUPER + System.currentTimeMillis() + ".mp3" /* cnb.z(-520361057712938L) */;
                    bad.a(cnh.af(new File(strB)), new File(file, str7));
                    dnc.g(null, 3, "已保存到: " /* cnb.z(-520373942614826L) */ + file.getAbsolutePath() + '/' + str7);
                    objX = ensVar;
                } catch (Throwable th) {
                    objX = bhu.x(th);
                }
                Throwable thB = dcy.b(objX);
                if (thB != null) {
                    String strZ = "保存失败: " /* cnb.z(-526391191796522L) */;
                    String message = thB.getMessage();
                    dnc.g(null, 3, strZ.concat(message != null ? dnj.az(50, message) : "未知错误" /* cnb.z(-526343947156266L) */));
                }
                return ensVar;
        }
    }
}

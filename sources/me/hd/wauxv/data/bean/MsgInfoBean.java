package me.hd.wauxv.data.bean;

import com.alibaba.fastjson2.JSONArray;
import com.alibaba.fastjson2.JSONObject;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import me.hd.wauxv.obf.aba;
import me.hd.wauxv.obf.acv;
import me.hd.wauxv.obf.avd;
import me.hd.wauxv.obf.azg;
import me.hd.wauxv.obf.azk;
import me.hd.wauxv.obf.bjs;
import me.hd.wauxv.obf.bte;
import me.hd.wauxv.obf.bzo;
import me.hd.wauxv.obf.cnb;
import me.hd.wauxv.obf.dgg;
import me.hd.wauxv.obf.dnc;
import me.hd.wauxv.obf.dnj;
import me.hd.wauxv.obf.dnq;
import me.hd.wauxv.obf.dnr;
import me.hd.wauxv.obf.dqc;
import me.hd.wauxv.obf.eom;
import me.hd.wauxv.obf.ewg;
import me.hd.wauxv.obf.ri;
import me.hd.wauxv.obf.wv;
import me.hd.wauxv.obf.xp;
import me.hd.wauxv.obf.yg;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class MsgInfoBean {
    private final long createTime;
    private final String imgPath;
    private final Integer isSendInt;
    private final byte[] lvBuffer;
    private final long msgId;
    private final Long msgSeq;
    private final Long msgSvrId;
    private final Object origin;
    private final String originContent;
    private final String talker;
    private final Integer talkerId;
    private final int type;

    public MsgInfoBean(Object obj) throws IllegalAccessException {
        this.origin = obj;
        int i = bte.a;
        azg azgVarR = dqc.bi(obj).r();
        azgVarR.ab = cnb.z(-8396661062442L);
        Object objE = ((azk) yg.e(azgVarR)).e();
        bzo.n(objE);
        this.msgId = ((Number) objE).longValue();
        azg azgVarR2 = dqc.bi(obj).r();
        azgVarR2.ab = cnb.z(-8379481193258L);
        this.msgSvrId = (Long) ((azk) yg.e(azgVarR2)).e();
        azg azgVarR3 = dqc.bi(obj).r();
        azgVarR3.ab = cnb.z(-8315056683818L);
        Object objE2 = ((azk) yg.e(azgVarR3)).e();
        bzo.n(objE2);
        this.type = ((Number) objE2).intValue();
        azg azgVarR4 = dqc.bi(obj).r();
        azgVarR4.ab = cnb.z(-8766028249898L);
        this.isSendInt = (Integer) ((azk) yg.e(azgVarR4)).e();
        azg azgVarR5 = dqc.bi(obj).r();
        azgVarR5.ab = cnb.z(-8761733282602L);
        Object objE3 = ((azk) yg.e(azgVarR5)).e();
        bzo.n(objE3);
        this.createTime = ((Number) objE3).longValue();
        azg azgVarR6 = dqc.bi(obj).r();
        azgVarR6.ab = cnb.z(-8688718838570L);
        Object objE4 = ((azk) yg.e(azgVarR6)).e();
        bzo.n(objE4);
        this.talker = (String) objE4;
        azg azgVarR7 = dqc.bi(obj).r();
        azgVarR7.ab = cnb.z(-8615704394538L);
        this.originContent = (String) ((azk) yg.e(azgVarR7)).e();
        azg azgVarR8 = dqc.bi(obj).r();
        azgVarR8.ab = cnb.z(-8538394983210L);
        this.imgPath = (String) ((azk) yg.e(azgVarR8)).e();
        azg azgVarR9 = dqc.bi(obj).r();
        azgVarR9.ab = cnb.z(-7911329757994L);
        this.lvBuffer = (byte[]) ((azk) yg.e(azgVarR9)).e();
        azg azgVarR10 = dqc.bi(obj).r();
        azgVarR10.ab = cnb.z(-7898444856106L);
        this.talkerId = (Integer) ((azk) yg.e(azgVarR10)).e();
        azg azgVarR11 = dqc.bi(obj).r();
        azgVarR11.ab = cnb.z(-7834020346666L);
        this.msgSeq = (Long) ((azk) yg.e(azgVarR11)).e();
    }

    public final List<String> getAtUserList() {
        Object byPath = dnc.e(getMsgSource()).getByPath(cnb.z(-5381594020650L));
        String str = byPath instanceof String ? (String) byPath : null;
        if (str == null || str.length() == 0) {
            return avd.a;
        }
        List listAs = dnj.as(str, new String[]{cnb.z(-5274219838250L)});
        ArrayList arrayList = new ArrayList();
        for (Object obj : listAs) {
            if (((String) obj).length() > 0) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    public final String getContent() {
        if (isText()) {
            if (!isGroupChat()) {
                String str = this.originContent;
                bzo.n(str);
                return str;
            }
            if (isSend()) {
                String str2 = this.originContent;
                bzo.n(str2);
                return str2;
            }
            String str3 = this.originContent;
            bzo.n(str3);
            return dnj.au(str3, cnb.z(-7722351196970L), str3);
        }
        if (isImage()) {
            String strH = this.originContent;
            if (strH != null) {
                if (dnj.ab(strH, cnb.z(-7730941131562L), false) && dnj.ab(strH, cnb.z(-8237747272490L), false)) {
                    String strAy = dnj.ay(dnj.au(strH, cnb.z(-8190502632234L), strH), cnb.z(-8147552959274L));
                    StringBuilder sb = new StringBuilder();
                    sb.append(cnb.z(-8117488188202L));
                    sb.append(dnc.a(strAy));
                    strH = yg.h(-8143257991978L, sb);
                } else if (strH.length() == 0) {
                    strH = this.imgPath;
                }
                if (strH != null) {
                    return strH;
                }
            }
            String str4 = this.imgPath;
            return str4 == null ? cnb.z(-8096013351722L) : str4;
        }
        if (isEmoji()) {
            String str5 = this.originContent;
            bzo.n(str5);
            if (!dnj.ab(str5, cnb.z(-8108898253610L), false) || !dnj.ab(str5, cnb.z(-8065948580650L), false)) {
                return str5;
            }
            String strAy2 = dnj.ay(dnj.au(str5, cnb.z(-8018703940394L), str5), cnb.z(-7975754267434L));
            StringBuilder sb2 = new StringBuilder();
            sb2.append(cnb.z(-5196910426922L));
            sb2.append(dnc.a(strAy2));
            return yg.h(-5222680230698L, sb2);
        }
        if (isVoice() || isVideo()) {
            String str6 = this.originContent;
            bzo.n(str6);
            return (dnj.ab(str6, cnb.z(-5175435590442L), false) && dnj.ab(str6, cnb.z(-5132485917482L), false)) ? dnj.ax(dnj.au(str6, cnb.z(-5102421146410L), str6), cnb.z(-5025111735082L)) : dnj.ax(dnj.au(str6, cnb.z(-5033701669674L), str6), cnb.z(-5042291604266L));
        }
        if (isShareCard()) {
            String str7 = this.originContent;
            bzo.n(str7);
            String strAy3 = dnj.ay(dnj.au(str7, cnb.z(-5050881538858L), str7), cnb.z(-4995046964010L));
            StringBuilder sb3 = new StringBuilder();
            sb3.append(cnb.z(-5016521800490L));
            sb3.append(dnc.a(strAy3));
            return yg.h(-4973572127530L, sb3);
        }
        if (isShareCard() || isLocation() || isApp() || isLink() || isTransfer() || isRedBag() || isVideoNumberVideo() || isNote() || isQuote() || isFile()) {
            String str8 = this.originContent;
            bzo.n(str8);
            String strAy4 = dnj.ay(dnj.au(str8, cnb.z(-5471788333866L), str8), cnb.z(-5497558137642L));
            StringBuilder sb4 = new StringBuilder();
            sb4.append(cnb.z(-5450313497386L));
            sb4.append(dnc.a(strAy4));
            return yg.h(-5407363824426L, sb4);
        }
        if (isPat()) {
            PatMsg patMsg = getPatMsg();
            bzo.n(patMsg);
            return patMsg.getTemplate();
        }
        String str9 = this.originContent;
        bzo.n(str9);
        return str9;
    }

    public final long getCreateTime() {
        return this.createTime;
    }

    public final FileMsg getFileMsg() {
        if (!isFile()) {
            return null;
        }
        String str = this.originContent;
        bzo.n(str);
        return new FileMsg(str);
    }

    public final String getImgPath() {
        return this.imgPath;
    }

    public final byte[] getLvBuffer() {
        return this.lvBuffer;
    }

    public final long getMsgId() {
        return this.msgId;
    }

    public final Long getMsgSeq() {
        return this.msgSeq;
    }

    public final String getMsgSource() {
        byte[] bArr = this.lvBuffer;
        if (bArr == null || bArr.length == 0) {
            return cnb.z(-5377299053354L);
        }
        ri riVar = new ri(0);
        if (bArr.length == 0 || bArr[0] != 123 || bArr[bArr.length - 1] != 125) {
            return cnb.z(-5373004086058L);
        }
        ByteBuffer byteBufferWrap = ByteBuffer.wrap(bArr);
        riVar.b = byteBufferWrap;
        if (byteBufferWrap == null) {
            bzo.ar(cnb.z(-22604412877610L));
            throw null;
        }
        byteBufferWrap.position(1);
        if (!riVar.g()) {
            ByteBuffer byteBuffer = riVar.b;
            if (byteBuffer == null) {
                bzo.ar(cnb.z(-22896470653738L));
                throw null;
            }
            short s = byteBuffer.getShort();
            if (s > 3072) {
                throw new IllegalArgumentException(cnb.z(-22866405882666L).toString());
            }
            if (s != 0) {
                ByteBuffer byteBuffer2 = riVar.b;
                if (byteBuffer2 == null) {
                    bzo.ar(cnb.z(-22217865820970L));
                    throw null;
                }
                byteBuffer2.position(byteBuffer2.position() + s);
            }
        }
        if (!riVar.g()) {
            ByteBuffer byteBuffer3 = riVar.b;
            if (byteBuffer3 == null) {
                bzo.ar(cnb.z(-23046794509098L));
                throw null;
            }
            byteBuffer3.position(byteBuffer3.position() + 4);
        }
        if (riVar.g()) {
            return cnb.z(-5385888987946L);
        }
        ByteBuffer byteBuffer4 = riVar.b;
        if (byteBuffer4 == null) {
            bzo.ar(cnb.z(-23845658426154L));
            throw null;
        }
        int i = byteBuffer4.getShort();
        if (i > 3072) {
            throw new IllegalArgumentException(cnb.z(-23798413785898L).toString());
        }
        if (i == 0) {
            return cnb.z(-23648089930538L);
        }
        byte[] bArr2 = new byte[i];
        ByteBuffer byteBuffer5 = riVar.b;
        if (byteBuffer5 != null) {
            byteBuffer5.get(bArr2);
            return new String(bArr2, StandardCharsets.UTF_8);
        }
        bzo.ar(cnb.z(-23643794963242L));
        throw null;
    }

    public final Long getMsgSvrId() {
        return this.msgSvrId;
    }

    public final Object getOrigin() {
        return this.origin;
    }

    public final String getOriginContent() {
        return this.originContent;
    }

    public final PatMsg getPatMsg() {
        if (!isPat()) {
            return null;
        }
        String str = this.originContent;
        bzo.n(str);
        return new PatMsg(str);
    }

    public final QuoteMsg getQuoteMsg() {
        if (!isQuote()) {
            return null;
        }
        String str = this.originContent;
        bzo.n(str);
        return new QuoteMsg(str);
    }

    public final String getSendTalker() {
        if (isSystem()) {
            return cnb.z(-7743826033450L);
        }
        if (isPat()) {
            PatMsg patMsg = getPatMsg();
            bzo.n(patMsg);
            return patMsg.getFromUser();
        }
        if (isSend()) {
            Object objB = acv.b(acv.a, eom.a.f);
            bzo.o(objB, cnb.z(-121955596368682L));
            return (String) objB;
        }
        if (!isGroupChat()) {
            return this.talker;
        }
        String str = this.originContent;
        bzo.n(str);
        return dnj.ax(str, cnb.z(-7713761262378L));
    }

    public final String getTalker() {
        return this.talker;
    }

    public final Integer getTalkerId() {
        return this.talkerId;
    }

    public final TransferMsg getTransferMsg() {
        if (!isTransfer()) {
            return null;
        }
        String str = this.originContent;
        bzo.n(str);
        return new TransferMsg(str);
    }

    public final int getType() {
        return this.type;
    }

    public final boolean isAnnounceAll() {
        return getAtUserList().contains(cnb.z(-5282809772842L));
    }

    public final boolean isApp() {
        return this.type == ewg.h.w;
    }

    public final boolean isAtMe() {
        List<String> atUserList = getAtUserList();
        Object objB = acv.b(acv.a, eom.a.f);
        bzo.o(objB, cnb.z(-121955596368682L));
        return atUserList.contains((String) objB);
    }

    public final boolean isChatroom() {
        return dnr.bi(this.talker, cnb.z(-4874787879722L));
    }

    public final boolean isEmoji() {
        return this.type == ewg.f.w;
    }

    public final boolean isEnumMsg(ewg ewgVar) {
        return this.type == ewgVar.w;
    }

    public final boolean isFile() {
        return this.type == ewg.u.w;
    }

    public final boolean isGroupChat() {
        return isChatroom() || isImChatroom();
    }

    public final boolean isImChatroom() throws IllegalAccessException {
        boolean zBi = dnr.bi(this.talker, cnb.z(-4780298599210L));
        xp xpVar = xp.a;
        String str = this.talker;
        xpVar.getClass();
        Object objB = xp.b(str);
        if (objB != null) {
            wv.a.getClass();
            int i = bte.a;
            azg azgVarR = dqc.bi(objB).r();
            azgVarR.ab = cnb.z(-76149770156842L);
            Object objE = ((azk) yg.e(azgVarR)).e();
            bzo.n(objE);
            boolean z = dnr.bi(this.talker, cnb.z(-4776003631914L)) && (((Number) objE).intValue() & 131072) == 131072;
            if (zBi || z) {
                return true;
            }
        }
        return false;
    }

    public final boolean isImage() {
        return this.type == ewg.b.w;
    }

    public final boolean isLink() {
        return this.type == ewg.k.w;
    }

    public final boolean isLocation() {
        return this.type == ewg.g.w;
    }

    public final boolean isNote() {
        return this.type == ewg.r.w;
    }

    public final boolean isNotifyAll() {
        boolean z;
        boolean z2;
        Object objB = acv.b(acv.a, eom.a.f);
        bzo.o(objB, cnb.z(-121955596368682L));
        List listAg = aba.ag((String) objB, cnb.z(-4660039514922L));
        if (!listAg.isEmpty()) {
            Iterator it = listAg.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                }
                if (getAtUserList().contains((String) it.next())) {
                    z = true;
                    break;
                }
            }
        } else {
            z = false;
            break;
        }
        List listAg2 = aba.ag(cnb.z(-4578435136298L), cnb.z(-4591320038186L));
        if (!listAg2.isEmpty()) {
            Iterator it2 = listAg2.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    z2 = false;
                    break;
                }
                if (dnj.ab(getContent(), (String) it2.next(), false)) {
                    z2 = true;
                    break;
                }
            }
        } else {
            z2 = false;
            break;
        }
        return z && z2;
    }

    public final boolean isOfficialAccount() {
        return dnr.bp(this.talker, cnb.z(-4681514351402L), false);
    }

    public final boolean isOpenIM() {
        return dnr.bi(this.talker, cnb.z(-4909147618090L));
    }

    public final boolean isPat() {
        return this.type == ewg.t.w;
    }

    public final boolean isPrivateChat() {
        Set set_cd = dgg._cd(cnb.z(-4518305594154L), cnb.z(-4535485463338L), cnb.z(-4440996182826L), cnb.z(-4462471019306L), cnb.z(-4930622454570L));
        if (!dnr.bp(this.talker, cnb.z(-4883377814314L), false) && !set_cd.isEmpty()) {
            Iterator it = set_cd.iterator();
            while (it.hasNext()) {
                if (dnj.ab(this.talker, (String) it.next(), true)) {
                    return false;
                }
            }
        }
        return true;
    }

    public final boolean isQuote() {
        return this.type == ewg.s.w;
    }

    public final boolean isRedBag() {
        int i = this.type;
        return i == ewg.o.w || i == ewg.p.w;
    }

    public final boolean isSend() {
        Integer num = this.isSendInt;
        return num != null && num.intValue() == 1;
    }

    public final Integer isSendInt() {
        return this.isSendInt;
    }

    public final boolean isShareCard() {
        return this.type == ewg.d.w;
    }

    public final boolean isSystem() {
        return this.type == ewg.j.w;
    }

    public final boolean isText() {
        return this.type == ewg.a.w;
    }

    public final boolean isTransfer() {
        return this.type == ewg.n.w;
    }

    public final boolean isVideo() {
        return this.type == ewg.e.w;
    }

    public final boolean isVideoNumberVideo() {
        return this.type == ewg.q.w;
    }

    public final boolean isVoice() {
        return this.type == ewg.c.w;
    }

    public final boolean isVoip() {
        return this.type == ewg.i.w;
    }

    public final boolean isVoipVideo() {
        return bzo.f(getContent(), cnb.z(-6283537152810L));
    }

    public final boolean isVoipVoice() {
        return bzo.f(getContent(), cnb.z(-4698694220586L));
    }

    public String toString() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(cnb.z(-6167573035818L), Long.valueOf(this.msgId));
        jSONObject.put(cnb.z(-6124623362858L), this.msgSvrId);
        jSONObject.put(cnb.z(-6085968657194L), Integer.valueOf(this.type));
        jSONObject.put(cnb.z(-6116033428266L), Boolean.valueOf(isSend()));
        jSONObject.put(cnb.z(-6068788788010L), Long.valueOf(this.createTime));
        jSONObject.put(cnb.z(-6536940223274L), this.talker);
        jSONObject.put(cnb.z(-6558415059754L), getSendTalker());
        jSONObject.put(cnb.z(-6476810681130L), getContent());
        jSONObject.put(cnb.z(-6442450942762L), this.imgPath);
        jSONObject.put(cnb.z(-6408091204394L), getMsgSource());
        jSONObject.put(cnb.z(-6382321400618L), this.talkerId);
        jSONObject.put(cnb.z(-6343666694954L), this.msgSeq);
        return jSONObject.toString();
    }

    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
    public static final class FileMsg {
        private final String ext;
        private final JSONObject json;
        private final String md5;
        private final long size;
        private final String title;

        public FileMsg(JSONObject jSONObject) {
            this.json = jSONObject;
            this.title = bjs.k(-3212635536170L, jSONObject);
            this.size = Long.parseLong(String.valueOf(jSONObject.getByPath(cnb.z(-3139621092138L))));
            this.ext = bjs.k(-2443836390186L, jSONObject);
            this.md5 = bjs.k(-2370821946154L, jSONObject);
        }

        public final String getExt() {
            return this.ext;
        }

        public final JSONObject getJson() {
            return this.json;
        }

        public final String getMd5() {
            return this.md5;
        }

        public final long getSize() {
            return this.size;
        }

        public final String getTitle() {
            return this.title;
        }

        public String toString() {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(cnb.z(-2744484100906L), this.title);
            jSONObject.put(cnb.z(-2701534427946L), Integer.valueOf(jSONObject.size()));
            jSONObject.put(cnb.z(-2662879722282L), this.ext);
            jSONObject.put(cnb.z(-2680059591466L), this.md5);
            return jSONObject.toString();
        }

        public FileMsg(String str) {
            this(dnc.e(cnb.z(-2216203123498L) + dnc.a(dnj.ay(dnj.au(str, cnb.z(-2289217567530L), str), cnb.z(-2246267894570L))) + cnb.z(-2723009264426L)));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
    public static final class PatMsg {
        private final long createTime;
        private final String fromUser;
        private final JSONObject json;
        private final String pattedUser;
        private final int readStatus;
        private final int recordNum;
        private final int showModifyTip;
        private final long svrId;
        private final String talker;
        private final String template;

        public PatMsg(JSONObject jSONObject) {
            this.json = jSONObject;
            this.talker = bjs.k(-2628519983914L, jSONObject);
            this.recordNum = Integer.parseInt(String.valueOf(jSONObject.getByPath(cnb.z(-2529735736106L))));
            this.fromUser = bjs.k(-3990024616746L, getRecordObj());
            this.pattedUser = bjs.k(-3968549780266L, getRecordObj());
            this.template = bjs.k(-3938485009194L, getRecordObj());
            this.createTime = Long.parseLong(String.valueOf(getRecordObj().getByPath(cnb.z(-3917010172714L))));
            this.readStatus = Integer.parseInt(String.valueOf(getRecordObj().getByPath(cnb.z(-4367981738794L))));
            this.svrId = Long.parseLong(String.valueOf(getRecordObj().getByPath(cnb.z(-4355096836906L))));
            this.showModifyTip = Integer.parseInt(String.valueOf(getRecordObj().getByPath(cnb.z(-4312147163946L))));
        }

        public final long getCreateTime() {
            return this.createTime;
        }

        public final String getFromUser() {
            return this.fromUser;
        }

        public final JSONObject getJson() {
            return this.json;
        }

        public final String getPattedUser() {
            return this.pattedUser;
        }

        public final int getReadStatus() {
            return this.readStatus;
        }

        public final int getRecordNum() {
            return this.recordNum;
        }

        public final JSONObject getRecordObj() {
            Object byPath = this.json.getByPath(cnb.z(-4234837752618L));
            if (byPath instanceof JSONArray) {
                return ((JSONArray) byPath).getJSONObject(0);
            }
            bzo.o(byPath, cnb.z(-3543348017962L));
            return (JSONObject) byPath;
        }

        public final int getShowModifyTip() {
            return this.showModifyTip;
        }

        public final long getSvrId() {
            return this.svrId;
        }

        public final String getTalker() {
            return this.talker;
        }

        public final String getTemplate() {
            return this.template;
        }

        public String toString() {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(cnb.z(-3843995728682L), this.talker);
            jSONObject.put(cnb.z(-3813930957610L), Integer.valueOf(this.recordNum));
            jSONObject.put(cnb.z(-3719441677098L), this.fromUser);
            jSONObject.put(cnb.z(-3680786971434L), this.pattedUser);
            jSONObject.put(cnb.z(-3667902069546L), this.template);
            jSONObject.put(cnb.z(-3629247363882L), Long.valueOf(this.createTime));
            jSONObject.put(cnb.z(-798863915818L), Integer.valueOf(this.readStatus));
            jSONObject.put(cnb.z(-768799144746L), Long.valueOf(this.svrId));
            jSONObject.put(cnb.z(-725849471786L), Integer.valueOf(this.showModifyTip));
            return jSONObject.toString();
        }

        public PatMsg(String str) {
            this(dnc.e(str));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
    public static final class QuoteMsg {
        private final String displayName;
        private final JSONObject json;
        private final String msgSource;
        private final String originContent;
        private final String sendTalker;
        private final long svrId;
        private final String talker;
        private final String title;
        private final int type;

        public QuoteMsg(JSONObject jSONObject) {
            this.json = jSONObject;
            this.title = bjs.k(-717259537194L, jSONObject);
            this.msgSource = bjs.k(-592705485610L, jSONObject);
            Long lBg = dnq.bg(String.valueOf(jSONObject.getByPath(cnb.z(-1065151888170L))));
            this.svrId = lBg != null ? lBg.longValue() : 0L;
            this.sendTalker = bjs.k(-901943130922L, jSONObject);
            this.displayName = bjs.k(-266287971114L, jSONObject);
            this.talker = bjs.k(-128849017642L, jSONObject);
            this.type = Integer.parseInt(String.valueOf(jSONObject.getByPath(cnb.z(-523986008874L))));
            this.originContent = bjs.k(-416611826474L, jSONObject);
        }

        public final String getContent() {
            int i = this.type;
            return i == ewg.a.w ? this.originContent : i == ewg.b.w ? cnb.z(-1885490641706L) : i == ewg.e.w ? cnb.z(-1838246001450L) : i == ewg.f.w ? cnb.z(-1842540968746L) : i == ewg.h.w ? bjs.k(-1795296328490L, this.json) : this.originContent;
        }

        public final String getDisplayName() {
            return this.displayName;
        }

        public final JSONObject getJson() {
            return this.json;
        }

        public final String getMsgSource() {
            return this.msgSource;
        }

        public final String getOriginContent() {
            return this.originContent;
        }

        public final String getSendTalker() {
            return this.sendTalker;
        }

        public final long getSvrId() {
            return this.svrId;
        }

        public final String getTalker() {
            return this.talker;
        }

        public final String getTitle() {
            return this.title;
        }

        public final int getType() {
            return this.type;
        }

        public String toString() {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(cnb.z(-2186138352426L), this.title);
            jSONObject.put(cnb.z(-2143188679466L), this.msgSource);
            jSONObject.put(cnb.z(-2117418875690L), Long.valueOf(this.svrId));
            jSONObject.put(cnb.z(-2074469202730L), this.sendTalker);
            jSONObject.put(cnb.z(-2061584300842L), this.displayName);
            jSONObject.put(cnb.z(-1975684954922L), this.talker);
            jSONObject.put(cnb.z(-1928440314666L), Integer.valueOf(this.type));
            jSONObject.put(cnb.z(-1958505085738L), getContent());
            return jSONObject.toString();
        }

        public QuoteMsg(String str) {
            this(dnc.e(cnb.z(-1906965478186L) + dnc.a(dnj.ay(dnj.au(str, cnb.z(-330712480554L), str), cnb.z(-287762807594L))) + cnb.z(-1864015805226L)));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
    public static final class TransferMsg {
        private final long beginTransferTime;
        private final String des;
        private final String feeDesc;
        private final int invalidTime;
        private final JSONObject json;
        private final String payerUsername;
        private final String receiverUsername;
        private final String title;
        private final String transactionId;
        private final String transferId;

        public TransferMsg(JSONObject jSONObject) {
            this.json = jSONObject;
            this.title = bjs.k(-1374389533482L, jSONObject);
            this.des = bjs.k(-1301375089450L, jSONObject);
            this.feeDesc = bjs.k(-1236950580010L, jSONObject);
            this.transactionId = bjs.k(-1627792603946L, jSONObject);
            this.transferId = bjs.k(-1511828486954L, jSONObject);
            this.invalidTime = Integer.parseInt(String.valueOf(jSONObject.getByPath(cnb.z(-7421703486250L))));
            this.beginTransferTime = Long.parseLong(String.valueOf(jSONObject.getByPath(cnb.z(-7279969565482L))));
            this.receiverUsername = bjs.k(-7662221654826L, jSONObject);
            this.payerUsername = bjs.k(-7477538061098L, jSONObject);
        }

        public final long getBeginTransferTime() {
            return this.beginTransferTime;
        }

        public final String getDes() {
            return this.des;
        }

        public final String getFeeDesc() {
            return this.feeDesc;
        }

        public final int getInvalidTime() {
            return this.invalidTime;
        }

        public final JSONObject getJson() {
            return this.json;
        }

        public final String getPayerUsername() {
            return this.payerUsername;
        }

        public final String getReceiverUsername() {
            return this.receiverUsername;
        }

        public final String getTitle() {
            return this.title;
        }

        public final String getTransactionId() {
            return this.transactionId;
        }

        public final String getTransferId() {
            return this.transferId;
        }

        public String toString() {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(cnb.z(-6644314405674L), this.title);
            jSONObject.put(cnb.z(-6601364732714L), this.des);
            jSONObject.put(cnb.z(-6618544601898L), this.feeDesc);
            jSONObject.put(cnb.z(-7133940677418L), this.transactionId);
            jSONObject.put(cnb.z(-7056631266090L), this.transferId);
            jSONObject.put(cnb.z(-7043746364202L), Integer.valueOf(this.invalidTime));
            jSONObject.put(cnb.z(-6957847018282L), Long.valueOf(this.beginTransferTime));
            jSONObject.put(cnb.z(-6897717476138L), this.receiverUsername);
            jSONObject.put(cnb.z(-8473970473770L), this.payerUsername);
            return jSONObject.toString();
        }

        public TransferMsg(String str) {
            this(dnc.e(cnb.z(-6734508718890L) + dnc.a(dnj.ay(dnj.au(str, cnb.z(-6738803686186L), str), cnb.z(-6764573489962L))) + cnb.z(-6691559045930L)));
        }
    }
}

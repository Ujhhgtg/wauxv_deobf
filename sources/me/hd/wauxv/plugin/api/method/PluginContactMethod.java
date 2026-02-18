package me.hd.wauxv.plugin.api.method;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;
import me.hd.wauxv.data.bean.info.FriendInfo;
import me.hd.wauxv.data.bean.info.GroupInfo;
import me.hd.wauxv.obf.acw;
import me.hd.wauxv.obf.acx;
import me.hd.wauxv.obf.arj;
import me.hd.wauxv.obf.avd;
import me.hd.wauxv.obf.bmy;
import me.hd.wauxv.obf.bte;
import me.hd.wauxv.obf.bym;
import me.hd.wauxv.obf.KotlinHelpers;
import me.hd.wauxv.obf.cde;
import me.hd.wauxv.obf.cdk;
import me.hd.wauxv.obf.clk;
import me.hd.wauxv.obf.cll;
import me.hd.wauxv.obf.clp;
import me.hd.wauxv.obf.clq;
import me.hd.wauxv.obf.clt;
import me.hd.wauxv.obf.clu;
import me.hd.wauxv.obf.cme;
import me.hd.wauxv.obf.cnb;
import me.hd.wauxv.obf.cty;
import me.hd.wauxv.obf.dal;
import me.hd.wauxv.obf.dkz;
import me.hd.wauxv.obf.dpv;
import me.hd.wauxv.obf.dqc;
import me.hd.wauxv.obf.emn;
import me.hd.wauxv.obf.xj;
import me.hd.wauxv.obf.xn;
import me.hd.wauxv.obf.xo;
import me.hd.wauxv.obf.xp;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class PluginContactMethod {
    @cty
    public final void addChatroomMember(String str, String str2)
            throws IllegalAccessException, InstantiationException, InvocationTargetException {
        List listBf = dqc.bf(str2);
        cll.a.getClass();
        cme.b(cme.a, emn.ba(clk.a).newInstance(str, listBf, null, null));
    }

    @cty
    public final void delChatroomMember(String str, String str2)
            throws IllegalAccessException, InstantiationException, InvocationTargetException {
        List listBf = dqc.bf(str2);
        clq.a.getClass();
        cme.b(cme.a, emn.ba(clp.a).newInstance(str, listBf, 0));
    }

    @cty
    public final String getAvatarUrl(String str) {
        bym.a.getClass();
        return bym.b(str, false);
    }

    @cty
    public final List<FriendInfo> getFriendList() {
        return bmy.s();
    }

    @cty
    public final String getFriendName(String str) {
        xj xjVar = xj.a;
        String strZ = "" /* cnb.z(-99252399242026L) */;
        xjVar.getClass();
        return xj.b(str, strZ);
    }

    @cty
    public final List<GroupInfo> getGroupList() {
        return bmy.t();
    }

    @cty
    public final int getGroupMemberCount(String str)
            throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        xp.a.getClass();
        Method methodBb = emn.bb(xo.a);
        xn.a.getClass();
        Object objInvoke = methodBb.invoke(xn.b(), str);
        throwIfVar1IsNull(objInvoke, "null cannot be cast to non-null type kotlin.Int" /* cnb.z(-380173325171498L) */);
        return ((Integer) objInvoke).intValue();
    }

    @cty
    public final List<String> getGroupMemberList(String str) {
        xp.a.getClass();
        int i = bte.a;
        xn.a.getClass();
        cde cdeVarT = dqc.bi(xn.b()).t();
        cdeVarT.a = dal.b(List.class);
        List<String> list = (List) ((cdk) dkz.n(new Object[] { dal.b(String.class) }, 1, cdeVarT)).j(str);
        return list == null ? avd.a : list;
    }

    @cty
    public final String getLoginAlias() throws IllegalAccessException, InvocationTargetException {
        acx.a.getClass();
        Object objInvoke = emn.bb(acw.a).invoke(null, null);
        throwIfVar1IsNull(objInvoke, "null cannot be cast to non-null type kotlin.collections.Map<*, *>" /*
                                                                                                          * cnb.z(-
                                                                                                          * 107949708016426L)
                                                                                                          */);
        Object obj = ((Map) objInvoke).get("last_login_alias" /* cnb.z(-109568910687018L) */);
        String str = obj instanceof String ? (String) obj : null;
        return str == null ? getLoginWxid() : str;
    }

    @cty
    public final String getLoginWxid() {
        acx.a.getClass();
        return acx.b();
    }

    @cty
    public final String getTargetTalker() {
        dpv.a.getClass();
        return dpv.b;
    }

    @cty
    public final void inviteChatroomMember(String str, String str2)
            throws IllegalAccessException, InstantiationException, InvocationTargetException {
        List listBf = dqc.bf(str2);
        clu.a.getClass();
        cme.b(cme.a, emn.ba(clt.a).newInstance(str, listBf, 0, null));
    }

    @cty
    public final void modifyContactLabelList(String str, String str2)
            throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        arj.ab(str, dqc.bf(str2));
    }

    @cty
    public final void verifyUser(String str, String str2, int i, int i2)
            throws IllegalAccessException, NoSuchMethodException, InstantiationException, InvocationTargetException {
        arj.ak(str, str2, i, i2);
    }

    @cty
    public final void modifyContactLabelList(String str, List<String> list)
            throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        arj.ab(str, list);
    }

    @cty
    public final void verifyUser(String str, String str2, int i)
            throws IllegalAccessException, NoSuchMethodException, InstantiationException, InvocationTargetException {
        arj.ak(str, str2, i, 0);
    }

    @cty
    public final String getAvatarUrl(String str, boolean z) {
        bym.a.getClass();
        return bym.b(str, z);
    }

    @cty
    public final String getFriendName(String str, String str2) {
        xj.a.getClass();
        return xj.b(str, str2);
    }

    @cty
    public final void addChatroomMember(String str, List<String> list)
            throws IllegalAccessException, InstantiationException, InvocationTargetException {
        cll.a.getClass();
        cme.b(cme.a, emn.ba(clk.a).newInstance(str, list, null, null));
    }

    @cty
    public final void delChatroomMember(String str, List<String> list)
            throws IllegalAccessException, InstantiationException, InvocationTargetException {
        clq.a.getClass();
        cme.b(cme.a, emn.ba(clp.a).newInstance(str, list, 0));
    }

    @cty
    public final void inviteChatroomMember(String str, List<String> list)
            throws IllegalAccessException, InstantiationException, InvocationTargetException {
        clu.a.getClass();
        cme.b(cme.a, emn.ba(clt.a).newInstance(str, list, 0, null));
    }
}

package me.hd.wauxv.obf;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Process;
import android.view.View;
import android.widget.LinearLayout;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import me.hd.wauxv.R;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class h implements bfu {
    public final /* synthetic */ int a;

    public /* synthetic */ h(int i) {
        this.a = i;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v0, types: [me.hd.wauxv.obf.afw] */
    /* JADX WARN: Type inference failed for: r6v1, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r6v10 */
    @Override // me.hd.wauxv.obf.bfu
    public final Object invoke() {
        String str;
        int i = this.a;
        int i2 = 2;
        ?? r6 = 0;
        int i3 = 1;
        ens ensVar = ens.a;
        switch (i) {
            case 0:
                io ioVar = emc.w;
                if (ioVar == null) {
                    throw new IllegalArgumentException("DexDescConfig must be init" /* cnb.z(-6021544147754L) */.toString());
                }
                ioVar.aj().clear();
                Thread.sleep(5000L);
                Process.killProcess(Process.myPid());
                return ensVar;
            case 1:
                io ioVar2 = cnf.ah;
                if (ioVar2 == null) {
                    throw new IllegalArgumentException("DefaultConfig must be init" /* cnb.z(-5763846109994L) */.toString());
                }
                ioVar2.aj().clear();
                Thread.sleep(5000L);
                Process.killProcess(Process.myPid());
                return ensVar;
            case 2:
                Object objB = acv.b(acv.a, eom.b.f);
                throwIfVar1IsNull(objB, "null cannot be cast to non-null type kotlin.String" /* cnb.z(-121221156961066L) */);
                return (String) objB;
            case 3:
                Object objB2 = acv.b(acv.a, eom.c.f);
                if (objB2 instanceof String) {
                    str = (String) objB2;
                }
                if (r6 == 0) {
                    r6 = str;
                    return "未填写" /* cnb.z(-121259811666730L) */;
                }
                r6 = str;
                return r6;
            case 4:
                Object objB3 = acv.b(acv.a, eom.d.f);
                String str2 = objB3 instanceof String ? (String) objB3 : null;
                return str2 == null ? "未填写" /* cnb.z(-122638496168746L) */ : str2;
            case 5:
                bw.a.r(40);
                bv.a.r(80);
                bu.a.q(0.5f);
                ca.a.p(true);
                cb.a.r(4);
                bz bzVar = bz.a;
                cf.a.getClass();
                bzVar.u((String) cf.b.getValue());
                bs.a.p(true);
                bt.a.r(4);
                br.a.u((String) cf.c.getValue());
                cd.a.p(true);
                ce.a.r(4);
                cc.a.u((String) cf.d.getValue());
                by.a.u("#FFFFFFFF" /* cnb.z(-432829624220458L) */);
                bx.a.u("#FF191919" /* cnb.z(-432735134939946L) */);
                return ensVar;
            case 6:
                return new ep(0);
            case 7:
                return Integer.valueOf(Build.VERSION.SDK_INT);
            case 8:
                Bitmap bitmapCreateBitmap = Bitmap.createBitmap(1, 1, Bitmap.Config.ARGB_8888);
                bitmapCreateBitmap.eraseColor(0);
                return bitmapCreateBitmap;
            case 9:
                File file = new File(qo.b, "icon_chats.png" /* cnb.z(-437713002036010L) */);
                if (file.exists()) {
                    return BitmapFactory.decodeFile(file.getAbsolutePath());
                }
                qo.a.getClass();
                return (Bitmap) qo.c.getValue();
            case 10:
                File file2 = new File(qo.b, "icon_contacts.png" /* cnb.z(-437648577526570L) */);
                if (file2.exists()) {
                    return BitmapFactory.decodeFile(file2.getAbsolutePath());
                }
                qo.a.getClass();
                return (Bitmap) qo.c.getValue();
            case 11:
                File file3 = new File(qo.b, "icon_discover.png" /* cnb.z(-438138203798314L) */);
                if (file3.exists()) {
                    return BitmapFactory.decodeFile(file3.getAbsolutePath());
                }
                qo.a.getClass();
                return (Bitmap) qo.c.getValue();
            case 12:
                File file4 = new File(qo.b, "icon_me.png" /* cnb.z(-438078074256170L) */);
                if (file4.exists()) {
                    return BitmapFactory.decodeFile(file4.getAbsolutePath());
                }
                qo.a.getClass();
                return (Bitmap) qo.c.getValue();
            case 13:
                qg.a.u("微信" /* cnb.z(-438017944714026L) */);
                qh.a.u("通讯" /* cnb.z(-437953520204586L) */);
                qi.a.u("发现" /* cnb.z(-437974995041066L) */);
                ql.a.u("我的" /* cnb.z(-437979290008362L) */);
                qm.a.p(true);
                qn.a.p(true);
                qk.a.p(false);
                qj.a.p(false);
                return ensVar;
            case 14:
                Bitmap bitmapCreateBitmap2 = Bitmap.createBitmap(1, 1, Bitmap.Config.ARGB_8888);
                bitmapCreateBitmap2.eraseColor(0);
                return bitmapCreateBitmap2;
            case 15:
                File file5 = new File(qw.b, "icon_chats.png" /* cnb.z(-437171836156714L) */);
                if (file5.exists()) {
                    return BitmapFactory.decodeFile(file5.getAbsolutePath());
                }
                qw.a.getClass();
                return (Bitmap) qw.c.getValue();
            case 16:
                File file6 = new File(qw.b, "icon_contacts.png" /* cnb.z(-437107411647274L) */);
                if (file6.exists()) {
                    return BitmapFactory.decodeFile(file6.getAbsolutePath());
                }
                qw.a.getClass();
                return (Bitmap) qw.c.getValue();
            case 17:
                File file7 = new File(qw.b, "icon_discover.png" /* cnb.z(-437597037919018L) */);
                if (file7.exists()) {
                    return BitmapFactory.decodeFile(file7.getAbsolutePath());
                }
                qw.a.getClass();
                return (Bitmap) qw.c.getValue();
            case 18:
                File file8 = new File(qw.b, "icon_me.png" /* cnb.z(-437536908376874L) */);
                if (file8.exists()) {
                    return BitmapFactory.decodeFile(file8.getAbsolutePath());
                }
                qw.a.getClass();
                return (Bitmap) qw.c.getValue();
            case 19:
                qr.a.u("#FFF7F7F7" /* cnb.z(-437408059357994L) */);
                qv.a.u("#FFCCE8E3" /* cnb.z(-437382289554218L) */);
                qt.a.u("#FF1E1E1E" /* cnb.z(-437356519750442L) */);
                qq.a.u("#FF1E1E1E" /* cnb.z(-436780994132778L) */);
                qu.a.u("#FF324B48" /* cnb.z(-436686504852266L) */);
                qs.a.u("#FFF7F7F7" /* cnb.z(-436660735048490L) */);
                return ensVar;
            case 20:
                vc.a.r(48);
                vf.a.r(80);
                vb.a.u("#FFF7F7F7" /* cnb.z(-576418970860330L) */);
                uw.a.u("#FFCCE8E3" /* cnb.z(-576324481579818L) */);
                uz.a.u("#FF1E1E1E" /* cnb.z(-576298711776042L) */);
                ve.a.u("#FF006A62" /* cnb.z(-576272941972266L) */);
                va.a.u("#FF1E1E1E" /* cnb.z(-576247172168490L) */);
                uv.a.u("#FF324B48" /* cnb.z(-576152682887978L) */);
                uy.a.u("#FFF7F7F7" /* cnb.z(-576676668898090L) */);
                vd.a.u("#FF81D5CB" /* cnb.z(-576650899094314L) */);
                return ensVar;
            case 21:
                vr.a.u("#FFEDEDED" /* cnb.z(-568408856853290L) */);
                vk.a.u("#FF006A62" /* cnb.z(-568314367572778L) */);
                vm.a.u("#FF161D1C" /* cnb.z(-568288597769002L) */);
                vo.a.u("#FF006A62" /* cnb.z(-568262827965226L) */);
                vq.a.u("#FF242424" /* cnb.z(-568237058161450L) */);
                vj.a.u("#FF81D5CB" /* cnb.z(-567592813067050L) */);
                vl.a.u("#FFDDE4E2" /* cnb.z(-567567043263274L) */);
                vn.a.u("#FF81D5CB" /* cnb.z(-567541273459498L) */);
                vp.a.p(false);
                return ensVar;
            case 22:
                vz.a.u("今日已发${totalMsg}条" /* cnb.z(-422908249766698L) */);
                vy.a.p(true);
                return ensVar;
            case 23:
                return xf.l;
            case 24:
                alc alcVar = aou.a;
                cnd.bf(akq.f, new lw(i2, r6, i3));
                return ensVar;
            case 25:
                alc alcVar2 = aou.a;
                cnd.bf(akq.f, new lw(i2, r6, i2));
                return ensVar;
            case 26:
                ccu ccuVar = new ccu();
                bmo.a.getClass();
                ccuVar.s = (int) (bmo.n().getResources().getDisplayMetrics().heightPixels * 0.9f);
                if (ccuVar.bl != null) {
                    ng.aj(new ccq(ccuVar, 0));
                }
                return ccuVar;
            case 27:
                bmo.a.getClass();
                View viewInflate = View.inflate(aqu.e(cnf.am(bmo.n())), R.layout.module_dialog_choose_contacts, null);
                throwIfVar1IsNull(viewInflate, "null cannot be cast to non-null type android.widget.LinearLayout" /* cnb.z(-394157738687274L) */);
                return (LinearLayout) viewInflate;
            case 28:
                bmo.a.getClass();
                return (LinearLayout) View.inflate(aqu.e(cnf.am(bmo.n())), R.layout.item_rv_contact_tab, null).findViewById(R.id.itemContactLinearLayout);
            default:
                try {
                    bmf[] bmfVarArrW = bhv.w();
                    ex exVar = new ex(i2);
                    Object[] objArrCopyOf = Arrays.copyOf(bmfVarArrW, 330);
                    throwIfVar1IsNull(objArrCopyOf, "copyOf(...)");
                    if (objArrCopyOf.length > 1) {
                        Arrays.sort(objArrCopyOf, exVar);
                    }
                    return la.a(objArrCopyOf);
                } catch (Exception e) {
                    ArrayList arrayList = ewq.a;
                    ewq.e("getAnnoHookList Failed" /* cnb.z(-22694607190826L) */, e, 12);
                    return avd.a;
                }
        }
    }
}

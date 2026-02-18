package me.hd.wauxv.obf;

import android.content.Context;
import android.content.Intent;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import com.google.android.material.checkbox.MaterialCheckBox;
import com.google.android.material.radiobutton.MaterialRadioButton;
import com.google.android.material.textfield.TextInputEditText;
import net.bytebuddy.pool.TypePool;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class bp implements bfu {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;

    public /* synthetic */ bp(Object obj, int i) {
        this.a = i;
        this.b = obj;
    }

    @Override // me.hd.wauxv.obf.bfu
    public final Object invoke() {
        switch (this.a) {
            case 0:
                ced cedVar = (ced) this.b;
                bw bwVar = bw.a;
                Integer numBf = dnq.bf(String.valueOf(cedVar.i.getText()));
                bwVar.r(numBf != null ? numBf.intValue() : 40);
                bv bvVar = bv.a;
                Integer numBf2 = dnq.bf(String.valueOf(cedVar.h.getText()));
                bvVar.r(numBf2 != null ? numBf2.intValue() : 80);
                bu buVar = bu.a;
                Float fBd = dnp.bd(String.valueOf(cedVar.g.getText()));
                buVar.q(fBd != null ? fBd.floatValue() : 0.5f);
                ca.a.p(cedVar.c.isChecked());
                cb cbVar = cb.a;
                Integer numBf3 = dnq.bf(String.valueOf(cedVar.m.getText()));
                cbVar.r(numBf3 != null ? numBf3.intValue() : 4);
                bz.a.u(String.valueOf(cedVar.l.getText()));
                bs.a.p(cedVar.b.isChecked());
                bt btVar = bt.a;
                Integer numBf4 = dnq.bf(String.valueOf(cedVar.f.getText()));
                btVar.r(numBf4 != null ? numBf4.intValue() : 4);
                br.a.u(String.valueOf(cedVar.e.getText()));
                cd.a.p(cedVar.d.isChecked());
                ce ceVar = ce.a;
                Integer numBf5 = dnq.bf(String.valueOf(cedVar.o.getText()));
                ceVar.r(numBf5 != null ? numBf5.intValue() : 4);
                cc.a.u(String.valueOf(cedVar.n.getText()));
                by.a.u(String.valueOf(cedVar.k.getText()));
                bx.a.u(String.valueOf(cedVar.j.getText()));
                return ens.a;
            case 1:
                Context context = ((RelativeLayout) this.b).getContext();
                Intent intent = new Intent();
                intent.setClassName(context, cnb.z(-94811403057962L));
                context.startActivity(intent);
                return ens.a;
            case 2:
                gg.a.u(String.valueOf(((cee) this.b).c.getText()));
                return ens.a;
            case 3:
                return cnb.ae((Object[]) this.b);
            case 4:
                cef cefVar = (cef) this.b;
                mb.a.p(cefVar.d.isChecked());
                mc.a.p(cefVar.e.isChecked());
                ma.a.p(cefVar.c.isChecked());
                return ens.a;
            case 5:
                ceg cegVar = (ceg) this.b;
                qg.a.u(String.valueOf(cegVar.c.getText()));
                qh.a.u(String.valueOf(cegVar.d.getText()));
                qi.a.u(String.valueOf(cegVar.e.getText()));
                ql.a.u(String.valueOf(cegVar.f.getText()));
                qm.a.p(((MaterialCheckBox) cegVar.i).isChecked());
                qn.a.p(((MaterialCheckBox) cegVar.j).isChecked());
                qk.a.p(((MaterialCheckBox) cegVar.h).isChecked());
                qj.a.p(((MaterialCheckBox) cegVar.g).isChecked());
                return ens.a;
            case 6:
                ceh cehVar = (ceh) this.b;
                qr.a.u(String.valueOf(cehVar.c.getText()));
                qv.a.u(String.valueOf(cehVar.g.getText()));
                qt.a.u(String.valueOf(cehVar.e.getText()));
                qq.a.u(String.valueOf(cehVar.b.getText()));
                qu.a.u(String.valueOf(cehVar.f.getText()));
                qs.a.u(String.valueOf(cehVar.d.getText()));
                return ens.a;
            case 7:
                cei ceiVar = (cei) this.b;
                vc vcVar = vc.a;
                Integer numBf6 = dnq.bf(String.valueOf(ceiVar.j.getText()));
                vcVar.r(numBf6 != null ? numBf6.intValue() : 48);
                vf vfVar = vf.a;
                Integer numBf7 = dnq.bf(String.valueOf(ceiVar.k.getText()));
                vfVar.r(numBf7 != null ? numBf7.intValue() : 80);
                vb.a.u(String.valueOf(ceiVar.g.getText()));
                uw.a.u(String.valueOf(ceiVar.c.getText()));
                uz.a.u(String.valueOf(ceiVar.e.getText()));
                ve.a.u(String.valueOf(ceiVar.i.getText()));
                va.a.u(String.valueOf(ceiVar.f.getText()));
                uv.a.u(String.valueOf(ceiVar.b.getText()));
                uy.a.u(String.valueOf(ceiVar.d.getText()));
                vd.a.u(String.valueOf(ceiVar.h.getText()));
                return ens.a;
            case 8:
                cej cejVar = (cej) this.b;
                vr.a.u(String.valueOf(cejVar.j.getText()));
                vk.a.u(String.valueOf(cejVar.d.getText()));
                vm.a.u(String.valueOf(cejVar.f.getText()));
                vo.a.u(String.valueOf(cejVar.h.getText()));
                vq.a.u(String.valueOf(cejVar.i.getText()));
                vj.a.u(String.valueOf(cejVar.c.getText()));
                vl.a.u(String.valueOf(cejVar.e.getText()));
                vn.a.u(String.valueOf(cejVar.g.getText()));
                vp.a.p(cejVar.b.isChecked());
                return ens.a;
            case 9:
                bqr bqrVar = (bqr) this.b;
                vz.a.u(String.valueOf(((TextInputEditText) bqrVar.e).getText()));
                vy.a.p(((MaterialCheckBox) bqrVar.d).isChecked());
                return ens.a;
            case 10:
                bqs bqsVar = (bqs) this.b;
                int checkedRadioButtonId = ((RadioGroup) bqsVar.f).getCheckedRadioButtonId();
                if (checkedRadioButtonId == ((MaterialRadioButton) bqsVar.d).getId()) {
                    xb.a.r(wy.a.e);
                } else if (checkedRadioButtonId == ((MaterialRadioButton) bqsVar.c).getId()) {
                    xb.a.r(wy.b.e);
                } else if (checkedRadioButtonId == ((MaterialRadioButton) bqsVar.e).getId()) {
                    xb.a.r(wy.c.e);
                }
                return ens.a;
            case 11:
                return new aml(((yu) this.b).f);
            case 12:
                cek cekVar = (cek) this.b;
                zq.a.p(cekVar.d.isChecked());
                zp.a.p(cekVar.c.isChecked());
                return ens.a;
            case 13:
                cel celVar = (cel) this.b;
                int checkedRadioButtonId2 = celVar.n.getCheckedRadioButtonId();
                if (checkedRadioButtonId2 == celVar.m.getId()) {
                    aie.a.r(aid.a.f);
                } else if (checkedRadioButtonId2 == celVar.l.getId()) {
                    aie.a.r(aid.b.f);
                } else if (checkedRadioButtonId2 == celVar.k.getId()) {
                    aie.a.r(aid.c.f);
                }
                aii aiiVar = aii.a;
                Float fBd2 = dnp.bd(String.valueOf(celVar.e.getText()));
                aiiVar.q(fBd2 != null ? fBd2.floatValue() : 0.0f);
                ail ailVar = ail.a;
                Float fBd3 = dnp.bd(String.valueOf(celVar.h.getText()));
                ailVar.q(fBd3 != null ? fBd3.floatValue() : 500.0f);
                aif aifVar = aif.a;
                Float fBd4 = dnp.bd(String.valueOf(celVar.b.getText()));
                aifVar.q(fBd4 != null ? fBd4.floatValue() : 1000.0f);
                aij aijVar = aij.a;
                Float fBd5 = dnp.bd(String.valueOf(celVar.f.getText()));
                aijVar.q(fBd5 != null ? fBd5.floatValue() : 1000.0f);
                aim aimVar = aim.a;
                Float fBd6 = dnp.bd(String.valueOf(celVar.i.getText()));
                aimVar.q(fBd6 != null ? fBd6.floatValue() : 5000.0f);
                aig aigVar = aig.a;
                Float fBd7 = dnp.bd(String.valueOf(celVar.c.getText()));
                aigVar.q(fBd7 != null ? fBd7.floatValue() : 10000.0f);
                aik aikVar = aik.a;
                Float fBd8 = dnp.bd(String.valueOf(celVar.g.getText()));
                aikVar.q(fBd8 != null ? fBd8.floatValue() : 10000.0f);
                ain ainVar = ain.a;
                Float fBd9 = dnp.bd(String.valueOf(celVar.j.getText()));
                ainVar.q(fBd9 != null ? fBd9.floatValue() : 50000.0f);
                aih aihVar = aih.a;
                Float fBd10 = dnp.bd(String.valueOf(celVar.d.getText()));
                aihVar.q(fBd10 != null ? fBd10.floatValue() : 100000.0f);
                return ens.a;
            case 14:
                cem cemVar = (cem) this.b;
                aip aipVar = aip.a;
                Integer numBf8 = dnq.bf(String.valueOf(cemVar.c.getText()));
                aipVar.r(numBf8 != null ? numBf8.intValue() : 5000);
                aiq aiqVar = aiq.a;
                Integer numBf9 = dnq.bf(String.valueOf(cemVar.d.getText()));
                aiqVar.r(numBf9 != null ? numBf9.intValue() : 1888);
                return ens.a;
            case 15:
                cee ceeVar = (cee) this.b;
                ait aitVar = ait.a;
                Integer numBf10 = dnq.bf(String.valueOf(ceeVar.c.getText()));
                aitVar.r(numBf10 != null ? numBf10.intValue() : 99);
                return ens.a;
            case 16:
                amn amnVar = (amn) this.b;
                StringBuilder sb = new StringBuilder();
                bmo.a.getClass();
                sb.append(bmo.s());
                sb.append(TypePool.Default.LazyTypeDescription.GenericTypeToken.INNER_CLASS_PATH);
                sb.append(amnVar.b);
                return sb.toString();
            case 17:
                amq amqVar = (amq) this.b;
                return "(" + aaz.k(amqVar.c, "", null, null, new amb(1), 30) + ")" + ams.h(amqVar.d);
            case 18:
                cek cekVar2 = (cek) this.b;
                aod.a.p(cekVar2.d.isChecked());
                aoc.a.p(cekVar2.c.isChecked());
                return ens.a;
            case 19:
                cen cenVar = (cen) this.b;
                int checkedRadioButtonId3 = ((RadioGroup) cenVar.m).getCheckedRadioButtonId();
                if (checkedRadioButtonId3 == ((MaterialRadioButton) cenVar.i).getId()) {
                    atw.a.r(atu.a.f);
                } else if (checkedRadioButtonId3 == ((MaterialRadioButton) cenVar.j).getId()) {
                    atw.a.r(atu.b.f);
                } else if (checkedRadioButtonId3 == ((MaterialRadioButton) cenVar.k).getId()) {
                    atw.a.r(atu.c.f);
                }
                int checkedRadioButtonId4 = ((RadioGroup) cenVar.l).getCheckedRadioButtonId();
                if (checkedRadioButtonId4 == ((MaterialRadioButton) cenVar.c).getId()) {
                    atv.a.r(atr.a.i);
                } else if (checkedRadioButtonId4 == ((MaterialRadioButton) cenVar.d).getId()) {
                    atv.a.r(atr.b.i);
                } else if (checkedRadioButtonId4 == ((MaterialRadioButton) cenVar.e).getId()) {
                    atv.a.r(atr.c.i);
                } else if (checkedRadioButtonId4 == ((MaterialRadioButton) cenVar.f).getId()) {
                    atv.a.r(atr.d.i);
                } else if (checkedRadioButtonId4 == ((MaterialRadioButton) cenVar.g).getId()) {
                    atv.a.r(atr.e.i);
                } else if (checkedRadioButtonId4 == ((MaterialRadioButton) cenVar.h).getId()) {
                    atv.a.r(atr.f.i);
                }
                return ens.a;
            case 20:
                ceo ceoVar = (ceo) this.b;
                bbg.a.u(String.valueOf(ceoVar.d.getText()));
                bbi.a.u(String.valueOf(ceoVar.f.getText()));
                bbf.a.u(String.valueOf(ceoVar.c.getText()));
                bbh.a.u(String.valueOf(ceoVar.e.getText()));
                return ens.a;
            case 21:
                bqs bqsVar2 = (bqs) this.b;
                bct.a.u(String.valueOf(((TextInputEditText) bqsVar2.c).getText()));
                if (((MaterialRadioButton) bqsVar2.e).isChecked()) {
                    bcs.a.r(bcr.a.e);
                } else if (((MaterialRadioButton) bqsVar2.d).isChecked()) {
                    bcs.a.r(bcr.b.e);
                } else if (((MaterialRadioButton) bqsVar2.f).isChecked()) {
                    bcs.a.r(bcr.c.e);
                }
                return ens.a;
            case 22:
                cep cepVar = (cep) this.b;
                bjh.a.u(String.valueOf(cepVar.k.getText()));
                bji.a.u(String.valueOf(cepVar.l.getText()));
                bjj.a.u(String.valueOf(cepVar.m.getText()));
                biy.a.u(String.valueOf(cepVar.b.getText()));
                biz.a.u(String.valueOf(cepVar.c.getText()));
                bja.a.u(String.valueOf(cepVar.d.getText()));
                bjb.a.u(String.valueOf(cepVar.e.getText()));
                bjc.a.u(String.valueOf(cepVar.f.getText()));
                bjd.a.u(String.valueOf(cepVar.g.getText()));
                bje.a.u(String.valueOf(cepVar.h.getText()));
                bjf.a.u(String.valueOf(cepVar.i.getText()));
                bjg.a.u(String.valueOf(cepVar.j.getText()));
                return ens.a;
            case 23:
                cem cemVar2 = (cem) this.b;
                bjv.a.u(String.valueOf(cemVar2.c.getText()));
                bjw.a.u(String.valueOf(cemVar2.d.getText()));
                return ens.a;
            case 24:
                bld.a.t(aaz.ad(dnj.as(String.valueOf(((cee) this.b).c.getText()), new String[]{cnb.z(-463053309082410L)})));
                return ens.a;
            case 25:
                cek cekVar3 = (cek) this.b;
                bli.a.p(cekVar3.c.isChecked());
                blj.a.p(cekVar3.d.isChecked());
                return ens.a;
            case 26:
                return ((Context) this.b).getFilesDir().getAbsolutePath() + cnb.z(-5781025979178L);
            case 27:
                return new amq(((cdf) this.b).f);
            case 28:
                ceo ceoVar2 = (ceo) this.b;
                cfj.a.u(String.valueOf(ceoVar2.d.getText()));
                cfl.a.u(String.valueOf(ceoVar2.f.getText()));
                cfi.a.u(String.valueOf(ceoVar2.c.getText()));
                cfk.a.u(String.valueOf(ceoVar2.e.getText()));
                return ens.a;
            default:
                ceg cegVar2 = (ceg) this.b;
                cfp.a.u(String.valueOf(cegVar2.e.getText()));
                cfq.a.u(String.valueOf(cegVar2.f.getText()));
                cft.a.u(String.valueOf(((TextInputEditText) cegVar2.i).getText()));
                cfu.a.u(String.valueOf(((TextInputEditText) cegVar2.j).getText()));
                cfn.a.u(String.valueOf(cegVar2.c.getText()));
                cfo.a.u(String.valueOf(cegVar2.d.getText()));
                cfr.a.u(String.valueOf(((TextInputEditText) cegVar2.g).getText()));
                cfs.a.u(String.valueOf(((TextInputEditText) cegVar2.h).getText()));
                return ens.a;
        }
    }
}

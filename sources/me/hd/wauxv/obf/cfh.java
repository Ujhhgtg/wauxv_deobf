package me.hd.wauxv.obf;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;
import android.os.Process;
import java.io.File;
import java.util.Arrays;
import me.hd.wauxv.ui.fragment.policy.PolicyFragment;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class cfh implements bfu {
    public final /* synthetic */ int a;

    public /* synthetic */ cfh(int i) {
        this.a = i;
    }

    @Override // me.hd.wauxv.obf.bfu
    public final Object invoke() {
        int i = this.a;
        int i2 = 3;
        ens ensVar = ens.a;
        switch (i) {
            case 0:
                Bitmap bitmapCreateBitmap = Bitmap.createBitmap(1, 1, Bitmap.Config.ARGB_8888);
                bitmapCreateBitmap.eraseColor(0);
                return bitmapCreateBitmap;
            case 1:
                File file = new File(cfm.b, cnb.z(-451585746402090L));
                if (file.exists()) {
                    return BitmapFactory.decodeFile(file.getAbsolutePath());
                }
                cfm.a.getClass();
                return (Bitmap) cfm.c.getValue();
            case 2:
                File file2 = new File(cfm.b, cnb.z(-451469782285098L));
                if (file2.exists()) {
                    return BitmapFactory.decodeFile(file2.getAbsolutePath());
                }
                cfm.a.getClass();
                return (Bitmap) cfm.c.getValue();
            case 3:
                cfj.a.u(cnb.z(-451366703069994L));
                cfl.a.u(cnb.z(-451890689080106L));
                cfi.a.u(cnb.z(-451864919276330L));
                cfk.a.u(cnb.z(-451770429995818L));
                return ensVar;
            case 4:
                cfp.a.u(cnb.z(-449549931903786L));
                cfq.a.u(cnb.z(-449524162100010L));
                cft.a.u(cnb.z(-449429672819498L));
                cfu.a.u(cnb.z(-448854147201834L));
                cfn.a.u(cnb.z(-448828377398058L));
                cfo.a.u(cnb.z(-448802607594282L));
                cfr.a.u(cnb.z(-448708118313770L));
                cfs.a.u(cnb.z(-448682348509994L));
                return ensVar;
            case 5:
                cfz.a.u(cnb.z(-468623881665322L));
                cga.a.u(cnb.z(-468546572253994L));
                return ensVar;
            case 6:
                cgk.a.u(cnb.z(-467399815985962L));
                cgl.a.u(cnb.z(-467374046182186L));
                cgg.a.u(cnb.z(-467348276378410L));
                cgh.a.u(cnb.z(-467322506574634L));
                cgp.a.u(cnb.z(-467777773108010L));
                cgq.a.u(cnb.z(-467717643565866L));
                cgj.a.r(64);
                cgm.a.r(64);
                cgi.a.r(10);
                cgn.a.p(true);
                cgo.a.p(true);
                return ensVar;
            case 7:
                dnc.g(null, 3, cnb.z(-524630255205162L));
                ewz.aq(cha.a, new cgu(4));
                return ensVar;
            case 8:
                dnc.g(null, 3, cnb.z(-524948082785066L));
                ewz.aq(cha.a, new cgu(i2));
                return ensVar;
            case 9:
                che.a.u(cnb.z(-450095392750378L));
                chg.a.u(cnb.z(-450069622946602L));
                chd.a.u(cnb.z(-450043853142826L));
                chf.a.u(cnb.z(-455996677815082L));
                return ensVar;
            case 10:
                return new deq();
            case 11:
                bpg bpgVar = new bpg(0);
                bpgVar.b(dal.b(cip.class), new cgu(11));
                return bpgVar.c();
            case 12:
                return new ko(cnt.b);
            case 13:
                dnt dntVar = dnt.n;
                dfx[] dfxVarArr = new dfx[0];
                if (dnj.ak("kotlin.Unit")) {
                    throw new IllegalArgumentException("Blank serial names are prohibited");
                }
                if (dntVar.equals(dnt.a)) {
                    throw new IllegalArgumentException("For StructureKind.CLASS please use 'buildClassSerialDescriptor' instead");
                }
                zd zdVar = new zd("kotlin.Unit");
                return new dfz("kotlin.Unit", dntVar, zdVar.b.size(), la.ab(dfxVarArr), zdVar);
            case 14:
                String strZ = cnb.z(-512926469323562L);
                String strZ2 = cnb.z(-512956534094634L);
                String strZ3 = cnb.z(-512952239127338L);
                bpo bpoVar = new bpo();
                bht bhtVar = anj.a;
                bpoVar.m = true;
                bpoVar.bf = strZ;
                bpoVar.bg = strZ2;
                bpoVar.bh = strZ3;
                bpoVar.bk = new df(5);
                bpoVar.bm();
                return ensVar;
            case 15:
                return Environment.getExternalStorageDirectory().getAbsolutePath();
            case 16:
                StringBuilder sb = new StringBuilder();
                yg.u(sb, (String) ctf.a.getValue(), -47841640708906L);
                bmo.a.getClass();
                sb.append(bmo.p());
                return sb.toString();
            case 17:
                cbm cbmVar = PolicyFragment.a;
                return cnb.z(-407592396389162L);
            case 18:
                cbm cbmVar2 = PolicyFragment.a;
                System.exit(0);
                throw new RuntimeException(cnb.z(-419403556453162L));
            case 19:
                System.exit(0);
                throw new RuntimeException(cnb.z(-419888887757610L));
            case 20:
                Process.killProcess(Process.myPid());
                return ensVar;
            case 21:
                cxk.a.u(cnb.z(-457667420093226L));
                cxj.a.u(cnb.z(-457637355322154L));
                return ensVar;
            case 22:
                des.a.u(cnb.z(-515658068523818L));
                det.a.u(cnb.z(-515589349047082L));
                return ensVar;
            case 23:
                int i3 = bte.a;
                adt adtVarM = dqc.bh(ajn.ag(cnb.z(-458655262571306L))).m();
                adtVarM.z(Arrays.copyOf(new Object[]{dal.b(Integer.TYPE), dal.b(String.class)}, 2));
                return (adu) aaz.e(adtVarM.a());
            case 24:
                dip.a.u(diq.b);
                return ensVar;
            case 25:
                djf.a.u(cnb.z(-532352606403370L));
                djg.a.u(cnb.z(-532232347319082L));
                dje.a.p(false);
                return ensVar;
            case 26:
                dkf.a.u(cnb.z(-561811787086634L));
                dkg.a.u(cnb.z(-561695822969642L));
                return ensVar;
            case 27:
                return new ko(dtt.b);
            case 28:
                return new ko(eif.b);
            default:
                return new ko(dul.b);
        }
    }

    public /* synthetic */ cfh(bzm bzmVar) {
        this.a = 13;
    }
}

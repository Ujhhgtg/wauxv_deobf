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
public final /* synthetic */ class Function1$VarIsInt$2 implements IFunction0 {
    public final /* synthetic */ int a;

    public /* synthetic */ Function1$VarIsInt$2(int i) {
        this.a = i;
    }

    @Override // me.hd.wauxv.obf.bfu
    public final Object invoke() {
        int i = this.a;
        int i2 = 3;
        Kotlin$Unit kotlinUnitVar = Kotlin$Unit.INSTANCE;
        switch (i) {
            case 0:
                Bitmap bitmapCreateBitmap = Bitmap.createBitmap(1, 1, Bitmap.Config.ARGB_8888);
                bitmapCreateBitmap.eraseColor(0);
                return bitmapCreateBitmap;
            case 1:
                File file = new File(cfm.b, "right_bubble.9.png" /* "right_bubble.9.png" /* "right_bubble.9.png" /* "right_bubble.9.png" /* cnb.z(-451585746402090L)   */);
                if (file.exists()) {
                    return BitmapFactory.decodeFile(file.getAbsolutePath());
                }
                cfm.a.getClass();
                return (Bitmap) cfm.c.getValue();
            case 2:
                File file2 = new File(cfm.b, "left_bubble.9.png" /* "left_bubble.9.png" /* "left_bubble.9.png" /* "left_bubble.9.png" /* cnb.z(-451469782285098L)   */);
                if (file2.exists()) {
                    return BitmapFactory.decodeFile(file2.getAbsolutePath());
                }
                cfm.a.getClass();
                return (Bitmap) cfm.c.getValue();
            case 3:
                cfj.a.u("#00000000" /* "#00000000" /* "#00000000" /* "#00000000" /* cnb.z(-451366703069994L)   */);
                cfl.a.u("#00000000" /* "#00000000" /* "#00000000" /* "#00000000" /* cnb.z(-451890689080106L)   */);
                cfi.a.u("#00000000" /* "#00000000" /* "#00000000" /* "#00000000" /* cnb.z(-451864919276330L)   */);
                cfk.a.u("#00000000" /* "#00000000" /* "#00000000" /* "#00000000" /* cnb.z(-451770429995818L)   */);
                return kotlinUnitVar;
            case 4:
                cfp.a.u("#FFE4E9FC" /* "#FFE4E9FC" /* "#FFE4E9FC" /* "#FFE4E9FC" /* cnb.z(-449549931903786L)   */);
                cfq.a.u("#11000000" /* "#11000000" /* "#11000000" /* "#11000000" /* cnb.z(-449524162100010L)   */);
                cft.a.u("#FFD7FAE4" /* "#FFD7FAE4" /* "#FFD7FAE4" /* "#FFD7FAE4" /* cnb.z(-449429672819498L)   */);
                cfu.a.u("#11000000" /* "#11000000" /* "#11000000" /* "#11000000" /* cnb.z(-448854147201834L)   */);
                cfn.a.u("#FF3D3D3D" /* "#FF3D3D3D" /* "#FF3D3D3D" /* "#FF3D3D3D" /* cnb.z(-448828377398058L)   */);
                cfo.a.u("#11000000" /* "#11000000" /* "#11000000" /* "#11000000" /* cnb.z(-448802607594282L)   */);
                cfr.a.u("#FFD7FAE4" /* "#FFD7FAE4" /* "#FFD7FAE4" /* "#FFD7FAE4" /* cnb.z(-448708118313770L)   */);
                cfs.a.u("#11000000" /* "#11000000" /* "#11000000" /* "#11000000" /* cnb.z(-448682348509994L)   */);
                return kotlinUnitVar;
            case 5:
                cfz.a.u("${sendText}喵~" /* "${sendText}喵~" /* "${sendText}喵~" /* "${sendText}喵~" /* cnb.z(-468623881665322L)   */);
                cga.a.u("HH:mm:ss" /* "HH:mm:ss" /* "HH:mm:ss" /* "HH:mm:ss" /* cnb.z(-468546572253994L)   */);
                return kotlinUnitVar;
            case 6:
                cgk.a.u("#11000000" /* "#11000000" /* "#11000000" /* "#11000000" /* cnb.z(-467399815985962L)   */);
                cgl.a.u("#FFFFFFFF" /* "#FFFFFFFF" /* "#FFFFFFFF" /* "#FFFFFFFF" /* cnb.z(-467374046182186L)   */);
                cgg.a.u("#11FFFFFF" /* "#11FFFFFF" /* "#11FFFFFF" /* "#11FFFFFF" /* cnb.z(-467348276378410L)   */);
                cgh.a.u("#FFFFFFFF" /* "#FFFFFFFF" /* "#FFFFFFFF" /* "#FFFFFFFF" /* cnb.z(-467322506574634L)   */);
                cgp.a.u("${time} | ${type}" /* "${time} | ${type}" /* "${time} | ${type}" /* "${time} | ${type}" /* cnb.z(-467777773108010L)   */);
                cgq.a.u("HH:mm:ss" /* "HH:mm:ss" /* "HH:mm:ss" /* "HH:mm:ss" /* cnb.z(-467717643565866L)   */);
                cgj.a.r(64);
                cgm.a.r(64);
                cgi.a.r(10);
                cgn.a.p(true);
                cgo.a.p(true);
                return kotlinUnitVar;
            case 7:
                dnc.sendToast(null, 3, "隐藏中" /* "隐藏中" /* "隐藏中" /* "隐藏中" /* cnb.z(-524630255205162L)   */);
                StaticAndroidHelpers.runOnUiThread(cha.a, new cgu(4));
                return kotlinUnitVar;
            case 8:
                dnc.sendToast(null, 3, "显示中" /* "显示中" /* "显示中" /* "显示中" /* cnb.z(-524948082785066L)   */);
                StaticAndroidHelpers.runOnUiThread(cha.a, new cgu(i2));
                return kotlinUnitVar;
            case 9:
                che.a.u("#FF000000" /* "#FF000000" /* "#FF000000" /* "#FF000000" /* cnb.z(-450095392750378L)   */);
                chg.a.u("#FF000000" /* "#FF000000" /* "#FF000000" /* "#FF000000" /* cnb.z(-450069622946602L)   */);
                chd.a.u("#FFFFFFFF" /* "#FFFFFFFF" /* "#FFFFFFFF" /* "#FFFFFFFF" /* cnb.z(-450043853142826L)   */);
                chf.a.u("#FF000000" /* "#FF000000" /* "#FF000000" /* "#FF000000" /* cnb.z(-455996677815082L)   */);
                return kotlinUnitVar;
            case 10:
                return new deq();
            case 11:
                bpg bpgVar = new bpg(0);
                bpgVar.b(dal.getKClassFromClass(cip.class), new cgu(11));
                return bpgVar.c();
            case 12:
                return new ko(cnt.b);
            case 13:
                dnt dntVar = dnt.n;
                dfx[] dfxVarArr = new dfx[0];
                if (StringsKt.isBlank("kotlin.Unit")) {
                    throw new IllegalArgumentException("Blank serial names are prohibited");
                }
                if (dntVar.equals(dnt.a)) {
                    throw new IllegalArgumentException("For StructureKind.CLASS please use 'buildClassSerialDescriptor' instead");
                }
                zd zdVar = new zd("kotlin.Unit");
                return new dfz("kotlin.Unit", dntVar, zdVar.b.size(), SomeStaticHelpers.arrayToList(dfxVarArr), zdVar);
            case 14:
                String strZ = "打开详情" /* "打开详情" /* "打开详情" /* "打开详情" /* cnb.z(-512926469323562L)   */;
                String strZ2 = "" /* "" /* "" /* "" /* cnb.z(-512956534094634L)   */;
                String strZ3 = "确定" /* "确定" /* "确定" /* "确定" /* cnb.z(-512952239127338L)   */;
                bpo bpoVar = new bpo();
                ResourcesCompat resourcesCompatVar = anj.a;
                bpoVar.m = true;
                bpoVar.bf = strZ;
                bpoVar.bg = strZ2;
                bpoVar.bh = strZ3;
                bpoVar.bk = new df(5);
                bpoVar.bm();
                return kotlinUnitVar;
            case 15:
                return Environment.getExternalStorageDirectory().getAbsolutePath();
            case 16:
                StringBuilder sb = new StringBuilder();
                sb.append((String) PathUtils.externalStorageRoot.getValue());
                sb.append("/Android/media/");
                sb.append(HostInfoRegistry.getPackageName());
                return sb.toString();
            case 17:
                cbm cbmVar = PolicyFragment.a;
                return "<html>\n<body>\n<h3>关于模块</h3>\n<p>（1）在使用过程中<font color=\"red\">可能存在封号风险</font></p>\n<p>（2）本模块是<font color=\"red\">免费软件</font>，如果您是购买的，请投诉卖家并要求退款</p>\n<p>（3）本模块<font color=\"red\">仅供学习交流</font>，请勿在<font color=\"red\">国内相关平台</font>宣传，请勿用于<font color=\"red\">任何非法及商业盈利</font>用途</p>\n<p>（4）请于<font color=\"red\">24小时内</font>删除相关模块资源，无论是安装包、本地应用亦或者是其他形式的数据</p>\n<p>（5）对于违反相关规定而产生的任何法律后果，一概与开发者无关，用户需自行承担全部责任</p>\n<br>\n\n<h3>免责事由</h3>\n<p>您知悉并同意，我们不因下述任一情况而可能导致的任何损害赔偿承担责任：</p>\n<p>（1）使用模块期间造成的账号封禁；</p>\n<p>（2）对本模块进行<font color=\"red\">逆向工程</font>，触发相关校验所导致的<font color=\"red\">社会性死亡、存储数据丢失、微信账号封禁</font>，您应当独立承担责任；</p>\n<br>\n\n<h3>其它条款</h3>\n<p>您知悉并同意以下条款：</p>\n<p>（1）我们有权在必要时修改本协议条款。本协议条款变更后，如果您继续使用本应用，即视为您已同意修改后的协议。如果您不同意修改后的协议，应当立即停止使用本应用；</p>\n<p>（2）本协议所有的条款标题仅为阅读方便，本身并无实际含义，不能作为本协议涵义解释的依据；</p>\n<p>（3）我们保留对于本协议的最终解释权。</p>\n<br>\n\n<h3>隐私政策</h3>\n<p>本模块包括第三方的产品和服务，当您使用这些产品和服务时，可能收集您的信息。目前我们接入的第三方SDK声明如下：</p>\n<p> - 友盟同欣（北京）科技有限公司</p>\n<p>（1）SDK名称：友盟SDK</p>\n<p>（2）服务类型：移动统计与性能监控</p>\n<p>（3）收集类型：设备信息、位置信息、网络信息</p>\n<p>（4）政策链接：<a href=\"https://www.umeng.com/page/policy\">https://www.umeng.com/page/policy</a></p>\n<br>\n\n<h4>如果您同意以上协议，请点击下方“已同意并重启”按钮。</h4>\n</body>\n</html>" /* "<html>\n<body>\n<h3>关于模块</h3>\n<p>（1）在使用过程中<font color=\"red\">可能存在封号风险</font></p>\n<p>（2）本模块是<font color=\"red\">免费软件</font>，如果您是购买的，请投诉卖家并要求退款</p>\n<p>（3）本模块<font color=\"red\">仅供学习交流</font>，请勿在<font color=\"red\">国内相关平台</font>宣传，请勿用于<font color=\"red\">任何非法及商业盈利</font>用途</p>\n<p>（4）请于<font color=\"red\">24小时内</font>删除相关模块资源，无论是安装包、本地应用亦或者是其他形式的数据</p>\n<p>（5）对于违反相关规定而产生的任何法律后果，一概与开发者无关，用户需自行承担全部责任</p>\n<br>\n\n<h3>免责事由</h3>\n<p>您知悉并同意，我们不因下述任一情况而可能导致的任何损害赔偿承担责任：</p>\n<p>（1）使用模块期间造成的账号封禁；</p>\n<p>（2）对本模块进行<font color=\"red\">逆向工程</font>，触发相关校验所导致的<font color=\"red\">社会性死亡、存储数据丢失、微信账号封禁</font>，您应当独立承担责任；</p>\n<br>\n\n<h3>其它条款</h3>\n<p>您知悉并同意以下条款：</p>\n<p>（1）我们有权在必要时修改本协议条款。本协议条款变更后，如果您继续使用本应用，即视为您已同意修改后的协议。如果您不同意修改后的协议，应当立即停止使用本应用；</p>\n<p>（2）本协议所有的条款标题仅为阅读方便，本身并无实际含义，不能作为本协议涵义解释的依据；</p>\n<p>（3）我们保留对于本协议的最终解释权。</p>\n<br>\n\n<h3>隐私政策</h3>\n<p>本模块包括第三方的产品和服务，当您使用这些产品和服务时，可能收集您的信息。目前我们接入的第三方SDK声明如下：</p>\n<p> - 友盟同欣（北京）科技有限公司</p>\n<p>（1）SDK名称：友盟SDK</p>\n<p>（2）服务类型：移动统计与性能监控</p>\n<p>（3）收集类型：设备信息、位置信息、网络信息</p>\n<p>（4）政策链接：<a href=\"https://www.umeng.com/page/policy\">https://www.umeng.com/page/policy</a></p>\n<br>\n\n<h4>如果您同意以上协议，请点击下方“已同意并重启”按钮。</h4>\n</body>\n</html>" /* "<html>\n<body>\n<h3>关于模块</h3>\n<p>（1）在使用过程中<font color=\"red\">可能存在封号风险</font></p>\n<p>（2）本模块是<font color=\"red\">免费软件</font>，如果您是购买的，请投诉卖家并要求退款</p>\n<p>（3）本模块<font color=\"red\">仅供学习交流</font>，请勿在<font color=\"red\">国内相关平台</font>宣传，请勿用于<font color=\"red\">任何非法及商业盈利</font>用途</p>\n<p>（4）请于<font color=\"red\">24小时内</font>删除相关模块资源，无论是安装包、本地应用亦或者是其他形式的数据</p>\n<p>（5）对于违反相关规定而产生的任何法律后果，一概与开发者无关，用户需自行承担全部责任</p>\n<br>\n\n<h3>免责事由</h3>\n<p>您知悉并同意，我们不因下述任一情况而可能导致的任何损害赔偿承担责任：</p>\n<p>（1）使用模块期间造成的账号封禁；</p>\n<p>（2）对本模块进行<font color=\"red\">逆向工程</font>，触发相关校验所导致的<font color=\"red\">社会性死亡、存储数据丢失、微信账号封禁</font>，您应当独立承担责任；</p>\n<br>\n\n<h3>其它条款</h3>\n<p>您知悉并同意以下条款：</p>\n<p>（1）我们有权在必要时修改本协议条款。本协议条款变更后，如果您继续使用本应用，即视为您已同意修改后的协议。如果您不同意修改后的协议，应当立即停止使用本应用；</p>\n<p>（2）本协议所有的条款标题仅为阅读方便，本身并无实际含义，不能作为本协议涵义解释的依据；</p>\n<p>（3）我们保留对于本协议的最终解释权。</p>\n<br>\n\n<h3>隐私政策</h3>\n<p>本模块包括第三方的产品和服务，当您使用这些产品和服务时，可能收集您的信息。目前我们接入的第三方SDK声明如下：</p>\n<p> - 友盟同欣（北京）科技有限公司</p>\n<p>（1）SDK名称：友盟SDK</p>\n<p>（2）服务类型：移动统计与性能监控</p>\n<p>（3）收集类型：设备信息、位置信息、网络信息</p>\n<p>（4）政策链接：<a href=\"https://www.umeng.com/page/policy\">https://www.umeng.com/page/policy</a></p>\n<br>\n\n<h4>如果您同意以上协议，请点击下方“已同意并重启”按钮。</h4>\n</body>\n</html>" /* "<html>\n<body>\n<h3>关于模块</h3>\n<p>（1）在使用过程中<font color=\"red\">可能存在封号风险</font></p>\n<p>（2）本模块是<font color=\"red\">免费软件</font>，如果您是购买的，请投诉卖家并要求退款</p>\n<p>（3）本模块<font color=\"red\">仅供学习交流</font>，请勿在<font color=\"red\">国内相关平台</font>宣传，请勿用于<font color=\"red\">任何非法及商业盈利</font>用途</p>\n<p>（4）请于<font color=\"red\">24小时内</font>删除相关模块资源，无论是安装包、本地应用亦或者是其他形式的数据</p>\n<p>（5）对于违反相关规定而产生的任何法律后果，一概与开发者无关，用户需自行承担全部责任</p>\n<br>\n\n<h3>免责事由</h3>\n<p>您知悉并同意，我们不因下述任一情况而可能导致的任何损害赔偿承担责任：</p>\n<p>（1）使用模块期间造成的账号封禁；</p>\n<p>（2）对本模块进行<font color=\"red\">逆向工程</font>，触发相关校验所导致的<font color=\"red\">社会性死亡、存储数据丢失、微信账号封禁</font>，您应当独立承担责任；</p>\n<br>\n\n<h3>其它条款</h3>\n<p>您知悉并同意以下条款：</p>\n<p>（1）我们有权在必要时修改本协议条款。本协议条款变更后，如果您继续使用本应用，即视为您已同意修改后的协议。如果您不同意修改后的协议，应当立即停止使用本应用；</p>\n<p>（2）本协议所有的条款标题仅为阅读方便，本身并无实际含义，不能作为本协议涵义解释的依据；</p>\n<p>（3）我们保留对于本协议的最终解释权。</p>\n<br>\n\n<h3>隐私政策</h3>\n<p>本模块包括第三方的产品和服务，当您使用这些产品和服务时，可能收集您的信息。目前我们接入的第三方SDK声明如下：</p>\n<p> - 友盟同欣（北京）科技有限公司</p>\n<p>（1）SDK名称：友盟SDK</p>\n<p>（2）服务类型：移动统计与性能监控</p>\n<p>（3）收集类型：设备信息、位置信息、网络信息</p>\n<p>（4）政策链接：<a href=\"https://www.umeng.com/page/policy\">https://www.umeng.com/page/policy</a></p>\n<br>\n\n<h4>如果您同意以上协议，请点击下方“已同意并重启”按钮。</h4>\n</body>\n</html>" /* cnb.z(-407592396389162L)   */;
            case 18:
                cbm cbmVar2 = PolicyFragment.a;
                System.exit(0);
                throw new RuntimeException("System.exit returned normally, while it was supposed to halt JVM." /* "System.exit returned normally, while it was supposed to halt JVM." /* "System.exit returned normally, while it was supposed to halt JVM." /* "System.exit returned normally, while it was supposed to halt JVM." /* cnb.z(-419403556453162L)   */);
            case 19:
                System.exit(0);
                throw new RuntimeException("System.exit returned normally, while it was supposed to halt JVM." /* "System.exit returned normally, while it was supposed to halt JVM." /* "System.exit returned normally, while it was supposed to halt JVM." /* "System.exit returned normally, while it was supposed to halt JVM." /* cnb.z(-419888887757610L)   */);
            case 20:
                Process.killProcess(Process.myPid());
                return kotlinUnitVar;
            case 21:
                cxk.a.u("[有人回我]" /* "[有人回我]" /* "[有人回我]" /* "[有人回我]" /* cnb.z(-457667420093226L)   */);
                cxj.a.u("#FFE14949" /* "#FFE14949" /* "#FFE14949" /* "#FFE14949" /* cnb.z(-457637355322154L)   */);
                return kotlinUnitVar;
            case 22:
                des.a.u("${time} ${nick}" /* "${time} ${nick}" /* "${time} ${nick}" /* "${time} ${nick}" /* cnb.z(-515658068523818L)   */);
                det.a.u("yyyy-MM-dd" /* "yyyy-MM-dd" /* "yyyy-MM-dd" /* "yyyy-MM-dd" /* cnb.z(-515589349047082L)   */);
                return kotlinUnitVar;
            case 23:
                int i3 = 0;
                adt adtVarM = dqc.bh(ajn.tryGetClassByClassName("com.tencent.mm.storage.emotion.SmileyPanelConfigInfo" /* "com.tencent.mm.storage.emotion.SmileyPanelConfigInfo" /* "com.tencent.mm.storage.emotion.SmileyPanelConfigInfo" /* "com.tencent.mm.storage.emotion.SmileyPanelConfigInfo" /* cnb.z(-458655262571306L)   */)).m();
                adtVarM.setParams(Arrays.copyOf(new Object[]{dal.getKClassFromClass(Integer.TYPE), dal.getKClassFromClass(String.class)}, 2));
                return (ConstructorHookWrapper) StaticHelpers5.safeGetFirstInList(adtVarM.a());
            case 24:
                dip.a.u(diq.b);
                return kotlinUnitVar;
            case 25:
                djf.a.u("${originalText} | ${time} | ${type}" /* "${originalText} | ${time} | ${type}" /* "${originalText} | ${time} | ${type}" /* "${originalText} | ${time} | ${type}" /* cnb.z(-532352606403370L)   */);
                djg.a.u("HH:mm:ss" /* "HH:mm:ss" /* "HH:mm:ss" /* "HH:mm:ss" /* cnb.z(-532232347319082L)   */);
                dje.a.p(false);
                return kotlinUnitVar;
            case 26:
                dkf.a.u("wx8dd6ecd81906fd84" /* "wx8dd6ecd81906fd84" /* "wx8dd6ecd81906fd84" /* "wx8dd6ecd81906fd84" /* cnb.z(-561811787086634L)   */);
                dkg.a.u("网抑云音乐" /* "网抑云音乐" /* "网抑云音乐" /* "网抑云音乐" /* cnb.z(-561695822969642L)   */);
                return kotlinUnitVar;
            case 27:
                return new ko(dtt.b);
            case 28:
                return new ko(eif.b);
            default:
                return new ko(dul.b);
        }
    }

    public /* synthetic */ Function1$VarIsInt$2(bzm bzmVar) {
        this.a = 13;
    }
}

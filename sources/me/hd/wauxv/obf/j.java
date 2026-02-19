package me.hd.wauxv.obf;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import me.hd.wauxv.R;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class j extends bdo {
    public final bdc a;
    public final bdc b;

    public j() {
        super(i.a);
        final int i = 0;
        this.a = da(new dq(this) { // from class: me.hd.wauxv.obf.g
            public final /* synthetic */ j b;

            {
                this.b = this;
            }

            @Override // me.hd.wauxv.obf.dq
            public final void c(Object obj) {
                switch (i) {
                    case 0:
                        j jVar = this.b;
                        Uri uri = (Uri) obj;
                        if (uri == null) {
                            return;
                        }
                        try {
                            OutputStream outputStreamOpenOutputStream = jVar.dc().getContentResolver()
                                    .openOutputStream(uri);
                            if (outputStreamOpenOutputStream != null) {
                                try {
                                    cnf.ba(outputStreamOpenOutputStream);
                                    dnc.g(null, 3, "导出成功" /* "导出成功" /* "导出成功" /* cnb.z(-415873093335850L)  */);
                                    outputStreamOpenOutputStream.close();
                                    return;
                                } catch (Throwable th) {
                                    try {
                                        throw th;
                                    } catch (Throwable th2) {
                                        cnh.m(outputStreamOpenOutputStream, th);
                                        throw th2;
                                    }
                                }
                            }
                            return;
                        } catch (Exception unused) {
                            dnc.g(null, 3, "导出失败" /* "导出失败" /* "导出失败" /* cnb.z(-415885978237738L)  */);
                            return;
                        }
                    default:
                        j jVar2 = this.b;
                        Uri uri2 = (Uri) obj;
                        if (uri2 == null) {
                            return;
                        }
                        try {
                            InputStream inputStreamOpenInputStream = jVar2.dc().getContentResolver()
                                    .openInputStream(uri2);
                            if (inputStreamOpenInputStream != null) {
                                try {
                                    cnf.bg(inputStreamOpenInputStream);
                                    dnc.g(null, 3, "导入成功" /* "导入成功" /* "导入成功" /* cnb.z(-415847323532074L)  */);
                                    inputStreamOpenInputStream.close();
                                    return;
                                } catch (Throwable th3) {
                                    try {
                                        throw th3;
                                    } catch (Throwable th4) {
                                        cnh.m(inputStreamOpenInputStream, th3);
                                        throw th4;
                                    }
                                }
                            }
                            return;
                        } catch (Exception unused2) {
                            dnc.g(null, 3, "导入失败" /* "导入失败" /* "导入失败" /* cnb.z(-415791488957226L)  */);
                            return;
                        }
                }
            }
        }, new dr("application/zip" /* "application/zip" /* "application/zip" /* cnb.z(-392439751768874L)  */));
        final int i2 = 1;
        this.b = da(new dq(this) { // from class: me.hd.wauxv.obf.g
            public final /* synthetic */ j b;

            {
                this.b = this;
            }

            @Override // me.hd.wauxv.obf.dq
            public final void c(Object obj) {
                switch (i2) {
                    case 0:
                        j jVar = this.b;
                        Uri uri = (Uri) obj;
                        if (uri == null) {
                            return;
                        }
                        try {
                            OutputStream outputStreamOpenOutputStream = jVar.dc().getContentResolver()
                                    .openOutputStream(uri);
                            if (outputStreamOpenOutputStream != null) {
                                try {
                                    cnf.ba(outputStreamOpenOutputStream);
                                    dnc.g(null, 3, "导出成功" /* "导出成功" /* "导出成功" /* cnb.z(-415873093335850L)  */);
                                    outputStreamOpenOutputStream.close();
                                    return;
                                } catch (Throwable th) {
                                    try {
                                        throw th;
                                    } catch (Throwable th2) {
                                        cnh.m(outputStreamOpenOutputStream, th);
                                        throw th2;
                                    }
                                }
                            }
                            return;
                        } catch (Exception unused) {
                            dnc.g(null, 3, "导出失败" /* "导出失败" /* "导出失败" /* cnb.z(-415885978237738L)  */);
                            return;
                        }
                    default:
                        j jVar2 = this.b;
                        Uri uri2 = (Uri) obj;
                        if (uri2 == null) {
                            return;
                        }
                        try {
                            InputStream inputStreamOpenInputStream = jVar2.dc().getContentResolver()
                                    .openInputStream(uri2);
                            if (inputStreamOpenInputStream != null) {
                                try {
                                    cnf.bg(inputStreamOpenInputStream);
                                    dnc.g(null, 3, "导入成功" /* "导入成功" /* "导入成功" /* cnb.z(-415847323532074L)  */);
                                    inputStreamOpenInputStream.close();
                                    return;
                                } catch (Throwable th3) {
                                    try {
                                        throw th3;
                                    } catch (Throwable th4) {
                                        cnh.m(inputStreamOpenInputStream, th3);
                                        throw th4;
                                    }
                                }
                            }
                            return;
                        } catch (Exception unused2) {
                            dnc.g(null, 3, "导入失败" /* "导入失败" /* "导入失败" /* cnb.z(-415791488957226L)  */);
                            return;
                        }
                }
            }
        }, new ds(0));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // me.hd.wauxv.obf.bdj
    public final void k(View view) {
        eqj eqjVar = this.d;
        throwIfVar1IsNull(eqjVar);
        final RecyclerView recyclerView = ((bdk) eqjVar).b;
        dc();
        final int i = 1;
        recyclerView.setLayoutManager(new LinearLayoutManager(1));
        final int i2 = 4;
        final int i3 = 2;
        final int i4 = 0;
        List listAg = OtherStaticHelpers.argsToList(new nz("WAuxiliary" /* "WAuxiliary" /* "WAuxiliary" /* cnb.z(-392371032292138L)  */),
                new ny("愿每个人都被这世界温柔以待" /* "愿每个人都被这世界温柔以待" /* "愿每个人都被这世界温柔以待" /* cnb.z(-392340967521066L)  */, ":)" /* ":)" /* ":)" /* cnb.z(-392263658109738L)  */, null, i2));
        nz nzVar = new nz("我的" /* "我的" /* "我的" /* cnb.z(-392285132946218L)  */);
        String strZ = "使用天数" /* "使用天数" /* "使用天数" /* cnb.z(-391670952622890L)  */;
        StringBuilder sb = new StringBuilder();
        eop.a.getClass();
        sb.append(eoo.a.k());
        sb.append((char) 22825);
        ArrayList arrayListO = aaz.o(listAg, OtherStaticHelpers.argsToList(nzVar, new ny(strZ, sb.toString(), 0 == true ? 1 : 0, i2)));
        nz nzVar2 = new nz("版本" /* "版本" /* "版本" /* cnb.z(-391701017393962L)  */);
        ny nyVar = new ny("模块版本" /* "模块版本" /* "模块版本" /* cnb.z(-391636592884522L)  */, "1.2.6.r1238.198c77c(1238)" /*
                                                                                              * "1.2.6.r1238.198c77c(1238)" /* "1.2.6.r1238.198c77c(1238)" /* cnb.z(-391666657655594L)  */
                                                                                              */, new d(i4));
        ny nyVar2 = new ny("编译时间" /* "编译时间" /* "编译时间" /* cnb.z(-391503448898346L)  */, exl.c, new d(i));
        String strZ2 = "宿主版本" /* "宿主版本" /* "宿主版本" /* cnb.z(-391516333800234L)  */;
        bmo.a.getClass();
        final int i5 = 3;
        final int i6 = 10;
        final int i7 = 11;
        final int i8 = 12;
        ArrayList arrayListO2 = aaz
                .o(aaz.o(aaz.o(arrayListO, OtherStaticHelpers.argsToList(nzVar2, nyVar, nyVar2, new ny(strZ2, bmo.s(), new d(i3)))),
                        OtherStaticHelpers.argsToList(new nz("隐私与协议" /* "隐私与协议" /* "隐私与协议" /* cnb.z(-391477679094570L)  */),
                                new ny("用户协议" /* "用户协议" /* "用户协议" /* cnb.z(-391434729421610L)  */, 0 == true ? 1 : 0,
                                        new View.OnClickListener(this) { // from class: me.hd.wauxv.obf.e
                                            public final /* synthetic */ j b;

                                            {
                                                this.b = this;
                                            }

                                            @Override // android.view.View.OnClickListener
                                            public final void onClick(View view2) {
                                                switch (i6) {
                                                    case 0:
                                                        cnh.ac(this.b.dc(),
                                                                "https://github.com/BetterAndroid/Hikage" /*
                                                                                                           * cnb.z(-
                                                                                                           * 413446436813610L)
                                                                                                           */);
                                                        break;
                                                    case 1:
                                                        cnh.ac(this.b.dc(), "https://github.com/LuckyPray/DexKit" /*
                                                                                                                   * cnb
                                                                                                                   * .z(
                                                                                                                   * -
                                                                                                                   * 413824393935658L)
                                                                                                                   */);
                                                        break;
                                                    case 2:
                                                        cnh.ac(this.b.dc(), "https://github.com/cinit/QAuxiliary" /*
                                                                                                                   * cnb
                                                                                                                   * .z(
                                                                                                                   * -
                                                                                                                   * 415284682816298L)
                                                                                                                   */);
                                                        break;
                                                    case 3:
                                                        cnh.ac(this.b.dc(), "https://github.com/suzhelan/TimTool" /*
                                                                                                                   * cnb
                                                                                                                   * .z(
                                                                                                                   * -
                                                                                                                   * 415164423732010L)
                                                                                                                   */);
                                                        break;
                                                    case 4:
                                                        cnh.ac(this.b.dc(), "https://github.com/fankes/TSBattery" /*
                                                                                                                   * cnb
                                                                                                                   * .z(
                                                                                                                   * -
                                                                                                                   * 415525200984874L)
                                                                                                                   */);
                                                        break;
                                                    case 5:
                                                        cnh.ac(this.b.dc(),
                                                                "https://github.com/KitsunePie/QQCleaner" /*
                                                                                                           * cnb.z(-
                                                                                                           * 415404941900586L)
                                                                                                           */);
                                                        break;
                                                    case 6:
                                                        cnh.ac(this.b.dc(), "https://github.com/LSPosed/LSPosed" /*
                                                                                                                  * cnb.
                                                                                                                  * z(-
                                                                                                                  * 414683387394858L)
                                                                                                                  */);
                                                        break;
                                                    case 7:
                                                        cnh.ac(this.b.dc(),
                                                                "https://github.com/Rosemoe/sora-editor" /*
                                                                                                          * cnb.z(-
                                                                                                          * 415048459615018L)
                                                                                                          */);
                                                        break;
                                                    case 8:
                                                        cnh.ac(this.b.dc(), "https://github.com/Lagrio" /*
                                                                                                         * cnb.z(-
                                                                                                         * 414863776021290L)
                                                                                                         */);
                                                        break;
                                                    case 9:
                                                        cnh.ac(this.b.dc(),
                                                                "https://github.com/HdShare/WAuxiliary_Public" /*
                                                                                                                * cnb.z(
                                                                                                                * -
                                                                                                                * 417556720515882L)
                                                                                                                */);
                                                        break;
                                                    case 10:
                                                        KotlinHelpers2.ar(this.b).j(R.id.policyFragment,
                                                                bht.r(new Pair(
                                                                        "showOnly" /* "showOnly" /* "showOnly" /* cnb.z(-415645460069162L)  */,
                                                                        Boolean.TRUE)));
                                                        break;
                                                    case 11:
                                                        this.b.a.a("wauxv_config.zip" /* "wauxv_config.zip" /* "wauxv_config.zip" /* cnb.z(-417376331889450L)  */);
                                                        break;
                                                    case 12:
                                                        this.b.b.a("application/zip" /* "application/zip" /* "application/zip" /* cnb.z(-417303317445418L)  */);
                                                        break;
                                                    case 13:
                                                        cnh.ac(this.b.dc(), "https://t.me/Hd_WAuxiliary_CI" /*
                                                                                                             * cnb.z(-
                                                                                                             * 417784353782570L)
                                                                                                             */);
                                                        break;
                                                    case 14:
                                                        cnh.ac(this.b.dc(), "https://t.me/Hd_WAuxiliary" /*
                                                                                                          * cnb.z(-
                                                                                                          * 417707044371242L)
                                                                                                          */);
                                                        break;
                                                    case 15:
                                                        cnh.ac(this.b.dc(),
                                                                "https://github.com/HdShare/WAuxiliary_Plugin" /*
                                                                                                                * cnb.z(
                                                                                                                * -
                                                                                                                * 416848050912042L)
                                                                                                                */);
                                                        break;
                                                    case 16:
                                                        api apiVar = api.a;
                                                        Context contextDc = this.b.dc();
                                                        String strZ3 = "m02krT/t'4E_$jgJt=2LKNe" /*
                                                                                                  * cnb.z(-
                                                                                                  * 417187353328426L)
                                                                                                  */;
                                                        apiVar.getClass();
                                                        api.tryGetClassByName(contextDc, strZ3);
                                                        break;
                                                    case 17:
                                                        cnh.ac(this.b.dc(), "https://afdian.com/a/hdshare" /*
                                                                                                            * cnb.z(-
                                                                                                            * 417084274113322L)
                                                                                                            */);
                                                        break;
                                                    case 18:
                                                        api apiVar2 = api.a;
                                                        Context contextDc2 = this.b.dc();
                                                        String strZ4 = "m0eZ$'Q@C9@1WK:'#+D~Bw" /*
                                                                                                 * cnb.z(-
                                                                                                 * 414176581253930L)
                                                                                                 */;
                                                        apiVar2.getClass();
                                                        api.tryGetClassByName(contextDc2, strZ4);
                                                        break;
                                                    case 19:
                                                        cnh.ac(this.b.dc(), "https://afdian.com/a/suzhelan" /*
                                                                                                             * cnb.z(-
                                                                                                             * 414077797006122L)
                                                                                                             */);
                                                        break;
                                                    case 20:
                                                        cnh.ac(this.b.dc(),
                                                                "https://github.com/HighCapable/YukiHookAPI" /*
                                                                                                              * cnb.z(-
                                                                                                              * 414000487594794L)
                                                                                                              */);
                                                        break;
                                                    case 21:
                                                        cnh.ac(this.b.dc(),
                                                                "https://github.com/HighCapable/KavaRef" /*
                                                                                                          * cnb.z(-
                                                                                                          * 414314020207402L)
                                                                                                          */);
                                                        break;
                                                    default:
                                                        cnh.ac(this.b.dc(),
                                                                "https://github.com/BetterAndroid/BetterAndroid" /*
                                                                                                                  * cnb.
                                                                                                                  * z(-
                                                                                                                  * 413596760668970L)
                                                                                                                  */);
                                                        break;
                                                }
                                            }
                                        }, i3))),
                        OtherStaticHelpers.argsToList(new nz("缓存与配置" /* "缓存与配置" /* "缓存与配置" /* cnb.z(-391447614323498L)  */), new ny(
                                "清除缓存" /* "清除缓存" /* "清除缓存" /* cnb.z(-391954420464426L)  */, 0 == true ? 1 : 0, new View.OnClickListener() { // from
                                                                                                                       // class:
                                                                                                                       // me.hd.wauxv.obf.f
                                    @Override // android.view.View.OnClickListener
                                    public final void onClick(View view2) {
                                        switch (i4) {
                                            case 0:
                                                bzy bzyVar = new bzy(recyclerView.getContext());
                                                String strZ3 = "提示" /* "提示" /* "提示" /* cnb.z(-416105021569834L)  */;
                                                eg egVar = (eg) bzyVar.d;
                                                egVar.d = strZ3;
                                                String strZ4 = "确定要清除模块缓存, 并重新开始适配数据?\n点击确定后请等待5秒并手动重启" /*
                                                                                                         * cnb.z(-
                                                                                                         * 416109316537130L)
                                                                                                         */;
                                                bmo.a.getClass();
                                                egVar.f = strZ4.concat(bmo.o());
                                                bzyVar.t("确定" /* "确定" /* "确定" /* cnb.z(-415928927910698L)  */, new amw(new h(0), 0));
                                                bzyVar.r("取消" /* "取消" /* "取消" /* cnb.z(-47455093652266L)  */,
                                                        new amw((3 & 2) != 0 ? new amd(1) : null, 1));
                                                bzyVar.i().show();
                                                break;
                                            default:
                                                bzy bzyVar2 = new bzy(recyclerView.getContext());
                                                String strZ5 = "提示" /* "提示" /* "提示" /* cnb.z(-415950402747178L)  */;
                                                eg egVar2 = (eg) bzyVar2.d;
                                                egVar2.d = strZ5;
                                                String strZ6 = "确定要清空模块配置, 包括功能开启状态等?\n点击确定后请等待5秒并手动重启" /*
                                                                                                         * cnb.z(-
                                                                                                         * 415954697714474L)
                                                                                                         */;
                                                bmo.a.getClass();
                                                egVar2.f = strZ6.concat(bmo.o());
                                                bzyVar2.t("确定" /* "确定" /* "确定" /* cnb.z(-417423576529706L)  */, new amw(new h(1), 0));
                                                bzyVar2.r("取消" /* "取消" /* "取消" /* cnb.z(-47455093652266L)  */,
                                                        new amw((3 & 2) != 0 ? new amd(1) : null, 1));
                                                bzyVar2.i().show();
                                                break;
                                        }
                                    }
                                }, i3), new ny("清空配置" /* "清空配置" /* "清空配置" /* cnb.z(-391915765758762L)  */, 0 == true ? 1 : 0,
                                        new View.OnClickListener() { // from class: me.hd.wauxv.obf.f
                                            @Override // android.view.View.OnClickListener
                                            public final void onClick(View view2) {
                                                switch (i) {
                                                    case 0:
                                                        bzy bzyVar = new bzy(recyclerView.getContext());
                                                        String strZ3 = "提示" /* "提示" /* "提示" /* cnb.z(-416105021569834L)  */;
                                                        eg egVar = (eg) bzyVar.d;
                                                        egVar.d = strZ3;
                                                        String strZ4 = "确定要清除模块缓存, 并重新开始适配数据?\n点击确定后请等待5秒并手动重启" /*
                                                                                                                 * cnb.z
                                                                                                                 * (-
                                                                                                                 * 416109316537130L)
                                                                                                                 */;
                                                        bmo.a.getClass();
                                                        egVar.f = strZ4.concat(bmo.o());
                                                        bzyVar.t("确定" /* "确定" /* "确定" /* cnb.z(-415928927910698L)  */,
                                                                new amw(new h(0), 0));
                                                        bzyVar.r("取消" /* "取消" /* "取消" /* cnb.z(-47455093652266L)  */,
                                                                new amw((3 & 2) != 0 ? new amd(1) : null, 1));
                                                        bzyVar.i().show();
                                                        break;
                                                    default:
                                                        bzy bzyVar2 = new bzy(recyclerView.getContext());
                                                        String strZ5 = "提示" /* "提示" /* "提示" /* cnb.z(-415950402747178L)  */;
                                                        eg egVar2 = (eg) bzyVar2.d;
                                                        egVar2.d = strZ5;
                                                        String strZ6 = "确定要清空模块配置, 包括功能开启状态等?\n点击确定后请等待5秒并手动重启" /*
                                                                                                                 * cnb.z
                                                                                                                 * (-
                                                                                                                 * 415954697714474L)
                                                                                                                 */;
                                                        bmo.a.getClass();
                                                        egVar2.f = strZ6.concat(bmo.o());
                                                        bzyVar2.t("确定" /* "确定" /* "确定" /* cnb.z(-417423576529706L)  */,
                                                                new amw(new h(1), 0));
                                                        bzyVar2.r("取消" /* "取消" /* "取消" /* cnb.z(-47455093652266L)  */,
                                                                new amw((3 & 2) != 0 ? new amd(1) : null, 1));
                                                        bzyVar2.i().show();
                                                        break;
                                                }
                                            }
                                        }, i3),
                                new ny("导出缓存配置" /* "导出缓存配置" /* "导出缓存配置" /* cnb.z(-391928650660650L)  */, 0 == true ? 1 : 0,
                                        new View.OnClickListener(this) { // from class: me.hd.wauxv.obf.e
                                            public final /* synthetic */ j b;

                                            {
                                                this.b = this;
                                            }

                                            @Override // android.view.View.OnClickListener
                                            public final void onClick(View view2) {
                                                switch (i7) {
                                                    case 0:
                                                        cnh.ac(this.b.dc(),
                                                                "https://github.com/BetterAndroid/Hikage" /*
                                                                                                           * cnb.z(-
                                                                                                           * 413446436813610L)
                                                                                                           */);
                                                        break;
                                                    case 1:
                                                        cnh.ac(this.b.dc(), "https://github.com/LuckyPray/DexKit" /*
                                                                                                                   * cnb
                                                                                                                   * .z(
                                                                                                                   * -
                                                                                                                   * 413824393935658L)
                                                                                                                   */);
                                                        break;
                                                    case 2:
                                                        cnh.ac(this.b.dc(), "https://github.com/cinit/QAuxiliary" /*
                                                                                                                   * cnb
                                                                                                                   * .z(
                                                                                                                   * -
                                                                                                                   * 415284682816298L)
                                                                                                                   */);
                                                        break;
                                                    case 3:
                                                        cnh.ac(this.b.dc(), "https://github.com/suzhelan/TimTool" /*
                                                                                                                   * cnb
                                                                                                                   * .z(
                                                                                                                   * -
                                                                                                                   * 415164423732010L)
                                                                                                                   */);
                                                        break;
                                                    case 4:
                                                        cnh.ac(this.b.dc(), "https://github.com/fankes/TSBattery" /*
                                                                                                                   * cnb
                                                                                                                   * .z(
                                                                                                                   * -
                                                                                                                   * 415525200984874L)
                                                                                                                   */);
                                                        break;
                                                    case 5:
                                                        cnh.ac(this.b.dc(),
                                                                "https://github.com/KitsunePie/QQCleaner" /*
                                                                                                           * cnb.z(-
                                                                                                           * 415404941900586L)
                                                                                                           */);
                                                        break;
                                                    case 6:
                                                        cnh.ac(this.b.dc(), "https://github.com/LSPosed/LSPosed" /*
                                                                                                                  * cnb.
                                                                                                                  * z(-
                                                                                                                  * 414683387394858L)
                                                                                                                  */);
                                                        break;
                                                    case 7:
                                                        cnh.ac(this.b.dc(),
                                                                "https://github.com/Rosemoe/sora-editor" /*
                                                                                                          * cnb.z(-
                                                                                                          * 415048459615018L)
                                                                                                          */);
                                                        break;
                                                    case 8:
                                                        cnh.ac(this.b.dc(), "https://github.com/Lagrio" /*
                                                                                                         * cnb.z(-
                                                                                                         * 414863776021290L)
                                                                                                         */);
                                                        break;
                                                    case 9:
                                                        cnh.ac(this.b.dc(),
                                                                "https://github.com/HdShare/WAuxiliary_Public" /*
                                                                                                                * cnb.z(
                                                                                                                * -
                                                                                                                * 417556720515882L)
                                                                                                                */);
                                                        break;
                                                    case 10:
                                                        KotlinHelpers2.ar(this.b).j(R.id.policyFragment,
                                                                bht.r(new Pair(
                                                                        "showOnly" /* "showOnly" /* "showOnly" /* cnb.z(-415645460069162L)  */,
                                                                        Boolean.TRUE)));
                                                        break;
                                                    case 11:
                                                        this.b.a.a("wauxv_config.zip" /* "wauxv_config.zip" /* "wauxv_config.zip" /* cnb.z(-417376331889450L)  */);
                                                        break;
                                                    case 12:
                                                        this.b.b.a("application/zip" /* "application/zip" /* "application/zip" /* cnb.z(-417303317445418L)  */);
                                                        break;
                                                    case 13:
                                                        cnh.ac(this.b.dc(), "https://t.me/Hd_WAuxiliary_CI" /*
                                                                                                             * cnb.z(-
                                                                                                             * 417784353782570L)
                                                                                                             */);
                                                        break;
                                                    case 14:
                                                        cnh.ac(this.b.dc(), "https://t.me/Hd_WAuxiliary" /*
                                                                                                          * cnb.z(-
                                                                                                          * 417707044371242L)
                                                                                                          */);
                                                        break;
                                                    case 15:
                                                        cnh.ac(this.b.dc(),
                                                                "https://github.com/HdShare/WAuxiliary_Plugin" /*
                                                                                                                * cnb.z(
                                                                                                                * -
                                                                                                                * 416848050912042L)
                                                                                                                */);
                                                        break;
                                                    case 16:
                                                        api apiVar = api.a;
                                                        Context contextDc = this.b.dc();
                                                        String strZ3 = "m02krT/t'4E_$jgJt=2LKNe" /*
                                                                                                  * cnb.z(-
                                                                                                  * 417187353328426L)
                                                                                                  */;
                                                        apiVar.getClass();
                                                        api.tryGetClassByName(contextDc, strZ3);
                                                        break;
                                                    case 17:
                                                        cnh.ac(this.b.dc(), "https://afdian.com/a/hdshare" /*
                                                                                                            * cnb.z(-
                                                                                                            * 417084274113322L)
                                                                                                            */);
                                                        break;
                                                    case 18:
                                                        api apiVar2 = api.a;
                                                        Context contextDc2 = this.b.dc();
                                                        String strZ4 = "m0eZ$'Q@C9@1WK:'#+D~Bw" /*
                                                                                                 * cnb.z(-
                                                                                                 * 414176581253930L)
                                                                                                 */;
                                                        apiVar2.getClass();
                                                        api.tryGetClassByName(contextDc2, strZ4);
                                                        break;
                                                    case 19:
                                                        cnh.ac(this.b.dc(), "https://afdian.com/a/suzhelan" /*
                                                                                                             * cnb.z(-
                                                                                                             * 414077797006122L)
                                                                                                             */);
                                                        break;
                                                    case 20:
                                                        cnh.ac(this.b.dc(),
                                                                "https://github.com/HighCapable/YukiHookAPI" /*
                                                                                                              * cnb.z(-
                                                                                                              * 414000487594794L)
                                                                                                              */);
                                                        break;
                                                    case 21:
                                                        cnh.ac(this.b.dc(),
                                                                "https://github.com/HighCapable/KavaRef" /*
                                                                                                          * cnb.z(-
                                                                                                          * 414314020207402L)
                                                                                                          */);
                                                        break;
                                                    default:
                                                        cnh.ac(this.b.dc(),
                                                                "https://github.com/BetterAndroid/BetterAndroid" /*
                                                                                                                  * cnb.
                                                                                                                  * z(-
                                                                                                                  * 413596760668970L)
                                                                                                                  */);
                                                        break;
                                                }
                                            }
                                        }, i3),
                                new ny("导入缓存配置" /* "导入缓存配置" /* "导入缓存配置" /* cnb.z(-391898585889578L)  */, 0 == true ? 1 : 0,
                                        new View.OnClickListener(this) { // from class: me.hd.wauxv.obf.e
                                            public final /* synthetic */ j b;

                                            {
                                                this.b = this;
                                            }

                                            @Override // android.view.View.OnClickListener
                                            public final void onClick(View view2) {
                                                switch (i8) {
                                                    case 0:
                                                        cnh.ac(this.b.dc(),
                                                                "https://github.com/BetterAndroid/Hikage" /*
                                                                                                           * cnb.z(-
                                                                                                           * 413446436813610L)
                                                                                                           */);
                                                        break;
                                                    case 1:
                                                        cnh.ac(this.b.dc(), "https://github.com/LuckyPray/DexKit" /*
                                                                                                                   * cnb
                                                                                                                   * .z(
                                                                                                                   * -
                                                                                                                   * 413824393935658L)
                                                                                                                   */);
                                                        break;
                                                    case 2:
                                                        cnh.ac(this.b.dc(), "https://github.com/cinit/QAuxiliary" /*
                                                                                                                   * cnb
                                                                                                                   * .z(
                                                                                                                   * -
                                                                                                                   * 415284682816298L)
                                                                                                                   */);
                                                        break;
                                                    case 3:
                                                        cnh.ac(this.b.dc(), "https://github.com/suzhelan/TimTool" /*
                                                                                                                   * cnb
                                                                                                                   * .z(
                                                                                                                   * -
                                                                                                                   * 415164423732010L)
                                                                                                                   */);
                                                        break;
                                                    case 4:
                                                        cnh.ac(this.b.dc(), "https://github.com/fankes/TSBattery" /*
                                                                                                                   * cnb
                                                                                                                   * .z(
                                                                                                                   * -
                                                                                                                   * 415525200984874L)
                                                                                                                   */);
                                                        break;
                                                    case 5:
                                                        cnh.ac(this.b.dc(),
                                                                "https://github.com/KitsunePie/QQCleaner" /*
                                                                                                           * cnb.z(-
                                                                                                           * 415404941900586L)
                                                                                                           */);
                                                        break;
                                                    case 6:
                                                        cnh.ac(this.b.dc(), "https://github.com/LSPosed/LSPosed" /*
                                                                                                                  * cnb.
                                                                                                                  * z(-
                                                                                                                  * 414683387394858L)
                                                                                                                  */);
                                                        break;
                                                    case 7:
                                                        cnh.ac(this.b.dc(),
                                                                "https://github.com/Rosemoe/sora-editor" /*
                                                                                                          * cnb.z(-
                                                                                                          * 415048459615018L)
                                                                                                          */);
                                                        break;
                                                    case 8:
                                                        cnh.ac(this.b.dc(), "https://github.com/Lagrio" /*
                                                                                                         * cnb.z(-
                                                                                                         * 414863776021290L)
                                                                                                         */);
                                                        break;
                                                    case 9:
                                                        cnh.ac(this.b.dc(),
                                                                "https://github.com/HdShare/WAuxiliary_Public" /*
                                                                                                                * cnb.z(
                                                                                                                * -
                                                                                                                * 417556720515882L)
                                                                                                                */);
                                                        break;
                                                    case 10:
                                                        KotlinHelpers2.ar(this.b).j(R.id.policyFragment,
                                                                bht.r(new Pair(
                                                                        "showOnly" /* "showOnly" /* "showOnly" /* cnb.z(-415645460069162L)  */,
                                                                        Boolean.TRUE)));
                                                        break;
                                                    case 11:
                                                        this.b.a.a("wauxv_config.zip" /* "wauxv_config.zip" /* "wauxv_config.zip" /* cnb.z(-417376331889450L)  */);
                                                        break;
                                                    case 12:
                                                        this.b.b.a("application/zip" /* "application/zip" /* "application/zip" /* cnb.z(-417303317445418L)  */);
                                                        break;
                                                    case 13:
                                                        cnh.ac(this.b.dc(), "https://t.me/Hd_WAuxiliary_CI" /*
                                                                                                             * cnb.z(-
                                                                                                             * 417784353782570L)
                                                                                                             */);
                                                        break;
                                                    case 14:
                                                        cnh.ac(this.b.dc(), "https://t.me/Hd_WAuxiliary" /*
                                                                                                          * cnb.z(-
                                                                                                          * 417707044371242L)
                                                                                                          */);
                                                        break;
                                                    case 15:
                                                        cnh.ac(this.b.dc(),
                                                                "https://github.com/HdShare/WAuxiliary_Plugin" /*
                                                                                                                * cnb.z(
                                                                                                                * -
                                                                                                                * 416848050912042L)
                                                                                                                */);
                                                        break;
                                                    case 16:
                                                        api apiVar = api.a;
                                                        Context contextDc = this.b.dc();
                                                        String strZ3 = "m02krT/t'4E_$jgJt=2LKNe" /*
                                                                                                  * cnb.z(-
                                                                                                  * 417187353328426L)
                                                                                                  */;
                                                        apiVar.getClass();
                                                        api.tryGetClassByName(contextDc, strZ3);
                                                        break;
                                                    case 17:
                                                        cnh.ac(this.b.dc(), "https://afdian.com/a/hdshare" /*
                                                                                                            * cnb.z(-
                                                                                                            * 417084274113322L)
                                                                                                            */);
                                                        break;
                                                    case 18:
                                                        api apiVar2 = api.a;
                                                        Context contextDc2 = this.b.dc();
                                                        String strZ4 = "m0eZ$'Q@C9@1WK:'#+D~Bw" /*
                                                                                                 * cnb.z(-
                                                                                                 * 414176581253930L)
                                                                                                 */;
                                                        apiVar2.getClass();
                                                        api.tryGetClassByName(contextDc2, strZ4);
                                                        break;
                                                    case 19:
                                                        cnh.ac(this.b.dc(), "https://afdian.com/a/suzhelan" /*
                                                                                                             * cnb.z(-
                                                                                                             * 414077797006122L)
                                                                                                             */);
                                                        break;
                                                    case 20:
                                                        cnh.ac(this.b.dc(),
                                                                "https://github.com/HighCapable/YukiHookAPI" /*
                                                                                                              * cnb.z(-
                                                                                                              * 414000487594794L)
                                                                                                              */);
                                                        break;
                                                    case 21:
                                                        cnh.ac(this.b.dc(),
                                                                "https://github.com/HighCapable/KavaRef" /*
                                                                                                          * cnb.z(-
                                                                                                          * 414314020207402L)
                                                                                                          */);
                                                        break;
                                                    default:
                                                        cnh.ac(this.b.dc(),
                                                                "https://github.com/BetterAndroid/BetterAndroid" /*
                                                                                                                  * cnb.
                                                                                                                  * z(-
                                                                                                                  * 413596760668970L)
                                                                                                                  */);
                                                        break;
                                                }
                                            }
                                        }, i3)));
        final int i9 = 13;
        final int i10 = 14;
        ArrayList arrayListO3 = aaz.o(arrayListO2,
                OtherStaticHelpers.argsToList(new nz("群组" /* "群组" /* "群组" /* cnb.z(-391851341249322L)  */),
                        new ny("Telegram Channel" /* "Telegram Channel" /* "Telegram Channel" /* cnb.z(-391872816085802L)  */,
                                "Hd_WAuxiliary_CI" /* "Hd_WAuxiliary_CI" /* "Hd_WAuxiliary_CI" /* cnb.z(-391799801641770L)  */, new View.OnClickListener(this) { // from
                                                                                                                    // class:
                                                                                                                    // me.hd.wauxv.obf.e
                                    public final /* synthetic */ j b;

                                    {
                                        this.b = this;
                                    }

                                    @Override // android.view.View.OnClickListener
                                    public final void onClick(View view2) {
                                        switch (i9) {
                                            case 0:
                                                cnh.ac(this.b.dc(), "https://github.com/BetterAndroid/Hikage" /*
                                                                                                               * cnb.z(-
                                                                                                               * 413446436813610L)
                                                                                                               */);
                                                break;
                                            case 1:
                                                cnh.ac(this.b.dc(), "https://github.com/LuckyPray/DexKit" /*
                                                                                                           * cnb.z(-
                                                                                                           * 413824393935658L)
                                                                                                           */);
                                                break;
                                            case 2:
                                                cnh.ac(this.b.dc(), "https://github.com/cinit/QAuxiliary" /*
                                                                                                           * cnb.z(-
                                                                                                           * 415284682816298L)
                                                                                                           */);
                                                break;
                                            case 3:
                                                cnh.ac(this.b.dc(), "https://github.com/suzhelan/TimTool" /*
                                                                                                           * cnb.z(-
                                                                                                           * 415164423732010L)
                                                                                                           */);
                                                break;
                                            case 4:
                                                cnh.ac(this.b.dc(), "https://github.com/fankes/TSBattery" /*
                                                                                                           * cnb.z(-
                                                                                                           * 415525200984874L)
                                                                                                           */);
                                                break;
                                            case 5:
                                                cnh.ac(this.b.dc(), "https://github.com/KitsunePie/QQCleaner" /*
                                                                                                               * cnb.z(-
                                                                                                               * 415404941900586L)
                                                                                                               */);
                                                break;
                                            case 6:
                                                cnh.ac(this.b.dc(), "https://github.com/LSPosed/LSPosed" /*
                                                                                                          * cnb.z(-
                                                                                                          * 414683387394858L)
                                                                                                          */);
                                                break;
                                            case 7:
                                                cnh.ac(this.b.dc(), "https://github.com/Rosemoe/sora-editor" /*
                                                                                                              * cnb.z(-
                                                                                                              * 415048459615018L)
                                                                                                              */);
                                                break;
                                            case 8:
                                                cnh.ac(this.b.dc(), "https://github.com/Lagrio" /*
                                                                                                 * cnb.z(-
                                                                                                 * 414863776021290L)
                                                                                                 */);
                                                break;
                                            case 9:
                                                cnh.ac(this.b.dc(), "https://github.com/HdShare/WAuxiliary_Public" /*
                                                                                                                    * cnb
                                                                                                                    * .z
                                                                                                                    * (-
                                                                                                                    * 417556720515882L)
                                                                                                                    */);
                                                break;
                                            case 10:
                                                KotlinHelpers2.ar(this.b).j(R.id.policyFragment,
                                                        bht.r(new Pair("showOnly" /* "showOnly" /* "showOnly" /* cnb.z(-415645460069162L)  */,
                                                                Boolean.TRUE)));
                                                break;
                                            case 11:
                                                this.b.a.a("wauxv_config.zip" /* "wauxv_config.zip" /* "wauxv_config.zip" /* cnb.z(-417376331889450L)  */);
                                                break;
                                            case 12:
                                                this.b.b.a("application/zip" /* "application/zip" /* "application/zip" /* cnb.z(-417303317445418L)  */);
                                                break;
                                            case 13:
                                                cnh.ac(this.b.dc(), "https://t.me/Hd_WAuxiliary_CI" /*
                                                                                                     * cnb.z(-
                                                                                                     * 417784353782570L)
                                                                                                     */);
                                                break;
                                            case 14:
                                                cnh.ac(this.b.dc(), "https://t.me/Hd_WAuxiliary" /*
                                                                                                  * cnb.z(-
                                                                                                  * 417707044371242L)
                                                                                                  */);
                                                break;
                                            case 15:
                                                cnh.ac(this.b.dc(), "https://github.com/HdShare/WAuxiliary_Plugin" /*
                                                                                                                    * cnb
                                                                                                                    * .z
                                                                                                                    * (-
                                                                                                                    * 416848050912042L)
                                                                                                                    */);
                                                break;
                                            case 16:
                                                api apiVar = api.a;
                                                Context contextDc = this.b.dc();
                                                String strZ3 = "m02krT/t'4E_$jgJt=2LKNe" /* "m02krT/t'4E_$jgJt=2LKNe" /* "m02krT/t'4E_$jgJt=2LKNe" /* cnb.z(-417187353328426L)  */;
                                                apiVar.getClass();
                                                api.tryGetClassByName(contextDc, strZ3);
                                                break;
                                            case 17:
                                                cnh.ac(this.b.dc(), "https://afdian.com/a/hdshare" /*
                                                                                                    * cnb.z(-
                                                                                                    * 417084274113322L)
                                                                                                    */);
                                                break;
                                            case 18:
                                                api apiVar2 = api.a;
                                                Context contextDc2 = this.b.dc();
                                                String strZ4 = "m0eZ$'Q@C9@1WK:'#+D~Bw" /* "m0eZ$'Q@C9@1WK:'#+D~Bw" /* "m0eZ$'Q@C9@1WK:'#+D~Bw" /* cnb.z(-414176581253930L)  */;
                                                apiVar2.getClass();
                                                api.tryGetClassByName(contextDc2, strZ4);
                                                break;
                                            case 19:
                                                cnh.ac(this.b.dc(), "https://afdian.com/a/suzhelan" /*
                                                                                                     * cnb.z(-
                                                                                                     * 414077797006122L)
                                                                                                     */);
                                                break;
                                            case 20:
                                                cnh.ac(this.b.dc(), "https://github.com/HighCapable/YukiHookAPI" /*
                                                                                                                  * cnb.
                                                                                                                  * z(-
                                                                                                                  * 414000487594794L)
                                                                                                                  */);
                                                break;
                                            case 21:
                                                cnh.ac(this.b.dc(), "https://github.com/HighCapable/KavaRef" /*
                                                                                                              * cnb.z(-
                                                                                                              * 414314020207402L)
                                                                                                              */);
                                                break;
                                            default:
                                                cnh.ac(this.b.dc(),
                                                        "https://github.com/BetterAndroid/BetterAndroid" /*
                                                                                                          * cnb.z(-
                                                                                                          * 413596760668970L)
                                                                                                          */);
                                                break;
                                        }
                                    }
                                }),
                        new ny("Telegram Group" /* "Telegram Group" /* "Telegram Group" /* cnb.z(-393324515031850L)  */,
                                "Hd_WAuxiliary" /* "Hd_WAuxiliary" /* "Hd_WAuxiliary" /* cnb.z(-393311630129962L)  */, new View.OnClickListener(this) { // from
                                                                                                                 // class:
                                                                                                                 // me.hd.wauxv.obf.e
                                    public final /* synthetic */ j b;

                                    {
                                        this.b = this;
                                    }

                                    @Override // android.view.View.OnClickListener
                                    public final void onClick(View view2) {
                                        switch (i10) {
                                            case 0:
                                                cnh.ac(this.b.dc(), "https://github.com/BetterAndroid/Hikage" /*
                                                                                                               * cnb.z(-
                                                                                                               * 413446436813610L)
                                                                                                               */);
                                                break;
                                            case 1:
                                                cnh.ac(this.b.dc(), "https://github.com/LuckyPray/DexKit" /*
                                                                                                           * cnb.z(-
                                                                                                           * 413824393935658L)
                                                                                                           */);
                                                break;
                                            case 2:
                                                cnh.ac(this.b.dc(), "https://github.com/cinit/QAuxiliary" /*
                                                                                                           * cnb.z(-
                                                                                                           * 415284682816298L)
                                                                                                           */);
                                                break;
                                            case 3:
                                                cnh.ac(this.b.dc(), "https://github.com/suzhelan/TimTool" /*
                                                                                                           * cnb.z(-
                                                                                                           * 415164423732010L)
                                                                                                           */);
                                                break;
                                            case 4:
                                                cnh.ac(this.b.dc(), "https://github.com/fankes/TSBattery" /*
                                                                                                           * cnb.z(-
                                                                                                           * 415525200984874L)
                                                                                                           */);
                                                break;
                                            case 5:
                                                cnh.ac(this.b.dc(), "https://github.com/KitsunePie/QQCleaner" /*
                                                                                                               * cnb.z(-
                                                                                                               * 415404941900586L)
                                                                                                               */);
                                                break;
                                            case 6:
                                                cnh.ac(this.b.dc(), "https://github.com/LSPosed/LSPosed" /*
                                                                                                          * cnb.z(-
                                                                                                          * 414683387394858L)
                                                                                                          */);
                                                break;
                                            case 7:
                                                cnh.ac(this.b.dc(), "https://github.com/Rosemoe/sora-editor" /*
                                                                                                              * cnb.z(-
                                                                                                              * 415048459615018L)
                                                                                                              */);
                                                break;
                                            case 8:
                                                cnh.ac(this.b.dc(), "https://github.com/Lagrio" /*
                                                                                                 * cnb.z(-
                                                                                                 * 414863776021290L)
                                                                                                 */);
                                                break;
                                            case 9:
                                                cnh.ac(this.b.dc(), "https://github.com/HdShare/WAuxiliary_Public" /*
                                                                                                                    * cnb
                                                                                                                    * .z
                                                                                                                    * (-
                                                                                                                    * 417556720515882L)
                                                                                                                    */);
                                                break;
                                            case 10:
                                                KotlinHelpers2.ar(this.b).j(R.id.policyFragment,
                                                        bht.r(new Pair("showOnly" /* "showOnly" /* "showOnly" /* cnb.z(-415645460069162L)  */,
                                                                Boolean.TRUE)));
                                                break;
                                            case 11:
                                                this.b.a.a("wauxv_config.zip" /* "wauxv_config.zip" /* "wauxv_config.zip" /* cnb.z(-417376331889450L)  */);
                                                break;
                                            case 12:
                                                this.b.b.a("application/zip" /* "application/zip" /* "application/zip" /* cnb.z(-417303317445418L)  */);
                                                break;
                                            case 13:
                                                cnh.ac(this.b.dc(), "https://t.me/Hd_WAuxiliary_CI" /*
                                                                                                     * cnb.z(-
                                                                                                     * 417784353782570L)
                                                                                                     */);
                                                break;
                                            case 14:
                                                cnh.ac(this.b.dc(), "https://t.me/Hd_WAuxiliary" /*
                                                                                                  * cnb.z(-
                                                                                                  * 417707044371242L)
                                                                                                  */);
                                                break;
                                            case 15:
                                                cnh.ac(this.b.dc(), "https://github.com/HdShare/WAuxiliary_Plugin" /*
                                                                                                                    * cnb
                                                                                                                    * .z
                                                                                                                    * (-
                                                                                                                    * 416848050912042L)
                                                                                                                    */);
                                                break;
                                            case 16:
                                                api apiVar = api.a;
                                                Context contextDc = this.b.dc();
                                                String strZ3 = "m02krT/t'4E_$jgJt=2LKNe" /* "m02krT/t'4E_$jgJt=2LKNe" /* "m02krT/t'4E_$jgJt=2LKNe" /* cnb.z(-417187353328426L)  */;
                                                apiVar.getClass();
                                                api.tryGetClassByName(contextDc, strZ3);
                                                break;
                                            case 17:
                                                cnh.ac(this.b.dc(), "https://afdian.com/a/hdshare" /*
                                                                                                    * cnb.z(-
                                                                                                    * 417084274113322L)
                                                                                                    */);
                                                break;
                                            case 18:
                                                api apiVar2 = api.a;
                                                Context contextDc2 = this.b.dc();
                                                String strZ4 = "m0eZ$'Q@C9@1WK:'#+D~Bw" /* "m0eZ$'Q@C9@1WK:'#+D~Bw" /* "m0eZ$'Q@C9@1WK:'#+D~Bw" /* cnb.z(-414176581253930L)  */;
                                                apiVar2.getClass();
                                                api.tryGetClassByName(contextDc2, strZ4);
                                                break;
                                            case 19:
                                                cnh.ac(this.b.dc(), "https://afdian.com/a/suzhelan" /*
                                                                                                     * cnb.z(-
                                                                                                     * 414077797006122L)
                                                                                                     */);
                                                break;
                                            case 20:
                                                cnh.ac(this.b.dc(), "https://github.com/HighCapable/YukiHookAPI" /*
                                                                                                                  * cnb.
                                                                                                                  * z(-
                                                                                                                  * 414000487594794L)
                                                                                                                  */);
                                                break;
                                            case 21:
                                                cnh.ac(this.b.dc(), "https://github.com/HighCapable/KavaRef" /*
                                                                                                              * cnb.z(-
                                                                                                              * 414314020207402L)
                                                                                                              */);
                                                break;
                                            default:
                                                cnh.ac(this.b.dc(),
                                                        "https://github.com/BetterAndroid/BetterAndroid" /*
                                                                                                          * cnb.z(-
                                                                                                          * 413596760668970L)
                                                                                                          */);
                                                break;
                                        }
                                    }
                                })));
        nz nzVar3 = new nz("源码" /* "源码" /* "源码" /* cnb.z(-393234320718634L)  */);
        final int i11 = 9;
        ny nyVar3 = new ny("WAuxiliary_Public" /* "WAuxiliary_Public" /* "WAuxiliary_Public" /* cnb.z(-393187076078378L)  */, "HdShare" /* "HdShare" /* "HdShare" /* cnb.z(-393126946536234L)  */,
                new View.OnClickListener(this) { // from class: me.hd.wauxv.obf.e
                    public final /* synthetic */ j b;

                    {
                        this.b = this;
                    }

                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        switch (i11) {
                            case 0:
                                cnh.ac(this.b.dc(), "https://github.com/BetterAndroid/Hikage" /*
                                                                                               * cnb.z(-
                                                                                               * 413446436813610L)
                                                                                               */);
                                break;
                            case 1:
                                cnh.ac(this.b.dc(),
                                        "https://github.com/LuckyPray/DexKit" /* "https://github.com/LuckyPray/DexKit" /* "https://github.com/LuckyPray/DexKit" /* cnb.z(-413824393935658L)  */);
                                break;
                            case 2:
                                cnh.ac(this.b.dc(),
                                        "https://github.com/cinit/QAuxiliary" /* "https://github.com/cinit/QAuxiliary" /* "https://github.com/cinit/QAuxiliary" /* cnb.z(-415284682816298L)  */);
                                break;
                            case 3:
                                cnh.ac(this.b.dc(),
                                        "https://github.com/suzhelan/TimTool" /* "https://github.com/suzhelan/TimTool" /* "https://github.com/suzhelan/TimTool" /* cnb.z(-415164423732010L)  */);
                                break;
                            case 4:
                                cnh.ac(this.b.dc(),
                                        "https://github.com/fankes/TSBattery" /* "https://github.com/fankes/TSBattery" /* "https://github.com/fankes/TSBattery" /* cnb.z(-415525200984874L)  */);
                                break;
                            case 5:
                                cnh.ac(this.b.dc(), "https://github.com/KitsunePie/QQCleaner" /*
                                                                                               * cnb.z(-
                                                                                               * 415404941900586L)
                                                                                               */);
                                break;
                            case 6:
                                cnh.ac(this.b.dc(),
                                        "https://github.com/LSPosed/LSPosed" /* "https://github.com/LSPosed/LSPosed" /* "https://github.com/LSPosed/LSPosed" /* cnb.z(-414683387394858L)  */);
                                break;
                            case 7:
                                cnh.ac(this.b.dc(), "https://github.com/Rosemoe/sora-editor" /*
                                                                                              * "https://github.com/Rosemoe/sora-editor" /* "https://github.com/Rosemoe/sora-editor" /* cnb.z(-415048459615018L)  */
                                                                                              */);
                                break;
                            case 8:
                                cnh.ac(this.b.dc(), "https://github.com/Lagrio" /* "https://github.com/Lagrio" /* "https://github.com/Lagrio" /* cnb.z(-414863776021290L)  */);
                                break;
                            case 9:
                                cnh.ac(this.b.dc(), "https://github.com/HdShare/WAuxiliary_Public" /*
                                                                                                    * cnb.z(-
                                                                                                    * 417556720515882L)
                                                                                                    */);
                                break;
                            case 10:
                                KotlinHelpers2.ar(this.b).j(R.id.policyFragment, bht.r(new Pair("showOnly" /*
                                                                                                 * cnb.z(-
                                                                                                 * 415645460069162L)
                                                                                                 */, Boolean.TRUE)));
                                break;
                            case 11:
                                this.b.a.a("wauxv_config.zip" /* "wauxv_config.zip" /* "wauxv_config.zip" /* cnb.z(-417376331889450L)  */);
                                break;
                            case 12:
                                this.b.b.a("application/zip" /* "application/zip" /* "application/zip" /* cnb.z(-417303317445418L)  */);
                                break;
                            case 13:
                                cnh.ac(this.b.dc(), "https://t.me/Hd_WAuxiliary_CI" /* "https://t.me/Hd_WAuxiliary_CI" /* "https://t.me/Hd_WAuxiliary_CI" /* cnb.z(-417784353782570L)  */);
                                break;
                            case 14:
                                cnh.ac(this.b.dc(), "https://t.me/Hd_WAuxiliary" /* "https://t.me/Hd_WAuxiliary" /* "https://t.me/Hd_WAuxiliary" /* cnb.z(-417707044371242L)  */);
                                break;
                            case 15:
                                cnh.ac(this.b.dc(), "https://github.com/HdShare/WAuxiliary_Plugin" /*
                                                                                                    * cnb.z(-
                                                                                                    * 416848050912042L)
                                                                                                    */);
                                break;
                            case 16:
                                api apiVar = api.a;
                                Context contextDc = this.b.dc();
                                String strZ3 = "m02krT/t'4E_$jgJt=2LKNe" /* "m02krT/t'4E_$jgJt=2LKNe" /* "m02krT/t'4E_$jgJt=2LKNe" /* cnb.z(-417187353328426L)  */;
                                apiVar.getClass();
                                api.tryGetClassByName(contextDc, strZ3);
                                break;
                            case 17:
                                cnh.ac(this.b.dc(), "https://afdian.com/a/hdshare" /* "https://afdian.com/a/hdshare" /* "https://afdian.com/a/hdshare" /* cnb.z(-417084274113322L)  */);
                                break;
                            case 18:
                                api apiVar2 = api.a;
                                Context contextDc2 = this.b.dc();
                                String strZ4 = "m0eZ$'Q@C9@1WK:'#+D~Bw" /* "m0eZ$'Q@C9@1WK:'#+D~Bw" /* "m0eZ$'Q@C9@1WK:'#+D~Bw" /* cnb.z(-414176581253930L)  */;
                                apiVar2.getClass();
                                api.tryGetClassByName(contextDc2, strZ4);
                                break;
                            case 19:
                                cnh.ac(this.b.dc(), "https://afdian.com/a/suzhelan" /* "https://afdian.com/a/suzhelan" /* "https://afdian.com/a/suzhelan" /* cnb.z(-414077797006122L)  */);
                                break;
                            case 20:
                                cnh.ac(this.b.dc(), "https://github.com/HighCapable/YukiHookAPI" /*
                                                                                                  * cnb.z(-
                                                                                                  * 414000487594794L)
                                                                                                  */);
                                break;
                            case 21:
                                cnh.ac(this.b.dc(), "https://github.com/HighCapable/KavaRef" /*
                                                                                              * "https://github.com/HighCapable/KavaRef" /* "https://github.com/HighCapable/KavaRef" /* cnb.z(-414314020207402L)  */
                                                                                              */);
                                break;
                            default:
                                cnh.ac(this.b.dc(), "https://github.com/BetterAndroid/BetterAndroid" /*
                                                                                                      * cnb.z(-
                                                                                                      * 413596760668970L)
                                                                                                      */);
                                break;
                        }
                    }
                });
        final int i12 = 15;
        ArrayList arrayListO4 = aaz.o(arrayListO3,
                OtherStaticHelpers.argsToList(nzVar3, nyVar3, new ny("WAuxiliary_Plugin" /* "WAuxiliary_Plugin" /* "WAuxiliary_Plugin" /* cnb.z(-393092586797866L)  */,
                        "HdShare" /* "HdShare" /* "HdShare" /* cnb.z(-393582213069610L)  */, new View.OnClickListener(this) { // from class:
                                                                                                   // me.hd.wauxv.obf.e
                            public final /* synthetic */ j b;

                            {
                                this.b = this;
                            }

                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view2) {
                                switch (i12) {
                                    case 0:
                                        cnh.ac(this.b.dc(), "https://github.com/BetterAndroid/Hikage" /*
                                                                                                       * cnb.z(-
                                                                                                       * 413446436813610L)
                                                                                                       */);
                                        break;
                                    case 1:
                                        cnh.ac(this.b.dc(), "https://github.com/LuckyPray/DexKit" /*
                                                                                                   * cnb.z(-
                                                                                                   * 413824393935658L)
                                                                                                   */);
                                        break;
                                    case 2:
                                        cnh.ac(this.b.dc(), "https://github.com/cinit/QAuxiliary" /*
                                                                                                   * cnb.z(-
                                                                                                   * 415284682816298L)
                                                                                                   */);
                                        break;
                                    case 3:
                                        cnh.ac(this.b.dc(), "https://github.com/suzhelan/TimTool" /*
                                                                                                   * cnb.z(-
                                                                                                   * 415164423732010L)
                                                                                                   */);
                                        break;
                                    case 4:
                                        cnh.ac(this.b.dc(), "https://github.com/fankes/TSBattery" /*
                                                                                                   * cnb.z(-
                                                                                                   * 415525200984874L)
                                                                                                   */);
                                        break;
                                    case 5:
                                        cnh.ac(this.b.dc(), "https://github.com/KitsunePie/QQCleaner" /*
                                                                                                       * cnb.z(-
                                                                                                       * 415404941900586L)
                                                                                                       */);
                                        break;
                                    case 6:
                                        cnh.ac(this.b.dc(), "https://github.com/LSPosed/LSPosed" /*
                                                                                                  * cnb.z(-
                                                                                                  * 414683387394858L)
                                                                                                  */);
                                        break;
                                    case 7:
                                        cnh.ac(this.b.dc(), "https://github.com/Rosemoe/sora-editor" /*
                                                                                                      * cnb.z(-
                                                                                                      * 415048459615018L)
                                                                                                      */);
                                        break;
                                    case 8:
                                        cnh.ac(this.b.dc(), "https://github.com/Lagrio" /* "https://github.com/Lagrio" /* "https://github.com/Lagrio" /* cnb.z(-414863776021290L)  */);
                                        break;
                                    case 9:
                                        cnh.ac(this.b.dc(), "https://github.com/HdShare/WAuxiliary_Public" /*
                                                                                                            * cnb.z(-
                                                                                                            * 417556720515882L)
                                                                                                            */);
                                        break;
                                    case 10:
                                        KotlinHelpers2.ar(this.b).j(R.id.policyFragment, bht
                                                .r(new Pair("showOnly" /* "showOnly" /* "showOnly" /* cnb.z(-415645460069162L)  */, Boolean.TRUE)));
                                        break;
                                    case 11:
                                        this.b.a.a("wauxv_config.zip" /* "wauxv_config.zip" /* "wauxv_config.zip" /* cnb.z(-417376331889450L)  */);
                                        break;
                                    case 12:
                                        this.b.b.a("application/zip" /* "application/zip" /* "application/zip" /* cnb.z(-417303317445418L)  */);
                                        break;
                                    case 13:
                                        cnh.ac(this.b.dc(), "https://t.me/Hd_WAuxiliary_CI" /*
                                                                                             * "https://t.me/Hd_WAuxiliary_CI" /* "https://t.me/Hd_WAuxiliary_CI" /* cnb.z(-417784353782570L)  */
                                                                                             */);
                                        break;
                                    case 14:
                                        cnh.ac(this.b.dc(),
                                                "https://t.me/Hd_WAuxiliary" /* "https://t.me/Hd_WAuxiliary" /* "https://t.me/Hd_WAuxiliary" /* cnb.z(-417707044371242L)  */);
                                        break;
                                    case 15:
                                        cnh.ac(this.b.dc(), "https://github.com/HdShare/WAuxiliary_Plugin" /*
                                                                                                            * cnb.z(-
                                                                                                            * 416848050912042L)
                                                                                                            */);
                                        break;
                                    case 16:
                                        api apiVar = api.a;
                                        Context contextDc = this.b.dc();
                                        String strZ3 = "m02krT/t'4E_$jgJt=2LKNe" /* "m02krT/t'4E_$jgJt=2LKNe" /* "m02krT/t'4E_$jgJt=2LKNe" /* cnb.z(-417187353328426L)  */;
                                        apiVar.getClass();
                                        api.tryGetClassByName(contextDc, strZ3);
                                        break;
                                    case 17:
                                        cnh.ac(this.b.dc(), "https://afdian.com/a/hdshare" /*
                                                                                            * "https://afdian.com/a/hdshare" /* "https://afdian.com/a/hdshare" /* cnb.z(-417084274113322L)  */
                                                                                            */);
                                        break;
                                    case 18:
                                        api apiVar2 = api.a;
                                        Context contextDc2 = this.b.dc();
                                        String strZ4 = "m0eZ$'Q@C9@1WK:'#+D~Bw" /* "m0eZ$'Q@C9@1WK:'#+D~Bw" /* "m0eZ$'Q@C9@1WK:'#+D~Bw" /* cnb.z(-414176581253930L)  */;
                                        apiVar2.getClass();
                                        api.tryGetClassByName(contextDc2, strZ4);
                                        break;
                                    case 19:
                                        cnh.ac(this.b.dc(), "https://afdian.com/a/suzhelan" /*
                                                                                             * "https://afdian.com/a/suzhelan" /* "https://afdian.com/a/suzhelan" /* cnb.z(-414077797006122L)  */
                                                                                             */);
                                        break;
                                    case 20:
                                        cnh.ac(this.b.dc(), "https://github.com/HighCapable/YukiHookAPI" /*
                                                                                                          * cnb.z(-
                                                                                                          * 414000487594794L)
                                                                                                          */);
                                        break;
                                    case 21:
                                        cnh.ac(this.b.dc(), "https://github.com/HighCapable/KavaRef" /*
                                                                                                      * cnb.z(-
                                                                                                      * 414314020207402L)
                                                                                                      */);
                                        break;
                                    default:
                                        cnh.ac(this.b.dc(), "https://github.com/BetterAndroid/BetterAndroid" /*
                                                                                                              * cnb.z(-
                                                                                                              * 413596760668970L)
                                                                                                              */);
                                        break;
                                }
                            }
                        })));
        final int i13 = 16;
        final int i14 = 17;
        final int i15 = 18;
        final int i16 = 19;
        ArrayList arrayListO5 = aaz.o(arrayListO4,
                OtherStaticHelpers.argsToList(new nz("打赏" /* "打赏" /* "打赏" /* cnb.z(-393547853331242L)  */), new ny("微信-Hd" /* "微信-Hd" /* "微信-Hd" /* cnb.z(-393552148298538L)  */,
                        "Hd" /* "Hd" /* "Hd" /* cnb.z(-393509198625578L)  */, new View.OnClickListener(this) { // from class:
                                                                                              // me.hd.wauxv.obf.e
                            public final /* synthetic */ j b;

                            {
                                this.b = this;
                            }

                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view2) {
                                switch (i13) {
                                    case 0:
                                        cnh.ac(this.b.dc(), "https://github.com/BetterAndroid/Hikage" /*
                                                                                                       * cnb.z(-
                                                                                                       * 413446436813610L)
                                                                                                       */);
                                        break;
                                    case 1:
                                        cnh.ac(this.b.dc(), "https://github.com/LuckyPray/DexKit" /*
                                                                                                   * cnb.z(-
                                                                                                   * 413824393935658L)
                                                                                                   */);
                                        break;
                                    case 2:
                                        cnh.ac(this.b.dc(), "https://github.com/cinit/QAuxiliary" /*
                                                                                                   * cnb.z(-
                                                                                                   * 415284682816298L)
                                                                                                   */);
                                        break;
                                    case 3:
                                        cnh.ac(this.b.dc(), "https://github.com/suzhelan/TimTool" /*
                                                                                                   * cnb.z(-
                                                                                                   * 415164423732010L)
                                                                                                   */);
                                        break;
                                    case 4:
                                        cnh.ac(this.b.dc(), "https://github.com/fankes/TSBattery" /*
                                                                                                   * cnb.z(-
                                                                                                   * 415525200984874L)
                                                                                                   */);
                                        break;
                                    case 5:
                                        cnh.ac(this.b.dc(), "https://github.com/KitsunePie/QQCleaner" /*
                                                                                                       * cnb.z(-
                                                                                                       * 415404941900586L)
                                                                                                       */);
                                        break;
                                    case 6:
                                        cnh.ac(this.b.dc(), "https://github.com/LSPosed/LSPosed" /*
                                                                                                  * cnb.z(-
                                                                                                  * 414683387394858L)
                                                                                                  */);
                                        break;
                                    case 7:
                                        cnh.ac(this.b.dc(), "https://github.com/Rosemoe/sora-editor" /*
                                                                                                      * cnb.z(-
                                                                                                      * 415048459615018L)
                                                                                                      */);
                                        break;
                                    case 8:
                                        cnh.ac(this.b.dc(), "https://github.com/Lagrio" /* "https://github.com/Lagrio" /* "https://github.com/Lagrio" /* cnb.z(-414863776021290L)  */);
                                        break;
                                    case 9:
                                        cnh.ac(this.b.dc(), "https://github.com/HdShare/WAuxiliary_Public" /*
                                                                                                            * cnb.z(-
                                                                                                            * 417556720515882L)
                                                                                                            */);
                                        break;
                                    case 10:
                                        KotlinHelpers2.ar(this.b).j(R.id.policyFragment, bht
                                                .r(new Pair("showOnly" /* "showOnly" /* "showOnly" /* cnb.z(-415645460069162L)  */, Boolean.TRUE)));
                                        break;
                                    case 11:
                                        this.b.a.a("wauxv_config.zip" /* "wauxv_config.zip" /* "wauxv_config.zip" /* cnb.z(-417376331889450L)  */);
                                        break;
                                    case 12:
                                        this.b.b.a("application/zip" /* "application/zip" /* "application/zip" /* cnb.z(-417303317445418L)  */);
                                        break;
                                    case 13:
                                        cnh.ac(this.b.dc(), "https://t.me/Hd_WAuxiliary_CI" /*
                                                                                             * "https://t.me/Hd_WAuxiliary_CI" /* "https://t.me/Hd_WAuxiliary_CI" /* cnb.z(-417784353782570L)  */
                                                                                             */);
                                        break;
                                    case 14:
                                        cnh.ac(this.b.dc(),
                                                "https://t.me/Hd_WAuxiliary" /* "https://t.me/Hd_WAuxiliary" /* "https://t.me/Hd_WAuxiliary" /* cnb.z(-417707044371242L)  */);
                                        break;
                                    case 15:
                                        cnh.ac(this.b.dc(), "https://github.com/HdShare/WAuxiliary_Plugin" /*
                                                                                                            * cnb.z(-
                                                                                                            * 416848050912042L)
                                                                                                            */);
                                        break;
                                    case 16:
                                        api apiVar = api.a;
                                        Context contextDc = this.b.dc();
                                        String strZ3 = "m02krT/t'4E_$jgJt=2LKNe" /* "m02krT/t'4E_$jgJt=2LKNe" /* "m02krT/t'4E_$jgJt=2LKNe" /* cnb.z(-417187353328426L)  */;
                                        apiVar.getClass();
                                        api.tryGetClassByName(contextDc, strZ3);
                                        break;
                                    case 17:
                                        cnh.ac(this.b.dc(), "https://afdian.com/a/hdshare" /*
                                                                                            * "https://afdian.com/a/hdshare" /* "https://afdian.com/a/hdshare" /* cnb.z(-417084274113322L)  */
                                                                                            */);
                                        break;
                                    case 18:
                                        api apiVar2 = api.a;
                                        Context contextDc2 = this.b.dc();
                                        String strZ4 = "m0eZ$'Q@C9@1WK:'#+D~Bw" /* "m0eZ$'Q@C9@1WK:'#+D~Bw" /* "m0eZ$'Q@C9@1WK:'#+D~Bw" /* cnb.z(-414176581253930L)  */;
                                        apiVar2.getClass();
                                        api.tryGetClassByName(contextDc2, strZ4);
                                        break;
                                    case 19:
                                        cnh.ac(this.b.dc(), "https://afdian.com/a/suzhelan" /*
                                                                                             * "https://afdian.com/a/suzhelan" /* "https://afdian.com/a/suzhelan" /* cnb.z(-414077797006122L)  */
                                                                                             */);
                                        break;
                                    case 20:
                                        cnh.ac(this.b.dc(), "https://github.com/HighCapable/YukiHookAPI" /*
                                                                                                          * cnb.z(-
                                                                                                          * 414000487594794L)
                                                                                                          */);
                                        break;
                                    case 21:
                                        cnh.ac(this.b.dc(), "https://github.com/HighCapable/KavaRef" /*
                                                                                                      * cnb.z(-
                                                                                                      * 414314020207402L)
                                                                                                      */);
                                        break;
                                    default:
                                        cnh.ac(this.b.dc(), "https://github.com/BetterAndroid/BetterAndroid" /*
                                                                                                              * cnb.z(-
                                                                                                              * 413596760668970L)
                                                                                                              */);
                                        break;
                                }
                            }
                        }), new ny("爱发电-HdShare" /* "爱发电-HdShare" /* "爱发电-HdShare" /* cnb.z(-393461953985322L)  */,
                                "HdShare" /* "HdShare" /* "HdShare" /* cnb.z(-393444774116138L)  */, new View.OnClickListener(this) { // from
                                                                                                           // class:
                                                                                                           // me.hd.wauxv.obf.e
                                    public final /* synthetic */ j b;

                                    {
                                        this.b = this;
                                    }

                                    @Override // android.view.View.OnClickListener
                                    public final void onClick(View view2) {
                                        switch (i14) {
                                            case 0:
                                                cnh.ac(this.b.dc(), "https://github.com/BetterAndroid/Hikage" /*
                                                                                                               * cnb.z(-
                                                                                                               * 413446436813610L)
                                                                                                               */);
                                                break;
                                            case 1:
                                                cnh.ac(this.b.dc(), "https://github.com/LuckyPray/DexKit" /*
                                                                                                           * cnb.z(-
                                                                                                           * 413824393935658L)
                                                                                                           */);
                                                break;
                                            case 2:
                                                cnh.ac(this.b.dc(), "https://github.com/cinit/QAuxiliary" /*
                                                                                                           * cnb.z(-
                                                                                                           * 415284682816298L)
                                                                                                           */);
                                                break;
                                            case 3:
                                                cnh.ac(this.b.dc(), "https://github.com/suzhelan/TimTool" /*
                                                                                                           * cnb.z(-
                                                                                                           * 415164423732010L)
                                                                                                           */);
                                                break;
                                            case 4:
                                                cnh.ac(this.b.dc(), "https://github.com/fankes/TSBattery" /*
                                                                                                           * cnb.z(-
                                                                                                           * 415525200984874L)
                                                                                                           */);
                                                break;
                                            case 5:
                                                cnh.ac(this.b.dc(), "https://github.com/KitsunePie/QQCleaner" /*
                                                                                                               * cnb.z(-
                                                                                                               * 415404941900586L)
                                                                                                               */);
                                                break;
                                            case 6:
                                                cnh.ac(this.b.dc(), "https://github.com/LSPosed/LSPosed" /*
                                                                                                          * cnb.z(-
                                                                                                          * 414683387394858L)
                                                                                                          */);
                                                break;
                                            case 7:
                                                cnh.ac(this.b.dc(), "https://github.com/Rosemoe/sora-editor" /*
                                                                                                              * cnb.z(-
                                                                                                              * 415048459615018L)
                                                                                                              */);
                                                break;
                                            case 8:
                                                cnh.ac(this.b.dc(), "https://github.com/Lagrio" /*
                                                                                                 * cnb.z(-
                                                                                                 * 414863776021290L)
                                                                                                 */);
                                                break;
                                            case 9:
                                                cnh.ac(this.b.dc(), "https://github.com/HdShare/WAuxiliary_Public" /*
                                                                                                                    * cnb
                                                                                                                    * .z
                                                                                                                    * (-
                                                                                                                    * 417556720515882L)
                                                                                                                    */);
                                                break;
                                            case 10:
                                                KotlinHelpers2.ar(this.b).j(R.id.policyFragment,
                                                        bht.r(new Pair("showOnly" /* "showOnly" /* "showOnly" /* cnb.z(-415645460069162L)  */,
                                                                Boolean.TRUE)));
                                                break;
                                            case 11:
                                                this.b.a.a("wauxv_config.zip" /* "wauxv_config.zip" /* "wauxv_config.zip" /* cnb.z(-417376331889450L)  */);
                                                break;
                                            case 12:
                                                this.b.b.a("application/zip" /* "application/zip" /* "application/zip" /* cnb.z(-417303317445418L)  */);
                                                break;
                                            case 13:
                                                cnh.ac(this.b.dc(), "https://t.me/Hd_WAuxiliary_CI" /*
                                                                                                     * cnb.z(-
                                                                                                     * 417784353782570L)
                                                                                                     */);
                                                break;
                                            case 14:
                                                cnh.ac(this.b.dc(), "https://t.me/Hd_WAuxiliary" /*
                                                                                                  * cnb.z(-
                                                                                                  * 417707044371242L)
                                                                                                  */);
                                                break;
                                            case 15:
                                                cnh.ac(this.b.dc(), "https://github.com/HdShare/WAuxiliary_Plugin" /*
                                                                                                                    * cnb
                                                                                                                    * .z
                                                                                                                    * (-
                                                                                                                    * 416848050912042L)
                                                                                                                    */);
                                                break;
                                            case 16:
                                                api apiVar = api.a;
                                                Context contextDc = this.b.dc();
                                                String strZ3 = "m02krT/t'4E_$jgJt=2LKNe" /* "m02krT/t'4E_$jgJt=2LKNe" /* "m02krT/t'4E_$jgJt=2LKNe" /* cnb.z(-417187353328426L)  */;
                                                apiVar.getClass();
                                                api.tryGetClassByName(contextDc, strZ3);
                                                break;
                                            case 17:
                                                cnh.ac(this.b.dc(), "https://afdian.com/a/hdshare" /*
                                                                                                    * cnb.z(-
                                                                                                    * 417084274113322L)
                                                                                                    */);
                                                break;
                                            case 18:
                                                api apiVar2 = api.a;
                                                Context contextDc2 = this.b.dc();
                                                String strZ4 = "m0eZ$'Q@C9@1WK:'#+D~Bw" /* "m0eZ$'Q@C9@1WK:'#+D~Bw" /* "m0eZ$'Q@C9@1WK:'#+D~Bw" /* cnb.z(-414176581253930L)  */;
                                                apiVar2.getClass();
                                                api.tryGetClassByName(contextDc2, strZ4);
                                                break;
                                            case 19:
                                                cnh.ac(this.b.dc(), "https://afdian.com/a/suzhelan" /*
                                                                                                     * cnb.z(-
                                                                                                     * 414077797006122L)
                                                                                                     */);
                                                break;
                                            case 20:
                                                cnh.ac(this.b.dc(), "https://github.com/HighCapable/YukiHookAPI" /*
                                                                                                                  * cnb.
                                                                                                                  * z(-
                                                                                                                  * 414000487594794L)
                                                                                                                  */);
                                                break;
                                            case 21:
                                                cnh.ac(this.b.dc(), "https://github.com/HighCapable/KavaRef" /*
                                                                                                              * cnb.z(-
                                                                                                              * 414314020207402L)
                                                                                                              */);
                                                break;
                                            default:
                                                cnh.ac(this.b.dc(),
                                                        "https://github.com/BetterAndroid/BetterAndroid" /*
                                                                                                          * cnb.z(-
                                                                                                          * 413596760668970L)
                                                                                                          */);
                                                break;
                                        }
                                    }
                                }),
                        new ny("微信-久雾" /* "微信-久雾" /* "微信-久雾" /* cnb.z(-393410414377770L)  */, "lovejiuwu" /* "lovejiuwu" /* "lovejiuwu" /* cnb.z(-393367464704810L)  */,
                                new View.OnClickListener(this) { // from class: me.hd.wauxv.obf.e
                                    public final /* synthetic */ j b;

                                    {
                                        this.b = this;
                                    }

                                    @Override // android.view.View.OnClickListener
                                    public final void onClick(View view2) {
                                        switch (i15) {
                                            case 0:
                                                cnh.ac(this.b.dc(), "https://github.com/BetterAndroid/Hikage" /*
                                                                                                               * cnb.z(-
                                                                                                               * 413446436813610L)
                                                                                                               */);
                                                break;
                                            case 1:
                                                cnh.ac(this.b.dc(), "https://github.com/LuckyPray/DexKit" /*
                                                                                                           * cnb.z(-
                                                                                                           * 413824393935658L)
                                                                                                           */);
                                                break;
                                            case 2:
                                                cnh.ac(this.b.dc(), "https://github.com/cinit/QAuxiliary" /*
                                                                                                           * cnb.z(-
                                                                                                           * 415284682816298L)
                                                                                                           */);
                                                break;
                                            case 3:
                                                cnh.ac(this.b.dc(), "https://github.com/suzhelan/TimTool" /*
                                                                                                           * cnb.z(-
                                                                                                           * 415164423732010L)
                                                                                                           */);
                                                break;
                                            case 4:
                                                cnh.ac(this.b.dc(), "https://github.com/fankes/TSBattery" /*
                                                                                                           * cnb.z(-
                                                                                                           * 415525200984874L)
                                                                                                           */);
                                                break;
                                            case 5:
                                                cnh.ac(this.b.dc(), "https://github.com/KitsunePie/QQCleaner" /*
                                                                                                               * cnb.z(-
                                                                                                               * 415404941900586L)
                                                                                                               */);
                                                break;
                                            case 6:
                                                cnh.ac(this.b.dc(), "https://github.com/LSPosed/LSPosed" /*
                                                                                                          * cnb.z(-
                                                                                                          * 414683387394858L)
                                                                                                          */);
                                                break;
                                            case 7:
                                                cnh.ac(this.b.dc(), "https://github.com/Rosemoe/sora-editor" /*
                                                                                                              * cnb.z(-
                                                                                                              * 415048459615018L)
                                                                                                              */);
                                                break;
                                            case 8:
                                                cnh.ac(this.b.dc(), "https://github.com/Lagrio" /*
                                                                                                 * cnb.z(-
                                                                                                 * 414863776021290L)
                                                                                                 */);
                                                break;
                                            case 9:
                                                cnh.ac(this.b.dc(), "https://github.com/HdShare/WAuxiliary_Public" /*
                                                                                                                    * cnb
                                                                                                                    * .z
                                                                                                                    * (-
                                                                                                                    * 417556720515882L)
                                                                                                                    */);
                                                break;
                                            case 10:
                                                KotlinHelpers2.ar(this.b).j(R.id.policyFragment,
                                                        bht.r(new Pair("showOnly" /* "showOnly" /* "showOnly" /* cnb.z(-415645460069162L)  */,
                                                                Boolean.TRUE)));
                                                break;
                                            case 11:
                                                this.b.a.a("wauxv_config.zip" /* "wauxv_config.zip" /* "wauxv_config.zip" /* cnb.z(-417376331889450L)  */);
                                                break;
                                            case 12:
                                                this.b.b.a("application/zip" /* "application/zip" /* "application/zip" /* cnb.z(-417303317445418L)  */);
                                                break;
                                            case 13:
                                                cnh.ac(this.b.dc(), "https://t.me/Hd_WAuxiliary_CI" /*
                                                                                                     * cnb.z(-
                                                                                                     * 417784353782570L)
                                                                                                     */);
                                                break;
                                            case 14:
                                                cnh.ac(this.b.dc(), "https://t.me/Hd_WAuxiliary" /*
                                                                                                  * cnb.z(-
                                                                                                  * 417707044371242L)
                                                                                                  */);
                                                break;
                                            case 15:
                                                cnh.ac(this.b.dc(), "https://github.com/HdShare/WAuxiliary_Plugin" /*
                                                                                                                    * cnb
                                                                                                                    * .z
                                                                                                                    * (-
                                                                                                                    * 416848050912042L)
                                                                                                                    */);
                                                break;
                                            case 16:
                                                api apiVar = api.a;
                                                Context contextDc = this.b.dc();
                                                String strZ3 = "m02krT/t'4E_$jgJt=2LKNe" /* "m02krT/t'4E_$jgJt=2LKNe" /* "m02krT/t'4E_$jgJt=2LKNe" /* cnb.z(-417187353328426L)  */;
                                                apiVar.getClass();
                                                api.tryGetClassByName(contextDc, strZ3);
                                                break;
                                            case 17:
                                                cnh.ac(this.b.dc(), "https://afdian.com/a/hdshare" /*
                                                                                                    * cnb.z(-
                                                                                                    * 417084274113322L)
                                                                                                    */);
                                                break;
                                            case 18:
                                                api apiVar2 = api.a;
                                                Context contextDc2 = this.b.dc();
                                                String strZ4 = "m0eZ$'Q@C9@1WK:'#+D~Bw" /* "m0eZ$'Q@C9@1WK:'#+D~Bw" /* "m0eZ$'Q@C9@1WK:'#+D~Bw" /* cnb.z(-414176581253930L)  */;
                                                apiVar2.getClass();
                                                api.tryGetClassByName(contextDc2, strZ4);
                                                break;
                                            case 19:
                                                cnh.ac(this.b.dc(), "https://afdian.com/a/suzhelan" /*
                                                                                                     * cnb.z(-
                                                                                                     * 414077797006122L)
                                                                                                     */);
                                                break;
                                            case 20:
                                                cnh.ac(this.b.dc(), "https://github.com/HighCapable/YukiHookAPI" /*
                                                                                                                  * cnb.
                                                                                                                  * z(-
                                                                                                                  * 414000487594794L)
                                                                                                                  */);
                                                break;
                                            case 21:
                                                cnh.ac(this.b.dc(), "https://github.com/HighCapable/KavaRef" /*
                                                                                                              * cnb.z(-
                                                                                                              * 414314020207402L)
                                                                                                              */);
                                                break;
                                            default:
                                                cnh.ac(this.b.dc(),
                                                        "https://github.com/BetterAndroid/BetterAndroid" /*
                                                                                                          * cnb.z(-
                                                                                                          * 413596760668970L)
                                                                                                          */);
                                                break;
                                        }
                                    }
                                }),
                        new ny("爱发电-言子楪世" /* "爱发电-言子楪世" /* "爱发电-言子楪世" /* cnb.z(-392791939087146L)  */, "suzhelan" /* "suzhelan" /* "suzhelan" /* cnb.z(-392753284381482L)  */,
                                new View.OnClickListener(this) { // from class: me.hd.wauxv.obf.e
                                    public final /* synthetic */ j b;

                                    {
                                        this.b = this;
                                    }

                                    @Override // android.view.View.OnClickListener
                                    public final void onClick(View view2) {
                                        switch (i16) {
                                            case 0:
                                                cnh.ac(this.b.dc(), "https://github.com/BetterAndroid/Hikage" /*
                                                                                                               * cnb.z(-
                                                                                                               * 413446436813610L)
                                                                                                               */);
                                                break;
                                            case 1:
                                                cnh.ac(this.b.dc(), "https://github.com/LuckyPray/DexKit" /*
                                                                                                           * cnb.z(-
                                                                                                           * 413824393935658L)
                                                                                                           */);
                                                break;
                                            case 2:
                                                cnh.ac(this.b.dc(), "https://github.com/cinit/QAuxiliary" /*
                                                                                                           * cnb.z(-
                                                                                                           * 415284682816298L)
                                                                                                           */);
                                                break;
                                            case 3:
                                                cnh.ac(this.b.dc(), "https://github.com/suzhelan/TimTool" /*
                                                                                                           * cnb.z(-
                                                                                                           * 415164423732010L)
                                                                                                           */);
                                                break;
                                            case 4:
                                                cnh.ac(this.b.dc(), "https://github.com/fankes/TSBattery" /*
                                                                                                           * cnb.z(-
                                                                                                           * 415525200984874L)
                                                                                                           */);
                                                break;
                                            case 5:
                                                cnh.ac(this.b.dc(), "https://github.com/KitsunePie/QQCleaner" /*
                                                                                                               * cnb.z(-
                                                                                                               * 415404941900586L)
                                                                                                               */);
                                                break;
                                            case 6:
                                                cnh.ac(this.b.dc(), "https://github.com/LSPosed/LSPosed" /*
                                                                                                          * cnb.z(-
                                                                                                          * 414683387394858L)
                                                                                                          */);
                                                break;
                                            case 7:
                                                cnh.ac(this.b.dc(), "https://github.com/Rosemoe/sora-editor" /*
                                                                                                              * cnb.z(-
                                                                                                              * 415048459615018L)
                                                                                                              */);
                                                break;
                                            case 8:
                                                cnh.ac(this.b.dc(), "https://github.com/Lagrio" /*
                                                                                                 * cnb.z(-
                                                                                                 * 414863776021290L)
                                                                                                 */);
                                                break;
                                            case 9:
                                                cnh.ac(this.b.dc(), "https://github.com/HdShare/WAuxiliary_Public" /*
                                                                                                                    * cnb
                                                                                                                    * .z
                                                                                                                    * (-
                                                                                                                    * 417556720515882L)
                                                                                                                    */);
                                                break;
                                            case 10:
                                                KotlinHelpers2.ar(this.b).j(R.id.policyFragment,
                                                        bht.r(new Pair("showOnly" /* "showOnly" /* "showOnly" /* cnb.z(-415645460069162L)  */,
                                                                Boolean.TRUE)));
                                                break;
                                            case 11:
                                                this.b.a.a("wauxv_config.zip" /* "wauxv_config.zip" /* "wauxv_config.zip" /* cnb.z(-417376331889450L)  */);
                                                break;
                                            case 12:
                                                this.b.b.a("application/zip" /* "application/zip" /* "application/zip" /* cnb.z(-417303317445418L)  */);
                                                break;
                                            case 13:
                                                cnh.ac(this.b.dc(), "https://t.me/Hd_WAuxiliary_CI" /*
                                                                                                     * cnb.z(-
                                                                                                     * 417784353782570L)
                                                                                                     */);
                                                break;
                                            case 14:
                                                cnh.ac(this.b.dc(), "https://t.me/Hd_WAuxiliary" /*
                                                                                                  * cnb.z(-
                                                                                                  * 417707044371242L)
                                                                                                  */);
                                                break;
                                            case 15:
                                                cnh.ac(this.b.dc(), "https://github.com/HdShare/WAuxiliary_Plugin" /*
                                                                                                                    * cnb
                                                                                                                    * .z
                                                                                                                    * (-
                                                                                                                    * 416848050912042L)
                                                                                                                    */);
                                                break;
                                            case 16:
                                                api apiVar = api.a;
                                                Context contextDc = this.b.dc();
                                                String strZ3 = "m02krT/t'4E_$jgJt=2LKNe" /* "m02krT/t'4E_$jgJt=2LKNe" /* "m02krT/t'4E_$jgJt=2LKNe" /* cnb.z(-417187353328426L)  */;
                                                apiVar.getClass();
                                                api.tryGetClassByName(contextDc, strZ3);
                                                break;
                                            case 17:
                                                cnh.ac(this.b.dc(), "https://afdian.com/a/hdshare" /*
                                                                                                    * cnb.z(-
                                                                                                    * 417084274113322L)
                                                                                                    */);
                                                break;
                                            case 18:
                                                api apiVar2 = api.a;
                                                Context contextDc2 = this.b.dc();
                                                String strZ4 = "m0eZ$'Q@C9@1WK:'#+D~Bw" /* "m0eZ$'Q@C9@1WK:'#+D~Bw" /* "m0eZ$'Q@C9@1WK:'#+D~Bw" /* cnb.z(-414176581253930L)  */;
                                                apiVar2.getClass();
                                                api.tryGetClassByName(contextDc2, strZ4);
                                                break;
                                            case 19:
                                                cnh.ac(this.b.dc(), "https://afdian.com/a/suzhelan" /*
                                                                                                     * cnb.z(-
                                                                                                     * 414077797006122L)
                                                                                                     */);
                                                break;
                                            case 20:
                                                cnh.ac(this.b.dc(), "https://github.com/HighCapable/YukiHookAPI" /*
                                                                                                                  * cnb.
                                                                                                                  * z(-
                                                                                                                  * 414000487594794L)
                                                                                                                  */);
                                                break;
                                            case 21:
                                                cnh.ac(this.b.dc(), "https://github.com/HighCapable/KavaRef" /*
                                                                                                              * cnb.z(-
                                                                                                              * 414314020207402L)
                                                                                                              */);
                                                break;
                                            default:
                                                cnh.ac(this.b.dc(),
                                                        "https://github.com/BetterAndroid/BetterAndroid" /*
                                                                                                          * cnb.z(-
                                                                                                          * 413596760668970L)
                                                                                                          */);
                                                break;
                                        }
                                    }
                                })));
        final int i17 = 20;
        final int i18 = 21;
        final int i19 = 22;
        final int i20 = 5;
        final int i21 = 6;
        final int i22 = 7;
        final int i23 = 8;
        recyclerView.setAdapter(new eqi(aaz.o(arrayListO5,
                OtherStaticHelpers.argsToList(new nz("致谢" /* "致谢" /* "致谢" /* cnb.z(-392731809545002L)  */), new ny("YukiHookAPI" /* "YukiHookAPI" /* "YukiHookAPI" /* cnb.z(-392667385035562L)  */,
                        "HighCapable" /* "HighCapable" /* "HighCapable" /* cnb.z(-392650205166378L)  */, new View.OnClickListener(this) { // from class:
                                                                                                       // me.hd.wauxv.obf.e
                            public final /* synthetic */ j b;

                            {
                                this.b = this;
                            }

                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view2) {
                                switch (i17) {
                                    case 0:
                                        cnh.ac(this.b.dc(), "https://github.com/BetterAndroid/Hikage" /*
                                                                                                       * cnb.z(-
                                                                                                       * 413446436813610L)
                                                                                                       */);
                                        break;
                                    case 1:
                                        cnh.ac(this.b.dc(), "https://github.com/LuckyPray/DexKit" /*
                                                                                                   * cnb.z(-
                                                                                                   * 413824393935658L)
                                                                                                   */);
                                        break;
                                    case 2:
                                        cnh.ac(this.b.dc(), "https://github.com/cinit/QAuxiliary" /*
                                                                                                   * cnb.z(-
                                                                                                   * 415284682816298L)
                                                                                                   */);
                                        break;
                                    case 3:
                                        cnh.ac(this.b.dc(), "https://github.com/suzhelan/TimTool" /*
                                                                                                   * cnb.z(-
                                                                                                   * 415164423732010L)
                                                                                                   */);
                                        break;
                                    case 4:
                                        cnh.ac(this.b.dc(), "https://github.com/fankes/TSBattery" /*
                                                                                                   * cnb.z(-
                                                                                                   * 415525200984874L)
                                                                                                   */);
                                        break;
                                    case 5:
                                        cnh.ac(this.b.dc(), "https://github.com/KitsunePie/QQCleaner" /*
                                                                                                       * cnb.z(-
                                                                                                       * 415404941900586L)
                                                                                                       */);
                                        break;
                                    case 6:
                                        cnh.ac(this.b.dc(), "https://github.com/LSPosed/LSPosed" /*
                                                                                                  * cnb.z(-
                                                                                                  * 414683387394858L)
                                                                                                  */);
                                        break;
                                    case 7:
                                        cnh.ac(this.b.dc(), "https://github.com/Rosemoe/sora-editor" /*
                                                                                                      * cnb.z(-
                                                                                                      * 415048459615018L)
                                                                                                      */);
                                        break;
                                    case 8:
                                        cnh.ac(this.b.dc(), "https://github.com/Lagrio" /* "https://github.com/Lagrio" /* "https://github.com/Lagrio" /* cnb.z(-414863776021290L)  */);
                                        break;
                                    case 9:
                                        cnh.ac(this.b.dc(), "https://github.com/HdShare/WAuxiliary_Public" /*
                                                                                                            * cnb.z(-
                                                                                                            * 417556720515882L)
                                                                                                            */);
                                        break;
                                    case 10:
                                        KotlinHelpers2.ar(this.b).j(R.id.policyFragment, bht
                                                .r(new Pair("showOnly" /* "showOnly" /* "showOnly" /* cnb.z(-415645460069162L)  */, Boolean.TRUE)));
                                        break;
                                    case 11:
                                        this.b.a.a("wauxv_config.zip" /* "wauxv_config.zip" /* "wauxv_config.zip" /* cnb.z(-417376331889450L)  */);
                                        break;
                                    case 12:
                                        this.b.b.a("application/zip" /* "application/zip" /* "application/zip" /* cnb.z(-417303317445418L)  */);
                                        break;
                                    case 13:
                                        cnh.ac(this.b.dc(), "https://t.me/Hd_WAuxiliary_CI" /*
                                                                                             * "https://t.me/Hd_WAuxiliary_CI" /* "https://t.me/Hd_WAuxiliary_CI" /* cnb.z(-417784353782570L)  */
                                                                                             */);
                                        break;
                                    case 14:
                                        cnh.ac(this.b.dc(),
                                                "https://t.me/Hd_WAuxiliary" /* "https://t.me/Hd_WAuxiliary" /* "https://t.me/Hd_WAuxiliary" /* cnb.z(-417707044371242L)  */);
                                        break;
                                    case 15:
                                        cnh.ac(this.b.dc(), "https://github.com/HdShare/WAuxiliary_Plugin" /*
                                                                                                            * cnb.z(-
                                                                                                            * 416848050912042L)
                                                                                                            */);
                                        break;
                                    case 16:
                                        api apiVar = api.a;
                                        Context contextDc = this.b.dc();
                                        String strZ3 = "m02krT/t'4E_$jgJt=2LKNe" /* "m02krT/t'4E_$jgJt=2LKNe" /* "m02krT/t'4E_$jgJt=2LKNe" /* cnb.z(-417187353328426L)  */;
                                        apiVar.getClass();
                                        api.tryGetClassByName(contextDc, strZ3);
                                        break;
                                    case 17:
                                        cnh.ac(this.b.dc(), "https://afdian.com/a/hdshare" /*
                                                                                            * "https://afdian.com/a/hdshare" /* "https://afdian.com/a/hdshare" /* cnb.z(-417084274113322L)  */
                                                                                            */);
                                        break;
                                    case 18:
                                        api apiVar2 = api.a;
                                        Context contextDc2 = this.b.dc();
                                        String strZ4 = "m0eZ$'Q@C9@1WK:'#+D~Bw" /* "m0eZ$'Q@C9@1WK:'#+D~Bw" /* "m0eZ$'Q@C9@1WK:'#+D~Bw" /* cnb.z(-414176581253930L)  */;
                                        apiVar2.getClass();
                                        api.tryGetClassByName(contextDc2, strZ4);
                                        break;
                                    case 19:
                                        cnh.ac(this.b.dc(), "https://afdian.com/a/suzhelan" /*
                                                                                             * "https://afdian.com/a/suzhelan" /* "https://afdian.com/a/suzhelan" /* cnb.z(-414077797006122L)  */
                                                                                             */);
                                        break;
                                    case 20:
                                        cnh.ac(this.b.dc(), "https://github.com/HighCapable/YukiHookAPI" /*
                                                                                                          * cnb.z(-
                                                                                                          * 414000487594794L)
                                                                                                          */);
                                        break;
                                    case 21:
                                        cnh.ac(this.b.dc(), "https://github.com/HighCapable/KavaRef" /*
                                                                                                      * cnb.z(-
                                                                                                      * 414314020207402L)
                                                                                                      */);
                                        break;
                                    default:
                                        cnh.ac(this.b.dc(), "https://github.com/BetterAndroid/BetterAndroid" /*
                                                                                                              * cnb.z(-
                                                                                                              * 413596760668970L)
                                                                                                              */);
                                        break;
                                }
                            }
                        }), new ny("KavaRef" /* "KavaRef" /* "KavaRef" /* cnb.z(-392564305820458L)  */,
                                "HighCapable" /* "HighCapable" /* "HighCapable" /* cnb.z(-392529946082090L)  */, new View.OnClickListener(this) { // from
                                                                                                               // class:
                                                                                                               // me.hd.wauxv.obf.e
                                    public final /* synthetic */ j b;

                                    {
                                        this.b = this;
                                    }

                                    @Override // android.view.View.OnClickListener
                                    public final void onClick(View view2) {
                                        switch (i18) {
                                            case 0:
                                                cnh.ac(this.b.dc(), "https://github.com/BetterAndroid/Hikage" /*
                                                                                                               * cnb.z(-
                                                                                                               * 413446436813610L)
                                                                                                               */);
                                                break;
                                            case 1:
                                                cnh.ac(this.b.dc(), "https://github.com/LuckyPray/DexKit" /*
                                                                                                           * cnb.z(-
                                                                                                           * 413824393935658L)
                                                                                                           */);
                                                break;
                                            case 2:
                                                cnh.ac(this.b.dc(), "https://github.com/cinit/QAuxiliary" /*
                                                                                                           * cnb.z(-
                                                                                                           * 415284682816298L)
                                                                                                           */);
                                                break;
                                            case 3:
                                                cnh.ac(this.b.dc(), "https://github.com/suzhelan/TimTool" /*
                                                                                                           * cnb.z(-
                                                                                                           * 415164423732010L)
                                                                                                           */);
                                                break;
                                            case 4:
                                                cnh.ac(this.b.dc(), "https://github.com/fankes/TSBattery" /*
                                                                                                           * cnb.z(-
                                                                                                           * 415525200984874L)
                                                                                                           */);
                                                break;
                                            case 5:
                                                cnh.ac(this.b.dc(), "https://github.com/KitsunePie/QQCleaner" /*
                                                                                                               * cnb.z(-
                                                                                                               * 415404941900586L)
                                                                                                               */);
                                                break;
                                            case 6:
                                                cnh.ac(this.b.dc(), "https://github.com/LSPosed/LSPosed" /*
                                                                                                          * cnb.z(-
                                                                                                          * 414683387394858L)
                                                                                                          */);
                                                break;
                                            case 7:
                                                cnh.ac(this.b.dc(), "https://github.com/Rosemoe/sora-editor" /*
                                                                                                              * cnb.z(-
                                                                                                              * 415048459615018L)
                                                                                                              */);
                                                break;
                                            case 8:
                                                cnh.ac(this.b.dc(), "https://github.com/Lagrio" /*
                                                                                                 * cnb.z(-
                                                                                                 * 414863776021290L)
                                                                                                 */);
                                                break;
                                            case 9:
                                                cnh.ac(this.b.dc(), "https://github.com/HdShare/WAuxiliary_Public" /*
                                                                                                                    * cnb
                                                                                                                    * .z
                                                                                                                    * (-
                                                                                                                    * 417556720515882L)
                                                                                                                    */);
                                                break;
                                            case 10:
                                                KotlinHelpers2.ar(this.b).j(R.id.policyFragment,
                                                        bht.r(new Pair("showOnly" /* "showOnly" /* "showOnly" /* cnb.z(-415645460069162L)  */,
                                                                Boolean.TRUE)));
                                                break;
                                            case 11:
                                                this.b.a.a("wauxv_config.zip" /* "wauxv_config.zip" /* "wauxv_config.zip" /* cnb.z(-417376331889450L)  */);
                                                break;
                                            case 12:
                                                this.b.b.a("application/zip" /* "application/zip" /* "application/zip" /* cnb.z(-417303317445418L)  */);
                                                break;
                                            case 13:
                                                cnh.ac(this.b.dc(), "https://t.me/Hd_WAuxiliary_CI" /*
                                                                                                     * cnb.z(-
                                                                                                     * 417784353782570L)
                                                                                                     */);
                                                break;
                                            case 14:
                                                cnh.ac(this.b.dc(), "https://t.me/Hd_WAuxiliary" /*
                                                                                                  * cnb.z(-
                                                                                                  * 417707044371242L)
                                                                                                  */);
                                                break;
                                            case 15:
                                                cnh.ac(this.b.dc(), "https://github.com/HdShare/WAuxiliary_Plugin" /*
                                                                                                                    * cnb
                                                                                                                    * .z
                                                                                                                    * (-
                                                                                                                    * 416848050912042L)
                                                                                                                    */);
                                                break;
                                            case 16:
                                                api apiVar = api.a;
                                                Context contextDc = this.b.dc();
                                                String strZ3 = "m02krT/t'4E_$jgJt=2LKNe" /* "m02krT/t'4E_$jgJt=2LKNe" /* "m02krT/t'4E_$jgJt=2LKNe" /* cnb.z(-417187353328426L)  */;
                                                apiVar.getClass();
                                                api.tryGetClassByName(contextDc, strZ3);
                                                break;
                                            case 17:
                                                cnh.ac(this.b.dc(), "https://afdian.com/a/hdshare" /*
                                                                                                    * cnb.z(-
                                                                                                    * 417084274113322L)
                                                                                                    */);
                                                break;
                                            case 18:
                                                api apiVar2 = api.a;
                                                Context contextDc2 = this.b.dc();
                                                String strZ4 = "m0eZ$'Q@C9@1WK:'#+D~Bw" /* "m0eZ$'Q@C9@1WK:'#+D~Bw" /* "m0eZ$'Q@C9@1WK:'#+D~Bw" /* cnb.z(-414176581253930L)  */;
                                                apiVar2.getClass();
                                                api.tryGetClassByName(contextDc2, strZ4);
                                                break;
                                            case 19:
                                                cnh.ac(this.b.dc(), "https://afdian.com/a/suzhelan" /*
                                                                                                     * cnb.z(-
                                                                                                     * 414077797006122L)
                                                                                                     */);
                                                break;
                                            case 20:
                                                cnh.ac(this.b.dc(), "https://github.com/HighCapable/YukiHookAPI" /*
                                                                                                                  * cnb.
                                                                                                                  * z(-
                                                                                                                  * 414000487594794L)
                                                                                                                  */);
                                                break;
                                            case 21:
                                                cnh.ac(this.b.dc(), "https://github.com/HighCapable/KavaRef" /*
                                                                                                              * cnb.z(-
                                                                                                              * 414314020207402L)
                                                                                                              */);
                                                break;
                                            default:
                                                cnh.ac(this.b.dc(),
                                                        "https://github.com/BetterAndroid/BetterAndroid" /*
                                                                                                          * cnb.z(-
                                                                                                          * 413596760668970L)
                                                                                                          */);
                                                break;
                                        }
                                    }
                                }),
                        new ny("BetterAndroid" /* "BetterAndroid" /* "BetterAndroid" /* cnb.z(-393062522026794L)  */,
                                "BetterAndroid" /* "BetterAndroid" /* "BetterAndroid" /* cnb.z(-392985212615466L)  */, new View.OnClickListener(this) { // from
                                                                                                                 // class:
                                                                                                                 // me.hd.wauxv.obf.e
                                    public final /* synthetic */ j b;

                                    {
                                        this.b = this;
                                    }

                                    @Override // android.view.View.OnClickListener
                                    public final void onClick(View view2) {
                                        switch (i19) {
                                            case 0:
                                                cnh.ac(this.b.dc(), "https://github.com/BetterAndroid/Hikage" /*
                                                                                                               * cnb.z(-
                                                                                                               * 413446436813610L)
                                                                                                               */);
                                                break;
                                            case 1:
                                                cnh.ac(this.b.dc(), "https://github.com/LuckyPray/DexKit" /*
                                                                                                           * cnb.z(-
                                                                                                           * 413824393935658L)
                                                                                                           */);
                                                break;
                                            case 2:
                                                cnh.ac(this.b.dc(), "https://github.com/cinit/QAuxiliary" /*
                                                                                                           * cnb.z(-
                                                                                                           * 415284682816298L)
                                                                                                           */);
                                                break;
                                            case 3:
                                                cnh.ac(this.b.dc(), "https://github.com/suzhelan/TimTool" /*
                                                                                                           * cnb.z(-
                                                                                                           * 415164423732010L)
                                                                                                           */);
                                                break;
                                            case 4:
                                                cnh.ac(this.b.dc(), "https://github.com/fankes/TSBattery" /*
                                                                                                           * cnb.z(-
                                                                                                           * 415525200984874L)
                                                                                                           */);
                                                break;
                                            case 5:
                                                cnh.ac(this.b.dc(), "https://github.com/KitsunePie/QQCleaner" /*
                                                                                                               * cnb.z(-
                                                                                                               * 415404941900586L)
                                                                                                               */);
                                                break;
                                            case 6:
                                                cnh.ac(this.b.dc(), "https://github.com/LSPosed/LSPosed" /*
                                                                                                          * cnb.z(-
                                                                                                          * 414683387394858L)
                                                                                                          */);
                                                break;
                                            case 7:
                                                cnh.ac(this.b.dc(), "https://github.com/Rosemoe/sora-editor" /*
                                                                                                              * cnb.z(-
                                                                                                              * 415048459615018L)
                                                                                                              */);
                                                break;
                                            case 8:
                                                cnh.ac(this.b.dc(), "https://github.com/Lagrio" /*
                                                                                                 * cnb.z(-
                                                                                                 * 414863776021290L)
                                                                                                 */);
                                                break;
                                            case 9:
                                                cnh.ac(this.b.dc(), "https://github.com/HdShare/WAuxiliary_Public" /*
                                                                                                                    * cnb
                                                                                                                    * .z
                                                                                                                    * (-
                                                                                                                    * 417556720515882L)
                                                                                                                    */);
                                                break;
                                            case 10:
                                                KotlinHelpers2.ar(this.b).j(R.id.policyFragment,
                                                        bht.r(new Pair("showOnly" /* "showOnly" /* "showOnly" /* cnb.z(-415645460069162L)  */,
                                                                Boolean.TRUE)));
                                                break;
                                            case 11:
                                                this.b.a.a("wauxv_config.zip" /* "wauxv_config.zip" /* "wauxv_config.zip" /* cnb.z(-417376331889450L)  */);
                                                break;
                                            case 12:
                                                this.b.b.a("application/zip" /* "application/zip" /* "application/zip" /* cnb.z(-417303317445418L)  */);
                                                break;
                                            case 13:
                                                cnh.ac(this.b.dc(), "https://t.me/Hd_WAuxiliary_CI" /*
                                                                                                     * cnb.z(-
                                                                                                     * 417784353782570L)
                                                                                                     */);
                                                break;
                                            case 14:
                                                cnh.ac(this.b.dc(), "https://t.me/Hd_WAuxiliary" /*
                                                                                                  * cnb.z(-
                                                                                                  * 417707044371242L)
                                                                                                  */);
                                                break;
                                            case 15:
                                                cnh.ac(this.b.dc(), "https://github.com/HdShare/WAuxiliary_Plugin" /*
                                                                                                                    * cnb
                                                                                                                    * .z
                                                                                                                    * (-
                                                                                                                    * 416848050912042L)
                                                                                                                    */);
                                                break;
                                            case 16:
                                                api apiVar = api.a;
                                                Context contextDc = this.b.dc();
                                                String strZ3 = "m02krT/t'4E_$jgJt=2LKNe" /* "m02krT/t'4E_$jgJt=2LKNe" /* "m02krT/t'4E_$jgJt=2LKNe" /* cnb.z(-417187353328426L)  */;
                                                apiVar.getClass();
                                                api.tryGetClassByName(contextDc, strZ3);
                                                break;
                                            case 17:
                                                cnh.ac(this.b.dc(), "https://afdian.com/a/hdshare" /*
                                                                                                    * cnb.z(-
                                                                                                    * 417084274113322L)
                                                                                                    */);
                                                break;
                                            case 18:
                                                api apiVar2 = api.a;
                                                Context contextDc2 = this.b.dc();
                                                String strZ4 = "m0eZ$'Q@C9@1WK:'#+D~Bw" /* "m0eZ$'Q@C9@1WK:'#+D~Bw" /* "m0eZ$'Q@C9@1WK:'#+D~Bw" /* cnb.z(-414176581253930L)  */;
                                                apiVar2.getClass();
                                                api.tryGetClassByName(contextDc2, strZ4);
                                                break;
                                            case 19:
                                                cnh.ac(this.b.dc(), "https://afdian.com/a/suzhelan" /*
                                                                                                     * cnb.z(-
                                                                                                     * 414077797006122L)
                                                                                                     */);
                                                break;
                                            case 20:
                                                cnh.ac(this.b.dc(), "https://github.com/HighCapable/YukiHookAPI" /*
                                                                                                                  * cnb.
                                                                                                                  * z(-
                                                                                                                  * 414000487594794L)
                                                                                                                  */);
                                                break;
                                            case 21:
                                                cnh.ac(this.b.dc(), "https://github.com/HighCapable/KavaRef" /*
                                                                                                              * cnb.z(-
                                                                                                              * 414314020207402L)
                                                                                                              */);
                                                break;
                                            default:
                                                cnh.ac(this.b.dc(),
                                                        "https://github.com/BetterAndroid/BetterAndroid" /*
                                                                                                          * cnb.z(-
                                                                                                          * 413596760668970L)
                                                                                                          */);
                                                break;
                                        }
                                    }
                                }),
                        new ny("Hikage" /* "Hikage" /* "Hikage" /* cnb.z(-392907903204138L)  */, "BetterAndroid" /* "BetterAndroid" /* "BetterAndroid" /* cnb.z(-392877838433066L)  */,
                                new View.OnClickListener(this) { // from class: me.hd.wauxv.obf.e
                                    public final /* synthetic */ j b;

                                    {
                                        this.b = this;
                                    }

                                    @Override // android.view.View.OnClickListener
                                    public final void onClick(View view2) {
                                        switch (i4) {
                                            case 0:
                                                cnh.ac(this.b.dc(), "https://github.com/BetterAndroid/Hikage" /*
                                                                                                               * cnb.z(-
                                                                                                               * 413446436813610L)
                                                                                                               */);
                                                break;
                                            case 1:
                                                cnh.ac(this.b.dc(), "https://github.com/LuckyPray/DexKit" /*
                                                                                                           * cnb.z(-
                                                                                                           * 413824393935658L)
                                                                                                           */);
                                                break;
                                            case 2:
                                                cnh.ac(this.b.dc(), "https://github.com/cinit/QAuxiliary" /*
                                                                                                           * cnb.z(-
                                                                                                           * 415284682816298L)
                                                                                                           */);
                                                break;
                                            case 3:
                                                cnh.ac(this.b.dc(), "https://github.com/suzhelan/TimTool" /*
                                                                                                           * cnb.z(-
                                                                                                           * 415164423732010L)
                                                                                                           */);
                                                break;
                                            case 4:
                                                cnh.ac(this.b.dc(), "https://github.com/fankes/TSBattery" /*
                                                                                                           * cnb.z(-
                                                                                                           * 415525200984874L)
                                                                                                           */);
                                                break;
                                            case 5:
                                                cnh.ac(this.b.dc(), "https://github.com/KitsunePie/QQCleaner" /*
                                                                                                               * cnb.z(-
                                                                                                               * 415404941900586L)
                                                                                                               */);
                                                break;
                                            case 6:
                                                cnh.ac(this.b.dc(), "https://github.com/LSPosed/LSPosed" /*
                                                                                                          * cnb.z(-
                                                                                                          * 414683387394858L)
                                                                                                          */);
                                                break;
                                            case 7:
                                                cnh.ac(this.b.dc(), "https://github.com/Rosemoe/sora-editor" /*
                                                                                                              * cnb.z(-
                                                                                                              * 415048459615018L)
                                                                                                              */);
                                                break;
                                            case 8:
                                                cnh.ac(this.b.dc(), "https://github.com/Lagrio" /*
                                                                                                 * cnb.z(-
                                                                                                 * 414863776021290L)
                                                                                                 */);
                                                break;
                                            case 9:
                                                cnh.ac(this.b.dc(), "https://github.com/HdShare/WAuxiliary_Public" /*
                                                                                                                    * cnb
                                                                                                                    * .z
                                                                                                                    * (-
                                                                                                                    * 417556720515882L)
                                                                                                                    */);
                                                break;
                                            case 10:
                                                KotlinHelpers2.ar(this.b).j(R.id.policyFragment,
                                                        bht.r(new Pair("showOnly" /* "showOnly" /* "showOnly" /* cnb.z(-415645460069162L)  */,
                                                                Boolean.TRUE)));
                                                break;
                                            case 11:
                                                this.b.a.a("wauxv_config.zip" /* "wauxv_config.zip" /* "wauxv_config.zip" /* cnb.z(-417376331889450L)  */);
                                                break;
                                            case 12:
                                                this.b.b.a("application/zip" /* "application/zip" /* "application/zip" /* cnb.z(-417303317445418L)  */);
                                                break;
                                            case 13:
                                                cnh.ac(this.b.dc(), "https://t.me/Hd_WAuxiliary_CI" /*
                                                                                                     * cnb.z(-
                                                                                                     * 417784353782570L)
                                                                                                     */);
                                                break;
                                            case 14:
                                                cnh.ac(this.b.dc(), "https://t.me/Hd_WAuxiliary" /*
                                                                                                  * cnb.z(-
                                                                                                  * 417707044371242L)
                                                                                                  */);
                                                break;
                                            case 15:
                                                cnh.ac(this.b.dc(), "https://github.com/HdShare/WAuxiliary_Plugin" /*
                                                                                                                    * cnb
                                                                                                                    * .z
                                                                                                                    * (-
                                                                                                                    * 416848050912042L)
                                                                                                                    */);
                                                break;
                                            case 16:
                                                api apiVar = api.a;
                                                Context contextDc = this.b.dc();
                                                String strZ3 = "m02krT/t'4E_$jgJt=2LKNe" /* "m02krT/t'4E_$jgJt=2LKNe" /* "m02krT/t'4E_$jgJt=2LKNe" /* cnb.z(-417187353328426L)  */;
                                                apiVar.getClass();
                                                api.tryGetClassByName(contextDc, strZ3);
                                                break;
                                            case 17:
                                                cnh.ac(this.b.dc(), "https://afdian.com/a/hdshare" /*
                                                                                                    * cnb.z(-
                                                                                                    * 417084274113322L)
                                                                                                    */);
                                                break;
                                            case 18:
                                                api apiVar2 = api.a;
                                                Context contextDc2 = this.b.dc();
                                                String strZ4 = "m0eZ$'Q@C9@1WK:'#+D~Bw" /* "m0eZ$'Q@C9@1WK:'#+D~Bw" /* "m0eZ$'Q@C9@1WK:'#+D~Bw" /* cnb.z(-414176581253930L)  */;
                                                apiVar2.getClass();
                                                api.tryGetClassByName(contextDc2, strZ4);
                                                break;
                                            case 19:
                                                cnh.ac(this.b.dc(), "https://afdian.com/a/suzhelan" /*
                                                                                                     * cnb.z(-
                                                                                                     * 414077797006122L)
                                                                                                     */);
                                                break;
                                            case 20:
                                                cnh.ac(this.b.dc(), "https://github.com/HighCapable/YukiHookAPI" /*
                                                                                                                  * cnb.
                                                                                                                  * z(-
                                                                                                                  * 414000487594794L)
                                                                                                                  */);
                                                break;
                                            case 21:
                                                cnh.ac(this.b.dc(), "https://github.com/HighCapable/KavaRef" /*
                                                                                                              * cnb.z(-
                                                                                                              * 414314020207402L)
                                                                                                              */);
                                                break;
                                            default:
                                                cnh.ac(this.b.dc(),
                                                        "https://github.com/BetterAndroid/BetterAndroid" /*
                                                                                                          * cnb.z(-
                                                                                                          * 413596760668970L)
                                                                                                          */);
                                                break;
                                        }
                                    }
                                }),
                        new ny("DexKit" /* "DexKit" /* "DexKit" /* cnb.z(-392869248498474L)  */, "LuckyPray" /* "LuckyPray" /* "LuckyPray" /* cnb.z(-392822003858218L)  */,
                                new View.OnClickListener(this) { // from class: me.hd.wauxv.obf.e
                                    public final /* synthetic */ j b;

                                    {
                                        this.b = this;
                                    }

                                    @Override // android.view.View.OnClickListener
                                    public final void onClick(View view2) {
                                        switch (i) {
                                            case 0:
                                                cnh.ac(this.b.dc(), "https://github.com/BetterAndroid/Hikage" /*
                                                                                                               * cnb.z(-
                                                                                                               * 413446436813610L)
                                                                                                               */);
                                                break;
                                            case 1:
                                                cnh.ac(this.b.dc(), "https://github.com/LuckyPray/DexKit" /*
                                                                                                           * cnb.z(-
                                                                                                           * 413824393935658L)
                                                                                                           */);
                                                break;
                                            case 2:
                                                cnh.ac(this.b.dc(), "https://github.com/cinit/QAuxiliary" /*
                                                                                                           * cnb.z(-
                                                                                                           * 415284682816298L)
                                                                                                           */);
                                                break;
                                            case 3:
                                                cnh.ac(this.b.dc(), "https://github.com/suzhelan/TimTool" /*
                                                                                                           * cnb.z(-
                                                                                                           * 415164423732010L)
                                                                                                           */);
                                                break;
                                            case 4:
                                                cnh.ac(this.b.dc(), "https://github.com/fankes/TSBattery" /*
                                                                                                           * cnb.z(-
                                                                                                           * 415525200984874L)
                                                                                                           */);
                                                break;
                                            case 5:
                                                cnh.ac(this.b.dc(), "https://github.com/KitsunePie/QQCleaner" /*
                                                                                                               * cnb.z(-
                                                                                                               * 415404941900586L)
                                                                                                               */);
                                                break;
                                            case 6:
                                                cnh.ac(this.b.dc(), "https://github.com/LSPosed/LSPosed" /*
                                                                                                          * cnb.z(-
                                                                                                          * 414683387394858L)
                                                                                                          */);
                                                break;
                                            case 7:
                                                cnh.ac(this.b.dc(), "https://github.com/Rosemoe/sora-editor" /*
                                                                                                              * cnb.z(-
                                                                                                              * 415048459615018L)
                                                                                                              */);
                                                break;
                                            case 8:
                                                cnh.ac(this.b.dc(), "https://github.com/Lagrio" /*
                                                                                                 * cnb.z(-
                                                                                                 * 414863776021290L)
                                                                                                 */);
                                                break;
                                            case 9:
                                                cnh.ac(this.b.dc(), "https://github.com/HdShare/WAuxiliary_Public" /*
                                                                                                                    * cnb
                                                                                                                    * .z
                                                                                                                    * (-
                                                                                                                    * 417556720515882L)
                                                                                                                    */);
                                                break;
                                            case 10:
                                                KotlinHelpers2.ar(this.b).j(R.id.policyFragment,
                                                        bht.r(new Pair("showOnly" /* "showOnly" /* "showOnly" /* cnb.z(-415645460069162L)  */,
                                                                Boolean.TRUE)));
                                                break;
                                            case 11:
                                                this.b.a.a("wauxv_config.zip" /* "wauxv_config.zip" /* "wauxv_config.zip" /* cnb.z(-417376331889450L)  */);
                                                break;
                                            case 12:
                                                this.b.b.a("application/zip" /* "application/zip" /* "application/zip" /* cnb.z(-417303317445418L)  */);
                                                break;
                                            case 13:
                                                cnh.ac(this.b.dc(), "https://t.me/Hd_WAuxiliary_CI" /*
                                                                                                     * cnb.z(-
                                                                                                     * 417784353782570L)
                                                                                                     */);
                                                break;
                                            case 14:
                                                cnh.ac(this.b.dc(), "https://t.me/Hd_WAuxiliary" /*
                                                                                                  * cnb.z(-
                                                                                                  * 417707044371242L)
                                                                                                  */);
                                                break;
                                            case 15:
                                                cnh.ac(this.b.dc(), "https://github.com/HdShare/WAuxiliary_Plugin" /*
                                                                                                                    * cnb
                                                                                                                    * .z
                                                                                                                    * (-
                                                                                                                    * 416848050912042L)
                                                                                                                    */);
                                                break;
                                            case 16:
                                                api apiVar = api.a;
                                                Context contextDc = this.b.dc();
                                                String strZ3 = "m02krT/t'4E_$jgJt=2LKNe" /* "m02krT/t'4E_$jgJt=2LKNe" /* "m02krT/t'4E_$jgJt=2LKNe" /* cnb.z(-417187353328426L)  */;
                                                apiVar.getClass();
                                                api.tryGetClassByName(contextDc, strZ3);
                                                break;
                                            case 17:
                                                cnh.ac(this.b.dc(), "https://afdian.com/a/hdshare" /*
                                                                                                    * cnb.z(-
                                                                                                    * 417084274113322L)
                                                                                                    */);
                                                break;
                                            case 18:
                                                api apiVar2 = api.a;
                                                Context contextDc2 = this.b.dc();
                                                String strZ4 = "m0eZ$'Q@C9@1WK:'#+D~Bw" /* "m0eZ$'Q@C9@1WK:'#+D~Bw" /* "m0eZ$'Q@C9@1WK:'#+D~Bw" /* cnb.z(-414176581253930L)  */;
                                                apiVar2.getClass();
                                                api.tryGetClassByName(contextDc2, strZ4);
                                                break;
                                            case 19:
                                                cnh.ac(this.b.dc(), "https://afdian.com/a/suzhelan" /*
                                                                                                     * cnb.z(-
                                                                                                     * 414077797006122L)
                                                                                                     */);
                                                break;
                                            case 20:
                                                cnh.ac(this.b.dc(), "https://github.com/HighCapable/YukiHookAPI" /*
                                                                                                                  * cnb.
                                                                                                                  * z(-
                                                                                                                  * 414000487594794L)
                                                                                                                  */);
                                                break;
                                            case 21:
                                                cnh.ac(this.b.dc(), "https://github.com/HighCapable/KavaRef" /*
                                                                                                              * cnb.z(-
                                                                                                              * 414314020207402L)
                                                                                                              */);
                                                break;
                                            default:
                                                cnh.ac(this.b.dc(),
                                                        "https://github.com/BetterAndroid/BetterAndroid" /*
                                                                                                          * cnb.z(-
                                                                                                          * 413596760668970L)
                                                                                                          */);
                                                break;
                                        }
                                    }
                                }),
                        new ny("QAuxiliary" /* "QAuxiliary" /* "QAuxiliary" /* cnb.z(-416435734051626L)  */, "cinit" /* "cinit" /* "cinit" /* cnb.z(-416354129673002L)  */,
                                new View.OnClickListener(this) { // from class: me.hd.wauxv.obf.e
                                    public final /* synthetic */ j b;

                                    {
                                        this.b = this;
                                    }

                                    @Override // android.view.View.OnClickListener
                                    public final void onClick(View view2) {
                                        switch (i3) {
                                            case 0:
                                                cnh.ac(this.b.dc(), "https://github.com/BetterAndroid/Hikage" /*
                                                                                                               * cnb.z(-
                                                                                                               * 413446436813610L)
                                                                                                               */);
                                                break;
                                            case 1:
                                                cnh.ac(this.b.dc(), "https://github.com/LuckyPray/DexKit" /*
                                                                                                           * cnb.z(-
                                                                                                           * 413824393935658L)
                                                                                                           */);
                                                break;
                                            case 2:
                                                cnh.ac(this.b.dc(), "https://github.com/cinit/QAuxiliary" /*
                                                                                                           * cnb.z(-
                                                                                                           * 415284682816298L)
                                                                                                           */);
                                                break;
                                            case 3:
                                                cnh.ac(this.b.dc(), "https://github.com/suzhelan/TimTool" /*
                                                                                                           * cnb.z(-
                                                                                                           * 415164423732010L)
                                                                                                           */);
                                                break;
                                            case 4:
                                                cnh.ac(this.b.dc(), "https://github.com/fankes/TSBattery" /*
                                                                                                           * cnb.z(-
                                                                                                           * 415525200984874L)
                                                                                                           */);
                                                break;
                                            case 5:
                                                cnh.ac(this.b.dc(), "https://github.com/KitsunePie/QQCleaner" /*
                                                                                                               * cnb.z(-
                                                                                                               * 415404941900586L)
                                                                                                               */);
                                                break;
                                            case 6:
                                                cnh.ac(this.b.dc(), "https://github.com/LSPosed/LSPosed" /*
                                                                                                          * cnb.z(-
                                                                                                          * 414683387394858L)
                                                                                                          */);
                                                break;
                                            case 7:
                                                cnh.ac(this.b.dc(), "https://github.com/Rosemoe/sora-editor" /*
                                                                                                              * cnb.z(-
                                                                                                              * 415048459615018L)
                                                                                                              */);
                                                break;
                                            case 8:
                                                cnh.ac(this.b.dc(), "https://github.com/Lagrio" /*
                                                                                                 * cnb.z(-
                                                                                                 * 414863776021290L)
                                                                                                 */);
                                                break;
                                            case 9:
                                                cnh.ac(this.b.dc(), "https://github.com/HdShare/WAuxiliary_Public" /*
                                                                                                                    * cnb
                                                                                                                    * .z
                                                                                                                    * (-
                                                                                                                    * 417556720515882L)
                                                                                                                    */);
                                                break;
                                            case 10:
                                                KotlinHelpers2.ar(this.b).j(R.id.policyFragment,
                                                        bht.r(new Pair("showOnly" /* "showOnly" /* "showOnly" /* cnb.z(-415645460069162L)  */,
                                                                Boolean.TRUE)));
                                                break;
                                            case 11:
                                                this.b.a.a("wauxv_config.zip" /* "wauxv_config.zip" /* "wauxv_config.zip" /* cnb.z(-417376331889450L)  */);
                                                break;
                                            case 12:
                                                this.b.b.a("application/zip" /* "application/zip" /* "application/zip" /* cnb.z(-417303317445418L)  */);
                                                break;
                                            case 13:
                                                cnh.ac(this.b.dc(), "https://t.me/Hd_WAuxiliary_CI" /*
                                                                                                     * cnb.z(-
                                                                                                     * 417784353782570L)
                                                                                                     */);
                                                break;
                                            case 14:
                                                cnh.ac(this.b.dc(), "https://t.me/Hd_WAuxiliary" /*
                                                                                                  * cnb.z(-
                                                                                                  * 417707044371242L)
                                                                                                  */);
                                                break;
                                            case 15:
                                                cnh.ac(this.b.dc(), "https://github.com/HdShare/WAuxiliary_Plugin" /*
                                                                                                                    * cnb
                                                                                                                    * .z
                                                                                                                    * (-
                                                                                                                    * 416848050912042L)
                                                                                                                    */);
                                                break;
                                            case 16:
                                                api apiVar = api.a;
                                                Context contextDc = this.b.dc();
                                                String strZ3 = "m02krT/t'4E_$jgJt=2LKNe" /* "m02krT/t'4E_$jgJt=2LKNe" /* "m02krT/t'4E_$jgJt=2LKNe" /* cnb.z(-417187353328426L)  */;
                                                apiVar.getClass();
                                                api.tryGetClassByName(contextDc, strZ3);
                                                break;
                                            case 17:
                                                cnh.ac(this.b.dc(), "https://afdian.com/a/hdshare" /*
                                                                                                    * cnb.z(-
                                                                                                    * 417084274113322L)
                                                                                                    */);
                                                break;
                                            case 18:
                                                api apiVar2 = api.a;
                                                Context contextDc2 = this.b.dc();
                                                String strZ4 = "m0eZ$'Q@C9@1WK:'#+D~Bw" /* "m0eZ$'Q@C9@1WK:'#+D~Bw" /* "m0eZ$'Q@C9@1WK:'#+D~Bw" /* cnb.z(-414176581253930L)  */;
                                                apiVar2.getClass();
                                                api.tryGetClassByName(contextDc2, strZ4);
                                                break;
                                            case 19:
                                                cnh.ac(this.b.dc(), "https://afdian.com/a/suzhelan" /*
                                                                                                     * cnb.z(-
                                                                                                     * 414077797006122L)
                                                                                                     */);
                                                break;
                                            case 20:
                                                cnh.ac(this.b.dc(), "https://github.com/HighCapable/YukiHookAPI" /*
                                                                                                                  * cnb.
                                                                                                                  * z(-
                                                                                                                  * 414000487594794L)
                                                                                                                  */);
                                                break;
                                            case 21:
                                                cnh.ac(this.b.dc(), "https://github.com/HighCapable/KavaRef" /*
                                                                                                              * cnb.z(-
                                                                                                              * 414314020207402L)
                                                                                                              */);
                                                break;
                                            default:
                                                cnh.ac(this.b.dc(),
                                                        "https://github.com/BetterAndroid/BetterAndroid" /*
                                                                                                          * cnb.z(-
                                                                                                          * 413596760668970L)
                                                                                                          */);
                                                break;
                                        }
                                    }
                                }),
                        new ny("TimTool" /* "TimTool" /* "TimTool" /* cnb.z(-416311180000042L)  */, "suzhelan" /* "suzhelan" /* "suzhelan" /* cnb.z(-416276820261674L)  */,
                                new View.OnClickListener(this) { // from class: me.hd.wauxv.obf.e
                                    public final /* synthetic */ j b;

                                    {
                                        this.b = this;
                                    }

                                    @Override // android.view.View.OnClickListener
                                    public final void onClick(View view2) {
                                        switch (i5) {
                                            case 0:
                                                cnh.ac(this.b.dc(), "https://github.com/BetterAndroid/Hikage" /*
                                                                                                               * cnb.z(-
                                                                                                               * 413446436813610L)
                                                                                                               */);
                                                break;
                                            case 1:
                                                cnh.ac(this.b.dc(), "https://github.com/LuckyPray/DexKit" /*
                                                                                                           * cnb.z(-
                                                                                                           * 413824393935658L)
                                                                                                           */);
                                                break;
                                            case 2:
                                                cnh.ac(this.b.dc(), "https://github.com/cinit/QAuxiliary" /*
                                                                                                           * cnb.z(-
                                                                                                           * 415284682816298L)
                                                                                                           */);
                                                break;
                                            case 3:
                                                cnh.ac(this.b.dc(), "https://github.com/suzhelan/TimTool" /*
                                                                                                           * cnb.z(-
                                                                                                           * 415164423732010L)
                                                                                                           */);
                                                break;
                                            case 4:
                                                cnh.ac(this.b.dc(), "https://github.com/fankes/TSBattery" /*
                                                                                                           * cnb.z(-
                                                                                                           * 415525200984874L)
                                                                                                           */);
                                                break;
                                            case 5:
                                                cnh.ac(this.b.dc(), "https://github.com/KitsunePie/QQCleaner" /*
                                                                                                               * cnb.z(-
                                                                                                               * 415404941900586L)
                                                                                                               */);
                                                break;
                                            case 6:
                                                cnh.ac(this.b.dc(), "https://github.com/LSPosed/LSPosed" /*
                                                                                                          * cnb.z(-
                                                                                                          * 414683387394858L)
                                                                                                          */);
                                                break;
                                            case 7:
                                                cnh.ac(this.b.dc(), "https://github.com/Rosemoe/sora-editor" /*
                                                                                                              * cnb.z(-
                                                                                                              * 415048459615018L)
                                                                                                              */);
                                                break;
                                            case 8:
                                                cnh.ac(this.b.dc(), "https://github.com/Lagrio" /*
                                                                                                 * cnb.z(-
                                                                                                 * 414863776021290L)
                                                                                                 */);
                                                break;
                                            case 9:
                                                cnh.ac(this.b.dc(), "https://github.com/HdShare/WAuxiliary_Public" /*
                                                                                                                    * cnb
                                                                                                                    * .z
                                                                                                                    * (-
                                                                                                                    * 417556720515882L)
                                                                                                                    */);
                                                break;
                                            case 10:
                                                KotlinHelpers2.ar(this.b).j(R.id.policyFragment,
                                                        bht.r(new Pair("showOnly" /* "showOnly" /* "showOnly" /* cnb.z(-415645460069162L)  */,
                                                                Boolean.TRUE)));
                                                break;
                                            case 11:
                                                this.b.a.a("wauxv_config.zip" /* "wauxv_config.zip" /* "wauxv_config.zip" /* cnb.z(-417376331889450L)  */);
                                                break;
                                            case 12:
                                                this.b.b.a("application/zip" /* "application/zip" /* "application/zip" /* cnb.z(-417303317445418L)  */);
                                                break;
                                            case 13:
                                                cnh.ac(this.b.dc(), "https://t.me/Hd_WAuxiliary_CI" /*
                                                                                                     * cnb.z(-
                                                                                                     * 417784353782570L)
                                                                                                     */);
                                                break;
                                            case 14:
                                                cnh.ac(this.b.dc(), "https://t.me/Hd_WAuxiliary" /*
                                                                                                  * cnb.z(-
                                                                                                  * 417707044371242L)
                                                                                                  */);
                                                break;
                                            case 15:
                                                cnh.ac(this.b.dc(), "https://github.com/HdShare/WAuxiliary_Plugin" /*
                                                                                                                    * cnb
                                                                                                                    * .z
                                                                                                                    * (-
                                                                                                                    * 416848050912042L)
                                                                                                                    */);
                                                break;
                                            case 16:
                                                api apiVar = api.a;
                                                Context contextDc = this.b.dc();
                                                String strZ3 = "m02krT/t'4E_$jgJt=2LKNe" /* "m02krT/t'4E_$jgJt=2LKNe" /* "m02krT/t'4E_$jgJt=2LKNe" /* cnb.z(-417187353328426L)  */;
                                                apiVar.getClass();
                                                api.tryGetClassByName(contextDc, strZ3);
                                                break;
                                            case 17:
                                                cnh.ac(this.b.dc(), "https://afdian.com/a/hdshare" /*
                                                                                                    * cnb.z(-
                                                                                                    * 417084274113322L)
                                                                                                    */);
                                                break;
                                            case 18:
                                                api apiVar2 = api.a;
                                                Context contextDc2 = this.b.dc();
                                                String strZ4 = "m0eZ$'Q@C9@1WK:'#+D~Bw" /* "m0eZ$'Q@C9@1WK:'#+D~Bw" /* "m0eZ$'Q@C9@1WK:'#+D~Bw" /* cnb.z(-414176581253930L)  */;
                                                apiVar2.getClass();
                                                api.tryGetClassByName(contextDc2, strZ4);
                                                break;
                                            case 19:
                                                cnh.ac(this.b.dc(), "https://afdian.com/a/suzhelan" /*
                                                                                                     * cnb.z(-
                                                                                                     * 414077797006122L)
                                                                                                     */);
                                                break;
                                            case 20:
                                                cnh.ac(this.b.dc(), "https://github.com/HighCapable/YukiHookAPI" /*
                                                                                                                  * cnb.
                                                                                                                  * z(-
                                                                                                                  * 414000487594794L)
                                                                                                                  */);
                                                break;
                                            case 21:
                                                cnh.ac(this.b.dc(), "https://github.com/HighCapable/KavaRef" /*
                                                                                                              * cnb.z(-
                                                                                                              * 414314020207402L)
                                                                                                              */);
                                                break;
                                            default:
                                                cnh.ac(this.b.dc(),
                                                        "https://github.com/BetterAndroid/BetterAndroid" /*
                                                                                                          * cnb.z(-
                                                                                                          * 413596760668970L)
                                                                                                          */);
                                                break;
                                        }
                                    }
                                }),
                        new ny("TSBattery" /* "TSBattery" /* "TSBattery" /* cnb.z(-416238165556010L)  */, "fankes" /* "fankes" /* "fankes" /* cnb.z(-416212395752234L)  */,
                                new View.OnClickListener(this) { // from class: me.hd.wauxv.obf.e
                                    public final /* synthetic */ j b;

                                    {
                                        this.b = this;
                                    }

                                    @Override // android.view.View.OnClickListener
                                    public final void onClick(View view2) {
                                        switch (i2) {
                                            case 0:
                                                cnh.ac(this.b.dc(), "https://github.com/BetterAndroid/Hikage" /*
                                                                                                               * cnb.z(-
                                                                                                               * 413446436813610L)
                                                                                                               */);
                                                break;
                                            case 1:
                                                cnh.ac(this.b.dc(), "https://github.com/LuckyPray/DexKit" /*
                                                                                                           * cnb.z(-
                                                                                                           * 413824393935658L)
                                                                                                           */);
                                                break;
                                            case 2:
                                                cnh.ac(this.b.dc(), "https://github.com/cinit/QAuxiliary" /*
                                                                                                           * cnb.z(-
                                                                                                           * 415284682816298L)
                                                                                                           */);
                                                break;
                                            case 3:
                                                cnh.ac(this.b.dc(), "https://github.com/suzhelan/TimTool" /*
                                                                                                           * cnb.z(-
                                                                                                           * 415164423732010L)
                                                                                                           */);
                                                break;
                                            case 4:
                                                cnh.ac(this.b.dc(), "https://github.com/fankes/TSBattery" /*
                                                                                                           * cnb.z(-
                                                                                                           * 415525200984874L)
                                                                                                           */);
                                                break;
                                            case 5:
                                                cnh.ac(this.b.dc(), "https://github.com/KitsunePie/QQCleaner" /*
                                                                                                               * cnb.z(-
                                                                                                               * 415404941900586L)
                                                                                                               */);
                                                break;
                                            case 6:
                                                cnh.ac(this.b.dc(), "https://github.com/LSPosed/LSPosed" /*
                                                                                                          * cnb.z(-
                                                                                                          * 414683387394858L)
                                                                                                          */);
                                                break;
                                            case 7:
                                                cnh.ac(this.b.dc(), "https://github.com/Rosemoe/sora-editor" /*
                                                                                                              * cnb.z(-
                                                                                                              * 415048459615018L)
                                                                                                              */);
                                                break;
                                            case 8:
                                                cnh.ac(this.b.dc(), "https://github.com/Lagrio" /*
                                                                                                 * cnb.z(-
                                                                                                 * 414863776021290L)
                                                                                                 */);
                                                break;
                                            case 9:
                                                cnh.ac(this.b.dc(), "https://github.com/HdShare/WAuxiliary_Public" /*
                                                                                                                    * cnb
                                                                                                                    * .z
                                                                                                                    * (-
                                                                                                                    * 417556720515882L)
                                                                                                                    */);
                                                break;
                                            case 10:
                                                KotlinHelpers2.ar(this.b).j(R.id.policyFragment,
                                                        bht.r(new Pair("showOnly" /* "showOnly" /* "showOnly" /* cnb.z(-415645460069162L)  */,
                                                                Boolean.TRUE)));
                                                break;
                                            case 11:
                                                this.b.a.a("wauxv_config.zip" /* "wauxv_config.zip" /* "wauxv_config.zip" /* cnb.z(-417376331889450L)  */);
                                                break;
                                            case 12:
                                                this.b.b.a("application/zip" /* "application/zip" /* "application/zip" /* cnb.z(-417303317445418L)  */);
                                                break;
                                            case 13:
                                                cnh.ac(this.b.dc(), "https://t.me/Hd_WAuxiliary_CI" /*
                                                                                                     * cnb.z(-
                                                                                                     * 417784353782570L)
                                                                                                     */);
                                                break;
                                            case 14:
                                                cnh.ac(this.b.dc(), "https://t.me/Hd_WAuxiliary" /*
                                                                                                  * cnb.z(-
                                                                                                  * 417707044371242L)
                                                                                                  */);
                                                break;
                                            case 15:
                                                cnh.ac(this.b.dc(), "https://github.com/HdShare/WAuxiliary_Plugin" /*
                                                                                                                    * cnb
                                                                                                                    * .z
                                                                                                                    * (-
                                                                                                                    * 416848050912042L)
                                                                                                                    */);
                                                break;
                                            case 16:
                                                api apiVar = api.a;
                                                Context contextDc = this.b.dc();
                                                String strZ3 = "m02krT/t'4E_$jgJt=2LKNe" /* "m02krT/t'4E_$jgJt=2LKNe" /* "m02krT/t'4E_$jgJt=2LKNe" /* cnb.z(-417187353328426L)  */;
                                                apiVar.getClass();
                                                api.tryGetClassByName(contextDc, strZ3);
                                                break;
                                            case 17:
                                                cnh.ac(this.b.dc(), "https://afdian.com/a/hdshare" /*
                                                                                                    * cnb.z(-
                                                                                                    * 417084274113322L)
                                                                                                    */);
                                                break;
                                            case 18:
                                                api apiVar2 = api.a;
                                                Context contextDc2 = this.b.dc();
                                                String strZ4 = "m0eZ$'Q@C9@1WK:'#+D~Bw" /* "m0eZ$'Q@C9@1WK:'#+D~Bw" /* "m0eZ$'Q@C9@1WK:'#+D~Bw" /* cnb.z(-414176581253930L)  */;
                                                apiVar2.getClass();
                                                api.tryGetClassByName(contextDc2, strZ4);
                                                break;
                                            case 19:
                                                cnh.ac(this.b.dc(), "https://afdian.com/a/suzhelan" /*
                                                                                                     * cnb.z(-
                                                                                                     * 414077797006122L)
                                                                                                     */);
                                                break;
                                            case 20:
                                                cnh.ac(this.b.dc(), "https://github.com/HighCapable/YukiHookAPI" /*
                                                                                                                  * cnb.
                                                                                                                  * z(-
                                                                                                                  * 414000487594794L)
                                                                                                                  */);
                                                break;
                                            case 21:
                                                cnh.ac(this.b.dc(), "https://github.com/HighCapable/KavaRef" /*
                                                                                                              * cnb.z(-
                                                                                                              * 414314020207402L)
                                                                                                              */);
                                                break;
                                            default:
                                                cnh.ac(this.b.dc(),
                                                        "https://github.com/BetterAndroid/BetterAndroid" /*
                                                                                                          * cnb.z(-
                                                                                                          * 413596760668970L)
                                                                                                          */);
                                                break;
                                        }
                                    }
                                }),
                        new ny("QQCleaner" /* "QQCleaner" /* "QQCleaner" /* cnb.z(-416182330981162L)  */, "KitsunePie" /* "KitsunePie" /* "KitsunePie" /* cnb.z(-416706316991274L)  */,
                                new View.OnClickListener(this) { // from class: me.hd.wauxv.obf.e
                                    public final /* synthetic */ j b;

                                    {
                                        this.b = this;
                                    }

                                    @Override // android.view.View.OnClickListener
                                    public final void onClick(View view2) {
                                        switch (i20) {
                                            case 0:
                                                cnh.ac(this.b.dc(), "https://github.com/BetterAndroid/Hikage" /*
                                                                                                               * cnb.z(-
                                                                                                               * 413446436813610L)
                                                                                                               */);
                                                break;
                                            case 1:
                                                cnh.ac(this.b.dc(), "https://github.com/LuckyPray/DexKit" /*
                                                                                                           * cnb.z(-
                                                                                                           * 413824393935658L)
                                                                                                           */);
                                                break;
                                            case 2:
                                                cnh.ac(this.b.dc(), "https://github.com/cinit/QAuxiliary" /*
                                                                                                           * cnb.z(-
                                                                                                           * 415284682816298L)
                                                                                                           */);
                                                break;
                                            case 3:
                                                cnh.ac(this.b.dc(), "https://github.com/suzhelan/TimTool" /*
                                                                                                           * cnb.z(-
                                                                                                           * 415164423732010L)
                                                                                                           */);
                                                break;
                                            case 4:
                                                cnh.ac(this.b.dc(), "https://github.com/fankes/TSBattery" /*
                                                                                                           * cnb.z(-
                                                                                                           * 415525200984874L)
                                                                                                           */);
                                                break;
                                            case 5:
                                                cnh.ac(this.b.dc(), "https://github.com/KitsunePie/QQCleaner" /*
                                                                                                               * cnb.z(-
                                                                                                               * 415404941900586L)
                                                                                                               */);
                                                break;
                                            case 6:
                                                cnh.ac(this.b.dc(), "https://github.com/LSPosed/LSPosed" /*
                                                                                                          * cnb.z(-
                                                                                                          * 414683387394858L)
                                                                                                          */);
                                                break;
                                            case 7:
                                                cnh.ac(this.b.dc(), "https://github.com/Rosemoe/sora-editor" /*
                                                                                                              * cnb.z(-
                                                                                                              * 415048459615018L)
                                                                                                              */);
                                                break;
                                            case 8:
                                                cnh.ac(this.b.dc(), "https://github.com/Lagrio" /*
                                                                                                 * cnb.z(-
                                                                                                 * 414863776021290L)
                                                                                                 */);
                                                break;
                                            case 9:
                                                cnh.ac(this.b.dc(), "https://github.com/HdShare/WAuxiliary_Public" /*
                                                                                                                    * cnb
                                                                                                                    * .z
                                                                                                                    * (-
                                                                                                                    * 417556720515882L)
                                                                                                                    */);
                                                break;
                                            case 10:
                                                KotlinHelpers2.ar(this.b).j(R.id.policyFragment,
                                                        bht.r(new Pair("showOnly" /* "showOnly" /* "showOnly" /* cnb.z(-415645460069162L)  */,
                                                                Boolean.TRUE)));
                                                break;
                                            case 11:
                                                this.b.a.a("wauxv_config.zip" /* "wauxv_config.zip" /* "wauxv_config.zip" /* cnb.z(-417376331889450L)  */);
                                                break;
                                            case 12:
                                                this.b.b.a("application/zip" /* "application/zip" /* "application/zip" /* cnb.z(-417303317445418L)  */);
                                                break;
                                            case 13:
                                                cnh.ac(this.b.dc(), "https://t.me/Hd_WAuxiliary_CI" /*
                                                                                                     * cnb.z(-
                                                                                                     * 417784353782570L)
                                                                                                     */);
                                                break;
                                            case 14:
                                                cnh.ac(this.b.dc(), "https://t.me/Hd_WAuxiliary" /*
                                                                                                  * cnb.z(-
                                                                                                  * 417707044371242L)
                                                                                                  */);
                                                break;
                                            case 15:
                                                cnh.ac(this.b.dc(), "https://github.com/HdShare/WAuxiliary_Plugin" /*
                                                                                                                    * cnb
                                                                                                                    * .z
                                                                                                                    * (-
                                                                                                                    * 416848050912042L)
                                                                                                                    */);
                                                break;
                                            case 16:
                                                api apiVar = api.a;
                                                Context contextDc = this.b.dc();
                                                String strZ3 = "m02krT/t'4E_$jgJt=2LKNe" /* "m02krT/t'4E_$jgJt=2LKNe" /* "m02krT/t'4E_$jgJt=2LKNe" /* cnb.z(-417187353328426L)  */;
                                                apiVar.getClass();
                                                api.tryGetClassByName(contextDc, strZ3);
                                                break;
                                            case 17:
                                                cnh.ac(this.b.dc(), "https://afdian.com/a/hdshare" /*
                                                                                                    * cnb.z(-
                                                                                                    * 417084274113322L)
                                                                                                    */);
                                                break;
                                            case 18:
                                                api apiVar2 = api.a;
                                                Context contextDc2 = this.b.dc();
                                                String strZ4 = "m0eZ$'Q@C9@1WK:'#+D~Bw" /* "m0eZ$'Q@C9@1WK:'#+D~Bw" /* "m0eZ$'Q@C9@1WK:'#+D~Bw" /* cnb.z(-414176581253930L)  */;
                                                apiVar2.getClass();
                                                api.tryGetClassByName(contextDc2, strZ4);
                                                break;
                                            case 19:
                                                cnh.ac(this.b.dc(), "https://afdian.com/a/suzhelan" /*
                                                                                                     * cnb.z(-
                                                                                                     * 414077797006122L)
                                                                                                     */);
                                                break;
                                            case 20:
                                                cnh.ac(this.b.dc(), "https://github.com/HighCapable/YukiHookAPI" /*
                                                                                                                  * cnb.
                                                                                                                  * z(-
                                                                                                                  * 414000487594794L)
                                                                                                                  */);
                                                break;
                                            case 21:
                                                cnh.ac(this.b.dc(), "https://github.com/HighCapable/KavaRef" /*
                                                                                                              * cnb.z(-
                                                                                                              * 414314020207402L)
                                                                                                              */);
                                                break;
                                            default:
                                                cnh.ac(this.b.dc(),
                                                        "https://github.com/BetterAndroid/BetterAndroid" /*
                                                                                                          * cnb.z(-
                                                                                                          * 413596760668970L)
                                                                                                          */);
                                                break;
                                        }
                                    }
                                }),
                        new ny("LSPosed" /* "LSPosed" /* "LSPosed" /* cnb.z(-416676252220202L)  */, "LSPosed" /* "LSPosed" /* "LSPosed" /* cnb.z(-416641892481834L)  */,
                                new View.OnClickListener(this) { // from class: me.hd.wauxv.obf.e
                                    public final /* synthetic */ j b;

                                    {
                                        this.b = this;
                                    }

                                    @Override // android.view.View.OnClickListener
                                    public final void onClick(View view2) {
                                        switch (i21) {
                                            case 0:
                                                cnh.ac(this.b.dc(), "https://github.com/BetterAndroid/Hikage" /*
                                                                                                               * cnb.z(-
                                                                                                               * 413446436813610L)
                                                                                                               */);
                                                break;
                                            case 1:
                                                cnh.ac(this.b.dc(), "https://github.com/LuckyPray/DexKit" /*
                                                                                                           * cnb.z(-
                                                                                                           * 413824393935658L)
                                                                                                           */);
                                                break;
                                            case 2:
                                                cnh.ac(this.b.dc(), "https://github.com/cinit/QAuxiliary" /*
                                                                                                           * cnb.z(-
                                                                                                           * 415284682816298L)
                                                                                                           */);
                                                break;
                                            case 3:
                                                cnh.ac(this.b.dc(), "https://github.com/suzhelan/TimTool" /*
                                                                                                           * cnb.z(-
                                                                                                           * 415164423732010L)
                                                                                                           */);
                                                break;
                                            case 4:
                                                cnh.ac(this.b.dc(), "https://github.com/fankes/TSBattery" /*
                                                                                                           * cnb.z(-
                                                                                                           * 415525200984874L)
                                                                                                           */);
                                                break;
                                            case 5:
                                                cnh.ac(this.b.dc(), "https://github.com/KitsunePie/QQCleaner" /*
                                                                                                               * cnb.z(-
                                                                                                               * 415404941900586L)
                                                                                                               */);
                                                break;
                                            case 6:
                                                cnh.ac(this.b.dc(), "https://github.com/LSPosed/LSPosed" /*
                                                                                                          * cnb.z(-
                                                                                                          * 414683387394858L)
                                                                                                          */);
                                                break;
                                            case 7:
                                                cnh.ac(this.b.dc(), "https://github.com/Rosemoe/sora-editor" /*
                                                                                                              * cnb.z(-
                                                                                                              * 415048459615018L)
                                                                                                              */);
                                                break;
                                            case 8:
                                                cnh.ac(this.b.dc(), "https://github.com/Lagrio" /*
                                                                                                 * cnb.z(-
                                                                                                 * 414863776021290L)
                                                                                                 */);
                                                break;
                                            case 9:
                                                cnh.ac(this.b.dc(), "https://github.com/HdShare/WAuxiliary_Public" /*
                                                                                                                    * cnb
                                                                                                                    * .z
                                                                                                                    * (-
                                                                                                                    * 417556720515882L)
                                                                                                                    */);
                                                break;
                                            case 10:
                                                KotlinHelpers2.ar(this.b).j(R.id.policyFragment,
                                                        bht.r(new Pair("showOnly" /* "showOnly" /* "showOnly" /* cnb.z(-415645460069162L)  */,
                                                                Boolean.TRUE)));
                                                break;
                                            case 11:
                                                this.b.a.a("wauxv_config.zip" /* "wauxv_config.zip" /* "wauxv_config.zip" /* cnb.z(-417376331889450L)  */);
                                                break;
                                            case 12:
                                                this.b.b.a("application/zip" /* "application/zip" /* "application/zip" /* cnb.z(-417303317445418L)  */);
                                                break;
                                            case 13:
                                                cnh.ac(this.b.dc(), "https://t.me/Hd_WAuxiliary_CI" /*
                                                                                                     * cnb.z(-
                                                                                                     * 417784353782570L)
                                                                                                     */);
                                                break;
                                            case 14:
                                                cnh.ac(this.b.dc(), "https://t.me/Hd_WAuxiliary" /*
                                                                                                  * cnb.z(-
                                                                                                  * 417707044371242L)
                                                                                                  */);
                                                break;
                                            case 15:
                                                cnh.ac(this.b.dc(), "https://github.com/HdShare/WAuxiliary_Plugin" /*
                                                                                                                    * cnb
                                                                                                                    * .z
                                                                                                                    * (-
                                                                                                                    * 416848050912042L)
                                                                                                                    */);
                                                break;
                                            case 16:
                                                api apiVar = api.a;
                                                Context contextDc = this.b.dc();
                                                String strZ3 = "m02krT/t'4E_$jgJt=2LKNe" /* "m02krT/t'4E_$jgJt=2LKNe" /* "m02krT/t'4E_$jgJt=2LKNe" /* cnb.z(-417187353328426L)  */;
                                                apiVar.getClass();
                                                api.tryGetClassByName(contextDc, strZ3);
                                                break;
                                            case 17:
                                                cnh.ac(this.b.dc(), "https://afdian.com/a/hdshare" /*
                                                                                                    * cnb.z(-
                                                                                                    * 417084274113322L)
                                                                                                    */);
                                                break;
                                            case 18:
                                                api apiVar2 = api.a;
                                                Context contextDc2 = this.b.dc();
                                                String strZ4 = "m0eZ$'Q@C9@1WK:'#+D~Bw" /* "m0eZ$'Q@C9@1WK:'#+D~Bw" /* "m0eZ$'Q@C9@1WK:'#+D~Bw" /* cnb.z(-414176581253930L)  */;
                                                apiVar2.getClass();
                                                api.tryGetClassByName(contextDc2, strZ4);
                                                break;
                                            case 19:
                                                cnh.ac(this.b.dc(), "https://afdian.com/a/suzhelan" /*
                                                                                                     * cnb.z(-
                                                                                                     * 414077797006122L)
                                                                                                     */);
                                                break;
                                            case 20:
                                                cnh.ac(this.b.dc(), "https://github.com/HighCapable/YukiHookAPI" /*
                                                                                                                  * cnb.
                                                                                                                  * z(-
                                                                                                                  * 414000487594794L)
                                                                                                                  */);
                                                break;
                                            case 21:
                                                cnh.ac(this.b.dc(), "https://github.com/HighCapable/KavaRef" /*
                                                                                                              * cnb.z(-
                                                                                                              * 414314020207402L)
                                                                                                              */);
                                                break;
                                            default:
                                                cnh.ac(this.b.dc(),
                                                        "https://github.com/BetterAndroid/BetterAndroid" /*
                                                                                                          * cnb.z(-
                                                                                                          * 413596760668970L)
                                                                                                          */);
                                                break;
                                        }
                                    }
                                }),
                        new ny("sora-editor" /* "sora-editor" /* "sora-editor" /* cnb.z(-416607532743466L)  */, "Rosemoe" /* "Rosemoe" /* "Rosemoe" /* cnb.z(-416521633397546L)  */,
                                new View.OnClickListener(this) { // from class: me.hd.wauxv.obf.e
                                    public final /* synthetic */ j b;

                                    {
                                        this.b = this;
                                    }

                                    @Override // android.view.View.OnClickListener
                                    public final void onClick(View view2) {
                                        switch (i22) {
                                            case 0:
                                                cnh.ac(this.b.dc(), "https://github.com/BetterAndroid/Hikage" /*
                                                                                                               * cnb.z(-
                                                                                                               * 413446436813610L)
                                                                                                               */);
                                                break;
                                            case 1:
                                                cnh.ac(this.b.dc(), "https://github.com/LuckyPray/DexKit" /*
                                                                                                           * cnb.z(-
                                                                                                           * 413824393935658L)
                                                                                                           */);
                                                break;
                                            case 2:
                                                cnh.ac(this.b.dc(), "https://github.com/cinit/QAuxiliary" /*
                                                                                                           * cnb.z(-
                                                                                                           * 415284682816298L)
                                                                                                           */);
                                                break;
                                            case 3:
                                                cnh.ac(this.b.dc(), "https://github.com/suzhelan/TimTool" /*
                                                                                                           * cnb.z(-
                                                                                                           * 415164423732010L)
                                                                                                           */);
                                                break;
                                            case 4:
                                                cnh.ac(this.b.dc(), "https://github.com/fankes/TSBattery" /*
                                                                                                           * cnb.z(-
                                                                                                           * 415525200984874L)
                                                                                                           */);
                                                break;
                                            case 5:
                                                cnh.ac(this.b.dc(), "https://github.com/KitsunePie/QQCleaner" /*
                                                                                                               * cnb.z(-
                                                                                                               * 415404941900586L)
                                                                                                               */);
                                                break;
                                            case 6:
                                                cnh.ac(this.b.dc(), "https://github.com/LSPosed/LSPosed" /*
                                                                                                          * cnb.z(-
                                                                                                          * 414683387394858L)
                                                                                                          */);
                                                break;
                                            case 7:
                                                cnh.ac(this.b.dc(), "https://github.com/Rosemoe/sora-editor" /*
                                                                                                              * cnb.z(-
                                                                                                              * 415048459615018L)
                                                                                                              */);
                                                break;
                                            case 8:
                                                cnh.ac(this.b.dc(), "https://github.com/Lagrio" /*
                                                                                                 * cnb.z(-
                                                                                                 * 414863776021290L)
                                                                                                 */);
                                                break;
                                            case 9:
                                                cnh.ac(this.b.dc(), "https://github.com/HdShare/WAuxiliary_Public" /*
                                                                                                                    * cnb
                                                                                                                    * .z
                                                                                                                    * (-
                                                                                                                    * 417556720515882L)
                                                                                                                    */);
                                                break;
                                            case 10:
                                                KotlinHelpers2.ar(this.b).j(R.id.policyFragment,
                                                        bht.r(new Pair("showOnly" /* "showOnly" /* "showOnly" /* cnb.z(-415645460069162L)  */,
                                                                Boolean.TRUE)));
                                                break;
                                            case 11:
                                                this.b.a.a("wauxv_config.zip" /* "wauxv_config.zip" /* "wauxv_config.zip" /* cnb.z(-417376331889450L)  */);
                                                break;
                                            case 12:
                                                this.b.b.a("application/zip" /* "application/zip" /* "application/zip" /* cnb.z(-417303317445418L)  */);
                                                break;
                                            case 13:
                                                cnh.ac(this.b.dc(), "https://t.me/Hd_WAuxiliary_CI" /*
                                                                                                     * cnb.z(-
                                                                                                     * 417784353782570L)
                                                                                                     */);
                                                break;
                                            case 14:
                                                cnh.ac(this.b.dc(), "https://t.me/Hd_WAuxiliary" /*
                                                                                                  * cnb.z(-
                                                                                                  * 417707044371242L)
                                                                                                  */);
                                                break;
                                            case 15:
                                                cnh.ac(this.b.dc(), "https://github.com/HdShare/WAuxiliary_Plugin" /*
                                                                                                                    * cnb
                                                                                                                    * .z
                                                                                                                    * (-
                                                                                                                    * 416848050912042L)
                                                                                                                    */);
                                                break;
                                            case 16:
                                                api apiVar = api.a;
                                                Context contextDc = this.b.dc();
                                                String strZ3 = "m02krT/t'4E_$jgJt=2LKNe" /* "m02krT/t'4E_$jgJt=2LKNe" /* "m02krT/t'4E_$jgJt=2LKNe" /* cnb.z(-417187353328426L)  */;
                                                apiVar.getClass();
                                                api.tryGetClassByName(contextDc, strZ3);
                                                break;
                                            case 17:
                                                cnh.ac(this.b.dc(), "https://afdian.com/a/hdshare" /*
                                                                                                    * cnb.z(-
                                                                                                    * 417084274113322L)
                                                                                                    */);
                                                break;
                                            case 18:
                                                api apiVar2 = api.a;
                                                Context contextDc2 = this.b.dc();
                                                String strZ4 = "m0eZ$'Q@C9@1WK:'#+D~Bw" /* "m0eZ$'Q@C9@1WK:'#+D~Bw" /* "m0eZ$'Q@C9@1WK:'#+D~Bw" /* cnb.z(-414176581253930L)  */;
                                                apiVar2.getClass();
                                                api.tryGetClassByName(contextDc2, strZ4);
                                                break;
                                            case 19:
                                                cnh.ac(this.b.dc(), "https://afdian.com/a/suzhelan" /*
                                                                                                     * cnb.z(-
                                                                                                     * 414077797006122L)
                                                                                                     */);
                                                break;
                                            case 20:
                                                cnh.ac(this.b.dc(), "https://github.com/HighCapable/YukiHookAPI" /*
                                                                                                                  * cnb.
                                                                                                                  * z(-
                                                                                                                  * 414000487594794L)
                                                                                                                  */);
                                                break;
                                            case 21:
                                                cnh.ac(this.b.dc(), "https://github.com/HighCapable/KavaRef" /*
                                                                                                              * cnb.z(-
                                                                                                              * 414314020207402L)
                                                                                                              */);
                                                break;
                                            default:
                                                cnh.ac(this.b.dc(),
                                                        "https://github.com/BetterAndroid/BetterAndroid" /*
                                                                                                          * cnb.z(-
                                                                                                          * 413596760668970L)
                                                                                                          */);
                                                break;
                                        }
                                    }
                                }),
                        new ny("Icon" /* "Icon" /* "Icon" /* cnb.z(-416487273659178L)  */, "MaiTungTM" /* "MaiTungTM" /* "MaiTungTM" /* cnb.z(-416448618953514L)  */,
                                new View.OnClickListener(this) { // from class: me.hd.wauxv.obf.e
                                    public final /* synthetic */ j b;

                                    {
                                        this.b = this;
                                    }

                                    @Override // android.view.View.OnClickListener
                                    public final void onClick(View view2) {
                                        switch (i23) {
                                            case 0:
                                                cnh.ac(this.b.dc(), "https://github.com/BetterAndroid/Hikage" /*
                                                                                                               * cnb.z(-
                                                                                                               * 413446436813610L)
                                                                                                               */);
                                                break;
                                            case 1:
                                                cnh.ac(this.b.dc(), "https://github.com/LuckyPray/DexKit" /*
                                                                                                           * cnb.z(-
                                                                                                           * 413824393935658L)
                                                                                                           */);
                                                break;
                                            case 2:
                                                cnh.ac(this.b.dc(), "https://github.com/cinit/QAuxiliary" /*
                                                                                                           * cnb.z(-
                                                                                                           * 415284682816298L)
                                                                                                           */);
                                                break;
                                            case 3:
                                                cnh.ac(this.b.dc(), "https://github.com/suzhelan/TimTool" /*
                                                                                                           * cnb.z(-
                                                                                                           * 415164423732010L)
                                                                                                           */);
                                                break;
                                            case 4:
                                                cnh.ac(this.b.dc(), "https://github.com/fankes/TSBattery" /*
                                                                                                           * cnb.z(-
                                                                                                           * 415525200984874L)
                                                                                                           */);
                                                break;
                                            case 5:
                                                cnh.ac(this.b.dc(), "https://github.com/KitsunePie/QQCleaner" /*
                                                                                                               * cnb.z(-
                                                                                                               * 415404941900586L)
                                                                                                               */);
                                                break;
                                            case 6:
                                                cnh.ac(this.b.dc(), "https://github.com/LSPosed/LSPosed" /*
                                                                                                          * cnb.z(-
                                                                                                          * 414683387394858L)
                                                                                                          */);
                                                break;
                                            case 7:
                                                cnh.ac(this.b.dc(), "https://github.com/Rosemoe/sora-editor" /*
                                                                                                              * cnb.z(-
                                                                                                              * 415048459615018L)
                                                                                                              */);
                                                break;
                                            case 8:
                                                cnh.ac(this.b.dc(), "https://github.com/Lagrio" /*
                                                                                                 * cnb.z(-
                                                                                                 * 414863776021290L)
                                                                                                 */);
                                                break;
                                            case 9:
                                                cnh.ac(this.b.dc(), "https://github.com/HdShare/WAuxiliary_Public" /*
                                                                                                                    * cnb
                                                                                                                    * .z
                                                                                                                    * (-
                                                                                                                    * 417556720515882L)
                                                                                                                    */);
                                                break;
                                            case 10:
                                                KotlinHelpers2.ar(this.b).j(R.id.policyFragment,
                                                        bht.r(new Pair("showOnly" /* "showOnly" /* "showOnly" /* cnb.z(-415645460069162L)  */,
                                                                Boolean.TRUE)));
                                                break;
                                            case 11:
                                                this.b.a.a("wauxv_config.zip" /* "wauxv_config.zip" /* "wauxv_config.zip" /* cnb.z(-417376331889450L)  */);
                                                break;
                                            case 12:
                                                this.b.b.a("application/zip" /* "application/zip" /* "application/zip" /* cnb.z(-417303317445418L)  */);
                                                break;
                                            case 13:
                                                cnh.ac(this.b.dc(), "https://t.me/Hd_WAuxiliary_CI" /*
                                                                                                     * cnb.z(-
                                                                                                     * 417784353782570L)
                                                                                                     */);
                                                break;
                                            case 14:
                                                cnh.ac(this.b.dc(), "https://t.me/Hd_WAuxiliary" /*
                                                                                                  * cnb.z(-
                                                                                                  * 417707044371242L)
                                                                                                  */);
                                                break;
                                            case 15:
                                                cnh.ac(this.b.dc(), "https://github.com/HdShare/WAuxiliary_Plugin" /*
                                                                                                                    * cnb
                                                                                                                    * .z
                                                                                                                    * (-
                                                                                                                    * 416848050912042L)
                                                                                                                    */);
                                                break;
                                            case 16:
                                                api apiVar = api.a;
                                                Context contextDc = this.b.dc();
                                                String strZ3 = "m02krT/t'4E_$jgJt=2LKNe" /* "m02krT/t'4E_$jgJt=2LKNe" /* "m02krT/t'4E_$jgJt=2LKNe" /* cnb.z(-417187353328426L)  */;
                                                apiVar.getClass();
                                                api.tryGetClassByName(contextDc, strZ3);
                                                break;
                                            case 17:
                                                cnh.ac(this.b.dc(), "https://afdian.com/a/hdshare" /*
                                                                                                    * cnb.z(-
                                                                                                    * 417084274113322L)
                                                                                                    */);
                                                break;
                                            case 18:
                                                api apiVar2 = api.a;
                                                Context contextDc2 = this.b.dc();
                                                String strZ4 = "m0eZ$'Q@C9@1WK:'#+D~Bw" /* "m0eZ$'Q@C9@1WK:'#+D~Bw" /* "m0eZ$'Q@C9@1WK:'#+D~Bw" /* cnb.z(-414176581253930L)  */;
                                                apiVar2.getClass();
                                                api.tryGetClassByName(contextDc2, strZ4);
                                                break;
                                            case 19:
                                                cnh.ac(this.b.dc(), "https://afdian.com/a/suzhelan" /*
                                                                                                     * cnb.z(-
                                                                                                     * 414077797006122L)
                                                                                                     */);
                                                break;
                                            case 20:
                                                cnh.ac(this.b.dc(), "https://github.com/HighCapable/YukiHookAPI" /*
                                                                                                                  * cnb.
                                                                                                                  * z(-
                                                                                                                  * 414000487594794L)
                                                                                                                  */);
                                                break;
                                            case 21:
                                                cnh.ac(this.b.dc(), "https://github.com/HighCapable/KavaRef" /*
                                                                                                              * cnb.z(-
                                                                                                              * 414314020207402L)
                                                                                                              */);
                                                break;
                                            default:
                                                cnh.ac(this.b.dc(),
                                                        "https://github.com/BetterAndroid/BetterAndroid" /*
                                                                                                          * cnb.z(-
                                                                                                          * 413596760668970L)
                                                                                                          */);
                                                break;
                                        }
                                    }
                                })))));
    }
}

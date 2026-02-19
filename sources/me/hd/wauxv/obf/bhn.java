package me.hd.wauxv.obf;

import android.content.Context;
import com.drake.net.exception.ConvertException;
import com.drake.net.exception.NetException;
import java.io.File;
import java.io.Serializable;
import java.util.concurrent.CancellationException;
import me.hd.wauxv.ui.activity.MainActivity;
import okhttp3.Response;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class bhn extends doi implements bgj {
    public final /* synthetic */ int a;
    public /* synthetic */ Object d;
    public final /* synthetic */ Serializable e;
    public final /* synthetic */ Object f;

    /*
     * JADX WARN: 'super' call moved to the top of the method (can break code
     * semantics)
     */
    public /* synthetic */ bhn(String str, IInvokable bgfVar, kotlinx$coroutines$internal$DispatchedContinuation afwVar, int i) {
        super(2, afwVar);
        this.a = i;
        this.e = str;
        this.f = bgfVar;
    }

    @Override // me.hd.wauxv.obf.bgj
    public final Object g(Object obj, Object obj2) throws Throwable {
        ahp ahpVar = (ahp) obj;
        kotlinx$coroutines$internal$DispatchedContinuation afwVar = (kotlinx$coroutines$internal$DispatchedContinuation) obj2;
        switch (this.a) {
            case 0:
                bhn bhnVar = (bhn) h(ahpVar, afwVar);
                Kotlin$Unit kotlinUnitVar = Kotlin$Unit.INSTANCE;
                bhnVar.i(kotlinUnitVar);
                return kotlinUnitVar;
            case 1:
                return ((bhn) h(ahpVar, afwVar)).i(Kotlin$Unit.INSTANCE);
            case 2:
                return ((bhn) h(ahpVar, afwVar)).i(Kotlin$Unit.INSTANCE);
            case 3:
                return ((bhn) h(ahpVar, afwVar)).i(Kotlin$Unit.INSTANCE);
            case 4:
                return ((bhn) h(ahpVar, afwVar)).i(Kotlin$Unit.INSTANCE);
            case 5:
                return ((bhn) h(ahpVar, afwVar)).i(Kotlin$Unit.INSTANCE);
            case 6:
                return ((bhn) h(ahpVar, afwVar)).i(Kotlin$Unit.INSTANCE);
            default:
                return ((bhn) h(ahpVar, afwVar)).i(Kotlin$Unit.INSTANCE);
        }
    }

    @Override // me.hd.wauxv.obf.nc
    public final kotlinx$coroutines$internal$DispatchedContinuation h(Object obj, kotlinx$coroutines$internal$DispatchedContinuation afwVar) {
        switch (this.a) {
            case 0:
                return new bhn((byx) this.d, (bhl) this.e, (MainActivity) this.f, afwVar);
            case 1:
                bhn bhnVar = new bhn((String) this.e, (beo) this.f, afwVar, 1);
                bhnVar.d = obj;
                return bhnVar;
            case 2:
                bhn bhnVar2 = new bhn((String) this.e, (beo) this.f, afwVar, 2);
                bhnVar2.d = obj;
                return bhnVar2;
            case 3:
                bhn bhnVar3 = new bhn((String) this.e, (beo) this.f, afwVar, 3);
                bhnVar3.d = obj;
                return bhnVar3;
            case 4:
                bhn bhnVar4 = new bhn((String) this.e, (beo) this.f, afwVar, 4);
                bhnVar4.d = obj;
                return bhnVar4;
            case 5:
                bhn bhnVar5 = new bhn((String) this.e, (beo) this.f, afwVar, 5);
                bhnVar5.d = obj;
                return bhnVar5;
            case 6:
                bhn bhnVar6 = new bhn((String) this.e, (beo) this.f, afwVar, 6);
                bhnVar6.d = obj;
                return bhnVar6;
            default:
                bhn bhnVar7 = new bhn((String) this.e, (beo) this.f, afwVar, 7);
                bhnVar7.d = obj;
                return bhnVar7;
        }
    }

    @Override // me.hd.wauxv.obf.nc
    public final Object i(Object obj) throws Throwable {
        int i = this.a;
        Object obj2 = this.f;
        Serializable serializable = this.e;
        switch (i) {
            case 0:
                FastKV.bd(obj);
                String strZ = "检测到差异版本" /* "检测到差异版本" /* "检测到差异版本" /* "检测到差异版本" /* cnb.z(-47704201755434L)   */;
                bhl bhlVar = (bhl) serializable;
                StringBuilder sb = new StringBuilder();
                sb.append("版本名 " /* "版本名 " /* "版本名 " /* "版本名 " /* cnb.z(-47669842017066L)   */ + bhlVar.a);
                sb.append('\n');
                sb.append("发布于 " /* "发布于 " /* "发布于 " /* "发布于 " /* cnb.z(-47631187311402L)   */ + bhlVar.d);
                sb.append('\n');
                sb.append("\n更新日志如下\n" /* "\n更新日志如下\n" /* "\n更新日志如下\n" /* "\n更新日志如下\n" /* cnb.z(-47644072213290L)   */);
                sb.append('\n');
                ((byx) this.d).b(strZ, concat(sb, bhlVar.c, '\n'), new ls((MainActivity) obj2, 2, bhlVar));
                return Kotlin$Unit.INSTANCE;
            case 1:
                FastKV.bd(obj);
                ahp ahpVar = (ahp) this.d;
                cna.q(ahpVar.e());
                eoj eojVar = new eoj();
                eojVar.j((String) serializable);
                eojVar.c = 1;
                eojVar.i(ahpVar.e()._w(arj.b));
                eojVar.k(null);
                ((beo) obj2).invoke(eojVar);
                Context context = ckv.a;
                dbv.a(eojVar.d, dal.c(File.class));
                Response responseExecute = eojVar.e.newCall(eojVar.f()).execute();
                try {
                    Object objB = bhs.p(responseExecute.request()).b(StaticHelpers7.am(dal.c(File.class)), responseExecute);
                    if (objB != null) {
                        return (File) objB;
                    }
                    throw new NullPointerException("null cannot be cast to non-null type java.io.File" /*
                                                                                                        * cnb.z(-
                                                                                                        * 544597558164266L)
                                                                                                        */);
                } catch (NetException e) {
                    throw e;
                } catch (CancellationException e2) {
                    throw e2;
                } catch (Throwable th) {
                    throw new ConvertException(responseExecute,
                            "An unexpected error occurred in the converter" /* "An unexpected error occurred in the converter" /* "An unexpected error occurred in the converter" /* "An unexpected error occurred in the converter" /* cnb.z(-541582491122474L)   */, th, null, 8,
                            null);
                }
            case 2:
                FastKV.bd(obj);
                ahp ahpVar2 = (ahp) this.d;
                cna.q(ahpVar2.e());
                eoj eojVar2 = new eoj();
                eojVar2.j((String) serializable);
                eojVar2.c = 1;
                eojVar2.i(ahpVar2.e()._w(arj.b));
                eojVar2.k(null);
                ((beo) obj2).invoke(eojVar2);
                Context context2 = ckv.a;
                dbv.a(eojVar2.d, dal.c(File.class));
                Response responseExecute2 = eojVar2.e.newCall(eojVar2.f()).execute();
                try {
                    Object objB2 = bhs.p(responseExecute2.request()).b(StaticHelpers7.am(dal.c(File.class)), responseExecute2);
                    if (objB2 != null) {
                        return (File) objB2;
                    }
                    throw new NullPointerException("null cannot be cast to non-null type java.io.File" /*
                                                                                                        * cnb.z(-
                                                                                                        * 580636628745002L)
                                                                                                        */);
                } catch (NetException e3) {
                    throw e3;
                } catch (CancellationException e4) {
                    throw e4;
                } catch (Throwable th2) {
                    throw new ConvertException(responseExecute2,
                            "An unexpected error occurred in the converter" /* "An unexpected error occurred in the converter" /* "An unexpected error occurred in the converter" /* "An unexpected error occurred in the converter" /* cnb.z(-580988816063274L)   */, th2, null,
                            8, null);
                }
            case 3:
                FastKV.bd(obj);
                ahp ahpVar3 = (ahp) this.d;
                cna.q(ahpVar3.e());
                eoj eojVar3 = new eoj();
                eojVar3.j((String) serializable);
                eojVar3.c = 1;
                eojVar3.i(ahpVar3.e()._w(arj.b));
                eojVar3.k(null);
                ((beo) obj2).invoke(eojVar3);
                Context context3 = ckv.a;
                dbv.a(eojVar3.d, dal.c(File.class));
                Response responseExecute3 = eojVar3.e.newCall(eojVar3.f()).execute();
                try {
                    Object objB3 = bhs.p(responseExecute3.request()).b(StaticHelpers7.am(dal.c(File.class)), responseExecute3);
                    if (objB3 != null) {
                        return (File) objB3;
                    }
                    throw new NullPointerException("null cannot be cast to non-null type java.io.File" /*
                                                                                                        * cnb.z(-
                                                                                                        * 582470579780394L)
                                                                                                        */);
                } catch (NetException e5) {
                    throw e5;
                } catch (CancellationException e6) {
                    throw e6;
                } catch (Throwable th3) {
                    throw new ConvertException(responseExecute3,
                            "An unexpected error occurred in the converter" /* "An unexpected error occurred in the converter" /* "An unexpected error occurred in the converter" /* "An unexpected error occurred in the converter" /* cnb.z(-581723255470890L)   */, th3, null,
                            8, null);
                }
            case 4:
                FastKV.bd(obj);
                ahp ahpVar4 = (ahp) this.d;
                cna.q(ahpVar4.e());
                eoj eojVar4 = new eoj();
                eojVar4.j((String) serializable);
                eojVar4.c = 1;
                eojVar4.i(ahpVar4.e()._w(arj.b));
                eojVar4.k(null);
                ((beo) obj2).invoke(eojVar4);
                Context context4 = ckv.a;
                dbv.a(eojVar4.d, dal.c(File.class));
                Response responseExecute4 = eojVar4.e.newCall(eojVar4.f()).execute();
                try {
                    Object objB4 = bhs.p(responseExecute4.request()).b(StaticHelpers7.am(dal.c(File.class)), responseExecute4);
                    if (objB4 != null) {
                        return (File) objB4;
                    }
                    throw new NullPointerException("null cannot be cast to non-null type java.io.File" /*
                                                                                                        * cnb.z(-
                                                                                                        * 588157116480298L)
                                                                                                        */);
                } catch (NetException e7) {
                    throw e7;
                } catch (CancellationException e8) {
                    throw e8;
                } catch (Throwable th4) {
                    throw new ConvertException(responseExecute4,
                            "An unexpected error occurred in the converter" /* "An unexpected error occurred in the converter" /* "An unexpected error occurred in the converter" /* "An unexpected error occurred in the converter" /* cnb.z(-587409792170794L)   */, th4, null,
                            8, null);
                }
            case 5:
                FastKV.bd(obj);
                ahp ahpVar5 = (ahp) this.d;
                cna.q(ahpVar5.e());
                eoj eojVar5 = new eoj();
                eojVar5.j((String) serializable);
                eojVar5.c = 1;
                eojVar5.i(ahpVar5.e()._w(arj.b));
                eojVar5.k(null);
                ((beo) obj2).invoke(eojVar5);
                Context context5 = ckv.a;
                dbv.a(eojVar5.d, dal.c(File.class));
                Response responseExecute5 = eojVar5.e.newCall(eojVar5.f()).execute();
                try {
                    Object objB5 = bhs.p(responseExecute5.request()).b(StaticHelpers7.am(dal.c(File.class)), responseExecute5);
                    if (objB5 != null) {
                        return (File) objB5;
                    }
                    throw new NullPointerException("null cannot be cast to non-null type java.io.File" /*
                                                                                                        * cnb.z(-
                                                                                                        * 585399747476266L)
                                                                                                        */);
                } catch (NetException e9) {
                    throw e9;
                } catch (CancellationException e10) {
                    throw e10;
                } catch (Throwable th5) {
                    throw new ConvertException(responseExecute5,
                            "An unexpected error occurred in the converter" /* "An unexpected error occurred in the converter" /* "An unexpected error occurred in the converter" /* "An unexpected error occurred in the converter" /* cnb.z(-586851446422314L)   */, th5, null,
                            8, null);
                }
            case 6:
                FastKV.bd(obj);
                ahp ahpVar6 = (ahp) this.d;
                cna.q(ahpVar6.e());
                eoj eojVar6 = new eoj();
                eojVar6.j((String) serializable);
                eojVar6.c = 1;
                eojVar6.i(ahpVar6.e()._w(arj.b));
                eojVar6.k(null);
                ((beo) obj2).invoke(eojVar6);
                Context context6 = ckv.a;
                dbv.a(eojVar6.d, dal.c(File.class));
                Response responseExecute6 = eojVar6.e.newCall(eojVar6.f()).execute();
                try {
                    Object objB6 = bhs.p(responseExecute6.request()).b(StaticHelpers7.am(dal.c(File.class)), responseExecute6);
                    if (objB6 != null) {
                        return (File) objB6;
                    }
                    throw new NullPointerException("null cannot be cast to non-null type java.io.File" /*
                                                                                                        * cnb.z(-
                                                                                                        * 586151366753066L)
                                                                                                        */);
                } catch (NetException e11) {
                    throw e11;
                } catch (CancellationException e12) {
                    throw e12;
                } catch (Throwable th6) {
                    throw new ConvertException(responseExecute6,
                            "An unexpected error occurred in the converter" /* "An unexpected error occurred in the converter" /* "An unexpected error occurred in the converter" /* "An unexpected error occurred in the converter" /* cnb.z(-586503554071338L)   */, th6, null,
                            8, null);
                }
            default:
                FastKV.bd(obj);
                ahp ahpVar7 = (ahp) this.d;
                cna.q(ahpVar7.e());
                eoj eojVar7 = new eoj();
                eojVar7.j((String) serializable);
                eojVar7.c = 1;
                eojVar7.i(ahpVar7.e()._w(arj.b));
                eojVar7.k(null);
                ((beo) obj2).invoke(eojVar7);
                Context context7 = ckv.a;
                dbv.a(eojVar7.d, dal.c(File.class));
                Response responseExecute7 = eojVar7.e.newCall(eojVar7.f()).execute();
                try {
                    Object objB7 = bhs.p(responseExecute7.request()).b(StaticHelpers7.am(dal.c(File.class)), responseExecute7);
                    if (objB7 != null) {
                        return (File) objB7;
                    }
                    throw new NullPointerException("null cannot be cast to non-null type java.io.File" /*
                                                                                                        * cnb.z(-
                                                                                                        * 609979845311274L)
                                                                                                        */);
                } catch (NetException e13) {
                    throw e13;
                } catch (CancellationException e14) {
                    throw e14;
                } catch (Throwable th7) {
                    throw new ConvertException(responseExecute7,
                            "An unexpected error occurred in the converter" /* "An unexpected error occurred in the converter" /* "An unexpected error occurred in the converter" /* "An unexpected error occurred in the converter" /* cnb.z(-609232521001770L)   */, th7, null,
                            8, null);
                }
        }
    }

    /*
     * JADX WARN: 'super' call moved to the top of the method (can break code
     * semantics)
     */
    public bhn(byx byxVar, bhl bhlVar, MainActivity mainActivity, kotlinx$coroutines$internal$DispatchedContinuation afwVar) {
        super(2, afwVar);
        this.a = 0;
        this.d = byxVar;
        this.e = bhlVar;
        this.f = mainActivity;
    }
}

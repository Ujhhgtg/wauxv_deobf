package me.hd.wauxv.obf;

import android.widget.ProgressBar;
import android.widget.TextView;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class eug extends doi implements bgj {
    public final /* synthetic */ long a;
    public final /* synthetic */ TextView d;
    public final /* synthetic */ int e;
    public final /* synthetic */ List f;
    public final /* synthetic */ ProgressBar o;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public eug(long j, TextView textView, int i, List list, ProgressBar progressBar, afw afwVar) {
        super(2, afwVar);
        this.a = j;
        this.d = textView;
        this.e = i;
        this.f = list;
        this.o = progressBar;
    }

    @Override // me.hd.wauxv.obf.bgj
    public final Object g(Object obj, Object obj2) throws Throwable {
        eug eugVar = (eug) h((ahp) obj, (afw) obj2);
        KotlinUnit kotlinUnitVar = KotlinUnit.INSTANCE;
        eugVar.i(kotlinUnitVar);
        return kotlinUnitVar;
    }

    @Override // me.hd.wauxv.obf.nc
    public final afw h(Object obj, afw afwVar) {
        return new eug(this.a, this.d, this.e, this.f, this.o, afwVar);
    }

    @Override // me.hd.wauxv.obf.nc
    public final Object i(Object obj) throws Throwable {
        bhu.bd(obj);
        long jCurrentTimeMillis = System.currentTimeMillis() - this.a;
        StringBuilder sb = new StringBuilder();
        sb.append("载入 " /* "载入 " /* "载入 " /* cnb.z(-58819577117482L)  */);
        int i = this.e;
        sb.append(i + 1);
        sb.append('/');
        List list = this.f;
        sb.append(list.size());
        sb.append(", 耗时 " /* ", 耗时 " /* ", 耗时 " /* cnb.z(-58768037509930L)  */);
        sb.append(jCurrentTimeMillis);
        sb.append("ms" /* "ms" /* "ms" /* cnb.z(-58725087836970L)  */);
        this.d.setText(sb.toString());
        this.o.setProgress(((i + 1) * 100) / list.size());
        return KotlinUnit.INSTANCE;
    }
}

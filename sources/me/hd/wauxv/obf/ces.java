package me.hd.wauxv.obf;

import com.alibaba.fastjson2.support.money.MoneySupport;
import java.util.function.BiFunction;
import java.util.function.Function;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ces implements Function {
    public final /* synthetic */ int a;
    public final /* synthetic */ BiFunction b;

    public /* synthetic */ ces(BiFunction biFunction, int i) {
        this.a = i;
        this.b = biFunction;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        switch (this.a) {
            case 0:
                return MoneySupport.lambda$createNumberValueWriter$1(this.b, obj);
            default:
                return MoneySupport.lambda$createCurrencyUnitReader$0(this.b, (String) obj);
        }
    }
}

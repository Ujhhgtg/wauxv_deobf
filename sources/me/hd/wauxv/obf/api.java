package me.hd.wauxv.obf;

import android.content.Context;
import android.content.Intent;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class api {
    public static final api a;

    static {
        "m02krT/t'4E_$jgJt=2LKNe" /* cnb.z(-80981608364842L) */;
        "https://afdian.com/a/hdshare" /* cnb.z(-80878529149738L) */;
        "m0eZ$'Q@C9@1WK:'#+D~Bw" /* cnb.z(-81286551042858L) */;
        "https://afdian.com/a/suzhelan" /* cnb.z(-81170586925866L) */;
        a = new api();
    }

    public static void b(Context context, String str) {
        Intent intent = new Intent();
        intent.setClassName(context, "com.tencent.mm.plugin.collect.reward.ui.QrRewardSelectMoneyUI" /* cnb.z(-79190607002410L) */);
        intent.putExtra("key_scene" /* cnb.z(-79456894974762L) */, 1);
        intent.putExtra("key_qrcode_url" /* cnb.z(-81080392612650L) */, str);
        intent.putExtra("key_channel" /* cnb.z(-80998788234026L) */, 24);
        context.startActivity(intent);
    }
}

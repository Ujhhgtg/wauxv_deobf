package me.hd.wauxv.obf;

import android.content.Context;
import android.content.res.XmlResourceParser;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.highcapable.hikage.bypass.HikageAttrsView;
import me.hd.wauxv.R;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class ewm {
    public static final ewm a;
    public static final /* synthetic */ btc[] b;
    public static final FactoryPools c;
    public static final FactoryPools d;
    public static Long e;
    public static AutoCloseable f;
    public static boolean g;
    public static final ewl h;
    public static final Kotlin$Lazy i;

    static {
        cwb cwbVar = new cwb(ewm.class, "ApkAssetsClass", "getApkAssetsClass()Ljava/lang/Class;");
        dal.a.getClass();
        b = new btc[]{cwbVar, new cwb(ewm.class, "XmlBlockClass", "getXmlBlockClass()Ljava/lang/Class;")};
        a = new ewm();
        c = ReflectionWrapper.h("android.content.res.ApkAssets", null, 6);
        d = new FactoryPools("android.content.res.XmlBlock", (bfu) null);
        h = new ewl(0);
        i = new Kotlin$Lazy(new efq(19));
    }

    public static final XmlResourceParser j(Context context) {
        Object objX;
        Class<HikageAttrsView> cls = HikageAttrsView.class;
        try {
            Object objInflate = StaticHelpers7.an(context).inflate(R.layout.layout_hikage_attrs_view, (ViewGroup) null, false);
            if (!(objInflate instanceof HikageAttrsView)) {
                objInflate = null;
            }
            objX = (HikageAttrsView) objInflate;
            if (objX == null) {
                String str = "0x" + Integer.toHexString(R.layout.layout_hikage_attrs_view);
                Class<HikageAttrsView> clsBf = HugeSyntheticPileOfHelpers.bf(dal.b(cls));
                if (clsBf != null) {
                    cls = clsBf;
                }
                throw new IllegalStateException(("This inflated view " + str + " is not a type of " + cls + " or is null.").toString());
            }
        } catch (Throwable th) {
            objX = FastKV.x(th);
        }
        if (objX instanceof dcx) {
            objX = null;
        }
        HikageAttrsView hikageAttrsView = (HikageAttrsView) ((View) objX);
        AttributeSet attrs$hikage_core_release = hikageAttrsView != null ? hikageAttrsView.getAttrs$hikage_core_release() : null;
        XmlResourceParser xmlResourceParser = attrs$hikage_core_release instanceof XmlResourceParser ? (XmlResourceParser) attrs$hikage_core_release : null;
        if (xmlResourceParser != null) {
            return xmlResourceParser;
        }
        throw new IllegalStateException("Failed to create AttributeSet.");
    }
}

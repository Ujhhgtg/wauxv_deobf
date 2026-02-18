package me.hd.wauxv.obf;

import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.XModuleResources;
import android.util.DisplayMetrics;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class exk extends Resources {
    public static final /* synthetic */ int a = 0;
    public final XModuleResources b;

    /* JADX WARN: Illegal instructions before constructor call */
    public exk(XModuleResources xModuleResources) {
        Object objX;
        Object objX2;
        Object objX3;
        try {
            objX = xModuleResources.getAssets();
        } catch (Throwable th) {
            objX = bhu.x(th);
        }
        AssetManager assetManager = (AssetManager) (objX instanceof dcx ? null : objX);
        try {
            objX2 = xModuleResources.getDisplayMetrics();
        } catch (Throwable th2) {
            objX2 = bhu.x(th2);
        }
        DisplayMetrics displayMetrics = (DisplayMetrics) (objX2 instanceof dcx ? null : objX2);
        try {
            objX3 = xModuleResources.getConfiguration();
        } catch (Throwable th3) {
            objX3 = bhu.x(th3);
        }
        super(assetManager, displayMetrics, (Configuration) (objX3 instanceof dcx ? null : objX3));
        this.b = xModuleResources;
    }

    public final String toString() {
        return "YukiModuleResources by " + this.b;
    }
}

package me.hd.wauxv.obf;

import android.graphics.Typeface;
import android.graphics.fonts.Font;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import java.io.IOException;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class emj extends emi {
    @Override // me.hd.wauxv.obf.emi
    public final Font i(bce bceVar) {
        Font fontG;
        Uri uri = bceVar.a;
        boolean zEquals = Objects.equals(uri.getScheme(), "systemfont");
        String str = bceVar.e;
        String authority = zEquals ? uri.getAuthority() : null;
        if (authority != null) {
            Typeface typefaceCreate = Typeface.create(authority, 0);
            Typeface typefaceCreate2 = Typeface.create(Typeface.DEFAULT, 0);
            if (typefaceCreate == null || typefaceCreate.equals(typefaceCreate2)) {
                typefaceCreate = null;
            }
            if (typefaceCreate != null && (fontG = emf.g(typefaceCreate)) != null) {
                if (TextUtils.isEmpty(str)) {
                    return fontG;
                }
                try {
                    return new Font.Builder(fontG).setFontVariationSettings(str).build();
                } catch (IOException unused) {
                    Log.e("TypefaceCompatApi31Impl", "Failed to clone Font instance. Fall back to provider font.");
                    return null;
                }
            }
        }
        return null;
    }
}

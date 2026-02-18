package me.hd.wauxv.obf;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.URLSpan;
import android.util.Log;
import android.view.View;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class bvr extends URLSpan {
    public final bzr a;
    public final String b;
    public final awp c;

    public bvr(bzr bzrVar, String str, awp awpVar) {
        super(str);
        this.a = bzrVar;
        this.b = str;
        this.c = awpVar;
    }

    @Override // android.text.style.URLSpan, android.text.style.ClickableSpan
    public final void onClick(View view) {
        this.c.getClass();
        String str = this.b;
        Uri uriBuild = Uri.parse(str);
        if (TextUtils.isEmpty(uriBuild.getScheme())) {
            uriBuild = uriBuild.buildUpon().scheme("https").build();
        }
        Context context = view.getContext();
        Intent intent = new Intent("android.intent.action.VIEW", uriBuild);
        intent.putExtra("com.android.browser.application_id", context.getPackageName());
        try {
            context.startActivity(intent);
        } catch (ActivityNotFoundException unused) {
            Log.w("LinkResolverDef", "Actvity was not found for the link: '" + str + "'");
        }
    }

    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public final void updateDrawState(TextPaint textPaint) {
        this.a.getClass();
        textPaint.setUnderlineText(true);
        textPaint.setColor(textPaint.linkColor);
    }
}

package me.hd.wauxv.obf;

import android.os.Bundle;
import android.text.style.ClickableSpan;
import android.view.View;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class ao extends ClickableSpan {
    public final int a;
    public final bd b;
    public final int c;

    public ao(int i, bd bdVar, int i2) {
        this.a = i;
        this.b = bdVar;
        this.c = i2;
    }

    @Override // android.text.style.ClickableSpan
    public final void onClick(View view) {
        Bundle bundle = new Bundle();
        bundle.putInt("ACCESSIBILITY_CLICKABLE_SPAN_ID", this.a);
        this.b.a.performAction(this.c, bundle);
    }
}

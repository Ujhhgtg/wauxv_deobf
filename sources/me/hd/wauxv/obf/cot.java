package me.hd.wauxv.obf;

import android.app.Notification;
import android.media.AudioAttributes;
import android.net.Uri;
import android.provider.Settings;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class cot {
    public final String a;
    public CharSequence b;
    public final int c;
    public String d;
    public final Uri e = Settings.System.DEFAULT_NOTIFICATION_URI;
    public final AudioAttributes f = Notification.AUDIO_ATTRIBUTES_DEFAULT;

    public cot(String str, int i) {
        this.a = str;
        this.c = i;
    }
}

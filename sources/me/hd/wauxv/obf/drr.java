package me.hd.wauxv.obf;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class drr implements drs {
    public static final String[] a = {"_data"};
    public static final String[] b = {"_data"};
    public final /* synthetic */ int c;
    public final ContentResolver d;

    public /* synthetic */ drr(ContentResolver contentResolver, int i) {
        this.c = i;
        this.d = contentResolver;
    }

    @Override // me.hd.wauxv.obf.drs
    public final Cursor e(Uri uri) {
        switch (this.c) {
            case 0:
                String lastPathSegment = uri.getLastPathSegment();
                return this.d.query(MediaStore.Images.Thumbnails.EXTERNAL_CONTENT_URI, a, "kind = 1 AND image_id = ?", new String[]{lastPathSegment}, null);
            default:
                String lastPathSegment2 = uri.getLastPathSegment();
                return this.d.query(MediaStore.Video.Thumbnails.EXTERNAL_CONTENT_URI, b, "kind = 1 AND video_id = ?", new String[]{lastPathSegment2}, null);
        }
    }
}

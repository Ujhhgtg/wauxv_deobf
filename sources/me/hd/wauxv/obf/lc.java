package me.hd.wauxv.obf;

import android.content.ContentResolver;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import android.os.ext.SdkExtensions;
import android.provider.MediaStore;
import java.io.FileNotFoundException;
import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class lc extends bww {
    public final /* synthetic */ int a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ lc(ContentResolver contentResolver, Uri uri, boolean z, int i) {
        super(contentResolver, uri, z);
        this.a = i;
    }

    @Override // me.hd.wauxv.obf.bww
    public final Object _aq(ContentResolver contentResolver, Uri uri) throws FileNotFoundException {
        switch (this.a) {
            case 0:
                boolean z = this.g;
                ContentResolver contentResolver2 = this.i;
                AssetFileDescriptor assetFileDescriptorOpenAssetFileDescriptor = (!z || !dqc.bd(uri) || Build.VERSION.SDK_INT < 30 || SdkExtensions.getExtensionVersion(30) < 17) ? contentResolver2.openAssetFileDescriptor(uri, "r") : MediaStore.openAssetFileDescriptor(contentResolver2, uri, "r", null);
                if (assetFileDescriptorOpenAssetFileDescriptor != null) {
                    return assetFileDescriptorOpenAssetFileDescriptor;
                }
                throw new FileNotFoundException("FileDescriptor is null for: " + uri);
            default:
                boolean z2 = this.g;
                ContentResolver contentResolver3 = this.i;
                AssetFileDescriptor assetFileDescriptorOpenAssetFileDescriptor2 = (!z2 || !dqc.bd(uri) || Build.VERSION.SDK_INT < 30 || SdkExtensions.getExtensionVersion(30) < 17) ? contentResolver3.openAssetFileDescriptor(uri, "r") : MediaStore.openAssetFileDescriptor(contentResolver3, uri, "r", null);
                if (assetFileDescriptorOpenAssetFileDescriptor2 != null) {
                    return assetFileDescriptorOpenAssetFileDescriptor2.getParcelFileDescriptor();
                }
                throw new FileNotFoundException("FileDescriptor is null for: " + uri);
        }
    }

    @Override // me.hd.wauxv.obf.ajb
    public final Class b() {
        switch (this.a) {
            case 0:
                return AssetFileDescriptor.class;
            default:
                return ParcelFileDescriptor.class;
        }
    }

    @Override // me.hd.wauxv.obf.bww
    public final void c(Object obj) throws IOException {
        switch (this.a) {
            case 0:
                ((AssetFileDescriptor) obj).close();
                break;
            default:
                ((ParcelFileDescriptor) obj).close();
                break;
        }
    }
}

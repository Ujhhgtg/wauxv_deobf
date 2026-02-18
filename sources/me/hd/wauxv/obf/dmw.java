package me.hd.wauxv.obf;

import android.content.ContentResolver;
import android.content.UriMatcher;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import android.os.Build;
import android.os.ext.SdkExtensions;
import android.provider.ContactsContract;
import android.provider.MediaStore;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class dmw extends bww {
    public static final UriMatcher a;

    static {
        UriMatcher uriMatcher = new UriMatcher(-1);
        a = uriMatcher;
        uriMatcher.addURI("com.android.contacts", "contacts/lookup/*/#", 1);
        uriMatcher.addURI("com.android.contacts", "contacts/lookup/*", 1);
        uriMatcher.addURI("com.android.contacts", "contacts/#/photo", 2);
        uriMatcher.addURI("com.android.contacts", "contacts/#", 3);
        uriMatcher.addURI("com.android.contacts", "contacts/#/display_photo", 4);
        uriMatcher.addURI("com.android.contacts", "phone_lookup/*", 5);
    }

    /* JADX WARN: Found duplicated region for block: B:28:0x0062  */
    /* JADX WARN: Found duplicated region for block: B:30:0x0068  */
    /* JADX WARN: Found duplicated region for block: B:35:0x0083  */
    @Override // me.hd.wauxv.obf.bww
    public final Object _aq(ContentResolver contentResolver, Uri uri) throws FileNotFoundException {
        Uri uriLookupContact;
        InputStream inputStreamOpenContactPhotoInputStream;
        int iMatch = a.match(uri);
        if (iMatch == 1) {
            uriLookupContact = ContactsContract.Contacts.lookupContact(contentResolver, uri);
            if (uriLookupContact != null) {
                throw new FileNotFoundException("Contact cannot be found");
            }
            inputStreamOpenContactPhotoInputStream = ContactsContract.Contacts.openContactPhotoInputStream(contentResolver, uriLookupContact, true);
        } else if (iMatch == 3) {
            inputStreamOpenContactPhotoInputStream = ContactsContract.Contacts.openContactPhotoInputStream(contentResolver, uri, true);
        } else if (iMatch == 5) {
            uriLookupContact = ContactsContract.Contacts.lookupContact(contentResolver, uri);
            if (uriLookupContact != null) {
                throw new FileNotFoundException("Contact cannot be found");
            }
            inputStreamOpenContactPhotoInputStream = ContactsContract.Contacts.openContactPhotoInputStream(contentResolver, uriLookupContact, true);
        } else if (!this.g || !dqc.bd(uri) || Build.VERSION.SDK_INT < 30 || SdkExtensions.getExtensionVersion(30) < 17) {
            inputStreamOpenContactPhotoInputStream = contentResolver.openInputStream(uri);
        } else {
            AssetFileDescriptor assetFileDescriptorOpenAssetFileDescriptor = MediaStore.openAssetFileDescriptor(contentResolver, uri, "r", null);
            if (assetFileDescriptorOpenAssetFileDescriptor == null) {
                throw new FileNotFoundException("FileDescriptor is null for: " + uri);
            }
            try {
                inputStreamOpenContactPhotoInputStream = assetFileDescriptorOpenAssetFileDescriptor.createInputStream();
            } catch (IOException e) {
                try {
                    assetFileDescriptorOpenAssetFileDescriptor.close();
                } catch (Exception unused) {
                }
                throw ((FileNotFoundException) new FileNotFoundException("Unable to create stream").initCause(e));
            }
        }
        if (inputStreamOpenContactPhotoInputStream != null) {
            return inputStreamOpenContactPhotoInputStream;
        }
        throw new FileNotFoundException("InputStream is null for " + uri);
    }

    @Override // me.hd.wauxv.obf.ajb
    public final Class b() {
        return InputStream.class;
    }

    @Override // me.hd.wauxv.obf.bww
    public final void c(Object obj) throws IOException {
        ((InputStream) obj).close();
    }
}

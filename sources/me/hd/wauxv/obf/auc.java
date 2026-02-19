package me.hd.wauxv.obf;

import android.os.Bundle;
import android.text.Editable;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputConnectionWrapper;
import android.widget.EditText;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class auc extends InputConnectionWrapper {
    public final EditText a;
    public final nu b;

    public auc(EditText editText, InputConnection inputConnection, EditorInfo editorInfo) {
        nu nuVar = new nu(24);
        super(inputConnection, false);
        this.a = editText;
        this.b = nuVar;
        if (atf.b != null) {
            atf atfVarL = atf.l();
            if (atfVarL.m() != 1 || editorInfo == null) {
                return;
            }
            if (editorInfo.extras == null) {
                editorInfo.extras = new Bundle();
            }
            ata ataVar = atfVarL.g;
            ataVar.getClass();
            Bundle bundle = editorInfo.extras;
            GenericMetadataIterator3 cdcVar = (GenericMetadataIterator3) ataVar.c.c;
            int iF = cdcVar.getVTableOffset(4);
            bundle.putInt("android.support.text.emoji.emojiCompat_metadataVersion", iF != 0 ? ((ByteBuffer) cdcVar.e).getInt(iF + cdcVar.b) : 0);
            editorInfo.extras.putBoolean("android.support.text.emoji.emojiCompat_replaceAll", false);
        }
    }

    @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
    public final boolean deleteSurroundingText(int i, int i2) {
        Editable editableText = this.a.getEditableText();
        this.b.getClass();
        return nu.h(this, editableText, i, i2, false) || super.deleteSurroundingText(i, i2);
    }

    @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
    public final boolean deleteSurroundingTextInCodePoints(int i, int i2) {
        Editable editableText = this.a.getEditableText();
        this.b.getClass();
        return nu.h(this, editableText, i, i2, true) || super.deleteSurroundingTextInCodePoints(i, i2);
    }
}

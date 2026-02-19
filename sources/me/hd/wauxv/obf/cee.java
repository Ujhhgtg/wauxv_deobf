package me.hd.wauxv.obf;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import me.hd.wauxv.R;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class cee implements eqj {
    public final /* synthetic */ int a;
    public final LinearLayout b;
    public final TextInputEditText c;

    public /* synthetic */ cee(LinearLayout linearLayout, TextInputEditText textInputEditText, int i) {
        this.a = i;
        this.b = linearLayout;
        this.c = textInputEditText;
    }

    public static cee d(LayoutInflater layoutInflater) {
        View viewInflate = layoutInflater.inflate(R.layout.module_dialog_anti_revoke, (ViewGroup) null, false);
        int i = R.id.moduleDialogEdtAntiRevokeTip;
        TextInputEditText textInputEditText = (TextInputEditText) KotlinHelpers2.aq(viewInflate, R.id.moduleDialogEdtAntiRevokeTip);
        if (textInputEditText != null) {
            i = R.id.moduleDialogInputAntiRevokeTip;
            if (((TextInputLayout) KotlinHelpers2.aq(viewInflate, R.id.moduleDialogInputAntiRevokeTip)) != null) {
                return new cee((LinearLayout) viewInflate, textInputEditText, 0);
            }
        }
        throw new NullPointerException("Missing required view with ID: " /* "Missing required view with ID: " /* "Missing required view with ID: " /* "Missing required view with ID: " /* cnb.z(-641187077684010L)   */.concat(viewInflate.getResources().getResourceName(i)));
    }

    public static cee e(LayoutInflater layoutInflater) {
        View viewInflate = layoutInflater.inflate(R.layout.module_dialog_menu_save, (ViewGroup) null, false);
        int i = R.id.moduleDialogEdtMenuSavePath;
        TextInputEditText textInputEditText = (TextInputEditText) KotlinHelpers2.aq(viewInflate, R.id.moduleDialogEdtMenuSavePath);
        if (textInputEditText != null) {
            i = R.id.moduleDialogInputMenuSavePath;
            if (((TextInputLayout) KotlinHelpers2.aq(viewInflate, R.id.moduleDialogInputMenuSavePath)) != null) {
                return new cee((LinearLayout) viewInflate, textInputEditText, 5);
            }
        }
        throw new NullPointerException("Missing required view with ID: " /* "Missing required view with ID: " /* "Missing required view with ID: " /* "Missing required view with ID: " /* cnb.z(-662077798611754L)   */.concat(viewInflate.getResources().getResourceName(i)));
    }

    @Override // me.hd.wauxv.obf.eqj
    public final View getRoot() {
        switch (this.a) {
            case 0:
                break;
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
            case 6:
                break;
        }
        return this.b;
    }

    public cee(LinearLayout linearLayout, TextInputEditText textInputEditText, RecyclerView recyclerView) {
        this.a = 2;
        this.b = linearLayout;
        this.c = textInputEditText;
    }
}

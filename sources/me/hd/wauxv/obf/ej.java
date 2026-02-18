package me.hd.wauxv.obf;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewStub;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.appcompat.app.AlertController$RecycleListView;
import androidx.core.widget.NestedScrollView;
import java.lang.ref.WeakReference;
import me.hd.wauxv.R;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class ej {
    public final Context a;
    public final int aa;
    public final int ab;
    public final int ac;
    public final boolean ad;
    public final eh ae;
    public final el b;
    public final Window c;
    public CharSequence d;
    public String e;
    public AlertController$RecycleListView f;
    public View g;
    public Button i;
    public CharSequence j;
    public Message k;
    public Button l;
    public CharSequence m;
    public Message n;
    public Button o;
    public CharSequence p;
    public Message q;
    public NestedScrollView r;
    public Drawable s;
    public ImageView t;
    public TextView u;
    public TextView v;
    public View w;
    public ListAdapter x;
    public final int z;
    public boolean h = false;
    public int y = -1;
    public final ch af = new ch(this, 1);

    public ej(Context context, el elVar, Window window) {
        this.a = context;
        this.b = elVar;
        this.c = window;
        eh ehVar = new eh();
        ehVar.a = new WeakReference(elVar);
        this.ae = ehVar;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(null, cyf.e, R.attr.alertDialogStyle, 0);
        this.z = typedArrayObtainStyledAttributes.getResourceId(0, 0);
        typedArrayObtainStyledAttributes.getResourceId(2, 0);
        this.aa = typedArrayObtainStyledAttributes.getResourceId(4, 0);
        typedArrayObtainStyledAttributes.getResourceId(5, 0);
        this.ab = typedArrayObtainStyledAttributes.getResourceId(7, 0);
        this.ac = typedArrayObtainStyledAttributes.getResourceId(3, 0);
        this.ad = typedArrayObtainStyledAttributes.getBoolean(6, true);
        typedArrayObtainStyledAttributes.getDimensionPixelSize(1, 0);
        typedArrayObtainStyledAttributes.recycle();
        elVar.e().o(1);
    }

    public static boolean ag(View view) {
        if (view.onCheckIsTextEditor()) {
            return true;
        }
        if (!(view instanceof ViewGroup)) {
            return false;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        while (childCount > 0) {
            childCount--;
            if (ag(viewGroup.getChildAt(childCount))) {
                return true;
            }
        }
        return false;
    }

    public static ViewGroup ah(View view, View view2) {
        if (view == null) {
            if (view2 instanceof ViewStub) {
                view2 = ((ViewStub) view2).inflate();
            }
            return (ViewGroup) view2;
        }
        if (view2 != null) {
            ViewParent parent = view2.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(view2);
            }
        }
        if (view instanceof ViewStub) {
            view = ((ViewStub) view).inflate();
        }
        return (ViewGroup) view;
    }

    public final void ai(int i, String str, DialogInterface.OnClickListener onClickListener) {
        Message messageObtainMessage = onClickListener != null ? this.ae.obtainMessage(i, onClickListener) : null;
        if (i == -3) {
            this.p = str;
            this.q = messageObtainMessage;
        } else if (i == -2) {
            this.m = str;
            this.n = messageObtainMessage;
        } else {
            if (i != -1) {
                throw new IllegalArgumentException("Button does not exist");
            }
            this.j = str;
            this.k = messageObtainMessage;
        }
    }
}

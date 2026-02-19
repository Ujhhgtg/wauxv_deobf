package me.hd.wauxv.obf;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.appbar.MaterialToolbar;
import io.github.rosemoe.sora.widget.CodeEditor;
import me.hd.wauxv.R;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class aan extends bgr implements bgk {
    public static final aan a = new aan(3, bdp.class, "inflate" /* "inflate" /* "inflate" /* "inflate" /* cnb.z(-420816600693546L)   */, "inflate(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Z)Lme/hd/wauxv/databinding/FragmentCodeBinding;" /* "inflate(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Z)Lme/hd/wauxv/databinding/FragmentCodeBinding;" /* "inflate(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Z)Lme/hd/wauxv/databinding/FragmentCodeBinding;" /* "inflate(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Z)Lme/hd/wauxv/databinding/FragmentCodeBinding;" /* cnb.z(-420782240955178L)   */, 0);

    @Override // me.hd.wauxv.obf.bgk
    public final Object b(Object obj, Object obj2, Object obj3) {
        ViewGroup viewGroup = (ViewGroup) obj2;
        boolean zBooleanValue = ((Boolean) obj3).booleanValue();
        View viewInflate = ((LayoutInflater) obj).inflate(R.layout.fragment_code, viewGroup, false);
        if (zBooleanValue) {
            viewGroup.addView(viewInflate);
        }
        int i = R.id.codeEditor;
        CodeEditor codeEditor = (CodeEditor) KotlinHelpers2.aq(viewInflate, R.id.codeEditor);
        if (codeEditor != null) {
            i = R.id.codeToolbar;
            MaterialToolbar materialToolbar = (MaterialToolbar) KotlinHelpers2.aq(viewInflate, R.id.codeToolbar);
            if (materialToolbar != null) {
                return new bdp((CoordinatorLayout) viewInflate, codeEditor, materialToolbar);
            }
        }
        throw new NullPointerException("Missing required view with ID: " /* "Missing required view with ID: " /* "Missing required view with ID: " /* "Missing required view with ID: " /* cnb.z(-634886360660778L)   */.concat(viewInflate.getResources().getResourceName(i)));
    }
}

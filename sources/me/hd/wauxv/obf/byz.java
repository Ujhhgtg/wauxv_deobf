package me.hd.wauxv.obf;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.card.MaterialCardView;
import com.google.android.material.imageview.ShapeableImageView;
import com.google.android.material.textview.MaterialTextView;
import me.hd.wauxv.R;
import no.agens.depth.BearSceneView;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class byz extends bgr implements bgf {
    public static final byz a = new byz(1, dj.class, "inflate" /* cnb.z(-389630843157290L) */, "inflate(Landroid/view/LayoutInflater;)Lme/hd/wauxv/databinding/ActivityMainBinding;" /* cnb.z(-389596483418922L) */, 0);

    @Override // me.hd.wauxv.obf.bgf
    public final Object invoke(Object obj) {
        View viewInflate = ((LayoutInflater) obj).inflate(R.layout.activity_main, (ViewGroup) null, false);
        int i = R.id.mainAppBar;
        if (((AppBarLayout) cnd.aq(viewInflate, R.id.mainAppBar)) != null) {
            i = R.id.mainBearSceneView;
            BearSceneView bearSceneView = (BearSceneView) cnd.aq(viewInflate, R.id.mainBearSceneView);
            if (bearSceneView != null) {
                i = R.id.mainButtonUpdate;
                MaterialButton materialButton = (MaterialButton) cnd.aq(viewInflate, R.id.mainButtonUpdate);
                if (materialButton != null) {
                    i = R.id.mainCardViewStatus;
                    MaterialCardView materialCardView = (MaterialCardView) cnd.aq(viewInflate, R.id.mainCardViewStatus);
                    if (materialCardView != null) {
                        i = R.id.mainClickView;
                        View viewAq = cnd.aq(viewInflate, R.id.mainClickView);
                        if (viewAq != null) {
                            i = R.id.mainImageViewStatus;
                            ShapeableImageView shapeableImageView = (ShapeableImageView) cnd.aq(viewInflate, R.id.mainImageViewStatus);
                            if (shapeableImageView != null) {
                                i = R.id.mainLinearLayoutUpdate;
                                LinearLayout linearLayout = (LinearLayout) cnd.aq(viewInflate, R.id.mainLinearLayoutUpdate);
                                if (linearLayout != null) {
                                    i = R.id.mainTextViewStatus;
                                    MaterialTextView materialTextView = (MaterialTextView) cnd.aq(viewInflate, R.id.mainTextViewStatus);
                                    if (materialTextView != null) {
                                        i = R.id.mainTextViewStatusVersion;
                                        MaterialTextView materialTextView2 = (MaterialTextView) cnd.aq(viewInflate, R.id.mainTextViewStatusVersion);
                                        if (materialTextView2 != null) {
                                            i = R.id.mainTextViewUpdateSummary;
                                            MaterialTextView materialTextView3 = (MaterialTextView) cnd.aq(viewInflate, R.id.mainTextViewUpdateSummary);
                                            if (materialTextView3 != null) {
                                                i = R.id.mainTextViewUpdateTitle;
                                                MaterialTextView materialTextView4 = (MaterialTextView) cnd.aq(viewInflate, R.id.mainTextViewUpdateTitle);
                                                if (materialTextView4 != null) {
                                                    i = R.id.mainToolbar;
                                                    MaterialToolbar materialToolbar = (MaterialToolbar) cnd.aq(viewInflate, R.id.mainToolbar);
                                                    if (materialToolbar != null) {
                                                        i = R.id.mainToolbarLayout;
                                                        if (((CollapsingToolbarLayout) cnd.aq(viewInflate, R.id.mainToolbarLayout)) != null) {
                                                            return new dj((CoordinatorLayout) viewInflate, bearSceneView, materialButton, materialCardView, viewAq, shapeableImageView, linearLayout, materialTextView, materialTextView2, materialTextView3, materialTextView4, materialToolbar);
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: " /* cnb.z(-635436116474666L) */.concat(viewInflate.getResources().getResourceName(i)));
    }
}

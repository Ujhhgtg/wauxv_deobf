package me.hd.wauxv.ui.activity;

import android.content.ComponentName;
import android.content.Context;
import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.imageview.ShapeableImageView;
import com.google.android.material.textview.MaterialTextView;
import me.hd.wauxv.R;
import me.hd.wauxv.obf.aam;
import me.hd.wauxv.obf.abi;
import me.hd.wauxv.obf.Dispatchers$IO;
import me.hd.wauxv.obf.Dispatchers$Default;
import me.hd.wauxv.obf.aou;
import me.hd.wauxv.obf.bhp;
import me.hd.wauxv.obf.bhq;
import me.hd.wauxv.obf.byx;
import me.hd.wauxv.obf.byz;
import me.hd.wauxv.obf.bzy;
import me.hd.wauxv.obf.KotlinHelpers2;
import me.hd.wauxv.obf.dg;
import me.hd.wauxv.obf.dj;
import me.hd.wauxv.obf.eg;
import me.hd.wauxv.obf.eqj;
import me.hd.wauxv.obf.etz;
import me.hd.wauxv.obf.eua;
import me.hd.wauxv.obf.exl;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class MainActivity extends dg {
    public static final /* synthetic */ int as = 0;
    public final String at;

    public MainActivity() {
        super(byz.a);
        this.at = "me.hd.wauxv.HomeActivity" /* "me.hd.wauxv.HomeActivity" /* "me.hd.wauxv.HomeActivity" /* cnb.z(-391400369683242L)  */;
    }

    public final boolean au(Context context) {
        return context.getPackageManager()
                .getComponentEnabledSetting(new ComponentName(context.getPackageName(), this.at)) == 2;
    }

    public final void av() {
        bzy bzyVar = new bzy(this);
        View viewInflate = LayoutInflater.from(this).inflate(R.layout.dialog_about, (ViewGroup) null, false);
        int i = R.id.aboutImageViewIcon;
        if (((ShapeableImageView) KotlinHelpers2.recursivelyFindViewById(viewInflate, R.id.aboutImageViewIcon)) != null) {
            i = R.id.aboutTextViewDesc;
            MaterialTextView materialTextView = (MaterialTextView) KotlinHelpers2.recursivelyFindViewById(viewInflate, R.id.aboutTextViewDesc);
            if (materialTextView != null) {
                i = R.id.aboutTextViewTitle;
                MaterialTextView materialTextView2 = (MaterialTextView) KotlinHelpers2.recursivelyFindViewById(viewInflate, R.id.aboutTextViewTitle);
                if (materialTextView2 != null) {
                    i = R.id.aboutTextViewVersion;
                    MaterialTextView materialTextView3 = (MaterialTextView) KotlinHelpers2.recursivelyFindViewById(viewInflate,
                            R.id.aboutTextViewVersion);
                    if (materialTextView3 != null) {
                        LinearLayout linearLayout = (LinearLayout) viewInflate;
                        materialTextView2.setText("WAuxiliary" /* "WAuxiliary" /* "WAuxiliary" /* cnb.z(-390438297008938L)  */);
                        materialTextView3.setText("1.2.6.r1238.198c77c" /* "1.2.6.r1238.198c77c" /* "1.2.6.r1238.198c77c" /* cnb.z(-390408232237866L)  */);
                        materialTextView.setMovementMethod(LinkMovementMethod.getInstance());
                        materialTextView.setText(Html.fromHtml(
                                "在 <b><a href=\"https://github.com/HdShare/WAuxiliary_Public\">GitHub</a></b> 查看公开源码<br/>\n在 <b><a href=\"https://github.com/HdShare/WAuxiliary_Plugin\">GitHub</a></b> 查看插件源码<br/>\n加入我们的 <b><a href=\"https://t.me/Hd_WAuxiliary_CI\">Telegram</a></b> 频道<br/>\n加入我们的 <b><a href=\"https://t.me/Hd_WAuxiliary\">Telegram</a></b> 群组<br/>" /*
                                                                                                                                                                                                                                                                                                                                                                             * cnb
                                                                                                                                                                                                                                                                                                                                                                             * .
                                                                                                                                                                                                                                                                                                                                                                             * z
                                                                                                                                                                                                                                                                                                                                                                             * (
                                                                                                                                                                                                                                                                                                                                                                             * -
                                                                                                                                                                                                                                                                                                                                                                             * 390356692630314L)
                                                                                                                                                                                                                                                                                                                                                                             */,
                                0));
                        if (linearLayout != null) {
                            ((eg) bzyVar.d).r = linearLayout;
                        }
                        bzyVar.i().show();
                        return;
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: "
                /* "Missing required view with ID: " /* "Missing required view with ID: " /* cnb.z(-634611482753834L)  */.concat(viewInflate.getResources().getResourceName(i)));
    }

    @Override // me.hd.wauxv.obf.dg, me.hd.wauxv.obf.hb, me.hd.wauxv.obf.aci,
              // android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        eqj eqjVar = this._ac;
        throwIfVar1IsNull(eqjVar);
        CoordinatorLayout coordinatorLayout = ((dj) eqjVar).a;
        etz etzVar = new etz(null, abi.f(getColor(R.color.md_theme_primary), 48), 61);
        FrameLayout frameLayout = new FrameLayout(coordinatorLayout.getContext());
        frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        frameLayout.setBackground(new eua(etzVar));
        coordinatorLayout.addView(frameLayout);
        bhq bhqVar = bhq.a;
        String strZ = "1.2.6.r1238.198c77c" /* "1.2.6.r1238.198c77c" /* "1.2.6.r1238.198c77c" /* cnb.z(-391292995500842L)  */;
        final int i = 0;
        byx byxVar = new byx(this, i);
        bhqVar.getClass();
        Dispatchers$Default alcVar = aou.a;
        KotlinHelpers2.bf(Dispatchers$IO.INSTANCE, new bhp(strZ, byxVar, this, null));
        eqj eqjVar2 = this._ac;
        throwIfVar1IsNull(eqjVar2);
        ((dj) eqjVar2).l.setTitle("WAuxiliary" /* "WAuxiliary" /* "WAuxiliary" /* cnb.z(-391241455893290L)  */);
        eqj eqjVar3 = this._ac;
        throwIfVar1IsNull(eqjVar3);
        MenuItem menuItemFindItem = ((dj) eqjVar3).l.getMenu().findItem(R.id.tab_hide_desktop_icon);
        menuItemFindItem.setChecked(au(this));
        final int i2 = 1;
        menuItemFindItem.setOnMenuItemClickListener(new aam(this, i2, menuItemFindItem));
        eqj eqjVar4 = this._ac;
        throwIfVar1IsNull(eqjVar4);
        ((dj) eqjVar4).l.setOnClickListener(new View.OnClickListener(this) { // from class: me.hd.wauxv.obf.byy
            public final /* synthetic */ MainActivity b;

            {
                this.b = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i3 = i;
                MainActivity mainActivity = this.b;
                switch (i3) {
                    case 0:
                        int i4 = MainActivity.as;
                        mainActivity.av();
                        break;
                    default:
                        int i5 = MainActivity.as;
                        mainActivity.av();
                        break;
                }
            }
        });
        eqj eqjVar5 = this._ac;
        throwIfVar1IsNull(eqjVar5);
        ((dj) eqjVar5).e.setOnClickListener(new View.OnClickListener(this) { // from class: me.hd.wauxv.obf.byy
            public final /* synthetic */ MainActivity b;

            {
                this.b = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i3 = i2;
                MainActivity mainActivity = this.b;
                switch (i3) {
                    case 0:
                        int i4 = MainActivity.as;
                        mainActivity.av();
                        break;
                    default:
                        int i5 = MainActivity.as;
                        mainActivity.av();
                        break;
                }
            }
        });
        if (exl.a) {
            eqj eqjVar6 = this._ac;
            throwIfVar1IsNull(eqjVar6);
            ((dj) eqjVar6).h.setText(getString(R.string.main_status_activated));
            eqj eqjVar7 = this._ac;
            throwIfVar1IsNull(eqjVar7);
            ((dj) eqjVar7).h.setTextColor(getColor(R.color.md_theme_onTertiaryContainer));
            eqj eqjVar8 = this._ac;
            throwIfVar1IsNull(eqjVar8);
            ((dj) eqjVar8).i.setText("1.2.6.r1238.198c77c" /* "1.2.6.r1238.198c77c" /* "1.2.6.r1238.198c77c" /* cnb.z(-391159851514666L)  */);
            eqj eqjVar9 = this._ac;
            throwIfVar1IsNull(eqjVar9);
            ((dj) eqjVar9).i.setTextColor(getColor(R.color.md_theme_onTertiaryContainer));
            eqj eqjVar10 = this._ac;
            throwIfVar1IsNull(eqjVar10);
            ((dj) eqjVar10).f.setImageResource(R.drawable.ic_status_activated_24dp);
            eqj eqjVar11 = this._ac;
            throwIfVar1IsNull(eqjVar11);
            ((dj) eqjVar11).f.setImageTintList(getColorStateList(R.color.md_theme_onTertiaryContainer));
            eqj eqjVar12 = this._ac;
            throwIfVar1IsNull(eqjVar12);
            ((dj) eqjVar12).d.setCardBackgroundColor(getColor(R.color.md_theme_tertiaryContainer));
            return;
        }
        eqj eqjVar13 = this._ac;
        throwIfVar1IsNull(eqjVar13);
        ((dj) eqjVar13).h.setText(getString(R.string.main_status_not_activated));
        eqj eqjVar14 = this._ac;
        throwIfVar1IsNull(eqjVar14);
        ((dj) eqjVar14).h.setTextColor(getColor(R.color.md_theme_onErrorContainer));
        eqj eqjVar15 = this._ac;
        throwIfVar1IsNull(eqjVar15);
        ((dj) eqjVar15).i.setText("1.2.6.r1238.198c77c" /* "1.2.6.r1238.198c77c" /* "1.2.6.r1238.198c77c" /* cnb.z(-390558556093226L)  */);
        eqj eqjVar16 = this._ac;
        throwIfVar1IsNull(eqjVar16);
        ((dj) eqjVar16).i.setTextColor(getColor(R.color.md_theme_onErrorContainer));
        eqj eqjVar17 = this._ac;
        throwIfVar1IsNull(eqjVar17);
        ((dj) eqjVar17).f.setImageResource(R.drawable.ic_status_not_activated_24dp);
        eqj eqjVar18 = this._ac;
        throwIfVar1IsNull(eqjVar18);
        ((dj) eqjVar18).f.setImageTintList(getColorStateList(R.color.md_theme_onErrorContainer));
        eqj eqjVar19 = this._ac;
        throwIfVar1IsNull(eqjVar19);
        ((dj) eqjVar19).d.setCardBackgroundColor(getColor(R.color.md_theme_errorContainer));
    }
}

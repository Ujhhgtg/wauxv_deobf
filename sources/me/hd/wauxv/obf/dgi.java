package me.hd.wauxv.obf;

import android.content.Context;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.Switch;
import android.widget.TextView;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class dgi extends LinearLayout {
    public final FrameLayout a;

    public dgi(Context context) {
        super(context);
        setOrientation(1);
        FrameLayout frameLayout = new FrameLayout(context);
        frameLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        frameLayout.addView(c(0));
        this.a = frameLayout;
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(0);
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        linearLayout.addView(b(0, "普通" /* "普通" /* "普通" /* "普通" /* cnb.z(-60760902335274L)   */));
        linearLayout.addView(b(1, "插件" /* "插件" /* "插件" /* "插件" /* cnb.z(-60782377171754L)   */));
        linearLayout.addView(b(2, "开发" /* "开发" /* "开发" /* "开发" /* cnb.z(-57969173592874L)   */));
        addView(linearLayout);
        addView(frameLayout);
    }

    public final TextView b(int i, String str) {
        TextView textView = new TextView(getContext());
        textView.setText(str);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2, 1.0f);
        layoutParams.gravity = 17;
        textView.setLayoutParams(layoutParams);
        textView.setGravity(17);
        int iIntValue = bhu.al(32, textView.getContext()).intValue();
        textView.setPadding(iIntValue, iIntValue, iIntValue, iIntValue);
        textView.setOnClickListener(new ccw(this, i, 1));
        return textView;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final ScrollView c(int i) {
        ScrollView scrollView = new ScrollView(getContext());
        LinearLayout linearLayout = new LinearLayout(scrollView.getContext());
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        linearLayout.setOrientation(1);
        int iIntValue = bhu.al(32, linearLayout.getContext()).intValue();
        linearLayout.setPadding(iIntValue, iIntValue, iIntValue, iIntValue);
        int i2 = 2;
        if (i == 0 || i == 2) {
            dov dovVar = ajf.a;
            for (oc ocVar : ajf.b(Boolean.valueOf(i == 2))) {
                if (ocVar instanceof nz) {
                    LinearLayout linearLayout2 = new LinearLayout(linearLayout.getContext());
                    linearLayout2.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
                    linearLayout2.setOrientation(1);
                    linearLayout2.setPadding(bhu.al(16, linearLayout2.getContext()).intValue(), bhu.al(32, linearLayout2.getContext()).intValue(), bhu.al(16, linearLayout2.getContext()).intValue(), bhu.al(32, linearLayout2.getContext()).intValue());
                    TextView textView = new TextView(linearLayout2.getContext());
                    textView.setText(((nz) ocVar).a);
                    textView.setTextSize(16.0f);
                    linearLayout2.addView(textView);
                    linearLayout.addView(linearLayout2);
                } else if (ocVar instanceof ob) {
                    LinearLayout linearLayout3 = new LinearLayout(linearLayout.getContext());
                    linearLayout3.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
                    linearLayout3.setOrientation(1);
                    linearLayout3.setPadding(bhu.al(16, linearLayout3.getContext()).intValue(), bhu.al(32, linearLayout3.getContext()).intValue(), bhu.al(16, linearLayout3.getContext()).intValue(), bhu.al(32, linearLayout3.getContext()).intValue());
                    Switch r10 = new Switch(linearLayout3.getContext());
                    ob obVar = (ob) ocVar;
                    r10.setText(obVar.a);
                    r10.setTextSize(16.0f);
                    r10.setChecked(obVar.c.z());
                    r10.setOnCheckedChangeListener(new zj(obVar, i2, r10));
                    linearLayout3.addView(r10);
                    TextView textView2 = new TextView(linearLayout3.getContext());
                    textView2.setText(obVar.b);
                    textView2.setTextSize(14.0f);
                    linearLayout3.addView(textView2);
                    linearLayout.addView(linearLayout3);
                }
            }
        } else {
            dgh dghVar = new dgh(linearLayout, null, null == true ? 1 : 0);
            alc alcVar = aou.a;
            KotlinHelpers2.bf(bza.a, dghVar);
        }
        scrollView.addView(linearLayout);
        return scrollView;
    }
}

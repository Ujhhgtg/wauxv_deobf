package me.hd.wauxv.obf;

import android.content.Context;
import android.content.res.Configuration;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.util.TypedValue;
import android.widget.ListView;
import android.widget.ProgressBar;
import io.github.rosemoe.sora.widget.CodeEditor;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class arm implements Runnable {
    public final /* synthetic */ int a;
    public final /* synthetic */ aro b;

    public /* synthetic */ arm(aro aroVar, int i) {
        this.a = i;
        this.b = aroVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        switch (this.a) {
            case 0:
                chm chmVar = this.b.j;
                int i = 0;
                ((ListView) chmVar.c).post(new ajz(chmVar, i, i));
                break;
            case 1:
                aro aroVar = this.b;
                if (aroVar.p) {
                    ((ProgressBar) aroVar.j.d).setVisibility(0);
                }
                break;
            case 2:
                final aro aroVar2 = this.b;
                ajy ajyVar = aroVar2._bf;
                CodeEditor codeEditor = aroVar2.a;
                ArrayList<dhr> arrayList = aroVar2.f.a;
                if (aroVar2.q) {
                    arq colorScheme = codeEditor.getColorScheme();
                    throwIfVar1IsNull(arrayList, "<this>");
                    if (colorScheme == null) {
                        colorScheme = arq.a;
                        throwIfVar1IsNull(colorScheme, "getDefault(...)");
                    }
                    int i2 = colorScheme.b.get(67);
                    for (dhr dhrVar : arrayList) {
                        dlb dlbVar = dhrVar.f;
                        if (dlbVar != null && !(dhrVar.b instanceof Spannable)) {
                            bgs bgsVar = dlbVar.b;
                            SpannableString spannableString = new SpannableString(dhrVar.b);
                            int size = bgsVar.c.size() - 1;
                            if (size >= 0) {
                                while (true) {
                                    int i3 = size - 1;
                                    int iIntValue = ((Number) bgsVar.c.get(size)).intValue();
                                    if (iIntValue >= 0 && iIntValue < spannableString.length()) {
                                        int i4 = iIntValue + 1;
                                        int length = spannableString.length();
                                        if (i4 > length) {
                                            i4 = length;
                                        }
                                        if (i4 > iIntValue) {
                                            try {
                                                spannableString.setSpan(new ForegroundColorSpan(i2), iIntValue, i4, 33);
                                            } catch (Exception e) {
                                                e.printStackTrace();
                                            }
                                        }
                                    }
                                    if (i3 >= 0) {
                                        size = i3;
                                    }
                                }
                            }
                            dhrVar.b = spannableString;
                            break;
                        }
                    }
                }
                WeakReference weakReference = aroVar2.g;
                if (weakReference == null || weakReference.get() != arrayList) {
                    ajyVar.a = aroVar2;
                    ajyVar.b = arrayList;
                    ajyVar.notifyDataSetInvalidated();
                    aroVar2.g = new WeakReference(arrayList);
                } else {
                    ajyVar.notifyDataSetChanged();
                }
                if (codeEditor.getProps().ai && (context = codeEditor.getContext()) != null) {
                    Configuration configuration = context.getResources().getConfiguration();
                    if ((configuration.keyboard != 1 || configuration.hardKeyboardHidden == 1) && aroVar2.h == -1) {
                        aroVar2.u();
                    }
                }
                float count = ajyVar.getCount() * ((int) TypedValue.applyDimension(1, 45.0f,
                        ajyVar.a.a.getContext().getResources().getDisplayMetrics()));
                if (count == 0.0f) {
                    aroVar2.t();
                }
                aroVar2.y(true);
                int i5 = aroVar2.al;
                int iMin = (int) Math.min(count, aroVar2.d);
                aroVar2.al = i5;
                aroVar2.am = iMin;
                aroVar2.an(false);
                codeEditor.eh(new arm(aroVar2, 0), 10L);
                if (!aroVar2.z.isShowing() && !aroVar2.b && aroVar2.o) {
                    aroVar2.m = System.currentTimeMillis();
                    final long j = aroVar2.c;
                    codeEditor.eh(new Runnable() { // from class: me.hd.wauxv.obf.arl
                        @Override // java.lang.Runnable
                        public final void run() {
                            aro aroVar3 = aroVar2;
                            if (aroVar3.n >= aroVar3.m || aroVar3.c != j || aroVar3.z.isShowing()) {
                                return;
                            }
                            aroVar3.an(true);
                        }
                    }, 70L);
                    break;
                }
                break;
            default:
                this.b.t();
                break;
        }
    }
}

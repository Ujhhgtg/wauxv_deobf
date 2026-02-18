package me.hd.wauxv.obf;

import android.R;
import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.os.Handler;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.ProgressBar;
import android.widget.Toast;
import io.github.rosemoe.sora.widget.CodeEditor;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class aro extends ase {
    public final ajy _bf;
    public final CodeEditor a;
    public boolean b;
    public long c;
    public int d;
    public arn e;
    public abw f;
    public WeakReference g;
    public int h;
    public final chm j;
    public final awy k;
    public ud l;
    public long m;
    public long n;
    public boolean o;
    public boolean p;
    public final boolean q;

    public aro(CodeEditor codeEditor) {
        super(codeEditor, 4);
        this.b = false;
        this.h = -1;
        this.m = 0L;
        this.n = -1L;
        this.o = true;
        this.p = false;
        this.q = true;
        this.a = codeEditor;
        ajy ajyVar = new ajy();
        this._bf = ajyVar;
        final chm chmVar = new chm();
        this.j = chmVar;
        chmVar.f = this;
        final Context context = codeEditor.getContext();
        LinearLayout linearLayout = new LinearLayout(context);
        chmVar.e = linearLayout;
        chmVar.c = new ListView(context);
        chmVar.d = new ProgressBar(context, null, R.attr.progressBarStyleHorizontal);
        linearLayout.setOrientation(1);
        ((LinearLayout) chmVar.e).setLayoutTransition(null);
        ((ListView) chmVar.c).setLayoutTransition(null);
        linearLayout.addView((ProgressBar) chmVar.d, new LinearLayout.LayoutParams(-1, (int) TypedValue.applyDimension(1, 20.0f, context.getResources().getDisplayMetrics())));
        linearLayout.addView((ListView) chmVar.c, new LinearLayout.LayoutParams(-1, -1));
        ((ProgressBar) chmVar.d).setIndeterminate(true);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) ((ProgressBar) chmVar.d).getLayoutParams();
        layoutParams.topMargin = (int) TypedValue.applyDimension(1, -8.0f, context.getResources().getDisplayMetrics());
        layoutParams.bottomMargin = (int) TypedValue.applyDimension(1, -8.0f, context.getResources().getDisplayMetrics());
        layoutParams.leftMargin = (int) TypedValue.applyDimension(1, 4.0f, context.getResources().getDisplayMetrics());
        layoutParams.rightMargin = (int) TypedValue.applyDimension(1, 4.0f, context.getResources().getDisplayMetrics());
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(TypedValue.applyDimension(1, 8.0f, context.getResources().getDisplayMetrics()));
        linearLayout.setBackground(gradientDrawable);
        LinearLayout linearLayout2 = (LinearLayout) chmVar.e;
        linearLayout2.setOutlineProvider(new akb());
        linearLayout2.setClipToOutline(true);
        ((ListView) chmVar.c).setDividerHeight(0);
        ((ProgressBar) chmVar.d).setVisibility(0);
        ((ListView) chmVar.c).setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: me.hd.wauxv.obf.aka
            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView adapterView, View view, int i, long j) {
                chm chmVar2 = chmVar;
                chmVar2.getClass();
                try {
                    ((aro) chmVar2.f).w(i);
                } catch (Exception e) {
                    e.printStackTrace(System.err);
                    Toast.makeText(context, e.toString(), 0).show();
                }
            }
        });
        this.z.setContentView(linearLayout);
        r();
        ((ListView) this.j.c).setAdapter(ajyVar);
        awy awyVar = new awy(codeEditor.i);
        this.k = awyVar;
        final int i = 0;
        awyVar.l(abg.class, new awz(this) { // from class: me.hd.wauxv.obf.ark
            public final /* synthetic */ aro b;

            {
                this.b = this;
            }

            @Override // me.hd.wauxv.obf.awz
            public final void g(ua uaVar, afc afcVar) {
                int i2;
                switch (i) {
                    case 0:
                        this.b.r();
                        break;
                    case 1:
                        afh afhVar = (afh) uaVar;
                        aro aroVar = this.b;
                        PopupWindow popupWindow = aroVar.z;
                        CodeEditor codeEditor2 = aroVar.a;
                        if (!afhVar.o && aroVar.o) {
                            int i3 = afhVar.a;
                            boolean z = true;
                            if (i3 != 1) {
                                ud udVar = afhVar.l;
                                ud udVar2 = afhVar.m;
                                if (i3 == 2) {
                                    if ((codeEditor2.h.c.e() && !codeEditor2.getProps().e) || udVar2.c == 0 || udVar.b != udVar2.b) {
                                        aroVar.t();
                                        z = false;
                                    }
                                    aroVar.y(popupWindow.isShowing());
                                } else if (i3 != 3 || codeEditor2.h.c.e() || !popupWindow.isShowing()) {
                                    z = false;
                                } else if (udVar.b == udVar2.b && udVar.c == udVar2.c - 1) {
                                    aroVar.y(true);
                                } else {
                                    aroVar.t();
                                    z = false;
                                }
                                if (z) {
                                    aroVar.v();
                                }
                            }
                        }
                        aroVar.t();
                        break;
                    case 2:
                        int i4 = ((dfb) uaVar).o;
                        aro aroVar2 = this.b;
                        if (i4 == 1) {
                            aroVar2.y(false);
                        } else if (i4 == 2) {
                            float dpUnit = aroVar2.a.getDpUnit() * 2000.0f;
                            if (Math.abs(0.0f) >= dpUnit || Math.abs(0.0f) >= dpUnit) {
                                aroVar2.t();
                            }
                        }
                        break;
                    case 3:
                        asb asbVar = (asb) uaVar;
                        int i5 = asbVar.m;
                        KeyEvent keyEvent = asbVar.l;
                        if (i5 == 2 && !asbVar.o && (keyEvent.getMetaState() & 4096) == 0 && !asbVar.n) {
                            aro aroVar3 = this.b;
                            if (aroVar3.z.isShowing()) {
                                int keyCode = keyEvent.getKeyCode();
                                if (keyCode == 19) {
                                    ListView listView = (ListView) aroVar3.j.c;
                                    int i6 = aroVar3.h - 1;
                                    if (i6 >= 0) {
                                        aroVar3.h = i6;
                                        ((ajy) listView.getAdapter()).notifyDataSetChanged();
                                        int i7 = aroVar3.h;
                                        if (i7 != -1) {
                                            chm chmVar2 = aroVar3.j;
                                            ((ListView) chmVar2.c).post(new ajz(chmVar2, i7, (int) TypedValue.applyDimension(1, 45.0f, aroVar3._bf.a.a.getContext().getResources().getDisplayMetrics())));
                                        }
                                    }
                                    asbVar.a = Boolean.TRUE;
                                    asbVar.b = 3;
                                } else if (keyCode == 20) {
                                    aroVar3.u();
                                    asbVar.a = Boolean.TRUE;
                                    asbVar.b = 3;
                                } else if (keyCode == 61 || keyCode == 66) {
                                    if (aroVar3.w(aroVar3.h)) {
                                        asbVar.a = Boolean.TRUE;
                                        asbVar.b = 3;
                                    }
                                } else if (keyCode == 92 || keyCode == 93) {
                                    aroVar3.t();
                                }
                            }
                            break;
                        }
                        break;
                    case 4:
                        dfn dfnVar = (dfn) uaVar;
                        boolean zN = dfnVar.n();
                        ud udVar3 = dfnVar.a;
                        aro aroVar4 = this.b;
                        if (!zN && (i2 = dfnVar.m) != 4 && i2 != 2 && i2 != 3 && i2 != 6 && i2 != 0) {
                            ud udVar4 = aroVar4.l;
                            if (udVar4 == null) {
                                aroVar4.l = udVar3.d();
                                break;
                            } else if (i2 == 7) {
                                if (udVar4.b != udVar3.b) {
                                    aroVar4.t();
                                    break;
                                } else if (aroVar4.z.isShowing() && Math.abs(aroVar4.l.c - udVar3.c) <= 1) {
                                    if (udVar3.c <= 0) {
                                        aroVar4.t();
                                    } else {
                                        aroVar4.v();
                                    }
                                    break;
                                }
                            }
                        } else {
                            aroVar4.t();
                            break;
                        }
                        break;
                    default:
                        aro aroVar5 = this.b;
                        aroVar5.o = false;
                        aroVar5.k.j(false);
                        aroVar5.s();
                        aroVar5.t();
                        break;
                }
            }
        });
        final int i2 = 1;
        awyVar.l(afh.class, new awz(this) { // from class: me.hd.wauxv.obf.ark
            public final /* synthetic */ aro b;

            {
                this.b = this;
            }

            @Override // me.hd.wauxv.obf.awz
            public final void g(ua uaVar, afc afcVar) {
                int i22;
                switch (i2) {
                    case 0:
                        this.b.r();
                        break;
                    case 1:
                        afh afhVar = (afh) uaVar;
                        aro aroVar = this.b;
                        PopupWindow popupWindow = aroVar.z;
                        CodeEditor codeEditor2 = aroVar.a;
                        if (!afhVar.o && aroVar.o) {
                            int i3 = afhVar.a;
                            boolean z = true;
                            if (i3 != 1) {
                                ud udVar = afhVar.l;
                                ud udVar2 = afhVar.m;
                                if (i3 == 2) {
                                    if ((codeEditor2.h.c.e() && !codeEditor2.getProps().e) || udVar2.c == 0 || udVar.b != udVar2.b) {
                                        aroVar.t();
                                        z = false;
                                    }
                                    aroVar.y(popupWindow.isShowing());
                                } else if (i3 != 3 || codeEditor2.h.c.e() || !popupWindow.isShowing()) {
                                    z = false;
                                } else if (udVar.b == udVar2.b && udVar.c == udVar2.c - 1) {
                                    aroVar.y(true);
                                } else {
                                    aroVar.t();
                                    z = false;
                                }
                                if (z) {
                                    aroVar.v();
                                }
                            }
                        }
                        aroVar.t();
                        break;
                    case 2:
                        int i4 = ((dfb) uaVar).o;
                        aro aroVar2 = this.b;
                        if (i4 == 1) {
                            aroVar2.y(false);
                        } else if (i4 == 2) {
                            float dpUnit = aroVar2.a.getDpUnit() * 2000.0f;
                            if (Math.abs(0.0f) >= dpUnit || Math.abs(0.0f) >= dpUnit) {
                                aroVar2.t();
                            }
                        }
                        break;
                    case 3:
                        asb asbVar = (asb) uaVar;
                        int i5 = asbVar.m;
                        KeyEvent keyEvent = asbVar.l;
                        if (i5 == 2 && !asbVar.o && (keyEvent.getMetaState() & 4096) == 0 && !asbVar.n) {
                            aro aroVar3 = this.b;
                            if (aroVar3.z.isShowing()) {
                                int keyCode = keyEvent.getKeyCode();
                                if (keyCode == 19) {
                                    ListView listView = (ListView) aroVar3.j.c;
                                    int i6 = aroVar3.h - 1;
                                    if (i6 >= 0) {
                                        aroVar3.h = i6;
                                        ((ajy) listView.getAdapter()).notifyDataSetChanged();
                                        int i7 = aroVar3.h;
                                        if (i7 != -1) {
                                            chm chmVar2 = aroVar3.j;
                                            ((ListView) chmVar2.c).post(new ajz(chmVar2, i7, (int) TypedValue.applyDimension(1, 45.0f, aroVar3._bf.a.a.getContext().getResources().getDisplayMetrics())));
                                        }
                                    }
                                    asbVar.a = Boolean.TRUE;
                                    asbVar.b = 3;
                                } else if (keyCode == 20) {
                                    aroVar3.u();
                                    asbVar.a = Boolean.TRUE;
                                    asbVar.b = 3;
                                } else if (keyCode == 61 || keyCode == 66) {
                                    if (aroVar3.w(aroVar3.h)) {
                                        asbVar.a = Boolean.TRUE;
                                        asbVar.b = 3;
                                    }
                                } else if (keyCode == 92 || keyCode == 93) {
                                    aroVar3.t();
                                }
                            }
                            break;
                        }
                        break;
                    case 4:
                        dfn dfnVar = (dfn) uaVar;
                        boolean zN = dfnVar.n();
                        ud udVar3 = dfnVar.a;
                        aro aroVar4 = this.b;
                        if (!zN && (i22 = dfnVar.m) != 4 && i22 != 2 && i22 != 3 && i22 != 6 && i22 != 0) {
                            ud udVar4 = aroVar4.l;
                            if (udVar4 == null) {
                                aroVar4.l = udVar3.d();
                                break;
                            } else if (i22 == 7) {
                                if (udVar4.b != udVar3.b) {
                                    aroVar4.t();
                                    break;
                                } else if (aroVar4.z.isShowing() && Math.abs(aroVar4.l.c - udVar3.c) <= 1) {
                                    if (udVar3.c <= 0) {
                                        aroVar4.t();
                                    } else {
                                        aroVar4.v();
                                    }
                                    break;
                                }
                            }
                        } else {
                            aroVar4.t();
                            break;
                        }
                        break;
                    default:
                        aro aroVar5 = this.b;
                        aroVar5.o = false;
                        aroVar5.k.j(false);
                        aroVar5.s();
                        aroVar5.t();
                        break;
                }
            }
        });
        final int i3 = 2;
        awyVar.l(dfb.class, new awz(this) { // from class: me.hd.wauxv.obf.ark
            public final /* synthetic */ aro b;

            {
                this.b = this;
            }

            @Override // me.hd.wauxv.obf.awz
            public final void g(ua uaVar, afc afcVar) {
                int i22;
                switch (i3) {
                    case 0:
                        this.b.r();
                        break;
                    case 1:
                        afh afhVar = (afh) uaVar;
                        aro aroVar = this.b;
                        PopupWindow popupWindow = aroVar.z;
                        CodeEditor codeEditor2 = aroVar.a;
                        if (!afhVar.o && aroVar.o) {
                            int i32 = afhVar.a;
                            boolean z = true;
                            if (i32 != 1) {
                                ud udVar = afhVar.l;
                                ud udVar2 = afhVar.m;
                                if (i32 == 2) {
                                    if ((codeEditor2.h.c.e() && !codeEditor2.getProps().e) || udVar2.c == 0 || udVar.b != udVar2.b) {
                                        aroVar.t();
                                        z = false;
                                    }
                                    aroVar.y(popupWindow.isShowing());
                                } else if (i32 != 3 || codeEditor2.h.c.e() || !popupWindow.isShowing()) {
                                    z = false;
                                } else if (udVar.b == udVar2.b && udVar.c == udVar2.c - 1) {
                                    aroVar.y(true);
                                } else {
                                    aroVar.t();
                                    z = false;
                                }
                                if (z) {
                                    aroVar.v();
                                }
                            }
                        }
                        aroVar.t();
                        break;
                    case 2:
                        int i4 = ((dfb) uaVar).o;
                        aro aroVar2 = this.b;
                        if (i4 == 1) {
                            aroVar2.y(false);
                        } else if (i4 == 2) {
                            float dpUnit = aroVar2.a.getDpUnit() * 2000.0f;
                            if (Math.abs(0.0f) >= dpUnit || Math.abs(0.0f) >= dpUnit) {
                                aroVar2.t();
                            }
                        }
                        break;
                    case 3:
                        asb asbVar = (asb) uaVar;
                        int i5 = asbVar.m;
                        KeyEvent keyEvent = asbVar.l;
                        if (i5 == 2 && !asbVar.o && (keyEvent.getMetaState() & 4096) == 0 && !asbVar.n) {
                            aro aroVar3 = this.b;
                            if (aroVar3.z.isShowing()) {
                                int keyCode = keyEvent.getKeyCode();
                                if (keyCode == 19) {
                                    ListView listView = (ListView) aroVar3.j.c;
                                    int i6 = aroVar3.h - 1;
                                    if (i6 >= 0) {
                                        aroVar3.h = i6;
                                        ((ajy) listView.getAdapter()).notifyDataSetChanged();
                                        int i7 = aroVar3.h;
                                        if (i7 != -1) {
                                            chm chmVar2 = aroVar3.j;
                                            ((ListView) chmVar2.c).post(new ajz(chmVar2, i7, (int) TypedValue.applyDimension(1, 45.0f, aroVar3._bf.a.a.getContext().getResources().getDisplayMetrics())));
                                        }
                                    }
                                    asbVar.a = Boolean.TRUE;
                                    asbVar.b = 3;
                                } else if (keyCode == 20) {
                                    aroVar3.u();
                                    asbVar.a = Boolean.TRUE;
                                    asbVar.b = 3;
                                } else if (keyCode == 61 || keyCode == 66) {
                                    if (aroVar3.w(aroVar3.h)) {
                                        asbVar.a = Boolean.TRUE;
                                        asbVar.b = 3;
                                    }
                                } else if (keyCode == 92 || keyCode == 93) {
                                    aroVar3.t();
                                }
                            }
                            break;
                        }
                        break;
                    case 4:
                        dfn dfnVar = (dfn) uaVar;
                        boolean zN = dfnVar.n();
                        ud udVar3 = dfnVar.a;
                        aro aroVar4 = this.b;
                        if (!zN && (i22 = dfnVar.m) != 4 && i22 != 2 && i22 != 3 && i22 != 6 && i22 != 0) {
                            ud udVar4 = aroVar4.l;
                            if (udVar4 == null) {
                                aroVar4.l = udVar3.d();
                                break;
                            } else if (i22 == 7) {
                                if (udVar4.b != udVar3.b) {
                                    aroVar4.t();
                                    break;
                                } else if (aroVar4.z.isShowing() && Math.abs(aroVar4.l.c - udVar3.c) <= 1) {
                                    if (udVar3.c <= 0) {
                                        aroVar4.t();
                                    } else {
                                        aroVar4.v();
                                    }
                                    break;
                                }
                            }
                        } else {
                            aroVar4.t();
                            break;
                        }
                        break;
                    default:
                        aro aroVar5 = this.b;
                        aroVar5.o = false;
                        aroVar5.k.j(false);
                        aroVar5.s();
                        aroVar5.t();
                        break;
                }
            }
        });
        final int i4 = 3;
        awyVar.l(asb.class, new awz(this) { // from class: me.hd.wauxv.obf.ark
            public final /* synthetic */ aro b;

            {
                this.b = this;
            }

            @Override // me.hd.wauxv.obf.awz
            public final void g(ua uaVar, afc afcVar) {
                int i22;
                switch (i4) {
                    case 0:
                        this.b.r();
                        break;
                    case 1:
                        afh afhVar = (afh) uaVar;
                        aro aroVar = this.b;
                        PopupWindow popupWindow = aroVar.z;
                        CodeEditor codeEditor2 = aroVar.a;
                        if (!afhVar.o && aroVar.o) {
                            int i32 = afhVar.a;
                            boolean z = true;
                            if (i32 != 1) {
                                ud udVar = afhVar.l;
                                ud udVar2 = afhVar.m;
                                if (i32 == 2) {
                                    if ((codeEditor2.h.c.e() && !codeEditor2.getProps().e) || udVar2.c == 0 || udVar.b != udVar2.b) {
                                        aroVar.t();
                                        z = false;
                                    }
                                    aroVar.y(popupWindow.isShowing());
                                } else if (i32 != 3 || codeEditor2.h.c.e() || !popupWindow.isShowing()) {
                                    z = false;
                                } else if (udVar.b == udVar2.b && udVar.c == udVar2.c - 1) {
                                    aroVar.y(true);
                                } else {
                                    aroVar.t();
                                    z = false;
                                }
                                if (z) {
                                    aroVar.v();
                                }
                            }
                        }
                        aroVar.t();
                        break;
                    case 2:
                        int i42 = ((dfb) uaVar).o;
                        aro aroVar2 = this.b;
                        if (i42 == 1) {
                            aroVar2.y(false);
                        } else if (i42 == 2) {
                            float dpUnit = aroVar2.a.getDpUnit() * 2000.0f;
                            if (Math.abs(0.0f) >= dpUnit || Math.abs(0.0f) >= dpUnit) {
                                aroVar2.t();
                            }
                        }
                        break;
                    case 3:
                        asb asbVar = (asb) uaVar;
                        int i5 = asbVar.m;
                        KeyEvent keyEvent = asbVar.l;
                        if (i5 == 2 && !asbVar.o && (keyEvent.getMetaState() & 4096) == 0 && !asbVar.n) {
                            aro aroVar3 = this.b;
                            if (aroVar3.z.isShowing()) {
                                int keyCode = keyEvent.getKeyCode();
                                if (keyCode == 19) {
                                    ListView listView = (ListView) aroVar3.j.c;
                                    int i6 = aroVar3.h - 1;
                                    if (i6 >= 0) {
                                        aroVar3.h = i6;
                                        ((ajy) listView.getAdapter()).notifyDataSetChanged();
                                        int i7 = aroVar3.h;
                                        if (i7 != -1) {
                                            chm chmVar2 = aroVar3.j;
                                            ((ListView) chmVar2.c).post(new ajz(chmVar2, i7, (int) TypedValue.applyDimension(1, 45.0f, aroVar3._bf.a.a.getContext().getResources().getDisplayMetrics())));
                                        }
                                    }
                                    asbVar.a = Boolean.TRUE;
                                    asbVar.b = 3;
                                } else if (keyCode == 20) {
                                    aroVar3.u();
                                    asbVar.a = Boolean.TRUE;
                                    asbVar.b = 3;
                                } else if (keyCode == 61 || keyCode == 66) {
                                    if (aroVar3.w(aroVar3.h)) {
                                        asbVar.a = Boolean.TRUE;
                                        asbVar.b = 3;
                                    }
                                } else if (keyCode == 92 || keyCode == 93) {
                                    aroVar3.t();
                                }
                            }
                            break;
                        }
                        break;
                    case 4:
                        dfn dfnVar = (dfn) uaVar;
                        boolean zN = dfnVar.n();
                        ud udVar3 = dfnVar.a;
                        aro aroVar4 = this.b;
                        if (!zN && (i22 = dfnVar.m) != 4 && i22 != 2 && i22 != 3 && i22 != 6 && i22 != 0) {
                            ud udVar4 = aroVar4.l;
                            if (udVar4 == null) {
                                aroVar4.l = udVar3.d();
                                break;
                            } else if (i22 == 7) {
                                if (udVar4.b != udVar3.b) {
                                    aroVar4.t();
                                    break;
                                } else if (aroVar4.z.isShowing() && Math.abs(aroVar4.l.c - udVar3.c) <= 1) {
                                    if (udVar3.c <= 0) {
                                        aroVar4.t();
                                    } else {
                                        aroVar4.v();
                                    }
                                    break;
                                }
                            }
                        } else {
                            aroVar4.t();
                            break;
                        }
                        break;
                    default:
                        aro aroVar5 = this.b;
                        aroVar5.o = false;
                        aroVar5.k.j(false);
                        aroVar5.s();
                        aroVar5.t();
                        break;
                }
            }
        });
        final int i5 = 4;
        awyVar.l(dfn.class, new awz(this) { // from class: me.hd.wauxv.obf.ark
            public final /* synthetic */ aro b;

            {
                this.b = this;
            }

            @Override // me.hd.wauxv.obf.awz
            public final void g(ua uaVar, afc afcVar) {
                int i22;
                switch (i5) {
                    case 0:
                        this.b.r();
                        break;
                    case 1:
                        afh afhVar = (afh) uaVar;
                        aro aroVar = this.b;
                        PopupWindow popupWindow = aroVar.z;
                        CodeEditor codeEditor2 = aroVar.a;
                        if (!afhVar.o && aroVar.o) {
                            int i32 = afhVar.a;
                            boolean z = true;
                            if (i32 != 1) {
                                ud udVar = afhVar.l;
                                ud udVar2 = afhVar.m;
                                if (i32 == 2) {
                                    if ((codeEditor2.h.c.e() && !codeEditor2.getProps().e) || udVar2.c == 0 || udVar.b != udVar2.b) {
                                        aroVar.t();
                                        z = false;
                                    }
                                    aroVar.y(popupWindow.isShowing());
                                } else if (i32 != 3 || codeEditor2.h.c.e() || !popupWindow.isShowing()) {
                                    z = false;
                                } else if (udVar.b == udVar2.b && udVar.c == udVar2.c - 1) {
                                    aroVar.y(true);
                                } else {
                                    aroVar.t();
                                    z = false;
                                }
                                if (z) {
                                    aroVar.v();
                                }
                            }
                        }
                        aroVar.t();
                        break;
                    case 2:
                        int i42 = ((dfb) uaVar).o;
                        aro aroVar2 = this.b;
                        if (i42 == 1) {
                            aroVar2.y(false);
                        } else if (i42 == 2) {
                            float dpUnit = aroVar2.a.getDpUnit() * 2000.0f;
                            if (Math.abs(0.0f) >= dpUnit || Math.abs(0.0f) >= dpUnit) {
                                aroVar2.t();
                            }
                        }
                        break;
                    case 3:
                        asb asbVar = (asb) uaVar;
                        int i52 = asbVar.m;
                        KeyEvent keyEvent = asbVar.l;
                        if (i52 == 2 && !asbVar.o && (keyEvent.getMetaState() & 4096) == 0 && !asbVar.n) {
                            aro aroVar3 = this.b;
                            if (aroVar3.z.isShowing()) {
                                int keyCode = keyEvent.getKeyCode();
                                if (keyCode == 19) {
                                    ListView listView = (ListView) aroVar3.j.c;
                                    int i6 = aroVar3.h - 1;
                                    if (i6 >= 0) {
                                        aroVar3.h = i6;
                                        ((ajy) listView.getAdapter()).notifyDataSetChanged();
                                        int i7 = aroVar3.h;
                                        if (i7 != -1) {
                                            chm chmVar2 = aroVar3.j;
                                            ((ListView) chmVar2.c).post(new ajz(chmVar2, i7, (int) TypedValue.applyDimension(1, 45.0f, aroVar3._bf.a.a.getContext().getResources().getDisplayMetrics())));
                                        }
                                    }
                                    asbVar.a = Boolean.TRUE;
                                    asbVar.b = 3;
                                } else if (keyCode == 20) {
                                    aroVar3.u();
                                    asbVar.a = Boolean.TRUE;
                                    asbVar.b = 3;
                                } else if (keyCode == 61 || keyCode == 66) {
                                    if (aroVar3.w(aroVar3.h)) {
                                        asbVar.a = Boolean.TRUE;
                                        asbVar.b = 3;
                                    }
                                } else if (keyCode == 92 || keyCode == 93) {
                                    aroVar3.t();
                                }
                            }
                            break;
                        }
                        break;
                    case 4:
                        dfn dfnVar = (dfn) uaVar;
                        boolean zN = dfnVar.n();
                        ud udVar3 = dfnVar.a;
                        aro aroVar4 = this.b;
                        if (!zN && (i22 = dfnVar.m) != 4 && i22 != 2 && i22 != 3 && i22 != 6 && i22 != 0) {
                            ud udVar4 = aroVar4.l;
                            if (udVar4 == null) {
                                aroVar4.l = udVar3.d();
                                break;
                            } else if (i22 == 7) {
                                if (udVar4.b != udVar3.b) {
                                    aroVar4.t();
                                    break;
                                } else if (aroVar4.z.isShowing() && Math.abs(aroVar4.l.c - udVar3.c) <= 1) {
                                    if (udVar3.c <= 0) {
                                        aroVar4.t();
                                    } else {
                                        aroVar4.v();
                                    }
                                    break;
                                }
                            }
                        } else {
                            aroVar4.t();
                            break;
                        }
                        break;
                    default:
                        aro aroVar5 = this.b;
                        aroVar5.o = false;
                        aroVar5.k.j(false);
                        aroVar5.s();
                        aroVar5.t();
                        break;
                }
            }
        });
        final int i6 = 5;
        awyVar.l(asf.class, new awz(this) { // from class: me.hd.wauxv.obf.ark
            public final /* synthetic */ aro b;

            {
                this.b = this;
            }

            @Override // me.hd.wauxv.obf.awz
            public final void g(ua uaVar, afc afcVar) {
                int i22;
                switch (i6) {
                    case 0:
                        this.b.r();
                        break;
                    case 1:
                        afh afhVar = (afh) uaVar;
                        aro aroVar = this.b;
                        PopupWindow popupWindow = aroVar.z;
                        CodeEditor codeEditor2 = aroVar.a;
                        if (!afhVar.o && aroVar.o) {
                            int i32 = afhVar.a;
                            boolean z = true;
                            if (i32 != 1) {
                                ud udVar = afhVar.l;
                                ud udVar2 = afhVar.m;
                                if (i32 == 2) {
                                    if ((codeEditor2.h.c.e() && !codeEditor2.getProps().e) || udVar2.c == 0 || udVar.b != udVar2.b) {
                                        aroVar.t();
                                        z = false;
                                    }
                                    aroVar.y(popupWindow.isShowing());
                                } else if (i32 != 3 || codeEditor2.h.c.e() || !popupWindow.isShowing()) {
                                    z = false;
                                } else if (udVar.b == udVar2.b && udVar.c == udVar2.c - 1) {
                                    aroVar.y(true);
                                } else {
                                    aroVar.t();
                                    z = false;
                                }
                                if (z) {
                                    aroVar.v();
                                }
                            }
                        }
                        aroVar.t();
                        break;
                    case 2:
                        int i42 = ((dfb) uaVar).o;
                        aro aroVar2 = this.b;
                        if (i42 == 1) {
                            aroVar2.y(false);
                        } else if (i42 == 2) {
                            float dpUnit = aroVar2.a.getDpUnit() * 2000.0f;
                            if (Math.abs(0.0f) >= dpUnit || Math.abs(0.0f) >= dpUnit) {
                                aroVar2.t();
                            }
                        }
                        break;
                    case 3:
                        asb asbVar = (asb) uaVar;
                        int i52 = asbVar.m;
                        KeyEvent keyEvent = asbVar.l;
                        if (i52 == 2 && !asbVar.o && (keyEvent.getMetaState() & 4096) == 0 && !asbVar.n) {
                            aro aroVar3 = this.b;
                            if (aroVar3.z.isShowing()) {
                                int keyCode = keyEvent.getKeyCode();
                                if (keyCode == 19) {
                                    ListView listView = (ListView) aroVar3.j.c;
                                    int i62 = aroVar3.h - 1;
                                    if (i62 >= 0) {
                                        aroVar3.h = i62;
                                        ((ajy) listView.getAdapter()).notifyDataSetChanged();
                                        int i7 = aroVar3.h;
                                        if (i7 != -1) {
                                            chm chmVar2 = aroVar3.j;
                                            ((ListView) chmVar2.c).post(new ajz(chmVar2, i7, (int) TypedValue.applyDimension(1, 45.0f, aroVar3._bf.a.a.getContext().getResources().getDisplayMetrics())));
                                        }
                                    }
                                    asbVar.a = Boolean.TRUE;
                                    asbVar.b = 3;
                                } else if (keyCode == 20) {
                                    aroVar3.u();
                                    asbVar.a = Boolean.TRUE;
                                    asbVar.b = 3;
                                } else if (keyCode == 61 || keyCode == 66) {
                                    if (aroVar3.w(aroVar3.h)) {
                                        asbVar.a = Boolean.TRUE;
                                        asbVar.b = 3;
                                    }
                                } else if (keyCode == 92 || keyCode == 93) {
                                    aroVar3.t();
                                }
                            }
                            break;
                        }
                        break;
                    case 4:
                        dfn dfnVar = (dfn) uaVar;
                        boolean zN = dfnVar.n();
                        ud udVar3 = dfnVar.a;
                        aro aroVar4 = this.b;
                        if (!zN && (i22 = dfnVar.m) != 4 && i22 != 2 && i22 != 3 && i22 != 6 && i22 != 0) {
                            ud udVar4 = aroVar4.l;
                            if (udVar4 == null) {
                                aroVar4.l = udVar3.d();
                                break;
                            } else if (i22 == 7) {
                                if (udVar4.b != udVar3.b) {
                                    aroVar4.t();
                                    break;
                                } else if (aroVar4.z.isShowing() && Math.abs(aroVar4.l.c - udVar3.c) <= 1) {
                                    if (udVar3.c <= 0) {
                                        aroVar4.t();
                                    } else {
                                        aroVar4.v();
                                    }
                                    break;
                                }
                            }
                        } else {
                            aroVar4.t();
                            break;
                        }
                        break;
                    default:
                        aro aroVar5 = this.b;
                        aroVar5.o = false;
                        aroVar5.k.j(false);
                        aroVar5.s();
                        aroVar5.t();
                        break;
                }
            }
        });
        x(ary.class, new amb(25));
        x(zx.class, null);
        x(asc.class, null);
        x(arx.class, new amb(26));
        x(dim.class, new amb(27));
    }

    public final void r() {
        arq colorScheme = this.a.getColorScheme();
        chm chmVar = this.j;
        chmVar.getClass();
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(TypedValue.applyDimension(1, 8.0f, ((aro) chmVar.f).a.getContext().getResources().getDisplayMetrics()));
        gradientDrawable.setStroke((int) TypedValue.applyDimension(1, 1.0f, ((aro) chmVar.f).a.getContext().getResources().getDisplayMetrics()), colorScheme.b.get(20));
        gradientDrawable.setColor(colorScheme.b.get(19));
        ((LinearLayout) chmVar.e).setBackground(gradientDrawable);
        LinearLayout linearLayout = (LinearLayout) chmVar.e;
        linearLayout.setOutlineProvider(new akb());
        linearLayout.setClipToOutline(true);
    }

    public final void s() {
        arn arnVar = this.e;
        if (arnVar != null && arnVar.isAlive()) {
            arnVar.f = true;
            arnVar.b.getClass();
            arnVar.interrupt();
            arnVar.d.i = true;
            arnVar.e = -1L;
        }
        this.e = null;
    }

    public final void t() {
        i();
        s();
        this.n = System.currentTimeMillis();
    }

    public final void u() {
        ListView listView = (ListView) this.j.c;
        if (this.h + 1 >= listView.getAdapter().getCount()) {
            return;
        }
        this.h++;
        ((ajy) listView.getAdapter()).notifyDataSetChanged();
        int i = this.h;
        if (i != -1) {
            int iApplyDimension = (int) TypedValue.applyDimension(1, 45.0f, this._bf.a.a.getContext().getResources().getDisplayMetrics());
            chm chmVar = this.j;
            ((ListView) chmVar.c).post(new ajz(chmVar, i, iApplyDimension));
        }
    }

    public final void v() {
        if (this.b || !this.o) {
            return;
        }
        CodeEditor codeEditor = this.a;
        if (!codeEditor.getText().w().h()) {
            if (!bhs.m(codeEditor.getStyles(), codeEditor.getCursor().c.d())) {
                if (System.nanoTime() - this.c < codeEditor.getProps().j) {
                    t();
                    this.c = System.nanoTime();
                    return;
                }
                s();
                this.c = System.nanoTime();
                this.h = -1;
                Handler handler = codeEditor.getHandler();
                arm armVar = new arm(this, 2);
                codeEditor.getEditorLanguage().getClass();
                this.f = new abw(handler, armVar, 0);
                this.e = new arn(this, this.c, this.f);
                this.p = true;
                codeEditor.eh(new arm(this, 1), 50L);
                this.e.start();
                return;
            }
        }
        t();
    }

    public final boolean w(int i) {
        if (i == -1) {
            return false;
        }
        dhr dhrVar = (dhr) ((ajy) ((ListView) this.j.c).getAdapter()).b.get(i);
        CodeEditor codeEditor = this.a;
        ahy cursor = codeEditor.getCursor();
        arn arnVar = this.e;
        if (!cursor.h() && arnVar != null) {
            this.b = true;
            codeEditor.ao++;
            codeEditor.getText().l();
            codeEditor.el();
            try {
                dhrVar.j(codeEditor, codeEditor.getText(), arnVar.a);
                codeEditor.ev();
                codeEditor.getText().u();
                int i2 = codeEditor.ao - 1;
                codeEditor.ao = i2;
                if (i2 < 0) {
                    codeEditor.ao = 0;
                }
                this.b = false;
                codeEditor.el();
            } catch (Throwable th) {
                codeEditor.getText().u();
                int i3 = codeEditor.ao - 1;
                codeEditor.ao = i3;
                if (i3 < 0) {
                    codeEditor.ao = 0;
                }
                this.b = false;
                throw th;
            }
        }
        t();
        return true;
    }

    public final void x(Class cls, bgf bgfVar) {
        this.k.l(cls, new ut(this, bgfVar));
    }

    public final void y(boolean z) {
        int iMin;
        CodeEditor codeEditor = this.a;
        float dpUnit = codeEditor.getDpUnit();
        ahy cursor = codeEditor.getCursor();
        float fEw = (20.0f * dpUnit) + codeEditor.ew();
        int rowHeight = codeEditor.getRowHeight();
        btr layout = codeEditor.getLayout();
        ud udVar = cursor.d;
        float f = rowHeight;
        float offsetY = (f / 2.0f) + (layout.r(udVar.b, udVar.c)[0] - codeEditor.getOffsetY());
        float height = codeEditor.getHeight() - offsetY;
        float f2 = 200.0f * dpUnit;
        if (height > f2) {
            height = f2;
        } else {
            float f3 = 100.0f * dpUnit;
            if (height < f3 && z) {
                float f4 = 0.0f;
                while (height < f3 && codeEditor.getOffsetY() + f4 + f <= codeEditor.getScrollMaxY()) {
                    height += f;
                    offsetY -= f;
                    f4 += f;
                }
                codeEditor.getScroller().d(codeEditor.getOffsetX(), codeEditor.getOffsetY(), 0, (int) f4, 0);
            }
        }
        if (codeEditor.getWidth() < 500.0f * dpUnit) {
            iMin = (codeEditor.getWidth() * 7) / 8;
            fEw = (codeEditor.getWidth() / 8.0f) / 2.0f;
        } else {
            iMin = (int) Math.min(dpUnit * 300.0f, codeEditor.getWidth() / 2.0f);
        }
        int i = this.am;
        this.d = (int) height;
        int offsetX = codeEditor.getOffsetX() + ((int) fEw);
        int offsetY2 = codeEditor.getOffsetY();
        this.aj = offsetX;
        this.ak = offsetY2 + ((int) offsetY);
        CodeEditor codeEditor2 = this.aa;
        this.ai = codeEditor2.getOffsetY();
        this.ah = codeEditor2.getOffsetX();
        an(false);
        this.al = iMin;
        this.am = i;
        an(false);
    }
}

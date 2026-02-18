package me.hd.wauxv.obf;

import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.RectF;
import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import io.github.rosemoe.sora.widget.CodeEditor;
import me.hd.wauxv.R;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class ass extends ase implements View.OnClickListener {
    public final CodeEditor a;
    public final ImageButton b;
    public final ImageButton c;
    public final ImageButton d;
    public final ImageButton e;
    public final ImageButton f;
    public final View g;
    public final asv h;
    public final awy j;
    public long k;
    public int l;
    public int m;
    public boolean n;

    public ass(CodeEditor codeEditor) {
        super(codeEditor, 2);
        this.n = true;
        this.a = codeEditor;
        this.h = codeEditor.getEventHandler();
        awy awyVar = new awy(codeEditor.i);
        this.j = awyVar;
        View viewInflate = LayoutInflater.from(codeEditor.getContext()).inflate(R.layout.text_compose_panel,
                (ViewGroup) null);
        this.g = viewInflate;
        ImageButton imageButton = (ImageButton) viewInflate.findViewById(R.id.panel_btn_select_all);
        this.b = imageButton;
        ImageButton imageButton2 = (ImageButton) viewInflate.findViewById(R.id.panel_btn_cut);
        this.e = imageButton2;
        ImageButton imageButton3 = (ImageButton) viewInflate.findViewById(R.id.panel_btn_copy);
        this.d = imageButton3;
        ImageButton imageButton4 = (ImageButton) viewInflate.findViewById(R.id.panel_btn_long_select);
        this.f = imageButton4;
        ImageButton imageButton5 = (ImageButton) viewInflate.findViewById(R.id.panel_btn_paste);
        this.c = imageButton5;
        imageButton.setOnClickListener(this);
        imageButton2.setOnClickListener(this);
        imageButton3.setOnClickListener(this);
        imageButton5.setOnClickListener(this);
        imageButton4.setOnClickListener(this);
        p();
        this.z.setContentView(viewInflate);
        int dpUnit = (int) (codeEditor.getDpUnit() * 48.0f);
        this.al = 0;
        this.am = dpUnit;
        an(false);
        this.z.setAnimationStyle(R.style.text_action_popup_animation);
        final int i = 0;
        awyVar.k(dfn.class, new aww(this) { // from class: me.hd.wauxv.obf.asq
            public final /* synthetic */ ass b;

            {
                this.b = this;
            }

            @Override // me.hd.wauxv.obf.aww
            public final void e(ua uaVar) {
                boolean z;
                switch (i) {
                    case 0:
                        dfn dfnVar = (dfn) uaVar;
                        ass assVar = this.b;
                        CodeEditor codeEditor2 = assVar.a;
                        asv asvVar = assVar.h;
                        if (!asvVar.ay()) {
                            int i2 = dfnVar.m;
                            ud udVar = dfnVar.a;
                            if (i2 != 9) {
                                if (!asvVar.aj) {
                                    assVar.m = i2;
                                    if (dfnVar.n() || (i2 == 5 && codeEditor2.getText().d == 0)) {
                                        if (i2 != 6) {
                                            codeEditor2.ei(new dh(assVar, 11));
                                        } else {
                                            assVar.i();
                                        }
                                        assVar.l = -1;
                                    } else {
                                        if (i2 == 3 && udVar.a == assVar.l && !assVar.z.isShowing()
                                                && codeEditor2.getText().e <= 0 && codeEditor2.dw()) {
                                            codeEditor2.ei(new dh(assVar, 11));
                                            z = true;
                                        } else {
                                            assVar.i();
                                            z = false;
                                        }
                                        if (i2 == 3 && !z) {
                                            assVar.l = udVar.a;
                                        } else {
                                            assVar.l = -1;
                                        }
                                    }
                                } else {
                                    assVar.i();
                                }
                                break;
                            }
                        }
                        break;
                    case 1:
                        ass assVar2 = this.b;
                        long j = assVar2.k;
                        long jCurrentTimeMillis = System.currentTimeMillis();
                        assVar2.k = jCurrentTimeMillis;
                        if (jCurrentTimeMillis - j < 200 && assVar2.m != 6) {
                            assVar2.r();
                            break;
                        }
                        break;
                    case 2:
                        bjy bjyVar = (bjy) uaVar;
                        boolean z2 = bjyVar.l;
                        ass assVar3 = this.b;
                        if (z2) {
                            assVar3.r();
                        }
                        if (!((CodeEditor) bjyVar.c).getCursor().h() && bjyVar.a == 0 && !bjyVar.l) {
                            assVar3.getAllSwitchHookInstances();
                            assVar3.a.eh(new asr(assVar3, 0), 100L);
                            break;
                        }
                        break;
                    case 3:
                        bxy bxyVar = (bxy) uaVar;
                        ass assVar4 = this.b;
                        CodeEditor codeEditor3 = assVar4.a;
                        if (codeEditor3.getCursor().h() && assVar4.m == 6) {
                            int i3 = bxyVar.a.a;
                            if (i3 >= codeEditor3.getCursor().c.a && i3 <= codeEditor3.getCursor().d.a) {
                                assVar4.m = 0;
                                assVar4.getAllSwitchHookInstances();
                            }
                            bxyVar.b = 2;
                            break;
                        }
                        break;
                    case 4:
                        ass assVar5 = this.b;
                        assVar5.getClass();
                        if (!((arx) uaVar).a) {
                            assVar5.i();
                        }
                        break;
                    case 5:
                        ass assVar6 = this.b;
                        assVar6.n = false;
                        assVar6.j.j(false);
                        assVar6.i();
                        break;
                    case 6:
                        this.b.p();
                        break;
                    default:
                        this.b.getAllSwitchHookInstances();
                        break;
                }
            }
        });
        final int i2 = 1;
        awyVar.k(dfb.class, new aww(this) { // from class: me.hd.wauxv.obf.asq
            public final /* synthetic */ ass b;

            {
                this.b = this;
            }

            @Override // me.hd.wauxv.obf.aww
            public final void e(ua uaVar) {
                boolean z;
                switch (i2) {
                    case 0:
                        dfn dfnVar = (dfn) uaVar;
                        ass assVar = this.b;
                        CodeEditor codeEditor2 = assVar.a;
                        asv asvVar = assVar.h;
                        if (!asvVar.ay()) {
                            int i22 = dfnVar.m;
                            ud udVar = dfnVar.a;
                            if (i22 != 9) {
                                if (!asvVar.aj) {
                                    assVar.m = i22;
                                    if (dfnVar.n() || (i22 == 5 && codeEditor2.getText().d == 0)) {
                                        if (i22 != 6) {
                                            codeEditor2.ei(new dh(assVar, 11));
                                        } else {
                                            assVar.i();
                                        }
                                        assVar.l = -1;
                                    } else {
                                        if (i22 == 3 && udVar.a == assVar.l && !assVar.z.isShowing()
                                                && codeEditor2.getText().e <= 0 && codeEditor2.dw()) {
                                            codeEditor2.ei(new dh(assVar, 11));
                                            z = true;
                                        } else {
                                            assVar.i();
                                            z = false;
                                        }
                                        if (i22 == 3 && !z) {
                                            assVar.l = udVar.a;
                                        } else {
                                            assVar.l = -1;
                                        }
                                    }
                                } else {
                                    assVar.i();
                                }
                                break;
                            }
                        }
                        break;
                    case 1:
                        ass assVar2 = this.b;
                        long j = assVar2.k;
                        long jCurrentTimeMillis = System.currentTimeMillis();
                        assVar2.k = jCurrentTimeMillis;
                        if (jCurrentTimeMillis - j < 200 && assVar2.m != 6) {
                            assVar2.r();
                            break;
                        }
                        break;
                    case 2:
                        bjy bjyVar = (bjy) uaVar;
                        boolean z2 = bjyVar.l;
                        ass assVar3 = this.b;
                        if (z2) {
                            assVar3.r();
                        }
                        if (!((CodeEditor) bjyVar.c).getCursor().h() && bjyVar.a == 0 && !bjyVar.l) {
                            assVar3.getAllSwitchHookInstances();
                            assVar3.a.eh(new asr(assVar3, 0), 100L);
                            break;
                        }
                        break;
                    case 3:
                        bxy bxyVar = (bxy) uaVar;
                        ass assVar4 = this.b;
                        CodeEditor codeEditor3 = assVar4.a;
                        if (codeEditor3.getCursor().h() && assVar4.m == 6) {
                            int i3 = bxyVar.a.a;
                            if (i3 >= codeEditor3.getCursor().c.a && i3 <= codeEditor3.getCursor().d.a) {
                                assVar4.m = 0;
                                assVar4.getAllSwitchHookInstances();
                            }
                            bxyVar.b = 2;
                            break;
                        }
                        break;
                    case 4:
                        ass assVar5 = this.b;
                        assVar5.getClass();
                        if (!((arx) uaVar).a) {
                            assVar5.i();
                        }
                        break;
                    case 5:
                        ass assVar6 = this.b;
                        assVar6.n = false;
                        assVar6.j.j(false);
                        assVar6.i();
                        break;
                    case 6:
                        this.b.p();
                        break;
                    default:
                        this.b.getAllSwitchHookInstances();
                        break;
                }
            }
        });
        final int i3 = 2;
        awyVar.k(bjy.class, new aww(this) { // from class: me.hd.wauxv.obf.asq
            public final /* synthetic */ ass b;

            {
                this.b = this;
            }

            @Override // me.hd.wauxv.obf.aww
            public final void e(ua uaVar) {
                boolean z;
                switch (i3) {
                    case 0:
                        dfn dfnVar = (dfn) uaVar;
                        ass assVar = this.b;
                        CodeEditor codeEditor2 = assVar.a;
                        asv asvVar = assVar.h;
                        if (!asvVar.ay()) {
                            int i22 = dfnVar.m;
                            ud udVar = dfnVar.a;
                            if (i22 != 9) {
                                if (!asvVar.aj) {
                                    assVar.m = i22;
                                    if (dfnVar.n() || (i22 == 5 && codeEditor2.getText().d == 0)) {
                                        if (i22 != 6) {
                                            codeEditor2.ei(new dh(assVar, 11));
                                        } else {
                                            assVar.i();
                                        }
                                        assVar.l = -1;
                                    } else {
                                        if (i22 == 3 && udVar.a == assVar.l && !assVar.z.isShowing()
                                                && codeEditor2.getText().e <= 0 && codeEditor2.dw()) {
                                            codeEditor2.ei(new dh(assVar, 11));
                                            z = true;
                                        } else {
                                            assVar.i();
                                            z = false;
                                        }
                                        if (i22 == 3 && !z) {
                                            assVar.l = udVar.a;
                                        } else {
                                            assVar.l = -1;
                                        }
                                    }
                                } else {
                                    assVar.i();
                                }
                                break;
                            }
                        }
                        break;
                    case 1:
                        ass assVar2 = this.b;
                        long j = assVar2.k;
                        long jCurrentTimeMillis = System.currentTimeMillis();
                        assVar2.k = jCurrentTimeMillis;
                        if (jCurrentTimeMillis - j < 200 && assVar2.m != 6) {
                            assVar2.r();
                            break;
                        }
                        break;
                    case 2:
                        bjy bjyVar = (bjy) uaVar;
                        boolean z2 = bjyVar.l;
                        ass assVar3 = this.b;
                        if (z2) {
                            assVar3.r();
                        }
                        if (!((CodeEditor) bjyVar.c).getCursor().h() && bjyVar.a == 0 && !bjyVar.l) {
                            assVar3.getAllSwitchHookInstances();
                            assVar3.a.eh(new asr(assVar3, 0), 100L);
                            break;
                        }
                        break;
                    case 3:
                        bxy bxyVar = (bxy) uaVar;
                        ass assVar4 = this.b;
                        CodeEditor codeEditor3 = assVar4.a;
                        if (codeEditor3.getCursor().h() && assVar4.m == 6) {
                            int i32 = bxyVar.a.a;
                            if (i32 >= codeEditor3.getCursor().c.a && i32 <= codeEditor3.getCursor().d.a) {
                                assVar4.m = 0;
                                assVar4.getAllSwitchHookInstances();
                            }
                            bxyVar.b = 2;
                            break;
                        }
                        break;
                    case 4:
                        ass assVar5 = this.b;
                        assVar5.getClass();
                        if (!((arx) uaVar).a) {
                            assVar5.i();
                        }
                        break;
                    case 5:
                        ass assVar6 = this.b;
                        assVar6.n = false;
                        assVar6.j.j(false);
                        assVar6.i();
                        break;
                    case 6:
                        this.b.p();
                        break;
                    default:
                        this.b.getAllSwitchHookInstances();
                        break;
                }
            }
        });
        final int i4 = 3;
        awyVar.k(bxy.class, new aww(this) { // from class: me.hd.wauxv.obf.asq
            public final /* synthetic */ ass b;

            {
                this.b = this;
            }

            @Override // me.hd.wauxv.obf.aww
            public final void e(ua uaVar) {
                boolean z;
                switch (i4) {
                    case 0:
                        dfn dfnVar = (dfn) uaVar;
                        ass assVar = this.b;
                        CodeEditor codeEditor2 = assVar.a;
                        asv asvVar = assVar.h;
                        if (!asvVar.ay()) {
                            int i22 = dfnVar.m;
                            ud udVar = dfnVar.a;
                            if (i22 != 9) {
                                if (!asvVar.aj) {
                                    assVar.m = i22;
                                    if (dfnVar.n() || (i22 == 5 && codeEditor2.getText().d == 0)) {
                                        if (i22 != 6) {
                                            codeEditor2.ei(new dh(assVar, 11));
                                        } else {
                                            assVar.i();
                                        }
                                        assVar.l = -1;
                                    } else {
                                        if (i22 == 3 && udVar.a == assVar.l && !assVar.z.isShowing()
                                                && codeEditor2.getText().e <= 0 && codeEditor2.dw()) {
                                            codeEditor2.ei(new dh(assVar, 11));
                                            z = true;
                                        } else {
                                            assVar.i();
                                            z = false;
                                        }
                                        if (i22 == 3 && !z) {
                                            assVar.l = udVar.a;
                                        } else {
                                            assVar.l = -1;
                                        }
                                    }
                                } else {
                                    assVar.i();
                                }
                                break;
                            }
                        }
                        break;
                    case 1:
                        ass assVar2 = this.b;
                        long j = assVar2.k;
                        long jCurrentTimeMillis = System.currentTimeMillis();
                        assVar2.k = jCurrentTimeMillis;
                        if (jCurrentTimeMillis - j < 200 && assVar2.m != 6) {
                            assVar2.r();
                            break;
                        }
                        break;
                    case 2:
                        bjy bjyVar = (bjy) uaVar;
                        boolean z2 = bjyVar.l;
                        ass assVar3 = this.b;
                        if (z2) {
                            assVar3.r();
                        }
                        if (!((CodeEditor) bjyVar.c).getCursor().h() && bjyVar.a == 0 && !bjyVar.l) {
                            assVar3.getAllSwitchHookInstances();
                            assVar3.a.eh(new asr(assVar3, 0), 100L);
                            break;
                        }
                        break;
                    case 3:
                        bxy bxyVar = (bxy) uaVar;
                        ass assVar4 = this.b;
                        CodeEditor codeEditor3 = assVar4.a;
                        if (codeEditor3.getCursor().h() && assVar4.m == 6) {
                            int i32 = bxyVar.a.a;
                            if (i32 >= codeEditor3.getCursor().c.a && i32 <= codeEditor3.getCursor().d.a) {
                                assVar4.m = 0;
                                assVar4.getAllSwitchHookInstances();
                            }
                            bxyVar.b = 2;
                            break;
                        }
                        break;
                    case 4:
                        ass assVar5 = this.b;
                        assVar5.getClass();
                        if (!((arx) uaVar).a) {
                            assVar5.i();
                        }
                        break;
                    case 5:
                        ass assVar6 = this.b;
                        assVar6.n = false;
                        assVar6.j.j(false);
                        assVar6.i();
                        break;
                    case 6:
                        this.b.p();
                        break;
                    default:
                        this.b.getAllSwitchHookInstances();
                        break;
                }
            }
        });
        final int i5 = 4;
        awyVar.k(arx.class, new aww(this) { // from class: me.hd.wauxv.obf.asq
            public final /* synthetic */ ass b;

            {
                this.b = this;
            }

            @Override // me.hd.wauxv.obf.aww
            public final void e(ua uaVar) {
                boolean z;
                switch (i5) {
                    case 0:
                        dfn dfnVar = (dfn) uaVar;
                        ass assVar = this.b;
                        CodeEditor codeEditor2 = assVar.a;
                        asv asvVar = assVar.h;
                        if (!asvVar.ay()) {
                            int i22 = dfnVar.m;
                            ud udVar = dfnVar.a;
                            if (i22 != 9) {
                                if (!asvVar.aj) {
                                    assVar.m = i22;
                                    if (dfnVar.n() || (i22 == 5 && codeEditor2.getText().d == 0)) {
                                        if (i22 != 6) {
                                            codeEditor2.ei(new dh(assVar, 11));
                                        } else {
                                            assVar.i();
                                        }
                                        assVar.l = -1;
                                    } else {
                                        if (i22 == 3 && udVar.a == assVar.l && !assVar.z.isShowing()
                                                && codeEditor2.getText().e <= 0 && codeEditor2.dw()) {
                                            codeEditor2.ei(new dh(assVar, 11));
                                            z = true;
                                        } else {
                                            assVar.i();
                                            z = false;
                                        }
                                        if (i22 == 3 && !z) {
                                            assVar.l = udVar.a;
                                        } else {
                                            assVar.l = -1;
                                        }
                                    }
                                } else {
                                    assVar.i();
                                }
                                break;
                            }
                        }
                        break;
                    case 1:
                        ass assVar2 = this.b;
                        long j = assVar2.k;
                        long jCurrentTimeMillis = System.currentTimeMillis();
                        assVar2.k = jCurrentTimeMillis;
                        if (jCurrentTimeMillis - j < 200 && assVar2.m != 6) {
                            assVar2.r();
                            break;
                        }
                        break;
                    case 2:
                        bjy bjyVar = (bjy) uaVar;
                        boolean z2 = bjyVar.l;
                        ass assVar3 = this.b;
                        if (z2) {
                            assVar3.r();
                        }
                        if (!((CodeEditor) bjyVar.c).getCursor().h() && bjyVar.a == 0 && !bjyVar.l) {
                            assVar3.getAllSwitchHookInstances();
                            assVar3.a.eh(new asr(assVar3, 0), 100L);
                            break;
                        }
                        break;
                    case 3:
                        bxy bxyVar = (bxy) uaVar;
                        ass assVar4 = this.b;
                        CodeEditor codeEditor3 = assVar4.a;
                        if (codeEditor3.getCursor().h() && assVar4.m == 6) {
                            int i32 = bxyVar.a.a;
                            if (i32 >= codeEditor3.getCursor().c.a && i32 <= codeEditor3.getCursor().d.a) {
                                assVar4.m = 0;
                                assVar4.getAllSwitchHookInstances();
                            }
                            bxyVar.b = 2;
                            break;
                        }
                        break;
                    case 4:
                        ass assVar5 = this.b;
                        assVar5.getClass();
                        if (!((arx) uaVar).a) {
                            assVar5.i();
                        }
                        break;
                    case 5:
                        ass assVar6 = this.b;
                        assVar6.n = false;
                        assVar6.j.j(false);
                        assVar6.i();
                        break;
                    case 6:
                        this.b.p();
                        break;
                    default:
                        this.b.getAllSwitchHookInstances();
                        break;
                }
            }
        });
        final int i6 = 5;
        awyVar.k(asf.class, new aww(this) { // from class: me.hd.wauxv.obf.asq
            public final /* synthetic */ ass b;

            {
                this.b = this;
            }

            @Override // me.hd.wauxv.obf.aww
            public final void e(ua uaVar) {
                boolean z;
                switch (i6) {
                    case 0:
                        dfn dfnVar = (dfn) uaVar;
                        ass assVar = this.b;
                        CodeEditor codeEditor2 = assVar.a;
                        asv asvVar = assVar.h;
                        if (!asvVar.ay()) {
                            int i22 = dfnVar.m;
                            ud udVar = dfnVar.a;
                            if (i22 != 9) {
                                if (!asvVar.aj) {
                                    assVar.m = i22;
                                    if (dfnVar.n() || (i22 == 5 && codeEditor2.getText().d == 0)) {
                                        if (i22 != 6) {
                                            codeEditor2.ei(new dh(assVar, 11));
                                        } else {
                                            assVar.i();
                                        }
                                        assVar.l = -1;
                                    } else {
                                        if (i22 == 3 && udVar.a == assVar.l && !assVar.z.isShowing()
                                                && codeEditor2.getText().e <= 0 && codeEditor2.dw()) {
                                            codeEditor2.ei(new dh(assVar, 11));
                                            z = true;
                                        } else {
                                            assVar.i();
                                            z = false;
                                        }
                                        if (i22 == 3 && !z) {
                                            assVar.l = udVar.a;
                                        } else {
                                            assVar.l = -1;
                                        }
                                    }
                                } else {
                                    assVar.i();
                                }
                                break;
                            }
                        }
                        break;
                    case 1:
                        ass assVar2 = this.b;
                        long j = assVar2.k;
                        long jCurrentTimeMillis = System.currentTimeMillis();
                        assVar2.k = jCurrentTimeMillis;
                        if (jCurrentTimeMillis - j < 200 && assVar2.m != 6) {
                            assVar2.r();
                            break;
                        }
                        break;
                    case 2:
                        bjy bjyVar = (bjy) uaVar;
                        boolean z2 = bjyVar.l;
                        ass assVar3 = this.b;
                        if (z2) {
                            assVar3.r();
                        }
                        if (!((CodeEditor) bjyVar.c).getCursor().h() && bjyVar.a == 0 && !bjyVar.l) {
                            assVar3.getAllSwitchHookInstances();
                            assVar3.a.eh(new asr(assVar3, 0), 100L);
                            break;
                        }
                        break;
                    case 3:
                        bxy bxyVar = (bxy) uaVar;
                        ass assVar4 = this.b;
                        CodeEditor codeEditor3 = assVar4.a;
                        if (codeEditor3.getCursor().h() && assVar4.m == 6) {
                            int i32 = bxyVar.a.a;
                            if (i32 >= codeEditor3.getCursor().c.a && i32 <= codeEditor3.getCursor().d.a) {
                                assVar4.m = 0;
                                assVar4.getAllSwitchHookInstances();
                            }
                            bxyVar.b = 2;
                            break;
                        }
                        break;
                    case 4:
                        ass assVar5 = this.b;
                        assVar5.getClass();
                        if (!((arx) uaVar).a) {
                            assVar5.i();
                        }
                        break;
                    case 5:
                        ass assVar6 = this.b;
                        assVar6.n = false;
                        assVar6.j.j(false);
                        assVar6.i();
                        break;
                    case 6:
                        this.b.p();
                        break;
                    default:
                        this.b.getAllSwitchHookInstances();
                        break;
                }
            }
        });
        final int i7 = 6;
        awyVar.k(abg.class, new aww(this) { // from class: me.hd.wauxv.obf.asq
            public final /* synthetic */ ass b;

            {
                this.b = this;
            }

            @Override // me.hd.wauxv.obf.aww
            public final void e(ua uaVar) {
                boolean z;
                switch (i7) {
                    case 0:
                        dfn dfnVar = (dfn) uaVar;
                        ass assVar = this.b;
                        CodeEditor codeEditor2 = assVar.a;
                        asv asvVar = assVar.h;
                        if (!asvVar.ay()) {
                            int i22 = dfnVar.m;
                            ud udVar = dfnVar.a;
                            if (i22 != 9) {
                                if (!asvVar.aj) {
                                    assVar.m = i22;
                                    if (dfnVar.n() || (i22 == 5 && codeEditor2.getText().d == 0)) {
                                        if (i22 != 6) {
                                            codeEditor2.ei(new dh(assVar, 11));
                                        } else {
                                            assVar.i();
                                        }
                                        assVar.l = -1;
                                    } else {
                                        if (i22 == 3 && udVar.a == assVar.l && !assVar.z.isShowing()
                                                && codeEditor2.getText().e <= 0 && codeEditor2.dw()) {
                                            codeEditor2.ei(new dh(assVar, 11));
                                            z = true;
                                        } else {
                                            assVar.i();
                                            z = false;
                                        }
                                        if (i22 == 3 && !z) {
                                            assVar.l = udVar.a;
                                        } else {
                                            assVar.l = -1;
                                        }
                                    }
                                } else {
                                    assVar.i();
                                }
                                break;
                            }
                        }
                        break;
                    case 1:
                        ass assVar2 = this.b;
                        long j = assVar2.k;
                        long jCurrentTimeMillis = System.currentTimeMillis();
                        assVar2.k = jCurrentTimeMillis;
                        if (jCurrentTimeMillis - j < 200 && assVar2.m != 6) {
                            assVar2.r();
                            break;
                        }
                        break;
                    case 2:
                        bjy bjyVar = (bjy) uaVar;
                        boolean z2 = bjyVar.l;
                        ass assVar3 = this.b;
                        if (z2) {
                            assVar3.r();
                        }
                        if (!((CodeEditor) bjyVar.c).getCursor().h() && bjyVar.a == 0 && !bjyVar.l) {
                            assVar3.getAllSwitchHookInstances();
                            assVar3.a.eh(new asr(assVar3, 0), 100L);
                            break;
                        }
                        break;
                    case 3:
                        bxy bxyVar = (bxy) uaVar;
                        ass assVar4 = this.b;
                        CodeEditor codeEditor3 = assVar4.a;
                        if (codeEditor3.getCursor().h() && assVar4.m == 6) {
                            int i32 = bxyVar.a.a;
                            if (i32 >= codeEditor3.getCursor().c.a && i32 <= codeEditor3.getCursor().d.a) {
                                assVar4.m = 0;
                                assVar4.getAllSwitchHookInstances();
                            }
                            bxyVar.b = 2;
                            break;
                        }
                        break;
                    case 4:
                        ass assVar5 = this.b;
                        assVar5.getClass();
                        if (!((arx) uaVar).a) {
                            assVar5.i();
                        }
                        break;
                    case 5:
                        ass assVar6 = this.b;
                        assVar6.n = false;
                        assVar6.j.j(false);
                        assVar6.i();
                        break;
                    case 6:
                        this.b.p();
                        break;
                    default:
                        this.b.getAllSwitchHookInstances();
                        break;
                }
            }
        });
        final int i8 = 7;
        awyVar.k(apr.class, new aww(this) { // from class: me.hd.wauxv.obf.asq
            public final /* synthetic */ ass b;

            {
                this.b = this;
            }

            @Override // me.hd.wauxv.obf.aww
            public final void e(ua uaVar) {
                boolean z;
                switch (i8) {
                    case 0:
                        dfn dfnVar = (dfn) uaVar;
                        ass assVar = this.b;
                        CodeEditor codeEditor2 = assVar.a;
                        asv asvVar = assVar.h;
                        if (!asvVar.ay()) {
                            int i22 = dfnVar.m;
                            ud udVar = dfnVar.a;
                            if (i22 != 9) {
                                if (!asvVar.aj) {
                                    assVar.m = i22;
                                    if (dfnVar.n() || (i22 == 5 && codeEditor2.getText().d == 0)) {
                                        if (i22 != 6) {
                                            codeEditor2.ei(new dh(assVar, 11));
                                        } else {
                                            assVar.i();
                                        }
                                        assVar.l = -1;
                                    } else {
                                        if (i22 == 3 && udVar.a == assVar.l && !assVar.z.isShowing()
                                                && codeEditor2.getText().e <= 0 && codeEditor2.dw()) {
                                            codeEditor2.ei(new dh(assVar, 11));
                                            z = true;
                                        } else {
                                            assVar.i();
                                            z = false;
                                        }
                                        if (i22 == 3 && !z) {
                                            assVar.l = udVar.a;
                                        } else {
                                            assVar.l = -1;
                                        }
                                    }
                                } else {
                                    assVar.i();
                                }
                                break;
                            }
                        }
                        break;
                    case 1:
                        ass assVar2 = this.b;
                        long j = assVar2.k;
                        long jCurrentTimeMillis = System.currentTimeMillis();
                        assVar2.k = jCurrentTimeMillis;
                        if (jCurrentTimeMillis - j < 200 && assVar2.m != 6) {
                            assVar2.r();
                            break;
                        }
                        break;
                    case 2:
                        bjy bjyVar = (bjy) uaVar;
                        boolean z2 = bjyVar.l;
                        ass assVar3 = this.b;
                        if (z2) {
                            assVar3.r();
                        }
                        if (!((CodeEditor) bjyVar.c).getCursor().h() && bjyVar.a == 0 && !bjyVar.l) {
                            assVar3.getAllSwitchHookInstances();
                            assVar3.a.eh(new asr(assVar3, 0), 100L);
                            break;
                        }
                        break;
                    case 3:
                        bxy bxyVar = (bxy) uaVar;
                        ass assVar4 = this.b;
                        CodeEditor codeEditor3 = assVar4.a;
                        if (codeEditor3.getCursor().h() && assVar4.m == 6) {
                            int i32 = bxyVar.a.a;
                            if (i32 >= codeEditor3.getCursor().c.a && i32 <= codeEditor3.getCursor().d.a) {
                                assVar4.m = 0;
                                assVar4.getAllSwitchHookInstances();
                            }
                            bxyVar.b = 2;
                            break;
                        }
                        break;
                    case 4:
                        ass assVar5 = this.b;
                        assVar5.getClass();
                        if (!((arx) uaVar).a) {
                            assVar5.i();
                        }
                        break;
                    case 5:
                        ass assVar6 = this.b;
                        assVar6.n = false;
                        assVar6.j.j(false);
                        assVar6.i();
                        break;
                    case 6:
                        this.b.p();
                        break;
                    default:
                        this.b.getAllSwitchHookInstances();
                        break;
                }
            }
        });
    }

    public static void o(ImageButton imageButton, int i) {
        if (imageButton.getDrawable() == null) {
            return;
        }
        imageButton.setColorFilter(new PorterDuffColorFilter(i, PorterDuff.Mode.SRC_ATOP));
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        int id = view.getId();
        CodeEditor codeEditor = this.a;
        if (id == R.id.panel_btn_select_all) {
            codeEditor.em();
            return;
        }
        if (id == R.id.panel_btn_cut) {
            if (codeEditor.getCursor().h()) {
                codeEditor.di();
            }
        } else if (id == R.id.panel_btn_paste) {
            codeEditor.eg();
            codeEditor.ep(codeEditor.getCursor().d.b, codeEditor.getCursor().d.c);
        } else if (id == R.id.panel_btn_copy) {
            codeEditor.df(true);
            codeEditor.ep(codeEditor.getCursor().d.b, codeEditor.getCursor().d.c);
        } else if (id == R.id.panel_btn_long_select && codeEditor.dw()) {
            if (codeEditor.bo.h()) {
                ud udVar = codeEditor.bo.c;
                codeEditor.ep(udVar.b, udVar.c);
            }
            codeEditor.be = true;
            codeEditor.invalidate();
        }
        i();
    }

    public final void p() {
        GradientDrawable gradientDrawable = new GradientDrawable();
        CodeEditor codeEditor = this.a;
        gradientDrawable.setCornerRadius(codeEditor.getDpUnit() * 5.0f);
        gradientDrawable.setColor(codeEditor.getColorScheme().b.get(65));
        this.g.setBackground(gradientDrawable);
        int i = codeEditor.getColorScheme().b.get(66);
        o(this.b, i);
        o(this.e, i);
        o(this.d, i);
        o(this.c, i);
        o(this.f, i);
    }

    public final void q() {
        CodeEditor codeEditor = this.a;
        boolean zHasPrimaryClip = codeEditor.bm.hasPrimaryClip();
        ImageButton imageButton = this.c;
        imageButton.setEnabled(zHasPrimaryClip);
        int i = 8;
        this.d.setVisibility(codeEditor.getCursor().h() ? 0 : 8);
        imageButton.setVisibility(codeEditor.dw() ? 0 : 8);
        this.e.setVisibility((codeEditor.getCursor().h() && codeEditor.dw()) ? 0 : 8);
        if (!codeEditor.getCursor().h() && codeEditor.dw()) {
            i = 0;
        }
        this.f.setVisibility(i);
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(1000000, Integer.MIN_VALUE);
        int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(100000, Integer.MIN_VALUE);
        View view = this.g;
        view.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
        int iMin = Math.min(view.getMeasuredWidth(), (int) (codeEditor.getDpUnit() * 230.0f));
        int i2 = this.am;
        this.al = iMin;
        this.am = i2;
        an(false);
        int iMax = Math.max(0,
                Math.min(codeEditor.getCursor().h()
                        ? Math.min(s(codeEditor.getLeftHandleDescriptor().a),
                                s(codeEditor.getRightHandleDescriptor().a))
                        : s(codeEditor.getInsertHandleDescriptor().a), (codeEditor.getHeight() - this.am) - 5));
        int iEb = (int) (((((codeEditor.eb()
                + codeEditor.j.r(codeEditor.getCursor().d.b, codeEditor.getCursor().d.c)[1]) - codeEditor.getOffsetX())
                + ((codeEditor.eb() + codeEditor.j.r(codeEditor.getCursor().c.b, codeEditor.getCursor().c.c)[1])
                        - codeEditor.getOffsetX()))
                / 2.0f) - (view.getMeasuredWidth() / 2.0f));
        CodeEditor codeEditor2 = this.aa;
        int offsetX = codeEditor2.getOffsetX() + iEb;
        int offsetY = codeEditor2.getOffsetY() + iMax;
        this.aj = offsetX;
        this.ak = offsetY;
        this.ai = codeEditor2.getOffsetY();
        this.ah = codeEditor2.getOffsetX();
        an(false);
        if (!this.n || codeEditor.getSnippetController().l() || !codeEditor.hasFocus() || codeEditor.dy()
                || this.z.isShowing()) {
            return;
        }
        an(true);
    }

    public final void r() {
        if (this.z.isShowing()) {
            i();
            CodeEditor codeEditor = this.a;
            if (codeEditor.getCursor().h()) {
                codeEditor.eh(new asr(this, 1), 200L);
            }
        }
    }

    public final int s(RectF rectF) {
        int rowHeight = this.a.getRowHeight();
        float f = rectF.top;
        float f2 = f - ((rowHeight * 3) / 2.0f);
        int i = this.am;
        return f2 > ((float) i) ? (int) ((f - (r2 / 2)) - i) : (int) (rectF.bottom + (rowHeight / 2));
    }
}

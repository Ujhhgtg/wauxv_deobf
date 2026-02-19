package me.hd.wauxv.obf;

import android.R;
import android.animation.Animator;
import android.animation.AnimatorSet;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Color;
import android.graphics.ImageDecoder;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.method.KeyListener;
import android.text.method.NumberKeyListener;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.util.Xml;
import android.view.ActionMode;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.AbsSeekBar;
import android.widget.EditText;
import android.widget.FrameLayout;
import io.github.rosemoe.sora.widget.CodeEditor;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.WeakHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public class DefaultConfig implements dln, dcm, EmojiMatchCallback, ccv {
    public static final int[] a = { R.attr.indeterminateDrawable, R.attr.progressDrawable };
    public final /* synthetic */ int b;
    public Object c;
    public Object d;

    public /* synthetic */ DefaultConfig(int i, boolean z) {
        this.b = i;
    }

    public static ez e(ImageDecoder.Source source, int i, int i2, crw crwVar) throws IOException {
        Drawable drawableDecodeDrawable = ImageDecoder.decodeDrawable(source, new alb(i, i2, crwVar));
        if (as.w(drawableDecodeDrawable)) {
            return new ez(as.g(drawableDecodeDrawable), 0);
        }
        throw new IOException(
                "Received unexpected drawable type for animated image, failing: " + drawableDecodeDrawable);
    }

    public static void f(DefaultConfig ioVar, eqh eqhVar, int i) {
        String strZ = "取消" /* "取消" /* "取消" /* "取消" /* cnb.z(-47455093652266L)   */;
        bfu amdVar = eqhVar;
        if ((i & 2) != 0) {
            amdVar = new amd(1);
        }
        bzy bzyVar = (bzy) ioVar.c;
        if (bzyVar != null) {
            bzyVar.r(strZ, new amw(amdVar, 1));
        }
    }

    public static void g(DefaultConfig ioVar, cfx cfxVar, int i) {
        String strZ = "确定" /* "确定" /* "确定" /* "确定" /* cnb.z(-47519518161706L)   */;
        bfu amdVar = cfxVar;
        if ((i & 2) != 0) {
            amdVar = new amd(1);
        }
        bzy bzyVar = (bzy) ioVar.c;
        if (bzyVar != null) {
            bzyVar.t(strZ, new amw(amdVar, 0));
        }
    }

    public static boolean h(CodeEditor codeEditor, ahy ahyVar, aff affVar, asb asbVar, btk btkVar) {
        int i = ahyVar.d.d().b;
        codeEditor.ep(i, affVar.y(i).b);
        codeEditor.de(codeEditor.getLineSeparator().f, true);
        codeEditor.dn();
        return btkVar.p(true) || asbVar.p(true);
    }

    public void aa(SomeFragmentManager someFragmentManagerVar, boolean z) {
        throwIfVar1IsNull(someFragmentManagerVar, "f");
        SomeFragmentManager someFragmentManagerVar2 = ((beg) this.c).y;
        if (someFragmentManagerVar2 != null) {
            someFragmentManagerVar2.cs().o.aa(someFragmentManagerVar, true);
        }
        for (bdt bdtVar : (CopyOnWriteArrayList) this.d) {
            if (z) {
                bdtVar.getClass();
            } else {
                DefaultConfig ioVar = bdtVar.a;
            }
        }
    }

    public void ab(SomeFragmentManager someFragmentManagerVar, Bundle bundle, boolean z) {
        throwIfVar1IsNull(someFragmentManagerVar, "f");
        SomeFragmentManager someFragmentManagerVar2 = ((beg) this.c).y;
        if (someFragmentManagerVar2 != null) {
            someFragmentManagerVar2.cs().o.ab(someFragmentManagerVar, bundle, true);
        }
        for (bdt bdtVar : (CopyOnWriteArrayList) this.d) {
            if (z) {
                bdtVar.getClass();
            } else {
                DefaultConfig ioVar = bdtVar.a;
            }
        }
    }

    public void ac(SomeFragmentManager someFragmentManagerVar, boolean z) {
        throwIfVar1IsNull(someFragmentManagerVar, "f");
        SomeFragmentManager someFragmentManagerVar2 = ((beg) this.c).y;
        if (someFragmentManagerVar2 != null) {
            someFragmentManagerVar2.cs().o.ac(someFragmentManagerVar, true);
        }
        for (bdt bdtVar : (CopyOnWriteArrayList) this.d) {
            if (z) {
                bdtVar.getClass();
            } else {
                DefaultConfig ioVar = bdtVar.a;
            }
        }
    }

    public void ad(SomeFragmentManager someFragmentManagerVar, boolean z) {
        throwIfVar1IsNull(someFragmentManagerVar, "f");
        SomeFragmentManager someFragmentManagerVar2 = ((beg) this.c).y;
        if (someFragmentManagerVar2 != null) {
            someFragmentManagerVar2.cs().o.ad(someFragmentManagerVar, true);
        }
        for (bdt bdtVar : (CopyOnWriteArrayList) this.d) {
            if (z) {
                bdtVar.getClass();
            } else {
                DefaultConfig ioVar = bdtVar.a;
            }
        }
    }

    public void ae(SomeFragmentManager someFragmentManagerVar, View view, boolean z) {
        throwIfVar1IsNull(someFragmentManagerVar, "f");
        throwIfVar1IsNull(view, "v");
        SomeFragmentManager someFragmentManagerVar2 = ((beg) this.c).y;
        if (someFragmentManagerVar2 != null) {
            someFragmentManagerVar2.cs().o.ae(someFragmentManagerVar, view, true);
        }
        for (bdt bdtVar : (CopyOnWriteArrayList) this.d) {
            if (z) {
                bdtVar.getClass();
            } else {
                DefaultConfig ioVar = bdtVar.a;
                beg begVar = (beg) this.c;
                if (someFragmentManagerVar == ((SomeFragmentManager) ioVar.c)) {
                    DefaultConfig ioVar2 = begVar.o;
                    ioVar2.getClass();
                    synchronized (((CopyOnWriteArrayList) ioVar2.d)) {
                        int size = ((CopyOnWriteArrayList) ioVar2.d).size();
                        for (int i = 0; i < size; i++) {
                            if (((bdt) ((CopyOnWriteArrayList) ioVar2.d).get(i)).a == ioVar) {
                                ((CopyOnWriteArrayList) ioVar2.d).remove(i);
                                break;
                            }
                        }
                    }
                    byu.u(view, (FrameLayout) ioVar.d);
                } else {
                    continue;
                }
            }
        }
    }

    public void af(SomeFragmentManager someFragmentManagerVar, boolean z) {
        throwIfVar1IsNull(someFragmentManagerVar, "f");
        SomeFragmentManager someFragmentManagerVar2 = ((beg) this.c).y;
        if (someFragmentManagerVar2 != null) {
            someFragmentManagerVar2.cs().o.af(someFragmentManagerVar, true);
        }
        for (bdt bdtVar : (CopyOnWriteArrayList) this.d) {
            if (z) {
                bdtVar.getClass();
            } else {
                DefaultConfig ioVar = bdtVar.a;
            }
        }
    }

    public Object ag(cut cutVar) {
        HashMap map = (HashMap) this.d;
        bjn bjnVar = (bjn) map.get(cutVar);
        if (bjnVar == null) {
            bjnVar = new bjn(cutVar);
            map.put(cutVar, bjnVar);
        } else {
            cutVar.d();
        }
        bjn bjnVar2 = bjnVar.d;
        bjnVar2.c = bjnVar.c;
        bjnVar.c.d = bjnVar2;
        bjn bjnVar3 = (bjn) this.c;
        bjnVar.d = bjnVar3;
        bjn bjnVar4 = bjnVar3.c;
        bjnVar.c = bjnVar4;
        bjnVar4.d = bjnVar;
        bjnVar.d.c = bjnVar;
        ArrayList arrayList = bjnVar.b;
        int size = arrayList != null ? arrayList.size() : 0;
        if (size > 0) {
            return bjnVar.b.remove(size - 1);
        }
        return null;
    }

    public boolean ah(String str, boolean z) {
        return aj().getBoolean(str, z);
    }

    public KeyListener ai(KeyListener keyListener) {
        if (keyListener instanceof NumberKeyListener) {
            return keyListener;
        }
        ((DefaultConfig) ((erp) this.d).v).getClass();
        if (keyListener instanceof auf) {
            return keyListener;
        }
        if (keyListener == null) {
            return null;
        }
        return keyListener instanceof NumberKeyListener ? keyListener : new auf(keyListener);
    }

    public ayd aj() {
        return (ayd) ((Kotlin$Lazy) this.d).getValue();
    }

    public dle ak(int i) {
        lg lgVar = (lg) this.c;
        return lgVar == null ? ajn.aa(0, 5L) : (dle) lgVar.b.get(i);
    }

    public boolean al(int i, KeyEvent keyEvent) {
        btm btmVar = (btm) this.d;
        if (btmVar.initOnce() || btmVar.d() || keyEvent.isCtrlPressed()) {
            return (i >= 29 && i <= 54) || i == 66 || i == 19 || i == 20 || i == 21 || i == 22 || i == 122 || i == 123;
        }
        return false;
    }

    public void am(AttributeSet attributeSet, int i) {
        switch (this.b) {
            case 0:
                AbsSeekBar absSeekBar = (AbsSeekBar) this.c;
                FactoryPools factoryPoolsVarK = FactoryPools.k(absSeekBar.getContext(), attributeSet, a, i);
                Drawable drawableT = factoryPoolsVarK.t(0);
                if (drawableT != null) {
                    if (drawableT instanceof AnimationDrawable) {
                        AnimationDrawable animationDrawable = (AnimationDrawable) drawableT;
                        int numberOfFrames = animationDrawable.getNumberOfFrames();
                        AnimationDrawable animationDrawable2 = new AnimationDrawable();
                        animationDrawable2.setOneShot(animationDrawable.isOneShot());
                        for (int i2 = 0; i2 < numberOfFrames; i2++) {
                            Drawable drawableBa = ba(animationDrawable.getFrame(i2), true);
                            drawableBa.setLevel(10000);
                            animationDrawable2.addFrame(drawableBa, animationDrawable.getDuration(i2));
                        }
                        animationDrawable2.setLevel(10000);
                        drawableT = animationDrawable2;
                    }
                    absSeekBar.setIndeterminateDrawable(drawableT);
                }
                Drawable drawableT2 = factoryPoolsVarK.t(1);
                if (drawableT2 != null) {
                    absSeekBar.setProgressDrawable(ba(drawableT2, false));
                }
                factoryPoolsVarK.ae();
                return;
            default:
                TypedArray typedArrayObtainStyledAttributes = ((EditText) this.c).getContext()
                        .obtainStyledAttributes(attributeSet, cyf.i, i, 0);
                try {
                    boolean z = true;
                    if (typedArrayObtainStyledAttributes.hasValue(14)) {
                        z = typedArrayObtainStyledAttributes.getBoolean(14, true);
                        break;
                    }
                    typedArrayObtainStyledAttributes.recycle();
                    aw(z);
                    return;
                } catch (Throwable th) {
                    typedArrayObtainStyledAttributes.recycle();
                    throw th;
                }
        }
    }

    public auc an(InputConnection inputConnection, EditorInfo editorInfo) {
        erp erpVar = (erp) this.d;
        if (inputConnection == null) {
            erpVar.getClass();
            inputConnection = null;
        } else {
            DefaultConfig ioVar = (DefaultConfig) erpVar.v;
            ioVar.getClass();
            if (!(inputConnection instanceof auc)) {
                inputConnection = new auc((EditText) ioVar.c, inputConnection, editorInfo);
            }
        }
        return (auc) inputConnection;
    }

    public void ao(da daVar) {
        chm chmVar = (chm) this.c;
        ((ActionMode.Callback) chmVar.d).onDestroyActionMode(chmVar.ab(daVar));
        AppCompatDelegate appCompatDelegateVar = (AppCompatDelegate) this.d;
        if (appCompatDelegateVar.aj != null) {
            appCompatDelegateVar.y.getDecorView().removeCallbacks(appCompatDelegateVar.ak);
        }
        if (appCompatDelegateVar.ai != null) {
            esg esgVar = appCompatDelegateVar.al;
            if (esgVar != null) {
                esgVar.c();
            }
            esg esgVarG = ViewCompat.getOrCreateAnimationHelper(appCompatDelegateVar.ai);
            esgVarG.b(0.0f);
            appCompatDelegateVar.al = esgVarG;
            esgVarG.e(new hr(this, 2));
        }
        appCompatDelegateVar.ah = null;
        ViewGroup viewGroup = appCompatDelegateVar.an;
        WeakHashMap weakHashMap = ViewCompat.a;
        eqo.c(viewGroup);
        appCompatDelegateVar.cr();
    }

    public boolean ap(da daVar, Menu menu) {
        ViewGroup viewGroup = ((AppCompatDelegate) this.d).an;
        WeakHashMap weakHashMap = ViewCompat.a;
        eqo.c(viewGroup);
        chm chmVar = (chm) this.c;
        ActionMode.Callback callback = (ActionMode.Callback) chmVar.d;
        doc docVarAb = chmVar.ab(daVar);
        dhq dhqVar = (dhq) chmVar.f;
        Menu ccpVar = (Menu) dhqVar.get(menu);
        if (ccpVar == null) {
            ccpVar = new ccp((Context) chmVar.e, (cbw) menu);
            dhqVar.put(menu, ccpVar);
        }
        return callback.onPrepareActionMode(docVarAb, ccpVar);
    }

    public void aq(bby bbyVar) {
        dby dbyVar = (dby) this.d;
        SyntheticPileOfMess bmuVar = (SyntheticPileOfMess) this.c;
        int i = bbyVar.b;
        if (i == 0) {
            dbyVar.execute(new cs(bmuVar, bbyVar.a, 4, false));
        } else {
            dbyVar.execute(new np(bmuVar, i, 1));
        }
    }

    /*
     * JADX WARN: Failed to restore switch over string. Please report as a
     * decompilation issue
     */
    /* JADX WARN: Found duplicated region for block: B:113:0x0110 A[SYNTHETIC] */
    /*
     * JADX WARN: Found duplicated region for block: B:63:0x0109 A[Catch:
     * IOException -> 0x0091, XmlPullParserException -> 0x0094, TryCatch #2
     * {IOException -> 0x0091, XmlPullParserException -> 0x0094, blocks:
     * (B:20:0x0062, B:97:0x0209, B:28:0x0074, B:29:0x0082, B:31:0x0087,
     * B:38:0x0097, B:46:0x00b1, B:41:0x00a0, B:44:0x00a9, B:47:0x00bf, B:51:0x00ce,
     * B:53:0x00d6, B:54:0x00e0, B:63:0x0109, B:64:0x0110, B:65:0x0128, B:57:0x00e9,
     * B:59:0x00f1, B:60:0x00ff, B:66:0x0129, B:68:0x0131, B:69:0x013f, B:72:0x0149,
     * B:73:0x0154, B:74:0x016c, B:75:0x016d, B:78:0x0177, B:79:0x0182, B:80:0x019a,
     * B:81:0x019b, B:83:0x01a3, B:84:0x01ac, B:87:0x01b6, B:88:0x01c0, B:89:0x01d8,
     * B:90:0x01d9, B:93:0x01e3, B:94:0x01ed, B:95:0x0205, B:96:0x0206), top:
     * B:105:0x0062 }]
     */
    public void ar(Context context, XmlResourceParser xmlResourceParser) {
        int eventType;
        adk adkVarH;
        adp adpVar = new adp();
        int attributeCount = xmlResourceParser.getAttributeCount();
        for (int i = 0; i < attributeCount; i++) {
            String attributeName = xmlResourceParser.getAttributeName(i);
            String attributeValue = xmlResourceParser.getAttributeValue(i);
            if (attributeName != null && attributeValue != null && "id".equals(attributeName)) {
                int identifier = attributeValue.contains("/")
                        ? context.getResources().getIdentifier(attributeValue.substring(attributeValue.indexOf(47) + 1),
                                "id", context.getPackageName())
                        : -1;
                if (identifier == -1) {
                    if (attributeValue.length() > 1) {
                        identifier = Integer.parseInt(attributeValue.substring(1));
                    } else {
                        Log.e("ConstraintLayoutStates", "error in parsing id");
                    }
                }
                try {
                    eventType = xmlResourceParser.getEventType();
                    adkVarH = null;
                } catch (IOException e) {
                    Log.e("ConstraintSet", "Error parsing XML resource", e);
                } catch (XmlPullParserException e2) {
                    Log.e("ConstraintSet", "Error parsing XML resource", e2);
                }
                while (eventType != 1) {
                    if (eventType == 0) {
                        xmlResourceParser.getName();
                    } else if (eventType == 2) {
                        String name = xmlResourceParser.getName();
                        switch (name.hashCode()) {
                            case -2025855158:
                                if (name.equals("Layout")) {
                                    if (adkVarH == null) {
                                        throw new RuntimeException("XML parser error must be within a Constraint "
                                                + xmlResourceParser.getLineNumber());
                                    }
                                    adkVarH.d.bq(context, Xml.asAttributeSet(xmlResourceParser));
                                } else {
                                    continue;
                                }
                                break;
                            case -1984451626:
                                if (name.equals("Motion")) {
                                    if (adkVarH == null) {
                                        throw new RuntimeException("XML parser error must be within a Constraint "
                                                + xmlResourceParser.getLineNumber());
                                    }
                                    adkVarH.c.k(context, Xml.asAttributeSet(xmlResourceParser));
                                } else {
                                    continue;
                                }
                                break;
                            case -1962203927:
                                if (name.equals("ConstraintOverride")) {
                                    adkVarH = adp.h(context, Xml.asAttributeSet(xmlResourceParser), true);
                                }
                                break;
                            case -1269513683:
                                if (name.equals("PropertySet")) {
                                    if (adkVarH == null) {
                                        throw new RuntimeException("XML parser error must be within a Constraint "
                                                + xmlResourceParser.getLineNumber());
                                    }
                                    adkVarH.b.e(context, Xml.asAttributeSet(xmlResourceParser));
                                } else {
                                    continue;
                                }
                                break;
                            case -1238332596:
                                if (name.equals("Transform")) {
                                    if (adkVarH == null) {
                                        throw new RuntimeException("XML parser error must be within a Constraint "
                                                + xmlResourceParser.getLineNumber());
                                    }
                                    adkVarH.e.o(context, Xml.asAttributeSet(xmlResourceParser));
                                } else {
                                    continue;
                                }
                                break;
                            case -71750448:
                                if (name.equals("Guideline")) {
                                    adkVarH = adp.h(context, Xml.asAttributeSet(xmlResourceParser), false);
                                    adkVarH.d.b = true;
                                }
                                break;
                            case 366511058:
                                if (name.equals("CustomMethod")) {
                                    if (adkVarH != null) {
                                        throw new RuntimeException("XML parser error must be within a Constraint "
                                                + xmlResourceParser.getLineNumber());
                                    }
                                    adc.h(context, xmlResourceParser, adkVarH.f);
                                } else {
                                    continue;
                                }
                                break;
                            case 1331510167:
                                if (name.equals("Barrier")) {
                                    adkVarH = adp.h(context, Xml.asAttributeSet(xmlResourceParser), false);
                                    adkVarH.d.bi = 1;
                                }
                                break;
                            case 1791837707:
                                if (name.equals("CustomAttribute")) {
                                    if (adkVarH != null) {
                                        throw new RuntimeException("XML parser error must be within a Constraint "
                                                + xmlResourceParser.getLineNumber());
                                    }
                                    adc.h(context, xmlResourceParser, adkVarH.f);
                                } else {
                                    continue;
                                }
                                break;
                            case 1803088381:
                                if (name.equals("Constraint")) {
                                    adkVarH = adp.h(context, Xml.asAttributeSet(xmlResourceParser), false);
                                }
                                break;
                        }
                    } else if (eventType == 3) {
                        String lowerCase = xmlResourceParser.getName().toLowerCase(Locale.ROOT);
                        switch (lowerCase.hashCode()) {
                            case -2075718416:
                                if (lowerCase.equals("guideline")) {
                                    adpVar.f.put(Integer.valueOf(adkVarH.a), adkVarH);
                                    adkVarH = null;
                                }
                                break;
                            case -190376483:
                                if (lowerCase.equals("constraint")) {
                                    adpVar.f.put(Integer.valueOf(adkVarH.a), adkVarH);
                                    adkVarH = null;
                                }
                                break;
                            case 426575017:
                                if (lowerCase.equals("constraintoverride")) {
                                    adpVar.f.put(Integer.valueOf(adkVarH.a), adkVarH);
                                    adkVarH = null;
                                }
                                break;
                            case 2146106725:
                                if (lowerCase.equals("constraintset")) {
                                    ((SparseArray) this.d).put(identifier, adpVar);
                                    return;
                                }
                                break;
                                break;
                            default:
                                break;
                        }
                    }
                    eventType = xmlResourceParser.next();
                }
                ((SparseArray) this.d).put(identifier, adpVar);
                return;
            }
        }
    }

    public void as(cut cutVar, Object obj) {
        HashMap map = (HashMap) this.d;
        bjn bjnVar = (bjn) map.get(cutVar);
        if (bjnVar == null) {
            bjnVar = new bjn(cutVar);
            bjnVar.d = bjnVar;
            bjn bjnVar2 = (bjn) this.c;
            bjnVar.d = bjnVar2.d;
            bjnVar.c = bjnVar2;
            bjnVar2.d = bjnVar;
            bjnVar.d.c = bjnVar;
            map.put(cutVar, bjnVar);
        } else {
            cutVar.d();
        }
        if (bjnVar.b == null) {
            bjnVar.b = new ArrayList();
        }
        bjnVar.b.add(obj);
    }

    public void at(String str, boolean z) {
        aj().putBoolean(str, z);
    }

    public void au(String str) {
        aoj aojVar;
        synchronized (this) {
            try {
                aojVar = (aoj) ((HashMap) this.c).get(str);
                cmz.n(aojVar, "Argument must not be null");
                int i = aojVar.b;
                if (i < 1) {
                    throw new IllegalStateException("Cannot release a lock that is not held, safeKey: " + str
                            + ", interestedThreads: " + aojVar.b);
                }
                int i2 = i - 1;
                aojVar.b = i2;
                if (i2 == 0) {
                    aoj aojVar2 = (aoj) ((HashMap) this.c).remove(str);
                    if (!aojVar2.equals(aojVar)) {
                        throw new IllegalStateException("Removed the wrong lock, expected to remove: " + aojVar
                                + ", but actually removed: " + aojVar2 + ", safeKey: " + str);
                    }
                    sb sbVar = (sb) this.d;
                    synchronized (sbVar.a) {
                        try {
                            if (sbVar.a.size() < 10) {
                                sbVar.a.offer(aojVar2);
                            }
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        aojVar.a.unlock();
    }

    public Object av() {
        bjn bjnVar = (bjn) this.c;
        bjn bjnVar2 = bjnVar.d;
        while (true) {
            boolean zEquals = bjnVar2.equals(bjnVar);
            Object obj = bjnVar2.a;
            if (zEquals) {
                return null;
            }
            ArrayList arrayList = bjnVar2.b;
            int size = arrayList != null ? arrayList.size() : 0;
            Object objRemove = size > 0 ? bjnVar2.b.remove(size - 1) : null;
            if (objRemove != null) {
                return objRemove;
            }
            bjn bjnVar3 = bjnVar2.d;
            bjnVar3.c = bjnVar2.c;
            bjnVar2.c.d = bjnVar3;
            ((HashMap) this.d).remove(obj);
            ((cut) obj).d();
            bjnVar2 = bjnVar2.d;
        }
    }

    public void aw(boolean z) {
        aut autVar = (aut) ((DefaultConfig) ((erp) this.d).v).d;
        if (autVar.c != z) {
            if (autVar.b != null) {
                atf atfVarL = atf.l();
                aus ausVar = autVar.b;
                atfVarL.getClass();
                cna.j(ausVar, "initCallback cannot be null");
                ReentrantReadWriteLock reentrantReadWriteLock = atfVarL.c;
                reentrantReadWriteLock.writeLock().lock();
                try {
                    atfVarL.d.remove(ausVar);
                    reentrantReadWriteLock.writeLock().unlock();
                } catch (Throwable th) {
                    reentrantReadWriteLock.writeLock().unlock();
                    throw th;
                }
            }
            autVar.c = z;
            if (z) {
                aut.d(autVar.a, atf.l().m());
            }
        }
    }

    public void ax(int i, int i2, int i3, int i4) {
        te teVar = (te) this.d;
        teVar.n.set(i, i2, i3, i4);
        Rect rect = teVar.m;
        super/* android.view.View */.setPadding(i + rect.left, i2 + rect.top, i3 + rect.right, i4 + rect.bottom);
    }

    public void ay(String str) {
        bzy bzyVar = (bzy) this.c;
        if (bzyVar != null) {
            ((eg) bzyVar.d).d = str;
        }
    }

    public void az() {
        bzy bzyVar = (bzy) this.c;
        if (bzyVar != null) {
            View view = (View) this.d;
            if (view != null) {
                ((eg) bzyVar.d).r = view;
            }
            bzyVar.i().show();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Drawable ba(Drawable drawable, boolean z) {
        if (drawable instanceof ewc) {
            ((ewd) ((ewc) drawable)).getClass();
        } else {
            if (drawable instanceof LayerDrawable) {
                LayerDrawable layerDrawable = (LayerDrawable) drawable;
                int numberOfLayers = layerDrawable.getNumberOfLayers();
                Drawable[] drawableArr = new Drawable[numberOfLayers];
                for (int i = 0; i < numberOfLayers; i++) {
                    int id = layerDrawable.getId(i);
                    drawableArr[i] = ba(layerDrawable.getDrawable(i), id == 16908301 || id == 16908303);
                }
                LayerDrawable layerDrawable2 = new LayerDrawable(drawableArr);
                for (int i2 = 0; i2 < numberOfLayers; i2++) {
                    layerDrawable2.setId(i2, layerDrawable.getId(i2));
                    layerDrawable2.setLayerGravity(i2, layerDrawable.getLayerGravity(i2));
                    layerDrawable2.setLayerWidth(i2, layerDrawable.getLayerWidth(i2));
                    layerDrawable2.setLayerHeight(i2, layerDrawable.getLayerHeight(i2));
                    layerDrawable2.setLayerInsetLeft(i2, layerDrawable.getLayerInsetLeft(i2));
                    layerDrawable2.setLayerInsetRight(i2, layerDrawable.getLayerInsetRight(i2));
                    layerDrawable2.setLayerInsetTop(i2, layerDrawable.getLayerInsetTop(i2));
                    layerDrawable2.setLayerInsetBottom(i2, layerDrawable.getLayerInsetBottom(i2));
                    layerDrawable2.setLayerInsetStart(i2, layerDrawable.getLayerInsetStart(i2));
                    layerDrawable2.setLayerInsetEnd(i2, layerDrawable.getLayerInsetEnd(i2));
                }
                return layerDrawable2;
            }
            if (drawable instanceof BitmapDrawable) {
                BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;
                Bitmap bitmap = bitmapDrawable.getBitmap();
                if (((Bitmap) this.d) == null) {
                    this.d = bitmap;
                }
                ShapeDrawable shapeDrawable = new ShapeDrawable(
                        new RoundRectShape(new float[] { 5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f }, null, null));
                shapeDrawable.getPaint()
                        .setShader(new BitmapShader(bitmap, Shader.TileMode.REPEAT, Shader.TileMode.CLAMP));
                shapeDrawable.getPaint().setColorFilter(bitmapDrawable.getPaint().getColorFilter());
                return z ? new ClipDrawable(shapeDrawable, 3, 1) : shapeDrawable;
            }
        }
        return drawable;
    }

    @Override // me.hd.wauxv.obf.aui
    public Object getResult() {
        return (eny) this.c;
    }

    @Override // me.hd.wauxv.obf.dln
    public void i(int i) {
        boolean zTryLock;
        DefaultConfig ioVar = (DefaultConfig) this.d;
        ArrayList arrayList = (ArrayList) ioVar.d;
        ReentrantLock reentrantLock = (ReentrantLock) ioVar.c;
        if (i < 0 || i >= arrayList.size()) {
            lg lgVar = (lg) this.c;
            if (lgVar != null) {
                lgVar.a.unlock();
            }
            this.c = null;
            return;
        }
        lg lgVar2 = (lg) this.c;
        if (lgVar2 != null) {
            lgVar2.a.unlock();
        }
        try {
            zTryLock = reentrantLock.tryLock(100L, TimeUnit.MICROSECONDS);
        } catch (InterruptedException e) {
            Log.w("LockedSpans", "failed to acquire the lock", e);
            Thread.currentThread().interrupt();
            zTryLock = false;
        }
        if (!zTryLock) {
            this.c = null;
            return;
        }
        try {
            lg lgVar3 = (lg) arrayList.get(i);
            if (lgVar3.a.tryLock()) {
                this.c = lgVar3;
            } else {
                this.c = null;
            }
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // me.hd.wauxv.obf.ccv
    public Drawable j(int i) {
        ViewGroup viewGroup = (ViewGroup) this.d;
        File file = new File(bbj.b, ((bbe) ((List) this.c).get(i)).c);
        if (file.exists()) {
            return new BitmapDrawable(viewGroup.getContext().getResources(),
                    BitmapFactory.decodeFile(file.getAbsolutePath()));
        }
        Drawable drawable = viewGroup.getContext().getDrawable(me.hd.wauxv.R.drawable.ic_float_button_menu_24dp);
        throwIfVar1IsNull(drawable);
        return drawable;
    }

    @Override // me.hd.wauxv.obf.avu
    public boolean saveStreamToFile(Object obj, File file, crw crwVar) {
        return ((ow) this.d).saveStreamToFile(new pa(((BitmapDrawable) ((dcg) obj).get()).getBitmap(), (oz) this.c), file, crwVar);
    }

    @Override // me.hd.wauxv.obf.dln
    public List l(int i) {
        boolean zTryLock;
        DefaultConfig ioVar = (DefaultConfig) this.d;
        ArrayList arrayList = (ArrayList) ioVar.d;
        ReentrantLock reentrantLock = (ReentrantLock) ioVar.c;
        ArrayList arrayList2 = new ArrayList();
        try {
            zTryLock = reentrantLock.tryLock(1L, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            Log.w("LockedSpans", "failed to acquire the lock", e);
            zTryLock = false;
        }
        if (zTryLock) {
            try {
                lg lgVar = i < arrayList.size() ? (lg) arrayList.get(i) : null;
                reentrantLock.unlock();
                if (lgVar != null) {
                    ReentrantLock reentrantLock2 = lgVar.a;
                    if (reentrantLock2.tryLock()) {
                        try {
                            return Collections.unmodifiableList(lgVar.b);
                        } finally {
                            reentrantLock2.unlock();
                        }
                    }
                }
                arrayList2.add(ak(0));
            } catch (Throwable th) {
                reentrantLock.unlock();
                throw th;
            }
        } else {
            arrayList2.add(ak(0));
        }
        return arrayList2;
    }

    @Override // me.hd.wauxv.obf.ccv
    public int m() {
        return cnh.aa(((ViewGroup) this.d).getContext()) ? Color.parseColor(bbf.a.o()) : Color.parseColor(bbg.a.o());
    }

    @Override // me.hd.wauxv.obf.dln
    public int n() {
        lg lgVar = (lg) this.c;
        if (lgVar == null) {
            return 1;
        }
        return lgVar.b.size();
    }

    @Override // me.hd.wauxv.obf.ccv
    public int o() {
        return ((List) this.c).size();
    }

    @Override // me.hd.wauxv.obf.aui
    public boolean onMatch(CharSequence charSequence, int i, int i2, EmojiMetadata emojiMetadataVar) {
        if ((emojiMetadataVar.d & 4) > 0) {
            return true;
        }
        if (((eny) this.c) == null) {
            this.c = new eny(
                    charSequence instanceof Spannable ? (Spannable) charSequence : new SpannableString(charSequence));
        }
        ((nu) this.d).getClass();
        ((eny) this.c).setSpan(new eml(emojiMetadataVar), i, i2, 33);
        return true;
    }

    public void q(SomeFragmentManager someFragmentManagerVar, boolean z) {
        throwIfVar1IsNull(someFragmentManagerVar, "f");
        SomeFragmentManager someFragmentManagerVar2 = ((beg) this.c).y;
        if (someFragmentManagerVar2 != null) {
            someFragmentManagerVar2.cs().o.ensureParameterNotNull(someFragmentManagerVar, true);
        }
        for (bdt bdtVar : (CopyOnWriteArrayList) this.d) {
            if (z) {
                bdtVar.getClass();
            } else {
                DefaultConfig ioVar = bdtVar.a;
            }
        }
    }

    public void r(SomeFragmentManager someFragmentManagerVar, boolean z) {
        throwIfVar1IsNull(someFragmentManagerVar, "f");
        beg begVar = (beg) this.c;
        hb hbVar = begVar.w.e;
        SomeFragmentManager someFragmentManagerVar2 = begVar.y;
        if (someFragmentManagerVar2 != null) {
            someFragmentManagerVar2.cs().o.r(someFragmentManagerVar, true);
        }
        for (bdt bdtVar : (CopyOnWriteArrayList) this.d) {
            if (z) {
                bdtVar.getClass();
            } else {
                DefaultConfig ioVar = bdtVar.a;
            }
        }
    }

    @Override // me.hd.wauxv.obf.ccv
    public int s() {
        return cnh.aa(((ViewGroup) this.d).getContext()) ? Color.parseColor(bbh.a.o()) : Color.parseColor(bbi.a.o());
    }

    public void t(SomeFragmentManager someFragmentManagerVar, boolean z) {
        throwIfVar1IsNull(someFragmentManagerVar, "f");
        SomeFragmentManager someFragmentManagerVar2 = ((beg) this.c).y;
        if (someFragmentManagerVar2 != null) {
            someFragmentManagerVar2.cs().o.t(someFragmentManagerVar, true);
        }
        for (bdt bdtVar : (CopyOnWriteArrayList) this.d) {
            if (z) {
                bdtVar.getClass();
            } else {
                DefaultConfig ioVar = bdtVar.a;
            }
        }
    }

    public String toString() {
        switch (this.b) {
            case 24:
                StringBuilder sb = new StringBuilder("GroupedLinkedMap( ");
                bjn bjnVar = (bjn) this.c;
                bjn bjnVar2 = bjnVar.c;
                boolean z = false;
                while (!bjnVar2.equals(bjnVar)) {
                    sb.append('{');
                    sb.append(bjnVar2.a);
                    sb.append(':');
                    ArrayList arrayList = bjnVar2.b;
                    sb.append(arrayList != null ? arrayList.size() : 0);
                    sb.append("}, ");
                    bjnVar2 = bjnVar2.c;
                    z = true;
                }
                if (z) {
                    sb.delete(sb.length() - 2, sb.length());
                }
                sb.append(" )");
                return sb.toString();
            default:
                return super.toString();
        }
    }

    public void u(SomeFragmentManager someFragmentManagerVar, boolean z) {
        throwIfVar1IsNull(someFragmentManagerVar, "f");
        SomeFragmentManager someFragmentManagerVar2 = ((beg) this.c).y;
        if (someFragmentManagerVar2 != null) {
            someFragmentManagerVar2.cs().o.u(someFragmentManagerVar, true);
        }
        for (bdt bdtVar : (CopyOnWriteArrayList) this.d) {
            if (z) {
                bdtVar.getClass();
            } else {
                DefaultConfig ioVar = bdtVar.a;
            }
        }
    }

    public void v(SomeFragmentManager someFragmentManagerVar, boolean z) {
        throwIfVar1IsNull(someFragmentManagerVar, "f");
        SomeFragmentManager someFragmentManagerVar2 = ((beg) this.c).y;
        if (someFragmentManagerVar2 != null) {
            someFragmentManagerVar2.cs().o.v(someFragmentManagerVar, true);
        }
        for (bdt bdtVar : (CopyOnWriteArrayList) this.d) {
            if (z) {
                bdtVar.getClass();
            } else {
                DefaultConfig ioVar = bdtVar.a;
            }
        }
    }

    public void w(SomeFragmentManager someFragmentManagerVar, boolean z) {
        throwIfVar1IsNull(someFragmentManagerVar, "f");
        SomeFragmentManager someFragmentManagerVar2 = ((beg) this.c).y;
        if (someFragmentManagerVar2 != null) {
            someFragmentManagerVar2.cs().o.w(someFragmentManagerVar, true);
        }
        for (bdt bdtVar : (CopyOnWriteArrayList) this.d) {
            if (z) {
                bdtVar.getClass();
            } else {
                DefaultConfig ioVar = bdtVar.a;
            }
        }
    }

    @Override // me.hd.wauxv.obf.dcm
    public int x(crw crwVar) {
        return 2;
    }

    public void y(SomeFragmentManager someFragmentManagerVar, boolean z) {
        throwIfVar1IsNull(someFragmentManagerVar, "f");
        beg begVar = (beg) this.c;
        hb hbVar = begVar.w.e;
        SomeFragmentManager someFragmentManagerVar2 = begVar.y;
        if (someFragmentManagerVar2 != null) {
            someFragmentManagerVar2.cs().o.y(someFragmentManagerVar, true);
        }
        for (bdt bdtVar : (CopyOnWriteArrayList) this.d) {
            if (z) {
                bdtVar.getClass();
            } else {
                DefaultConfig ioVar = bdtVar.a;
            }
        }
    }

    public void z(SomeFragmentManager someFragmentManagerVar, boolean z) {
        throwIfVar1IsNull(someFragmentManagerVar, "f");
        SomeFragmentManager someFragmentManagerVar2 = ((beg) this.c).y;
        if (someFragmentManagerVar2 != null) {
            someFragmentManagerVar2.cs().o.z(someFragmentManagerVar, true);
        }
        for (bdt bdtVar : (CopyOnWriteArrayList) this.d) {
            if (z) {
                bdtVar.getClass();
            } else {
                DefaultConfig ioVar = bdtVar.a;
            }
        }
    }

    public /* synthetic */ DefaultConfig(Object obj, int i) {
        this.b = i;
        this.d = obj;
    }

    public /* synthetic */ DefaultConfig(Object obj, int i, Object obj2) {
        this.b = i;
        this.c = obj;
        this.d = obj2;
    }

    public /* synthetic */ DefaultConfig(Object obj, Object obj2, int i, boolean z) {
        this.b = i;
        this.d = obj;
        this.c = obj2;
    }

    public DefaultConfig(Context context, String str) {
        this.b = 29;
        this.c = new Kotlin$Lazy(new bp(context, 26));
        this.d = new Kotlin$Lazy(new ls(this, 4, str));
    }

    public DefaultConfig(beg begVar) {
        this.b = 20;
        this.c = begVar;
        this.d = new CopyOnWriteArrayList();
    }

    public DefaultConfig(AbsSeekBar absSeekBar) {
        this.b = 0;
        this.c = absSeekBar;
    }

    public DefaultConfig(EditText editText, int i) {
        this.b = i;
        switch (i) {
            case 16:
                this.c = editText;
                aut autVar = new aut(editText);
                this.d = autVar;
                editText.addTextChangedListener(autVar);
                if (atj.b == null) {
                    synchronized (atj.a) {
                        try {
                            if (atj.b == null) {
                                atj atjVar = new atj();
                                try {
                                    atj.c = Class.forName("android.text.DynamicLayout$ChangeWatcher", false,
                                            atj.class.getClassLoader());
                                    break;
                                } catch (Throwable unused) {
                                }
                                atj.b = atjVar;
                            }
                        } catch (Throwable th) {
                            throw th;
                        }
                        break;
                    }
                }
                editText.setEditableFactory(atj.b);
                return;
            default:
                this.c = editText;
                this.d = new erp(editText);
                return;
        }
    }

    public DefaultConfig(CodeEditor codeEditor) {
        this.b = 15;
        this.c = codeEditor;
        this.d = new btm(codeEditor);
    }

    public DefaultConfig(Context context, int i) {
        this.b = i;
        switch (i) {
            case 13:
                this.c = new bzy(context);
                break;
            default:
                TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(
                        cmz.an(context, me.hd.wauxv.R.attr.materialCalendarStyle, cal.class.getCanonicalName()).data,
                        cxs.t);
                nu.createInstanceWithArgs(context, typedArrayObtainStyledAttributes.getResourceId(4, 0));
                nu.createInstanceWithArgs(context, typedArrayObtainStyledAttributes.getResourceId(2, 0));
                nu.createInstanceWithArgs(context, typedArrayObtainStyledAttributes.getResourceId(3, 0));
                nu.createInstanceWithArgs(context, typedArrayObtainStyledAttributes.getResourceId(5, 0));
                ColorStateList colorStateListV = cnb.v(context, typedArrayObtainStyledAttributes, 7);
                this.c = nu.createInstanceWithArgs(context, typedArrayObtainStyledAttributes.getResourceId(9, 0));
                nu.createInstanceWithArgs(context, typedArrayObtainStyledAttributes.getResourceId(8, 0));
                this.d = nu.createInstanceWithArgs(context, typedArrayObtainStyledAttributes.getResourceId(10, 0));
                new Paint().setColor(colorStateListV.getDefaultColor());
                typedArrayObtainStyledAttributes.recycle();
                break;
        }
    }

    public DefaultConfig(Animation animation) {
        this.b = 19;
        this.c = animation;
        this.d = null;
    }

    public DefaultConfig(Animator animator) {
        this.b = 19;
        this.c = null;
        AnimatorSet animatorSet = new AnimatorSet();
        this.d = animatorSet;
        animatorSet.play(animator);
    }

    public DefaultConfig(ArrayList arrayList, ArrayList arrayList2) {
        this.b = 23;
        int size = arrayList.size();
        this.c = new int[size];
        this.d = new float[size];
        for (int i = 0; i < size; i++) {
            ((int[]) this.c)[i] = ((Integer) arrayList.get(i)).intValue();
            ((float[]) this.d)[i] = ((Float) arrayList2.get(i)).floatValue();
        }
    }

    public DefaultConfig(int i, int i2) {
        this.b = 23;
        this.c = new int[] { i, i2 };
        this.d = new float[] { 0.0f, 1.0f };
    }

    public DefaultConfig(int i, int i2, int i3) {
        this.b = 23;
        this.c = new int[] { i, i2, i3 };
        this.d = new float[] { 0.0f, 0.5f, 1.0f };
    }

    public DefaultConfig(byu byuVar, SomeFragmentManager someFragmentManagerVar, FrameLayout frameLayout) {
        this.b = 21;
        this.c = someFragmentManagerVar;
        this.d = frameLayout;
    }

    public DefaultConfig(Class cls, bep bepVar, ws wsVar) {
        this.b = 25;
        this.c = cls;
        this.d = wsVar;
    }

    public DefaultConfig(int i) {
        this.b = i;
        switch (i) {
            case 7:
                this.d = new ArrayList(128);
                this.c = new ReentrantLock();
                break;
            case 14:
                this.c = new HashMap();
                this.d = new sb(1);
                break;
            case 24:
                this.c = new bjn(null);
                this.d = new HashMap();
                break;
            case 26:
                this.c = new ReentrantLock(true);
                this.d = new HashMap();
                break;
            default:
                this.c = new Rect();
                this.d = new Rect();
                break;
        }
    }
}

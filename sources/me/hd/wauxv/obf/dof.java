package me.hd.wauxv.obf;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import android.view.InflateException;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.SubMenu;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class dof extends MenuInflater {
    public static final Class[] a;
    public static final Class[] b;
    public final Object[] c;
    public final Object[] d;
    public final Context e;
    public Object f;

    static {
        Class[] clsArr = {Context.class};
        a = clsArr;
        b = clsArr;
    }

    public dof(Context context) {
        super(context);
        this.e = context;
        Object[] objArr = {context};
        this.c = objArr;
        this.d = objArr;
    }

    public static Object g(Object obj) {
        return (!(obj instanceof Activity) && (obj instanceof ContextWrapper)) ? g(((ContextWrapper) obj).getBaseContext()) : obj;
    }

    public final void h(XmlPullParser xmlPullParser, AttributeSet attributeSet, Menu menu) throws XmlPullParserException, IOException {
        int i;
        XmlPullParser xmlPullParser2;
        ColorStateList colorStateList;
        int resourceId;
        doe doeVar = new doe(this, menu);
        int eventType = xmlPullParser.getEventType();
        do {
            i = 2;
            if (eventType == 2) {
                String name = xmlPullParser.getName();
                if (!name.equals("menu")) {
                    throw new RuntimeException("Expecting menu, got ".concat(name));
                }
                eventType = xmlPullParser.next();
                break;
            }
            eventType = xmlPullParser.next();
        } while (eventType != 1);
        boolean z = false;
        boolean z2 = false;
        String str = null;
        while (!z) {
            if (eventType == 1) {
                throw new RuntimeException("Unexpected end of document");
            }
            if (eventType == i) {
                if (!z2) {
                    String name2 = xmlPullParser.getName();
                    boolean zEquals = name2.equals("group");
                    Context context = this.e;
                    if (zEquals) {
                        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, cyf.p);
                        doeVar.b = typedArrayObtainStyledAttributes.getResourceId(1, 0);
                        doeVar.c = typedArrayObtainStyledAttributes.getInt(3, 0);
                        doeVar.d = typedArrayObtainStyledAttributes.getInt(4, 0);
                        doeVar.e = typedArrayObtainStyledAttributes.getInt(5, 0);
                        doeVar.f = typedArrayObtainStyledAttributes.getBoolean(2, true);
                        doeVar.g = typedArrayObtainStyledAttributes.getBoolean(0, true);
                        typedArrayObtainStyledAttributes.recycle();
                    } else if (name2.equals("item")) {
                        TypedArray typedArrayObtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, cyf.q);
                        doeVar.i = typedArrayObtainStyledAttributes2.getResourceId(2, 0);
                        doeVar.j = (typedArrayObtainStyledAttributes2.getInt(5, doeVar.c) & (-65536)) | (typedArrayObtainStyledAttributes2.getInt(6, doeVar.d) & 65535);
                        doeVar.k = typedArrayObtainStyledAttributes2.getText(7);
                        doeVar.l = typedArrayObtainStyledAttributes2.getText(8);
                        doeVar.m = typedArrayObtainStyledAttributes2.getResourceId(0, 0);
                        String string = typedArrayObtainStyledAttributes2.getString(9);
                        doeVar.n = string == null ? (char) 0 : string.charAt(0);
                        doeVar.o = typedArrayObtainStyledAttributes2.getInt(16, 4096);
                        String string2 = typedArrayObtainStyledAttributes2.getString(10);
                        doeVar.p = string2 == null ? (char) 0 : string2.charAt(0);
                        doeVar.q = typedArrayObtainStyledAttributes2.getInt(20, 4096);
                        if (typedArrayObtainStyledAttributes2.hasValue(11)) {
                            doeVar.r = typedArrayObtainStyledAttributes2.getBoolean(11, false) ? 1 : 0;
                        } else {
                            doeVar.r = doeVar.e;
                        }
                        doeVar.s = typedArrayObtainStyledAttributes2.getBoolean(3, false);
                        doeVar.t = typedArrayObtainStyledAttributes2.getBoolean(4, doeVar.f);
                        doeVar.u = typedArrayObtainStyledAttributes2.getBoolean(1, doeVar.g);
                        doeVar.v = typedArrayObtainStyledAttributes2.getInt(21, -1);
                        doeVar.y = typedArrayObtainStyledAttributes2.getString(12);
                        doeVar.w = typedArrayObtainStyledAttributes2.getResourceId(13, 0);
                        doeVar.x = typedArrayObtainStyledAttributes2.getString(15);
                        String string3 = typedArrayObtainStyledAttributes2.getString(14);
                        boolean z3 = string3 != null;
                        if (z3 && doeVar.w == 0 && doeVar.x == null) {
                            doeVar.z = (cca) doeVar.af(string3, b, this.d);
                        } else {
                            if (z3) {
                                Log.w("SupportMenuInflater", "Ignoring attribute 'actionProviderClass'. Action view already specified.");
                            }
                            doeVar.z = null;
                        }
                        doeVar.aa = typedArrayObtainStyledAttributes2.getText(17);
                        doeVar.ab = typedArrayObtainStyledAttributes2.getText(22);
                        if (typedArrayObtainStyledAttributes2.hasValue(19)) {
                            doeVar.ad = apy.f(typedArrayObtainStyledAttributes2.getInt(19, -1), doeVar.ad);
                        } else {
                            doeVar.ad = null;
                        }
                        if (typedArrayObtainStyledAttributes2.hasValue(18)) {
                            if (!typedArrayObtainStyledAttributes2.hasValue(18) || (resourceId = typedArrayObtainStyledAttributes2.getResourceId(18, 0)) == 0 || (colorStateList = bht.v(context, resourceId)) == null) {
                                colorStateList = typedArrayObtainStyledAttributes2.getColorStateList(18);
                            }
                            doeVar.ac = colorStateList;
                        } else {
                            doeVar.ac = null;
                        }
                        typedArrayObtainStyledAttributes2.recycle();
                        doeVar.h = false;
                        xmlPullParser2 = xmlPullParser;
                    } else if (name2.equals("menu")) {
                        doeVar.h = true;
                        SubMenu subMenuAddSubMenu = doeVar.a.addSubMenu(doeVar.b, doeVar.i, doeVar.j, doeVar.k);
                        doeVar.ag(subMenuAddSubMenu.getItem());
                        xmlPullParser2 = xmlPullParser;
                        h(xmlPullParser2, attributeSet, subMenuAddSubMenu);
                    } else {
                        xmlPullParser2 = xmlPullParser;
                        str = name2;
                        z2 = true;
                    }
                }
                xmlPullParser2 = xmlPullParser;
                z = z;
            } else if (eventType != 3) {
                xmlPullParser2 = xmlPullParser;
                z = z;
            } else {
                String name3 = xmlPullParser.getName();
                if (z2 && name3.equals(str)) {
                    xmlPullParser2 = xmlPullParser;
                    z2 = false;
                    str = null;
                } else {
                    if (name3.equals("group")) {
                        doeVar.b = 0;
                        doeVar.c = 0;
                        doeVar.d = 0;
                        doeVar.e = 0;
                        doeVar.f = true;
                        doeVar.g = true;
                    } else if (name3.equals("item")) {
                        if (!doeVar.h) {
                            cca ccaVar = doeVar.z;
                            if (ccaVar == null || !ccaVar.b.hasSubMenu()) {
                                doeVar.h = true;
                                doeVar.ag(doeVar.a.add(doeVar.b, doeVar.i, doeVar.j, doeVar.k));
                            } else {
                                doeVar.h = true;
                                doeVar.ag(doeVar.a.addSubMenu(doeVar.b, doeVar.i, doeVar.j, doeVar.k).getItem());
                            }
                        }
                    } else if (name3.equals("menu")) {
                        xmlPullParser2 = xmlPullParser;
                        z = true;
                    }
                    xmlPullParser2 = xmlPullParser;
                    z = z;
                }
            }
            eventType = xmlPullParser2.next();
            i = 2;
            z = z;
            z2 = z2;
        }
    }

    @Override // android.view.MenuInflater
    public final void inflate(int i, Menu menu) {
        if (!(menu instanceof cbw)) {
            super.inflate(i, menu);
            return;
        }
        XmlResourceParser layout = null;
        boolean z = false;
        try {
            try {
                layout = this.e.getResources().getLayout(i);
                AttributeSet attributeSetAsAttributeSet = Xml.asAttributeSet(layout);
                if (menu instanceof cbw) {
                    cbw cbwVar = (cbw) menu;
                    if (!cbwVar.q) {
                        cbwVar.av();
                        z = true;
                    }
                }
                h(layout, attributeSetAsAttributeSet, menu);
                if (z) {
                    ((cbw) menu).au();
                }
                layout.close();
            } catch (IOException e) {
                throw new InflateException("Error inflating menu XML", e);
            } catch (XmlPullParserException e2) {
                throw new InflateException("Error inflating menu XML", e2);
            }
        } catch (Throwable th) {
            if (z) {
                ((cbw) menu).au();
            }
            if (layout != null) {
                layout.close();
            }
            throw th;
        }
    }
}

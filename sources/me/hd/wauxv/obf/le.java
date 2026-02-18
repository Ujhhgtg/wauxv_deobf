package me.hd.wauxv.obf;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.net.Uri;
import android.util.Log;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class le implements cdv {
    public final /* synthetic */ int a;
    public final Object b;
    public final Object c;

    public /* synthetic */ le(Object obj, int i, Object obj2) {
        this.a = i;
        this.c = obj;
        this.b = obj2;
    }

    @Override // me.hd.wauxv.obf.cdv
    public final boolean d(Object obj) {
        switch (this.a) {
            case 0:
                Uri uri = (Uri) obj;
                return "file".equals(uri.getScheme()) && !uri.getPathSegments().isEmpty() && "android_asset".equals(uri.getPathSegments().get(0));
            case 1:
                return true;
            case 2:
                Iterator it = ((ArrayList) this.c).iterator();
                while (it.hasNext()) {
                    if (((cdv) it.next()).d(obj)) {
                        return true;
                    }
                }
                return false;
            case 3:
                return true;
            default:
                Uri uri2 = (Uri) obj;
                return "android.resource".equals(uri2.getScheme()) && ((Context) this.c).getPackageName().equals(uri2.getAuthority());
        }
    }

    @Override // me.hd.wauxv.obf.cdv
    public final cdu e(Object obj, int i, int i2, crw crwVar) {
        azo azoVar;
        cdu cduVarE;
        Uri uri;
        switch (this.a) {
            case 0:
                Uri uri2 = (Uri) obj;
                String strSubstring = uri2.toString().substring(22);
                cpi cpiVar = new cpi(uri2);
                AssetManager assetManager = (AssetManager) this.c;
                switch (((ld) this.b).a) {
                    case 0:
                        azoVar = new azo(assetManager, strSubstring, 0);
                        break;
                    default:
                        azoVar = new azo(assetManager, strSubstring, 1);
                        break;
                }
                return new cdu(cpiVar, azoVar);
            case 1:
                Integer num = (Integer) obj;
                Resources.Theme theme = (Resources.Theme) crwVar.b(dcl.a);
                return new cdu(new cpi(num), new ans(theme, theme != null ? theme.getResources() : ((Context) this.c).getResources(), (anr) this.b, num.intValue()));
            case 2:
                ArrayList arrayList = (ArrayList) this.c;
                int size = arrayList.size();
                ArrayList arrayList2 = new ArrayList(size);
                btj btjVar = null;
                for (int i3 = 0; i3 < size; i3++) {
                    cdv cdvVar = (cdv) arrayList.get(i3);
                    if (cdvVar.d(obj) && (cduVarE = cdvVar.e(obj, i, i2, crwVar)) != null) {
                        btjVar = cduVarE.a;
                        arrayList2.add(cduVarE.c);
                    }
                }
                if (arrayList2.isEmpty() || btjVar == null) {
                    return null;
                }
                return new cdu(btjVar, new chk(arrayList2, (cuv) this.b));
            case 3:
                Integer num2 = (Integer) obj;
                try {
                    uri = Uri.parse("android.resource://" + ((Resources) this.b).getResourcePackageName(num2.intValue()) + '/' + num2);
                    break;
                } catch (Resources.NotFoundException e) {
                    if (Log.isLoggable("ResourceLoader", 5)) {
                        Log.w("ResourceLoader", "Received invalid resource id: " + num2, e);
                    }
                    uri = null;
                }
                if (uri == null) {
                    return null;
                }
                return ((cdv) this.c).e(uri, i, i2, crwVar);
            default:
                Uri uri3 = (Uri) obj;
                cdv cdvVar2 = (cdv) this.b;
                List<String> pathSegments = uri3.getPathSegments();
                cdu cduVarE2 = null;
                if (pathSegments.size() == 1) {
                    try {
                        int i4 = Integer.parseInt(uri3.getPathSegments().get(0));
                        if (i4 != 0) {
                            cduVarE2 = cdvVar2.e(Integer.valueOf(i4), i, i2, crwVar);
                        } else if (Log.isLoggable("ResourceUriLoader", 5)) {
                            Log.w("ResourceUriLoader", "Failed to parse a valid non-0 resource id from: " + uri3);
                        }
                        return cduVarE2;
                    } catch (NumberFormatException e2) {
                        if (!Log.isLoggable("ResourceUriLoader", 5)) {
                            return cduVarE2;
                        }
                        Log.w("ResourceUriLoader", "Failed to parse resource id from: " + uri3, e2);
                        return cduVarE2;
                    }
                }
                if (pathSegments.size() != 2) {
                    if (!Log.isLoggable("ResourceUriLoader", 5)) {
                        return null;
                    }
                    Log.w("ResourceUriLoader", "Failed to parse resource uri: " + uri3);
                    return null;
                }
                List<String> pathSegments2 = uri3.getPathSegments();
                String str = pathSegments2.get(0);
                String str2 = pathSegments2.get(1);
                Context context = (Context) this.c;
                int identifier = context.getResources().getIdentifier(str2, str, context.getPackageName());
                if (identifier != 0) {
                    return cdvVar2.e(Integer.valueOf(identifier), i, i2, crwVar);
                }
                if (!Log.isLoggable("ResourceUriLoader", 5)) {
                    return null;
                }
                Log.w("ResourceUriLoader", "Failed to find resource id for: " + uri3);
                return null;
        }
    }

    public String toString() {
        switch (this.a) {
            case 2:
                return "MultiModelLoader{modelLoaders=" + Arrays.toString(((ArrayList) this.c).toArray()) + '}';
            default:
                return super.toString();
        }
    }

    public le(Resources resources, cdv cdvVar) {
        this.a = 3;
        this.b = resources;
        this.c = cdvVar;
    }

    public le(Context context, anr anrVar) {
        this.a = 1;
        this.c = context.getApplicationContext();
        this.b = anrVar;
    }

    public le(Context context, cdv cdvVar) {
        this.a = 4;
        this.c = context.getApplicationContext();
        this.b = cdvVar;
    }
}

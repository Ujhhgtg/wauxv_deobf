package me.hd.wauxv.obf;

import android.content.Context;
import android.content.IntentFilter;
import android.location.Location;
import android.location.LocationManager;
import android.os.PowerManager;
import android.util.Log;
import java.util.Calendar;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class hx extends hz {
    public final /* synthetic */ int a = 0;
    public final /* synthetic */ ic b;
    public final Object c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public hx(ic icVar, jx jxVar) {
        super(icVar);
        this.b = icVar;
        this.c = jxVar;
    }

    @Override // me.hd.wauxv.obf.hz
    public final IntentFilter d() {
        switch (this.a) {
            case 0:
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("android.os.action.POWER_SAVE_MODE_CHANGED");
                return intentFilter;
            default:
                IntentFilter intentFilter2 = new IntentFilter();
                intentFilter2.addAction("android.intent.action.TIME_SET");
                intentFilter2.addAction("android.intent.action.TIMEZONE_CHANGED");
                intentFilter2.addAction("android.intent.action.TIME_TICK");
                return intentFilter2;
        }
    }

    @Override // me.hd.wauxv.obf.hz
    public final int e() {
        Location location;
        boolean z;
        long j;
        switch (this.a) {
            case 0:
                return hs.a((PowerManager) this.c) ? 2 : 1;
            default:
                jx jxVar = (jx) this.c;
                emb embVar = (emb) jxVar.f;
                LocationManager locationManager = (LocationManager) jxVar.e;
                if (embVar.b <= System.currentTimeMillis()) {
                    Context context = (Context) jxVar.h;
                    Location lastKnownLocation = null;
                    if (aye.o(context, "android.permission.ACCESS_COARSE_LOCATION") == 0) {
                        try {
                        } catch (Exception e) {
                            Log.d("TwilightManager", "Failed to get last known location", e);
                        }
                        Location lastKnownLocation2 = locationManager.isProviderEnabled("network") ? locationManager.getLastKnownLocation("network") : null;
                        location = lastKnownLocation2;
                    } else {
                        location = null;
                    }
                    if (aye.o(context, "android.permission.ACCESS_FINE_LOCATION") == 0) {
                        try {
                            if (locationManager.isProviderEnabled("gps")) {
                                lastKnownLocation = locationManager.getLastKnownLocation("gps");
                            }
                        } catch (Exception e2) {
                            Log.d("TwilightManager", "Failed to get last known location", e2);
                        }
                    }
                    if (lastKnownLocation == null || location == null ? lastKnownLocation != null : lastKnownLocation.getTime() > location.getTime()) {
                        location = lastKnownLocation;
                    }
                    if (location != null) {
                        long jCurrentTimeMillis = System.currentTimeMillis();
                        if (ema.a == null) {
                            ema.a = new ema();
                        }
                        ema emaVar = ema.a;
                        emaVar.e(jCurrentTimeMillis - 86400000, location.getLatitude(), location.getLongitude());
                        emaVar.e(jCurrentTimeMillis, location.getLatitude(), location.getLongitude());
                        z = emaVar.d == 1;
                        long j2 = emaVar.c;
                        long j3 = emaVar.b;
                        emaVar.e(86400000 + jCurrentTimeMillis, location.getLatitude(), location.getLongitude());
                        long j4 = emaVar.c;
                        if (j2 == -1 || j3 == -1) {
                            j = jCurrentTimeMillis + 43200000;
                        } else {
                            if (jCurrentTimeMillis > j3) {
                                j2 = j4;
                            } else if (jCurrentTimeMillis > j2) {
                                j2 = j3;
                            }
                            j = j2 + 60000;
                        }
                        embVar.a = z;
                        embVar.b = j;
                    } else {
                        Log.i("TwilightManager", "Could not get last known location. This is probably because the app does not have any location permissions. Falling back to hardcoded sunrise/sunset values.");
                        int i = Calendar.getInstance().get(11);
                        if (i < 6 || i >= 22) {
                            z = true;
                        }
                    }
                    break;
                } else {
                    z = embVar.a;
                }
                return z ? 2 : 1;
        }
    }

    @Override // me.hd.wauxv.obf.hz
    public final void f() {
        switch (this.a) {
            case 0:
                this.b.by(true, true);
                break;
            default:
                this.b.by(true, true);
                break;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public hx(ic icVar, Context context) {
        super(icVar);
        this.b = icVar;
        this.c = (PowerManager) context.getApplicationContext().getSystemService("power");
    }
}

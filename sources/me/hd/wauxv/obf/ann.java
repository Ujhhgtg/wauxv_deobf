package me.hd.wauxv.obf;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.view.InputDevice;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class ann {
    public final Context a;
    public final ano b;
    public VelocityTracker c;
    public float d;
    public int e = -1;
    public int f = -1;
    public int g = -1;
    public final int[] h = { Integer.MAX_VALUE, 0 };

    public ann(Context context, ano anoVar) {
        this.a = context;
        this.b = anoVar;
    }

    /* JADX WARN: Found duplicated region for block: B:30:0x0079 */
    /* JADX WARN: Found duplicated region for block: B:51:0x00c0 */
    /* JADX WARN: Found duplicated region for block: B:83:0x0166 */
    public final void i(MotionEvent motionEvent, int i) {
        int i2;
        int i3;
        int scaledMinimumFlingVelocity;
        int scaledMaximumFlingVelocity;
        boolean z;
        float f;
        float yVelocity;
        long j;
        float f2;
        float fSqrt;
        float f3;
        int source = motionEvent.getSource();
        int deviceId = motionEvent.getDeviceId();
        int i4 = this.f;
        int[] iArr = this.h;
        if (i4 == source && this.g == deviceId && this.e == i) {
            z = false;
            i2 = 1;
            i3 = 0;
        } else {
            Context context = this.a;
            ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
            int deviceId2 = motionEvent.getDeviceId();
            int source2 = motionEvent.getSource();
            i2 = 1;
            int i5 = Build.VERSION.SDK_INT;
            i3 = 0;
            if (i5 >= 34) {
                scaledMinimumFlingVelocity = ba.f(viewConfiguration, deviceId2, i, source2);
            } else {
                InputDevice device = InputDevice.getDevice(deviceId2);
                if (device == null || device.getMotionRange(i, source2) == null) {
                    scaledMinimumFlingVelocity = Integer.MAX_VALUE;
                } else {
                    Resources resources = context.getResources();
                    int identifier = (source2 == 4194304 && i == 26)
                            ? resources.getIdentifier("config_viewMinRotaryEncoderFlingVelocity", "dimen", "android")
                            : -1;
                    Objects.requireNonNull(viewConfiguration);
                    if (identifier == -1) {
                        scaledMinimumFlingVelocity = viewConfiguration.getScaledMinimumFlingVelocity();
                    } else if (identifier == 0
                            || (scaledMinimumFlingVelocity = resources.getDimensionPixelSize(identifier)) < 0) {
                        scaledMinimumFlingVelocity = Integer.MAX_VALUE;
                    }
                }
            }
            iArr[0] = scaledMinimumFlingVelocity;
            int deviceId3 = motionEvent.getDeviceId();
            int source3 = motionEvent.getSource();
            if (i5 >= 34) {
                scaledMaximumFlingVelocity = ba.e(viewConfiguration, deviceId3, i, source3);
            } else {
                InputDevice device2 = InputDevice.getDevice(deviceId3);
                if (device2 == null || device2.getMotionRange(i, source3) == null) {
                    scaledMaximumFlingVelocity = Integer.MIN_VALUE;
                } else {
                    Resources resources2 = context.getResources();
                    int identifier2 = (source3 == 4194304 && i == 26)
                            ? resources2.getIdentifier("config_viewMaxRotaryEncoderFlingVelocity", "dimen", "android")
                            : -1;
                    Objects.requireNonNull(viewConfiguration);
                    if (identifier2 == -1) {
                        scaledMaximumFlingVelocity = viewConfiguration.getScaledMaximumFlingVelocity();
                    } else if (identifier2 == 0
                            || (scaledMaximumFlingVelocity = resources2.getDimensionPixelSize(identifier2)) < 0) {
                        scaledMaximumFlingVelocity = Integer.MIN_VALUE;
                    }
                }
            }
            iArr[1] = scaledMaximumFlingVelocity;
            this.f = source;
            this.g = deviceId;
            this.e = i;
            z = true;
        }
        if (iArr[i3] == Integer.MAX_VALUE) {
            VelocityTracker velocityTracker = this.c;
            if (velocityTracker != null) {
                velocityTracker.recycle();
                this.c = null;
                return;
            }
            return;
        }
        if (this.c == null) {
            this.c = VelocityTracker.obtain();
        }
        VelocityTracker velocityTracker2 = this.c;
        Map map = epn.a;
        velocityTracker2.addMovement(motionEvent);
        float f4 = 0.0f;
        int i6 = 20;
        if (Build.VERSION.SDK_INT < 34 && motionEvent.getSource() == 4194304) {
            Map map2 = epn.a;
            if (!map2.containsKey(velocityTracker2)) {
                map2.put(velocityTracker2, new epo());
            }
            epo epoVar = (epo) map2.get(velocityTracker2);
            long[] jArr = epoVar.b;
            long eventTime = motionEvent.getEventTime();
            if (epoVar.d != 0 && eventTime - jArr[epoVar.e] > 40) {
                epoVar.d = i3;
                epoVar.c = 0.0f;
            }
            int i7 = (epoVar.e + 1) % 20;
            epoVar.e = i7;
            int i8 = epoVar.d;
            if (i8 != 20) {
                epoVar.d = i8 + 1;
            }
            epoVar.a[i7] = motionEvent.getAxisValue(26);
            jArr[epoVar.e] = eventTime;
        }
        velocityTracker2.computeCurrentVelocity(1000, Float.MAX_VALUE);
        epo epoVar2 = (epo) epn.a.get(velocityTracker2);
        if (epoVar2 != null) {
            float[] fArr = epoVar2.a;
            long[] jArr2 = epoVar2.b;
            int i9 = epoVar2.d;
            if (i9 < 2) {
                f2 = Float.MAX_VALUE;
                fSqrt = 0.0f;
                f = 0.0f;
            } else {
                int i10 = epoVar2.e;
                int i11 = ((i10 + 20) - (i9 - 1)) % 20;
                long j2 = jArr2[i10];
                while (true) {
                    j = jArr2[i11];
                    if (j2 - j <= 100) {
                        break;
                    }
                    epoVar2.d--;
                    i11 = (i11 + 1) % 20;
                }
                int i12 = epoVar2.d;
                if (i12 < 2) {
                    f2 = Float.MAX_VALUE;
                    fSqrt = 0.0f;
                    f = 0.0f;
                } else if (i12 == 2) {
                    int i13 = (i11 + 1) % 20;
                    if (j == jArr2[i13]) {
                        f2 = Float.MAX_VALUE;
                        fSqrt = 0.0f;
                        f = 0.0f;
                    } else {
                        fSqrt = fArr[i13] / (r13 - j);
                        f2 = Float.MAX_VALUE;
                        f = 0.0f;
                    }
                } else {
                    f2 = Float.MAX_VALUE;
                    float fAbs = 0.0f;
                    int i14 = 0;
                    int i15 = 0;
                    while (true) {
                        if (i14 >= epoVar2.d - 1) {
                            break;
                        }
                        int i16 = i14 + i11;
                        long j3 = jArr2[i16 % 20];
                        int i17 = (i16 + 1) % i6;
                        if (jArr2[i17] == j3) {
                            f3 = f4;
                        } else {
                            i15++;
                            f3 = f4;
                            float fSqrt2 = (fAbs < f4 ? -1.0f : 1.0f) * ((float) Math.sqrt(Math.abs(fAbs) * 2.0f));
                            float f5 = fArr[i17] / (jArr2[i17] - j3);
                            fAbs += Math.abs(f5) * (f5 - fSqrt2);
                            if (i15 == i2) {
                                fAbs *= 0.5f;
                            }
                        }
                        i14++;
                        f4 = f3;
                        i6 = 20;
                        i2 = 1;
                    }
                    f = f4;
                    fSqrt = (fAbs < f ? -1.0f : 1.0f) * ((float) Math.sqrt(Math.abs(fAbs) * 2.0f));
                }
            }
            float f6 = fSqrt * 1000;
            epoVar2.c = f6;
            if (f6 < (-Math.abs(f2))) {
                epoVar2.c = -Math.abs(f2);
            } else if (epoVar2.c > Math.abs(f2)) {
                epoVar2.c = Math.abs(f2);
            }
        } else {
            f = 0.0f;
        }
        if (Build.VERSION.SDK_INT >= 34) {
            yVelocity = ba.tryGetClassByName(velocityTracker2, i);
        } else if (i == 0) {
            yVelocity = velocityTracker2.getXVelocity();
        } else if (i == 1) {
            yVelocity = velocityTracker2.getYVelocity();
        } else {
            epo epoVar3 = (epo) epn.a.get(velocityTracker2);
            yVelocity = (epoVar3 == null || i != 26) ? f : epoVar3.c;
        }
        ano anoVar = this.b;
        float f7 = anoVar.f() * yVelocity;
        float fSignum = Math.signum(f7);
        if (z || (fSignum != Math.signum(this.d) && fSignum != f)) {
            anoVar.g();
        }
        if (Math.abs(f7) < iArr[0]) {
            return;
        }
        float fMax = Math.max(-r1, Math.min(f7, iArr[1]));
        this.d = anoVar.e(fMax) ? fMax : f;
    }
}

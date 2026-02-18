package me.hd.wauxv.obf;

import android.icu.text.DateFormat;
import android.icu.text.DisplayContext;
import android.icu.util.TimeZone;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class cet implements Comparable, Parcelable {
    public static final Parcelable.Creator<cet> CREATOR = new cu(15);
    public final Calendar a;
    public final int b;
    public final int c;
    public final int d;
    public final int e;
    public final long f;
    public String g;

    public cet(Calendar calendar) {
        calendar.set(5, 1);
        Calendar calendarB = eoq.b(calendar);
        this.a = calendarB;
        this.b = calendarB.get(2);
        this.c = calendarB.get(1);
        this.d = calendarB.getMaximum(7);
        this.e = calendarB.getActualMaximum(5);
        this.f = calendarB.getTimeInMillis();
    }

    public static cet h(int i, int i2) {
        Calendar calendarD = eoq.d(null);
        calendarD.set(1, i);
        calendarD.set(2, i2);
        return new cet(calendarD);
    }

    public static cet i(long j) {
        Calendar calendarD = eoq.d(null);
        calendarD.setTimeInMillis(j);
        return new cet(calendarD);
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        return this.a.compareTo(((cet) obj).a);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof cet)) {
            return false;
        }
        cet cetVar = (cet) obj;
        return this.b == cetVar.b && this.c == cetVar.c;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.b), Integer.valueOf(this.c)});
    }

    public final String j() {
        if (this.g == null) {
            long timeInMillis = this.a.getTimeInMillis();
            Locale locale = Locale.getDefault();
            AtomicReference atomicReference = eoq.a;
            DateFormat instanceForSkeleton = DateFormat.getInstanceForSkeleton("yMMMM", locale);
            instanceForSkeleton.setTimeZone(TimeZone.getTimeZone("UTC"));
            instanceForSkeleton.setContext(DisplayContext.CAPITALIZATION_FOR_STANDALONE);
            this.g = instanceForSkeleton.format(new Date(timeInMillis));
        }
        return this.g;
    }

    public final int k(cet cetVar) {
        if (!(this.a instanceof GregorianCalendar)) {
            throw new IllegalArgumentException("Only Gregorian calendars are supported.");
        }
        return (cetVar.b - this.b) + ((cetVar.c - this.c) * 12);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.c);
        parcel.writeInt(this.b);
    }
}

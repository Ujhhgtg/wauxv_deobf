package me.hd.wauxv.obf;

import android.os.Handler;
import android.os.Looper;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class atf {
    public static final Object a = new Object();
    public static volatile atf b;
    public final ReentrantReadWriteLock c;
    public final kz d;
    public volatile int e;
    public final Handler f;
    public final ata g;
    public final ate h;
    public final nu i;
    public final int j;
    public final akm k;

    public atf(bbv bbvVar) {
        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
        this.c = reentrantReadWriteLock;
        this.e = 3;
        ate ateVar = (ate) bbvVar.b;
        this.h = ateVar;
        int i = bbvVar.a;
        this.j = i;
        this.k = (akm) bbvVar.c;
        this.f = new Handler(Looper.getMainLooper());
        this.d = new kz(0);
        this.i = new nu(23);
        ata ataVar = new ata(this);
        this.g = ataVar;
        reentrantReadWriteLock.writeLock().lock();
        if (i == 0) {
            try {
                this.e = 0;
            } catch (Throwable th) {
                this.c.writeLock().unlock();
                throw th;
            }
        }
        reentrantReadWriteLock.writeLock().unlock();
        if (m() == 0) {
            try {
                ateVar.c(new asz(ataVar));
            } catch (Throwable th2) {
                o(th2);
            }
        }
    }

    public static atf l() {
        atf atfVar;
        synchronized (a) {
            try {
                atfVar = b;
                if (!(atfVar != null)) {
                    throw new IllegalStateException("EmojiCompat is not initialized.\n\nYou must initialize EmojiCompat prior to referencing the EmojiCompat instance.\n\nThe most likely cause of this error is disabling the EmojiCompatInitializer\neither explicitly in AndroidManifest.xml, or by including\nandroidx.emoji2:emoji2-bundled.\n\nAutomatic initialization is typically performed by EmojiCompatInitializer. If\nyou are not expecting to initialize EmojiCompat manually in your application,\nplease check to ensure it has not been removed from your APK's manifest. You can\ndo this in Android Studio using Build > Analyze APK.\n\nIn the APK Analyzer, ensure that the startup entry for\nEmojiCompatInitializer and InitializationProvider is present in\n AndroidManifest.xml. If it is missing or contains tools:node=\"remove\", and you\nintend to use automatic configuration, verify:\n\n  1. Your application does not include emoji2-bundled\n  2. All modules do not contain an exclusion manifest rule for\n     EmojiCompatInitializer or InitializationProvider. For more information\n     about manifest exclusions see the documentation for the androidx startup\n     library.\n\nIf you intend to use emoji2-bundled, please call EmojiCompat.init. You can\nlearn more in the documentation for BundledEmojiCompatConfig.\n\nIf you intended to perform manual configuration, it is recommended that you call\nEmojiCompat.init immediately on application startup.\n\nIf you still cannot resolve this issue, please open a bug with your specific\nconfiguration to help improve error message.");
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return atfVar;
    }

    public final int m() {
        this.c.readLock().lock();
        try {
            return this.e;
        } finally {
            this.c.readLock().unlock();
        }
    }

    public final void n() {
        if (!(this.j == 1)) {
            throw new IllegalStateException("Set metadataLoadStrategy to LOAD_STRATEGY_MANUAL to execute manual loading");
        }
        if (m() == 1) {
            return;
        }
        this.c.writeLock().lock();
        try {
            if (this.e == 0) {
                this.c.writeLock().unlock();
                return;
            }
            this.e = 0;
            this.c.writeLock().unlock();
            ata ataVar = this.g;
            atf atfVar = ataVar.a;
            try {
                atfVar.h.c(new asz(ataVar));
            } catch (Throwable th) {
                atfVar.o(th);
            }
        } catch (Throwable th2) {
            this.c.writeLock().unlock();
            throw th2;
        }
    }

    public final void o(Throwable th) {
        ArrayList arrayList = new ArrayList();
        this.c.writeLock().lock();
        try {
            this.e = 2;
            arrayList.addAll(this.d);
            this.d.clear();
            this.c.writeLock().unlock();
            this.f.post(new np(arrayList, this.e, th));
        } catch (Throwable th2) {
            this.c.writeLock().unlock();
            throw th2;
        }
    }

    /* JADX WARN: Found duplicated region for block: B:52:0x009f A[Catch: all -> 0x0082, TryCatch #0 {all -> 0x0082, blocks: (B:32:0x005a, B:35:0x005f, B:37:0x0063, B:39:0x0070, B:46:0x008f, B:48:0x0099, B:50:0x009c, B:52:0x009f, B:54:0x00af, B:55:0x00b2), top: B:89:0x005a }] */
    /* JADX WARN: Found duplicated region for block: B:54:0x00af A[Catch: all -> 0x0082, TryCatch #0 {all -> 0x0082, blocks: (B:32:0x005a, B:35:0x005f, B:37:0x0063, B:39:0x0070, B:46:0x008f, B:48:0x0099, B:50:0x009c, B:52:0x009f, B:54:0x00af, B:55:0x00b2), top: B:89:0x005a }] */
    /* JADX WARN: Found duplicated region for block: B:61:0x00c7  */
    /* JADX WARN: Found duplicated region for block: B:80:0x0100  */
    /* JADX WARN: Found duplicated region for block: B:96:? A[SYNTHETIC] */
    /* JADX WARN: Found duplicated region for block: B:98:? A[RETURN, SYNTHETIC] */
    public final CharSequence p(int i, int i2, CharSequence charSequence) throws Throwable {
        Throwable th;
        CharSequence charSequence2;
        int i3;
        int i4;
        eml[] emlVarArr;
        int spanStart;
        if (!(m() == 1)) {
            throw new IllegalStateException("Not initialized yet");
        }
        if (i < 0) {
            throw new IllegalArgumentException("start cannot be negative");
        }
        if (i2 < 0) {
            throw new IllegalArgumentException("end cannot be negative");
        }
        cna.g("start should be <= than end", i <= i2);
        eny enyVar = null;
        if (charSequence == null) {
            return null;
        }
        cna.g("start should be < than charSequence length", i <= charSequence.length());
        cna.g("end should be < than charSequence length", i2 <= charSequence.length());
        if (charSequence.length() == 0 || i == i2) {
            return charSequence;
        }
        jx jxVar = this.g.b;
        jxVar.getClass();
        boolean z = charSequence instanceof dlm;
        if (z) {
            ((dlm) charSequence).c();
        }
        if (z) {
            enyVar = new eny((Spannable) charSequence);
            if (enyVar != null) {
                for (eml emlVar : emlVarArr) {
                    spanStart = enyVar.b.getSpanStart(emlVar);
                    int spanEnd = enyVar.b.getSpanEnd(emlVar);
                    if (spanStart != i2) {
                        enyVar.removeSpan(emlVar);
                    }
                    i = Math.min(spanStart, i);
                    i2 = Math.max(spanEnd, i2);
                }
            }
            i3 = i;
            i4 = i2;
            if (i3 != i4) {
                charSequence2 = charSequence;
                if (!z) {
                    return charSequence2;
                }
            } else {
                charSequence2 = charSequence;
                if (!z) {
                    return charSequence2;
                }
            }
            ((dlm) charSequence2).d();
            return charSequence2;
        }
        try {
            if (charSequence instanceof Spannable) {
                try {
                    enyVar = new eny((Spannable) charSequence);
                } catch (Throwable th2) {
                    th = th2;
                    charSequence2 = charSequence;
                    th = th;
                    if (!z) {
                        throw th;
                    }
                    ((dlm) charSequence2).d();
                    throw th;
                }
            } else if ((charSequence instanceof Spanned) && ((Spanned) charSequence).nextSpanTransition(i - 1, i2 + 1, eml.class) <= i2) {
                enyVar = new eny();
                enyVar.a = false;
                enyVar.b = new SpannableString(charSequence);
            }
            if (enyVar != null && (emlVarArr = (eml[]) enyVar.b.getSpans(i, i2, eml.class)) != null && emlVarArr.length > 0) {
                while (i < r5) {
                    spanStart = enyVar.b.getSpanStart(emlVar);
                    int spanEnd2 = enyVar.b.getSpanEnd(emlVar);
                    if (spanStart != i2) {
                        enyVar.removeSpan(emlVar);
                    }
                    i = Math.min(spanStart, i);
                    i2 = Math.max(spanEnd2, i2);
                }
            }
            i3 = i;
            i4 = i2;
            if (i3 != i4 || i3 >= charSequence.length()) {
                charSequence2 = charSequence;
                if (!z) {
                    return charSequence2;
                }
            } else {
                charSequence2 = charSequence;
                try {
                    eny enyVar2 = (eny) jxVar.ac(charSequence2, i3, i4, Integer.MAX_VALUE, false, new io(enyVar, 17, (nu) jxVar.e));
                    if (enyVar2 != null) {
                        Spannable spannable = enyVar2.b;
                        if (z) {
                            ((dlm) charSequence2).d();
                        }
                        return spannable;
                    }
                    if (!z) {
                        return charSequence2;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    th = th;
                    if (!z) {
                        throw th;
                    }
                    ((dlm) charSequence2).d();
                    throw th;
                }
            }
            ((dlm) charSequence2).d();
            return charSequence2;
        } catch (Throwable th4) {
            th = th4;
            charSequence2 = charSequence;
        }
        if (!z) {
            throw th;
        }
        ((dlm) charSequence2).d();
        throw th;
    }

    public final void q(atd atdVar) {
        cna.j(atdVar, "initCallback cannot be null");
        this.c.writeLock().lock();
        try {
            if (this.e == 1 || this.e == 2) {
                this.f.post(new np(Arrays.asList(atdVar), this.e, (Throwable) null));
            } else {
                this.d.add(atdVar);
            }
        } finally {
            this.c.writeLock().unlock();
        }
    }
}

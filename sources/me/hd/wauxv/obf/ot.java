package me.hd.wauxv.obf;

import android.text.SpannableStringBuilder;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class ot {
    public static final String a;
    public static final String b;
    public static final ot c;
    public static final ot d;
    public final boolean e;

    static {
        cxc cxcVar = dqi.c;
        a = Character.toString((char) 8206);
        b = Character.toString((char) 8207);
        c = new ot(false);
        d = new ot(true);
    }

    public ot(boolean z) {
        cxc cxcVar = dqi.a;
        this.e = z;
    }

    public static int f(CharSequence charSequence) {
        byte directionality;
        os osVar = new os(charSequence);
        osVar.d = 0;
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (true) {
            int i4 = osVar.d;
            if (i4 < osVar.c && i == 0) {
                CharSequence charSequence2 = osVar.b;
                char cCharAt = charSequence2.charAt(i4);
                osVar.e = cCharAt;
                if (Character.isHighSurrogate(cCharAt)) {
                    int iCodePointAt = Character.codePointAt(charSequence2, osVar.d);
                    osVar.d = Character.charCount(iCodePointAt) + osVar.d;
                    directionality = Character.getDirectionality(iCodePointAt);
                } else {
                    osVar.d++;
                    char c2 = osVar.e;
                    directionality = c2 < 1792 ? os.a[c2] : Character.getDirectionality(c2);
                }
                if (directionality != 0) {
                    if (directionality == 1 || directionality == 2) {
                        if (i3 == 0) {
                            return 1;
                        }
                    } else if (directionality != 9) {
                        switch (directionality) {
                            case 14:
                            case 15:
                                i3++;
                                i2 = -1;
                                continue;
                            case 16:
                            case 17:
                                i3++;
                                i2 = 1;
                                continue;
                            case 18:
                                i3--;
                                i2 = 0;
                                continue;
                        }
                    }
                } else if (i3 == 0) {
                    return -1;
                }
                i = i3;
            }
        }
        if (i != 0) {
            if (i2 == 0) {
                while (osVar.d > 0) {
                    switch (osVar.f()) {
                        case 14:
                        case 15:
                            if (i == i3) {
                                return -1;
                            }
                            i3--;
                            break;
                        case 16:
                        case 17:
                            if (i == i3) {
                                return 1;
                            }
                            i3--;
                            break;
                        case 18:
                            i3++;
                            break;
                        default:
                            break;
                    }
                }
            } else {
                return i2;
            }
        }
        return 0;
    }

    public static int g(CharSequence charSequence) {
        os osVar = new os(charSequence);
        osVar.d = osVar.c;
        int i = 0;
        while (true) {
            int i2 = i;
            while (osVar.d > 0) {
                byte bF = osVar.f();
                if (bF == 0) {
                    if (i == 0) {
                        return -1;
                    }
                    if (i2 == 0) {
                    }
                } else if (bF == 1 || bF == 2) {
                    if (i == 0) {
                        return 1;
                    }
                    if (i2 == 0) {
                    }
                } else if (bF != 9) {
                    switch (bF) {
                        case 14:
                        case 15:
                            if (i2 == i) {
                                return -1;
                            }
                            i--;
                            break;
                        case 16:
                        case 17:
                            if (i2 == i) {
                                return 1;
                            }
                            i--;
                            break;
                        case 18:
                            i++;
                            break;
                        default:
                            if (i2 != 0) {
                            }
                            break;
                    }
                } else {
                    continue;
                }
            }
            return 0;
        }
    }

    public final SpannableStringBuilder h(CharSequence charSequence) {
        cxc cxcVar = dqi.c;
        if (charSequence == null) {
            return null;
        }
        boolean zK = cxcVar.k(charSequence.length(), charSequence);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        boolean zK2 = (zK ? dqi.b : dqi.a).k(charSequence.length(), charSequence);
        String str = "";
        String str2 = b;
        String str3 = a;
        boolean z = this.e;
        spannableStringBuilder.append((CharSequence) ((z || !(zK2 || f(charSequence) == 1)) ? (!z || (zK2 && f(charSequence) != -1)) ? "" : str2 : str3));
        if (zK != z) {
            spannableStringBuilder.append(zK ? (char) 8235 : (char) 8234);
            spannableStringBuilder.append(charSequence);
            spannableStringBuilder.append((char) 8236);
        } else {
            spannableStringBuilder.append(charSequence);
        }
        boolean zK3 = (zK ? dqi.b : dqi.a).k(charSequence.length(), charSequence);
        if (!z && (zK3 || g(charSequence) == 1)) {
            str = str3;
        } else if (z && (!zK3 || g(charSequence) == -1)) {
            str = str2;
        }
        spannableStringBuilder.append((CharSequence) str);
        return spannableStringBuilder;
    }
}

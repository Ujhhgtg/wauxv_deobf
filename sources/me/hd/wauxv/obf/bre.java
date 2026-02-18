package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class bre {
    public static final ek a;
    public static final String[] b = {"abstract", "assert", "boolean", "byte", "char", "class", "do", "double", "final", "float", "for", "if", "int", "long", "new", "public", "private", "protected", "package", "return", "static", "short", "super", "switch", "else", "volatile", "synchronized", "strictfp", "goto", "continue", "break", "transient", "void", "try", "catch", "finally", "while", "case", "default", "const", "enum", "extends", "implements", "import", "instanceof", "interface", "native", "this", "throw", "throws", "true", "false", "null", "var", "sealed", "permits"};
    public CharSequence c;
    public int d;
    public int e;
    public int f;

    static {
        ekk[] ekkVarArr = {ekk.an, ekk.ao, ekk.ap, ekk.aq, ekk.ar, ekk.as, ekk.at, ekk.au, ekk.av, ekk.aw, ekk.ax, ekk.ay, ekk.az, ekk.ba, ekk.bb, ekk.bc, ekk.bd, ekk.be, ekk.bf, ekk.bg, ekk.bh, ekk.bi, ekk.bj, ekk.bk, ekk.bl, ekk.bm, ekk.bn, ekk.bo, ekk.bp, ekk.bq, ekk.br, ekk.bs, ekk.bt, ekk.bu, ekk.bv, ekk.bw, ekk.bx, ekk.by, ekk.bz, ekk.ca, ekk.cb, ekk.cc, ekk.cd, ekk.ce, ekk.cf, ekk.cg, ekk.ch, ekk.ci, ekk.cj, ekk.ck, ekk.cm, ekk.cn, ekk.co, ekk.ak, ekk.al, ekk.am};
        a = new ek((byte) 0, 13);
        int i = 0;
        while (true) {
            String[] strArr = b;
            if (i >= strArr.length) {
                return;
            }
            ek ekVar = a;
            String str = strArr[i];
            ekk ekkVar = ekkVarArr[i];
            ekVar.getClass();
            ekVar.c = Math.max(str.length(), ekVar.c);
            ek.f((but) ekVar.d, str, 0, str.length(), ekkVar);
            i++;
        }
    }

    public bre(String str) {
        if (str == null) {
            throw new IllegalArgumentException("src can not be null");
        }
        this.c = str;
        this.f = 0;
        this.d = str.length();
    }

    public static boolean g(char c) {
        if (c >= '0' && c <= '9') {
            return true;
        }
        if (c < 'A' || c > 'F') {
            return c >= 'a' && c <= 'f';
        }
        return true;
    }

    public final char h() {
        return this.c.charAt(this.e + this.f);
    }

    public final ekk i() {
        char cCharAt;
        char cCharAt2;
        char cCharAt3;
        boolean z;
        char cH;
        Object obj;
        int i = this.e + this.f;
        this.e = i;
        if (i >= this.d) {
            return ekk.d;
        }
        char cCharAt4 = this.c.charAt(i);
        this.f = 1;
        ekk ekkVar = ekk.b;
        if (cCharAt4 != '\n') {
            if (cCharAt4 != '\r') {
                if (cCharAt4 == '\t' || cCharAt4 == ' ' || cCharAt4 == '\f' || cCharAt4 == '\n' || cCharAt4 == '\r') {
                    while (true) {
                        int i2 = this.e + this.f;
                        if (i2 >= this.d || (!((cCharAt = this.c.charAt(i2)) == '\t' || cCharAt == ' ' || cCharAt == '\f' || cCharAt == '\n' || cCharAt == '\r') || cCharAt == '\r' || cCharAt == '\n')) {
                            break;
                        }
                        this.f++;
                    }
                    return ekk.a;
                }
                if (cib.c(cib.a, cCharAt4)) {
                    but butVar = (but) ((but) ((but) a.d).b).n(cCharAt4);
                    while (true) {
                        int i3 = this.e + this.f;
                        if (i3 >= this.d) {
                            break;
                        }
                        char cCharAt5 = this.c.charAt(i3);
                        if (!cib.c(cib.b, cCharAt5)) {
                            break;
                        }
                        this.f++;
                        butVar = butVar == null ? null : (but) ((but) butVar.b).n(cCharAt5);
                    }
                    return (butVar == null || (obj = butVar.c) == null) ? ekk.j : (ekk) obj;
                }
                if (cCharAt4 >= '0' && cCharAt4 <= '9') {
                    int i4 = this.e;
                    int i5 = this.f + i4;
                    int i6 = this.d;
                    ekk ekkVar2 = ekk.k;
                    if (i5 != i6) {
                        if (this.c.charAt(i4) == '0') {
                            if (h() == 'x') {
                                this.f++;
                            }
                            z = true;
                        } else {
                            z = false;
                        }
                        while (this.e + this.f < this.d && g(h())) {
                            this.f++;
                        }
                        if (this.e + this.f != this.d) {
                            char cH2 = h();
                            ekk ekkVar3 = ekk.aj;
                            if (cH2 == '.') {
                                if (!z) {
                                    int i7 = this.f + 1;
                                    this.f = i7;
                                    if (this.e + i7 != this.d) {
                                        while (this.e + this.f < this.d && g(h())) {
                                            this.f++;
                                        }
                                        if (this.e + this.f != this.d) {
                                            char cH3 = h();
                                            if (cH3 != 'e' && cH3 != 'E') {
                                                if (cH3 != 'f') {
                                                }
                                                this.f++;
                                                return ekkVar3;
                                            }
                                            int i8 = this.f + 1;
                                            this.f = i8;
                                            if (this.e + i8 != this.d) {
                                                if (h() == '-' || h() == '+') {
                                                    this.f++;
                                                }
                                                while (this.e + this.f < this.d && (cH = h()) >= '0' && cH <= '9') {
                                                    this.f++;
                                                }
                                                if (this.e + this.f != this.d) {
                                                    cH3 = h();
                                                    if (cH3 != 'f' || cH3 == 'F' || cH3 == 'D' || cH3 == 'd') {
                                                        this.f++;
                                                        return ekkVar3;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                    return ekkVar3;
                                }
                            } else {
                                if (cH2 == 'l' || cH2 == 'L') {
                                    this.f++;
                                    return ekkVar2;
                                }
                                if (cH2 == 'F' || cH2 == 'f' || cH2 == 'D' || cH2 == 'd') {
                                    this.f++;
                                    return ekkVar3;
                                }
                            }
                        }
                    }
                    return ekkVar2;
                }
                if (cCharAt4 == ';') {
                    return ekk.v;
                }
                if (cCharAt4 == '(') {
                    return ekk.p;
                }
                if (cCharAt4 == ')') {
                    return ekk.q;
                }
                if (cCharAt4 == ':') {
                    return ekk.ad;
                }
                if (cCharAt4 == '<') {
                    return ekk.z;
                }
                if (cCharAt4 == '>') {
                    return ekk.y;
                }
                if (cCharAt4 == '!') {
                    return ekk.aa;
                }
                if (cCharAt4 == '\"') {
                    if (this.e + this.f != this.d) {
                        while (true) {
                            int i9 = this.e + this.f;
                            if (i9 >= this.d || (cCharAt2 = this.c.charAt(i9)) == '\"') {
                                int i10 = this.e;
                                int i11 = this.f;
                                if (i10 + i11 >= this.d) {
                                    break;
                                }
                                this.f = i11 + 1;
                                break;
                            }
                            if (cCharAt2 == '\\') {
                                this.f++;
                                j();
                            } else {
                                if (cCharAt2 == '\n') {
                                    break;
                                }
                                this.f++;
                            }
                        }
                    }
                    return ekk.n;
                }
                if (cCharAt4 == '=') {
                    return ekk.x;
                }
                if (cCharAt4 == '[') {
                    return ekk.t;
                }
                char c = '?';
                if (cCharAt4 == '?') {
                    return ekk.ac;
                }
                if (cCharAt4 == '@') {
                    return ekk.cl;
                }
                if (cCharAt4 == ']') {
                    return ekk.u;
                }
                if (cCharAt4 == '^') {
                    return ekk.ah;
                }
                switch (cCharAt4) {
                    case '%':
                        return ekk.ai;
                    case '&':
                        return ekk.ae;
                    case '\'':
                        if (this.e + this.f != this.d) {
                            while (true) {
                                int i12 = this.e + this.f;
                                if (i12 >= this.d || (cCharAt3 = this.c.charAt(i12)) == '\'') {
                                    int i13 = this.e;
                                    int i14 = this.f;
                                    if (i13 + i14 != this.d) {
                                        this.f = i14 + 1;
                                    }
                                } else if (cCharAt3 == '\\') {
                                    this.f++;
                                    j();
                                } else if (cCharAt3 != '\n') {
                                    this.f++;
                                }
                            }
                        }
                        return ekk.o;
                    default:
                        switch (cCharAt4) {
                            case '*':
                                return ekk.i;
                            case '+':
                                return ekk.ag;
                            case ',':
                                return ekk.w;
                            case '-':
                                return ekk.m;
                            case '.':
                                return ekk.l;
                            case '/':
                                if (this.e + 1 != this.d) {
                                    char cH4 = h();
                                    if (cH4 == '/') {
                                        this.f++;
                                        while (this.e + this.f < this.d && h() != '\n') {
                                            this.f++;
                                        }
                                        return ekk.g;
                                    }
                                    if (cH4 == '*') {
                                        this.f++;
                                        while (this.e + this.f < this.d) {
                                            char cH5 = h();
                                            if (cH5 == '/' && c == '*') {
                                                this.f++;
                                                return ekk.e;
                                            }
                                            this.f++;
                                            c = cH5;
                                        }
                                        return ekk.f;
                                    }
                                }
                                return ekk.h;
                            default:
                                switch (cCharAt4) {
                                    case '{':
                                        return ekk.r;
                                    case '|':
                                        return ekk.af;
                                    case '}':
                                        return ekk.s;
                                    case '~':
                                        return ekk.ab;
                                    default:
                                        return ekk.c;
                                }
                        }
                }
            }
            int i15 = this.e + 1;
            if (i15 < this.d && this.c.charAt(i15) == '\n') {
                this.f++;
            }
        }
        return ekkVar;
    }

    public final void j() {
        int i;
        if (this.e + this.f == this.d) {
            return;
        }
        char cH = h();
        if (cH == '\\' || cH == 't' || cH == 'f' || cH == 'n' || cH == 'r' || cH == '0' || cH == '\"' || cH == '\'' || cH == 'b') {
            this.f++;
            return;
        }
        if (cH == 'u') {
            this.f++;
            for (int i2 = 0; i2 < 4 && (i = this.e + this.f) < this.d && g(this.c.charAt(i)); i2++) {
                this.f++;
            }
        }
    }
}

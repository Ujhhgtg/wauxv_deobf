package com.umeng.analytics.pro;

import com.umeng.analytics.pro.da;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public class ck {
    private final dg a;
    private final dt b;

    public ck() {
        this(new da.a());
    }

    private db j(byte[] bArr, co coVar, co... coVarArr) {
        this.b.a(bArr);
        int length = coVarArr.length + 1;
        co[] coVarArr2 = new co[length];
        int i = 0;
        coVarArr2[0] = coVar;
        int i2 = 0;
        while (i2 < coVarArr.length) {
            int i3 = i2 + 1;
            coVarArr2[i3] = coVarArr[i2];
            i2 = i3;
        }
        this.a.j();
        db dbVarL = null;
        while (i < length) {
            dbVarL = this.a.l();
            if (dbVarL.b == 0 || dbVarL.c > coVarArr2[i].a()) {
                return null;
            }
            if (dbVarL.c != coVarArr2[i].a()) {
                dj.a(this.a, dbVarL.b);
                this.a.m();
            } else {
                i++;
                if (i < length) {
                    this.a.j();
                }
            }
        }
        return dbVarL;
    }

    public void a(ch chVar, byte[] bArr) {
        try {
            this.b.a(bArr);
            chVar.read(this.a);
        } finally {
            this.b.e();
            this.a.B();
        }
    }

    public Byte b(byte[] bArr, co coVar, co... coVarArr) {
        return (Byte) a((byte) 3, bArr, coVar, coVarArr);
    }

    public Double c(byte[] bArr, co coVar, co... coVarArr) {
        return (Double) a((byte) 4, bArr, coVar, coVarArr);
    }

    public Short d(byte[] bArr, co coVar, co... coVarArr) {
        return (Short) a((byte) 6, bArr, coVar, coVarArr);
    }

    public Integer e(byte[] bArr, co coVar, co... coVarArr) {
        return (Integer) a((byte) 8, bArr, coVar, coVarArr);
    }

    public Long f(byte[] bArr, co coVar, co... coVarArr) {
        return (Long) a((byte) 10, bArr, coVar, coVarArr);
    }

    public String g(byte[] bArr, co coVar, co... coVarArr) {
        return (String) a((byte) 11, bArr, coVar, coVarArr);
    }

    public ByteBuffer h(byte[] bArr, co coVar, co... coVarArr) {
        return (ByteBuffer) a((byte) 100, bArr, coVar, coVarArr);
    }

    public Short i(byte[] bArr, co coVar, co... coVarArr) {
        try {
            try {
                if (j(bArr, coVar, coVarArr) == null) {
                    this.b.e();
                    this.a.B();
                    return null;
                }
                this.a.j();
                Short shValueOf = Short.valueOf(this.a.l().c);
                this.b.e();
                this.a.B();
                return shValueOf;
            } catch (Exception e) {
                throw new cn(e);
            }
        } catch (Throwable th) {
            this.b.e();
            this.a.B();
            throw th;
        }
    }

    public ck(di diVar) {
        dt dtVar = new dt();
        this.b = dtVar;
        this.a = diVar.a(dtVar);
    }

    public void a(ch chVar, String str, String str2) {
        try {
            try {
                a(chVar, str.getBytes(str2));
                this.a.B();
            } catch (UnsupportedEncodingException unused) {
                throw new cn("JVM DOES NOT SUPPORT ENCODING: " + str2);
            }
        } catch (Throwable th) {
            this.a.B();
            throw th;
        }
    }

    public void a(ch chVar, byte[] bArr, co coVar, co... coVarArr) {
        try {
            try {
                if (j(bArr, coVar, coVarArr) != null) {
                    chVar.read(this.a);
                }
                this.b.e();
                this.a.B();
            } catch (Exception e) {
                throw new cn(e);
            }
        } catch (Throwable th) {
            this.b.e();
            this.a.B();
            throw th;
        }
    }

    public Boolean a(byte[] bArr, co coVar, co... coVarArr) {
        return (Boolean) a((byte) 2, bArr, coVar, coVarArr);
    }

    private Object a(byte b, byte[] bArr, co coVar, co... coVarArr) {
        try {
            try {
                db dbVarJ = j(bArr, coVar, coVarArr);
                if (dbVarJ != null) {
                    if (b != 2) {
                        if (b != 3) {
                            if (b != 4) {
                                if (b != 6) {
                                    if (b != 8) {
                                        if (b != 100) {
                                            if (b != 10) {
                                                if (b == 11 && dbVarJ.b == 11) {
                                                    String strZ = this.a.z();
                                                    this.b.e();
                                                    this.a.B();
                                                    return strZ;
                                                }
                                            } else if (dbVarJ.b == 10) {
                                                Long lValueOf = Long.valueOf(this.a.x());
                                                this.b.e();
                                                this.a.B();
                                                return lValueOf;
                                            }
                                        } else if (dbVarJ.b == 11) {
                                            ByteBuffer byteBufferA = this.a.A();
                                            this.b.e();
                                            this.a.B();
                                            return byteBufferA;
                                        }
                                    } else if (dbVarJ.b == 8) {
                                        Integer numValueOf = Integer.valueOf(this.a.w());
                                        this.b.e();
                                        this.a.B();
                                        return numValueOf;
                                    }
                                } else if (dbVarJ.b == 6) {
                                    Short shValueOf = Short.valueOf(this.a.v());
                                    this.b.e();
                                    this.a.B();
                                    return shValueOf;
                                }
                            } else if (dbVarJ.b == 4) {
                                Double dValueOf = Double.valueOf(this.a.y());
                                this.b.e();
                                this.a.B();
                                return dValueOf;
                            }
                        } else if (dbVarJ.b == 3) {
                            Byte bValueOf = Byte.valueOf(this.a.u());
                            this.b.e();
                            this.a.B();
                            return bValueOf;
                        }
                    } else if (dbVarJ.b == 2) {
                        Boolean boolValueOf = Boolean.valueOf(this.a.t());
                        this.b.e();
                        this.a.B();
                        return boolValueOf;
                    }
                }
                this.b.e();
                this.a.B();
                return null;
            } catch (Exception e) {
                throw new cn(e);
            }
        } catch (Throwable th) {
            this.b.e();
            this.a.B();
            throw th;
        }
    }

    public void a(ch chVar, String str) {
        a(chVar, str.getBytes());
    }
}

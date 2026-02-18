package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class bpz implements bqa {
    public long a;
    public int b;

    @Override // me.hd.wauxv.obf.bqa
    public bpw toInstant() {
        long j = this.a;
        bpw bpwVar = bpw.a;
        bpw bpwVar2 = bpw.a;
        if (j >= bpwVar2.c) {
            bpw bpwVar3 = bpw.b;
            if (j <= bpwVar3.c) {
                long j2 = this.b;
                long j3 = j2 / 1000000000;
                if ((j2 ^ 1000000000) < 0 && j3 * 1000000000 != j2) {
                    j3--;
                }
                long j4 = j + j3;
                if ((j ^ j4) < 0 && (j3 ^ j) >= 0) {
                    return j > 0 ? bpwVar3 : bpwVar2;
                }
                if (j4 >= -31557014167219200L) {
                    if (j4 <= 31556889864403199L) {
                        long j5 = j2 % 1000000000;
                        return new bpw(j4, (int) (j5 + ((((j5 ^ 1000000000) & ((-j5) | j5)) >> 63) & 1000000000)));
                    }
                }
            }
        }
        throw new bpx("The parsed date is outside the range representable by Instant (Unix epoch second " + j + ')');
    }
}

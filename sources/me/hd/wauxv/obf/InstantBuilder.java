package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class InstantBuilder implements IConvertableToInstant {
    public long seconds;
    public int nanoAdjustment;

    @Override // me.hd.wauxv.obf.bqa
    public Instant toInstant() {
        long j = this.seconds;
        Instant instantVar = Instant.a;
        Instant instantVar2 = Instant.a;
        if (j >= instantVar2.c) {
            Instant instantVar3 = Instant.b;
            if (j <= instantVar3.c) {
                long j2 = this.nanoAdjustment;
                long j3 = j2 / 1000000000;
                if ((j2 ^ 1000000000) < 0 && j3 * 1000000000 != j2) {
                    j3--;
                }
                long j4 = j + j3;
                if ((j ^ j4) < 0 && (j3 ^ j) >= 0) {
                    return j > 0 ? instantVar3 : instantVar2;
                }
                if (j4 >= -31557014167219200L) {
                    if (j4 <= 31556889864403199L) {
                        long j5 = j2 % 1000000000;
                        return new Instant(j4, (int) (j5 + ((((j5 ^ 1000000000) & ((-j5) | j5)) >> 63) & 1000000000)));
                    }
                }
            }
        }
        throw new bpx("The parsed date is outside the range representable by Instant (Unix epoch second " + j + ')');
    }
}

package me.hd.wauxv.obf;

import java.nio.ByteBuffer;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class amh implements Iterator {
    public final amj a;
    public int b = 0;
    public final /* synthetic */ amk c;

    public amh(amk amkVar) {
        this.c = amkVar;
        this.a = amkVar.n(amkVar.c.g.c);
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.b < this.c.c.g.b;
    }

    @Override // java.util.Iterator
    public final Object next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        this.b++;
        amj amjVar = this.a;
        ByteBuffer byteBuffer = amjVar.b;
        return new yx(amjVar.d, byteBuffer.position(), byteBuffer.getInt(), byteBuffer.getInt(), byteBuffer.getInt(), byteBuffer.getInt(), byteBuffer.getInt(), byteBuffer.getInt(), byteBuffer.getInt(), byteBuffer.getInt());
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}

package me.hd.wauxv.obf;

import android.view.View;
import android.view.ViewGroup;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public class z implements Iterator, IEmpty {
    public final /* synthetic */ int a;
    public int b;
    public final Object c;

    public /* synthetic */ z(Object obj, int i) {
        this.a = i;
        this.c = obj;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        switch (this.a) {
            case 0:
                return this.b < ((KotlinAbstractReadonlyList) this.c).a();
            case 1:
                return this.b < ((Object[]) this.c).length;
            case 2:
                return this.b > 0;
            case 3:
                return this.b < ((dlo) this.c).i();
            case 4:
                return this.b < ((byte[]) this.c).length;
            case 5:
                return this.b < ((int[]) this.c).length;
            case 6:
                return this.b < ((long[]) this.c).length;
            case 7:
                return this.b < ((short[]) this.c).length;
            default:
                return this.b < ((ViewGroup) this.c).getChildCount();
        }
    }

    @Override // java.util.Iterator
    public final Object next() {
        switch (this.a) {
            case 0:
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                KotlinAbstractReadonlyList kotlinAbstractReadonlyListVar = (KotlinAbstractReadonlyList) this.c;
                int i = this.b;
                this.b = i + 1;
                return kotlinAbstractReadonlyListVar.get(i);
            case 1:
                try {
                    Object[] objArr = (Object[]) this.c;
                    int i2 = this.b;
                    this.b = i2 + 1;
                    return objArr[i2];
                } catch (ArrayIndexOutOfBoundsException e) {
                    this.b--;
                    throw new NoSuchElementException(e.getMessage());
                }
            case 2:
                dfx dfxVar = (dfx) this.c;
                int i3 = dfxVar.i();
                int i4 = this.b;
                this.b = i4 - 1;
                return dfxVar.l(i3 - i4);
            case 3:
                dlo dloVar = (dlo) this.c;
                int i5 = this.b;
                this.b = i5 + 1;
                return dloVar.j(i5);
            case 4:
                int i6 = this.b;
                byte[] bArr = (byte[]) this.c;
                if (i6 >= bArr.length) {
                    throw new NoSuchElementException(String.valueOf(this.b));
                }
                this.b = i6 + 1;
                return new emp(bArr[i6]);
            case 5:
                int i7 = this.b;
                int[] iArr = (int[]) this.c;
                if (i7 >= iArr.length) {
                    throw new NoSuchElementException(String.valueOf(this.b));
                }
                this.b = i7 + 1;
                return new emu(iArr[i7]);
            case 6:
                int i8 = this.b;
                long[] jArr = (long[]) this.c;
                if (i8 >= jArr.length) {
                    throw new NoSuchElementException(String.valueOf(this.b));
                }
                this.b = i8 + 1;
                return new emz(jArr[i8]);
            case 7:
                int i9 = this.b;
                short[] sArr = (short[]) this.c;
                if (i9 >= sArr.length) {
                    throw new NoSuchElementException(String.valueOf(this.b));
                }
                this.b = i9 + 1;
                return new ene(sArr[i9]);
            default:
                ViewGroup viewGroup = (ViewGroup) this.c;
                int i10 = this.b;
                this.b = i10 + 1;
                View childAt = viewGroup.getChildAt(i10);
                if (childAt != null) {
                    return childAt;
                }
                throw new IndexOutOfBoundsException();
        }
    }

    @Override // java.util.Iterator
    public final void remove() {
        switch (this.a) {
            case 0:
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
            case 1:
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
            case 2:
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
            case 3:
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
            case 4:
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
            case 5:
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
            case 6:
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
            case 7:
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
            default:
                ViewGroup viewGroup = (ViewGroup) this.c;
                int i = this.b - 1;
                this.b = i;
                viewGroup.removeViewAt(i);
                return;
        }
    }

    public z(Object[] objArr) {
        this.a = 1;
        throwIfVar1IsNull(objArr, "array");
        this.c = objArr;
    }

    public z(dfx dfxVar) {
        this.a = 2;
        this.c = dfxVar;
        this.b = dfxVar.i();
    }
}

package bsh;

import java.io.IOException;
import me.hd.wauxv.obf.yg;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractCharStream implements CharStream {
    public static final int DEFAULT_BUF_SIZE = 4096;
    protected int available;
    protected char[] buffer;
    protected int bufpos;
    protected int bufsize;
    protected int inBuf;
    private int[] m_aBufColumn;
    private int[] m_aBufLine;
    private boolean m_bPrevCharIsCR;
    private boolean m_bPrevCharIsLF;
    private int m_nColumnNo;
    private int m_nLineNo;
    protected int maxNextCharInd;
    protected int tokenBegin;
    private int m_nTabSize = 1;
    private boolean m_bTrackLineColumn = true;

    public AbstractCharStream(int i, int i2, int i3) {
        reInit(i, i2, i3);
    }

    public static final int hexval(char c) throws IOException {
        switch (c) {
            case '0':
                return 0;
            case '1':
                return 1;
            case '2':
                return 2;
            case '3':
                return 3;
            case '4':
                return 4;
            case '5':
                return 5;
            case '6':
                return 6;
            case '7':
                return 7;
            case '8':
                return 8;
            case '9':
                return 9;
            default:
                switch (c) {
                    case 'A':
                        return 10;
                    case 'B':
                        return 11;
                    case 'C':
                        return 12;
                    case 'D':
                        return 13;
                    case 'E':
                        return 14;
                    case 'F':
                        return 15;
                    default:
                        switch (c) {
                            case 'a':
                                return 10;
                            case 'b':
                                return 11;
                            case 'c':
                                return 12;
                            case 'd':
                                return 13;
                            case 'e':
                                return 14;
                            case 'f':
                                return 15;
                            default:
                                throw new IOException("Invalid hex char '" + c + "' (=" + ((int) c) + ") provided!");
                        }
                }
        }
    }

    public final void adjustBeginLineColumn(int i, int i2) {
        int i3;
        int i4 = this.tokenBegin;
        int i5 = this.bufpos;
        if (i5 >= i4) {
            i3 = (i5 - i4) + this.inBuf + 1;
        } else {
            i3 = this.inBuf + (this.bufsize - i4) + i5 + 1;
        }
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        while (i6 < i3) {
            int[] iArr = this.m_aBufLine;
            int i9 = this.bufsize;
            int i10 = i4 % i9;
            i4++;
            int i11 = i4 % i9;
            if (iArr[i10] != iArr[i11]) {
                i7 = i10;
                break;
            }
            iArr[i10] = i;
            int[] iArr2 = this.m_aBufColumn;
            int i12 = (iArr2[i11] + i8) - iArr2[i10];
            iArr2[i10] = i8 + i2;
            i6++;
            i8 = i12;
            i7 = i10;
        }
        if (i6 < i3) {
            int i13 = i + 1;
            this.m_aBufLine[i7] = i;
            this.m_aBufColumn[i7] = i2 + i8;
            while (true) {
                int i14 = i6 + 1;
                if (i6 >= i3) {
                    break;
                }
                int[] iArr3 = this.m_aBufLine;
                int i15 = this.bufsize;
                i7 = i4 % i15;
                i4++;
                if (iArr3[i7] != iArr3[i4 % i15]) {
                    iArr3[i7] = i13;
                    i13++;
                } else {
                    iArr3[i7] = i13;
                }
                i6 = i14;
            }
        }
        this.m_nLineNo = this.m_aBufLine[i7];
        this.m_nColumnNo = this.m_aBufColumn[i7];
    }

    @Override // bsh.CharStream
    public void backup(int i) {
        int i2 = this.bufsize;
        if (i > i2) {
            throw new IllegalStateException(yg.concatToVar1(yg.concatVar213(i, "Cannot back ", " chars which is larger than the internal buffer size ("), ")", this.bufsize));
        }
        this.inBuf += i;
        int i3 = this.bufpos - i;
        this.bufpos = i3;
        if (i3 < 0) {
            this.bufpos = i3 + i2;
        }
    }

    @Override // bsh.CharStream
    public char beginToken() throws IOException {
        this.tokenBegin = -1;
        char c = readChar();
        this.tokenBegin = this.bufpos;
        return c;
    }

    @Override // bsh.CharStream
    public void done() {
        this.buffer = null;
        this.m_aBufLine = null;
        this.m_aBufColumn = null;
    }

    public void expandBuff(boolean z) {
        int bufSizeAfterExpansion = getBufSizeAfterExpansion();
        char[] cArr = new char[bufSizeAfterExpansion];
        int[] iArr = new int[bufSizeAfterExpansion];
        int[] iArr2 = new int[bufSizeAfterExpansion];
        int i = this.bufsize;
        int i2 = this.tokenBegin;
        int i3 = i - i2;
        if (z) {
            System.arraycopy(this.buffer, i2, cArr, 0, i3);
            System.arraycopy(this.buffer, 0, cArr, i3, this.bufpos);
            this.buffer = cArr;
            System.arraycopy(this.m_aBufLine, this.tokenBegin, iArr, 0, i3);
            System.arraycopy(this.m_aBufLine, 0, iArr, i3, this.bufpos);
            this.m_aBufLine = iArr;
            System.arraycopy(this.m_aBufColumn, this.tokenBegin, iArr2, 0, i3);
            System.arraycopy(this.m_aBufColumn, 0, iArr2, i3, this.bufpos);
            this.m_aBufColumn = iArr2;
            int i4 = this.bufpos + i3;
            this.bufpos = i4;
            this.maxNextCharInd = i4;
        } else {
            System.arraycopy(this.buffer, i2, cArr, 0, i3);
            this.buffer = cArr;
            System.arraycopy(this.m_aBufLine, this.tokenBegin, iArr, 0, i3);
            this.m_aBufLine = iArr;
            System.arraycopy(this.m_aBufColumn, this.tokenBegin, iArr2, 0, i3);
            this.m_aBufColumn = iArr2;
            int i5 = this.bufpos - this.tokenBegin;
            this.bufpos = i5;
            this.maxNextCharInd = i5;
        }
        this.bufsize = bufSizeAfterExpansion;
        this.available = bufSizeAfterExpansion;
        this.tokenBegin = 0;
    }

    public void fillBuff() throws IOException {
        if (this.maxNextCharInd == this.available) {
            internalAdjustBuffSize();
        }
        try {
            char[] cArr = this.buffer;
            int i = this.maxNextCharInd;
            int iStreamRead = streamRead(cArr, i, this.available - i);
            if (iStreamRead != -1) {
                this.maxNextCharInd += iStreamRead;
            } else {
                streamClose();
                throw new IOException("PGCC end of stream");
            }
        } catch (IOException e) {
            this.bufpos--;
            backup(0);
            if (this.tokenBegin == -1) {
                this.tokenBegin = this.bufpos;
            }
            throw e;
        }
    }

    @Override // bsh.CharStream
    public int getBeginColumn() {
        return this.m_aBufColumn[this.tokenBegin];
    }

    @Override // bsh.CharStream
    public int getBeginLine() {
        return this.m_aBufLine[this.tokenBegin];
    }

    public int getBufSizeAfterExpansion() {
        return this.bufsize * 2;
    }

    public final int getColumn() {
        return this.m_nColumnNo;
    }

    @Override // bsh.CharStream
    public int getEndColumn() {
        return this.m_aBufColumn[this.bufpos];
    }

    @Override // bsh.CharStream
    public int getEndLine() {
        return this.m_aBufLine[this.bufpos];
    }

    @Override // bsh.CharStream
    public String getImage() {
        int i = this.bufpos;
        int i2 = this.tokenBegin;
        return i >= i2 ? new String(this.buffer, i2, (i - i2) + 1) : new String(this.buffer, i2, this.bufsize - i2).concat(new String(this.buffer, 0, this.bufpos + 1));
    }

    public final int getLine() {
        return this.m_nLineNo;
    }

    @Override // bsh.CharStream
    public char[] getSuffix(int i) {
        char[] cArr = new char[i];
        int i2 = this.bufpos;
        if (i2 + 1 >= i) {
            System.arraycopy(this.buffer, (i2 - i) + 1, cArr, 0, i);
            return cArr;
        }
        int i3 = (i - i2) - 1;
        System.arraycopy(this.buffer, this.bufsize - i3, cArr, 0, i3);
        System.arraycopy(this.buffer, 0, cArr, i3, this.bufpos + 1);
        return cArr;
    }

    @Override // bsh.CharStream
    public final int getTabSize() {
        return this.m_nTabSize;
    }

    public final void internalAdjustBuffSize() {
        int i = this.bufsize;
        int i2 = i / 2;
        int i3 = this.available;
        if (i3 != i) {
            int i4 = this.tokenBegin;
            if (i3 > i4) {
                this.available = i;
                return;
            } else if (i4 - i3 < i2) {
                expandBuff(true);
                return;
            } else {
                this.available = i4;
                return;
            }
        }
        int i5 = this.tokenBegin;
        if (i5 < 0) {
            this.bufpos = 0;
            this.maxNextCharInd = 0;
        } else {
            if (i5 <= i2) {
                expandBuff(false);
                return;
            }
            this.bufpos = 0;
            this.maxNextCharInd = 0;
            this.available = i5;
        }
    }

    public final void internalSetBufLineColumn(int i, int i2) {
        int[] iArr = this.m_aBufLine;
        int i3 = this.bufpos;
        iArr[i3] = i;
        this.m_aBufColumn[i3] = i2;
    }

    public final void internalUpdateLineColumn(char c) {
        this.m_nColumnNo++;
        if (this.m_bPrevCharIsLF) {
            this.m_bPrevCharIsLF = false;
            this.m_nColumnNo = 1;
            this.m_nLineNo++;
        } else if (this.m_bPrevCharIsCR) {
            this.m_bPrevCharIsCR = false;
            if (c == '\n') {
                this.m_bPrevCharIsLF = true;
            } else {
                this.m_nColumnNo = 1;
                this.m_nLineNo++;
            }
        }
        if (c == '\t') {
            int i = this.m_nColumnNo - 1;
            this.m_nColumnNo = i;
            int i2 = this.m_nTabSize;
            this.m_nColumnNo = (i2 - (i % i2)) + i;
        } else if (c == '\n') {
            this.m_bPrevCharIsLF = true;
        } else if (c == '\r') {
            this.m_bPrevCharIsCR = true;
        }
        internalSetBufLineColumn(this.m_nLineNo, this.m_nColumnNo);
    }

    @Override // bsh.CharStream
    public final boolean isTrackLineColumn() {
        return this.m_bTrackLineColumn;
    }

    public final void reInit(int i, int i2, int i3) {
        this.m_nLineNo = i;
        this.m_nColumnNo = i2 - 1;
        this.m_bPrevCharIsCR = false;
        this.m_bPrevCharIsLF = false;
        char[] cArr = this.buffer;
        if (cArr == null || i3 != cArr.length) {
            this.bufsize = i3;
            this.available = i3;
            this.buffer = new char[i3];
            this.m_aBufLine = new int[i3];
            this.m_aBufColumn = new int[i3];
        }
        this.maxNextCharInd = 0;
        this.inBuf = 0;
        this.tokenBegin = 0;
        this.bufpos = -1;
    }

    @Override // bsh.CharStream
    public char readChar() throws IOException {
        int i = this.inBuf;
        if (i > 0) {
            this.inBuf = i - 1;
            int i2 = this.bufpos + 1;
            this.bufpos = i2;
            if (i2 == this.bufsize) {
                this.bufpos = 0;
            }
            return this.buffer[this.bufpos];
        }
        int i3 = this.bufpos + 1;
        this.bufpos = i3;
        if (i3 >= this.maxNextCharInd) {
            fillBuff();
        }
        char c = this.buffer[this.bufpos];
        if (this.m_bTrackLineColumn) {
            internalUpdateLineColumn(c);
        }
        return c;
    }

    @Override // bsh.CharStream
    public final void setTabSize(int i) {
        this.m_nTabSize = i;
    }

    @Override // bsh.CharStream
    public final void setTrackLineColumn(boolean z) {
        this.m_bTrackLineColumn = z;
    }

    public abstract void streamClose();

    public abstract int streamRead(char[] cArr, int i, int i2);
}

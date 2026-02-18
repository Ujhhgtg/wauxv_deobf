package bsh;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public class JavaCharStream extends AbstractCharStream {
    protected static final int NEXTCHAR_BUF_SIZE = 4096;
    private Reader m_aIS;
    private char[] m_aNextCharBuf;
    private int nextCharInd;

    public JavaCharStream(Reader reader, int i, int i2, int i3) {
        super(i, i2, i3);
        this.nextCharInd = -1;
        this.m_aNextCharBuf = new char[4096];
        this.m_aIS = reader;
    }

    private char readByte() throws IOException {
        int i = this.nextCharInd + 1;
        this.nextCharInd = i;
        if (i >= this.maxNextCharInd) {
            fillBuff();
        }
        return this.m_aNextCharBuf[this.nextCharInd];
    }

    @Override // bsh.AbstractCharStream, bsh.CharStream
    public char beginToken() {
        int i = this.inBuf;
        if (i <= 0) {
            this.tokenBegin = 0;
            this.bufpos = -1;
            return readChar();
        }
        this.inBuf = i - 1;
        int i2 = this.bufpos + 1;
        this.bufpos = i2;
        if (i2 == this.bufsize) {
            this.bufpos = 0;
        }
        int i3 = this.bufpos;
        this.tokenBegin = i3;
        return this.buffer[i3];
    }

    @Override // bsh.AbstractCharStream, bsh.CharStream
    public void done() {
        this.m_aNextCharBuf = null;
        super.done();
    }

    @Override // bsh.AbstractCharStream
    public void fillBuff() throws IOException {
        if (this.maxNextCharInd == 4096) {
            this.maxNextCharInd = 0;
            this.nextCharInd = 0;
        }
        try {
            char[] cArr = this.m_aNextCharBuf;
            int i = this.maxNextCharInd;
            int iStreamRead = streamRead(cArr, i, 4096 - i);
            if (iStreamRead != -1) {
                this.maxNextCharInd += iStreamRead;
            } else {
                streamClose();
                throw new IOException();
            }
        } catch (IOException e) {
            int i2 = this.bufpos;
            if (i2 != 0) {
                this.bufpos = i2 - 1;
                backup(0);
            } else {
                internalSetBufLineColumn(getLine(), getColumn());
            }
            throw e;
        }
    }

    public void reInit(Reader reader) {
        reInit(reader, 1, 1, 4096);
    }

    @Override // bsh.AbstractCharStream, bsh.CharStream
    public char readChar() throws IOException {
        char c;
        char c2;
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
        if (i3 == this.available) {
            internalAdjustBuffSize();
        }
        char c3 = readByte();
        this.buffer[this.bufpos] = c3;
        if (c3 != '\\') {
            if (isTrackLineColumn()) {
                internalUpdateLineColumn(c3);
            }
            return c3;
        }
        if (isTrackLineColumn()) {
            internalUpdateLineColumn(c3);
        }
        int i4 = 1;
        while (true) {
            int i5 = this.bufpos + 1;
            this.bufpos = i5;
            if (i5 == this.available) {
                internalAdjustBuffSize();
            }
            try {
                c = readByte();
                this.buffer[this.bufpos] = c;
                if (c != '\\') {
                    break;
                }
                if (isTrackLineColumn()) {
                    internalUpdateLineColumn(c);
                }
                i4++;
            } catch (IOException unused) {
                if (i4 > 1) {
                    backup(i4 - 1);
                }
                return '\\';
            }
        }
        if (isTrackLineColumn()) {
            internalUpdateLineColumn(c);
        }
        if (c != 'u' || (i4 & 1) != 1) {
            backup(i4);
            return '\\';
        }
        int i6 = this.bufpos - 1;
        this.bufpos = i6;
        if (i6 < 0) {
            this.bufpos = this.bufsize - 1;
        }
        while (true) {
            try {
                c2 = readByte();
                if (c2 != 'u') {
                    break;
                }
                if (isTrackLineColumn()) {
                    internalUpdateLineColumn(c2);
                }
            } catch (IOException unused2) {
                throw new IllegalStateException("Invalid escape character at line " + getLine() + " column " + getColumn() + ".");
            }
        }
        char c4 = readByte();
        char c5 = readByte();
        char c6 = readByte();
        char cHexval = (char) ((AbstractCharStream.hexval(c2) << 12) | (AbstractCharStream.hexval(c4) << 8) | (AbstractCharStream.hexval(c5) << 4) | AbstractCharStream.hexval(c6));
        this.buffer[this.bufpos] = cHexval;
        if (isTrackLineColumn()) {
            internalUpdateLineColumn(c2);
            internalUpdateLineColumn(c4);
            internalUpdateLineColumn(c5);
            internalUpdateLineColumn(c6);
        }
        if (i4 == 1) {
            return cHexval;
        }
        backup(i4 - 1);
        return '\\';
    }

    @Override // bsh.AbstractCharStream
    public void streamClose() throws IOException {
        this.m_aIS.close();
    }

    @Override // bsh.AbstractCharStream
    public int streamRead(char[] cArr, int i, int i2) {
        return this.m_aIS.read(cArr, i, i2);
    }

    public void reInit(Reader reader, int i, int i2) {
        reInit(reader, i, i2, 4096);
    }

    public void reInit(Reader reader, int i, int i2, int i3) {
        this.m_aNextCharBuf = new char[4096];
        this.nextCharInd = -1;
        this.m_aIS = reader;
        reInit(i, i2, i3);
    }

    public JavaCharStream(Reader reader, int i, int i2) {
        this(reader, i, i2, 4096);
    }

    public JavaCharStream(Reader reader) {
        this(reader, 1, 1, 4096);
    }

    public JavaCharStream(InputStream inputStream, Charset charset, int i, int i2, int i3) {
        this(new InputStreamReader(inputStream, charset), i, i2, i3);
    }

    public void reInit(InputStream inputStream, Charset charset) {
        reInit(inputStream, charset, 1, 1, 4096);
    }

    public JavaCharStream(InputStream inputStream, Charset charset, int i, int i2) {
        this(inputStream, charset, i, i2, 4096);
    }

    public void reInit(InputStream inputStream, Charset charset, int i, int i2) {
        reInit(inputStream, charset, i, i2, 4096);
    }

    public JavaCharStream(InputStream inputStream, Charset charset) {
        this(inputStream, charset, 1, 1, 4096);
    }

    public void reInit(InputStream inputStream, Charset charset, int i, int i2, int i3) {
        reInit(new InputStreamReader(inputStream, charset), i, i2, i3);
    }
}

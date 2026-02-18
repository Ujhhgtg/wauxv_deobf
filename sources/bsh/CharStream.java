package bsh;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public interface CharStream {
    void backup(int i);

    char beginToken();

    void done();

    int getBeginColumn();

    int getBeginLine();

    int getEndColumn();

    int getEndLine();

    String getImage();

    char[] getSuffix(int i);

    int getTabSize();

    boolean isTrackLineColumn();

    char readChar();

    void setTabSize(int i);

    void setTrackLineColumn(boolean z);
}

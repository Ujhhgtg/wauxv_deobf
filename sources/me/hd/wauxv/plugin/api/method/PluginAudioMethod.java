package me.hd.wauxv.plugin.api.method;

import java.io.File;
import java.io.IOException;
import me.hd.wauxv.hook.core.p000native.AudioNative;
import me.hd.wauxv.obf.bad;
import me.hd.wauxv.obf.cnb;
import me.hd.wauxv.obf.cnh;
import me.hd.wauxv.obf.cty;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class PluginAudioMethod {
    @cty
    public final int getSilkDuration(String str) {
        return cnh.w(str);
    }

    @cty
    public final void mp3ToSilk(String str, String str2) throws IOException {
        File fileMp3ToSilkFile = mp3ToSilkFile(str);
        bad.a(fileMp3ToSilkFile, new File(str2));
        fileMp3ToSilkFile.delete();
    }

    @cty
    public final File mp3ToSilkFile(String str) throws IOException {
        File file = new File(str);
        cnh.k(file, "mp3ToSilk" /* cnb.z(-398963807091498L) */);
        File fileX = cnh.x("pcm" /* cnb.z(-398938037287722L) */);
        String absolutePath = file.getAbsolutePath();
        String absolutePath2 = fileX.getAbsolutePath();
        AudioNative audioNative = AudioNative.a;
        audioNative.mp3ToPcmInit();
        int iMp3ToPcmConvert = audioNative.mp3ToPcmConvert(absolutePath, absolutePath2);
        audioNative.mp3ToPcmClose();
        File fileX2 = cnh.x("silk" /* cnb.z(-398886497680170L) */);
        audioNative.pcmToSilkConvert(fileX.getAbsolutePath(), fileX2.getAbsolutePath(), true, false, iMp3ToPcmConvert, 24000, 20, 0, 0, 0, 2, 24000);
        fileX.delete();
        return fileX2;
    }

    @cty
    public final String mp3ToSilkPath(String str) {
        return mp3ToSilkFile(str).getAbsolutePath();
    }

    @cty
    public final void silkToMp3(String str, String str2) {
        File fileSilkToMp3File = silkToMp3File(str);
        bad.a(fileSilkToMp3File, new File(str2));
        fileSilkToMp3File.delete();
    }

    @cty
    public final File silkToMp3File(String str) {
        return cnh.af(new File(str));
    }

    @cty
    public final String silkToMp3Path(String str) {
        return silkToMp3File(str).getAbsolutePath();
    }
}

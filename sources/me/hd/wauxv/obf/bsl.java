package me.hd.wauxv.obf;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.function.BiFunction;
import java.util.function.Function;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class bsl extends brx implements Map<String, brx>, bsw {
    public static final bsk Companion = new bsk();
    public final Map a;

    public bsl(Map map) {
        bzo.q(map, "content");
        this.a = map;
    }

    @Override // java.util.Map
    public final void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public final /* bridge */ /* synthetic */ brx compute(String str, BiFunction<? super String, ? super brx, ? extends brx> biFunction) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public final /* bridge */ /* synthetic */ brx computeIfAbsent(String str, Function<? super String, ? extends brx> function) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public final /* bridge */ /* synthetic */ brx computeIfPresent(String str, BiFunction<? super String, ? super brx, ? extends brx> biFunction) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public final boolean containsKey(Object obj) {
        if (!(obj instanceof String)) {
            return false;
        }
        return this.a.containsKey((String) obj);
    }

    @Override // java.util.Map
    public final boolean containsValue(Object obj) {
        if (!(obj instanceof brx)) {
            return false;
        }
        return this.a.containsValue((brx) obj);
    }

    @Override // java.util.Map
    public final Set<Map.Entry<String, brx>> entrySet() {
        return this.a.entrySet();
    }

    @Override // java.util.Map
    public final boolean equals(Object obj) {
        return bzo.f(this.a, obj);
    }

    @Override // java.util.Map
    public final brx get(Object obj) {
        if (!(obj instanceof String)) {
            return null;
        }
        return (brx) this.a.get((String) obj);
    }

    @Override // java.util.Map
    public final int hashCode() {
        return this.a.hashCode();
    }

    @Override // java.util.Map
    public final boolean isEmpty() {
        return this.a.isEmpty();
    }

    @Override // java.util.Map
    public final Set<String> keySet() {
        return this.a.keySet();
    }

    @Override // java.util.Map
    public final /* bridge */ /* synthetic */ brx merge(String str, brx brxVar, BiFunction<? super brx, ? super brx, ? extends brx> biFunction) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public final /* bridge */ /* synthetic */ brx put(String str, brx brxVar) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public final void putAll(Map<? extends String, ? extends brx> map) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public final /* bridge */ /* synthetic */ brx putIfAbsent(String str, brx brxVar) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public final brx remove(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public final /* bridge */ /* synthetic */ brx replace(String str, brx brxVar) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public final void replaceAll(BiFunction<? super String, ? super brx, ? extends brx> biFunction) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public final int size() {
        return this.a.size();
    }

    public final String toString() {
        return aaz.k(this.a.entrySet(), ",", "{", "}", new blx(25), 24);
    }

    @Override // java.util.Map
    public final Collection<brx> values() {
        return this.a.values();
    }

    @Override // java.util.Map
    public final boolean remove(Object obj, Object obj2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public final /* bridge */ /* synthetic */ boolean replace(String str, brx brxVar, brx brxVar2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}

package com.alibaba.fastjson2.reader;

import com.alibaba.fastjson2.JSONException;
import com.alibaba.fastjson2.util.GuavaSupport;
import com.alibaba.fastjson2.util.MapMultiValueType;
import java.util.AbstractMap;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ConcurrentNavigableMap;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.function.Function;
import me.hd.wauxv.obf.cpv;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public class ObjectReaderImplMapMultiValueType implements ObjectReader {
    final Function builder;
    final Class instanceType;
    final Class mapType;
    final MapMultiValueType multiValueType;

    public ObjectReaderImplMapMultiValueType(MapMultiValueType mapMultiValueType) {
        this.multiValueType = mapMultiValueType;
        Class mapType = mapMultiValueType.getMapType();
        this.mapType = mapType;
        Function cpvVar = null;
        if (mapType == Map.class || mapType == AbstractMap.class || mapType == ObjectReaderImplMap.CLASS_SINGLETON_MAP) {
            mapType = HashMap.class;
        } else if (mapType == ObjectReaderImplMap.CLASS_UNMODIFIABLE_MAP) {
            mapType = LinkedHashMap.class;
        } else if (mapType == SortedMap.class || mapType == ObjectReaderImplMap.CLASS_UNMODIFIABLE_SORTED_MAP || mapType == ObjectReaderImplMap.CLASS_UNMODIFIABLE_NAVIGABLE_MAP) {
            mapType = TreeMap.class;
        } else if (mapType == ConcurrentMap.class) {
            mapType = ConcurrentHashMap.class;
        } else if (mapType == ConcurrentNavigableMap.class) {
            mapType = ConcurrentSkipListMap.class;
        } else {
            String typeName = mapType.getTypeName();
            typeName.getClass();
            if (typeName.equals("java.util.Collections$SynchronizedSortedMap")) {
                cpvVar = new cpv(6);
            } else {
                if (typeName.equals("com.google.common.collect.SingletonImmutableBiMap")) {
                    cpvVar = GuavaSupport.singletonBiMapConverter();
                } else if (typeName.equals("java.util.Collections$SynchronizedMap")) {
                    cpvVar = new cpv(4);
                } else if (typeName.equals("java.util.Collections$SynchronizedNavigableMap")) {
                    cpvVar = new cpv(5);
                } else if (typeName.equals("com.google.common.collect.ImmutableMap") || typeName.equals("com.google.common.collect.RegularImmutableMap")) {
                    cpvVar = GuavaSupport.immutableMapConverter();
                }
                mapType = HashMap.class;
            }
            mapType = TreeMap.class;
        }
        this.instanceType = mapType;
        this.builder = cpvVar;
    }

    @Override // com.alibaba.fastjson2.reader.ObjectReader
    public Object createInstance(long j) {
        Class cls = this.instanceType;
        if (cls == null || cls.isInterface()) {
            return new HashMap();
        }
        try {
            return this.instanceType.newInstance();
        } catch (Exception e) {
            throw new JSONException("create map error", e);
        }
    }

    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Not found exit edge by exit block: B:23:0x0073
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.checkLoopExits(LoopRegionMaker.java:272)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.makeLoopRegion(LoopRegionMaker.java:237)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:80)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:91)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:68)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:118)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:108)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:68)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeMthRegion(RegionMaker.java:48)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:25)
        */
    @Override // com.alibaba.fastjson2.reader.ObjectReader
    public java.lang.Object readObject(com.alibaba.fastjson2.JSONReader r15, java.lang.reflect.Type r16, java.lang.Object r17, long r18) {
        /*
            Method dump skipped, instruction units count: 260
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson2.reader.ObjectReaderImplMapMultiValueType.readObject(com.alibaba.fastjson2.JSONReader, java.lang.reflect.Type, java.lang.Object, long):java.lang.Object");
    }
}

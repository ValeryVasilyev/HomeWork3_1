package ru.sbt.generics;

import java.util.Map;

public interface CountMap<K, V> {

    default void add(K k){
    }

    default int getCount(K k){return 0;}

    int remove(K k);

    int size();

    void addAll(CountMap<K, V> source);

    void toMap(Map destination);

    Map<K, V> toMap();
}

package ru.sbt.generics;

import java.util.HashMap;
import java.util.Map;

public class CountMapImpl<K, V> implements CountMap<K, V> {
    private Map<K, Integer> map = (Map<K, Integer>) toMap();
    public Map destination = toMap();

    @Override // Метод добавляет элемент в контейнер
    public void add(K k) {
        if (getCount(k) == 0) { // Проверка наличия элемента в контейнере
            this.map.put(k, Integer.valueOf(1)); // Если нет элемента, то счётчик = 1
        } else {
            this.map.put(k, getCount(k) + Integer.valueOf(1)); // Если элемент уже есть, то добавляем к счётчику +1
        }
    }

    @Override // Метод возвращает значение счетчика
    public int getCount(K k) {
        return this.map.containsKey(k) == true ? this.map.get(k) : 0; // Возвращает 0, если такого элемента нет в контейнере
    }

    @Override // Метод удаляет элемент из контейнера и возвращает значение счётчика
    public int remove(K k) {
        int count = 0;
        if (this.map.containsKey(k) == true) { // Возвращаем 0, если элемента нет в контейнере
            count = this.map.get(k);
            this.map.remove(k);
        }
        return count;
    }

    @Override // Возвращаем кол-во элементов в контейнере
    public int size() {
        return this.map.size();
    }

    @Override // Добавляем элементы в контейнер из другого контейнера
    public void addAll(CountMap<K, V> source) {
        CountMapImpl<K, V> sourceMap = (CountMapImpl<K, V>) source;
        for(K key : sourceMap.map.keySet()) {
            if (getCount(key) == 0) { // Проверка наличия элемента в контейнере
                this.map.put(key, sourceMap.getCount(key)); // Если нет элемента, то счётчик = 1
            } else {
                this.map.put(key, getCount(key) + sourceMap.getCount(key)); // Если элемент уже есть, то добавляем к счётчику +1
            }
        }
    }

    @Override // Возвращаем мапу
    public Map<K, V> toMap() {
        Map<K, V> map = new HashMap();
        return map;
    }

    @Override
    public void toMap(Map destination) {
        for(K key : this.map.keySet()) {
            destination.put(key, this.map.get(key));
        }
    }
}

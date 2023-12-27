package ru.sbt.generics;

public class Start extends CountMapImpl{
    public static void main(String[] args) {
        CountMap map = new CountMapImpl();

        // Добавляем в экземпляр контейнера int
        map.add(10);
        map.add(5);
        map.add(6);
        map.add(5);
        map.add(10);
        map.add(10);

        // Добавляем строки
        map.add("10");
        map.add("10");
        map.add("10");
        map.add("10");

        // Создаём 2ой экземпляр контейнера, который будем добавлять к 1му
        CountMap addingMap = new CountMapImpl();
        addingMap.add("10");
        addingMap.add("1");
        addingMap.add("1");
        addingMap.add("1");
        addingMap.add("1");
        addingMap.add("1");
        addingMap.add("10");
        addingMap.add(10);
        addingMap.add(10);

        System.out.println("getCount: " + map.getCount(6)); // 1
        System.out.println("getCount: " + map.getCount(5)); // 2
        System.out.println("getCount: " + map.getCount(10)); // 3
        System.out.println("getCount: " + map.getCount("10")); // 4

        System.out.println("getCount within remove(): " + map.remove("10")); // 4

        System.out.println("getCount after remove(): " + map.getCount("10")); // 0

        map.addAll(addingMap);

        System.out.println("getCount after addAll(): " + map.getCount(10)); // 2

        System.out.println("size: " + map.size()); // 4
    }
}

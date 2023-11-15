package org.example;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class PhoneBook {
    // изменения на TreeMap, чтобы использовать встроенную сортировку
    static Map<String, String> phoneBook = new TreeMap<>();
    static int counter = 0;
    public static int add(String name, String phoneNumber){
        if(!phoneBook.containsKey(name)){
            phoneBook.put(name, phoneNumber);
            counter++;
        }
        return counter;
    }

    public static String findByNumber(String phoneNumber){
        return phoneBook.entrySet().stream()
                    .filter(entry -> entry.getValue().equals(phoneNumber))
                    .map(Map.Entry::getKey)
                    .findFirst()
                    .orElse(null);

    }

    public static String findByName(String name){
        return phoneBook.entrySet().stream()
                .filter(entry -> entry.getKey().equals(name))
                .map(Map.Entry::getValue)
                .findFirst()
                .orElse(null);
    }

    public static void printAllNames(){
    }
}

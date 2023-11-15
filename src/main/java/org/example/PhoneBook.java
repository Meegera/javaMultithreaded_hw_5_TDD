package org.example;

import java.util.HashMap;
import java.util.Map;

public class PhoneBook {
    static Map<String, String> phoneBook = new HashMap<>();
    static int counter = 0;
    public static int add(String name, String phoneNumber){
        if(!phoneBook.containsKey(name)){
            phoneBook.put(name, phoneNumber);
            counter++;
        }
        return counter;
    }

    public static String findByNumber(String phoneNumber){
        return null;
    }
}

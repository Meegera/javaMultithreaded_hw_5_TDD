package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Map;

class PhoneBookTest {

    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @ParameterizedTest
    @CsvSource({
            "Anna, +89997355656, 1",
            "Olga, +89997355656, 2",
            "Anna, +89997355656, 2",
            "Elena, +89997355656, 3"
    })
    void testAdd(String name, String phoneNumber, Integer count){
        Integer actual = PhoneBook.add(name, phoneNumber);
        Assertions.assertEquals(count, actual);
    }

    @ParameterizedTest
    @CsvSource({
            "Anna, +89997355656, +89997000996, null",
            "Olga, +89967777656, +89997355656, Anna"
    })
    void testFindByNumber(String name, String phoneNumber, String resultPhoneNumber,String nameToFind){
        PhoneBook.add(name, phoneNumber);
        String resultName = PhoneBook.findByNumber(resultPhoneNumber);
        if(nameToFind.equals("null")){
            Assertions.assertEquals(null, resultName);
            return;
        }
        Assertions.assertEquals(nameToFind, resultName);
    }

    @ParameterizedTest
    @CsvSource({
            "Anna, +89997355656, null, Liza",
            "Olga, +89967777656, +89997355656, Anna"
    })
    void testFindByName(String name, String phoneNumber, String resultPhoneNumber,String resultName){
        PhoneBook.add(name, phoneNumber);
        String result = PhoneBook.findByName(resultName);
        if(resultPhoneNumber.equals("null")){
            Assertions.assertEquals(null, result);
            return;
        }
        Assertions.assertEquals(resultPhoneNumber, result);
    }

    @Test
    void testPrintAll(){
        System.setOut(new PrintStream(outputStream));
        try {
            Map<String, String> data = Map.of(
                    "Anna", "+89997355656",
                    "Liza", "+89997387878",
                    "Andrey", "+8999739929"
            );
            for(Map.Entry<String, String> entry:data.entrySet()){
                PhoneBook.add(entry.getKey(), entry.getValue());
            }

            PhoneBook.printAllNames();
            // Получение вывода в строку
            String actualOutput = outputStream.toString().trim();
            String expectedOutput = "Andrey\nAnna\nLiza";
            Assertions.assertEquals(expectedOutput, actualOutput);
        } finally {
            System.setOut(originalOut);
        }

    }

}
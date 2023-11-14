package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class PhoneBookTest {

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

}
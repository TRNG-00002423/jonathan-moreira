package com.yourname.qa.week2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class HappyTest {

    @Test
    void testGreeter(){
        Greeter greeter = new Greeter();

        String expectedResult = "Hello, John";

        String actualResult = greeter.hello("John");

        Assertions.assertEquals(expectedResult, actualResult);
    }

}

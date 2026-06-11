package com.yourname.qa.week2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SadTest {

    @Test
    public void testGreeter(){
        Greeter greeter = new Greeter();

        Assertions.assertThrows(IllegalArgumentException.class,  ()-> greeter.hello(""));
    }
}

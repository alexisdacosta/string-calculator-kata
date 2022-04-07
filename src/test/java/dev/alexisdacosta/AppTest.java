package dev.alexisdacosta;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import dev.alexisdacosta.services.StringCalculator;

/**
 * Unit test to test this kata.
 */
public class AppTest 
{
    @Test 
    public void testStep1(){
        assertTrue(StringCalculator.add("1,2,4") == 7);
    }

    @Test 
    public void testStep1Bis(){
        assertTrue(StringCalculator.add("1,2,3,4,5,6,7,8,9") == 45);
    }

    @Test
    public void testStep3(){
        assertTrue(StringCalculator.add("1\n2,4") == 7);
    }

    @Test
    public void testStep3Bis(){
        assertTrue(StringCalculator.add("1,\n") == 1);
    }

    @Test
    public void testStep4(){
        assertTrue(StringCalculator.add("//;\n1;2") == 3);
    }

    @Test
    public void testStep4Bis(){
        assertTrue(StringCalculator.add("// \n1 2") == 3);
    }

    @Test
    public void testStep5(){
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            StringCalculator.add("//;\n1;-2");
        });

        String expectedMessage = "Negative numbers not allowed";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void testStep6(){
        Exception exception = assertThrows(RuntimeException.class, () -> {
            StringCalculator.add("//;\na;-2");
        });

        String expectedMessage = "Invalid number: ";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }
}

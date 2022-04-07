package dev.alexisdacosta;

import dev.alexisdacosta.services.StringCalculator;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "StringCalculator Kata\n" );

        int res = StringCalculator.add("1,2,4");
        System.out.println("res = " + res + "\n");

        res = StringCalculator.add("1\n2,4");
        System.out.println("res = " + res + "\n");

        res = StringCalculator.add("1,\n");
        System.out.println("res = " + res + "\n");

        res = StringCalculator.add("//;\n1;2");
        System.out.println("res = " + res + "\n");

        res = StringCalculator.add("// \n1 2");
        System.out.println("res = " + res + "\n");
        
        try {
            res = StringCalculator.add("//;\n1;-2");
            System.out.println("res = " + res + "\n");
        } catch (Exception e) {
            System.out.println("res = " + e.getMessage() + "\n");
        } 

    }
}

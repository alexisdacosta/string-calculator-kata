package dev.alexisdacosta.services;

public class StringCalculator {
    
    /**
     * Get the delimiter from the input add string.
     * @param numbers
     * @return
     */
    private static String getDelimiter(String numbers) {
        //== Default delimiter is ","
        String delimiter = ",";

        // Check if the input string contains a delimiter configuration
        if (numbers.startsWith("//")) {
            delimiter = numbers.substring(2, 3);
        }
        return delimiter;
    }

    /**
     * Add positive numbers separated by an separator or new line.
     * @param numbers
     * @return
     */
    public static int add(String numbers) {
        //== 0 if the input is an empty string
        if (numbers.isEmpty()) {
            return 0;
        }

        //== Filter numbers string with a regex to follow this example
        // numbers = "//;\n1;2" -> numbers = ";"
        // numbers = "//,\n1,2" -> numbers = ","
        String delimiter = getDelimiter(numbers);
        System.out.println("delimiter = " + delimiter);

        //== Remove "//;\n" from numbers
        numbers = numbers.replaceAll("//" + delimiter + "\n", "");
        System.out.println("numbers = " + numbers);

        //== Split numbers string with delimiter
        String[] numbersArray = numbers.split(delimiter + "|\\\n");

        //== Do the sum of each number of the array
        int sum = 0;
        for (String number : numbersArray) {
            int num = 0; 
            
            //== Verify if the number string is a number
            try {
                num = Integer.parseInt(number);
            } catch (Exception e) {
                throw new RuntimeException("Invalid number: " + number);
            }

            //== Verify if the number is negative
            if (num < 0) {
                throw new IllegalArgumentException("Negative numbers not allowed");
            }
            sum += Integer.parseInt(number);
        }

        return sum;
    }
}

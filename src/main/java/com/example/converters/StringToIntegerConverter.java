package com.example.converters;

public class StringToIntegerConverter {

    public static int convert(String stringToConvert){
        if(stringToConvert == null || stringToConvert.isEmpty())
            throw new NumberFormatException("String is null or empty");

        stringToConvert = stringToConvert.trim();

        int result = 0;

        boolean isNegative = stringToConvert.startsWith("-");

        if(stringToConvert.startsWith("+") || stringToConvert.startsWith("-"))
            stringToConvert = stringToConvert.substring(1);

        char[] chars = stringToConvert.toCharArray();

        if(chars.length == 0)
            throw new NumberFormatException("Empty value");

        for(int i = 0; i < chars.length; i++){

            if(!Character.isDigit(chars[i]))
                throw new NumberFormatException("Invalid input string");

            if(i == 0)
                result = Character.getNumericValue(chars[i]);
            else
                result = result * 10 + Character.getNumericValue(chars[i]);

        }

        return isNegative ? -result : result;
    }
}

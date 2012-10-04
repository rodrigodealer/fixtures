package br.com.pordotom;

public class FixtureUtil {

    public static String getCapitalizedSetter(String field) {
        String firstLetter = field.substring(0, 1).toUpperCase();
        String restOfWord = field.substring(1, field.length());
        return "set" + firstLetter + restOfWord;
    }

}

package com.amanuel;
/*
Create an array of String,Populate with first names in mixed cases.
Include one name which can be read the same backwards and forward (bob)
 -> Transform names all to upper case
 -> Add a randomly generated middle initial, and include a period.
 -> add a last name which is a reverse of the first name.
 -> Print the array after each change
 -> Create a new modifiable ArrayList removing names where the first name is equal to the last name

 */


import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class LambdaExpressionChallenge {

    private static Random random = new Random();//jdk 17

    public static void main(String[] args) {

        String[] names = {"Aman", "Bob", "Daniel", "Solo"};
        Arrays.setAll(names, i -> names[i].toUpperCase());

        System.out.println("Transformed to upper case " + Arrays.toString(names));

        List<String> namesList = Arrays.asList(names);

        namesList.replaceAll(s -> s += " " + getRandomAlphabet('A', 'E') + ".");
        System.out.println("+++ Initials Added +++++++");
        System.out.println(Arrays.toString(names));


        System.out.println("++++++++++++++++++++++++++");
        namesList.replaceAll(s -> s += " " + getNamesReversed(s.split(" ")[0]));//leave the initial
        Arrays.asList(names).forEach(s -> System.out.println(getNamesReversed(s)));

        List<String> newList = new ArrayList<>(List.of(names));//new copy
          newList.removeIf(s -> s.substring(0, s.indexOf(" "))
                 .equals(s.substring(s.lastIndexOf(" ") + 1)));

        System.out.println("++++++lastname == firstname removed+++++++");
         newList.forEach(s-> System.out.println(s));

    }


    public static char getRandomAlphabet(char start, char end) {
        return (char) random.nextInt((int) start, (int) end + 1);
    }

    private static String getNamesReversed(String name) {
        return new StringBuilder(name).reverse().toString();
    }


}

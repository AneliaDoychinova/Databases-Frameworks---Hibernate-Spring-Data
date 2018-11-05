package Exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

public class d_VowelOrDigit04 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String [] vowels = {"a","e","o","u","i"};
        List<String> vowelsList = Arrays.asList(vowels);
        String symbol = bf.readLine();
        if(Character.isDigit(symbol.charAt(0))){
            System.out.println("digit");
        }
        else if(vowelsList.contains(symbol)){
            System.out.println("vowel");
        }
        else {
            System.out.println("other");
        }
    }
}

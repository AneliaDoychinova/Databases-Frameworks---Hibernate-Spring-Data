package Exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class l_ReverseString12 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String word = bf.readLine();

        String reversed = new StringBuilder(word).reverse().toString();

        System.out.println(reversed);
    }
}

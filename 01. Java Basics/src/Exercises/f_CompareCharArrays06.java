package Exercises;

import java.util.Arrays;
import java.util.Scanner;

public class f_CompareCharArrays06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] letters = new String[2];

        for (int i = 0; i < letters.length; i++) {
            letters[i] = String.join("", scanner.nextLine().split("\\s+"));
        }

        Arrays.sort(letters);
        System.out.println(String.join("\n", letters));
    }
}

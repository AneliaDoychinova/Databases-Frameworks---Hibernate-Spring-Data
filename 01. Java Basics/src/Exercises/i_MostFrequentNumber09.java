package Exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class i_MostFrequentNumber09 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int[] numbers = Arrays
                .stream(bf.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int maxCount = 0;
        int theNumber = 0;

        for (int number : numbers) {
            int currCount = 0;
            for (int number1 : numbers) {
                if (number == number1) {
                    currCount++;
                }
            }

            if (currCount > maxCount) {
                maxCount = currCount;
                theNumber = number;
            }
        }
        System.out.println(theNumber);
    }
}

package Exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class h_MaxSequenceOfIncreasingElements08 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int[] numbers = Arrays
                .stream(bf.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();


        int length = 1;
        int maxLength = 1;
        int bestStartIndex = 0;
        int startIndex = 0;

        for (int i = 1; i <= numbers.length - 1; i++) {
            if (numbers[i] > numbers[i-1]) {
                length++;

                if (maxLength < length)
                {
                    maxLength = length;
                    bestStartIndex = startIndex;
                }

            }
            else{
                length = 1;
                startIndex = i;
            }

        }

        for (int i = bestStartIndex; i < bestStartIndex+maxLength; i++){
            System.out.print(numbers[i] + " ");
        }
    }
}
